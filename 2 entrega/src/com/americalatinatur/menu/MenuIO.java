package com.americalatinatur.menu;

import java.util.Scanner;


public class MenuIO {
	
	
	public static int menu(Scanner scanner) {
	System.out.println("Escolha uma opcao de 1 - 3\n" + "1 - Usuario\n" 
			+ "2 - Destino\n" 
			+ "3 - Sair\n");
	
	return scanner.nextInt();
	

}
}