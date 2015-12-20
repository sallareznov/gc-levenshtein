package fil.iagl.opl.greencomputing.levenshtein

object Main {

  def usage() : Unit = {
    println("Browse the file README.md at the root of the project to know how to use this program")
  }

  def main(args: Array[String]) : Unit = {
    if (args.length < 1) {
      usage()
      return
    }
    val filepath = args(0)
    val calculator = new LevenshteinDistanceCalculator
    val distanceTechniques = List(new RecursiveLevenshteinDistanceTechnique, new DynamicLevenshteinDistanceTechnique)
    calculator.calculateDistanceFromFile(filepath, distanceTechniques)
    println("DONE!")
  }

}
