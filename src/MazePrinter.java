public class MazePrinter{
	
	public void printMaze(){
		Game.clearConsole();
		printMazeWalls(size + 2);
		for(int i = 0; i < size; i++){
			printMazeLine(i);
		}
		printMazeWalls(size + 2);
		
	}
	
	private void printMazeLine(int line){
		System.out.print("\t" + mazeWallCharacter);
		for(int j = 0; j < size; j++){
			System.out.print(maze[line][j]);	
		}
		System.out.println(mazeWallCharacter + "\t");	
	}
	private void printMazeWalls(int length){
		System.out.print("\t");	
		for(int i = 0; i < length; i++){
			System.out.print(mazeWallCharacter);	
		}
		System.out.println("\t");	
	}
}