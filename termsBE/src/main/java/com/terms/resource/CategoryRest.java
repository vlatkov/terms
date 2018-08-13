package com.terms.resource;


import com.terms.domen.Category;
import com.terms.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping(value = "${api.path}",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoryRest {

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/category",
            method = RequestMethod.POST)
    //@PreAuthorize("hasRole('ROLE_SUPERUSER')")
    public ResponseEntity<Category> saveCategory(@RequestBody Category category)
    {
        Category savedCategory = categoryService.saveCategory(category);
        HttpHeaders httpHeaders = new HttpHeaders();

        return Optional.ofNullable(savedCategory)
                .map(result -> new ResponseEntity<>(result, httpHeaders ,HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @RequestMapping(value = "/category",
            method = RequestMethod.GET)
    //@PreAuthorize("hasRole('ROLE_SUPERUSER')")
    public ResponseEntity<List<Category>> getAllCategory()
    {
        return Optional.ofNullable(categoryService.getAllCategory())
                .map(result -> new ResponseEntity<>(result,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }



}
