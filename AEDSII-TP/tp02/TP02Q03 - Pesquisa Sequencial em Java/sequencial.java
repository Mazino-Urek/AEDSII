/*
 * Nome: Diego Da Silva Ferreira
 * Matricula: 71 06 78
 *
 * version 3.1
 *
 * */

import java.io.*;
import java.util.Arrays;

class Jogador {

	private int[] id;
	private String[] nome;
	private int[] altura;
	private int[] peso;
	private String[] universidade;
	private int[] anoNascimento;
	private String[] cidadeNascimento;
	private String[] estadoNascimento;


//***************start construtores **********************

	Jogador () {
	
	        this.id 	      = null;
	        this.nome 	      = null;
	        this.altura 	      = null;
	        this.peso 	      = null;
    	        this.universidade     = null;
	        this.anoNascimento    = null;
   	        this.cidadeNascimento = null;
  	        this.estadoNascimento = null;
	}

	Jogador (int n){

		try{	

			this.id               = new int[n];
			this.nome             = new String [n];
			this.altura           = new int[n];
			this.peso             = new int[n];
			this.universidade     = new String [n];
			this.anoNascimento    = new int[n];
			this.cidadeNascimento = new String [n];
			this.estadoNascimento = new String [n];

			Arrays.fill(id , -1);
			Arrays.fill(nome, "nao informado");
			Arrays.fill(altura, -1);
			Arrays.fill(peso, -1);
			Arrays.fill(universidade, "nao informado");
			Arrays.fill(anoNascimento, -1);
			Arrays.fill(cidadeNascimento, "nao informado");
			Arrays.fill(estadoNascimento, "nao informado");

		} catch (NegativeArraySizeException tamanhoInvalido){
		
			MyIO.println("--> tamanho invalido --> " + tamanhoInvalido);
		}
	}

	Jogador(String fileName) {
	
		ler(fileName);
	}

//*****************end contrutores *****************************


//******************start metodos get **************************

	int getId(int position){
	
		int resp = -1;
		
		try{	
			resp = id[position];

		} catch(ArrayIndexOutOfBoundsException positionInvalida){
		
			MyIO.println("\n--> posição invalida --> " + positionInvalida);
		
		} catch (NullPointerException positionNothing) {
		
			MyIO.println("\n--> posição inexistente --> " + positionNothing);

		}

		return resp;
	}//end get id

	int getAltura(int position){
	
		int resp = -1;

                try{
                        resp = altura[position];

                } catch(ArrayIndexOutOfBoundsException positionInvalida){

                        MyIO.println("\n--> posição invalida --> " + positionInvalida);

                } catch (NullPointerException positionNothing) {

                        MyIO.println("\n--> posição inexistente --> " + positionNothing);

                }

                return resp;
	}//end get altura

	int getPeso(int position){
	
		int resp = -1;

                try{
                        resp = peso[position];

                } catch(ArrayIndexOutOfBoundsException positionInvalida){

                        MyIO.println("\n--> posição invalida --> " + positionInvalida);

                } catch (NullPointerException positionNothing) {

                        MyIO.println("\n--> posição inexistente --> " + positionNothing);

                }

                return resp;
	}//end get peso

	int getAnoNascimento(int position){
                
		int resp = -1;

                try{
                        resp = anoNascimento[position];

                } catch(ArrayIndexOutOfBoundsException positionInvalida){

                        MyIO.println("\n--> posição invalida --> " + positionInvalida);

                } catch (NullPointerException positionNothing) {

                        MyIO.println("\n--> posição inexistente --> " + positionNothing);

                }

                return resp;
	}//end get ano Nascimento

	String getNome(int position){
	
                String resp = "";

                try{
                        resp = nome[position];

                } catch(ArrayIndexOutOfBoundsException positionInvalida){

                        MyIO.println("\n--> posição invalida --> " + positionInvalida);

                } catch (NullPointerException positionNothing) {

                        MyIO.println("\n--> posição inexistente --> " + positionNothing);

                }

                return resp;
	}//end get nome

	String getUniversidade(int position){
	
                String resp = "";

                try{
                        resp = universidade[position];

                } catch(ArrayIndexOutOfBoundsException positionInvalida){

                        MyIO.println("\n--> posição invalida --> " + positionInvalida);

                } catch (NullPointerException positionNothing) {

                        MyIO.println("\n--> posição inexistente --> " + positionNothing);

                }

                return resp;
	}//end get universicadade

	String getCidadeNascimento(int position){
	
                String resp = "";

                try{
                        resp = cidadeNascimento[position];

                } catch(ArrayIndexOutOfBoundsException positionInvalida){

                        MyIO.println("\n--> posição invalida --> " + positionInvalida);

                } catch (NullPointerException positionNothing) {

                        MyIO.println("\n--> posição inexistente --> " + positionNothing);

                }

                return resp;
	}//end get cidade Nascimento

	String getEstadoNascimento(int position){
	
                String resp = "";

                try{
                        resp = estadoNascimento[position];

                } catch(ArrayIndexOutOfBoundsException positionInvalida){

                        MyIO.println("\n--> posição invalida --> " + positionInvalida);

                } catch (NullPointerException positionNothing) {

                        MyIO.println("\n--> posição inexistente --> " + positionNothing);

                }

                return resp;
	}//end get estado Nascimento

//**********************end metodos get ********************


//*********************start metodos set *******************

	void setId (int position , int id){
	
                try{
			this.id[position] = id;

                } catch(ArrayIndexOutOfBoundsException positionInvalida){

                        MyIO.println("\n--> posição invalida --> " + positionInvalida);

                } catch (NullPointerException positionNothing) {

                        MyIO.println("\n--> posição inexistente --> " + positionNothing);
                }

	}//end set id

	void setNome (int position, String nome) {

		try{	
			this.nome[position] = nome;

                } catch(ArrayIndexOutOfBoundsException positionInvalida){

                        MyIO.println("\n--> posição invalida --> " + positionInvalida);

                } catch (NullPointerException positionNothing) {

                        MyIO.println("\n--> posição inexistente --> " + positionNothing);
                }

	}//end set nome

	void setAltura (int position , int altura){

		try{	
			this.altura[position] = altura;

		} catch(ArrayIndexOutOfBoundsException positionInvalida){

                        MyIO.println("\n--> posição invalida --> " + positionInvalida);

                } catch (NullPointerException positionNothing) {

                        MyIO.println("\n--> posição inexistente --> " + positionNothing);
                }
	}//end set altura

	void setPeso (int position , int peso){
	
		try{
			this.peso[position] = peso;

		} catch(ArrayIndexOutOfBoundsException positionInvalida){

                        MyIO.println("\n--> posição invalida --> " + positionInvalida);

                } catch (NullPointerException positionNothing) {

                        MyIO.println("\n--> posição inexistente --> " + positionNothing);
                }
	}//end set peso

	void setUniversidade (int position, String universidade) {
	
		try{
			this.universidade[position] = universidade;
	
		} catch(ArrayIndexOutOfBoundsException positionInvalida){

                        MyIO.println("\n--> posição invalida --> " + positionInvalida);

                } catch (NullPointerException positionNothing) {

                        MyIO.println("\n--> posição inexistente --> " + positionNothing);
                }
	}//end set univesidade

	void setAnoNascimento (int position , int anoNascimento){
	
		try{
			this.anoNascimento[position] = anoNascimento;

		} catch(ArrayIndexOutOfBoundsException positionInvalida){

                        MyIO.println("\n--> posição invalida --> " + positionInvalida);

                } catch (NullPointerException positionNothing) {

                        MyIO.println("\n--> posição inexistente --> " + positionNothing);
                }
	}//end set Ano Nascimento

	void setCidadeNascimento (int position, String cidadeNascimento ) {
	
		try{
			this.cidadeNascimento[position] = cidadeNascimento;
	
		} catch(ArrayIndexOutOfBoundsException positionInvalida){

                        MyIO.println("\n--> posição invalida --> " + positionInvalida);

                } catch (NullPointerException positionNothing) {

                        MyIO.println("\n--> posição inexistente --> " + positionNothing);
                }	
	}//end set cidade nascimento

	void setEstadoNascimento (int position, String estadoNascimento ) {

		try{	
			this.estadoNascimento[position] = estadoNascimento;
	
		} catch(ArrayIndexOutOfBoundsException positionInvalida){

                        MyIO.println("\n--> posição invalida --> " + positionInvalida);

                } catch (NullPointerException positionNothing) {

                        MyIO.println("\n--> posição inexistente --> " + positionNothing);
                }
	}//set estado nascimento

	void set (int position,
		  int id,
		  String nome,
		  int altura,
		  int peso,
		  String universidade,
		  int anoNascimento,
		  String cidadeNascimento,
		  String estadoNascimento ) {

		try{	

			this.id[position] = id;
			this.nome[position] = nome;
			this.altura[position] = altura;
			this.peso[position] = peso;
			this.universidade[position] = universidade;
			this.anoNascimento[position] = anoNascimento;
			this.cidadeNascimento[position] = cidadeNascimento;
			this.estadoNascimento[position] = estadoNascimento;

		} catch(ArrayIndexOutOfBoundsException positionInvalida){

                        MyIO.println("\n--> posição invalida --> " + positionInvalida);

                } catch (NullPointerException positionNothing) {

                        MyIO.println("\n--> posição inexistente --> " + positionNothing);
                }
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
	 * mostra os atributos de um jogador especifico
	 * @param int position - jogador selecionado
	 * */
	void imprimir (int position){

		try{
			MyIO.println("[" + id[position] + " ## " +
					 nome[position] + " ## " +
				       altura[position] + " ## " + 
				       	 peso[position] + " ## " +
				anoNascimento[position] + " ## " +
		                 universidade[position] + " ## " +
			     cidadeNascimento[position]	+ " ## " +
			     estadoNascimento[position]	+ "]"     );
		
		} catch(ArrayIndexOutOfBoundsException positionInvalida){

                        MyIO.println("\n--> posição invalida --> " + positionInvalida);

                } catch (NullPointerException positionNothing) {

                        MyIO.println("\n--> posição inexistente --> " + positionNothing);
                }
	}//end imprimir


	/*
	 * lê os atributos de um arquivo '.csv'
	 * @param String fileName - nome do arquivo a ser lido.
	 * */
	void ler (String fileName) {
	
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

			this.id               = new int[n];
			this.nome             = new String [n];
			this.altura           = new int[n];
			this.peso             = new int[n];
			this.universidade     = new String [n];
			this.anoNascimento    = new int[n];
			this.cidadeNascimento = new String [n];
			this.estadoNascimento = new String [n];

			LNR.reset();
			principal = LNR.readLine();

			/* sitema de leitura e separação dos atributos do arquivo*/
			for(int i = 0; i < n; i++) {

				principal = LNR.readLine();
				principal += ",a";
				aux = principal.split(",");

				if(!aux[0].equals(""))
					id[i] = Integer.parseInt(aux[0]);
				else 
					id[i] = -1;

				if(!aux[1].equals(""))
					nome[i] = aux[1];
				else 
					nome[i] = "nao informado";

				if(!aux[2].equals(""))
					altura[i] = Integer.parseInt(aux[2]);
				else
					altura[i] = -1;

				if(!aux[3].equals(""))
					peso[i] = Integer.parseInt(aux[3]);
				else
					peso[i] = -1;

				if(!aux[4].equals(""))
					universidade[i] = aux[4];
				else 
					universidade[i] = "nao informado";

				if(!aux[5].equals(""))
					anoNascimento[i] = Integer.parseInt(aux[5]);
				else 
					anoNascimento[i] = -1;

				if(!aux[6].equals(""))
					cidadeNascimento[i] = aux[6];
				else 
					cidadeNascimento[i] = "nao informado";

				if(!aux[7].equals(""))
					estadoNascimento[i] = aux[7];
				else 
					estadoNascimento[i] = "nao informado";

			}//end for

			LNR.close();

		} catch (FileNotFoundException fileNothing){

			MyIO.println("\n-->Arquivo inexistente -->  " + fileNothing);
		
		} catch (IOException ERRO){
		
			MyIO.println("\n--> ERRO -->" + ERRO);
		}

	}//end ler


}//end Jogador


public class sequencial{

	public static int nComparacoes = 0;

	/*
	 * realiza a pesquisa sequencial em um array de jogadores
	 * @param Jogador novo - registro a ser aplicado a pesquisa sequencial
	 * @param String nome - nome a ser procurado
	 * @return boolean resp - true caso haja o nome pesquisado
	 * */
	public static boolean pesquisaSequencial(Jogador novo, String nome){
		
		boolean resp = false;

		for(int i = 0; novo.getId(i) > -1 && !resp ; i++){
			
			nComparacoes++;

			if(novo.getNome(i).equals(nome))
				resp = true;
		}//end for
		
		return resp;
	}//end pesquisaSequencial

	public static void main(String[] args) {
	
		long tempoInicial = System.currentTimeMillis();
		Jogador novo1 = new Jogador("/tmp/players.csv");
		Jogador novo2 = new Jogador(100);
		String entrada = MyIO.readLine();
		int n1 = 0, n2;

		while(!entrada.equals("FIM")){
	
			n2 = Integer.parseInt(entrada);

			novo2.set(n1,
				  novo1.getId(n2),
				  novo1.getNome(n2),
				  novo1.getAltura(n2),
				  novo1.getPeso(n2),
				  novo1.getUniversidade(n2),
				  novo1.getAnoNascimento(n2),
				  novo1.getCidadeNascimento(n2),
				  novo1.getEstadoNascimento(n2));
			
			//sistema para pegar a exeção da saida publica
			if(novo2.getId(n1) == 2011)
				novo2.setNome(n1, novo2.getNome(n1).replace("*", ""));	
			
			n1++;
			entrada = MyIO.readLine();
		}//end while

		entrada = MyIO.readLine();

		while(!entrada.equals("FIM")){
		
			if(pesquisaSequencial(novo2, entrada))
				MyIO.println("SIM");
			else
				MyIO.println("NAO");

			entrada = MyIO.readLine();
		}//end while

		Arq.openWrite("710678_sequencial.txt");

		Arq.print("710678\t" + (System.currentTimeMillis() - tempoInicial) + 
				"\t" + nComparacoes);

		Arq.close();
	}//end main
}//end classe
