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
	public void startMenu(){
		clearConsole();
		System.out.println(
			"-----\tMaze\t-----\n" 
			+ "1) New game\n" 
			+ "2) How to play\n" 
			+ "3) Exit"
		);
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
				conrolsMenu();
				break;
			case "3":
				System.out.println("Bye!");
				break;
			
		}
	}
	
	private void conrolsMenu(){
		clearConsole();
		System.out.println(
			"Task: Collect all coins to go on the next level\n"
			+ "\n" 
			+ "Controls:\n" 
			+ "W - forward\n" 
			+ "A - left\n" 
			+ "S - back\n" 
			+ "D - right\n"
			+ "\n"
			+ "1) back to the main menu"
		);
		String playersChoise = scanner.nextLine();
		while(!(playersChoise.equals("1"))){
			System.out.println("You entered wrong number. Try again.");
			playersChoise = scanner.nextLine();
		}
		startMenu();
	}
	
	public static void clearConsole(){
		try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} 
		catch (Exception E) {
			System.out.println(E);
		}
	}
	

}