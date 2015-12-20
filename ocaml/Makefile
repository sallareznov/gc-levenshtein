#### COMPILATORS ####

COPT	= ocamlc.opt
OPTOPT	= ocamlopt.opt

#### FILES TO CLEAN ####

MLIS 			= levenshtein.mli
CMIS			= levenshtein.cmi main.cmi
CMXS			= levenshtein.cmx main.cmx
OBJECTS		= levenshtein.o main.o
BINARIES	= levenshtein

#### RULES TO CALL AT THE COMPILATION ####

LEVENSHTEIN	= levenshtein.mli levenshtein.cmi levenshtein.cmx levenshtein
EXEC	= $(LEVENSHTEIN)

all: $(EXEC)

#### MLIS ####

levenshtein.mli:
	$(COPT) -i levenshtein.ml > levenshtein.mli

#### CMIS ####

levenshtein.cmi: levenshtein.mli
	$(COPT) -c levenshtein.mli -o levenshtein.cmi

#### CMXS ####

levenshtein.cmx: levenshtein.ml
	$(OPTOPT) -c levenshtein.ml -o levenshtein.cmx

main.cmx: main.ml
		$(OPTOPT) -c main.ml -o main.cmx

#### BINARIES ####

levenshtein: levenshtein.cmx main.cmx
	$(OPTOPT) levenshtein.cmx main.cmx -o levenshtein

#### CLEAN ####

.PHONY: $(MLIS) clean mrproper

clean:
	$(RM) -rf $(MLIS) $(CMIS) $(CMXS) $(OBJECTS)

mrproper:
	$(RM) -rf $(BINARIES) *~

realclean: clean mrproper
