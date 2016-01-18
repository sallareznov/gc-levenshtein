require "./LevenshteinDistanceTechnique.rb"

class RecursiveLevenshteinDistanceTechnique
  include LevenshteinDistanceTechnique

  def name()
    print "Recursive distance"
  end

  def calculateDistance(word1, word2)
    lengthWord1 = word1.length
    lengthWord2 = word2.length
    if (word1.eql?(word2))
      return 0
    elsif (lengthWord1 == 0)
      return lengthWord2
    elsif (lengthWord2 == 0)
      return lengthWord1
    else
      firstLetterWord1 = word1[0]
      firstLetterWord2 = word2[0]
      subWord1 = word1[1..-1]
      subWord2 = word2[1..-1]
      if (firstLetterWord1 == firstLetterWord2)
        return calculateDistance(subWord1, subWord2)
      else
        return 1 + [calculateDistance(subWord1, subWord2), calculateDistance(word1, subWord2), calculateDistance(subWord1, word2)].min
      end
    end
  end

end
