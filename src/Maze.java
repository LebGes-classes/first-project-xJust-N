
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

	
	Maze(int size, int score, int playerX, int playerY){
		setSize(size);
		setScore(score);
		initMazeMatrix();
		setPlayerXPos(playerX);
		setPlayerYPos(playerY);
	}
	Maze(int size){
		setSize(size);
		setScore(0);
		initMazeMatrix();
		setPlayerXPos(size - 1);
		setPlayerYPos(size / 2);
	}
	Maze(){
		setSize(5);
		setScore(0);
		initMazeMatrix();
		setPlayerXPos(size - 1);
		setPlayerYPos(size / 2);
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
	
	public char getCell(int x, int y){
		if(isAvailableCell(x, y)){
			return mazeMatrix[x][y];
		}
		throw new IllegalArgumentException("Invalid coordinates");
	}
	public int getSize(){
		return size;
	}
	private void setSize(int size){
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
		if(numberOfCoins >= 0){
			this.numberOfCoins = numberOfCoins;
		}
		else{
			throw new IllegalArgumentException("Negative value");
		}
	}
		public int getScore(){
		return score;
	}
	
	void setScore(int score){
		if(score >= 0){
			this.score = score;
		}
		else{
			throw new IllegalArgumentException("Negative value");
		}
	}
	
	
	public int getCoinValue(){
		return coinValue;
	}
	public void setCoinValue(int coinValue){
		if(coinValue >= 0){
			this.coinValue = coinValue;
		}
		else{
			throw new IllegalArgumentException("Negative value");
		}
	}
	
	public int getPlayerXPos(){
		return playerX;
	}
	void setPlayerXPos(int x){
		if(x >= 0 && x < size){
			playerX = x;
		}
		else{
			throw new IllegalArgumentException("Invalid x");
		}
	}
	public int getPlayerYPos(){
		return playerY;
	}
	void setPlayerYPos(int y){
		if(y >= 0 && y < size){
			playerY = y;
		}
		else{
			throw new IllegalArgumentException("Invalid y");
		}
	}
	public int getFinishXPos(){
		return finishX;
	}
	void setFinishXPos(int x){
		if(x >= 0 && x < size){
			finishX = x;
		}
		else{
			throw new IllegalArgumentException("Invalid y");
		}
	}
	public int getFinishYPos(){
		return finishY;
	}
	public void setFinishYPos(int y){
		if(y >= 0 && y < size){
			finishY = y;
		}
		else{
			throw new IllegalArgumentException("Invalid y");
		}
	}
}