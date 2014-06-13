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
			for (j = 0; j < window; j++) sum += matrix[i][j];
			if (sum > largest) largest = sum;
			for (j = window; j < cols; j++) {
				sum += (matrix[i][j] - matrix[i][j - window]);
				if (sum > largest) largest = sum;
			}
		}
		return largest;
	}

	public int largestVertical(int window) {
		int largest = -1;
		int i, j, sum;
		
		for (j = 0; j < cols; j++) {
			sum = 0;
			for (i = 0; i < window; i++) sum += matrix[i][j];
			if (sum > largest) largest = sum;
			for (i = window; i < rows; i++) {
				sum += (matrix[i][j] - matrix[i - window][j]);
				if (sum > largest) largest = sum;
			}
		}
		return largest;
	}
	
	public int largestDiagonal(int window) {
		int largest = -1;
		int i, j, k;
		// The number of diagonal slices is given by
		int slices = rows * cols - 1;
		
		// Slice determines the starting point of the diagonal
		for (k = 0; k < slices; k++){
			
		}
		
		
		return largest;
	}
	
	public static void main(String[] args) {

	}

}
