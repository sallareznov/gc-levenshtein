package fil.iagl.opl.greencomputing.levenshtein

class RecursiveLevenshteinDistanceTechnique extends LevenshteinDistanceTechnique {

  override def name(): String = return "Recursive distance"

  override def calculateDistance(word1: String, word2: String): Int = {
    val lengthWord1 = word1.length()
    val lengthWord2 = word2.length()
    (lengthWord1, lengthWord2) match {
      case (0, _) => lengthWord2
      case (_, 0) => lengthWord1
      case _ => {
        val firstLetterWord1 = word1.charAt(0)
        val firstLetterWord2 = word2.charAt(0)
        val subWord1 = word1.substring(1)
        val subWord2 = word2.substring(1)
        if (firstLetterWord1 == firstLetterWord2) calculateDistance(subWord1, subWord2) else
          1 + math.min(math.min(calculateDistance(word1, subWord2), calculateDistance(subWord1, word2)), calculateDistance(subWord1, subWord2))
      }
    }
  }

}
