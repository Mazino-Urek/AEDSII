/*
 * Nome: Diego Da SIlva Ferreira
 * Matricula: 71 06 78
 *
 * Questão: Leia o nome de dois arquivos e copie o conteúdo do primeiro
 * para o último
 * */

public class Exercicio_07 {

	public static void main(String[] args){
	
		String s, ss;

		s = MyIO.readString();
		ss = MyIO.readString();

		Arq.openRead(s);

		s = "";
		while(Arq.hasNext()){
		
			s += Arq.readLine();
			s += "\n";

		}

		Arq.close();
		Arq.openWrite(ss);

		Arq.print(s);

		Arq.close();
	
	}
}
