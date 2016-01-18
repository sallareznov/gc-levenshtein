require "./LevenshteinDistanceCalculator.rb"

class LevenshteinDistanceCalculator

  def calculateDistanceFromFile(filepath, techniques)
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
    end
  end

end
