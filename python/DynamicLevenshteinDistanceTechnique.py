from LevenshteinDistanceTechnique import LevenshteinDistanceTechnique

class DynamicLevenshteinDistanceTechnique(LevenshteinDistanceTechnique):

    def name(self):
        return "Dynamic distance"

    def calculateDistance(self, word1, word2):
        lengthWord1 = len(word1)
        lengthWord2 = len(word2)
        table = [[0]*(lengthWord2 + 1) for i in range(lengthWord1 + 1)]
        for i in range(0, lengthWord1 + 1):
            for j in range(0, lengthWord2 + 1):
                if (i == 0):
                    table[i][j] = j
                elif (j == 0):
                    table[i][j] = i
                elif (word1[i - 1] == word2[j - 1]):
                    table[i][j] = table[i-1][j-1]
                else:
                    table[i][j] = 1 + min(min(table[i-1][j-1], table[i][j-1]), table[i-1][j])
        return table[lengthWord1][lengthWord2]
