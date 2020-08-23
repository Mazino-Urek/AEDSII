/*
Faça um método que receba um array de inteiros e um
número inteiro x e retorne um valor booleano informando se o
elemento x está contido no array
*/

import java.util.Scanner;

public class Exercicio_01 {


	public static boolean verificaArray (int[] x , int numero) {
	
		boolean resp = false;

		for(int s = 0; s < 10; s++){
			if(x[s] == numero){
				resp = true;
				s = 10;
			}
		}
	
		return resp;
	}


	public static void main(String[] args){

		int[] x = new int[10];
		int numero;
		Scanner in = new Scanner (System.in);

		
		for(int b = 0; b < 10; b++){
			
			System.out.println("digite um numero inteiro: ");
			x[b] = in.nextInt();
		}

		System.out.println("digite um numero inteiro a ser procurado no array: ");
		numero = in.nextInt();

		System.out.println("Resposta:  " + verificaArray(x, numero));


	}







}
