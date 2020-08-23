/*
 * Nome: Diego Da Silva Ferreira
 * Matricula: 71 06 78
 *
 * Questão 09: Faça um método recursivo para cada um dos problemas abaixo
 * */

public class Exercicio_09 {

	/*
	 * calcula a segunte função:T(0) = 1 
	 * 			    T(1) = 2
	 * 			    T(n) = T(n-1) * T(n-2) - T(n-1)
	 * @param int n - termo a ser calculado
	 * @return int 1 - caso n seja igual a 0
	 * @return int 2 - caso n seja igual a 1
	 * @return int resp - calculo do termo (caso n > 1)
	 * */
	public static int problema01 (int n){
	
		int resp = 0;

		if(n == 0){
			return 1;
		}
		else{
			if(n == 1){
				 return 2;
			}
		}

		resp += (problema01(n - 1) * problema01(n - 2)) - problema01(n - 1);

		return resp;


	}

	/*
	 * solução pra o problema: t(0) = 1
	 * 			   T(n) = T(n -1)²
	 * @param int n - termo a ser calculado
	 * @return int 1 - caso n == 0
	 * @return int resp - resultado do termo calculado (caso n > 0)
	 * */
	public static int problema02(int n){
	
		int resp = 0;

		if(n == 0){
		
			return 1;
		}

		resp += problema02(n- 1) * problema02(n - 1);

		return resp;


	}


	public static void main (String[] args){
	
		int x = MyIO.readInt();

		switch(x){
		
			case 1:
				MyIO.println(problema01(MyIO.readInt()));
			break;
	
			case 2:
				MyIO.println(problema02(MyIO.readInt()));
			break;
		}
	}




}
