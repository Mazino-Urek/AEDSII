

class principal{

	public static void main (String[] args)throws Exception{
	
		Trie tt = new Trie();

		tt.inserir(MyIO.readString());
		tt.inserir(MyIO.readString());
		tt.inserir(MyIO.readString());
		
		tt.contaletra('d');

		tt.mostrar();

		MyIO.println(tt.pesquisar(MyIO.readString()));
		MyIO.println(tt.pesquisar(MyIO.readString()));
		MyIO.println(tt.pesquisar(MyIO.readString()));

	
	}

}
