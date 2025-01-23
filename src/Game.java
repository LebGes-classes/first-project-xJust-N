import java.util.Scanner;


public class Game{
	private int level;
	private Scanner scanner = new Scanner(System.in);
	private boolean gameRunning = false;
	public Game(){
		setLevel(1);
	}
	public Game(int level){
		setLevel(level);
	}
	
	private void playGame(){
		Maze maze = new Maze();
		gameRunning = true;
		while(level <= 50 && gameRunning){
			if(level > 1){
				maze = new Maze(level * 5, maze.getScore(), maze.getPlayerXPos(), maze.getPlayerYPos());
			}
			MazeGenerator.generate(maze);
			Player player = new Player(maze);
			while(!player.isPlayerReachedEnd() && gameRunning){
				Printer.printGame(level, maze);
				player.keyScanner();
				gameRunning = !player.isStoppedGame();
			}
			level += 1;
		}
		start();
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
				controlsMenu();
				break;
			case "3":
				System.out.println("Bye!");
				break;
			
		}
	}
	
	private void controlsMenu(){
		Printer.printControlsMenu();
		String playersChoise = scanner.nextLine();
		while(!(playersChoise.equals("1"))){
			System.out.println("You entered wrong number. Try again.");
			playersChoise = scanner.nextLine();
		}
		start();
	}
	public void setLevel(int lvl){
		level = lvl;
	}
	public int getLevel(){
		return level;
	}
}