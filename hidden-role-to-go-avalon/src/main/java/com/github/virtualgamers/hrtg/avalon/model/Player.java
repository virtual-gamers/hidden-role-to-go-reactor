package com.github.virtualgamers.hrtg.avalon.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import com.github.virtualgamers.hrtg.avalon.enums.CharacterCard;
import com.github.virtualgamers.hrtg.core.model.User;

@Entity
public class Player extends User {

    @Column
    private CharacterCard role;

    @Column
    private boolean hasTeamToken;

    @Column
    private boolean alignmentFlipped;

    @Column
    boolean onceLadyOfTheLake;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    List<KnowledgePlayer> knowledgePlayer;
}
