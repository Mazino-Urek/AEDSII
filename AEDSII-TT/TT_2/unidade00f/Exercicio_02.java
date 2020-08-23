/*
 * Nome: Diego Da Silva Ferreria
 * Matricula: 71 06 78
 *
 * questão 2: Faça um programa que abre um arquivo e cria uma cópia
 * */

public class Exercicio_02 {


	public static void copia (String s){
	
		String copia = "";
		Arq.openRead(s);

		while(Arq.hasNext()){
			copia += Arq.readLine();
			copia += "\n";		
		}

		Arq.close();
		Arq.openWrite("copia.txt");

		Arq.print(copia);

		Arq.close();
	
	}

	public static void main(String[] args){
	
		copia(MyIO.readString());

	
	
	}

}

