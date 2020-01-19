package com.github.virtualgamers.hrtg.avalon.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Avalon {

    @OneToOne
    Player ladyOfTheLake;

    @Column
    boolean lancelotCurrentlyFlipped;

    @OneToMany
    List<LancelotInfo> lancelotInfo;

    int voteMarkerCounter;

    int currentQuestNumber;

    @OneToMany
    List<Quest> quest;
}
