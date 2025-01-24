public class Printer{
	
	static void printMainMenu(){
		clearConsole();
		System.out.println(
			"<-----The Maze----->\n" 
			+ "1) New game\n" 
			+ "2) How to play\n" 
			+ "3) Exit"
		);
	}
	static void printControlsMenu(){
		clearConsole();
		System.out.println(
			"Task: Collect coins and find an exit\n"
			+ "\n"
			+ "Controls:\n"
			+ "W - forward\n"
			+ "A - left\n"
			+ "S - back\n"
			+ "D - right\n"
			+ "1 - back to the main menu\n"
			+ "2 - skip level\n"
			+ "\n"
			+ "1) back to the main menu"
		);
	}
	static void printGameOverScreen(int level, int score){
		clearConsole();
		System.out.println(
			"\tGame over\t\n" 
			+ "Score: " + score + " points\t\n"
			+ "Completed: " + level + " levels\t\n"
			+ "\n"
			+ "1) back to the main menu"
		);
	}
	static void printGame(int level, Maze maze){
		clearConsole();
		printMaze(maze);
		printGameInterface(level,maze);
	}
	
	private static void printMaze(Maze maze){
		clearConsole();
		char mazeWallCharacter = Chars.getWallCharacter();
		char playerCharacter = Chars.getPlayerCharacter();
		char exitCharacter = Chars.getExitCharacter();
		String yellowColor = Chars.getColorYellow();
		String blueColor = Chars.getColorBlue();
		String endColor = Chars.getColorEnd();
		
		int size = maze.getSize();
		char[][] mazeMatrix = maze.getMazeMatrix();
		clearConsole();
		printChars(mazeWallCharacter, size + 2);
		for(int i = 0; i < size; i++){
			System.out.print("\t" + mazeWallCharacter);
			for(int j = 0; j < size; j++){
				char cell = mazeMatrix[i][j];
				if(cell == playerCharacter){
					System.out.print(blueColor + cell + endColor);
				}
				else if(cell == ' ' || cell == mazeWallCharacter || cell == exitCharacter){
					System.out.print(cell);
				}
				else {
					System.out.print(yellowColor + cell + endColor);
				}
			}
			System.out.println(mazeWallCharacter + "\t");	
		}
		printChars(mazeWallCharacter, size + 2);
		
	}
	private static void printGameInterface(int level, Maze maze){
		System.out.println("\t" + "Level: " + level + "\t" + "\n" +
							"\t" + "Score: " + maze.getScore() + "\t" + "\n" +
							"\t" + "Coins to collect: " + maze.getNumberOfCoins() + "\t");
	}
	
	private static void printChars(char ch, int length){
		System.out.print("\t");	
		for(int i = 0; i < length; i++){
			System.out.print(ch);	
		}
		System.out.println("\t");	
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