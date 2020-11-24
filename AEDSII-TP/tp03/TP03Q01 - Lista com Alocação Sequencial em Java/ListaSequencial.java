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

class Lista {

	private Jogador[] player;
	private int n;

	Lista(){
	
		player = new Jogador[10];
		for(int i = 0; i < player.length; i++)
			player[i] = new Jogador(); 
		n = 0;
	}//end construtor 

	Lista(int n){
	
		player = new Jogador[n];
		for(int i = 0; i < player.length; i++)
			player[i] = new Jogador(); 
		this.n = 0;
	}//end construtor

	/*
	 * Insere um jogador no começo da lista
	 * @param Jogador jogador - jogador a ser inserido
	 * */
	void inserirInicio(Jogador jogador) throws Exception{
	
		if(n >= player.length)
			throw new Exception("ERRO -> array cheio");
	
		for(int i = n; i > 0; i--)
			player[i] = player[i-1];

		player[0] = jogador;
		n++;	
	}//end inserirInicio

	/*
	 * Insere um jogador em uma posição escolhida na lista
	 * @param Jogador jogador - jogador a ser inserido
	 * @param int pos - posição a ser inserida o jogador
	 * */
	void inserir(Jogador jogador, int pos) throws Exception{

		if(this.n >= player.length || pos < 0 || pos > n)
			throw new Exception("erro --> posição invalida");

		for(int i = n; i> pos; i--)
			player[i] = player[i-1];

		player[pos] = jogador;
		n++;	
	}//end inserir

	/*
	 * Insere um jogador no final da lista
	 * @param Jogador jogador - jogador a ser inserido
	 * */
	void inserirFim(Jogador jogador) throws Exception{
	
		if(n >= player.length)
			throw new Exception("Erro --> Array cheio");

		player[n] = jogador;
		n++;

	}//end inserirFim

	/*
	 * Remove um jogador do fim da lista
	 * @param Jogador player[--n] - jogador removido
	 * */
	Jogador removerFim() throws Exception{
	
		if(n == 0)
			throw new Exception("Erro --> array fazio");

		return player[--n];
	}//end removerFim

	/*
	 * Remove um jogador do inicio da lista
	 * @return Jogador resp - jogador removido
	 * */
	Jogador removerInicio() throws Exception{
	
		if(n == 0)
			throw new Exception("Erro --> array vazio");

		Jogador resp = player[0];
		n--;

		for(int i = 0; i < n; i++)
			player[i] = player[i+1];

		return resp;
	}//end removerInicio

	/*
	 * Remove um jogador de uma posição escolhida
	 * @param int pos - posição do jogador a ser removido
	 * @return Jogador resp - jogador removido
	 * */
	Jogador remover(int pos) throws Exception{
	
		if(n == 0 || pos < 0 || pos >= n)
		     throw new Exception("erro --> posição vazia");

		Jogador resp = player[pos];
		n--;

		for(int i = pos; i < n; i++)
			player[i] = player[i+1];

		return resp;

	}//end remover

	/*
	 * Mostra todos os jogadores presentes na lista
	 * */
	void mostrar(){
	
		for(int i = 0; i < this.n; i++)
			MyIO.println("[" + i + "] ## " 
				         + player[i].getNome()  + " ## " +
					 player[i].getAltura()  + " ## " +
				           player[i].getPeso()  + " ## " + 
				  player[i].getAnoNascimento()  + " ## " +
				   player[i].getUniversidade()  + " ## " +
		               player[i].getCidadeNascimento()  + " ## " +
			       player[i].getEstadoNascimento()	+ " ##"     );
	}//end mostrar
}

public class ListaSequencial{
	public static void main(String[] args) throws Exception{

		Jogador[] player = Jogador.ler("/tmp/players.csv");
		Jogador[] removidos = new Jogador[20];
		Lista lista = new Lista(220);
		String aux = MyIO.readString();
		String[] array;
		int in, n = 0;

		/*leitura da primeira entrada*/
		while(!aux.equals("FIM")){
			lista.inserirFim(player[Integer.parseInt(aux)]);
			aux = MyIO.readString();
		}//end while

		in = MyIO.readInt();

		/*leitura e execução dos comandos*/
		while( in > 0 ){

			aux = MyIO.readLine();
			array = aux.split(" ");

			switch (array[0]){
				case "II":
					lista.inserirInicio(player[Integer.parseInt(array[1])]);
					break;
				case "IF":
					lista.inserirFim(player[Integer.parseInt(array[1])]);
					break;
				case "I*":
					lista.inserir(player[Integer.parseInt(array[2])], Integer.parseInt(array[1]) );
					break;
				case "RI":
					removidos[n] = lista.removerInicio();
					n++;
					break;
				case "RF":
					removidos[n] = lista.removerFim();
					n++;
					break;
				case "R*":
					removidos[n] = lista.remover(Integer.parseInt(array[1]));
					n++;
					break;
				default: 
					MyIO.println("puts");
			}
			in--;
		}

		for(int i = 0; i < n; i++)
			MyIO.println("(R) " + removidos[i].getNome());

		lista.mostrar();

	}//end main
}//end classe
