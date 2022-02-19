package com.shop.myshopforcft.entityanddto;

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
        product.setNumber(12322l);
        product.setCountOnStore(3l);

        display.setProduct(product);
        display.setSize(1024.0);

        assertEquals(display.getProduct().getCountOnStore(), 3l);
        assertEquals(display.getProduct().getManufacturer(), "Apple");
        assertEquals(display.getProduct().getNumber(), 12322l);
        assertEquals(display.getProduct().getPrice(), 999.99);
        assertEquals(display.getSize(), 1024.0);

        assertNull(display.getId());
    }

    @Test
    public void testDisplayDto(){
        DisplayDto displayDto = new DisplayDto();
        ProductDto productDto = new ProductDto();

        productDto.setManufacturer("Apple");
        productDto.setPrice(999.99);
        productDto.setNumber(12322l);
        productDto.setCountOnStore(3l);

        displayDto.setProductDto(productDto);
        displayDto.setSize(123.0);

        assertEquals(displayDto.getProductDto().getCountOnStore(), 3l);
        assertEquals(displayDto.getProductDto().getManufacturer(), "Apple");
        assertEquals(displayDto.getProductDto().getNumber(), 12322l);
        assertEquals(displayDto.getProductDto().getPrice(), 999.99);
        assertEquals(displayDto.getSize(), 123.0);

        displayDto.setId(1L);
        assertEquals(displayDto.getId(), 1L);
    }
}
