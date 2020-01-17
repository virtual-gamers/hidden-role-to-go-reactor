package com.github.virtualgamers.hrtg.core.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.github.virtualgamers.hrtg.core.model.Party;

/**
 * {@link CrudRepository} for managing {@link Party}s in the DB
 *
 * @author CCThomas
 *
 */
@Repository
public interface PartyRepository extends CrudRepository<Party, String> {

}
