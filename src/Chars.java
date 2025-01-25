public class Chars{
	private static char wallCharacter = '█';
	private static char[] coinCharacters = {'$', '€', '₿'};
	private static char playerCharacter = 'o';
	private static char exitCharacter = '#';
	private static String yellow = "\u001b[33m";
	private static String blue = "\u001b[34m";
	private static String end = "\u001b[0m";
	
	public static boolean isCoin(char ch){
		for(char coin:coinCharacters){
			if(ch == coin){
				return true;
			}
		}
		return false;
	}
	
	public static char getWallCharacter(){
		return wallCharacter;
	}
	
	public static char[] getCoinCharacters(){
		return coinCharacters;
	}

	public static char getPlayerCharacter(){
		return playerCharacter;
	}

	public static char getExitCharacter(){
		return exitCharacter;
	}
	public static String getColorYellow(){
		return yellow;
	}
	public static String getColorBlue(){
		return blue;
	}
	public static String getColorEnd(){
		return end;
	}
	
	
}