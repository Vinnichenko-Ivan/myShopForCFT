package com.shop.myshopforcft.service.impl;

import com.shop.myshopforcft.dto.DiskDto;
import com.shop.myshopforcft.entity.Disk;
import com.shop.myshopforcft.entity.Product;
import com.shop.myshopforcft.exception.ProductNotFoundException;
import com.shop.myshopforcft.repository.DisksRepository;
import com.shop.myshopforcft.repository.ProductReposintory;
import com.shop.myshopforcft.service.DiskService;
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
public class DiskServiceImpl implements DiskService {

    private final ProductReposintory productReposintory;

    private final DisksRepository disksRepository;

    @Transactional
    @Override
    public void addDisk(DiskDto diskDto){
        Product product = new Product();

        product.setFromDto(diskDto.getProductDto());

        productReposintory.save(product);

        Disk disk = new Disk();

        disk.setSize(diskDto.getSize());
        disk.setProduct(product);

        disksRepository.save(disk);
    }

    @Transactional
    @Override
    public List<DiskDto> getAll(){
        return disksRepository.findAll().stream().map(disk -> {
            DiskDto diskDto = new DiskDto();
            diskDto.setProductDto(disk.getProduct().getToDto());
            diskDto.setId(disk.getId());
            diskDto.setSize(disk.getSize());
            return diskDto;
        }).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public DiskDto getDisk(Long id){
        Disk disk = disksRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        DiskDto diskDto = new DiskDto();
        diskDto.setId(disk.getId());
        diskDto.setSize(disk.getSize());
        diskDto.setProductDto(disk.getProduct().getToDto());
        return diskDto;
    }

    @Transactional
    @Override
    public void updateDisk(DiskDto diskDto){
        Disk disk = disksRepository.findById(diskDto.getId()).orElseThrow(ProductNotFoundException::new);
        Product product = disk.getProduct();

        product.setFromDto(diskDto.getProductDto());

        productReposintory.save(product);

        disk.setSize(diskDto.getSize());
        disk.setProduct(product);

        disksRepository.save(disk);
    }

    @Transactional
    @Override
    public void deleteDisk(Long id){
        Disk disk = disksRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        productReposintory.delete(disk.getProduct());
        disksRepository.delete(disk);
    }
}
