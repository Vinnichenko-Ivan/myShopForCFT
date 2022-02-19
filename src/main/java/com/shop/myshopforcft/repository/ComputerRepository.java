package com.shop.myshopforcft.repository;

import com.shop.myshopforcft.entity.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ivan Vinnichenko
 */
@Repository
public interface ComputerRepository extends JpaRepository<Computer, Long> {

}
