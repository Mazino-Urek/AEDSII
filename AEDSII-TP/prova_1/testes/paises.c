#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <time.h>


typedef struct{

	char* nome;
	int ouro;
	int prata;
	int cobre;
} Copa;


void print (Copa in){

	printf("%s %d %d %d\n", in.nome, in.ouro, in.prata, in.cobre);
}//end print










void main (void){

	int n;
	scanf("%d", &n);
	Copa *array = (Copa*) calloc (n, sizeof(Copa));


	for(int i = 0; i < n; i++){

		array[i].nome = (char*) calloc (100, sizeof(char));

		scanf("%s" , array[i].nome);
		scanf("%d" , &array[i].ouro);
		scanf("%d" , &array[i].prata);
		scanf("%d" , &array[i].cobre);
	}

	for(int i = 0; i < n; i++)
		print(array[i]);

}
















