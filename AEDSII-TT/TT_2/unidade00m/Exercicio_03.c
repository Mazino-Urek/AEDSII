/* 
 * Nome : Diego Da Silva Ferreira
 * Matricula : 71 06 78
 *
 * Questão 03 : Faça um programa que leia n números inteiros, armazene-os em um
 * arquivo, leia-os do arquivo e mostre-os na tela
 * */


#include <stdio.h>



int main (void){

	int n;
	int p = 0;
	scanf("%i" , &n);

	int x;

	FILE *arq = fopen("txt.txt" , "w");
	
	for(p = 0; p < n; p++){
	
		scanf("%i" , &x);
		fprintf(arq , "%i\n" , x);

	}

	fclose(arq);

	arq = fopen("txt.txt" , "r");
	
	for(p = 0; p < n; p++){
	
		fscanf(arq , "%i" , &x);
		printf( "%i\n" , x);

	}

	fclose(arq);

	




}
