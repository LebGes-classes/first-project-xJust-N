import java.util.Random;

public class MazeGenerator{
	
	public static void generate(Maze maze){
		int size = maze.getSize();
		int startX = maze.getStartXPos();
		int startY = maze.getStartYPos();
		char[][] mazeMatrix = maze.getMazeMatrix();
		char mazeWallCharacter = Chars.getWallCharacter();
		char exitCharacter = Chars.getExitCharacter();
		char[] coinCharacters = Chars.getCoinCharacters();
		int coinCharactersSize = coinCharacters.length;
		
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				mazeMatrix[i][j] = mazeWallCharacter;
			}
		}
		mazeMatrix[startX][startY] = Chars.getPlayerCharacter();
		
		Random random = new Random();
		int coinSpawnChance = size;
		int numberOfCoins = 0;
		int[][] movesets = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
		int[][] avaiableMovesets = {{0, 0}, {0, 0}, {0, 0}, {0, 0}};
		int x = startX;
		int y = startY;
		int finishX = 0;
		int finishY = 0;
		boolean isExitCreated = false;
		while(x != startX || y != startY || !isExitCreated){
			int avaiableCount = 0;
			int backX = 0;
			int backY = 0;
			for(int[] direction : movesets){
				int x1 = x + direction[0] * 2;
				int y1 = y + direction[1] * 2;
				if(x1 >= 0 && y1 >= 0 && x1 < size && y1 < size){
					if(mazeMatrix[x1][y1] == mazeWallCharacter){
						avaiableMovesets[avaiableCount][0] = direction[0];
						avaiableMovesets[avaiableCount][1] = direction[1];
						avaiableCount++;
					}
					else if(mazeMatrix[x + direction[0]][y + direction[1]] == 'v'){
						backX = direction[0];
						backY = direction[1];
					}
				}
			}
			if(avaiableCount == 0){
				for(int i = 0; i < 2; i++){	
					if(!isExitCreated){
						mazeMatrix[x][y] = exitCharacter;
						finishX = x;
						finishY = y;
						isExitCreated = true;
					}
					else if(numberOfCoins == 0 || random.nextInt(coinSpawnChance) == coinSpawnChance - 1){
						int coinIndex = random.nextInt(coinCharactersSize);
						mazeMatrix[x][y] = coinCharacters[coinIndex];
						numberOfCoins += 1 + coinIndex;
					}
					else{
						mazeMatrix[x][y] = ' ';
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
					mazeMatrix[x][y] = 'v';
				}
					
				finishX = x;
				finishY = y;
			}
		}
		maze.setFinishXPos(finishX);
		maze.setFinishYPos(finishY);
		maze.setNumberOfCoins(numberOfCoins);
		
	}
}