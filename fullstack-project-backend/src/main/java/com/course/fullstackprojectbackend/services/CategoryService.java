package com.course.fullstackprojectbackend.services;

import com.course.fullstackprojectbackend.domain.Category;
import com.course.fullstackprojectbackend.repositories.CategoryRepository;
import com.course.fullstackprojectbackend.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public Category findById(Integer id){
        Optional<Category> category = repository.findById(id);
        return category.orElseThrow(() -> new ObjectNotFoundException(
                "Object Not Found. ID: " + id + " Type: " + Category.class.getName()
        ));
    }


}
