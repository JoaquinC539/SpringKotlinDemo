package com.kotlind.demo.models.vendedor;

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Vendedor(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L,
    var nombre: String = "",
    var codigoEmpleado: String = ""
) {
    companion object {
        fun test() {
            println("test")
        }
    }
}
