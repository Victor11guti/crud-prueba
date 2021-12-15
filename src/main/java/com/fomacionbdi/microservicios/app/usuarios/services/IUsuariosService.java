package com.fomacionbdi.microservicios.app.usuarios.services;

import java.util.List;

import com.fomacionbdi.microservicios.app.usuarios.models.entity.UsuarioEntity;

public interface IUsuariosService {

	public abstract   UsuarioEntity crearUsuario(UsuarioEntity user);
	public abstract void eliminar(Long id);
	public abstract List<UsuarioEntity> listarTodos();
	public abstract UsuarioEntity listarUno(Long id);
	
	public abstract UsuarioEntity  ListarPornombre(String name);
		
}
