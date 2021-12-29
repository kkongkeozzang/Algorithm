import java.util.Scanner;

public class BOJ10818 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		String str = sc.nextLine();
		sc.close();
		String[] arr = str.split(" ");
		int[] intArr = new int[n];
		for(int i=0; i<n;i++) {
			intArr[i] = Integer.parseInt((arr[i]));
		}
		int minNum = 1000001;
		int maxNum = -1000001;
		for(int i : intArr) {
			if(minNum>i) {
				minNum = i;
			}
			if(maxNum<i) {
				maxNum = i;
			}
		}
		
		System.out.println(minNum + " " + maxNum);
	}
}
