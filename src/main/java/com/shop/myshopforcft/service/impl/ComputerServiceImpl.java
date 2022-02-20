package com.shop.myshopforcft.service.impl;

import com.shop.myshopforcft.dto.ComputerDto;
import com.shop.myshopforcft.entity.Computer;
import com.shop.myshopforcft.entity.Product;
import com.shop.myshopforcft.exception.ProductNotFoundException;
import com.shop.myshopforcft.repository.ComputerRepository;
import com.shop.myshopforcft.repository.ProductReposintory;
import com.shop.myshopforcft.service.ComputerService;
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
public class ComputerServiceImpl implements ComputerService {

    private final ProductReposintory productReposintory;

    private final ComputerRepository computerRepository;

    @Transactional
    @Override
    public void addComputer(ComputerDto computerDto) {
        Product product = new Product();

        product.setFromDto(computerDto.getProductDto());

        productReposintory.save(product);

        Computer computer = new Computer();

        computer.setFormFactor(computerDto.getFormFactor());
        computer.setProduct(product);

        computerRepository.save(computer);
    }

    @Transactional
    @Override
    public List<ComputerDto> getAll(){
        return computerRepository.findAll().stream().map(computer -> {
            ComputerDto computerDto = new ComputerDto();
            computerDto.setProductDto(computer.getProduct().getToDto());
            computerDto.setId(computer.getId());
            computerDto.setFormFactor(computer.getFormFactor());
            return computerDto;
        }).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public ComputerDto getComputer(Long id){
        Computer computer = computerRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        ComputerDto computerDto = new ComputerDto();
        computerDto.setId(computer.getId());
        computerDto.setFormFactor(computer.getFormFactor());
        computerDto.setProductDto(computer.getProduct().getToDto());
        return computerDto;
    }

    @Transactional
    @Override
    public void updateComputer(ComputerDto computerDto) {
        Computer computer = computerRepository.findById(computerDto.getId()).orElseThrow(ProductNotFoundException::new);
        Product product = computer.getProduct();

        product.setFromDto(computerDto.getProductDto());

        productReposintory.save(product);

        computer.setFormFactor(computerDto.getFormFactor());
        computer.setProduct(product);

        computerRepository.save(computer);
    }

    @Transactional
    @Override
    public void deleteComputer(Long id){
        Computer computer = computerRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        productReposintory.delete(computer.getProduct());
        computerRepository.delete(computer);
    }


}
