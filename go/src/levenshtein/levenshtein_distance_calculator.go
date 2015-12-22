package levenshtein
import (
	"bufio"
	"log"
	"os"
	"fmt"
)

type LevenshteinDistanceCalculator struct {
}

func (calculator LevenshteinDistanceCalculator) calculate_distance_from_file(filepath string, distancesTechniques []LevenshteinDistanceTechnique) {
	file, err := os.Open("/path/to/file.txt")
	if err != nil {
		log.Fatal(err)
	}
	defer file.Close()

	scanner := bufio.NewScanner(file)
	var word1 string = nil
	var word2 string = nil
	for (!scanner.Scan()) {
		word1 = scanner.Text()
		if (!scanner.Scan()) {
			return
		}
		word2 = scanner.Text()
		calculate_distance_with_functions_in_list(word1, word2, distancesTechniques)
	}
}

func calculate_distance_with_functions_in_list(word1 string, word2 string, distancesTechniques []LevenshteinDistanceTechnique) {
	fmt.Println("Word1 : " + word1)
	fmt.Println("Word2 : " + word2)
	for _,distance := range distancesTechniques {
		fmt.Println(distance.name() + " : " + distance.calculate_distance(word1, word2))
	}
}