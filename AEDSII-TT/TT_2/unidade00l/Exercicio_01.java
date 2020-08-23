/*
 * Nome: Diego Da Silva Ferreira
 * Matricula: 71 06 78
 *
 * questão: Faça uma classe retângulo contendo os atributos base e
 * altura, pelo menos dois métodos construtores, o método
 * double getArea() que retorna a área do retângulo, o método
 * double getPerimetro() que retorna o perímetro do retângulo e
 * o método double getDiagonal() que retorna a diagonal do
 * retângulo
 *
 * questão 2 : Faça também uma classe Lixao contendo um método main
 * sendo que esse terá dois objetos do tipo retângulo e chamará
 * os métodos desenvolvidos na classe retângulo
 * */

import java.lang.Math;

class retangulo {

	double base;
	double altura;

	retangulo(double base, double altura){
	
		this.base = base;
		this.altura = altura;
	}

	retangulo(double base){
	
		this.base = base;
		this.altura = 0;
	}

	double getArea(){
		return (base * altura);
	}

	double getPerimetro(){
	
		return (2 * altura) + (2* base);	
	}

	double getDiagonal() {
		return (Math.sqrt( Math.pow(base, 2) + Math.pow(altura, 2) ));
	}

}


class Lixao {

	retangulo o = new retangulo(10, 3);
	retangulo oo = new retangulo(10 , 5);


	Lixao(double a, double b, double c, double d){
	
		o = new retangulo(a , b);
		oo = new retangulo(c , d);
	}

	void print(){
	
		System.out.println(o.getArea());
		System.out.println(o.getPerimetro());
		System.out.println(o.getDiagonal());
	
		System.out.println(oo.getArea());
		System.out.println(oo.getPerimetro());
		System.out.println(oo.getDiagonal());
	}


}




public class Exercicio_01{


	public static void main (String[] args){

		Lixao g = new Lixao(10 , 3, 10 , 5);

		g.print();
	}
}




