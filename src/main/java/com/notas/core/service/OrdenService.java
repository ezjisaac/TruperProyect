package com.notas.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notas.core.dao.OrdenesRepository;
import com.notas.core.dao.ProductosRepository;
import com.notas.core.entity.Ordenes;
import com.notas.core.entity.Productos;

import jakarta.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@Service
public class OrdenService {
    @Autowired
    private OrdenesRepository ordenRepository;
    
    @Autowired
    private ProductosRepository productoRepository;

    @Transactional
    public Ordenes guardarOrdenDeCompra() {
        Ordenes orden = new Ordenes();
        orden.setSucursalId(1L);
        orden.setFecha(new Date());
        orden.setTotal(725.50);

        ordenRepository.save(orden);

        Productos producto1 = new Productos();
        producto1.setOrdenId(orden.getOrdenId());
        producto1.setCodigo("18156");
        producto1.setDescripcion("Esmeriladora angular");
        producto1.setPrecio(625);

        Productos producto2 = new Productos();
        producto2.setOrdenId(orden.getOrdenId());
        producto2.setCodigo("17193");
        producto2.setDescripcion("Pala redonda");
        producto2.setPrecio(100.50);

        productoRepository.save(producto1);
        productoRepository.save(producto2);

        return orden;
    }
    
    public Ordenes obtenerOrdenPorId(Long id) {
        Optional<Ordenes> orden = ordenRepository.findById(id);
        return orden.orElse(null);
    }
    
    public Productos actualizarPrecio(String codigo, double nuevoPrecio) {
        Optional<Productos> productoOpt = productoRepository.findByCodigo(codigo);
        if (productoOpt.isPresent()) {
            Productos producto = productoOpt.get();
            producto.setPrecio(nuevoPrecio);
            productoRepository.save(producto);
            return producto;
        } else {
            throw new RuntimeException("Producto no encontrado");
        }
    }
    
}
