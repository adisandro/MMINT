(forall ((nc Int)) (=>
	(and (node nc) (= (nodeType nc) STATE))
	(exists ((ec Int))
		(and (edge ec) (= (src ec) nc))
	)
))