package com.notas.core.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notas.core.entity.Productos;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Long>{
	Optional<Productos> findByCodigo(String codigo);
}
