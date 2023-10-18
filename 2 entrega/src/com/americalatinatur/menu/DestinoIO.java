package com.americalatinatur.menu;

import java.sql.Connection;
import java.util.Scanner;

import com.americalatinatur.dao.DestinoDAO;
import com.americalatinatur.database.DatabaseConnection;
import com.americalatinatur.model.Usuario;
import com.americalatinatur.model.Destino;

public class DestinoIO {
	
	
	static Connection connection = DatabaseConnection.createConnection();
	static DestinoDAO destinoDAO = new DestinoDAO(connection);
	
	public static int SubMenuDestino(Scanner scanner) {
		int option = Integer.MAX_VALUE;
		do {
			System.out.println("Menu Destino\n" + "1 - Cadastrar\n" + "2 - Listar\n" + "3 - Atualizar\n" + "4 - Deletar" + "\n0 - Sair");
			
			option = scanner.nextInt();
			switch (option) {
			case 1:
				scanner.nextLine();
				Destino destino = new Destino();
				Usuario usuarioDestino = new Usuario();
				destino.setUsuario(usuarioDestino);
				destinoDAO.createDestino(destino);
				
				
				System.out.println("Digite o nome do Destino: ");
				destino.setNomeDestino(scanner.nextLine().trim());
				
				System.out.println ("Digite data do Destino: ");
				destino.setDatasDestino(scanner.nextLine().trim());
				
				System.out.println("Preco: ");
				destino.setPrecoDestino(scanner.nextLine().trim());
				
				destinoDAO.createDestino(destino);
				
				break;
			case 2:
				destinoDAO.readAllDestino();
				break;
			case 3:
				Destino destinoAtualizado = new Destino();
				Usuario usuarioDestinoAtualizado = new Usuario();
				System.out.println("Digite o ID do Destino a ser atualizado: ");
				destinoAtualizado.setIdDestino(scanner.nextInt());
				scanner.nextLine();
				
				System.out.println("Digite o nome do Destino: ");
				destinoAtualizado.setNomeDestino(scanner.nextLine());
				
				System.out.println ("Digite a nova data: ");
				destinoAtualizado.setDatasDestino(scanner.nextLine());
				
				System.out.println ("Digite novo preco: ");
				destinoAtualizado.setPrecoDestino(scanner.nextLine());
				
				destinoDAO.updateDestino(destinoAtualizado);
				break;
			case 4:
				System.out.println("Digite o ID do Destino a ser Deletado");
				int idDestino = scanner.nextInt();
				destinoDAO.deleteDestino(idDestino);
				break;
		
			default:
				System.out.println("Digite uma opcao valida");

			}

		} while (option != 0);

			return option;

		}
		
	}
