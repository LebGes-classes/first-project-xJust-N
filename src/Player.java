import java.util.Scanner;

public class Player {
    private Maze maze;
    boolean isReachedEnd = false;
    private Scanner scanner = new Scanner(System.in);
	public Player(Maze maze){
		this.maze = maze;
	}

    public void keyScanner() {
		boolean flag = true;
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
					flag = false;
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

        while (!isReachedEnd && isMoveValid(playerX, playerY, step, isVertical)) {
            mazeMatrix[playerX][playerY] = ' ';
            if (isVertical) {
                playerX += step;
            } else {
                playerY += step;
            }
            char cell = mazeMatrix[playerX][playerY];

            if (cell == exitCharacter) {
                isReachedEnd = true;
                break;
            } else if (cell != ' ') {
                collectCoin(playerX, playerY);
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
            return maze.isAvailableCell(playerX + step, playerY) &&
                   maze.getMazeMatrix()[playerX + step][playerY] != Chars.getWallCharacter();
        } else {
            return maze.isAvailableCell(playerX, playerY + step) &&
                   maze.getMazeMatrix()[playerX][playerY + step] != Chars.getWallCharacter();
        }
    }

    private void collectCoin(int x, int y) {
        char coin = maze.getCell(x, y);
        char[] coins = Chars.getCoinCharacters();
        int coinValue = maze.getCoinValue();
        int amount = coinValue;

        for (char c : coins) {
            if (coin == c) {
                amount += coinValue;
                break;
            }
        }

        maze.setNumberOfCoins(amount + maze.getNumberOfCoins());
    }
	public boolean isPlayerReachedEnd(){
		return isReachedEnd;
	}
}