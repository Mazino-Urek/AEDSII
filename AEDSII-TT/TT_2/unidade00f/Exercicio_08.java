/*
 * Nome : Diego Da Silva Ferreria
 * Matricula: 71 06 78
 *
 * Questão 8: Leia o nome de dois arquivos, abra o primeiro, converta seu
 * conteúdo para letra maiúscula e salve o no segundo
 * 
 * */

public class Exercicio_08 {

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

		s = converte(s);

		Arq.openWrite(ss);

		Arq.print(s);

		Arq.close();

	}
}



