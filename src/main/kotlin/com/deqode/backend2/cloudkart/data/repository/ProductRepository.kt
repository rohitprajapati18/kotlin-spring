package com.deqode.backend2.cloudkart.data.repository

import com.deqode.backend2.cloudkart.data.entity.Product
import org.springframework.data.mongodb.repository.MongoRepository

interface ProductRepository: MongoRepository<Product, Long> {
}