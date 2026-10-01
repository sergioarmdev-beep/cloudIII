package com.error418.orderService.config;

import com.error418.orderService.dto.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "producto-service")
public interface ProductoClient {

    @GetMapping("/producto/listarProducto/{id}")
    Producto obtenerProducto(@PathVariable("id") int id);
}

