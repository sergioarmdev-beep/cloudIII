package com.error418.orderService.service;

import com.error418.orderService.config.ProductoClient;
import com.error418.orderService.dto.Producto;
import com.error418.orderService.model.Orden;
import com.error418.orderService.repository.OrdenRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrdenServiceImpl implements OrdenService {

    private final ProductoClient productoClient;
    private final OrdenRepository ordenRepository;

    public OrdenServiceImpl(ProductoClient productoClient, OrdenRepository ordenRepository) {
        this.productoClient = productoClient;
        this.ordenRepository = ordenRepository;
    }

    @Override
    public List<Orden> listarOrdenes() {
        return ordenRepository.findAll();
    }

    @Override
    public Orden registrarOrden(Orden orden) {
        // Llamar al microservicio de producto-service por Eureka
        Producto producto = productoClient.obtenerProducto(orden.getIdproducto());

        if (producto == null) {
            throw new RuntimeException("Producto no encontrado");
        }

        // Cálculo automático del total basado en el precio remoto
        orden.setTotal(producto.getPrecio() * orden.getCantidad());

        return ordenRepository.save(orden);
    }
}

