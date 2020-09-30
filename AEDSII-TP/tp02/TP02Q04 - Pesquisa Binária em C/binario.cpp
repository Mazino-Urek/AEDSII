/*
 * Nome: Diego Da Silva Ferreira
 * Matricula: 71 06 78
 *
 * V 1.1
 *
 * */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <time.h>

/*difinindo o tipo Jogador*/
typedef struct {

	int id;
	char *nome;
	int altura;
	int peso;
	char *universidade;
	int anoNascimento;
	char *cidadeNascimento;
	char *estadoNascimento;
} Jogador;

/*
 * seta os valores de um jogador
 * @param int id - valor do atributo id
 * @param char *nome - valor do atributo nome
 * @param int altura - valor do atributo altura
 * @param int peso - valor do atributo peso
 * @param char *universidade - valor do universidade
 * @param int anoNascimento - valor do atributo anoNacimento
 * @param char *cidadeNascimento - valor do atributo cidadeNascimetno
 * @param char * estadoNascimneto - valor do atributo estadoNascimento
 * @return Jogador resp - jogador com atributos setados
 * */
Jogador set (int id, char *nome, int altura, int peso,
	     char *universidade , int anoNascimento,
	     char *cidadeNascimento, char *estadoNascimento) {

	Jogador resp;

	resp.id = id;
	resp.nome = nome;
	resp.altura = altura;
	resp.peso = peso;
	resp.universidade = universidade;
	resp.anoNascimento = anoNascimento;
	resp.cidadeNascimento = cidadeNascimento;
	resp.estadoNascimento = estadoNascimento;

	return resp;
}//end set


/*
 * le os atributos de Jogador de um arquivo .csv 
 * @param char* fileName - nome do arquivo a ser lido
 * @return Jogador resp - array de jogaorres com artributos lidos do arquivo
 * */
Jogador *ler (char *fileName){

	char string[150];
	Jogador *resp;
	string[149] = '\0';
	char *aux1 , *aux2 , *aux3;
	int n = 0;

	
	FILE* arq = fopen(fileName, "r");

	/*metodo da saber o tamnho do arquivo*/
	while(fgets(string, 148 , arq) != NULL)
		n++;

	resp =(Jogador *) calloc (n-1 , sizeof(Jogador));

	fseek(arq, 0 , SEEK_SET);
	fgets(string, 148, arq);

	/*medodo de leitura do aquivo*/
	for(int i = 0; i < n - 1; i++ ){
	
		fgets(string, 148, arq);
		string[strlen(string) - 1] = ',';
		aux1 = strdup(string);

		aux2 = strsep(&aux1, ",");

		if(strlen(aux2) != 0)
			resp[i].id = atoi(aux2);
		else
			resp[i].id = -1;
	
		aux2 = strsep(&aux1, ",");

		if(strlen(aux2) != 0)
			resp[i].nome = aux2;
		else
			resp[i].nome = strdup("nao informado");
	

		aux2 = strsep(&aux1 , ",");

		if(strlen(aux2) != 0)
			resp[i].altura = atoi(aux2);
		else
			resp[i].altura = -1;

		aux2 = strsep(&aux1 , ",");

		if(strlen(aux2) != 0)
			resp[i].peso = atoi(aux2);
		else
			resp[i].peso = -1;
	
		
		aux2 = strsep(&aux1 , ",");

		if(strlen(aux2) != 0)
			resp[i].universidade = aux2;
		else
			resp[i].universidade = strdup("nao informado");
	
		aux2 = strsep(&aux1 , ",");

		if(strlen(aux2) != 0)
			resp[i].anoNascimento = atoi(aux2);
		else
			resp[i].anoNascimento = -1;
	
		aux2 = strsep(&aux1 , ",");

		if(strlen(aux2) != 0)
			resp[i].cidadeNascimento = aux2;
		else
			resp[i].cidadeNascimento = strdup("nao informado");
	
		aux2 = strsep(&aux1 , ",");

		if(strlen(aux2) != 0)
			resp[i].estadoNascimento = aux2;
		else
			resp[i].estadoNascimento = strdup("nao informado");
				
	}//end for

	fclose(arq);
	
	return resp;
}//end ler

/*
 * printa os atributos de um Jogador
 * @param Jogador in - jogador a ter seus atributos printados
 * */
void imprimir (Jogador in) {

	printf("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]\n" , 
		in.id,
		in.nome,
		in.altura,
		in.peso,
		in.anoNascimento,
		in.universidade,
		in.cidadeNascimento,
		in.estadoNascimento);
}//end imprimir


//contador de comparações
int nComparacao = 0;

/*
 * ordena um array de Jogadores pelo nome
 * @param Jogador *novo - array a ser ordenado
 * @param int n - tamanho do array
 * */
void ordena (Jogador *novo, int n){

	Jogador tmp;
	int j;

	for(int i = 1; i < n; i++){

		tmp = novo[i];
		j = i - 1;

		nComparacao++;
		while((j>= 0) && (strcmp(novo[j].nome, tmp.nome) > 0 )){
			
			nComparacao++;

			novo[j + 1] = novo[j];
			j--;
		}//end while

		novo[j+1] = tmp;
	}//end for


}//end ordena


/*
 * pesquisa se existe um nome em um array de Jogador
 * @param Jogador *novo - aray de jogadores a ser realizada a pesquisa
 * @param char[] nome - nome a ser procurado
 * @param int dir - tamanho do array;
 * @return bool resp - true caso o nome exista no array
 * */
bool pesquisaBinaria (Jogador *novo, char nome[], int dir){
	
	dir--;
	int esq = 0, pivo;
	bool resp = false;

	while(esq <= dir && !resp){

		pivo = (dir + esq) / 2;
		
		nComparacao++;
		if(strcmp(novo[pivo].nome, nome) == 0){

			resp = true;
			esq = dir + 1;
		}
		else{
			nComparacao++;
			if(strcmp(novo[pivo].nome, nome) < 0)
				esq = pivo + 1;
			else
				dir = pivo -1;
		}//end else
	}//end while

	return resp;

}//end pesquisaBinaria

int main (void){

	clock_t tempoInicial = clock();
	Jogador *jogador = ler(strdup("/tmp/players.csv"));
	Jogador *novo1   = (Jogador*) calloc (100 , sizeof(Jogador));
	char entrada[50];
	int n = 0;

	scanf("%s" , entrada);

	while(strcmp(entrada , "FIM") != 0){
	
		novo1[n] = jogador[atoi(entrada)];

		if(novo1[n].id == 2011)
			novo1[n].nome[strlen(novo1[n].nome) - 1] = '\0';

		scanf("%s" , entrada);	
		n++;
	}//end while

	ordena(novo1, n);

	getchar();

	fgets(entrada, 48, stdin);
	entrada[strlen(entrada) - 1] = '\0';

	while(strcmp(entrada , "FIM") != 0){

		if(pesquisaBinaria(novo1, entrada,  n))	
			printf("SIM\n");
		else
			printf("NAO\n");


		fgets(entrada, 48, stdin);
		entrada[strlen(entrada) - 1] = '\0';
	}//end while

	FILE *arq = fopen("710678_binaria.txt", "w");

	fprintf(arq ,"710678\t%ld\t%d", clock() - tempoInicial, nComparacao);

	fclose(arq);

	free(jogador);
	free(novo1);

	return 0;
}//end main
