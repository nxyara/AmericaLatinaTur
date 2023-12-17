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
import com.americalatinatur.models.Destino;
import com.americalatinatur.repositories.UsuarioRepository;
import com.americalatinatur.repositories.DestinoRepository;


@RestController
@RequestMapping("/destino")
public class DestinoController {
	
	
	@Autowired
	private DestinoRepository pr;
	
	@Autowired
	private UsuarioRepository cr;
	
	@GetMapping("/alldestinos")
	public List<Destino> getAllDestinos() {

		return pr.findAll();
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<Destino> getDestinoById(@PathVariable Long id) {
		Destino destino = pr.findById(id).orElseThrow(() -> new RuntimeException(id + "Not Found"));

		return ResponseEntity.ok(destino);
	}

	
	@PostMapping("/savedestino")
	public Destino saveDestino(@RequestBody Destino destino) {
		Usuario usuario = cr.findById(destino.getUsuario().getId()).orElseThrow(() -> new RuntimeException(destino.getUsuario().getId() + "Not Found"));
		destino.setUsuario(usuario);
		
		return pr.save(destino);
	}

	
	@PutMapping("/{id}")
	public ResponseEntity<Destino> updateDestino(@PathVariable Long id, @RequestBody Destino destinoUpdated) {
		Destino destino = pr.findById(id).orElseThrow(() -> new RuntimeException(id + "Not Found"));
		Usuario usuario = cr.findById(destinoUpdated.getUsuario().getId()).orElseThrow(() -> new RuntimeException(destinoUpdated.getUsuario().getId() + "Not Found"));

		destino.setName(destinoUpdated.getName());
		destino.setUsuario(usuario);

		return ResponseEntity.ok(destino);
	}

	
	@DeleteMapping("/{id}")
	public void deleteDestino(@PathVariable Long id) {
		Destino destino = pr.findById(id).orElseThrow(() -> new RuntimeException(id + "Not Found"));
		pr.delete(destino);
	}
	
	
	
}