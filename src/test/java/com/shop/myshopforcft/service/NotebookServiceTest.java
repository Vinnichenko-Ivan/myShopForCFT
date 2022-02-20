package com.shop.myshopforcft.service;

import com.shop.myshopforcft.dto.NotebookDto;
import com.shop.myshopforcft.dto.ProductDto;
import com.shop.myshopforcft.entity.Notebook;
import com.shop.myshopforcft.entity.Product;
import com.shop.myshopforcft.repository.NotebookRepository;
import com.shop.myshopforcft.repository.ProductReposintory;
import com.shop.myshopforcft.service.impl.NotebookServiceImpl;
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

public class NotebookServiceTest {
    private NotebookService notebookService;

    private NotebookRepository notebookRepositiry;

    private ProductReposintory productReposintory;

    @BeforeEach
    public void init(){
        notebookRepositiry = mock(NotebookRepository.class);

        productReposintory = mock(ProductReposintory.class);

        notebookService = new NotebookServiceImpl(productReposintory, notebookRepositiry);
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

    private Answer<Double> deleteNotebook = new Answer<Double>() {
        @Override
        public Double answer(InvocationOnMock invocation) throws Throwable
        {

            return null;
        }
    };

    private Answer<Double> addNewNotebook = new Answer<Double>() {
        @Override
        public Double answer(InvocationOnMock invocation) throws Throwable
        {
            Notebook notebook = (Notebook) invocation.getArguments()[0];

            assertEquals(notebook.getProduct().getCountOnStore(), 3L);
            assertEquals(notebook.getProduct().getManufacturer(), "Apple");
            assertEquals(notebook.getProduct().getNumber(), 12322L);
            assertEquals(notebook.getProduct().getPrice(), 999.99);
            assertEquals(notebook.getProduct().getToDto().getCountOnStore(), 3L);
            assertEquals(notebook.getProduct().getToDto().getManufacturer(), "Apple");
            assertEquals(notebook.getProduct().getToDto().getNumber(), 12322L);
            assertEquals(notebook.getProduct().getToDto().getPrice(), 999.99);
            assertEquals(notebook.getSize(), 1.0);

            return null;
        }
    };

    @Test
    public void test(){
        ProductDto productDto = new ProductDto();

        NotebookDto notebookDto = new NotebookDto();

        productDto.setManufacturer("Apple");
        productDto.setPrice(999.99);
        productDto.setNumber(12322L);
        productDto.setCountOnStore(3L);

        notebookDto.setProductDto(productDto);
        notebookDto.setSize(1.0);
        when(productReposintory.save(any())).then(addNewProduct);
        when(notebookRepositiry.save(any())).then(addNewNotebook);
        notebookService.addNotebook(notebookDto);


        Product product = new Product();
        product.setFromDto(productDto);

        Notebook notebook = new Notebook();
        notebook.setSize(1.0);
        notebook.setProduct(product);

        when(notebookRepositiry.findById(1L)).thenReturn(Optional.of(notebook));

        NotebookDto result1 = notebookService.getNotebook(1L);

        assertEquals(result1.getProductDto().getCountOnStore(), 3L);
        assertEquals(result1.getProductDto().getManufacturer(), "Apple");
        assertEquals(result1.getProductDto().getNumber(), 12322L);
        assertEquals(result1.getProductDto().getPrice(), 999.99);
        assertEquals(result1.getSize(), 1.0);

        List<Notebook> list = new ArrayList<>();
        list.add(notebook);

        List<NotebookDto> listDto = new ArrayList<>();
        listDto.add(notebookDto);

        when(notebookRepositiry.findAll()).thenReturn(list);

        assertEquals(notebookService.getAll(), listDto);

        notebookDto.setId(1L);
        notebookService.updateNotebook(notebookDto);

        notebookService.deleteNotebook(1L);//TODO проверка точно ли удаляет.
    }
}
