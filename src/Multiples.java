public class Multiples {

	public static void main(String[] args) {

		int N  = Integer.parseInt(args[0]);
		int next3 = 3;
		int next5 = 5;
		int sum = 0;
		while (next3 < N) {
			if (next3 == next5) {
				sum += next3;
				next3 += 3;
				next5 += 5;
			} else if (next3 < next5) {
				sum += next3;
				next3 += 3;
			}
			else {
				sum += next5;
				next5 += 5;
			}
		}
		System.out.println("The sum = " + sum);
	}

}
