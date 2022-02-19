package com.shop.myshopforcft.service;

import com.shop.myshopforcft.entity.Computer;
import com.shop.myshopforcft.entity.enums.ComputerFormFactor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Ivan Vinnichenko
 */

public interface ComputerService {

    /**
     * Метод добавления нового компьютера.
     * @param formFactor форм-фактор
     * @param number серия
     * @param manufacturer производитель
     * @param price цена
     * @param countOnStore количество товара в магазине
     */
    void addComputer(
            ComputerFormFactor formFactor,
            Long number,
            String manufacturer,
            Double price,
            Long countOnStore
    );

    /**
     * Метод получения всех компьютеров.
     */
    List<Computer> getAll();

    /**
     * Метод получения компьютера по id
     * @param id ид компьютера
     */
    Computer getComputer(Long id);

    /**
     * Метод добавления нового компьютера.
     * @param id ид редактируемого компьютера
     * @param formFactor форм-фактор
     * @param number серия
     * @param manufacturer производитель
     * @param price цена
     * @param countOnStore количество товара в магазине
     */
    void updateComputer(
            Long id,
            ComputerFormFactor formFactor,
            Long number,
            String manufacturer,
            Double price,
            Long countOnStore
    );

    /**
     * Удаление компьютера
     * @param id ид удаляемого
    */
    void deleteComputer(Long id);
}
