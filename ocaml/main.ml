let usage() = Printf.printf "Browse the file README.md at the root of the project to know how to use this program\n"

let _ =
		if ((Array.length Sys.argv) < 2) then
			usage()
		else begin
			let filepath = Sys.argv.(1)
			in
			Levenshtein.calculate_distance_from_file filepath;
			Printf.printf "DONE !"
		end
