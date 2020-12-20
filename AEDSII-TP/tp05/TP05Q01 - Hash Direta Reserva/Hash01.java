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

class Hash{
	private Jogador[] hash;
	private int pri, sec, res,  total; 

	Hash(){
		this(21, 9);
	}//end contrutor
	Hash(int pri, int sec){
		this.pri = pri;
		this.sec = sec;
		total = pri + sec;
		this.res = 0;
		
		hash = new Jogador[total];
		for(int i = 0; i < total; i++)
			hash[i] = null;
	}//end construtor

	/*
	 * metodo para inserir elementos na tabela 
	 * @param Jogador elemento - elemento a ser inserido
	 * */
	public void inserir(Jogador elemento)throws Exception{
		int pos = transformer(elemento.getAltura());

		if(hash[pos] == null)
			hash[pos] = elemento;
		else if(res == sec){
		//	MyIO.println("");//throw new Exception("Erro --> hash lotado");	
		}
		else
			hash[pri + res++] = elemento;	
	}//end inserir

	/*
	 * função para remover elementos da tabela
	 * @param int altura - elemento a ser removido 
	 * @return Jogador resp - elemento removido
	 * */
	public Jogador remover(int altura){	
		int pos = transformer(altura);
		Jogador resp = null;

		if(hash[pos] != null){
			resp = hash[pos];
			for(int i = pri; i < pri + res; i++)
				if(transformer(hash[i].getAltura()) == pos){
					hash[pos] = hash[i];
					subir(i);
					i = pri + res;
				}//end if
		}//end if
		return resp;
	}//end remover

	/*
	 * metodo para realocar elementos na area de reserva
	 * @param int pos - posição de realocamento
	 * */
	private void subir(int pos){
		for(int i = pos; i < pri + res - 1; i++)
			hash[i] = hash[i+1];
	}//end subir

	/*
	 * metodo para pesquisar um Jogador na tabela pelo nome
	 * @param String nome - Nome a ser pesquisado na tabela
	 * @return boolean resp - true caso o nome exita na tabela
	 * */
	public boolean pesquisarNome(String nome){
		boolean resp = false;

		for(int i = 0; i < pri+sec; i++){
			Hash01.comp++;
			if(hash[i] != null && nome.equals( hash[i].getNome() ) ){
				resp = true;
				i = pri + sec;
			}//end if
		}//end for
		return resp;
	}//end pesquisar

	/*
	 * metodo para mostrar todos os elementos da tabela e suas respectivas posições
	 * */
	public void mostrar(){
		for(int i = 0; i < total; i++)
			if(hash[i] != null)
				MyIO.println("[" + i + "]" + " -> " + hash[i].getNome());	
	}//end mostrar

	/*
	 * realiza o Altuta mod tamTab (função de transformação)
	 * @param int altura - altura a ser operada
	 * */
	private int transformer(int altura){
		return (altura%pri);
	}//transformer
}//end Hash

public class Hash01{
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
		Arq.openWrite("710678_hashReserva.txt");
		Arq.print("710678\t" + tTotal + "\t" + comp);
		Arq.close();
	}//end main
}//end classe
