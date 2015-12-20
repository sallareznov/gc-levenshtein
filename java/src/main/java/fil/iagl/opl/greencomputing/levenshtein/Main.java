package fil.iagl.opl.greencomputing.levenshtein;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void usage() {
		System.out
				.println("Browse the file README.md at the root of the project to know how to use this program");
	}

	public static void main(String[] args) throws IOException {
		if (args.length < 1) {
			usage();
			return;
		}
		final String filepath = args[0];
		final LevenshteinDistanceCalculator calculator = new LevenshteinDistanceCalculator();
		final List<LevenshteinDistanceTechnique> levenshteinDistanceTechniques = Arrays
				.asList(new RecursiveLevenshteinDistanceTechnique(),
						new DynamicLevenshteinDistanceTechnique());
		calculator.calculateDistancesFromFile(filepath, levenshteinDistanceTechniques);
		System.out.println("DONE!");
	}

}
