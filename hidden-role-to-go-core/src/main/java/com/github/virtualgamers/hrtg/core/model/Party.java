package com.github.virtualgamers.hrtg.core.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import com.github.virtualgamers.hrtg.core.model.listener.PartyListener;

/**
 * Represents a party, or a grouping of {@link User}s playing a {@link Game}
 *
 * @author CCThomas
 *
 */
@Entity
@EntityListeners(PartyListener.class)
public class Party implements Serializable {
    private static final long serialVersionUID = 3680839567940085207L;

    @Id
    String id; // Will Act as Party Code

    @Column(name = "party_leader_user_id")
    String partyLeaderUserId;

    @OneToOne
    Game game;

    /**
     * {@link LinkedList} is used, as with most games, turn order will matter.
     */
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true,

            mappedBy = "id.partyId")
    List<User> users;


    public Party() {/* required for jpa */}

    public Party(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getPartyLeaderUserId() {
        return partyLeaderUserId;
    }

    public void setPartyLeaderUserId(final String partyLeaderUserId) {
        this.partyLeaderUserId = partyLeaderUserId;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(final Game game) {
        this.game = game;
    }

    public List<User> getUsers() {
        return users;
    }


    public void setUsers(final List<User> users) {
        this.users = users;
    }

    /**
     * Add {@link List} of {@link User}s to {@link Party#users}
     *
     * @param users {@link List} of {@link User}s
     */
    public void addUsers(final List<User> users) {
        if (this.users == null) {
            this.users = users;
        } else {
            users.addAll(users);
        }
    }

    /**
     * Add {@link Array} of {@link User}s to {@link Party#users}
     *
     * @param users {@link List} of {@link User}s
     */
    public void addUsers(final User... users) {
        addUsers(new ArrayList<>(Arrays.asList(users)));

    }

    @Override
    public String toString() {

        return "Party [id=" + id + ", partyLeaderUserId=" + partyLeaderUserId + ", game=" + game
                + ", users=" + users + "]";
    }
}
