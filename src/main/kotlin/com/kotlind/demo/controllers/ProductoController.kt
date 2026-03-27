package com.kotlind.demo.controllers

import com.kotlind.demo.models.producto.Producto
import com.kotlind.demo.services.ProductoService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("producto")
class ProductoController(private val productoService: ProductoService) {

    @PostMapping
    fun saveProducto(@RequestBody producto: Producto): ResponseEntity<Producto> {
        return ResponseEntity.ok().body(productoService.addProducto(producto))
    }

    @GetMapping
    fun getProductos(): ResponseEntity<List<Producto>> {
        return ResponseEntity.ok().body(productoService.getAllProdcuto())
    }

    @GetMapping("/{id}")
    fun getProducto(@PathVariable id: Long): ResponseEntity<Producto> {
        return ResponseEntity.ok().body(productoService.getProducto(id))
    }
}
