package com.kotlind.demo.services.impl

import com.kotlind.demo.exceptions.AppException
import com.kotlind.demo.models.vendedor.Vendedor
import com.kotlind.demo.repositories.VendedorRepository
import com.kotlind.demo.services.VendedorService
import com.kotlind.demo.utils.log
import jakarta.transaction.Transactional
import jdk.jshell.spi.ExecutionControl
import org.h2.expression.function.RandFunction
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class VendedorServiceImpl : VendedorService {

    private val vendedorRepository: VendedorRepository


    // private val logg= LoggerUtil.
    // private companion object {
    //     val log: Logger = LoggerFactory.getLogger(VendedorServiceImpl::class.java)
    // }

    constructor(vendedorRepository: VendedorRepository) {
        this.vendedorRepository = vendedorRepository
    }


    @Transactional(rollbackOn = [Exception::class])
    override fun addVendedor(vendedor: Vendedor): Vendedor {
        try {
            log.info("Insertando vendedor: {}", vendedor.nombre)
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

    override fun getAllVendedores(): List<Vendedor> {
        return vendedorRepository.findAll()
    }

    override fun getVendedor(id: Int): Vendedor {
        log.info("Venedor id $id")
        return vendedorRepository.findVendedorById(id.toLong()) ?: throw AppException("Empty result")

    }
}
