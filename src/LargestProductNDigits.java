import java.math.BigInteger;

public class LargestProductNDigits {

	private int [] buffer;
	private int head;
	private int tail;
	
	// The 1000 digit number is stored as a string.
	public LargestProductNDigits (String  num) {
		int len = num.length();
		buffer = new int[len];
		// Store each digit independently
		for (int i = 0; i < len; i++)
			buffer[i] = Integer.valueOf(num.charAt(i));
	}
	
	// Find the largest product of n consecutive digits
	public int largestProductNDigits (int n) {
		int product = 1;

		return product;
	}
	
	public static void main(String[] args) {

	}

}
