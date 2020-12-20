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
				//principal += ",a";
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



class Celula{
	public Jogador elemento;
	public Celula prox;
	
	Celula(){
		this(null);
	}//end construtor

	Celula(Jogador elemento){
		this.elemento = elemento;
		this.prox = null;
	}//end construtor
}//end celula

class Lista {
	private Celula primeiro, ultimo;

	Lista(){
		primeiro = new Celula();
		ultimo = primeiro;
	}//end construtor 

	/*
	 * Insere um jogador no começo da lista
	 * @param Jogador jogador - jogador a ser inserido
	 * */
	void inserirInicio(Jogador jogador){
		Celula tmp = new Celula(jogador);
		tmp.prox = primeiro.prox;
		primeiro.prox = tmp;
		if(primeiro == ultimo)
			ultimo = tmp;
		tmp = null;
	}//end inserirInicio

	/*
	 * Insere um jogador em uma posição escolhida na lista
	 * @param Jogador jogador - jogador a ser inserido
	 * @param int pos - posição a ser inserida o jogador
	 * */
	void inserir(Jogador jogador, int pos) throws Exception{
		int tamanho = 0;
		for(Celula i = primeiro; i.prox != null; i = i.prox, tamanho++); 

		if(pos < 0 || pos > tamanho)
			throw new Exception("posição invalida");
		else if(pos == 0)
			inserirInicio(jogador);
		else if(pos == tamanho)
			inserirFim(jogador);	
		else{
			Celula i = primeiro;
			for(int j = 0; j < pos; j++, i = i.prox);
			Celula tmp = new Celula(jogador);
			tmp.prox = i.prox;
			i.prox = tmp;
			tmp = i = null;
		}
	}//end inserir

	/*
	 * Insere um jogador no final da lista
	 * @param Jogador jogador - jogador a ser inserido
	 * */
	void inserirFim(Jogador jogador) throws Exception{
		ultimo.prox = new Celula(jogador);
		ultimo = ultimo.prox;
	}//end inserirFim

	/*
	 * Remove um jogador do fim da lista
	 * @param Jogador player[--n] - jogador removido
	 * */
	Jogador removerFim() throws Exception{
		if(primeiro == ultimo)
			throw new Exception("Erro --> array fazio");

		Jogador elemento;
		Celula i;
		for(i = primeiro; i.prox != ultimo; i = i.prox);
		elemento = ultimo.elemento;
		ultimo = i;
		i = ultimo.prox = null;
		return elemento;
	}//end removerFim

	/*
	 * Remove um jogador do inicio da lista
	 * @return Jogador resp - jogador removido
	 * */
	Jogador removerInicio() throws Exception{
		if(primeiro == ultimo)
			throw new Exception("Erro --> array vazio");

		Jogador elemento;
		Celula tmp = primeiro;
		primeiro = primeiro.prox;
		elemento = primeiro.elemento;
		tmp.prox = null;
		tmp = null;
		return elemento;
	}//end removerInicio

	/*
	 * Remove um jogador de uma posição escolhida
	 * @param int pos - posição do jogador a ser removido
	 * @return Jogador resp - jogador removido
	 * */
	Jogador remover(int pos) throws Exception{	
		Jogador elemento;
		int tamanho = 0;
		for(Celula i = primeiro; i.prox != null; i = i.prox, tamanho++); 
	
		if(primeiro == ultimo || pos < 0 || pos >= tamanho)	
			throw new Exception("posição invalida");
		else if(pos == 0)
			elemento = removerInicio();
		else if(pos == tamanho -1)
			elemento = removerFim();
		else{
			Celula i = primeiro;
			for(int j = 0; j < pos; j++, i = i.prox);
			Celula tmp = i.prox;
			elemento = tmp.elemento;
			i.prox = tmp.prox;
			tmp.prox = null;
			i = tmp = null;
		}
		return elemento;
	}//end remover

	/*
	 * Mostra todos os jogadores presentes na lista
	 * */
	void mostrar(){
		Celula tmp = primeiro.prox;
		Jogador player;
		int i = 0;
	
		while(tmp != null){
			player = tmp.elemento;
			MyIO.println("[" + i + "] ## " 
				         + player.getNome()  + " ## " +
					 player.getAltura()  + " ## " +
				           player.getPeso()  + " ## " + 
				  player.getAnoNascimento()  + " ## " +
				   player.getUniversidade()  + " ## " +
		               player.getCidadeNascimento()  + " ## " +
			       player.getEstadoNascimento()	+ " ##"     );
			tmp = tmp.prox;
			i++;
		}//end for
	}//end mostrar

	/*
	 * metodo para procurar um jogador atravez de seu nome na lista
	 * @param String nome - nome do jogador pesquisado 
	 * @return boolean resp - true caso o jogador exista na lista
	 * */
	public boolean pesquisar(String nome){
		boolean resp = false;
		for(Celula i = primeiro.prox; i != null; i = i.prox){
			Hash03.comp++;
			if(i.elemento.getNome().equals(nome)){
				resp = true;
				i = ultimo;
			}
		}//end for
		return resp;
	}//end pesquisar
}//end Lista

class Hash{
	private Lista[] hash;

	Hash(){
		this(21);
	}//end contrutor
	Hash(int tam){
		hash = new Lista[tam];
		for(int i = 0; i < hash.length; i++)
			hash[i] = new Lista();
	}//end construtor

	/*
	 * metodo para inserir elementos na tabela com hash e rehash 
	 * @param Jogador elemento - elemento a ser inserido
	 * */
	public void inserir(Jogador elemento)throws Exception{
		int pos = transformer( elemento.getAltura() );
		hash[pos].inserirFim(elemento);
	}//end inserir

	/*
	 * função para remover elementos da tabela
	 * @param int altura - elemento a ser removido 
	 * @return Jogador resp - elemento removido
	 * */
	public Jogador remover(int altura)throws Exception{	
		int pos = transformer(altura);
		return hash[pos].removerFim();
	}//end remover

	/*
	 * metodo para pesquisar um Jogador na tabela pelo nome
	 * @param String nome - Nome a ser pesquisado na tabela
	 * @return boolean resp - true caso o nome exita na tabela
	 * */
	public boolean pesquisarNome(String nome){
		boolean resp = false;

		for(int i = 0; i < hash.length; i++){
			Hash03.comp++;
			if(hash[i].pesquisar(nome)){
				resp = true;
				i = hash.length;
			}//end if
		}//end for
		return resp;
	}//end pesquisarNome

	/*
	 * metodo para mostrar todos os elementos da tabela e suas respectivas posições
	 * */
	public void mostrar(){
		for(int i = 0; i < hash.length; i++)
			if(hash[i] != null)
				hash[i].mostrar();	
	}//end mostrar

	/*
	 * realiza o Altuta mod tamTab (função de transformação)
	 * @param int altura - altura a ser operada
	 * */
	private int transformer(int altura){
		return (altura%hash.length);
	}//transformer
}//end Hash

public class Hash03{
	public static int comp;

	public static void main(String[] args) throws Exception{	
		long tInicial, tFinal, tTotal = 0; 
		Jogador[] player = Jogador.ler("/tmp/players.csv");
		Hash hash = new Hash();
		boolean aux;
		comp = 0;
		
		String entrada = MyIO.readString();
		while(!entrada.equals("FIM")){
			hash.inserir(player[Integer.parseInt(entrada)]);
			entrada = MyIO.readString();
		}//end while
		entrada = MyIO.readLine();
		while(!entrada.equals("FIM")){
			//calculo de tempo de pesquisa
			tInicial = System.currentTimeMillis();
				aux = hash.pesquisarNome(entrada);
			tFinal = System.currentTimeMillis();
			tTotal += tFinal - tInicial;
			
			MyIO.print(entrada);
			if(aux)
				MyIO.println(" SIM");
			else
				MyIO.println(" NAO");
			entrada = MyIO.readLine();
		}//end while

		//gravação do arquivo de log
		Arq.openWrite("710678_hashIndireta.txt");
		Arq.print("710678\t" + tTotal + "\t" + comp);
		Arq.close();
	}//end main
}//end classe
