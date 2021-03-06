package fil.iagl.opl.greencomputing.levenshtein;

public class RecursiveLevenshteinDistanceTechnique implements LevenshteinDistanceTechnique {

	@Override
    public String name() {
    	return "Recursive distance";
    }

	@Override
	public int calculateDistance(String word1, String word2) {
		if (word1.equals(word2)) {
			return 0;
		}
		final int lengthWord1 = word1.length();
		final int lengthWord2 = word2.length();
		if (lengthWord1 == 0)
			return lengthWord2;
		else if (lengthWord2 == 0)
			return lengthWord1;
		else {
			final char firstLetterWord1 = word1.charAt(0);
			final char firstLetterWord2 = word2.charAt(0);
			final String subWord1 = word1.substring(1);
			final String subWord2 = word2.substring(1);
			if (firstLetterWord1 == firstLetterWord2)
				return calculateDistance(subWord1, subWord2);
			else
				return 1 + Math.min(Math.min(calculateDistance(subWord1, word2), calculateDistance(word1, subWord2)),
						calculateDistance(subWord1, subWord2));
		}
	}

}
