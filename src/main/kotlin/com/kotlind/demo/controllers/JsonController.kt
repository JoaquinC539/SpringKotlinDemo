package com.kotlind.demo.controllers

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
import java.util.Arrays

@RestController
@RequestMapping("json")
class JsonController {

    val postUrl = "https://jsonplaceholder.typicode.com/posts"

    @GetMapping
    fun getPosts(): ResponseEntity<Any> {

        val http = RestTemplateBuilder().build()
        // var req = ResponseEntity()
        var res = http.exchange(postUrl, HttpMethod.GET, null, Any::class.java)
        return ResponseEntity.ok().body(res.body)
    }

    @PostMapping
    fun addPost(@RequestBody req: String): ResponseEntity<Any> {
        val http = RestTemplateBuilder().build()
        val headers = HttpHeaders()
        headers.accept = Arrays.asList(MediaType.APPLICATION_JSON)
        var reqe: HttpEntity<String> = HttpEntity<String>(req, headers)
        return ResponseEntity.ok().body(http.exchange(postUrl, HttpMethod.POST, reqe, Any::class.java).body)
    }

    @PostMapping("/2")
    fun addPost2(@RequestBody req: String): ResponseEntity<Any> {
        val client = WebClient.create()
        val res = client.post().uri(postUrl).bodyValue(req)
            .retrieve().bodyToMono(Any::class.java).block()
        return ResponseEntity.ok().body(res)
    }
}
