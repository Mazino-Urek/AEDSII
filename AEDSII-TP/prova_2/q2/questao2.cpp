/*
 * nome: diego da silva Ferreira
 * Turma: 71 06 78
 *
 * */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <time.h>
#include <math.h>

int *vagoes;

void start(int t){
	vagoes = (int*) calloc(t, sizeof(int));
}//end start

void inserir(int V, int quant){
	vagoes[V] += quant;
}//end inserir

int  distin (int a, int b, int c, int d){

	int resp = 0, aa;

	aa = a;
	for(int i = a; i <= b; i++)
		resp += vagoes[aa++];

	if(!(c < a && b < d)){
		if(c <= b){	
			b++;
			for(int i = b; i <= d; i++)
				resp += vagoes[b++];
		}
		else{	
			for(int i = c; i <= d; i++)
				resp += vagoes[c++];	
		}
	}
	else{
		resp = 0;
		for(int i = c; i <= d; i++){
			resp += vagoes[c++];
		}
	}
	return resp;
}//end distin

int  main (){
	int tamanho, repet;
	int aux1, aux2, aux3, aux4;

	scanf("%d" , &tamanho);
	scanf("%d" , &repet);

	start(tamanho);

	for(int i = 0; i < repet; i++){
		scanf("%d" , &aux1);

		if(aux1 == 1){
			scanf("%d" , &aux1);
			scanf("%d" , &aux2);
			inserir(aux1, aux2);	
		}
		else{		
			scanf("%d" , &aux1);
			scanf("%d" , &aux2);
			scanf("%d" , &aux3);
			scanf("%d" , &aux4);

			printf("%d\n", distin(aux1, aux2, aux3, aux4));	
		}//end 
	}//end for
}//end main
