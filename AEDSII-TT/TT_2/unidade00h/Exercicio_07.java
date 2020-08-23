/*
 * Nome: Diego DA Silva Ferreira
 * Matricula; 71 06 78
 *
 * Faça um método recursivo que receba um string e retorne um número
 * inteiro indicando a quantidade de caracteres NOT vogal AND NOT
 * consoante maiúscula da string recebida como parâmetro
 *
 * */

public class Exercicio_07 {

	/*
	 * verifica se um caractere é uma letra maiuscula
	 * @param char c - caractere a ser verificado
	 * @return boolean - true caso seja um letra seja maiuscula
	 * */
	public static boolean isLetraMaiuscula(char c){
	
		return (c >= 'A' && c <= 'Z');
	}

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
	 * conta a quantidade de naõ vogais e não maiusculas em um string (recursiva)
	 * @param String s - String a ser verificada
	 * @param int i - navega pela string (utilizado na recursividade)
	 * @return int resp - quantidade de não vogais e não letras maiusculas
	 * */
	public static int contaNvNmm (String s, int i){
	
		int resp = 0;

		if(i < s.length()){
		
			if(!isVogal(s.charAt(i)) && !isLetraMaiuscula(s.charAt(i)) ){
				resp = 1;
			}

			resp += contaNvNmm(s, i + 1);
		}
		return resp;

	}//end contaNvNmm


	/*
	 * chama a função recursiva contaNvNmm
	 * @param String s - String a ser verificada
	 * @return int - quantidade de não vogais e não letra maiusculas
	 * */
	public static int contaNvNmm(String s){
	
		return contaNvNmm(s , 0);
	}

	public static void main (String[] args){
	
		String s = MyIO.readLine();

		MyIO.println(contaNvNmm(s));
	}



}
