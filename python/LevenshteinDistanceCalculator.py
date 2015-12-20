import sys
from RecursiveLevenshteinDistanceTechnique import RecursiveLevenshteinDistanceTechnique
from DynamicLevenshteinDistanceTechnique import DynamicLevenshteinDistanceTechnique

class LevenshteinDistanceCalculator:

    def calculateDistancesWithFunctionsInList(self, word1, word2, distanceTechniques):
        sys.stdout.write("Word1 : " + word1)
        sys.stdout.write("Word2 : " + word2)
        for distanceTechnique in distanceTechniques:
            sys.stdout.write(distanceTechnique.name() + " : " + str(distanceTechnique.calculateDistance(word1, word2)))
            sys.stdout.write("\n")
        sys.stdout.write("\n")

    def calculateDistanceFromFile(self, filepath, distanceTechniques):
        reader = open(filepath)
        word1 = None
        word2 = None
        while True:
            word1 = reader.readline()
            word2 = reader.readline()
            if not word2:
                return
            else:
                self.calculateDistancesWithFunctionsInList(word1, word2, distanceTechniques)
