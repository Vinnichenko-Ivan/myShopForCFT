package com.shop.myshopforcft.entity;

import com.shop.myshopforcft.dto.DisplayDto;
import com.shop.myshopforcft.dto.ProductDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author Ivan Vinnichenko
 */

public class DisplayTest {
    @Test
    public void testDisplay(){
        Display display = new Display();
        Product product = new Product();

        product.setManufacturer("Apple");
        product.setPrice(999.99);
        product.setNumber(12322L);
        product.setCountOnStore(3L);

        display.setProduct(product);
        display.setDiagonal(1024.0);

        assertEquals(display.getProduct().getCountOnStore(), 3L);
        assertEquals(display.getProduct().getManufacturer(), "Apple");
        assertEquals(display.getProduct().getNumber(), 12322L);
        assertEquals(display.getProduct().getPrice(), 999.99);
        assertEquals(display.getDiagonal(), 1024.0);

        assertNull(display.getId());
    }

    @Test
    public void testDisplayDto(){
        DisplayDto displayDto = new DisplayDto();
        ProductDto productDto = new ProductDto();

        productDto.setManufacturer("Apple");
        productDto.setPrice(999.99);
        productDto.setNumber(12322L);
        productDto.setCountOnStore(3L);

        displayDto.setProductDto(productDto);
        displayDto.setDiagonal(123.0);

        assertEquals(displayDto.getProductDto().getCountOnStore(), 3L);
        assertEquals(displayDto.getProductDto().getManufacturer(), "Apple");
        assertEquals(displayDto.getProductDto().getNumber(), 12322L);
        assertEquals(displayDto.getProductDto().getPrice(), 999.99);
        assertEquals(displayDto.getDiagonal(), 123.0);

        displayDto.setId(1L);
        assertEquals(displayDto.getId(), 1L);
    }
}
