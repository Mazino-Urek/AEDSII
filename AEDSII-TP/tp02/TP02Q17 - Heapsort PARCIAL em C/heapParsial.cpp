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
int nCompara = 0;

//cotador de movimentações
int nMovi = 0;


/*
 * realiza a troca de posições entre dois elementos de um array de jogadores
 * @param Jogador *novo1 - posição a ser trocada
 * @param Jogador *novo2 - posição a ser trocada
 * */
void swap(Jogador *novo1, Jogador *novo2){

        nMovi += 3;

        Jogador tmp;
        tmp    = *novo1;
        *novo1 = *novo2;
        *novo2 = tmp;
}//end swap



/*
 * procura pelo maior filho em um heap
 * @param Jogador *array - heap a ser realizada a buasca
 * @param int i - posição de pesquisa (pai)
 * @param int tamHeap - tamanho do heap
 * */
int getMaiorFilho(Jogador *array, int i, int tamHeap){
	int filho;
	nCompara++;
	if (2*i == tamHeap || array[2*i].altura >= array[2*i+1].altura){
		nCompara++;
		if(array[2*i].altura == array[2*i+1].altura && !(2*i == tamHeap)){
			nCompara++;
			if(strcmp(array[2*i].nome, array[2*i+1].nome) > 0){
				filho = 2*i;
			}else{
				filho = 2*i + 1;
			}
		}else{
			filho = 2*i;
		}
	}else {
		filho = 2*i + 1;
	}
	return filho;
}//end getMaiorFilho


/*
 * recontroi o heap realizando a ordenação
 * @aram Jogador *array - heap a ser recontruido
 * @param int tamHeap - tamanho do heap
 * */
void reconstruir(Jogador *array, int tamHeap){
	int i = 1, filho;
	while(i <= (tamHeap/2)){
		filho = getMaiorFilho(array, i, tamHeap);
		nCompara++;
		if(array[i].altura <= array[filho].altura){
			nCompara++;
			if(array[i].altura == array[filho].altura){
				nCompara++;
				if(strcmp(array[i].nome, array[filho].nome) < 0){
					swap(&array[i], &array[filho]);
					i = filho;
				}else{
					i = tamHeap;
				}
			}else{
				swap(&array[i] , &array[filho]);
				i = filho;
			}
		}else{
			i = tamHeap;
		}
	}//end while
}//end recunstruir

/*
 * constroi um heap
 * @param Jogador *array - array a ser contruido o heap
 * @param int tamHeap - tamanho do heap
 * */
void construir(Jogador *array, int tamHeap){
	nCompara++;
	bool aux = true;
	for(int i = tamHeap; i > 1 && array[i].altura >= array[i/2].altura && aux; i /= 2){
		nCompara += 2;
		if(array[i].altura == array[i/2].altura){
			nCompara++;
			if(strcmp(array[i].nome , array[i/2].nome) > 0){
				swap(&array[i], &array[i/2]);
			}
			else{
				aux = false;
			}
		}else{
			swap(&array[i], &array[i/2]);
		}

	}//end for
}//end contruir




/*
 * ordena parcialmente um vetor de Jogador pela altura 
 * Nota: criterio de desempate pelo nome
 * @param Jogador *array - array a ser ordenado
 * @param int n - tamanho do array
 * @param int k - tamanho do array a ser ordenado
 * @return array - array ordenado
 * */
Jogador* heapsort(Jogador *array, int n, int k) {
	//Alterar o vetor ignorando a posicao zero
	Jogador *tmp = (Jogador*) calloc(n+1, sizeof(Jogador));
	for(int i = 0; i < n; i++){
		nMovi++;
		tmp[i+1] = array[i];
	}
	free(array);
	array = tmp;

	//Contrucao do heap
	for(int tamHeap = 2; tamHeap <= k; tamHeap++){
		construir(array, tamHeap);
	}

	//ordenação parcial
	for (int i = k + 1; i <= n; i++){
		nCompara++;
		if (array[i].altura < array[1].altura){
			swap(&array[i] , &array[1]);
			reconstruir(array, k+5);
		}//end if
	}//end for


	//Ordenacao propriamente dita
	int tamHeap = n;
	while(tamHeap > 1){
		swap(&array[1], &array[tamHeap--]);
		reconstruir(array, tamHeap);
	}

	//Alterar o vetor para voltar a posicao zero
	free(tmp);
	tmp = array;
	array = (Jogador*) calloc(k, sizeof(Jogador));
	for(int i = 0; i < k; i++){
		nCompara++;
		array[i] = tmp[i+1];
	}
	return array;
}//end heapsort



int main (void){

	Jogador *jogador = ler(strdup("/tmp/players.csv"));
	Jogador *novo   = (Jogador*) calloc (800 , sizeof(Jogador));
	char entrada[50];
	int n = 0, k = 10;

	scanf("%s" , entrada);

	while(strcmp(entrada , "FIM") != 0){
	
		novo[n] = jogador[atoi(entrada)];

		scanf("%s" , entrada);
		n++;
	}//end while
	
	free(jogador);

	
	clock_t tempoInicial = clock();
	novo = heapsort(novo, n, k);
	clock_t tempoFinal = clock();

	for(int i = 0; i < k; i++)
		imprimir(novo[i]);


	FILE *arq = fopen("710678_heapsort.txt", "w");

	fprintf(arq ,"710678\t%d\t%d\t%ld",  nCompara, nMovi  , tempoFinal - tempoInicial);

	fclose(arq);

	free(novo);

	return 0;
}//end main
