package main

import "os"
import "fmt"
import (
	"levenshtein"
	"container/list"
)

func main() {
	if len(os.Args) < 2 {
		fmt.Println("Browse the file README.md at the root of the project to know how to use this program")
		return
	}
	filepath := os.Args[0]
	recursive_technique := levenshtein.RecursiveLevenshteinDistanceTechnique{}
	dynamic_technique := levenshtein.DynamicLevenshteinDistanceTechnique{}
	var techniques [2]list.List
	techniques[0] = recursive_technique
	techniques[1] = dynamic_technique
	calculator := levenshtein.LevenshteinDistanceCalculator{}
	// TODO method call
}
