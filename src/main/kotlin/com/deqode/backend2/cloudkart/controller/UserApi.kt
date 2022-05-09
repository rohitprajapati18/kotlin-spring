package com.deqode.backend2.cloudkart.controller

import com.deqode.backend2.cloudkart.data.entity.Gender
import com.deqode.backend2.cloudkart.data.entity.User
import com.deqode.backend2.cloudkart.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/users")
class UserApi(@Autowired val userService: UserService){

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Long): User? {
        try{
            return userService.getUserById(id)
        }catch(err: Exception){
            return User(-1, "", "", "", "", Date(), Gender.NOT_SPECIFIED)
        }
    }

    @GetMapping("/get/{value}")
    fun getUserByValue(@PathVariable value: String): User?{
        try{
            if(!value.contains('@'))
                return userService.getUserByUsername(value)
            else
                return userService.getUserByEmail(value)
        }catch (err: Exception){
            return User(-1, "", "", "", "", Date(), Gender.NOT_SPECIFIED)
        }
    }

    @PostMapping("/add")
    fun addUser(@RequestBody newuser: User): User?{
        try{
            return userService.addUser(newuser)
        }catch(err: Exception){
            return User(-1, "", "", "", "", Date(), Gender.NOT_SPECIFIED)
        }
    }
}