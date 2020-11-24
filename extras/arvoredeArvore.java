
class NoChar {

	public char letra;
	public NoChar dir, esq;
	public NoString palavra;

	NoChar (char letra) {
		this.letra = letra;
		this.dir = null;
		this.esq = null;
		this.palavra = null;
	}
}

class NoString {

	public String palavra;
	public NoString esq, dir;

	NoString (String palavra) {
	
		this.palavra = palavra;
		this.esq = null;
		this.dir = null;
	}
}

class ADA {

	private NoChar raiz;

	ADA () throws Exception{

		int letra = 108;
		
		for(int i = 109; i <= 122 && letra >= 97; i++, letra-- ){
			inserir((char) i);
			inserir((char) letra);
		}
	}

	/*
	 * insere um elemento na arvore
	 * @param Jogador jogador - elemento a ser inserido
	 * */
	private void inserir (char letra) throws Exception{
		raiz = inserir(letra, raiz);
	}//end inserir

	private NoChar inserir (char letra , NoChar i) throws Exception{

		if(i == null)
			i = new NoChar(letra);
		else if(letra > i.letra)
			i.esq = inserir(letra, i.esq);
		else if(letra < i.letra)
			i.dir = inserir(letra , i.dir);
		else
			throw new Exception("Erro --");
		return i;
	}//end inserir





}



class arvoredeArvore {

	public static void main (String[] args) throws Exception{
	
		ADA teste = new ADA();
	
	}

}






