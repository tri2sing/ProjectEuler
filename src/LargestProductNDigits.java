
public class LargestProductNDigits {

	private int [] buffer;
	private int len;
	
	// The 1000 digit number is stored as a string.
	public LargestProductNDigits (String  num) {
		len = num.length();
		buffer = new int[len];
		// Store each digit independently
		for (int i = 0; i < len; i++) {
			buffer[i] = Character.getNumericValue(num.charAt(i));
		}
	}
	
	public void printNumber () {
		for (int i = 0; i < len; i++) {
			System.out.print (buffer[i]);
		}
		System.out.println();
	}
	

	// Check for presence of a zero from start to start+N-1
	// Returns the position of the zero if present, else -1
	private int isZeroInNextN (int start, int N) {
		
		for(int i = start; i < start + N; i++) {
			if(buffer[i] == 0) return i;
		}
		
		return -1;
	}
	
	// Multiplies all numbers from start to end-1
	private int multiplyConsecutive (int start, int end) {
		int prod = 1;
		
		for (int i = start; i < end; i++) {
			prod *= buffer[i];
		}
		return prod;
	}
	
	// Find the largest product of n consecutive digits
	public int largestProductNDigits (int N) {
		int current = 1, largest = 1;
		int count = 1;
		
		// Find the first consecutive non-zero N numbers
		int start = 0;
		int zeroAt = isZeroInNextN(start, N);
		while (zeroAt != -1){
			start = zeroAt + N;
			zeroAt = isZeroInNextN(start, N);
		}
		current = multiplyConsecutive(start, start + N);
		largest = current;
		
		// Now we can incrementally work through the array
		for(int k = start, i = start + N; i < len; i++) {
			if(buffer[i] != 0) {
				
			}
			
		}
		
		return largest;
	}
	
	public static void main(String[] args) {

		String num = "18023783282389239230909230923092392392309";
		LargestProductNDigits lpnd = new LargestProductNDigits(num);
		lpnd.printNumber();
		
		
	}

}
