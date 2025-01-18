
public class Maze{
	private int size;
	private char[][] mazeMatrix;
	private int numberOfCoins = 0;
	private int startX;
	private int startY;
	private int finishX;
	private int finishY;

	
	Maze(int size, int startX, int startY){
		setSize(size);
		mazeMatrix = new char[size][size];
		setStartXPos(startX);
		setStartYPos(startY);
	}
	Maze(int size){
		setSize(size);
		mazeMatrix = new char[size][size];
		setStartXPos(size - 1);
		setStartYPos(size / 2);
	}
	Maze(){
		setSize(5);
		mazeMatrix = new char[size][size];
		setStartXPos(size - 1);
		setStartYPos(size / 2);
	}
	
	public int getSize(){
		return size;
	}
	public void setSize(int size){
		this.size = size;
	}
	public char getMazeCell(int x, int y){
		return mazeMatrix[x][y];
	}
	public void setMazeCell(char cell, int x, int y){
		mazeMatrix[x][y] = cell;
	}
	public char[][] getMazeMatrix(){
		return mazeMatrix;
	}
	public void setMazeMatrix(char[][] mazeMatrix){
		this.mazeMatrix = mazeMatrix;
	}
	public int getNumberOfCoins(){
		return numberOfCoins;
	}
	public void setNumberOfCoins(int numberOfCoins){
		this.numberOfCoins = numberOfCoins;
	}
	public int getStartXPos(){
		return startX;
	}
	public void setStartXPos(int x){
		this.startX = x;
	}
	public int getStartYPos(){
		return startY;
	}
	public void setStartYPos(int y){
		this.startY = y;
	}
	public int getFinishXPos(){
		return finishX;
	}
	public void setFinishXPos(int x){
		this.finishX = x;
	}
	public int getFinishYPos(){
		return startY;
	}
	public void setFinishYPos(int y){
		this.startY = y;
	}
}