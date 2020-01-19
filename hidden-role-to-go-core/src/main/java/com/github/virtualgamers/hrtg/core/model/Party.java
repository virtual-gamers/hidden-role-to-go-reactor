package com.github.virtualgamers.hrtg.core.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static Logger logger = LoggerFactory.getLogger(Party.class);

    @Id
    // @GeneratedValue(generator = "system-uuid")
    // @GenericGenerator(name = "system-uuid", strategy = "uuid")
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


    public Party() {/* needed for jpa */}

    public Party(final String partyCode) {
        this.id = partyCode;
        this.partyCode = partyCode;
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

    public void addUsers(final User... users) {
        logger.info("Adding users=" + Arrays.stream(users).map(user -> user.toString())
                .collect(Collectors.joining(",")));

        // Creates mutable list
        addUsers(new ArrayList<>(Arrays.asList(users)));
    }

    public void addUsers(final List<User> users) {
        if (this.users == null) {
            setUsers(users);
        } else {
            this.users.addAll(users);
        }
    }

    public List<User> getUsers() {
        return users;
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
