package com.shop.myshopforcft.entity;

import com.shop.myshopforcft.dto.NotebookDto;
import com.shop.myshopforcft.dto.ProductDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author Ivan Vinnichenko
 */
public class NotebookTest {
    @Test
    public void testNotebook(){
        Notebook notebook = new Notebook();
        Product product = new Product();

        product.setManufacturer("Apple");
        product.setPrice(999.99);
        product.setNumber(12322L);
        product.setCountOnStore(3L);

        notebook.setProduct(product);
        notebook.setSize(1024.0);

        assertEquals(notebook.getProduct().getCountOnStore(), 3L);
        assertEquals(notebook.getProduct().getManufacturer(), "Apple");
        assertEquals(notebook.getProduct().getNumber(), 12322L);
        assertEquals(notebook.getProduct().getPrice(), 999.99);
        assertEquals(notebook.getSize(), 1024.0);

        assertNull(notebook.getId());
    }

    @Test
    public void testNotebookDto(){
        NotebookDto notebookDto = new NotebookDto();
        ProductDto productDto = new ProductDto();

        productDto.setManufacturer("Apple");
        productDto.setPrice(999.99);
        productDto.setNumber(12322L);
        productDto.setCountOnStore(3L);

        notebookDto.setProductDto(productDto);
        notebookDto.setSize(123.0);

        assertEquals(notebookDto.getProductDto().getCountOnStore(), 3L);
        assertEquals(notebookDto.getProductDto().getManufacturer(), "Apple");
        assertEquals(notebookDto.getProductDto().getNumber(), 12322L);
        assertEquals(notebookDto.getProductDto().getPrice(), 999.99);
        assertEquals(notebookDto.getSize(), 123.0);

        notebookDto.setId(1L);
        assertEquals(notebookDto.getId(), 1L);
    }

}
