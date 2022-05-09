package com.deqode.backend2.cloudkart.data.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "USER")
data class User(
    @Id
    var id:Int,
    var username:String,
    var email:String,
    var firstName:String?,
    var lastName:String?,
    var dateOfBirth: Date,
    var gender: Gender
)