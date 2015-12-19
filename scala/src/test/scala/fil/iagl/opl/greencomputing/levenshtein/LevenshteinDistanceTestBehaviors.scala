package fil.iagl.opl.greencomputing.levenshtein

import org.scalatest._

trait LevenshteinDistanceTestBehaviors {

  this: FlatSpec =>

  def sameDistanceForAllTechniques(levenshteinDistance: LevenshteinDistance, word1: String, word2: String, expectedDistance: Int) = {
    levenshteinDistance.name() + " between " + word1 + " and " + word2 + " " should " be " + expectedDistance in {
      val actualDistance = levenshteinDistance.calculateDistance(word1, word2)
      assert(actualDistance == expectedDistance)
    }
  }

}
