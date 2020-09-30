/*
 * Nome Diego Da Silva Ferreria
 * Matricula 71 06 78
 *
 * */


#include <stdio.h>
#include <stdlib.h>



/*
 * ordena um array de inteiros
 * @param int *array - array a ser ordenado
 * @param int n - tamanho do array
 * */
void ordena (int *array, int n){

	int j , tmp;

	for(int i = 1; i < n; i++){


		tmp = array[i];
		j = i-1;

		while(j >= 0 && array[j] > tmp){
			array[j+1] = array[j];
			j--;
		}

		array[j+1] = tmp;
	}//end for
}//end ordena


int main(void){

	int *array;
	int n;

	while(scanf("%d" , &n) != EOF){

		array = (int*) calloc (n, sizeof(int));

		for(int i = 0; i < n; i++)
			scanf("%d" , &array[i]);

		ordena(array, n);

		for(int i = 0; i < n; i++)
			printf("%04d\n" , array[i]);

	}//end while
}//end main

