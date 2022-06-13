package io.order.manager.food.order.manager.services;

import io.order.manager.food.order.manager.dto.FoodOrderDTO;
import io.order.manager.food.order.manager.entities.Event;

import java.util.List;

public interface EventService {
    Event findOneEvent(int id);
    Event saveEvent(Event event);
    void updateEvent(int id,Event event);
    String deleteEvent(int id );
    List<Event> getAllEvent();
}
