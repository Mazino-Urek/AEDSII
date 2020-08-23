/*
Nome: Diego Da Silva Ferreira
Matricula: 71 06 78

*/
public class cifra {

/*
 * avança todos os caracteres de uma String em 3 posições na tabela ascii
 * @param String s - frase a ser criptografada
 * @return String resp - frase criptografada
 */
public static String cezar (String s){

	String resp = "";
	
	for(int x = 0; x < s.length(); x++){
	
		resp += (char) (s.charAt(x) + 3);
	}

	return resp;
}


public static void main (String[] args){

	String s = MyIO.readLine();

	//verifica se s é igual a "FIM"
	while(!(s.length() == 3 && 
		s.charAt(0) == 'F' && 
		s.charAt(1) == 'I' && 
		s.charAt(2) == 'M')){
		
		MyIO.println(cezar(s));

		s = MyIO.readLine();

	}

}
}
