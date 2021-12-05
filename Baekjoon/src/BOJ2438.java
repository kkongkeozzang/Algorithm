import java.util.Scanner;

public class BOJ2438 {
	public static void main(String[] agrs) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		String arr = "";
		for(int i=1;i<=n;i++) {
			arr += "*";
			System.out.println(arr);
		}
		sc.close();
	}
}
