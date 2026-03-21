package com.kotlind.demo.services

import com.kotlind.demo.models.vendedor.Vendedor


interface VendedorService {

    fun addVendedor(vendedor: Vendedor): Vendedor

    fun getAllVendedores(): List<Vendedor>

    fun getVendedor(id: Int): Vendedor
}
