package com.example.reviewBlog.controller

import com.example.reviewBlog.model.Article
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/article")
class ArticleController {
    fun getArticle(): Article {
        return Article()
    }

}