 package com.kgfsl.eventapp;

import java.util.List;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import com.kgfsl.eventapp.Event;
import com.kgfsl.eventapp.EventService;
import com.kgfsl.eventapp.EventRepository;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/events")
public class EventController {

    @Autowired
    private EventService eventService;
    private EventRepository eventRepository;
    @GetMapping("/get")
    public @ResponseBody ResponseEntity<List<Event>> all() {
        return new ResponseEntity<>(eventService.getAll(), HttpStatus.OK);
    }

    // @GetMapping("/get/{eventId}")
    // public @ResponseBody ResponseEntity<?> getById(@PathVariable Long eventId) {

    //     Event event = eventService.find(eventId);
    //     return new ResponseEntity<>(event, HttpStatus.OK);

    // }

    @GetMapping("/get/{eventId}")
    public @ResponseBody ResponseEntity<?> getById(@PathVariable Long eventId) {

        Event event = eventService.find(eventId);
        
        return new ResponseEntity<>(event, HttpStatus.OK);

    }

    @GetMapping("/get3")
    public @ResponseBody ResponseEntity<List<Event>> get3() {
        return new ResponseEntity<>(eventService.get3(), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<?> post(@RequestBody Event event, UriComponentsBuilder ucBuilder) {
        eventService.save(event);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/get/{id}").buildAndExpand(event.getId()).toUri());
        return new ResponseEntity<>(event,headers, HttpStatus.CREATED);

    }
    @PutMapping("/put/{eventId}")
    public ResponseEntity<Object> put( @RequestBody Event event,@PathVariable Long eventId, UriComponentsBuilder ucBuilder) {
         eventService.save(event);
      
        // System.out.println(" eventId"+ eventId);
        // Event e=eventService.find(eventId);
        // System.out.println("object address"+e);
        // System.out.println("old location"+e.getLocation());
        
        // e.setEdition(event.getEdition());
        // e.setDate(event.getDate());
        // e.setLocation(event.getLocation());
        // e.setAgenda(event.getAgenda());


        // System.out.println("new location "+e.getLocation());
        // System.out.println(e.getId()+" "+e.getDate()+" "+e.getLocation());
       
        // eventRepository.saveAndFlush(e);
        // eventService.save(e);
        // HttpHeaders headers = new HttpHeaders();
        // headers.setLocation(ucBuilder.path("/get/{id}").buildAndExpand(event.getId()).toUri());
       
       
       
        return new ResponseEntity<>(event, HttpStatus.CREATED);
    }



    // @PutMapping("/students/{id}")
	// public ResponseEntity<Object> updateStudent(@RequestBody Student student, @PathVariable long id) {

	// 	Optional<Student> studentOptional = studentRepository.findById(id);

	// 	if (!studentOptional.isPresent())
	// 		return ResponseEntity.notFound().build();

	// 	student.setId(id);
		
	// 	studentRepository.save(student);

	// 	return ResponseEntity.noContent().build();
	// }

 

    // @DeleteMapping("/delete/{eventId}")
    // public ResponseEntity<?> delete(@PathVariable Long eventId) {
    //     //Event currentevent = eventService.find(eventId);
    //     eventService.delete(eventId);
    //     return new ResponseEntity<>(HttpStatus.OK);
    // }


}



// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// @CrossOrigin("*")

// @RequestMapping("api/events")
// public class EventController{
//     @Autowired
//     private EventService eventService;
//     @RequestMapping(method=RequestMethod.POST)
//     public ResponseEntity<?> save(@RequestBody Event event){
//         eventService.save(event);
//         return new ResponseEntity<Event>(event,HttpStatus.OK);
//     }
//     @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
// 	public void delete(@PathVariable Long id) {
// 		eventService.delete(id);
//     }
//     @RequestMapping(method = RequestMethod.GET)
// 	public List<Event> get() {
// 		return eventService.getAll();
// 	}
//     @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
// 	public Event find(@PathVariable Long id) {
// 		return eventService.find(id);
// 	}
//     @RequestMapping(value = "put/{id}", method = RequestMethod.PUT)
    
//         public ResponseEntity<?> update(@RequestBody Event event, @PathVariable("id") Long id) {
//             Event f1=event;
//             System.out.println(id+"+++++++++");
//             eventService.update(f1, id);           
//             return new ResponseEntity<Event>(HttpStatus.OK);
        
//         }
    
    
// }