package test;

import java.util.Arrays;
import java.util.Random;

public class TalebTwitterQ {

	public static void main(String[] args) {
		// Which is more likely for of the following series of coin tosses?? -- NNT on twitter 

		Character[] a = new Character[] { 'H', 'T', 'H', 'T', 'H', 'T', 'H', 'T', 'H', 'T', 'T', 'H', 'T', 'H', 'H',
				'T', 'T', 'T', 'H', 'H' };

		Character[] b = new Character[] { 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H',
				'H', 'H', 'H', 'H', 'H' };

		Character[] c = new Character[] { 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'T', 'T', 'T', 'T', 'T',
				'T', 'T', 'T', 'T', 'T' };

		Random r = new Random();
		int count_a = 0;
		int count_b = 0;
		int count_c = 0;

		for (int i = 0; i < 1000000; i++) {
			Character[] tes = new Character[20];
			for (int j = 0; j < 20; j++) {
				int n = r.nextInt(100) + 1;
				if (n < 50) {
					tes[j] = 'H';
				} else {
					tes[j] = 'T';
				}
			}

			if (Arrays.equals(a, tes)) {
				count_a++;
			} else if (Arrays.equals(b, tes)) {
				count_b++;
			} else if (Arrays.equals(c, tes)) {
				count_c++;
			}
		}

		System.out.printf("the count of various is %n Array A: %d %n Array B: %d %n Array C: %d %n Array none: %d",
				count_a, count_b, count_c, (1000000 - count_a - count_b - count_c));
	}
	
	//The answer is all are equally likely - NNT. Running program multiple times, the program is consistent with the answer.

}
