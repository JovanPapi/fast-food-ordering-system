package com.fastfood.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private String name;
    private String nameTranslate;
    private int price;
    private String description;
    private String ingredients;
    private String type;
}
