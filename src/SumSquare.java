/***
 * The sum of the squares of the first ten natural numbers is 385
 * The square of the sum of the first ten natural numbers is 2640
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 - 385 = 2640.
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 * 
 * @author Sameer Adhikari
 *
 */
public class SumSquare {

	public static void main(String[] args) {
		int N  = Integer.parseInt(args[0]);
		/* Sum of squares of first n integers = n(n+1)(2n+1)/6
		 * Sum of first n integers = n(n+1)/2
		 * Using these formulae we can come up with the formula
		 * We use long for the result to prevent overflow in multiplication
		 */
		long diff = N * (N - 1) * (N + 1) * (3 * N + 2) / 12;
		System.out.println (diff);

	}

}
