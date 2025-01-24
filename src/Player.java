import java.util.Scanner;

public class Player {
    private Maze maze;
	boolean stoppedGame = false;
    boolean reachedEnd = false;
    private Scanner scanner = new Scanner(System.in);
	public Player(Maze maze){
		this.maze = maze;
	}

    public void keyScanner() {
		String input = (scanner.nextLine()).toLowerCase();
		for (int i = 0; i < input.length(); i++) {
			char command = input.charAt(i);
			switch (command) {
				case 'w':
					movePlayer(-1, true);
					break;
				case 'a':
					movePlayer(-1, false);
					break;
				case 's':
					movePlayer(1, true);
					break;
				case 'd':
					movePlayer(1, false);
					break;
				case '1':
					stoppedGame = true;
					break;
				case '2':
					skipLevel();
					break;
				default:
					break;
			}
		}
        
    }

    private void movePlayer(int step, boolean isVertical) {
        int size = maze.getSize();
        char[][] mazeMatrix = maze.getMazeMatrix();
        int playerX = maze.getPlayerXPos();
        int playerY = maze.getPlayerYPos();
        char exitCharacter = Chars.getExitCharacter();
        char wallCharacter = Chars.getWallCharacter(); 
        char playerCharacter = Chars.getPlayerCharacter();

        while (!reachedEnd && isMoveValid(playerX, playerY, step, isVertical)) {
            mazeMatrix[playerX][playerY] = ' ';
            if (isVertical) {
                playerX += step;
            } else {
                playerY += step;
            }
            char cell = mazeMatrix[playerX][playerY];

            if (cell == exitCharacter) {
                reachedEnd = true;
                break;
            } else if (cell != ' ') {
                maze.collectCoin(playerX, playerY);
            }

            mazeMatrix[playerX][playerY] = playerCharacter;

            if (maze.isCrossroad(playerX, playerY)) {
                break;
            }
        }

        if (isVertical) {
            maze.setPlayerXPos(playerX);
        } else {
            maze.setPlayerYPos(playerY);
        }
    }

    private boolean isMoveValid(int playerX, int playerY, int step, boolean isVertical) {
        if (isVertical) {
            return maze.isAvailableCell(playerX + step, playerY);
        } else {
            return maze.isAvailableCell(playerX, playerY + step);
        }
    }
	private void skipLevel(){
		maze.setPlayerXPos(maze.getFinishXPos());
		maze.setPlayerYPos(maze.getFinishYPos());
		reachedEnd = true;
	}
	
	boolean isPlayerReachedEnd(){
		return reachedEnd;
	}
	boolean isStoppedGame(){
		return stoppedGame;
	}
}