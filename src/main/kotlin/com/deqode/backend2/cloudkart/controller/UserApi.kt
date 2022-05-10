package com.deqode.backend2.cloudkart.controller

import com.deqode.backend2.cloudkart.config.JwtTokenUtil
import com.deqode.backend2.cloudkart.data.entity.Gender
import com.deqode.backend2.cloudkart.data.entity.ResponseToken
import com.deqode.backend2.cloudkart.data.entity.User
import com.deqode.backend2.cloudkart.data.entity.UserCredentials
import com.deqode.backend2.cloudkart.service.JwtUserDetailsService
import com.deqode.backend2.cloudkart.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.DisabledException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin
class UserApi(@Autowired val userService: UserService){

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Long): User? {
        try{
            return userService.getUserById(id)
        }catch(err: Exception){
            return User(-1, "", "", "", "", "", Date(), Gender.NOT_SPECIFIED)
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
            return User(-1, "", "", "", "", "", Date(), Gender.NOT_SPECIFIED)
        }
    }

    @PostMapping("/add")
    fun addUser(@RequestBody newuser: User): User?{
        try{
            return userService.addUser(newuser)
        }catch(err: Exception){
            return User(-1, "", "", "", "", "", Date(), Gender.NOT_SPECIFIED)
        }
    }


    @Autowired
    private val authenticationManager: AuthenticationManager? = null

    @Autowired
    private val jwtTokenUtil: JwtTokenUtil? = null

    @Autowired
    private val userDetailsService: JwtUserDetailsService? = null

    @RequestMapping(value = ["/authenticate"], method = [RequestMethod.POST])
    @Throws(java.lang.Exception::class)
    fun createAuthenticationToken(@RequestBody authenticationRequest: UserCredentials): ResponseEntity<*>? {

        authenticate(authenticationRequest.username, authenticationRequest.password)
        val userDetails = userDetailsService?.loadUserByUsername(authenticationRequest.username)
        val token = jwtTokenUtil!!.generateToken(userDetails!!)
        return ResponseEntity.ok<Any>(token?.let { ResponseToken(it) })
    }

    @Throws(java.lang.Exception::class)
    private fun authenticate(username: String, password: String) {
        try {
            authenticationManager!!.authenticate(UsernamePasswordAuthenticationToken(username, password))
        } catch (e: DisabledException) {
            throw java.lang.Exception("USER_DISABLED", e)
        } catch (e: BadCredentialsException) {
            throw java.lang.Exception("INVALID_CREDENTIALS", e)
        }
    }

}