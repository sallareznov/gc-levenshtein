package fil.iagl.opl.greencomputing.levenshtein

trait LevenshteinDistanceTechnique {

  def name() : String

  def calculateDistance(word1: String, word2: String) : Int

}
