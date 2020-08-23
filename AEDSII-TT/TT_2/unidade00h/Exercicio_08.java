/*
 * Nome: Diego Da Silva Ferreira
 * Matricula: 71 06 78
 *
 * Questão 08: Faça um método recursivo que receba um array de inteiros e os ordene
 * */



import java.util.Random;


public class Exercicio_08 {

	/*
	 * ordena o array recursivamente
	 * @param int a - posição a ser ordenada
	 * @param int b - procura no array
	 * @param int c[] - array a ser ordenado
	 * @return int c - array ordenado
	 * */
	public static int[] or (int a, int b, int c[]){
	
		int p = 0;
	

		if((a + 1) < c.length){
				if(b < c.length){

					if(c[a] > c[b]){

						p = c[a];
						c[a] = c[b];
						c[b] = p;
					}

					c = or(a , b + 1, c);

				}
				else{
					c = or(a +1, a + 2, c );
				}
			
		}	
		
		return c;		
	
	}//end or

	/*
	 * chama a funcção recursiva de ordenação pasando menos parametros
	 * @param int c[] - array a ser ordenado
	 * @return - array ordenado
	 * */
	public static int[] or(int c[]){
		return or(0 , 1, c);
	}//end or

	public static void main (String[] args){
	
		Random ram = new Random();

		int[] novo = new int[10];
		int[] resp;

		System.out.println();

		for(int a = 0; a < novo.length; a++){
		
			novo[a] = ram.nextInt(10);
			System.out . print(novo[a] + ", ");	
		}

		resp = or(novo);

		System.out.println("\n");

		for(int s = 0; s < resp.length; s++){
			
			System.out.print(resp[s] + ", ");
		}

		System.out.println();
	}
}
