[![Codacy Badge](https://api.codacy.com/project/badge/grade/315d9a57d7284a9d868d933114ddc8f0)](https://www.codacy.com/app/sallareznov/gc-levenshtein)
[![Code Climate](https://codeclimate.com/github/sallareznov/gc-levenshtein/badges/gpa.svg)](https://codeclimate.com/github/sallareznov/gc-levenshtein)

<p align="center">
  <img alt="EnergyFootprint" src="energy-footprint.jpg">
</p>

# Energy footprint of the Levenshtein distance computing algorithm

### Author
* Salla DIAGNE ([sallareznov](https://github.com/sallareznov))

(You can read the full report with the results by browsing the file [report/report.pdf](https://github.com/sallareznov/gc-levenshtein/blob/master/report/report.pdf)).

### The goal

The goal of this project is to measure and compare energy footprints of multiple languages through programs executing the same task.

### The tool
To get those metrics, the project uses [PowerAPI](http://powerapi.org), a middleware toolkit for building software-defined power meters. Software-defined power meters are configurable software libraries that can estimate the power consumption of software in real-time.

### The algorithm
This algorithm, implemented in multiple languages, reads a dictionary of words in a text file (one word per line), and calculates the Levenshtein distance between all consecutive words. This computation is done in two ways : recursively, and iteratively (using dynamic programming).

Every program takes one argument, which is a file path of a dictionary containing one word per line.
* reads a file containing one word per line
* for every pair of consecutive words, calculates the Levenshtein distance recursively and iteratively.

The design of the program is the following :

<p align="center">
  <img alt="UML" src="uml.png">
</p>

The algorithm follows this flowchart :

<p align="center">
  <img alt="FlowChart" src="flowchart.png">
</p>

### The program

Every implemented program requires one argument, referencing the dictionary of words (one word per line). For example, to use the program implemented in Ocaml with the dictionary file in the repository, you have to execute the following commands :

```
$ cd ocaml
$ make
$ ./levenshtein ../dictionary.txt
```

### The languages
In alphabetical order, the algorithm is implemented in :

1. [ ] [Ada](ada)
2. [x] [C](c)
3. [ ] [C++](cpp)
4. [ ] [Eiffel](eiffel)
5. [x] [Go](go)
6. [ ] [Haskell](haskell)
7. [x] [Java](java)
8. [x] [Ocaml](ocaml)
9. [ ] [Pascal](pascal)
10. [ ] [Perl](perl)
11. [x] [Python](python)
12. [ ] [Ruby](ruby)
13. [x] [Scala](scala)
14. [ ] [Smalltalk](smalltalk)
