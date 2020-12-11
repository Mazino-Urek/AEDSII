class Trie{
	
	private No raiz;

	Trie(){
		raiz = new No();
	}//end construtor

	public void inserir(String nome)throws Exception{
		inserir(conversor(nome), 0, raiz);	
	}//end inserir

	public void inserir(String nome, int i, No no)throws Exception{
	
		if(no.cor)
			throw new Exception("erro ao inserir 2");
		else if(i == (nome.length())){
				no.cor = true;
				no.letras = null;
		}
		else{
			char letra = nome.charAt(i);
			int prox = no.indice(letra);
			if(no.letras[prox] == null){
				no.letras[prox] = new No();	
				inserir(nome, i + 1, no.letras[prox]);
			}
			else if(i < nome.length() - 1)
				inserir(nome, i + 1, no.letras[prox]);
			else
				throw new Exception("erro ao inserir 1");
		}//end else
	}//end inserir

	public boolean pesquisar(String nome){
		return pesquisar(conversor(nome), 0, raiz);
	}//end pesquisar
	
	public boolean pesquisar(String nome, int i, No no){
		boolean resp;

		if(no.cor)
			if(i == nome.length())
				resp = true;
			else
				resp = false;
		else{
			char letra = nome.charAt(i);
			int prox = no.indice(letra);
			if(no.letras[prox] == null)
				resp = false;
			else
				resp = pesquisar(nome, i+1, no.letras[prox]);
		}
		return resp;
	}//end pesquisar

	public void mostrar(){
		mostrar("", raiz);
	}//end mostrar

	public void mostrar(String nome, No no){
		if(no.cor)
			MyIO.println(nome);
		else
			for(int i = 0; i < 26; i++)
				if(no.letras[i] != null)
					mostrar((nome + (char)(i + 97)), no.letras[i]);	
	}//end mostrar

	public void contaletra(char letra){
		MyIO.println(contaletra(letra, raiz));
	}//end mostrar

	public int contaletra(char letra, No no){
		int resp = 0;
		if(!no.cor)
			for(int i = 0; i < 26; i++)
				if(no.letras[i] != null){
					if(no.letras[no.indice(letra)] != null)
						resp++;	
					resp += contaletra(letra, no.letras[i]);	
				}
		return resp;
	}//end mostrar




	/*
	 * converte letras maiusculas em minusculas e elemina caracteres especiais
	 * @param String nome - string a ser tratada
	 * @return String resp - String tratada 
	 * */
	public String conversor(String nome){
		String resp = "";
		char letra;

		for(int i = 0; i < nome.length(); i++){
			letra = nome.charAt(i);
			if(letra >= 'a' && letra <= 'z')
				resp += letra;
			else
				if(letra >= 'A' && letra <= 'Z'){
					letra = (char)((int)letra + 32);
					resp += letra;
				}
		}//end for
		return resp;	
	}//end conversor
}//end trie
