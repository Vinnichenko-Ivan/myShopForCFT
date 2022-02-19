package com.shop.myshopforcft.repository;

import com.shop.myshopforcft.entityanddto.Notebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ivan Vinnichenko
 */
@Repository
public interface NotebookRepository extends JpaRepository<Notebook, Long> {
}
