package com.kotlind.demo.services.impl

import com.kotlind.demo.models.vendedor.Vendedor
import com.kotlind.demo.repositories.VendedorRepository
import com.kotlind.demo.services.VendedorService
import jakarta.transaction.Transactional
import jdk.jshell.spi.ExecutionControl
import org.h2.expression.function.RandFunction
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class VendedorServiceImpl : VendedorService {

    private val vendedorRepository: VendedorRepository

    constructor(vendedorRepository: VendedorRepository) {
        this.vendedorRepository = vendedorRepository
    }

    @Transactional(rollbackOn = [Exception::class])
    override fun addVendedor(vendedor: Vendedor): Vendedor {
        try {
            println(vendedor.toString())
            var strBuilder = StringBuilder()
            var i = 0
            val chars = ('a'..'z').joinToString("") + "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            while (i < 13) {
                val rand = chars.random()
                strBuilder.append(rand)
                i++
            }
            vendedor.codigoEmpleado = strBuilder.toString()
            val vr = vendedorRepository.save(vendedor)

            return vr;
        } catch (e: Exception) {
            throw Exception("Ocurrio un error ${e.message}")
        }

    }
}
