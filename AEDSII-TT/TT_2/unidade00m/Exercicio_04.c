/*
 * Nome: Diego Da Silva Ferreira
 * Matricula: 71 06 78
 *
 * questão: Faça um programa que leia n números inteiros e os mostre em ordem
 * inversa sem usar arrays
 * */

#include <stdio.h>

/*
 * função recursiva para printar numeros ao contrario
 * @param int n - numero de termos a serem lidos
 * */
void print(int n){

	int x;

	if(n > 0){
	
		scanf("%i" , &x );
		print(n - 1);
		printf("%i\n" , x);

	}
}




int main (void){

	int x;
	scanf("%i" , &x);
	print(x);



}












































