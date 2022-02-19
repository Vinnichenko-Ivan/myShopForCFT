package com.shop.myshopforcft.controller;

import com.shop.myshopforcft.entity.Computer;
import com.shop.myshopforcft.entity.enums.ComputerFormFactor;
import com.shop.myshopforcft.service.ComputerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.tags.Tag;
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
    public void addNewComputer(
                ComputerFormFactor formFactor,
                Long number,
                String manufacturer,
                Double price,
                Long countOnStore
    ) {
        computerService.addComputer(formFactor, number, manufacturer, price, countOnStore);
    }

    @ApiOperation("Просмотр всех компьютеров.")
    @GetMapping("/get/all")
    public List<Computer> getAll() {
        return computerService.getAll();
    }

    @ApiOperation("Получение компьютера по id.")
    @GetMapping("/get/{id}")
    public Computer getComputer(
            @ApiParam("id компьютера")
            @PathVariable
                    Long id
    ) {
        return computerService.getComputer(id);
    }

    @ApiOperation("Редактирование компьютера по id.")
    @PutMapping("/update/{id}")
    public void updateComputer(
            @ApiParam("id компьютера")
            @PathVariable
                    Long id,
                    ComputerFormFactor formFactor,
                    Long number,
                    String manufacturer,
                    Double price,
                    Long countOnStore
    ) {
        computerService.updateComputer(id, formFactor, number, manufacturer, price, countOnStore);
    }

    @ApiOperation("Удаление компьютера по id.")
    @DeleteMapping("/delete/{id}")
    public void deleteComputer(
            @ApiParam("id компьютера")
            @PathVariable
                    Long id
    ) {
        computerService.deleteComputer(id);
    }
}
