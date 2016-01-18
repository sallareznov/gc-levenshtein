module Main where

import System.IO

recursiveDistance::[Char] -> [Char] -> Int
recursiveDistance "" s2 = length s2
recursiveDistance s1 "" = length s1
recursiveDistance s1 s2
   | last s1 == last s2 = recursiveDistance (tail s1) (tail s2)
   | otherwise = 1 + minimum [ recursiveDistance (tail s1) s2, recursiveDistance s1 (tail s2), recursiveDistance (tail s1) (tail s2)]


main = do
    handle <- openFile "../dictionary_EN.txt" ReadMode
    contents <- hGetContents handle
    putStr contents
    hClose handle

