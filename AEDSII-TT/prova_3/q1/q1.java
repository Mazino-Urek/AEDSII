
/*
 * Nome: Diego Da Silva Ferreira
 * Matricula: 71 06 78
 * */

public boolean pesquisa(String nome, int i, No no){
	boolean resp = false;

	if(no.cor){
		if(i == nome.length()){
			resp = true;
		}
		else{
			resp = false;
		}
	}
	else{
		char caractere = nome.charAt(i);
		No tmp = no.arvore.pesquisar(caractere).elemento;
		if(tmp == null){
			resp = false;
		}
		else{
			pesquisa(nome, i + 1, tmp);
		}
	}//end else
	return resp;
}//end pesquisar

public pesquisa(String nome){
	return pesquisa(nome, 0, raiz);
}//end pesquisa




/*
 * Analize de complexidade
 * comparações
 * pior caso: 3n * m comparações --> O(n*m)
 * melhor caso: 5 comparações --> O(1)
 *
 * */














