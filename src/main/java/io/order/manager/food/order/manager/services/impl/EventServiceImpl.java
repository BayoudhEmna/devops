package io.order.manager.food.order.manager.services.impl;

import io.order.manager.food.order.manager.entities.Event;
import io.order.manager.food.order.manager.repositories.EventRepository;
import io.order.manager.food.order.manager.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepository eventRepository;
    @Override
    public Event findOneEvent(int id) {
        return null;
    }

    @Override
    public Event saveEvent(Event event) {
        Event category = eventRepository.save(event);
        return category;
    }

    @Override
    public void updateEvent(int id, Event event) {
        if(!Objects.equals(id, event.getId())){
            throw new IllegalArgumentException("IDs don't match");
        }
        eventRepository.save(event);
    }

    @Override
    public String deleteEvent(int id) {
        if (eventRepository.findById(id).isPresent()) {
            eventRepository.deleteById(id);
            return "category supprimé";
        } else {
            return "category non supprimé";
        }
    }

    @Override
    public List<Event> getAllEvent() {
        List<Event> allEvents = eventRepository.findAll();
        return allEvents;
    }
}
