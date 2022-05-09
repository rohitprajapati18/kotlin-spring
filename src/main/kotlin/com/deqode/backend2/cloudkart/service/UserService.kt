package com.deqode.backend2.cloudkart.service

import com.deqode.backend2.cloudkart.data.entity.User
import com.deqode.backend2.cloudkart.data.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService(@Autowired val user: UserRepository) {

    fun getUserById(id: Long):User?{
        return user.findById(id).get();
    }

    fun addUser(newuser: User): User?{
        return user.save(newuser);
    }

    fun getUserByUsername(username: String): User?{
        return user.findByUsername(username)
    }

    fun getUserByEmail(email: String): User?{
        return user.findByEmail(email)
    }
}