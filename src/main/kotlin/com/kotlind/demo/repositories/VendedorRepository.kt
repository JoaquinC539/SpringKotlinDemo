package com.kotlind.demo.repositories

import com.kotlind.demo.models.vendedor.Vendedor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface VendedorRepository : JpaRepository<Vendedor, Long> {
    fun findByNombre(nombre: String): Vendedor?

    @Query(
        """
        SELECT * FROM VENDEDOR where id = :id
    """, nativeQuery = true
    )
    fun findVendedorById(@Param("id") id: Long): Vendedor?
}
