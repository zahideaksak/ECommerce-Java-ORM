package com.tobeto.pairwork_orm.services.dtos.categoryDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryForListingDto {
    private int id;
    private String name;
}
