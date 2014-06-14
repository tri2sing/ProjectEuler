public class GridLargest {

	private int[][] matrix;
	int rows;
	int cols;

	public GridLargest(int[][] matrix) {
		this.matrix = matrix;
		this.rows = matrix.length;
		this.cols = matrix[0].length;
	}

	public int largestHorizontal(int window) {
		int largest = -1;
		int i, j, sum;

		for (i = 0; i < rows; i++) {
			sum = 0;
			for (j = 0; j < window; j++)
				sum += matrix[i][j];
			if (sum > largest)
				largest = sum;
			for (j = window; j < cols; j++) {
				sum += (matrix[i][j] - matrix[i][j - window]);
				if (sum > largest)
					largest = sum;
			}
		}
		return largest;
	}

	public int largestVertical(int window) {
		int largest = -1;
		int i, j, sum;

		for (j = 0; j < cols; j++) {
			sum = 0;
			for (i = 0; i < window; i++)
				sum += matrix[i][j];
			if (sum > largest)
				largest = sum;
			for (i = window; i < rows; i++) {
				sum += (matrix[i][j] - matrix[i - window][j]);
				if (sum > largest)
					largest = sum;
			}
		}
		return largest;
	}

	public int largestDiagonal(int window) {
		int largest = -1;
		int i, j, k;
		// The number of diagonal slices is given by
		int slices = rows + cols - 1;

		// Traverse the diagonal slices starting at the 
		// right top and going towards left bottom (clockwise)
		for (k = -cols + 1; k < rows; k++) {
			System.out.print("Slice " + k + ": ");
			i = (k < 0) ? 0 : k;
			j = (k > 0) ? 0 : -k;
			while (i < rows && j < cols) {
				System.out.print (matrix[i][j] + " ");
				i += 1;
				j += 1;
			}
			System.out.println();
		}

		return largest;
	}

	public int largestDiagonalInverse(int window) {
		int largest = -1;
		int i, j, k;
		int slices = rows + cols - 1;
		
		// Traverse the diagonal inverses starting at the 
		// right bottom and towards left top (counter clockwise)
		
		return largest;
	}
	
	public static void main(String[] args) {
		int [][] data = new int [][] {
				{0, 1, 2, 3},
				{4, 5, 6, 7},
				{8, 9, 10, 11}
		};
		
		GridLargest gl = new GridLargest(data);
		int val = gl.largestDiagonal(4);
	}

}
