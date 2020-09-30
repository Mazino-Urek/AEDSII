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


public class insertion{
	
	//contam o numero de comparações e movimentações
	public static int nCompara = 0;
	public static int nMovi = 0;


	/*
	 * ordena um array de Jogador pelo anoNascimento 
	 * nota: criterio de desempate pelo nome
	 * @param Jogador[] array - array a ser ordenado
	 * @param int n - tamanho do array;
	 * */
	public static void insercao (Jogador[] array, int n){

		Jogador tmp;
		boolean aux;
		int j;

		for(int i = 1; i < n; i++ ){
			
			 nMovi++;
			 tmp = array[i];
			 aux = true;
			 j = i-1;
			
 			 nCompara++;
			 while((j >= 0) && 
			       (array[j].getAnoNascimento() >= tmp.getAnoNascimento()) && aux){
				
				nCompara += 2;
				if(array[j].getAnoNascimento() != tmp.getAnoNascimento()){
					nMovi++;
					array[j+1] = array[j];
					j--;
				}
				else{
					nCompara++;
					if(array[j].getNome().compareTo(tmp.getNome()) > 0){
						nMovi++;
						array[j+1] = array[j];
						j--;
					}
					else
						aux = false;
				}//end else
			}//end while

			nMovi++;
			array[j+1] = tmp;
		}//end for
	}//end insecao



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
		insercao(player2, n);
		tFinal = System.currentTimeMillis();		

		for(int i = 0; i < n; i++)
			player2[i].imprimir();


		Arq.openWrite("710678_insercao.txt");

		Arq.print("710678\t"      +
			  nCompara + "\t" +
		  	  nMovi    + "\t" +  
			  (tFinal - tInicial) );

		Arq.close();
	}//end main
}//end classe
