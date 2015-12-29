open OUnit2

let test_same_distance_for_all_techniques test_ctxt =
  let distance_techniques = [|Levenshtein.recursive_distance; Levenshtein.dynamic_distance|]
  in
  for i = 0 to Array.length distance_techniques - 1 do
    assert_equal 0 (distance_techniques.(i) "something" "something");
    assert_equal 2 (distance_techniques.(i) "this" "has");
    assert_equal 2 (distance_techniques.(i) "book" "back");
    assert_equal 3 (distance_techniques.(i) "sitting" "kitten");
    assert_equal 4 (distance_techniques.(i) "meilenstein" "levenshtein");
    assert_equal 9 (distance_techniques.(i) "something" "");
    assert_equal 9 (distance_techniques.(i) "" "something")
  done

let suite =
"levenshtein_test">:::
 ["test_same_distance_for_all_techniques">:: test_same_distance_for_all_techniques]

let () = run_test_tt_main suite
