package com.shop.myshopforcft.repository;

import com.shop.myshopforcft.entityanddto.Display;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ivan Vinnichenko
 */
@Repository
public interface DisplayRepository  extends JpaRepository<Display, Long> {
}
