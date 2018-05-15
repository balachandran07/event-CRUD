package com.kgfsl.eventapp;


import java.util.List;

import com.kgfsl.eventapp.Event;

public interface BookCategoryService {

    public List<BookCategory> getAll();

    public BookCategory save(BookCategory event);

    public BookCategory find(long id);

    public void delete(Long id);

}