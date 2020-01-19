package com.github.virtualgamers.hrtg.avalon.model;

import javax.persistence.Entity;
import com.github.virtualgamers.hrtg.avalon.enums.VoteToken;

@Entity
public class PlayerVoteToken {
    Player player;
    VoteToken voteToken;
}
