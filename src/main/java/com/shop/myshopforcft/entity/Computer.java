package com.shop.myshopforcft.entity;

import com.shop.myshopforcft.entity.enums.ComputerFormFactor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

/**
 * @author Ivan Vinnichenko
 */
@Entity
@Table(name = "computers")
public class Computer{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Getter
    private Long id;

    @Getter
    @Setter
    @Column(name = "form_factor")
    private ComputerFormFactor formFactor;

    @Getter
    @Setter
    @OneToOne()
    private Product product;
}
