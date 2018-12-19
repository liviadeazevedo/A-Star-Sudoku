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

//Classe que ira conter todas as informacoes necessarias para cada slot aberto do sudoku.
public class Slot {

	private boolean preenchido; //Se ele esta preenchido ou nao.
	private int fn; //funcao heuristica do A*.
	private int i;//posicao da linha.
	private int j;//posicao da coluna.
	private int[] possibilidades = {1,2,3,4,5,6,7,8,9};//total de possibilidades que sao validas naquele slot.

	public Slot(boolean preenchido,int i,int j){
		this.i = i;
		this.j = j;
		this.preenchido = preenchido;
	}

	//Getters e Setters de cada atributo da classe Slot.
	public boolean getPreenchido(){
		return preenchido;
	}

	public void setPreenchido(boolean preenchido){
		this.preenchido = preenchido;
	}

	public int getFn(){
		return fn;
	}

	public void setFn(int fn){
		this.fn = fn;
	}

	public int getI(){
		return i;
	}

	public void setI(int i){
		this.i = i;
	}

	public int getJ(){
		return j;
	}

	public void setJ(int j){
		this.j = j;
	}

	/*Os getters e setters do vetor terao uma pequena diferenca em relacao ao padrao.
	 * Isso eh necessario para suprir as necessidades de implementacao no algoritmo aplicado*/

	//Ira retornar o valor presente na posicao informada no vetor.
	public int getPossibilidades(int posicao){
		return possibilidades[posicao];
	}

	//Ira substituir o valor original de uma posicao do vetor, informando o valor desejado e a posicao a ser substituida
	public void setPossibilidades(int posicao,int numero){
		this.possibilidades[posicao] = numero;
	}

}