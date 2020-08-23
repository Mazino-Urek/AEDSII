/*
 * Nome: Diego Da Silva Ferreria
 * Matricula: 71 06 78
 *
 * Questão 6: Leia o nome de um arquivo e mostre seu conteúdo convertido
 * para letras maiúsculas
 * */


public class Exercicio_06 {

	/*
	 * converte letras minusculas presentes em uma string em maiusculas
	 * @param String s - String a ser convertida
	 * @return String resp - String convertida
	 * */
	public static String converte (String s){
	
		String resp = "";

		for(int a = 0; a < s.length(); a++){

			if(s.charAt(a) >= 'a' && s.charAt(a) <= 'z'){
			
				resp += (char) (s.charAt(a) - 32);
			}		
			else{
			
				resp += s.charAt(a);
			}
		
		}
		return resp;
	
	}

	public static void main (String[] args){
	
		String s = MyIO.readString();

		Arq.openRead(s);

		s = "";
		while(Arq.hasNext()){
		
			s += Arq.readLine();
			s += "\n";
			
		}

		s = converte(s);

		MyIO.print(s);

		Arq.close();


	}


}

