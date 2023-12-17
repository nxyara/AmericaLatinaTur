package com.americalatinatur.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

@Entity
public class Usuario {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String name;
	
	
	private LocalDate dataNasc;


	@Transient
	@OneToMany(mappedBy = "destinos")
	@JsonIgnore
	
	private Set<Destino> destinos = new HashSet<>();
	
	
	public LocalDate getDataNasc() {
		return dataNasc;
	}


	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}


	public Set<Destino> getDestinos() {
		return destinos;
	}


	public void setDestinos(Set<Destino> destinos) {
		this.destinos = destinos;
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


	
	
	
	
	
	
}
