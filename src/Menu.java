import java.util.Scanner;


public class Menu {
	
	private String playerAnswer;
	
	public Menu(){
		
		playerAnswer = "";
	}
	
	
	/* Prints the main menu on screen */
	public void printMenu(){
		
		System.out.println("MAIN MENU");
		System.out.println("    - Start a new Game (N)");
		System.out.println("    - Statistics (S)");
		System.out.println("    - Exit (E)");
	}
	
	/* Prompts the player to choose an option from the main menu */
	public void printChooseAnOption(){
		
		Scanner in = new Scanner(System.in);
		
		do{
			System.out.print("Please enter your choice: ");
			playerAnswer = in.nextLine().toUpperCase();
		}while(!is_answer_acceptable(playerAnswer));
	}
	
	
	public String getAnswer(){
		
		return playerAnswer;
	}
	
	
	/* Checks if player's answer is acceptable */
	public boolean is_answer_acceptable(String anAnswer){
		
		if((anAnswer.equals("N"))||(anAnswer.equals("E"))||(anAnswer.equals("S"))){
			return true;
		}
		return false;		
	}
}
