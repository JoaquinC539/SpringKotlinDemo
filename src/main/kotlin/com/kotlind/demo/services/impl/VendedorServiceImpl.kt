package com.kotlind.demo.services.impl

import com.kotlind.demo.models.vendedor.Vendedor
import com.kotlind.demo.services.VendedorService
import jdk.jshell.spi.ExecutionControl
import org.h2.expression.function.RandFunction
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class VendedorServiceImpl : VendedorService {


    override fun addVendedor(vendedor: Vendedor): Vendedor {

        println(vendedor.toString())
        var strBuilder = StringBuilder()
        var i = 0
        val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        while (i < 10) {
            val rand = chars.random()
            strBuilder.append(rand)
            i++
        }
        val vr = Vendedor(1, vendedor.nombre, strBuilder.toString())
        return vr;
    }
}
