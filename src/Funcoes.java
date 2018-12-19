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
public class Funcoes {

	public static final int DIMENSAO = 9;
	public static final int NUMERO_TOTAL_SLOTS_LINHA_COLUNA_QUADRADO = 20;
	public static final int DIMENSAO_QUADRADOS = 3;

	public static int Gn(Slot s,int[][] tabuleiro)
	{
		int g_n = 0;
		int slots_abertos = 0;
		int a,b,x = 0,y = 0;
		
		//contando slots abertos da coluna.
		for(a = 0; a < DIMENSAO; a++)
		{
			if(a != s.getI() && tabuleiro[a][s.getJ()] == 0)
				slots_abertos++;
		}

		//contando slots abertos da linha.
		for(a = 0; a < DIMENSAO; a++)
		{
			if(a != s.getJ() && tabuleiro[s.getI()][a] == 0)
				slots_abertos++;
		}

		//Deslocamentos necessarios para podermos utilizar o quadrado 3x3 certo dependendo da posicao do slot.
		if(s.getI() >= 0 && s.getI() < 3)
			y = 0;
		if(s.getI() >= 3 && s.getI() < 6)
			y = 3;
		if(s.getI() >= 6 && s.getI() < 9)
			y = 6;

		if(s.getJ() >= 0 && s.getJ() < 3)
			x = 0;
		if(s.getJ() >= 3 && s.getJ() < 6)
			x = 3;
		if(s.getJ() >= 6 && s.getJ() < 9)
			x = 6;

		//contando slots abertos do quadrado 3x3 correspondente.
		for(a = 0; a < DIMENSAO_QUADRADOS;a++)
		{
			if(a + y == s.getI())
				continue;

			for(b = 0;b < DIMENSAO_QUADRADOS;b++)
			{
				if(b + x == s.getJ())
					continue;

				if(a != s.getI() && b != s.getJ() && tabuleiro[y+a][x+b] == 0)
					slots_abertos++;
			}
		}

		g_n = NUMERO_TOTAL_SLOTS_LINHA_COLUNA_QUADRADO - slots_abertos;

		return g_n;

	};

	public static int Hn(Slot s)
	{
		int h_n = 0;
		int i;

		for(i = 0;i < DIMENSAO;i++)
		{
			if(s.getPossibilidades(i) != 0)
				h_n++;
		}

		return h_n;
	};

	public static int ehPossivelInserir(int[][] tabuleiro,int valor,Slot s)
	{
		int a,b,x = 0,y = 0;

		//Compara coluna
		for(a = 0; a < DIMENSAO; a++)
		{
			if(a != s.getI() && tabuleiro[a][s.getJ()] == valor)
				return 0;
		}

		//Compara linha
		for(a = 0; a < DIMENSAO; a++)
		{
			if(a != s.getJ() && tabuleiro[s.getI()][a] == valor)
				return 0;
		}

		//Compara quadrado

		//Deslocamentos necessarios para podermos utilizar o quadrado 3x3 certo dependendo da posicao do slot.
		if(s.getI() >= 0 && s.getI() < 3)
			y = 0;
		if(s.getI() >= 3 && s.getI() < 6)
			y = 3;
		if(s.getI() >= 6 && s.getI() < 9)
			y = 6;

		if(s.getJ() >= 0 && s.getJ() < 3)
			x = 0;
		if(s.getJ() >= 3 && s.getJ() < 6)
			x = 3;
		if(s.getJ() >= 6 && s.getJ() < 9)
			x = 6;

		for(a = 0; a < DIMENSAO_QUADRADOS;a++)
		{
			for(b = 0;b < DIMENSAO_QUADRADOS;b++)
			{
				if(a != s.getI() && b != s.getJ() && tabuleiro[y+a][x+b] == valor)
					return 0;
			}
		}

		return valor;
	};

	public static void imprimirResultado(int[][] tabuleiro)
	{
		int i,j;

		for(i = 0;i < DIMENSAO;i++)
		{
			if(i == 3 || i == 6)
			{
				System.out.println("---------------------------");
			}

			for(j = 0;j< DIMENSAO;j++)
			{
				System.out.print(tabuleiro[i][j] + "  ");

				if(j == 2 || j == 5)
				{
					System.out.print("|");
				}
			}
			System.out.println("");
		}
	};

	public static void bubbleSort(Slot[] list, int n)
	{
		int c, d;
		Slot t;

		for (c = 0 ; c < ( n - 1 ); c++)
		{
			for (d = 0 ; d < n - c - 1; d++)
			{
				if (list[d].getFn() < list[d+1].getFn()) //forma crescente: >
				{
					/* Swapping */
					t         = list[d];
					list[d]   = list[d+1];
					list[d+1] = t;
				}
			}
		}
	};

	public static boolean preencheuTudo(int[][] tabuleiro)
	{
		int i,j;

		for(i = 0;i < DIMENSAO;i++)
		{
			for(j = 0;j < DIMENSAO;j++)
			{
				if(tabuleiro[i][j] == 0)
				{
					return false;
				}
			}
		}

		return true;
	};

}