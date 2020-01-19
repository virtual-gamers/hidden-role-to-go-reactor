package com.github.virtualgamers.hrtg.avalon.model;

import javax.persistence.Embeddable;
import com.github.virtualgamers.hrtg.avalon.enums.Knowledge;
import com.github.virtualgamers.hrtg.avalon.enums.CharacterCard;

@Embeddable
public class KnowledgeRole {
    private final CharacterCard role;
    private final Knowledge knowledge;

    public KnowledgeRole(final CharacterCard role, final Knowledge knowledge) {
        this.role = role;
        this.knowledge = knowledge;
    }

    public CharacterCard getRole() {
        return role;
    }

    public Knowledge getKnowledge() {
        return knowledge;
    }
}
