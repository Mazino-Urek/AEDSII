/*
 * Nome: Diego Da Silva Fereira
 * Matricula: 71 06 78 
 *
 * Questão 3: Faça um método recursivo que receba dois números inteiros e retorne a
 * multiplicação do primeiro pelo segundo fazendo somas
 * */

public class Exercicio_03{

	public static int rMultiplica (int a , int b){

		if(b > 1){
			a += rMultiplica(a, b - 1);
		}

		return a;				
	
	}



	public static void main (String[] args){
	
		int a = MyIO.readInt();
		int b = MyIO.readInt();

		a = rMultiplica(a , b);

		MyIO.println(a);
	
	}


}
