package fil.iagl.opl.greencomputing.levenshtein;

public class DynamicLevenshteinDistanceTechnique implements LevenshteinDistanceTechnique {

  @Override
  public String name() {
    return "Dynamic distance";
  }

  private int[][] buildTable(String word1, String word2) {
    if (word1.equals(word2)) {
      return 0;
    }
    final int lengthWord1 = word1.length();
    final int lengthWord2 = word2.length();
    final int[][] table = new int[lengthWord1 + 1][lengthWord2 + 1];
    for (int i = 0 ; i <= lengthWord1 ; i++) {
      for (int j = 0 ; j <= lengthWord2 ; j++) {
        if (i == 0)
        table[i][j] = j;
        else if (j == 0)
        table[i][j] = i;
        else if (word1.charAt(i - 1) == word2.charAt(j - 1))
        table[i][j] = table[i - 1][j - 1];
        else
        table[i][j] = 1 + Math.min(Math.min(table[i - 1][j],  table[i][j - 1]), table[i - 1][j - 1]);
      }
    }
    return table;
  }

  @Override
  public int calculateDistance(String word1, String word2) {
    final int[][] table = buildTable(word1, word2);
    final int lengthWord1 = word1.length();
    final int lengthWord2 = word2.length();
    return table[lengthWord1][lengthWord2];
  }

}
