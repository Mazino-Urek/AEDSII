/*
 * Nome: Diego Da Silva Ferreira
 * Matricula: 71 06 78
 *
 * questão 3: Execute e brinque com os arquivos
 * ExemploRAF01Escrita.java, ExemploRAF02Leitura.java e
 * ExemploRAF03Cabecote.java 
 * */

import java.io.*;
class ExemploRAF02Leitura {
	public static void main (String[] args) throws Exception{
		RandomAccessFile raf = new RandomAccessFile("exemplo.txt", "rw");
		
		for(int x = 0; x < 10; x++){

			System.out.println(raf.readLine());

			for(int a = x; a >= 0; a--){
				System.out.print("  ");
			}

		}
		raf.close();
	}
}
