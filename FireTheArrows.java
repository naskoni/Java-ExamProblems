import java.util.Scanner;

public class FireTheArrows {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scn = new Scanner(System.in);
		int n = Integer.parseInt(scn.nextLine());
		char[][] matrix = new char[n][];
		
		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = scn.nextLine().toCharArray(); 
		}
		
		boolean madeAMove = true;
		while (madeAMove) {
			madeAMove = false;
			
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					if (matrix[i][j] == '<') {
						if (j > 0 && matrix[i][j - 1] == 'o') {
							matrix[i][j - 1] = '<';
							matrix[i][j] = 'o';
							madeAMove = true;
						}
					}
					
					else if (matrix[i][j] == '>') {
						if (j < matrix[i].length - 1 && matrix[i][j + 1] == 'o') {
							matrix[i][j + 1] = '>';
							matrix[i][j] = 'o';
							madeAMove = true;
						}
					}
					
					else if (matrix[i][j] == 'v') {
						if (i < matrix.length - 1 && matrix[i + 1][j] == 'o') {
							matrix[i + 1][j] = 'v';
							matrix[i][j] = 'o';
							madeAMove = true;
						}
					}
					
					else if (matrix[i][j] == '^') {
						if (i > 0 && matrix[i - 1][j] == 'o') {
							matrix[i - 1][j] = '^';
							matrix[i][j] = 'o';
							madeAMove = true;
						}
					}
				}				
			}
		}
		
		printMatrix(matrix);
	}

	private static void printMatrix(char[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}		
	}
}
