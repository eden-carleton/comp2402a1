package comp2402a1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Part7 {
	
	/**
	 * Your code goes here - see Part0 for an example
	 * @param r the reader to read from
	 * @param w the writer to write to
	 * @throws IOException
	 */
	public static void doIt(BufferedReader r, PrintWriter w) throws IOException {
		ArrayList<String> data = new ArrayList<>();
		String line;
		int lower = 0, upper = 0;

		// Read each line from the input until the end
		while ((line = r.readLine()) != null) {
			// Iterate through the lines stored in 'data' ArrayList
			for (int i = 0; i < data.size(); i++) {
				if (line.compareTo(data.get(i)) > 0) {
					upper++;  // Increment count of lines greater than the current line
				} else if (line.compareTo(data.get(i)) < 0) {
					lower++; // Increment count of lines smaller than the current line
				}
				if (lower >= 1000 && upper >= 1000) {
					System.out.println(line);
				}
			}

			// Add the current line to the 'data' ArrayList
			data.add(line);
		}
	}

	/**
	 * The driver.  Open a BufferedReader and a PrintWriter, either from System.in
	 * and System.out or from filenames specified on the command line, then call doIt.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedReader r;
			PrintWriter w;
			if (args.length == 0) {
				r = new BufferedReader(new InputStreamReader(System.in));
				w = new PrintWriter(System.out);
			} else if (args.length == 1) {
				r = new BufferedReader(new FileReader(args[0]));
				w = new PrintWriter(System.out);				
			} else {
				r = new BufferedReader(new FileReader(args[0]));
				w = new PrintWriter(new FileWriter(args[1]));
			}
			long start = System.nanoTime();
			doIt(r, w);
			w.flush();
			long stop = System.nanoTime();
			System.out.println("Execution time: " + 10e-9 * (stop-start));
		} catch (IOException e) {
			System.err.println(e);
			System.exit(-1);
		}
	}
}
