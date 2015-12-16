CC	= gcc
CFLAGS	= -Wall -ansi
CFLAGS += -g

HDR_DIR = include
SRC_DIR = src
OBJ_DIR = lib
BIN_DIR = bin

OBJECTS_FILES	= $(wildcard $(OBJ_DIR)/*.o)
BINARIES_FILES	= $(wildcard $(BIN_DIR)/*)
HIDDEN_FILES	= *~

COMPILED_OBJECTS	= levenshtein.o
COMPILED_BINARIES	= levenshtein

all: $(COMPILED_OBJECTS) $(COMPILED_BINARIES)

levenshtein.o: $(SRC_DIR)/levenshtein.c
	$(CC) $(CFLAGS) -c $(SRC_DIR)/levenshtein.c -o $(OBJ_DIR)/levenshtein.o $(INCDIR)

levenshtein: $(OBJ_DIR)/levenshtein.o
	$(CC) $(CFLAGS) $(OBJ_DIR)/levenshtein.o -o $(BIN_DIR)/levenshtein $(LIBS)

.PHONY: clean mrproper

clean:
	$(RM) $(OBJECTS_FILES)

mrproper:
	$(RM) $(BINARIES_FILES) *~

realclean: clean mrproper
