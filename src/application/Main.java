package application;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Field[][] velha = new Field[3][3];

		char simboloAtual = 'X';

		String vitoria;

		Boolean game = true;

		iniciarJogo(velha);

		while (game) {
			formandoJogo(velha);
			vitoria = verificarVitoria(velha);

			if (!vitoria.equals(" ")) {
				System.out.printf("Jogador %s: Venceu%n", vitoria);
				break;
			}
			try {
				if (jogar(velha, simboloAtual, sc)) {
					if (simboloAtual == 'X') {
						simboloAtual = 'O';
					} else {
						simboloAtual = 'X';
					}
				} else {
					System.out.println("Falha na jogada");
				}
			} catch (Exception e) {
				System.out.println("Erro: " + e.getMessage());
			}
		}
		System.out.println("Fim de Jogo");
		sc.close();
	}

	public static void formandoJogo(Field[][] velha) {
		limparTela();

		System.out.println("     0      1     2\n");
	
		System.out.printf(" 0    %c  |  %c  |  %c  %n", velha[0][0].getSymbol(), velha[0][1].getSymbol(),
				velha[0][2].getSymbol());
		System.out.println("    -----------------");
		System.out.printf(" 1    %c  |  %c  |  %c  %n", velha[1][0].getSymbol(), velha[1][1].getSymbol(),
				velha[1][2].getSymbol());
		System.out.println("    -----------------");
		System.out.printf(" 2    %c  |  %c  |  %c  %n%n%n", velha[2][0].getSymbol(), velha[2][1].getSymbol(),
				velha[2][2].getSymbol());
	}

	public static void limparTela() {
		for (int i = 0; i <= 200; i++) {
			System.out.println();
		}
	}

	public static void iniciarJogo(Field[][] velha) {

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				velha[i][j] = new Field();
			}
		}

	}

	public static Boolean jogar(Field[][] velha, char simboloAtual, Scanner sc) {
		

		System.out.printf("Quem Joga: %c%n", simboloAtual);
		System.out.print("Informe a linha: ");
		int linha = sc.nextInt();
		System.out.print("Informe a coluna: ");
		int coluna = sc.nextInt();

		if (velha[linha][coluna].getSymbol() == ' ') {
			velha[linha][coluna].setSymbol(simboloAtual);
			return true;
		} else {
			return false;
		}
	}

	public static String verificarVitoria(Field[][] velha) {
		if (velha[0][0].getSymbol() == 'X' && velha[0][1].getSymbol() == 'X' && velha[0][2].getSymbol() == 'X'
				|| velha[1][0].getSymbol() == 'X' && velha[1][1].getSymbol() == 'X' && velha[1][2].getSymbol() == 'X'
				|| velha[2][0].getSymbol() == 'X' && velha[2][1].getSymbol() == 'X' && velha[2][2].getSymbol() == 'X'
				|| velha[0][0].getSymbol() == 'X' && velha[1][0].getSymbol() == 'X' && velha[2][0].getSymbol() == 'X'
				|| velha[0][1].getSymbol() == 'X' && velha[1][1].getSymbol() == 'X' && velha[2][1].getSymbol() == 'X'
				|| velha[0][2].getSymbol() == 'X' && velha[1][2].getSymbol() == 'X' && velha[2][2].getSymbol() == 'X'
				|| velha[0][0].getSymbol() == 'X' && velha[1][1].getSymbol() == 'X' && velha[2][2].getSymbol() == 'X'
				|| velha[0][2].getSymbol() == 'X' && velha[1][1].getSymbol() == 'X' && velha[2][0].getSymbol() == 'X') {
			
			return "X";

		}
		else if(velha[0][0].getSymbol() == 'O' && velha[0][1].getSymbol() == 'O' && velha[0][2].getSymbol() == 'O'
				|| velha[1][0].getSymbol() == 'O' && velha[1][1].getSymbol() == 'O' && velha[1][2].getSymbol() == 'O'
				|| velha[2][0].getSymbol() == 'O' && velha[2][1].getSymbol() == 'O' && velha[2][2].getSymbol() == 'O'
				|| velha[0][0].getSymbol() == 'O' && velha[1][0].getSymbol() == 'O' && velha[2][0].getSymbol() == 'O'
				|| velha[0][1].getSymbol() == 'O' && velha[1][1].getSymbol() == 'O' && velha[2][1].getSymbol() == 'O'
				|| velha[0][2].getSymbol() == 'O' && velha[1][2].getSymbol() == 'O' && velha[2][2].getSymbol() == 'O'
				|| velha[0][0].getSymbol() == 'O' && velha[1][1].getSymbol() == 'O' && velha[2][2].getSymbol() == 'O'
				|| velha[0][2].getSymbol() == 'O' && velha[1][1].getSymbol() == 'O' && velha[2][0].getSymbol() == 'O') {
			
			return "O";
			
		}
		return " ";
	}

}
