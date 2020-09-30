/*
 * Nome: Diego Da Silva Ferreira
 * Matricula: 71 06 78
 *
 * version 4.0
 *
 * */

import java.io.*;
import java.util.Arrays;

class Jogador {

	private int id;
	private String nome;
	private int altura;
	private int peso;
	private String universidade;
	private int anoNascimento;
	private String cidadeNascimento;
	private String estadoNascimento;


//***************start construtores **********************

	Jogador () {
	
	        this.id 	      = -1;
	        this.nome 	      = "";
	        this.altura 	      = -1;
	        this.peso 	      = -1;
    	        this.universidade     = "";
	        this.anoNascimento    = -1;
   	        this.cidadeNascimento = "";
  	        this.estadoNascimento = "";
	}

	Jogador ( int id,
		  String nome,
		  int altura,
		  int peso,
		  String universidade,
		  int anoNascimento,
		  String cidadeNascimento,
		  String estadoNascimento ) {


		this.id = id;
		this.nome = nome;
		this.altura = altura;
		this.peso = peso;
		this.universidade = universidade;
		this.anoNascimento = anoNascimento;
		this.cidadeNascimento = cidadeNascimento;
		this.estadoNascimento = estadoNascimento;
	
	}

//*****************end contrutores *****************************


//******************start metodos get **************************

	int getId(){return id;}

	int getAltura(){return altura;}

	int getPeso(){return peso;}

	int getAnoNascimento(){return anoNascimento;}

	String getNome(){return nome;}

	String getUniversidade(){return universidade;}

	String getCidadeNascimento(){return cidadeNascimento;}

	String getEstadoNascimento(){return estadoNascimento;}

//**********************end metodos get ********************


//*********************start metodos set *******************

	void setId (int id){this.id = id;}

	void setNome (String nome) {this.nome = nome;}

	void setAltura (int altura){this.altura = altura;}

	void setPeso (int peso){this.peso = peso;}

	void setUniversidade (String universidade) {this.universidade = universidade;}

	void setAnoNascimento (int anoNascimento){this.anoNascimento = anoNascimento;}

	void setCidadeNascimento(String cidadeNascimento){this.cidadeNascimento = cidadeNascimento;}

	void setEstadoNascimento(String estadoNascimento){this.estadoNascimento = estadoNascimento;}

	void set (int id,
		  String nome,
		  int altura,
		  int peso,
		  String universidade,
		  int anoNascimento,
		  String cidadeNascimento,
		  String estadoNascimento ) {

		this.id = id;
		this.nome = nome;
		this.altura = altura;
		this.peso = peso;
		this.universidade = universidade;
		this.anoNascimento = anoNascimento;
		this.cidadeNascimento = cidadeNascimento;
		this.estadoNascimento = estadoNascimento;
	}//set estado nascimento

//****************end metodos set***************


	/*
	 * copia todos os atributos de outro jogador
	 * @param Jogador outher - jogador a ser copiado
	 * */
	void clone (Jogador outher){
	
		this.id = outher.id;
		this.nome = outher.nome;
		this.altura = outher.altura;
		this.peso = outher.peso;
		this.universidade = outher.universidade;
		this.anoNascimento = outher.anoNascimento;
		this.cidadeNascimento = outher.cidadeNascimento;
		this.estadoNascimento = outher.estadoNascimento;
	}//end clone


	/*
	 * mostra os atributos de um jogador 
	 * */
	void imprimir (){

			MyIO.println("[" + id  + " ## " +
					 nome   + " ## " +
				       altura   + " ## " + 
				       	 peso   + " ## " +
				anoNascimento   + " ## " +
		                 universidade   + " ## " +
			     cidadeNascimento	+ " ## " +
			     estadoNascimento	+ "]"     );
	}//end imprimir


	/*
	 * lê os atributos de um arquivo '.csv'
	 * @param String fileName - nome do arquivo a ser lido.
	 * */
	public static Jogador[] ler(String fileName) {
	
		Jogador[] resp;
		String principal = "";
		int pn = 0;
		String[] aux;
		int n;

		try{
			File file = new File(fileName);
			LineNumberReader LNR = new LineNumberReader(new FileReader(file));
			
			LNR.mark((int)file.length() + 1);
			
			LNR.skip(file.length());
			n  = LNR.getLineNumber() - 1;

			resp = new Jogador[n];	

			LNR.reset();
			principal = LNR.readLine();

			/* sitema de leitura e separação dos atributos do arquivo*/
			for(int i = 0; i < n; i++) {

				resp[i] = new Jogador();
				principal = LNR.readLine();
				aux = principal.split("," , 8);

				if(!aux[0].equals(""))
					resp[i].id = Integer.parseInt(aux[0]);
				else 
					resp[i].id = -1;

				if(!aux[1].equals(""))
					resp[i].nome = aux[1];
				else 
					resp[i].nome = "nao informado";

				if(!aux[2].equals(""))
					resp[i].altura = Integer.parseInt(aux[2]);
				else
					resp[i].altura = -1;

				if(!aux[3].equals(""))
					resp[i].peso = Integer.parseInt(aux[3]);
				else
					resp[i].peso = -1;

				if(!aux[4].equals(""))
					resp[i].universidade = aux[4];
				else 
					resp[i].universidade = "nao informado";

				if(!aux[5].equals(""))
					resp[i].anoNascimento = Integer.parseInt(aux[5]);
				else 
					resp[i].anoNascimento = -1;

				if(!aux[6].equals(""))
					resp[i].cidadeNascimento = aux[6];
				else 
					resp[i].cidadeNascimento = "nao informado";

				if(!aux[7].equals(""))
					resp[i].estadoNascimento = aux[7];
				else 
					resp[i].estadoNascimento = "nao informado";

			}//end for

			LNR.close();

			return resp;

		} catch (FileNotFoundException fileNothing){

			MyIO.println("\n-->Arquivo inexistente -->  " + fileNothing);
		
		} catch (IOException ERRO){
		
			MyIO.println("\n--> ERRO -->" + ERRO);
		}

		return null;
	
	}//end ler


}//end Jogador


public class heap{
	
	//contam o numero de comparações e movimentações
	public static int nCompara = 0;
	public static int nMovi = 0;

	/*
	 * realiza a troca de duas posições de um array
	 * @param Jogador[] array - array a ser realizada a troca
	 * @param int x - posição a ser trocado
	 * @param int y - posição a ser trocado
	 * */
	public static void swap(Jogador[]array, int x , int y){

		nMovi += 3;
		Jogador tmp = array[x];
		array[x] = array[y];
		array[y] = tmp;
	}//end swap

	/*
	 * procura pelo maior filho em um heap
	 * @param Jogador array - heap a ser realizada a buasca
	 * @param int i - posição de pesquisa (pai)
	 * @param int tamHeap - tamanho do heap
	 * */
	public static int getMaiorFilho(Jogador[] array, int i, int tamHeap){
		int filho;
		nCompara++;
		if (2*i == tamHeap || array[2*i].getAltura() >= array[2*i+1].getAltura()){
			nCompara++;
			if(array[2*i].getAltura() == array[2*i+1].getAltura() && !(2*i == tamHeap)){
				nCompara++;
				if(array[2*i].getNome().compareTo(array[2*i+1].getNome()) > 0){
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
	 * @aram Jogador[] array - heap a ser recontruido
	 * @param int tamHeap - tamanho do heap
	 * */
	public static void reconstruir(Jogador[] array, int tamHeap){
		int i = 1, filho;
		while(i <= (tamHeap/2)){
			filho = getMaiorFilho(array, i, tamHeap);
			nCompara++;
			if(array[i].getAltura() <= array[filho].getAltura()){
				nCompara++;
				if(array[i].getAltura() == array[filho].getAltura()){
					nCompara++;
					if(array[i].getNome().compareTo(array[filho].getNome()) < 0){
						swap(array, i, filho);
						i = filho;
					}else{
						i = tamHeap;
					}
				}else{
					swap(array, i, filho);
					i = filho;
				}
			}else{
				i = tamHeap;
			}
		}//end while
	}//end recunstruir

	/*
	 * constroi um heap
	 * @param Jogador[] array - array a ser contruido o heap
	 * @param int tamHeap - tamanho do heap
	 * */
	public static void construir(Jogador[] array, int tamHeap){
		nCompara++;
		for(int i = tamHeap; i > 1 && array[i].getAltura() >= array[i/2].getAltura(); i /= 2){
			nCompara += 2;
			if(array[i].getAltura() == array[i/2].getAltura()){
				nCompara++;
				if(array[i].getNome().compareTo(array[i/2].getNome()) > 0){
					swap(array, i, i/2);
				}
			}else{
				swap(array, i, i/2);
			}
					
		}//end for
	}//end contruir


	/*
	 * ordena um vetor de Jogador pela altura 
	 * Nota: criterio de desempate pelo nome
	 * @param Jogador[] array - array a ser ordenado
	 * @param int n - tamanho do array
	 * @return array - array ordenado
	 * */
	public static Jogador[] heapsort(Jogador[] array, int n) {
		//Alterar o vetor ignorando a posicao zero
		Jogador[] tmp = new Jogador[n+1];
		for(int i = 0; i < n; i++){
			nMovi++;
			tmp[i+1] = array[i];
		}
		array = tmp;

		//Contrucao do heap
		for(int tamHeap = 2; tamHeap <= n; tamHeap++){
			construir(array, tamHeap);
		}

		//Ordenacao propriamente dita
		int tamHeap = n;
		while(tamHeap > 1){
			swap(array, 1, tamHeap--);
			reconstruir(array, tamHeap);
		}

		//Alterar o vetor para voltar a posicao zero
		tmp = array;
		array = new Jogador[n];
		for(int i = 0; i < n; i++){
			nCompara++;
			array[i] = tmp[i+1];
		}
		return array;
	}//end heapsort



	public static void main(String[] args) {
	
		long tInicial, tFinal; 
		Jogador[] player1 = Jogador.ler("/tmp/players.csv");
		Jogador[] player2 = new Jogador[600];
		int n;

		String entrada = MyIO.readLine();
		for(n = 0; !entrada.equals("FIM"); n++){
	
			player2[n] = player1[Integer.parseInt(entrada)];
			
			entrada = MyIO.readLine();
		}//end for

		tInicial = System.currentTimeMillis();		
		player2 = heapsort(player2, n);
		tFinal = System.currentTimeMillis();		

		for(int i = 0; i < n; i++)
			player2[i].imprimir();


		Arq.openWrite("710678_heapsort.txt");

		Arq.print("710678\t"      +
			  nCompara + "\t" +
		  	  nMovi    + "\t" +  
			  (tFinal - tInicial) );

		Arq.close();
	}//end main
}//end classe
