package com.kotlind.demo.services

import com.kotlind.demo.models.producto.Producto


interface ProductoService {
    fun addProducto(producto: Producto): Producto

    fun getAllProdcuto(): List<Producto>

    fun getProducto(id: Long): Producto
}
