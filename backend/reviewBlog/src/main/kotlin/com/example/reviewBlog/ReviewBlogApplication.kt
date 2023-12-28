package com.example.reviewBlog

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication


@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
class ReviewBlogApplication

fun main(args: Array<String>) {
	runApplication<ReviewBlogApplication>(*args)
}
