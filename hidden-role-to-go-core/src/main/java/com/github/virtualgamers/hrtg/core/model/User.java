package com.github.virtualgamers.hrtg.core.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * {@link User} to represent a {@link User}
 *
 * @author CCThomas
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable {
    private static final long serialVersionUID = -5150843110738770669L;

    /**
     * Primary Key for {@link User}
     *
     * @author CCThomas
     *
     */
    @Embeddable
    public static class Pk implements Serializable {
        private static final long serialVersionUID = 895890843575300126L;

        @Column(name = "party_id")
        String partyId;

        @Column(name = "username")
        String username;

        Pk() {/* required for jpa */}

        public Pk(final String partyId, final String username) {
            this.partyId = partyId;
            this.username = username;
        }

        public String getPartyId() {
            return partyId;
        }

        public void setPartyId(final String partyId) {
            this.partyId = partyId;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(final String username) {
            this.username = username;
        }

        @Override
        public String toString() {
            return "Pk [partyId=" + partyId + ", username=" + username + "]";
        }
    }

    @EmbeddedId
    Pk id;

    public User() {/* required for jpa */}

    public User(final String partyId, final String username) {
        id = new Pk(partyId, username);
    }

    public String getPartyId() {
        return id.partyId;
    }

    public void setPartyId(final String partyId) {
        this.id.partyId = partyId;
    }

    public String getUsername() {
        return id.username;
    }

    public void setUsername(final String username) {
        id.username = username;
    }

    public Pk getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User [id=" + id + "]";
    }
}
