package levenshtein
import "strings"

type RecursiveLevenshteinDistanceTechnique struct {
}

func (technique RecursiveLevenshteinDistanceTechnique) name() string {
  return "Recursive distance"
}

func (technique RecursiveLevenshteinDistanceTechnique) calculate_distance(word1 string, word2 string) int {
	if strings.EqualFold(word1, word2) {
		return 0
	}
	var lengthWord1 = len(word1)
	var lengthWord2 = len(word2)
	if lengthWord1 == 0 {
		return lengthWord2
	} else if lengthWord2 == 0 {
		return lengthWord1
	}
	else {
		var firstLetterWord1 = word1[0]
		var firstLetterWord2 = word2[0]
		var subWord1 = word1[:1]
		var subLetterWord2 = word2[:1]
		if firstLetterWord1 == firstLetterWord2 {
			return calculate_distance(subWord1, subWord2)
		}
		else {
			return 1 + math.min(math.Min(calculate_distance(word1, subWord2), calculate_distance(subWord1, word2)), calculate_distance(subWord1, subWord2))
		}
	}
}
