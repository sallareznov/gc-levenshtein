package levenshtein_test
import (
	"testing"
	"levenshtein"
)

var levenshteinDistances = []struct {
	word1            string
	word2            string
	expectedDistance int
}{
	{"something", "something", 0},
	{"this", "has", 2},
	{"book", "back", 2},
	{"sitting", "kitten", 3},
	{"meilenstein", "levenshtein", 4},
	{"something", "", 9},
	{"", "something", 9},
}

func TestCalculateDistance(t *testing.T) {
	var techniques [2]levenshtein.LevenshteinDistanceTechnique
	techniques[0] = levenshtein.RecursiveLevenshteinDistanceTechnique{}
	techniques[1] = levenshtein.DynamicLevenshteinDistanceTechnique{}
	for _, technique := range techniques {
		for index, distanceSet := range levenshteinDistances {
			actualDistance := technique.CalculateDistance(distanceSet.word1, distanceSet.word2)
			if actualDistance != distanceSet.expectedDistance {
				t.Fatalf("at index %d, expected %d, got %d.", index, distanceSet.expectedDistance, actualDistance)
			}
		}
	}
}