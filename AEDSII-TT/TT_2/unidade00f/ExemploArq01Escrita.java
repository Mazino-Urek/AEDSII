/*
 * Nome Diego Da Silva Ferreira
 * Matricula: 71 06 78
 *
 * Questão 1: Execute e brinque com os arquivos
 * ExemploArq01Escrita.java e ExemploArq02Leitura.java
 * */


class ExemploArq01Escrita {
	public static void main (String[] args){
		Arq.openWrite("exemplo.txt");

		for(int a = 0; a < 10; a++){
			for(int s = 1; s <= 10; s++){
			
				Arq.print(s + "\t");

			}
			Arq.println("");		
		}

		Arq.close();
	}
}
