/*
 * This java program allow user to make desired move but check the position of desired move
 * vacant or not
 */
package tictactoe;
import java.util.*;
/**
 * 
 * @author Kaif
 *
 */

public class TicTacToeGame5 {

	char[] board;
	private static char playerSymbol;
	private static char computerSymbol;

	public TicTacToeGame5() {
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
	public void makeMove(Scanner sc) {
		System.out.println("Enter position you want");
		int position = sc.nextInt();
		if(board[position] == ' ') {
		  board[position] = playerSymbol;
		}
		else {
			System.out.println("This position is not available");
		}
	}

	/**
	 * This is main method of program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		TicTacToeGame5 player5 = new TicTacToeGame5();

		/*
		 * To make fresh board
		 */
		player5.makeBoard();
		/*
		 * To choose  for player X or O
		 */
		playerSymbol = player5.chooseSymbol(sc);
		if(playerSymbol== 'X') {
			computerSymbol = 'O';
		}
		else {
			computerSymbol = 'X';
		}
		
		System.out.println("Symbol of player is "+playerSymbol);
		System.out.println("Symbol of computer is "+computerSymbol);
		/*
		 * To make first move of player
		 */
		player5.makeMove(sc);
		/*
		 * To make second move but using same position used in first move this
		 * time program will show your desired posistion is already taken
		 */
		player5.makeMove(sc);
		
		sc.close();
	}
}
