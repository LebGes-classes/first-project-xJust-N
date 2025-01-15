import java.util.Random;

public class Map{
	private int size;
	private char[][] maze;
	private int numberOfCoins = 0;
	private int coinSpawnChance = 10;
	private int startX;
	private int startY;
	private int finishX;
	private int finishY;
	private char mazeWallCharacter = '#';
	private char coinCharacter = '$';
	private char playerCharacter = 'o';
	private Random random = new Random();
	
	Map(int size){
		this.size = size;
		maze = new char[size][size];
		startX = size / 2;
		startY = size - 1;
		clearMaze();
		generateMaze();
	}
	Map(){
		this.size = 9;
		maze = new char[size][size];
		startX = size / 2;
		startY = size - 1;
		clearMaze();
		System.out.println(123);
		generateMaze();
	}
	
	public void clearMaze(){
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				maze[i][j] = mazeWallCharacter;
			}
		}
	}
	public void generateMaze(){
		int x = startX;
		int y = startY;
		maze[x][y] = playerCharacter;
		int[][] movesets = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
		int[][] avaiableMovesets = {{0, 0}, {0, 0}, {0, 0}};
		boolean flag = true;
		while(x != startX || y != startY || flag){
			if(flag){
				flag = false;
			}
			int avaiableCount = 0;
			int backX = 0;
			int backY = 0;
			for(int[] direction : movesets){
				int x1 = x + direction[0] * 2;
				int y1 = y + direction[1] * 2;
				if(x1 >= 0 && y1 >= 0 && x1 < size && y1 < size){
					if(maze[x1][y1] == mazeWallCharacter){
						avaiableMovesets[avaiableCount][0] = direction[0];
						avaiableMovesets[avaiableCount][1] = direction[1];
						avaiableCount++;
					}
					else if(maze[x + direction[0]][y + direction[1]] == 'v'){
						backX = direction[0];
						backY = direction[1];
					}
				}
			}
				if(avaiableCount == 0){
					for(int i = 0; i < 2; i++){	
						if(numberOfCoins == 0 || random.nextInt(coinSpawnChance) == coinSpawnChance - 1){
							maze[x][y] = coinCharacter;
							numberOfCoins++;
						}
						else{
							maze[x][y] = ' ';
						}
						x += backX;
						y += backY;
					}
				}	
				
				else{
					int index = random.nextInt(avaiableCount);
					for(int i = 0; i < 2; i++){
						x += avaiableMovesets[index][0];
						y += avaiableMovesets[index][1];
						maze[x][y] = 'v';
					}
					
					finishX = x;
					finishY = y;

				}
				
		}
	}
	
	
	public void printMaze(){
		Game.clearConsole();
		for(int i = 0; i < size - 1; i++){
			System.out.print(mazeWallCharacter);	
		}
		System.out.println(mazeWallCharacter + "\t");
		for(int i = 0; i < size; i++){
			System.out.print(mazeWallCharacter);
			for(int j = 0; j < size; j++){
				System.out.print(maze[i][j]);
			}
			System.out.println(mazeWallCharacter + "\t");
		}
		for(int i = 0; i < size - 1; i++){
			System.out.print(mazeWallCharacter);	
		}
		System.out.println(mazeWallCharacter + "\t");
	}
}