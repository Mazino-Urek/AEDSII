/*
 * Nome: Diego Da Silva Ferreira
 * Matricula : 71 06 78
 *
 * */

import java.io.*;

public class arquivo{

	public static void main (String[] args) throws IOException{
	
		int x = MyIO.readInt();
		double aux;

		RandomAccessFile raf = new RandomAccessFile("novoarq.txt" , "rw");

		for(int a = 0; a < x; a++){
		
			raf.writeDouble(MyIO.readDouble());
		}

		raf.close();


		raf = new RandomAccessFile("novoarq.txt" , "rw");

		x--;
		while(x >= 0){
		
			raf.seek(x * 8);
			aux = raf.readDouble();

			/*mecanismo para evitar printar a 
			 *parte fracionaria caso ela não exista
			 */
			if((aux - (int)aux) > 0){
			
				MyIO.println(aux);
			}
			else{
			
				MyIO.println((int)aux);
			}
		
			x--;
		}
		
		raf.close();
	}
}
