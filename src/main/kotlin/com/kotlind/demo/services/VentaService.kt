package  com.kotlind.demo.services

import com.kotlind.demo.models.venta.Venta
import com.kotlind.demo.models.venta.VentaDto

interface VentaService {
    fun addVenta(venta: Venta): Venta

    fun getVentasRaw(): List<Venta>

    fun getVentas(total: Double?, cantidad: Int?, vendedorId: Long?, productoId: Long?): List<VentaDto>
}
