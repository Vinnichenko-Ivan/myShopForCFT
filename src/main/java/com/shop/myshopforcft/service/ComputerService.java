package com.shop.myshopforcft.service;

import com.shop.myshopforcft.dto.ComputerDto;

import java.util.List;

/**
 * @author Ivan Vinnichenko
 */

public interface ComputerService {

    /**
     * Метод добавления нового компьютера.
     * @param computerDto Компьютер который нужно сохранить. Id будет изменено.
     */
    void addComputer(ComputerDto computerDto);

    /**
     * Метод получения всех компьютеров.
     */
    List<ComputerDto> getAll();

    /**
     * Метод получения компьютера по id
     * @param id ид компьютера
     */
    ComputerDto getComputer(Long id);

    /**
     * Метод редактирования компьютера.
     * @param computerDto Компьютер который нужно изменить. id берется из dto.
     */
    void updateComputer(ComputerDto computerDto);

    /**
     * Удаление компьютера
     * @param id ид удаляемого
    */
    void deleteComputer(Long id);
}
