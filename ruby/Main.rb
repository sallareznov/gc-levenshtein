#!/usr/bin/ruby

require "./RecursiveLevenshteinDistanceTechnique.rb"
require "./DynamicLevenshteinDistanceTechnique.rb"

if __FILE__ == $PROGRAM_NAME
  puts "Hello world"
  if (ARGV.length < 1)
    puts "Browse the file README.md at the root of the project to know how to use this program"
    exit 1
  end
  filepath = ARGV[0]
  techniques = Array[RecursiveLevenshteinDistanceTechnique.new, DynamicLevenshteinDistanceTechnique.new]
  calculator = LevenshteinDistanceCalculator.new
  dynamicTechnique = DynamicLevenshteinDistanceTechnique.new
  dynamicTechnique.calculateDistance("carie", "durite")

#  calculator.calculateDistanceFromFile(filepath, techniques)
  exit 0
end
