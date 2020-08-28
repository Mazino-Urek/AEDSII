/*
 * Nome : Diego Da Silva Ferreira
 * Mateicula : 71 06 78
 *
 * */

import java.net.*;
import java.io.*;

public class html {

	/*
	 * copia o codigo html de um pagina web para uma String
	 * @param String endereco - url da pagina web
	 * @return Strig resp - copia do html
	 * */
	public static String getStringHtml (String endereco) throws IOException{
	
		String resp = "", linha;
		URL url = new URL (endereco);
		BufferedReader buf = new BufferedReader(new InputStreamReader(url.openStream()));

		while ((linha = buf.readLine()) != null)
			resp += linha;

	
		return resp;
	}

	/*
	 * conta a quantidade de vogais (incluindo os acentuados), consoantes ,<br> e <bable> 
	 * presentes em uma string e os printa na tela
	 * @param String s - String a ser analizada
	 * @param String nomePagina - nome da pagina analizada
	 * */
	public static void conta (String s , String nomePagina){
	
		int a = 0,  aa = 0, aaa = 0, aaaaa = 0, oooo = 0,
		    e = 0,  ee = 0, eee = 0, ooooo = 0, uuuu = 0,
		    i = 0,  ii = 0, iii = 0, aaaa = 0, consoante = 0,
		    o = 0,  oo = 0, ooo = 0, eeee = 0, br = 0,
		    u = 0,  uu = 0, uuu = 0, iiii = 0, table = 0;
		

		for(int x = 0; x < s.length(); x++){
		
			if (s.charAt(x) == 'a')
					a++;
			
			else if(s.charAt(x) == 'e')
					e++;

			else if(s.charAt(x) == 'i')
					i++;

			else if(s.charAt(x) == 'o')
					o++;

			else if(s.charAt(x) == 'u')
					u++;

			else if(s.charAt(x) == (char)(225))
					aa++;
		
			else if(s.charAt(x) == (char) (233))
					ee++;

			else if(s.charAt(x) == (char)(237))
					ii++;

			else if(s.charAt(x) == (char)(243))
					oo++;

			else if(s.charAt(x) == (char)(250))
					uu++;

			else if(s.charAt(x) == (char)(224))
					aaa++;

			else if(s.charAt(x) == (char)(232))
					eee++;

			else if(s.charAt(x) == (char)(236))
					iii++;

			else if(s.charAt(x) == (char)(242))
					ooo++;

			else if(s.charAt(x) == (char)(249))
					uuu++;

			else if(s.charAt(x) == (char)(227))
					aaaaa++;

			else if(s.charAt(x) == (char)(245))
					ooooo++;
	
			else if(s.charAt(x) == (char)(226))
					aaaa++;

			else if(s.charAt(x) == (char)(234))
					eeee++;

			else if(s.charAt(x) == (char)(238))
					iiii++;

			else if(s.charAt(x) == (char)(244))
					oooo++;

			else if(s.charAt(x) == (char)(251))
					uuuu++;

			else if(s.charAt(x) >= 'a' && s.charAt(x) <= 'z')
					consoante++;

			else if(s.charAt(x) == '<')
			{
				if(s.charAt(x+1) == 'b' && 
			           s.charAt(x+2) == 'r' && 
				   s.charAt(x+3) == '>')
				{
					br++;
					x += 4;

				}//end if
				else if(s.charAt(x+1) == 't' && 
				        s.charAt(x+2) == 'a' && s.charAt(x+3) == 'b' && 
					s.charAt(x+4) == 'l' && s.charAt(x+5) == 'e' && 
					s.charAt(x+6) == '>')
				{
					table++;
					x += 7;
				}//end if
			}//end if
		}//end for


		MyIO.println( "a(" + a     + ") " +
			      "e(" + e     + ") " +
			      "i(" + i     + ") " +
			      "o(" + o     + ") " +
			      "u(" + u     + ") " +
			      "á(" + aa    + ") " +
			      "é(" + ee    + ") " +
			      "í(" + ii    + ") " +
			      "ó(" + oo    + ") " +
			      "ú(" + uu    + ") " +
			      "à(" + aaa   + ") " +
			      "è(" + eee   + ") " +
			      "ì(" + iii   + ") " +
			      "ò(" + ooo   + ") " +
			      "ù(" + uuu   + ") " +
			      "ã(" + aaaaa + ") " +
			      "õ(" + ooooo + ") " +
			      "â(" + aaaa  + ") " +
			      "ê(" + eeee  + ") " +
			      "î(" + iiii  + ") " +
			      "ô(" + oooo  + ") " +
			      "û(" + uuuu  + ") " +

			      "consoante(" + consoante + ") " +
			      "<br>("      + br        + ") " + 
			      "<table>("   + table     + ") " +
			      nomePagina );


	
	}//end contar


	public static void main(String[] args) throws IOException{

		String nomePagina = MyIO.readLine();
	

		//metodo para verificar se string é igual a "FIM"
		while(!(nomePagina.length() == 3 &&
			nomePagina.charAt(0) == 'F' &&
			nomePagina.charAt(1) == 'I' &&
			nomePagina.charAt(2) == 'M')){

			conta( getStringHtml( MyIO.readString() ) , nomePagina );

			

			nomePagina = MyIO.readLine();

		}//end while
	

	
	}//end main
}//end html
