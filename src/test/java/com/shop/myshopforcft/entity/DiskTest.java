package com.shop.myshopforcft.entity;

import com.shop.myshopforcft.dto.DiskDto;
import com.shop.myshopforcft.dto.ProductDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author Ivan Vinnichenko
 */

public class DiskTest {
    @Test
    public void testDisk(){
        Disk disk = new Disk();
        Product product = new Product();

        product.setManufacturer("Apple");
        product.setPrice(999.99);
        product.setNumber(12322L);
        product.setCountOnStore(3L);

        disk.setProduct(product);
        disk.setSize(1024.0);

        assertEquals(disk.getProduct().getCountOnStore(), 3L);
        assertEquals(disk.getProduct().getManufacturer(), "Apple");
        assertEquals(disk.getProduct().getNumber(), 12322L);
        assertEquals(disk.getProduct().getPrice(), 999.99);
        assertEquals(disk.getSize(), 1024.0);

        assertNull(disk.getId());
    }

    @Test
    public void testDiskDto(){
        DiskDto diskDto = new DiskDto();
        ProductDto productDto = new ProductDto();

        productDto.setManufacturer("Apple");
        productDto.setPrice(999.99);
        productDto.setNumber(12322L);
        productDto.setCountOnStore(3L);

        diskDto.setProductDto(productDto);
        diskDto.setSize(123.0);

        assertEquals(diskDto.getProductDto().getCountOnStore(), 3L);
        assertEquals(diskDto.getProductDto().getManufacturer(), "Apple");
        assertEquals(diskDto.getProductDto().getNumber(), 12322L);
        assertEquals(diskDto.getProductDto().getPrice(), 999.99);
        assertEquals(diskDto.getSize(), 123.0);

        diskDto.setId(1L);
        assertEquals(diskDto.getId(), 1L);
    }
}
