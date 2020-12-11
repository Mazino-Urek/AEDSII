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
	public boolean cor;

	No (Jogador elemento) {
		this(elemento, null, null, false);
	}
	
	No (Jogador elemento, boolean cor) {
		this(elemento, null, null, cor);
	}
	
	No (Jogador elemento, No esq, No dir, boolean cor) {
		this.elemento = elemento;
		this.esq = esq;
		this.dir = dir;
		this.cor = cor;
	}
}//end CelulaDup

class Arvore{

	private No raiz;
	
	Arvore () {
		this.raiz = null;
	}//end construtor
	
	/* 
	 * Metodo iterativo para inserir elemento.
	 * @param Jogador elemento - Elemento a ser inserido.
	 * @throws Exception Se o elemento existir na arvore.
	 * */
	public void inserir(Jogador elemento) throws Exception {
		//Se a arvore estiver vazia
		if(raiz == null)
			raiz = new No(elemento, false);

			//Senao, se a arvore tiver um elemento 
		else if (raiz.esq == null && raiz.dir == null){
			if (raiz.elemento.getNome().compareTo(elemento.getNome()) > 0)
				raiz.esq = new No(elemento, true);
			else 
				raiz.dir = new No(elemento, true);

			//Senao, se a arvore tiver dois elementos (raiz e dir)
		} else if (raiz.esq == null){
			if(raiz.elemento.getNome().compareTo(elemento.getNome()) > 0)
				raiz.esq = new No(elemento);
			else if (raiz.dir.elemento.getNome().compareTo(elemento.getNome()) > 0){
				raiz.esq = new No(raiz.elemento);
				raiz.elemento = elemento;
			} else {
				raiz.esq = new No(raiz.elemento);
				raiz.elemento = raiz.dir.elemento;
				raiz.dir.elemento = elemento;
			}

			raiz.esq.cor = raiz.dir.cor = false;

			//Senao, se a arvore tiver dois elementos (raiz e esq)
		} else if (raiz.dir == null){
			if(  raiz.elemento.getNome().compareTo(elemento.getNome()) < 0)
				raiz.dir = new No(elemento);
			else if (raiz.esq.elemento.getNome().compareTo(elemento.getNome()) < 0){
				raiz.dir = new No(raiz.elemento);
				raiz.elemento = elemento;
			} else {
				raiz.dir = new No(raiz.elemento);
				raiz.elemento = raiz.esq.elemento;
				raiz.esq.elemento = elemento;
			}//end else

			raiz.esq.cor = raiz.dir.cor = false;

			//Senao, a arvore tem tres ou mais elementos
		} else 
			inserir(elemento, null, null, null, raiz);

		raiz.cor = false;
	}//end inserir

	/*
	 * metodo recursivo para inserir elemento na arvore
	 * @param Jogador elemento - elemento a ser inserido
	 * @param No bisavo - bisovo do No i
	 * @param No avo - avo do No i
	 * @param No pai - pai do No i
	 * @param No i - No candidato a ter o elemento inserido
	 * @thorwos Exception - elemento já existe na arvore
	 * */
	private void inserir(Jogador elemento, No bisavo, No avo, No pai, No i) throws Exception {
		if (i == null) {
			if(elemento.getNome().compareTo(pai.elemento.getNome()) < 0)
				i = pai.esq = new No(elemento, true);
			else
				i = pai.dir = new No(elemento, true);
			
			if(pai.cor == true)
				balancear(bisavo, avo, pai, i);
		} else {
			//Achou um 4-no: eh preciso fragmeta-lo e reequilibrar a arvore
			if(i.esq != null && i.dir != null && i.esq.cor == true && i.dir.cor == true){
				i.cor = true;
				i.esq.cor = i.dir.cor = false;
				if(i == raiz)
					i.cor = false;
				else if(pai.cor == true)
					balancear(bisavo, avo, pai, i);
				
			}
			if (elemento.getNome().compareTo(i.elemento.getNome()) < 0) 
				inserir(elemento, avo, pai, i, i.esq);
			else if (elemento.getNome().compareTo(i.elemento.getNome()) > 0) 
				inserir(elemento, avo, pai, i, i.dir);
			else 
				throw new Exception("Erro inserir (elemento repetido)!");
			
		}//end else
	}//end inserir

	/*
	 * realiza o balanceamento da arvore
	 * @param No bisavo - bisovo do No a ser balanceado
	 * @param No avo - avo do No a ser balanceado
	 * @param No pai - pai do No a ser balanceado
	 * @param No i - No a ser balanceado
	 * */
	private void balancear(No bisavo, No avo, No pai, No i){

		//Se o pai tambem e preto, reequilibrar a arvore, rotacionando o avo
		if(pai.cor == true){
			//4 tipos de reequilibrios e acoplamento
			if(pai.elemento.getNome().compareTo(avo.elemento.getNome()) > 0) // rotacao a esquerda ou direita-esquerda
				if(i.elemento.getNome().compareTo(pai.elemento.getNome()) > 0)
					avo = rotacaoEsq(avo);
				 else 
					avo = rotacaoDirEsq(avo);
			else  // rotacao a direita ou esquerda-direita
				if(i.elemento.getNome().compareTo(pai.elemento.getNome()) < 0)
					avo = rotacaoDir(avo);
				else
					avo = rotacaoEsqDir(avo);
			if(bisavo == null)
				raiz = avo;
			else
				if(avo.elemento.getNome().compareTo(bisavo.elemento.getNome()) < 0)
					bisavo.esq = avo;
				else
					bisavo.dir = avo;

			//reestabelecer as cores apos a rotacao
			avo.cor = false;
			avo.esq.cor = avo.dir.cor = true;
		} //if(pai.cor == true)
	}//end balancear

	/*
	 * realiza a rotação a direita
	 * @param No no - No a ser rotacionado
	 * @return No noEsq - No rotacionado
	 * */
	private No rotacaoDir(No no) {
		No noEsq = no.esq;
		No noEsqDir = noEsq.dir;

		noEsq.dir = no;
		no.esq = noEsqDir;

		return noEsq;
	}//end rotacaoDir

	/*
	 * realiza a rotação a esquerda
	 * @param No no - No a ser rotacionado
	 * @return No noDir - No rotacionado
	 * */
	private No rotacaoEsq(No no) {
		No noDir = no.dir;
		No noDirEsq = noDir.esq;

		noDir.esq = no;
		no.dir = noDirEsq;
		return noDir;
	}//end rotacaoEsq

	/*
	 * realiza a rotação dupla direita esquerda
	 * @param No no - No a ser rotacionado
	 * @return No - No rotacionado
	 * */
	private No rotacaoDirEsq(No no) {
		no.dir = rotacaoDir(no.dir);
		return rotacaoEsq(no);
	}//end rotacaoDirEsq

	/*
	 * realiza a rotação dupla esquerda direita
	 * @param No no - No a ser rotacionado
	 * @return No - No rotacionado
	 * */
	private No rotacaoEsqDir(No no) {
		no.esq = rotacaoEsq(no.esq);
		return rotacaoDir(no);
	}//end rotacaoEsqDir

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
		alviNegra.comp++;

		if(i == null){
			resp = " NAO";
		}
		else{
			alviNegra.comp++;
		       	if(nome.equals(i.elemento.getNome())){
				resp = " SIM";
			}
			else{
				alviNegra.comp++;
			       	if(nome.compareTo(i.elemento.getNome()) < 0){
					MyIO.print(" esq");
					resp = pesquisar(nome, i.esq);
				}
				else{
					MyIO.print(" dir");
					resp = pesquisar(nome, i.dir);
				}//end else
			}//end else
		}//end else
		return resp;
	}//end pesquisar
}//end Arvore

public class alviNegra{

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
			
			//calculo de tempo de execução
			tInicial = System.currentTimeMillis();
				MyIO.println(arvore.pesquisar(entrada));//realização da pesquisa
			tFinal = System.currentTimeMillis();
			tTotal += tFinal - tInicial;
			
			entrada = MyIO.readLine();
		}//end while

		Arq.openWrite("710678_avinegra.txt");

		Arq.print("710678\t" + tTotal + "\t" + comp);

		Arq.close();
	}//end main
}//end classe
