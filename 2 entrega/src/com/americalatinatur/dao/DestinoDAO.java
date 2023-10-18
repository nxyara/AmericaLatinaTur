package com.americalatinatur.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.americalatinatur.model.Destino;
import com.americalatinatur.model.Usuario;

public class DestinoDAO {

	private static String sql;

	private final Connection connection;

	public DestinoDAO(Connection connection) {
		this.connection = connection;
	}

	// CREATE
	public void createDestino(Destino destino) {
		sql = "INSERT INTO Destino (nomeDestino, datasDestino, precoDestino, idUsuario) VALUES (?, ?, ?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, destino.getNomeDestino());
			stmt.setString(2, destino.getDatasDestino());
			stmt.setString(3, destino.getPrecoDestino());
			stmt.setInt(4, destino.getUsuario().getIdUsuario());

			stmt.executeUpdate();
			System.out.println("Destino criado com sucesso!" + destino.toString());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	// READ
	public void readAllDestino() {
		sql = "SELECT * FROM destino as d " + "INNER JOIN usuario as u " + "ON d.idUsuario = u.idUsuario";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet r = stmt.executeQuery();
			while (r.next()) {
			}
				Destino destino = new Destino();
				destino.setIdDestino(r.getInt("idDestino"));
				destino.setNomeDestino(r.getString("nomeDestino"));
				destino.setDatasDestino(r.getString("datasDestino"));
				destino.setPrecoDestino(r.getString("precoDestino"));
				
				//Usuario do Destino
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(r.getInt("idUsuario"));
				usuario.setNomeUsuario(r.getString("nomeUsuario"));
				usuario.setCpfUsuario(r.getString("cpfUsuario"));
				usuario.setEnderecoUsuario(r.getString("enderecoUsuario"));
				usuario.setTelefoneUsuario(r.getString("telefoneUsuario"));
				destino.setUsuario(usuario);
				System.out.println("ID do Destino: " + destino.getIdDestino() 
				+ "\nNome do Destino: " 
				+ "\nID e Nome de Usuario: " + usuario.getIdUsuario() + usuario.getNomeUsuario() );

			
	} catch (SQLException e) {
		System.out.println("Nao foi possivel atualizar o Destino. Mensagem: " + e.getMessage());
	}
}		
		
		
		//UPDATE
		public void updateDestino(Destino destino) {
			sql = "UPDATE destino SET nomeDestino = ?, datasDestino = ?, precoDestino = ?, idUsuario = ? WHERE idDestino = ?";
			try (PreparedStatement stmt = connection.prepareStatement(sql)) {
				stmt.setString(1, destino.getNomeDestino());
				stmt.setString(2, destino.getDatasDestino());
				stmt.setString(3, destino.getPrecoDestino());
				stmt.setInt(4, destino.getUsuario().getIdUsuario());
				
				stmt.executeUpdate();
				System.out.println("Destino atualizado com sucesso\n" 
				+ "ID: " + destino.getIdDestino()
				+ "\nNome: " + destino.getNomeDestino());
			
				
			} catch (SQLException e) {
				System.out.println("Nao foi possivel atualizar o Destino." + "Mensagem: " + e.getMessage());
			}
		}
			
			//DELETE
			public void deleteDestino(int id) {
				sql = "DELETE FROM destino WHERE idDestino = ?";
				try (PreparedStatement stmt = connection.prepareStatement(sql)) {
					stmt.setInt(1, id);
					stmt.executeUpdate();
					
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			
		}
			
	}
		
		
