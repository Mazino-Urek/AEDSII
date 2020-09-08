/*
 * Nome : Diego Da Silva Ferrerira
 * Matricula : 71 06 78
 *
 * */


class Boleano {

	private int quantidade;
	private int[] valor;
	private String bool;
	private int cabecote;

	/*
	 * construtor, inicializa variaveis
	 * */
	Boleano () {
	
		this.cabecote = 0;
		this.valor = new int[3];
	}

	/*
	 * redefine valores dos atributos da class
	 * @param int quantidade - quantidade de oprandos a serem lidos
	 * */
	void redefinir (int quantidade) {
	
		this.cabecote = 0;
		this.quantidade = quantidade;

		for(int x = 0; x < quantidade; x++){
		
			this.valor[x] = MyIO.readInt();		
		}

		this.bool = MyIO.readLine();
		nullspace();	

	}

	/*
	 * retira espaços da String bool
	 * */
	void nullspace () {

		String resp = "";

		for(int x = 0; x < bool.length(); x++)
			if(this.bool.charAt(x) != ' ' )
				resp += this.bool.charAt(x);
			
		this.bool = resp;

	}

	/*
	 * realiza a operação not (!)
	 * @return bolean resp - resposta da operação
	 * */
	boolean not () {
		
		boolean resp;	
		
		cabecote += 4;
		resp =  ! interpretador();
		cabecote++;

		return resp;

	
	}//end not

	/*
	 * realiza a operação and (&&)
	 * @return bolean resp - resposta da operação
	 * */
	boolean and () {
	
		boolean aux , resp;
		cabecote += 4;
		resp = interpretador();
		cabecote++;
		while(this.bool.charAt(cabecote) == ','){
			cabecote++;
			aux = interpretador();
			resp = resp && aux;
			cabecote++;
		}//end while

		return resp;
	}//end and

	/*
	 * realiza a operação or (||)
	 * @return boolean resp - resposta da operação
	 * */
	boolean or () {
	
		boolean aux , resp;
		cabecote += 3;
		resp = interpretador();
		cabecote++;
		while(this.bool.charAt(cabecote) == ','){

			cabecote++;
			aux = interpretador();
			resp = resp || aux;
			cabecote++;
		}//end while

		return resp;
	}//end or

	/*
	 * interpreta uma espreção boolean presente na string bool
	 * @return boolean resp - resposta da operação boolean 
	 * */
	boolean interpretador (){
	
		boolean resp = true;
		char a = this.bool.charAt(cabecote);

		if(a == 'A')
                          resp =  valor[0] == 1;
 
                else if(a == 'B')
                          resp = valor[1] == 1;
 
                else if(a == 'C')
                          resp = valor[2] == 1;

		else if(a == 'n')
			resp = not();

		else if(a == 'a')
			resp = and();

		else if(a == 'o')
			resp = or();

		return resp;
	}//end interpretador
}//end boleano


public class algebra {

	public static void main(String[] args){

		int x = MyIO.readInt();
		Boleano novo = new Boleano();

		while(x != 0){

			novo.redefinir(x);

			if(novo.interpretador()){

				MyIO.println("1");
			}
			else{

				MyIO.println("0");
			}

			x = MyIO.readInt();
		}
	}
}
