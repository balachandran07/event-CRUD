package com.kgfsl.eventapp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kgfsl.eventapp.Event;
import com.kgfsl.eventapp.EventRepository;
import com.kgfsl.eventapp.EventService;
import java.util.stream.Collectors;

@Service("eventService")
public class EventServiceImp implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<Event> getAll() {
        System.out.println("Get All Status");
        // TODO Auto-generated method stub
        return eventRepository.findAll();
    }

    @Override
    public Event save(Event event) {
        
        return eventRepository.saveAndFlush(event);

    }
    // @Override
	// public void update(Event event, Long id) {
    //     event.setId(id);
    //     eventRepository.saveAndFlush(event);
        
	// }

    @Override
    public Event find(long id) {
        // TODO Auto-generated method stub
        return eventRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        eventRepository.delete(id);
    }

    @Override
    public List<Event> get3() {
        // TODO Auto-generated method stub
        return eventRepository.findAll().stream().limit(3).collect(Collectors.toList());
    }

	

}