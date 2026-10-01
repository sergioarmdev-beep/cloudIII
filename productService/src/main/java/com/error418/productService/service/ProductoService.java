package com.error418.productService.service;
import com.error418.productService.model.Producto;

import java.util.List;

public interface ProductoService {
    List<Producto> listarProductos();
    Producto listarProducto(int id);
    Producto registrarProducto(Producto producto);
}

