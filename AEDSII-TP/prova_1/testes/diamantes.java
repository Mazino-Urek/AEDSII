public class diamantes {


	public static void main (String[] args){

		String dia;
		int n = MyIO.readInt();
		int nmaior, nmenor;
		

		for(int i = 0; i < n; i++ ){

			nmaior = 0;
			nmenor = 0;
			dia = MyIO.readLine();

			for(int j = 0; j < dia.length(); j++){

				if(dia.charAt(j) == '>')
					nmaior++;
				else if(dia.charAt(j) == '<')
					nmenor++;
			}

			if(nmaior < nmenor)
				MyIO.println(nmaior);
			else
				MyIO.println(nmenor);
		}
	}
}
