package fil.iagl.opl.greencomputing.levenshtein

import java.io.File

import scala.io.{Codec, Source}

class LevenshteinDistanceCalculator {

  def calculateDistanceFromFile(filepath: String, distanceTechniques: List[LevenshteinDistanceTechnique]) : Unit = {
    val source = Source.fromFile(new File(filepath))(Codec("UTF-8"))
    val fileIterator = source.getLines()
    while (fileIterator.hasNext) {
      val word1 = fileIterator.next()
      val word2 = fileIterator.next()
      calculateDistancesWithFunctionsInList(word1, word2, distanceTechniques)
    }
    source.close()
  }

  private def calculateDistancesWithFunctionsInList(word1: String, word2: String, distanceTechniques: List[LevenshteinDistanceTechnique]) : Unit = {
    println("Word1 : " + word1)
    println("Word2 : " + word2)
    distanceTechniques.foreach {
      distance => println(distance.name() + " : " + distance.calculateDistance(word1, word2))
    }
    println()
  }

}
