package  com.kotlind.demo.services.impl

import com.kotlind.demo.exceptions.AppException
import com.kotlind.demo.models.venta.Venta
import com.kotlind.demo.models.venta.VentaDto
import com.kotlind.demo.repositories.ProductoRepository
import com.kotlind.demo.repositories.VendedorRepository
import com.kotlind.demo.repositories.VentaRepository
import com.kotlind.demo.services.ProductoService
import com.kotlind.demo.services.VendedorService
import com.kotlind.demo.services.VentaService
import com.kotlind.demo.utils.log
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.LocalDateTime

@Service
class VentaServiceImpl(
    private val ventaRepository: VentaRepository,
    private val vendedorService: VendedorService,
    private val productoService: ProductoService
) : VentaService {
    override fun addVenta(venta: Venta): Venta {
        try {
            log.info(LocalDateTime.now().toString())
            vendedorService.getVendedor(venta.vendedorId)
            productoService.getProducto(venta.productoId)
            return ventaRepository.save(venta)
        } catch (e: Exception) {
            throw AppException("Error ocurred at adding Venta: ${e.message}")
        }
    }

    override fun getVentasRaw(): List<Venta> {
        return ventaRepository.findAll()
    }

    override fun getVentas(total: Double?, cantidad: Int?, vendedorId: Long?, productoId: Long?): List<VentaDto> {
        try {
            return ventaRepository.findVentaData(total, cantidad, vendedorId, productoId)
        } catch (e: Exception) {
            throw AppException("Error ocurred at getting venta data: ${e.message}")
        }
    }


}
