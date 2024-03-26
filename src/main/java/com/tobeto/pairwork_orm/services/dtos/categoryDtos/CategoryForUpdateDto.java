package com.tobeto.pairwork_orm.services.dtos.categoryDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryForUpdateDto {
    private int id;
    private String name;
}
