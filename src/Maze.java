
public class Maze{
	private int size;
	private char[][] mazeMatrix;
	private int numberOfCoins = 0;
	private int playerX;
	private int playerY;
	private int finishX;
	private int finishY;

	
	Maze(int size, int playerX, int playerY){
		setSize(size);
		initMazeMatrix();
		setPlayerXPos(playerX);
		setPlayerYPos(playerY);
	}
	Maze(int size){
		setSize(size);
		initMazeMatrix();
		setPlayerXPos(size - 1);
		setPlayerYPos(size / 2);
	}
	Maze(){
		setSize(5);
		initMazeMatrix();
		setPlayerXPos(size - 1);
		setPlayerYPos(size / 2);
	}
	public char getCell(int x, int y){
		if(x >= 0 && y >= 0 && x < size && y < size){
			return mazeMatrix[x][y]
		}
		throw new IllegalArgumentException("Invalid coordinates");
	}
	
	
	
	public int getSize(){
		return size;
	}
	public void setSize(int size){
		this.size = size;
	}
	public char[][] getMazeMatrix(){
		return mazeMatrix;
	}
	public void initMazeMatrix(){
		this.mazeMatrix = new char[size][size];
	}
	public int getNumberOfCoins(){
		return numberOfCoins;
	}
	public void setNumberOfCoins(int numberOfCoins){
		this.numberOfCoins = numberOfCoins;
	}
	public int getPlayerXPos(){
		return playerX;
	}
	public void setPlayerXPos(int x){
		this.playerX = x;
	}
	public int getPlayerYPos(){
		return playerY;
	}
	public void setPlayertYPos(int y){
		this.playerY = y;
	}
	public int getFinishXPos(){
		return finishX;
	}
	public void setFinishXPos(int x){
		this.finishX = x;
	}
	public int getFinishYPos(){
		return finishY;
	}
	public void setFinishYPos(int y){
		this.finishY = y;
	}
}