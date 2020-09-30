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

//contador de movimentações
int nMovimenta = 0;

/*
 * busca o maior id em um array de Jogador
 * @param Jogador *array - array a ser realizada a busca
 * @param int n - tamanho do array
 * */
int getMax(Jogador *array, int n) {
	nMovimenta++;
	Jogador max = array[0];
	for (int i = 1; i < n; i++){
		nComparacao++;
		if (array[i].id > max.id){
			nMovimenta++;
			max = array[i];
		}
	}//end for
	return max.id;
}//end getMax


/*
 * ordenada um array de jogadores pelo id, tomando como base as posições mais importantes
 * Nota: usado em conjunto com o radixSort
 * @param Jogador *array - array a ser ordenado
 * @param int size - tamanho do array
 * @param int place - setor a ser ordenado a ser ordenado
 * */
void countingSort(Jogador *array, int size, int place) {
	
	Jogador output[size + 1];
	int max = (array[0].id / place) % 10;

	for (int i = 1; i < size; i++) {
		nComparacao++;
		if (((array[i].id / place) % 10) > max){
			nMovimenta++;
			max = array[i].id;
		}
	}

	//array de contagem
	int count[max + 1];

	for (int i = 0; i < max; nMovimenta++, count[i] = 0, ++i);

	for (int i = 0; i < size; nMovimenta++, count[(array[i].id / place) % 10]++ , i++);

	for (int i = 1; i < 10; nMovimenta++, count[i] += count[i - 1], i++);

	//ordenação
	for (int i = size - 1; i >= 0; i--){
		nMovimenta++;
		output[count[(array[i].id / place) % 10] - 1] = array[i];
		count[(array[i].id / place) % 10]--;
	}

	for (int i = 0; i < size; nMovimenta++, array[i] = output[i], i++);

}//end coutingSort


/*
 * ordena uma array de jogadores pelo id
 * @param Jogador *array - array a ser ordenado
 * @param int size - tamanho do array
 * */
void radixsort(Jogador *array, int size) {
	
	int max = getMax(array, size);

	//aplicando o countingSort para ordenar elementos baseados em seu valor
	for (int place = 1; max / place > 0; place *= 10)
		countingSort(array, size, place);
}//end radixSort




int main (void){

	Jogador *jogador = ler(strdup("/tmp/players.csv"));
	Jogador *novo   = (Jogador*) calloc (800 , sizeof(Jogador));
	char entrada[50];
	int n = 0;

	scanf("%s" , entrada);

	while(strcmp(entrada , "FIM") != 0){
	
		novo[n] = jogador[atoi(entrada)];

		scanf("%s" , entrada);
		n++;
	}//end while
	
	free(jogador);

	clock_t tempoInicial = clock();
	radixsort(novo, n);
	clock_t tempoFinal = clock();

	for(int i = 0; i < n; i++)
		imprimir(novo[i]);


	FILE *arq = fopen("710678_radixsort.txt", "w");

        fprintf(arq ,"710678\t%d\t%d\t%ld", nComparacao, nMovimenta  ,tempoFinal - tempoInicial);

	fclose(arq);

	free(novo);

	return 0;
}//end main
