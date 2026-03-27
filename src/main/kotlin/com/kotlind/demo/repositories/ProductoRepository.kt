package com.kotlind.demo.repositories

import com.kotlind.demo.models.producto.Producto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface ProductoRepository : JpaRepository<Producto, Long> {
    fun findByNombre(nombre: String): Producto?

    @Query(
        """
        SELECT * FROM PRODUCTO where id = :id
    """, nativeQuery = true
    )
    fun findVendedorById(@Param("id") id: Long): Producto?
}
