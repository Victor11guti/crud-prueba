package com.fomacionbdi.microservicios.app.usuarios.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="usuarios")
public class UsuarioEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String name;
	
	@ManyToOne
	@JoinColumn(name ="id_rol")
	@NotNull
	private RolEntity rol;
	
	
	private char status;

	public UsuarioEntity () {}
	public UsuarioEntity(Long id, String name, RolEntity rol, char status) {
		super();
		this.id = id;
		this.name = name;
		this.rol = rol;
		status = status;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public RolEntity getRol() {
		return rol;
	}


	public void setRol(RolEntity rol) {
		this.rol = rol;
	}


	public char getStatus() {
		return status;
	}


	public void setStatus(char status) {
		status = status;
	}
	
	private static final long serialVersionUID = 1L;


		
}
