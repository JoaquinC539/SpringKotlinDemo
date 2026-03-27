package com.kotlind.demo.controllers

import com.kotlind.demo.models.venta.Venta
import com.kotlind.demo.models.venta.VentaDto
import com.kotlind.demo.services.VentaService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("venta")
class VentaController(private val ventaService: VentaService) {

    @PostMapping
    fun addVenta(@RequestBody venta: Venta): ResponseEntity<Venta> {
        return ResponseEntity.ok().body(ventaService.addVenta(venta))
    }

    @GetMapping
    @RequestMapping("/raw")
    fun getVentasRaw(): ResponseEntity<List<Venta>> {
        return ResponseEntity.ok().body(ventaService.getVentasRaw())
    }

    @GetMapping
    fun getVentaData(): ResponseEntity<List<VentaDto>> {
        return ResponseEntity.ok().body(ventaService.getVentas())
    }


}
