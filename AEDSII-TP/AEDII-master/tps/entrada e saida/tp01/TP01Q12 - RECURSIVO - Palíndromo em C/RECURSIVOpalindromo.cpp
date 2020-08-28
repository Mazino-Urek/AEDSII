/*
 * Nome : Diego Da Silva Ferreira
 * Matricula : 71 06 78
 * 
 * */

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>


/*
 * verifica se uma cadeia de caracteres é um palindromo
 * @param char *s - cadeia de caracteres a ser verificada
 * @param int cabecote - percorre a cadeia a de caracteres (utilizada na recursividade)
 * @return bool resp - true caso a cadeia de caracteres seja um palindromo
 * */
bool isPalindromo (char *s, int cabecote) {

	bool resp = true;

	if(cabecote < (int)(strlen(s) / 2)){
	
		if(s[cabecote] == s[ (strlen(s) - 1) - cabecote] ){
		
			resp = isPalindromo(s , cabecote + 1);
		}
		else{
		
			resp = false;
		}
	}//end if

	return resp;

}//end isPalindromo


int main(void){

	char *s = (char *) calloc (1001 , sizeof (char));

	s[1000] = '\0';
	fgets (s , 999 , stdin);
	s[strlen(s) - 1] = '\0';

	while(strcmp( s , "FIM") != 0){

		if(isPalindromo(s , 0)){
			printf("SIM\n");
		}
		else{
			printf("NAO\n");
		}

		fgets(s , 999, stdin);
		s[strlen(s) - 1] = '\0';

	}//end while

	return 0;
}//end main
