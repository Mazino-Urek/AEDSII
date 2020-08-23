/*
 * Nome: Diego Da Silva Ferreira
 * Matricula: 71 06 78
 *
 * questão 3: Execute e brinque com os arquivos
 * ExemploRAF01Escrita.java, ExemploArq02Leitura.java e
 * ExemploRAF03Cabecote.java 
 * */

import java.io.*;
class ExemploRAF01Escrita {
	public static void main (String[] args) throws Exception{
		RandomAccessFile raf = new RandomAccessFile("exemplo.txt", "rw");
		
		for(int x = 0; x < 10; x++){
			raf.writeBytes("Algoritimos");
			raf.writeBytes("\n");
			for(int a = x; a >= 0; a--){
				raf.writeBytes("\t");
			}

		}
		raf.close();
	}
}
