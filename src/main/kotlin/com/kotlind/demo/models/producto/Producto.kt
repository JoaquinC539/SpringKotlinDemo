package com.kotlind.demo.models.producto

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive

@Entity
class Producto(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L,
    @NotBlank
    var nombre: String = "",
    var codigoProducto: String = "",
    @Positive
    var precio: Double = 0.0
)

// @Entity
// class Producto {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     var id: Long =0L
//     var nombre: String = ""

//     var precio: Double = 0.0

//     constructor() {
//         id = 0L
//         nombre = ""
//         this.precio = 0.0
//     }

//     constructor(id: Long, nombre: String, precio: Double) {
//         this.id = id
//         this.nombre = nombre
//         this.precio = precio
//     }
// }
