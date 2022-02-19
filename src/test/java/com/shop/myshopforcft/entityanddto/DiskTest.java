package com.shop.myshopforcft.entityanddto;

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
        product.setNumber(12322l);
        product.setCountOnStore(3l);

        disk.setProduct(product);
        disk.setSize(1024.0);

        assertEquals(disk.getProduct().getCountOnStore(), 3l);
        assertEquals(disk.getProduct().getManufacturer(), "Apple");
        assertEquals(disk.getProduct().getNumber(), 12322l);
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
        productDto.setNumber(12322l);
        productDto.setCountOnStore(3l);

        diskDto.setProductDto(productDto);
        diskDto.setSize(123.0);

        assertEquals(diskDto.getProductDto().getCountOnStore(), 3l);
        assertEquals(diskDto.getProductDto().getManufacturer(), "Apple");
        assertEquals(diskDto.getProductDto().getNumber(), 12322l);
        assertEquals(diskDto.getProductDto().getPrice(), 999.99);
        assertEquals(diskDto.getSize(), 123.0);

        diskDto.setId(1L);
        assertEquals(diskDto.getId(), 1L);
    }
}
