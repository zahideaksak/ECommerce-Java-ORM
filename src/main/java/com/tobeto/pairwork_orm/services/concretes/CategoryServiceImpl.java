package com.tobeto.pairwork_orm.services.concretes;

import com.tobeto.pairwork_orm.entities.Category;
import com.tobeto.pairwork_orm.repositories.CategoryRepository;
import com.tobeto.pairwork_orm.services.abstracts.CategoryService;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    @Override
    public void add(CategoryForAddDto dto) {
        if (dto.getName().length() < 3) {
            throw new RuntimeException("The name must add least 3 character.");
        }
        Category category = new Category();
        category.setName(dto.getName());
        categoryRepository.save(category);
    }

    @Override
    public void update(CategoryForUpdateDto dto) {
        if (dto.getName().length() < 3) {
            throw new RuntimeException("The name must add least 3 character.");
        }
        Category category = categoryRepository.findById(dto.getId()).orElseThrow();
        category.setName(dto.getName());
        categoryRepository.save(category);
    }

    @Override
    public void delete(CategoryForDeleteDto dto) {
        Category category = categoryRepository.findById(dto.getId()).orElseThrow();
        categoryRepository.delete(category);
    }

    @Override
    public List<CategoryForListingDto> getAll() {
        List<Category> categories = categoryRepository.findAll();

        List<CategoryForListingDto> result = new ArrayList<>();
        // Listeyi Manual Mapleme - Amatör
        // TODO: Refactor
        for (Category c: categories) {
            CategoryForListingDto dto = new CategoryForListingDto(c.getId(), c.getName());
            result.add(dto);
        }
        return result;
    }

    @Override
    public CategoryForGetByIdDto getById(int id) {
        Category category = categoryRepository.findById(id).orElseThrow();
        return new CategoryForGetByIdDto(category.getId(), category.getName());
    }
}
