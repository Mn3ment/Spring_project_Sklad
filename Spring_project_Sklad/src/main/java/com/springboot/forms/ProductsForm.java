package com.springboot.forms;

import lombok.Data;

@Data
public class ProductsForm {
    private String description;
    private Double price;
    private Integer count;
}
