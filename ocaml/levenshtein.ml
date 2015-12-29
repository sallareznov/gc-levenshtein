let rec recursive_distance u v =
	if (u = v) then
		0
	else begin
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
			if u.[0] = v.[0] then
				recursive_distance u' v'
			else
				1 + (min (min (recursive_distance u' v') (recursive_distance u v')) (recursive_distance u' v))
		end
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
			if u.[i-1] = v.[j-1] then
				table.(i).(j) <- table.(i-1).(j-1)
			else
			table.(i).(j) <- 1 + min (min table.(i-1).(j-1) table.(i).(j-1)) table.(i-1).(j)
		done;
	done;
	table

let dynamic_distance u v =
	if (u = v) then
		0
	else
		let n = String.length u and m = String.length v and table = build_table u v
		in
		table.(n).(m)

let calculate_distance_from_file filepath =
	let _in = open_in filepath
	in
	try
		while true do
			let word1 = input_line _in and word2 = input_line _in
			in
			Printf.printf "Word1 : %s\n" word1;
			Printf.printf "Word2 : %s\n" word2;
			Printf.printf "Recursive distance : %d\n" (recursive_distance word1 word2);
			Printf.printf "Dynamic distance : %d\n" (dynamic_distance word1 word2);
			Printf.printf "\n"
		done
	with
		| End_of_file -> close_in _in
