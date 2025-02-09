package main.java.notfind.find;

public class NotFind {
	
	public String removeSubstring(String input, String toRemove) {
        // Dividir toRemove com base em '&&'
        String[] terms = toRemove.split(" && ");
        
        // Aplicar cada termo de remoção sequencialmente
        for (String term : terms) {
            input = applyTerm(input, term.trim());
        }
        
        return input;
    }
	
	private String applyTerm(String input, String term) {
		switch (term) {
        case "\\d": return input.replaceAll("[0-9]", "");
        case "\\w": return input.replaceAll("[a-zA-Z0-9_]", "");
        case "\\s": return input.replaceAll("\\s+", "");
        case "\\l": return input.replaceAll("[a-z]", "");
        case "\\u": return input.replaceAll("[A-Z]", "");
        case "\\a": return input.replaceAll("[a-zA-Z]", "");
        default:
            return removeLiteralSubstring(input, term);
		}
    }
	
	private String removeLiteralSubstring(String input, String toRemove) {
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
