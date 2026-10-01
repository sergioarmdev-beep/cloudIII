package com.error418.productService.controller;

import com.error418.productService.model.Producto;
import com.error418.productService.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/listarProductos")
    public ResponseEntity<List<Producto>> listarProductos() {
        return new ResponseEntity<List<Producto>>(productoService.listarProductos(), HttpStatus.OK);
    }

    @GetMapping("/listarProducto/{id}")
    public ResponseEntity<Producto> listarProducto(@PathVariable("id") int id) {
        return new ResponseEntity<Producto>(productoService.listarProducto(id), HttpStatus.OK);
    }

    @PostMapping("/registrarProducto")
    public ResponseEntity<Producto> registrarProducto(@RequestBody Producto producto) {
        return new ResponseEntity<Producto>(productoService.registrarProducto(producto), HttpStatus.CREATED);
    }
}
