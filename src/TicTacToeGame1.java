/*
 * This java program creates a fresh board for new game.
 */
package tictactoe;
/**
 * 
 * @author Kaif
 *
 */

public class TicTacToeGame1 {
	
    char [] board;
	private char playerSymbol;
	private char computerSymbol;
	

	public TicTacToeGame1() {
		super();
		board = new char[10];
		
	}
	
	/*
	 * To define method for assigning empty spaces
	 */
	public void makeBoard() {
		for(int i=0;i<board.length;i++) {
			board[i] = ' ';
		}
		System.out.println("Board created succesfully");
	}
	/**
	 * This is main mehtod of program 
	 * @param args
	 */
	public static void main(String[] args) {
		 
		
		TicTacToeGame1 player1 = new TicTacToeGame1();
		
		/*
		 * To make fresh board
		 */
		player1.makeBoard();
	}
}
