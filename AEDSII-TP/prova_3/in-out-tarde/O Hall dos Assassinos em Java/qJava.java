/*
 * Nome: Diego Da Silva Ferreira
 * Matricula: 71 06 78
 * */

class Celula{
	public String nome;
	public boolean vida;
	public int quant;
	public Celula prox;
	
	Celula(){
	//	this("");
	}//end construtor

	Celula(String nome, int quant, boolean vida){
		this.nome = nome;
		this.prox = null;
		this.quant = quant;
		this.vida = vida;
	}//end construtor
}//end celula

class Lista {

	private Celula primeiro, ultimo;

	Lista(){
		primeiro = new Celula();
		ultimo = primeiro;
	}//end construtor 

	void inserirFim(String nome, int num, boolean vida){
		ultimo.prox = new Celula(nome, num, vida);
		ultimo = ultimo.prox;
	}//end inserirFim

	public void assacinato(String assa, String vit){
	
		Celula cel1, cel2;
		cel1 = pesquisar(assa);
		cel2 = pesquisar(vit);

		if(cel1 == null){
			inserirFim(assa, 1, true);
		}
		else{
			cel1.quant++;
		}

		if(cel2 == null){
			inserirFim(vit, 0, false);
		}
		else{
			cel2.vida = false;
		}
	}

	public Celula pesquisar(String nome){
		Celula resp = null;

		for(Celula i = primeiro.prox; i != null; i = i.prox){
			if(i.nome.equals(nome)){
				resp = i;
				i = ultimo;
			}//end if
		}//end for
		return resp;
	}//end pesquisar

	public void mostrar(){
	
		MyIO.println("HALL OF MURDERERS");

		for(Celula i = primeiro.prox; i != null; i = i.prox){
			if(i.vida){
				MyIO.println(i.nome + " " + i.quant);
			}
		}
	}
}//end Lista

class qJava{
	public static void main(String[] args){
	
		String nome1, nome2;
		Lista lista = new Lista();

		nome1 = MyIO.readString();
		while(!nome1.equals("FIM")){
			nome2 = MyIO.readString();
			lista.assacinato( nome1, nome2   );
			nome1 = MyIO.readString();
		}//end while
		lista.mostrar();	
	}//end main
}//end qJava


