/*
 * Nome: Diego Da Silva Ferreira
 * Matricula: 71 06 78
 *
 * */

public class isjava {

	/*
	 * vreifica se um caractere é um numero
	 * @param char c - caractere a ser verificado
	 * @return - true caso o caractere seja um numero
	 * */
	public static boolean isNumero (char c){
	
		return (c >= '0' && c <= '9');
	}

	/*
	 * verifica se um caractere é uma letra
	 * @param char c - caractere a ser verificado
	 * @return boolean - true caso o caractere seja uma letra e false caso contrario
	 * */
	public static boolean isLetra (char c){
	
		return (tMinusculo(c) >= 'a' && tMinusculo(c) <= 'z');
	}//end isLetra



	/*
	 * verifica e transforma caracteres maiusculos em minusculos
	 * @param char x - caractere a ser verificado e transformado
	 * @return char x - retorna o cactere minusculo (exeto se ele não for letra)
	 * */
	public static char tMinusculo (char x){
		
		if(x >= 'A' && x <= 'Z'){
		
			return (char) (x + 32);
		}
		
		return x; 
	}//end tMinusculo


	/*
	 * verifica se o caractere é vogal
	 * @param char c - caractere a ser verificado
	 * @retun boolean - true caso o caractere seja vogal e false caso contrario
	 * */
	public static boolean isVogal(char c){

		return (tMinusculo(c) == 'a' ||
			tMinusculo(c) == 'e' ||
			tMinusculo(c) == 'i' ||
			tMinusculo(c) == 'o' ||
			tMinusculo(c) == 'u');
	
	}//end is vogal


	/*
	 * verifica se todos os caracteres de um frase são vogais
	 * @param String s - frase a ser verificada
	 * @return boolean resp - true caso todos os caracteres sejam vogais e false caso contrario
	 * */
	public static boolean isVogal(String s) {
	
		boolean resp = true;

		for(int x = 0; x < s.length(); x++){
		
			if(!isVogal(s.charAt(x))){

				resp = false;
				x = s.length();
			}
		}

		return resp;
	}//end isVogal


	/*
	 * verifica se todos os caracteres de uma frase são consoates
	 * @param String s - frase a ser verificada
	 * @return boolean resp - true caso todas os caracteres da frase sejão consoantes e false caso contrario
	 * */
	public static boolean isConsoante(String s){
	
		boolean resp = true;

		for(int x = 0; x < s.length(); x++){
			
			if(!(isLetra(s.charAt(x))) || (isVogal(s.charAt(x))) ){
			
				resp = false;
				x = s.length();
			}
		}

		return resp;
	
	
	}//end isConsoante


	/*
	 * verifica se uma string contem em numero interio
	 * @param String s - string a ser verificada
	 * @return boolean resp - true caso a string contenha um numero inteiro
	 * */
	public static boolean isInteiro (String s){
	
		boolean resp = true;

		for(int x = 0; x < s.length(); x++){
		
			if(!isNumero(s.charAt(x)) ){
			
				resp = false;
				x = s.length();
			}
		}

		return resp;
	
	}//end isInteiro


	/*
	 * verifica se uma String contem um numero real
	 * @param String s - string a ser verificada
	 * @return boolena resp - true caso a string contenha um numro real 
	 * */
	public static boolean isReal (String s){
	
		boolean resp = true;
		int h = 0;

		for(int x = 0; x < s.length(); x++){
	
			if((s.charAt(x) == ',') || (s.charAt(x) == '.')){
				h++; 
			}

			if((!isNumero(s.charAt(x)) && s.charAt(x) != ','  && s.charAt(x) != '.')
			    || !(h >= 0 && h <= 1) ){
			
				resp = false;
				x = s.length();
			}
		}

		return resp;
	
	}//end isReal




	public static void main (String[] args){


		String s = MyIO.readLine();
		
		//verifica se s é igual a "FIM"
		while(!(s.length() == 3 &&
			s.charAt(0) == 'F' &&
			s.charAt(1) == 'I' &&
			s.charAt(2) == 'M')){

			if(isVogal(s)){ MyIO.print("SIM");}
			else{MyIO.print("NAO");}

			if(isConsoante(s)){ MyIO.print(" SIM");}
			else{MyIO.print(" NAO");}
	
			if(isInteiro(s)){ MyIO.print(" SIM");}
			else{MyIO.print(" NAO");}		
				
			if(isReal(s)){ MyIO.println(" SIM");}
			else{MyIO.println(" NAO");}	
			
			s = MyIO.readLine();

		}
	}//end main
}
