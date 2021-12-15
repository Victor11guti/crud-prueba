package com.fomacionbdi.microservicios.app.usuarios.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="roles")
public class RolEntity implements Serializable {

	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id_rol;
	@NotNull
	private String name;
	
	public RolEntity () {}
	
	public RolEntity(Long id_rol, String name) {
		super();
		this.id_rol = id_rol;
		this.name = name;
	}
	public Long getId_rol() {
		return id_rol;
	}
	public void setId_rol(Long id_rol) {
		this.id_rol = id_rol;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	private static final long serialVersionUID = 1L;

}
