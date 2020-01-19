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
    private static final long serialVersionUID = 831938488084888274L;

    @Embeddable
    public static class Pk implements Serializable {
        private static final long serialVersionUID = 895890843575300126L;

        // @ManyToOne
        @Column(name = "id")
        String party;

        @Column(name = "username")
        String username;

        Pk() {}

        Pk(final String party, final String username) {
            this.party = party;
            this.username = username;
        }

        public String getParty() {
            return party;
        }

        public void setParty(final String party) {
            this.party = party;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(final String username) {
            this.username = username;
        }
    }

    @EmbeddedId
    Pk id;

    public User() {}

    public User(final String party, final String username) {
        id = new Pk(party, username);
    }

    public String getParty() {
        return id.party;
    }

    public void setParty(final String party) {
        id.party = party;
    }

    public String getUsername() {
        return id.username;
    }

    public void setUsername(final String username) {
        id.username = username;
    }

    @Override
    public String toString() {
        return "User [party=" + id.party + ", username=" + id.username + "]";
    }

    public Pk getId() {
        return id;
    }
}
