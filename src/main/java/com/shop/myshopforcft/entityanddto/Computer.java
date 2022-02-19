package com.shop.myshopforcft.entityanddto;

import com.shop.myshopforcft.entityanddto.enums.ComputerFormFactor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
