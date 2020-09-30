
public class sacola{

	public static int[] ordena(int[] array, int n) {

		int menor, aux;
		int[] resp = new int[n];

		for(int i = 0; i < n; i++){
			resp[i] = array[i];
		}

		for(int i = 0; i < n-1; i++){

			menor = i;

			for(int j = i+1; j < n; j++){
				if(resp[menor] > resp[j]){
					menor = j;
				}
			}

			aux = resp[menor];
			resp[menor] = resp[i];
			resp[i] = aux;
		}
		return resp;
	}




	public static void main(String[] args){

		Arq.openRead("q1.txt");
		int x, n1 = 0, n2 = 0, aux;
		int[] sai1;
		int[] sai2;
		int[] aux2;
		boolean stak, que, pri, impo, not;


		while(Arq.hasNext()){

			x = Arq.readInt();

			sai1 = new int[x];
			sai2 = new int[x];

			n1 = 0;
			n2 = 0;
			for(int i = 0; i < x; i++){
				if(Arq.readInt() == 1){
					sai1[n1] = Arq.readInt();		
					n1++;
				}
				else{
					sai2[n2] = Arq.readInt();
					n2++;
				}
			}

			aux2 = ordena(sai1, n1);


			stak = true;
			que = true;
			pri = true;

			aux = 0;
			for(int p = 0; p < n2 && p < n1; p++){

				stak = sai2[p] == sai1[n1 - p - 1] && stak;
				que =  sai1[p] == sai2[p] && que;
				pri =  sai2[p] == aux2[n1 - p - 1] && pri;
			

			}

			if(stak && que || stak && pri || que && pri){

				MyIO.println("not sure");

			}
			else{

				if(stak){
					MyIO.println("stack");
				}
				else{
					if(que){
						MyIO.println("queue");
					}
					else{
						if(pri){
							MyIO.println("priority queue");
						}
						else{
							MyIO.println("impossible");
						}
					}
				}

			}



		}
	}
}

















































