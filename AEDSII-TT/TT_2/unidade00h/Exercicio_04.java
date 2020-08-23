/*
 * Nome: Diego Da Silva Ferreira
 * Matricula: 71 06 78
 *
 * Questão 04: Faça um método recursivo que receba um array de números inteiros e um
 * número inteiro n indicando o tamanho do array e retorne o maior elemento
 * */

import java.util.Random;

public class Exercicio_04{

	/*
	 * procura o maior elemento da array (recursivo)
	 * @param int a[] - array a ser vasculhado
	 * @param int b - posição verificada
	 * @param int c - posição do maior elemento
	 * @return int c - maior elemento da array
	 * */
	public static int maior(int a[] , int b, int c){

		if(b < a.length){
			if(a[b] > a[c]){
				c = b;
			}
			c = maior(a , b + 1, c);
		}
		else{
			c = a[c];
		}

		return c; 

	}

	/*
	 * chama a função recursiva maior
	 * @param int a[] - array a ser vasculhada
	 * @return int - maior elemento da array
	 * */
	public static int maior(int a[]){
		return maior(a, 0, 0);
	}

	public static void main (String[] args){

		int[] a = new int[10];
		Random ram = new Random();
		
		for(int s = 0; s < a.length; s++){
			a[s] = ram.nextInt(10);
			MyIO.print(a[s] + ", ");
		}

		MyIO.println("\n\n" + maior(a));
	}




}
