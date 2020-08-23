/*
 * Nome: Dieog Da Silva Ferreira
 * Matricula: 71 06 78
 *
 * Questão 2: Um aluno desenvolveu a classe abaixo e pediu sua ajuda para compilá-la. 
 * Para ajudar, você deve criar uma
 * classe Ponto com as seguintes regras: 
 * */


class Ponto{

	private double x;
	private double y;
	private int id;
	private int nextID = 0;

	Ponto (int id , int nextID){
	
		this.id = id;
		this.nextID = nextID;
		this.y = 0;
		this.x = 0;
	}

	Ponto ( int id , int nextID , double x , double y ){
	
		this.id = id;
		this.nextID = nextID;
		this.y = y;
		this.x = x;
	}

	double getx (){
		return this.x;
	}

	double gety (){
		return this.y;
	}

	void setx (int x){
		this.x = x;
	}

	void sety (int y){
		this.y = y;
	}
}


class Exercicio_02 {
	public static void main (String[] args){
		Ponto p1 = new Ponto(4,3,  1, 0);
		Ponto p2 = new Ponto(8,5,  2, 0);
		Ponto p3 = new Ponto(9,10, 3, 0);
		
		System.out.println("x de P1: " + p1.getx());
		System.out.println("x de P2: " + p2.getx());
		System.out.println("x de P3: " + p3.getx());
	}
}





