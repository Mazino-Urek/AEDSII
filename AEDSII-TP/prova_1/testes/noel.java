public class noel {


	public static String[] ordena(String[] nomes){

		int j;
		String aux;

		for(int i = 1; i < nomes.length; i++ ){
			aux = nomes[i];
			j = i-1;

			while(j >= 0 && aux.compareTo(nomes[j]) < 0 ){

				nomes[j+1] = nomes[j];
				j--;
			}
			nomes[j+1] = aux;			
		}
		return nomes;
	}


	public static void main (String[] arags){

		int nu = MyIO.readInt();
		int com = 0, ncom = 0;

		String nomes[] = new String[nu];
		char comportadas, aux;

		for(int i = 0; i < nu; i++){

			comportadas = MyIO.readChar();
			aux = MyIO.readChar();


			nomes[i] = MyIO.readLine();


			if(comportadas == '+')
				com++;
			else
				ncom++;

		}

		nomes = ordena(nomes);

		for(int i = 0; i < nu; i++)
			MyIO.println(nomes[i]);

		MyIO.println("Se comportaram: " + com + " | Nao se comportaram: " + ncom);
	}
}
