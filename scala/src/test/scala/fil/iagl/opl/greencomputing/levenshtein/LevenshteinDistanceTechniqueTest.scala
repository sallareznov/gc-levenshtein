package fil.iagl.opl.greencomputing.levenshtein

import org.scalatest._

class LevenshteinDistanceTechniqueTest extends FlatSpec with LevenshteinDistanceTechniqueTestBehaviors {

    val distanceTechniques = Array(new RecursiveLevenshteinDistanceTechnique, new DynamicLevenshteinDistanceTechnique)

    distanceTechniques.foreach(distanceTechnique => {
      distanceTechnique.name() should behave like sameDistanceForAllTechniques(distanceTechnique, "something", "something", 0)
      distanceTechnique.name() should behave like sameDistanceForAllTechniques(distanceTechnique, "this", "has", 2)
      distanceTechnique.name() should behave like sameDistanceForAllTechniques(distanceTechnique, "book", "back", 2)
      distanceTechnique.name() should behave like sameDistanceForAllTechniques(distanceTechnique, "kitten", "sitting", 3)
      distanceTechnique.name() should behave like sameDistanceForAllTechniques(distanceTechnique, "meilenstein", "levenshtein", 4)
      distanceTechnique.name() should behave like sameDistanceForAllTechniques(distanceTechnique, "something", "", 9)
      distanceTechnique.name() should behave like sameDistanceForAllTechniques(distanceTechnique, "", "something", 9)
    })
}
