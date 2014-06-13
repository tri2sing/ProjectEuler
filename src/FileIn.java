import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class FileIn {

	private BufferedReader rin;

	public FileIn(String fileName) throws IOException {

		rin = new BufferedReader(new FileReader(fileName));
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
		String fname = "C:\\Users\\sadhikar\\Documents\\workspacejava\\ProjectEuler\\input\\ProductInGrid.txt";
		FileIn f1 = new FileIn (fname);
		f1.readMatrix(20, 20);
	}

}
