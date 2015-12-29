package fil.iagl.opl.greencomputing.levenshtein;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LevenshteinDistanceTechniqueTest {

	private String word1;
	private String word2;
	private int expectedDistance;

	public LevenshteinDistanceTechniqueTest(String word1, String word2,
			int expectedDistance) {
		this.word1 = word1;
		this.word2 = word2;
		this.expectedDistance = expectedDistance;
	}

	@Parameters
	public static Collection<Object[]> data() {
		final Object[][] data = {
			{ "something", "something", 0 },
			{ "this", "has", 2 },
			{ "book", "back", 2 },
			{ "kitten", "sitting", 3 },
			{ "meilenstein", "levenshtein", 4 },
			{ "something", "", 9 },
			{ "", "something", 9 }
		};
		return Arrays.asList(data);
	}

	@Test
	public void test() {
		final List<LevenshteinDistanceTechnique> distanceTechniques = Arrays.asList(new RecursiveLevenshteinDistanceTechnique(), new DynamicLevenshteinDistanceTechnique());
		distanceTechniques.forEach(technique -> Assert.assertEquals(expectedDistance, technique.calculateDistance(word1, word2)));
	}

}
