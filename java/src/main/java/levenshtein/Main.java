package levenshtein;

public class Main {
	
	public static void usage() {
		System.out.println("Browse the file README.md at the root of the project to know how to use this program");
	}
	
	public static void main(String[] args) {
		if (args.length < 2) {
			usage();
			return;
		}
		final String filepath = args[0];
		final String option = args[1];
		if ("--rec".equals(option)) {
			
			//new RecursiveLevenshteinDistance().calculateDistance(word1, word2);
		}
			
	}

}
