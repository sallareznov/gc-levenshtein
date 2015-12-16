#### COMPILATORS ####

COPT	= ocamlc.opt
OPTOPT	= ocamlopt.opt

#### FILES TO CLEAN ####

MLIS 		= levenshtein.mli
CMIS		= levenshtein.cmi
CMXS		= levenshtein.cmx
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

#### BINARIES ####

levenshtein: levenshtein.cmx
	$(OPTOPT) levenshtein.cmx -o levenshtein

#### CLEAN ####

.PHONY: $(MLIS) levenshtein.mli clean mrproper

clean:
	$(RM) -rf $(CMIS) *.cmo $(CMXS) *.o

mrproper:
	$(RM) -rf $(BINARIES) *~

realclean: clean mrproper
