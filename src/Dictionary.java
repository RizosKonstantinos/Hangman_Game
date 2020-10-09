
public class Dictionary {
		
	
	/*  
	 * Returns a string which is the word that the player is trying to find.
	 *  This method is basically the pool where words are kept.
	*/
	public String getWord(int index) {
	
		switch (index) {
			case 0: return "UNIVERSITY";
			case 1: return "COMPUTER";
			case 2: return "LAPTOP";
			case 3: return "HEADPHONES";
			case 4: return "FUZZY";
			case 5: return "DOG";
			case 6: return "KEYHOLE";
			case 7: return "TELEPHONE";
			case 8: return "PRINTER";
			case 9: return "BUILDING";
			case 10: return "KIWIFRUIT";
			case 11: return "LUCKY";
			case 12: return "LUXURY";
			case 13: return "JUKEBOX";
			case 14: return "JACKPOT";
			case 15: return "GOSSIP";
			case 16: return "PIXEL";
			case 17: return "QUIZ";
			case 18: return "PUZZLE";
			case 19: return "VORTEX";
			case 20: return "WIZARD";
			case 21: return "WALKWAY";
			case 22: return "MATRIX";
			case 23: return "PUPPY";
			case 24: return "ZOMBIE";
			case 25: return "ZODIAC";
			case 26: return "WAVE";
			case 27: return "VODKA";
			case 28: return "ABYSS";
			case 29: return "BLIZZARD";			
			default: return "Illegal index";
		}
	}
}
