package com.notas.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.notas.core.entity.Ordenes;
import com.notas.core.entity.Productos;
import com.notas.core.service.OrdenService;

@RestController
@RequestMapping("/ordenes")
public class OrdenController {
    @Autowired
    private OrdenService ordenService;

    @PostMapping
    public Ordenes guardarOrden() {
        return ordenService.guardarOrdenDeCompra();
    }
    
    @GetMapping("/{id}")
    public Ordenes obtenerOrden(@PathVariable Long id) {
        return ordenService.obtenerOrdenPorId(id);
    }
    
    @PutMapping("/producto/{codigo}")
    public Productos actualizarPrecio(@PathVariable String codigo, @RequestParam double nuevoPrecio) {
        return ordenService.actualizarPrecio(codigo, nuevoPrecio);
    }
    
}