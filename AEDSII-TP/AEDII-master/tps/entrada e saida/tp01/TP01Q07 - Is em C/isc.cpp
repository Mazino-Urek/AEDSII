/*
 * Nome: Diego Da Silva Ferreira
 * Matricula: 71 06 78
 *
 * */

#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>


        /*
         * verifica e transforma caracteres maiusculos em minusculos
         * @param char x - caractere a ser verificado e transformado
         * @return char x - retorna o cactere minusculo (exeto se ele não for letra)
         * */
        char tMinusculo (char x){

                if(x >= 'A' && x <= 'Z'){

                        return (char) (x + 32);
                }

                return x;
        }//end tMinusculo





	/*
	 * verifica se um caractere é um numero
	 * @param char c - caractere a ser verificado
	 * @return bool - true caso o caractere seja um numero
	 * */
	bool isNumero (char c){
	
		return (c >= '0' && c <= '9');
	}

	/*
	 * verifica se um caractere é uma letra
	 * @param char c - caractere a ser verificado
	 * @return bool - true caso o caractere seja uma letra e false caso contrario
	 * */
	bool isLetra (char c){
	
		return (tMinusculo(c) >= 'a' && tMinusculo(c) <= 'z');
	}//end isLetra




	/*
	 * verifica se o caractere é vogal
	 * @param char c - caractere a ser verificado
	 * @retun bool - true caso o caractere seja vogal e false caso contrario
	 * */
	bool isVogal(char c){

		return (tMinusculo(c) == 'a' ||
			tMinusculo(c) == 'e' ||
			tMinusculo(c) == 'i' ||
			tMinusculo(c) == 'o' ||
			tMinusculo(c) == 'u');
	
	}//end is vogal


	/*
	 * verifica se todos os caracteres de um frase são vogais
	 * @param char *s - frase a ser verificada
	 * @return bool resp - true caso todos os caracteres sejam vogais e false caso contrario
	 * */
	bool isVogal01(char *s) {
	
		bool resp = true;

		for(int x = 0; x < strlen(s); x++){
		
			if(!isVogal(s[x])){

				resp = false;
				x = strlen(s);
			}
		}

		return resp;
	}//end isVogal


	/*
	 * verifica se todos os caracteres de uma frase são consoates
	 * @param char *s - frase a ser verificada
	 * @return bool resp - true caso todas os caracteres da frase sejão consoantes e false caso contrario
	 * */
	bool isConsoante(char *s){
	
		bool resp = true;

		for(int x = 0; x < strlen(s); x++){
			
			if(!(isLetra(s[x])) || (isVogal(s[x])) ){
			
				resp = false;
				x = strlen(s);
			}
		}

		return resp;
	
	
	}//end isConsoante


	/*
	 * verifica se uma cadeia de caracteres contem em numero interio
	 * @param char *s - xadeia de caracteres a ser verificada a ser verificada
	 * @return bool resp - true caso a string contenha um numero inteiro
	 * */
	bool isInteiro (char *s){
	
		bool resp = true;

		for(int x = 0; x < strlen(s); x++){
		
			if(!isNumero(s[x]) ){
			
				resp = false;
				x = strlen(s);
			}
		}

		return resp;
	
	}//end isInteiro


	/*
	 * verifica se uma cadeia de caracteres contem um numero real
	 * @param cahr *s - cadeia de caracteres a ser verificada
	 * @return bool resp - true caso a cadeia de caracteres contenha um numro real 
	 * */
	bool isReal (char *s){
	
		bool resp = true;
		int h = 0;

		for(int x = 0; x < strlen(s); x++){
	
			if((s[x] == ',') || (s[x] == '.')){
				h++; 
			}

			if((!isNumero(s[x]) && s[x] != ','  && s[x] != '.')
			    || !(h >= 0 && h <= 1) ){
			
				resp = false;
				x = strlen(s);
			}
		}

		return resp;
	
	}//end isReal




	int main (void){


		char *s = (char*) calloc (502 , sizeof(char)) ;
		s[501] = '\0';
		fgets(s , 500 , stdin);
		s[strlen(s) - 1] = '\0';
		
		//verifica se s é igual a "FIM"
		while(!(strlen(s) == 3 &&
			s[0] == 'F' &&
			s[1] == 'I' &&
			s[2] == 'M')){

			if(isVogal01(s)){ printf("SIM");}
			else{printf("NAO");}

			if(isConsoante(s)){ printf(" SIM");}
			else{printf(" NAO");}
	
			if(isInteiro(s)){ printf(" SIM");}
			else{printf(" NAO");}		
				
			if(isReal(s)){ printf(" SIM\n");}
			else{printf(" NAO\n");}	
			
			fgets(s , 500 , stdin);
			s[strlen(s) - 1] = '\0';
		}
	}//end main

