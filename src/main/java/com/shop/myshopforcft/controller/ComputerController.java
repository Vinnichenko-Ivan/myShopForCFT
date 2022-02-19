package com.shop.myshopforcft.controller;

import com.shop.myshopforcft.dto.ComputerDto;
import com.shop.myshopforcft.service.ComputerService;
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
@RequestMapping("/product/computer")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ComputerController {

    private final ComputerService computerService;

    @ApiOperation("Добавление нового компьютера.")
    @PostMapping("/addNewComputer")
    public void addNewComputer(ComputerDto computerDto) {
        computerService.addComputer(computerDto);
    }

    @ApiOperation("Просмотр всех компьютеров.")
    @GetMapping("/get/all")
    public List<ComputerDto> getAll() {
        return computerService.getAll();
    }

    @ApiOperation("Получение компьютера по id.")
    @GetMapping("/get/{id}")
    public ComputerDto getComputer(
            @ApiParam("id компьютера.")
            @PathVariable
                    Long id
    ) {
        return computerService.getComputer(id);
    }

    @ApiOperation("Редактирование компьютера по id.")
    @PutMapping("/update/{id}")
    public void updateComputer(ComputerDto computerDto) {
        computerService.updateComputer(computerDto);
    }

    @ApiOperation("Удаление компьютера по id.")
    @DeleteMapping("/delete/{id}")
    public void deleteComputer(
            @ApiParam("id компьютера.")
            @PathVariable
                    Long id
    ) {
        computerService.deleteComputer(id);
    }
}
