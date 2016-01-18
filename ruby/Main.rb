#!/usr/bin/ruby

require "./RecursiveLevenshteinDistanceTechnique.rb"
require "./DynamicLevenshteinDistanceTechnique.rb"

if __FILE__ == $PROGRAM_NAME
  if (ARGV.length < 1)
    puts "Browse the file README.md at the root of the project to know how to use this program"
    exit 1
  end
  filepath = ARGV[0]
  techniques = Array[RecursiveLevenshteinDistanceTechnique.new]
  lines = IO.readlines(filepath)
  for index in 0..(lines.length - 1)
    word1 = lines[index]
    word2 = lines[index + 1]
    puts "Word1 : #{word1}"
    puts "Word2 : #{word2}"
    for technique in techniques
      techniqueName = technique.name()
      distance = technique.calculateDistance(word1, word2)
      puts "#{techniqueName} : #{distance}"
    end
    puts ""
  end
#  calculator = LevenshteinDistanceCalculator. new
#  calculator.calculateDistanceFromFile(filepath, techniques)
  exit 0
end
