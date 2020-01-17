package com.github.virtualgamers.hrtg.core.model;

import java.io.Serializable;

public class UserPK implements Serializable {
    private static final long serialVersionUID = -1985891138211154970L;
    public String partyId;
    public String username;

    public UserPK() {}

    public UserPK(final String partyId, final String username) {
        super();
        this.partyId = partyId;
        this.username = username;
    }
}
