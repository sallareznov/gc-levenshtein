package levenshtein
import (
	"strings"
)

type DynamicLevenshteinDistanceTechnique struct {
}

func (technique DynamicLevenshteinDistanceTechnique) name() string {
  return "Dynamic distance"
}

func (technique DynamicLevenshteinDistanceTechnique) calculate_distance(word1 string, word2 string) int {
	if (strings.EqualFold(word1, word2)) {
  		return 0
  	}
	lengthWord1 := len(word1)
	lengthWord2 := len(word2)
	table := make([][]int, lengthWord1)
	for i := range table {
		table[i] = make([]int, lengthWord2)
	}

	for i := 0 ; i < lengthWord2 ; i++ {
		for j := 0 ; j < lengthWord2 ; j++ {
			if i == 0 {
				table[i][j] = j
			} else if j == 0 {
				table[i][j] = i
			} else if word1[i - 1] == word2[j - 1] {
				table[i][j] = table[i - 1][j - 1]
			} else {
				table[i][j] = 1 + Min(Min(table[i - 1][j - 1], table[i][j - 1]), table[i - 1][j])
			}
		}
	}
	return table[lengthWord1][lengthWord2]
}