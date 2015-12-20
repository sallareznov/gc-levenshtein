package fil.iagl.opl.greencomputing.levenshtein;

public interface LevenshteinDistanceTechnique {
	
	String name();
	
	int calculateDistance(String word1, String word2);

}
