package com.github.virtualgamers.hrtg.avalon.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Quest {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    String id;

    @Column
    int questNumber;

    @Column
    int numberOnMision;

    @OneToOne
    Player crown;

    @OneToMany
    List<PlayerQuestCard> playerQuestCards;

    @OneToMany
    List<PlayerVoteToken> playerVoteTokens;
}
