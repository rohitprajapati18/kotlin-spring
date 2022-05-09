package com.deqode.backend2.cloudkart.controller

import com.deqode.backend2.cloudkart.data.entity.Product
import com.deqode.backend2.cloudkart.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/products")
class ProductApi(@Autowired val productService: ProductService) {

    @GetMapping("/{id}")
    fun getProduct(@PathVariable id: Long): Product? {
        return productService.getProductById(id);
    }

    @PostMapping("/add")
    fun addProduct(@RequestBody product: Product): Product?{
        try{
            return productService.addNewProduct(product);
        }catch(err: Exception){
            return Product(-1, "", "", "")
        }
    }
}