package main.java.notfind;

import java.util.Scanner;

import main.java.notfind.find.NotFind;

public class Main {
	
	public static void main(String[] args) {
		
		/* DICIONARIO
		 * \d representa caracteres digitos (numeros)
		 * \w representa qualquer caractere alfanumerico 
		 * \s representa qualquer espaço em branco
		 * \a representa as letras maisculas e minuculas
		 * \l representa as letras minusculas
		 * \\u representa as letras maiusculas */
		
		
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite a string principal: ");
		String input = scanner.nextLine();
		
		System.out.println("Digite a substring a ser removida: ");
		String toRemove = scanner.nextLine();
		
		NotFind finder = new NotFind();
		String result = finder.removeSubstring(input, toRemove);
		
		System.out.println("Resultado da remoção: " + result);
		
		scanner.close();
	}

}
