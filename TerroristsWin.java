import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TerroristsWin {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);		
		StringBuilder text = new StringBuilder(scn.nextLine());
		
		List<Integer> bombIndexes = new ArrayList<>();
		List<Integer> damageIndexes = new ArrayList<>();
		
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			
			if (c == '|') {
				bombIndexes.add(i);
			}			
		}
		
		for (int i = 0; i < bombIndexes.size(); i += 2) {
			int start = bombIndexes.get(i) + 1;
			int end = bombIndexes.get(i + 1);
			String bomb = text.substring(start, end);
			int bombPower = calcBombPower(bomb);
			
			start = start - bombPower - 1;
			damageIndexes.add(start);
			end = end + bombPower;
			damageIndexes.add(end);
		}		
		
		int index = 0;
		for (int i = 0; i < text.length(); i++) {
			if (index == damageIndexes.size()) {
				break;
			}
			if (i >= damageIndexes.get(index) && i <= damageIndexes.get(index + 1)) {
				text.setCharAt(i, '.');
			}
			if (i == damageIndexes.get(index + 1)) {
				index +=2;
			}
		}
		
		System.out.println(text);

	}

	private static int calcBombPower(String bomb) {
		int sum = 0;
		for (int j = 0; j < bomb.length(); j++) {
			sum += bomb.charAt(j);
		}
		int power = sum % 10;
		return power;
	}

}
