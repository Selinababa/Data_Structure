package Josephus01;

import java.util.Scanner;

public class MainOfJ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		JosephusP j = new JosephusP();
		System.out.println("Please input the size of the linklist:");
		int n = sc.nextInt();
		System.out.println("Please input the password:");
		int k = sc.nextInt();
		j.count(n, k);
	}
}
