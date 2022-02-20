package com.shop.myshopforcft.dto;

import com.shop.myshopforcft.entity.enums.ComputerFormFactor;
import lombok.Data;

/**
 * @author Ivan Vinnichenko
 */
@Data
public class ComputerDto {

    private Long id;

    private ComputerFormFactor formFactor;

    private ProductDto productDto;
}
