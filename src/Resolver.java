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
public class Resolver {

	public static final int DIMENSAO = 9;
	public static final int NUMERO_TOTAL_SLOTS_LINHA_COLUNA_QUADRADO = 20;
	public static final int DIMENSAO_QUADRADOS = 3;
	public static final int LISTA_FECHADA = -1; //Representa o elemento da lista aberta que foi preenchido.

	public static boolean resolver(int[][] tabuleiro,Slot[]listaAberta, int numeroSlotsAbertos){

		int i,j;
		Slot[] listaAbertaDaIteracao = new Slot[numeroSlotsAbertos];
		int[][] tabuleiroIteracao = new int[DIMENSAO][DIMENSAO];

		//Fazendo uma copia do tabuleiro original da iteracao
		for(i = 0;i < DIMENSAO;i++){
			for(j = 0;j < DIMENSAO;j++){
				tabuleiroIteracao[i][j] = tabuleiro[i][j];
			}
		}
		//Se o tabuleiro foi todo preenchido seguindo as regras, imprimi-se o resultado.
		if(Funcoes.preencheuTudo(tabuleiro)){
			Funcoes.imprimirResultado(tabuleiro);
			return true;
		}
		//Criando os slots abertos(os espacos vazios da tabuleiro) da iteracao.
		for(i = 0;i < numeroSlotsAbertos;i++){
			listaAbertaDaIteracao[i] = new Slot(listaAberta[i].getPreenchido(),listaAberta[i].getI(),listaAberta[i].getJ());

			for(j = 0;j < DIMENSAO;j++){
				listaAbertaDaIteracao[i].setPossibilidades(j,listaAberta[i].getPossibilidades(j));
			}	
		}
		//Calculando o f(n).
		for(i = 0;i < numeroSlotsAbertos;i++){
			if(!listaAbertaDaIteracao[i].getPreenchido()){
				//
				for(j = 0;j < DIMENSAO;j++){
					listaAbertaDaIteracao[i].setPossibilidades(j,Funcoes.ehPossivelInserir(tabuleiroIteracao,j + 1,listaAbertaDaIteracao[i]));	
				}
				
				if(Funcoes.Hn(listaAbertaDaIteracao[i]) != 0){
					listaAbertaDaIteracao[i].setFn((Funcoes.Gn(listaAbertaDaIteracao[i], tabuleiroIteracao) + Funcoes.Hn(listaAbertaDaIteracao[i])));
				}else{
					return false;
				}
			}
		}
		
		//O Fn a ser escolhido será o maior dentre todos!(O bubbleSort aplicado será em ordem descrescente!)
		Funcoes.bubbleSort(listaAbertaDaIteracao, numeroSlotsAbertos);

		for(j = 0;j < DIMENSAO;j++){
			if(listaAbertaDaIteracao[0].getPossibilidades(j) != 0){
				tabuleiroIteracao[listaAbertaDaIteracao[0].getI()][listaAbertaDaIteracao[0].getJ()] = listaAbertaDaIteracao[0].getPossibilidades(j);
				listaAbertaDaIteracao[0].setPreenchido(true); //Representa o slot preenchido.
				listaAbertaDaIteracao[0].setFn(LISTA_FECHADA); //O slot vai para a lista fechada(-1 no fn representa o slot que esta na lista fechada).
				
				//Se conseguirmos resolver o tabuleiro, retornamos como verdadeiro nossa tentativa.
				if(Resolver.resolver(tabuleiroIteracao, listaAbertaDaIteracao,numeroSlotsAbertos)){
					return true;
				}
				//Se nao entrarmos no if, entao o valor inserido no slot correspondente não eh valido.Precisamos trocar este valor.
				tabuleiroIteracao[listaAbertaDaIteracao[0].getI()][listaAbertaDaIteracao[0].getJ()] = 0;
				listaAbertaDaIteracao[0].setPreenchido(false);
			}
		}
		//Se nenhum valor eh valido,entao temos um slot anterior preenchido de maneira errada.Precisamos voltar e mudar este valor.
		return false;
	}
}