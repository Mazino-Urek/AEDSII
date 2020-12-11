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

class No {
	public Jogador elemento;
	public No esq;
	public No dir;
	public int nivel;

	public No (Jogador elemento) {
		this(elemento, null, null, 1);
	}//end construtor
	
	public No (Jogador elemento, No esq, No dir, int nivel) {
		this.elemento = elemento;
		this.esq = esq;
		this.dir = dir;
		this.nivel = nivel;
	}//end construtor

	public void setnivel(){
		this.nivel = 1 + Math.max(getNivel(esq), getNivel(dir));
	}//end setnivel

	public int getNivel(No no){
		return (no == null)? 0 : no.nivel;
	}//end getNivel
}//end CelulaDup

class Arvore{

	private No raiz;
	
	Arvore () {
		this.raiz = null;
	}//end construtor

	/*
	 * insere um elemento na arvore
	 * @param Jogador jogador - elemento a ser inserido
	 * */
	void inserir (Jogador jogador) throws Exception{
		raiz = inserir(jogador, raiz);
	}//end inserir

	/*
	 * insere um elemento na arvore
	 * @param Jogador jogador - elemento a ser inserido
	 * */
	No inserir (Jogador jogador , No i) throws Exception{
	
		if(i == null)
			i = new No(jogador);
		else if(jogador.getNome().compareTo(i.elemento.getNome()) > 0)
			i.esq = inserir(jogador, i.esq);		
		else if(jogador.getNome().compareTo(i.elemento.getNome()) < 0)
			i.dir = inserir(jogador, i.dir);		
		else
			throw new Exception("Erro --");
		return i;
	}//end inserir

	/*
	 * realiza uma busca na arvore pelo atributo nome do jagador
	 * @param String nome - nome a ser procurado
	 * @return String - SIM caso o elemento exista na arvore, NAO caso contrario
	 * */
	String pesquisar (String nome){
		MyIO.print(" raiz");
		return pesquisar(nome, raiz);
	}//end pesquisar

	/*
	 * realiza uma busca na arvore pelo atributo nome do jagador
	 * @param String nome - nome a ser procurado
	 * @return String - SIM caso o elemento exista na arvore, NAO caso contrario
	 * */
	String pesquisar (String nome, No i){
		String resp;
		biArvore.comp++;

		if(i == null){
			resp = " NAO";
		}
		else{
			biArvore.comp++;
		       	if(nome.equals(i.elemento.getNome())){
				resp = " SIM";
			}
			else{
				biArvore.comp++;
			       	if(nome.compareTo(i.elemento.getNome()) > 0){
					MyIO.print(" dir");
					resp = pesquisar(nome, i.esq);
				}
				else{
					MyIO.print(" esq");
					resp = pesquisar(nome, i.dir);
				}//end else
			}//end else
		}//end else
		return resp;
	}//end pesquisar
}//end Arvore

public class biArvore{

	public static int comp;

	public static void main(String[] args) throws Exception{	
		long tInicial, tFinal, tTotal = 0; 
		Jogador[] player = Jogador.ler("/tmp/players.csv");
		Arvore arvore = new Arvore();
		comp = 0;
		
		String entrada = MyIO.readString();
		while(!entrada.equals("FIM")){
			arvore.inserir(player[Integer.parseInt(entrada)]);
			entrada = MyIO.readString();
		}//end while

		entrada = MyIO.readLine();
		while(!entrada.equals("FIM")){
			MyIO.print(entrada);
			tInicial = System.currentTimeMillis();
			MyIO.println(arvore.pesquisar(entrada));
			tFinal = System.currentTimeMillis();
			tTotal += tFinal - tInicial;
			entrada = MyIO.readLine();
		}//end while

		Arq.openWrite("710678_arvoreBinaria.txt");

		Arq.print("710678\t" + tTotal + "\t" + comp);

		Arq.close();
	}//end main
}//end classe
