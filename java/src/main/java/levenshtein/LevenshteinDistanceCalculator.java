package levenshtein;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LevenshteinDistanceCalculator {

	public void calculateDistancesFromFile(String filepath, LevenshteinDistance levenshteinDistance) throws IOException {
		final BufferedReader reader = new BufferedReader(new FileReader(filepath));
		String word1 = null;
		String word2 = null;
		while ((word1 = reader.readLine()) != null && (word2 = reader.readLine()) != null) {
			levenshteinDistance.calculateDistance(word1, word2);
		}
		reader.close();
	}

}
