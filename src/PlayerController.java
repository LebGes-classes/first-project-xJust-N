import java.util.Scanner;

public class PlayerController{
	private Maze maze;
	boolean reachedEnd = false;
	private Scanner scanner = new Scanner();
	
	public PlayerController(Maze maze){
		this.maze = maze;
	}

	public void keyListener(){

		String input = (scanner.nextLine()).toLowerCase();
		for(int i = 0; i < input.length; i++){
			char command = input.charAt(i);
			switch(command){
				case 'w':
					move(-1,true);
					break;
				case 'a':
					move(-1, false);
					break;
				case 's':
					move(1, true);
					break;
				case 'd':
					move(1, false);
					break;
				case '1':
					return false;
				default:
					break;
					
			}
		}
	}
	private void move(int step, boolean direction){
		int size = maze.getSize();
		playerX = maze.getPlayerX();
		playerY = maze.getPlayerY();
		while(true){
			for(int i = 0; i >= 0 && i < size; i += v){
				
			}
		}
	}
	
	
	public void setPlayerX(int x){
		playerX = x;
	}
	public void setPlayerY(int y){
		playerY = y;
	}
}