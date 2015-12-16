#ifndef _LEVENSHTEIN_H_
#define _LEVENSHTEIN_H_

#define MIN(X, Y) (((X) < (Y)) ? (X) : (Y))
#define MAX(X, Y) (((X) < (Y)) ? (Y) : (X))

int recursive_distance(char *word1, int length_word1, char *word2, int length_word2);
int dynamic_distance(char *word1, int length_word1, char *word2, int length_word2);
void calculate_distance_from_file(char *filepath);

#endif
