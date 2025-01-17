
public class Maze{
	private int size;
	private char[][] maze;
	private int numberOfCoins = 0;
	private int coinSpawnChance = 10;
	private int startX;
	private int startY;
	private int finishX;
	private int finishY;

	
	Maze(int size, int startX, int startY){
		this.size = size;
		maze = new char[size][size];
		this.startX = startX;
		this.startY = startY;
		clearMaze();
		generateMaze();
	}
	Maze(){
		this.size = 5;
		maze = new char[size][size];
		startX = size - 1;
		startY = size / 2;
		clearMaze();
		generateMaze();
	}
}