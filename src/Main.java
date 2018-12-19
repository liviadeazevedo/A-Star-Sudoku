/**
 * 
 * @author Lívia de Azevedo da Silva
 * Atividade Acadêmica de Inteligência Artificial
 * Universidade Federal Rural do Rio de Janeiro
 * 
 * Tema: Resolvendo Sudoku 9x9 com o algoritmo A*
 * Período: 2015-1
 * 
 * Há neste projeto 4 códigos:
 * Main.java;
 * Slot.java;
 * Funcoes.java;
 * Resolver.java;
 * 
 */

public class Main {
	
	public static final int DIMENSAO = 9;
	public static final int NUMERO_TOTAL_SLOTS_LINHA_COLUNA_QUADRADO = 20;
	public static final int DIMENSAO_QUADRADOS = 3;
	
	public static void main(String[] args) {
		
		//Variaveis de iteracao.
		int i,j,k;
		//Variavel para amarzenar o numero de slots abertos no sudoku respectivo.
		int numeroSlotsAbertos = 0;
		
		//Casos de teste do Sudoku. Selecione um e coloque o programa para rodar.
		
		int[][] tabuleiro_Sudoku = {
                {4,7,0,5,8,0,0,0,2},
			    {0,6,0,0,0,4,0,5,3},
			    {0,0,1,9,0,0,4,0,0},
			    {0,1,0,0,4,0,9,0,0},
			    {3,0,2,7,0,0,8,0,5},
			    {0,0,5,3,1,0,0,2,0},
			    {0,0,6,0,0,2,3,0,0},
			    {5,3,0,6,0,0,0,8,0},
			    {1,0,0,0,9,3,0,4,6}
    };
    
    
	/*
		int[][] tabuleiro_Sudoku = {
                {3,0,0,0,0,0,0,1,2},
			    {0,8,0,0,1,0,0,0,6},
			    {0,0,6,0,0,7,0,0,0},
			    {9,0,0,6,0,0,2,0,0},
			    {0,1,0,0,5,0,0,9,0},
			    {0,0,5,0,0,4,0,0,8},
			    {0,0,0,5,0,0,7,0,0},
			    {8,0,0,0,3,0,0,2,0},
			    {6,3,0,0,0,0,0,0,9}
    };
   */
		/*
		int[][] tabuleiro_Sudoku = {
                {2,0,0,0,0,0,0,0,6},
			    {0,4,0,0,0,0,0,5,0},
			    {0,0,5,0,0,0,8,0,0},
			    {0,0,0,9,0,7,0,0,0},
			    {0,0,0,0,1,0,0,0,0},
			    {0,0,0,6,0,2,0,0,0},
			    {0,0,9,0,0,0,6,0,0},
			    {0,5,0,0,0,0,0,3,0},
			    {8,0,0,0,0,0,0,0,2}
    };
    */
		
		/*
		int[][] tabuleiro_Sudoku = {
                {0,8,0,0,0,0,0,8,0},
			    {0,5,0,6,0,0,0,0,1},
			    {0,0,3,1,4,0,0,0,0},
			    {9,0,6,0,5,0,3,0,0},
			    {0,0,0,0,0,0,0,0,0},
			    {0,0,5,0,2,0,1,0,7},
			    {0,0,0,0,6,5,7,0,0},
			    {3,0,0,0,0,1,9,2,0},
			    {0,4,0,0,0,0,0,1,0}
    };
    */
		/*
		int[][] tabuleiro_Sudoku = {
                {0,8,0,0,0,0,0,8,0},
			    {0,5,0,6,0,0,0,0,1},
			    {0,0,3,1,4,0,0,0,0},
			    {9,0,6,0,5,0,3,0,0},
			    {0,0,0,0,0,0,0,0,0},
			    {0,0,5,0,2,0,1,0,7},
			    {0,0,0,0,6,5,7,0,0},
			    {3,0,0,0,0,1,9,2,0},
			    {0,4,0,0,0,0,0,1,0}
    };
    */
		
		
		
		//Iteração para descobrir o número de slots abertos no tabuleiro.
		for(i = 0;i < DIMENSAO;i++){
			for(j = 0;j < DIMENSAO;j++){
				if(tabuleiro_Sudoku[i][j] == 0){
					numeroSlotsAbertos++;
				}
			}
		}
	
		//Criação da lista aberta.
		Slot[]listaAberta = new Slot[numeroSlotsAbertos];
		
		for(i = 0,k = 0;i < DIMENSAO;i++){
			
			for(j = 0;j < DIMENSAO;j++){
				
				if(tabuleiro_Sudoku[i][j] == 0){
					listaAberta[k] = new Slot(false,i,j);
					k++;
				}
			}
		}
		
		
		System.out.println("Tabuleiro do Sudoku não resolvido");
		Funcoes.imprimirResultado(tabuleiro_Sudoku);
		System.out.println();
		System.out.println();
		System.out.println();
		
		//Aplicacao e resolucao do sudoku.
		if(!Resolver.resolver(tabuleiro_Sudoku,listaAberta,numeroSlotsAbertos)){
			Funcoes.imprimirResultado(tabuleiro_Sudoku);
			System.out.println();
			System.out.println("O Sudoku não possui solução!");
		}else{
			System.out.println();
			System.out.println("O Sudoku possui solução!");
		}

	}

}