package com.deqode.backend2.cloudkart.data.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="PRODUCT")
class Product (
    @Id
    var id: Long,
    @Column(name="PROUDCT_NAME")
    var name: String?,
    @Column(name="CATEGORY")
    var category: String?,
    @Column(name="SUB_CATEGORY")
    var subCategory: String?
) {
}