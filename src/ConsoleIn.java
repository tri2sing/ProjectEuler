import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class ConsoleIn {

	private BufferedReader rin;

	public ConsoleIn() throws IOException {

		rin = new BufferedReader(new InputStreamReader(System.in));
	}

	public int[][] readMatrix(int M, int N) throws IOException {
		int[][] data = new int[M][N];

		for (int i = 0; i < M; i++) {
			String line = rin.readLine();
			String [] parts = line.split(" ");
			for (int j = 0; j < N; j++) {
				data[i][j] = Integer.parseInt(parts[j]);
			}
		}

		return data;
	}

	public static void main(String[] args) throws IOException {
		ConsoleIn f1 = new ConsoleIn ();
		int [][] matrix = f1.readMatrix(3, 3);
		System.out.println();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j ++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

}
