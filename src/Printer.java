public class Printer{
	
	public static void printMaze(Maze maze){
		char mazeWallCharacter = Chars.getWallCharacter();
		char playerCharacter = Chars.getPlayerCharacter();
		char exitCharacter = Chars.getExitCharacter();
		String yellowColor = Chars.getColorYellow();
		String blueColor = Chars.getColorBlue();
		String endColor = Chars.getColorEnd();
		int size = maze.getSize();
		char[][] mazeMatrix = maze.getMazeMatrix();
		Game.clearConsole();
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
	
	private static void printChars(char ch, int length){
		System.out.print("\t");	
		for(int i = 0; i < length; i++){
			System.out.print(ch);	
		}
		System.out.println("\t");	
	}
}