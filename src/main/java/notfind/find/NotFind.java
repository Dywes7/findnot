package main.java.notfind.find;

public class NotFind {
	
	public String removeSubstring(String input, String toRemove) {
		
		// Metacaractere \d
		if (toRemove.equals("\\d")) {		// Verica se toRemove é igual á '\d'
			
			// Usa método java e passa expressão regular [0-9] a ser substituida por "" na string input.
			return input.replaceAll("[0-9]", "");
		}
		
		// Metacaractere \w
		if (toRemove.equals("\\w")) {
			// Remove todos os caracteres alfanuméricos e sublinhados da string input
            return input.replaceAll("[a-zA-Z0-9_]", "");
		}
		
		// Metacaractere \s
		if (toRemove.equals("\\s")) {
            // Remove todos os espaços em branco da string input
            return input.replaceAll("\\s+", "");
        }
		
		 // Metacaractere \a para todas as letras (maiúsculas e minúsculas)
        if (toRemove.equals("\\a")) {
            return input.replaceAll("[a-zA-Z]", "");
        }

        // Metacaractere \l (letras minúsculas)
        if (toRemove.equals("\\l")) {
            return input.replaceAll("[a-z]", "");
        }
        
        // Metacaractere \\u  (letras maiúsculas)
        if (toRemove.equals("\\u")) {
            return input.replaceAll("[A-Z]", "");
        
        }
		
		
		
		// Inicializa start com a posição da primeira ocorrencia de 'toRemove' na String 'input'
		int start = input.indexOf(toRemove);
		
		// Loop em execução enquanto a substring 'toRemove' ainda existir na String 'input'
		while(start != -1) {
			
			/* 
			 *	Calcula a posição do fim da substring 'toRemove' dentro da String 'input' adicionando
			 *	o comprimento toRemove a posição inicial start	
			 */
			int end = start + toRemove.length();
			
			
			/*  Atualiza a string input, removendo a substring toRemove. Ela faz isso concatenando duas partes da 
			 * string input: de 0 até start (que exclui a substring toRemove) e de end até o final da string input 
			 * (que começa logo após o fim de toRemove) */
			input = input.substring(0, start) + input.substring(end);
			
			// Atualiza a variável 'start' com o incio da proxima ocorrencia de 'toRemove" na string 'input' atualizada.
			/* O segundo parâmetro do método indexOf especifica o índice a partir do qual a busca deve começar, o que evita 
			que o método verifique novamente a parte da string já analisada. 
			*/
			start = input.indexOf(toRemove, start);
		}
		// Quando a string 'toRemove' não for mais encontrada, retornar a String modificada
		return input;
	}

}
