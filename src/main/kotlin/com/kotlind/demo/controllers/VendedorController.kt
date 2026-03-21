package com.kotlind.demo.controllers

import com.kotlind.demo.models.vendedor.Vendedor
import com.kotlind.demo.services.VendedorService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping("vendedor")
class VendedorController {

    private val vendedorService: VendedorService

    constructor(vendedorService: VendedorService) {
        this.vendedorService = vendedorService
    }

    @PostMapping
    fun saveVendedor(@RequestBody vendedor: Vendedor): ResponseEntity<Vendedor> {
        return ResponseEntity.ok().body(vendedorService.addVendedor(vendedor))
    }

    @GetMapping
    fun getAllVendedores(): ResponseEntity<List<Vendedor>> {
        return ResponseEntity.ok().body(vendedorService.getAllVendedores())
    }

    @GetMapping("/{id}")
    fun getVendedor(@PathVariable id: Int): ResponseEntity<Vendedor> {
        return ResponseEntity.ok().body(vendedorService.getVendedor(id))
    }


}
