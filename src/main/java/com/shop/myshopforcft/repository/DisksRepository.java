package com.shop.myshopforcft.repository;

import com.shop.myshopforcft.entity.Disk;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Ivan Vinnichenko
 */

public interface DisksRepository extends JpaRepository<Disk, Long> {
}
