package com.deqode.backend2.cloudkart.service

import com.deqode.backend2.cloudkart.data.entity.User
import com.deqode.backend2.cloudkart.data.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service


@Service
class JwtUserDetailsService : UserDetailsService {
    @Autowired
    private val userDao: UserRepository? = null


    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails? {
        val u: User? = userDao?.findByUsername(username)
        //System.out.println(username);
        return if (u != null) { org.springframework.security.core.userdetails.User(u.username, u.password,
            ArrayList<GrantedAuthority>())
        } else {
            throw Exception("User not found with username: $username")
        }
    }
}