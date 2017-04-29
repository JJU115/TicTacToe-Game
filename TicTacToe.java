import java.util.Scanner;

public class TicTacToe {
	public static void main(String[] args) {
	
		System.out.println("\n\n          \t**********************");
		System.out.println("|*|*|*|*\tWELCOME TO TIC-TAC-TOE\t\t*|*|*|*|");
		System.out.println("        \t**********************\n\n");
	
		System.out.println("X Goes first - O goes second. Pick which one Player 1 will be by typing it in below.");
		
		Scanner console = new Scanner(System.in);
		int marker;
		String player1 = console.next();
		while (!player1.equals("X") && !player1.equals("O")) {
			System.out.println("Please enter an \'X\' or \'O\'");
			player1 = console.next();
		}	
	
		if (player1.equals("X"))
			marker = 1;		//Represents an 'X'
		else
			marker = -1;	//Represents an 'O'
	
		int[][] board = new int[3][3];
		int turnNum = 1;
		playGame(board, marker, turnNum);
	
	
		while(!checkWin(board) && turnNum < 9) {
			marker *= -1;
			turnNum++;
			playGame(board, marker, turnNum);
			
		}
		
		System.out.println("\n");
		printBoard(board);

		if (turnNum == 9 && !checkWin(board))
			System.out.println("\n\nIt's a draw! Thanks for playing!");
		else if (marker == 1)
			System.out.println("\n\nX is the winner!");
		else
			System.out.println("\n\nO is the winner!");
		
	
	
	}
	
	public static void playGame(int[][] board, int currPlayer, int turnNum) {
		
		Scanner input = new Scanner(System.in);
		int rowNum, colNum;
		
		if (currPlayer == 1)
			System.out.println("\nX's Turn\n\n");
		else
			System.out.println("\nO's Turn\n\n");
	
		printBoard(board);
		
		System.out.println("\n\nEnter coordinates of where you'd like to place your marker.");
		System.out.println("Enter the row and column numbers, both must be a 0, 1 or 2: \n0 0 -> puts marker in top left corner");
		System.out.println("0 1 -> puts marker in top centre spot\n1 1 -> puts marker in centre of the board\n");
		
		System.out.print("Enter your row number --> ");
		rowNum = getInput(input);
		System.out.println("Your row number is: " + rowNum);	
		
		System.out.print("Enter your column number --> ");
		colNum = getInput(input);
		System.out.println("Your column number is: " + colNum);
		
		while(board[rowNum][colNum] != 0) {
			System.out.println("There's already a marker at that spot, look at the board and enter a valid coordinate set\n");
			System.out.print("Enter your row number --> ");
			rowNum = getInput(input);
			System.out.println("Your row number is: " + rowNum);	
		
			System.out.print("Enter your column number --> ");
			colNum = getInput(input);
			System.out.println("Your column number is: " + colNum);	
		}	
		
		board[rowNum][colNum] = currPlayer;
	}	
	
	
	public static int getInput(Scanner input) {
	
		String temp;
		
		temp = input.next();
		while(!temp.equals("2") && !temp.equals("1") && !temp.equals("0")) {
			System.out.print("Please enter a 0, 1, or 2 --> ");
			temp = input.next();
		}

		return Integer.parseInt(temp);
	}	
	
	
	public static boolean checkWin(int[][] board) {
	
		int count = 0;
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) 
				count += board[i][j];
			
			if (count == 3 || count == -3)
				return true;
			else
				count = 0;
		}
		
		count = 0;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) 
				count += board[j][i];
			
			if (count == 3 || count == -3)
				return true;
			else
				count = 0;
		}
		
		count = board[0][0] + board[1][1] + board[2][2];
		if (count == 3 || count == -3)
			return true;
		else 
			count = 0;
		
		count = board[0][2] + board[1][1] + board[2][0];
		if (count == 3 || count == -3)
			return true;
		else
			count = 0;
		
		for(int i=0; i<3; i++) 
			for(int j=0; j<3; j++)
				if (board[i][j] != 0)
					count++;
				
								//If here, it is a draw
		return false;
	}	
	
	
	public static void printBoard(int[][] board) {
		
		for(int i=0; i<2; i++) {
		
			for(int j=0; j<2; j++) {
				if (board[i][j] == 1)
					System.out.print(" X |");
				else if (board[i][j] == -1)
					System.out.print(" O |");
				else
					System.out.print("   |");
			}

			if (board[i][2] == 1)
				System.out.println(" X");
			else if (board[i][2] == -1)
				System.out.println(" O");
			else
				System.out.println();
			
			System.out.println("-----------");
		}
		
		for(int j=0; j<2; j++) {
			if (board[2][j] == 1)
				System.out.print(" X |");
			else if (board[2][j] == -1)
				System.out.print(" O |");
			else			
				System.out.print("   |");
		}

		if (board[2][2] == 1)
			System.out.println("X");
		else if (board[2][2] == -1)
			System.out.println("O");
	}	


}