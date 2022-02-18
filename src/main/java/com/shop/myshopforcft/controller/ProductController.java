package com.shop.myshopforcft.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ivan Vinnichenko
 */
@Api
@RestController
@RequestMapping("/product")
public class ProductController {

    @ApiOperation("Проверка работы.")
    @PostMapping("/test")
    public void test(){
    }
}
