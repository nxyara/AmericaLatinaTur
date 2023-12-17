package com.americalatinatur.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.americalatinatur.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
