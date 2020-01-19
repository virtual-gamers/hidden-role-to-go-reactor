package com.github.virtualgamers.hrtg.core.model.listener;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.github.virtualgamers.hrtg.core.model.Party;
import com.github.virtualgamers.hrtg.core.publisher.Publisher;

@Component
public class PartyListener {
    Logger logger = LoggerFactory.getLogger(PartyListener.class);

    @Autowired
    Publisher publisher;

    @PostPersist
    @PostUpdate
    public void post(final Party party) {
        logger.info("post with party=" + party);
        publisher.publish("party", party);
    }
}
