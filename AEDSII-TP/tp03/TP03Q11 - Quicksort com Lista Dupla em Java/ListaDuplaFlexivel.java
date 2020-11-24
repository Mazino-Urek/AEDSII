/*
 * Nome: Diego Da Silva Ferreira
 * Matricula: 71 06 78
 *
 * version 4.1
 *
 * */

import java.io.*;

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
	
		Jogador[] resp = null;
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
		} catch (FileNotFoundException fileNothing){
			MyIO.println("\n-->Arquivo inexistente -->  " + fileNothing);
		} catch (IOException ERRO){	
			MyIO.println("\n--> ERRO -->" + ERRO);
		}
		return resp;
	}//end ler
}//end Jogador

class CelulaDupla{
	public Jogador elemento;
	public CelulaDupla prox, ant;
	
	CelulaDupla(){
		this(null);
	}//end construtor

	CelulaDupla(Jogador elemento){
		this.elemento = elemento;
		this.prox = null;
	}//end construtor
}//end celula

class ListaDupla {

	private CelulaDupla primeiro, ultimo;

	ListaDupla(){
		primeiro = new CelulaDupla();
		ultimo = primeiro;
	}//end construtor 

	/*
	 * Insere um jogador no começo da lista
	 * @param Jogador jogador - jogador a ser inserido
	 * */
	void inserirInicio(Jogador jogador){
		CelulaDupla tmp = new CelulaDupla(jogador);
		tmp.ant = primeiro;
		tmp.prox = primeiro.prox;
		primeiro.prox = tmp;
		if(primeiro == ultimo)
			ultimo = tmp;
		else
			tmp.prox.ant = tmp;
		tmp = null;
	}//end inserirInicio

	/*
	 * Insere um jogador em uma posição escolhida na lista
	 * @param Jogador jogador - jogador a ser inserido
	 * @param int pos - posição a ser inserida o jogador
	 * */
	void inserir(Jogador jogador, int pos) throws Exception{
		int tamanho = 0;
		for(CelulaDupla i = primeiro; i.prox != null; i = i.prox, tamanho++); 

		if(pos < 0 || pos > tamanho)
			throw new Exception("posição invalida");
		else if(pos == 0)
			inserirInicio(jogador);
		else if(pos == tamanho)
			inserirFim(jogador);	
		else{
			CelulaDupla i = primeiro;
			for(int j = 0; j < pos; j++, i = i.prox);
			CelulaDupla tmp = new CelulaDupla(jogador);
			tmp.ant = i;
			tmp.prox = i.prox;
			tmp.ant.prox = tmp.prox.ant = tmp;
			tmp = i = null;
		}
	}//end inserir

	/*
	 * Insere um jogador no final da lista
	 * @param Jogador jogador - jogador a ser inserido
	 * */
	void inserirFim(Jogador jogador) throws Exception{
		ultimo.prox = new CelulaDupla(jogador);
		ultimo.prox.ant = ultimo;
		ultimo = ultimo.prox;
	}//end inserirFim

	/*
	 * Remove um jogador do fim da lista
	 * @param Jogador player[--n] - jogador removido
	 * */
	Jogador removerFim() throws Exception{
		if(primeiro == ultimo)
			throw new Exception("Erro --> array fazio");

		Jogador elemento = ultimo.elemento;
		ultimo = ultimo.ant;
		ultimo.prox.ant = null;
		ultimo.prox = null;
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
		CelulaDupla tmp = primeiro;
		primeiro = primeiro.prox;
		elemento = primeiro.elemento;
		tmp.prox = primeiro.ant =  null;
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
		for(CelulaDupla i = primeiro; i.prox != null; i = i.prox, tamanho++); 
	
		if(primeiro == ultimo || pos < 0 || pos >= tamanho)	
			throw new Exception("posição invalida");
		else if(pos == 0)
			elemento = removerInicio();
		else if(pos == tamanho -1)
			elemento = removerFim();
		else{
			CelulaDupla i = primeiro.prox;
			for(int j = 0; j < pos; j++, i = i.prox);
			i.ant.prox = i.prox;
			i.prox.ant = i.ant;
			elemento = i.elemento;
			i.prox = i.ant = null;
			i = null;
		}
		return elemento;
	}//end remover


	/*
	 * determina o tamanho da lista
	 * @return int tamanho - tamanho da lista
	 * */
	int getTam(){
		
		int tamanho = 0;
		for(CelulaDupla i = primeiro; i.prox != null; i = i.prox, tamanho++); 
		return tamanho;	
	}//end getTam

	/*
	 * busca uma celulaDupla da lista 
	 * @param int x - celula a ser buscada
	 * @return Celuladupla tmp - celula buscada
	 * */
	CelulaDupla getCell(int x){
		CelulaDupla tmp = primeiro.prox;
		for(int i = 0; i != x && tmp != null; i++, tmp = tmp.prox);
		return tmp;
	}//end getCell


	/*
	 * Mostra todos os jogadores presentes na lista
	 * */
	void mostrar(){
		CelulaDupla tmp = primeiro.prox;
		Jogador player;
		int i = 0;
	
		while(tmp != null){
			player = tmp.elemento;
			MyIO.println("[" + player.getId() + " ## " 
				         + player.getNome()  + " ## " +
					 player.getAltura()  + " ## " +
				           player.getPeso()  + " ## " + 
				  player.getAnoNascimento()  + " ## " +
				   player.getUniversidade()  + " ## " +
		               player.getCidadeNascimento()  + " ## " +
			       player.getEstadoNascimento()	+ "]"     );
			tmp = tmp.prox;
			i++;
		}//end for
	}//end mostrar
}//end Lista

public class ListaDuplaFlexivel{

	/*contador do numer de comparações e movimentações*/
	public static int nCompara = 0;
	public static int nMovi = 0;

	/*
	 * realiza a troca dois jogadores de posição
	 * */
	public static void swap(CelulaDupla x, CelulaDupla y){
		
		Jogador tmp = x.elemento;
		x.elemento = y.elemento;
		y.elemento = tmp;
	}//end swap

	/*
	 * Realiza a ordenação de uma ListaDupla pelo estado ne nascimento  
	 * */
	public static void quicksortRec(ListaDupla array, int esq, int dir) {
		int i = esq, j = dir;
		boolean aux;
		Jogador pivo = array.getCell((dir+esq)/2).elemento;
		while (i <= j) {
			aux = true;
			while (array.getCell(i).elemento.getEstadoNascimento().compareTo(pivo.getEstadoNascimento()) <= 0 && aux){
				nCompara += 2;
			       	if(array.getCell(i).elemento.getEstadoNascimento().compareTo(pivo.getEstadoNascimento()) != 0)
					i++;
				else{
					nCompara++;
					if(array.getCell(i).elemento.getNome().compareTo(pivo.getNome()) < 0)
						i++;
					else
						aux = false;
				}//end else
			}//end while
			aux = true;
			while (array.getCell(j).elemento.getEstadoNascimento().compareTo(pivo.getEstadoNascimento()) >= 0 && aux){
				nCompara += 2;
			       	if(array.getCell(j).elemento.getEstadoNascimento().compareTo(pivo.getEstadoNascimento()) != 0)
					j--;
				else{
					nCompara++;
					if(array.getCell(j).elemento.getNome().compareTo(pivo.getNome()) > 0)
						j--;
					else
						aux = false;
				}//end else
			}//end while
			if (i <= j) {
				nMovi += 3;
				swap(array.getCell(i), array.getCell(j));
				i++;
				j--;
			}//end if
		}//end while
		if (esq < j)  quicksortRec(array, esq, j);
		if (i < dir)  quicksortRec(array, i, dir);
	}//end quicksortRec

	/*
	 * Realiza a ordenação de uma ListaDupla pelo estado ne nascimento  
	 * */
	public static void quicksort(ListaDupla array){
		quicksortRec(array, 0, array.getTam() -1 );
	}//end quicksort

	public static void main(String[] args) throws Exception{

		long tInicial, tFinal;
		Jogador[] player = Jogador.ler("/tmp/players.csv");
		ListaDupla lista = new ListaDupla();
		String aux = MyIO.readString();

		/*leitura da primeira entrada*/
		while(!aux.equals("FIM")){
			lista.inserirFim(player[Integer.parseInt(aux)]);
			aux = MyIO.readString();
		}//end while
		
		tInicial = System.currentTimeMillis();//calcular o tempo de execução
			quicksort(lista);
		tFinal = System.currentTimeMillis();//calcular o tempo de execução

		
		lista.mostrar();

		Arq.openWrite("710678_quicksort2.txt");

		Arq.print("710678\t" +
			  nCompara + "\t" +
			  nMovi    + "\t" + 
			  (tFinal-tInicial));
		Arq.close();
	
	}//end main
}//end classe
