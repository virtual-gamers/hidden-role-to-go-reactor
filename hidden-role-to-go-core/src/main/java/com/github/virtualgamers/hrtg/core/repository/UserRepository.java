package com.github.virtualgamers.hrtg.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.github.virtualgamers.hrtg.core.model.User;

/**
 * {@link CrudRepository} for managing {@link User}s in the DB
 *
 * @author CCThomas
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, User.Pk> {
}
