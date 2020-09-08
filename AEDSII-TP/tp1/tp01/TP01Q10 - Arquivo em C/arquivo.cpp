/*
 * Nome : Diego Da Silva Ferreira
 * Matricula : 71 06 78
 *
 * */

#include <stdio.h>
#include <stdlib.h>

int main (void){

	int n , x;
	double aux;
	scanf("%d" , &n);

	FILE* arq = fopen("novoarq.txt" , "wb");

	for(x = 0; x < n; x++ ){
	
		scanf("%lf" , &aux);
		fwrite( &aux , sizeof(double) , 1 , arq);
	}

	fclose(arq);

	arq = fopen("novoarq.txt" , "rw");

	for(x = 1; x <= n; x++){
	
		//mecanismo para ler o arquivo ao contrario
		fseek(arq , -(x  *  sizeof(double)) , SEEK_END );

		fread( &aux , sizeof(double) , 1 , arq );
		printf( "%g\n" , aux );		
	}

	fclose(arq);
}
