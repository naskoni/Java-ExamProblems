import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Pyramid {
	
	public static void main(String[] args) {		
		@SuppressWarnings("resource")
		Scanner scn = new Scanner(System.in);
		int n = Integer.parseInt(scn.nextLine());
		int startNum = Integer.parseInt(scn.nextLine().trim());		
		ArrayList<Integer> listNums = new ArrayList<>();
		listNums.add(startNum);
		
		for (int i = 0; i < n - 1; i++) {
			String[] currLine = scn.nextLine().split("\\s+");
			int[] currNums = new int[currLine.length];
			for (int j = 0; j < currLine.length; j++) {
				if (currLine[j].equals("")) {
					currNums[j] = Integer.MIN_VALUE;
				} else {
					currNums[j] = Integer.parseInt(currLine[j]);
				}
			}
			
			Arrays.sort(currNums);
			boolean found = false;
			for (int j = 0; j < currNums.length; j++) {							
				if (startNum < currNums[j]) {
					listNums.add(currNums[j]);
					startNum = currNums[j];
					found = true;
					break;
				} else {	
					continue;
				}				
			}
			
			if (!found) {
				startNum++;
			}			
		}
		
		for (int i = 0; i < listNums.size(); i++) {
			if (i < listNums.size() - 1) {
				System.out.print(listNums.get(i) + ", ");
			} else {
				System.out.print(listNums.get(i));
			}
		}		
	}	
}
	
