import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class SchoolSystem {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scn = new Scanner(System.in);
		int n = Integer.parseInt(scn.nextLine());
		Map<String, TreeMap<String, List<Double>>> grades = new TreeMap<>();
		
		for (int i = 0; i < n; i++) {
			String[] tokens = scn.nextLine().split(" ");
			String name = tokens[0] + " " + tokens[1];
			String subject = tokens[2];
			double grade = Double.parseDouble(tokens[3]);
			
			if (!grades.containsKey(name)) {
				grades.put(name, new TreeMap<>());
				grades.get(name).put(subject, new ArrayList<Double>());
				grades.get(name).get(subject).add(grade);
			} else {
				if (!grades.get(name).containsKey(subject)) {
					grades.get(name).put(subject, new ArrayList<Double>());
					grades.get(name).get(subject).add(grade);
				} else {
					grades.get(name).get(subject).add(grade);
				}
			}
		}
		
		for (Entry<String, TreeMap<String, List<Double>>> entry : grades.entrySet()) {
			System.out.printf("%s: [", entry.getKey());
			
			Map<String, List<Double>> subject = entry.getValue();
			int count = subject.entrySet().size();
			for (Entry<String, List<Double>> entry2 : subject.entrySet()) {
				double sumOfGrades = entry2.getValue().stream()
						.mapToDouble(Double::doubleValue)
						.sum();
				int countOfGrades = entry2.getValue().size();
				double averageGrade = sumOfGrades / countOfGrades;
				if (count == 1) {
					System.out.printf("%s - %.2f]", entry2.getKey(), averageGrade);
				} else {
					System.out.printf("%s - %.2f, ", entry2.getKey(), averageGrade);
				}
				count--;				
				
			}
			System.out.println();
		}

	}

}
