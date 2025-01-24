
public class Maze{
	private int size;
	private char[][] mazeMatrix;
	private int score;
	private int coinValue = 5;
	private int numberOfCoins;
	private int playerX;
	private int playerY;
	private int finishX;
	private int finishY;

	
	Maze(int level, int score, int playerX, int playerY){
		setSize(convertLevelToSize(level));
		setScore(score);
		initMazeMatrix();
		setPlayerXPos(playerX);
		setPlayerYPos(playerY);
	}
	Maze(int level){
		setSize(convertLevelToSize(level));
		setScore(0);
		initMazeMatrix();
		setPlayerXPos(size - 1);
		setPlayerYPos(size / 2);
	}
	Maze(){
		setSize(convertLevelToSize(1));
		setScore(0);
		initMazeMatrix();
		setPlayerXPos(size - 1);
		setPlayerYPos(size / 2);
	}
	
	private int convertLevelToSize(int level){
		int border = 3;
		if(level <= 0){
			throw new IllegalArgumentException("Level must be positive");
		}
		if(level <= border){
			return level * 5;
		}
		else{
			return border * 5 + (level - border) * 4;
		}
	}
	
	public boolean isValidCoordinates(int x, int y){
		return x >= 0 && x < size && y >= 0 && y < size;
	}
	public boolean isAvailableCell(int x, int y){
		return isValidCoordinates(x,y) && mazeMatrix[x][y] != Chars.getWallCharacter();
	}
	public boolean isCrossroad(int x, int y){
		int ways = 0;
		int[][] movesets = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
		for(int[] direction : movesets){
			int x1 = x + direction[0];
			int y1 = y + direction[1];
			if(isAvailableCell(x1, y1)){
				ways++;
			}
		}
		return ways > 2;
	}
	void collectCoin(int x, int y) {
        char coin = mazeMatrix[x][y];
        char[] coins = Chars.getCoinCharacters();
        int i = 0;
        while(i < coins.length && coin != coins[i]) {
			i += 1;
        }
		if(coin == coins[i]){
			score += (i+1) * coinValue;
			numberOfCoins -= 1;
		}
		else{
			throw new IllegalArgumentException("Not a coin");
		}
    }
	public void setCoinValue(int coinValue){
		if(coinValue > 0){
			this.coinValue = coinValue;
		}
		else{
			throw new IllegalArgumentException("Value must be positive");
		}
	}
	public int getSize(){
		return size;
	}
	void setSize(int size){
		this.size = size;
	}
	public char[][] getMazeMatrix(){
		return mazeMatrix;
	}
	private void initMazeMatrix(){
		this.mazeMatrix = new char[size][size];
	}
	public int getNumberOfCoins(){
		return numberOfCoins;
	}
	void setNumberOfCoins(int numberOfCoins){
		this.numberOfCoins = numberOfCoins;
	}
	public int getScore(){
		return score;
	}
	
	void setScore(int score){
		this.score = score;
	}
	
	public int getCoinValue(){
		return coinValue;
	}
	
	public int getPlayerXPos(){
		return playerX;
	}
	void setPlayerXPos(int x){
		playerX = x;
	}
	public int getPlayerYPos(){
		return playerY;
	}
	void setPlayerYPos(int y){
		playerY = y;
	}
	public int getFinishXPos(){
		return finishX;
	}
	void setFinishXPos(int x){
		finishX = x;
	}

	public int getFinishYPos(){
		return finishY;
	}
	void setFinishYPos(int y){
		finishY = y;
	}
}