import unittest
from RecursiveLevenshteinDistanceTechnique import RecursiveLevenshteinDistanceTechnique
from DynamicLevenshteinDistanceTechnique import DynamicLevenshteinDistanceTechnique

class LevenshteinDistanceTechniqueTest(unittest.TestCase):

    def __init__(self, word1, word2, expectedDistance):
        unittest.TestCase.__init__(self, methodName='testSameDistanceForAllTechniques')
        self.word1 = word1
        self.word2 = word2
        self.expectedDistance = expectedDistance

    def testSameDistanceForAllTechniques(self):
        distanceTechniques = [RecursiveLevenshteinDistanceTechnique(), DynamicLevenshteinDistanceTechnique()]
        for distanceTechnique in distanceTechniques:
            self.assertEqual(distanceTechnique.calculateDistance(self.word1, self.word2), self.expectedDistance)

    def shortDescription(self):
        # We need to distinguish between instances of this test case.
        return "LevenshteinDistanceTechniqueTest for " + self.word1 + " and " + self.word2


def getTestDataSuite():
    wordsAndDistances = [ ["something", "something", 0], ["this", "has", 2], ["book", "back", 2], ["kitten", "sitting", 3], ["meilenstein", "levenshtein", 4], ["something", "", 9], ["", "something", 9] ]
    return unittest.TestSuite([LevenshteinDistanceTechniqueTest(wordsAndDistance[0], wordsAndDistance[1], wordsAndDistance[2]) for wordsAndDistance in wordsAndDistances])

if __name__ == '__main__':
    testRunner = unittest.TextTestRunner()
    testRunner.run(getTestDataSuite())
