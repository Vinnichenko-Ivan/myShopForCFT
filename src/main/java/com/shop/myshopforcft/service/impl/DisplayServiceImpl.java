package com.shop.myshopforcft.service.impl;

import com.shop.myshopforcft.dto.DisplayDto;
import com.shop.myshopforcft.entity.Display;
import com.shop.myshopforcft.entity.Product;
import com.shop.myshopforcft.exception.ProductNotFoundException;
import com.shop.myshopforcft.repository.DisplayRepository;
import com.shop.myshopforcft.repository.ProductReposintory;
import com.shop.myshopforcft.service.DisplayService;
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
public class DisplayServiceImpl implements DisplayService {

    private final ProductReposintory productReposintory;

    private final DisplayRepository displayRepository;

    @Transactional
    @Override
    public void addDisplay(DisplayDto displayDto){
        Product product = new Product();

        product.setFromDto(displayDto.getProductDto());

        productReposintory.save(product);

        Display display = new Display();

        display.setDiagonal(displayDto.getDiagonal());
        display.setProduct(product);

        displayRepository.save(display);
    }

    @Transactional
    @Override
    public List<DisplayDto> getAll(){
        return displayRepository.findAll().stream().map(display -> {
            DisplayDto displayDto = new DisplayDto();
            displayDto.setProductDto(display.getProduct().getToDto());
            displayDto.setId(display.getId());
            displayDto.setDiagonal(display.getDiagonal());
            return displayDto;
        }).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public DisplayDto getDisplay(Long id){
        Display display = displayRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        DisplayDto displayDto = new DisplayDto();
        displayDto.setId(display.getId());
        displayDto.setDiagonal(display.getDiagonal());
        displayDto.setProductDto(display.getProduct().getToDto());
        return displayDto;
    }

    @Transactional
    @Override
    public void updateDisplay(DisplayDto displayDto){
        Display display = displayRepository.findById(displayDto.getId()).orElseThrow(ProductNotFoundException::new);
        Product product = display.getProduct();

        product.setFromDto(displayDto.getProductDto());

        productReposintory.save(product);

        display.setDiagonal(displayDto.getDiagonal());
        display.setProduct(product);

        displayRepository.save(display);
    }

    @Transactional
    @Override
    public void deleteDisplay(Long id){
        Display display = displayRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        productReposintory.delete(display.getProduct());
        displayRepository.delete(display);
    }
}
