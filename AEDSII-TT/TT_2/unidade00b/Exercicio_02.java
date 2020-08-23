/*
Repita o exercício acima considerando que os elementos do
array estão ordenados de forma crescente. Uma sugestão
seria começar a pesquisa pelo meio do array
*/


import java.util.Scanner;


public class Exercicio_02 {


public static boolean procuraArray (int[] array , int x){

	boolean resp = false;

	if(x >= array[0] && array[9] >= x){//verifica se a possibilidade do numero estar no Array
	
		for(int a = 0; a < 10; a++){//confirma a exestencia do numero no array
		
			if(array[a] == x){
			
				resp = true;
				a = 10;
			}
		}
	}

	return resp;

}


public static void main(String[] args){

	int[] array = new int[10];
	int x;
	Scanner in = new Scanner (System.in);

	for(int a = 1; a <= 10; a++){
		array[a - 1] = a;
	}

	System.out.println("Digite um valor inteiro a ser procurado: ");

	x = in.nextInt();

	System.out.println("Resposta: " + procuraArray(array , x));

}
}
