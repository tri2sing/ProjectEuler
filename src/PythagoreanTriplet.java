/**
 *  Pythagorean triplet is a set of three natural numbers, a < b < c, for which a**2 + b**2 = c**2
 *  For example, 32 + 42 = 9 + 16 = 25 = 52.
 *  There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 *  Find the product abc.
 * @author Sameer Adhikari
 *
 */

import java.util.NoSuchElementException;

public class PythagoreanTriplet {

	// The value of a + b + c
	private int sum;
	private int a;
	private int b;
	private int c;

	/**
	 * @return None
	 * @param sum
	 *            The value to which the Pythagorean triplet should add up to.
	 */
	public PythagoreanTriplet(int sum) {
		this.sum = sum;
		a = -1;
		b = -1;
		c = -1;
	}

	public void findTriplet() {
		for (int i = 0; i < sum - 1; i++) {
			for (int j = i + 1; j < sum; j++) {
				int k = sum - (i + j);
				// System.out.println("i = " + i + " j = " + j + " k = " + k);
				if (k <= j)
					break;
				if ((k * k) == (i * i + j * j)) {
					a = i;
					b = j;
					c = k;
					return;
				}
			}
		}
	}

	/**
	 * @return the value a
	 * @throws NoSuchElementException
	 *             if getA is called before the findTriplet
	 */
	public int getA() {
		if (a == -1)
			throw new NoSuchElementException();
		return a;
	}

	/**
	 * @return the value of b
	 * @throws NoSuchElementException
	 *             if getB is called before the findTriplet
	 */
	public int getB() {
		if (b == -1)
			throw new NoSuchElementException();
		return b;
	}

	/**
	 * @return the value of c
	 * @throws NoSuchElementException
	 *             if getB is called before the findTriplet
	 */
	public int getC() {
		if (c == -1)
			throw new NoSuchElementException();
		return c;
	}

	public static void main(String[] args) {

		PythagoreanTriplet pt = new PythagoreanTriplet(12);
		pt.findTriplet();
		int prod = pt.getA() * pt.getB() * pt.getC();
		System.out.println("Product for sum 12 = " + prod);

		PythagoreanTriplet pt1 = new PythagoreanTriplet(1000);
		pt1.findTriplet();
		prod = pt1.getA() * pt1.getB() * pt1.getC();
		System.out.println("Product for sum 1000 = " + prod);
	}

}
