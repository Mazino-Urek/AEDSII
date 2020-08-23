/*
 * Nome: Diego DA Silva Ferreira
 * Matricula; 71 06 78
 *
 * Questão 06: Faça um método recursivo que receba um array de caracteres e retorne um
 * número inteiro indicando a quantidade de vogais do mesmo
 * */

public class Exercicio_06 {

	/*
	 * transforma letras maiusculas em minusculas
	 * @param char c - letra a ser tranfomada
	 * @return char c - letra convertida para minusculo(exeto quando não for letra)
	 * */
	public static char min (char c){
	
		if(c >= 'A' && c <= 'Z'){
			c = (char) (c + 32);
		}

		return c;
	}//end min

	/*
	 * verifica se um caractere é uma vogal
	 * @param char c - caractere a ser verificado
	 * @return boolean - true caso o caractere seja vogal
	 * */
	public static boolean isVogal(char c ){
		c = min(c);
		return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
	}//en isVogal
	

	/*
	 * conta a quantidade de vogais em um string (recursiva)
	 * @param String s - String a ser verificada
	 * @param int i - navega pela string (utilizado na recursividade)
	 * @return int resp - quantidade de vogais 
	 * */
	public static int contaVogal (String s, int i){
	
		int resp = 0;

		if(i < s.length()){
		
			if(isVogal(s.charAt(i))){
				resp = 1;
			}

			resp += contaVogal(s, i + 1);
		}
		return resp;

	}//end contaVogal


	/*
	 * chama a função recursiva contaVogal
	 * @param String s - String a ser verificada
	 * @return int - quantidade de vogais
	 * */
	public static int contaVogal(String s){
	
		return contaVogal(s , 0);
	}

	public static void main (String[] args){
	
		String s = MyIO.readLine();

		MyIO.println(contaVogal(s));
	}



}
