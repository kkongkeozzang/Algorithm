import java.util.Scanner;

public class BOJ11720 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		char[] num = sc.nextLine().toCharArray();
		int total = 0;
		for(int i=0;i<t;i++) {
			total += Integer.parseInt(String.valueOf(num[i]));
		}
		sc.close();
		System.out.println(total);
	}
}
