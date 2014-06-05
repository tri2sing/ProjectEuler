
public class LargestProductNDigits {

	private int [] buffer;
	private int len;
	
	private int sBrute;  // Store location of start of largest product
	private int eBrute;	// Store location of start of smallest product
	
	private int sEff;
	private int eEff;
	
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
	private long multiplyConsecutive (int start, int end) {
		long prod = 1;
		
		for (int i = start; i < end; i++) {
			prod *= buffer[i];
		}
		return prod;
	}
	
	// Find the largest product of N consecutive digits using brute force.
	// Goes through the digits in a sliding window of length N and multiplies.
	// This leads to repeated multiplication of overlapping numbers among
	// consecutive windows.
	
	public long findLargestProductBrute (int N) {
		long current = 1, largest = 1;
		
		for (int i = 0; i < len - N + 1; i++) {
			current = multiplyConsecutive(i,  i + N);
			if (current > largest) {
				largest = current;
				sBrute = i;
				eBrute = i + N - 1;
			}
		}
		return largest;
	}

	// Find the largest product of N consecutive digits in an efficient manner.
	// The basic idea is that the product of 1 to N overlaps with 2 to N+1 for N-1 terms.
	public long findLargestProductEfficent (int N) {
		long current = 1, largest = 1;
		
		// Find the first consecutive non-zero N numbers
		int start = 0;
		int zeroAt = isZeroInNextN(start, N);
		while (zeroAt != -1){
			start = zeroAt + 1;
			zeroAt = isZeroInNextN(start, N);
		}
		current = multiplyConsecutive(start, start + N);
		largest = current;
		
		// Now we can incrementally work through the array
		int k = start, i = start + N;
		while (i < len) {
			// if next digit is non zero we update the product
			// using a sliding window.
			if(buffer[i] != 0) {
				// Multiply by the next digit and then
				// divide by the  digit that is to fall off
				current = (current * buffer[i]) / buffer[k];
				i++;
				k++;
			}
			else {  // if the next digit is zero then
				// find the next sequence of non-zeroes
				start = i + 1;
				if (start + N >= len) break;
				zeroAt = isZeroInNextN(start, N);
				while (zeroAt != -1){
					start = zeroAt + 1;
					if (start + N >= len) break;
					zeroAt = isZeroInNextN(start, N);
				}
				if (start + N >= len) break;
				current = multiplyConsecutive(start, start + N);
				k = start;
				i = start + N;				
			}

			if(current > largest){
				sEff = k;
				eEff = i - 1;
				largest = current;
			}
		}
		
		return largest;
	}
	
	void printIndicesBrute() {
		System.out.println("Start = " + sBrute + " End = " + eBrute);
	}

	void printIndicesEff() {
		System.out.println("Start = " + sEff + " End = " + eEff);
	}

	public static void main(String[] args) {

		String num = "78023783282389";
		String num1 = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
		LargestProductNDigits lpnd = new LargestProductNDigits(num);
		LargestProductNDigits lpnd1 = new LargestProductNDigits(num1);
		
		System.out.println("\nFor a 14 digit number");
		lpnd.printNumber();
		System.out.println("Largest product 1 digit eff = " + lpnd.findLargestProductEfficent(1));
		lpnd.printIndicesEff();
		System.out.println("Largest product 1 digit brute = " + lpnd.findLargestProductBrute(1));
		lpnd.printIndicesBrute();
		System.out.println("Largest product 2 digit eff = " + lpnd.findLargestProductEfficent(2));
		lpnd.printIndicesEff();
		System.out.println("Largest product 2 digit brute = " + lpnd.findLargestProductBrute(2));
		lpnd.printIndicesBrute();
		System.out.println("Largest product 3 digit eff = " + lpnd.findLargestProductEfficent(3));
		lpnd.printIndicesEff();
		System.out.println("Largest product 3 digit brute = " + lpnd.findLargestProductBrute(3));
		lpnd.printIndicesBrute();
	
		System.out.println("\nFor a 1000 digit number");
		lpnd1.printNumber();
		System.out.println("Largest product 1 digit eff = " + lpnd1.findLargestProductEfficent(1));
		lpnd1.printIndicesEff();
		System.out.println("Largest product 1 digit brute = " + lpnd1.findLargestProductBrute(1));
		lpnd1.printIndicesBrute();
		System.out.println("Largest product 4 digit eff = " + lpnd1.findLargestProductEfficent(4));
		lpnd1.printIndicesEff();
		System.out.println("Largest product 4 digit brute = " + lpnd1.findLargestProductBrute(4));
		lpnd1.printIndicesBrute();
		System.out.println("Largest product 13 digit eff = " + lpnd1.findLargestProductEfficent(13));
		lpnd1.printIndicesEff();
		System.out.println("Largest product 13 digit brute = " + lpnd1.findLargestProductBrute(13));
		lpnd1.printIndicesBrute();
		
		
	}

}
