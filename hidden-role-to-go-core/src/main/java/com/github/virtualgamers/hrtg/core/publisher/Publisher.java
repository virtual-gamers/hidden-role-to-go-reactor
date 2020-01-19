package com.github.virtualgamers.hrtg.core.publisher;

import org.springframework.stereotype.Component;

@Component
public interface Publisher {
    void publish(final String channel, final Object message);
}
