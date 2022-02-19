package com.shop.myshopforcft.service;

import com.shop.myshopforcft.dto.DisplayDto;
import com.shop.myshopforcft.dto.NotebookDto;

import java.util.List;

/**
 * @author Ivan Vinnichenko
 */

public interface NotebookService {
    /**
     * Метод добавления нового ноутбука.
     * @param notebookDto Ноутбук который нужно сохранить. Id будет изменено.
     */
    void addNotebook(NotebookDto notebookDto);

    /**
     * Метод получения всех ноутбуков.
     */
    List<NotebookDto> getAll();

    /**
     * Метод получения ноутбука по id.
     * @param id ид ноутбука.
     */
    NotebookDto getNotebook(Long id);

    /**
     * Метод редактирования ноутбука.
     * @param notebookDto Ноутбук который нужно изменить. id берется из dto.
     */
    void updateNotebook(NotebookDto notebookDto);

    /**
     * Удаление ноутбука.
     * @param id ид удаляемого ноутбука.
     */
    void deleteNotebook(Long id);
}
