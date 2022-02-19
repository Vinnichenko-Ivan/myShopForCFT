package com.shop.myshopforcft.dto;

import lombok.Data;

/**
 * @author Ivan Vinnichenko
 */
@Data
public class DiskDto {

    private Long id;

    private Double size;

    private ProductDto productDto;
}
