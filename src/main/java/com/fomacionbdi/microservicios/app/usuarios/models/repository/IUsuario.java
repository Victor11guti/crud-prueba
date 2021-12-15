package com.fomacionbdi.microservicios.app.usuarios.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fomacionbdi.microservicios.app.usuarios.models.entity.UsuarioEntity;

public interface IUsuario extends JpaRepository<UsuarioEntity, Long>  {

	
	
	@Query("SELECT u FROM UsuarioEntity u WHERE u.name LIKE CONCAT('%',:name,'%')")
	public abstract UsuarioEntity listarporNombre( @Param("name")String name);
	
	

}
