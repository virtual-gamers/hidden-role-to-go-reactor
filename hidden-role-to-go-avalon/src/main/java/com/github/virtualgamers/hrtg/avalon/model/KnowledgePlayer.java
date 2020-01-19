package com.github.virtualgamers.hrtg.avalon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class KnowledgePlayer extends KnowledgeRole {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    String id;

    @Column
    private String username;

    public KnowledgePlayer(final KnowledgeRole knowledgeRole, final String username) {
        super(knowledgeRole.getRole(), knowledgeRole.getKnowledge());
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }
}
