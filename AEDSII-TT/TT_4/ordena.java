/*
 * Nome : Diego Da Silva Ferreira
 * Matricula : 71 06 78
 * V 1.0
 * */

public class ordena {








	public static void main (String[] args){
	
		int[] array = new int[18];
		array[0]  = 12 ;
		array[1]  = 4;
		array[2]  = 8;
		array[3]  = 2;
		array[4]  = 14;
		array[5]  = 17;
		array[6]  = 6;
		array[7]  = 18;
		array[8]  = 10;
		array[9]  = 16;
		array[10] = 15;
		array[11] = 5;
		array[12] = 13;
		array[13] = 9;
		array[14] = 1;
		array[15] = 11;
		array[16] = 7;
		array[17] = 3;
		int menor;
		int segura = 0;
		int n = array.length;

		for (int i = 0; i < (n - 1); i++) {
			menor = i;

			MyIO.print("\narray : ");
			for(int z = 0; z < array.length; z++){
				MyIO.print("[" + array[z] + "] ");
			}

			for (int j = (i + 1); j < n; j++){

				MyIO.print("\ncomparação : " + array[menor] + " > " + array[j]);

				if (array[menor] > array[j]){
					menor = j;
				}
			}
			
			MyIO.println("\n\nmovimentações :");
			segura = array[i];
		
			for(int z = 0; z < array.length; z++){
                                MyIO.print("[" + array[z] + "] ");
                        }

			array[i] = array[menor];
			MyIO.println("");

                        for(int z = 0; z < array.length; z++){
				MyIO.print("[" + array[z] + "] ");
			}
		
			array[menor] = segura;
			MyIO.println("");
		
			for(int z = 0; z < array.length; z++){
				MyIO.print("[" + array[z] + "] ");
			}
			MyIO.println("\n\nfim movimetção\n");
		}
	}
}


