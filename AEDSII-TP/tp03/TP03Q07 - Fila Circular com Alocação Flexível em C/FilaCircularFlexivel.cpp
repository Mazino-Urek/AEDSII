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
#define MAXTAM 4

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

typedef struct Celula{

	Jogador elemento;
	Celula *prox;
} Celula;


/*
 * Aloca uma Celula e a atrbui um jogador
 * @param Jogador jogador - jogador a ser atribuido a celula
 * @return *celula resp - celula alocada
 * */
Celula *novaCelula(Jogador jogador){	
	Celula *resp = (Celula*) malloc (sizeof(Celula));
	resp->elemento = jogador;
	resp->prox = NULL;
	return resp;
}//end novaCelula

/*---------------------------------------Fim Celula-------------------------------------------------*/

/*---------------------------------------iniciao Fila-----------------------------------------------*/

/*atributos da Fila*/
Celula *primeiro, *ultimo;
int MAX;

/*inicializador*/
void start(){
       Jogador tmp;
       primeiro = ultimo = novaCelula(tmp);
       MAX = 0;
}//end start

/*
 * remove um jogador da fila
 * @return Jogador resp - jogador removido
 * */
Jogador remover(){
	if(primeiro == ultimo)
		exit(EXIT_FAILURE);

	Celula *tmp = primeiro;
	primeiro = primeiro->prox;
	Jogador elemento = primeiro->elemento;
	tmp->prox = NULL;
	free(tmp);
	tmp = NULL;
	MAX--;
	return elemento;
}//end remover 

/*
 * insere um jogadr na fila
 * @param Jogador jogador - jogador a ser inserido
 * */
void inserir(Jogador jogador){
	if(MAX > MAXTAM)
		remover();

	ultimo->prox = novaCelula(jogador);
	ultimo = ultimo->prox;
	MAX++;
}//end inserir

/*
 * calcula a media da altura dos jogadores na lista
 * @return double - meida das alturas
 * */
double mediaAltura(){
	int media = 0, cont = 0;
	Celula *tmp = primeiro->prox;

	while(tmp != NULL){
		media += tmp->elemento.altura;
		tmp = tmp->prox;
		cont++;
	}//end while

	return (double)media/(double)cont;
}//end mediaAltura

/*
 * mostra os jogadores contidos na Fila
 * */
void mostrar(){
	int cont = 0;
	Celula *tmp = primeiro->prox;

	while(tmp != NULL){
		printf("[%d] ## %s ## %d ## %d ## %d ## %s ## %s ## %s ##\n",
			cont++, 
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

int main (void){
	Jogador *jogador = ler(strdup("/tmp/players.csv"));
	char entrada[10], comando;
	int nentradas , aux, cont = 0;
	start();

	scanf("%s" , entrada);
	while(strcmp(entrada , "FIM") != 0){
		inserir(jogador[atoi(entrada)]);
		printf("%d\n", (int)round(mediaAltura()));
		scanf("%s" , entrada);
	}//end while

	scanf("%d", &nentradas);
	/*leitor/interpretador de comandos*/
	while(nentradas > 0){
		getchar();
		scanf("%c", &comando);

		switch((int) comando){
			case 73:
				scanf("%d", &aux);
				inserir(jogador[aux]);
				printf("%d\n", (int)round(mediaAltura()));
				break;
			case 82:
				printf("(R) %s\n", remover().nome);
				break;
			default:
				printf("\ncomando não reconhecido\n");
				break;
		}//end switch
		nentradas--;
	}//end while
	
	mostrar();
	free(jogador);
	return 0;
}//end main
