package com.notas.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notas.core.entity.Ordenes;


@Repository
public interface OrdenesRepository extends JpaRepository<Ordenes, Long>{

}
