package io.order.manager.food.order.manager.services.impl;


import io.order.manager.food.order.manager.dto.CategoryDTO;
import io.order.manager.food.order.manager.entities.Category;
import io.order.manager.food.order.manager.mappers.CategoryMapper;
import io.order.manager.food.order.manager.repositories.CategoryRepository;
import io.order.manager.food.order.manager.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CategoryServicesImp implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<CategoryDTO> listAll() {
        List<Category> allcategories = categoryRepository.findAll();
        return allcategories.stream().map(x -> categoryMapper.convertEntityToDto(x)).collect(Collectors.toList());
    }

    @Override
    public CategoryDTO save(CategoryDTO cat) {
        Category category = categoryRepository.save(categoryMapper.convertDtoToEntity(cat));
        return categoryMapper.convertEntityToDto(category);
    }

    @Override
    public void update(Long id, CategoryDTO categoryDTO) {
        if(!Objects.equals(id, categoryDTO.getId())){
            throw new IllegalArgumentException("IDs don't match");
        }
        Category category = categoryMapper.convertDtoToEntity(categoryDTO);
        categoryRepository.save(category);
    }

    @Override
    public String delete(Long id) {
        if (categoryRepository.findById(id).isPresent()) {
            categoryRepository.deleteById(id);
            return "category supprimé";
        } else {
            return "category non supprimé";
        }
    }
}
