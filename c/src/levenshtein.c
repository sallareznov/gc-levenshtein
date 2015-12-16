#include "../include/levenshtein.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int recursive_distance(char *word1, int length_word1, char *word2, int length_word2) {
  if (length_word1 == 0)
    return length_word2;
  else if (length_word2 == 0)
    return length_word1;
  else {
    char first_letter_word1, first_letter_word2;
    char subword1[length_word1 - 1], subword2[length_word2 - 1];
    first_letter_word1 = word1[0];
    first_letter_word2 = word2[0];
    strncpy(subword1, word1 + 1, length_word1 - 1);
    strncpy(subword2, word2 + 1, length_word2 - 1);
    if (first_letter_word1 == first_letter_word2)
      return recursive_distance(subword1, length_word1 - 1, subword2, length_word2 - 1);
    else {
      return MAX ((MAX (recursive_distance(subword1, length_word1 - 1, word2, length_word2), recursive_distance(word1, length_word1, subword2, length_word2 - 1))), (recursive_distance(subword1, length_word1 - 1, subword2, length_word2 - 1)));
    }
  }
}

char **build_table(char *word1, char *word2) {
  return NULL;
}

int dynamic_distance(char *word1, int length_word1, char *word2, int length_word2) {
  return 0;
}

void get_word(FILE *fd, char *word, int *index) {
  char c;

  *index = 0;
  while ((c = fgetc(fd)) != '\n') {
    printf("%c\n", c);
    word[*index++] = c;
  }
}

void calculate_distance_from_file(char *filepath) {
  FILE *fd;
  char *word1, *word2;
  int length_word1, length_word2;

  fd = fopen(filepath, "r");
  word1 = malloc(sizeof(char *));
  word2 = malloc(sizeof(char *));
  get_word(fd, word1, &length_word1);
  get_word(fd, word2, &length_word2);
  printf("Word1 : %s\n", word1);
  printf("Word2 : %s\n", word2);
  printf("Recursive distance : %d\n", recursive_distance(word1, length_word1, word2, length_word2));
  recursive_distance(word1, length_word1, word2, length_word2);
  printf("\n");
}

void usage() {
  printf("Browse the file README.md at the root of the project to know how to use this program\n");
}

int main(int argc, char *argv[]) {
  char *filepath;

  if (argc < 2) {
    usage();
    return 1;
  }
  filepath = argv[1];
  calculate_distance_from_file(filepath);
  printf("DONE\n");
  return 0;
}
