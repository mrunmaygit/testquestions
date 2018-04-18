 import java.io.*;
 class Player{
	int column;
	int row;
	String playerName;
}

public class TicTacToeComputer{

	int gridSize;
	int totalPlayers;
	String board[][];
	int totalMoves;
	int move;

	public static void main(String args[])throws IOException{
	    
	    TicTacToe newGame = new TicTacToe();

	    // Local variables
	    String playerResponse = new String();
	    String playerResponseDetail[] new String[2]();
	    int result;

		int flag = 1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// Get board grid size
		System.out.println("Enter grid Size : ");
		newGame.gridSize = Integer.parseInt(br.readLine());

        newGame.board = new String[100][100];

		// Declare total players array
		Player player[] = new Player[2];
		
		// Set player names
		for(int i =0;i<newGame.totalPlayers;i++){

			System.out.println("Set player name : ");
			player[i] = new Player();
			player[i].playerName=br.readLine();
		}

		// Tell player about computer player
		System.out.println(player[1].playerName+" will be Computer player");

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
			if(i==0){
				// Ask player to have his move
				System.out.println(player[i].playerName+" tell your move row and column (by space) : ");
				playerResponse = br.readLine();
				playerResponseDetail[] =playerResponse.split("\\s+");
				result = newGame.move(Integer.parseInt(playerResponseDetail[0]), Integer.parseInt(playerResponseDetail[1]), player[i]);

			}
			else{
				Random r = new Random();
				int Low = 0;
				int High = newGame.gridSize;
				int row = r.nextInt(High-Low) + Low;
				int column = r.nextInt(High-Low) + Low;
				result = newGame.move(Integer.parseInt(row, column, player[i]);

			}
			
			
			// Check result
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
				if(i==0){
				System.out.println("Invalid move ! Play again");					
				}
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
		else if(checkInDigonal2(row,column,player)==1){
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
	/**
	 * Check if player winning in row
	 * @param int
	 * @param int
	 * @param Player
	 * @return int
	 */
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
	/**
	 * Check if player winning in column
	 * @param int
	 * @param int
	 * @param Player
	 * @return int
	 */
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


	/**
	 * Check if player winning in digonal
	 * @param int
	 * @param int
	 * @param Player
	 * @return int
	 */
	public int checkInDigonal(int row,int column, Player player){
		int win = 1;
		
		// Check if in that digonal if player is winning
		for(int i=0;i<this.gridSize;i++){
			if(!(this.board[i][i].equals(player.playerName))){
				win = 0;
			}
		}
		return win;
	}

	/**
	 * Check if player winning in digonal
	 * @param int
	 * @param int
	 * @param Player
	 * @return int
	 */
	public int checkInDigonal2(int row,int column, Player player){
		int win = 1;
		// Check if in that digonal if player is winning
		for(int i=this.gridSize-1;i>=0;i--){
			for(int j=0;j<this.gridSize;i++){
				if(!(this.board[i][j].equals(player.playerName))){
					win = 0;
				}	
			}
		}

		return win;
	}
}
