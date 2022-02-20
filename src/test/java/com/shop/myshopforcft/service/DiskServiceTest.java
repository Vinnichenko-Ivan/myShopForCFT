package com.shop.myshopforcft.service;

import com.shop.myshopforcft.dto.DiskDto;
import com.shop.myshopforcft.dto.ProductDto;
import com.shop.myshopforcft.entity.Disk;
import com.shop.myshopforcft.entity.Product;
import com.shop.myshopforcft.repository.DisksRepository;
import com.shop.myshopforcft.repository.ProductReposintory;
import com.shop.myshopforcft.service.impl.DiskServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * @author Ivan Vinnichenko
 */

public class DiskServiceTest {
    private DiskService diskService;

    private DisksRepository diskRepositiry;

    private ProductReposintory productReposintory;

    @BeforeEach
    public void init(){
        diskRepositiry = mock(DisksRepository.class);

        productReposintory = mock(ProductReposintory.class);

        diskService = new DiskServiceImpl(productReposintory, diskRepositiry);
    }


    private final Answer<Double> addNewProduct = (invocation -> {
        Product product = (Product) invocation.getArguments()[0];

        assertEquals(product.getCountOnStore(), 3L);
        assertEquals(product.getManufacturer(), "Apple");
        assertEquals(product.getNumber(), 12322L);
        assertEquals(product.getPrice(), 999.99);
        assertEquals(product.getToDto().getCountOnStore(), 3L);
        assertEquals(product.getToDto().getManufacturer(), "Apple");
        assertEquals(product.getToDto().getNumber(), 12322L);
        assertEquals(product.getToDto().getPrice(), 999.99);
        return null;
    });

    private Answer<Double> deleteDisk = new Answer<Double>() {
        @Override
        public Double answer(InvocationOnMock invocation) throws Throwable
        {
            return null;
        }
    };

    private Answer<Double> addNewDisk = new Answer<Double>() {
        @Override
        public Double answer(InvocationOnMock invocation) throws Throwable
        {
            Disk disk = (Disk) invocation.getArguments()[0];

            assertEquals(disk.getProduct().getCountOnStore(), 3L);
            assertEquals(disk.getProduct().getManufacturer(), "Apple");
            assertEquals(disk.getProduct().getNumber(), 12322L);
            assertEquals(disk.getProduct().getPrice(), 999.99);
            assertEquals(disk.getProduct().getToDto().getCountOnStore(), 3L);
            assertEquals(disk.getProduct().getToDto().getManufacturer(), "Apple");
            assertEquals(disk.getProduct().getToDto().getNumber(), 12322L);
            assertEquals(disk.getProduct().getToDto().getPrice(), 999.99);
            assertEquals(disk.getSize(), 1.0);

            return null;
        }
    };

    @Test
    public void test(){
        ProductDto productDto = new ProductDto();

        DiskDto diskDto = new DiskDto();

        productDto.setManufacturer("Apple");
        productDto.setPrice(999.99);
        productDto.setNumber(12322L);
        productDto.setCountOnStore(3L);

        diskDto.setProductDto(productDto);
        diskDto.setSize(1.0);
        when(productReposintory.save(any())).then(addNewProduct);
        when(diskRepositiry.save(any())).then(addNewDisk);
        diskService.addDisk(diskDto);


        Product product = new Product();
        product.setFromDto(productDto);

        Disk disk = new Disk();
        disk.setSize(1.0);
        disk.setProduct(product);

        when(diskRepositiry.findById(1L)).thenReturn(Optional.of(disk));

        DiskDto result1 = diskService.getDisk(1L);

        assertEquals(result1.getProductDto().getCountOnStore(), 3L);
        assertEquals(result1.getProductDto().getManufacturer(), "Apple");
        assertEquals(result1.getProductDto().getNumber(), 12322L);
        assertEquals(result1.getProductDto().getPrice(), 999.99);
        assertEquals(result1.getSize(), 1.0);

        List<Disk> list = new ArrayList<>();
        list.add(disk);

        List<DiskDto> listDto = new ArrayList<>();
        listDto.add(diskDto);

        when(diskRepositiry.findAll()).thenReturn(list);

        assertEquals(diskService.getAll(), listDto);

        diskDto.setId(1L);
        diskService.updateDisk(diskDto);


        diskService.deleteDisk(1L);//TODO проверка точно ли удаляет.
    }
}
