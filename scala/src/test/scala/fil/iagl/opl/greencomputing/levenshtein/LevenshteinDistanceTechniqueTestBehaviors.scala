package fil.iagl.opl.greencomputing.levenshtein

import org.scalatest._

trait LevenshteinDistanceTechniqueTestBehaviors {

  this: FlatSpec =>

  def sameDistanceForAllTechniques(distanceTechnique: LevenshteinDistanceTechnique, word1: String, word2: String, expectedDistance: Int) = {
    distanceTechnique.name() + " between " + word1 + " and " + word2 + " " should " be " + expectedDistance in {
      val actualDistance = distanceTechnique.calculateDistance(word1, word2)
      assert(actualDistance == expectedDistance)
    }
  }

}
