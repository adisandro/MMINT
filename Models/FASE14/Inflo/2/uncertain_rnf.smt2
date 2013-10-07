(assert (exists (( c Resource))(node Authorship  c )))
(assert (exists (( c DependerLink))(edge TrackAuthorship2Authorship  c )))
(assert (forall (( c Decomposition))(=> (edge CreateDiscussions2UseDiscussions c )(not (or (edge MakeViews2Browsing c )(edge AddSourceInDescription2CreateGraph c )(edge UseAutomatedReputationSystem2ExtensiveModeration c )(edge UseAutomatedReputationSystem2LessExtensiveModeration c )(edge TrackAuthorship2BeInflo c )(edge DisplayGraphs2BeInflo c )(edge TrackRevisions2BeInflo c )(edge CreateGraphs2BeInflo c ))))))
(assert (not (exists (( c Decomposition))(edge UseAutomatedReputationSystem2ExtensiveModeration  c ))))
