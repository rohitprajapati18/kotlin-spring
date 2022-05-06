package com.deqode.backend2.cloudkart.data.repository

import com.deqode.backend2.cloudkart.data.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository: JpaRepository<Product, Long> {
}