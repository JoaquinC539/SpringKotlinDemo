package com.kotlind.demo.repositories

import com.kotlind.demo.models.vendedor.Vendedor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface VendedorRepository : JpaRepository<Vendedor, Long>
