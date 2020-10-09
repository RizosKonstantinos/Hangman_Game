import java.util.Scanner;


public class Player {
	
	private int tries; // This is a variable to count how many tries the player has .

	
	public Player(){
		
		tries = 8; 
	}
	
	public int getTries(){
		
		return tries;
	}
	
	
	// Reduces the counter of the tries by 1 if player made a wrong guess.
	public void reduceTries(){
		
		tries--;
	}
	
	
	
	public void printTriesLeft(){
		
		System.out.println("You have "+tries+" guesses left.");
	}
	
	
	// Takes the input entered by the player and checks compatibility with the game's rules.
	public String getGuess(){
		
		Scanner input = new Scanner(System.in);
		String guess;
		
		do{
			System.out.print("Your guess: ");
			guess = input.nextLine().toUpperCase();
		
			if(is_input_acceptable(guess)){
				break;
			}
			else{
				System.out.println("Wrong input! Your must enter only letters.");
			}
		}while(true);
		
		return guess;
	}
	
	
	/*
	 *  Checks if the letter entered by the player is acceptable.
	 *  The player can only enter one letter.
	 */
	public boolean is_input_acceptable(String aGuess){
		
		if(aGuess.matches("[A-Za-z]{1}")){
			return true;
		}
		return false;
	}
	
}
