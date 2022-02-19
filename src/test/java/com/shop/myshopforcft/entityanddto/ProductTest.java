package com.shop.myshopforcft.entityanddto;

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
        product.setNumber(12322l);
        product.setCountOnStore(3l);

        ProductDto productDto = product.getToDto();
        ProductDto productDto2 = new ProductDto();
        productDto2.setManufacturer("Apple");
        productDto2.setPrice(999.99);
        productDto2.setNumber(12322l);
        productDto2.setCountOnStore(3l);


        assertEquals(productDto.getCountOnStore(), 3l);
        assertEquals(productDto.getManufacturer(), "Apple");
        assertEquals(productDto.getNumber(), 12322l);
        assertEquals(productDto.getPrice(), 999.99);
        assertEquals(productDto, productDto2);
        assertEquals(product.getCountOnStore(), 3l);
        assertEquals(product.getManufacturer(), "Apple");
        assertEquals(product.getNumber(), 12322l);
        assertEquals(product.getPrice(), 999.99);
        assertEquals(product.getToDto().getCountOnStore(), 3l);
        assertEquals(product.getToDto().getManufacturer(), "Apple");
        assertEquals(product.getToDto().getNumber(), 12322l);
        assertEquals(product.getToDto().getPrice(), 999.99);
        assertEquals(product.getToDto(), productDto);
        assertEquals(product.getToDto(), productDto2);
    }

    @Test
    public void DtoToProduct(){
        ProductDto productDto = new ProductDto();
        productDto.setManufacturer("Apple");
        productDto.setPrice(999.99);
        productDto.setNumber(12322l);
        productDto.setCountOnStore(3l);

        Product product = new Product();
        product.setFromDto(productDto);
        assertEquals(productDto.getCountOnStore(), 3l);
        assertEquals(productDto.getManufacturer(), "Apple");
        assertEquals(productDto.getNumber(), 12322l);
        assertEquals(productDto.getPrice(), 999.99);
        assertEquals(product.getCountOnStore(), 3l);
        assertEquals(product.getManufacturer(), "Apple");
        assertEquals(product.getNumber(), 12322l);
        assertEquals(product.getPrice(), 999.99);
        assertEquals(product.getToDto().getCountOnStore(), 3l);
        assertEquals(product.getToDto().getManufacturer(), "Apple");
        assertEquals(product.getToDto().getNumber(), 12322l);
        assertEquals(product.getToDto().getPrice(), 999.99);
    }
}
