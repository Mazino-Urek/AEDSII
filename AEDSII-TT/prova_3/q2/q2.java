




public int getMaior(){

	int resp = NULO;
	int aux;

	if(T1[0] != NULO){
		resp = T1[0];
	}
	else{
		for(int i = TAM - 1; i > 0; i++){
			if(T1[i] != NULO){
				resp = T1[i];
				i = TAM;
			}
		}
	}

	if(T2[0] != null){
		aux = T1[0].getMaior();
		if(aux > resp){
			resp = aux;
		}
	}
	else{
		for(int i = TAM - 1; i > 0; i++){
			if(T2[i] != null){
				aux = T2[i].getMior();
				if(aux > resp){
					resp = aux;
				}
				i = TAM;
			}
		}
	}

	for(int i = 0; i < TAM + TAMRESERVA; i++){
		if(){
		
		}
	
	}



}











