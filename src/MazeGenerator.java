import java.util.Random;

public class MazeGenerator implements MapGenerator{
	
	private Random random = new Random();
	private size;
	
	
	public void clear(){
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				maze[i][j] = mazeWallCharacter;
			}
		}
	}
	public void generate(){
		int x = startX;
		int y = startY;
		maze[x][y] = playerCharacter;
		int[][] movesets = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
		int[][] avaiableMovesets = {{0, 0}, {0, 0}, {0, 0}, {0, 0}};
		boolean flag = true;
		boolean isExitCreated = false;
		while(x != startX || y != startY || flag){
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
						if(!isExitCreated){
							maze[x][y] = exitCharacter;
							finishX = x;
							finishY = y;
							isExitCreated = true;
						}
						else if(numberOfCoins == 0 || random.nextInt(coinSpawnChance) == coinSpawnChance - 1){
							if (random.nextBoolean()){
								maze[x][y] = coinCharacter2;
								numberOfCoins += 5;
							}
							else{
								maze[x][y] = coinCharacter1;
								numberOfCoins++;
							}
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
					if(flag){
						flag = false;
					}

				}
				
		}
	}
}