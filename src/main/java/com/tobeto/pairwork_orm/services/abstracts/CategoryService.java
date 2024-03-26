package com.tobeto.pairwork_orm.services.abstracts;

import com.tobeto.pairwork_orm.entities.Category;
import com.tobeto.pairwork_orm.services.dtos.categoryDtos.*;

import java.util.List;

public interface CategoryService {
    void add(CategoryForAddDto dto);
    void update(CategoryForUpdateDto dto);
    void delete(CategoryForDeleteDto dto);
    List<CategoryForListingDto> getAll();
    CategoryForGetByIdDto getById(int id);
}
