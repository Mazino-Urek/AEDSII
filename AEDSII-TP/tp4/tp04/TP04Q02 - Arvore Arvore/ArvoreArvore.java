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

	No (Jogador elemento) {
		this(elemento, null, null);
	}
	No (Jogador elemento, No esq, No dir) {
		this.elemento = elemento;
		this.esq = esq;
		this.dir = dir;
	}
}//end CelulaDup

class No2 {

	public int elemento;
	public No2 esq;
	public No2 dir;
	public No outro;

	No2 (int elemento) {
		this(elemento, null, null, null);
	}
	No2 (int elemento, No2 esq, No2 dir, No outro) {
		this.elemento = elemento;
		this.esq = esq;
		this.dir = dir;
		this.outro = outro;
	}
}//end CelulaDup

class Arvore{
	private No2 raiz;
	
	Arvore ()  throws Exception{
		this.raiz = null;
		inserir(7);
		inserir(3);
		inserir(11);
		inserir(1);
		inserir(5);
		inserir(9);
		inserir(12);
		inserir(0);
		inserir(2);
		inserir(4);
		inserir(6);
		inserir(8);
		inserir(10);
		inserir(13);
		inserir(14);
	}//end construtor

	/*
	 * insere um elemento na arvore primaria
	 * @param int valor- elemento a ser inserido
	 * */
	private void inserir (int valor) throws Exception{
		raiz = inserir(valor, raiz);
	}//end inserir

	/*
	 * insere um elemento na arvore primaria
	 * @param int valor - elemento a ser inserido
	 * @return No2 i - raiz
	 * */
	private No2 inserir (int valor , No2 i) throws Exception{
	
		if(i == null)
			i = new No2(valor);
		else if(valor < i.elemento)
			i.esq = inserir(valor, i.esq);		
		else if(valor > i.elemento)
			i.dir = inserir(valor, i.dir);		
		else
			throw new Exception("Erro --");
		return i;
	}//end inserir

	/*
	 * realiza uma busca na arvore primaria
	 * @param int valor - valor procurado
	 * @return No2 resp - No2 procurado
	 * */
	private No2 pesquisar (int valor, No2 i){
		No2 resp;

		if(i == null){
			resp = null;
		}
		else{
		       	if(valor == i.elemento){
				resp = i;
			}
			else{
			       	if(valor < i.elemento){
					resp = pesquisar(valor, i.esq);
				}
				else{
					resp = pesquisar(valor, i.dir);
				}//end else
			}//end else
		}//end else
		return resp;
	}//end pesquisar
	
/*----------------------------------------------------*/
	
	/*
	 * insere um elemento na arvore secundaria
	 * @param Jogador jogador - elemento a ser inserido
	 * */
	void inserir (Jogador jogador) throws Exception{
		No2 tmp = pesquisar((jogador.getAltura() % 15), raiz); 
		tmp.outro = inserir(jogador, tmp.outro);
	}//end inserir

	/*
	 * insere um elemento na arvore secundaria
	 * @param Jogador jogador - elemento a ser inserido
	 * @return No resp - No raiz da arvore secondaria
	 * */
	No inserir (Jogador jogador , No i) throws Exception{
	
		if(i == null)
			i = new No(jogador);
		else if(jogador.getNome().compareTo(i.elemento.getNome()) < 0)
			i.esq = inserir(jogador, i.esq);		
		else if(jogador.getNome().compareTo(i.elemento.getNome()) > 0)
			i.dir = inserir(jogador, i.dir);		
		else
			throw new Exception("Erro --");
		return i;
	}//end inserir

	/*
	 * realiza uma busca na arvore pelo atributo nome do jagador
	 * @param String nome - nome a ser procurado
	 * @return String resp - " SIM" caso o elemento exista na arvore, " NAO" caso contrario
	 * */
	String pesquisar (String nome){
		String resp;
		MyIO.print(" raiz");
		ArvoreArvore.comp++;
		if(pesquisar(nome, raiz))
			resp = " SIM";
		else 
			resp = " NAO";
		return resp;
	}//end pesquisar


	/*
	 * realiza uma pesquisa por força bruta na arvore na arvore secundaria 
	 * (utilazada para caminha na arvore primarira)
	 * @param String nome - nome a ser procurado na arvore secundaria
	 * @param No2 i - No2 a ser realizado a pesquisa
	 * @return boolean resp - true caso a elemento exista na arvore secundaria
	 * */
	boolean pesquisar(String nome, No2 i){
		boolean resp;

		ArvoreArvore.comp++;
		if(i == null)
			resp = false;
		else{
			ArvoreArvore.comp++;
			if(pesquisar(nome, i.outro)){
				resp = true;
			}
			else{
				ArvoreArvore.comp++;
				MyIO.print(" esq");
				if(pesquisar(nome, i.esq)){
					resp = true;
				}
				else{
					MyIO.print(" dir");
					resp = pesquisar(nome, i.dir);
				}//else
			}//else
		}//end else
		return resp;
	}//end pesuisar

	/*
	 * realiza uma busca por força bruta na arvore secundaria pelo atributo nome do jagador
	 * @param String nome - nome a ser procurado
	 * @return boolean resp - true caso o elemento exista na arvore, false caso contrario
	 * */
	boolean pesquisar (String nome, No i){
		boolean resp;

		ArvoreArvore.comp++;
		if(i == null){
			resp = false;
		}
		else{
			ArvoreArvore.comp++;
		       	if(nome.equals(i.elemento.getNome())){
				resp = true;
			}
			else{
				ArvoreArvore.comp++;
				MyIO.print(" ESQ");
				if(pesquisar(nome, i.esq))
						resp = true;	
				else{
					MyIO.print(" DIR");
					resp = pesquisar(nome, i.dir);
				}//end else
			}//end else
		}//end else
		return resp;
	}//end pesquisar
}//end Arvore

public class ArvoreArvore{

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

		Arq.openWrite("710678_arvoreArvore.txt");

		Arq.print("710678\t" + tTotal + "\t" + comp);

		Arq.close();
	}//end main
}//end classe
