 import java.io.*;
 class Player{
	int column;
	int row;
	String playerName;
}

public class TicTacToe{

	int gridSize;
	int totalPlayers;
	String board[][];
	int totalMoves;
	int move;
	public static void main(String args[])throws IOException{
	    
	    TicTacToe newGame = new TicTacToe();

		int flag = 1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// Get board grid size
		System.out.println("Enter grid Size : ");
		newGame.gridSize = Integer.parseInt(br.readLine());

        newGame.board = new String[100][100];
		// Get total player numbers
		System.out.println("How many players ? : ");
		newGame.totalPlayers = Integer.parseInt(br.readLine());
		
		System.out.println(newGame.totalPlayers);
		// Declare total players array
		Player player[] = new Player[newGame.totalPlayers];
		
		// Set player names
		for(int i =0;i<newGame.totalPlayers;i++){

			System.out.println("Set player name : ");
			player[i] = new Player();
			player[i].playerName=br.readLine();
		}

		// Initiailize strings
		for(int i=0;i<newGame.gridSize;i++){
			for(int j=0;j<newGame.gridSize;j++){
				newGame.board[i][j] = new String();
			}
		}

		// Set total number of moves
		newGame.totalMoves= newGame.gridSize*newGame.gridSize;
		newGame.move=0;

		// Start the game 
		System.out.println("Lets start now !");
		int i = 0;

		// Loop until last move
		while(newGame.move<newGame.totalMoves){
			// Ask player to have his movesd
			System.out.println(player[i].playerName+" tell your move row and column (by space) : ");
			String playerResponse = br.readLine();
			String playerResponseDetail[] =playerResponse.split("\\s+");
			
			// Check result
			int result = newGame.move(Integer.parseInt(playerResponseDetail[0]), Integer.parseInt(playerResponseDetail[1]), player[i]);
			if(result==0){
				i++;
				if(i>newGame.totalPlayers-1){
					i=0;
				}
			}
			else if(result==1){
				System.out.println("Congrats !! "+player[i].playerName+" you have won !");
				flag=0;
				i++;
			}
			else if(result==2){
				System.out.println("Invalid move ! Play again");
			}
			else{
				System.out.println("No moves left !");
				System.out.println(" We have to stop now ! Thanks to all");
				flag=0;
				i++;
			}
			
			if(flag==0){
				break;
			}
		}

	}

	public int move(int row, int column, Player player){

		this.move++;
		int flag=1;
		int win=1;

		// Check if already occupied
		if(!this.board[row][column].equals(player.playerName) && this.board[row][column].length()>0){
			System.out.println("Already occupid !");
			this.move++;
			return 2;
		}	

		// Set player position
		this.board[row][column] = player.playerName;

		System.out.println(player.playerName+" is at : "+row+" "+column);


		if(checkInRow(row,column,player)==1){
			return 1;
		}
		else if(checkInColumn(row,column,player)==1){
			return 1;
		}
		else if(checkInDigonal(row,column,player)==1){
			return 1;
		}
		else if(this.move==this.totalMoves){
			System.out.println("Fuull !");
			return 3;
		}
		else{
			return 0;
		}

	}

	public int checkInRow(int row,int column, Player player){
		int win = 1;

		// Check if in that row if player is winning
		for(int i=0;i<this.gridSize;i++){
			if(!(this.board[row][i].equals(player.playerName))){
				win = 0;
			}
		}
		return win;
	}

	public int checkInColumn(int row,int column, Player player){
		int win = 1;

		// Check if in that column if player is winning
		for(int i=0;i<this.gridSize;i++){
			if(!(this.board[i][column].equals(player.playerName))){
				win = 0;
			}
		}
		return win;
	}

	public int checkInDigonal(int row,int column, Player player){
		int win = 1;
		// Check if in that digonal if player is winning
		for(int i=0;i<this.gridSize;i++){
			if(!(this.board[i][i].equals(player.playerName))){
				win = 0;
			}
		}

		// Check if in that digonal if player is winning
		for(int i=this.gridSize-1;i>=0;i--){
			if(!(this.board[i][i].equals(player.playerName))){
				win = 0;
			}
		}

		return win;
	}
}
