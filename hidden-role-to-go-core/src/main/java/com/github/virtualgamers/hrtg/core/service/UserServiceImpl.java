package com.github.virtualgamers.hrtg.core.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import com.github.virtualgamers.hrtg.core.model.User;
import com.github.virtualgamers.hrtg.core.repository.UserRepository;

@Component
@Primary
public class UserServiceImpl implements UserService {

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    PartyService partyService;

    @Override
    public User createUser(final String partyId, final String username) {
        logger.info("Creating User with partyId=" + partyId + ", username=" + username);

        final User user = userRepository.save(new User(partyId, username));

        logger.info("New User Created. user=" + user);
        return user;
    }

    @Override
    public User getUser(final String partyId, final String username) {
        logger.info("Getting User with partyId=" + partyId + " and username=" + username);

        final Optional<User> optional =
                userRepository.findById(new User(partyId, username).getId());
        if (optional.isEmpty()) {
            throw new IllegalStateException("No User exists for username=" + username);
        }

        final User user = optional.get();
        logger.info("Retireved user=" + user);
        return user;
    }
}
