package com.kotlind.demo.services.impl

import com.kotlind.demo.exceptions.AppException
import com.kotlind.demo.models.producto.Producto
import com.kotlind.demo.models.vendedor.Vendedor
import com.kotlind.demo.repositories.ProductoRepository
import com.kotlind.demo.services.ProductoService
import com.kotlind.demo.utils.log
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class ProductoServiceImpl(private val productoRepository: ProductoRepository) : ProductoService {

    @Transactional(rollbackOn = [AppException::class, Exception::class])
    override fun addProducto(producto: Producto): Producto {
        try {
            var strBuilder = StringBuilder()
            var i = 0
            val chars = ('a'..'z').joinToString("") + "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            while (i < 20) {
                val rand = chars.random()
                strBuilder.append(rand)
                i++
            }
            producto.codigoProducto = strBuilder.toString()
            val pr = productoRepository.save(producto)
            return pr
        } catch (e: Exception) {
            throw AppException("An error ocurred at saving Producto ${e.message}")
        }
    }

    override fun getAllProdcuto(): List<Producto> {
        try {
            return productoRepository.findAll()
        } catch (e: Exception) {
            throw AppException("An error ocurred at getting Productos ${e.message}")
        }

    }

    override fun getProducto(id: Long): Producto {
        try {
            log.info("Producto id: $id")
            return productoRepository.findVendedorById(id) ?: throw AppException("Producto not found with id $id")
        } catch (e: Exception) {
            throw AppException("An error ocurred at getting Producto ${e.message}")
        }
    }

}
