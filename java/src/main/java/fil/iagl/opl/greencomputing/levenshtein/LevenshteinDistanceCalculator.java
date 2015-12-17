package fil.iagl.opl.greencomputing.levenshtein;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LevenshteinDistanceCalculator {

	public void calculateDistancesFromFile(String filepath) throws IOException {
		final BufferedReader reader = new BufferedReader(new FileReader(
				filepath));
		String word1 = null;
		String word2 = null;
		final LevenshteinDistance recursiveLevenshteinDistance = new RecursiveLevenshteinDistance();
		final LevenshteinDistance dynamicLevenshteinDistance = new DynamicLevenshteinDistance();
		while ((word1 = reader.readLine()) != null
				&& (word2 = reader.readLine()) != null) {
			System.out.println("Word1 : " + word1);
			System.out.println("Word2 : " + word2);
			final int recursiveLevenshteinDistanceResult = recursiveLevenshteinDistance
					.calculateDistance(word1, word2);
			System.out.println("Recursive distance : "
					+ recursiveLevenshteinDistanceResult);
			final int dynamicLevenshteinDistanceResult = dynamicLevenshteinDistance
					.calculateDistance(word1, word2);
			System.out.println("Dynamic distance : "
					+ dynamicLevenshteinDistanceResult);
			System.out.println();
		}
		reader.close();
	}

}
