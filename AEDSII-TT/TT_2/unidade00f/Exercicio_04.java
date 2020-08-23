

/*
 * Nome: Diego Da Silva Ferreira
 * Matricula:
 *
 * Questão 4: Leia o nome de um arquivo e uma frase e salve essa frase
 * nesse arquivo
 * */

public class Exercicio_04 {

	public static void main(String[] args){
	
		String s = MyIO.readString();
		Arq.openWrite(s);

		s = MyIO.readLine();

		Arq.print(s);


		Arq.close();
	
	}




}
