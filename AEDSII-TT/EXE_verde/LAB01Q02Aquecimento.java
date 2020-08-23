class LAB01Q02Aquecimento {
   public static boolean isMaiuscula (char c){
      return (c >= 'A' && c <= 'Z');
   }

   public static boolean isFim(String s){
      return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
   }

   //função recursiva para contar letras maiúsculas
   /*
    * @s       = palavra a ser verificada
    * @tamanho = tamanho da palavra menos um
    * @resp    = deve sempre começar como 0 (se destina a contabilização de maiúsculas)
    *
    * */
   public static int contarLetrasMaiusculas (String s , int tamanho , int resp){
      
     //verifica se a palavra já terminou
     if(tamanho >= 0){
     
	     //verifica se a letra é maiúscula
	     if(isMaiuscula(s.charAt(tamanho))){
	     
		     //chamada da recursividade
		     resp = resp + contarLetrasMaiusculas(s , --tamanho , 1);
	     }
	     else{
		     //chamada da recursividade
		     resp = resp + contarLetrasMaiusculas(s , --tamanho , 0);
	     }
	          
     }

      return resp;
   }

   public static void main (String[] args){
      String[] entrada = new String[1000];
      int numEntrada = 0;

      //Leitura da entrada padrao
      do {
         entrada[numEntrada] = MyIO.readLine();
      } while (isFim(entrada[numEntrada++]) == false);
      numEntrada--;   //Desconsiderar ultima linha contendo a palavra FIM

      //Para cada linha de entrada, gerando uma de saida contendo o numero de letras maiusculas da entrada
      for(int i = 0; i < numEntrada; i++){
         MyIO.println(contarLetrasMaiusculas(entrada[i] , entrada[i].length() - 1 , 0));
      }
   }
}
