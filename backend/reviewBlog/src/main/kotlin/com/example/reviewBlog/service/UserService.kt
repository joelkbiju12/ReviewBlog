package com.example.reviewBlog.service

import com.example.reviewBlog.model.User
import com.example.reviewBlog.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService( private val userRespository: UserRepository) {

    fun save(user : User): User{
        return this.userRespository.save(user)
    }

    fun findByEmail(email: String) : User? {
        return this.userRespository.findByEmail(email)

    }

}