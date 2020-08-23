/*
Nome: Diego Da Silva Ferrera
Matricula: 71 06 78
*/

public class palindromo {

/*
 *testa se a String é um palindromo
 *@param String s - string a ser verificada
 *@return bollean resp - retorna true caso a string seja um palindromo e false caso contrario
 * */
public static boolean teste (String s){

	boolean resp = true;
	int a = s.length() - 1;

	for(int x = 0; x < a; x++){
		if(s.charAt(x) != s.charAt(a)){
			resp = false;
			x = a;
		}
		a--;
	}
	return resp;

}

public static void main(String[] args){
	
	boolean x = true;
	String s = MyIO.readLine();

	//metodo para verificar se string é igual a "FIM"
	while(!(s.length() == 3 && 
		s.charAt(0) == 'F' && 
		s.charAt(1) == 'I' && 
		s.charAt(2) == 'M')){

		
			if(teste(s)){
				System.out.println("SIM");
			}
			else{
				System.out.println("NAO");
			}	
		
		s = MyIO.readLine();

	}

}
}

