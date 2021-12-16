package com.fomacionbdi.microservicios.app.usuarios.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fomacionbdi.microservicios.app.usuarios.models.entity.Alumno;
import com.fomacionbdi.microservicios.app.usuarios.models.entity.RolEntity;
import com.fomacionbdi.microservicios.app.usuarios.models.entity.UsuarioEntity;
import com.fomacionbdi.microservicios.app.usuarios.services.IRolesServices;
import com.fomacionbdi.microservicios.app.usuarios.services.IUsuariosService;

@RestController
@CrossOrigin (origins = {"http://localhost:4200"})

@RequestMapping("/api")

public class IndexController {

	@Autowired
	private IRolesServices rolesServices;

	@Autowired
	private IUsuariosService usuariosServices;

	@GetMapping("/roles")
	@ResponseBody
	public List<RolEntity> index() {

		return rolesServices.listar();
	}

	@GetMapping("/consultar")
	@ResponseBody
	public ResponseEntity<?> listarUser() {

		return ResponseEntity.ok().body(usuariosServices.listarTodos());

	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		UsuarioEntity user;
		Map<String, Object> response = new HashMap<>();
		user = usuariosServices.listarUno(id);

		if (user == null) {
			return new ResponseEntity<>("NO existe usuario ", HttpStatus.BAD_REQUEST);
		}
		usuariosServices.eliminar(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/crear")

	public ResponseEntity<?> create(@RequestBody UsuarioEntity user) {
		Map<String, Object> response = new HashMap<>();
		UsuarioEntity us = null;
		UsuarioEntity user1 = usuariosServices.ListarPornombre(user.getName());

		if (user1 != null) {
			return new ResponseEntity<>("Existe usuario con ese nombre ", HttpStatus.BAD_REQUEST);
		}
		us = usuariosServices.crearUsuario(user);
		if (us == null) {

			return new ResponseEntity<>("error al guardar", HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(us);

	}

	@PutMapping("editar/{id}")
	public ResponseEntity<?> editar(@RequestBody UsuarioEntity user ,@PathVariable Long id){
		Map<String, Object> response = new HashMap<>();
		UsuarioEntity us =usuariosServices.listarUno(id);
		UsuarioEntity us2 =null;
		UsuarioEntity user1 = usuariosServices.ListarPornombre(user.getName());
		if (user1 != null) {
		return new ResponseEntity<>("Existe usuario con ese nombre ", HttpStatus.NOT_FOUND);
		}
		
		try {
			us.setName(user.getName());
			us.setRol(user.getRol());
			us.setStatus(user.getStatus());
			
			us2 = usuariosServices.crearUsuario(us);
			
			
		}catch (Exception e) {
			
			response.put("mensaje", "paciente editado con exito");
			response.put("usuario", us2);
			
			return new ResponseEntity<Map<String ,Object>>(response, HttpStatus.CREATED);
		}
		
		us2 = usuariosServices.crearUsuario(us);
		return ResponseEntity.status(HttpStatus.CREATED).body(us2);
		
	}
	
	
	@GetMapping("/listar-uno/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id){
		Optional<UsuarioEntity> o = Optional.ofNullable(usuariosServices.listarUno(id));
		if(o.isEmpty()) {
		 return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
		
	}
	

}
