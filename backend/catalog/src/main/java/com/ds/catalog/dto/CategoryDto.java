package com.ds.catalog.dto;

import com.ds.catalog.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto implements Serializable {

    private Long id;
    private String name;

    public CategoryDto(Category entity){
        this.id = entity.getId();
        this.name = entity.getName();
    }
}
