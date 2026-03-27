package com.kotlind.demo.models.venta

import com.kotlind.demo.models.producto.Producto
import com.kotlind.demo.models.vendedor.Vendedor
import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.sql.Date
import java.sql.Timestamp
import java.time.LocalDate
import java.time.LocalDateTime

data class VentaDto(
    @Id
    var idVenta: Long = 0L,
    var vendedorId: Long = 0L,
    var vendedorCodigo: String = "",
    var productoId: Long = 0L,
    var productoCodigo: String = "",
    var productoPrecio: Double = 0.0,
    var cantidad: Int = 0,
    var fecha: LocalDateTime?,
    var total: Double = 0.0
)
