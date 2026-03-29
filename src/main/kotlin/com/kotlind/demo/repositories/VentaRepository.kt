package com.kotlind.demo.repositories

import com.kotlind.demo.models.venta.Venta
import com.kotlind.demo.models.venta.VentaDto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface VentaRepository : JpaRepository<Venta, Long> {

    @Query(
        """
        SELECT vt.id idVenta,
        vd.id vendedorId,
        vd.codigo_empleado vendedorCodigo,
       p.id productoId,
       p.codigo_producto productoCodigo,
       p.nombre,
       p.precio productoPrecio,
       vt.cantidad, vt.fecha,
       p.precio*vt.cantidad total
        FROM VENTA vt
        JOIN VENDEDOR vd ON vt.vendedor_id=vd.id
        JOIN PRODUCTO p ON vt.producto_id=p.id
        WHERE (:total is null or p.precio*vt.cantidad >= :total)
        AND (:cantidad IS NULL OR vt.cantidad >= :cantidad)
        AND (:vendedorId IS NULL OR vd.id = :vendedorId)
        AND (:productoId IS NULL OR P.ID = :productoId)
    """, nativeQuery = true, name = "Venta.findVentaData"
    )
    fun findVentaData(
        @Param("total") total: Double?,
        cantidad: Int?,
        vendedorId: Long?,
        productoId: Long?
    ): List<VentaDto>
}
