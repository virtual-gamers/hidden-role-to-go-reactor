package com.github.virtualgamers.hrtg.core.publisher;

import org.springframework.stereotype.Component;

/**
 * Interface for Publishing
 *
 * @author CCThomas
 *
 */
@Component
public interface Publisher {
    void publish(final String channel, final Object message);
}
