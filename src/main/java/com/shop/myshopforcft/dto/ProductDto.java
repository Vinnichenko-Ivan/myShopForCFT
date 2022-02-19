package com.shop.myshopforcft.dto;

import lombok.Data;

/**
 * @author Ivan Vinnichenko
 */
@Data
public class ProductDto {

    private Long number;

    private String manufacturer;

    private Double price;

    private Long countOnStore;
}
