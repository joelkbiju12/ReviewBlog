package com.example.reviewBlog.repository

import com.example.reviewBlog.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User,Int> {
    fun findByEmail(email: String): User?
}