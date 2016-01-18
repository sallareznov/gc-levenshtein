#include "../include/levenshtein.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int recursive_distance(char *word1, int length_word1, char *word2, int length_word2) {
  if (strcmp(word1, word2) == 0)
    return 0;
  if (length_word1 == 0)
    return length_word2;
  else if (length_word2 == 0)
    return length_word1;
  else {
    char first_letter_word1, first_letter_word2;
    char subword1[length_word1], subword2[length_word2];
    first_letter_word1 = word1[0];
    first_letter_word2 = word2[0];
    memcpy(subword1, &word1[1], length_word1 - 1);
    memcpy(subword2, &word2[1], length_word2 - 1);
    subword1[length_word1 - 1] = '\0';
    subword1[length_word2 - 1] = '\0';
    if (first_letter_word1 == first_letter_word2)
      return recursive_distance(subword1, length_word1 - 1, subword2, length_word2 - 1);
    else {
      return 1 + MIN ((MIN (recursive_distance(subword1, length_word1 - 1, word2, length_word2), recursive_distance(word1, length_word1, subword2, length_word2 - 1))), (recursive_distance(subword1, length_word1 - 1, subword2, length_word2 - 1)));
    }
  }
}

int dynamic_distance(char *word1, int length_word1, char *word2, int length_word2) {
  int table[length_word1 + 1][length_word2 + 1], i, j;

  for (i = 0 ; i <= length_word1 ; i++) {
    for (j = 0 ; j <= length_word2 ; j++) {
      if (i == 0)
        table[i][j] = j;
      else if (j == 0)
        table[i][j] = i;
      else {
        if (word1[i - 1] == word2[j - 1])
          table[i][j] = table[i - 1][j - 1];
        else
          table[i][j] = 1 + MIN(MIN(table[i - 1][j - 1], table[i][j - 1]), table[i - 1][j]);
      }
    }
  }
  return table[length_word1][length_word2];
}

int string_length(char *s) {
   int c = 0;

   while(*(s+c))
      c++;

   return c;
}

void trim(char *str)
{
    char *ptr = str;
    while(*ptr == ' ' || *ptr == '\t' || *ptr == '\r' || *ptr == '\n') ++ptr;

    char *end = ptr;
    while(*end) ++end;

    if(end > ptr)
    {
        for(--end; end >= ptr && (*end == ' ' || *end == '\t' || *end == '\r' || *end == '\n'); --end);
    }

    memmove(str, ptr, end-ptr);
    str[end-ptr] = 0;
}

void calculate_distance_from_file(char *filepath) {
  FILE *fd;
  char word1[256], word2[256];
  int length_word1, length_word2;

  fd = fopen(filepath, "r");
  while (fgets(word1, sizeof(word1), fd)) {
    if (!fgets(word2, sizeof(word2), fd)) {
      break;
    }
    trim(word1);
    trim(word2);
    printf("Word1 : %s\n", word1);
    printf("Word2 : %s\n", word2);
    length_word1 = strlen(word1);
    length_word2 = strlen(word2);
    printf("Recursive distance : %d\n", recursive_distance(word1, length_word1, word2, length_word2));
    printf("Dynamic distance : %d\n", dynamic_distance(word1, length_word1, word2, length_word2));
    printf("\n");
    memset(word1, 0, strlen(word1));
    memset(word2, 0, strlen(word2));
  }
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
  printf("DONE !\n");
  return 0;
}
