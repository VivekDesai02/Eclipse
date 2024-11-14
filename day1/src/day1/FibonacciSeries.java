package day1;
import java.util.Scanner;

public class FibonacciSeries {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enetr the Limit");
		int limit = sc.nextInt();
		
		int Fs = 0, Se = 1;
		
		System.out.print(Fs + " " + Se+" ");
		
		for(int i = 0; i < limit; i++) {
			int Tr = Fs + Se;
			System.out.print(Tr + " ");
			Fs = Se;
			Se = Tr; /* jbuygyfuhiuh */
		}
		

	}

}
