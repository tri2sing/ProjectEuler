/*
 * A palindromic number reads the same both ways. 
The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
Find the largest palindrome made from the product of two 3-digit numbers.
*/

public class PalindromeProduct {

	// The largest product of any two three digit numbers is 999 * 999 = 998001.
	// Hence we only need to generate 6 digit palindromes descending from 997799.
	// We only need to go down to 100001 to at the most.
	
	public static void generatePalindromes () {
		int i, j, k;
		double palindrome;
		
		for (i = 9; i >= 1; i--)
			for (j = 9; j >= 0; j--)
				for (k = 7; k >= 0; k--) {
					palindrome = i * Math.pow(10, 5) + j * Math.pow(10, 4) + k * Math.pow(10, 3) + k * Math.pow(10, 2) + j * 10 + i;
					System.out.println(palindrome);
				}
		
	}
	
	
	// Check if a number is a palindrome without using strings.
	// The alternative is to convert integet to string, reverse it, and compare the two strings.
	
	public static boolean isPalindrome(int x) {
		  if (x < 0) return false;
		  if (x >= 0 && x <= 9) return true;
		  
		  int div = 1;
		  while (x / div >= 10) {
		    div *= 10;
		  }        
		  while (x != 0) {
		    int l = x / div;
		    int r = x % 10;
		    if (l != r) return false;
		    x = (x % div) / 10;
		    div /= 100;
		  }
		  return true;
		}
	
	// Generate products of three digit numbers
	public static int findPalindrome () {
		int i, j, product;
		int currentMax = 0;
		
		for (i = 999; i > 99; i--)
			for (j = i; j > 99; j--) {  // j starts from i, because once we are done with i * j, there is no need to do j * i
				product = i * j;
				if (isPalindrome(product) && product > currentMax) currentMax = product;
			}
		return currentMax;
	}
	
	
	public static void main(String[] args) {
		// PalindromeProduct.generatePalindromes();
		System.out.println(PalindromeProduct.findPalindrome());
	}

}
