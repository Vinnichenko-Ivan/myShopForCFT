package com.shop.myshopforcft.entityanddto;

import com.shop.myshopforcft.dto.ProductDto;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

/**
 * @author Ivan Vinnichenko
 */
@Entity
@Table()
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    @Getter
    private Long id;

    @Getter
    @Setter
    private Long number;

    @Getter
    @Setter
    private String manufacturer;

    @Getter
    @Setter
    private Double price;

    @Getter
    @Setter
    private Long countOnStore;

    public void setFromDto(ProductDto productDto){
        number = productDto.getNumber();
        manufacturer = productDto.getManufacturer();
        price = productDto.getPrice();
        countOnStore = productDto.getCountOnStore();
    }

    public ProductDto getToDto(){
        ProductDto productDto = new ProductDto();
        productDto.setPrice(price);
        productDto.setManufacturer(manufacturer);
        productDto.setNumber(number);
        productDto.setCountOnStore(countOnStore);
        return productDto;
    }

}
