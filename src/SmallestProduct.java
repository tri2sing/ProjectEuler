/***
 *  2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 *  What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 *  * @author Sameer Adhikari
 * 
 */

public class SmallestProduct {

	// Assume at least one is non zero and use Euclid's algorithm
	public static long GCD (long a, long b) {
		if (a == 0) return b;
		if (b == 0) return a;
		
		while (a != b) {
			if (a > b) a = a - b;
			else b = b - a;
		}
		return a;
	}
	
	public static void main(String[] args) {

		// Assume N is at least 2
		int range  = Integer.parseInt(args[0]);
		long LCM = 1;
		long product = 1;
		
		for (int i = 2; i < range + 1; i++) {
			product = LCM * i;
			LCM = product / SmallestProduct.GCD (i, LCM);
		}
		System.out.println (LCM);
	}

}
