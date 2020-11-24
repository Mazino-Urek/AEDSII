/*
 * Nome: Diego Da Silva Ferreira
 * Matricula: 71 06 78
 * */


class CelulaM{
	
	public int elemento;
	public CelulaM esq, dir, sup, inf;

	CelulaM(){
		this(0);
	}//end construtor
	
	CelulaM(int elemento){
		this.elemento = elemento;
		this.esq = null;
		this.dir = null;
		this.sup = null;
		this.inf = null;	
	}//end construtor

}//end CelulaM

class Matriz{

	private CelulaM inicio;
	private int linha, coluna;

	/*
	 * Construtor da matrix
	 * @param int linha - numero de linhas da matriz
	 * @param int coluna - numero da colunas da matriz
	 * */
	Matriz(int linha, int coluna){
		this.linha = linha;
		this.coluna = coluna;
		
		inicio = new CelulaM();
		CelulaM tmp1 = inicio;
		CelulaM tmp2;
		CelulaM tmp3;

		for(int l = 0; l < linha ; l++){
			tmp2 = tmp1;
			tmp3 = tmp1.sup;
			for(int c = 0; c < coluna -1 ; c++){
				tmp2.dir = new CelulaM();
				tmp2.dir.esq = tmp2;
				tmp2 = tmp2.dir;

				if(l > 0){
					tmp3 = tmp3.dir;
					tmp2.sup = tmp3;
					tmp3.inf = tmp2;			
				}//end if
			}//end for interno
			tmp1.inf = new CelulaM();
			tmp1.inf.sup = tmp1;
			tmp1 = tmp1.inf;
		}//end for externo
	}//end construtor

	/*
	 * atribui valores aos elementos da matriz
	 * */
	void ler(){
		CelulaM tmp1 = inicio;
		CelulaM tmp2;

		for(int ll = 0; ll < linha; ll++){
			tmp1.elemento = MyIO.readInt();
			tmp2 = tmp1;
			for(int c = 0; c < coluna -1 ; c++){
				tmp2.dir.elemento = MyIO.readInt(); 
				tmp2 = tmp2.dir;
			}
			tmp1 = tmp1.inf;
		}//end for	
	}//end construtor

	/*
	 * Mostra os elementos da matrix
	 * */
	void mostrar(){
		CelulaM tmp1 = inicio;
		CelulaM tmp2;

		for(int l = 0; l < linha; l++){
			MyIO.print(tmp1.elemento);
			tmp2 = tmp1;
			for(int c = 0; c < coluna -1 ; c++){
				MyIO.print(" " + tmp2.dir.elemento); 
				tmp2 = tmp2.dir;
			}
			MyIO.println("");
			tmp1 = tmp1.inf;
		}//end for	
	}//end mostrar


	/*
	 * busca uma celula da matriz
	 * @param int l - condenadas da linha
	 * @param int c - cordenadas da coluna
	 * @return CelulaM resp - celula buscada
	 * */
	CelulaM getCell(int l, int c){
	
		CelulaM resp = null;
		if(l < linha && l >=0 && c < coluna && c >= 0){
			resp = inicio;
			for(int i = 0; i < l; i++, resp = resp.inf);
			for(int i = 0; i < c; i++, resp = resp.dir);
		}//end if
		return resp;
	}//end getCell

	/*
	 * Realiza a soma de duas matrizes 
	 * @param Matrix other - matrix a ser somada
	 * @return Matrix resp - matrix contendo o resultado
	 * */
	Matriz somaMatriz(Matriz other){
		Matriz resp = null;
		if(this.linha == other.linha && this.coluna == other.coluna){
		
			resp = new Matriz(this.linha, this.coluna);
			CelulaM P1 = inicio, O1 = other.inicio, R1 = resp.inicio;
			CelulaM R2, P2, O2;
			
			for(int l = 0; l < linha; l++){
				R1.elemento = P1.elemento + O1.elemento;
				P2 = P1;
				R2 = R1;
				O2 = O1;
				for(int c = 0; c < coluna -1 ; c++){
					R2.dir.elemento = P2.dir.elemento + O2.dir.elemento;
					R2 = R2.dir;
					P2 = P2.dir;
					O2 = O2.dir;
				}
				R1 = R1.inf;
				P1 = P1.inf;
				O1 = O1.inf;
			}//end for
		}
		else
			MyIO.println("\nmatrizes incompativeis\n");

		return resp;	
	}//end somaMatrix

	/*
	 * Mostra a diagonal principal da matriz
	 * */
	void mostrarDiagonalPrincipal(){
		if(linha == coluna){
			CelulaM tmp = inicio;

			for(int l = 0; l < linha -1; l++){
				MyIO.print(tmp.elemento + " ");
				tmp = tmp.inf.dir;
			}//end for
				MyIO.println(tmp.elemento);
		}
		else
			MyIO.println("Matriz invalida");
	}//end mostrar

	/*
	 * Mostra a diagonal secundaria da matriz
	 * */
	void mostrarDiagonalSecundaria(){
		if(linha == coluna){
			CelulaM tmp = inicio;

			for(; tmp.dir != null; tmp = tmp.dir);

			for(int l = 0; l < linha -1; l++){
				MyIO.print(tmp.elemento + " ");
				tmp = tmp.inf.esq;
			}//end for
				MyIO.println(tmp.elemento);
		}
		else
			MyIO.println("Matriz invalida");
	}//end mostrar

	/*
	 * realiza a multiplicação de duas matrizes
	 * @param Matriz other - multiplicador
	 * @return Matriz resp - resultado a multiplicação
	 * */
	Matriz multiplicacao(Matriz other){
		Matriz resp = null;

		if(this.coluna == other.linha){
			resp = new Matriz(this.linha, this.linha);			

			for (int i = 0; i < this.linha; i++){
				for (int j = 0; j < other.coluna; j++) {
					int somatoria = 0;
					for (int k = 0; k < this.coluna; k++) {
						int produto = this.getCell(i, k).elemento * other.getCell(k, j).elemento;
						somatoria += produto;
					}//end for terciario
					resp.getCell(i, j).elemento = somatoria ;
				}//end for secundario
			}//end for primario
		}//end if
		return resp;
	}//end multiplicacao
}//end Matrix


class MatrixFlexival {
	public static void main(String[] args) {
		
		int n = MyIO.readInt();
		Matriz matriz1;
		Matriz matriz2;

		for(int i = 0; i < n * 2; i += 2){
		
			matriz1 = new Matriz(MyIO.readInt(), MyIO.readInt());
			matriz1.ler();
				
			matriz2 = new Matriz(MyIO.readInt(), MyIO.readInt());
			matriz2.ler();

			matriz1.mostrarDiagonalPrincipal();
			matriz1.mostrarDiagonalSecundaria();
			matriz1.somaMatriz(matriz2).mostrar();
			matriz1.multiplicacao(matriz2).mostrar();
		}//end while
	}//end main
}//end MatrizFlexivel
