/*
 * Nome : Diego Da Silva Ferreira 
 * Matricula : 71 06 78 
 *
 * */

public class RECURSIVOciframento {
	
	/*
	 * cifra uma String com o ciframento de cezar (+3)
	 * @param String s - String a ser cifrada
	 * @param int cabecote - percorre a string (utilizado na recursividade)
	 * @return String resp - string cifrada
	 * */
	public static String cezar (String s , int cabecote) {
	
		String resp = "";

		if(s.length() > cabecote){
		
			resp += (char) (s.charAt(cabecote) + 3);
			resp += cezar (s, cabecote + 1);	
		}//end if

		return resp;	
	}//end cezar
	

	/*
	 * chama a função recursiva cezar
	 * @String s - String a ser cifrada pela função
	 * @return String - String cifrada;
	 * */
	public static String cezar (String s){
	
		return cezar(s, 0);
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

		}//end while

	}//end main
}//end  recursivociframento
