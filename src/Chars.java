public class Chars{
	private static final char WALL_CHARACTER = '█';
	private static final char[] COIN_CHARACTERS = {'$', '€', '₿'};
	private static final char PLAYER_CHARACTER = 'o';
	private static final char EXIT_CHARACTER = '#';
	private static final String YELLOW = "\u001B[33m";
	private static final String BLUE = "\u001B[34m";
	private static final String END = "\u001B[0m";
	
	
	public static char getWallCharacter(){
		return WALL_CHARACTER;
	}
	
	public static char[] getCoinCharacters(){
		return COIN_CHARACTERS;
	}

	public static char getPlayerCharacter(){
		return PLAYER_CHARACTER;
	}

	public static char getExitCharacter(){
		return EXIT_CHARACTER;
	}
	public static String getColorYellow(){
		return YELLOW;
	}
	public static String getColorBlue(){
		return BLUE;
	}
	public static String getColorEnd(){
		return END;
	}
	
	
}