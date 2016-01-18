require "./LevenshteinDistanceTechnique.rb"

class DynamicLevenshteinDistanceTechnique
  include LevenshteinDistanceTechnique

  def name()
    print "Dynamic distance"
  end

  def calculateDistance(word1, word2)
    if (word1.eql?(word2))
      return 0
    end
    table = Array.new(word1.length + 1){Array.new(word2.length + 1)}
    for table.each_with_index do |value, i|
      for table[0].each_with_index do |value, j|
        if (i == 0)
          table[i][j] = j
        elsif (j == 0)
          table[i][j] = i
        elsif (word1[i - 1] == word2[j - 1])
          table[i][j] = table[i - 1][j - 1]
        else
          table[i][j] = 1 + [table[i - 1][j - 1], table[i][j - 1], table[i - 1][j]].min
        end
      end
    end
  end

end
