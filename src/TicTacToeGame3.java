/*
 * This java program display the game board 
 */
package tictactoe;
import java.util.*;

/**
 * 
 * @author Kaif
 *
 */

public class TicTacToeGame3 {

	char[] board;
	private static char playerSymbol;
	private static char computerSymbol;

	public TicTacToeGame3() {
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

	/**
	 * This is main method of program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		TicTacToeGame3 player3 = new TicTacToeGame3();

		/*
		 * To make fresh board
		 */
		player3.makeBoard();
		/*
		 * To choose  for player X or O
		 */
		playerSymbol = player3.chooseSymbol(sc);
		if(playerSymbol== 'X') {
			computerSymbol = 'O';
		}
		else {
			computerSymbol = 'X';
		}
		
		System.out.println("Symbol of player is "+playerSymbol);
		System.out.println("Symbol of computer is "+computerSymbol);

		player3.showBoard();
		sc.close();
	}
}
