package com.notas.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notas.core.entity.Sucursales;

@Repository
public interface SucursalesReposiitory extends JpaRepository<Sucursales, Integer> {

}
