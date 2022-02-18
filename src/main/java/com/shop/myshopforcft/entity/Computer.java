package com.shop.myshopforcft.entity;

import com.shop.myshopforcft.entity.enums.ComputerFormFactor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Ivan Vinnichenko
 */
@Entity
@Table(name = "notebooks")
public class Computer extends Product{

    @Getter
    @Setter
    @Column(name = "form_factor")
    private ComputerFormFactor formFactor;

    @Getter
    @Setter
    @Column(name = "size")
    private Double size;

    @Getter
    @Setter
    @OneToOne()
    private Product product;
}
