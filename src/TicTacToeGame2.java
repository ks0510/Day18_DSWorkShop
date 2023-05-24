/*
 * This java program allow user to choose symbol for game
 */
package tictactoe;
import java.util.*;

/**
 * 
 * @author Kaif
 *
 */
public class TicTacToeGame2 {

	char[] board;
	private static char playerSymbol;
	private static char computerSymbol;

	public TicTacToeGame2() {
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
	 * To define method to choose symbol
	 */
	public Character chooseSymbol(Scanner sc) {
		System.out.println("Enter your symbol");
		char symbol = sc.next().charAt(0);
		return symbol;
	}

	/**
	 * This is main mehtod of program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		TicTacToeGame2 player2 = new TicTacToeGame2();

		/*
		 * To make fresh board
		 */
		player2.makeBoard();
		/*
		 * To choose  for player X or O
		 */
		playerSymbol = player2.chooseSymbol(sc);
		if(playerSymbol== 'X') {
			computerSymbol = 'O';
		}
		else {
			computerSymbol = 'X';
		}
		
		System.out.println("Symbol of player is "+playerSymbol);
		System.out.println("Symbol of computer is "+computerSymbol);
		
		sc.close();
	}
}
