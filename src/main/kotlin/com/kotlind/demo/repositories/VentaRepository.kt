package com.kotlind.demo.repositories

import com.kotlind.demo.models.venta.Venta
import com.kotlind.demo.models.venta.VentaDto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface VentaRepository : JpaRepository<Venta, Long> {

    @Query(
        """
        SELECT vt.id idVenta,
        vd.id vendedorId,
        vd.codigo_empleado vendedorCodigo,
       p.id productoId,
       p.codigo_producto productoCodigo,
       p.precio productoPrecio,
       vt.cantidad, vt.fecha,
       p.precio*vt.cantidad total
        FROM VENTA vt
        JOIN VENDEDOR vd ON vt.vendedor_id=vd.id
        JOIN PRODUCTO p ON vt.producto_id=p.id
    """, nativeQuery = true, name = "Venta.findVentaData"
    )
    fun findVentaData(): List<VentaDto>
}
