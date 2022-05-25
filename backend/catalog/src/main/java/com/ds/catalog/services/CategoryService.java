package com.ds.catalog.services;

import com.ds.catalog.dto.CategoryDto;
import com.ds.catalog.entities.Category;
import com.ds.catalog.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;


import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    ModelMapper mapper;

    public List<CategoryDto> findAll(){
        List<Category> category = repository.findAll();

        List<CategoryDto> categoryDto = category.stream()
                .map(e -> mapper.map(e, CategoryDto.class)).toList();

        return categoryDto;
    }
}
