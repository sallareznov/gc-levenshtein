package fil.iagl.opl.greencomputing.levenshtein;

import java.io.IOException;

public class Main {
	
	public static void usage() {
		System.out.println("Browse the file README.md at the root of the project to know how to use this program");
	}
	
	public static void main(String[] args) throws IOException {
		if (args.length < 1) {
			usage();
			return;
		}
		final String filepath = args[0];
		final LevenshteinDistanceCalculator calculator = new LevenshteinDistanceCalculator();
		calculator.calculateDistancesFromFile(filepath);
	}

}
