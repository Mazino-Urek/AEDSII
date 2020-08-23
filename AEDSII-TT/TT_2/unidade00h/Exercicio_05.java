/*
 * Nome: Diego Da Silva Ferreira
 * Matricula: 71 06 78
 *
 * Questão 05 : Faça um método recursivo que receba um array de caracteres e retorne um
 * valor booleano indicando se esse é um palíndromo
 * */

public class Exercicio_05 {

	/*
	 * verifica se uma String é um palindromo
	 * @param String s - String a ser verificada
	 * @param int a - posição a ser verificada (unsada na recursividade)
	 * @return boolean resp - true caso a strig seja um palindromo
	 * */
	public static boolean pali(String s, int a ){
	
		boolean resp = true;

		if(a < (int) (s.length() / 2)){
		
			if(s.charAt(a) == s.charAt((s.length() - 1) - a)){
			
				resp = pali(s, a + 1);

			}
			else{
			
				return false;
			}
		}

		return resp;	
	}

	/*
	 * chama a função recursiva pali 
	 * @param String s - String a ser verificada
	 * @return boolean resp - true caso a strig seja um palindromo
	 * */
	public static boolean pali(String s){
	
		return pali(s , 0);
	}
	public static void main (String[] args){
	
		boolean x = true;
		String s = MyIO.readLine();

		//metodo para verificar se string é igual a "FIM"
		while(!(s.length() == 3 && 
			s.charAt(0) == 'F' && 
			s.charAt(1) == 'I' && 
			s.charAt(2) == 'M')){


			if(pali(s)){
				System.out.println("SIM");
			}
			else{
				System.out.println("NAO");
			}	

			s = MyIO.readLine();

		}
	}


}



