package com.americalatinatur.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.americalatinatur.models.Usuario;
import com.americalatinatur.repositories.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository cr;
	
	@GetMapping("/allusuarios")
	public List<Usuario> getAllUsuarios(){
		
		return cr.findAll();		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
		Usuario usuario = cr.findById(id).orElseThrow(() -> new RuntimeException(id + "Not Found"));

		return ResponseEntity.ok(usuario);
	}
	
	@PostMapping("/saveusuario")
	public Usuario saveUsuario(@RequestBody Usuario usuario) {

		return cr.save(usuario);
	}

	
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuarioUpdated) {
		Usuario Usuario = cr.findById(id).orElseThrow(() -> new RuntimeException(id + "Not Found"));

		Usuario.setName(usuarioUpdated.getName());
		Usuario.setDataNasc(usuarioUpdated.getDataNasc());

		return ResponseEntity.ok(Usuario);
	}

	
	@DeleteMapping("/{id}")
	public void deleteUsuario(@PathVariable Long id) {
		Usuario usuario = cr.findById(id).orElseThrow(() -> new RuntimeException(id + "Not Found"));
		cr.delete(usuario);

	}
	
	
}
