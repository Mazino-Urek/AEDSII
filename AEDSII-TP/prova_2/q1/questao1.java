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
		int cont = 1;

		for(int ll = 0; ll < linha; ll++){
			tmp1.elemento = cont++;
			tmp2 = tmp1;
			for(int c = 0; c < coluna -1 ; c++){
				tmp2.dir.elemento = cont++;
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
	 * realiza a espiral (percurso) de batuque na matriz
	 * @param int l - linha que batuke inicia
	 * @param int c - coluna que batuque inicia
	 * */
	void Batuke (int l, int c){
	
		int cont = linha * coluna;
		CelulaM tmp;
		int esq = 2;
		int dir = 1;
		int bai = 1;
		int cim = 2;
		int quant = 2;
		boolean aux = true;
		tmp = getCell(l, c);
		if(tmp != null){
			MyIO.print(tmp.elemento + " ");
			cont--;
		}
		
		while(cont > 0){
			
			for(int i = 0; i < dir && aux; i++){
				c++;
				tmp = getCell(l, c);
				if(tmp != null){
					MyIO.print(tmp.elemento + " ");
					cont--;
				}
				if(cont <= 0) aux = false;
				else quant++;
			}
			dir += 2;

			for(int i = 0; i < bai && aux; i++){
				l++;
				tmp = getCell(l, c);
				if(tmp != null){
					MyIO.print(tmp.elemento + " " );
					cont--;
				}
				if(cont <= 0) aux = false;
				else quant++;
			}
			bai += 2;

			for(int i = 0; i < esq && aux; i++){
				c--;
				tmp = getCell(l, c);
				if(tmp != null){
					MyIO.print(tmp.elemento + " " );
					cont--;
				}
				if(cont <= 0) aux = false;
				else quant++;
			}
			esq += 2;

			for(int i = 0; i < cim && aux; i++){
				l--;
				tmp = getCell(l, c);
				if(tmp != null){
					MyIO.print(tmp.elemento + " ");
					cont--;
				}
				if(cont <= 0) aux = false;
				else quant++;
			}
			cim += 2;		
		}//end while

		MyIO.println("\n" + quant);	
	}//end Batuke
}//end Matrix

class questao1 {
	public static void main (String[] args){
	
		int n = MyIO.readInt();
		Matriz matriz = new  Matriz(n,n);
		matriz.ler();
		matriz.Batuke(MyIO.readInt(), MyIO.readInt());
	}//end main
}//end questo1
