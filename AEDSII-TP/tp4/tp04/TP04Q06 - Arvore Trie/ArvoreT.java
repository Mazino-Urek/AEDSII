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


class No{

	public No[] prox;
	public boolean cor;

	No(){
		prox = new No[140];
		for(int i = 0; i < prox.length; i++)
			prox[i] = null;
		this.cor = false;
	}//end contrutor

	No(boolean cor){
		prox = new No[140];
		for(int i = 0; i < prox.length; i++)
			prox[i] = null;
		this.cor = cor;
	}//end contrutor

	/*
	 * converte um caracter em uma posição valida da tabela hash
	 * @param char letra - letra a ser convertida
	 * @return int - posição obtida
	 * */
        public int indice(char letra){ 
                return ((int)letra - 32);
        }//end indice
}//end NoT

class Trie{
	
	private No raiz;

	Trie(){
		raiz = new No();
	}//end construtor

	/*
	 * metodo interativo para inserir elementos na arvore
	 * @param String nome - elemento a ser inserido
	 * */
	public void inserir(String nome)throws Exception{
		inserir(nome, 0, raiz);	
	}//end inserir

	/*
	 * metodo recursivo para inserir elementos na arvore
	 * @param String nome - elemento a ser inserido
	 * @param int i - indice da String nome
	 * @param No no - no atual de inserção
	 * @throw - caso tente inserir prefixo ou elementos repetidos
	 * */
	private void inserir(String nome, int i, No no)throws Exception{
	
		if(no.cor)
			throw new Exception("erro ao inserir 2");
		else if(i == (nome.length())){
				no.cor = true;
				no.prox = null;
		}
		else{
			char letra = nome.charAt(i);
			int prox = no.indice(letra);
			//criando ramificação
			if(no.prox[prox] == null){
				no.prox[prox] = new No();	
				inserir(nome, i + 1, no.prox[prox]);
			}
			//garantindo a não inserção de prefixo
			else if(i < nome.length() - 1)
				inserir(nome, i + 1, no.prox[prox]);
			else
				throw new Exception("erro ao inserir 1");
		}//end else
	}//end inserir

	/*
	 * Metodo interativo para pesquisar elementos na arvore
	 * @param String nome - elemento a ser pesquisado
	 * @return boolean - true caso o elemento exista a arvore
	 * */
	public boolean pesquisar(String nome){
		return pesquisar(nome, 0, raiz);
	}//end pesquisar

	/*
	 * Metodo recursivo para pesquisar elementos na arvore
	 * @param String nome - elemento a ser pesquisado
	 * @param int i - indice da string nome
	 * @param No no - no atual da pesquisa
	 * @return boolean resp - true caso o elemento exista a arvore
	 * */
	private boolean pesquisar(String nome, int i, No no){
		boolean resp;

		ArvoreT.comp++;
		if(no.cor){
			ArvoreT.comp++;
			if(i == nome.length())
				resp = true;
			else
				resp = false;
		}else{
			char letra = nome.charAt(i);
			int prox = no.indice(letra);
			ArvoreT.comp++;
			if(no.prox[prox] == null)
				resp = false;
			else
				resp = pesquisar(nome, i+1, no.prox[prox]);
		}
		return resp;
	}//end pesquisar

	/*
	 * Metodo interativo para mostrar todos os elementos contidos na arvore
	 * */
	public void mostrar(){
		mostrar("", raiz);
	}//end mostrar

	/*
	 * Metodo recursivo para mostrar todos os elementos contidos na arvore
	 * @param String nome - elemento encontrado na arvore
	 * @param No no - No atual da pesquisa
	 * */
	private void mostrar(String nome, No no){
		if(no.cor)
			MyIO.println(nome);
		else
			for(int i = 0; i < no.prox.length; i++)
				if(no.prox[i] != null)
					mostrar((nome + (char)(i + 32)), no.prox[i]);	
	}//end mostrar

	/*
	 * Metodo interativo para realizar o merge de duas arvores
	 * @param Trie other - arvore a ser realizado o merge
	 * @return resp - arvore resultado do merge
	 * */
	public Trie merge(Trie other)throws Exception{
		Trie resp = new Trie();
		merge("", other.raiz, resp);
		merge("", this.raiz, resp);
		return resp;
	}//end mostrar

	/*
	 * Metodo recursivo para realizar a copia de uma arvore
	 * @param Trie merge - arvore resulado
	 * @param String nome - elemento a ser inserido na arvore resultado
	 * @param No no - No atual de copia
	 * */
	public void merge(String nome, No no, Trie merge)throws Exception{
		if(no.cor)
			merge.inserir(nome);
		else
			for(int i = 0; i < no.prox.length; i++)
				if(no.prox[i] != null)
					merge((nome + (char)(i + 32)), no.prox[i], merge);	
	}//end mostrar
}//end trie


public class ArvoreT{
	public static int comp;

	public static void main(String[] args) throws Exception{	
		long tInicial, tFinal, tTotal = 0; 
		Jogador jogador;
		Jogador[] player = Jogador.ler("/tmp/players.csv");
		Trie arvore1 = new Trie();
		Trie arvore2 = new Trie();
		Trie merge;
		boolean aux;
		comp = 0;
		
		/*leitura da primeira entrada*/
		String entrada = MyIO.readString();
		while(!entrada.equals("FIM")){
			jogador = player[Integer.parseInt(entrada)];
			MyIO.println(jogador.getId() + "\t" + jogador.getNome());
			arvore1.inserir(jogador.getNome());
			entrada = MyIO.readString();
		}//end while

		/*leitura da segunda  entrada*/
		entrada = MyIO.readString();
		while(!entrada.equals("FIM")){
			jogador = player[Integer.parseInt(entrada)];
			MyIO.println(jogador.getId() + "\t" + jogador.getNome());
			arvore2.inserir(jogador.getNome());	
			entrada = MyIO.readString();
		}//end while

		/*realização do merge*/
		merge = arvore1.merge(arvore2);

		/*leitura da terceira entrada*/
		entrada = MyIO.readLine();
		while(!entrada.equals("FIM")){
			//calculo de tempo de pesquisa
			tInicial = System.currentTimeMillis();
				aux = merge.pesquisar(entrada);
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
		Arq.openWrite("710678_arvoreTrie.txt");
		Arq.print("710678\t" + tTotal + "\t" + comp);
		Arq.close();
	}//end main
}//end classe
