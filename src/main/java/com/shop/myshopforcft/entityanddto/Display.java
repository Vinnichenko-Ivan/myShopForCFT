package com.shop.myshopforcft.entityanddto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
    private Long id;

    @Getter
    @Setter
    private Double size;

    @Getter
    @Setter
    @OneToOne()
    private Product product;
}
