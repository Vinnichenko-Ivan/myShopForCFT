package com.shop.myshopforcft.entity;

import com.shop.myshopforcft.dto.ComputerDto;
import com.shop.myshopforcft.dto.ProductDto;
import com.shop.myshopforcft.entity.enums.ComputerFormFactor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Ivan Vinnichenko
 */

public class ComputerTest {
    @Test
    public void testComputer(){

        Computer computer = new Computer();
        Product product = new Product();

        product.setManufacturer("Apple");
        product.setPrice(999.99);
        product.setNumber(12322L);
        product.setCountOnStore(3L);

        computer.setProduct(product);
        computer.setFormFactor(ComputerFormFactor.DESKTOP);

        assertEquals(computer.getProduct().getCountOnStore(), 3L);
        assertEquals(computer.getProduct().getManufacturer(), "Apple");
        assertEquals(computer.getProduct().getNumber(), 12322L);
        assertEquals(computer.getProduct().getPrice(), 999.99);
        assertEquals(computer.getFormFactor(), ComputerFormFactor.DESKTOP);

        assertNull(computer.getId());
    }

    @Test
    public void testComputerDto(){
        ComputerDto computerDto = new ComputerDto();
        ProductDto productDto = new ProductDto();

        productDto.setManufacturer("Apple");
        productDto.setPrice(999.99);
        productDto.setNumber(12322L);
        productDto.setCountOnStore(3L);

        computerDto.setProductDto(productDto);
        computerDto.setFormFactor(ComputerFormFactor.DESKTOP);

        assertEquals(computerDto.getProductDto().getCountOnStore(), 3L);
        assertEquals(computerDto.getProductDto().getManufacturer(), "Apple");
        assertEquals(computerDto.getProductDto().getNumber(), 12322L);
        assertEquals(computerDto.getProductDto().getPrice(), 999.99);
        assertEquals(computerDto.getFormFactor(), ComputerFormFactor.DESKTOP);

        computerDto.setId(1L);
        assertEquals(computerDto.getId(), 1L);

    }
}
