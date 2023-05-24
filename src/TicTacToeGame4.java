/*
 * This java program allow user to make desired move
 */
package tictactoe;

import java.util.*;

/**
 * 
 * @author Kaif
 *
 */

public class TicTacToeGame4 {

	char[] board;
	private static char playerSymbol;
	private static char computerSymbol;

	public TicTacToeGame4() {
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
	 * To define method to make desirable move for player only not computer
	 */
	public void makeMove(Scanner sc) {
		System.out.println("Enter position you want");
		int position = sc.nextInt();
		board[position] = playerSymbol;
	}

	/**
	 * This is main method of program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		TicTacToeGame4 player4 = new TicTacToeGame4();

		/*
		 * To make fresh board
		 */
		player4.makeBoard();
		/*
		 * To choose  for player X or O
		 */
		playerSymbol = player4.chooseSymbol(sc);
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
		player4.makeMove(sc);
		/*
		 * To show board after fisrt move
		 */
		player4.showBoard();
		
		sc.close();
	}
}
