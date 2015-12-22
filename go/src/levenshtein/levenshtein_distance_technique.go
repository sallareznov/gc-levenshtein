package levenshtein

type LevenshteinDistanceTechnique interface {
	name() string
	calculate_distance(word1 string, word2 string) int
}
