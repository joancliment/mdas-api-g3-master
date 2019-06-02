package tv.codely.java_bootstrap.Shared.Domain;

import java.util.List;

public interface EventBus {
    void publish(final List<DomainEvent> events);

    void publish(DomainEvent event);
}
