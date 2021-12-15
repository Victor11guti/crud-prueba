package com.fomacionbdi.microservicios.app.usuarios.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fomacionbdi.microservicios.app.usuarios.models.entity.RolEntity;
import com.fomacionbdi.microservicios.app.usuarios.models.repository.IRoles;



@Service
public class RolesServiceImpl implements  IRolesServices {

	@Autowired
	private IRoles rolesRepository;
	
	@Override
	public List<RolEntity> listar() {
		return rolesRepository.findAll();
	}
	
	

}
