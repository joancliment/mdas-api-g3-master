package tv.codely.java_bootstrap.Shared.Infrastructure;

import reactor.bus.Event;
import reactor.bus.selector.Selector;
import tv.codely.java_bootstrap.Shared.Application.DomainEventSubscriber;
import tv.codely.java_bootstrap.Shared.Domain.DomainEvent;
import tv.codely.java_bootstrap.Shared.Domain.EventBus;
import reactor.fn.Consumer;
import java.util.List;
import java.util.Set;

import static reactor.bus.selector.Selectors.$;

public class ReactorEventBus implements EventBus {

    private final reactor.bus.EventBus bus;

    public ReactorEventBus(final Set<DomainEventSubscriber> subscribers) {
        bus = reactor.bus.EventBus.create();

        subscribers.forEach(this::registerOnEventBus);
    }

    @Override
    public void publish(final List<DomainEvent> events) {
        events.forEach(this::publish);
    }

    public void publish(final DomainEvent event) {
        Class<? extends DomainEvent> eventIdentifier = event.getClass();
        Event<DomainEvent> wrappedEvent = Event.wrap(event);

        bus.notify(eventIdentifier, wrappedEvent);
    }

    private void registerOnEventBus(final DomainEventSubscriber subscriber) {
        final Selector eventIdentifier = $(subscriber.subscribedTo());

        bus.on(eventIdentifier, eventConsumer(subscriber));
    }

    private Consumer<Event> eventConsumer(final DomainEventSubscriber subscriber) {
        return (Event reactorEvent) -> {
            DomainEvent unwrappedEvent = (DomainEvent) reactorEvent.getData();
            subscriber.consume(unwrappedEvent);
        };
    }

}
