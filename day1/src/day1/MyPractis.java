package day1;
import java.util.Scanner;

public class MyPractis {
	
	static void PrimeNumber(int num) {
		int isPrime = 0;
		for(int i = 2; i <= num/2; i++) {
			if(num % i == 0) {
				isPrime = 1;
			}
		}
		if(isPrime == 0) {
			System.out.println("This is Prime Number...");
		}else {
			System.out.println("This is not prime number... ");
		}
	}
	
	static void ArmstrongNumber(int num, int digit) {
		int sum = 0;
		int temp = num;
		
		for(int i = 0; num > 0; i++) {
			int x = num % 10;
			int mult = 0;
			
			for(int j = 1; j < digit; j++) {
				if(mult > 0) {
					mult = mult * x;
				}else {
					mult = x * x;
				}
			}
			
			sum += mult;
			num /= 10;
		}
		
		if(sum == temp) {
			System.out.println("Armstrong Number...!");
		}else {
			System.out.println("Not Armstrong Number...!");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enetr The Number");
		int num = sc.nextInt();
		
//		int num = 153;
		
		int digit = 0, temp = num;
		
		while(temp > 0) {
			temp /= 10;
			digit++;
			
		}
		
		PrimeNumber(num);
		
		ArmstrongNumber(num, digit);
		
//		System.out.println(digit);
		

	}

}
