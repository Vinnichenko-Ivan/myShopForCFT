package com.shop.myshopforcft.entity;

import com.shop.myshopforcft.dto.ProductDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Ivan Vinnichenko
 */

public class ProductTest {
    @Test
    public void ProductToDto(){
        Product product = new Product();
        product.setManufacturer("Apple");
        product.setPrice(999.99);
        product.setNumber(12322L);
        product.setCountOnStore(3L);

        ProductDto productDto = product.getToDto();
        ProductDto productDto2 = new ProductDto();
        productDto2.setManufacturer("Apple");
        productDto2.setPrice(999.99);
        productDto2.setNumber(12322L);
        productDto2.setCountOnStore(3L);


        assertEquals(productDto.getCountOnStore(), 3L);
        assertEquals(productDto.getManufacturer(), "Apple");
        assertEquals(productDto.getNumber(), 12322L);
        assertEquals(productDto.getPrice(), 999.99);
        assertEquals(productDto, productDto2);
        assertEquals(product.getCountOnStore(), 3L);
        assertEquals(product.getManufacturer(), "Apple");
        assertEquals(product.getNumber(), 12322L);
        assertEquals(product.getPrice(), 999.99);
        assertEquals(product.getToDto().getCountOnStore(), 3L);
        assertEquals(product.getToDto().getManufacturer(), "Apple");
        assertEquals(product.getToDto().getNumber(), 12322L);
        assertEquals(product.getToDto().getPrice(), 999.99);
        assertEquals(product.getToDto(), productDto);
        assertEquals(product.getToDto(), productDto2);
    }

    @Test
    public void DtoToProduct(){
        ProductDto productDto = new ProductDto();
        productDto.setManufacturer("Apple");
        productDto.setPrice(999.99);
        productDto.setNumber(12322L);
        productDto.setCountOnStore(3L);

        Product product = new Product();
        product.setFromDto(productDto);
        assertEquals(productDto.getCountOnStore(), 3L);
        assertEquals(productDto.getManufacturer(), "Apple");
        assertEquals(productDto.getNumber(), 12322L);
        assertEquals(productDto.getPrice(), 999.99);
        assertEquals(product.getCountOnStore(), 3L);
        assertEquals(product.getManufacturer(), "Apple");
        assertEquals(product.getNumber(), 12322L);
        assertEquals(product.getPrice(), 999.99);
        assertEquals(product.getToDto().getCountOnStore(), 3L);
        assertEquals(product.getToDto().getManufacturer(), "Apple");
        assertEquals(product.getToDto().getNumber(), 12322L);
        assertEquals(product.getToDto().getPrice(), 999.99);
    }
}
