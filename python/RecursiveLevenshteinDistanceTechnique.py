from LevenshteinDistanceTechnique import LevenshteinDistanceTechnique

class RecursiveLevenshteinDistanceTechnique(LevenshteinDistanceTechnique):

    def name(self):
        return "Recursive distance"

    def calculateDistance(self, word1, word2):
        lengthWord1 = len(word1)
        lengthWord2 = len(word2)
        if (lengthWord1 == 0):
            return lengthWord2
        elif (lengthWord2 == 0):
            return lengthWord1
        else:
            firstLetterWord1 = word1[0]
            firstLetterWord2 = word2[0]
            subWord1 = word1[1:]
            subword2 = word2[1:]
            if (firstLetterWord1 == firstLetterWord2):
                return self.calculateDistance(subWord1, subword2)
            else:
                return 1 + min(min(self.calculateDistance(word1, subword2), self.calculateDistance(subWord1, word2)), self.calculateDistance(subWord1, subword2))
