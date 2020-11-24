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

	Matriz Sweeper(){
		
		Matriz resp = new Matriz(this.linha, this.coluna);
		CelulaM tmp;
		int cont;
	
		for(int i = 0; i < linha; i++){
			for(int j = 0; j < coluna; j++){
				tmp = this.getCell(i, j);
				if(tmp.elemento == 1){
					
					resp.getCell(i,j).elemento = 9;
				}
				else{
					
					cont = 0;
					if(tmp.sup != null && tmp.sup.elemento == 1){
						cont++;
					}
					if(tmp.inf != null && tmp.inf.elemento == 1){
						cont++;
					}
					if(tmp.dir != null && tmp.dir.elemento == 1){
						cont++;
					}
					if(tmp.esq != null && tmp.esq.elemento == 1){
						cont++;
					}

					resp.getCell(i,j).elemento = cont;
				}//end else
			}//end for interno
		}//end for externo

		return resp;
	}//end Sweeper
}//end Matrix


class questao1 {

	public static void main (String[] args){
	
		Matriz matriz;
		String entrada = MyIO.readLine();
		String[] aux;

		while(!entrada.equals("FIM")){
		
			aux = entrada.split(" ");

			matriz = new Matriz(Integer.parseInt(aux[0]), Integer.parseInt(aux[1]));
			matriz.ler();
			matriz.Sweeper().mostrar();
			entrada = MyIO.readLine();
		}	
	}//end main


}//end questo1





























