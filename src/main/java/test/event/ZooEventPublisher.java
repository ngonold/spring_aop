package test.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class ZooEventPublisher {
    private ApplicationEventPublisher applicationEventPublisher;
    @Autowired
    public ZooEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publishHungryEvent(final String message) {
        ZooEvent zooEvent = new ZooEvent(this, message);
        applicationEventPublisher.publishEvent(zooEvent);
    }
}
