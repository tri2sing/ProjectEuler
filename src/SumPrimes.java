/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17. Find the sum of all the
 * primes below two million.
 * 
 * @author Sameer Adhikari
 * 
 */

public class SumPrimes {

	private int limit; // Number below which to find the primes and add them
	private boolean[] isPrime; // isPrime[i] == true if number if prime

	/**
	 * 
	 * @param limit
	 *            is the number below which we have to find the primes
	 */
	public SumPrimes(int limit) {
		this.limit = limit;
		isPrime = new boolean[limit + 1];
		for (int i = 2; i < limit + 1; i++)
			isPrime[i] = true;
		runEratosthenesSieve();
	}

	private void runEratosthenesSieve() {
		double sqrt = Math.sqrt(limit);
		for (int i = 2; i <= Math.ceil(sqrt); i++) {
			if (isPrime[i] == true) {
				for (int j = i * i; j < limit + 1; j += i) {
					isPrime[j] = false;
				}
			}

		}
	}

	public void printPrimes() {
		for (int i = 2; i < limit + 1; i++)
			if (isPrime[i])
				System.out.format("%d ", i);
		System.out.println();
	}

	public long sumPrimes() {
		long sum = 0;
		for (int i = 2; i < limit + 1; i++)
			if (isPrime[i])
				sum += i;
		return sum;
	}

	public static void main(String[] args) {

		SumPrimes sp = new SumPrimes(20);
		sp.printPrimes();
		System.out.println(sp.sumPrimes());

		SumPrimes sp1 = new SumPrimes(2000000);
		System.out.println(sp1.sumPrimes());
	}

}
