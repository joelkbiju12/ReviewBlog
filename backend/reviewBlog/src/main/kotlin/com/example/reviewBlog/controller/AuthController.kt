package com.example.reviewBlog.controller

import com.example.reviewBlog.dtos.LoginDTO
import com.example.reviewBlog.dtos.Message
import com.example.reviewBlog.dtos.RegisterDTO
import com.example.reviewBlog.model.User
import com.example.reviewBlog.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.security.config.annotation.rsocket.RSocketSecurity.JwtSpec
import io.jsonwebtoken
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api")
class AuthController(private val userService: UserService) {

    @GetMapping("hello")
    fun hello(): String {
        return "hello"
    }

    @PostMapping("register")
    fun register(@RequestBody body: RegisterDTO): ResponseEntity<User> {
        val user = User()
        user.name = body.name
        user.email = body.email
        user.password = body.password

        return ResponseEntity.ok(this.userService.save(user))
    }

    @PostMapping("login")
    fun login(@RequestBody body: LoginDTO): ResponseEntity<Any> {
        val user = this.userService.findByEmail(body.email)
        if (user == null) {
            return ResponseEntity.badRequest().body(Message("User Not found"))
        }

        if (!user.comparePassword(body.password)) {
            return ResponseEntity.badRequest().body(Message("Invalid password"))
        }

        val issuer = user.id.toString()
        val jwt = Jwts.builder()

        return ResponseEntity.ok(user)
    }
}
