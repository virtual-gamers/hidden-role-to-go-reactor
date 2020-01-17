package com.github.virtualgamers.hrtg.core.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import org.hibernate.annotations.GenericGenerator;

/**
 * {@link Game} to represent a {@link Game}
 *
 * @author CCThomas
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Game implements Serializable {
    private static final long serialVersionUID = 5558531536132285623L;

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    String id;

    @Column
    Party party;
}
