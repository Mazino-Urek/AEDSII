/*
 * Nome: Diego Da Silva Ferreira
 * Matricula: 71 06 78
 * */

#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <stdbool.h>
#include <string.h>

typedef struct No{

	int elemento;
	No *esq; 
	No *dir;
} No;

No* newNo(int elemento){

	No* resp = (No*) malloc(sizeof(No));
	resp->elemento = elemento;
	resp->dir = NULL;
	resp->esq = NULL;
	return resp;
}

No* raiz;
No** lista;
int tam;

void start(){
	raiz = NULL;
	lista = (No**) malloc(500 * sizeof(No*));
	tam = 0;
}

No* inserir(int elemento, No* no){
	if(no == NULL){
		no = newNo(elemento);
	}
	else{
		if(elemento > no->elemento){
			no->dir = inserir(elemento, no->dir);
		}
		else{
			no->esq = inserir(elemento, no->esq);
		}
	}
	return no;
}

void insert(int elemento){
	raiz = inserir(elemento, raiz);
}

void per(){

	int aux = tam;
	tam = 0;
	No** lista2 = (No**) malloc (500 * sizeof(No*));
	for(int i = 0; i < aux; i++){
		printf("%d " , lista[i]->elemento);
		if(lista[i]->esq != NULL){
			lista2[tam++] = lista[i]->esq;
		}
		if(lista[i]->dir != NULL){
			lista2[tam++] = lista[i]->dir;
		}
	}

	free(lista);
	lista = lista2;

	if(tam != 0){
		per();
	}
}

void percorre(){
	lista[0] = raiz;
	tam = 1;
	per();
}

int main (void){

	int i, cont, aux;
	scanf("%d", &i);
	
	for(int b = 1; b <= i; b++){
		start();
		scanf("%d", &cont);
		for(int a = 0; a <  cont; a++){		
			scanf("%d", &aux);
			insert(aux);	
		}
		printf("Case %d:\n", b);
		percorre();
		printf("\n");
		if(b != i){
		printf("\n");
			
		}
	}




	return 0;
}//end main
