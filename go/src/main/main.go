package main

import "os"
import (
	"fmt"
	"levenshtein"
)

func main() {
	if len(os.Args) < 2 {
		fmt.Println("Browse the file README.md at the root of the project to know how to use this program")
		return
	}
	filepath := os.Args[1]
	techniques := make([]levenshtein.LevenshteinDistanceTechnique, 2)
	recursiveDistance := levenshtein.RecursiveLevenshteinDistanceTechnique{}
	dynamicDistance := levenshtein.DynamicLevenshteinDistanceTechnique{}
	//fmt.Println(levenshtein.RecursiveLevenshteinDistanceTechnique{}.CalculateDistance("carie", "durite"))
	//fmt.Println(levenshtein.DynamicLevenshteinDistanceTechnique{}.CalculateDistance("carie", "durite"))
	techniques[0] = recursiveDistance
	techniques[1] = dynamicDistance
	calculator := levenshtein.LevenshteinDistanceCalculator{}
	calculator.CalculateDistanceFromFile(filepath, techniques)
	fmt.Println("DONE !")
}
