package com.shop.myshopforcft.service;

import com.shop.myshopforcft.dto.ComputerDto;
import com.shop.myshopforcft.dto.ProductDto;
import com.shop.myshopforcft.entity.Computer;
import com.shop.myshopforcft.entity.Product;
import com.shop.myshopforcft.entity.enums.ComputerFormFactor;
import com.shop.myshopforcft.repository.ComputerRepository;
import com.shop.myshopforcft.repository.ProductReposintory;
import com.shop.myshopforcft.service.impl.ComputerServiceImpl;
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

public class ComputerServiceTest {

    private ComputerService computerService;

    private ComputerRepository computerRepositiry;
    
    private ProductReposintory productReposintory;

    @BeforeEach
    public void init(){
        computerRepositiry = mock(ComputerRepository.class);

        productReposintory = mock(ProductReposintory.class);

        computerService = new ComputerServiceImpl(productReposintory, computerRepositiry);
    }


    private Answer<Double> addNewProduct = new Answer<Double>() {
        @Override
        public Double answer(InvocationOnMock invocation) throws Throwable
        {
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
        }
    };

    private Answer<Double> deleteComputer = new Answer<Double>() {
        @Override
        public Double answer(InvocationOnMock invocation) throws Throwable
        {

            return null;
        }
    };

    private Answer<Double> addNewComputer = new Answer<Double>() {
        @Override
        public Double answer(InvocationOnMock invocation) throws Throwable
        {
            Computer computer = (Computer) invocation.getArguments()[0];

            assertEquals(computer.getProduct().getCountOnStore(), 3L);
            assertEquals(computer.getProduct().getManufacturer(), "Apple");
            assertEquals(computer.getProduct().getNumber(), 12322L);
            assertEquals(computer.getProduct().getPrice(), 999.99);
            assertEquals(computer.getProduct().getToDto().getCountOnStore(), 3L);
            assertEquals(computer.getProduct().getToDto().getManufacturer(), "Apple");
            assertEquals(computer.getProduct().getToDto().getNumber(), 12322L);
            assertEquals(computer.getProduct().getToDto().getPrice(), 999.99);
            assertEquals(computer.getFormFactor(), ComputerFormFactor.DESKTOP);

            return null;
        }
    };

    @Test
    public void test(){
        ProductDto productDto = new ProductDto();

        ComputerDto computerDto = new ComputerDto();

        productDto.setManufacturer("Apple");
        productDto.setPrice(999.99);
        productDto.setNumber(12322L);
        productDto.setCountOnStore(3L);

        computerDto.setProductDto(productDto);
        computerDto.setFormFactor(ComputerFormFactor.DESKTOP);
        when(productReposintory.save(any())).then(addNewProduct);
        when(computerRepositiry.save(any())).then(addNewComputer);
        computerService.addComputer(computerDto);


        Product product = new Product();
        product.setFromDto(productDto);

        Computer computer = new Computer();
        computer.setFormFactor(ComputerFormFactor.DESKTOP);
        computer.setProduct(product);

        when(computerRepositiry.findById(1L)).thenReturn(Optional.of(computer));

        ComputerDto result1 = computerService.getComputer(1L);

        assertEquals(result1.getProductDto().getCountOnStore(), 3L);
        assertEquals(result1.getProductDto().getManufacturer(), "Apple");
        assertEquals(result1.getProductDto().getNumber(), 12322L);
        assertEquals(result1.getProductDto().getPrice(), 999.99);
        assertEquals(result1.getFormFactor(), ComputerFormFactor.DESKTOP);

        List<Computer> list = new ArrayList<>();
        list.add(computer);

        List<ComputerDto> listDto = new ArrayList<>();
        listDto.add(computerDto);

        when(computerRepositiry.findAll()).thenReturn(list);

        assertEquals(computerService.getAll(), listDto);

        computerDto.setId(1L);
        computerService.updateComputer(computerDto);


        computerService.deleteComputer(1L);//TODO проверка точно ли удаляет.

    }
}
