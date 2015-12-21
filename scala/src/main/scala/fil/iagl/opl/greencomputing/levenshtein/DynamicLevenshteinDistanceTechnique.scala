package fil.iagl.opl.greencomputing.levenshtein

class DynamicLevenshteinDistanceTechnique extends LevenshteinDistanceTechnique {

  override def name() : String = "Dynamic distance"

  override def calculateDistance(word1: String, word2: String): Int = {
    val lengthWord1 = word1.length()
    val lengthWord2 = word2.length()
    val table = Array.ofDim[Int](lengthWord1 + 1, lengthWord2 + 1)
    for (i <- 0 to lengthWord1; j <- 0 to lengthWord2) {
      (i, j) match {
        case (0, _) => table(i)(j) = j
        case (_, 0) => table(i)(j) = i
        case _ => {
          if (word1.charAt(i - 1) == word2.charAt(j - 1))
          table(i)(j) = table(i-1)(j-1)
          else
          table(i)(j) = 1 + math.min(math.min(table(i-1)(j-1), table(i)(j-1)), table(i-1)(j))
        }
      }
    }
    table(lengthWord1)(lengthWord2)
  }

}
