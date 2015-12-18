package fil.iagl.opl.greencomputing.levenshtein

trait LevenshteinDistance {

  def name() : String

  def calculateDistance(word1: String, word2: String) : Int

}
