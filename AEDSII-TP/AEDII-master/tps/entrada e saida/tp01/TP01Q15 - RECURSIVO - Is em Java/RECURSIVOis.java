/*
 * Nome: Diego Da Silva Ferreira
 * Matricula : 71 06 78
 *
 * */



class Is {

	private String s;
	private boolean[] resp;
	private int virgula;

	/*
	 * construtor 
	 * */
	Is (){
	
		this.s = "";
		virgula = 0;
		resp = new boolean[4];
		for(int i = 0; i < resp.length; i++)
				resp[i] = true;
	
	}//end construtor Is

	/*
	 * redefine o valor da String s
	 * e seta o valores de resp como true
	 * */
	void setString (String s) {
	
		this.s = s;	
		virgula = 0;
		for(int i = 0; i < resp.length; i++)
			resp[i] = true;

	}//end setString


	/*
	 * verifica e transforma caracteres maiusculos em minusculos
	 * @param char x - caractere a ser verificado e transformado
	 * @return char x - retorna o cactere minusculo (exeto se ele não for letra)
	 * */
	char tMinusculo (char x){

		if(x >= 'A' && x <= 'Z'){

			return (char) (x + 32);
		}

		return x;
	}//end tMinusculo

	/*
	 * verifica se o caractere é vogal
	 * @param char c - caractere a ser verificado
	 * @retun boolean - true caso o caractere seja vogal e false caso contrario
	 * */
	boolean isVogal(char c){

		return (tMinusculo(c) == 'a' ||
			tMinusculo(c) == 'e' ||
			tMinusculo(c) == 'i' ||
			tMinusculo(c) == 'o' ||
			tMinusculo(c) == 'u');

	}//end is vogal



	/*
	 * percorre a string s verificando se ela é composta por
	 * vogais , consoantes , inteiros ou reais
	 * @param int cabecote - percorrea a string (utilizado na recursividade)
	 * */
	void is (int cabecote){
	
		char caractere = s.charAt(cabecote); 

		if (isVogal(caractere)){
		    
			resp[1] = false;
			resp[2] = false;
			resp[3] = false;			
		    
		    }
		else if(tMinusculo(caractere) >= 'a' && tMinusculo(caractere) <= 'z'){
		
			resp[0] = false;
			resp[2] = false;
			resp[3] = false;		
		}
		else if(caractere >= '0' && caractere <= '9' ) {
		
			resp[0] = false;
			resp[1] = false;
		}
		else if(caractere == ',' || caractere == '.'){
			
			virgula++;

			if(virgula > 1){
				
				resp[3] = false;
			}
			else{
				resp[2] = false;
			}
		}
		else{
		
				resp[0] = false;
				resp[1] = false;
				resp[2] = false;
				resp[3] = false;
				cabecote = this.s.length();
		}

		if(cabecote < (s.length() - 1))
			is(cabecote + 1);
	}//end is


	/*
	 * printa os resultados do metodo is
	 * */
	void printIs() {
	
		is(0);

		if(resp[0]){ MyIO.print("SIM");}
		else{MyIO.print("NAO");}

		if(resp[1]){ MyIO.print(" SIM");}
		else{MyIO.print(" NAO");}

		if(resp[2]){ MyIO.print(" SIM");}
		else{MyIO.print(" NAO");}

		if(resp[3]){ MyIO.println(" SIM");}
		else{MyIO.println(" NAO");}
	
	}//end printIs
}//end Is


public class RECURSIVOis{

	public static void main (String[] args){

		String s = MyIO.readLine();
		Is resp = new Is();

		//verifica se s é igual a "FIM"
		while(!(s.length() == 3 &&
			s.charAt(0) == 'F' &&
			s.charAt(1) == 'I' &&
			s.charAt(2) == 'M')){

			
			resp.setString(s);
			resp.printIs();

			s = MyIO.readLine();

		}//end while
	}//end main
}//end RECURSIVOis
