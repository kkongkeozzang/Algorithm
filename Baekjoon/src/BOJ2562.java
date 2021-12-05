import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ2562 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int maxNum = 0;
		List<Integer> list = new ArrayList<>();
		for (int i=0;i<9;i++) {
			list.add(sc.nextInt());
		}
		for (int i : list) {
			maxNum = Math.max(maxNum, i);
		}
		System.out.println(maxNum);
		System.out.println(list.indexOf(maxNum)+1);
	}
}
