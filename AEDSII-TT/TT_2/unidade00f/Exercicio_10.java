/*
 * Nome: Diego Da Silva Ferreira
 * Matricula: 71 06 78
 *
 * Questão 10: Leia o nome de um arquivo e mostre na tela o conteúdo
 * desse arquivo criptografado usando o ciframento de César
 * (k = 3) 
 * */

public class Exercicio_10 {

	/*
	 * avança todos os caracteres de uma String em 3 posições na tabela ascii
	 * @param String s - frase a ser criptografada
	 * @return String resp - frase criptografada
	 */
	public static String cezar (String s){

		String resp = "";

		for(int x = 0; x < s.length(); x++){

			resp += (char) (s.charAt(x) + 3);
		}

		return resp;
	}


	public static void main(String[] args){

		String s = MyIO.readString();

		Arq.openRead(s);

		while(Arq.hasNext()){

			s += Arq.readLine();
			s += "\n";
		}
		Arq.close();

		s = cezar(s);

		MyIO.println(s);

	}
}
