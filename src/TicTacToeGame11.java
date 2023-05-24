/*
 * This java program suugest if corner positions are not vacant
 */
package tictactoe;

import java.util.Scanner;

public class TicTacToeGame11 {
	char[] board;
	private static char playerSymbol;
	private static char computerSymbol;

	public TicTacToeGame11() {
		super();
		board = new char[10];
	}

	/*
	 * To define method for assigning empty spaces
	 */
	public void makeBoard() {
		for (int i = 0; i < board.length; i++) {
			board[i] = ' ';
		}
		System.out.println("Board created succesfully");
	}

	/*
	 * To define method to choose symbol for game
	 */
	public Character chooseSymbol(Scanner sc) {
		System.out.println("Enter your symbol");
		char symbol = sc.next().charAt(0);
		return symbol;
	}

	/*
	 * To define method which print our board
	 */
	public void showBoard() {
		System.out.println("|---|---|---|");
		System.out.println("| " + board[1] + " | " + board[2] + " | " + board[3] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[4] + " | " + board[5] + " | " + board[6] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[7] + " | " + board[8] + " | " + board[9] + " |");
		System.out.println("|---|---|---|");
	}

	/*
	 * To define method to make desirable move for player only not computer but
	 * first check position is vacant or not
	 */
	public void makeMovePlayer(Scanner sc) {
		System.out.println("This is player's turn and your symbol is " + playerSymbol);
		System.out.println("Enter position you want");
		int position = sc.nextInt();
		if (board[position] == ' ') {
			board[position] = playerSymbol;
		} else {
			System.out.println("This position is not available put another position");
			makeMovePlayer(sc);
		}
	}

	/*
	 * To define method to make desirable move for computer only not player but
	 * first check position is vacant or not
	 */
	public void makeMoveComputer(Scanner sc) {
		System.out.println("This is computer's turn and your symbol is " + computerSymbol);
		System.out.println("Enter position you want");
		int position = sc.nextInt();
		if (board[position] == ' ') {
			board[position] = computerSymbol;
		} else {
			System.out.println("This position is not available put another position");
			makeMoveComputer(sc);
		}
	}

	/*
	 * This function check whether player or computer won or not
	 */
	public boolean checkWin(char symbol) {
		if ((// for horizontal line win
		board[1] == symbol && board[2] == symbol && board[3] == symbol)
				|| (board[4] == symbol && board[5] == symbol && board[6] == symbol)
				|| (board[7] == symbol && board[8] == symbol && board[9] == symbol) ||
				/*
				 * For vertical line win
				 */
				(board[1] == symbol && board[4] == symbol && board[7] == symbol)
				|| (board[2] == symbol && board[5] == symbol && board[8] == symbol)
				|| (board[3] == symbol && board[6] == symbol && board[9] == symbol) ||
				/*
				 * For diagonal win
				 */
				(board[1] == symbol && board[5] == symbol && board[9] == symbol)
				|| (board[3] == symbol && board[5] == symbol && board[7] == symbol)) {

			return true;
		}
		return false;
	}

	/*
	 * This method will give us status who is winning or tie or to continue game
	 */
	public void gameStatus() {

		while (true) {
			if (checkWin('X')) {
				showBoard();
				System.out.println("Player wins!");
				break;
			}
			if (checkWin('O')) {
				showBoard();
				System.out.println("Computer wins!");
				break;
			}

			if (!isFull()) {
				showBoard();
				System.out.println("No one is winning nor tie Play next move");
				break;
			} else {
				showBoard();
				System.out.println("Game ended in tie");
				break;
			}
		}
	}

	/*
	 * Method to check board is full or not
	 */
	public boolean isFull() {
		for (int i = 1; i < board.length; i++) {
			if (board[i] == ' ') {
				return false;
			}
		}
		return true;
	}

	/*
	 * To define a method in which player will play only corner moves and suggest centre 
	 * if corner positions are not vacant for player only
	 */
	public void moveCorner() {
		if (board[1] == ' ') {
			board[1] = playerSymbol;
		} else if (board[3] == ' ') {
			board[3] = playerSymbol;
		} else if (board[7] == ' ') {
			board[7] = playerSymbol;
		} else if (board[9] == ' ') {
			board[9] = playerSymbol;
		}
		else {
			System.out.println("Corner positions are not vacant go for centre position");
		}
	}

	/**
	 * This is main method of program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		TicTacToeGame11 game = new TicTacToeGame11();

		game.makeBoard();

		double tossResult = Math.random() % 2;

		/*
		 * To make toss between player and computer and who will win he will choose
		 * symbol first
		 */

		if (tossResult < 0.5) {
			System.out.println("computer won the toss");
			computerSymbol = game.chooseSymbol(sc);
			/*
			 * To set player symbol according to computer symbol
			 */
			if (computerSymbol == 'X') {
				playerSymbol = 'O';
			} else {
				playerSymbol = 'X';
			}
			/*
			 * Computer won the toss so he will play first
			 */
			game.makeMoveComputer(sc);
		} else {
			System.out.println("player won the toss");
			playerSymbol = game.chooseSymbol(sc);
			/*
			 * To set player symbol according to computer symbol
			 */
			if (playerSymbol == 'X') {
				computerSymbol = 'O';
			} else {
				computerSymbol = 'X';
			}
			/*
			 * Player won the toss so he will play first
			 */
			game.makeMovePlayer(sc);
		}
		System.out.println("Symbol of player is " + playerSymbol);
		System.out.println("Symbol of computer is " + computerSymbol);
		
		/*
		 * To play corner move first as mentioned in UC10
		 */
		game.moveCorner();
		game.makeMoveComputer(sc);
		game.moveCorner();
		game.makeMoveComputer(sc);
		game.moveCorner();
		game.moveCorner();
		/*
		 * After this move program will say corner moves are not vacant
		 */
		game.moveCorner();
		game.gameStatus();
		/*
		 * Here we are solving UC8 by giving chance to computer to ask for a for
		 * position he wanted it will play like a human
		 */
		game.makeMoveComputer(sc);

		/*
		 * As UC9 said to check opponent and play to block opponent
		 */
		game.gameStatus();

		/*
		 * To play to block opponent
		 */
		game.makeMovePlayer(sc);
		game.gameStatus();

	}
}
