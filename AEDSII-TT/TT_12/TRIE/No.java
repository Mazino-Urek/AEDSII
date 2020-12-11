class No{

	public No[] letras;
	public boolean cor;

	No(){

		letras = new No[26];
		for(int i = 0; i < 26; i++)
			letras[i] = null;
		this.cor = false;
	}//end contrutor

	No(boolean cor){
		letras = new No[26];
		for(int i = 0; i < 26; i++)
			letras[i] = null;
		this.cor = cor;
	}//end contrutor

        public int indice(char letra){ 
                return ((char)((int)letra - 97));
        }//end indice

	public boolean verifica(){
		boolean resp = false;
		for(int i = 0; i < 26; i++){
			if(letras[i] != null){
				resp = true;
				i = 26;
			}//end if
		}//end for
		return resp;
	}//end verifica
}//end NoT
