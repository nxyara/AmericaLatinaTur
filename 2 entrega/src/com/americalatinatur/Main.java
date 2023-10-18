package com.americalatinatur;

import java.util.Scanner;
import com.americalatinatur.menu.MenuIO;
import com.americalatinatur.menu.UsuarioIO;
import com.americalatinatur.menu.DestinoIO;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
				
		
		int option = 0;

		do {

			option = MenuIO.menu(scanner);

			switch (option) {
			case 1:
				UsuarioIO.SubMenuUsuario(scanner);
				break;
			case 2:
				DestinoIO.SubMenuDestino(scanner);
				break;
			default:
				System.out.println("Digite uma opcao valida!");
						
				}
			} while (option != 5);
				scanner.close();
		}
}
