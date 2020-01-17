package com.github.virtualgamers.hrtg.core.service;

import java.util.Optional;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import com.github.virtualgamers.hrtg.core.model.Party;
import com.github.virtualgamers.hrtg.core.model.User;
import com.github.virtualgamers.hrtg.core.repository.PartyRepository;

@Component
@Primary
public class PartyServiceImpl implements PartyService {

    Logger logger = LoggerFactory.getLogger(PartyServiceImpl.class);

    @Autowired
    PartyRepository partyRepository;

    @Autowired
    UserService userService;

    @Override
    public User addToParty(final String partyId, final String username) {
        logger.info("Adding to Party. partyId=" + partyId + " and username=" + username);
        final Party party = getParty(partyId);
        final User user = userService.createUser(party.getId(), username);

        logger.info("Adding user to party=" + party + ", user=" + user);
        party.addUsers(user);

        partyRepository.save(party);
        logger.info("Saved Party=" + party);
        return user;
    }

    @Override
    public Party getParty(final String partyId) {
        logger.info("Getting Party with partyId=" + partyId);
        final Optional<Party> optional = partyRepository.findById(partyId);
        if (optional.isEmpty()) {
            throw new IllegalStateException("No Party exists for partyId=" + partyId);
        }

        final Party party = optional.get();
        logger.info("Retireved party=" + party);
        return party;
    }

    @Override
    public String getCode(final String partyId) {
        logger.info("Getting Party code for partyId=" + partyId);
        final Party party = getParty(partyId);

        logger.info("Retireved partyCode=" + partyId);
        return party.getPartyCode();
    }

    @Override
    public Party startParty(final String username) {
        logger.info("Starting Party for username=" + username);

        logger.info("Creating party");
        final Party party = new Party();
        party.setPartyCode(generatePartyCode());

        final Party persistedParty = partyRepository.save(party);
        logger.info("New Party started. persistedParty=" + persistedParty);

        final String partyId = party.getId();
        final User user = userService.createUser(partyId, username);

        logger.info("Adding user to party with partyId=" + partyId + ". user=" + user);
        party.addUsers(user);
        party.setPartyLeaderUserId(user.getUsername());

        final Party updatedParty = partyRepository.save(party);
        logger.info("Party updated with party leader. updatedParty=" + updatedParty);
        return updatedParty;
    }

    private String generatePartyCode() {
        final Random random = new Random();
        // Map to store 62 possible characters.
        final String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int size = 4; // 62^4 = 14776336 possibilities
        String code;
        int attemptsSinceRezise = 0;
        do {
            // Runtime Safety Checks
            if (attemptsSinceRezise > 5) {
                attemptsSinceRezise = 0;
                size += 1;
                logger.info("To many attempts generating party code. New paty code size=" + size);
            } else {
                attemptsSinceRezise++;
            }


            code = "";
            for (int i = 0; i < size; i++) {
                code += characters.charAt(random.nextInt(characters.length()));
            }
        } while (partyRepository.findByPartyCode(code).isPresent());
        return code;
    }
}
