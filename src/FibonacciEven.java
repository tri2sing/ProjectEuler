/***
 * Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be: 
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 * By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
 * @author Sameer Adhikari
 *
 */

public class FibonacciEven {

	public static void main(String[] args) {

		// The biggest Fibonacci number below which we want to sum
		long limit  = Integer.parseInt(args[0]);
		long f0 = 1;	// We don't start with F0=1, and F1=1
		long f1 = 2;
		long sum = 0;
		long temp;
		
		while (f1 < limit) {
			if (f1%2 == 0) sum += f1;
			temp = f1;
			f1 += f0;
			f0 = temp;
		}
		System.out.println("The sum = " + sum);
	}

}
