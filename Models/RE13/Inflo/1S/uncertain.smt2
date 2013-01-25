;Endpoint Types
(declare-const ENDPOINT_TASK Int)
(declare-const ENDPOINT_GOAL Int)
(declare-const ENDPOINT_SOFTGOAL Int)
(declare-const ENDPOINT_RESOURCE Int)
(assert (= ENDPOINT_TASK 1))
(assert (= ENDPOINT_GOAL 2))
(assert (= ENDPOINT_SOFTGOAL 3))
(assert (= ENDPOINT_RESOURCE 4))

;Contribution Types
(declare-const CONTRIBUTION_MAKE Int)
(declare-const CONTRIBUTION_HELP Int)
(declare-const CONTRIBUTION_SOMEPLUS Int)
(declare-const CONTRIBUTION_BREAK Int)
(declare-const CONTRIBUTION_HURT Int)
(declare-const CONTRIBUTION_SOMEMINUS Int)
(declare-const CONTRIBUTION_UNKNOWN Int)
(assert (= CONTRIBUTION_MAKE 11))
(assert (= CONTRIBUTION_HELP 12))
(assert (= CONTRIBUTION_SOMEPLUS 13))
(assert (= CONTRIBUTION_BREAK 14))
(assert (= CONTRIBUTION_HURT 15))
(assert (= CONTRIBUTION_SOMEMINUS 16))
(assert (= CONTRIBUTION_UNKNOWN 17))

;Model
(declare-datatypes () ((Actor
	InfloUser
	InfloManagerEditors
	Source
	AutomatedReputationSystem
	Inflo
)))
(declare-datatypes () ((Task
	Browsing
	CreateGraph
	UseDiscussions
	MakeViews
	AddSourceInDescription
	CreateDiscussions
	ExtensiveModeration
	UseAutomatedReputationSystem
	LessExtensiveModeration
	ProvideReputations
	ModerationARS
	TrackAuthorship
	DisplayGraphs
	TrackRevisions
	CreateGraphs
	BeInflo
	ModerationTasks
)))
(declare-datatypes () ((Goal
	UseInflo
	InfloBeModerated
	ModerateInflo
	AllowModeration
)))
(declare-datatypes () ((SoftGoal
	MakeModelsTrustworthy
	ValidateModel
	GetFeedback
)))
(declare-datatypes () ((Resource
	Moderation
	Graphing
	ReputationValues
	Info
	Authorship
)))
(declare-datatypes () ((IntentionalElement
	InfloUser2MakeModelsTrustworthy
	InfloUser2UseInflo
	InfloUser2ValidateModel
	InfloUser2GetFeedback
	InfloUser2Browsing
	InfloUser2CreateGraph
	InfloUser2UseDiscussions
	InfloUser2InfloBeModerated
	InfloUser2MakeViews
	InfloUser2AddSourceInDescription
	InfloUser2CreateDiscussions
	InfloManagerEditors2ExtensiveModeration
	InfloManagerEditors2UseAutomatedReputationSystem
	InfloManagerEditors2ModerateInflo
	InfloManagerEditors2LessExtensiveModeration
	AutomatedReputationSystem2ProvideReputations
	AutomatedReputationSystem2ModerationARS
	Inflo2AllowModeration
	Inflo2TrackAuthorship
	Inflo2DisplayGraphs
	Inflo2TrackRevisions
	Inflo2CreateGraphs
	Inflo2BeInflo
	Inflo2ModerationTasks
)))
(declare-datatypes () ((MeansEnd
	Browsing2UseInflo
	CreateGraph2UseInflo
	UseDiscussions2UseInflo
	ExtensiveModeration2ModerateInflo
	UseAutomatedReputationSystem2ModerateInflo
	LessExtensiveModeration2ModerateInflo
	ModerationTasks2AllowModeration
)))
(declare-datatypes () ((Decomposition
	Browsing2MakeViews
	CreateGraph2AddSourceInDescription
	UseDiscussions2CreateDiscussions
	ExtensiveModeration2UseAutomatedReputationSystem
	LessExtensiveModeration2UseAutomatedReputationSystem
	BeInflo2TrackAuthorship
	BeInflo2DisplayGraphs
	BeInflo2TrackRevisions
	BeInflo2CreateGraphs
)))
(declare-datatypes () ((Contribution
	ValidateModel2MakeModelsTrustworthy
	GetFeedback2MakeModelsTrustworthy
	UseDiscussions2ValidateModel
	InfloBeModerated2GetFeedback
	UseDiscussions2GetFeedback
)))
(declare-datatypes () ((Depender
	InfloBeModerated2Moderation
	AllowModeration2Moderation
	UseInflo2Graphing
	UseAutomatedReputationSystem2ReputationValues
	AddSourceInDescription2Info
	TrackAuthorship2Authorship
)))
(declare-datatypes () ((Dependee
	Moderation2ModerateInflo
	Moderation2ExtensiveModeration
	Moderation2ModerationARS
	Graphing2BeInflo
	ReputationValues2ProvideReputations
	Authorship2CreateGraph
	Authorship2CreateDiscussions
)))

;Concretizations
(declare-sort ActorConcretization)
(declare-sort TaskConcretization)
(declare-sort GoalConcretization)
(declare-sort SoftGoalConcretization)
(declare-sort ResourceConcretization)
(declare-sort IntentionalElementConcretization)
(declare-sort MeansEndConcretization)
(declare-sort DecompositionConcretization)
(declare-sort ContributionConcretization)
(declare-sort DependerConcretization)
(declare-sort DependeeConcretization)
(declare-fun node (Actor ActorConcretization) Bool)
(declare-fun node (Task TaskConcretization) Bool)
(declare-fun node (Goal GoalConcretization) Bool)
(declare-fun node (SoftGoal SoftGoalConcretization) Bool)
(declare-fun node (Resource ResourceConcretization) Bool)
(declare-fun edge (IntentionalElement IntentionalElementConcretization) Bool)
(declare-fun tgtEndpoint (IntentionalElementConcretization) Int)
(declare-fun src (IntentionalElementConcretization) ActorConcretization)
(declare-fun tgt (IntentionalElementConcretization) TaskConcretization)
(declare-fun tgt (IntentionalElementConcretization) GoalConcretization)
(declare-fun tgt (IntentionalElementConcretization) SoftGoalConcretization)
(declare-fun tgt (IntentionalElementConcretization) ResourceConcretization)
(declare-fun edge (MeansEnd MeansEndConcretization) Bool)
(declare-fun src (MeansEndConcretization) TaskConcretization)
(declare-fun tgt (MeansEndConcretization) GoalConcretization)
(declare-fun edge (Decomposition DecompositionConcretization) Bool)
(declare-fun tgtEndpoint (DecompositionConcretization) Int)
(declare-fun src (DecompositionConcretization) TaskConcretization)
(declare-fun tgt (DecompositionConcretization) TaskConcretization)
(declare-fun tgt (DecompositionConcretization) GoalConcretization)
(declare-fun tgt (DecompositionConcretization) SoftGoalConcretization)
(declare-fun tgt (DecompositionConcretization) ResourceConcretization)
(declare-fun edge (Contribution ContributionConcretization) Bool)
(declare-fun srcEndpoint (ContributionConcretization) Int)
(declare-fun type (ContributionConcretization) Int)
(declare-fun src (ContributionConcretization) TaskConcretization)
(declare-fun src (ContributionConcretization) GoalConcretization)
(declare-fun src (ContributionConcretization) SoftGoalConcretization)
(declare-fun src (ContributionConcretization) ResourceConcretization)
(declare-fun tgt (ContributionConcretization) SoftGoalConcretization)
(declare-fun edge (Depender DependerConcretization) Bool)
(declare-fun srcEndpoint (DependerConcretization) Int)
(declare-fun tgtEndpoint (DependerConcretization) Int)
(declare-fun src (DependerConcretization) TaskConcretization)
(declare-fun src (DependerConcretization) GoalConcretization)
(declare-fun src (DependerConcretization) SoftGoalConcretization)
(declare-fun src (DependerConcretization) ResourceConcretization)
(declare-fun tgt (DependerConcretization) TaskConcretization)
(declare-fun tgt (DependerConcretization) GoalConcretization)
(declare-fun tgt (DependerConcretization) SoftGoalConcretization)
(declare-fun tgt (DependerConcretization) ResourceConcretization)
(declare-fun edge (Dependee DependeeConcretization) Bool)
(declare-fun srcEndpoint (DependeeConcretization) Int)
(declare-fun tgtEndpoint (DependeeConcretization) Int)
(declare-fun src (DependeeConcretization) TaskConcretization)
(declare-fun src (DependeeConcretization) GoalConcretization)
(declare-fun src (DependeeConcretization) SoftGoalConcretization)
(declare-fun src (DependeeConcretization) ResourceConcretization)
(declare-fun tgt (DependeeConcretization) TaskConcretization)
(declare-fun tgt (DependeeConcretization) GoalConcretization)
(declare-fun tgt (DependeeConcretization) SoftGoalConcretization)
(declare-fun tgt (DependeeConcretization) ResourceConcretization)

;Analysis labels
(declare-fun inited (TaskConcretization) Bool)
(declare-fun inited (GoalConcretization) Bool)
(declare-fun inited (SoftGoalConcretization) Bool)
(declare-fun inited (ResourceConcretization) Bool)
(declare-fun fsSrcEndpoint (ContributionConcretization) Bool)
(declare-fun psSrcEndpoint (ContributionConcretization) Bool)
(declare-fun unSrcEndpoint (ContributionConcretization) Bool)
(declare-fun coSrcEndpoint (ContributionConcretization) Bool)
(declare-fun pdSrcEndpoint (ContributionConcretization) Bool)
(declare-fun fdSrcEndpoint (ContributionConcretization) Bool)
(declare-fun fs (TaskConcretization) Bool)
(declare-fun fs (GoalConcretization) Bool)
(declare-fun fs (SoftGoalConcretization) Bool)
(declare-fun fs (ResourceConcretization) Bool)
(declare-fun fs (MeansEndConcretization) Bool)
(declare-fun fs (DecompositionConcretization) Bool)
(declare-fun fs (ContributionConcretization) Bool)
(declare-fun fs (DependerConcretization) Bool)
(declare-fun fs (DependeeConcretization) Bool)
(declare-fun ps (TaskConcretization) Bool)
(declare-fun ps (GoalConcretization) Bool)
(declare-fun ps (SoftGoalConcretization) Bool)
(declare-fun ps (ResourceConcretization) Bool)
(declare-fun ps (MeansEndConcretization) Bool)
(declare-fun ps (DecompositionConcretization) Bool)
(declare-fun ps (ContributionConcretization) Bool)
(declare-fun ps (DependerConcretization) Bool)
(declare-fun ps (DependeeConcretization) Bool)
(declare-fun un (TaskConcretization) Bool)
(declare-fun un (GoalConcretization) Bool)
(declare-fun un (SoftGoalConcretization) Bool)
(declare-fun un (ResourceConcretization) Bool)
(declare-fun un (MeansEndConcretization) Bool)
(declare-fun un (DecompositionConcretization) Bool)
(declare-fun un (ContributionConcretization) Bool)
(declare-fun un (DependerConcretization) Bool)
(declare-fun un (DependeeConcretization) Bool)
(declare-fun co (TaskConcretization) Bool)
(declare-fun co (GoalConcretization) Bool)
(declare-fun co (SoftGoalConcretization) Bool)
(declare-fun co (ResourceConcretization) Bool)
(declare-fun co (MeansEndConcretization) Bool)
(declare-fun co (DecompositionConcretization) Bool)
(declare-fun co (ContributionConcretization) Bool)
(declare-fun co (DependerConcretization) Bool)
(declare-fun co (DependeeConcretization) Bool)
(declare-fun pd (TaskConcretization) Bool)
(declare-fun pd (GoalConcretization) Bool)
(declare-fun pd (SoftGoalConcretization) Bool)
(declare-fun pd (ResourceConcretization) Bool)
(declare-fun pd (MeansEndConcretization) Bool)
(declare-fun pd (DecompositionConcretization) Bool)
(declare-fun pd (ContributionConcretization) Bool)
(declare-fun pd (DependerConcretization) Bool)
(declare-fun pd (DependeeConcretization) Bool)
(declare-fun fd (TaskConcretization) Bool)
(declare-fun fd (GoalConcretization) Bool)
(declare-fun fd (SoftGoalConcretization) Bool)
(declare-fun fd (ResourceConcretization) Bool)
(declare-fun fd (MeansEndConcretization) Bool)
(declare-fun fd (DecompositionConcretization) Bool)
(declare-fun fd (ContributionConcretization) Bool)
(declare-fun fd (DependerConcretization) Bool)
(declare-fun fd (DependeeConcretization) Bool)
(assert (forall ((c MeansEndConcretization)) (= (fs c) (fs (src c)))))
(assert (forall ((c MeansEndConcretization)) (= (ps c) (ps (src c)))))
(assert (forall ((c MeansEndConcretization)) (= (un c) (un (src c)))))
(assert (forall ((c MeansEndConcretization)) (= (co c) (co (src c)))))
(assert (forall ((c MeansEndConcretization)) (= (pd c) (pd (src c)))))
(assert (forall ((c MeansEndConcretization)) (= (fd c) (fd (src c)))))
(assert (forall ((c DecompositionConcretization)) (= (fs c)
	(ite (= (tgtEndpoint c) ENDPOINT_TASK)
		(fs ((as tgt (TaskConcretization)) c))
		(ite (= (tgtEndpoint c) ENDPOINT_GOAL)
			(fs ((as tgt (GoalConcretization)) c))
			(ite (= (tgtEndpoint c) ENDPOINT_SOFTGOAL)
				(fs ((as tgt (SoftGoalConcretization)) c))
				(fs ((as tgt (ResourceConcretization)) c))
			)
		)
	)
)))
(assert (forall ((c DecompositionConcretization)) (= (ps c)
	(ite (= (tgtEndpoint c) ENDPOINT_TASK)
		(ps ((as tgt (TaskConcretization)) c))
		(ite (= (tgtEndpoint c) ENDPOINT_GOAL)
			(ps ((as tgt (GoalConcretization)) c))
			(ite (= (tgtEndpoint c) ENDPOINT_SOFTGOAL)
				(ps ((as tgt (SoftGoalConcretization)) c))
				(ps ((as tgt (ResourceConcretization)) c))
			)
		)
	)
)))
(assert (forall ((c DecompositionConcretization)) (= (un c)
	(ite (= (tgtEndpoint c) ENDPOINT_TASK)
		(un ((as tgt (TaskConcretization)) c))
		(ite (= (tgtEndpoint c) ENDPOINT_GOAL)
			(un ((as tgt (GoalConcretization)) c))
			(ite (= (tgtEndpoint c) ENDPOINT_SOFTGOAL)
				(un ((as tgt (SoftGoalConcretization)) c))
				(un ((as tgt (ResourceConcretization)) c))
			)
		)
	)
)))
(assert (forall ((c DecompositionConcretization)) (= (co c)
	(ite (= (tgtEndpoint c) ENDPOINT_TASK)
		(co ((as tgt (TaskConcretization)) c))
		(ite (= (tgtEndpoint c) ENDPOINT_GOAL)
			(co ((as tgt (GoalConcretization)) c))
			(ite (= (tgtEndpoint c) ENDPOINT_SOFTGOAL)
				(co ((as tgt (SoftGoalConcretization)) c))
				(co ((as tgt (ResourceConcretization)) c))
			)
		)
	)
)))
(assert (forall ((dc DecompositionConcretization)) (= (pd dc)
	(ite (= (tgtEndpoint dc) ENDPOINT_TASK)
		(pd ((as tgt (TaskConcretization)) dc))
		(ite (= (tgtEndpoint dc) ENDPOINT_GOAL)
			(pd ((as tgt (GoalConcretization)) dc))
			(ite (= (tgtEndpoint dc) ENDPOINT_SOFTGOAL)
				(pd ((as tgt (SoftGoalConcretization)) dc))
				(pd ((as tgt (ResourceConcretization)) dc))
			)
		)
	)
)))
(assert (forall ((c DecompositionConcretization)) (= (fd c)
	(ite (= (tgtEndpoint c) ENDPOINT_TASK)
		(fd ((as tgt (TaskConcretization)) c))
		(ite (= (tgtEndpoint c) ENDPOINT_GOAL)
			(fd ((as tgt (GoalConcretization)) c))
			(ite (= (tgtEndpoint c) ENDPOINT_SOFTGOAL)
				(fd ((as tgt (SoftGoalConcretization)) c))
				(fd ((as tgt (ResourceConcretization)) c))
			)
		)
	)
)))
(assert (forall ((c ContributionConcretization)) (= (fsSrcEndpoint c)
	(ite (= (srcEndpoint c) ENDPOINT_TASK)
		(fs ((as src (TaskConcretization)) c))
		(ite (= (srcEndpoint c) ENDPOINT_GOAL)
			(fs ((as src (GoalConcretization)) c))
			(ite (= (srcEndpoint c) ENDPOINT_SOFTGOAL)
				(fs ((as src (SoftGoalConcretization)) c))
				(fs ((as src (ResourceConcretization)) c))
			)
		)
	)
)))
(assert (forall ((c ContributionConcretization)) (= (psSrcEndpoint c)
	(ite (= (srcEndpoint c) ENDPOINT_TASK)
		(ps ((as src (TaskConcretization)) c))
		(ite (= (srcEndpoint c) ENDPOINT_GOAL)
			(ps ((as src (GoalConcretization)) c))
			(ite (= (srcEndpoint c) ENDPOINT_SOFTGOAL)
				(ps ((as src (SoftGoalConcretization)) c))
				(ps ((as src (ResourceConcretization)) c))
			)
		)
	)
)))
(assert (forall ((c ContributionConcretization)) (= (unSrcEndpoint c)
	(ite (= (srcEndpoint c) ENDPOINT_TASK)
		(un ((as src (TaskConcretization)) c))
		(ite (= (srcEndpoint c) ENDPOINT_GOAL)
			(un ((as src (GoalConcretization)) c))
			(ite (= (srcEndpoint c) ENDPOINT_SOFTGOAL)
				(un ((as src (SoftGoalConcretization)) c))
				(un ((as src (ResourceConcretization)) c))
			)
		)
	)
)))
(assert (forall ((c ContributionConcretization)) (= (coSrcEndpoint c)
	(ite (= (srcEndpoint c) ENDPOINT_TASK)
		(co ((as src (TaskConcretization)) c))
		(ite (= (srcEndpoint c) ENDPOINT_GOAL)
			(co ((as src (GoalConcretization)) c))
			(ite (= (srcEndpoint c) ENDPOINT_SOFTGOAL)
				(co ((as src (SoftGoalConcretization)) c))
				(co ((as src (ResourceConcretization)) c))
			)
		)
	)
)))
(assert (forall ((c ContributionConcretization)) (= (pdSrcEndpoint c)
	(ite (= (srcEndpoint c) ENDPOINT_TASK)
		(pd ((as src (TaskConcretization)) c))
		(ite (= (srcEndpoint c) ENDPOINT_GOAL)
			(pd ((as src (GoalConcretization)) c))
			(ite (= (srcEndpoint c) ENDPOINT_SOFTGOAL)
				(pd ((as src (SoftGoalConcretization)) c))
				(pd ((as src (ResourceConcretization)) c))
			)
		)
	)
)))
(assert (forall ((c ContributionConcretization)) (= (fdSrcEndpoint c)
	(ite (= (srcEndpoint c) ENDPOINT_TASK)
		(fd ((as src (TaskConcretization)) c))
		(ite (= (srcEndpoint c) ENDPOINT_GOAL)
			(fd ((as src (GoalConcretization)) c))
			(ite (= (srcEndpoint c) ENDPOINT_SOFTGOAL)
				(fd ((as src (SoftGoalConcretization)) c))
				(fd ((as src (ResourceConcretization)) c))
			)
		)
	)
)))
(assert (forall ((c ContributionConcretization)) (= (fs c)
	(ite (= (type c) CONTRIBUTION_MAKE)
		(ite (fsSrcEndpoint c)
			true
			false
		)
		false
	)
)))
(assert (forall ((c ContributionConcretization)) (= (ps c)
	(ite (= (type c) CONTRIBUTION_MAKE)
		(ite (psSrcEndpoint c)
			true
			false
		)
		(ite (or (= (type c) CONTRIBUTION_HELP) (= (type c) CONTRIBUTION_SOMEPLUS))
			(ite (or (fsSrcEndpoint c) (psSrcEndpoint c))
				true
				false
			)
			(ite (or (= (type c) CONTRIBUTION_BREAK) (= (type c) CONTRIBUTION_HURT) (= (type c) CONTRIBUTION_SOMEMINUS))
				(ite (or (pdSrcEndpoint c) (fdSrcEndpoint c))
					true
					false
				)
				false
			)
		)
	)
)))
(assert (forall ((c ContributionConcretization)) (= (un c)
	(ite (= (type c) CONTRIBUTION_UNKNOWN)
		true
		(ite (unSrcEndpoint c)
			true
			false
		)
	)
)))
(assert (forall ((c ContributionConcretization)) (= (co c)
	(ite (= (type c) CONTRIBUTION_UNKNOWN)
		false
		(ite (coSrcEndpoint c)
			true
			false
		)
	)
)))
(assert (forall ((c ContributionConcretization)) (= (pd c)
	(ite (= (type c) CONTRIBUTION_MAKE)
		(ite (pdSrcEndpoint c)
			true
			false
		)
		(ite (or (= (type c) CONTRIBUTION_HELP) (= (type c) CONTRIBUTION_SOMEPLUS))
			(ite (or (pdSrcEndpoint c) (fdSrcEndpoint c))
				true
				false
			)
			(ite (= (type c) CONTRIBUTION_BREAK)
				(ite (psSrcEndpoint c)
					true
					false
				)
				(ite (or (= (type c) CONTRIBUTION_HURT) (= (type c) CONTRIBUTION_SOMEMINUS))
					(ite (or (fsSrcEndpoint c) (psSrcEndpoint c))
						true
						false
					)
					false
				)
			)
		)
	)
)))
(assert (forall ((c ContributionConcretization)) (= (fd c)
	(ite (= (type c) CONTRIBUTION_MAKE)
		(ite (fdSrcEndpoint c)
			true
			false
		)
		(ite (= (type c) CONTRIBUTION_BREAK)
			(ite (fsSrcEndpoint c)
				true
				false
			)
			false
		)
	)
)))
(assert (forall ((c DependerConcretization)) (= (fs c)
	(ite (= (tgtEndpoint c) ENDPOINT_TASK)
		(fs ((as tgt (TaskConcretization)) c))
		(ite (= (tgtEndpoint c) ENDPOINT_GOAL)
			(fs ((as tgt (GoalConcretization)) c))
			(ite (= (tgtEndpoint c) ENDPOINT_SOFTGOAL)
				(fs ((as tgt (SoftGoalConcretization)) c))
				(fs ((as tgt (ResourceConcretization)) c))
			)
		)
	)
)))
(assert (forall ((c DependerConcretization)) (= (ps c)
	(ite (= (tgtEndpoint c) ENDPOINT_TASK)
		(ps ((as tgt (TaskConcretization)) c))
		(ite (= (tgtEndpoint c) ENDPOINT_GOAL)
			(ps ((as tgt (GoalConcretization)) c))
			(ite (= (tgtEndpoint c) ENDPOINT_SOFTGOAL)
				(ps ((as tgt (SoftGoalConcretization)) c))
				(ps ((as tgt (ResourceConcretization)) c))
			)
		)
	)
)))
(assert (forall ((c DependerConcretization)) (= (un c)
	(ite (= (tgtEndpoint c) ENDPOINT_TASK)
		(un ((as tgt (TaskConcretization)) c))
		(ite (= (tgtEndpoint c) ENDPOINT_GOAL)
			(un ((as tgt (GoalConcretization)) c))
			(ite (= (tgtEndpoint c) ENDPOINT_SOFTGOAL)
				(un ((as tgt (SoftGoalConcretization)) c))
				(un ((as tgt (ResourceConcretization)) c))
			)
		)
	)
)))
(assert (forall ((c DependerConcretization)) (= (co c)
	(ite (= (tgtEndpoint c) ENDPOINT_TASK)
		(co ((as tgt (TaskConcretization)) c))
		(ite (= (tgtEndpoint c) ENDPOINT_GOAL)
			(co ((as tgt (GoalConcretization)) c))
			(ite (= (tgtEndpoint c) ENDPOINT_SOFTGOAL)
				(co ((as tgt (SoftGoalConcretization)) c))
				(co ((as tgt (ResourceConcretization)) c))
			)
		)
	)
)))
(assert (forall ((c DependerConcretization)) (= (pd c)
	(ite (= (tgtEndpoint c) ENDPOINT_TASK)
		(pd ((as tgt (TaskConcretization)) c))
		(ite (= (tgtEndpoint c) ENDPOINT_GOAL)
			(pd ((as tgt (GoalConcretization)) c))
			(ite (= (tgtEndpoint c) ENDPOINT_SOFTGOAL)
				(pd ((as tgt (SoftGoalConcretization)) c))
				(pd ((as tgt (ResourceConcretization)) c))
			)
		)
	)
)))
(assert (forall ((c DependerConcretization)) (= (fd c)
	(ite (= (tgtEndpoint c) ENDPOINT_TASK)
		(fd ((as tgt (TaskConcretization)) c))
		(ite (= (tgtEndpoint c) ENDPOINT_GOAL)
			(fd ((as tgt (GoalConcretization)) c))
			(ite (= (tgtEndpoint c) ENDPOINT_SOFTGOAL)
				(fd ((as tgt (SoftGoalConcretization)) c))
				(fd ((as tgt (ResourceConcretization)) c))
			)
		)
	)
)))
(assert (forall ((c DependeeConcretization)) (= (fs c)
	(ite (= (tgtEndpoint c) ENDPOINT_TASK)
		(fs ((as tgt (TaskConcretization)) c))
		(ite (= (tgtEndpoint c) ENDPOINT_GOAL)
			(fs ((as tgt (GoalConcretization)) c))
			(ite (= (tgtEndpoint c) ENDPOINT_SOFTGOAL)
				(fs ((as tgt (SoftGoalConcretization)) c))
				(fs ((as tgt (ResourceConcretization)) c))
			)
		)
	)
)))
(assert (forall ((c DependeeConcretization)) (= (ps c)
	(ite (= (tgtEndpoint c) ENDPOINT_TASK)
		(ps ((as tgt (TaskConcretization)) c))
		(ite (= (tgtEndpoint c) ENDPOINT_GOAL)
			(ps ((as tgt (GoalConcretization)) c))
			(ite (= (tgtEndpoint c) ENDPOINT_SOFTGOAL)
				(ps ((as tgt (SoftGoalConcretization)) c))
				(ps ((as tgt (ResourceConcretization)) c))
			)
		)
	)
)))
(assert (forall ((c DependeeConcretization)) (= (un c)
	(ite (= (tgtEndpoint c) ENDPOINT_TASK)
		(un ((as tgt (TaskConcretization)) c))
		(ite (= (tgtEndpoint c) ENDPOINT_GOAL)
			(un ((as tgt (GoalConcretization)) c))
			(ite (= (tgtEndpoint c) ENDPOINT_SOFTGOAL)
				(un ((as tgt (SoftGoalConcretization)) c))
				(un ((as tgt (ResourceConcretization)) c))
			)
		)
	)
)))
(assert (forall ((c DependeeConcretization)) (= (co c)
	(ite (= (tgtEndpoint c) ENDPOINT_TASK)
		(co ((as tgt (TaskConcretization)) c))
		(ite (= (tgtEndpoint c) ENDPOINT_GOAL)
			(co ((as tgt (GoalConcretization)) c))
			(ite (= (tgtEndpoint c) ENDPOINT_SOFTGOAL)
				(co ((as tgt (SoftGoalConcretization)) c))
				(co ((as tgt (ResourceConcretization)) c))
			)
		)
	)
)))
(assert (forall ((c DependeeConcretization)) (= (pd c)
	(ite (= (tgtEndpoint c) ENDPOINT_TASK)
		(pd ((as tgt (TaskConcretization)) c))
		(ite (= (tgtEndpoint c) ENDPOINT_GOAL)
			(pd ((as tgt (GoalConcretization)) c))
			(ite (= (tgtEndpoint c) ENDPOINT_SOFTGOAL)
				(pd ((as tgt (SoftGoalConcretization)) c))
				(pd ((as tgt (ResourceConcretization)) c))
			)
		)
	)
)))
(assert (forall ((c DependeeConcretization)) (= (fd c)
	(ite (= (tgtEndpoint c) ENDPOINT_TASK)
		(fd ((as tgt (TaskConcretization)) c))
		(ite (= (tgtEndpoint c) ENDPOINT_GOAL)
			(fd ((as tgt (GoalConcretization)) c))
			(ite (= (tgtEndpoint c) ENDPOINT_SOFTGOAL)
				(fd ((as tgt (SoftGoalConcretization)) c))
				(fd ((as tgt (ResourceConcretization)) c))
			)
		)
	)
)))

;Uninitialized labels
(declare-fun n (TaskConcretization) Bool)
(declare-fun n (GoalConcretization) Bool)
(declare-fun n (SoftGoalConcretization) Bool)
(declare-fun n (ResourceConcretization) Bool)
(declare-fun n (MeansEndConcretization) Bool)
(declare-fun n (DecompositionConcretization) Bool)
(declare-fun n (ContributionConcretization) Bool)
(declare-fun n (DependerConcretization) Bool)
(declare-fun n (DependeeConcretization) Bool)
(assert (forall ((c MeansEndConcretization)) (= (n c) (n (src c)))))
(assert (forall ((c DecompositionConcretization)) (= (n c)
	(ite (= (tgtEndpoint c) ENDPOINT_TASK)
		(n ((as tgt (TaskConcretization)) c))
		(ite (= (tgtEndpoint c) ENDPOINT_GOAL)
			(n ((as tgt (GoalConcretization)) c))
			(ite (= (tgtEndpoint c) ENDPOINT_SOFTGOAL)
				(n ((as tgt (SoftGoalConcretization)) c))
				(n ((as tgt (ResourceConcretization)) c))
			)
		)
	)
)))
(assert (forall ((c ContributionConcretization)) (= (n c)
	(ite (= (srcEndpoint c) ENDPOINT_TASK)
		(n ((as src (TaskConcretization)) c))
		(ite (= (srcEndpoint c) ENDPOINT_GOAL)
			(n ((as src (GoalConcretization)) c))
			(ite (= (srcEndpoint c) ENDPOINT_SOFTGOAL)
				(n ((as src (SoftGoalConcretization)) c))
				(n ((as src (ResourceConcretization)) c))
			)
		)
	)
)))
(assert (forall ((c DependerConcretization)) (= (n c)
	(ite (= (tgtEndpoint c) ENDPOINT_TASK)
		(n ((as tgt (TaskConcretization)) c))
		(ite (= (tgtEndpoint c) ENDPOINT_GOAL)
			(n ((as tgt (GoalConcretization)) c))
			(ite (= (tgtEndpoint c) ENDPOINT_SOFTGOAL)
				(n ((as tgt (SoftGoalConcretization)) c))
				(n ((as tgt (ResourceConcretization)) c))
			)
		)
	)
)))
(assert (forall ((c DependeeConcretization)) (= (n c)
	(ite (= (tgtEndpoint c) ENDPOINT_TASK)
		(n ((as tgt (TaskConcretization)) c))
		(ite (= (tgtEndpoint c) ENDPOINT_GOAL)
			(n ((as tgt (GoalConcretization)) c))
			(ite (= (tgtEndpoint c) ENDPOINT_SOFTGOAL)
				(n ((as tgt (SoftGoalConcretization)) c))
				(n ((as tgt (ResourceConcretization)) c))
			)
		)
	)
)))

;Only one analysis label
(assert (forall ((c TaskConcretization)) (xor (fs c) (ps c) (un c) (co c) (pd c) (fd c) (n c))))
(assert (forall ((c GoalConcretization)) (xor (fs c) (ps c) (un c) (co c) (pd c) (fd c) (n c))))
(assert (forall ((c SoftGoalConcretization)) (xor (fs c) (ps c) (un c) (co c) (pd c) (fd c) (n c))))
(assert (forall ((c ResourceConcretization)) (xor (fs c) (ps c) (un c) (co c) (pd c) (fd c) (n c))))

;No self-loops:
;;MeansEnd can't
;;Decomposition only from Task to Task
;;Contribution only from SoftGoal to SoftGoal
;;Depender and Dependee only if there are dependencies among dependums
(assert (forall ((c DecompositionConcretization)) (=>
	(= (tgtEndpoint c) ENDPOINT_TASK)
	(not (= (src c) ((as tgt (TaskConcretization)) c)))
)))
(assert (forall ((c ContributionConcretization)) (=>
	(= (srcEndpoint c) ENDPOINT_SOFTGOAL)
	(not (= ((as src (SoftGoalConcretization)) c) (tgt c)))
)))

;Complete Model
(assert	(forall ((c ActorConcretization)) (or
	(node InfloUser c)
	(node InfloManagerEditors c)
	(node Source c)
	(node AutomatedReputationSystem c)
	(node Inflo c)
)))
(assert	(forall ((c TaskConcretization)) (or
	(node Browsing c)
	(node CreateGraph c)
	(node UseDiscussions c)
	(node MakeViews c)
	(node AddSourceInDescription c)
	(node CreateDiscussions c)
	(node ExtensiveModeration c)
	(node UseAutomatedReputationSystem c)
	(node LessExtensiveModeration c)
	(node ProvideReputations c)
	(node ModerationARS c)
	(node TrackAuthorship c)
	(node DisplayGraphs c)
	(node TrackRevisions c)
	(node CreateGraphs c)
	(node BeInflo c)
	(node ModerationTasks c)
)))
(assert (forall ((c GoalConcretization)) (or
	(node UseInflo c)
	(node InfloBeModerated c)
	(node ModerateInflo c)
	(node AllowModeration c)
)))
(assert (forall ((c SoftGoalConcretization)) (or
	(node MakeModelsTrustworthy c)
	(node ValidateModel c)
	(node GetFeedback c)
)))
(assert (forall ((c ResourceConcretization)) (or
	(node Moderation c)
	(node Graphing c)
	(node ReputationValues c)
	(node Info c)
	(node Authorship c)
)))
(assert (forall ((c IntentionalElementConcretization)) (or
	(edge InfloUser2MakeModelsTrustworthy c)
	(edge InfloUser2UseInflo c)
	(edge InfloUser2ValidateModel c)
	(edge InfloUser2GetFeedback c)
	(edge InfloUser2Browsing c)
	(edge InfloUser2CreateGraph c)
	(edge InfloUser2UseDiscussions c)
	(edge InfloUser2InfloBeModerated c)
	(edge InfloUser2MakeViews c)
	(edge InfloUser2AddSourceInDescription c)
	(edge InfloUser2CreateDiscussions c)
	(edge InfloManagerEditors2ExtensiveModeration c)
	(edge InfloManagerEditors2UseAutomatedReputationSystem c)
	(edge InfloManagerEditors2ModerateInflo c)
	(edge InfloManagerEditors2LessExtensiveModeration c)
	(edge AutomatedReputationSystem2ProvideReputations c)
	(edge AutomatedReputationSystem2ModerationARS c)
	(edge Inflo2AllowModeration c)
	(edge Inflo2TrackAuthorship c)
	(edge Inflo2DisplayGraphs c)
	(edge Inflo2TrackRevisions c)
	(edge Inflo2CreateGraphs c)
	(edge Inflo2BeInflo c)
	(edge Inflo2ModerationTasks c)
)))
(assert (forall ((c MeansEndConcretization)) (or
	(edge Browsing2UseInflo c)
	(edge CreateGraph2UseInflo c)
	(edge UseDiscussions2UseInflo c)
	(edge ExtensiveModeration2ModerateInflo c)
	(edge UseAutomatedReputationSystem2ModerateInflo c)
	(edge LessExtensiveModeration2ModerateInflo c)
	(edge ModerationTasks2AllowModeration c)
)))
(assert (forall ((c DecompositionConcretization)) (or
	(edge Browsing2MakeViews c)
	(edge CreateGraph2AddSourceInDescription c)
	(edge UseDiscussions2CreateDiscussions c)
	(edge ExtensiveModeration2UseAutomatedReputationSystem c)
	(edge LessExtensiveModeration2UseAutomatedReputationSystem c)
	(edge BeInflo2TrackAuthorship c)
	(edge BeInflo2DisplayGraphs c)
	(edge BeInflo2TrackRevisions c)
	(edge BeInflo2CreateGraphs c)
)))
(assert (forall ((c ContributionConcretization)) (or
	(edge ValidateModel2MakeModelsTrustworthy c)
	(edge GetFeedback2MakeModelsTrustworthy c)
	(edge UseDiscussions2ValidateModel c)
	(edge InfloBeModerated2GetFeedback c)
	(edge UseDiscussions2GetFeedback c)
)))
(assert (forall ((c DependerConcretization)) (or
	(edge InfloBeModerated2Moderation c)
	(edge AllowModeration2Moderation c)
	(edge UseInflo2Graphing c)
	(edge UseAutomatedReputationSystem2ReputationValues c)
	(edge AddSourceInDescription2Info c)
	(edge TrackAuthorship2Authorship c)
)))
(assert (forall ((c DependeeConcretization)) (or
	(edge Moderation2ModerateInflo c)
	(edge Moderation2ExtensiveModeration c)
	(edge Moderation2ModerationARS c)
	(edge Graphing2BeInflo c)
	(edge ReputationValues2ProvideReputations c)
	(edge Authorship2CreateGraph c)
	(edge Authorship2CreateDiscussions c)
)))

;Model Elements
;InfloUser Exists
(assert	(exists ((c ActorConcretization)) (node InfloUser c)))
;InfloUser is Unique
(assert	(forall ((c1 ActorConcretization) (c2 ActorConcretization)) (=>
	(and (node InfloUser c1) (node InfloUser c2))
	(= c1 c2)
)))
;InfloUser is Distinct from InfloManagerEditors
(assert	(forall ((c ActorConcretization)) (=>
	(node InfloUser c)
	(not (node InfloManagerEditors c))
)))
;InfloUser is Distinct from Source
(assert	(forall ((c ActorConcretization)) (=>
	(node InfloUser c)
	(not (node Source c))
)))
;InfloUser is Distinct from AutomatedReputationSystem
(assert	(forall ((c ActorConcretization)) (=>
	(node InfloUser c)
	(not (node AutomatedReputationSystem c))
)))
;InfloUser is Distinct from Inflo
(assert	(forall ((c ActorConcretization)) (=>
	(node InfloUser c)
	(not (node Inflo c))
)))
;InfloManagerEditors Exists
(assert	(exists ((c ActorConcretization)) (node InfloManagerEditors c)))
;InfloManagerEditors is Unique
(assert	(forall ((c1 ActorConcretization) (c2 ActorConcretization)) (=>
	(and (node InfloManagerEditors c1) (node InfloManagerEditors c2))
	(= c1 c2)
)))
;InfloManagerEditors is Distinct from InfloUser
(assert	(forall ((c ActorConcretization)) (=>
	(node InfloManagerEditors c)
	(not (node InfloUser c))
)))
;InfloManagerEditors is Distinct from Source
(assert	(forall ((c ActorConcretization)) (=>
	(node InfloManagerEditors c)
	(not (node Source c))
)))
;InfloManagerEditors is Distinct from AutomatedReputationSystem
(assert	(forall ((c ActorConcretization)) (=>
	(node InfloManagerEditors c)
	(not (node AutomatedReputationSystem c))
)))
;InfloManagerEditors is Distinct from Inflo
(assert	(forall ((c ActorConcretization)) (=>
	(node InfloManagerEditors c)
	(not (node Inflo c))
)))
;Source Exists
(assert	(exists ((c ActorConcretization)) (node Source c)))
;Source is Unique
(assert	(forall ((c1 ActorConcretization) (c2 ActorConcretization)) (=>
	(and (node Source c1) (node Source c2))
	(= c1 c2)
)))
;Source is Distinct from InfloUser
(assert	(forall ((c ActorConcretization)) (=>
	(node Source c)
	(not (node InfloUser c))
)))
;Source is Distinct from InfloManagerEditors
(assert	(forall ((c ActorConcretization)) (=>
	(node Source c)
	(not (node InfloManagerEditors c))
)))
;Source is Distinct from AutomatedReputationSystem
(assert	(forall ((c ActorConcretization)) (=>
	(node Source c)
	(not (node AutomatedReputationSystem c))
)))
;Source is Distinct from Inflo
(assert	(forall ((c ActorConcretization)) (=>
	(node Source c)
	(not (node Inflo c))
)))
;AutomatedReputationSystem Exists
(assert	(exists ((c ActorConcretization)) (node AutomatedReputationSystem c)))
;AutomatedReputationSystem is Unique
(assert	(forall ((c1 ActorConcretization) (c2 ActorConcretization)) (=>
	(and (node AutomatedReputationSystem c1) (node AutomatedReputationSystem c2))
	(= c1 c2)
)))
;AutomatedReputationSystem is Distinct from InfloUser
(assert	(forall ((c ActorConcretization)) (=>
	(node AutomatedReputationSystem c)
	(not (node InfloUser c))
)))
;AutomatedReputationSystem is Distinct from InfloManagerEditors
(assert	(forall ((c ActorConcretization)) (=>
	(node AutomatedReputationSystem c)
	(not (node InfloManagerEditors c))
)))
;AutomatedReputationSystem is Distinct from Source
(assert	(forall ((c ActorConcretization)) (=>
	(node AutomatedReputationSystem c)
	(not (node Source c))
)))
;AutomatedReputationSystem is Distinct from Inflo
(assert	(forall ((c ActorConcretization)) (=>
	(node AutomatedReputationSystem c)
	(not (node Inflo c))
)))
;Inflo Exists
(assert	(exists ((c ActorConcretization)) (node Inflo c)))
;Inflo is Unique
(assert	(forall ((c1 ActorConcretization) (c2 ActorConcretization)) (=>
	(and (node Inflo c1) (node Inflo c2))
	(= c1 c2)
)))
;Inflo is Distinct from InfloUser
(assert	(forall ((c ActorConcretization)) (=>
	(node Inflo c)
	(not (node InfloUser c))
)))
;Inflo is Distinct from InfloManagerEditors
(assert	(forall ((c ActorConcretization)) (=>
	(node Inflo c)
	(not (node InfloManagerEditors c))
)))
;Inflo is Distinct from Source
(assert	(forall ((c ActorConcretization)) (=>
	(node Inflo c)
	(not (node Source c))
)))
;Inflo is Distinct from AutomatedReputationSystem
(assert	(forall ((c ActorConcretization)) (=>
	(node Inflo c)
	(not (node AutomatedReputationSystem c))
)))
;Browsing initial analysis tag
(assert (forall ((c TaskConcretization)) (=>
	(node Browsing c)
	(= (inited c) false)
)))
;Browsing Exists
(assert	(exists ((c TaskConcretization)) (node Browsing c)))
;Browsing is Unique
(assert	(forall ((c1 TaskConcretization) (c2 TaskConcretization)) (=>
	(and (node Browsing c1) (node Browsing c2))
	(= c1 c2)
)))
;Browsing is Distinct from ExtensiveModeration
(assert	(forall ((c TaskConcretization)) (=>
	(node Browsing c)
	(not (node ExtensiveModeration c))
)))
;Browsing is Distinct from UseAutomatedReputationSystem
(assert	(forall ((c TaskConcretization)) (=>
	(node Browsing c)
	(not (node UseAutomatedReputationSystem c))
)))
;Browsing is Distinct from LessExtensiveModeration
(assert	(forall ((c TaskConcretization)) (=>
	(node Browsing c)
	(not (node LessExtensiveModeration c))
)))
;Browsing is Distinct from ProvideReputations
(assert	(forall ((c TaskConcretization)) (=>
	(node Browsing c)
	(not (node ProvideReputations c))
)))
;Browsing is Distinct from ModerationARS
(assert	(forall ((c TaskConcretization)) (=>
	(node Browsing c)
	(not (node ModerationARS c))
)))
;Browsing is Distinct from TrackAuthorship
(assert	(forall ((c TaskConcretization)) (=>
	(node Browsing c)
	(not (node TrackAuthorship c))
)))
;Browsing is Distinct from DisplayGraphs
(assert	(forall ((c TaskConcretization)) (=>
	(node Browsing c)
	(not (node DisplayGraphs c))
)))
;Browsing is Distinct from TrackRevisions
(assert	(forall ((c TaskConcretization)) (=>
	(node Browsing c)
	(not (node TrackRevisions c))
)))
;Browsing is Distinct from CreateGraphs
(assert	(forall ((c TaskConcretization)) (=>
	(node Browsing c)
	(not (node CreateGraphs c))
)))
;Browsing is Distinct from BeInflo
(assert	(forall ((c TaskConcretization)) (=>
	(node Browsing c)
	(not (node BeInflo c))
)))
;Browsing is Distinct from ModerationTasks
(assert	(forall ((c TaskConcretization)) (=>
	(node Browsing c)
	(not (node ModerationTasks c))
)))
;Browsing is Distinct from CreateGraph
(assert	(forall ((c TaskConcretization)) (=>
	(node Browsing c)
	(not (node CreateGraph c))
)))
;Browsing is Distinct from UseDiscussions
(assert	(forall ((c TaskConcretization)) (=>
	(node Browsing c)
	(not (node UseDiscussions c))
)))
;Browsing is Distinct from MakeViews
(assert	(forall ((c TaskConcretization)) (=>
	(node Browsing c)
	(not (node MakeViews c))
)))
;Browsing is Distinct from AddSourceInDescription
(assert	(forall ((c TaskConcretization)) (=>
	(node Browsing c)
	(not (node AddSourceInDescription c))
)))

;CreateGraph initial analysis tag
(assert (forall ((c TaskConcretization)) (=>
	(node CreateGraph c)
	(= (inited c) false)
)))
;CreateGraph Exists
(assert	(exists ((c TaskConcretization)) (node CreateGraph c)))
;CreateGraph is Unique
(assert	(forall ((c1 TaskConcretization) (c2 TaskConcretization)) (=>
	(and (node CreateGraph c1) (node CreateGraph c2))
	(= c1 c2)
)))
;CreateGraph is Distinct from ExtensiveModeration
(assert	(forall ((c TaskConcretization)) (=>
	(node CreateGraph c)
	(not (node ExtensiveModeration c))
)))
;CreateGraph is Distinct from UseAutomatedReputationSystem
(assert	(forall ((c TaskConcretization)) (=>
	(node CreateGraph c)
	(not (node UseAutomatedReputationSystem c))
)))
;CreateGraph is Distinct from LessExtensiveModeration
(assert	(forall ((c TaskConcretization)) (=>
	(node CreateGraph c)
	(not (node LessExtensiveModeration c))
)))
;CreateGraph is Distinct from ProvideReputations
(assert	(forall ((c TaskConcretization)) (=>
	(node CreateGraph c)
	(not (node ProvideReputations c))
)))
;CreateGraph is Distinct from ModerationARS
(assert	(forall ((c TaskConcretization)) (=>
	(node CreateGraph c)
	(not (node ModerationARS c))
)))
;CreateGraph is Distinct from TrackAuthorship
(assert	(forall ((c TaskConcretization)) (=>
	(node CreateGraph c)
	(not (node TrackAuthorship c))
)))
;CreateGraph is Distinct from DisplayGraphs
(assert	(forall ((c TaskConcretization)) (=>
	(node CreateGraph c)
	(not (node DisplayGraphs c))
)))
;CreateGraph is Distinct from TrackRevisions
(assert	(forall ((c TaskConcretization)) (=>
	(node CreateGraph c)
	(not (node TrackRevisions c))
)))
;CreateGraph is Distinct from CreateGraphs
(assert	(forall ((c TaskConcretization)) (=>
	(node CreateGraph c)
	(not (node CreateGraphs c))
)))
;CreateGraph is Distinct from BeInflo
(assert	(forall ((c TaskConcretization)) (=>
	(node CreateGraph c)
	(not (node BeInflo c))
)))
;CreateGraph is Distinct from ModerationTasks
(assert	(forall ((c TaskConcretization)) (=>
	(node CreateGraph c)
	(not (node ModerationTasks c))
)))
;CreateGraph is Distinct from Browsing
(assert	(forall ((c TaskConcretization)) (=>
	(node CreateGraph c)
	(not (node Browsing c))
)))
;CreateGraph is Distinct from UseDiscussions
(assert	(forall ((c TaskConcretization)) (=>
	(node CreateGraph c)
	(not (node UseDiscussions c))
)))
;CreateGraph is Distinct from MakeViews
(assert	(forall ((c TaskConcretization)) (=>
	(node CreateGraph c)
	(not (node MakeViews c))
)))
;CreateGraph is Distinct from AddSourceInDescription
(assert	(forall ((c TaskConcretization)) (=>
	(node CreateGraph c)
	(not (node AddSourceInDescription c))
)))

;UseDiscussions initial analysis tag
(assert (forall ((c TaskConcretization)) (=>
	(node UseDiscussions c)
	(= (inited c) false)
)))
;UseDiscussions Exists
(assert	(exists ((c TaskConcretization)) (node UseDiscussions c)))
;UseDiscussions is Unique
(assert	(forall ((c1 TaskConcretization) (c2 TaskConcretization)) (=>
	(and (node UseDiscussions c1) (node UseDiscussions c2))
	(= c1 c2)
)))
;UseDiscussions is Distinct from ExtensiveModeration
(assert	(forall ((c TaskConcretization)) (=>
	(node UseDiscussions c)
	(not (node ExtensiveModeration c))
)))
;UseDiscussions is Distinct from UseAutomatedReputationSystem
(assert	(forall ((c TaskConcretization)) (=>
	(node UseDiscussions c)
	(not (node UseAutomatedReputationSystem c))
)))
;UseDiscussions is Distinct from LessExtensiveModeration
(assert	(forall ((c TaskConcretization)) (=>
	(node UseDiscussions c)
	(not (node LessExtensiveModeration c))
)))
;UseDiscussions is Distinct from ProvideReputations
(assert	(forall ((c TaskConcretization)) (=>
	(node UseDiscussions c)
	(not (node ProvideReputations c))
)))
;UseDiscussions is Distinct from ModerationARS
(assert	(forall ((c TaskConcretization)) (=>
	(node UseDiscussions c)
	(not (node ModerationARS c))
)))
;UseDiscussions is Distinct from TrackAuthorship
(assert	(forall ((c TaskConcretization)) (=>
	(node UseDiscussions c)
	(not (node TrackAuthorship c))
)))
;UseDiscussions is Distinct from DisplayGraphs
(assert	(forall ((c TaskConcretization)) (=>
	(node UseDiscussions c)
	(not (node DisplayGraphs c))
)))
;UseDiscussions is Distinct from TrackRevisions
(assert	(forall ((c TaskConcretization)) (=>
	(node UseDiscussions c)
	(not (node TrackRevisions c))
)))
;UseDiscussions is Distinct from CreateGraphs
(assert	(forall ((c TaskConcretization)) (=>
	(node UseDiscussions c)
	(not (node CreateGraphs c))
)))
;UseDiscussions is Distinct from BeInflo
(assert	(forall ((c TaskConcretization)) (=>
	(node UseDiscussions c)
	(not (node BeInflo c))
)))
;UseDiscussions is Distinct from ModerationTasks
(assert	(forall ((c TaskConcretization)) (=>
	(node UseDiscussions c)
	(not (node ModerationTasks c))
)))
;UseDiscussions is Distinct from Browsing
(assert	(forall ((c TaskConcretization)) (=>
	(node UseDiscussions c)
	(not (node Browsing c))
)))
;UseDiscussions is Distinct from CreateGraph
(assert	(forall ((c TaskConcretization)) (=>
	(node UseDiscussions c)
	(not (node CreateGraph c))
)))
;UseDiscussions is Distinct from MakeViews
(assert	(forall ((c TaskConcretization)) (=>
	(node UseDiscussions c)
	(not (node MakeViews c))
)))
;UseDiscussions is Distinct from AddSourceInDescription
(assert	(forall ((c TaskConcretization)) (=>
	(node UseDiscussions c)
	(not (node AddSourceInDescription c))
)))

;MakeViews initial analysis tag
(assert (forall ((c TaskConcretization)) (=>
	(node MakeViews c)
	(and
		(= (fs c) true)
		(= (ps c) false)
		(= (un c) false)
		(= (co c) false)
		(= (pd c) false)
		(= (fd c) false)
		(= (n c) false)
		(= (inited c) true)
	)
)))
;MakeViews Exists
(assert	(exists ((c TaskConcretization)) (node MakeViews c)))
;MakeViews is Unique
(assert	(forall ((c1 TaskConcretization) (c2 TaskConcretization)) (=>
	(and (node MakeViews c1) (node MakeViews c2))
	(= c1 c2)
)))
;MakeViews is Distinct from ExtensiveModeration
(assert	(forall ((c TaskConcretization)) (=>
	(node MakeViews c)
	(not (node ExtensiveModeration c))
)))
;MakeViews is Distinct from UseAutomatedReputationSystem
(assert	(forall ((c TaskConcretization)) (=>
	(node MakeViews c)
	(not (node UseAutomatedReputationSystem c))
)))
;MakeViews is Distinct from LessExtensiveModeration
(assert	(forall ((c TaskConcretization)) (=>
	(node MakeViews c)
	(not (node LessExtensiveModeration c))
)))
;MakeViews is Distinct from ProvideReputations
(assert	(forall ((c TaskConcretization)) (=>
	(node MakeViews c)
	(not (node ProvideReputations c))
)))
;MakeViews is Distinct from ModerationARS
(assert	(forall ((c TaskConcretization)) (=>
	(node MakeViews c)
	(not (node ModerationARS c))
)))
;MakeViews is Distinct from TrackAuthorship
(assert	(forall ((c TaskConcretization)) (=>
	(node MakeViews c)
	(not (node TrackAuthorship c))
)))
;MakeViews is Distinct from DisplayGraphs
(assert	(forall ((c TaskConcretization)) (=>
	(node MakeViews c)
	(not (node DisplayGraphs c))
)))
;MakeViews is Distinct from TrackRevisions
(assert	(forall ((c TaskConcretization)) (=>
	(node MakeViews c)
	(not (node TrackRevisions c))
)))
;MakeViews is Distinct from CreateGraphs
(assert	(forall ((c TaskConcretization)) (=>
	(node MakeViews c)
	(not (node CreateGraphs c))
)))
;MakeViews is Distinct from BeInflo
(assert	(forall ((c TaskConcretization)) (=>
	(node MakeViews c)
	(not (node BeInflo c))
)))
;MakeViews is Distinct from ModerationTasks
(assert	(forall ((c TaskConcretization)) (=>
	(node MakeViews c)
	(not (node ModerationTasks c))
)))
;MakeViews is Distinct from Browsing
(assert	(forall ((c TaskConcretization)) (=>
	(node MakeViews c)
	(not (node Browsing c))
)))
;MakeViews is Distinct from CreateGraph
(assert	(forall ((c TaskConcretization)) (=>
	(node MakeViews c)
	(not (node CreateGraph c))
)))
;MakeViews is Distinct from UseDiscussions
(assert	(forall ((c TaskConcretization)) (=>
	(node MakeViews c)
	(not (node UseDiscussions c))
)))
;MakeViews is Distinct from AddSourceInDescription
(assert	(forall ((c TaskConcretization)) (=>
	(node MakeViews c)
	(not (node AddSourceInDescription c))
)))

;AddSourceInDescription initial analysis tag
(assert (forall ((c TaskConcretization)) (=>
	(node AddSourceInDescription c)
	(= (inited c) false)
)))
;AddSourceInDescription Exists
(assert	(exists ((c TaskConcretization)) (node AddSourceInDescription c)))
;AddSourceInDescription is Unique
(assert	(forall ((c1 TaskConcretization) (c2 TaskConcretization)) (=>
	(and (node AddSourceInDescription c1) (node AddSourceInDescription c2))
	(= c1 c2)
)))
;AddSourceInDescription is Distinct from ExtensiveModeration
(assert	(forall ((c TaskConcretization)) (=>
	(node AddSourceInDescription c)
	(not (node ExtensiveModeration c))
)))
;AddSourceInDescription is Distinct from UseAutomatedReputationSystem
(assert	(forall ((c TaskConcretization)) (=>
	(node AddSourceInDescription c)
	(not (node UseAutomatedReputationSystem c))
)))
;AddSourceInDescription is Distinct from LessExtensiveModeration
(assert	(forall ((c TaskConcretization)) (=>
	(node AddSourceInDescription c)
	(not (node LessExtensiveModeration c))
)))
;AddSourceInDescription is Distinct from ProvideReputations
(assert	(forall ((c TaskConcretization)) (=>
	(node AddSourceInDescription c)
	(not (node ProvideReputations c))
)))
;AddSourceInDescription is Distinct from ModerationARS
(assert	(forall ((c TaskConcretization)) (=>
	(node AddSourceInDescription c)
	(not (node ModerationARS c))
)))
;AddSourceInDescription is Distinct from TrackAuthorship
(assert	(forall ((c TaskConcretization)) (=>
	(node AddSourceInDescription c)
	(not (node TrackAuthorship c))
)))
;AddSourceInDescription is Distinct from DisplayGraphs
(assert	(forall ((c TaskConcretization)) (=>
	(node AddSourceInDescription c)
	(not (node DisplayGraphs c))
)))
;AddSourceInDescription is Distinct from TrackRevisions
(assert	(forall ((c TaskConcretization)) (=>
	(node AddSourceInDescription c)
	(not (node TrackRevisions c))
)))
;AddSourceInDescription is Distinct from CreateGraphs
(assert	(forall ((c TaskConcretization)) (=>
	(node AddSourceInDescription c)
	(not (node CreateGraphs c))
)))
;AddSourceInDescription is Distinct from BeInflo
(assert	(forall ((c TaskConcretization)) (=>
	(node AddSourceInDescription c)
	(not (node BeInflo c))
)))
;AddSourceInDescription is Distinct from ModerationTasks
(assert	(forall ((c TaskConcretization)) (=>
	(node AddSourceInDescription c)
	(not (node ModerationTasks c))
)))
;AddSourceInDescription is Distinct from Browsing
(assert	(forall ((c TaskConcretization)) (=>
	(node AddSourceInDescription c)
	(not (node Browsing c))
)))
;AddSourceInDescription is Distinct from CreateGraph
(assert	(forall ((c TaskConcretization)) (=>
	(node AddSourceInDescription c)
	(not (node CreateGraph c))
)))
;AddSourceInDescription is Distinct from UseDiscussions
(assert	(forall ((c TaskConcretization)) (=>
	(node AddSourceInDescription c)
	(not (node UseDiscussions c))
)))
;AddSourceInDescription is Distinct from MakeViews
(assert	(forall ((c TaskConcretization)) (=>
	(node AddSourceInDescription c)
	(not (node MakeViews c))
)))

;CreateDiscussions initial analysis tag
(assert (forall ((c TaskConcretization)) (=>
	(node CreateDiscussions c)
	(and
		(= (fs c) true)
		(= (ps c) false)
		(= (un c) false)
		(= (co c) false)
		(= (pd c) false)
		(= (fd c) false)
		(= (n c) false)
		(= (inited c) true)
	)
)))
;CreateDiscussions is Unique
(assert	(forall ((c1 TaskConcretization) (c2 TaskConcretization)) (=>
	(and (node CreateDiscussions c1) (node CreateDiscussions c2))
	(= c1 c2)
)))
;CreateDiscussions is Distinct from ExtensiveModeration
(assert	(forall ((c TaskConcretization)) (=>
	(node CreateDiscussions c)
	(not (node ExtensiveModeration c))
)))
;CreateDiscussions is Distinct from UseAutomatedReputationSystem
(assert	(forall ((c TaskConcretization)) (=>
	(node CreateDiscussions c)
	(not (node UseAutomatedReputationSystem c))
)))
;CreateDiscussions is Distinct from LessExtensiveModeration
(assert	(forall ((c TaskConcretization)) (=>
	(node CreateDiscussions c)
	(not (node LessExtensiveModeration c))
)))
;CreateDiscussions is Distinct from ProvideReputations
(assert	(forall ((c TaskConcretization)) (=>
	(node CreateDiscussions c)
	(not (node ProvideReputations c))
)))
;CreateDiscussions is Distinct from ModerationARS
(assert	(forall ((c TaskConcretization)) (=>
	(node CreateDiscussions c)
	(not (node ModerationARS c))
)))
;CreateDiscussions is Distinct from TrackAuthorship
(assert	(forall ((c TaskConcretization)) (=>
	(node CreateDiscussions c)
	(not (node TrackAuthorship c))
)))
;CreateDiscussions is Distinct from DisplayGraphs
(assert	(forall ((c TaskConcretization)) (=>
	(node CreateDiscussions c)
	(not (node DisplayGraphs c))
)))
;CreateDiscussions is Distinct from TrackRevisions
(assert	(forall ((c TaskConcretization)) (=>
	(node CreateDiscussions c)
	(not (node TrackRevisions c))
)))
;CreateDiscussions is Distinct from CreateGraphs
(assert	(forall ((c TaskConcretization)) (=>
	(node CreateDiscussions c)
	(not (node CreateGraphs c))
)))
;CreateDiscussions is Distinct from BeInflo
(assert	(forall ((c TaskConcretization)) (=>
	(node CreateDiscussions c)
	(not (node BeInflo c))
)))
;CreateDiscussions is Distinct from ModerationTasks
(assert	(forall ((c TaskConcretization)) (=>
	(node CreateDiscussions c)
	(not (node ModerationTasks c))
)))

;ExtensiveModeration initial analysis tag
(assert (forall ((c TaskConcretization)) (=>
	(node ExtensiveModeration c)
	(= (inited c) false)
)))
;ExtensiveModeration Exists
(assert	(exists ((c TaskConcretization)) (node ExtensiveModeration c)))
;ExtensiveModeration is Unique
(assert	(forall ((c1 TaskConcretization) (c2 TaskConcretization)) (=>
	(and (node ExtensiveModeration c1) (node ExtensiveModeration c2))
	(= c1 c2)
)))
;ExtensiveModeration is Distinct from Browsing
(assert	(forall ((c TaskConcretization)) (=>
	(node ExtensiveModeration c)
	(not (node Browsing c))
)))
;ExtensiveModeration is Distinct from CreateGraph
(assert	(forall ((c TaskConcretization)) (=>
	(node ExtensiveModeration c)
	(not (node CreateGraph c))
)))
;ExtensiveModeration is Distinct from UseDiscussions
(assert	(forall ((c TaskConcretization)) (=>
	(node ExtensiveModeration c)
	(not (node UseDiscussions c))
)))
;ExtensiveModeration is Distinct from MakeViews
(assert	(forall ((c TaskConcretization)) (=>
	(node ExtensiveModeration c)
	(not (node MakeViews c))
)))
;ExtensiveModeration is Distinct from AddSourceInDescription
(assert	(forall ((c TaskConcretization)) (=>
	(node ExtensiveModeration c)
	(not (node AddSourceInDescription c))
)))
;ExtensiveModeration is Distinct from CreateDiscussions
(assert	(forall ((c TaskConcretization)) (=>
	(node ExtensiveModeration c)
	(not (node CreateDiscussions c))
)))
;ExtensiveModeration is Distinct from ProvideReputations
(assert	(forall ((c TaskConcretization)) (=>
	(node ExtensiveModeration c)
	(not (node ProvideReputations c))
)))
;ExtensiveModeration is Distinct from ModerationARS
(assert	(forall ((c TaskConcretization)) (=>
	(node ExtensiveModeration c)
	(not (node ModerationARS c))
)))
;ExtensiveModeration is Distinct from TrackAuthorship
(assert	(forall ((c TaskConcretization)) (=>
	(node ExtensiveModeration c)
	(not (node TrackAuthorship c))
)))
;ExtensiveModeration is Distinct from DisplayGraphs
(assert	(forall ((c TaskConcretization)) (=>
	(node ExtensiveModeration c)
	(not (node DisplayGraphs c))
)))
;ExtensiveModeration is Distinct from TrackRevisions
(assert	(forall ((c TaskConcretization)) (=>
	(node ExtensiveModeration c)
	(not (node TrackRevisions c))
)))
;ExtensiveModeration is Distinct from CreateGraphs
(assert	(forall ((c TaskConcretization)) (=>
	(node ExtensiveModeration c)
	(not (node CreateGraphs c))
)))
;ExtensiveModeration is Distinct from BeInflo
(assert	(forall ((c TaskConcretization)) (=>
	(node ExtensiveModeration c)
	(not (node BeInflo c))
)))
;ExtensiveModeration is Distinct from ModerationTasks
(assert	(forall ((c TaskConcretization)) (=>
	(node ExtensiveModeration c)
	(not (node ModerationTasks c))
)))
;ExtensiveModeration is Distinct from UseAutomatedReputationSystem
(assert	(forall ((c TaskConcretization)) (=>
	(node ExtensiveModeration c)
	(not (node UseAutomatedReputationSystem c))
)))

;UseAutomatedReputationSystem initial analysis tag
(assert (forall ((c TaskConcretization)) (=>
	(node UseAutomatedReputationSystem c)
	(= (inited c) false)
)))
;UseAutomatedReputationSystem Exists
(assert	(exists ((c TaskConcretization)) (node UseAutomatedReputationSystem c)))
;UseAutomatedReputationSystem is Unique
(assert	(forall ((c1 TaskConcretization) (c2 TaskConcretization)) (=>
	(and (node UseAutomatedReputationSystem c1) (node UseAutomatedReputationSystem c2))
	(= c1 c2)
)))
;UseAutomatedReputationSystem is Distinct from Browsing
(assert	(forall ((c TaskConcretization)) (=>
	(node UseAutomatedReputationSystem c)
	(not (node Browsing c))
)))
;UseAutomatedReputationSystem is Distinct from CreateGraph
(assert	(forall ((c TaskConcretization)) (=>
	(node UseAutomatedReputationSystem c)
	(not (node CreateGraph c))
)))
;UseAutomatedReputationSystem is Distinct from UseDiscussions
(assert	(forall ((c TaskConcretization)) (=>
	(node UseAutomatedReputationSystem c)
	(not (node UseDiscussions c))
)))
;UseAutomatedReputationSystem is Distinct from MakeViews
(assert	(forall ((c TaskConcretization)) (=>
	(node UseAutomatedReputationSystem c)
	(not (node MakeViews c))
)))
;UseAutomatedReputationSystem is Distinct from AddSourceInDescription
(assert	(forall ((c TaskConcretization)) (=>
	(node UseAutomatedReputationSystem c)
	(not (node AddSourceInDescription c))
)))
;UseAutomatedReputationSystem is Distinct from CreateDiscussions
(assert	(forall ((c TaskConcretization)) (=>
	(node UseAutomatedReputationSystem c)
	(not (node CreateDiscussions c))
)))
;UseAutomatedReputationSystem is Distinct from ProvideReputations
(assert	(forall ((c TaskConcretization)) (=>
	(node UseAutomatedReputationSystem c)
	(not (node ProvideReputations c))
)))
;UseAutomatedReputationSystem is Distinct from ModerationARS
(assert	(forall ((c TaskConcretization)) (=>
	(node UseAutomatedReputationSystem c)
	(not (node ModerationARS c))
)))
;UseAutomatedReputationSystem is Distinct from TrackAuthorship
(assert	(forall ((c TaskConcretization)) (=>
	(node UseAutomatedReputationSystem c)
	(not (node TrackAuthorship c))
)))
;UseAutomatedReputationSystem is Distinct from DisplayGraphs
(assert	(forall ((c TaskConcretization)) (=>
	(node UseAutomatedReputationSystem c)
	(not (node DisplayGraphs c))
)))
;UseAutomatedReputationSystem is Distinct from TrackRevisions
(assert	(forall ((c TaskConcretization)) (=>
	(node UseAutomatedReputationSystem c)
	(not (node TrackRevisions c))
)))
;UseAutomatedReputationSystem is Distinct from CreateGraphs
(assert	(forall ((c TaskConcretization)) (=>
	(node UseAutomatedReputationSystem c)
	(not (node CreateGraphs c))
)))
;UseAutomatedReputationSystem is Distinct from BeInflo
(assert	(forall ((c TaskConcretization)) (=>
	(node UseAutomatedReputationSystem c)
	(not (node BeInflo c))
)))
;UseAutomatedReputationSystem is Distinct from ModerationTasks
(assert	(forall ((c TaskConcretization)) (=>
	(node UseAutomatedReputationSystem c)
	(not (node ModerationTasks c))
)))
;UseAutomatedReputationSystem is Distinct from ExtensiveModeration
(assert	(forall ((c TaskConcretization)) (=>
	(node UseAutomatedReputationSystem c)
	(not (node ExtensiveModeration c))
)))

;LessExtensiveModeration initial analysis tag
(assert (forall ((c TaskConcretization)) (=>
	(node LessExtensiveModeration c)
	(= (inited c) false)
)))
;LessExtensiveModeration is Unique
(assert	(forall ((c1 TaskConcretization) (c2 TaskConcretization)) (=>
	(and (node LessExtensiveModeration c1) (node LessExtensiveModeration c2))
	(= c1 c2)
)))
;LessExtensiveModeration is Distinct from Browsing
(assert	(forall ((c TaskConcretization)) (=>
	(node LessExtensiveModeration c)
	(not (node Browsing c))
)))
;LessExtensiveModeration is Distinct from CreateGraph
(assert	(forall ((c TaskConcretization)) (=>
	(node LessExtensiveModeration c)
	(not (node CreateGraph c))
)))
;LessExtensiveModeration is Distinct from UseDiscussions
(assert	(forall ((c TaskConcretization)) (=>
	(node LessExtensiveModeration c)
	(not (node UseDiscussions c))
)))
;LessExtensiveModeration is Distinct from MakeViews
(assert	(forall ((c TaskConcretization)) (=>
	(node LessExtensiveModeration c)
	(not (node MakeViews c))
)))
;LessExtensiveModeration is Distinct from AddSourceInDescription
(assert	(forall ((c TaskConcretization)) (=>
	(node LessExtensiveModeration c)
	(not (node AddSourceInDescription c))
)))
;LessExtensiveModeration is Distinct from CreateDiscussions
(assert	(forall ((c TaskConcretization)) (=>
	(node LessExtensiveModeration c)
	(not (node CreateDiscussions c))
)))
;LessExtensiveModeration is Distinct from ProvideReputations
(assert	(forall ((c TaskConcretization)) (=>
	(node LessExtensiveModeration c)
	(not (node ProvideReputations c))
)))
;LessExtensiveModeration is Distinct from ModerationARS
(assert	(forall ((c TaskConcretization)) (=>
	(node LessExtensiveModeration c)
	(not (node ModerationARS c))
)))
;LessExtensiveModeration is Distinct from TrackAuthorship
(assert	(forall ((c TaskConcretization)) (=>
	(node LessExtensiveModeration c)
	(not (node TrackAuthorship c))
)))
;LessExtensiveModeration is Distinct from DisplayGraphs
(assert	(forall ((c TaskConcretization)) (=>
	(node LessExtensiveModeration c)
	(not (node DisplayGraphs c))
)))
;LessExtensiveModeration is Distinct from TrackRevisions
(assert	(forall ((c TaskConcretization)) (=>
	(node LessExtensiveModeration c)
	(not (node TrackRevisions c))
)))
;LessExtensiveModeration is Distinct from CreateGraphs
(assert	(forall ((c TaskConcretization)) (=>
	(node LessExtensiveModeration c)
	(not (node CreateGraphs c))
)))
;LessExtensiveModeration is Distinct from BeInflo
(assert	(forall ((c TaskConcretization)) (=>
	(node LessExtensiveModeration c)
	(not (node BeInflo c))
)))
;LessExtensiveModeration is Distinct from ModerationTasks
(assert	(forall ((c TaskConcretization)) (=>
	(node LessExtensiveModeration c)
	(not (node ModerationTasks c))
)))

;ProvideReputations initial analysis tag
(assert (forall ((c TaskConcretization)) (=>
	(node ProvideReputations c)
	(and
		(= (fs c) true)
		(= (ps c) false)
		(= (un c) false)
		(= (co c) false)
		(= (pd c) false)
		(= (fd c) false)
		(= (n c) false)
		(= (inited c) true)
	)
)))
;ProvideReputations Exists
(assert	(exists ((c TaskConcretization)) (node ProvideReputations c)))
;ProvideReputations is Unique
(assert	(forall ((c1 TaskConcretization) (c2 TaskConcretization)) (=>
	(and (node ProvideReputations c1) (node ProvideReputations c2))
	(= c1 c2)
)))
;ProvideReputations is Distinct from Browsing
(assert	(forall ((c TaskConcretization)) (=>
	(node ProvideReputations c)
	(not (node Browsing c))
)))
;ProvideReputations is Distinct from CreateGraph
(assert	(forall ((c TaskConcretization)) (=>
	(node ProvideReputations c)
	(not (node CreateGraph c))
)))
;ProvideReputations is Distinct from UseDiscussions
(assert	(forall ((c TaskConcretization)) (=>
	(node ProvideReputations c)
	(not (node UseDiscussions c))
)))
;ProvideReputations is Distinct from MakeViews
(assert	(forall ((c TaskConcretization)) (=>
	(node ProvideReputations c)
	(not (node MakeViews c))
)))
;ProvideReputations is Distinct from AddSourceInDescription
(assert	(forall ((c TaskConcretization)) (=>
	(node ProvideReputations c)
	(not (node AddSourceInDescription c))
)))
;ProvideReputations is Distinct from CreateDiscussions
(assert	(forall ((c TaskConcretization)) (=>
	(node ProvideReputations c)
	(not (node CreateDiscussions c))
)))
;ProvideReputations is Distinct from ExtensiveModeration
(assert	(forall ((c TaskConcretization)) (=>
	(node ProvideReputations c)
	(not (node ExtensiveModeration c))
)))
;ProvideReputations is Distinct from UseAutomatedReputationSystem
(assert	(forall ((c TaskConcretization)) (=>
	(node ProvideReputations c)
	(not (node UseAutomatedReputationSystem c))
)))
;ProvideReputations is Distinct from LessExtensiveModeration
(assert	(forall ((c TaskConcretization)) (=>
	(node ProvideReputations c)
	(not (node LessExtensiveModeration c))
)))
;ProvideReputations is Distinct from TrackAuthorship
(assert	(forall ((c TaskConcretization)) (=>
	(node ProvideReputations c)
	(not (node TrackAuthorship c))
)))
;ProvideReputations is Distinct from DisplayGraphs
(assert	(forall ((c TaskConcretization)) (=>
	(node ProvideReputations c)
	(not (node DisplayGraphs c))
)))
;ProvideReputations is Distinct from TrackRevisions
(assert	(forall ((c TaskConcretization)) (=>
	(node ProvideReputations c)
	(not (node TrackRevisions c))
)))
;ProvideReputations is Distinct from CreateGraphs
(assert	(forall ((c TaskConcretization)) (=>
	(node ProvideReputations c)
	(not (node CreateGraphs c))
)))
;ProvideReputations is Distinct from BeInflo
(assert	(forall ((c TaskConcretization)) (=>
	(node ProvideReputations c)
	(not (node BeInflo c))
)))
;ProvideReputations is Distinct from ModerationTasks
(assert	(forall ((c TaskConcretization)) (=>
	(node ProvideReputations c)
	(not (node ModerationTasks c))
)))
;ProvideReputations is Distinct from ModerationARS
(assert	(forall ((c TaskConcretization)) (=>
	(node ProvideReputations c)
	(not (node ModerationARS c))
)))

;ModerationARS initial analysis tag
(assert (forall ((c TaskConcretization)) (=>
	(node ModerationARS c)
	(and
		(= (fs c) false)
		(= (ps c) false)
		(= (un c) false)
		(= (co c) false)
		(= (pd c) false)
		(= (fd c) true)
		(= (n c) false)
		(= (inited c) true)
	)
)))
;ModerationARS is Unique
(assert	(forall ((c1 TaskConcretization) (c2 TaskConcretization)) (=>
	(and (node ModerationARS c1) (node ModerationARS c2))
	(= c1 c2)
)))
;ModerationARS is Distinct from Browsing
(assert	(forall ((c TaskConcretization)) (=>
	(node ModerationARS c)
	(not (node Browsing c))
)))
;ModerationARS is Distinct from CreateGraph
(assert	(forall ((c TaskConcretization)) (=>
	(node ModerationARS c)
	(not (node CreateGraph c))
)))
;ModerationARS is Distinct from UseDiscussions
(assert	(forall ((c TaskConcretization)) (=>
	(node ModerationARS c)
	(not (node UseDiscussions c))
)))
;ModerationARS is Distinct from MakeViews
(assert	(forall ((c TaskConcretization)) (=>
	(node ModerationARS c)
	(not (node MakeViews c))
)))
;ModerationARS is Distinct from AddSourceInDescription
(assert	(forall ((c TaskConcretization)) (=>
	(node ModerationARS c)
	(not (node AddSourceInDescription c))
)))
;ModerationARS is Distinct from CreateDiscussions
(assert	(forall ((c TaskConcretization)) (=>
	(node ModerationARS c)
	(not (node CreateDiscussions c))
)))
;ModerationARS is Distinct from ExtensiveModeration
(assert	(forall ((c TaskConcretization)) (=>
	(node ModerationARS c)
	(not (node ExtensiveModeration c))
)))
;ModerationARS is Distinct from UseAutomatedReputationSystem
(assert	(forall ((c TaskConcretization)) (=>
	(node ModerationARS c)
	(not (node UseAutomatedReputationSystem c))
)))
;ModerationARS is Distinct from LessExtensiveModeration
(assert	(forall ((c TaskConcretization)) (=>
	(node ModerationARS c)
	(not (node LessExtensiveModeration c))
)))
;ModerationARS is Distinct from TrackAuthorship
(assert	(forall ((c TaskConcretization)) (=>
	(node ModerationARS c)
	(not (node TrackAuthorship c))
)))
;ModerationARS is Distinct from DisplayGraphs
(assert	(forall ((c TaskConcretization)) (=>
	(node ModerationARS c)
	(not (node DisplayGraphs c))
)))
;ModerationARS is Distinct from TrackRevisions
(assert	(forall ((c TaskConcretization)) (=>
	(node ModerationARS c)
	(not (node TrackRevisions c))
)))
;ModerationARS is Distinct from CreateGraphs
(assert	(forall ((c TaskConcretization)) (=>
	(node ModerationARS c)
	(not (node CreateGraphs c))
)))
;ModerationARS is Distinct from BeInflo
(assert	(forall ((c TaskConcretization)) (=>
	(node ModerationARS c)
	(not (node BeInflo c))
)))
;ModerationARS is Distinct from ModerationTasks
(assert	(forall ((c TaskConcretization)) (=>
	(node ModerationARS c)
	(not (node ModerationTasks c))
)))
;ModerationARS is Distinct from ProvideReputations
(assert	(forall ((c TaskConcretization)) (=>
	(node ModerationARS c)
	(not (node ProvideReputations c))
)))

;TrackAuthorship initial analysis tag
(assert (forall ((c TaskConcretization)) (=>
	(node TrackAuthorship c)
	(= (inited c) false)
)))
;TrackAuthorship Exists
(assert	(exists ((c TaskConcretization)) (node TrackAuthorship c)))
;TrackAuthorship is Unique
(assert	(forall ((c1 TaskConcretization) (c2 TaskConcretization)) (=>
	(and (node TrackAuthorship c1) (node TrackAuthorship c2))
	(= c1 c2)
)))
;TrackAuthorship is Distinct from Browsing
(assert	(forall ((c TaskConcretization)) (=>
	(node TrackAuthorship c)
	(not (node Browsing c))
)))
;TrackAuthorship is Distinct from CreateGraph
(assert	(forall ((c TaskConcretization)) (=>
	(node TrackAuthorship c)
	(not (node CreateGraph c))
)))
;TrackAuthorship is Distinct from UseDiscussions
(assert	(forall ((c TaskConcretization)) (=>
	(node TrackAuthorship c)
	(not (node UseDiscussions c))
)))
;TrackAuthorship is Distinct from MakeViews
(assert	(forall ((c TaskConcretization)) (=>
	(node TrackAuthorship c)
	(not (node MakeViews c))
)))
;TrackAuthorship is Distinct from AddSourceInDescription
(assert	(forall ((c TaskConcretization)) (=>
	(node TrackAuthorship c)
	(not (node AddSourceInDescription c))
)))
;TrackAuthorship is Distinct from CreateDiscussions
(assert	(forall ((c TaskConcretization)) (=>
	(node TrackAuthorship c)
	(not (node CreateDiscussions c))
)))
;TrackAuthorship is Distinct from ExtensiveModeration
(assert	(forall ((c TaskConcretization)) (=>
	(node TrackAuthorship c)
	(not (node ExtensiveModeration c))
)))
;TrackAuthorship is Distinct from UseAutomatedReputationSystem
(assert	(forall ((c TaskConcretization)) (=>
	(node TrackAuthorship c)
	(not (node UseAutomatedReputationSystem c))
)))
;TrackAuthorship is Distinct from LessExtensiveModeration
(assert	(forall ((c TaskConcretization)) (=>
	(node TrackAuthorship c)
	(not (node LessExtensiveModeration c))
)))
;TrackAuthorship is Distinct from ProvideReputations
(assert	(forall ((c TaskConcretization)) (=>
	(node TrackAuthorship c)
	(not (node ProvideReputations c))
)))
;TrackAuthorship is Distinct from ModerationARS
(assert	(forall ((c TaskConcretization)) (=>
	(node TrackAuthorship c)
	(not (node ModerationARS c))
)))
;TrackAuthorship is Distinct from DisplayGraphs
(assert	(forall ((c TaskConcretization)) (=>
	(node TrackAuthorship c)
	(not (node DisplayGraphs c))
)))
;TrackAuthorship is Distinct from TrackRevisions
(assert	(forall ((c TaskConcretization)) (=>
	(node TrackAuthorship c)
	(not (node TrackRevisions c))
)))
;TrackAuthorship is Distinct from CreateGraphs
(assert	(forall ((c TaskConcretization)) (=>
	(node TrackAuthorship c)
	(not (node CreateGraphs c))
)))
;TrackAuthorship is Distinct from BeInflo
(assert	(forall ((c TaskConcretization)) (=>
	(node TrackAuthorship c)
	(not (node BeInflo c))
)))
;TrackAuthorship is Distinct from ModerationTasks
(assert	(forall ((c TaskConcretization)) (=>
	(node TrackAuthorship c)
	(not (node ModerationTasks c))
)))

;DisplayGraphs initial analysis tag
(assert (forall ((c TaskConcretization)) (=>
	(node DisplayGraphs c)
	(and
		(= (fs c) false)
		(= (ps c) false)
		(= (un c) false)
		(= (co c) false)
		(= (pd c) false)
		(= (fd c) true)
		(= (n c) false)
		(= (inited c) true)
	)
)))
;DisplayGraphs Exists
(assert	(exists ((c TaskConcretization)) (node DisplayGraphs c)))
;DisplayGraphs is Unique
(assert	(forall ((c1 TaskConcretization) (c2 TaskConcretization)) (=>
	(and (node DisplayGraphs c1) (node DisplayGraphs c2))
	(= c1 c2)
)))
;DisplayGraphs is Distinct from Browsing
(assert	(forall ((c TaskConcretization)) (=>
	(node DisplayGraphs c)
	(not (node Browsing c))
)))
;DisplayGraphs is Distinct from CreateGraph
(assert	(forall ((c TaskConcretization)) (=>
	(node DisplayGraphs c)
	(not (node CreateGraph c))
)))
;DisplayGraphs is Distinct from UseDiscussions
(assert	(forall ((c TaskConcretization)) (=>
	(node DisplayGraphs c)
	(not (node UseDiscussions c))
)))
;DisplayGraphs is Distinct from MakeViews
(assert	(forall ((c TaskConcretization)) (=>
	(node DisplayGraphs c)
	(not (node MakeViews c))
)))
;DisplayGraphs is Distinct from AddSourceInDescription
(assert	(forall ((c TaskConcretization)) (=>
	(node DisplayGraphs c)
	(not (node AddSourceInDescription c))
)))
;DisplayGraphs is Distinct from CreateDiscussions
(assert	(forall ((c TaskConcretization)) (=>
	(node DisplayGraphs c)
	(not (node CreateDiscussions c))
)))
;DisplayGraphs is Distinct from ExtensiveModeration
(assert	(forall ((c TaskConcretization)) (=>
	(node DisplayGraphs c)
	(not (node ExtensiveModeration c))
)))
;DisplayGraphs is Distinct from UseAutomatedReputationSystem
(assert	(forall ((c TaskConcretization)) (=>
	(node DisplayGraphs c)
	(not (node UseAutomatedReputationSystem c))
)))
;DisplayGraphs is Distinct from LessExtensiveModeration
(assert	(forall ((c TaskConcretization)) (=>
	(node DisplayGraphs c)
	(not (node LessExtensiveModeration c))
)))
;DisplayGraphs is Distinct from ProvideReputations
(assert	(forall ((c TaskConcretization)) (=>
	(node DisplayGraphs c)
	(not (node ProvideReputations c))
)))
;DisplayGraphs is Distinct from ModerationARS
(assert	(forall ((c TaskConcretization)) (=>
	(node DisplayGraphs c)
	(not (node ModerationARS c))
)))
;DisplayGraphs is Distinct from TrackAuthorship
(assert	(forall ((c TaskConcretization)) (=>
	(node DisplayGraphs c)
	(not (node TrackAuthorship c))
)))
;DisplayGraphs is Distinct from TrackRevisions
(assert	(forall ((c TaskConcretization)) (=>
	(node DisplayGraphs c)
	(not (node TrackRevisions c))
)))
;DisplayGraphs is Distinct from CreateGraphs
(assert	(forall ((c TaskConcretization)) (=>
	(node DisplayGraphs c)
	(not (node CreateGraphs c))
)))
;DisplayGraphs is Distinct from BeInflo
(assert	(forall ((c TaskConcretization)) (=>
	(node DisplayGraphs c)
	(not (node BeInflo c))
)))
;DisplayGraphs is Distinct from ModerationTasks
(assert	(forall ((c TaskConcretization)) (=>
	(node DisplayGraphs c)
	(not (node ModerationTasks c))
)))

;TrackRevisions initial analysis tag
(assert (forall ((c TaskConcretization)) (=>
	(node TrackRevisions c)
	(and
		(= (fs c) true)
		(= (ps c) false)
		(= (un c) false)
		(= (co c) false)
		(= (pd c) false)
		(= (fd c) false)
		(= (n c) false)
		(= (inited c) true)
	)
)))
;TrackRevisions Exists
(assert	(exists ((c TaskConcretization)) (node TrackRevisions c)))
;TrackRevisions is Unique
(assert	(forall ((c1 TaskConcretization) (c2 TaskConcretization)) (=>
	(and (node TrackRevisions c1) (node TrackRevisions c2))
	(= c1 c2)
)))
;TrackRevisions is Distinct from Browsing
(assert	(forall ((c TaskConcretization)) (=>
	(node TrackRevisions c)
	(not (node Browsing c))
)))
;TrackRevisions is Distinct from CreateGraph
(assert	(forall ((c TaskConcretization)) (=>
	(node TrackRevisions c)
	(not (node CreateGraph c))
)))
;TrackRevisions is Distinct from UseDiscussions
(assert	(forall ((c TaskConcretization)) (=>
	(node TrackRevisions c)
	(not (node UseDiscussions c))
)))
;TrackRevisions is Distinct from MakeViews
(assert	(forall ((c TaskConcretization)) (=>
	(node TrackRevisions c)
	(not (node MakeViews c))
)))
;TrackRevisions is Distinct from AddSourceInDescription
(assert	(forall ((c TaskConcretization)) (=>
	(node TrackRevisions c)
	(not (node AddSourceInDescription c))
)))
;TrackRevisions is Distinct from CreateDiscussions
(assert	(forall ((c TaskConcretization)) (=>
	(node TrackRevisions c)
	(not (node CreateDiscussions c))
)))
;TrackRevisions is Distinct from ExtensiveModeration
(assert	(forall ((c TaskConcretization)) (=>
	(node TrackRevisions c)
	(not (node ExtensiveModeration c))
)))
;TrackRevisions is Distinct from UseAutomatedReputationSystem
(assert	(forall ((c TaskConcretization)) (=>
	(node TrackRevisions c)
	(not (node UseAutomatedReputationSystem c))
)))
;TrackRevisions is Distinct from LessExtensiveModeration
(assert	(forall ((c TaskConcretization)) (=>
	(node TrackRevisions c)
	(not (node LessExtensiveModeration c))
)))
;TrackRevisions is Distinct from ProvideReputations
(assert	(forall ((c TaskConcretization)) (=>
	(node TrackRevisions c)
	(not (node ProvideReputations c))
)))
;TrackRevisions is Distinct from ModerationARS
(assert	(forall ((c TaskConcretization)) (=>
	(node TrackRevisions c)
	(not (node ModerationARS c))
)))
;TrackRevisions is Distinct from TrackAuthorship
(assert	(forall ((c TaskConcretization)) (=>
	(node TrackRevisions c)
	(not (node TrackAuthorship c))
)))
;TrackRevisions is Distinct from DisplayGraphs
(assert	(forall ((c TaskConcretization)) (=>
	(node TrackRevisions c)
	(not (node DisplayGraphs c))
)))
;TrackRevisions is Distinct from CreateGraphs
(assert	(forall ((c TaskConcretization)) (=>
	(node TrackRevisions c)
	(not (node CreateGraphs c))
)))
;TrackRevisions is Distinct from BeInflo
(assert	(forall ((c TaskConcretization)) (=>
	(node TrackRevisions c)
	(not (node BeInflo c))
)))
;TrackRevisions is Distinct from ModerationTasks
(assert	(forall ((c TaskConcretization)) (=>
	(node TrackRevisions c)
	(not (node ModerationTasks c))
)))

;CreateGraphs initial analysis tag
(assert (forall ((c TaskConcretization)) (=>
	(node CreateGraphs c)
	(and
		(= (fs c) true)
		(= (ps c) false)
		(= (un c) false)
		(= (co c) false)
		(= (pd c) false)
		(= (fd c) false)
		(= (n c) false)
		(= (inited c) true)
	)
)))
;CreateGraphs Exists
(assert	(exists ((c TaskConcretization)) (node CreateGraphs c)))
;CreateGraphs is Unique
(assert	(forall ((c1 TaskConcretization) (c2 TaskConcretization)) (=>
	(and (node CreateGraphs c1) (node CreateGraphs c2))
	(= c1 c2)
)))
;CreateGraphs is Distinct from Browsing
(assert	(forall ((c TaskConcretization)) (=>
	(node CreateGraphs c)
	(not (node Browsing c))
)))
;CreateGraphs is Distinct from CreateGraph
(assert	(forall ((c TaskConcretization)) (=>
	(node CreateGraphs c)
	(not (node CreateGraph c))
)))
;CreateGraphs is Distinct from UseDiscussions
(assert	(forall ((c TaskConcretization)) (=>
	(node CreateGraphs c)
	(not (node UseDiscussions c))
)))
;CreateGraphs is Distinct from MakeViews
(assert	(forall ((c TaskConcretization)) (=>
	(node CreateGraphs c)
	(not (node MakeViews c))
)))
;CreateGraphs is Distinct from AddSourceInDescription
(assert	(forall ((c TaskConcretization)) (=>
	(node CreateGraphs c)
	(not (node AddSourceInDescription c))
)))
;CreateGraphs is Distinct from CreateDiscussions
(assert	(forall ((c TaskConcretization)) (=>
	(node CreateGraphs c)
	(not (node CreateDiscussions c))
)))
;CreateGraphs is Distinct from ExtensiveModeration
(assert	(forall ((c TaskConcretization)) (=>
	(node CreateGraphs c)
	(not (node ExtensiveModeration c))
)))
;CreateGraphs is Distinct from UseAutomatedReputationSystem
(assert	(forall ((c TaskConcretization)) (=>
	(node CreateGraphs c)
	(not (node UseAutomatedReputationSystem c))
)))
;CreateGraphs is Distinct from LessExtensiveModeration
(assert	(forall ((c TaskConcretization)) (=>
	(node CreateGraphs c)
	(not (node LessExtensiveModeration c))
)))
;CreateGraphs is Distinct from ProvideReputations
(assert	(forall ((c TaskConcretization)) (=>
	(node CreateGraphs c)
	(not (node ProvideReputations c))
)))
;CreateGraphs is Distinct from ModerationARS
(assert	(forall ((c TaskConcretization)) (=>
	(node CreateGraphs c)
	(not (node ModerationARS c))
)))
;CreateGraphs is Distinct from TrackAuthorship
(assert	(forall ((c TaskConcretization)) (=>
	(node CreateGraphs c)
	(not (node TrackAuthorship c))
)))
;CreateGraphs is Distinct from DisplayGraphs
(assert	(forall ((c TaskConcretization)) (=>
	(node CreateGraphs c)
	(not (node DisplayGraphs c))
)))
;CreateGraphs is Distinct from TrackRevisions
(assert	(forall ((c TaskConcretization)) (=>
	(node CreateGraphs c)
	(not (node TrackRevisions c))
)))
;CreateGraphs is Distinct from BeInflo
(assert	(forall ((c TaskConcretization)) (=>
	(node CreateGraphs c)
	(not (node BeInflo c))
)))
;CreateGraphs is Distinct from ModerationTasks
(assert	(forall ((c TaskConcretization)) (=>
	(node CreateGraphs c)
	(not (node ModerationTasks c))
)))

;BeInflo initial analysis tag
(assert (forall ((c TaskConcretization)) (=>
	(node BeInflo c)
	(= (inited c) false)
)))
;BeInflo Exists
(assert	(exists ((c TaskConcretization)) (node BeInflo c)))
;BeInflo is Unique
(assert	(forall ((c1 TaskConcretization) (c2 TaskConcretization)) (=>
	(and (node BeInflo c1) (node BeInflo c2))
	(= c1 c2)
)))
;BeInflo is Distinct from Browsing
(assert	(forall ((c TaskConcretization)) (=>
	(node BeInflo c)
	(not (node Browsing c))
)))
;BeInflo is Distinct from CreateGraph
(assert	(forall ((c TaskConcretization)) (=>
	(node BeInflo c)
	(not (node CreateGraph c))
)))
;BeInflo is Distinct from UseDiscussions
(assert	(forall ((c TaskConcretization)) (=>
	(node BeInflo c)
	(not (node UseDiscussions c))
)))
;BeInflo is Distinct from MakeViews
(assert	(forall ((c TaskConcretization)) (=>
	(node BeInflo c)
	(not (node MakeViews c))
)))
;BeInflo is Distinct from AddSourceInDescription
(assert	(forall ((c TaskConcretization)) (=>
	(node BeInflo c)
	(not (node AddSourceInDescription c))
)))
;BeInflo is Distinct from CreateDiscussions
(assert	(forall ((c TaskConcretization)) (=>
	(node BeInflo c)
	(not (node CreateDiscussions c))
)))
;BeInflo is Distinct from ExtensiveModeration
(assert	(forall ((c TaskConcretization)) (=>
	(node BeInflo c)
	(not (node ExtensiveModeration c))
)))
;BeInflo is Distinct from UseAutomatedReputationSystem
(assert	(forall ((c TaskConcretization)) (=>
	(node BeInflo c)
	(not (node UseAutomatedReputationSystem c))
)))
;BeInflo is Distinct from LessExtensiveModeration
(assert	(forall ((c TaskConcretization)) (=>
	(node BeInflo c)
	(not (node LessExtensiveModeration c))
)))
;BeInflo is Distinct from ProvideReputations
(assert	(forall ((c TaskConcretization)) (=>
	(node BeInflo c)
	(not (node ProvideReputations c))
)))
;BeInflo is Distinct from ModerationARS
(assert	(forall ((c TaskConcretization)) (=>
	(node BeInflo c)
	(not (node ModerationARS c))
)))
;BeInflo is Distinct from TrackAuthorship
(assert	(forall ((c TaskConcretization)) (=>
	(node BeInflo c)
	(not (node TrackAuthorship c))
)))
;BeInflo is Distinct from DisplayGraphs
(assert	(forall ((c TaskConcretization)) (=>
	(node BeInflo c)
	(not (node DisplayGraphs c))
)))
;BeInflo is Distinct from TrackRevisions
(assert	(forall ((c TaskConcretization)) (=>
	(node BeInflo c)
	(not (node TrackRevisions c))
)))
;BeInflo is Distinct from CreateGraphs
(assert	(forall ((c TaskConcretization)) (=>
	(node BeInflo c)
	(not (node CreateGraphs c))
)))
;BeInflo is Distinct from ModerationTasks
(assert	(forall ((c TaskConcretization)) (=>
	(node BeInflo c)
	(not (node ModerationTasks c))
)))

;ModerationTasks initial analysis tag
(assert (forall ((c TaskConcretization)) (=>
	(node ModerationTasks c)
	(and
		(= (fs c) false)
		(= (ps c) false)
		(= (un c) false)
		(= (co c) false)
		(= (pd c) false)
		(= (fd c) true)
		(= (n c) false)
		(= (inited c) true)
	)
)))
;ModerationTasks is Unique
(assert	(forall ((c1 TaskConcretization) (c2 TaskConcretization)) (=>
	(and (node ModerationTasks c1) (node ModerationTasks c2))
	(= c1 c2)
)))
;ModerationTasks is Distinct from Browsing
(assert	(forall ((c TaskConcretization)) (=>
	(node ModerationTasks c)
	(not (node Browsing c))
)))
;ModerationTasks is Distinct from CreateGraph
(assert	(forall ((c TaskConcretization)) (=>
	(node ModerationTasks c)
	(not (node CreateGraph c))
)))
;ModerationTasks is Distinct from UseDiscussions
(assert	(forall ((c TaskConcretization)) (=>
	(node ModerationTasks c)
	(not (node UseDiscussions c))
)))
;ModerationTasks is Distinct from MakeViews
(assert	(forall ((c TaskConcretization)) (=>
	(node ModerationTasks c)
	(not (node MakeViews c))
)))
;ModerationTasks is Distinct from AddSourceInDescription
(assert	(forall ((c TaskConcretization)) (=>
	(node ModerationTasks c)
	(not (node AddSourceInDescription c))
)))
;ModerationTasks is Distinct from CreateDiscussions
(assert	(forall ((c TaskConcretization)) (=>
	(node ModerationTasks c)
	(not (node CreateDiscussions c))
)))
;ModerationTasks is Distinct from ExtensiveModeration
(assert	(forall ((c TaskConcretization)) (=>
	(node ModerationTasks c)
	(not (node ExtensiveModeration c))
)))
;ModerationTasks is Distinct from UseAutomatedReputationSystem
(assert	(forall ((c TaskConcretization)) (=>
	(node ModerationTasks c)
	(not (node UseAutomatedReputationSystem c))
)))
;ModerationTasks is Distinct from LessExtensiveModeration
(assert	(forall ((c TaskConcretization)) (=>
	(node ModerationTasks c)
	(not (node LessExtensiveModeration c))
)))
;ModerationTasks is Distinct from ProvideReputations
(assert	(forall ((c TaskConcretization)) (=>
	(node ModerationTasks c)
	(not (node ProvideReputations c))
)))
;ModerationTasks is Distinct from ModerationARS
(assert	(forall ((c TaskConcretization)) (=>
	(node ModerationTasks c)
	(not (node ModerationARS c))
)))
;ModerationTasks is Distinct from TrackAuthorship
(assert	(forall ((c TaskConcretization)) (=>
	(node ModerationTasks c)
	(not (node TrackAuthorship c))
)))
;ModerationTasks is Distinct from DisplayGraphs
(assert	(forall ((c TaskConcretization)) (=>
	(node ModerationTasks c)
	(not (node DisplayGraphs c))
)))
;ModerationTasks is Distinct from TrackRevisions
(assert	(forall ((c TaskConcretization)) (=>
	(node ModerationTasks c)
	(not (node TrackRevisions c))
)))
;ModerationTasks is Distinct from CreateGraphs
(assert	(forall ((c TaskConcretization)) (=>
	(node ModerationTasks c)
	(not (node CreateGraphs c))
)))
;ModerationTasks is Distinct from BeInflo
(assert	(forall ((c TaskConcretization)) (=>
	(node ModerationTasks c)
	(not (node BeInflo c))
)))

;UseInflo initial analysis tag
(assert (forall ((c GoalConcretization)) (=>
	(node UseInflo c)
	(= (inited c) false)
)))
;UseInflo Exists
(assert	(exists ((c GoalConcretization)) (node UseInflo c)))
;UseInflo is Unique
(assert	(forall ((c1 GoalConcretization) (c2 GoalConcretization)) (=>
	(and (node UseInflo c1) (node UseInflo c2))
	(= c1 c2)
)))
;UseInflo is Distinct from ModerateInflo
(assert	(forall ((c GoalConcretization)) (=>
	(node UseInflo c)
	(not (node ModerateInflo c))
)))
;UseInflo is Distinct from AllowModeration
(assert	(forall ((c GoalConcretization)) (=>
	(node UseInflo c)
	(not (node AllowModeration c))
)))
;UseInflo is Distinct from InfloBeModerated
(assert	(forall ((c GoalConcretization)) (=>
	(node UseInflo c)
	(not (node InfloBeModerated c))
)))

;InfloBeModerated initial analysis tag
(assert (forall ((c GoalConcretization)) (=>
	(node InfloBeModerated c)
	(= (inited c) false)
)))
;InfloBeModerated Exists
(assert	(exists ((c GoalConcretization)) (node InfloBeModerated c)))
;InfloBeModerated is Unique
(assert	(forall ((c1 GoalConcretization) (c2 GoalConcretization)) (=>
	(and (node InfloBeModerated c1) (node InfloBeModerated c2))
	(= c1 c2)
)))
;InfloBeModerated is Distinct from ModerateInflo
(assert	(forall ((c GoalConcretization)) (=>
	(node InfloBeModerated c)
	(not (node ModerateInflo c))
)))
;InfloBeModerated is Distinct from AllowModeration
(assert	(forall ((c GoalConcretization)) (=>
	(node InfloBeModerated c)
	(not (node AllowModeration c))
)))
;InfloBeModerated is Distinct from UseInflo
(assert	(forall ((c GoalConcretization)) (=>
	(node InfloBeModerated c)
	(not (node UseInflo c))
)))

;ModerateInflo initial analysis tag
(assert (forall ((c GoalConcretization)) (=>
	(node ModerateInflo c)
	(= (inited c) false)
)))
;ModerateInflo Exists
(assert	(exists ((c GoalConcretization)) (node ModerateInflo c)))
;ModerateInflo is Unique
(assert	(forall ((c1 GoalConcretization) (c2 GoalConcretization)) (=>
	(and (node ModerateInflo c1) (node ModerateInflo c2))
	(= c1 c2)
)))
;ModerateInflo is Distinct from UseInflo
(assert	(forall ((c GoalConcretization)) (=>
	(node ModerateInflo c)
	(not (node UseInflo c))
)))
;ModerateInflo is Distinct from InfloBeModerated
(assert	(forall ((c GoalConcretization)) (=>
	(node ModerateInflo c)
	(not (node InfloBeModerated c))
)))
;ModerateInflo is Distinct from AllowModeration
(assert	(forall ((c GoalConcretization)) (=>
	(node ModerateInflo c)
	(not (node AllowModeration c))
)))

;AllowModeration initial analysis tag
(assert (forall ((c GoalConcretization)) (=>
	(node AllowModeration c)
	(= (inited c) false)
)))
;AllowModeration Exists
(assert	(exists ((c GoalConcretization)) (node AllowModeration c)))
;AllowModeration is Unique
(assert	(forall ((c1 GoalConcretization) (c2 GoalConcretization)) (=>
	(and (node AllowModeration c1) (node AllowModeration c2))
	(= c1 c2)
)))
;AllowModeration is Distinct from UseInflo
(assert	(forall ((c GoalConcretization)) (=>
	(node AllowModeration c)
	(not (node UseInflo c))
)))
;AllowModeration is Distinct from InfloBeModerated
(assert	(forall ((c GoalConcretization)) (=>
	(node AllowModeration c)
	(not (node InfloBeModerated c))
)))
;AllowModeration is Distinct from ModerateInflo
(assert	(forall ((c GoalConcretization)) (=>
	(node AllowModeration c)
	(not (node ModerateInflo c))
)))

;MakeModelsTrustworthy initial analysis tag
(assert (forall ((c SoftGoalConcretization)) (=>
	(node MakeModelsTrustworthy c)
	(= (inited c) false)
)))
;MakeModelsTrustworthy Exists
(assert	(exists ((c SoftGoalConcretization)) (node MakeModelsTrustworthy c)))
;MakeModelsTrustworthy is Unique
(assert	(forall ((c1 SoftGoalConcretization) (c2 SoftGoalConcretization)) (=>
	(and (node MakeModelsTrustworthy c1) (node MakeModelsTrustworthy c2))
	(= c1 c2)
)))

;ValidateModel initial analysis tag
(assert (forall ((c SoftGoalConcretization)) (=>
	(node ValidateModel c)
	(= (inited c) false)
)))
;ValidateModel Exists
(assert	(exists ((c SoftGoalConcretization)) (node ValidateModel c)))
;ValidateModel is Unique
(assert	(forall ((c1 SoftGoalConcretization) (c2 SoftGoalConcretization)) (=>
	(and (node ValidateModel c1) (node ValidateModel c2))
	(= c1 c2)
)))

;GetFeedback initial analysis tag
(assert (forall ((c SoftGoalConcretization)) (=>
	(node GetFeedback c)
	(= (inited c) false)
)))
;GetFeedback Exists
(assert	(exists ((c SoftGoalConcretization)) (node GetFeedback c)))
;GetFeedback is Unique
(assert	(forall ((c1 SoftGoalConcretization) (c2 SoftGoalConcretization)) (=>
	(and (node GetFeedback c1) (node GetFeedback c2))
	(= c1 c2)
)))

;Moderation initial analysis tag
(assert (forall ((c ResourceConcretization)) (=>
	(node Moderation c)
	(= (inited c) false)
)))
;Moderation Exists
(assert	(exists ((c ResourceConcretization)) (node Moderation c)))
;Moderation is Unique
(assert	(forall ((c1 ResourceConcretization) (c2 ResourceConcretization)) (=>
	(and (node Moderation c1) (node Moderation c2))
	(= c1 c2)
)))
;Moderation is Distinct from Graphing
(assert	(forall ((c ResourceConcretization)) (=>
	(node Moderation c)
	(not (node Graphing c))
)))
;Moderation is Distinct from ReputationValues
(assert	(forall ((c ResourceConcretization)) (=>
	(node Moderation c)
	(not (node ReputationValues c))
)))
;Moderation is Distinct from Info
(assert	(forall ((c ResourceConcretization)) (=>
	(node Moderation c)
	(not (node Info c))
)))
;Moderation is Distinct from Authorship
(assert	(forall ((c ResourceConcretization)) (=>
	(node Moderation c)
	(not (node Authorship c))
)))

;Graphing initial analysis tag
(assert (forall ((c ResourceConcretization)) (=>
	(node Graphing c)
	(= (inited c) false)
)))
;Graphing Exists
(assert	(exists ((c ResourceConcretization)) (node Graphing c)))
;Graphing is Unique
(assert	(forall ((c1 ResourceConcretization) (c2 ResourceConcretization)) (=>
	(and (node Graphing c1) (node Graphing c2))
	(= c1 c2)
)))
;Graphing is Distinct from Moderation
(assert	(forall ((c ResourceConcretization)) (=>
	(node Graphing c)
	(not (node Moderation c))
)))
;Graphing is Distinct from ReputationValues
(assert	(forall ((c ResourceConcretization)) (=>
	(node Graphing c)
	(not (node ReputationValues c))
)))
;Graphing is Distinct from Info
(assert	(forall ((c ResourceConcretization)) (=>
	(node Graphing c)
	(not (node Info c))
)))
;Graphing is Distinct from Authorship
(assert	(forall ((c ResourceConcretization)) (=>
	(node Graphing c)
	(not (node Authorship c))
)))

;ReputationValues initial analysis tag
(assert (forall ((c ResourceConcretization)) (=>
	(node ReputationValues c)
	(= (inited c) false)
)))
;ReputationValues Exists
(assert	(exists ((c ResourceConcretization)) (node ReputationValues c)))
;ReputationValues is Unique
(assert	(forall ((c1 ResourceConcretization) (c2 ResourceConcretization)) (=>
	(and (node ReputationValues c1) (node ReputationValues c2))
	(= c1 c2)
)))
;ReputationValues is Distinct from Moderation
(assert	(forall ((c ResourceConcretization)) (=>
	(node ReputationValues c)
	(not (node Moderation c))
)))
;ReputationValues is Distinct from Graphing
(assert	(forall ((c ResourceConcretization)) (=>
	(node ReputationValues c)
	(not (node Graphing c))
)))
;ReputationValues is Distinct from Info
(assert	(forall ((c ResourceConcretization)) (=>
	(node ReputationValues c)
	(not (node Info c))
)))
;ReputationValues is Distinct from Authorship
(assert	(forall ((c ResourceConcretization)) (=>
	(node ReputationValues c)
	(not (node Authorship c))
)))

;Info initial analysis tag
(assert (forall ((c ResourceConcretization)) (=>
	(node Info c)
	(and
		(= (fs c) true)
		(= (ps c) false)
		(= (un c) false)
		(= (co c) false)
		(= (pd c) false)
		(= (fd c) false)
		(= (n c) false)
		(= (inited c) true)
	)
)))
;Info Exists
(assert	(exists ((c ResourceConcretization)) (node Info c)))
;Info is Unique
(assert	(forall ((c1 ResourceConcretization) (c2 ResourceConcretization)) (=>
	(and (node Info c1) (node Info c2))
	(= c1 c2)
)))
;Info is Distinct from Moderation
(assert	(forall ((c ResourceConcretization)) (=>
	(node Info c)
	(not (node Moderation c))
)))
;Info is Distinct from Graphing
(assert	(forall ((c ResourceConcretization)) (=>
	(node Info c)
	(not (node Graphing c))
)))
;Info is Distinct from ReputationValues
(assert	(forall ((c ResourceConcretization)) (=>
	(node Info c)
	(not (node ReputationValues c))
)))
;Info is Distinct from Authorship
(assert	(forall ((c ResourceConcretization)) (=>
	(node Info c)
	(not (node Authorship c))
)))

;Authorship initial analysis tag
(assert (forall ((c ResourceConcretization)) (=>
	(node Authorship c)
	(= (inited c) false)
)))
;Authorship is Unique
(assert	(forall ((c1 ResourceConcretization) (c2 ResourceConcretization)) (=>
	(and (node Authorship c1) (node Authorship c2))
	(= c1 c2)
)))
;Authorship is Distinct from Moderation
(assert	(forall ((c ResourceConcretization)) (=>
	(node Authorship c)
	(not (node Moderation c))
)))
;Authorship is Distinct from Graphing
(assert	(forall ((c ResourceConcretization)) (=>
	(node Authorship c)
	(not (node Graphing c))
)))
;Authorship is Distinct from ReputationValues
(assert	(forall ((c ResourceConcretization)) (=>
	(node Authorship c)
	(not (node ReputationValues c))
)))
;Authorship is Distinct from Info
(assert	(forall ((c ResourceConcretization)) (=>
	(node Authorship c)
	(not (node Info c))
)))

;InfloUser2MakeModelsTrustworthy tgtEndpoint constant
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2MakeModelsTrustworthy c)
	(= (tgtEndpoint c) ENDPOINT_SOFTGOAL)
)))
;InfloUser2MakeModelsTrustworthy endpoints
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2MakeModelsTrustworthy c)
	(and
		(node InfloUser (src c))
		(node MakeModelsTrustworthy ((as tgt (SoftGoalConcretization)) c))
	)
)))
;InfloUser2MakeModelsTrustworthy Exists
(assert	(exists ((c IntentionalElementConcretization)) (edge InfloUser2MakeModelsTrustworthy c)))
;InfloUser2MakeModelsTrustworthy is Unique
(assert	(forall ((c1 IntentionalElementConcretization) (c2 IntentionalElementConcretization)) (=>
	(and (edge InfloUser2MakeModelsTrustworthy c1) (edge InfloUser2MakeModelsTrustworthy c2))
	(= c1 c2)
)))
;InfloUser2UseInflo tgtEndpoint constant
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2UseInflo c)
	(= (tgtEndpoint c) ENDPOINT_GOAL)
)))
;InfloUser2UseInflo endpoints
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2UseInflo c)
	(and
		(node InfloUser (src c))
		(node UseInflo ((as tgt (GoalConcretization)) c))
	)
)))
;InfloUser2UseInflo Exists
(assert	(exists ((c IntentionalElementConcretization)) (edge InfloUser2UseInflo c)))
;InfloUser2UseInflo is Unique
(assert	(forall ((c1 IntentionalElementConcretization) (c2 IntentionalElementConcretization)) (=>
	(and (edge InfloUser2UseInflo c1) (edge InfloUser2UseInflo c2))
	(= c1 c2)
)))
;InfloUser2UseInflo is Distinct from InfloManagerEditors2ModerateInflo
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2UseInflo c)
	(not (edge InfloManagerEditors2ModerateInflo c))
)))
;InfloUser2UseInflo is Distinct from Inflo2AllowModeration
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2UseInflo c)
	(not (edge Inflo2AllowModeration c))
)))
;InfloUser2UseInflo is Distinct from InfloUser2InfloBeModerated
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2UseInflo c)
	(not (edge InfloUser2InfloBeModerated c))
)))
;InfloUser2ValidateModel tgtEndpoint constant
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2ValidateModel c)
	(= (tgtEndpoint c) ENDPOINT_SOFTGOAL)
)))
;InfloUser2ValidateModel endpoints
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2ValidateModel c)
	(and
		(node InfloUser (src c))
		(node ValidateModel ((as tgt (SoftGoalConcretization)) c))
	)
)))
;InfloUser2ValidateModel Exists
(assert	(exists ((c IntentionalElementConcretization)) (edge InfloUser2ValidateModel c)))
;InfloUser2ValidateModel is Unique
(assert	(forall ((c1 IntentionalElementConcretization) (c2 IntentionalElementConcretization)) (=>
	(and (edge InfloUser2ValidateModel c1) (edge InfloUser2ValidateModel c2))
	(= c1 c2)
)))
;InfloUser2GetFeedback tgtEndpoint constant
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2GetFeedback c)
	(= (tgtEndpoint c) ENDPOINT_SOFTGOAL)
)))
;InfloUser2GetFeedback endpoints
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2GetFeedback c)
	(and
		(node InfloUser (src c))
		(node GetFeedback ((as tgt (SoftGoalConcretization)) c))
	)
)))
;InfloUser2GetFeedback Exists
(assert	(exists ((c IntentionalElementConcretization)) (edge InfloUser2GetFeedback c)))
;InfloUser2GetFeedback is Unique
(assert	(forall ((c1 IntentionalElementConcretization) (c2 IntentionalElementConcretization)) (=>
	(and (edge InfloUser2GetFeedback c1) (edge InfloUser2GetFeedback c2))
	(= c1 c2)
)))
;InfloUser2Browsing tgtEndpoint constant
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2Browsing c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;InfloUser2Browsing endpoints
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2Browsing c)
	(and
		(node InfloUser (src c))
		(node Browsing ((as tgt (TaskConcretization)) c))
	)
)))
;InfloUser2Browsing Exists
(assert	(exists ((c IntentionalElementConcretization)) (edge InfloUser2Browsing c)))
;InfloUser2Browsing is Unique
(assert	(forall ((c1 IntentionalElementConcretization) (c2 IntentionalElementConcretization)) (=>
	(and (edge InfloUser2Browsing c1) (edge InfloUser2Browsing c2))
	(= c1 c2)
)))
;InfloUser2Browsing is Distinct from InfloManagerEditors2ExtensiveModeration
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2Browsing c)
	(not (edge InfloManagerEditors2ExtensiveModeration c))
)))
;InfloUser2Browsing is Distinct from InfloManagerEditors2UseAutomatedReputationSystem
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2Browsing c)
	(not (edge InfloManagerEditors2UseAutomatedReputationSystem c))
)))
;InfloUser2Browsing is Distinct from InfloManagerEditors2LessExtensiveModeration
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2Browsing c)
	(not (edge InfloManagerEditors2LessExtensiveModeration c))
)))
;InfloUser2Browsing is Distinct from AutomatedReputationSystem2ProvideReputations
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2Browsing c)
	(not (edge AutomatedReputationSystem2ProvideReputations c))
)))
;InfloUser2Browsing is Distinct from AutomatedReputationSystem2ModerationARS
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2Browsing c)
	(not (edge AutomatedReputationSystem2ModerationARS c))
)))
;InfloUser2Browsing is Distinct from Inflo2TrackAuthorship
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2Browsing c)
	(not (edge Inflo2TrackAuthorship c))
)))
;InfloUser2Browsing is Distinct from Inflo2DisplayGraphs
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2Browsing c)
	(not (edge Inflo2DisplayGraphs c))
)))
;InfloUser2Browsing is Distinct from Inflo2TrackRevisions
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2Browsing c)
	(not (edge Inflo2TrackRevisions c))
)))
;InfloUser2Browsing is Distinct from Inflo2CreateGraphs
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2Browsing c)
	(not (edge Inflo2CreateGraphs c))
)))
;InfloUser2Browsing is Distinct from Inflo2BeInflo
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2Browsing c)
	(not (edge Inflo2BeInflo c))
)))
;InfloUser2Browsing is Distinct from Inflo2ModerationTasks
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2Browsing c)
	(not (edge Inflo2ModerationTasks c))
)))
;InfloUser2Browsing is Distinct from InfloUser2CreateGraph
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2Browsing c)
	(not (edge InfloUser2CreateGraph c))
)))
;InfloUser2Browsing is Distinct from InfloUser2UseDiscussions
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2Browsing c)
	(not (edge InfloUser2UseDiscussions c))
)))
;InfloUser2Browsing is Distinct from InfloUser2MakeViews
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2Browsing c)
	(not (edge InfloUser2MakeViews c))
)))
;InfloUser2Browsing is Distinct from InfloUser2AddSourceInDescription
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2Browsing c)
	(not (edge InfloUser2AddSourceInDescription c))
)))
;InfloUser2CreateGraph tgtEndpoint constant
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2CreateGraph c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;InfloUser2CreateGraph endpoints
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2CreateGraph c)
	(and
		(node InfloUser (src c))
		(node CreateGraph ((as tgt (TaskConcretization)) c))
	)
)))
;InfloUser2CreateGraph Exists
(assert	(exists ((c IntentionalElementConcretization)) (edge InfloUser2CreateGraph c)))
;InfloUser2CreateGraph is Unique
(assert	(forall ((c1 IntentionalElementConcretization) (c2 IntentionalElementConcretization)) (=>
	(and (edge InfloUser2CreateGraph c1) (edge InfloUser2CreateGraph c2))
	(= c1 c2)
)))
;InfloUser2CreateGraph is Distinct from InfloManagerEditors2ExtensiveModeration
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2CreateGraph c)
	(not (edge InfloManagerEditors2ExtensiveModeration c))
)))
;InfloUser2CreateGraph is Distinct from InfloManagerEditors2UseAutomatedReputationSystem
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2CreateGraph c)
	(not (edge InfloManagerEditors2UseAutomatedReputationSystem c))
)))
;InfloUser2CreateGraph is Distinct from InfloManagerEditors2LessExtensiveModeration
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2CreateGraph c)
	(not (edge InfloManagerEditors2LessExtensiveModeration c))
)))
;InfloUser2CreateGraph is Distinct from AutomatedReputationSystem2ProvideReputations
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2CreateGraph c)
	(not (edge AutomatedReputationSystem2ProvideReputations c))
)))
;InfloUser2CreateGraph is Distinct from AutomatedReputationSystem2ModerationARS
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2CreateGraph c)
	(not (edge AutomatedReputationSystem2ModerationARS c))
)))
;InfloUser2CreateGraph is Distinct from Inflo2TrackAuthorship
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2CreateGraph c)
	(not (edge Inflo2TrackAuthorship c))
)))
;InfloUser2CreateGraph is Distinct from Inflo2DisplayGraphs
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2CreateGraph c)
	(not (edge Inflo2DisplayGraphs c))
)))
;InfloUser2CreateGraph is Distinct from Inflo2TrackRevisions
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2CreateGraph c)
	(not (edge Inflo2TrackRevisions c))
)))
;InfloUser2CreateGraph is Distinct from Inflo2CreateGraphs
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2CreateGraph c)
	(not (edge Inflo2CreateGraphs c))
)))
;InfloUser2CreateGraph is Distinct from Inflo2BeInflo
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2CreateGraph c)
	(not (edge Inflo2BeInflo c))
)))
;InfloUser2CreateGraph is Distinct from Inflo2ModerationTasks
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2CreateGraph c)
	(not (edge Inflo2ModerationTasks c))
)))
;InfloUser2CreateGraph is Distinct from InfloUser2Browsing
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2CreateGraph c)
	(not (edge InfloUser2Browsing c))
)))
;InfloUser2CreateGraph is Distinct from InfloUser2UseDiscussions
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2CreateGraph c)
	(not (edge InfloUser2UseDiscussions c))
)))
;InfloUser2CreateGraph is Distinct from InfloUser2MakeViews
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2CreateGraph c)
	(not (edge InfloUser2MakeViews c))
)))
;InfloUser2CreateGraph is Distinct from InfloUser2AddSourceInDescription
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2CreateGraph c)
	(not (edge InfloUser2AddSourceInDescription c))
)))
;InfloUser2UseDiscussions tgtEndpoint constant
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2UseDiscussions c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;InfloUser2UseDiscussions endpoints
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2UseDiscussions c)
	(and
		(node InfloUser (src c))
		(node UseDiscussions ((as tgt (TaskConcretization)) c))
	)
)))
;InfloUser2UseDiscussions Exists
(assert	(exists ((c IntentionalElementConcretization)) (edge InfloUser2UseDiscussions c)))
;InfloUser2UseDiscussions is Unique
(assert	(forall ((c1 IntentionalElementConcretization) (c2 IntentionalElementConcretization)) (=>
	(and (edge InfloUser2UseDiscussions c1) (edge InfloUser2UseDiscussions c2))
	(= c1 c2)
)))
;InfloUser2UseDiscussions is Distinct from InfloManagerEditors2ExtensiveModeration
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2UseDiscussions c)
	(not (edge InfloManagerEditors2ExtensiveModeration c))
)))
;InfloUser2UseDiscussions is Distinct from InfloManagerEditors2UseAutomatedReputationSystem
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2UseDiscussions c)
	(not (edge InfloManagerEditors2UseAutomatedReputationSystem c))
)))
;InfloUser2UseDiscussions is Distinct from InfloManagerEditors2LessExtensiveModeration
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2UseDiscussions c)
	(not (edge InfloManagerEditors2LessExtensiveModeration c))
)))
;InfloUser2UseDiscussions is Distinct from AutomatedReputationSystem2ProvideReputations
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2UseDiscussions c)
	(not (edge AutomatedReputationSystem2ProvideReputations c))
)))
;InfloUser2UseDiscussions is Distinct from AutomatedReputationSystem2ModerationARS
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2UseDiscussions c)
	(not (edge AutomatedReputationSystem2ModerationARS c))
)))
;InfloUser2UseDiscussions is Distinct from Inflo2TrackAuthorship
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2UseDiscussions c)
	(not (edge Inflo2TrackAuthorship c))
)))
;InfloUser2UseDiscussions is Distinct from Inflo2DisplayGraphs
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2UseDiscussions c)
	(not (edge Inflo2DisplayGraphs c))
)))
;InfloUser2UseDiscussions is Distinct from Inflo2TrackRevisions
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2UseDiscussions c)
	(not (edge Inflo2TrackRevisions c))
)))
;InfloUser2UseDiscussions is Distinct from Inflo2CreateGraphs
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2UseDiscussions c)
	(not (edge Inflo2CreateGraphs c))
)))
;InfloUser2UseDiscussions is Distinct from Inflo2BeInflo
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2UseDiscussions c)
	(not (edge Inflo2BeInflo c))
)))
;InfloUser2UseDiscussions is Distinct from Inflo2ModerationTasks
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2UseDiscussions c)
	(not (edge Inflo2ModerationTasks c))
)))
;InfloUser2UseDiscussions is Distinct from InfloUser2Browsing
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2UseDiscussions c)
	(not (edge InfloUser2Browsing c))
)))
;InfloUser2UseDiscussions is Distinct from InfloUser2CreateGraph
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2UseDiscussions c)
	(not (edge InfloUser2CreateGraph c))
)))
;InfloUser2UseDiscussions is Distinct from InfloUser2MakeViews
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2UseDiscussions c)
	(not (edge InfloUser2MakeViews c))
)))
;InfloUser2UseDiscussions is Distinct from InfloUser2AddSourceInDescription
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2UseDiscussions c)
	(not (edge InfloUser2AddSourceInDescription c))
)))
;InfloUser2InfloBeModerated tgtEndpoint constant
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2InfloBeModerated c)
	(= (tgtEndpoint c) ENDPOINT_GOAL)
)))
;InfloUser2InfloBeModerated endpoints
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2InfloBeModerated c)
	(and
		(node InfloUser (src c))
		(node InfloBeModerated ((as tgt (GoalConcretization)) c))
	)
)))
;InfloUser2InfloBeModerated Exists
(assert	(exists ((c IntentionalElementConcretization)) (edge InfloUser2InfloBeModerated c)))
;InfloUser2InfloBeModerated is Unique
(assert	(forall ((c1 IntentionalElementConcretization) (c2 IntentionalElementConcretization)) (=>
	(and (edge InfloUser2InfloBeModerated c1) (edge InfloUser2InfloBeModerated c2))
	(= c1 c2)
)))
;InfloUser2InfloBeModerated is Distinct from InfloManagerEditors2ModerateInflo
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2InfloBeModerated c)
	(not (edge InfloManagerEditors2ModerateInflo c))
)))
;InfloUser2InfloBeModerated is Distinct from Inflo2AllowModeration
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2InfloBeModerated c)
	(not (edge Inflo2AllowModeration c))
)))
;InfloUser2InfloBeModerated is Distinct from InfloUser2UseInflo
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2InfloBeModerated c)
	(not (edge InfloUser2UseInflo c))
)))
;InfloUser2MakeViews tgtEndpoint constant
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2MakeViews c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;InfloUser2MakeViews endpoints
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2MakeViews c)
	(and
		(node InfloUser (src c))
		(node MakeViews ((as tgt (TaskConcretization)) c))
	)
)))
;InfloUser2MakeViews Exists
(assert	(exists ((c IntentionalElementConcretization)) (edge InfloUser2MakeViews c)))
;InfloUser2MakeViews is Unique
(assert	(forall ((c1 IntentionalElementConcretization) (c2 IntentionalElementConcretization)) (=>
	(and (edge InfloUser2MakeViews c1) (edge InfloUser2MakeViews c2))
	(= c1 c2)
)))
;InfloUser2MakeViews is Distinct from InfloManagerEditors2ExtensiveModeration
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2MakeViews c)
	(not (edge InfloManagerEditors2ExtensiveModeration c))
)))
;InfloUser2MakeViews is Distinct from InfloManagerEditors2UseAutomatedReputationSystem
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2MakeViews c)
	(not (edge InfloManagerEditors2UseAutomatedReputationSystem c))
)))
;InfloUser2MakeViews is Distinct from InfloManagerEditors2LessExtensiveModeration
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2MakeViews c)
	(not (edge InfloManagerEditors2LessExtensiveModeration c))
)))
;InfloUser2MakeViews is Distinct from AutomatedReputationSystem2ProvideReputations
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2MakeViews c)
	(not (edge AutomatedReputationSystem2ProvideReputations c))
)))
;InfloUser2MakeViews is Distinct from AutomatedReputationSystem2ModerationARS
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2MakeViews c)
	(not (edge AutomatedReputationSystem2ModerationARS c))
)))
;InfloUser2MakeViews is Distinct from Inflo2TrackAuthorship
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2MakeViews c)
	(not (edge Inflo2TrackAuthorship c))
)))
;InfloUser2MakeViews is Distinct from Inflo2DisplayGraphs
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2MakeViews c)
	(not (edge Inflo2DisplayGraphs c))
)))
;InfloUser2MakeViews is Distinct from Inflo2TrackRevisions
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2MakeViews c)
	(not (edge Inflo2TrackRevisions c))
)))
;InfloUser2MakeViews is Distinct from Inflo2CreateGraphs
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2MakeViews c)
	(not (edge Inflo2CreateGraphs c))
)))
;InfloUser2MakeViews is Distinct from Inflo2BeInflo
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2MakeViews c)
	(not (edge Inflo2BeInflo c))
)))
;InfloUser2MakeViews is Distinct from Inflo2ModerationTasks
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2MakeViews c)
	(not (edge Inflo2ModerationTasks c))
)))
;InfloUser2MakeViews is Distinct from InfloUser2Browsing
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2MakeViews c)
	(not (edge InfloUser2Browsing c))
)))
;InfloUser2MakeViews is Distinct from InfloUser2CreateGraph
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2MakeViews c)
	(not (edge InfloUser2CreateGraph c))
)))
;InfloUser2MakeViews is Distinct from InfloUser2UseDiscussions
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2MakeViews c)
	(not (edge InfloUser2UseDiscussions c))
)))
;InfloUser2MakeViews is Distinct from InfloUser2AddSourceInDescription
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2MakeViews c)
	(not (edge InfloUser2AddSourceInDescription c))
)))
;InfloUser2AddSourceInDescription tgtEndpoint constant
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2AddSourceInDescription c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;InfloUser2AddSourceInDescription endpoints
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2AddSourceInDescription c)
	(and
		(node InfloUser (src c))
		(node AddSourceInDescription ((as tgt (TaskConcretization)) c))
	)
)))
;InfloUser2AddSourceInDescription Exists
(assert	(exists ((c IntentionalElementConcretization)) (edge InfloUser2AddSourceInDescription c)))
;InfloUser2AddSourceInDescription is Unique
(assert	(forall ((c1 IntentionalElementConcretization) (c2 IntentionalElementConcretization)) (=>
	(and (edge InfloUser2AddSourceInDescription c1) (edge InfloUser2AddSourceInDescription c2))
	(= c1 c2)
)))
;InfloUser2AddSourceInDescription is Distinct from InfloManagerEditors2ExtensiveModeration
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2AddSourceInDescription c)
	(not (edge InfloManagerEditors2ExtensiveModeration c))
)))
;InfloUser2AddSourceInDescription is Distinct from InfloManagerEditors2UseAutomatedReputationSystem
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2AddSourceInDescription c)
	(not (edge InfloManagerEditors2UseAutomatedReputationSystem c))
)))
;InfloUser2AddSourceInDescription is Distinct from InfloManagerEditors2LessExtensiveModeration
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2AddSourceInDescription c)
	(not (edge InfloManagerEditors2LessExtensiveModeration c))
)))
;InfloUser2AddSourceInDescription is Distinct from AutomatedReputationSystem2ProvideReputations
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2AddSourceInDescription c)
	(not (edge AutomatedReputationSystem2ProvideReputations c))
)))
;InfloUser2AddSourceInDescription is Distinct from AutomatedReputationSystem2ModerationARS
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2AddSourceInDescription c)
	(not (edge AutomatedReputationSystem2ModerationARS c))
)))
;InfloUser2AddSourceInDescription is Distinct from Inflo2TrackAuthorship
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2AddSourceInDescription c)
	(not (edge Inflo2TrackAuthorship c))
)))
;InfloUser2AddSourceInDescription is Distinct from Inflo2DisplayGraphs
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2AddSourceInDescription c)
	(not (edge Inflo2DisplayGraphs c))
)))
;InfloUser2AddSourceInDescription is Distinct from Inflo2TrackRevisions
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2AddSourceInDescription c)
	(not (edge Inflo2TrackRevisions c))
)))
;InfloUser2AddSourceInDescription is Distinct from Inflo2CreateGraphs
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2AddSourceInDescription c)
	(not (edge Inflo2CreateGraphs c))
)))
;InfloUser2AddSourceInDescription is Distinct from Inflo2BeInflo
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2AddSourceInDescription c)
	(not (edge Inflo2BeInflo c))
)))
;InfloUser2AddSourceInDescription is Distinct from Inflo2ModerationTasks
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2AddSourceInDescription c)
	(not (edge Inflo2ModerationTasks c))
)))
;InfloUser2AddSourceInDescription is Distinct from InfloUser2Browsing
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2AddSourceInDescription c)
	(not (edge InfloUser2Browsing c))
)))
;InfloUser2AddSourceInDescription is Distinct from InfloUser2CreateGraph
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2AddSourceInDescription c)
	(not (edge InfloUser2CreateGraph c))
)))
;InfloUser2AddSourceInDescription is Distinct from InfloUser2UseDiscussions
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2AddSourceInDescription c)
	(not (edge InfloUser2UseDiscussions c))
)))
;InfloUser2AddSourceInDescription is Distinct from InfloUser2MakeViews
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2AddSourceInDescription c)
	(not (edge InfloUser2MakeViews c))
)))
;InfloUser2CreateDiscussions tgtEndpoint constant
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2CreateDiscussions c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;InfloUser2CreateDiscussions endpoints
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2CreateDiscussions c)
	(and
		(node InfloUser (src c))
		(node CreateDiscussions ((as tgt (TaskConcretization)) c))
	)
)))
;InfloUser2CreateDiscussions is Unique
(assert	(forall ((c1 IntentionalElementConcretization) (c2 IntentionalElementConcretization)) (=>
	(and (edge InfloUser2CreateDiscussions c1) (edge InfloUser2CreateDiscussions c2))
	(= c1 c2)
)))
;InfloUser2CreateDiscussions is Distinct from InfloManagerEditors2ExtensiveModeration
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2CreateDiscussions c)
	(not (edge InfloManagerEditors2ExtensiveModeration c))
)))
;InfloUser2CreateDiscussions is Distinct from InfloManagerEditors2UseAutomatedReputationSystem
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2CreateDiscussions c)
	(not (edge InfloManagerEditors2UseAutomatedReputationSystem c))
)))
;InfloUser2CreateDiscussions is Distinct from InfloManagerEditors2LessExtensiveModeration
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2CreateDiscussions c)
	(not (edge InfloManagerEditors2LessExtensiveModeration c))
)))
;InfloUser2CreateDiscussions is Distinct from AutomatedReputationSystem2ProvideReputations
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2CreateDiscussions c)
	(not (edge AutomatedReputationSystem2ProvideReputations c))
)))
;InfloUser2CreateDiscussions is Distinct from AutomatedReputationSystem2ModerationARS
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2CreateDiscussions c)
	(not (edge AutomatedReputationSystem2ModerationARS c))
)))
;InfloUser2CreateDiscussions is Distinct from Inflo2TrackAuthorship
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2CreateDiscussions c)
	(not (edge Inflo2TrackAuthorship c))
)))
;InfloUser2CreateDiscussions is Distinct from Inflo2DisplayGraphs
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2CreateDiscussions c)
	(not (edge Inflo2DisplayGraphs c))
)))
;InfloUser2CreateDiscussions is Distinct from Inflo2TrackRevisions
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2CreateDiscussions c)
	(not (edge Inflo2TrackRevisions c))
)))
;InfloUser2CreateDiscussions is Distinct from Inflo2CreateGraphs
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2CreateDiscussions c)
	(not (edge Inflo2CreateGraphs c))
)))
;InfloUser2CreateDiscussions is Distinct from Inflo2BeInflo
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2CreateDiscussions c)
	(not (edge Inflo2BeInflo c))
)))
;InfloUser2CreateDiscussions is Distinct from Inflo2ModerationTasks
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloUser2CreateDiscussions c)
	(not (edge Inflo2ModerationTasks c))
)))
;InfloManagerEditors2ExtensiveModeration tgtEndpoint constant
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2ExtensiveModeration c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;InfloManagerEditors2ExtensiveModeration endpoints
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2ExtensiveModeration c)
	(and
		(node InfloManagerEditors (src c))
		(node ExtensiveModeration ((as tgt (TaskConcretization)) c))
	)
)))
;InfloManagerEditors2ExtensiveModeration Exists
(assert	(exists ((c IntentionalElementConcretization)) (edge InfloManagerEditors2ExtensiveModeration c)))
;InfloManagerEditors2ExtensiveModeration is Unique
(assert	(forall ((c1 IntentionalElementConcretization) (c2 IntentionalElementConcretization)) (=>
	(and (edge InfloManagerEditors2ExtensiveModeration c1) (edge InfloManagerEditors2ExtensiveModeration c2))
	(= c1 c2)
)))
;InfloManagerEditors2ExtensiveModeration is Distinct from InfloUser2Browsing
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2ExtensiveModeration c)
	(not (edge InfloUser2Browsing c))
)))
;InfloManagerEditors2ExtensiveModeration is Distinct from InfloUser2CreateGraph
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2ExtensiveModeration c)
	(not (edge InfloUser2CreateGraph c))
)))
;InfloManagerEditors2ExtensiveModeration is Distinct from InfloUser2UseDiscussions
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2ExtensiveModeration c)
	(not (edge InfloUser2UseDiscussions c))
)))
;InfloManagerEditors2ExtensiveModeration is Distinct from InfloUser2MakeViews
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2ExtensiveModeration c)
	(not (edge InfloUser2MakeViews c))
)))
;InfloManagerEditors2ExtensiveModeration is Distinct from InfloUser2AddSourceInDescription
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2ExtensiveModeration c)
	(not (edge InfloUser2AddSourceInDescription c))
)))
;InfloManagerEditors2ExtensiveModeration is Distinct from InfloUser2CreateDiscussions
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2ExtensiveModeration c)
	(not (edge InfloUser2CreateDiscussions c))
)))
;InfloManagerEditors2ExtensiveModeration is Distinct from AutomatedReputationSystem2ProvideReputations
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2ExtensiveModeration c)
	(not (edge AutomatedReputationSystem2ProvideReputations c))
)))
;InfloManagerEditors2ExtensiveModeration is Distinct from AutomatedReputationSystem2ModerationARS
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2ExtensiveModeration c)
	(not (edge AutomatedReputationSystem2ModerationARS c))
)))
;InfloManagerEditors2ExtensiveModeration is Distinct from Inflo2TrackAuthorship
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2ExtensiveModeration c)
	(not (edge Inflo2TrackAuthorship c))
)))
;InfloManagerEditors2ExtensiveModeration is Distinct from Inflo2DisplayGraphs
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2ExtensiveModeration c)
	(not (edge Inflo2DisplayGraphs c))
)))
;InfloManagerEditors2ExtensiveModeration is Distinct from Inflo2TrackRevisions
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2ExtensiveModeration c)
	(not (edge Inflo2TrackRevisions c))
)))
;InfloManagerEditors2ExtensiveModeration is Distinct from Inflo2CreateGraphs
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2ExtensiveModeration c)
	(not (edge Inflo2CreateGraphs c))
)))
;InfloManagerEditors2ExtensiveModeration is Distinct from Inflo2BeInflo
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2ExtensiveModeration c)
	(not (edge Inflo2BeInflo c))
)))
;InfloManagerEditors2ExtensiveModeration is Distinct from Inflo2ModerationTasks
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2ExtensiveModeration c)
	(not (edge Inflo2ModerationTasks c))
)))
;InfloManagerEditors2ExtensiveModeration is Distinct from InfloManagerEditors2UseAutomatedReputationSystem
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2ExtensiveModeration c)
	(not (edge InfloManagerEditors2UseAutomatedReputationSystem c))
)))
;InfloManagerEditors2UseAutomatedReputationSystem tgtEndpoint constant
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2UseAutomatedReputationSystem c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;InfloManagerEditors2UseAutomatedReputationSystem endpoints
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2UseAutomatedReputationSystem c)
	(and
		(node InfloManagerEditors (src c))
		(node UseAutomatedReputationSystem ((as tgt (TaskConcretization)) c))
	)
)))
;InfloManagerEditors2UseAutomatedReputationSystem Exists
(assert	(exists ((c IntentionalElementConcretization)) (edge InfloManagerEditors2UseAutomatedReputationSystem c)))
;InfloManagerEditors2UseAutomatedReputationSystem is Unique
(assert	(forall ((c1 IntentionalElementConcretization) (c2 IntentionalElementConcretization)) (=>
	(and (edge InfloManagerEditors2UseAutomatedReputationSystem c1) (edge InfloManagerEditors2UseAutomatedReputationSystem c2))
	(= c1 c2)
)))
;InfloManagerEditors2UseAutomatedReputationSystem is Distinct from InfloUser2Browsing
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2UseAutomatedReputationSystem c)
	(not (edge InfloUser2Browsing c))
)))
;InfloManagerEditors2UseAutomatedReputationSystem is Distinct from InfloUser2CreateGraph
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2UseAutomatedReputationSystem c)
	(not (edge InfloUser2CreateGraph c))
)))
;InfloManagerEditors2UseAutomatedReputationSystem is Distinct from InfloUser2UseDiscussions
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2UseAutomatedReputationSystem c)
	(not (edge InfloUser2UseDiscussions c))
)))
;InfloManagerEditors2UseAutomatedReputationSystem is Distinct from InfloUser2MakeViews
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2UseAutomatedReputationSystem c)
	(not (edge InfloUser2MakeViews c))
)))
;InfloManagerEditors2UseAutomatedReputationSystem is Distinct from InfloUser2AddSourceInDescription
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2UseAutomatedReputationSystem c)
	(not (edge InfloUser2AddSourceInDescription c))
)))
;InfloManagerEditors2UseAutomatedReputationSystem is Distinct from InfloUser2CreateDiscussions
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2UseAutomatedReputationSystem c)
	(not (edge InfloUser2CreateDiscussions c))
)))
;InfloManagerEditors2UseAutomatedReputationSystem is Distinct from AutomatedReputationSystem2ProvideReputations
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2UseAutomatedReputationSystem c)
	(not (edge AutomatedReputationSystem2ProvideReputations c))
)))
;InfloManagerEditors2UseAutomatedReputationSystem is Distinct from AutomatedReputationSystem2ModerationARS
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2UseAutomatedReputationSystem c)
	(not (edge AutomatedReputationSystem2ModerationARS c))
)))
;InfloManagerEditors2UseAutomatedReputationSystem is Distinct from Inflo2TrackAuthorship
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2UseAutomatedReputationSystem c)
	(not (edge Inflo2TrackAuthorship c))
)))
;InfloManagerEditors2UseAutomatedReputationSystem is Distinct from Inflo2DisplayGraphs
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2UseAutomatedReputationSystem c)
	(not (edge Inflo2DisplayGraphs c))
)))
;InfloManagerEditors2UseAutomatedReputationSystem is Distinct from Inflo2TrackRevisions
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2UseAutomatedReputationSystem c)
	(not (edge Inflo2TrackRevisions c))
)))
;InfloManagerEditors2UseAutomatedReputationSystem is Distinct from Inflo2CreateGraphs
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2UseAutomatedReputationSystem c)
	(not (edge Inflo2CreateGraphs c))
)))
;InfloManagerEditors2UseAutomatedReputationSystem is Distinct from Inflo2BeInflo
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2UseAutomatedReputationSystem c)
	(not (edge Inflo2BeInflo c))
)))
;InfloManagerEditors2UseAutomatedReputationSystem is Distinct from Inflo2ModerationTasks
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2UseAutomatedReputationSystem c)
	(not (edge Inflo2ModerationTasks c))
)))
;InfloManagerEditors2UseAutomatedReputationSystem is Distinct from InfloManagerEditors2ExtensiveModeration
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2UseAutomatedReputationSystem c)
	(not (edge InfloManagerEditors2ExtensiveModeration c))
)))
;InfloManagerEditors2ModerateInflo tgtEndpoint constant
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2ModerateInflo c)
	(= (tgtEndpoint c) ENDPOINT_GOAL)
)))
;InfloManagerEditors2ModerateInflo endpoints
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2ModerateInflo c)
	(and
		(node InfloManagerEditors (src c))
		(node ModerateInflo ((as tgt (GoalConcretization)) c))
	)
)))
;InfloManagerEditors2ModerateInflo Exists
(assert	(exists ((c IntentionalElementConcretization)) (edge InfloManagerEditors2ModerateInflo c)))
;InfloManagerEditors2ModerateInflo is Unique
(assert	(forall ((c1 IntentionalElementConcretization) (c2 IntentionalElementConcretization)) (=>
	(and (edge InfloManagerEditors2ModerateInflo c1) (edge InfloManagerEditors2ModerateInflo c2))
	(= c1 c2)
)))
;InfloManagerEditors2ModerateInflo is Distinct from InfloUser2UseInflo
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2ModerateInflo c)
	(not (edge InfloUser2UseInflo c))
)))
;InfloManagerEditors2ModerateInflo is Distinct from InfloUser2InfloBeModerated
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2ModerateInflo c)
	(not (edge InfloUser2InfloBeModerated c))
)))
;InfloManagerEditors2ModerateInflo is Distinct from Inflo2AllowModeration
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2ModerateInflo c)
	(not (edge Inflo2AllowModeration c))
)))
;InfloManagerEditors2LessExtensiveModeration tgtEndpoint constant
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2LessExtensiveModeration c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;InfloManagerEditors2LessExtensiveModeration endpoints
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2LessExtensiveModeration c)
	(and
		(node InfloManagerEditors (src c))
		(node LessExtensiveModeration ((as tgt (TaskConcretization)) c))
	)
)))
;InfloManagerEditors2LessExtensiveModeration is Unique
(assert	(forall ((c1 IntentionalElementConcretization) (c2 IntentionalElementConcretization)) (=>
	(and (edge InfloManagerEditors2LessExtensiveModeration c1) (edge InfloManagerEditors2LessExtensiveModeration c2))
	(= c1 c2)
)))
;InfloManagerEditors2LessExtensiveModeration is Distinct from InfloUser2Browsing
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2LessExtensiveModeration c)
	(not (edge InfloUser2Browsing c))
)))
;InfloManagerEditors2LessExtensiveModeration is Distinct from InfloUser2CreateGraph
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2LessExtensiveModeration c)
	(not (edge InfloUser2CreateGraph c))
)))
;InfloManagerEditors2LessExtensiveModeration is Distinct from InfloUser2UseDiscussions
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2LessExtensiveModeration c)
	(not (edge InfloUser2UseDiscussions c))
)))
;InfloManagerEditors2LessExtensiveModeration is Distinct from InfloUser2MakeViews
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2LessExtensiveModeration c)
	(not (edge InfloUser2MakeViews c))
)))
;InfloManagerEditors2LessExtensiveModeration is Distinct from InfloUser2AddSourceInDescription
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2LessExtensiveModeration c)
	(not (edge InfloUser2AddSourceInDescription c))
)))
;InfloManagerEditors2LessExtensiveModeration is Distinct from InfloUser2CreateDiscussions
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2LessExtensiveModeration c)
	(not (edge InfloUser2CreateDiscussions c))
)))
;InfloManagerEditors2LessExtensiveModeration is Distinct from AutomatedReputationSystem2ProvideReputations
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2LessExtensiveModeration c)
	(not (edge AutomatedReputationSystem2ProvideReputations c))
)))
;InfloManagerEditors2LessExtensiveModeration is Distinct from AutomatedReputationSystem2ModerationARS
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2LessExtensiveModeration c)
	(not (edge AutomatedReputationSystem2ModerationARS c))
)))
;InfloManagerEditors2LessExtensiveModeration is Distinct from Inflo2TrackAuthorship
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2LessExtensiveModeration c)
	(not (edge Inflo2TrackAuthorship c))
)))
;InfloManagerEditors2LessExtensiveModeration is Distinct from Inflo2DisplayGraphs
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2LessExtensiveModeration c)
	(not (edge Inflo2DisplayGraphs c))
)))
;InfloManagerEditors2LessExtensiveModeration is Distinct from Inflo2TrackRevisions
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2LessExtensiveModeration c)
	(not (edge Inflo2TrackRevisions c))
)))
;InfloManagerEditors2LessExtensiveModeration is Distinct from Inflo2CreateGraphs
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2LessExtensiveModeration c)
	(not (edge Inflo2CreateGraphs c))
)))
;InfloManagerEditors2LessExtensiveModeration is Distinct from Inflo2BeInflo
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2LessExtensiveModeration c)
	(not (edge Inflo2BeInflo c))
)))
;InfloManagerEditors2LessExtensiveModeration is Distinct from Inflo2ModerationTasks
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge InfloManagerEditors2LessExtensiveModeration c)
	(not (edge Inflo2ModerationTasks c))
)))
;AutomatedReputationSystem2ProvideReputations tgtEndpoint constant
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge AutomatedReputationSystem2ProvideReputations c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;AutomatedReputationSystem2ProvideReputations endpoints
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge AutomatedReputationSystem2ProvideReputations c)
	(and
		(node AutomatedReputationSystem (src c))
		(node ProvideReputations ((as tgt (TaskConcretization)) c))
	)
)))
;AutomatedReputationSystem2ProvideReputations Exists
(assert	(exists ((c IntentionalElementConcretization)) (edge AutomatedReputationSystem2ProvideReputations c)))
;AutomatedReputationSystem2ProvideReputations is Unique
(assert	(forall ((c1 IntentionalElementConcretization) (c2 IntentionalElementConcretization)) (=>
	(and (edge AutomatedReputationSystem2ProvideReputations c1) (edge AutomatedReputationSystem2ProvideReputations c2))
	(= c1 c2)
)))
;AutomatedReputationSystem2ProvideReputations is Distinct from InfloUser2Browsing
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge AutomatedReputationSystem2ProvideReputations c)
	(not (edge InfloUser2Browsing c))
)))
;AutomatedReputationSystem2ProvideReputations is Distinct from InfloUser2CreateGraph
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge AutomatedReputationSystem2ProvideReputations c)
	(not (edge InfloUser2CreateGraph c))
)))
;AutomatedReputationSystem2ProvideReputations is Distinct from InfloUser2UseDiscussions
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge AutomatedReputationSystem2ProvideReputations c)
	(not (edge InfloUser2UseDiscussions c))
)))
;AutomatedReputationSystem2ProvideReputations is Distinct from InfloUser2MakeViews
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge AutomatedReputationSystem2ProvideReputations c)
	(not (edge InfloUser2MakeViews c))
)))
;AutomatedReputationSystem2ProvideReputations is Distinct from InfloUser2AddSourceInDescription
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge AutomatedReputationSystem2ProvideReputations c)
	(not (edge InfloUser2AddSourceInDescription c))
)))
;AutomatedReputationSystem2ProvideReputations is Distinct from InfloUser2CreateDiscussions
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge AutomatedReputationSystem2ProvideReputations c)
	(not (edge InfloUser2CreateDiscussions c))
)))
;AutomatedReputationSystem2ProvideReputations is Distinct from InfloManagerEditors2ExtensiveModeration
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge AutomatedReputationSystem2ProvideReputations c)
	(not (edge InfloManagerEditors2ExtensiveModeration c))
)))
;AutomatedReputationSystem2ProvideReputations is Distinct from InfloManagerEditors2UseAutomatedReputationSystem
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge AutomatedReputationSystem2ProvideReputations c)
	(not (edge InfloManagerEditors2UseAutomatedReputationSystem c))
)))
;AutomatedReputationSystem2ProvideReputations is Distinct from InfloManagerEditors2LessExtensiveModeration
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge AutomatedReputationSystem2ProvideReputations c)
	(not (edge InfloManagerEditors2LessExtensiveModeration c))
)))
;AutomatedReputationSystem2ProvideReputations is Distinct from Inflo2TrackAuthorship
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge AutomatedReputationSystem2ProvideReputations c)
	(not (edge Inflo2TrackAuthorship c))
)))
;AutomatedReputationSystem2ProvideReputations is Distinct from Inflo2DisplayGraphs
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge AutomatedReputationSystem2ProvideReputations c)
	(not (edge Inflo2DisplayGraphs c))
)))
;AutomatedReputationSystem2ProvideReputations is Distinct from Inflo2TrackRevisions
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge AutomatedReputationSystem2ProvideReputations c)
	(not (edge Inflo2TrackRevisions c))
)))
;AutomatedReputationSystem2ProvideReputations is Distinct from Inflo2CreateGraphs
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge AutomatedReputationSystem2ProvideReputations c)
	(not (edge Inflo2CreateGraphs c))
)))
;AutomatedReputationSystem2ProvideReputations is Distinct from Inflo2BeInflo
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge AutomatedReputationSystem2ProvideReputations c)
	(not (edge Inflo2BeInflo c))
)))
;AutomatedReputationSystem2ProvideReputations is Distinct from Inflo2ModerationTasks
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge AutomatedReputationSystem2ProvideReputations c)
	(not (edge Inflo2ModerationTasks c))
)))
;AutomatedReputationSystem2ProvideReputations is Distinct from AutomatedReputationSystem2ModerationARS
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge AutomatedReputationSystem2ProvideReputations c)
	(not (edge AutomatedReputationSystem2ModerationARS c))
)))
;AutomatedReputationSystem2ModerationARS tgtEndpoint constant
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge AutomatedReputationSystem2ModerationARS c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;AutomatedReputationSystem2ModerationARS endpoints
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge AutomatedReputationSystem2ModerationARS c)
	(and
		(node AutomatedReputationSystem (src c))
		(node ModerationARS ((as tgt (TaskConcretization)) c))
	)
)))
;AutomatedReputationSystem2ModerationARS is Unique
(assert	(forall ((c1 IntentionalElementConcretization) (c2 IntentionalElementConcretization)) (=>
	(and (edge AutomatedReputationSystem2ModerationARS c1) (edge AutomatedReputationSystem2ModerationARS c2))
	(= c1 c2)
)))
;AutomatedReputationSystem2ModerationARS is Distinct from InfloUser2Browsing
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge AutomatedReputationSystem2ModerationARS c)
	(not (edge InfloUser2Browsing c))
)))
;AutomatedReputationSystem2ModerationARS is Distinct from InfloUser2CreateGraph
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge AutomatedReputationSystem2ModerationARS c)
	(not (edge InfloUser2CreateGraph c))
)))
;AutomatedReputationSystem2ModerationARS is Distinct from InfloUser2UseDiscussions
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge AutomatedReputationSystem2ModerationARS c)
	(not (edge InfloUser2UseDiscussions c))
)))
;AutomatedReputationSystem2ModerationARS is Distinct from InfloUser2MakeViews
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge AutomatedReputationSystem2ModerationARS c)
	(not (edge InfloUser2MakeViews c))
)))
;AutomatedReputationSystem2ModerationARS is Distinct from InfloUser2AddSourceInDescription
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge AutomatedReputationSystem2ModerationARS c)
	(not (edge InfloUser2AddSourceInDescription c))
)))
;AutomatedReputationSystem2ModerationARS is Distinct from InfloUser2CreateDiscussions
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge AutomatedReputationSystem2ModerationARS c)
	(not (edge InfloUser2CreateDiscussions c))
)))
;AutomatedReputationSystem2ModerationARS is Distinct from InfloManagerEditors2ExtensiveModeration
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge AutomatedReputationSystem2ModerationARS c)
	(not (edge InfloManagerEditors2ExtensiveModeration c))
)))
;AutomatedReputationSystem2ModerationARS is Distinct from InfloManagerEditors2UseAutomatedReputationSystem
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge AutomatedReputationSystem2ModerationARS c)
	(not (edge InfloManagerEditors2UseAutomatedReputationSystem c))
)))
;AutomatedReputationSystem2ModerationARS is Distinct from InfloManagerEditors2LessExtensiveModeration
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge AutomatedReputationSystem2ModerationARS c)
	(not (edge InfloManagerEditors2LessExtensiveModeration c))
)))
;AutomatedReputationSystem2ModerationARS is Distinct from Inflo2TrackAuthorship
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge AutomatedReputationSystem2ModerationARS c)
	(not (edge Inflo2TrackAuthorship c))
)))
;AutomatedReputationSystem2ModerationARS is Distinct from Inflo2DisplayGraphs
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge AutomatedReputationSystem2ModerationARS c)
	(not (edge Inflo2DisplayGraphs c))
)))
;AutomatedReputationSystem2ModerationARS is Distinct from Inflo2TrackRevisions
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge AutomatedReputationSystem2ModerationARS c)
	(not (edge Inflo2TrackRevisions c))
)))
;AutomatedReputationSystem2ModerationARS is Distinct from Inflo2CreateGraphs
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge AutomatedReputationSystem2ModerationARS c)
	(not (edge Inflo2CreateGraphs c))
)))
;AutomatedReputationSystem2ModerationARS is Distinct from Inflo2BeInflo
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge AutomatedReputationSystem2ModerationARS c)
	(not (edge Inflo2BeInflo c))
)))
;AutomatedReputationSystem2ModerationARS is Distinct from Inflo2ModerationTasks
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge AutomatedReputationSystem2ModerationARS c)
	(not (edge Inflo2ModerationTasks c))
)))
;AutomatedReputationSystem2ModerationARS is Distinct from AutomatedReputationSystem2ProvideReputations
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge AutomatedReputationSystem2ModerationARS c)
	(not (edge AutomatedReputationSystem2ProvideReputations c))
)))
;Inflo2AllowModeration tgtEndpoint constant
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2AllowModeration c)
	(= (tgtEndpoint c) ENDPOINT_GOAL)
)))
;Inflo2AllowModeration endpoints
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2AllowModeration c)
	(and
		(node Inflo (src c))
		(node AllowModeration ((as tgt (GoalConcretization)) c))
	)
)))
;Inflo2AllowModeration Exists
(assert	(exists ((c IntentionalElementConcretization)) (edge Inflo2AllowModeration c)))
;Inflo2AllowModeration is Unique
(assert	(forall ((c1 IntentionalElementConcretization) (c2 IntentionalElementConcretization)) (=>
	(and (edge Inflo2AllowModeration c1) (edge Inflo2AllowModeration c2))
	(= c1 c2)
)))
;Inflo2AllowModeration is Distinct from InfloUser2UseInflo
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2AllowModeration c)
	(not (edge InfloUser2UseInflo c))
)))
;Inflo2AllowModeration is Distinct from InfloUser2InfloBeModerated
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2AllowModeration c)
	(not (edge InfloUser2InfloBeModerated c))
)))
;Inflo2AllowModeration is Distinct from InfloManagerEditors2ModerateInflo
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2AllowModeration c)
	(not (edge InfloManagerEditors2ModerateInflo c))
)))
;Inflo2TrackAuthorship tgtEndpoint constant
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2TrackAuthorship c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;Inflo2TrackAuthorship endpoints
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2TrackAuthorship c)
	(and
		(node Inflo (src c))
		(node TrackAuthorship ((as tgt (TaskConcretization)) c))
	)
)))
;Inflo2TrackAuthorship Exists
(assert	(exists ((c IntentionalElementConcretization)) (edge Inflo2TrackAuthorship c)))
;Inflo2TrackAuthorship is Unique
(assert	(forall ((c1 IntentionalElementConcretization) (c2 IntentionalElementConcretization)) (=>
	(and (edge Inflo2TrackAuthorship c1) (edge Inflo2TrackAuthorship c2))
	(= c1 c2)
)))
;Inflo2TrackAuthorship is Distinct from InfloUser2Browsing
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2TrackAuthorship c)
	(not (edge InfloUser2Browsing c))
)))
;Inflo2TrackAuthorship is Distinct from InfloUser2CreateGraph
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2TrackAuthorship c)
	(not (edge InfloUser2CreateGraph c))
)))
;Inflo2TrackAuthorship is Distinct from InfloUser2UseDiscussions
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2TrackAuthorship c)
	(not (edge InfloUser2UseDiscussions c))
)))
;Inflo2TrackAuthorship is Distinct from InfloUser2MakeViews
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2TrackAuthorship c)
	(not (edge InfloUser2MakeViews c))
)))
;Inflo2TrackAuthorship is Distinct from InfloUser2AddSourceInDescription
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2TrackAuthorship c)
	(not (edge InfloUser2AddSourceInDescription c))
)))
;Inflo2TrackAuthorship is Distinct from InfloUser2CreateDiscussions
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2TrackAuthorship c)
	(not (edge InfloUser2CreateDiscussions c))
)))
;Inflo2TrackAuthorship is Distinct from InfloManagerEditors2ExtensiveModeration
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2TrackAuthorship c)
	(not (edge InfloManagerEditors2ExtensiveModeration c))
)))
;Inflo2TrackAuthorship is Distinct from InfloManagerEditors2UseAutomatedReputationSystem
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2TrackAuthorship c)
	(not (edge InfloManagerEditors2UseAutomatedReputationSystem c))
)))
;Inflo2TrackAuthorship is Distinct from InfloManagerEditors2LessExtensiveModeration
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2TrackAuthorship c)
	(not (edge InfloManagerEditors2LessExtensiveModeration c))
)))
;Inflo2TrackAuthorship is Distinct from AutomatedReputationSystem2ProvideReputations
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2TrackAuthorship c)
	(not (edge AutomatedReputationSystem2ProvideReputations c))
)))
;Inflo2TrackAuthorship is Distinct from AutomatedReputationSystem2ModerationARS
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2TrackAuthorship c)
	(not (edge AutomatedReputationSystem2ModerationARS c))
)))
;Inflo2TrackAuthorship is Distinct from Inflo2DisplayGraphs
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2TrackAuthorship c)
	(not (edge Inflo2DisplayGraphs c))
)))
;Inflo2TrackAuthorship is Distinct from Inflo2TrackRevisions
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2TrackAuthorship c)
	(not (edge Inflo2TrackRevisions c))
)))
;Inflo2TrackAuthorship is Distinct from Inflo2CreateGraphs
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2TrackAuthorship c)
	(not (edge Inflo2CreateGraphs c))
)))
;Inflo2TrackAuthorship is Distinct from Inflo2BeInflo
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2TrackAuthorship c)
	(not (edge Inflo2BeInflo c))
)))
;Inflo2TrackAuthorship is Distinct from Inflo2ModerationTasks
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2TrackAuthorship c)
	(not (edge Inflo2ModerationTasks c))
)))
;Inflo2DisplayGraphs tgtEndpoint constant
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2DisplayGraphs c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;Inflo2DisplayGraphs endpoints
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2DisplayGraphs c)
	(and
		(node Inflo (src c))
		(node DisplayGraphs ((as tgt (TaskConcretization)) c))
	)
)))
;Inflo2DisplayGraphs Exists
(assert	(exists ((c IntentionalElementConcretization)) (edge Inflo2DisplayGraphs c)))
;Inflo2DisplayGraphs is Unique
(assert	(forall ((c1 IntentionalElementConcretization) (c2 IntentionalElementConcretization)) (=>
	(and (edge Inflo2DisplayGraphs c1) (edge Inflo2DisplayGraphs c2))
	(= c1 c2)
)))
;Inflo2DisplayGraphs is Distinct from InfloUser2Browsing
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2DisplayGraphs c)
	(not (edge InfloUser2Browsing c))
)))
;Inflo2DisplayGraphs is Distinct from InfloUser2CreateGraph
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2DisplayGraphs c)
	(not (edge InfloUser2CreateGraph c))
)))
;Inflo2DisplayGraphs is Distinct from InfloUser2UseDiscussions
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2DisplayGraphs c)
	(not (edge InfloUser2UseDiscussions c))
)))
;Inflo2DisplayGraphs is Distinct from InfloUser2MakeViews
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2DisplayGraphs c)
	(not (edge InfloUser2MakeViews c))
)))
;Inflo2DisplayGraphs is Distinct from InfloUser2AddSourceInDescription
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2DisplayGraphs c)
	(not (edge InfloUser2AddSourceInDescription c))
)))
;Inflo2DisplayGraphs is Distinct from InfloUser2CreateDiscussions
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2DisplayGraphs c)
	(not (edge InfloUser2CreateDiscussions c))
)))
;Inflo2DisplayGraphs is Distinct from InfloManagerEditors2ExtensiveModeration
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2DisplayGraphs c)
	(not (edge InfloManagerEditors2ExtensiveModeration c))
)))
;Inflo2DisplayGraphs is Distinct from InfloManagerEditors2UseAutomatedReputationSystem
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2DisplayGraphs c)
	(not (edge InfloManagerEditors2UseAutomatedReputationSystem c))
)))
;Inflo2DisplayGraphs is Distinct from InfloManagerEditors2LessExtensiveModeration
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2DisplayGraphs c)
	(not (edge InfloManagerEditors2LessExtensiveModeration c))
)))
;Inflo2DisplayGraphs is Distinct from AutomatedReputationSystem2ProvideReputations
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2DisplayGraphs c)
	(not (edge AutomatedReputationSystem2ProvideReputations c))
)))
;Inflo2DisplayGraphs is Distinct from AutomatedReputationSystem2ModerationARS
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2DisplayGraphs c)
	(not (edge AutomatedReputationSystem2ModerationARS c))
)))
;Inflo2DisplayGraphs is Distinct from Inflo2TrackAuthorship
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2DisplayGraphs c)
	(not (edge Inflo2TrackAuthorship c))
)))
;Inflo2DisplayGraphs is Distinct from Inflo2TrackRevisions
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2DisplayGraphs c)
	(not (edge Inflo2TrackRevisions c))
)))
;Inflo2DisplayGraphs is Distinct from Inflo2CreateGraphs
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2DisplayGraphs c)
	(not (edge Inflo2CreateGraphs c))
)))
;Inflo2DisplayGraphs is Distinct from Inflo2BeInflo
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2DisplayGraphs c)
	(not (edge Inflo2BeInflo c))
)))
;Inflo2DisplayGraphs is Distinct from Inflo2ModerationTasks
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2DisplayGraphs c)
	(not (edge Inflo2ModerationTasks c))
)))
;Inflo2TrackRevisions tgtEndpoint constant
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2TrackRevisions c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;Inflo2TrackRevisions endpoints
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2TrackRevisions c)
	(and
		(node Inflo (src c))
		(node TrackRevisions ((as tgt (TaskConcretization)) c))
	)
)))
;Inflo2TrackRevisions Exists
(assert	(exists ((c IntentionalElementConcretization)) (edge Inflo2TrackRevisions c)))
;Inflo2TrackRevisions is Unique
(assert	(forall ((c1 IntentionalElementConcretization) (c2 IntentionalElementConcretization)) (=>
	(and (edge Inflo2TrackRevisions c1) (edge Inflo2TrackRevisions c2))
	(= c1 c2)
)))
;Inflo2TrackRevisions is Distinct from InfloUser2Browsing
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2TrackRevisions c)
	(not (edge InfloUser2Browsing c))
)))
;Inflo2TrackRevisions is Distinct from InfloUser2CreateGraph
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2TrackRevisions c)
	(not (edge InfloUser2CreateGraph c))
)))
;Inflo2TrackRevisions is Distinct from InfloUser2UseDiscussions
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2TrackRevisions c)
	(not (edge InfloUser2UseDiscussions c))
)))
;Inflo2TrackRevisions is Distinct from InfloUser2MakeViews
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2TrackRevisions c)
	(not (edge InfloUser2MakeViews c))
)))
;Inflo2TrackRevisions is Distinct from InfloUser2AddSourceInDescription
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2TrackRevisions c)
	(not (edge InfloUser2AddSourceInDescription c))
)))
;Inflo2TrackRevisions is Distinct from InfloUser2CreateDiscussions
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2TrackRevisions c)
	(not (edge InfloUser2CreateDiscussions c))
)))
;Inflo2TrackRevisions is Distinct from InfloManagerEditors2ExtensiveModeration
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2TrackRevisions c)
	(not (edge InfloManagerEditors2ExtensiveModeration c))
)))
;Inflo2TrackRevisions is Distinct from InfloManagerEditors2UseAutomatedReputationSystem
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2TrackRevisions c)
	(not (edge InfloManagerEditors2UseAutomatedReputationSystem c))
)))
;Inflo2TrackRevisions is Distinct from InfloManagerEditors2LessExtensiveModeration
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2TrackRevisions c)
	(not (edge InfloManagerEditors2LessExtensiveModeration c))
)))
;Inflo2TrackRevisions is Distinct from AutomatedReputationSystem2ProvideReputations
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2TrackRevisions c)
	(not (edge AutomatedReputationSystem2ProvideReputations c))
)))
;Inflo2TrackRevisions is Distinct from AutomatedReputationSystem2ModerationARS
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2TrackRevisions c)
	(not (edge AutomatedReputationSystem2ModerationARS c))
)))
;Inflo2TrackRevisions is Distinct from Inflo2TrackAuthorship
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2TrackRevisions c)
	(not (edge Inflo2TrackAuthorship c))
)))
;Inflo2TrackRevisions is Distinct from Inflo2DisplayGraphs
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2TrackRevisions c)
	(not (edge Inflo2DisplayGraphs c))
)))
;Inflo2TrackRevisions is Distinct from Inflo2CreateGraphs
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2TrackRevisions c)
	(not (edge Inflo2CreateGraphs c))
)))
;Inflo2TrackRevisions is Distinct from Inflo2BeInflo
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2TrackRevisions c)
	(not (edge Inflo2BeInflo c))
)))
;Inflo2TrackRevisions is Distinct from Inflo2ModerationTasks
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2TrackRevisions c)
	(not (edge Inflo2ModerationTasks c))
)))
;Inflo2CreateGraphs tgtEndpoint constant
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2CreateGraphs c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;Inflo2CreateGraphs endpoints
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2CreateGraphs c)
	(and
		(node Inflo (src c))
		(node CreateGraphs ((as tgt (TaskConcretization)) c))
	)
)))
;Inflo2CreateGraphs Exists
(assert	(exists ((c IntentionalElementConcretization)) (edge Inflo2CreateGraphs c)))
;Inflo2CreateGraphs is Unique
(assert	(forall ((c1 IntentionalElementConcretization) (c2 IntentionalElementConcretization)) (=>
	(and (edge Inflo2CreateGraphs c1) (edge Inflo2CreateGraphs c2))
	(= c1 c2)
)))
;Inflo2CreateGraphs is Distinct from InfloUser2Browsing
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2CreateGraphs c)
	(not (edge InfloUser2Browsing c))
)))
;Inflo2CreateGraphs is Distinct from InfloUser2CreateGraph
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2CreateGraphs c)
	(not (edge InfloUser2CreateGraph c))
)))
;Inflo2CreateGraphs is Distinct from InfloUser2UseDiscussions
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2CreateGraphs c)
	(not (edge InfloUser2UseDiscussions c))
)))
;Inflo2CreateGraphs is Distinct from InfloUser2MakeViews
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2CreateGraphs c)
	(not (edge InfloUser2MakeViews c))
)))
;Inflo2CreateGraphs is Distinct from InfloUser2AddSourceInDescription
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2CreateGraphs c)
	(not (edge InfloUser2AddSourceInDescription c))
)))
;Inflo2CreateGraphs is Distinct from InfloUser2CreateDiscussions
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2CreateGraphs c)
	(not (edge InfloUser2CreateDiscussions c))
)))
;Inflo2CreateGraphs is Distinct from InfloManagerEditors2ExtensiveModeration
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2CreateGraphs c)
	(not (edge InfloManagerEditors2ExtensiveModeration c))
)))
;Inflo2CreateGraphs is Distinct from InfloManagerEditors2UseAutomatedReputationSystem
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2CreateGraphs c)
	(not (edge InfloManagerEditors2UseAutomatedReputationSystem c))
)))
;Inflo2CreateGraphs is Distinct from InfloManagerEditors2LessExtensiveModeration
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2CreateGraphs c)
	(not (edge InfloManagerEditors2LessExtensiveModeration c))
)))
;Inflo2CreateGraphs is Distinct from AutomatedReputationSystem2ProvideReputations
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2CreateGraphs c)
	(not (edge AutomatedReputationSystem2ProvideReputations c))
)))
;Inflo2CreateGraphs is Distinct from AutomatedReputationSystem2ModerationARS
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2CreateGraphs c)
	(not (edge AutomatedReputationSystem2ModerationARS c))
)))
;Inflo2CreateGraphs is Distinct from Inflo2TrackAuthorship
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2CreateGraphs c)
	(not (edge Inflo2TrackAuthorship c))
)))
;Inflo2CreateGraphs is Distinct from Inflo2DisplayGraphs
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2CreateGraphs c)
	(not (edge Inflo2DisplayGraphs c))
)))
;Inflo2CreateGraphs is Distinct from Inflo2TrackRevisions
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2CreateGraphs c)
	(not (edge Inflo2TrackRevisions c))
)))
;Inflo2CreateGraphs is Distinct from Inflo2BeInflo
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2CreateGraphs c)
	(not (edge Inflo2BeInflo c))
)))
;Inflo2CreateGraphs is Distinct from Inflo2ModerationTasks
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2CreateGraphs c)
	(not (edge Inflo2ModerationTasks c))
)))
;Inflo2BeInflo tgtEndpoint constant
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2BeInflo c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;Inflo2BeInflo endpoints
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2BeInflo c)
	(and
		(node Inflo (src c))
		(node BeInflo ((as tgt (TaskConcretization)) c))
	)
)))
;Inflo2BeInflo Exists
(assert	(exists ((c IntentionalElementConcretization)) (edge Inflo2BeInflo c)))
;Inflo2BeInflo is Unique
(assert	(forall ((c1 IntentionalElementConcretization) (c2 IntentionalElementConcretization)) (=>
	(and (edge Inflo2BeInflo c1) (edge Inflo2BeInflo c2))
	(= c1 c2)
)))
;Inflo2BeInflo is Distinct from InfloUser2Browsing
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2BeInflo c)
	(not (edge InfloUser2Browsing c))
)))
;Inflo2BeInflo is Distinct from InfloUser2CreateGraph
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2BeInflo c)
	(not (edge InfloUser2CreateGraph c))
)))
;Inflo2BeInflo is Distinct from InfloUser2UseDiscussions
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2BeInflo c)
	(not (edge InfloUser2UseDiscussions c))
)))
;Inflo2BeInflo is Distinct from InfloUser2MakeViews
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2BeInflo c)
	(not (edge InfloUser2MakeViews c))
)))
;Inflo2BeInflo is Distinct from InfloUser2AddSourceInDescription
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2BeInflo c)
	(not (edge InfloUser2AddSourceInDescription c))
)))
;Inflo2BeInflo is Distinct from InfloUser2CreateDiscussions
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2BeInflo c)
	(not (edge InfloUser2CreateDiscussions c))
)))
;Inflo2BeInflo is Distinct from InfloManagerEditors2ExtensiveModeration
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2BeInflo c)
	(not (edge InfloManagerEditors2ExtensiveModeration c))
)))
;Inflo2BeInflo is Distinct from InfloManagerEditors2UseAutomatedReputationSystem
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2BeInflo c)
	(not (edge InfloManagerEditors2UseAutomatedReputationSystem c))
)))
;Inflo2BeInflo is Distinct from InfloManagerEditors2LessExtensiveModeration
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2BeInflo c)
	(not (edge InfloManagerEditors2LessExtensiveModeration c))
)))
;Inflo2BeInflo is Distinct from AutomatedReputationSystem2ProvideReputations
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2BeInflo c)
	(not (edge AutomatedReputationSystem2ProvideReputations c))
)))
;Inflo2BeInflo is Distinct from AutomatedReputationSystem2ModerationARS
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2BeInflo c)
	(not (edge AutomatedReputationSystem2ModerationARS c))
)))
;Inflo2BeInflo is Distinct from Inflo2TrackAuthorship
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2BeInflo c)
	(not (edge Inflo2TrackAuthorship c))
)))
;Inflo2BeInflo is Distinct from Inflo2DisplayGraphs
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2BeInflo c)
	(not (edge Inflo2DisplayGraphs c))
)))
;Inflo2BeInflo is Distinct from Inflo2TrackRevisions
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2BeInflo c)
	(not (edge Inflo2TrackRevisions c))
)))
;Inflo2BeInflo is Distinct from Inflo2CreateGraphs
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2BeInflo c)
	(not (edge Inflo2CreateGraphs c))
)))
;Inflo2BeInflo is Distinct from Inflo2ModerationTasks
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2BeInflo c)
	(not (edge Inflo2ModerationTasks c))
)))
;Inflo2ModerationTasks tgtEndpoint constant
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2ModerationTasks c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;Inflo2ModerationTasks endpoints
(assert (forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2ModerationTasks c)
	(and
		(node Inflo (src c))
		(node ModerationTasks ((as tgt (TaskConcretization)) c))
	)
)))
;Inflo2ModerationTasks is Unique
(assert	(forall ((c1 IntentionalElementConcretization) (c2 IntentionalElementConcretization)) (=>
	(and (edge Inflo2ModerationTasks c1) (edge Inflo2ModerationTasks c2))
	(= c1 c2)
)))
;Inflo2ModerationTasks is Distinct from InfloUser2Browsing
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2ModerationTasks c)
	(not (edge InfloUser2Browsing c))
)))
;Inflo2ModerationTasks is Distinct from InfloUser2CreateGraph
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2ModerationTasks c)
	(not (edge InfloUser2CreateGraph c))
)))
;Inflo2ModerationTasks is Distinct from InfloUser2UseDiscussions
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2ModerationTasks c)
	(not (edge InfloUser2UseDiscussions c))
)))
;Inflo2ModerationTasks is Distinct from InfloUser2MakeViews
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2ModerationTasks c)
	(not (edge InfloUser2MakeViews c))
)))
;Inflo2ModerationTasks is Distinct from InfloUser2AddSourceInDescription
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2ModerationTasks c)
	(not (edge InfloUser2AddSourceInDescription c))
)))
;Inflo2ModerationTasks is Distinct from InfloUser2CreateDiscussions
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2ModerationTasks c)
	(not (edge InfloUser2CreateDiscussions c))
)))
;Inflo2ModerationTasks is Distinct from InfloManagerEditors2ExtensiveModeration
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2ModerationTasks c)
	(not (edge InfloManagerEditors2ExtensiveModeration c))
)))
;Inflo2ModerationTasks is Distinct from InfloManagerEditors2UseAutomatedReputationSystem
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2ModerationTasks c)
	(not (edge InfloManagerEditors2UseAutomatedReputationSystem c))
)))
;Inflo2ModerationTasks is Distinct from InfloManagerEditors2LessExtensiveModeration
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2ModerationTasks c)
	(not (edge InfloManagerEditors2LessExtensiveModeration c))
)))
;Inflo2ModerationTasks is Distinct from AutomatedReputationSystem2ProvideReputations
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2ModerationTasks c)
	(not (edge AutomatedReputationSystem2ProvideReputations c))
)))
;Inflo2ModerationTasks is Distinct from AutomatedReputationSystem2ModerationARS
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2ModerationTasks c)
	(not (edge AutomatedReputationSystem2ModerationARS c))
)))
;Inflo2ModerationTasks is Distinct from Inflo2TrackAuthorship
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2ModerationTasks c)
	(not (edge Inflo2TrackAuthorship c))
)))
;Inflo2ModerationTasks is Distinct from Inflo2DisplayGraphs
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2ModerationTasks c)
	(not (edge Inflo2DisplayGraphs c))
)))
;Inflo2ModerationTasks is Distinct from Inflo2TrackRevisions
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2ModerationTasks c)
	(not (edge Inflo2TrackRevisions c))
)))
;Inflo2ModerationTasks is Distinct from Inflo2CreateGraphs
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2ModerationTasks c)
	(not (edge Inflo2CreateGraphs c))
)))
;Inflo2ModerationTasks is Distinct from Inflo2BeInflo
(assert	(forall ((c IntentionalElementConcretization)) (=>
	(edge Inflo2ModerationTasks c)
	(not (edge Inflo2BeInflo c))
)))
;Browsing2UseInflo endpoints
(assert (forall ((c MeansEndConcretization)) (=>
	(edge Browsing2UseInflo c)
	(and
		(node Browsing (src c))
		(node UseInflo (tgt c))
	)
)))
;Browsing2UseInflo Exists
(assert	(exists ((c MeansEndConcretization)) (edge Browsing2UseInflo c)))
;Browsing2UseInflo is Unique
(assert	(forall ((c1 MeansEndConcretization) (c2 MeansEndConcretization)) (=>
	(and (edge Browsing2UseInflo c1) (edge Browsing2UseInflo c2))
	(= c1 c2)
)))
;Browsing2UseInflo is Distinct from ExtensiveModeration2ModerateInflo
(assert	(forall ((c MeansEndConcretization)) (=>
	(edge Browsing2UseInflo c)
	(not (edge ExtensiveModeration2ModerateInflo c))
)))
;Browsing2UseInflo is Distinct from UseAutomatedReputationSystem2ModerateInflo
(assert	(forall ((c MeansEndConcretization)) (=>
	(edge Browsing2UseInflo c)
	(not (edge UseAutomatedReputationSystem2ModerateInflo c))
)))
;Browsing2UseInflo is Distinct from LessExtensiveModeration2ModerateInflo
(assert	(forall ((c MeansEndConcretization)) (=>
	(edge Browsing2UseInflo c)
	(not (edge LessExtensiveModeration2ModerateInflo c))
)))
;Browsing2UseInflo is Distinct from ModerationTasks2AllowModeration
(assert	(forall ((c MeansEndConcretization)) (=>
	(edge Browsing2UseInflo c)
	(not (edge ModerationTasks2AllowModeration c))
)))
;Browsing2UseInflo is Distinct from CreateGraph2UseInflo
(assert	(forall ((c MeansEndConcretization)) (=>
	(edge Browsing2UseInflo c)
	(not (edge CreateGraph2UseInflo c))
)))
;Browsing2UseInflo is Distinct from UseDiscussions2UseInflo
(assert	(forall ((c MeansEndConcretization)) (=>
	(edge Browsing2UseInflo c)
	(not (edge UseDiscussions2UseInflo c))
)))
;CreateGraph2UseInflo endpoints
(assert (forall ((c MeansEndConcretization)) (=>
	(edge CreateGraph2UseInflo c)
	(and
		(node CreateGraph (src c))
		(node UseInflo (tgt c))
	)
)))
;CreateGraph2UseInflo Exists
(assert	(exists ((c MeansEndConcretization)) (edge CreateGraph2UseInflo c)))
;CreateGraph2UseInflo is Unique
(assert	(forall ((c1 MeansEndConcretization) (c2 MeansEndConcretization)) (=>
	(and (edge CreateGraph2UseInflo c1) (edge CreateGraph2UseInflo c2))
	(= c1 c2)
)))
;CreateGraph2UseInflo is Distinct from ExtensiveModeration2ModerateInflo
(assert	(forall ((c MeansEndConcretization)) (=>
	(edge CreateGraph2UseInflo c)
	(not (edge ExtensiveModeration2ModerateInflo c))
)))
;CreateGraph2UseInflo is Distinct from UseAutomatedReputationSystem2ModerateInflo
(assert	(forall ((c MeansEndConcretization)) (=>
	(edge CreateGraph2UseInflo c)
	(not (edge UseAutomatedReputationSystem2ModerateInflo c))
)))
;CreateGraph2UseInflo is Distinct from LessExtensiveModeration2ModerateInflo
(assert	(forall ((c MeansEndConcretization)) (=>
	(edge CreateGraph2UseInflo c)
	(not (edge LessExtensiveModeration2ModerateInflo c))
)))
;CreateGraph2UseInflo is Distinct from ModerationTasks2AllowModeration
(assert	(forall ((c MeansEndConcretization)) (=>
	(edge CreateGraph2UseInflo c)
	(not (edge ModerationTasks2AllowModeration c))
)))
;CreateGraph2UseInflo is Distinct from Browsing2UseInflo
(assert	(forall ((c MeansEndConcretization)) (=>
	(edge CreateGraph2UseInflo c)
	(not (edge Browsing2UseInflo c))
)))
;CreateGraph2UseInflo is Distinct from UseDiscussions2UseInflo
(assert	(forall ((c MeansEndConcretization)) (=>
	(edge CreateGraph2UseInflo c)
	(not (edge UseDiscussions2UseInflo c))
)))
;UseDiscussions2UseInflo endpoints
(assert (forall ((c MeansEndConcretization)) (=>
	(edge UseDiscussions2UseInflo c)
	(and
		(node UseDiscussions (src c))
		(node UseInflo (tgt c))
	)
)))
;UseDiscussions2UseInflo Exists
(assert	(exists ((c MeansEndConcretization)) (edge UseDiscussions2UseInflo c)))
;UseDiscussions2UseInflo is Unique
(assert	(forall ((c1 MeansEndConcretization) (c2 MeansEndConcretization)) (=>
	(and (edge UseDiscussions2UseInflo c1) (edge UseDiscussions2UseInflo c2))
	(= c1 c2)
)))
;UseDiscussions2UseInflo is Distinct from ExtensiveModeration2ModerateInflo
(assert	(forall ((c MeansEndConcretization)) (=>
	(edge UseDiscussions2UseInflo c)
	(not (edge ExtensiveModeration2ModerateInflo c))
)))
;UseDiscussions2UseInflo is Distinct from UseAutomatedReputationSystem2ModerateInflo
(assert	(forall ((c MeansEndConcretization)) (=>
	(edge UseDiscussions2UseInflo c)
	(not (edge UseAutomatedReputationSystem2ModerateInflo c))
)))
;UseDiscussions2UseInflo is Distinct from LessExtensiveModeration2ModerateInflo
(assert	(forall ((c MeansEndConcretization)) (=>
	(edge UseDiscussions2UseInflo c)
	(not (edge LessExtensiveModeration2ModerateInflo c))
)))
;UseDiscussions2UseInflo is Distinct from ModerationTasks2AllowModeration
(assert	(forall ((c MeansEndConcretization)) (=>
	(edge UseDiscussions2UseInflo c)
	(not (edge ModerationTasks2AllowModeration c))
)))
;UseDiscussions2UseInflo is Distinct from Browsing2UseInflo
(assert	(forall ((c MeansEndConcretization)) (=>
	(edge UseDiscussions2UseInflo c)
	(not (edge Browsing2UseInflo c))
)))
;UseDiscussions2UseInflo is Distinct from CreateGraph2UseInflo
(assert	(forall ((c MeansEndConcretization)) (=>
	(edge UseDiscussions2UseInflo c)
	(not (edge CreateGraph2UseInflo c))
)))
;ExtensiveModeration2ModerateInflo endpoints
(assert (forall ((c MeansEndConcretization)) (=>
	(edge ExtensiveModeration2ModerateInflo c)
	(and
		(node ExtensiveModeration (src c))
		(node ModerateInflo (tgt c))
	)
)))
;ExtensiveModeration2ModerateInflo is Unique
(assert	(forall ((c1 MeansEndConcretization) (c2 MeansEndConcretization)) (=>
	(and (edge ExtensiveModeration2ModerateInflo c1) (edge ExtensiveModeration2ModerateInflo c2))
	(= c1 c2)
)))
;ExtensiveModeration2ModerateInflo is Distinct from Browsing2UseInflo
(assert	(forall ((c MeansEndConcretization)) (=>
	(edge ExtensiveModeration2ModerateInflo c)
	(not (edge Browsing2UseInflo c))
)))
;ExtensiveModeration2ModerateInflo is Distinct from CreateGraph2UseInflo
(assert	(forall ((c MeansEndConcretization)) (=>
	(edge ExtensiveModeration2ModerateInflo c)
	(not (edge CreateGraph2UseInflo c))
)))
;ExtensiveModeration2ModerateInflo is Distinct from UseDiscussions2UseInflo
(assert	(forall ((c MeansEndConcretization)) (=>
	(edge ExtensiveModeration2ModerateInflo c)
	(not (edge UseDiscussions2UseInflo c))
)))
;ExtensiveModeration2ModerateInflo is Distinct from ModerationTasks2AllowModeration
(assert	(forall ((c MeansEndConcretization)) (=>
	(edge ExtensiveModeration2ModerateInflo c)
	(not (edge ModerationTasks2AllowModeration c))
)))
;ExtensiveModeration2ModerateInflo is Distinct from UseAutomatedReputationSystem2ModerateInflo
(assert	(forall ((c MeansEndConcretization)) (=>
	(edge ExtensiveModeration2ModerateInflo c)
	(not (edge UseAutomatedReputationSystem2ModerateInflo c))
)))
;UseAutomatedReputationSystem2ModerateInflo endpoints
(assert (forall ((c MeansEndConcretization)) (=>
	(edge UseAutomatedReputationSystem2ModerateInflo c)
	(and
		(node UseAutomatedReputationSystem (src c))
		(node ModerateInflo (tgt c))
	)
)))
;UseAutomatedReputationSystem2ModerateInflo is Unique
(assert	(forall ((c1 MeansEndConcretization) (c2 MeansEndConcretization)) (=>
	(and (edge UseAutomatedReputationSystem2ModerateInflo c1) (edge UseAutomatedReputationSystem2ModerateInflo c2))
	(= c1 c2)
)))
;UseAutomatedReputationSystem2ModerateInflo is Distinct from Browsing2UseInflo
(assert	(forall ((c MeansEndConcretization)) (=>
	(edge UseAutomatedReputationSystem2ModerateInflo c)
	(not (edge Browsing2UseInflo c))
)))
;UseAutomatedReputationSystem2ModerateInflo is Distinct from CreateGraph2UseInflo
(assert	(forall ((c MeansEndConcretization)) (=>
	(edge UseAutomatedReputationSystem2ModerateInflo c)
	(not (edge CreateGraph2UseInflo c))
)))
;UseAutomatedReputationSystem2ModerateInflo is Distinct from UseDiscussions2UseInflo
(assert	(forall ((c MeansEndConcretization)) (=>
	(edge UseAutomatedReputationSystem2ModerateInflo c)
	(not (edge UseDiscussions2UseInflo c))
)))
;UseAutomatedReputationSystem2ModerateInflo is Distinct from ModerationTasks2AllowModeration
(assert	(forall ((c MeansEndConcretization)) (=>
	(edge UseAutomatedReputationSystem2ModerateInflo c)
	(not (edge ModerationTasks2AllowModeration c))
)))
;UseAutomatedReputationSystem2ModerateInflo is Distinct from ExtensiveModeration2ModerateInflo
(assert	(forall ((c MeansEndConcretization)) (=>
	(edge UseAutomatedReputationSystem2ModerateInflo c)
	(not (edge ExtensiveModeration2ModerateInflo c))
)))
;LessExtensiveModeration2ModerateInflo endpoints
(assert (forall ((c MeansEndConcretization)) (=>
	(edge LessExtensiveModeration2ModerateInflo c)
	(and
		(node LessExtensiveModeration (src c))
		(node ModerateInflo (tgt c))
	)
)))
;LessExtensiveModeration2ModerateInflo is Unique
(assert	(forall ((c1 MeansEndConcretization) (c2 MeansEndConcretization)) (=>
	(and (edge LessExtensiveModeration2ModerateInflo c1) (edge LessExtensiveModeration2ModerateInflo c2))
	(= c1 c2)
)))
;LessExtensiveModeration2ModerateInflo is Distinct from Browsing2UseInflo
(assert	(forall ((c MeansEndConcretization)) (=>
	(edge LessExtensiveModeration2ModerateInflo c)
	(not (edge Browsing2UseInflo c))
)))
;LessExtensiveModeration2ModerateInflo is Distinct from CreateGraph2UseInflo
(assert	(forall ((c MeansEndConcretization)) (=>
	(edge LessExtensiveModeration2ModerateInflo c)
	(not (edge CreateGraph2UseInflo c))
)))
;LessExtensiveModeration2ModerateInflo is Distinct from UseDiscussions2UseInflo
(assert	(forall ((c MeansEndConcretization)) (=>
	(edge LessExtensiveModeration2ModerateInflo c)
	(not (edge UseDiscussions2UseInflo c))
)))
;LessExtensiveModeration2ModerateInflo is Distinct from ModerationTasks2AllowModeration
(assert	(forall ((c MeansEndConcretization)) (=>
	(edge LessExtensiveModeration2ModerateInflo c)
	(not (edge ModerationTasks2AllowModeration c))
)))
;ModerationTasks2AllowModeration endpoints
(assert (forall ((c MeansEndConcretization)) (=>
	(edge ModerationTasks2AllowModeration c)
	(and
		(node ModerationTasks (src c))
		(node AllowModeration (tgt c))
	)
)))
;ModerationTasks2AllowModeration is Unique
(assert	(forall ((c1 MeansEndConcretization) (c2 MeansEndConcretization)) (=>
	(and (edge ModerationTasks2AllowModeration c1) (edge ModerationTasks2AllowModeration c2))
	(= c1 c2)
)))
;ModerationTasks2AllowModeration is Distinct from Browsing2UseInflo
(assert	(forall ((c MeansEndConcretization)) (=>
	(edge ModerationTasks2AllowModeration c)
	(not (edge Browsing2UseInflo c))
)))
;ModerationTasks2AllowModeration is Distinct from CreateGraph2UseInflo
(assert	(forall ((c MeansEndConcretization)) (=>
	(edge ModerationTasks2AllowModeration c)
	(not (edge CreateGraph2UseInflo c))
)))
;ModerationTasks2AllowModeration is Distinct from UseDiscussions2UseInflo
(assert	(forall ((c MeansEndConcretization)) (=>
	(edge ModerationTasks2AllowModeration c)
	(not (edge UseDiscussions2UseInflo c))
)))
;ModerationTasks2AllowModeration is Distinct from ExtensiveModeration2ModerateInflo
(assert	(forall ((c MeansEndConcretization)) (=>
	(edge ModerationTasks2AllowModeration c)
	(not (edge ExtensiveModeration2ModerateInflo c))
)))
;ModerationTasks2AllowModeration is Distinct from UseAutomatedReputationSystem2ModerateInflo
(assert	(forall ((c MeansEndConcretization)) (=>
	(edge ModerationTasks2AllowModeration c)
	(not (edge UseAutomatedReputationSystem2ModerateInflo c))
)))
;ModerationTasks2AllowModeration is Distinct from LessExtensiveModeration2ModerateInflo
(assert	(forall ((c MeansEndConcretization)) (=>
	(edge ModerationTasks2AllowModeration c)
	(not (edge LessExtensiveModeration2ModerateInflo c))
)))
;Browsing2MakeViews tgtEndpoint constant
(assert (forall ((c DecompositionConcretization)) (=>
	(edge Browsing2MakeViews c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;Browsing2MakeViews endpoints
(assert (forall ((c DecompositionConcretization)) (=>
	(edge Browsing2MakeViews c)
	(and
		(node Browsing (src c))
		(node MakeViews ((as tgt (TaskConcretization)) c))
	)
)))
;Browsing2MakeViews Exists
(assert	(exists ((c DecompositionConcretization)) (edge Browsing2MakeViews c)))
;Browsing2MakeViews is Unique
(assert	(forall ((c1 DecompositionConcretization) (c2 DecompositionConcretization)) (=>
	(and (edge Browsing2MakeViews c1) (edge Browsing2MakeViews c2))
	(= c1 c2)
)))
;Browsing2MakeViews is Distinct from ExtensiveModeration2UseAutomatedReputationSystem
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge Browsing2MakeViews c)
	(not (edge ExtensiveModeration2UseAutomatedReputationSystem c))
)))
;Browsing2MakeViews is Distinct from LessExtensiveModeration2UseAutomatedReputationSystem
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge Browsing2MakeViews c)
	(not (edge LessExtensiveModeration2UseAutomatedReputationSystem c))
)))
;Browsing2MakeViews is Distinct from BeInflo2TrackAuthorship
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge Browsing2MakeViews c)
	(not (edge BeInflo2TrackAuthorship c))
)))
;Browsing2MakeViews is Distinct from BeInflo2DisplayGraphs
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge Browsing2MakeViews c)
	(not (edge BeInflo2DisplayGraphs c))
)))
;Browsing2MakeViews is Distinct from BeInflo2TrackRevisions
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge Browsing2MakeViews c)
	(not (edge BeInflo2TrackRevisions c))
)))
;Browsing2MakeViews is Distinct from BeInflo2CreateGraphs
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge Browsing2MakeViews c)
	(not (edge BeInflo2CreateGraphs c))
)))
;Browsing2MakeViews is Distinct from CreateGraph2AddSourceInDescription
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge Browsing2MakeViews c)
	(not (edge CreateGraph2AddSourceInDescription c))
)))
;CreateGraph2AddSourceInDescription tgtEndpoint constant
(assert (forall ((c DecompositionConcretization)) (=>
	(edge CreateGraph2AddSourceInDescription c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;CreateGraph2AddSourceInDescription endpoints
(assert (forall ((c DecompositionConcretization)) (=>
	(edge CreateGraph2AddSourceInDescription c)
	(and
		(node CreateGraph (src c))
		(node AddSourceInDescription ((as tgt (TaskConcretization)) c))
	)
)))
;CreateGraph2AddSourceInDescription Exists
(assert	(exists ((c DecompositionConcretization)) (edge CreateGraph2AddSourceInDescription c)))
;CreateGraph2AddSourceInDescription is Unique
(assert	(forall ((c1 DecompositionConcretization) (c2 DecompositionConcretization)) (=>
	(and (edge CreateGraph2AddSourceInDescription c1) (edge CreateGraph2AddSourceInDescription c2))
	(= c1 c2)
)))
;CreateGraph2AddSourceInDescription is Distinct from ExtensiveModeration2UseAutomatedReputationSystem
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge CreateGraph2AddSourceInDescription c)
	(not (edge ExtensiveModeration2UseAutomatedReputationSystem c))
)))
;CreateGraph2AddSourceInDescription is Distinct from LessExtensiveModeration2UseAutomatedReputationSystem
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge CreateGraph2AddSourceInDescription c)
	(not (edge LessExtensiveModeration2UseAutomatedReputationSystem c))
)))
;CreateGraph2AddSourceInDescription is Distinct from BeInflo2TrackAuthorship
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge CreateGraph2AddSourceInDescription c)
	(not (edge BeInflo2TrackAuthorship c))
)))
;CreateGraph2AddSourceInDescription is Distinct from BeInflo2DisplayGraphs
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge CreateGraph2AddSourceInDescription c)
	(not (edge BeInflo2DisplayGraphs c))
)))
;CreateGraph2AddSourceInDescription is Distinct from BeInflo2TrackRevisions
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge CreateGraph2AddSourceInDescription c)
	(not (edge BeInflo2TrackRevisions c))
)))
;CreateGraph2AddSourceInDescription is Distinct from BeInflo2CreateGraphs
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge CreateGraph2AddSourceInDescription c)
	(not (edge BeInflo2CreateGraphs c))
)))
;CreateGraph2AddSourceInDescription is Distinct from Browsing2MakeViews
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge CreateGraph2AddSourceInDescription c)
	(not (edge Browsing2MakeViews c))
)))
;UseDiscussions2CreateDiscussions tgtEndpoint constant
(assert (forall ((c DecompositionConcretization)) (=>
	(edge UseDiscussions2CreateDiscussions c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;UseDiscussions2CreateDiscussions endpoints
(assert (forall ((c DecompositionConcretization)) (=>
	(edge UseDiscussions2CreateDiscussions c)
	(and
		(node UseDiscussions (src c))
		(node CreateDiscussions ((as tgt (TaskConcretization)) c))
	)
)))
;UseDiscussions2CreateDiscussions is Unique
(assert	(forall ((c1 DecompositionConcretization) (c2 DecompositionConcretization)) (=>
	(and (edge UseDiscussions2CreateDiscussions c1) (edge UseDiscussions2CreateDiscussions c2))
	(= c1 c2)
)))
;UseDiscussions2CreateDiscussions is Distinct from ExtensiveModeration2UseAutomatedReputationSystem
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge UseDiscussions2CreateDiscussions c)
	(not (edge ExtensiveModeration2UseAutomatedReputationSystem c))
)))
;UseDiscussions2CreateDiscussions is Distinct from LessExtensiveModeration2UseAutomatedReputationSystem
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge UseDiscussions2CreateDiscussions c)
	(not (edge LessExtensiveModeration2UseAutomatedReputationSystem c))
)))
;UseDiscussions2CreateDiscussions is Distinct from BeInflo2TrackAuthorship
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge UseDiscussions2CreateDiscussions c)
	(not (edge BeInflo2TrackAuthorship c))
)))
;UseDiscussions2CreateDiscussions is Distinct from BeInflo2DisplayGraphs
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge UseDiscussions2CreateDiscussions c)
	(not (edge BeInflo2DisplayGraphs c))
)))
;UseDiscussions2CreateDiscussions is Distinct from BeInflo2TrackRevisions
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge UseDiscussions2CreateDiscussions c)
	(not (edge BeInflo2TrackRevisions c))
)))
;UseDiscussions2CreateDiscussions is Distinct from BeInflo2CreateGraphs
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge UseDiscussions2CreateDiscussions c)
	(not (edge BeInflo2CreateGraphs c))
)))
;ExtensiveModeration2UseAutomatedReputationSystem tgtEndpoint constant
(assert (forall ((c DecompositionConcretization)) (=>
	(edge ExtensiveModeration2UseAutomatedReputationSystem c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;ExtensiveModeration2UseAutomatedReputationSystem endpoints
(assert (forall ((c DecompositionConcretization)) (=>
	(edge ExtensiveModeration2UseAutomatedReputationSystem c)
	(and
		(node ExtensiveModeration (src c))
		(node UseAutomatedReputationSystem ((as tgt (TaskConcretization)) c))
	)
)))
;ExtensiveModeration2UseAutomatedReputationSystem is Unique
(assert	(forall ((c1 DecompositionConcretization) (c2 DecompositionConcretization)) (=>
	(and (edge ExtensiveModeration2UseAutomatedReputationSystem c1) (edge ExtensiveModeration2UseAutomatedReputationSystem c2))
	(= c1 c2)
)))
;ExtensiveModeration2UseAutomatedReputationSystem is Distinct from Browsing2MakeViews
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge ExtensiveModeration2UseAutomatedReputationSystem c)
	(not (edge Browsing2MakeViews c))
)))
;ExtensiveModeration2UseAutomatedReputationSystem is Distinct from CreateGraph2AddSourceInDescription
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge ExtensiveModeration2UseAutomatedReputationSystem c)
	(not (edge CreateGraph2AddSourceInDescription c))
)))
;ExtensiveModeration2UseAutomatedReputationSystem is Distinct from UseDiscussions2CreateDiscussions
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge ExtensiveModeration2UseAutomatedReputationSystem c)
	(not (edge UseDiscussions2CreateDiscussions c))
)))
;ExtensiveModeration2UseAutomatedReputationSystem is Distinct from BeInflo2TrackAuthorship
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge ExtensiveModeration2UseAutomatedReputationSystem c)
	(not (edge BeInflo2TrackAuthorship c))
)))
;ExtensiveModeration2UseAutomatedReputationSystem is Distinct from BeInflo2DisplayGraphs
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge ExtensiveModeration2UseAutomatedReputationSystem c)
	(not (edge BeInflo2DisplayGraphs c))
)))
;ExtensiveModeration2UseAutomatedReputationSystem is Distinct from BeInflo2TrackRevisions
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge ExtensiveModeration2UseAutomatedReputationSystem c)
	(not (edge BeInflo2TrackRevisions c))
)))
;ExtensiveModeration2UseAutomatedReputationSystem is Distinct from BeInflo2CreateGraphs
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge ExtensiveModeration2UseAutomatedReputationSystem c)
	(not (edge BeInflo2CreateGraphs c))
)))
;ExtensiveModeration2UseAutomatedReputationSystem is Distinct from LessExtensiveModeration2UseAutomatedReputationSystem
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge ExtensiveModeration2UseAutomatedReputationSystem c)
	(not (edge LessExtensiveModeration2UseAutomatedReputationSystem c))
)))
;LessExtensiveModeration2UseAutomatedReputationSystem tgtEndpoint constant
(assert (forall ((c DecompositionConcretization)) (=>
	(edge LessExtensiveModeration2UseAutomatedReputationSystem c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;LessExtensiveModeration2UseAutomatedReputationSystem endpoints
(assert (forall ((c DecompositionConcretization)) (=>
	(edge LessExtensiveModeration2UseAutomatedReputationSystem c)
	(and
		(node LessExtensiveModeration (src c))
		(node UseAutomatedReputationSystem ((as tgt (TaskConcretization)) c))
	)
)))
;LessExtensiveModeration2UseAutomatedReputationSystem is Unique
(assert	(forall ((c1 DecompositionConcretization) (c2 DecompositionConcretization)) (=>
	(and (edge LessExtensiveModeration2UseAutomatedReputationSystem c1) (edge LessExtensiveModeration2UseAutomatedReputationSystem c2))
	(= c1 c2)
)))
;LessExtensiveModeration2UseAutomatedReputationSystem is Distinct from Browsing2MakeViews
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge LessExtensiveModeration2UseAutomatedReputationSystem c)
	(not (edge Browsing2MakeViews c))
)))
;LessExtensiveModeration2UseAutomatedReputationSystem is Distinct from CreateGraph2AddSourceInDescription
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge LessExtensiveModeration2UseAutomatedReputationSystem c)
	(not (edge CreateGraph2AddSourceInDescription c))
)))
;LessExtensiveModeration2UseAutomatedReputationSystem is Distinct from UseDiscussions2CreateDiscussions
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge LessExtensiveModeration2UseAutomatedReputationSystem c)
	(not (edge UseDiscussions2CreateDiscussions c))
)))
;LessExtensiveModeration2UseAutomatedReputationSystem is Distinct from BeInflo2TrackAuthorship
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge LessExtensiveModeration2UseAutomatedReputationSystem c)
	(not (edge BeInflo2TrackAuthorship c))
)))
;LessExtensiveModeration2UseAutomatedReputationSystem is Distinct from BeInflo2DisplayGraphs
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge LessExtensiveModeration2UseAutomatedReputationSystem c)
	(not (edge BeInflo2DisplayGraphs c))
)))
;LessExtensiveModeration2UseAutomatedReputationSystem is Distinct from BeInflo2TrackRevisions
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge LessExtensiveModeration2UseAutomatedReputationSystem c)
	(not (edge BeInflo2TrackRevisions c))
)))
;LessExtensiveModeration2UseAutomatedReputationSystem is Distinct from BeInflo2CreateGraphs
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge LessExtensiveModeration2UseAutomatedReputationSystem c)
	(not (edge BeInflo2CreateGraphs c))
)))
;LessExtensiveModeration2UseAutomatedReputationSystem is Distinct from ExtensiveModeration2UseAutomatedReputationSystem
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge LessExtensiveModeration2UseAutomatedReputationSystem c)
	(not (edge ExtensiveModeration2UseAutomatedReputationSystem c))
)))
;BeInflo2TrackAuthorship tgtEndpoint constant
(assert (forall ((c DecompositionConcretization)) (=>
	(edge BeInflo2TrackAuthorship c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;BeInflo2TrackAuthorship endpoints
(assert (forall ((c DecompositionConcretization)) (=>
	(edge BeInflo2TrackAuthorship c)
	(and
		(node BeInflo (src c))
		(node TrackAuthorship ((as tgt (TaskConcretization)) c))
	)
)))
;BeInflo2TrackAuthorship Exists
(assert	(exists ((c DecompositionConcretization)) (edge BeInflo2TrackAuthorship c)))
;BeInflo2TrackAuthorship is Unique
(assert	(forall ((c1 DecompositionConcretization) (c2 DecompositionConcretization)) (=>
	(and (edge BeInflo2TrackAuthorship c1) (edge BeInflo2TrackAuthorship c2))
	(= c1 c2)
)))
;BeInflo2TrackAuthorship is Distinct from Browsing2MakeViews
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge BeInflo2TrackAuthorship c)
	(not (edge Browsing2MakeViews c))
)))
;BeInflo2TrackAuthorship is Distinct from CreateGraph2AddSourceInDescription
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge BeInflo2TrackAuthorship c)
	(not (edge CreateGraph2AddSourceInDescription c))
)))
;BeInflo2TrackAuthorship is Distinct from UseDiscussions2CreateDiscussions
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge BeInflo2TrackAuthorship c)
	(not (edge UseDiscussions2CreateDiscussions c))
)))
;BeInflo2TrackAuthorship is Distinct from ExtensiveModeration2UseAutomatedReputationSystem
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge BeInflo2TrackAuthorship c)
	(not (edge ExtensiveModeration2UseAutomatedReputationSystem c))
)))
;BeInflo2TrackAuthorship is Distinct from LessExtensiveModeration2UseAutomatedReputationSystem
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge BeInflo2TrackAuthorship c)
	(not (edge LessExtensiveModeration2UseAutomatedReputationSystem c))
)))
;BeInflo2TrackAuthorship is Distinct from BeInflo2DisplayGraphs
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge BeInflo2TrackAuthorship c)
	(not (edge BeInflo2DisplayGraphs c))
)))
;BeInflo2TrackAuthorship is Distinct from BeInflo2TrackRevisions
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge BeInflo2TrackAuthorship c)
	(not (edge BeInflo2TrackRevisions c))
)))
;BeInflo2TrackAuthorship is Distinct from BeInflo2CreateGraphs
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge BeInflo2TrackAuthorship c)
	(not (edge BeInflo2CreateGraphs c))
)))
;BeInflo2DisplayGraphs tgtEndpoint constant
(assert (forall ((c DecompositionConcretization)) (=>
	(edge BeInflo2DisplayGraphs c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;BeInflo2DisplayGraphs endpoints
(assert (forall ((c DecompositionConcretization)) (=>
	(edge BeInflo2DisplayGraphs c)
	(and
		(node BeInflo (src c))
		(node DisplayGraphs ((as tgt (TaskConcretization)) c))
	)
)))
;BeInflo2DisplayGraphs Exists
(assert	(exists ((c DecompositionConcretization)) (edge BeInflo2DisplayGraphs c)))
;BeInflo2DisplayGraphs is Unique
(assert	(forall ((c1 DecompositionConcretization) (c2 DecompositionConcretization)) (=>
	(and (edge BeInflo2DisplayGraphs c1) (edge BeInflo2DisplayGraphs c2))
	(= c1 c2)
)))
;BeInflo2DisplayGraphs is Distinct from Browsing2MakeViews
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge BeInflo2DisplayGraphs c)
	(not (edge Browsing2MakeViews c))
)))
;BeInflo2DisplayGraphs is Distinct from CreateGraph2AddSourceInDescription
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge BeInflo2DisplayGraphs c)
	(not (edge CreateGraph2AddSourceInDescription c))
)))
;BeInflo2DisplayGraphs is Distinct from UseDiscussions2CreateDiscussions
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge BeInflo2DisplayGraphs c)
	(not (edge UseDiscussions2CreateDiscussions c))
)))
;BeInflo2DisplayGraphs is Distinct from ExtensiveModeration2UseAutomatedReputationSystem
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge BeInflo2DisplayGraphs c)
	(not (edge ExtensiveModeration2UseAutomatedReputationSystem c))
)))
;BeInflo2DisplayGraphs is Distinct from LessExtensiveModeration2UseAutomatedReputationSystem
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge BeInflo2DisplayGraphs c)
	(not (edge LessExtensiveModeration2UseAutomatedReputationSystem c))
)))
;BeInflo2DisplayGraphs is Distinct from BeInflo2TrackAuthorship
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge BeInflo2DisplayGraphs c)
	(not (edge BeInflo2TrackAuthorship c))
)))
;BeInflo2DisplayGraphs is Distinct from BeInflo2TrackRevisions
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge BeInflo2DisplayGraphs c)
	(not (edge BeInflo2TrackRevisions c))
)))
;BeInflo2DisplayGraphs is Distinct from BeInflo2CreateGraphs
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge BeInflo2DisplayGraphs c)
	(not (edge BeInflo2CreateGraphs c))
)))
;BeInflo2TrackRevisions tgtEndpoint constant
(assert (forall ((c DecompositionConcretization)) (=>
	(edge BeInflo2TrackRevisions c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;BeInflo2TrackRevisions endpoints
(assert (forall ((c DecompositionConcretization)) (=>
	(edge BeInflo2TrackRevisions c)
	(and
		(node BeInflo (src c))
		(node TrackRevisions ((as tgt (TaskConcretization)) c))
	)
)))
;BeInflo2TrackRevisions Exists
(assert	(exists ((c DecompositionConcretization)) (edge BeInflo2TrackRevisions c)))
;BeInflo2TrackRevisions is Unique
(assert	(forall ((c1 DecompositionConcretization) (c2 DecompositionConcretization)) (=>
	(and (edge BeInflo2TrackRevisions c1) (edge BeInflo2TrackRevisions c2))
	(= c1 c2)
)))
;BeInflo2TrackRevisions is Distinct from Browsing2MakeViews
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge BeInflo2TrackRevisions c)
	(not (edge Browsing2MakeViews c))
)))
;BeInflo2TrackRevisions is Distinct from CreateGraph2AddSourceInDescription
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge BeInflo2TrackRevisions c)
	(not (edge CreateGraph2AddSourceInDescription c))
)))
;BeInflo2TrackRevisions is Distinct from UseDiscussions2CreateDiscussions
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge BeInflo2TrackRevisions c)
	(not (edge UseDiscussions2CreateDiscussions c))
)))
;BeInflo2TrackRevisions is Distinct from ExtensiveModeration2UseAutomatedReputationSystem
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge BeInflo2TrackRevisions c)
	(not (edge ExtensiveModeration2UseAutomatedReputationSystem c))
)))
;BeInflo2TrackRevisions is Distinct from LessExtensiveModeration2UseAutomatedReputationSystem
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge BeInflo2TrackRevisions c)
	(not (edge LessExtensiveModeration2UseAutomatedReputationSystem c))
)))
;BeInflo2TrackRevisions is Distinct from BeInflo2TrackAuthorship
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge BeInflo2TrackRevisions c)
	(not (edge BeInflo2TrackAuthorship c))
)))
;BeInflo2TrackRevisions is Distinct from BeInflo2DisplayGraphs
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge BeInflo2TrackRevisions c)
	(not (edge BeInflo2DisplayGraphs c))
)))
;BeInflo2TrackRevisions is Distinct from BeInflo2CreateGraphs
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge BeInflo2TrackRevisions c)
	(not (edge BeInflo2CreateGraphs c))
)))
;BeInflo2CreateGraphs tgtEndpoint constant
(assert (forall ((c DecompositionConcretization)) (=>
	(edge BeInflo2CreateGraphs c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;BeInflo2CreateGraphs endpoints
(assert (forall ((c DecompositionConcretization)) (=>
	(edge BeInflo2CreateGraphs c)
	(and
		(node BeInflo (src c))
		(node CreateGraphs ((as tgt (TaskConcretization)) c))
	)
)))
;BeInflo2CreateGraphs Exists
(assert	(exists ((c DecompositionConcretization)) (edge BeInflo2CreateGraphs c)))
;BeInflo2CreateGraphs is Unique
(assert	(forall ((c1 DecompositionConcretization) (c2 DecompositionConcretization)) (=>
	(and (edge BeInflo2CreateGraphs c1) (edge BeInflo2CreateGraphs c2))
	(= c1 c2)
)))
;BeInflo2CreateGraphs is Distinct from Browsing2MakeViews
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge BeInflo2CreateGraphs c)
	(not (edge Browsing2MakeViews c))
)))
;BeInflo2CreateGraphs is Distinct from CreateGraph2AddSourceInDescription
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge BeInflo2CreateGraphs c)
	(not (edge CreateGraph2AddSourceInDescription c))
)))
;BeInflo2CreateGraphs is Distinct from UseDiscussions2CreateDiscussions
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge BeInflo2CreateGraphs c)
	(not (edge UseDiscussions2CreateDiscussions c))
)))
;BeInflo2CreateGraphs is Distinct from ExtensiveModeration2UseAutomatedReputationSystem
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge BeInflo2CreateGraphs c)
	(not (edge ExtensiveModeration2UseAutomatedReputationSystem c))
)))
;BeInflo2CreateGraphs is Distinct from LessExtensiveModeration2UseAutomatedReputationSystem
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge BeInflo2CreateGraphs c)
	(not (edge LessExtensiveModeration2UseAutomatedReputationSystem c))
)))
;BeInflo2CreateGraphs is Distinct from BeInflo2TrackAuthorship
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge BeInflo2CreateGraphs c)
	(not (edge BeInflo2TrackAuthorship c))
)))
;BeInflo2CreateGraphs is Distinct from BeInflo2DisplayGraphs
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge BeInflo2CreateGraphs c)
	(not (edge BeInflo2DisplayGraphs c))
)))
;BeInflo2CreateGraphs is Distinct from BeInflo2TrackRevisions
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge BeInflo2CreateGraphs c)
	(not (edge BeInflo2TrackRevisions c))
)))
;ValidateModel2MakeModelsTrustworthy type constant
(assert (forall ((c ContributionConcretization)) (=>
	(edge ValidateModel2MakeModelsTrustworthy c)
	(= (type c) CONTRIBUTION_HELP)
)))
;ValidateModel2MakeModelsTrustworthy srcEndpoint constant
(assert (forall ((c ContributionConcretization)) (=>
	(edge ValidateModel2MakeModelsTrustworthy c)
	(= (srcEndpoint c) ENDPOINT_SOFTGOAL)
)))
;ValidateModel2MakeModelsTrustworthy endpoints
(assert (forall ((c ContributionConcretization)) (=>
	(edge ValidateModel2MakeModelsTrustworthy c)
	(and
		(node ValidateModel ((as src (SoftGoalConcretization)) c))
		(node MakeModelsTrustworthy (tgt c))
	)
)))
;ValidateModel2MakeModelsTrustworthy Exists
(assert	(exists ((c ContributionConcretization)) (edge ValidateModel2MakeModelsTrustworthy c)))
;ValidateModel2MakeModelsTrustworthy is Unique
(assert	(forall ((c1 ContributionConcretization) (c2 ContributionConcretization)) (=>
	(and (edge ValidateModel2MakeModelsTrustworthy c1) (edge ValidateModel2MakeModelsTrustworthy c2))
	(= c1 c2)
)))
;GetFeedback2MakeModelsTrustworthy type constant
(assert (forall ((c ContributionConcretization)) (=>
	(edge GetFeedback2MakeModelsTrustworthy c)
	(= (type c) CONTRIBUTION_HELP)
)))
;GetFeedback2MakeModelsTrustworthy srcEndpoint constant
(assert (forall ((c ContributionConcretization)) (=>
	(edge GetFeedback2MakeModelsTrustworthy c)
	(= (srcEndpoint c) ENDPOINT_SOFTGOAL)
)))
;GetFeedback2MakeModelsTrustworthy endpoints
(assert (forall ((c ContributionConcretization)) (=>
	(edge GetFeedback2MakeModelsTrustworthy c)
	(and
		(node GetFeedback ((as src (SoftGoalConcretization)) c))
		(node MakeModelsTrustworthy (tgt c))
	)
)))
;GetFeedback2MakeModelsTrustworthy Exists
(assert	(exists ((c ContributionConcretization)) (edge GetFeedback2MakeModelsTrustworthy c)))
;GetFeedback2MakeModelsTrustworthy is Unique
(assert	(forall ((c1 ContributionConcretization) (c2 ContributionConcretization)) (=>
	(and (edge GetFeedback2MakeModelsTrustworthy c1) (edge GetFeedback2MakeModelsTrustworthy c2))
	(= c1 c2)
)))
;UseDiscussions2ValidateModel type constant
(assert (forall ((c ContributionConcretization)) (=>
	(edge UseDiscussions2ValidateModel c)
	(= (type c) CONTRIBUTION_SOMEPLUS)
)))
;UseDiscussions2ValidateModel srcEndpoint constant
(assert (forall ((c ContributionConcretization)) (=>
	(edge UseDiscussions2ValidateModel c)
	(= (srcEndpoint c) ENDPOINT_TASK)
)))
;UseDiscussions2ValidateModel endpoints
(assert (forall ((c ContributionConcretization)) (=>
	(edge UseDiscussions2ValidateModel c)
	(and
		(node UseDiscussions ((as src (TaskConcretization)) c))
		(node ValidateModel (tgt c))
	)
)))
;UseDiscussions2ValidateModel Exists
(assert	(exists ((c ContributionConcretization)) (edge UseDiscussions2ValidateModel c)))
;UseDiscussions2ValidateModel is Unique
(assert	(forall ((c1 ContributionConcretization) (c2 ContributionConcretization)) (=>
	(and (edge UseDiscussions2ValidateModel c1) (edge UseDiscussions2ValidateModel c2))
	(= c1 c2)
)))
;UseDiscussions2ValidateModel is Distinct from UseDiscussions2GetFeedback
(assert	(forall ((c ContributionConcretization)) (=>
	(edge UseDiscussions2ValidateModel c)
	(not (edge UseDiscussions2GetFeedback c))
)))
;InfloBeModerated2GetFeedback type constant
(assert (forall ((c ContributionConcretization)) (=>
	(edge InfloBeModerated2GetFeedback c)
	(= (type c) CONTRIBUTION_HURT)
)))
;InfloBeModerated2GetFeedback srcEndpoint constant
(assert (forall ((c ContributionConcretization)) (=>
	(edge InfloBeModerated2GetFeedback c)
	(= (srcEndpoint c) ENDPOINT_GOAL)
)))
;InfloBeModerated2GetFeedback endpoints
(assert (forall ((c ContributionConcretization)) (=>
	(edge InfloBeModerated2GetFeedback c)
	(and
		(node InfloBeModerated ((as src (GoalConcretization)) c))
		(node GetFeedback (tgt c))
	)
)))
;InfloBeModerated2GetFeedback Exists
(assert	(exists ((c ContributionConcretization)) (edge InfloBeModerated2GetFeedback c)))
;InfloBeModerated2GetFeedback is Unique
(assert	(forall ((c1 ContributionConcretization) (c2 ContributionConcretization)) (=>
	(and (edge InfloBeModerated2GetFeedback c1) (edge InfloBeModerated2GetFeedback c2))
	(= c1 c2)
)))
;UseDiscussions2GetFeedback type constant
(assert (forall ((c ContributionConcretization)) (=>
	(edge UseDiscussions2GetFeedback c)
	(= (type c) CONTRIBUTION_HELP)
)))
;UseDiscussions2GetFeedback srcEndpoint constant
(assert (forall ((c ContributionConcretization)) (=>
	(edge UseDiscussions2GetFeedback c)
	(= (srcEndpoint c) ENDPOINT_TASK)
)))
;UseDiscussions2GetFeedback endpoints
(assert (forall ((c ContributionConcretization)) (=>
	(edge UseDiscussions2GetFeedback c)
	(and
		(node UseDiscussions ((as src (TaskConcretization)) c))
		(node GetFeedback (tgt c))
	)
)))
;UseDiscussions2GetFeedback is Unique
(assert	(forall ((c1 ContributionConcretization) (c2 ContributionConcretization)) (=>
	(and (edge UseDiscussions2GetFeedback c1) (edge UseDiscussions2GetFeedback c2))
	(= c1 c2)
)))
;UseDiscussions2GetFeedback is Distinct from UseDiscussions2ValidateModel
(assert	(forall ((c ContributionConcretization)) (=>
	(edge UseDiscussions2GetFeedback c)
	(not (edge UseDiscussions2ValidateModel c))
)))
;InfloBeModerated2Moderation srcEndpoint constant
(assert (forall ((c DependerConcretization)) (=>
	(edge InfloBeModerated2Moderation c)
	(= (srcEndpoint c) ENDPOINT_GOAL)
)))
;InfloBeModerated2Moderation tgtEndpoint constant
(assert (forall ((c DependerConcretization)) (=>
	(edge InfloBeModerated2Moderation c)
	(= (tgtEndpoint c) ENDPOINT_RESOURCE)
)))
;InfloBeModerated2Moderation endpoints
(assert (forall ((c DependerConcretization)) (=>
	(edge InfloBeModerated2Moderation c)
	(and
		(node InfloBeModerated ((as src (GoalConcretization)) c))
		(node Moderation ((as tgt (ResourceConcretization)) c))
	)
)))
;InfloBeModerated2Moderation Exists
(assert	(exists ((c DependerConcretization)) (edge InfloBeModerated2Moderation c)))
;InfloBeModerated2Moderation is Unique
(assert	(forall ((c1 DependerConcretization) (c2 DependerConcretization)) (=>
	(and (edge InfloBeModerated2Moderation c1) (edge InfloBeModerated2Moderation c2))
	(= c1 c2)
)))
;InfloBeModerated2Moderation is Distinct from AllowModeration2Moderation
(assert	(forall ((c DependerConcretization)) (=>
	(edge InfloBeModerated2Moderation c)
	(not (edge AllowModeration2Moderation c))
)))
;InfloBeModerated2Moderation is Distinct from UseInflo2Graphing
(assert	(forall ((c DependerConcretization)) (=>
	(edge InfloBeModerated2Moderation c)
	(not (edge UseInflo2Graphing c))
)))
;AllowModeration2Moderation srcEndpoint constant
(assert (forall ((c DependerConcretization)) (=>
	(edge AllowModeration2Moderation c)
	(= (srcEndpoint c) ENDPOINT_GOAL)
)))
;AllowModeration2Moderation tgtEndpoint constant
(assert (forall ((c DependerConcretization)) (=>
	(edge AllowModeration2Moderation c)
	(= (tgtEndpoint c) ENDPOINT_RESOURCE)
)))
;AllowModeration2Moderation endpoints
(assert (forall ((c DependerConcretization)) (=>
	(edge AllowModeration2Moderation c)
	(and
		(node AllowModeration ((as src (GoalConcretization)) c))
		(node Moderation ((as tgt (ResourceConcretization)) c))
	)
)))
;AllowModeration2Moderation Exists
(assert	(exists ((c DependerConcretization)) (edge AllowModeration2Moderation c)))
;AllowModeration2Moderation is Unique
(assert	(forall ((c1 DependerConcretization) (c2 DependerConcretization)) (=>
	(and (edge AllowModeration2Moderation c1) (edge AllowModeration2Moderation c2))
	(= c1 c2)
)))
;AllowModeration2Moderation is Distinct from InfloBeModerated2Moderation
(assert	(forall ((c DependerConcretization)) (=>
	(edge AllowModeration2Moderation c)
	(not (edge InfloBeModerated2Moderation c))
)))
;AllowModeration2Moderation is Distinct from UseInflo2Graphing
(assert	(forall ((c DependerConcretization)) (=>
	(edge AllowModeration2Moderation c)
	(not (edge UseInflo2Graphing c))
)))
;UseInflo2Graphing srcEndpoint constant
(assert (forall ((c DependerConcretization)) (=>
	(edge UseInflo2Graphing c)
	(= (srcEndpoint c) ENDPOINT_GOAL)
)))
;UseInflo2Graphing tgtEndpoint constant
(assert (forall ((c DependerConcretization)) (=>
	(edge UseInflo2Graphing c)
	(= (tgtEndpoint c) ENDPOINT_RESOURCE)
)))
;UseInflo2Graphing endpoints
(assert (forall ((c DependerConcretization)) (=>
	(edge UseInflo2Graphing c)
	(and
		(node UseInflo ((as src (GoalConcretization)) c))
		(node Graphing ((as tgt (ResourceConcretization)) c))
	)
)))
;UseInflo2Graphing Exists
(assert	(exists ((c DependerConcretization)) (edge UseInflo2Graphing c)))
;UseInflo2Graphing is Unique
(assert	(forall ((c1 DependerConcretization) (c2 DependerConcretization)) (=>
	(and (edge UseInflo2Graphing c1) (edge UseInflo2Graphing c2))
	(= c1 c2)
)))
;UseInflo2Graphing is Distinct from InfloBeModerated2Moderation
(assert	(forall ((c DependerConcretization)) (=>
	(edge UseInflo2Graphing c)
	(not (edge InfloBeModerated2Moderation c))
)))
;UseInflo2Graphing is Distinct from AllowModeration2Moderation
(assert	(forall ((c DependerConcretization)) (=>
	(edge UseInflo2Graphing c)
	(not (edge AllowModeration2Moderation c))
)))
;UseAutomatedReputationSystem2ReputationValues srcEndpoint constant
(assert (forall ((c DependerConcretization)) (=>
	(edge UseAutomatedReputationSystem2ReputationValues c)
	(= (srcEndpoint c) ENDPOINT_TASK)
)))
;UseAutomatedReputationSystem2ReputationValues tgtEndpoint constant
(assert (forall ((c DependerConcretization)) (=>
	(edge UseAutomatedReputationSystem2ReputationValues c)
	(= (tgtEndpoint c) ENDPOINT_RESOURCE)
)))
;UseAutomatedReputationSystem2ReputationValues endpoints
(assert (forall ((c DependerConcretization)) (=>
	(edge UseAutomatedReputationSystem2ReputationValues c)
	(and
		(node UseAutomatedReputationSystem ((as src (TaskConcretization)) c))
		(node ReputationValues ((as tgt (ResourceConcretization)) c))
	)
)))
;UseAutomatedReputationSystem2ReputationValues Exists
(assert	(exists ((c DependerConcretization)) (edge UseAutomatedReputationSystem2ReputationValues c)))
;UseAutomatedReputationSystem2ReputationValues is Unique
(assert	(forall ((c1 DependerConcretization) (c2 DependerConcretization)) (=>
	(and (edge UseAutomatedReputationSystem2ReputationValues c1) (edge UseAutomatedReputationSystem2ReputationValues c2))
	(= c1 c2)
)))
;UseAutomatedReputationSystem2ReputationValues is Distinct from AddSourceInDescription2Info
(assert	(forall ((c DependerConcretization)) (=>
	(edge UseAutomatedReputationSystem2ReputationValues c)
	(not (edge AddSourceInDescription2Info c))
)))
;UseAutomatedReputationSystem2ReputationValues is Distinct from TrackAuthorship2Authorship
(assert	(forall ((c DependerConcretization)) (=>
	(edge UseAutomatedReputationSystem2ReputationValues c)
	(not (edge TrackAuthorship2Authorship c))
)))
;AddSourceInDescription2Info srcEndpoint constant
(assert (forall ((c DependerConcretization)) (=>
	(edge AddSourceInDescription2Info c)
	(= (srcEndpoint c) ENDPOINT_TASK)
)))
;AddSourceInDescription2Info tgtEndpoint constant
(assert (forall ((c DependerConcretization)) (=>
	(edge AddSourceInDescription2Info c)
	(= (tgtEndpoint c) ENDPOINT_RESOURCE)
)))
;AddSourceInDescription2Info endpoints
(assert (forall ((c DependerConcretization)) (=>
	(edge AddSourceInDescription2Info c)
	(and
		(node AddSourceInDescription ((as src (TaskConcretization)) c))
		(node Info ((as tgt (ResourceConcretization)) c))
	)
)))
;AddSourceInDescription2Info Exists
(assert	(exists ((c DependerConcretization)) (edge AddSourceInDescription2Info c)))
;AddSourceInDescription2Info is Unique
(assert	(forall ((c1 DependerConcretization) (c2 DependerConcretization)) (=>
	(and (edge AddSourceInDescription2Info c1) (edge AddSourceInDescription2Info c2))
	(= c1 c2)
)))
;AddSourceInDescription2Info is Distinct from UseAutomatedReputationSystem2ReputationValues
(assert	(forall ((c DependerConcretization)) (=>
	(edge AddSourceInDescription2Info c)
	(not (edge UseAutomatedReputationSystem2ReputationValues c))
)))
;AddSourceInDescription2Info is Distinct from TrackAuthorship2Authorship
(assert	(forall ((c DependerConcretization)) (=>
	(edge AddSourceInDescription2Info c)
	(not (edge TrackAuthorship2Authorship c))
)))
;TrackAuthorship2Authorship srcEndpoint constant
(assert (forall ((c DependerConcretization)) (=>
	(edge TrackAuthorship2Authorship c)
	(= (srcEndpoint c) ENDPOINT_TASK)
)))
;TrackAuthorship2Authorship tgtEndpoint constant
(assert (forall ((c DependerConcretization)) (=>
	(edge TrackAuthorship2Authorship c)
	(= (tgtEndpoint c) ENDPOINT_RESOURCE)
)))
;TrackAuthorship2Authorship endpoints
(assert (forall ((c DependerConcretization)) (=>
	(edge TrackAuthorship2Authorship c)
	(and
		(node TrackAuthorship ((as src (TaskConcretization)) c))
		(node Authorship ((as tgt (ResourceConcretization)) c))
	)
)))
;TrackAuthorship2Authorship is Unique
(assert	(forall ((c1 DependerConcretization) (c2 DependerConcretization)) (=>
	(and (edge TrackAuthorship2Authorship c1) (edge TrackAuthorship2Authorship c2))
	(= c1 c2)
)))
;TrackAuthorship2Authorship is Distinct from UseAutomatedReputationSystem2ReputationValues
(assert	(forall ((c DependerConcretization)) (=>
	(edge TrackAuthorship2Authorship c)
	(not (edge UseAutomatedReputationSystem2ReputationValues c))
)))
;TrackAuthorship2Authorship is Distinct from AddSourceInDescription2Info
(assert	(forall ((c DependerConcretization)) (=>
	(edge TrackAuthorship2Authorship c)
	(not (edge AddSourceInDescription2Info c))
)))
;Moderation2ModerateInflo srcEndpoint constant
(assert (forall ((c DependeeConcretization)) (=>
	(edge Moderation2ModerateInflo c)
	(= (srcEndpoint c) ENDPOINT_RESOURCE)
)))
;Moderation2ModerateInflo tgtEndpoint constant
(assert (forall ((c DependeeConcretization)) (=>
	(edge Moderation2ModerateInflo c)
	(= (tgtEndpoint c) ENDPOINT_GOAL)
)))
;Moderation2ModerateInflo endpoints
(assert (forall ((c DependeeConcretization)) (=>
	(edge Moderation2ModerateInflo c)
	(and
		(node Moderation ((as src (ResourceConcretization)) c))
		(node ModerateInflo ((as tgt (GoalConcretization)) c))
	)
)))
;Moderation2ModerateInflo is Unique
(assert	(forall ((c1 DependeeConcretization) (c2 DependeeConcretization)) (=>
	(and (edge Moderation2ModerateInflo c1) (edge Moderation2ModerateInflo c2))
	(= c1 c2)
)))
;Moderation2ExtensiveModeration srcEndpoint constant
(assert (forall ((c DependeeConcretization)) (=>
	(edge Moderation2ExtensiveModeration c)
	(= (srcEndpoint c) ENDPOINT_RESOURCE)
)))
;Moderation2ExtensiveModeration tgtEndpoint constant
(assert (forall ((c DependeeConcretization)) (=>
	(edge Moderation2ExtensiveModeration c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;Moderation2ExtensiveModeration endpoints
(assert (forall ((c DependeeConcretization)) (=>
	(edge Moderation2ExtensiveModeration c)
	(and
		(node Moderation ((as src (ResourceConcretization)) c))
		(node ExtensiveModeration ((as tgt (TaskConcretization)) c))
	)
)))
;Moderation2ExtensiveModeration is Unique
(assert	(forall ((c1 DependeeConcretization) (c2 DependeeConcretization)) (=>
	(and (edge Moderation2ExtensiveModeration c1) (edge Moderation2ExtensiveModeration c2))
	(= c1 c2)
)))
;Moderation2ExtensiveModeration is Distinct from Moderation2ModerationARS
(assert	(forall ((c DependeeConcretization)) (=>
	(edge Moderation2ExtensiveModeration c)
	(not (edge Moderation2ModerationARS c))
)))
;Moderation2ExtensiveModeration is Distinct from Graphing2BeInflo
(assert	(forall ((c DependeeConcretization)) (=>
	(edge Moderation2ExtensiveModeration c)
	(not (edge Graphing2BeInflo c))
)))
;Moderation2ExtensiveModeration is Distinct from ReputationValues2ProvideReputations
(assert	(forall ((c DependeeConcretization)) (=>
	(edge Moderation2ExtensiveModeration c)
	(not (edge ReputationValues2ProvideReputations c))
)))
;Moderation2ExtensiveModeration is Distinct from Authorship2CreateGraph
(assert	(forall ((c DependeeConcretization)) (=>
	(edge Moderation2ExtensiveModeration c)
	(not (edge Authorship2CreateGraph c))
)))
;Moderation2ExtensiveModeration is Distinct from Authorship2CreateDiscussions
(assert	(forall ((c DependeeConcretization)) (=>
	(edge Moderation2ExtensiveModeration c)
	(not (edge Authorship2CreateDiscussions c))
)))
;Moderation2ModerationARS srcEndpoint constant
(assert (forall ((c DependeeConcretization)) (=>
	(edge Moderation2ModerationARS c)
	(= (srcEndpoint c) ENDPOINT_RESOURCE)
)))
;Moderation2ModerationARS tgtEndpoint constant
(assert (forall ((c DependeeConcretization)) (=>
	(edge Moderation2ModerationARS c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;Moderation2ModerationARS endpoints
(assert (forall ((c DependeeConcretization)) (=>
	(edge Moderation2ModerationARS c)
	(and
		(node Moderation ((as src (ResourceConcretization)) c))
		(node ModerationARS ((as tgt (TaskConcretization)) c))
	)
)))
;Moderation2ModerationARS is Unique
(assert	(forall ((c1 DependeeConcretization) (c2 DependeeConcretization)) (=>
	(and (edge Moderation2ModerationARS c1) (edge Moderation2ModerationARS c2))
	(= c1 c2)
)))
;Moderation2ModerationARS is Distinct from Moderation2ExtensiveModeration
(assert	(forall ((c DependeeConcretization)) (=>
	(edge Moderation2ModerationARS c)
	(not (edge Moderation2ExtensiveModeration c))
)))
;Moderation2ModerationARS is Distinct from Graphing2BeInflo
(assert	(forall ((c DependeeConcretization)) (=>
	(edge Moderation2ModerationARS c)
	(not (edge Graphing2BeInflo c))
)))
;Moderation2ModerationARS is Distinct from ReputationValues2ProvideReputations
(assert	(forall ((c DependeeConcretization)) (=>
	(edge Moderation2ModerationARS c)
	(not (edge ReputationValues2ProvideReputations c))
)))
;Moderation2ModerationARS is Distinct from Authorship2CreateGraph
(assert	(forall ((c DependeeConcretization)) (=>
	(edge Moderation2ModerationARS c)
	(not (edge Authorship2CreateGraph c))
)))
;Moderation2ModerationARS is Distinct from Authorship2CreateDiscussions
(assert	(forall ((c DependeeConcretization)) (=>
	(edge Moderation2ModerationARS c)
	(not (edge Authorship2CreateDiscussions c))
)))
;Graphing2BeInflo srcEndpoint constant
(assert (forall ((c DependeeConcretization)) (=>
	(edge Graphing2BeInflo c)
	(= (srcEndpoint c) ENDPOINT_RESOURCE)
)))
;Graphing2BeInflo tgtEndpoint constant
(assert (forall ((c DependeeConcretization)) (=>
	(edge Graphing2BeInflo c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;Graphing2BeInflo endpoints
(assert (forall ((c DependeeConcretization)) (=>
	(edge Graphing2BeInflo c)
	(and
		(node Graphing ((as src (ResourceConcretization)) c))
		(node BeInflo ((as tgt (TaskConcretization)) c))
	)
)))
;Graphing2BeInflo Exists
(assert	(exists ((c DependeeConcretization)) (edge Graphing2BeInflo c)))
;Graphing2BeInflo is Unique
(assert	(forall ((c1 DependeeConcretization) (c2 DependeeConcretization)) (=>
	(and (edge Graphing2BeInflo c1) (edge Graphing2BeInflo c2))
	(= c1 c2)
)))
;Graphing2BeInflo is Distinct from Moderation2ExtensiveModeration
(assert	(forall ((c DependeeConcretization)) (=>
	(edge Graphing2BeInflo c)
	(not (edge Moderation2ExtensiveModeration c))
)))
;Graphing2BeInflo is Distinct from Moderation2ModerationARS
(assert	(forall ((c DependeeConcretization)) (=>
	(edge Graphing2BeInflo c)
	(not (edge Moderation2ModerationARS c))
)))
;Graphing2BeInflo is Distinct from ReputationValues2ProvideReputations
(assert	(forall ((c DependeeConcretization)) (=>
	(edge Graphing2BeInflo c)
	(not (edge ReputationValues2ProvideReputations c))
)))
;Graphing2BeInflo is Distinct from Authorship2CreateGraph
(assert	(forall ((c DependeeConcretization)) (=>
	(edge Graphing2BeInflo c)
	(not (edge Authorship2CreateGraph c))
)))
;Graphing2BeInflo is Distinct from Authorship2CreateDiscussions
(assert	(forall ((c DependeeConcretization)) (=>
	(edge Graphing2BeInflo c)
	(not (edge Authorship2CreateDiscussions c))
)))
;ReputationValues2ProvideReputations srcEndpoint constant
(assert (forall ((c DependeeConcretization)) (=>
	(edge ReputationValues2ProvideReputations c)
	(= (srcEndpoint c) ENDPOINT_RESOURCE)
)))
;ReputationValues2ProvideReputations tgtEndpoint constant
(assert (forall ((c DependeeConcretization)) (=>
	(edge ReputationValues2ProvideReputations c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;ReputationValues2ProvideReputations endpoints
(assert (forall ((c DependeeConcretization)) (=>
	(edge ReputationValues2ProvideReputations c)
	(and
		(node ReputationValues ((as src (ResourceConcretization)) c))
		(node ProvideReputations ((as tgt (TaskConcretization)) c))
	)
)))
;ReputationValues2ProvideReputations Exists
(assert	(exists ((c DependeeConcretization)) (edge ReputationValues2ProvideReputations c)))
;ReputationValues2ProvideReputations is Unique
(assert	(forall ((c1 DependeeConcretization) (c2 DependeeConcretization)) (=>
	(and (edge ReputationValues2ProvideReputations c1) (edge ReputationValues2ProvideReputations c2))
	(= c1 c2)
)))
;ReputationValues2ProvideReputations is Distinct from Moderation2ExtensiveModeration
(assert	(forall ((c DependeeConcretization)) (=>
	(edge ReputationValues2ProvideReputations c)
	(not (edge Moderation2ExtensiveModeration c))
)))
;ReputationValues2ProvideReputations is Distinct from Moderation2ModerationARS
(assert	(forall ((c DependeeConcretization)) (=>
	(edge ReputationValues2ProvideReputations c)
	(not (edge Moderation2ModerationARS c))
)))
;ReputationValues2ProvideReputations is Distinct from Graphing2BeInflo
(assert	(forall ((c DependeeConcretization)) (=>
	(edge ReputationValues2ProvideReputations c)
	(not (edge Graphing2BeInflo c))
)))
;ReputationValues2ProvideReputations is Distinct from Authorship2CreateGraph
(assert	(forall ((c DependeeConcretization)) (=>
	(edge ReputationValues2ProvideReputations c)
	(not (edge Authorship2CreateGraph c))
)))
;ReputationValues2ProvideReputations is Distinct from Authorship2CreateDiscussions
(assert	(forall ((c DependeeConcretization)) (=>
	(edge ReputationValues2ProvideReputations c)
	(not (edge Authorship2CreateDiscussions c))
)))
;Authorship2CreateGraph srcEndpoint constant
(assert (forall ((c DependeeConcretization)) (=>
	(edge Authorship2CreateGraph c)
	(= (srcEndpoint c) ENDPOINT_RESOURCE)
)))
;Authorship2CreateGraph tgtEndpoint constant
(assert (forall ((c DependeeConcretization)) (=>
	(edge Authorship2CreateGraph c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;Authorship2CreateGraph endpoints
(assert (forall ((c DependeeConcretization)) (=>
	(edge Authorship2CreateGraph c)
	(and
		(node Authorship ((as src (ResourceConcretization)) c))
		(node CreateGraph ((as tgt (TaskConcretization)) c))
	)
)))
;Authorship2CreateGraph is Unique
(assert	(forall ((c1 DependeeConcretization) (c2 DependeeConcretization)) (=>
	(and (edge Authorship2CreateGraph c1) (edge Authorship2CreateGraph c2))
	(= c1 c2)
)))
;Authorship2CreateGraph is Distinct from Moderation2ExtensiveModeration
(assert	(forall ((c DependeeConcretization)) (=>
	(edge Authorship2CreateGraph c)
	(not (edge Moderation2ExtensiveModeration c))
)))
;Authorship2CreateGraph is Distinct from Moderation2ModerationARS
(assert	(forall ((c DependeeConcretization)) (=>
	(edge Authorship2CreateGraph c)
	(not (edge Moderation2ModerationARS c))
)))
;Authorship2CreateGraph is Distinct from Graphing2BeInflo
(assert	(forall ((c DependeeConcretization)) (=>
	(edge Authorship2CreateGraph c)
	(not (edge Graphing2BeInflo c))
)))
;Authorship2CreateGraph is Distinct from ReputationValues2ProvideReputations
(assert	(forall ((c DependeeConcretization)) (=>
	(edge Authorship2CreateGraph c)
	(not (edge ReputationValues2ProvideReputations c))
)))
;Authorship2CreateGraph is Distinct from Authorship2CreateDiscussions
(assert	(forall ((c DependeeConcretization)) (=>
	(edge Authorship2CreateGraph c)
	(not (edge Authorship2CreateDiscussions c))
)))
;Authorship2CreateDiscussions srcEndpoint constant
(assert (forall ((c DependeeConcretization)) (=>
	(edge Authorship2CreateDiscussions c)
	(= (srcEndpoint c) ENDPOINT_RESOURCE)
)))
;Authorship2CreateDiscussions tgtEndpoint constant
(assert (forall ((c DependeeConcretization)) (=>
	(edge Authorship2CreateDiscussions c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;Authorship2CreateDiscussions endpoints
(assert (forall ((c DependeeConcretization)) (=>
	(edge Authorship2CreateDiscussions c)
	(and
		(node Authorship ((as src (ResourceConcretization)) c))
		(node CreateDiscussions ((as tgt (TaskConcretization)) c))
	)
)))
;Authorship2CreateDiscussions is Unique
(assert	(forall ((c1 DependeeConcretization) (c2 DependeeConcretization)) (=>
	(and (edge Authorship2CreateDiscussions c1) (edge Authorship2CreateDiscussions c2))
	(= c1 c2)
)))
;Authorship2CreateDiscussions is Distinct from Moderation2ExtensiveModeration
(assert	(forall ((c DependeeConcretization)) (=>
	(edge Authorship2CreateDiscussions c)
	(not (edge Moderation2ExtensiveModeration c))
)))
;Authorship2CreateDiscussions is Distinct from Moderation2ModerationARS
(assert	(forall ((c DependeeConcretization)) (=>
	(edge Authorship2CreateDiscussions c)
	(not (edge Moderation2ModerationARS c))
)))
;Authorship2CreateDiscussions is Distinct from Graphing2BeInflo
(assert	(forall ((c DependeeConcretization)) (=>
	(edge Authorship2CreateDiscussions c)
	(not (edge Graphing2BeInflo c))
)))
;Authorship2CreateDiscussions is Distinct from ReputationValues2ProvideReputations
(assert	(forall ((c DependeeConcretization)) (=>
	(edge Authorship2CreateDiscussions c)
	(not (edge ReputationValues2ProvideReputations c))
)))
;Authorship2CreateDiscussions is Distinct from Authorship2CreateGraph
(assert	(forall ((c DependeeConcretization)) (=>
	(edge Authorship2CreateDiscussions c)
	(not (edge Authorship2CreateGraph c))
)))


;Goal propagation (MeansEnd + Depender + Dependee)
(assert	(forall ((c GoalConcretization)) (=> (not (inited c)) (= (fs c) (ite
	(or
		(and (exists ((mec MeansEndConcretization)) (and (= (tgt mec) c) (fs mec))) (not (exists ((dc DependerConcretization)) (and (= (srcEndpoint dc) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc) c) (or (fd dc) (pd dc) (co dc) (un dc) (n dc) (ps dc))))))
		(and (exists ((dc1 DependerConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc1) c) (fs dc1))) (not (exists ((dc2 DependerConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (n dc2) (ps dc2))))))
		(and (exists ((dc1 DependeeConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc1) c) (fs dc1))) (not (exists ((dc2 DependeeConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (n dc2) (ps dc2))))))
	)
	true
	false
)))))
(assert	(forall ((c GoalConcretization)) (=> (not (inited c)) (= (ps c) (ite
	(or
		(and (exists ((mec1 MeansEndConcretization)) (and (= (tgt mec1) c) (ps mec1))) (and (not (exists ((mec2 MeansEndConcretization)) (and (= (tgt mec2) c) (fs mec2)))) (not (exists ((dc DependerConcretization)) (and (= (srcEndpoint dc) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc) c) (or (fd dc) (pd dc) (co dc) (un dc) (n dc)))))))
		(and (exists ((dc1 DependerConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc1) c) (ps dc1))) (not (exists ((dc2 DependerConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (n dc2))))))
		(and (exists ((dc1 DependeeConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc1) c) (ps dc1))) (not (exists ((dc2 DependeeConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (n dc2))))))
	)
	true
	false
)))))
(assert (forall ((c GoalConcretization)) (=> (not (inited c)) (= (n c) (ite
	(or
		(and (not (exists ((mec MeansEndConcretization)) (= (tgt mec) c))) (not (exists ((dc1 DependerConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc1) c)))) (not (exists ((dc2 DependeeConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc2) c)))))
		(and (exists ((mec1 MeansEndConcretization)) (and (= (tgt mec1) c) (n mec1))) (and (not (exists ((mec2 MeansEndConcretization)) (and (= (tgt mec2) c) (or (fs mec2) (ps mec2) (un mec2) (co mec2) (pd mec2) (fd mec2))))) (not (exists ((dc DependerConcretization)) (and (= (srcEndpoint dc) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc) c) (or (fd dc) (pd dc) (co dc) (un dc)))))))
		(and (exists ((dc1 DependerConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc1) c) (n dc1))) (not (exists ((dc2 DependerConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2))))))
		(and (exists ((dc1 DependeeConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc1) c) (n dc1))) (not (exists ((dc2 DependeeConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2))))))
	)
	true
	false
)))))
(assert	(forall ((c GoalConcretization)) (=> (not (inited c)) (= (un c) (ite
	(or
		(and (exists ((mec1 MeansEndConcretization)) (and (= (tgt mec1) c) (un mec1))) (and (not (exists ((mec2 MeansEndConcretization)) (and (= (tgt mec2) c) (or (fs mec2) (ps mec2))))) (not (exists ((dc DependerConcretization)) (and (= (srcEndpoint dc) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc) c) (or (fd dc) (pd dc) (co dc)))))))
		(and (exists ((dc1 DependerConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc1) c) (un dc1))) (not (exists ((dc2 DependerConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc2) c) (or (fd dc2) (pd dc2) (co dc2))))))
		(and (exists ((dc1 DependeeConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc1) c) (un dc1))) (not (exists ((dc2 DependeeConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc2) c) (or (fd dc2) (pd dc2) (co dc2))))))
	)
	true
	false
)))))
(assert	(forall ((c GoalConcretization)) (=> (not (inited c)) (= (co c) (ite
	(or
		(and (exists ((mec1 MeansEndConcretization)) (and (= (tgt mec1) c) (co mec1))) (and (not (exists ((mec2 MeansEndConcretization)) (and (= (tgt mec2) c) (or (fs mec2) (ps mec2) (un mec2))))) (not (exists ((dc DependerConcretization)) (and (= (srcEndpoint dc) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc) c) (or (fd dc) (pd dc)))))))
		(and (exists ((dc1 DependerConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc1) c) (co dc1))) (not (exists ((dc2 DependerConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc2) c) (or (fd dc2) (pd dc2))))))
		(and (exists ((dc1 DependeeConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc1) c) (co dc1))) (not (exists ((dc2 DependeeConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc2) c) (or (fd dc2) (pd dc2))))))
	)
	true
	false
)))))
(assert	(forall ((c GoalConcretization)) (=> (not (inited c)) (= (pd c) (ite
	(or
		(and (exists ((mec1 MeansEndConcretization)) (and (= (tgt mec1) c) (pd mec1))) (and (not (exists ((mec2 MeansEndConcretization)) (and (= (tgt mec2) c) (or (fs mec2) (ps mec2) (un mec2) (co mec2))))) (not (exists ((dc DependerConcretization)) (and (= (srcEndpoint dc) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc) c) (fd dc))))))
		(and (exists ((dc1 DependerConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc1) c) (pd dc1))) (not (exists ((dc2 DependerConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc2) c) (fd dc2)))))
		(and (exists ((dc1 DependeeConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc1) c) (pd dc1))) (not (exists ((dc2 DependeeConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc2) c) (fd dc2)))))
	)
	true
	false
)))))
(assert	(forall ((c GoalConcretization)) (=> (not (inited c)) (= (fd c) (ite
	(or
		(and (exists ((mec1 MeansEndConcretization)) (and (= (tgt mec1) c) (fd mec1))) (not (exists ((mec2 MeansEndConcretization)) (and (= (tgt mec2) c) (or (fs mec2) (ps mec2) (un mec2) (co mec2) (pd mec2))))))
		(exists ((dc DependerConcretization)) (and (= (srcEndpoint dc) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc) c) (fd dc)))
		(exists ((dc DependeeConcretization)) (and (= (srcEndpoint dc) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc) c) (fd dc)))
	)
	true
	false
)))))

;Task propagation (Decomposition + Depender)
(assert (forall ((c TaskConcretization)) (=> (not (inited c)) (= (fd c) (ite
	(or
		(exists ((dc DecompositionConcretization)) (and (= (src dc) c) (fd dc)))
		(exists ((dc DependerConcretization)) (and (= (srcEndpoint dc) ENDPOINT_TASK) (= ((as src (TaskConcretization)) dc) c) (fd dc)))
	)
	true
	false
)))))
(assert (forall ((c TaskConcretization)) (=> (not (inited c))  (= (pd c) (ite
	(or
		(and (exists ((dc1 DecompositionConcretization)) (and (= (src dc1) c) (pd dc1))) (not (exists ((dc2 DecompositionConcretization)) (and (= (src dc2) c) (fd dc2)))) (not (exists ((dc3 DependerConcretization)) (and (= (srcEndpoint dc3) ENDPOINT_TASK) (= ((as src (TaskConcretization)) dc3) c) (fd dc3)))))
		(and (exists ((dc1 DependerConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_TASK) (= ((as src (TaskConcretization)) dc1) c) (pd dc1))) (not (exists ((dc2 DependerConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_TASK) (= ((as src (TaskConcretization)) dc2) c) (fd dc2)))) (not (exists ((dc3 DecompositionConcretization)) (and (= (src dc3) c) (fd dc3)))))
	)
	true
	false
)))))
(assert (forall ((c TaskConcretization)) (=> (not (inited c))  (= (co c) (ite
	(or
		(and (exists ((dc1 DecompositionConcretization)) (and (= (src dc1) c) (co dc1))) (not (exists ((dc2 DecompositionConcretization)) (and (= (src dc2) c) (or (fd dc2) (pd dc2))))) (not (exists ((dc3 DependerConcretization)) (and (= (srcEndpoint dc3) ENDPOINT_TASK) (= ((as src (TaskConcretization)) dc3) c) (or (fd dc3) (pd dc3))))))
		(and (exists ((dc1 DependerConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_TASK) (= ((as src (TaskConcretization)) dc1) c) (co dc1))) (not (exists ((dc2 DependerConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_TASK) (= ((as src (TaskConcretization)) dc2) c) (or (fd dc2) (pd dc2))))) (not (exists ((dc3 DecompositionConcretization)) (and (= (src dc3) c) (or (fd dc3) (pd dc3))))))
	)
	true
	false
)))))
(assert (forall ((c TaskConcretization)) (=> (not (inited c))  (= (un c) (ite
	(or
		(and (exists ((dc1 DecompositionConcretization)) (and (= (src dc1) c) (un dc1))) (not (exists ((dc2 DecompositionConcretization)) (and (= (src dc2) c) (or (fd dc2) (pd dc2) (co dc2))))) (not (exists ((dc3 DependerConcretization)) (and (= (srcEndpoint dc3) ENDPOINT_TASK) (= ((as src (TaskConcretization)) dc3) c) (or (fd dc3) (pd dc3) (co dc3))))))
		(and (exists ((dc1 DependerConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_TASK) (= ((as src (TaskConcretization)) dc1) c) (un dc1))) (not (exists ((dc2 DependerConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_TASK) (= ((as src (TaskConcretization)) dc2) c) (or (fd dc2) (pd dc2) (co dc2))))) (not (exists ((dc3 DecompositionConcretization)) (and (= (src dc3) c) (or (fd dc3) (pd dc3) (co dc3))))))
	)
	true
	false
)))))
(assert (forall ((c TaskConcretization)) (=> (not (inited c)) (= (n c) (ite
	(or
		(and (not (exists ((dc1 DecompositionConcretization)) (= (src dc1) c))) (not (exists ((dc2 DependerConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_TASK) (= ((as src (TaskConcretization)) dc2) c)))))
		(and (exists ((dc1 DecompositionConcretization)) (and (= (src dc1) c) (n dc1))) (not (exists ((dc2 DecompositionConcretization)) (and (= (src dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2))))) (not (exists ((dc3 DependerConcretization)) (and (= (srcEndpoint dc3) ENDPOINT_TASK) (= ((as src (TaskConcretization)) dc3) c) (or (fd dc3) (pd dc3) (co dc3) (un dc3))))))
		(and (exists ((dc1 DependerConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_TASK) (= ((as src (TaskConcretization)) dc1) c) (n dc1))) (not (exists ((dc2 DependerConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_TASK) (= ((as src (TaskConcretization)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2))))) (not (exists ((dc3 DecompositionConcretization)) (and (= (src dc3) c) (or (fd dc3) (pd dc3) (co dc3) (un dc3))))))
	)
	true
	false
)))))
(assert (forall ((c TaskConcretization)) (=> (not (inited c))  (= (ps c) (ite
	(or
		(and (exists ((dc1 DecompositionConcretization)) (and (= (src dc1) c) (ps dc1))) (not (exists ((dc2 DecompositionConcretization)) (and (= (src dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (n dc2))))) (not (exists ((dc3 DependerConcretization)) (and (= (srcEndpoint dc3) ENDPOINT_TASK) (= ((as src (TaskConcretization)) dc3) c) (or (fd dc3) (pd dc3) (co dc3) (un dc3) (n dc3))))))
		(and (exists ((dc1 DependerConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_TASK) (= ((as src (TaskConcretization)) dc1) c) (ps dc1))) (not (exists ((dc2 DependerConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_TASK) (= ((as src (TaskConcretization)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (n dc2))))) (not (exists ((dc3 DecompositionConcretization)) (and (= (src dc3) c) (or (fd dc3) (pd dc3) (co dc3) (un dc3) (n dc3))))))
	)
	true
	false
)))))
(assert (forall ((c TaskConcretization)) (=> (not (inited c))  (= (fs c) (ite
	(or
		(and (exists ((dc1 DecompositionConcretization)) (and (= (src dc1) c) (fs dc1))) (not (exists ((dc2 DecompositionConcretization)) (and (= (src dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (n dc2) (ps dc2))))) (not (exists ((dc3 DependerConcretization)) (and (= (srcEndpoint dc3) ENDPOINT_TASK) (= ((as src (TaskConcretization)) dc3) c) (or (fd dc3) (pd dc3) (co dc3) (un dc3) (n dc3) (ps dc3))))))
		(and (exists ((dc1 DependerConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_TASK) (= ((as src (TaskConcretization)) dc1) c) (fs dc1))) (not (exists ((dc2 DependerConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_TASK) (= ((as src (TaskConcretization)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (n dc2) (ps dc2))))) (not (exists ((dc3 DecompositionConcretization)) (and (= (src dc3) c) (or (fd dc3) (pd dc3) (co dc3) (un dc3) (n dc3) (ps dc3))))))
	)
	true
	false
)))))

;SoftGoal propagation (only Contribution)
(assert (forall ((c SoftGoalConcretization)) (=> (not (inited c)) (= (n c) (ite
	(or
		(not (exists ((cc ContributionConcretization)) (= (tgt cc) c)))
		(and (exists ((cc1 ContributionConcretization)) (and (= (tgt cc1) c) (n cc1))) (not (exists ((cc2 ContributionConcretization)) (and (= (tgt cc2) c) (or (fs cc2) (ps cc2) (un cc2) (co cc2) (pd cc2) (fd cc2))))))
	)
	true
	false
)))))
(assert (forall ((c SoftGoalConcretization)) (=> (not (inited c)) (= (co c) (ite
	(or (exists ((cc1 ContributionConcretization)) (and (= (tgt cc1) c) (co cc1))) (exists ((cc2 ContributionConcretization) (cc3 ContributionConcretization)) (and (= (tgt cc2) c) (and (= (tgt cc3) c) (and (or (fs cc2) (ps cc2)) (or (pd cc3) (fd cc3)))))))
	true
	false
)))))
(assert (forall ((c SoftGoalConcretization)) (=> (not (inited c)) (= (un c) (ite
	(and (exists ((cc1 ContributionConcretization)) (and (= (tgt cc1) c) (un cc1))) (not (exists ((cc2 ContributionConcretization)) (and (= (tgt cc2) c) (co cc2)))) (not (exists ((cc3 ContributionConcretization) (cc4 ContributionConcretization)) (and (= (tgt cc3) c) (and (= (tgt cc4) c) (and (or (fs cc3) (ps cc3)) (or (pd cc4) (fd cc4))))))))
	true
	false
)))))
(assert (forall ((c SoftGoalConcretization)) (=> (not (inited c)) (= (fs c) (ite
	(and (exists ((cc1 ContributionConcretization)) (and (= (tgt cc1) c) (fs cc1))) (not (exists ((cc2 ContributionConcretization)) (and (= (tgt cc2) c) (or (un cc2) (co cc2) (pd cc2) (fd cc2))))))
	true
	false
)))))
(assert (forall ((c SoftGoalConcretization)) (=> (not (inited c)) (= (ps c) (ite
	(and (exists ((cc1 ContributionConcretization)) (and (= (tgt cc1) c) (ps cc1))) (not (exists ((cc2 ContributionConcretization)) (and (= (tgt cc2) c) (or (fs cc2) (un cc2) (co cc2) (pd cc2) (fd cc2))))))
	true
	false
)))))
(assert (forall ((c SoftGoalConcretization)) (=> (not (inited c)) (= (fd c) (ite
	(and (exists ((cc1 ContributionConcretization)) (and (= (tgt cc1) c) (fd cc1))) (not (exists ((cc2 ContributionConcretization)) (and (= (tgt cc2) c) (or (fs cc2) (ps cc2) (un cc2) (co cc2))))))
	true
	false
)))))
(assert (forall ((c SoftGoalConcretization)) (=> (not (inited c)) (= (pd c) (ite
	(and (exists ((cc1 ContributionConcretization)) (and (= (tgt cc1) c) (pd cc1))) (not (exists ((cc2 ContributionConcretization)) (and (= (tgt cc2) c) (or (fs cc2) (ps cc2) (un cc2) (co cc2) (fd cc2))))))
	true
	false
)))))

;Resource propagation (only Dependee)
(assert (forall ((c ResourceConcretization)) (=> (not (inited c)) (= (fd c) (ite
	(exists ((dc DependeeConcretization)) (and (= (srcEndpoint dc) ENDPOINT_RESOURCE) (= ((as src (ResourceConcretization)) dc) c) (fd dc)))
	true
	false
)))))
(assert (forall ((c ResourceConcretization)) (=> (not (inited c))  (= (pd c) (ite
	(and (exists ((dc1 DependeeConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_RESOURCE) (= ((as src (ResourceConcretization)) dc1) c) (pd dc1))) (not (exists ((dc2 DependeeConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_RESOURCE) (= ((as src (ResourceConcretization)) dc2) c) (fd dc2)))))
	true
	false
)))))
(assert (forall ((c ResourceConcretization)) (=> (not (inited c))  (= (co c) (ite
	(and (exists ((dc1 DependeeConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_RESOURCE) (= ((as src (ResourceConcretization)) dc1) c) (co dc1))) (not (exists ((dc2 DependeeConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_RESOURCE) (= ((as src (ResourceConcretization)) dc2) c) (or (fd dc2) (pd dc2))))))
	true
	false
)))))
(assert (forall ((c ResourceConcretization)) (=> (not (inited c))  (= (un c) (ite
	(and (exists ((dc1 DependeeConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_RESOURCE) (= ((as src (ResourceConcretization)) dc1) c) (un dc1))) (not (exists ((dc2 DependeeConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_RESOURCE) (= ((as src (ResourceConcretization)) dc2) c) (or (fd dc2) (pd dc2) (co dc2))))))
	true
	false
)))))
(assert (forall ((c ResourceConcretization)) (=> (not (inited c)) (= (n c) (ite
	(or
		(not (exists ((dc DependeeConcretization)) (and (= (srcEndpoint dc) ENDPOINT_RESOURCE) (= ((as src (ResourceConcretization)) dc) c))))
		(and (exists ((dc1 DependeeConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_RESOURCE) (= ((as src (ResourceConcretization)) dc1) c) (n dc1))) (not (exists ((dc2 DependeeConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_RESOURCE) (= ((as src (ResourceConcretization)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2))))))
	)
	true
	false
)))))
(assert (forall ((c ResourceConcretization)) (=> (not (inited c))  (= (ps c) (ite
	(and (exists ((dc1 DependeeConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_RESOURCE) (= ((as src (ResourceConcretization)) dc1) c) (ps dc1))) (not (exists ((dc2 DependeeConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_RESOURCE) (= ((as src (ResourceConcretization)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (n dc2))))))
	true
	false
)))))
(assert (forall ((c ResourceConcretization)) (=> (not (inited c))  (= (fs c) (ite
	(and (exists ((dc1 DependeeConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_RESOURCE) (= ((as src (ResourceConcretization)) dc1) c) (fs dc1))) (not (exists ((dc2 DependeeConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_RESOURCE) (= ((as src (ResourceConcretization)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (n dc2) (ps dc2))))))
	true
	false
)))))

(assert (and (forall ((c GoalConcretization)) (=> (node UseInflo c) (fs c))) (forall ((c SoftGoalConcretization)) (=> (node MakeModelsTrustworthy c) (ps c)))))

(check-sat)
(get-model)
