
import java.util.Random;


public class Game {
	
	private static int gamesPlayed; // This variable is counting the total games the player played in each session
	private static int wins;  // This variable is counting the total wins
	private static int defeats;  // This variable is counting the total defeats
	private int correctGuesses = 0; // counts the correct guesses the player made so far
	private int wrongGuesses = 0;  // counts the wrong guesses the player made so far
	private String theWordToSolve;
	private boolean solved = false;  
	private int numberOfCorrectLetters = 0;  // counts the amount of correct letters appearing in the word. The counter increases
									         // depending on how many times a letter appears in the word.
	
	private char[] lettersUsedAlready = new char[26];
	private int usedLettersCounter = 0;
	
	
	public Game(){				
		
	}
	
	
	public void startNewGame(){
		
		gamesPlayed++;		
		theWordToSolve = generateNewWord();
		
		int wordLength = theWordToSolve.length();		
		char[] dashedWord = new char[wordLength];
		
		generateDashedWord(dashedWord,wordLength);
		generateUsedLetters(lettersUsedAlready);
		
		Player thePlayer = new Player();
		String playersGuess;
		
	//	System.out.println();
	//	System.out.println("*** GAME STARTED ***");
		printGameStart();
				
		while(!solved && thePlayer.getTries()>0){

			printDashedWord(dashedWord);
			thePlayer.printTriesLeft();
			playersGuess = thePlayer.getGuess();
			
			if(isLetterNotUsed(lettersUsedAlready,playersGuess)){	
				
				if(guess_matches(theWordToSolve,playersGuess)){
					addUsedLetter(lettersUsedAlready,usedLettersCounter,playersGuess);
					reveal_letter(theWordToSolve, dashedWord, playersGuess);
					correctGuesses++;
					System.out.println("Your guess is CORRECT!");
					
					if(numberOfCorrectLetters == theWordToSolve.length()){
						solved = true;
						break;
					}		
				}
				else{
					System.out.println("There are no "+playersGuess+"'s in the word.");
					thePlayer.reduceTries();
					wrongGuesses++;
					addUsedLetter(lettersUsedAlready,usedLettersCounter,playersGuess);
				}
			}
			else{
				System.out.println("You already tried this letter. Please try again!");
			}
		}
		
		if(solved){
			printWin();
		}
		else{
			printDefeat();
		}
	}
	
	
	/* Generates the word that the player is trying to find. */
	public String generateNewWord(){
		
		Dictionary Dict = new Dictionary();
		theWordToSolve = Dict.getWord(RandomNumberGenerator());		
		return theWordToSolve;		
	}
	
		

	/*
	 Makes a copy of the original word but instead of letters there is only the character '-'.
	 For example if the word is: animal this method generates the table [-,-,-,-,-,-] with length = 6 which is
	 equal to the length of the word animal.
	*/
	public void generateDashedWord(char[] unknownWord,int unknownWordLength){
		
		for(int i=0; i<unknownWordLength; i++ ){
			unknownWord[i] ='-';
		}
	}
	
	
	/* Prints the word the player is trying to find on the screen. */
	public void printDashedWord(char[] unknownWord){
		
		System.out.print("The random word is now: ");
		for(char s :unknownWord){
			System.out.print(s);
		}
		System.out.println();
	}

	
	/* Generates a random integer. */
	public int RandomNumberGenerator(){
		
		Random rand = new Random();	
		return rand.nextInt(30);	// The integer is between 0 to 29.
	}
	
	
	/* Checks if player's guess is part of the original word */
	public boolean guess_matches(String aWord,String aGuess){
		
		for(int i=0; i<aWord.length(); i++){
			if(aWord.charAt(i)==aGuess.charAt(0)){
				return true;
			}
		}
		return false;
	}
	
	
	/* Reveals the correct letter that the player found */
	public void reveal_letter(String aWord,char[] aHiddenWord,String aGuess){
		
		for(int i=0; i<aWord.length(); i++){
			if(aWord.charAt(i) == aGuess.charAt(0)){
				aHiddenWord[i] = aGuess.charAt(0);
				numberOfCorrectLetters++;
			}
		}
	}
	

	/* Generates a 26 length table filled with the character '-' */
	public void generateUsedLetters(char[] usedLetters){
		
		for(int i=0; i<26; i++ ){
			usedLetters[i] ='-';
		}
	}
	
	
	/* Checks if the player has already tried the letter he entered */
	public boolean isLetterNotUsed(char[] usedLetters,String aGuess){
		
		for(int i=0; i<26; i++){
			if(aGuess.charAt(0)== usedLetters[i]){
				return false;
			}
		}
		return true;
	}
	
	
	/* Adds the letter entered by the player to the next free cell in the table containing the used letters */
	public void addUsedLetter(char[] table,int index,String aGuess){
		
		table[index] = aGuess.charAt(0);
		usedLettersCounter++;
	}

	public void printGameStart(){
		System.out.println();
		System.out.println();
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("                            The game is starting");
		System.out.println("                You can only make 8 guesses wrong. Have fun!!!");
		System.out.println("------------------------------------------------------------------------------");
		System.out.println();
		System.out.println();
	}
	
	
	/* Prints a message if the player won the game */
	public void printWin(){
		
		wins++;
		System.out.println();
		System.out.println();
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("          Congratulations! You guessed the word: " +theWordToSolve+"          ");
		System.out.println("          You made "+correctGuesses+" correct guesses and "+wrongGuesses+" wrong guesses");
		System.out.println("------------------------------------------------------------------------------");
		System.out.println();
		System.out.println();
		correctGuesses=0;
		wrongGuesses =0;
	}
	
	
	/* Prints a message if the player lost the game */
	public void printDefeat(){
		
		defeats++;
		System.out.println();
		System.out.println();
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("                       Oops! You didn't make it                           ");
		System.out.println("                       The word was: " +theWordToSolve+"                       ");
		System.out.println("              You made "+correctGuesses+" correct guesses and "+wrongGuesses+" wrong guesses");
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println();
		System.out.println();
		correctGuesses=0;
		wrongGuesses =0;
	}
	
	
	
	public int getGamesPlayed(){
		
		return gamesPlayed;
	}
	
	
	
	public int getWins(){
		
		return wins;
	}
	
	
	
	public int getLoses(){
		
		return defeats;
	}
}
