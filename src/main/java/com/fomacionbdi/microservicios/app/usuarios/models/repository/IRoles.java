package com.fomacionbdi.microservicios.app.usuarios.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fomacionbdi.microservicios.app.usuarios.models.entity.RolEntity;

public interface IRoles extends JpaRepository<RolEntity, Long> {

}
