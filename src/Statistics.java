
public class Statistics {
	
	private Game myGame;
	
	public Statistics(){

		myGame = new Game();
	}
	
	
	// Prints the statistics of the games that the player played so far 
	public void printStatistics(){
		
		System.out.println("                           ____________");
		System.out.println("__________________________| STATISTICS |__________________________ ");
		System.out.println();
		System.out.println(" You have played so far "+myGame.getGamesPlayed()+" games."
				+ " You won "+myGame.getWins()+" times and lost "+ myGame.getLoses()+" times.");
		System.out.println("__________________________________________________________________");
		System.out.println();
		
	}

}
