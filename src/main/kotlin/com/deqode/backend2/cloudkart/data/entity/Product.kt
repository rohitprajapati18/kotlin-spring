package com.deqode.backend2.cloudkart.data.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "PRODUCT")
data class Product(
    @Id
    var id: Long?,
    var name: String?,
    var category: String?,
    var subCategory: String?
)