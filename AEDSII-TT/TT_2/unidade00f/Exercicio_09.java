/*
 * Nome : Diego Da Silva Ferreria
 * Matricula: 71 06 78
 *
 * Questão 8: Leia o nome de dois arquivos e copie o conteúdo do primeiro
 * para o segundo invertendo a ordem dos caracteres. O último
 * caractere no arquivo de entrada será o primeiro do de saída, o
 * penúltimo caractere será o segundo, ...
 * 
 * */

public class Exercicio_09{

	/*
	 * inverte uma String (recursivo)
	 * @param String s - String a ser convertida
	 * @param String resp - string convertida (utilizada na recursividadde)
	 * @param int i - utilizado para percorrerr a String recursivamente
	 * @return String resp - String convertida
	 * */
	public static String inverte(String s, String resp, int i){
	
		if(s.length() > i){
			
			resp += inverte(s , resp , i + 1);
			resp += s.charAt(i);
		}

		return resp;


	}

	/*
	 * chama função recursiva inverte
	 * @param String s - String a ser invertida
	 * @return String - String invertida
	 * */
	public static String inverte (String s){
		return inverte(s , "", 0);
	}

	public static void main(String[] args){

		String s, ss;

		s = MyIO.readString();
		ss = MyIO.readString();

		Arq.openRead(s);

		s = "";
		while(Arq.hasNext()){

			s += Arq.readLine();
			s += "\n";

		}

		Arq.close();

		s = inverte(s);

		Arq.openWrite(ss);

		Arq.print(s);

		Arq.close();

	}
}



