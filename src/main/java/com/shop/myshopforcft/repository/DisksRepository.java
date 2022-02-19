package com.shop.myshopforcft.repository;

import com.shop.myshopforcft.entity.Disk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ivan Vinnichenko
 */
@Repository
public interface DisksRepository extends JpaRepository<Disk, Long> {
}
