/*
 * This java program allow user to check winner of game 
 * 
 */
package tictactoe;

import java.util.*;

/**
 * 
 * @author Kaif
 *
 */

public class TicTacToeGame7 {

	char[] board;
	private static char playerSymbol;
	private static char computerSymbol;

	public TicTacToeGame7() {
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
		System.out.println("This is player's turn and your symbol is "+playerSymbol);
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
		System.out.println("This is computer's turn and your symbol is "+computerSymbol);
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

	/**
	 * This is main method of program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		TicTacToeGame7 game = new TicTacToeGame7();
		
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
		 * 
		 */
		game.makeMovePlayer(sc);
		
		game.makeMoveComputer(sc);
		
		game.makeMovePlayer(sc);
		
		/*
		 * After playing three moves will check game status
		 */
		game.gameStatus();

		sc.close();
	}
}
