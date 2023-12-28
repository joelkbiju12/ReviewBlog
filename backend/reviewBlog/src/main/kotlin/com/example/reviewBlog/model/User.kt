package com.example.reviewBlog.model

import jakarta.persistence.*
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder


@Entity
@Table(name = "AppUser")
class User {
    @Id
    @GeneratedValue
    var id : Int = 0
    @Column
    var name : String = ""

    @Column(unique = true)
    var email : String = ""

    @Column
    var password : String = ""
        get() = field
        set(value){
            val passwordEncoder = BCryptPasswordEncoder()
            field = passwordEncoder.encode(value)
        }
    fun comparePassword( password : String): Boolean {
        return BCryptPasswordEncoder().matches(password, this.password)
    }
}