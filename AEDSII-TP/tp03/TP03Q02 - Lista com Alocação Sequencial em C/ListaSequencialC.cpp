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
#define MAXTAM 220

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

/*---------------------------------------iniciao Lista----------------------------------------------*/

Jogador array[MAXTAM];
int n;

void start(){ n = 0;}

/*
 * insere um jogador no inicio da lista remanejando os demais
 * @param Jogador jogador - jogador a ser inserido
 * */
void inserirInicio(Jogador jogador){
	if(n >= MAXTAM)
		exit(EXIT_FAILURE);

	for(int i = n; i > 0; i--)
		array[i] = array[i-1];

	array[0] = jogador;
	n++;
}//end inserirInicio

/*
 * insere um jogador no final do array
 * @param Jogador jogador - jogador a ser inserido
 * */
void inserirFim(Jogador jogador){	
	if(n >= MAXTAM)
		exit(EXIT_FAILURE);

	array[n] = jogador;
	n++;
}//end inserirFim

/*
 * Insere um jogador em qualquer posição da lista
 * @param int pos - posição a ser inserida
 * @param Jogador jogador - jogador a ser inserido
 * */
void inserir(int pos, Jogador jogador){
	if(n >= MAXTAM || pos < 0 || pos > n)
		exit(EXIT_FAILURE);

	for(int i = n; i > pos; i--)
		array[i] = array[i-1];

	array[pos] = jogador;
	n++;
}//end inserir

/*
 * Remove o jogador do inicio do array
 * @return Jogador resp - Jogador removido
 * */
Jogador removerInicio(){
	if(n == 0)
		exit(EXIT_FAILURE);

	Jogador resp = array[0];
	n--;
	
	for(int i = 0; i < n; i++)
		array[i] = array[i+1];

	return resp;
}//end removerInicio

/*
 * remover um Jogador do final da lista
 * @return Jogador array[--n] - jogador removido
 * */
Jogador removerFim(){
	if(n == 0)
		exit(EXIT_FAILURE);

	return array[--n];
}//end removerFim

/*
 * remove um jogador de uma determinadad posição da lista
 * @param int pos - posição a ser removida
 * @return Jogador resp - jogador removido
 * */
Jogador remover(int pos){
	if(n == MAXTAM || pos < 0 || pos > n)
		exit(EXIT_FAILURE);

	Jogador resp = array[pos];
	n--;

	for(int i = pos; i < n; i++)
		array[i] = array[i+1];

	return resp;
}//end remover

/*
 * mostra os jogadores contidos na lista
 * */
void mostrar(){

	for(int i = 0; i < n; i++)
		printf("[%d] ## %s ## %d ## %d ## %d ## %s ## %s ## %s ##\n",
			i, 
			array[i].nome, 
			array[i].altura,
			array[i].peso,
			array[i].anoNascimento,
			array[i].universidade,
			array[i].cidadeNascimento,
			array[i].estadoNascimento);

}//end mostrar

/*---------------------------------------Fim lista--------------------------------------------------*/

int main (void){

	Jogador *jogador = ler(strdup("/tmp/players.csv"));
	Jogador removidos[200];
	char entrada[10];
	int nentradas , aux, aux2, x, cont = 0;
	start();

	scanf("%s" , entrada);
	while(strcmp(entrada , "FIM") != 0){
	
		inserirFim(jogador[atoi(entrada)]);

		scanf("%s" , entrada);
	}//end while

	scanf("%d", &nentradas);
	/*leitor/interpretador de comandos*/
	while(nentradas > 0){
		getchar();
		scanf("%s", entrada);
		x = (int) entrada[0] + (int) entrada[1];

		switch(x){
			case 146:
				scanf("%d", &aux);
				inserirInicio(jogador[aux]);
				break;
			case 143:
				scanf("%d", &aux);
				inserirFim(jogador[aux]);
				break;
			case 115:
				scanf("%d", &aux);
				scanf("%d", &aux2);
				inserir(aux , jogador[aux2]);
				break;
			case 155:
				removidos[cont] = removerInicio();
				cont++;
				break;
			case 152:
				removidos[cont] = removerFim();
				cont++;
				break;
			case 124:
				scanf("%d", &aux);
				removidos[cont] = remover(aux);
				cont++;
				break;
			default:
				printf("comando não reconhecido");
				break;
		}//end switch
		nentradas--;
	}//end while

	for(int i = 0; i < cont; i++)
		printf("(R) %s\n", removidos[i].nome);

	mostrar();
	free(jogador);
	return 0;
}//end main
