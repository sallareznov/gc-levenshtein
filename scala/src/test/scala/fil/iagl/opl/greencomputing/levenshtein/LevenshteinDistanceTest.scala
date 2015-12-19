package fil.iagl.opl.greencomputing.levenshtein

import org.scalatest._

class LevenshteinDistanceTest extends FlatSpec with LevenshteinDistanceTestBehaviors {

    val distances = Array(new RecursiveLevenshteinDistance, new DynamicLevenshteinDistance)
    val recursiveLevenshteinDistance = new RecursiveLevenshteinDistance
    val dynamicLevenshteinDistance = new DynamicLevenshteinDistance

     // recursiveLevenshteinDistance.name() should behave like sameDistanceForAllTechniques(recursiveLevenshteinDistance, "book", "back", 2)
    //  dynamicLevenshteinDistance.name() should behave like sameDistanceForAllTechniques(dynamicLevenshteinDistance, "kitten", "sitting", 3)

    distances.foreach(distance => {
      distance.name() should behave like sameDistanceForAllTechniques(distance, "book", "back", 2)
      distance.name() should behave like sameDistanceForAllTechniques(distance, "kitten", "sitting", 3)
    })
}