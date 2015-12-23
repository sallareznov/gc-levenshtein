package levenshtein

import "os"
import "fmt"

func main() {
	if len(os.Args) < 2 {
		fmt.Println("Browse the file README.md at the root of the project to know how to use this program")
		return
	}
	filepath := os.Args[0]
	techniques := make([]LevenshteinDistanceTechnique, 2)
	techniques[0] = RecursiveLevenshteinDistanceTechnique{}
	techniques[1] = DynamicLevenshteinDistanceTechnique{}
	calculator := LevenshteinDistanceCalculator{}
	fmt.Println("Here")
	calculator.calculate_distance_from_file(filepath, techniques)
}
