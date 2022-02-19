package com.shop.myshopforcft.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ivan Vinnichenko
 */
@Api
@RestController
@RequestMapping("/product")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ProductController {

    @ApiOperation("Проверка работы.")
    @PostMapping("/test")
    public void test(){
    }
}
