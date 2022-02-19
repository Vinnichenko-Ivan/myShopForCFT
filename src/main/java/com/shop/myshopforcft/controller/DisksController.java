package com.shop.myshopforcft.controller;

import com.shop.myshopforcft.dto.DiskDto;
import com.shop.myshopforcft.service.DiskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ivan Vinnichenko
 */
@Api
@RestController
@RequestMapping("/product/disk")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class DisksController {

    private final DiskService diskService;

    @ApiOperation("Добавление нового диска.")
    @PostMapping("/addNewDisk")
    public void addNewDisk(DiskDto diskDto) {
        diskService.addDisk(diskDto);
    }

    @ApiOperation("Просмотр всех дисков.")
    @GetMapping("/get/all")
    public List<DiskDto> getAll() {
        return diskService.getAll();
    }

    @ApiOperation("Получение диска по id.")
    @GetMapping("/get/{id}")
    public DiskDto getComputer(
            @ApiParam("id диска.")
            @PathVariable
                    Long id
    ) {
        return diskService.getDisk(id);
    }

    @ApiOperation("Редактирование диска по id.")
    @PutMapping("/update/{id}")
    public void updateComputer(DiskDto diskDto) {
        diskService.updateDisk(diskDto);
    }

    @ApiOperation("Удаление диска по id.")
    @DeleteMapping("/delete/{id}")
    public void deleteComputer(
            @ApiParam("id диска.")
            @PathVariable
                    Long id
    ) {
        diskService.deleteDisk(id);
    }
}
