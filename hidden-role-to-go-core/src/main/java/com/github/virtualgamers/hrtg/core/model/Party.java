package com.github.virtualgamers.hrtg.core.model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;

/**
 * Represents a party, or a grouping of {@link User}s playing a {@link Game}
 *
 * @author CCThomas
 *
 */
@Entity
public class Party {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    String id;

    @Column(name = "party_code")
    String partyCode;

    @Column(name = "party_leader_user_id")
    String partyLeaderUserId;

    @Column(name = "game_id")
    String gameId;

    /**
     * {@link LinkedList} is used, as with most games, turn order will matter.
     */
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true,
            mappedBy = "id.party")
    List<User> users;

    public Party() {}

    public Party(final User user) {
        this.partyLeaderUserId = user.getUsername();
        this.users = new LinkedList<>();
        this.users.add(user);
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getPartyCode() {
        return partyCode;
    }

    public void setPartyCode(final String partyCode) {
        this.partyCode = partyCode;
    }

    public void setUsers(final List<User> users) {
        this.users = users;
    }

    public String getPartyLeaderUserId() {
        return partyLeaderUserId;
    }

    public void setPartyLeaderUserId(final String partyLeaderUserId) {
        this.partyLeaderUserId = partyLeaderUserId;
    }

    public void addUsers(final User... abstractUsers) {
        addUsers(Arrays //
                .stream(abstractUsers) //
                .map(abstractUser -> abstractUser) //
                .collect(Collectors.toCollection(LinkedList::new)));
    }

    public void addUsers(final LinkedList<User> abstractUsers) {
        if (this.users == null) {
            setUsers(abstractUsers);
        }
        this.users.addAll(abstractUsers);
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(final LinkedList<User> users) {
        this.users = users;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(final String gameId) {
        this.gameId = gameId;
    }

    @Override
    public String toString() {
        return "Party [id=" + id + ", partyCode=" + partyCode + ", partyLeaderUserId="
                + partyLeaderUserId + ", gameId=" + gameId + ", users=" + users + "]";
    }
}
