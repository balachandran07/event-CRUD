package com.kgfsl.eventapp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kgfsl.eventapp.Event;
import com.kgfsl.eventapp.EventRepository;
import com.kgfsl.eventapp.EventService;

@Service
public class BookCategoryServiceImp implements BookCategoryService {

    @Autowired
    private BookCategoryRepository bookCategoryRepository;

    @Override
    public List<BookCategory> getAll() {
        // TODO Auto-generated method stub
        return bookCategoryRepository.findAll();
    }

    @Override
    public BookCategory save(BookCategory bookCategory) {
        // TODO Auto-generated method stub
        return bookCategoryRepository.saveAndFlush(bookCategory);

    }

    @Override
    public BookCategory find(long id) {
        // TODO Auto-generated method stub
        return bookCategoryRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        bookCategoryRepository.delete(id);
    }

}