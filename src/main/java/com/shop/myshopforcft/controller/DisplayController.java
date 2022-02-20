package com.shop.myshopforcft.controller;

import com.shop.myshopforcft.dto.DisplayDto;
import com.shop.myshopforcft.service.DisplayService;
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
@RequestMapping("/product/display")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class DisplayController {

    private final DisplayService displayService;

    @ApiOperation("Добавление нового дисплея.")
    @PostMapping("/addNewDisplay")
    public void addNewDisk(DisplayDto displayDto) {
        displayService.addDisplay(displayDto);
    }

    @ApiOperation("Просмотр всех дисплеев.")
    @GetMapping("/get/all")
    public List<DisplayDto> getAll() {
        return displayService.getAll();
    }

    @ApiOperation("Получение дисплея по id.")
    @GetMapping("/get/{id}")
    public DisplayDto getComputer(
            @ApiParam("id дисплея.")
            @PathVariable
                    Long id
    ) {
        return displayService.getDisplay(id);
    }

    @ApiOperation("Редактирование дисплея по id.")
    @PutMapping("/update/{id}")
    public void updateComputer(DisplayDto displayDto) {
        displayService.updateDisplay(displayDto);
    }

    @ApiOperation("Удаление дисплея по id.")
    @DeleteMapping("/delete/{id}")
    public void deleteComputer(
            @ApiParam("id дисплея.")
            @PathVariable
                    Long id
    ) {
        displayService.deleteDisplay(id);
    }
}
