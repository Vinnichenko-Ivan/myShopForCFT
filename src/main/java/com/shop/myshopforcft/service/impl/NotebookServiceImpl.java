package com.shop.myshopforcft.service.impl;

import com.shop.myshopforcft.dto.NotebookDto;
import com.shop.myshopforcft.entityanddto.Notebook;
import com.shop.myshopforcft.entityanddto.Product;
import com.shop.myshopforcft.exception.ProductNotFoundException;
import com.shop.myshopforcft.repository.NotebookRepository;
import com.shop.myshopforcft.repository.ProductReposintory;
import com.shop.myshopforcft.service.NotebookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Ivan Vinnichenko
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class NotebookServiceImpl implements NotebookService {

    private final ProductReposintory productReposintory;

    private final NotebookRepository notebookRepository;

    @Transactional
    @Override
    public void addNotebook(NotebookDto notebookDto){
        Product product = new Product();

        product.setFromDto(notebookDto.getProductDto());

        productReposintory.save(product);

        Notebook notebook = new Notebook();

        notebook.setSize(notebookDto.getSize());
        notebook.setProduct(product);

        notebookRepository.save(notebook);
    }

    @Transactional
    @Override
    public List<NotebookDto> getAll(){
        return notebookRepository.findAll().stream().map(display -> {
            NotebookDto notebookDto = new NotebookDto();
            notebookDto.setProductDto(display.getProduct().getToDto());
            notebookDto.setId(display.getId());
            notebookDto.setSize(display.getSize());
            return notebookDto;
        }).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public NotebookDto getNotebook(Long id){
        Notebook notebook = notebookRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        NotebookDto notebookDto = new NotebookDto();
        notebookDto.setId(notebook.getId());
        notebookDto.setSize(notebook.getSize());
        notebookDto.setProductDto(notebook.getProduct().getToDto());
        return notebookDto;
    }

    @Transactional
    @Override
    public void updateNotebook(NotebookDto notebookDto){
        Notebook notebook = notebookRepository.findById(notebookDto.getId()).orElseThrow(ProductNotFoundException::new);
        Product product = notebook.getProduct();

        product.setFromDto(notebookDto.getProductDto());

        productReposintory.save(product);

        notebook.setSize(notebookDto.getSize());
        notebook.setProduct(product);

        notebookRepository.save(notebook);
    }

    @Transactional
    @Override
    public void deleteNotebook(Long id){
        Notebook notebook = notebookRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        notebookRepository.delete(notebook);
    }
}
