/*
 * Nome: Diego Da Silva Fereira
 * Matricula: 71 06 78
 *
 * Questão 5 : Leia o nome de um arquivo e mostre seu conteúdo na tela
 * */

public class Exercicio_05 {

	public static void main(String[] args){
	
		String s = MyIO.readString();

		Arq.openRead(s);

		while(Arq.hasNext()){

			MyIO.println(Arq.readLine());
	
		}
		Arq.close();
	
	}
}
