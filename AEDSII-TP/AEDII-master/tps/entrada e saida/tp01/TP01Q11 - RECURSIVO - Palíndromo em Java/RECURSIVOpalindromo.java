/*
 * Nome : Diego Da Silva Ferreira
 * Matricula : 71 06 78
 *
 * */


public class RECURSIVOpalindromo {

	/*
	 * verifica se um string é um palindromo 
	 * @param String s - string a ser analizada
	 * @param int cabecote - percorre a string (utilizado na rcursividade)
	 * @return boolean resp - true cao a string seja um palindromo
	 * */
	public static boolean isPalindromo (String s , int cabecote){
	
		boolean resp = true;

		if(cabecote < (int) (s.length() /2) ){
			if(s.charAt(cabecote) == s.charAt((s.length() - 1) - cabecote))
				resp = isPalindromo(s , cabecote + 1);
			else 
				resp = false;
		}//end if
			
		return resp;
	}//end isPalindromo


	/*
	 * chama a função recursiva isPalindromo 
	 * @param String s - string a ser analizada 
	 * @return boolean - true caso a string seja um palindromo
	 * */
	public static boolean isPalindromo (String s){
	
		return isPalindromo(s , 0);
	}//end isPalindromo


	public static void main (String[] args) {
	
		String s = MyIO.readLine();

		//metodo para verificar se string é igual a "FIM"
		while(!(s.length() == 3 && 
			s.charAt(0) == 'F' && 
			s.charAt(1) == 'I' && 
			s.charAt(2) == 'M')){

			if(isPalindromo(s)){
				System.out.println("SIM");
			}
			else{
				System.out.println("NAO");
			}	

			s = MyIO.readLine();
		
		}//end while	
	}//end 
}//end RECURSIVOpalindromo
