package com.terms.services;


import com.terms.domen.Category;
import com.terms.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.PublicKey;
import java.util.List;

@Service
@Transactional
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }
    public List<Category> getCategoryByName(String name){
        return categoryRepository.findAllByName(name);
    }

    @Transactional
    public Category saveCategory(Category category){
        return categoryRepository.save(category);
    }
}
