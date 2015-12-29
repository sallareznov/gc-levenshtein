package levenshtein

type LevenshteinDistanceTechnique interface {
	Name() string
	CalculateDistance(word1 string, word2 string) int
}

func Min(x, y int) int {
	if x < y {
		return x
	}
	return y
}