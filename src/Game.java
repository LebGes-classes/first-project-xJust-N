import java.util.Scanner;


public class Game{
	private int level;
	private int finalLevel;
	private Scanner scanner = new Scanner(System.in);
	private boolean gameRunning = false;
	
	public Game(){
		setLevel(0);
		setFinalLevel(50);
	}
	public Game(int level){
		setLevel(level);
		setFinalLevel(50);
	}
	public Game(int level, int finalLevel){
		setLevel(level);
		setFinalLevel(finalLevel);
	}
	
	private void playGame(){
		Maze maze = new Maze();
		gameRunning = true;
		while(level <= finalLevel && gameRunning){
			level += 1;
			if(level > 1){
				maze = new Maze(level, maze.getScore(), maze.getPlayerXPos(), maze.getPlayerYPos());
			}
			MazeGenerator.generate(maze);
			Player player = new Player(maze);
			while(!player.isPlayerReachedEnd() && gameRunning){
				Printer.printGame(level, maze);
				player.keyScanner();
				gameRunning = !player.isStoppedGame();
			}
		}
		Printer.printGameOverScreen(level - 1, maze.getScore());
		waitForReturnToMainMenu();
	}
	public void start(){
		Printer.printMainMenu();
		String playersChoise = scanner.nextLine();
		while(!(playersChoise.equals("1") || playersChoise.equals("2") || playersChoise.equals("3"))){
			System.out.println("You entered wrong number. Try again.");
			playersChoise = scanner.nextLine();
		}
		switch(playersChoise){
			case "1":
				playGame();
				break;
			case "2":
				Printer.printControlsMenu();
				waitForReturnToMainMenu();
				break;
			case "3":
				System.out.println("Bye!");
				break;
			
		}
	}
	
	private void waitForReturnToMainMenu(){
		String playersChoise = scanner.nextLine();
		while(!(playersChoise.equals("1"))){
			System.out.println("You entered wrong number. Try again.");
			playersChoise = scanner.nextLine();
		}
		start();
	}
	private void setLevel(int lvl){
		level = lvl;
	}
	public int getLevel(){
		return level;
	}
	private void setFinalLevel(int lvl){
		finalLevel = lvl;
	}
	public int getFinalLevel(){
		return finalLevel;
	}
}
