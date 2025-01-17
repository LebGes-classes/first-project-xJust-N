public class Chars{
	private char wallCharacter = '█';
	private char[][] coinCharacters = {'$', 'c'};
	private char playerCharacter = 'o';
	private char exitCharacter = '#';
	
	public void setWallCharacter(char ch){
		this.wallCharacter = ch;
	}
	public char getWallCharacter(){
		return wallCharacter;
	}
	public void setCoinCharacters(char[] ch){
		this.coinCharacters = new ch;
	}
	public char[] getCoinCharacters(){
		return coinCharacters;
	}
	public void setPlayerCharacter(char ch){
		this.playerCharacter = ch;
	}
	public char getPlayerCharacter(){
		return playerCharacter;
	}
	public void setExitCharacter(char ch){
		this.playerCharacter = ch;
	}
	public char getExitCharacter(){
		return exitCharacter;
	}
	
	
}