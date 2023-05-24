/*
 * This java program do a toss between player and computer to choose who plays first
 */
package tictactoe;
import java.util.*;

/**
 * 
 * @author Kaif
 *
 */

public class TicTacToeGame6 {

	char[] board;
	private static char playerSymbol;
	private static char computerSymbol;

	public TicTacToeGame6() {
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
	 * To define method to make desirable move for player only not computer but first
	 * check position is vacant or not
	 */
	public void makeMovePlayer(Scanner sc) {
		System.out.println("Enter position you want");
		int position = sc.nextInt();
		if(board[position] == ' ') {
		  board[position] = playerSymbol;
		}
		else {
			System.out.println("This position is not available put another position");
			makeMovePlayer(sc);
		}
	}
	/*
	 * To define method to make desirable move for computer only not player but first
	 * check position is vacant or not
	 */
	public void makeMoveComputer(Scanner sc) {
		System.out.println("Enter position you want");
		int position = sc.nextInt();
		if(board[position] == ' ') {
		  board[position] = computerSymbol;
		}
		else {
			System.out.println("This position is not available put another position");
			makeMoveComputer(sc);
		}
	}

	/**
	 * This is main method of program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		TicTacToeGame6 player6 = new TicTacToeGame6();

		TicTacToeGame6 computer = new TicTacToeGame6();

		double tossResult = Math.random() % 2;
		
		/*
		 * To make toss between player and computer and who will
		 * win he will choose symbol first
		 */

		if (tossResult < 0.5) {
			System.out.println("computer won the toss");
		    computerSymbol =player6.chooseSymbol(sc);
		    /*
		     * To set player symbol according to computer symbol
		     */
			if(computerSymbol=='X') {
				playerSymbol = 'O';
			}
			else {
				playerSymbol = 'X';
			}
		} else {
			System.out.println("player won the toss");
			playerSymbol =player6.chooseSymbol(sc);
			/*
		     * To set player symbol according to computer symbol
		     */
			if(playerSymbol=='X') {
				computerSymbol = 'O';
			}
			else {
				computerSymbol = 'X';
			}
		}
		System.out.println("Symbol of player is "+playerSymbol);
		System.out.println("Symbol of computer is "+computerSymbol);
		sc.close();
	}
}
