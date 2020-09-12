/*
 * Nome: Diego Da Silva Ferreira
 * Matricula: 71 06 78
 * */

import java.util.Random;

class IB {

	private int[] array;

	//construtor aleatrio
	IB (int n) {
	
		array = new int[n];
	      	
		Random ram = new Random();
		
		for (int i = 0; i < n; i++)
			array[i] = ram.nextInt(100);
	
	}//end IB

	//construtor do pior caso
	IB () {
	
		array = new int[10];

		for(int i = 0; i < 10; i++)
			array[i]= 10 - i;
	}//end IB


	/*
	 * printa o array por completo
	 * */
	void printarray (){
	
		for(int i = 0; i < array.length; i++)
			System.out.print( "[" +array[i] + "] ");

		System.out.println();
	}//end printarray



	/*
	 * realiza a pesquisa binaria e movimenta elementos a array
	 * @param int posicao - setor da array a ser realizada a pesquisa
	 * @param int troca - elemento a ser ordenado.
	 * */
	void pesquisaB (int posicao, int troca){
	
		int inf = 0 ,sup = posicao, pino = (sup - 1) / 2, resp = 0;
		boolean aux = true;

		while((inf <= sup) && aux ) {	

			if(array[pino] <= troca  && array[pino+1] > troca){
			
				aux = false;
				resp = pino + 1; 
			}//end if
			else{

				if(array[pino] < troca)
					inf = pino +1;
				else
					sup = pino - 1;		
			}//end else

			pino = (inf + sup) / 2;
		}//end while
		
		
		for(; posicao >= resp && posicao > 0; posicao--)
			array[posicao] = array[posicao - 1];

		array[resp] = troca;
	}//end pesquisaB


	/*
	 * realiza a ordenação do array por inserção
	 * */
	void insercao (){
	
		int tmp, j;

		for (int i = 1; i < array.length; i++) {
			tmp = array[i];

			j = i - 1;

			if((array[j] > tmp))
				pesquisaB(i , tmp);

		}//end for
	}//end insecao

}//end IB



class exercicio_02 {

	public static void main (String[] args){

		IB teste = new IB(MyIO.readInt());

		teste.printarray();

		teste.insercao();

		teste.printarray();
	
	
	}//end main
}//end exercicio_02
