/*
 *Nome: Diego Da Silva Ferreira
 *Matricula: 71 06 78
 * */

import java.util.Random;

public class aleatorio{

	/*
	 *compara e substitui caracteres de um frase
	 *@param String s - frase a ser manipulada
	 *@param char a - caractere a ser substituido
	 *@param char b - caractere substituto
	 *@return resp - frase manipulada
	 */
	public static String altera (String s , char a, char b){

		String resp = "";	

		for(int x = 0; x < s.length(); x++){
			if(s.charAt(x) == a){
				resp += b;
			}
			else{
				resp += s.charAt(x);
			}
		}
		
		return resp;

	}


	public static void main(String[] args){

		String s = MyIO.readLine();
		Random ram = new Random();
		ram.setSeed(4);

		//verifica se s é igual a "FIM"
		while(!(s.length() == 3 && 
			s.charAt(0) == 'F' && 
			s.charAt(1) == 'I' && 
			s.charAt(2) == 'M')){

			MyIO.println(altera(s ,
					   ((char) ('a' + (Math.abs(ram.nextInt()) % 26))) , 
					   ((char) ('a' + (Math.abs(ram.nextInt()) % 26)))));

			s = MyIO.readLine();

		}

	}
}
