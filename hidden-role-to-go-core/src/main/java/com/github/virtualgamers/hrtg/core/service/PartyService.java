package com.github.virtualgamers.hrtg.core.service;

import org.springframework.stereotype.Component;
import com.github.virtualgamers.hrtg.core.model.Party;
import com.github.virtualgamers.hrtg.core.model.User;;

/**
 * {@link PartyService} sets up a {@link Party}
 *
 * @author CCThomas
 *
 */
@Component
public interface PartyService {

    /**
     * Add {@link User} to a {@link Party} with partyId
     *
     * @param partyId for a {@link Party}
     * @param user {@link User}
     */
    User addToParty(String partyId, String username);

    /**
     * Gets a {@link Party} by partyId
     *
     * @param partyId
     * @return {@link Party}
     */
    Party getParty(String partyId);

    /**
     * Get the {@link Party} Code
     *
     * @param partyId
     * @return {@link String} partyCode
     */
    String getCode(String partyId);

    /**
     * Starts a {@link Party} for a {@link User}
     *
     * @param user {@link User}
     * @return {@link Party}
     */
    Party startParty(String username);
}
