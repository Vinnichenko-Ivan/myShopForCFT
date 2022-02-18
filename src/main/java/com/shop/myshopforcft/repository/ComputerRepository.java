package com.shop.myshopforcft.repository;

import com.shop.myshopforcft.entity.Computer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Ivan Vinnichenko
 */

public interface ComputerRepository extends JpaRepository<Computer, Long> {
}
