package com.americalatinatur.menu;

import java.sql.Connection;
import java.util.Scanner;

import com.americalatinatur.dao.UsuarioDAO;
import com.americalatinatur.database.DatabaseConnection;
import com.americalatinatur.model.Usuario;

public class UsuarioIO {

	static Connection connection = DatabaseConnection.createConnection();
	static UsuarioDAO usuarioDAO = new UsuarioDAO(connection);

	public static int SubMenuUsuario(Scanner scanner) {
		int option = Integer.MAX_VALUE;
		do {
			System.out.println("MENU USUARIO\n" + "1 - Cadastrar\n" + "2 - Listar\n"
			+ "3 - Atualizar\n" 
			+ "4 - Deletar\n"
			+ "0 - Sair");
			
			option = scanner.nextInt();
			switch (option) {
			case 1:
				scanner.nextLine();
				Usuario usuario = new Usuario();
				System.out.println("Nome completo: ");
				usuario.setNomeUsuario(scanner.nextLine());
				System.out.println("CPF: ");
				usuario.setCpfUsuario(scanner.nextLine().trim());
				System.out.println("Endereco: ");
				usuario.setEnderecoUsuario(scanner.nextLine());
				System.out.println("Telefone: ");
				usuario.setTelefoneUsuario(scanner.next().trim());

				usuarioDAO.createUsuario(usuario);
				break;
			case 2:
				usuarioDAO.readAllClients();
				break;
			case 3:
				Usuario usuarioAtualizado = new Usuario();
				System.out.println("Digite o ID do usuario a ser atualizado: ");
				usuarioAtualizado.setIdUsuario(scanner.nextInt());
				scanner.nextLine();
				System.out.println("Nome completo: ");
				usuarioAtualizado.setNomeUsuario(scanner.nextLine());
				System.out.println("CPF: ");
				usuarioAtualizado.setCpfUsuario(scanner.nextLine().trim());
				System.out.println("Endereco: ");
				usuarioAtualizado.setEnderecoUsuario(scanner.nextLine());
				System.out.println("Telefone: ");
				usuarioAtualizado.setTelefoneUsuario(scanner.next().trim());

				usuarioDAO.uptadeClient(usuarioAtualizado);
				break;
			case 4:
				System.out.println("Digite o ID do Usuario a ser Deletado");
				int idUsuario = scanner.nextInt();
				usuarioDAO.deleteClient(idUsuario);
			default:
				System.out.println("Digite uma opcao valida.");
			}

		} while (option != 0);

			return scanner.nextInt();		
			}
	}
	
	
