package com.shop.myshopforcft.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

/**
 * @author Ivan Vinnichenko
 */
@Entity
@Table(name = "displays")
public class Display {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Getter
    private UUID id;

    @Getter
    @Setter
    private Double size;

    @Getter
    @Setter
    @OneToOne()
    private Product product;
}
