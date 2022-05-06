package com.deqode.backend2.cloudkart.controller

import com.deqode.backend2.cloudkart.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(name = "/api/v1/products")
class ProductApi(@Autowired val productService: ProductService) {

    @GetMapping(value = "/")
    func getAllProducts():{

    }

}