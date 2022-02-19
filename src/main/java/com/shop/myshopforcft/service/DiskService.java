package com.shop.myshopforcft.service;

import com.shop.myshopforcft.dto.DiskDto;

import java.util.List;

/**
 * @author Ivan Vinnichenko
 */

public interface DiskService {
    /**
     * Метод добавления нового диска.
     * @param diskDto Диск который нужно сохранить. Id будет изменено.
     */
    void addDisk(DiskDto diskDto);

    /**
     * Метод получения всех дисков.
     */
    List<DiskDto> getAll();

    /**
     * Метод получения диска по id
     * @param id ид диска
     */
    DiskDto getDisk(Long id);

    /**
     * Метод редактирования диска.
     * @param diskDto Диска который нужно изменить. id берется из dto.
     */
    void updateDisk(DiskDto diskDto);

    /**
     * Удаление диска.
     * @param id ид удаляемого диска.
     */
    void deleteDisk(Long id);
}
