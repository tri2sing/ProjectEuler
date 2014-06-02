public class PrimeFactor {

	public static void main(String[] args) {

		
		long largest = -1;

		long input = Long.parseLong(args[0]);
		long target = input;

		// For single digit primes we do a divisor test
		int[] singles = new int[] { 2, 3, 5, 7 };
		for (int i = 0; i < singles.length; i++) {
			int divisor = singles[i];
			if (target % divisor == 0) {
				largest = divisor;
				while (target % divisor == 0)
					target /= divisor;
			}
		}

		// Now we focus on the double digit and larger primes.   
		// The reason for separation is that the method of 
		// generating the primes lead to false positives
		// (i.e. numbers divisible by 5, which we cannot use.
		long checker = 12;
		while (largest < target) {
			// checker - 1 = 11, 17, 23, 29, 35 (ineligible), 41, ...
			if ((checker - 1) % 5 != 0 && (checker - 1) % 7 != 0) {
				if (target % (checker - 1) == 0) {
					largest = checker - 1;
					while (target % (checker - 1) == 0) target /= (checker - 1);
				}
			}
			// checker + 1 = 13, 19, 25 (ineligible), 31, 37, 43, 
			if ((checker + 1) % 5 != 0 && (checker + 1) % 7 != 0) {
				if (target % (checker + 1) == 0) {
					largest = checker + 1;
					while (target % (checker + 1) == 0) target /= (checker + 1);
				}
			}
			checker += 6;
		}
		System.out.println ("The largest prime factor = " + largest);
	}

}
