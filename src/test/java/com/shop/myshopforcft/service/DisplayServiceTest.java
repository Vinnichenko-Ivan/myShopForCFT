package com.shop.myshopforcft.service;

import com.shop.myshopforcft.dto.DisplayDto;
import com.shop.myshopforcft.dto.ProductDto;
import com.shop.myshopforcft.entity.Display;
import com.shop.myshopforcft.entity.Product;
import com.shop.myshopforcft.repository.DisplayRepository;
import com.shop.myshopforcft.repository.ProductReposintory;
import com.shop.myshopforcft.service.impl.DisplayServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Ivan Vinnichenko
 */

public class DisplayServiceTest {
    private DisplayService displayService;

    private DisplayRepository displayRepositiry;

    private ProductReposintory productReposintory;

    @BeforeEach
    public void init(){
        displayRepositiry = mock(DisplayRepository.class);

        productReposintory = mock(ProductReposintory.class);

        displayService = new DisplayServiceImpl(productReposintory, displayRepositiry);
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

    private Answer<Double> deleteDisplay = new Answer<Double>() {
        @Override
        public Double answer(InvocationOnMock invocation) throws Throwable
        {

            return null;
        }
    };

    private Answer<Double> addNewDisplay = new Answer<Double>() {
        @Override
        public Double answer(InvocationOnMock invocation) throws Throwable
        {
            Display display = (Display) invocation.getArguments()[0];

            assertEquals(display.getProduct().getCountOnStore(), 3L);
            assertEquals(display.getProduct().getManufacturer(), "Apple");
            assertEquals(display.getProduct().getNumber(), 12322L);
            assertEquals(display.getProduct().getPrice(), 999.99);
            assertEquals(display.getProduct().getToDto().getCountOnStore(), 3L);
            assertEquals(display.getProduct().getToDto().getManufacturer(), "Apple");
            assertEquals(display.getProduct().getToDto().getNumber(), 12322L);
            assertEquals(display.getProduct().getToDto().getPrice(), 999.99);
            assertEquals(display.getDiagonal(), 1.0);

            return null;
        }
    };

    @Test
    public void test(){
        ProductDto productDto = new ProductDto();

        DisplayDto displayDto = new DisplayDto();

        productDto.setManufacturer("Apple");
        productDto.setPrice(999.99);
        productDto.setNumber(12322L);
        productDto.setCountOnStore(3L);

        displayDto.setProductDto(productDto);
        displayDto.setDiagonal(1.0);
        when(productReposintory.save(any())).then(addNewProduct);
        when(displayRepositiry.save(any())).then(addNewDisplay);
        displayService.addDisplay(displayDto);


        Product product = new Product();
        product.setFromDto(productDto);

        Display display = new Display();
        display.setDiagonal(1.0);
        display.setProduct(product);

        when(displayRepositiry.findById(1L)).thenReturn(Optional.of(display));

        DisplayDto result1 = displayService.getDisplay(1L);

        assertEquals(result1.getProductDto().getCountOnStore(), 3L);
        assertEquals(result1.getProductDto().getManufacturer(), "Apple");
        assertEquals(result1.getProductDto().getNumber(), 12322L);
        assertEquals(result1.getProductDto().getPrice(), 999.99);
        assertEquals(result1.getDiagonal(), 1.0);

        List<Display> list = new ArrayList<>();
        list.add(display);

        List<DisplayDto> listDto = new ArrayList<>();
        listDto.add(displayDto);

        when(displayRepositiry.findAll()).thenReturn(list);

        assertEquals(displayService.getAll(), listDto);

        displayDto.setId(1L);
        displayService.updateDisplay(displayDto);


        displayService.deleteDisplay(1L);//TODO проверка точно ли удаляет.
    }
}
