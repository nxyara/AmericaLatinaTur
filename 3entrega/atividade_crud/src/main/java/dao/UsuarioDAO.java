package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;

@SuppressWarnings("unused")
public class UsuarioDAO {

	private String sql;

	private Connection connection;

	public UsuarioDAO(Connection connection) {
		this.connection = connection;
	}
	
	public UsuarioDAO() throws SQLException {
        connection = database.databaseConnection.createConnection();
  
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




//	public UsuarioDAO() {
//	
//		// TODO Auto-generated constructor stub
//	}



	// CREATE
	public void createUsuario(Usuario usuario) {
		sql = "INSERT INTO usuario (nome, login, senha, dataNasc) VALUES (?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, usuario.getNomeUsuario());
			stmt.setString(2, usuario.getLogin());
			stmt.setString(3, usuario.getSenha());
			Date data = Date.valueOf(usuario.getDataNasc());
			stmt.setDate(4, data);

			stmt.executeUpdate();
			System.out.println(
					"Usuario criado com sucesso!");
		} catch (SQLException e) {
			System.out.println("[LOG] Nao foi possivel criar o usuario. Mensagem: " + e.getMessage());
			e.printStackTrace();
		}
	}

	
	// READ
	public Usuario findClient (int id) {
		Usuario usuario = null;
		sql = "SELECT * FROM usuario WHERE id=?";
		
	
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			
			stmt.setInt(1, id);
			ResultSet r = stmt.executeQuery();
			
			if(r.next()) {
				usuario = new Usuario();
				usuario.setIdUsuario(r.getInt("id"));
				usuario.setNomeUsuario("nome");
				usuario.setLogin("login");
				usuario.setSenha("senha");
				usuario.setDataNasc(r.getDate("dataNasc").toLocalDate());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}

	public List<Usuario> findClients() {
		String sql = "SELECT * FROM usuario";
		
		List<Usuario> clients = new ArrayList<Usuario>();
		
		ResultSet r = null;
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			r = stmt.executeQuery();
			
		while(r.next()) {
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(r.getInt("id"));
				usuario.setNomeUsuario("nome");
				usuario.setLogin("login");
				usuario.setSenha("senha");
				usuario.setDataNasc(r.getDate("dataNasc").toLocalDate());
				clients.add(usuario);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clients;
	}
	
	
	
	// UPDATE
	public void updateUsuario(Usuario usuario) {
		sql = "UPDATE usuario SET id = ?, nome = ?, login = ?, dataNasc = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, usuario.getNomeUsuario());
			stmt.setString(2, usuario.getLogin());
			stmt.setString(3, usuario.getSenha());
			Date sqlDate = Date.valueOf(usuario.getDataNasc());
			stmt.setDate(4, sqlDate);
			stmt.setInt(5, usuario.getIdUsuario());
			
			stmt.executeUpdate();
			System.out.println(
					"Usuario atualizado com sucesso: " + usuario.getIdUsuario() + usuario.getNomeUsuario());

		} catch (SQLException e) {
			System.out.println("[LOG] Nao foi possivel atualizar o usuario." + e.getMessage());
			e.printStackTrace();
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
			e.printStackTrace();
		}
	}
}


