

public class Main {

	public static void main(String[] args) {

		Menu theMenu = new Menu();
		
		Statistics stats = new Statistics();
		
		boolean more = true;
		
		while(more){

			/* Prints the main menu on the screen */
			theMenu.printMenu();

			/* Player chooses an option from the menu */
			theMenu.printChooseAnOption();

			String playerAnswer = theMenu.getAnswer();

			switch (playerAnswer) {
				case "N":

					/* Create and start a new game*/
					Game aNewGame = new Game();
					aNewGame.startNewGame();
					break;

				case "S":

					/* Print the statistics of the games so far */
					stats.printStatistics();
					break;

				case "E":

					/* Exit the game*/
					more = false;
					break;

				default:
					System.out.println();
					break;
			}
		}
	}
}
