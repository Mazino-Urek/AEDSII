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

/*---------------------------------------Inicio NO----------------------------------------------*/

typedef struct No{

	Jogador elemento;
	No *dir;
	No *esq;
	int nivel;
} No;

/*
 * Retorna o maior entre dois interios
 * @param int a - inteiro a ser comparado
 * @param int b - inteiro a ser comparado
 * @return int -  o maior entre a e b
 * */
int Max(int a, int b){
	return ((a > b)? a : b);
}//end Max

/*
 * aloca um novo No com jagador
 * @param Jogador jogador - jogador a ser insido no No
 * @reuturn No resp - No alocado com jogador
 * */
No *novoNo(Jogador jogador){	
	No *resp = (No*) malloc (sizeof(No));
	resp->elemento = jogador;
	resp->dir = NULL;
	resp->esq = NULL;
	resp->nivel = 1;
	return resp;
}//end novoNo

/*
 * busca no nivel de um No da arvore
 * @param No* no - no a que se deseja obter o nivel
 * @reuturn int - nivel desejado 
 * */
int getNivel(No* no){
	return ((no == NULL)? 0 : no->nivel);
}//end getNivel

/*
 * seta o nivel de um no da arvore
 * @param No* no - No que se deseja setar o nivel 
 * */
void setNivel(No* no){
	no->nivel = 1 + Max(getNivel(no->esq), getNivel(no->dir));
}//end setNivel

/*---------------------------------------Fim No-------------------------------------------------*/

/*---------------------------------------iniciao AVL-----------------------------------------------*/

/*
 * realiza a rotação a direita em um No
 * @param No* no - a ser realizado a rotação
 * @return No* no - no a assumir posição do no rotacionado
 * */
No* rotacionarDir(No* no) {
	No* noEsq = no->esq;
	No* noEsqDir = noEsq->dir;

	noEsq->dir = no;
	no->esq = noEsqDir;

	setNivel(no);
	setNivel(noEsq);

	return noEsq;
}//end rotacionarDir

/*
 * realiza a rotação a esquerda em um No
 * @param No* no - a ser realizado a rotação
 * @return No* no - no a assumir posição do no rotacionado
 * */
No* rotacionarEsq(No* no) {
	No* noDir = no->dir;
	No* noDirEsq = noDir->esq;

	noDir->esq = no;
	no->dir = noDirEsq;

	setNivel(no);
	setNivel(noDir);
	return noDir;
}//end ratacionarEsq

/*
 * Realiza o balaceamento de um no da arvore
 * @param No* no - No a ser balaceado
 * @return No* no - No balanceado
 * */
No* balancear(No* no){
	if(no != NULL){	
		int fator = getNivel(no->dir) - getNivel(no->esq);
	
		if(abs(fator) <= 1){
			setNivel(no);
		}
		else if(fator == 2){
				int fatorFilhoDir = getNivel(no->dir->dir) - getNivel(no->dir->esq);

				if(fatorFilhoDir == -1)
					no->dir = rotacionarDir(no->dir);
				
				no = rotacionarEsq(no);
			}
			else if(fator == -2){
				
				int fatorFilhoEsq = getNivel(no->esq->dir) - getNivel(no->esq->esq);

				if(fatorFilhoEsq == 1)
					no->esq = rotacionarEsq(no->esq);

				no = rotacionarDir(no);
			
			}//end 
			else
				printf("erro ao balancear");
	}//end if
	return no;
}//end Balancear

/*
 * Realiza a inserção de elementos na arvore
 * @param jogador jogador - elemento a ser inserido na arvore
 * @param No* no -  No raiz da arvore a ser inserido a o elemento
 * @return No* no - No raiz da arvore
 * */
No* inserir(Jogador jogador, No* i){
	if (i == NULL) {
		i =  novoNo(jogador);
	} else if ( strcmp(jogador.nome,  i->elemento.nome) < 0 ) {
		i->esq = inserir(jogador, i->esq);

	} else if (strcmp(jogador.nome,  i->elemento.nome) > 0) {
		i->dir = inserir(jogador, i->dir);

	} else {
		printf("Erro ao inserir!\n");
	}

	return balancear(i);
}//end inserir

/*contador de comparações*/
int comp = 0;

/*
 * realizar a pesqisa de um elemento na arvore
 * @param char* nome - nome a ser pesquisado a arvore
 * @param No* i - No raiz da arvore a ser vealizada a pesquisa
 * @return bool resp - true se, e somente se o elemento existir na arvore
 * */
bool pesquisar(char* nome, No* i) {
	bool resp;
	comp++;
	if (i == NULL) {
		resp = false;
	} 
	else{
		comp++;
		if (strcmp(nome, i->elemento.nome) == 0) {
			resp = true;
		}
		else{
			comp++;
			if ( strcmp(nome, i->elemento.nome) < 0 ) {
				printf(" esq");
				resp = pesquisar(nome, i->esq);
			}
			else{
				printf(" dir");
				resp = pesquisar(nome, i->dir);
			}
		}//end else
	}//end else
	return resp;
}//end pesquisar

/*
 * realiza a desalocação de uma arvore
 * @param No* no - No raiz da arvore a ser desalocada 
 * */
void freeArvore(No* no){
	if(no != NULL){
		freeArvore(no->esq);
		freeArvore(no->dir);
		free(no);
	}
}//end freeArvore

/*---------------------------------------Fim AVL--------------------------------------------------*/

int main (void){
	Jogador *jogador = ler(strdup("/tmp/players.csv"));
	Jogador removidos[20];
	char entrada[10], comando;
	char* nome = (char*) calloc (50, sizeof(char));
	int nentradas , cont = 0;
	bool aux;
	clock_t tempoInicial, tempoFinal, tempoTotal = 0;
	No* raiz = NULL;
	comp = 0;

	scanf("%s" , entrada);
	while(strcmp(entrada , "FIM") != 0){
		raiz = inserir(jogador[atoi(entrada)], raiz);
		scanf("%s" , entrada);
	}//end while

	fgets( nome, 49, stdin);//primeira leitura suja
	fgets( nome, 49, stdin);
	nome[strlen(nome) - 1] = '\0';//eliminando o '\n'
	while(strcmp(nome , "FIM") != 0){
		printf("%s raiz", nome);

		/*calculando tempo de execução*/
		tempoInicial = clock();
		aux = pesquisar(nome, raiz);
		tempoFinal = clock();
		tempoTotal += tempoFinal - tempoInicial;
	
		if(aux)
			printf(" SIM\n");
		else
			printf(" NAO\n");
		fgets( nome, 49, stdin);
		nome[strlen(nome) - 1] = '\0';//eliminando o '\n'
	}//end while

	freeArvore(raiz);
	free(jogador);

	FILE *arq = fopen("710678_avl.txt", "w");
	fprintf(arq ,"710678\t%d\t%ld" , comp, tempoTotal);
	fclose(arq);

	return 0;
}//end main
