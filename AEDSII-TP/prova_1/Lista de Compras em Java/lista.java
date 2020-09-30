/*
 * Nome: Diego Da Silva Ferreira
 * Matricula: 71 06 78
 * 
 * */

public class lista{


	//tamanho do array
	public static  int n = 0;


	/*
	 * execlui palavers repetidos em um array de String
	 * @param String array - a ser vasculhado
	 * @return String[] resp - array de strings sem palavras repetidas
	 * */
	public static String[] exclui (String[] array){

		n = 1;
		boolean aux;
		String[] resp = new String[100];

		resp[0] = array[0];

		for(int i = 1; i < array.length; i++){
			
			aux = true;

			for(int j = 0; j < n; j++){

				if(array[i].compareTo(resp[j]) == 0)
					aux = false;
			}

			if(aux){
				resp[n] = array[i];
				n++;
			}

		}//end for
		return resp;
	}//end exclui


	/*
	 * ordena um vetor de strings
	 * @param String[] array - vetor a ser ordenado
	 * */
	public static void ordena (String[] array){


		String tmp;
		boolean aux;
		int j;

		for(int i = 1; i < n; i++ ){

			 tmp = array[i];
			 j = i-1;

			 while((j >= 0) && ( array[j].compareTo(tmp) > 0)){
				array[j+1] = array[j];
				j--;		

			}//end while

			array[j+1] = tmp;
		}//end for
	}//end ordena


	public static void main(String[] args){

		String[] array;
		String linha;
		int tam = MyIO.readInt();

		for(int i = 0; i < tam; i++ ){

			linha = MyIO.readLine();
			array = linha.split(" ");

			array = exclui(array);

			ordena(array);

			for(int j = 0; j < n; j++)
				MyIO.print(array[j] + " ");

			MyIO.println("");		
		
		}//end for
	}//end main
}//end lista


