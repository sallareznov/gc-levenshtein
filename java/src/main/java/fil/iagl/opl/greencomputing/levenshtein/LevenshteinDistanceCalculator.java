package fil.iagl.opl.greencomputing.levenshtein;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class LevenshteinDistanceCalculator {

	public void calculateDistancesFromFile(String filepath,
			List<LevenshteinDistanceTechnique> distanceTechniques)
			throws IOException {
		final BufferedReader reader = new BufferedReader(new FileReader(
				filepath));
		String word1 = null;
		String word2 = null;
		while ((word1 = reader.readLine()) != null
				&& (word2 = reader.readLine()) != null) {
			calculateDistancesWithFunctionsInList(word1, word2,
					distanceTechniques);
		}
		reader.close();
	}

	private void calculateDistancesWithFunctionsInList(String word1,
			String word2, List<LevenshteinDistanceTechnique> distanceTechniques) {
		System.out.println("Word1 : " + word1);
		System.out.println("Word2 : " + word2);
		distanceTechniques.forEach(distance -> System.out.println(distance
				.name() + " : " + distance.calculateDistance(word1, word2)));
		System.out.println();
	}
}
