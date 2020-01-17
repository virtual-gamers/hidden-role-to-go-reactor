package com.github.virtualgamers.hrtg.core.service;

import org.springframework.stereotype.Component;
import com.github.virtualgamers.hrtg.core.model.Party;
import com.github.virtualgamers.hrtg.core.model.User;

/**
 * {@link User} Service
 *
 * @author CCThomas
 *
 */
@Component
public interface UserService {
    /**
     * Creates a {@link User} with a given username
     *
     * @param partyId for a {@link Party}
     * @param username for a {@link User}
     * @return {@link User}
     */
    User createUser(String partyId, String username);

    /**
     *
     * @param partyId
     * @param username
     * @return
     */
    User getUser(String partyId, String username);
}
