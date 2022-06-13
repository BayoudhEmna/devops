package io.order.manager.food.order.manager.repositories;

import io.order.manager.food.order.manager.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Integer> {
}
