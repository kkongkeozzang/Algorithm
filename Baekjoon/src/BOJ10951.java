import java.util.Scanner;

public class BOJ10951 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			while(true) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				System.out.println(a+b);
			}
		}catch(Exception e) {
			System.exit(0);
		}
	}
}
