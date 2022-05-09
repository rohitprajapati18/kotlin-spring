package com.deqode.backend2.cloudkart.service

import com.deqode.backend2.cloudkart.data.entity.Product
import com.deqode.backend2.cloudkart.data.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductService(@Autowired val productRepository: ProductRepository) {
    fun getAllProducts(): List<Product>{
        return productRepository.findAll()
    }

    fun getProductById(id: Long): Product{
        return productRepository.getById(id);
    }

    fun addNewProduct(newProduct: Product): Product{
        try{
            return productRepository.save(newProduct);
        }catch(e: Exception){

        }

        return Product(-1, "", "", "");
    }
}