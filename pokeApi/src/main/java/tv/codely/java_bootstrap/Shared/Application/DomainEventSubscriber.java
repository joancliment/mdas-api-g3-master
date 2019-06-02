package tv.codely.java_bootstrap.Shared.Application;

import tv.codely.java_bootstrap.Shared.Domain.DomainEvent;

public interface DomainEventSubscriber<EventType extends DomainEvent> {

    Class<EventType> subscribedTo();
    void consume(EventType event);

}
