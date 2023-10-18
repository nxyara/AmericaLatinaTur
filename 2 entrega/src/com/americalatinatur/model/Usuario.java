package com.americalatinatur.model;

public class Usuario {

	private int idUsuario;

	private String nomeUsuario;

	private String cpfUsuario;

	private String enderecoUsuario;

	private String telefoneUsuario;

	public Usuario() {
		super();
	}

	public Usuario(String nomeUsuario, String cpfUsuario, String enderecoUsuario, String telefoneUsuario) {
		super();
		this.nomeUsuario = nomeUsuario;
		this.cpfUsuario = cpfUsuario;
		this.enderecoUsuario = enderecoUsuario;
		this.telefoneUsuario = telefoneUsuario;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getCpfUsuario() {
		return cpfUsuario;
	}

	public void setCpfUsuario(String cpfUsuario) {
		this.cpfUsuario = cpfUsuario;
	}

	public String getEnderecoUsuario() {
		return enderecoUsuario;
	}

	public void setEnderecoUsuario(String enderecoUsuario) {
		this.enderecoUsuario = enderecoUsuario;
	}

	public String getTelefoneUsuario() {
		return telefoneUsuario;
	}

	public void setTelefoneUsuario(String telefoneUsuario) {
		this.telefoneUsuario = telefoneUsuario;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nomeUsuario=" + nomeUsuario + ", cpfUsuario=" + cpfUsuario
				+ ", enderecoUsuario=" + enderecoUsuario + ", telefoneUsuario=" + telefoneUsuario + "]";
	}

}
