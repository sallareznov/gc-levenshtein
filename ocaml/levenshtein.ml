let rec recursive_distance u v =
	let n = String.length u and m = String.length v
	in
	if n = 0 then
		m
	else
	if m = 0 then
		n
	else begin
		let u' = String.sub u 1 (n - 1) and v' = String.sub v 1 (m - 1)
		in
		if Char.uppercase u.[0] = Char.uppercase v.[0] then
			recursive_distance u' v'
		else
			1 + (min (min (recursive_distance u' v') (recursive_distance u v')) (recursive_distance u' v))
	end

let build_table u v =
	let n = String.length u and m = String.length v
	in
	let table = Array.make_matrix (n + 1) (m + 1) 0
	in
	for i = 0 to n do
		for j = 0 to m do
			if i = 0 then
				table.(i).(j) <- j
			else
			if j = 0 then
				table.(i).(j) <- i
			else
			if Char.uppercase u.[i-1] = Char.uppercase v.[j-1] then
				table.(i).(j) <- table.(i-1).(j-1)
			else
			table.(i).(j) <- 1 + min (min table.(i-1).(j-1) table.(i).(j-1)) table.(i-1).(j)
		done;
	done;
	table

let dynamic_distance u v =
	let n = String.length u and m = String.length v and table = build_table u v
	in
	table.(n).(m)

let open_file filepath = open_in filepath

let get_next_words _in =
	try
	 	(input_line _in, input_line _in)
	with
		| End_of_file -> close_in _in; ("", "")

let calculate_distance_from_file filepath distance =
	let _in = open_file filepath
	in
	while true do
		let (word1, word2) = get_next_words _in
		in
		distance word1 word2
	done

let usage() = Printf.printf "Browse the file README.md at the root of the project to know how to use this program\n"

let _ =
		if ((Array.length Sys.argv) < 3) then
			usage()
		else begin
    	if (Sys.argv.(2) = "--rec") then
      	calculate_distance_from_file Sys.argv.(1) recursive_distance
    	else if (Sys.argv.(2) = "--dyn") then
      	calculate_distance_from_file Sys.argv.(1) dynamic_distance
			else
				usage();
		end

		Printf.printf "DONE !"
