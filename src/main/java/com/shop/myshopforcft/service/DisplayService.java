package com.shop.myshopforcft.service;

import com.shop.myshopforcft.dto.DisplayDto;

import java.util.List;

/**
 * @author Ivan Vinnichenko
 */

public interface DisplayService {
    /**
     * Метод добавления нового монитора.
     * @param displayDto Монитор который нужно сохранить. Id будет изменено.
     */
    void addDisplay(DisplayDto displayDto);

    /**
     * Метод получения всех мониторов.
     */
    List<DisplayDto> getAll();

    /**
     * Метод получения монитора по id
     * @param id ид монитора
     */
    DisplayDto getDisplay(Long id);

    /**
     * Метод редактирования монитора.
     * @param displayDto Монитор который нужно изменить. id берется из dto.
     */
    void updateDisplay(DisplayDto displayDto);

    /**
     * Удаление монитора.
     * @param id ид удаляемого монитора.
     */
    void deleteDisplay(Long id);
}
