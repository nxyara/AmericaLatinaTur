package com.americalatinatur.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.americalatinatur.model.Usuario;

public class UsuarioDAO {

	private static String sql;

	private final Connection connection;

	public UsuarioDAO(Connection connection) {
		this.connection = connection;
	}

	// CREATE
	public void createUsuario(Usuario usuario) {
		sql = "INSERT INTO usuario (nomeUsuario, cpfUsuario, enderecoUsuario, telefoneUsuario) VALUES (?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, usuario.getNomeUsuario());
			stmt.setString(2, usuario.getCpfUsuario());
			stmt.setString(3, usuario.getEnderecoUsuario());
			stmt.setString(4, usuario.getTelefoneUsuario());

			stmt.executeUpdate();
			System.out.println(
					"Usuario criado com sucesso: " + usuario.getNomeUsuario() + " e CPF: " + usuario.getCpfUsuario());
		} catch (SQLException e) {
			System.out.println("[LOG] Nao foi possivel criar o usuario. Mensagem: " + e.getMessage());
		}
	}

	// READ
	public void readAllClients() {
		sql = "SELECT * FROM usuario";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			
			ResultSet r = stmt.executeQuery();
			while (r.next()) {
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(r.getInt("idUsuario"));
				usuario.setNomeUsuario(r.getString("nomeUsuario"));
				usuario.setCpfUsuario(r.getString("cpfUsuario"));
				usuario.setEnderecoUsuario(r.getString("enderecoUsuario"));
				usuario.setTelefoneUsuario(r.getString("telefoneUsuario"));

				System.out.printf("ID: %d\n Nome: %s\n CPF: %s\n Endereco: %s\n Telefone: %s\n", usuario.getIdUsuario(),
						usuario.getNomeUsuario(), usuario.getCpfUsuario(), usuario.getEnderecoUsuario(),
						usuario.getTelefoneUsuario());

			}
			if (!r.next()) {
				System.out.println("NAO HA DADOS");
			}

		} catch (SQLException e) {
			System.out.println("[LOG]Nao foi possivel acessar as informacoes. Mensagem: " + e.getMessage());
		}
	}

	// UPDATE
	public void uptadeClient(Usuario usuario) {
		sql = "UPDATE usuario SET nomeUsuario = ?, cpfUsuario = ?, enderecoUsuario = ?, telefoneUsuario = ? WHERE = idUsuario = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, usuario.getNomeUsuario());
			stmt.setString(2, usuario.getCpfUsuario());
			stmt.setString(3, usuario.getEnderecoUsuario());
			stmt.setString(4, usuario.getTelefoneUsuario());
			stmt.setInt(5, usuario.getIdUsuario());

			stmt.executeUpdate();
			System.out.println(
					"Usuario atualizado com sucesso: " + usuario.getNomeUsuario() + "\nCPF: " + usuario.getCpfUsuario());

		} catch (SQLException e) {
			System.out.println("[LOG] Nao foi possivel atualizar o usuario." + e.getMessage());
		}
	}

	// DELETE
	public void deleteClient(int id) {
		sql = "DELETE FROM usuario WHERE idUsuario = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);

			stmt.executeUpdate();
			System.out.println("Usuario deletado com sucesso!");

		} catch (SQLException e) {
			System.out.println("Nao foi possivel deletar o usuario." + "Mensagem: " + e.getMessage());
		}
	}
}
