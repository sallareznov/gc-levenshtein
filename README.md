# Carbon footprint of the Levenshtein distance algorithm

(You can read the full report with the results by browsing the file [report/report.pdf](https://github.com/sallareznov/gc-levenshtein/blob/master/report/report.pdf)).

### The goal

The goal of this project is to measure and compare carbon footprints of multiple languages through programs executing the same task.

### The tool
To get those metrics, the project uses [PowerAPI](http://powerapi.org), a middleware toolkit for building software-defined power meters. Software-defined power meters are configurable software libraries that can estimate the power consumption of software in real-time.

### The algorithm
This algorithm, implemented in multiple languages, reads a dictionary of words in a text file (one word per line), and calculates the Levenshtein distance between all consecutive words. This computation is done in two ways : recursively, and iteratively (using dynamic programming).

Every program takes one argument, which is a file path of a dictionary containing one word per line.
* reads a file containing one word per line
* for every pair of consecutive words, calculates the Levenshtein distance recursively and iteratively.

The design of the program is the following :

![UML](uml.png)

### The languages
The algorithm is implemented in :
1. Ada
* C
* C++
* COBOL (?)
* CoffeeScript
* Eiffel
* Erlang
* Go
* Haskell
* Java
* Lisp
* Ocaml
* Pascal
* Perl
* Python
* Ruby
* Scala
* Smalltalk
