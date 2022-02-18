package com.shop.myshopforcft.repository;

import com.shop.myshopforcft.entity.Notebook;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Ivan Vinnichenko
 */

public interface NotebookRepository extends JpaRepository<Notebook, Long> {
}
