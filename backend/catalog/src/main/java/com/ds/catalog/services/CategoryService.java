package com.ds.catalog.services;

import com.ds.catalog.dto.CategoryDto;
import com.ds.catalog.entities.Category;
import com.ds.catalog.repository.CategoryRepository;
import com.ds.catalog.services.exceptions.EntityNotFoundException;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    ModelMapper mapper;

    @Transactional
    public List<CategoryDto> findAll(){
        List<Category> category = repository.findAll();
        List<CategoryDto> categoryDto = category.stream()
                .map(e -> mapper.map(e, CategoryDto.class)).toList();
        return categoryDto;
    }

    @Transactional
    public CategoryDto findById(long id){
        Optional<Category> obj = repository.findById(id);
        Category entity = obj.orElseThrow(() -> new EntityNotFoundException("Entidade não encontrada!"));
        return new CategoryDto(entity);
    }
}
