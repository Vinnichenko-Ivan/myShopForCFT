package com.shop.myshopforcft.controller;

import com.shop.myshopforcft.dto.NotebookDto;
import com.shop.myshopforcft.service.NotebookService;
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
@RequestMapping("/product/notebook")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class NotebookController {

    private final NotebookService notebookService;

    @ApiOperation("Добавление нового ноутбука.")
    @PostMapping("/addNewNotebook")
    public void addNewDisk(NotebookDto notebookDto) {
        notebookService.addNotebook(notebookDto);
    }

    @ApiOperation("Просмотр всех ноутбуков.")
    @GetMapping("/get/all")
    public List<NotebookDto> getAll() {
        return notebookService.getAll();
    }

    @ApiOperation("Получение ноутбука по id.")
    @GetMapping("/get/{id}")
    public NotebookDto getNotebook(
            @ApiParam("id ноутбука.")
            @PathVariable
                    Long id
    ) {
        return notebookService.getNotebook(id);
    }

    @ApiOperation("Редактирование ноутбука по id.")
    @PutMapping("/update/{id}")
    public void updateNotebook(NotebookDto notebookDto) {
        notebookService.updateNotebook(notebookDto);
    }

    @ApiOperation("Удаление ноутбука по id.")
    @DeleteMapping("/delete/{id}")
    public void deleteNotebook(
            @ApiParam("id ноутбука.")
            @PathVariable
                    Long id
    ) {
        notebookService.deleteNotebook(id);
    }
}
