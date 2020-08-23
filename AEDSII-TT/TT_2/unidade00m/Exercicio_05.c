/*
 * Nome : Diego Da Silva Ferreira
 * Matricula : 71 06 78
 *
 * Faça um programa que leia n números inteiros e os mostre a soma do
 * primeiro e último, segundo e penúltimo e assim sucessivamente.
 * Novamente, sem usar arrays
 * */

#include <stdio.h>
#include <stdlib.h>

int main (void){

	int n , z , x , c;
	scanf("%i" , &n);

	FILE* arq = fopen("txtxtt.txt" , "wb");

	for(z = 0; z < n; z++){
	
		scanf("%i" , &x);
		fwrite(&x, sizeof (int), 1, arq);	
	}

	fclose(arq);
	arq = fopen("txtxtt.txt" , "rb");

	for(z = 0; z < n / 2; z++){
	
		fseek(arq , z * sizeof(int) , SEEK_SET);
		fread(&x, sizeof (int), 1, arq);	

		fseek(arq , -((z + 1) * sizeof(int)) , SEEK_END);
		fread(&c, sizeof (int), 1, arq);

		printf("%i + %i = %i\n\n" ,c , x , c + x);

	}

	fclose(arq);

	return 0;
}
