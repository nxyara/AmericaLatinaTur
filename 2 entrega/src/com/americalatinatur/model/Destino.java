package com.americalatinatur.model;

public class Destino {

	private int idDestino;
	
	private String nomeDestino;
	
	private String datasDestino;
	
	private String precoDestino;
	
	private Usuario usuario;

	public int getIdDestino() {
		return idDestino;
	}

	public void setIdDestino(int idDestino) {
		this.idDestino = idDestino;
	}

	public String getNomeDestino() {
		return nomeDestino;
	}

	public void setNomeDestino(String nomeDestino) {
		this.nomeDestino = nomeDestino;
	}

	public String getDatasDestino() {
		return datasDestino;
	}

	public void setDatasDestino(String datasDestino) {
		this.datasDestino = datasDestino;
	}

	public String getPrecoDestino() {
		return precoDestino;
	}

	public void setPrecoDestino(String precoDestino) {
		this.precoDestino = precoDestino;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Destino [idDestino=" + idDestino + ", nomeDestino=" + nomeDestino + ", datasDestino=" + datasDestino
				+ ", precoDestino=" + precoDestino + ", usuario=" + usuario + "]";
	} 
	
	
	
	
}
