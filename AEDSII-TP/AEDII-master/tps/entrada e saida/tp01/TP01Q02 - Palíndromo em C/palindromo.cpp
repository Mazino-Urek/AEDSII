#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

/*
 * verifica se a cadeia de caracteres é um palindromo
 * @param char *s - cadeia de caracteres a ser verificada
 * @return bool resp - retorna true se palindromo e false caso contrario
 */
bool teste (char *s){
	
	bool resp = true;
	int a = strlen(s) - 1;
	int x = 0;

	for(; x < a ; x++){
		if(s[x] != s[a]){
			resp = false;
			x = a;
		}
		a--;
	}

	return resp;
}


int main (void){

	char *s = (char *) calloc (1001 , sizeof (char));
	
	s[1000] = '\0';
	fgets (s , 999 , stdin);
	s[strlen(s) - 1] = '\0';

	while(strcmp( s , "FIM") != 0){

		if(teste(s)){
			printf("SIM\n");
		}
		else{
			printf("NAO\n");
		}
		
		fgets(s , 999, stdin);
		s[strlen(s) - 1] = '\0';

	}
}


