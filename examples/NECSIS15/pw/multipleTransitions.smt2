(forall ((c1 Int) (c2 Int)) (=>
	(and (edge c1) (edge c2) (not (= c1 c2)))
	(not (and
		(= (src c1) (src c2))
		(= (tgt c1) (tgt c2))
	))
))