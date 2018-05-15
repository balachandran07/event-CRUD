package com.kgfsl.eventapp;

import com.kgfsl.eventapp.BookCategory;
import com.kgfsl.eventapp.BookCategoryRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.util.UriComponentsBuilder;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api//BookCategorys")
public class BookCategoryController {
  
  @Autowired
  private BookCategoryService bookCategoryService;

  @GetMapping("/get")
  public @ResponseBody ResponseEntity<List<BookCategory>> all() {
      return new ResponseEntity<>(bookCategoryService.getAll(), HttpStatus.OK);
  }

  @PostMapping("/post")
  public ResponseEntity<?> post(@RequestBody BookCategory bookCategory, UriComponentsBuilder ucBuilder) {
      bookCategoryService.save(bookCategory);
      HttpHeaders headers = new HttpHeaders();
      headers.setLocation(ucBuilder.path("/get/{id}").buildAndExpand(bookCategory.getBookcatId()).toUri());
      return new ResponseEntity<>(headers, HttpStatus.CREATED);

  }

  @GetMapping("/get/{bookcatId}")
  public @ResponseBody ResponseEntity<?> getById(@PathVariable Long bookcatId) {

      BookCategory bookCategory = bookCategoryService.find(bookcatId);
      return new ResponseEntity<>(bookCategory, HttpStatus.OK);

  }

  @PutMapping("/put/{bookcatId}")
  public ResponseEntity<?> put(@PathVariable Long bookcatId, @RequestBody BookCategory bookCategory) {
      bookCategoryService.save(bookCategory);
      return new ResponseEntity<>(bookCategory, HttpStatus.OK);
  }

  @DeleteMapping("/delete/{bookcatId}")
  public ResponseEntity<?> delete(@PathVariable Long bookcatId) {
      //Event currentevent = bookCategoryService.find(eventId);
      bookCategoryService.delete(bookcatId);
      return new ResponseEntity<>(HttpStatus.OK);
  }
}