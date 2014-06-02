
public class NthPrime {

	public static boolean isPrime (int x) {
		double sqrt = Math.sqrt (x);
		for (int i = 2; i <= Math.ceil(sqrt); i++) {
			if (x % i == 0) return false;
		}
		return true;
	}

	public static boolean hasIntSqrt(double x)
	{
		double sqrt = Math.sqrt (x);
		if (sqrt == Math.round(sqrt)) return true;
		else return false;
	}
	
	public static void main(String[] args) {


		int nth  = Integer.parseInt(args[0]);
		if (nth == 1) {
			System.out.println(2);
			return;
		}
		
		int i = 1;
		int target = 3;  // Assume nth > 1
		
		while (i < nth) {
			if (isPrime(target)) ++i;
			if (i == nth) break;
			else target += 2;  // Check only odd numbers
		}
		System.out.println(target);
	}
}
