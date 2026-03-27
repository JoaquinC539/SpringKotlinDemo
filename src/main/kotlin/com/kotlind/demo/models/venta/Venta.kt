package com.kotlind.demo.models.venta

import jakarta.annotation.Generated
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive
import java.time.Instant
import java.time.LocalDateTime

@Entity
data class Venta(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L,
    @Positive
    var vendedorId: Long = 0,
    @Positive
    var productoId: Long = 0,
    @Positive
    var cantidad: Int = 0,
    var fecha: Instant = Instant.now()

)
