package com.fomacionbdi.microservicios.app.usuarios.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fomacionbdi.microservicios.app.usuarios.models.entity.UsuarioEntity;
import com.fomacionbdi.microservicios.app.usuarios.models.repository.IUsuario;

@Service
public class UsuariosServiceImpl  implements IUsuariosService{

	@Autowired
	private IUsuario repositoriUser;
	
	@Override
	public UsuarioEntity crearUsuario(UsuarioEntity user) {
		
		return repositoriUser.save(user);
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stu
		repositoriUser.deleteById(id);
	}

	@Override
	public List<UsuarioEntity> listarTodos() {
		// TODO Auto-generated method stub
		return repositoriUser.findAll();
	}

	@Override
	public UsuarioEntity listarUno(Long id) {
		// TODO Auto-generated method stub
		return repositoriUser.findById(id).orElse(null);
	}

	@Override
	public UsuarioEntity ListarPornombre(String name) {
		
		return repositoriUser.listarporNombre(name);
	}

}
