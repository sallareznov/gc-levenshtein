package levenshtein
import (
	"bufio"
	"log"
	"os"
	"fmt"
	"strconv"
)

type LevenshteinDistanceCalculator struct {
}

func (calculator LevenshteinDistanceCalculator) CalculateDistanceFromFile(filepath string, distancesTechniques []LevenshteinDistanceTechnique) {
	file, err := os.Open(filepath)
	if err != nil {
		log.Fatal(err)
	}
	defer file.Close()
	reader := bufio.NewReader(file)
	scanner := bufio.NewScanner(reader)
	var word1 string = ""
	var word2 string = ""
	//fmt.Println("text : " + scanner.Text())
	for scanner.Scan() {
		word1 = scanner.Text()
		if (!scanner.Scan()) {
			return
		}
		word2 = scanner.Text()
		CalculateDistanceWithFunctionsInList(word1, word2, distancesTechniques)
	}
}

func CalculateDistanceWithFunctionsInList(word1 string, word2 string, distancesTechniques []LevenshteinDistanceTechnique) {
	fmt.Println("Word1 : " + word1)
	fmt.Println("Word2 : " + word2)
	for _,distance := range distancesTechniques {
		fmt.Println(distance.Name() + " : " + strconv.Itoa(distance.CalculateDistance(word1, word2)))
	}
}