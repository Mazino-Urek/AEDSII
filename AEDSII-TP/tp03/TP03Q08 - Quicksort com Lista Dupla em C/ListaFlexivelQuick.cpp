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
#include <math.h>

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
/*---------------------------------------Fim Jogador------------------------------------------------*/

/*---------------------------------------Inicio Celula----------------------------------------------*/

typedef struct CelulaDupla{

	Jogador elemento;
	CelulaDupla *prox, *ant;
} CelulaDupla;


/*
 * Aloca uma Celula e a atrbui um jogador
 * @param Jogador jogador - jogador a ser atribuido a celula
 * @return *celula resp - celula alocada
 * */
CelulaDupla *novaCelula(Jogador jogador){	
	CelulaDupla *resp = (CelulaDupla*) malloc (sizeof(CelulaDupla));
	resp->elemento = jogador;
	resp->prox = resp->ant = NULL;
	return resp;
}//end novaCelula

/*---------------------------------------Fim Celula-------------------------------------------------*/

/*---------------------------------------iniciao Fila-----------------------------------------------*/

/*proprieades da fila*/
CelulaDupla *primeiro, *ultimo;

/*construtor*/
void start (){
	Jogador tmp;
	ultimo = primeiro = novaCelula(tmp);
}//end start

/*
 * insere um jogador no inicio da lista
 * @param Jogador jogador - jogador a ser inserido
 * */
void inserirInicio(Jogador jogador){
	CelulaDupla *tmp = novaCelula(jogador);
	tmp->ant = primeiro;
	tmp->ant = primeiro->prox;
	primeiro->prox = tmp;
	if(primeiro == ultimo)
		ultimo = tmp;
	else
		tmp->prox->ant = tmp;
	tmp = NULL;
}//end inserirInicio

/*
 * insere um Jogador no final da lista
 * @param Jogador jogador - jogador a ser inserido
 * */
void inserirFim(Jogador jogador){
	ultimo->prox = novaCelula(jogador);
	ultimo->prox->ant = ultimo;
	ultimo = ultimo->prox;
}//end inserirFim

/*
 * busca o tamanho da lista
 * @return int tamanho - tamho da lista*/
int getTam(){
	int tamanho = 0;
	for(CelulaDupla *i = primeiro; i->prox != NULL; i = i->prox, tamanho++);
	return tamanho;	
}//end getTam

CelulaDupla *getCell(int x){	
	CelulaDupla *tmp = primeiro->prox;
	for(int i = 0; i != x && tmp != NULL; i++, tmp = tmp->prox);
	return tmp;
}//end getCell

/*
 * mostra os jogadores contidos na Fila
 * */
void mostrar(){
	int cont = 0;
	CelulaDupla *tmp = primeiro->prox;

	while(tmp != NULL){
		printf("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]\n",
			tmp->elemento.id, 
			tmp->elemento.nome, 
			tmp->elemento.altura,
			tmp->elemento.peso,
			tmp->elemento.anoNascimento,
			tmp->elemento.universidade,
			tmp->elemento.cidadeNascimento,
			tmp->elemento.estadoNascimento);
		tmp = tmp->prox;
	}//end while
}//end mostrar

/*---------------------------------------Fim Fila--------------------------------------------------*/

/*---------------------------------------quicksort-------------------------------------------------*/

/*contador de comparações e movimentações*/
int nComparacao = 0;
int nMovimenta = 0;

/*
 * Realiza a troca de dois jogadores de uma lista
 * @param int x - jogador a ser trocado
 * @param int y - jogador a ser trocado
 * */
void swap(int x, int y){
	
	CelulaDupla *tmp1 = getCell(x);
	CelulaDupla *tmp2 = getCell(y);
	Jogador aux = tmp1->elemento;
	tmp1->elemento = tmp2->elemento;
	tmp2->elemento = aux;
}//end swap

/*
 * realiza a ordenação de uma listaDupla pelo estado de nascimento (caso empate pelo nome)
 * @param int esq - inicio da lista
 * @param int dir - final da lista
 * */
void quickSort (int esq, int dir){

	int i = esq, j = dir;
	bool aux;
	nMovimenta++;
	Jogador pivo = getCell((dir + esq) / 2)->elemento;

	while(i <= j){
		aux = true;
		
		nComparacao++;
		while(strcmp(getCell(i)->elemento.estadoNascimento, pivo.estadoNascimento) <= 0 && aux){
			nComparacao += 2;       
			if(strcmp(getCell(i)->elemento.estadoNascimento, pivo.estadoNascimento) != 0 ){
				i++;
			}
			else{
				nComparacao++;
				if(strcmp(getCell(i)->elemento.nome , pivo.nome) < 0){
					i++;
				}
				else
					aux = false;
			}//end else
		}//end while
		aux = true;
		nComparacao++;
		while(strcmp(getCell(j)->elemento.estadoNascimento, pivo.estadoNascimento) >= 0 && aux){
			nComparacao += 2;
		       	if(strcmp(getCell(j)->elemento.estadoNascimento, pivo.estadoNascimento) != 0 ){
				j--;
			}
			else{
				nComparacao++;
				if(strcmp(getCell(j)->elemento.nome , pivo.nome) > 0){
					j--;
				}
				else
					aux = false;
			}//end else	       	
		}//end while

		if(i <= j){
			nMovimenta += 3;
			swap(i, j);
			i++;
			j--;
		}//end if
	}//end while

	if(esq < j)
		quickSort(esq, j);
	if(i < dir)
		quickSort( i, dir);
}//end quickSort

/*
 * realiza a ordenação de uma listaDupla pelo estado de nascimento (caso empate pelo nome)
 * */
void quickSort (){
	quickSort(0, getTam() - 1);
}//end quicksort

/*--------------------------------------------------end quicksort------------------------------------*/

int main (void){
	Jogador *jogador = ler(strdup("/tmp/players.csv"));
	char entrada[10], comando;
	int nentradas , aux, cont = 0;
	start();

	scanf("%s" , entrada);
	while(strcmp(entrada , "FIM") != 0){
		inserirFim(jogador[atoi(entrada)]);
		scanf("%s" , entrada);
	}//end while

	clock_t tInicial = clock();
	quickSort();
	clock_t tFinal = clock();

	mostrar();

	free(jogador);

	FILE *arq = fopen("710678_quicksort2.txt", "w");
	fprintf(arq, "710678\t%d\t%d\t%ld", nComparacao, nMovimenta, tFinal-tInicial );

	return 0;
}//end main
