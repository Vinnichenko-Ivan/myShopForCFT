package com.shop.myshopforcft.repository;

import com.shop.myshopforcft.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ivan Vinnichenko
 */
@Repository
public interface ProductReposintory extends JpaRepository<Product, Long> {

}
