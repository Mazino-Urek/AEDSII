/*
 * Exercício Resolvido (6): Outra forma de compreender o código anterior é executando o mesmo
 * */


class exercicioResolvido_06 {
	public static void main (String[] args) {
		int[] n = {4,5,6,7,8,9,10,11,12,13,14,15,16,17,31,32,33,63,64,65};
		int cont;
		for(int k = 0; k < n.length; k++){
			System.out.print("\n[n = " + n[k] + "] => ");
			cont = 0;
			for(int i = n[k]; i > 0; i /= 2){
				System.out.print(" " + i);
				cont++;
			}
			System.out.print(" (" + cont + " vezes)");
		}
		System.out.print("\n");
	}
}
/*
saida do programa:

[n = 4] =>  4 2 1 (3 vezes)
[n = 5] =>  5 2 1 (3 vezes)
[n = 6] =>  6 3 1 (3 vezes)
[n = 7] =>  7 3 1 (3 vezes)
[n = 8] =>  8 4 2 1 (4 vezes)
[n = 9] =>  9 4 2 1 (4 vezes)
[n = 10] =>  10 5 2 1 (4 vezes)
[n = 11] =>  11 5 2 1 (4 vezes)
[n = 12] =>  12 6 3 1 (4 vezes)
[n = 13] =>  13 6 3 1 (4 vezes)
[n = 14] =>  14 7 3 1 (4 vezes)
[n = 15] =>  15 7 3 1 (4 vezes)
[n = 16] =>  16 8 4 2 1 (5 vezes)
[n = 17] =>  17 8 4 2 1 (5 vezes)
[n = 31] =>  31 15 7 3 1 (5 vezes)
[n = 32] =>  32 16 8 4 2 1 (6 vezes)
[n = 33] =>  33 16 8 4 2 1 (6 vezes)
[n = 63] =>  63 31 15 7 3 1 (6 vezes)
[n = 64] =>  64 32 16 8 4 2 1 (7 vezes)
[n = 65] =>  65 32 16 8 4 2 1 (7 vezes)


*/
