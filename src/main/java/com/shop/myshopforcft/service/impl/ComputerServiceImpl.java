package com.shop.myshopforcft.service.impl;

import com.shop.myshopforcft.entity.Computer;
import com.shop.myshopforcft.entity.Product;
import com.shop.myshopforcft.entity.enums.ComputerFormFactor;
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
    public void addComputer(ComputerFormFactor formFactor, Long number, String manufacturer, Double price, Long countOnStore) {
        Product product = new Product();

        product.setCountOnStore(countOnStore);
        product.setPrice(price);
        product.setNumber(number);
        product.setManufacturer(manufacturer);

        productReposintory.save(product);

        Computer computer = new Computer();

        computer.setFormFactor(formFactor);
        computer.setProduct(product);

        computerRepository.save(computer);
    }

    @Transactional
    @Override
    public List<Computer> getAll(){
        return computerRepository.findAll();
    }

    @Transactional
    @Override
    public Computer getComputer(Long id){
        return computerRepository.findById(id).orElseThrow(ProductNotFoundException::new);
    }

    @Transactional
    @Override
    public void updateComputer(Long id, ComputerFormFactor formFactor, Long number, String manufacturer, Double price, Long countOnStore) {
        Computer computer = computerRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        Product product = computer.getProduct();

        product.setCountOnStore(countOnStore);
        product.setPrice(price);
        product.setNumber(number);
        product.setManufacturer(manufacturer);

        productReposintory.save(product);

        computer.setFormFactor(formFactor);
        computer.setProduct(product);

        computerRepository.save(computer);
    }

    @Transactional
    @Override
    public void deleteComputer(Long id){
        Computer computer = computerRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        computerRepository.delete(computer);
    }


}
