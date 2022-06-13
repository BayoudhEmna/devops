package io.order.manager.food.order.manager.ressources;


import io.order.manager.food.order.manager.dto.CategoryDTO;
import io.order.manager.food.order.manager.entities.Event;
import io.order.manager.food.order.manager.services.CategoryService;
import io.order.manager.food.order.manager.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/events")
public class EventRessources {
    @Autowired
    EventService eventService;

    @GetMapping
    // Affiche Liste des events
    public List<Event> allEvents() {
        return eventService.getAllEvent();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    //Ajouter events:
    public ResponseEntity<Event> addEvent(@RequestBody Event event) {
        return new ResponseEntity<>(eventService.saveEvent(event), HttpStatus.OK);    }


    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    // Update event
    public ResponseEntity<String> updateEvent(@PathVariable(value = "id") int id, @RequestBody Event event) {
        eventService.updateEvent(id, event);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    // Delete category
    public ResponseEntity<String> deletecategory(@PathVariable(value = "id") int id) {
        eventService.deleteEvent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
