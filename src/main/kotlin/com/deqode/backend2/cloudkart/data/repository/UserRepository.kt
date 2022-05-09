package com.deqode.backend2.cloudkart.data.repository

import com.deqode.backend2.cloudkart.data.entity.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query

interface UserRepository: MongoRepository<User, Long> {
    @Query("{username: '?0'}")
    fun findByUsername(username: String): User?

    @Query("{email: '?0'}")
    fun findByEmail(email: String): User?

}