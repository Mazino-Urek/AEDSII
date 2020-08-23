/*
Repita o exercício acima fazendo menos comparações com
os elementos do array
*/


import java.util.Random;

public class Exercicio_04{

public static void mostraMaiorMenor (int[] array){

	int menor = array[0] , maior = array[0];

	for(int x = 1; x < array.length; x++){
		if(menor > array[x]){//procura o menor
			menor = array[x];
		}
		else{//diminui o numero de comparações.
			if(maior < array[x]){//procura o maior
				maior = array[x];
			}
		}
	}

	
	System.out.println("\nmaior: " + maior + "\nmenor: " + menor);
} 

public static void main (String[] args){

	int[] array = new int[10];
	int[] resp  = new int[2];
	Random ram  = new Random();
	
	System.out.print("arranjo gerrado: ");
	for(int s = 0; s < 10; s++){
	
		array[s] = ram.nextInt(100);//gera numero aleatorios de 0 a 100
		System.out.print(array[s] + ", ");//mostra numeros gerados na tela
	
	}

	mostraMaiorMenor(array);


}

}

