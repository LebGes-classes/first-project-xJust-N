import java.util.Scanner;


public class Game{
	private int level;
	private Scanner scanner;
	
	public Game(){
		this.level = 0;
		scanner = new Scanner(System.in);
	}
	public Game(int level){
		this.level = level;
		scanner = new Scanner(System.in);
	}
	
	private void playGame(){
		Maze maze = new Maze(101);
		MazeGenerator.generate(maze);
		Printer.printMaze(maze);
		
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
				controls();
				break;
			case "3":
				System.out.println("Bye!");
				break;
			
		}
	}
	
	private void controls(){
		Printer.printControlsMenu();
		String playersChoise = scanner.nextLine();
		while(!(playersChoise.equals("1"))){
			System.out.println("You entered wrong number. Try again.");
			playersChoise = scanner.nextLine();
		}
		startMenu();
	}
}