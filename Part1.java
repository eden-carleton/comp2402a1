package comp2402a1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Part1 {

	/**
	 * Your code goes here - see Part0 for an example
	 * @param r the reader to read from
	 * @param w the writer to write to
	 * @throws IOException
	 */
	public static void doIt(BufferedReader r, PrintWriter w) throws IOException {

		// Store lines in a deque for efficient rotation
		Deque<String> lines = new ArrayDeque<>();

		// Read all lines from the reader
		String line;
		while ((line = r.readLine()) != null) {
			lines.add(line);
		}

		int n = lines.size();
		int splitIndex = n / 2;

		// Rotate the deque to put lines 0 to floor(n/2)-1 at the end
		for (int i = 0; i < splitIndex; i++) {
			String lineToMove = lines.removeFirst();
			lines.addLast(lineToMove);
		}

		// Output lines from floor(n/2) to n-1
		for (int i = splitIndex; i < n; i++) {
			w.println(lines.removeFirst());
		}

		// Output lines from 0 to floor(n/2)-1
		for (int i = 0; i < splitIndex; i++) {
			w.println(lines.removeFirst());
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
