package levenshtein
import "strings"


type RecursiveLevenshteinDistanceTechnique struct {
}

func (technique RecursiveLevenshteinDistanceTechnique) Name() string {
  return "Recursive distance"
}

func (technique RecursiveLevenshteinDistanceTechnique) CalculateDistance(word1 string, word2 string) int {
		if (strings.EqualFold(word1, word2)) {
			return 0
		}
		lengthWord1 := len(word1)
		lengthWord2 := len(word2)
		if lengthWord1 == 0 {
			return lengthWord2
		} else if lengthWord2 == 0 {
			return lengthWord1
		} else {
			firstLetterWord1 := word1[0]
			firstLetterWord2 := word2[0]
			subWord1 := word1[1:]
			subWord2 := word2[1:]
			if firstLetterWord1 == firstLetterWord2 {
				return RecursiveLevenshteinDistanceTechnique.CalculateDistance(technique, subWord1, subWord2)
			} else {
				return 1 + Min(Min(RecursiveLevenshteinDistanceTechnique.CalculateDistance(technique, word1, subWord2), RecursiveLevenshteinDistanceTechnique.CalculateDistance(technique, subWord1, word2)), RecursiveLevenshteinDistanceTechnique.CalculateDistance(technique, subWord1, subWord2))
			}
		}
}