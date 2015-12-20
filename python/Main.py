import sys
from LevenshteinDistanceCalculator import LevenshteinDistanceCalculator
from RecursiveLevenshteinDistanceTechnique import RecursiveLevenshteinDistanceTechnique
from DynamicLevenshteinDistanceTechnique import DynamicLevenshteinDistanceTechnique

if __name__ == "__main__":
    if (len(sys.argv) < 2):
        print("Browse the file README.md at the root of the project to know how to use this program\n")
    else:
        filepath = sys.argv[1]
        calculator = LevenshteinDistanceCalculator()
        recursiveTechnique = RecursiveLevenshteinDistanceTechnique()
        dynamicTechnique = DynamicLevenshteinDistanceTechnique()
        distanceTechniques = [recursiveTechnique, dynamicTechnique]
        calculator.calculateDistanceFromFile(filepath, distanceTechniques)
