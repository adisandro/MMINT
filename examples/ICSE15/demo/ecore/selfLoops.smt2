(forall ((c Int)) (=>
    (edge c)
    (not (= (src c) (tgt c)))
))