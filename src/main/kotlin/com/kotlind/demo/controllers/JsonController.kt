package com.kotlind.demo.controllers

import com.kotlind.demo.exceptions.AppException
import com.kotlind.demo.utils.log
import org.springframework.boot.http.client.ClientHttpRequestFactoryBuilder
import org.springframework.boot.restclient.RestTemplateBuilder
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.http.client.ClientHttpRequest
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import org.springframework.web.service.registry.HttpServiceGroup
import tools.jackson.databind.ObjectMapper
import java.util.Arrays

@RestController
@RequestMapping("json")
class JsonController(private val objectMapper: ObjectMapper) {

    val postUrl = "https://jsonplaceholder.typicode.com/posts"


    // val objectMapper = ObjectMapper()

    data class Post(val userId: Long = 0L, val id: Long = 0L, val title: String = "", val body: String = "")

    @GetMapping
    fun getPosts(): ResponseEntity<Any> {

        val http = RestTemplateBuilder().build()
        // var req = ResponseEntity()
        var res = http.exchange(postUrl, HttpMethod.GET, null, Any::class.java)
        // var res = http.exchange(postUrl, HttpMethod.GET, null, ))
        return ResponseEntity.ok().body(res.body)
    }

    @PostMapping
    fun addPost(@RequestBody req: String): ResponseEntity<Any> {
        val http = RestTemplateBuilder().build()
        val headers = HttpHeaders()
        headers.accept = Arrays.asList(MediaType.APPLICATION_JSON)
        var bodyParsed = objectMapper.readValue(req, Post::class.java)
        log.info(bodyParsed.toString())
        var tree = objectMapper.readTree(req)
        var title = tree.get("title")?.asString()
        log.info("Title: $title")
        var reqe: HttpEntity<String> = HttpEntity<String>(req, headers)
        var res = http.exchange(postUrl, HttpMethod.POST, reqe, Post::class.java)
        log.info("Post res: ${res.body?.id} + ${res.body?.title}")
        val postRes = Post(
            bodyParsed.userId,
            res.body?.id ?: throw AppException("No creado post"),
            bodyParsed.title,
            bodyParsed.body
        )

        return ResponseEntity.ok().body(postRes)
    }

    @PostMapping("/2")
    fun addPost2(@RequestBody req: String): ResponseEntity<Any> {
        val client = WebClient.create()
        var bodyParsed = objectMapper.readValue(req, Post::class.java)
        log.info(bodyParsed.toString())
        var tree = objectMapper.readTree(req)
        var title = tree.get("title").stringValue()
        log.info("Title: $title")
        val res = client.post().uri(postUrl).bodyValue(req).header("Accept", MediaType.APPLICATION_JSON_VALUE)
            .retrieve().bodyToMono(Post::class.java).block()
        val postRes =
            Post(
                userId = bodyParsed.userId,
                id = res?.id ?: throw AppException("not inserted"),
                title = bodyParsed.title,
                body = bodyParsed.body
            )
        return ResponseEntity.ok().body(postRes)
    }
}
