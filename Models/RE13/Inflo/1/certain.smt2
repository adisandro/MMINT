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
	ExtensiveModeration
	UseAutomatedReputationSystem
	ProvideReputations
	TrackAuthorship
	DisplayGraphs
	TrackRevisions
	CreateGraphs
	BeInflo
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
)))
(declare-datatypes () ((Intention
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
	InfloManagerEditors2ExtensiveModeration
	InfloManagerEditors2UseAutomatedReputationSystem
	InfloManagerEditors2ModerateInflo
	AutomatedReputationSystem2ProvideReputations
	Inflo2AllowModeration
	Inflo2TrackAuthorship
	Inflo2DisplayGraphs
	Inflo2TrackRevisions
	Inflo2CreateGraphs
	Inflo2BeInflo
)))
(declare-datatypes () ((MeansEnd
	Browsing2UseInflo
	CreateGraph2UseInflo
	UseDiscussions2UseInflo
)))
(declare-datatypes () ((Decomposition
	MakeViews2Browsing
	AddSourceInDescription2CreateGraph
	TrackAuthorship2BeInflo
	DisplayGraphs2BeInflo
	TrackRevisions2BeInflo
	CreateGraphs2BeInflo
)))
(declare-datatypes () ((Contribution
	ValidateModel2MakeModelsTrustworthy
	GetFeedback2MakeModelsTrustworthy
	UseDiscussions2ValidateModel
	InfloBeModerated2GetFeedback
)))
(declare-datatypes () ((DependerLink
	InfloBeModerated2Moderation
	AllowModeration2Moderation
	UseInflo2Graphing
	UseAutomatedReputationSystem2ReputationValues
	AddSourceInDescription2Info
)))
(declare-datatypes () ((DependeeLink
	Moderation2ModerateInflo
	Graphing2BeInflo
	ReputationValues2ProvideReputations
)))

;Concretizations
(declare-sort ActorConcretization)
(declare-sort TaskConcretization)
(declare-sort GoalConcretization)
(declare-sort SoftGoalConcretization)
(declare-sort ResourceConcretization)
(declare-sort IntentionConcretization)
(declare-sort MeansEndConcretization)
(declare-sort DecompositionConcretization)
(declare-sort ContributionConcretization)
(declare-sort DependerLinkConcretization)
(declare-sort DependeeLinkConcretization)
(declare-fun node (Actor ActorConcretization) Bool)
(declare-fun node (Task TaskConcretization) Bool)
(declare-fun node (Goal GoalConcretization) Bool)
(declare-fun node (SoftGoal SoftGoalConcretization) Bool)
(declare-fun node (Resource ResourceConcretization) Bool)
(declare-fun edge (Intention IntentionConcretization) Bool)
(declare-fun tgtEndpoint (IntentionConcretization) Int)
(declare-fun src (IntentionConcretization) ActorConcretization)
(declare-fun tgt (IntentionConcretization) TaskConcretization)
(declare-fun tgt (IntentionConcretization) GoalConcretization)
(declare-fun tgt (IntentionConcretization) SoftGoalConcretization)
(declare-fun tgt (IntentionConcretization) ResourceConcretization)
(declare-fun edge (MeansEnd MeansEndConcretization) Bool)
(declare-fun src (MeansEndConcretization) TaskConcretization)
(declare-fun tgt (MeansEndConcretization) GoalConcretization)
(declare-fun edge (Decomposition DecompositionConcretization) Bool)
(declare-fun srcEndpoint (DecompositionConcretization) Int)
(declare-fun src (DecompositionConcretization) TaskConcretization)
(declare-fun src (DecompositionConcretization) GoalConcretization)
(declare-fun src (DecompositionConcretization) SoftGoalConcretization)
(declare-fun src (DecompositionConcretization) ResourceConcretization)
(declare-fun tgt (DecompositionConcretization) TaskConcretization)
(declare-fun edge (Contribution ContributionConcretization) Bool)
(declare-fun srcEndpoint (ContributionConcretization) Int)
(declare-fun type (ContributionConcretization) Int)
(declare-fun src (ContributionConcretization) TaskConcretization)
(declare-fun src (ContributionConcretization) GoalConcretization)
(declare-fun src (ContributionConcretization) SoftGoalConcretization)
(declare-fun src (ContributionConcretization) ResourceConcretization)
(declare-fun tgt (ContributionConcretization) SoftGoalConcretization)
(declare-fun edge (DependerLink DependerLinkConcretization) Bool)
(declare-fun srcEndpoint (DependerLinkConcretization) Int)
(declare-fun tgtEndpoint (DependerLinkConcretization) Int)
(declare-fun src (DependerLinkConcretization) TaskConcretization)
(declare-fun src (DependerLinkConcretization) GoalConcretization)
(declare-fun src (DependerLinkConcretization) SoftGoalConcretization)
(declare-fun src (DependerLinkConcretization) ResourceConcretization)
(declare-fun tgt (DependerLinkConcretization) TaskConcretization)
(declare-fun tgt (DependerLinkConcretization) GoalConcretization)
(declare-fun tgt (DependerLinkConcretization) SoftGoalConcretization)
(declare-fun tgt (DependerLinkConcretization) ResourceConcretization)
(declare-fun edge (DependeeLink DependeeLinkConcretization) Bool)
(declare-fun srcEndpoint (DependeeLinkConcretization) Int)
(declare-fun tgtEndpoint (DependeeLinkConcretization) Int)
(declare-fun src (DependeeLinkConcretization) TaskConcretization)
(declare-fun src (DependeeLinkConcretization) GoalConcretization)
(declare-fun src (DependeeLinkConcretization) SoftGoalConcretization)
(declare-fun src (DependeeLinkConcretization) ResourceConcretization)
(declare-fun tgt (DependeeLinkConcretization) TaskConcretization)
(declare-fun tgt (DependeeLinkConcretization) GoalConcretization)
(declare-fun tgt (DependeeLinkConcretization) SoftGoalConcretization)
(declare-fun tgt (DependeeLinkConcretization) ResourceConcretization)

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
(declare-fun fs (DependerLinkConcretization) Bool)
(declare-fun fs (DependeeLinkConcretization) Bool)
(declare-fun ps (TaskConcretization) Bool)
(declare-fun ps (GoalConcretization) Bool)
(declare-fun ps (SoftGoalConcretization) Bool)
(declare-fun ps (ResourceConcretization) Bool)
(declare-fun ps (MeansEndConcretization) Bool)
(declare-fun ps (DecompositionConcretization) Bool)
(declare-fun ps (ContributionConcretization) Bool)
(declare-fun ps (DependerLinkConcretization) Bool)
(declare-fun ps (DependeeLinkConcretization) Bool)
(declare-fun un (TaskConcretization) Bool)
(declare-fun un (GoalConcretization) Bool)
(declare-fun un (SoftGoalConcretization) Bool)
(declare-fun un (ResourceConcretization) Bool)
(declare-fun un (MeansEndConcretization) Bool)
(declare-fun un (DecompositionConcretization) Bool)
(declare-fun un (ContributionConcretization) Bool)
(declare-fun un (DependerLinkConcretization) Bool)
(declare-fun un (DependeeLinkConcretization) Bool)
(declare-fun co (TaskConcretization) Bool)
(declare-fun co (GoalConcretization) Bool)
(declare-fun co (SoftGoalConcretization) Bool)
(declare-fun co (ResourceConcretization) Bool)
(declare-fun co (MeansEndConcretization) Bool)
(declare-fun co (DecompositionConcretization) Bool)
(declare-fun co (ContributionConcretization) Bool)
(declare-fun co (DependerLinkConcretization) Bool)
(declare-fun co (DependeeLinkConcretization) Bool)
(declare-fun pd (TaskConcretization) Bool)
(declare-fun pd (GoalConcretization) Bool)
(declare-fun pd (SoftGoalConcretization) Bool)
(declare-fun pd (ResourceConcretization) Bool)
(declare-fun pd (MeansEndConcretization) Bool)
(declare-fun pd (DecompositionConcretization) Bool)
(declare-fun pd (ContributionConcretization) Bool)
(declare-fun pd (DependerLinkConcretization) Bool)
(declare-fun pd (DependeeLinkConcretization) Bool)
(declare-fun fd (TaskConcretization) Bool)
(declare-fun fd (GoalConcretization) Bool)
(declare-fun fd (SoftGoalConcretization) Bool)
(declare-fun fd (ResourceConcretization) Bool)
(declare-fun fd (MeansEndConcretization) Bool)
(declare-fun fd (DecompositionConcretization) Bool)
(declare-fun fd (ContributionConcretization) Bool)
(declare-fun fd (DependerLinkConcretization) Bool)
(declare-fun fd (DependeeLinkConcretization) Bool)
(assert (forall ((c MeansEndConcretization)) (= (fs c) (fs (src c)))))
(assert (forall ((c MeansEndConcretization)) (= (ps c) (ps (src c)))))
(assert (forall ((c MeansEndConcretization)) (= (un c) (un (src c)))))
(assert (forall ((c MeansEndConcretization)) (= (co c) (co (src c)))))
(assert (forall ((c MeansEndConcretization)) (= (pd c) (pd (src c)))))
(assert (forall ((c MeansEndConcretization)) (= (fd c) (fd (src c)))))
(assert (forall ((c DecompositionConcretization)) (= (fs c)
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
(assert (forall ((c DecompositionConcretization)) (= (ps c)
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
(assert (forall ((c DecompositionConcretization)) (= (un c)
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
(assert (forall ((c DecompositionConcretization)) (= (co c)
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
(assert (forall ((dc DecompositionConcretization)) (= (pd dc)
	(ite (= (srcEndpoint dc) ENDPOINT_TASK)
		(pd ((as src (TaskConcretization)) dc))
		(ite (= (srcEndpoint dc) ENDPOINT_GOAL)
			(pd ((as src (GoalConcretization)) dc))
			(ite (= (srcEndpoint dc) ENDPOINT_SOFTGOAL)
				(pd ((as src (SoftGoalConcretization)) dc))
				(pd ((as src (ResourceConcretization)) dc))
			)
		)
	)
)))
(assert (forall ((c DecompositionConcretization)) (= (fd c)
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
(assert (forall ((c DependerLinkConcretization)) (= (fs c)
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
(assert (forall ((c DependerLinkConcretization)) (= (ps c)
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
(assert (forall ((c DependerLinkConcretization)) (= (un c)
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
(assert (forall ((c DependerLinkConcretization)) (= (co c)
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
(assert (forall ((c DependerLinkConcretization)) (= (pd c)
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
(assert (forall ((c DependerLinkConcretization)) (= (fd c)
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
(assert (forall ((c DependeeLinkConcretization)) (= (fs c)
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
(assert (forall ((c DependeeLinkConcretization)) (= (ps c)
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
(assert (forall ((c DependeeLinkConcretization)) (= (un c)
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
(assert (forall ((c DependeeLinkConcretization)) (= (co c)
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
(assert (forall ((c DependeeLinkConcretization)) (= (pd c)
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
(assert (forall ((c DependeeLinkConcretization)) (= (fd c)
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
(declare-fun n (DependerLinkConcretization) Bool)
(declare-fun n (DependeeLinkConcretization) Bool)
(assert (forall ((c MeansEndConcretization)) (= (n c) (n (src c)))))
(assert (forall ((c DecompositionConcretization)) (= (n c)
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
(assert (forall ((c DependerLinkConcretization)) (= (n c)
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
(assert (forall ((c DependeeLinkConcretization)) (= (n c)
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
	(= (srcEndpoint c) ENDPOINT_TASK)
	(not (= ((as src (TaskConcretization)) c) (tgt c)))
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
;Tasks are Complete
(assert (forall ((c TaskConcretization)) (or
	(node Browsing c)
	(node CreateGraph c)
	(node UseDiscussions c)
	(node MakeViews c)
	(node AddSourceInDescription c)
	(node ExtensiveModeration c)
	(node UseAutomatedReputationSystem c)
	(node ProvideReputations c)
	(node TrackAuthorship c)
	(node DisplayGraphs c)
	(node TrackRevisions c)
	(node CreateGraphs c)
	(node BeInflo c)
)))
;Goals are Complete
(assert (forall ((c GoalConcretization)) (or
	(node UseInflo c)
	(node InfloBeModerated c)
	(node ModerateInflo c)
	(node AllowModeration c)
)))
;SoftGoals are Complete
(assert (forall ((c SoftGoalConcretization)) (or
	(node MakeModelsTrustworthy c)
	(node ValidateModel c)
	(node GetFeedback c)
)))
;Resources are Complete
(assert (forall ((c ResourceConcretization)) (or
	(node Moderation c)
	(node Graphing c)
	(node ReputationValues c)
	(node Info c)
)))
(assert (forall ((c IntentionConcretization)) (or
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
	(edge InfloManagerEditors2ExtensiveModeration c)
	(edge InfloManagerEditors2UseAutomatedReputationSystem c)
	(edge InfloManagerEditors2ModerateInflo c)
	(edge AutomatedReputationSystem2ProvideReputations c)
	(edge Inflo2AllowModeration c)
	(edge Inflo2TrackAuthorship c)
	(edge Inflo2DisplayGraphs c)
	(edge Inflo2TrackRevisions c)
	(edge Inflo2CreateGraphs c)
	(edge Inflo2BeInflo c)
)))
;MeansEnds are Complete
(assert (forall ((c MeansEndConcretization)) (or
	(edge Browsing2UseInflo c)
	(edge CreateGraph2UseInflo c)
	(edge UseDiscussions2UseInflo c)
)))
;Decompositions are Complete
(assert (forall ((c DecompositionConcretization)) (or
	(edge MakeViews2Browsing c)
	(edge AddSourceInDescription2CreateGraph c)
	(edge TrackAuthorship2BeInflo c)
	(edge DisplayGraphs2BeInflo c)
	(edge TrackRevisions2BeInflo c)
	(edge CreateGraphs2BeInflo c)
)))
;Contributions are Complete
(assert (forall ((c ContributionConcretization)) (or
	(edge ValidateModel2MakeModelsTrustworthy c)
	(edge GetFeedback2MakeModelsTrustworthy c)
	(edge UseDiscussions2ValidateModel c)
	(edge InfloBeModerated2GetFeedback c)
)))
(assert (forall ((c DependerLinkConcretization)) (or
	(edge InfloBeModerated2Moderation c)
	(edge AllowModeration2Moderation c)
	(edge UseInflo2Graphing c)
	(edge UseAutomatedReputationSystem2ReputationValues c)
	(edge AddSourceInDescription2Info c)
)))
(assert (forall ((c DependeeLinkConcretization)) (or
	(edge Moderation2ModerateInflo c)
	(edge Graphing2BeInflo c)
	(edge ReputationValues2ProvideReputations c)
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
;MakeModelsTrustworthy is Distinct from ValidateModel
(assert	(forall ((c SoftGoalConcretization)) (=>
	(node MakeModelsTrustworthy c)
	(not (node ValidateModel c))
)))
;MakeModelsTrustworthy is Distinct from GetFeedback
(assert	(forall ((c SoftGoalConcretization)) (=>
	(node MakeModelsTrustworthy c)
	(not (node GetFeedback c))
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
;ValidateModel is Distinct from MakeModelsTrustworthy
(assert	(forall ((c SoftGoalConcretization)) (=>
	(node ValidateModel c)
	(not (node MakeModelsTrustworthy c))
)))
;ValidateModel is Distinct from GetFeedback
(assert	(forall ((c SoftGoalConcretization)) (=>
	(node ValidateModel c)
	(not (node GetFeedback c))
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
;GetFeedback is Distinct from MakeModelsTrustworthy
(assert	(forall ((c SoftGoalConcretization)) (=>
	(node GetFeedback c)
	(not (node MakeModelsTrustworthy c))
)))
;GetFeedback is Distinct from ValidateModel
(assert	(forall ((c SoftGoalConcretization)) (=>
	(node GetFeedback c)
	(not (node ValidateModel c))
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
;Browsing is Distinct from ProvideReputations
(assert	(forall ((c TaskConcretization)) (=>
	(node Browsing c)
	(not (node ProvideReputations c))
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
;CreateGraph is Distinct from ProvideReputations
(assert	(forall ((c TaskConcretization)) (=>
	(node CreateGraph c)
	(not (node ProvideReputations c))
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
;UseDiscussions is Distinct from ProvideReputations
(assert	(forall ((c TaskConcretization)) (=>
	(node UseDiscussions c)
	(not (node ProvideReputations c))
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
;MakeViews is Distinct from ProvideReputations
(assert	(forall ((c TaskConcretization)) (=>
	(node MakeViews c)
	(not (node ProvideReputations c))
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
;AddSourceInDescription is Distinct from ProvideReputations
(assert	(forall ((c TaskConcretization)) (=>
	(node AddSourceInDescription c)
	(not (node ProvideReputations c))
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

;ExtensiveModeration initial analysis tag
(assert (forall ((c TaskConcretization)) (=>
	(node ExtensiveModeration c)
	(and
		(= (fs c) false)
		(= (ps c) false)
		(= (un c) false)
		(= (co c) false)
		(= (pd c) false)
		(= (fd c) false)
		(= (n c) true)
		(= (inited c) true)
	)
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
;ExtensiveModeration is Distinct from ProvideReputations
(assert	(forall ((c TaskConcretization)) (=>
	(node ExtensiveModeration c)
	(not (node ProvideReputations c))
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
;UseAutomatedReputationSystem is Distinct from ProvideReputations
(assert	(forall ((c TaskConcretization)) (=>
	(node UseAutomatedReputationSystem c)
	(not (node ProvideReputations c))
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
;UseAutomatedReputationSystem is Distinct from ExtensiveModeration
(assert	(forall ((c TaskConcretization)) (=>
	(node UseAutomatedReputationSystem c)
	(not (node ExtensiveModeration c))
)))

;ModerateInflo initial analysis tag
(assert (forall ((c GoalConcretization)) (=>
	(node ModerateInflo c)
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

;TrackAuthorship initial analysis tag
(assert (forall ((c TaskConcretization)) (=>
	(node TrackAuthorship c)
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
;TrackAuthorship is Distinct from ProvideReputations
(assert	(forall ((c TaskConcretization)) (=>
	(node TrackAuthorship c)
	(not (node ProvideReputations c))
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
;DisplayGraphs is Distinct from ProvideReputations
(assert	(forall ((c TaskConcretization)) (=>
	(node DisplayGraphs c)
	(not (node ProvideReputations c))
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
;TrackRevisions is Distinct from ProvideReputations
(assert	(forall ((c TaskConcretization)) (=>
	(node TrackRevisions c)
	(not (node ProvideReputations c))
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
;CreateGraphs is Distinct from ProvideReputations
(assert	(forall ((c TaskConcretization)) (=>
	(node CreateGraphs c)
	(not (node ProvideReputations c))
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
;BeInflo is Distinct from ProvideReputations
(assert	(forall ((c TaskConcretization)) (=>
	(node BeInflo c)
	(not (node ProvideReputations c))
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

;InfloUser2MakeModelsTrustworthy tgtEndpoint constant
(assert (forall ((c IntentionConcretization)) (=>
	(edge InfloUser2MakeModelsTrustworthy c)
	(= (tgtEndpoint c) ENDPOINT_SOFTGOAL)
)))
;InfloUser2MakeModelsTrustworthy endpoints
(assert (forall ((c IntentionConcretization)) (=>
	(edge InfloUser2MakeModelsTrustworthy c)
	(and
		(node InfloUser (src c))
		(node MakeModelsTrustworthy ((as tgt (SoftGoalConcretization)) c))
	)
)))
;InfloUser2MakeModelsTrustworthy Exists
(assert	(exists ((c IntentionConcretization)) (edge InfloUser2MakeModelsTrustworthy c)))
;InfloUser2MakeModelsTrustworthy is Unique
(assert	(forall ((c1 IntentionConcretization) (c2 IntentionConcretization)) (=>
	(and (edge InfloUser2MakeModelsTrustworthy c1) (edge InfloUser2MakeModelsTrustworthy c2))
	(= c1 c2)
)))
;InfloUser2MakeModelsTrustworthy is Distinct from InfloUser2ValidateModel
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2MakeModelsTrustworthy c)
	(not (edge InfloUser2ValidateModel c))
)))
;InfloUser2MakeModelsTrustworthy is Distinct from InfloUser2GetFeedback
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2MakeModelsTrustworthy c)
	(not (edge InfloUser2GetFeedback c))
)))
;InfloUser2UseInflo tgtEndpoint constant
(assert (forall ((c IntentionConcretization)) (=>
	(edge InfloUser2UseInflo c)
	(= (tgtEndpoint c) ENDPOINT_GOAL)
)))
;InfloUser2UseInflo endpoints
(assert (forall ((c IntentionConcretization)) (=>
	(edge InfloUser2UseInflo c)
	(and
		(node InfloUser (src c))
		(node UseInflo ((as tgt (GoalConcretization)) c))
	)
)))
;InfloUser2UseInflo Exists
(assert	(exists ((c IntentionConcretization)) (edge InfloUser2UseInflo c)))
;InfloUser2UseInflo is Unique
(assert	(forall ((c1 IntentionConcretization) (c2 IntentionConcretization)) (=>
	(and (edge InfloUser2UseInflo c1) (edge InfloUser2UseInflo c2))
	(= c1 c2)
)))
;InfloUser2UseInflo is Distinct from InfloManagerEditors2ModerateInflo
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2UseInflo c)
	(not (edge InfloManagerEditors2ModerateInflo c))
)))
;InfloUser2UseInflo is Distinct from Inflo2AllowModeration
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2UseInflo c)
	(not (edge Inflo2AllowModeration c))
)))
;InfloUser2UseInflo is Distinct from InfloUser2InfloBeModerated
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2UseInflo c)
	(not (edge InfloUser2InfloBeModerated c))
)))
;InfloUser2ValidateModel tgtEndpoint constant
(assert (forall ((c IntentionConcretization)) (=>
	(edge InfloUser2ValidateModel c)
	(= (tgtEndpoint c) ENDPOINT_SOFTGOAL)
)))
;InfloUser2ValidateModel endpoints
(assert (forall ((c IntentionConcretization)) (=>
	(edge InfloUser2ValidateModel c)
	(and
		(node InfloUser (src c))
		(node ValidateModel ((as tgt (SoftGoalConcretization)) c))
	)
)))
;InfloUser2ValidateModel Exists
(assert	(exists ((c IntentionConcretization)) (edge InfloUser2ValidateModel c)))
;InfloUser2ValidateModel is Unique
(assert	(forall ((c1 IntentionConcretization) (c2 IntentionConcretization)) (=>
	(and (edge InfloUser2ValidateModel c1) (edge InfloUser2ValidateModel c2))
	(= c1 c2)
)))
;InfloUser2ValidateModel is Distinct from InfloUser2MakeModelsTrustworthy
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2ValidateModel c)
	(not (edge InfloUser2MakeModelsTrustworthy c))
)))
;InfloUser2ValidateModel is Distinct from InfloUser2GetFeedback
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2ValidateModel c)
	(not (edge InfloUser2GetFeedback c))
)))
;InfloUser2GetFeedback tgtEndpoint constant
(assert (forall ((c IntentionConcretization)) (=>
	(edge InfloUser2GetFeedback c)
	(= (tgtEndpoint c) ENDPOINT_SOFTGOAL)
)))
;InfloUser2GetFeedback endpoints
(assert (forall ((c IntentionConcretization)) (=>
	(edge InfloUser2GetFeedback c)
	(and
		(node InfloUser (src c))
		(node GetFeedback ((as tgt (SoftGoalConcretization)) c))
	)
)))
;InfloUser2GetFeedback Exists
(assert	(exists ((c IntentionConcretization)) (edge InfloUser2GetFeedback c)))
;InfloUser2GetFeedback is Unique
(assert	(forall ((c1 IntentionConcretization) (c2 IntentionConcretization)) (=>
	(and (edge InfloUser2GetFeedback c1) (edge InfloUser2GetFeedback c2))
	(= c1 c2)
)))
;InfloUser2GetFeedback is Distinct from InfloUser2MakeModelsTrustworthy
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2GetFeedback c)
	(not (edge InfloUser2MakeModelsTrustworthy c))
)))
;InfloUser2GetFeedback is Distinct from InfloUser2ValidateModel
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2GetFeedback c)
	(not (edge InfloUser2ValidateModel c))
)))
;InfloUser2Browsing tgtEndpoint constant
(assert (forall ((c IntentionConcretization)) (=>
	(edge InfloUser2Browsing c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;InfloUser2Browsing endpoints
(assert (forall ((c IntentionConcretization)) (=>
	(edge InfloUser2Browsing c)
	(and
		(node InfloUser (src c))
		(node Browsing ((as tgt (TaskConcretization)) c))
	)
)))
;InfloUser2Browsing Exists
(assert	(exists ((c IntentionConcretization)) (edge InfloUser2Browsing c)))
;InfloUser2Browsing is Unique
(assert	(forall ((c1 IntentionConcretization) (c2 IntentionConcretization)) (=>
	(and (edge InfloUser2Browsing c1) (edge InfloUser2Browsing c2))
	(= c1 c2)
)))
;InfloUser2Browsing is Distinct from InfloManagerEditors2ExtensiveModeration
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2Browsing c)
	(not (edge InfloManagerEditors2ExtensiveModeration c))
)))
;InfloUser2Browsing is Distinct from InfloManagerEditors2UseAutomatedReputationSystem
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2Browsing c)
	(not (edge InfloManagerEditors2UseAutomatedReputationSystem c))
)))
;InfloUser2Browsing is Distinct from AutomatedReputationSystem2ProvideReputations
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2Browsing c)
	(not (edge AutomatedReputationSystem2ProvideReputations c))
)))
;InfloUser2Browsing is Distinct from Inflo2TrackAuthorship
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2Browsing c)
	(not (edge Inflo2TrackAuthorship c))
)))
;InfloUser2Browsing is Distinct from Inflo2DisplayGraphs
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2Browsing c)
	(not (edge Inflo2DisplayGraphs c))
)))
;InfloUser2Browsing is Distinct from Inflo2TrackRevisions
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2Browsing c)
	(not (edge Inflo2TrackRevisions c))
)))
;InfloUser2Browsing is Distinct from Inflo2CreateGraphs
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2Browsing c)
	(not (edge Inflo2CreateGraphs c))
)))
;InfloUser2Browsing is Distinct from Inflo2BeInflo
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2Browsing c)
	(not (edge Inflo2BeInflo c))
)))
;InfloUser2Browsing is Distinct from InfloUser2CreateGraph
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2Browsing c)
	(not (edge InfloUser2CreateGraph c))
)))
;InfloUser2Browsing is Distinct from InfloUser2UseDiscussions
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2Browsing c)
	(not (edge InfloUser2UseDiscussions c))
)))
;InfloUser2Browsing is Distinct from InfloUser2MakeViews
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2Browsing c)
	(not (edge InfloUser2MakeViews c))
)))
;InfloUser2Browsing is Distinct from InfloUser2AddSourceInDescription
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2Browsing c)
	(not (edge InfloUser2AddSourceInDescription c))
)))
;InfloUser2CreateGraph tgtEndpoint constant
(assert (forall ((c IntentionConcretization)) (=>
	(edge InfloUser2CreateGraph c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;InfloUser2CreateGraph endpoints
(assert (forall ((c IntentionConcretization)) (=>
	(edge InfloUser2CreateGraph c)
	(and
		(node InfloUser (src c))
		(node CreateGraph ((as tgt (TaskConcretization)) c))
	)
)))
;InfloUser2CreateGraph Exists
(assert	(exists ((c IntentionConcretization)) (edge InfloUser2CreateGraph c)))
;InfloUser2CreateGraph is Unique
(assert	(forall ((c1 IntentionConcretization) (c2 IntentionConcretization)) (=>
	(and (edge InfloUser2CreateGraph c1) (edge InfloUser2CreateGraph c2))
	(= c1 c2)
)))
;InfloUser2CreateGraph is Distinct from InfloManagerEditors2ExtensiveModeration
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2CreateGraph c)
	(not (edge InfloManagerEditors2ExtensiveModeration c))
)))
;InfloUser2CreateGraph is Distinct from InfloManagerEditors2UseAutomatedReputationSystem
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2CreateGraph c)
	(not (edge InfloManagerEditors2UseAutomatedReputationSystem c))
)))
;InfloUser2CreateGraph is Distinct from AutomatedReputationSystem2ProvideReputations
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2CreateGraph c)
	(not (edge AutomatedReputationSystem2ProvideReputations c))
)))
;InfloUser2CreateGraph is Distinct from Inflo2TrackAuthorship
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2CreateGraph c)
	(not (edge Inflo2TrackAuthorship c))
)))
;InfloUser2CreateGraph is Distinct from Inflo2DisplayGraphs
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2CreateGraph c)
	(not (edge Inflo2DisplayGraphs c))
)))
;InfloUser2CreateGraph is Distinct from Inflo2TrackRevisions
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2CreateGraph c)
	(not (edge Inflo2TrackRevisions c))
)))
;InfloUser2CreateGraph is Distinct from Inflo2CreateGraphs
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2CreateGraph c)
	(not (edge Inflo2CreateGraphs c))
)))
;InfloUser2CreateGraph is Distinct from Inflo2BeInflo
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2CreateGraph c)
	(not (edge Inflo2BeInflo c))
)))
;InfloUser2CreateGraph is Distinct from InfloUser2Browsing
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2CreateGraph c)
	(not (edge InfloUser2Browsing c))
)))
;InfloUser2CreateGraph is Distinct from InfloUser2UseDiscussions
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2CreateGraph c)
	(not (edge InfloUser2UseDiscussions c))
)))
;InfloUser2CreateGraph is Distinct from InfloUser2MakeViews
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2CreateGraph c)
	(not (edge InfloUser2MakeViews c))
)))
;InfloUser2CreateGraph is Distinct from InfloUser2AddSourceInDescription
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2CreateGraph c)
	(not (edge InfloUser2AddSourceInDescription c))
)))
;InfloUser2UseDiscussions tgtEndpoint constant
(assert (forall ((c IntentionConcretization)) (=>
	(edge InfloUser2UseDiscussions c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;InfloUser2UseDiscussions endpoints
(assert (forall ((c IntentionConcretization)) (=>
	(edge InfloUser2UseDiscussions c)
	(and
		(node InfloUser (src c))
		(node UseDiscussions ((as tgt (TaskConcretization)) c))
	)
)))
;InfloUser2UseDiscussions Exists
(assert	(exists ((c IntentionConcretization)) (edge InfloUser2UseDiscussions c)))
;InfloUser2UseDiscussions is Unique
(assert	(forall ((c1 IntentionConcretization) (c2 IntentionConcretization)) (=>
	(and (edge InfloUser2UseDiscussions c1) (edge InfloUser2UseDiscussions c2))
	(= c1 c2)
)))
;InfloUser2UseDiscussions is Distinct from InfloManagerEditors2ExtensiveModeration
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2UseDiscussions c)
	(not (edge InfloManagerEditors2ExtensiveModeration c))
)))
;InfloUser2UseDiscussions is Distinct from InfloManagerEditors2UseAutomatedReputationSystem
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2UseDiscussions c)
	(not (edge InfloManagerEditors2UseAutomatedReputationSystem c))
)))
;InfloUser2UseDiscussions is Distinct from AutomatedReputationSystem2ProvideReputations
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2UseDiscussions c)
	(not (edge AutomatedReputationSystem2ProvideReputations c))
)))
;InfloUser2UseDiscussions is Distinct from Inflo2TrackAuthorship
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2UseDiscussions c)
	(not (edge Inflo2TrackAuthorship c))
)))
;InfloUser2UseDiscussions is Distinct from Inflo2DisplayGraphs
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2UseDiscussions c)
	(not (edge Inflo2DisplayGraphs c))
)))
;InfloUser2UseDiscussions is Distinct from Inflo2TrackRevisions
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2UseDiscussions c)
	(not (edge Inflo2TrackRevisions c))
)))
;InfloUser2UseDiscussions is Distinct from Inflo2CreateGraphs
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2UseDiscussions c)
	(not (edge Inflo2CreateGraphs c))
)))
;InfloUser2UseDiscussions is Distinct from Inflo2BeInflo
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2UseDiscussions c)
	(not (edge Inflo2BeInflo c))
)))
;InfloUser2UseDiscussions is Distinct from InfloUser2Browsing
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2UseDiscussions c)
	(not (edge InfloUser2Browsing c))
)))
;InfloUser2UseDiscussions is Distinct from InfloUser2CreateGraph
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2UseDiscussions c)
	(not (edge InfloUser2CreateGraph c))
)))
;InfloUser2UseDiscussions is Distinct from InfloUser2MakeViews
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2UseDiscussions c)
	(not (edge InfloUser2MakeViews c))
)))
;InfloUser2UseDiscussions is Distinct from InfloUser2AddSourceInDescription
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2UseDiscussions c)
	(not (edge InfloUser2AddSourceInDescription c))
)))
;InfloUser2InfloBeModerated tgtEndpoint constant
(assert (forall ((c IntentionConcretization)) (=>
	(edge InfloUser2InfloBeModerated c)
	(= (tgtEndpoint c) ENDPOINT_GOAL)
)))
;InfloUser2InfloBeModerated endpoints
(assert (forall ((c IntentionConcretization)) (=>
	(edge InfloUser2InfloBeModerated c)
	(and
		(node InfloUser (src c))
		(node InfloBeModerated ((as tgt (GoalConcretization)) c))
	)
)))
;InfloUser2InfloBeModerated Exists
(assert	(exists ((c IntentionConcretization)) (edge InfloUser2InfloBeModerated c)))
;InfloUser2InfloBeModerated is Unique
(assert	(forall ((c1 IntentionConcretization) (c2 IntentionConcretization)) (=>
	(and (edge InfloUser2InfloBeModerated c1) (edge InfloUser2InfloBeModerated c2))
	(= c1 c2)
)))
;InfloUser2InfloBeModerated is Distinct from InfloManagerEditors2ModerateInflo
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2InfloBeModerated c)
	(not (edge InfloManagerEditors2ModerateInflo c))
)))
;InfloUser2InfloBeModerated is Distinct from Inflo2AllowModeration
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2InfloBeModerated c)
	(not (edge Inflo2AllowModeration c))
)))
;InfloUser2InfloBeModerated is Distinct from InfloUser2UseInflo
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2InfloBeModerated c)
	(not (edge InfloUser2UseInflo c))
)))
;InfloUser2MakeViews tgtEndpoint constant
(assert (forall ((c IntentionConcretization)) (=>
	(edge InfloUser2MakeViews c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;InfloUser2MakeViews endpoints
(assert (forall ((c IntentionConcretization)) (=>
	(edge InfloUser2MakeViews c)
	(and
		(node InfloUser (src c))
		(node MakeViews ((as tgt (TaskConcretization)) c))
	)
)))
;InfloUser2MakeViews Exists
(assert	(exists ((c IntentionConcretization)) (edge InfloUser2MakeViews c)))
;InfloUser2MakeViews is Unique
(assert	(forall ((c1 IntentionConcretization) (c2 IntentionConcretization)) (=>
	(and (edge InfloUser2MakeViews c1) (edge InfloUser2MakeViews c2))
	(= c1 c2)
)))
;InfloUser2MakeViews is Distinct from InfloManagerEditors2ExtensiveModeration
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2MakeViews c)
	(not (edge InfloManagerEditors2ExtensiveModeration c))
)))
;InfloUser2MakeViews is Distinct from InfloManagerEditors2UseAutomatedReputationSystem
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2MakeViews c)
	(not (edge InfloManagerEditors2UseAutomatedReputationSystem c))
)))
;InfloUser2MakeViews is Distinct from AutomatedReputationSystem2ProvideReputations
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2MakeViews c)
	(not (edge AutomatedReputationSystem2ProvideReputations c))
)))
;InfloUser2MakeViews is Distinct from Inflo2TrackAuthorship
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2MakeViews c)
	(not (edge Inflo2TrackAuthorship c))
)))
;InfloUser2MakeViews is Distinct from Inflo2DisplayGraphs
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2MakeViews c)
	(not (edge Inflo2DisplayGraphs c))
)))
;InfloUser2MakeViews is Distinct from Inflo2TrackRevisions
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2MakeViews c)
	(not (edge Inflo2TrackRevisions c))
)))
;InfloUser2MakeViews is Distinct from Inflo2CreateGraphs
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2MakeViews c)
	(not (edge Inflo2CreateGraphs c))
)))
;InfloUser2MakeViews is Distinct from Inflo2BeInflo
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2MakeViews c)
	(not (edge Inflo2BeInflo c))
)))
;InfloUser2MakeViews is Distinct from InfloUser2Browsing
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2MakeViews c)
	(not (edge InfloUser2Browsing c))
)))
;InfloUser2MakeViews is Distinct from InfloUser2CreateGraph
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2MakeViews c)
	(not (edge InfloUser2CreateGraph c))
)))
;InfloUser2MakeViews is Distinct from InfloUser2UseDiscussions
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2MakeViews c)
	(not (edge InfloUser2UseDiscussions c))
)))
;InfloUser2MakeViews is Distinct from InfloUser2AddSourceInDescription
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2MakeViews c)
	(not (edge InfloUser2AddSourceInDescription c))
)))
;InfloUser2AddSourceInDescription tgtEndpoint constant
(assert (forall ((c IntentionConcretization)) (=>
	(edge InfloUser2AddSourceInDescription c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;InfloUser2AddSourceInDescription endpoints
(assert (forall ((c IntentionConcretization)) (=>
	(edge InfloUser2AddSourceInDescription c)
	(and
		(node InfloUser (src c))
		(node AddSourceInDescription ((as tgt (TaskConcretization)) c))
	)
)))
;InfloUser2AddSourceInDescription Exists
(assert	(exists ((c IntentionConcretization)) (edge InfloUser2AddSourceInDescription c)))
;InfloUser2AddSourceInDescription is Unique
(assert	(forall ((c1 IntentionConcretization) (c2 IntentionConcretization)) (=>
	(and (edge InfloUser2AddSourceInDescription c1) (edge InfloUser2AddSourceInDescription c2))
	(= c1 c2)
)))
;InfloUser2AddSourceInDescription is Distinct from InfloManagerEditors2ExtensiveModeration
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2AddSourceInDescription c)
	(not (edge InfloManagerEditors2ExtensiveModeration c))
)))
;InfloUser2AddSourceInDescription is Distinct from InfloManagerEditors2UseAutomatedReputationSystem
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2AddSourceInDescription c)
	(not (edge InfloManagerEditors2UseAutomatedReputationSystem c))
)))
;InfloUser2AddSourceInDescription is Distinct from AutomatedReputationSystem2ProvideReputations
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2AddSourceInDescription c)
	(not (edge AutomatedReputationSystem2ProvideReputations c))
)))
;InfloUser2AddSourceInDescription is Distinct from Inflo2TrackAuthorship
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2AddSourceInDescription c)
	(not (edge Inflo2TrackAuthorship c))
)))
;InfloUser2AddSourceInDescription is Distinct from Inflo2DisplayGraphs
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2AddSourceInDescription c)
	(not (edge Inflo2DisplayGraphs c))
)))
;InfloUser2AddSourceInDescription is Distinct from Inflo2TrackRevisions
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2AddSourceInDescription c)
	(not (edge Inflo2TrackRevisions c))
)))
;InfloUser2AddSourceInDescription is Distinct from Inflo2CreateGraphs
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2AddSourceInDescription c)
	(not (edge Inflo2CreateGraphs c))
)))
;InfloUser2AddSourceInDescription is Distinct from Inflo2BeInflo
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2AddSourceInDescription c)
	(not (edge Inflo2BeInflo c))
)))
;InfloUser2AddSourceInDescription is Distinct from InfloUser2Browsing
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2AddSourceInDescription c)
	(not (edge InfloUser2Browsing c))
)))
;InfloUser2AddSourceInDescription is Distinct from InfloUser2CreateGraph
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2AddSourceInDescription c)
	(not (edge InfloUser2CreateGraph c))
)))
;InfloUser2AddSourceInDescription is Distinct from InfloUser2UseDiscussions
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2AddSourceInDescription c)
	(not (edge InfloUser2UseDiscussions c))
)))
;InfloUser2AddSourceInDescription is Distinct from InfloUser2MakeViews
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloUser2AddSourceInDescription c)
	(not (edge InfloUser2MakeViews c))
)))
;InfloManagerEditors2ExtensiveModeration tgtEndpoint constant
(assert (forall ((c IntentionConcretization)) (=>
	(edge InfloManagerEditors2ExtensiveModeration c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;InfloManagerEditors2ExtensiveModeration endpoints
(assert (forall ((c IntentionConcretization)) (=>
	(edge InfloManagerEditors2ExtensiveModeration c)
	(and
		(node InfloManagerEditors (src c))
		(node ExtensiveModeration ((as tgt (TaskConcretization)) c))
	)
)))
;InfloManagerEditors2ExtensiveModeration Exists
(assert	(exists ((c IntentionConcretization)) (edge InfloManagerEditors2ExtensiveModeration c)))
;InfloManagerEditors2ExtensiveModeration is Unique
(assert	(forall ((c1 IntentionConcretization) (c2 IntentionConcretization)) (=>
	(and (edge InfloManagerEditors2ExtensiveModeration c1) (edge InfloManagerEditors2ExtensiveModeration c2))
	(= c1 c2)
)))
;InfloManagerEditors2ExtensiveModeration is Distinct from InfloUser2Browsing
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloManagerEditors2ExtensiveModeration c)
	(not (edge InfloUser2Browsing c))
)))
;InfloManagerEditors2ExtensiveModeration is Distinct from InfloUser2CreateGraph
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloManagerEditors2ExtensiveModeration c)
	(not (edge InfloUser2CreateGraph c))
)))
;InfloManagerEditors2ExtensiveModeration is Distinct from InfloUser2UseDiscussions
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloManagerEditors2ExtensiveModeration c)
	(not (edge InfloUser2UseDiscussions c))
)))
;InfloManagerEditors2ExtensiveModeration is Distinct from InfloUser2MakeViews
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloManagerEditors2ExtensiveModeration c)
	(not (edge InfloUser2MakeViews c))
)))
;InfloManagerEditors2ExtensiveModeration is Distinct from InfloUser2AddSourceInDescription
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloManagerEditors2ExtensiveModeration c)
	(not (edge InfloUser2AddSourceInDescription c))
)))
;InfloManagerEditors2ExtensiveModeration is Distinct from AutomatedReputationSystem2ProvideReputations
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloManagerEditors2ExtensiveModeration c)
	(not (edge AutomatedReputationSystem2ProvideReputations c))
)))
;InfloManagerEditors2ExtensiveModeration is Distinct from Inflo2TrackAuthorship
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloManagerEditors2ExtensiveModeration c)
	(not (edge Inflo2TrackAuthorship c))
)))
;InfloManagerEditors2ExtensiveModeration is Distinct from Inflo2DisplayGraphs
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloManagerEditors2ExtensiveModeration c)
	(not (edge Inflo2DisplayGraphs c))
)))
;InfloManagerEditors2ExtensiveModeration is Distinct from Inflo2TrackRevisions
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloManagerEditors2ExtensiveModeration c)
	(not (edge Inflo2TrackRevisions c))
)))
;InfloManagerEditors2ExtensiveModeration is Distinct from Inflo2CreateGraphs
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloManagerEditors2ExtensiveModeration c)
	(not (edge Inflo2CreateGraphs c))
)))
;InfloManagerEditors2ExtensiveModeration is Distinct from Inflo2BeInflo
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloManagerEditors2ExtensiveModeration c)
	(not (edge Inflo2BeInflo c))
)))
;InfloManagerEditors2ExtensiveModeration is Distinct from InfloManagerEditors2UseAutomatedReputationSystem
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloManagerEditors2ExtensiveModeration c)
	(not (edge InfloManagerEditors2UseAutomatedReputationSystem c))
)))
;InfloManagerEditors2UseAutomatedReputationSystem tgtEndpoint constant
(assert (forall ((c IntentionConcretization)) (=>
	(edge InfloManagerEditors2UseAutomatedReputationSystem c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;InfloManagerEditors2UseAutomatedReputationSystem endpoints
(assert (forall ((c IntentionConcretization)) (=>
	(edge InfloManagerEditors2UseAutomatedReputationSystem c)
	(and
		(node InfloManagerEditors (src c))
		(node UseAutomatedReputationSystem ((as tgt (TaskConcretization)) c))
	)
)))
;InfloManagerEditors2UseAutomatedReputationSystem Exists
(assert	(exists ((c IntentionConcretization)) (edge InfloManagerEditors2UseAutomatedReputationSystem c)))
;InfloManagerEditors2UseAutomatedReputationSystem is Unique
(assert	(forall ((c1 IntentionConcretization) (c2 IntentionConcretization)) (=>
	(and (edge InfloManagerEditors2UseAutomatedReputationSystem c1) (edge InfloManagerEditors2UseAutomatedReputationSystem c2))
	(= c1 c2)
)))
;InfloManagerEditors2UseAutomatedReputationSystem is Distinct from InfloUser2Browsing
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloManagerEditors2UseAutomatedReputationSystem c)
	(not (edge InfloUser2Browsing c))
)))
;InfloManagerEditors2UseAutomatedReputationSystem is Distinct from InfloUser2CreateGraph
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloManagerEditors2UseAutomatedReputationSystem c)
	(not (edge InfloUser2CreateGraph c))
)))
;InfloManagerEditors2UseAutomatedReputationSystem is Distinct from InfloUser2UseDiscussions
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloManagerEditors2UseAutomatedReputationSystem c)
	(not (edge InfloUser2UseDiscussions c))
)))
;InfloManagerEditors2UseAutomatedReputationSystem is Distinct from InfloUser2MakeViews
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloManagerEditors2UseAutomatedReputationSystem c)
	(not (edge InfloUser2MakeViews c))
)))
;InfloManagerEditors2UseAutomatedReputationSystem is Distinct from InfloUser2AddSourceInDescription
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloManagerEditors2UseAutomatedReputationSystem c)
	(not (edge InfloUser2AddSourceInDescription c))
)))
;InfloManagerEditors2UseAutomatedReputationSystem is Distinct from AutomatedReputationSystem2ProvideReputations
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloManagerEditors2UseAutomatedReputationSystem c)
	(not (edge AutomatedReputationSystem2ProvideReputations c))
)))
;InfloManagerEditors2UseAutomatedReputationSystem is Distinct from Inflo2TrackAuthorship
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloManagerEditors2UseAutomatedReputationSystem c)
	(not (edge Inflo2TrackAuthorship c))
)))
;InfloManagerEditors2UseAutomatedReputationSystem is Distinct from Inflo2DisplayGraphs
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloManagerEditors2UseAutomatedReputationSystem c)
	(not (edge Inflo2DisplayGraphs c))
)))
;InfloManagerEditors2UseAutomatedReputationSystem is Distinct from Inflo2TrackRevisions
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloManagerEditors2UseAutomatedReputationSystem c)
	(not (edge Inflo2TrackRevisions c))
)))
;InfloManagerEditors2UseAutomatedReputationSystem is Distinct from Inflo2CreateGraphs
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloManagerEditors2UseAutomatedReputationSystem c)
	(not (edge Inflo2CreateGraphs c))
)))
;InfloManagerEditors2UseAutomatedReputationSystem is Distinct from Inflo2BeInflo
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloManagerEditors2UseAutomatedReputationSystem c)
	(not (edge Inflo2BeInflo c))
)))
;InfloManagerEditors2UseAutomatedReputationSystem is Distinct from InfloManagerEditors2ExtensiveModeration
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloManagerEditors2UseAutomatedReputationSystem c)
	(not (edge InfloManagerEditors2ExtensiveModeration c))
)))
;InfloManagerEditors2ModerateInflo tgtEndpoint constant
(assert (forall ((c IntentionConcretization)) (=>
	(edge InfloManagerEditors2ModerateInflo c)
	(= (tgtEndpoint c) ENDPOINT_GOAL)
)))
;InfloManagerEditors2ModerateInflo endpoints
(assert (forall ((c IntentionConcretization)) (=>
	(edge InfloManagerEditors2ModerateInflo c)
	(and
		(node InfloManagerEditors (src c))
		(node ModerateInflo ((as tgt (GoalConcretization)) c))
	)
)))
;InfloManagerEditors2ModerateInflo Exists
(assert	(exists ((c IntentionConcretization)) (edge InfloManagerEditors2ModerateInflo c)))
;InfloManagerEditors2ModerateInflo is Unique
(assert	(forall ((c1 IntentionConcretization) (c2 IntentionConcretization)) (=>
	(and (edge InfloManagerEditors2ModerateInflo c1) (edge InfloManagerEditors2ModerateInflo c2))
	(= c1 c2)
)))
;InfloManagerEditors2ModerateInflo is Distinct from InfloUser2UseInflo
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloManagerEditors2ModerateInflo c)
	(not (edge InfloUser2UseInflo c))
)))
;InfloManagerEditors2ModerateInflo is Distinct from InfloUser2InfloBeModerated
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloManagerEditors2ModerateInflo c)
	(not (edge InfloUser2InfloBeModerated c))
)))
;InfloManagerEditors2ModerateInflo is Distinct from Inflo2AllowModeration
(assert	(forall ((c IntentionConcretization)) (=>
	(edge InfloManagerEditors2ModerateInflo c)
	(not (edge Inflo2AllowModeration c))
)))
;AutomatedReputationSystem2ProvideReputations tgtEndpoint constant
(assert (forall ((c IntentionConcretization)) (=>
	(edge AutomatedReputationSystem2ProvideReputations c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;AutomatedReputationSystem2ProvideReputations endpoints
(assert (forall ((c IntentionConcretization)) (=>
	(edge AutomatedReputationSystem2ProvideReputations c)
	(and
		(node AutomatedReputationSystem (src c))
		(node ProvideReputations ((as tgt (TaskConcretization)) c))
	)
)))
;AutomatedReputationSystem2ProvideReputations Exists
(assert	(exists ((c IntentionConcretization)) (edge AutomatedReputationSystem2ProvideReputations c)))
;AutomatedReputationSystem2ProvideReputations is Unique
(assert	(forall ((c1 IntentionConcretization) (c2 IntentionConcretization)) (=>
	(and (edge AutomatedReputationSystem2ProvideReputations c1) (edge AutomatedReputationSystem2ProvideReputations c2))
	(= c1 c2)
)))
;AutomatedReputationSystem2ProvideReputations is Distinct from InfloUser2Browsing
(assert	(forall ((c IntentionConcretization)) (=>
	(edge AutomatedReputationSystem2ProvideReputations c)
	(not (edge InfloUser2Browsing c))
)))
;AutomatedReputationSystem2ProvideReputations is Distinct from InfloUser2CreateGraph
(assert	(forall ((c IntentionConcretization)) (=>
	(edge AutomatedReputationSystem2ProvideReputations c)
	(not (edge InfloUser2CreateGraph c))
)))
;AutomatedReputationSystem2ProvideReputations is Distinct from InfloUser2UseDiscussions
(assert	(forall ((c IntentionConcretization)) (=>
	(edge AutomatedReputationSystem2ProvideReputations c)
	(not (edge InfloUser2UseDiscussions c))
)))
;AutomatedReputationSystem2ProvideReputations is Distinct from InfloUser2MakeViews
(assert	(forall ((c IntentionConcretization)) (=>
	(edge AutomatedReputationSystem2ProvideReputations c)
	(not (edge InfloUser2MakeViews c))
)))
;AutomatedReputationSystem2ProvideReputations is Distinct from InfloUser2AddSourceInDescription
(assert	(forall ((c IntentionConcretization)) (=>
	(edge AutomatedReputationSystem2ProvideReputations c)
	(not (edge InfloUser2AddSourceInDescription c))
)))
;AutomatedReputationSystem2ProvideReputations is Distinct from InfloManagerEditors2ExtensiveModeration
(assert	(forall ((c IntentionConcretization)) (=>
	(edge AutomatedReputationSystem2ProvideReputations c)
	(not (edge InfloManagerEditors2ExtensiveModeration c))
)))
;AutomatedReputationSystem2ProvideReputations is Distinct from InfloManagerEditors2UseAutomatedReputationSystem
(assert	(forall ((c IntentionConcretization)) (=>
	(edge AutomatedReputationSystem2ProvideReputations c)
	(not (edge InfloManagerEditors2UseAutomatedReputationSystem c))
)))
;AutomatedReputationSystem2ProvideReputations is Distinct from Inflo2TrackAuthorship
(assert	(forall ((c IntentionConcretization)) (=>
	(edge AutomatedReputationSystem2ProvideReputations c)
	(not (edge Inflo2TrackAuthorship c))
)))
;AutomatedReputationSystem2ProvideReputations is Distinct from Inflo2DisplayGraphs
(assert	(forall ((c IntentionConcretization)) (=>
	(edge AutomatedReputationSystem2ProvideReputations c)
	(not (edge Inflo2DisplayGraphs c))
)))
;AutomatedReputationSystem2ProvideReputations is Distinct from Inflo2TrackRevisions
(assert	(forall ((c IntentionConcretization)) (=>
	(edge AutomatedReputationSystem2ProvideReputations c)
	(not (edge Inflo2TrackRevisions c))
)))
;AutomatedReputationSystem2ProvideReputations is Distinct from Inflo2CreateGraphs
(assert	(forall ((c IntentionConcretization)) (=>
	(edge AutomatedReputationSystem2ProvideReputations c)
	(not (edge Inflo2CreateGraphs c))
)))
;AutomatedReputationSystem2ProvideReputations is Distinct from Inflo2BeInflo
(assert	(forall ((c IntentionConcretization)) (=>
	(edge AutomatedReputationSystem2ProvideReputations c)
	(not (edge Inflo2BeInflo c))
)))
;Inflo2AllowModeration tgtEndpoint constant
(assert (forall ((c IntentionConcretization)) (=>
	(edge Inflo2AllowModeration c)
	(= (tgtEndpoint c) ENDPOINT_GOAL)
)))
;Inflo2AllowModeration endpoints
(assert (forall ((c IntentionConcretization)) (=>
	(edge Inflo2AllowModeration c)
	(and
		(node Inflo (src c))
		(node AllowModeration ((as tgt (GoalConcretization)) c))
	)
)))
;Inflo2AllowModeration Exists
(assert	(exists ((c IntentionConcretization)) (edge Inflo2AllowModeration c)))
;Inflo2AllowModeration is Unique
(assert	(forall ((c1 IntentionConcretization) (c2 IntentionConcretization)) (=>
	(and (edge Inflo2AllowModeration c1) (edge Inflo2AllowModeration c2))
	(= c1 c2)
)))
;Inflo2AllowModeration is Distinct from InfloUser2UseInflo
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2AllowModeration c)
	(not (edge InfloUser2UseInflo c))
)))
;Inflo2AllowModeration is Distinct from InfloUser2InfloBeModerated
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2AllowModeration c)
	(not (edge InfloUser2InfloBeModerated c))
)))
;Inflo2AllowModeration is Distinct from InfloManagerEditors2ModerateInflo
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2AllowModeration c)
	(not (edge InfloManagerEditors2ModerateInflo c))
)))
;Inflo2TrackAuthorship tgtEndpoint constant
(assert (forall ((c IntentionConcretization)) (=>
	(edge Inflo2TrackAuthorship c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;Inflo2TrackAuthorship endpoints
(assert (forall ((c IntentionConcretization)) (=>
	(edge Inflo2TrackAuthorship c)
	(and
		(node Inflo (src c))
		(node TrackAuthorship ((as tgt (TaskConcretization)) c))
	)
)))
;Inflo2TrackAuthorship Exists
(assert	(exists ((c IntentionConcretization)) (edge Inflo2TrackAuthorship c)))
;Inflo2TrackAuthorship is Unique
(assert	(forall ((c1 IntentionConcretization) (c2 IntentionConcretization)) (=>
	(and (edge Inflo2TrackAuthorship c1) (edge Inflo2TrackAuthorship c2))
	(= c1 c2)
)))
;Inflo2TrackAuthorship is Distinct from InfloUser2Browsing
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2TrackAuthorship c)
	(not (edge InfloUser2Browsing c))
)))
;Inflo2TrackAuthorship is Distinct from InfloUser2CreateGraph
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2TrackAuthorship c)
	(not (edge InfloUser2CreateGraph c))
)))
;Inflo2TrackAuthorship is Distinct from InfloUser2UseDiscussions
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2TrackAuthorship c)
	(not (edge InfloUser2UseDiscussions c))
)))
;Inflo2TrackAuthorship is Distinct from InfloUser2MakeViews
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2TrackAuthorship c)
	(not (edge InfloUser2MakeViews c))
)))
;Inflo2TrackAuthorship is Distinct from InfloUser2AddSourceInDescription
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2TrackAuthorship c)
	(not (edge InfloUser2AddSourceInDescription c))
)))
;Inflo2TrackAuthorship is Distinct from InfloManagerEditors2ExtensiveModeration
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2TrackAuthorship c)
	(not (edge InfloManagerEditors2ExtensiveModeration c))
)))
;Inflo2TrackAuthorship is Distinct from InfloManagerEditors2UseAutomatedReputationSystem
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2TrackAuthorship c)
	(not (edge InfloManagerEditors2UseAutomatedReputationSystem c))
)))
;Inflo2TrackAuthorship is Distinct from AutomatedReputationSystem2ProvideReputations
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2TrackAuthorship c)
	(not (edge AutomatedReputationSystem2ProvideReputations c))
)))
;Inflo2TrackAuthorship is Distinct from Inflo2DisplayGraphs
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2TrackAuthorship c)
	(not (edge Inflo2DisplayGraphs c))
)))
;Inflo2TrackAuthorship is Distinct from Inflo2TrackRevisions
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2TrackAuthorship c)
	(not (edge Inflo2TrackRevisions c))
)))
;Inflo2TrackAuthorship is Distinct from Inflo2CreateGraphs
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2TrackAuthorship c)
	(not (edge Inflo2CreateGraphs c))
)))
;Inflo2TrackAuthorship is Distinct from Inflo2BeInflo
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2TrackAuthorship c)
	(not (edge Inflo2BeInflo c))
)))
;Inflo2DisplayGraphs tgtEndpoint constant
(assert (forall ((c IntentionConcretization)) (=>
	(edge Inflo2DisplayGraphs c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;Inflo2DisplayGraphs endpoints
(assert (forall ((c IntentionConcretization)) (=>
	(edge Inflo2DisplayGraphs c)
	(and
		(node Inflo (src c))
		(node DisplayGraphs ((as tgt (TaskConcretization)) c))
	)
)))
;Inflo2DisplayGraphs Exists
(assert	(exists ((c IntentionConcretization)) (edge Inflo2DisplayGraphs c)))
;Inflo2DisplayGraphs is Unique
(assert	(forall ((c1 IntentionConcretization) (c2 IntentionConcretization)) (=>
	(and (edge Inflo2DisplayGraphs c1) (edge Inflo2DisplayGraphs c2))
	(= c1 c2)
)))
;Inflo2DisplayGraphs is Distinct from InfloUser2Browsing
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2DisplayGraphs c)
	(not (edge InfloUser2Browsing c))
)))
;Inflo2DisplayGraphs is Distinct from InfloUser2CreateGraph
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2DisplayGraphs c)
	(not (edge InfloUser2CreateGraph c))
)))
;Inflo2DisplayGraphs is Distinct from InfloUser2UseDiscussions
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2DisplayGraphs c)
	(not (edge InfloUser2UseDiscussions c))
)))
;Inflo2DisplayGraphs is Distinct from InfloUser2MakeViews
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2DisplayGraphs c)
	(not (edge InfloUser2MakeViews c))
)))
;Inflo2DisplayGraphs is Distinct from InfloUser2AddSourceInDescription
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2DisplayGraphs c)
	(not (edge InfloUser2AddSourceInDescription c))
)))
;Inflo2DisplayGraphs is Distinct from InfloManagerEditors2ExtensiveModeration
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2DisplayGraphs c)
	(not (edge InfloManagerEditors2ExtensiveModeration c))
)))
;Inflo2DisplayGraphs is Distinct from InfloManagerEditors2UseAutomatedReputationSystem
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2DisplayGraphs c)
	(not (edge InfloManagerEditors2UseAutomatedReputationSystem c))
)))
;Inflo2DisplayGraphs is Distinct from AutomatedReputationSystem2ProvideReputations
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2DisplayGraphs c)
	(not (edge AutomatedReputationSystem2ProvideReputations c))
)))
;Inflo2DisplayGraphs is Distinct from Inflo2TrackAuthorship
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2DisplayGraphs c)
	(not (edge Inflo2TrackAuthorship c))
)))
;Inflo2DisplayGraphs is Distinct from Inflo2TrackRevisions
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2DisplayGraphs c)
	(not (edge Inflo2TrackRevisions c))
)))
;Inflo2DisplayGraphs is Distinct from Inflo2CreateGraphs
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2DisplayGraphs c)
	(not (edge Inflo2CreateGraphs c))
)))
;Inflo2DisplayGraphs is Distinct from Inflo2BeInflo
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2DisplayGraphs c)
	(not (edge Inflo2BeInflo c))
)))
;Inflo2TrackRevisions tgtEndpoint constant
(assert (forall ((c IntentionConcretization)) (=>
	(edge Inflo2TrackRevisions c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;Inflo2TrackRevisions endpoints
(assert (forall ((c IntentionConcretization)) (=>
	(edge Inflo2TrackRevisions c)
	(and
		(node Inflo (src c))
		(node TrackRevisions ((as tgt (TaskConcretization)) c))
	)
)))
;Inflo2TrackRevisions Exists
(assert	(exists ((c IntentionConcretization)) (edge Inflo2TrackRevisions c)))
;Inflo2TrackRevisions is Unique
(assert	(forall ((c1 IntentionConcretization) (c2 IntentionConcretization)) (=>
	(and (edge Inflo2TrackRevisions c1) (edge Inflo2TrackRevisions c2))
	(= c1 c2)
)))
;Inflo2TrackRevisions is Distinct from InfloUser2Browsing
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2TrackRevisions c)
	(not (edge InfloUser2Browsing c))
)))
;Inflo2TrackRevisions is Distinct from InfloUser2CreateGraph
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2TrackRevisions c)
	(not (edge InfloUser2CreateGraph c))
)))
;Inflo2TrackRevisions is Distinct from InfloUser2UseDiscussions
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2TrackRevisions c)
	(not (edge InfloUser2UseDiscussions c))
)))
;Inflo2TrackRevisions is Distinct from InfloUser2MakeViews
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2TrackRevisions c)
	(not (edge InfloUser2MakeViews c))
)))
;Inflo2TrackRevisions is Distinct from InfloUser2AddSourceInDescription
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2TrackRevisions c)
	(not (edge InfloUser2AddSourceInDescription c))
)))
;Inflo2TrackRevisions is Distinct from InfloManagerEditors2ExtensiveModeration
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2TrackRevisions c)
	(not (edge InfloManagerEditors2ExtensiveModeration c))
)))
;Inflo2TrackRevisions is Distinct from InfloManagerEditors2UseAutomatedReputationSystem
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2TrackRevisions c)
	(not (edge InfloManagerEditors2UseAutomatedReputationSystem c))
)))
;Inflo2TrackRevisions is Distinct from AutomatedReputationSystem2ProvideReputations
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2TrackRevisions c)
	(not (edge AutomatedReputationSystem2ProvideReputations c))
)))
;Inflo2TrackRevisions is Distinct from Inflo2TrackAuthorship
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2TrackRevisions c)
	(not (edge Inflo2TrackAuthorship c))
)))
;Inflo2TrackRevisions is Distinct from Inflo2DisplayGraphs
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2TrackRevisions c)
	(not (edge Inflo2DisplayGraphs c))
)))
;Inflo2TrackRevisions is Distinct from Inflo2CreateGraphs
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2TrackRevisions c)
	(not (edge Inflo2CreateGraphs c))
)))
;Inflo2TrackRevisions is Distinct from Inflo2BeInflo
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2TrackRevisions c)
	(not (edge Inflo2BeInflo c))
)))
;Inflo2CreateGraphs tgtEndpoint constant
(assert (forall ((c IntentionConcretization)) (=>
	(edge Inflo2CreateGraphs c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;Inflo2CreateGraphs endpoints
(assert (forall ((c IntentionConcretization)) (=>
	(edge Inflo2CreateGraphs c)
	(and
		(node Inflo (src c))
		(node CreateGraphs ((as tgt (TaskConcretization)) c))
	)
)))
;Inflo2CreateGraphs Exists
(assert	(exists ((c IntentionConcretization)) (edge Inflo2CreateGraphs c)))
;Inflo2CreateGraphs is Unique
(assert	(forall ((c1 IntentionConcretization) (c2 IntentionConcretization)) (=>
	(and (edge Inflo2CreateGraphs c1) (edge Inflo2CreateGraphs c2))
	(= c1 c2)
)))
;Inflo2CreateGraphs is Distinct from InfloUser2Browsing
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2CreateGraphs c)
	(not (edge InfloUser2Browsing c))
)))
;Inflo2CreateGraphs is Distinct from InfloUser2CreateGraph
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2CreateGraphs c)
	(not (edge InfloUser2CreateGraph c))
)))
;Inflo2CreateGraphs is Distinct from InfloUser2UseDiscussions
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2CreateGraphs c)
	(not (edge InfloUser2UseDiscussions c))
)))
;Inflo2CreateGraphs is Distinct from InfloUser2MakeViews
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2CreateGraphs c)
	(not (edge InfloUser2MakeViews c))
)))
;Inflo2CreateGraphs is Distinct from InfloUser2AddSourceInDescription
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2CreateGraphs c)
	(not (edge InfloUser2AddSourceInDescription c))
)))
;Inflo2CreateGraphs is Distinct from InfloManagerEditors2ExtensiveModeration
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2CreateGraphs c)
	(not (edge InfloManagerEditors2ExtensiveModeration c))
)))
;Inflo2CreateGraphs is Distinct from InfloManagerEditors2UseAutomatedReputationSystem
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2CreateGraphs c)
	(not (edge InfloManagerEditors2UseAutomatedReputationSystem c))
)))
;Inflo2CreateGraphs is Distinct from AutomatedReputationSystem2ProvideReputations
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2CreateGraphs c)
	(not (edge AutomatedReputationSystem2ProvideReputations c))
)))
;Inflo2CreateGraphs is Distinct from Inflo2TrackAuthorship
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2CreateGraphs c)
	(not (edge Inflo2TrackAuthorship c))
)))
;Inflo2CreateGraphs is Distinct from Inflo2DisplayGraphs
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2CreateGraphs c)
	(not (edge Inflo2DisplayGraphs c))
)))
;Inflo2CreateGraphs is Distinct from Inflo2TrackRevisions
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2CreateGraphs c)
	(not (edge Inflo2TrackRevisions c))
)))
;Inflo2CreateGraphs is Distinct from Inflo2BeInflo
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2CreateGraphs c)
	(not (edge Inflo2BeInflo c))
)))
;Inflo2BeInflo tgtEndpoint constant
(assert (forall ((c IntentionConcretization)) (=>
	(edge Inflo2BeInflo c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;Inflo2BeInflo endpoints
(assert (forall ((c IntentionConcretization)) (=>
	(edge Inflo2BeInflo c)
	(and
		(node Inflo (src c))
		(node BeInflo ((as tgt (TaskConcretization)) c))
	)
)))
;Inflo2BeInflo Exists
(assert	(exists ((c IntentionConcretization)) (edge Inflo2BeInflo c)))
;Inflo2BeInflo is Unique
(assert	(forall ((c1 IntentionConcretization) (c2 IntentionConcretization)) (=>
	(and (edge Inflo2BeInflo c1) (edge Inflo2BeInflo c2))
	(= c1 c2)
)))
;Inflo2BeInflo is Distinct from InfloUser2Browsing
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2BeInflo c)
	(not (edge InfloUser2Browsing c))
)))
;Inflo2BeInflo is Distinct from InfloUser2CreateGraph
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2BeInflo c)
	(not (edge InfloUser2CreateGraph c))
)))
;Inflo2BeInflo is Distinct from InfloUser2UseDiscussions
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2BeInflo c)
	(not (edge InfloUser2UseDiscussions c))
)))
;Inflo2BeInflo is Distinct from InfloUser2MakeViews
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2BeInflo c)
	(not (edge InfloUser2MakeViews c))
)))
;Inflo2BeInflo is Distinct from InfloUser2AddSourceInDescription
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2BeInflo c)
	(not (edge InfloUser2AddSourceInDescription c))
)))
;Inflo2BeInflo is Distinct from InfloManagerEditors2ExtensiveModeration
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2BeInflo c)
	(not (edge InfloManagerEditors2ExtensiveModeration c))
)))
;Inflo2BeInflo is Distinct from InfloManagerEditors2UseAutomatedReputationSystem
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2BeInflo c)
	(not (edge InfloManagerEditors2UseAutomatedReputationSystem c))
)))
;Inflo2BeInflo is Distinct from AutomatedReputationSystem2ProvideReputations
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2BeInflo c)
	(not (edge AutomatedReputationSystem2ProvideReputations c))
)))
;Inflo2BeInflo is Distinct from Inflo2TrackAuthorship
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2BeInflo c)
	(not (edge Inflo2TrackAuthorship c))
)))
;Inflo2BeInflo is Distinct from Inflo2DisplayGraphs
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2BeInflo c)
	(not (edge Inflo2DisplayGraphs c))
)))
;Inflo2BeInflo is Distinct from Inflo2TrackRevisions
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2BeInflo c)
	(not (edge Inflo2TrackRevisions c))
)))
;Inflo2BeInflo is Distinct from Inflo2CreateGraphs
(assert	(forall ((c IntentionConcretization)) (=>
	(edge Inflo2BeInflo c)
	(not (edge Inflo2CreateGraphs c))
)))
;ValidateModel2MakeModelsTrustworthy Exists
(assert	(exists ((c ContributionConcretization)) (edge ValidateModel2MakeModelsTrustworthy c)))
;ValidateModel2MakeModelsTrustworthy is Unique
(assert	(forall ((c1 ContributionConcretization) (c2 ContributionConcretization)) (=>
	(and (edge ValidateModel2MakeModelsTrustworthy c1) (edge ValidateModel2MakeModelsTrustworthy c2))
	(= c1 c2)
)))
;ValidateModel2MakeModelsTrustworthy is Distinct from GetFeedback2MakeModelsTrustworthy
(assert	(forall ((c ContributionConcretization)) (=>
	(edge ValidateModel2MakeModelsTrustworthy c)
	(not (edge GetFeedback2MakeModelsTrustworthy c))
)))
;ValidateModel2MakeModelsTrustworthy is Distinct from UseDiscussions2ValidateModel
(assert	(forall ((c ContributionConcretization)) (=>
	(edge ValidateModel2MakeModelsTrustworthy c)
	(not (edge UseDiscussions2ValidateModel c))
)))
;ValidateModel2MakeModelsTrustworthy is Distinct from InfloBeModerated2GetFeedback
(assert	(forall ((c ContributionConcretization)) (=>
	(edge ValidateModel2MakeModelsTrustworthy c)
	(not (edge InfloBeModerated2GetFeedback c))
)))

;ValidateModel2MakeModelsTrustworthy endpoints
(assert (forall ((c ContributionConcretization)) (=>
	(edge ValidateModel2MakeModelsTrustworthy c)
	(and
		(node ValidateModel ((as src (SoftGoalConcretization)) c))
		(node MakeModelsTrustworthy (tgt c))
	)
)))
;ValidateModel2MakeModelsTrustworthy srcEndpoint constant
(assert (forall ((c ContributionConcretization)) (=>
	(edge ValidateModel2MakeModelsTrustworthy c)
	(= (srcEndpoint c) ENDPOINT_SOFTGOAL)
)))

;ValidateModel2MakeModelsTrustworthy type constant
(assert (forall ((c ContributionConcretization)) (=>
	(edge ValidateModel2MakeModelsTrustworthy c)
	(= (type c) CONTRIBUTION_HELP)
)))
;GetFeedback2MakeModelsTrustworthy Exists
(assert	(exists ((c ContributionConcretization)) (edge GetFeedback2MakeModelsTrustworthy c)))
;GetFeedback2MakeModelsTrustworthy is Unique
(assert	(forall ((c1 ContributionConcretization) (c2 ContributionConcretization)) (=>
	(and (edge GetFeedback2MakeModelsTrustworthy c1) (edge GetFeedback2MakeModelsTrustworthy c2))
	(= c1 c2)
)))
;GetFeedback2MakeModelsTrustworthy is Distinct from ValidateModel2MakeModelsTrustworthy
(assert	(forall ((c ContributionConcretization)) (=>
	(edge GetFeedback2MakeModelsTrustworthy c)
	(not (edge ValidateModel2MakeModelsTrustworthy c))
)))
;GetFeedback2MakeModelsTrustworthy is Distinct from UseDiscussions2ValidateModel
(assert	(forall ((c ContributionConcretization)) (=>
	(edge GetFeedback2MakeModelsTrustworthy c)
	(not (edge UseDiscussions2ValidateModel c))
)))
;GetFeedback2MakeModelsTrustworthy is Distinct from InfloBeModerated2GetFeedback
(assert	(forall ((c ContributionConcretization)) (=>
	(edge GetFeedback2MakeModelsTrustworthy c)
	(not (edge InfloBeModerated2GetFeedback c))
)))

;GetFeedback2MakeModelsTrustworthy endpoints
(assert (forall ((c ContributionConcretization)) (=>
	(edge GetFeedback2MakeModelsTrustworthy c)
	(and
		(node GetFeedback ((as src (SoftGoalConcretization)) c))
		(node MakeModelsTrustworthy (tgt c))
	)
)))
;GetFeedback2MakeModelsTrustworthy srcEndpoint constant
(assert (forall ((c ContributionConcretization)) (=>
	(edge GetFeedback2MakeModelsTrustworthy c)
	(= (srcEndpoint c) ENDPOINT_SOFTGOAL)
)))

;GetFeedback2MakeModelsTrustworthy type constant
(assert (forall ((c ContributionConcretization)) (=>
	(edge GetFeedback2MakeModelsTrustworthy c)
	(= (type c) CONTRIBUTION_HELP)
)))
;Browsing2UseInflo Exists
(assert	(exists ((c MeansEndConcretization)) (edge Browsing2UseInflo c)))
;Browsing2UseInflo is Unique
(assert	(forall ((c1 MeansEndConcretization) (c2 MeansEndConcretization)) (=>
	(and (edge Browsing2UseInflo c1) (edge Browsing2UseInflo c2))
	(= c1 c2)
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

;Browsing2UseInflo endpoints
(assert (forall ((c MeansEndConcretization)) (=>
	(edge Browsing2UseInflo c)
	(and
		(node Browsing (src c))
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

;CreateGraph2UseInflo endpoints
(assert (forall ((c MeansEndConcretization)) (=>
	(edge CreateGraph2UseInflo c)
	(and
		(node CreateGraph (src c))
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

;UseDiscussions2UseInflo endpoints
(assert (forall ((c MeansEndConcretization)) (=>
	(edge UseDiscussions2UseInflo c)
	(and
		(node UseDiscussions (src c))
		(node UseInflo (tgt c))
	)
)))

;UseDiscussions2ValidateModel Exists
(assert	(exists ((c ContributionConcretization)) (edge UseDiscussions2ValidateModel c)))
;UseDiscussions2ValidateModel is Unique
(assert	(forall ((c1 ContributionConcretization) (c2 ContributionConcretization)) (=>
	(and (edge UseDiscussions2ValidateModel c1) (edge UseDiscussions2ValidateModel c2))
	(= c1 c2)
)))
;UseDiscussions2ValidateModel is Distinct from ValidateModel2MakeModelsTrustworthy
(assert	(forall ((c ContributionConcretization)) (=>
	(edge UseDiscussions2ValidateModel c)
	(not (edge ValidateModel2MakeModelsTrustworthy c))
)))
;UseDiscussions2ValidateModel is Distinct from GetFeedback2MakeModelsTrustworthy
(assert	(forall ((c ContributionConcretization)) (=>
	(edge UseDiscussions2ValidateModel c)
	(not (edge GetFeedback2MakeModelsTrustworthy c))
)))
;UseDiscussions2ValidateModel is Distinct from InfloBeModerated2GetFeedback
(assert	(forall ((c ContributionConcretization)) (=>
	(edge UseDiscussions2ValidateModel c)
	(not (edge InfloBeModerated2GetFeedback c))
)))

;UseDiscussions2ValidateModel endpoints
(assert (forall ((c ContributionConcretization)) (=>
	(edge UseDiscussions2ValidateModel c)
	(and
		(node UseDiscussions ((as src (TaskConcretization)) c))
		(node ValidateModel (tgt c))
	)
)))
;UseDiscussions2ValidateModel srcEndpoint constant
(assert (forall ((c ContributionConcretization)) (=>
	(edge UseDiscussions2ValidateModel c)
	(= (srcEndpoint c) ENDPOINT_TASK)
)))

;UseDiscussions2ValidateModel type constant
(assert (forall ((c ContributionConcretization)) (=>
	(edge UseDiscussions2ValidateModel c)
	(= (type c) CONTRIBUTION_SOMEPLUS)
)))
;InfloBeModerated2GetFeedback Exists
(assert	(exists ((c ContributionConcretization)) (edge InfloBeModerated2GetFeedback c)))
;InfloBeModerated2GetFeedback is Unique
(assert	(forall ((c1 ContributionConcretization) (c2 ContributionConcretization)) (=>
	(and (edge InfloBeModerated2GetFeedback c1) (edge InfloBeModerated2GetFeedback c2))
	(= c1 c2)
)))
;InfloBeModerated2GetFeedback is Distinct from ValidateModel2MakeModelsTrustworthy
(assert	(forall ((c ContributionConcretization)) (=>
	(edge InfloBeModerated2GetFeedback c)
	(not (edge ValidateModel2MakeModelsTrustworthy c))
)))
;InfloBeModerated2GetFeedback is Distinct from GetFeedback2MakeModelsTrustworthy
(assert	(forall ((c ContributionConcretization)) (=>
	(edge InfloBeModerated2GetFeedback c)
	(not (edge GetFeedback2MakeModelsTrustworthy c))
)))
;InfloBeModerated2GetFeedback is Distinct from UseDiscussions2ValidateModel
(assert	(forall ((c ContributionConcretization)) (=>
	(edge InfloBeModerated2GetFeedback c)
	(not (edge UseDiscussions2ValidateModel c))
)))

;InfloBeModerated2GetFeedback endpoints
(assert (forall ((c ContributionConcretization)) (=>
	(edge InfloBeModerated2GetFeedback c)
	(and
		(node InfloBeModerated ((as src (GoalConcretization)) c))
		(node GetFeedback (tgt c))
	)
)))
;InfloBeModerated2GetFeedback srcEndpoint constant
(assert (forall ((c ContributionConcretization)) (=>
	(edge InfloBeModerated2GetFeedback c)
	(= (srcEndpoint c) ENDPOINT_GOAL)
)))

;InfloBeModerated2GetFeedback type constant
(assert (forall ((c ContributionConcretization)) (=>
	(edge InfloBeModerated2GetFeedback c)
	(= (type c) CONTRIBUTION_HURT)
)))
;MakeViews2Browsing Exists
(assert	(exists ((c DecompositionConcretization)) (edge MakeViews2Browsing c)))
;MakeViews2Browsing is Unique
(assert	(forall ((c1 DecompositionConcretization) (c2 DecompositionConcretization)) (=>
	(and (edge MakeViews2Browsing c1) (edge MakeViews2Browsing c2))
	(= c1 c2)
)))
;MakeViews2Browsing is Distinct from TrackAuthorship2BeInflo
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge MakeViews2Browsing c)
	(not (edge TrackAuthorship2BeInflo c))
)))
;MakeViews2Browsing is Distinct from DisplayGraphs2BeInflo
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge MakeViews2Browsing c)
	(not (edge DisplayGraphs2BeInflo c))
)))
;MakeViews2Browsing is Distinct from TrackRevisions2BeInflo
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge MakeViews2Browsing c)
	(not (edge TrackRevisions2BeInflo c))
)))
;MakeViews2Browsing is Distinct from CreateGraphs2BeInflo
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge MakeViews2Browsing c)
	(not (edge CreateGraphs2BeInflo c))
)))
;MakeViews2Browsing is Distinct from AddSourceInDescription2CreateGraph
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge MakeViews2Browsing c)
	(not (edge AddSourceInDescription2CreateGraph c))
)))

;MakeViews2Browsing endpoints
(assert (forall ((c DecompositionConcretization)) (=>
	(edge MakeViews2Browsing c)
	(and
		(node MakeViews ((as src (TaskConcretization)) c))
		(node Browsing (tgt c))
	)
)))
;MakeViews2Browsing srcEndpoint constant
(assert (forall ((c DecompositionConcretization)) (=>
	(edge MakeViews2Browsing c)
	(= (srcEndpoint c) ENDPOINT_TASK)
)))

;AddSourceInDescription2CreateGraph Exists
(assert	(exists ((c DecompositionConcretization)) (edge AddSourceInDescription2CreateGraph c)))
;AddSourceInDescription2CreateGraph is Unique
(assert	(forall ((c1 DecompositionConcretization) (c2 DecompositionConcretization)) (=>
	(and (edge AddSourceInDescription2CreateGraph c1) (edge AddSourceInDescription2CreateGraph c2))
	(= c1 c2)
)))
;AddSourceInDescription2CreateGraph is Distinct from TrackAuthorship2BeInflo
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge AddSourceInDescription2CreateGraph c)
	(not (edge TrackAuthorship2BeInflo c))
)))
;AddSourceInDescription2CreateGraph is Distinct from DisplayGraphs2BeInflo
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge AddSourceInDescription2CreateGraph c)
	(not (edge DisplayGraphs2BeInflo c))
)))
;AddSourceInDescription2CreateGraph is Distinct from TrackRevisions2BeInflo
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge AddSourceInDescription2CreateGraph c)
	(not (edge TrackRevisions2BeInflo c))
)))
;AddSourceInDescription2CreateGraph is Distinct from CreateGraphs2BeInflo
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge AddSourceInDescription2CreateGraph c)
	(not (edge CreateGraphs2BeInflo c))
)))
;AddSourceInDescription2CreateGraph is Distinct from MakeViews2Browsing
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge AddSourceInDescription2CreateGraph c)
	(not (edge MakeViews2Browsing c))
)))

;AddSourceInDescription2CreateGraph endpoints
(assert (forall ((c DecompositionConcretization)) (=>
	(edge AddSourceInDescription2CreateGraph c)
	(and
		(node AddSourceInDescription ((as src (TaskConcretization)) c))
		(node CreateGraph (tgt c))
	)
)))
;AddSourceInDescription2CreateGraph srcEndpoint constant
(assert (forall ((c DecompositionConcretization)) (=>
	(edge AddSourceInDescription2CreateGraph c)
	(= (srcEndpoint c) ENDPOINT_TASK)
)))

;TrackAuthorship2BeInflo Exists
(assert	(exists ((c DecompositionConcretization)) (edge TrackAuthorship2BeInflo c)))
;TrackAuthorship2BeInflo is Unique
(assert	(forall ((c1 DecompositionConcretization) (c2 DecompositionConcretization)) (=>
	(and (edge TrackAuthorship2BeInflo c1) (edge TrackAuthorship2BeInflo c2))
	(= c1 c2)
)))
;TrackAuthorship2BeInflo is Distinct from MakeViews2Browsing
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge TrackAuthorship2BeInflo c)
	(not (edge MakeViews2Browsing c))
)))
;TrackAuthorship2BeInflo is Distinct from AddSourceInDescription2CreateGraph
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge TrackAuthorship2BeInflo c)
	(not (edge AddSourceInDescription2CreateGraph c))
)))
;TrackAuthorship2BeInflo is Distinct from DisplayGraphs2BeInflo
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge TrackAuthorship2BeInflo c)
	(not (edge DisplayGraphs2BeInflo c))
)))
;TrackAuthorship2BeInflo is Distinct from TrackRevisions2BeInflo
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge TrackAuthorship2BeInflo c)
	(not (edge TrackRevisions2BeInflo c))
)))
;TrackAuthorship2BeInflo is Distinct from CreateGraphs2BeInflo
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge TrackAuthorship2BeInflo c)
	(not (edge CreateGraphs2BeInflo c))
)))

;TrackAuthorship2BeInflo endpoints
(assert (forall ((c DecompositionConcretization)) (=>
	(edge TrackAuthorship2BeInflo c)
	(and
		(node TrackAuthorship ((as src (TaskConcretization)) c))
		(node BeInflo (tgt c))
	)
)))
;TrackAuthorship2BeInflo srcEndpoint constant
(assert (forall ((c DecompositionConcretization)) (=>
	(edge TrackAuthorship2BeInflo c)
	(= (srcEndpoint c) ENDPOINT_TASK)
)))

;DisplayGraphs2BeInflo Exists
(assert	(exists ((c DecompositionConcretization)) (edge DisplayGraphs2BeInflo c)))
;DisplayGraphs2BeInflo is Unique
(assert	(forall ((c1 DecompositionConcretization) (c2 DecompositionConcretization)) (=>
	(and (edge DisplayGraphs2BeInflo c1) (edge DisplayGraphs2BeInflo c2))
	(= c1 c2)
)))
;DisplayGraphs2BeInflo is Distinct from MakeViews2Browsing
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge DisplayGraphs2BeInflo c)
	(not (edge MakeViews2Browsing c))
)))
;DisplayGraphs2BeInflo is Distinct from AddSourceInDescription2CreateGraph
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge DisplayGraphs2BeInflo c)
	(not (edge AddSourceInDescription2CreateGraph c))
)))
;DisplayGraphs2BeInflo is Distinct from TrackAuthorship2BeInflo
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge DisplayGraphs2BeInflo c)
	(not (edge TrackAuthorship2BeInflo c))
)))
;DisplayGraphs2BeInflo is Distinct from TrackRevisions2BeInflo
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge DisplayGraphs2BeInflo c)
	(not (edge TrackRevisions2BeInflo c))
)))
;DisplayGraphs2BeInflo is Distinct from CreateGraphs2BeInflo
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge DisplayGraphs2BeInflo c)
	(not (edge CreateGraphs2BeInflo c))
)))

;DisplayGraphs2BeInflo endpoints
(assert (forall ((c DecompositionConcretization)) (=>
	(edge DisplayGraphs2BeInflo c)
	(and
		(node DisplayGraphs ((as src (TaskConcretization)) c))
		(node BeInflo (tgt c))
	)
)))
;DisplayGraphs2BeInflo srcEndpoint constant
(assert (forall ((c DecompositionConcretization)) (=>
	(edge DisplayGraphs2BeInflo c)
	(= (srcEndpoint c) ENDPOINT_TASK)
)))

;TrackRevisions2BeInflo Exists
(assert	(exists ((c DecompositionConcretization)) (edge TrackRevisions2BeInflo c)))
;TrackRevisions2BeInflo is Unique
(assert	(forall ((c1 DecompositionConcretization) (c2 DecompositionConcretization)) (=>
	(and (edge TrackRevisions2BeInflo c1) (edge TrackRevisions2BeInflo c2))
	(= c1 c2)
)))
;TrackRevisions2BeInflo is Distinct from MakeViews2Browsing
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge TrackRevisions2BeInflo c)
	(not (edge MakeViews2Browsing c))
)))
;TrackRevisions2BeInflo is Distinct from AddSourceInDescription2CreateGraph
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge TrackRevisions2BeInflo c)
	(not (edge AddSourceInDescription2CreateGraph c))
)))
;TrackRevisions2BeInflo is Distinct from TrackAuthorship2BeInflo
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge TrackRevisions2BeInflo c)
	(not (edge TrackAuthorship2BeInflo c))
)))
;TrackRevisions2BeInflo is Distinct from DisplayGraphs2BeInflo
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge TrackRevisions2BeInflo c)
	(not (edge DisplayGraphs2BeInflo c))
)))
;TrackRevisions2BeInflo is Distinct from CreateGraphs2BeInflo
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge TrackRevisions2BeInflo c)
	(not (edge CreateGraphs2BeInflo c))
)))

;TrackRevisions2BeInflo endpoints
(assert (forall ((c DecompositionConcretization)) (=>
	(edge TrackRevisions2BeInflo c)
	(and
		(node TrackRevisions ((as src (TaskConcretization)) c))
		(node BeInflo (tgt c))
	)
)))
;TrackRevisions2BeInflo srcEndpoint constant
(assert (forall ((c DecompositionConcretization)) (=>
	(edge TrackRevisions2BeInflo c)
	(= (srcEndpoint c) ENDPOINT_TASK)
)))

;CreateGraphs2BeInflo Exists
(assert	(exists ((c DecompositionConcretization)) (edge CreateGraphs2BeInflo c)))
;CreateGraphs2BeInflo is Unique
(assert	(forall ((c1 DecompositionConcretization) (c2 DecompositionConcretization)) (=>
	(and (edge CreateGraphs2BeInflo c1) (edge CreateGraphs2BeInflo c2))
	(= c1 c2)
)))
;CreateGraphs2BeInflo is Distinct from MakeViews2Browsing
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge CreateGraphs2BeInflo c)
	(not (edge MakeViews2Browsing c))
)))
;CreateGraphs2BeInflo is Distinct from AddSourceInDescription2CreateGraph
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge CreateGraphs2BeInflo c)
	(not (edge AddSourceInDescription2CreateGraph c))
)))
;CreateGraphs2BeInflo is Distinct from TrackAuthorship2BeInflo
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge CreateGraphs2BeInflo c)
	(not (edge TrackAuthorship2BeInflo c))
)))
;CreateGraphs2BeInflo is Distinct from DisplayGraphs2BeInflo
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge CreateGraphs2BeInflo c)
	(not (edge DisplayGraphs2BeInflo c))
)))
;CreateGraphs2BeInflo is Distinct from TrackRevisions2BeInflo
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge CreateGraphs2BeInflo c)
	(not (edge TrackRevisions2BeInflo c))
)))

;CreateGraphs2BeInflo endpoints
(assert (forall ((c DecompositionConcretization)) (=>
	(edge CreateGraphs2BeInflo c)
	(and
		(node CreateGraphs ((as src (TaskConcretization)) c))
		(node BeInflo (tgt c))
	)
)))
;CreateGraphs2BeInflo srcEndpoint constant
(assert (forall ((c DecompositionConcretization)) (=>
	(edge CreateGraphs2BeInflo c)
	(= (srcEndpoint c) ENDPOINT_TASK)
)))

;InfloBeModerated2Moderation srcEndpoint constant
(assert (forall ((c DependerLinkConcretization)) (=>
	(edge InfloBeModerated2Moderation c)
	(= (srcEndpoint c) ENDPOINT_GOAL)
)))
;InfloBeModerated2Moderation tgtEndpoint constant
(assert (forall ((c DependerLinkConcretization)) (=>
	(edge InfloBeModerated2Moderation c)
	(= (tgtEndpoint c) ENDPOINT_RESOURCE)
)))
;InfloBeModerated2Moderation endpoints
(assert (forall ((c DependerLinkConcretization)) (=>
	(edge InfloBeModerated2Moderation c)
	(and
		(node InfloBeModerated ((as src (GoalConcretization)) c))
		(node Moderation ((as tgt (ResourceConcretization)) c))
	)
)))
;InfloBeModerated2Moderation Exists
(assert	(exists ((c DependerLinkConcretization)) (edge InfloBeModerated2Moderation c)))
;InfloBeModerated2Moderation is Unique
(assert	(forall ((c1 DependerLinkConcretization) (c2 DependerLinkConcretization)) (=>
	(and (edge InfloBeModerated2Moderation c1) (edge InfloBeModerated2Moderation c2))
	(= c1 c2)
)))
;InfloBeModerated2Moderation is Distinct from AllowModeration2Moderation
(assert	(forall ((c DependerLinkConcretization)) (=>
	(edge InfloBeModerated2Moderation c)
	(not (edge AllowModeration2Moderation c))
)))
;InfloBeModerated2Moderation is Distinct from UseInflo2Graphing
(assert	(forall ((c DependerLinkConcretization)) (=>
	(edge InfloBeModerated2Moderation c)
	(not (edge UseInflo2Graphing c))
)))
;AllowModeration2Moderation srcEndpoint constant
(assert (forall ((c DependerLinkConcretization)) (=>
	(edge AllowModeration2Moderation c)
	(= (srcEndpoint c) ENDPOINT_GOAL)
)))
;AllowModeration2Moderation tgtEndpoint constant
(assert (forall ((c DependerLinkConcretization)) (=>
	(edge AllowModeration2Moderation c)
	(= (tgtEndpoint c) ENDPOINT_RESOURCE)
)))
;AllowModeration2Moderation endpoints
(assert (forall ((c DependerLinkConcretization)) (=>
	(edge AllowModeration2Moderation c)
	(and
		(node AllowModeration ((as src (GoalConcretization)) c))
		(node Moderation ((as tgt (ResourceConcretization)) c))
	)
)))
;AllowModeration2Moderation Exists
(assert	(exists ((c DependerLinkConcretization)) (edge AllowModeration2Moderation c)))
;AllowModeration2Moderation is Unique
(assert	(forall ((c1 DependerLinkConcretization) (c2 DependerLinkConcretization)) (=>
	(and (edge AllowModeration2Moderation c1) (edge AllowModeration2Moderation c2))
	(= c1 c2)
)))
;AllowModeration2Moderation is Distinct from InfloBeModerated2Moderation
(assert	(forall ((c DependerLinkConcretization)) (=>
	(edge AllowModeration2Moderation c)
	(not (edge InfloBeModerated2Moderation c))
)))
;AllowModeration2Moderation is Distinct from UseInflo2Graphing
(assert	(forall ((c DependerLinkConcretization)) (=>
	(edge AllowModeration2Moderation c)
	(not (edge UseInflo2Graphing c))
)))
;UseInflo2Graphing srcEndpoint constant
(assert (forall ((c DependerLinkConcretization)) (=>
	(edge UseInflo2Graphing c)
	(= (srcEndpoint c) ENDPOINT_GOAL)
)))
;UseInflo2Graphing tgtEndpoint constant
(assert (forall ((c DependerLinkConcretization)) (=>
	(edge UseInflo2Graphing c)
	(= (tgtEndpoint c) ENDPOINT_RESOURCE)
)))
;UseInflo2Graphing endpoints
(assert (forall ((c DependerLinkConcretization)) (=>
	(edge UseInflo2Graphing c)
	(and
		(node UseInflo ((as src (GoalConcretization)) c))
		(node Graphing ((as tgt (ResourceConcretization)) c))
	)
)))
;UseInflo2Graphing Exists
(assert	(exists ((c DependerLinkConcretization)) (edge UseInflo2Graphing c)))
;UseInflo2Graphing is Unique
(assert	(forall ((c1 DependerLinkConcretization) (c2 DependerLinkConcretization)) (=>
	(and (edge UseInflo2Graphing c1) (edge UseInflo2Graphing c2))
	(= c1 c2)
)))
;UseInflo2Graphing is Distinct from InfloBeModerated2Moderation
(assert	(forall ((c DependerLinkConcretization)) (=>
	(edge UseInflo2Graphing c)
	(not (edge InfloBeModerated2Moderation c))
)))
;UseInflo2Graphing is Distinct from AllowModeration2Moderation
(assert	(forall ((c DependerLinkConcretization)) (=>
	(edge UseInflo2Graphing c)
	(not (edge AllowModeration2Moderation c))
)))
;UseAutomatedReputationSystem2ReputationValues srcEndpoint constant
(assert (forall ((c DependerLinkConcretization)) (=>
	(edge UseAutomatedReputationSystem2ReputationValues c)
	(= (srcEndpoint c) ENDPOINT_TASK)
)))
;UseAutomatedReputationSystem2ReputationValues tgtEndpoint constant
(assert (forall ((c DependerLinkConcretization)) (=>
	(edge UseAutomatedReputationSystem2ReputationValues c)
	(= (tgtEndpoint c) ENDPOINT_RESOURCE)
)))
;UseAutomatedReputationSystem2ReputationValues endpoints
(assert (forall ((c DependerLinkConcretization)) (=>
	(edge UseAutomatedReputationSystem2ReputationValues c)
	(and
		(node UseAutomatedReputationSystem ((as src (TaskConcretization)) c))
		(node ReputationValues ((as tgt (ResourceConcretization)) c))
	)
)))
;UseAutomatedReputationSystem2ReputationValues Exists
(assert	(exists ((c DependerLinkConcretization)) (edge UseAutomatedReputationSystem2ReputationValues c)))
;UseAutomatedReputationSystem2ReputationValues is Unique
(assert	(forall ((c1 DependerLinkConcretization) (c2 DependerLinkConcretization)) (=>
	(and (edge UseAutomatedReputationSystem2ReputationValues c1) (edge UseAutomatedReputationSystem2ReputationValues c2))
	(= c1 c2)
)))
;UseAutomatedReputationSystem2ReputationValues is Distinct from AddSourceInDescription2Info
(assert	(forall ((c DependerLinkConcretization)) (=>
	(edge UseAutomatedReputationSystem2ReputationValues c)
	(not (edge AddSourceInDescription2Info c))
)))
;AddSourceInDescription2Info srcEndpoint constant
(assert (forall ((c DependerLinkConcretization)) (=>
	(edge AddSourceInDescription2Info c)
	(= (srcEndpoint c) ENDPOINT_TASK)
)))
;AddSourceInDescription2Info tgtEndpoint constant
(assert (forall ((c DependerLinkConcretization)) (=>
	(edge AddSourceInDescription2Info c)
	(= (tgtEndpoint c) ENDPOINT_RESOURCE)
)))
;AddSourceInDescription2Info endpoints
(assert (forall ((c DependerLinkConcretization)) (=>
	(edge AddSourceInDescription2Info c)
	(and
		(node AddSourceInDescription ((as src (TaskConcretization)) c))
		(node Info ((as tgt (ResourceConcretization)) c))
	)
)))
;AddSourceInDescription2Info Exists
(assert	(exists ((c DependerLinkConcretization)) (edge AddSourceInDescription2Info c)))
;AddSourceInDescription2Info is Unique
(assert	(forall ((c1 DependerLinkConcretization) (c2 DependerLinkConcretization)) (=>
	(and (edge AddSourceInDescription2Info c1) (edge AddSourceInDescription2Info c2))
	(= c1 c2)
)))
;AddSourceInDescription2Info is Distinct from UseAutomatedReputationSystem2ReputationValues
(assert	(forall ((c DependerLinkConcretization)) (=>
	(edge AddSourceInDescription2Info c)
	(not (edge UseAutomatedReputationSystem2ReputationValues c))
)))
;Moderation2ModerateInflo srcEndpoint constant
(assert (forall ((c DependeeLinkConcretization)) (=>
	(edge Moderation2ModerateInflo c)
	(= (srcEndpoint c) ENDPOINT_RESOURCE)
)))
;Moderation2ModerateInflo tgtEndpoint constant
(assert (forall ((c DependeeLinkConcretization)) (=>
	(edge Moderation2ModerateInflo c)
	(= (tgtEndpoint c) ENDPOINT_GOAL)
)))
;Moderation2ModerateInflo endpoints
(assert (forall ((c DependeeLinkConcretization)) (=>
	(edge Moderation2ModerateInflo c)
	(and
		(node Moderation ((as src (ResourceConcretization)) c))
		(node ModerateInflo ((as tgt (GoalConcretization)) c))
	)
)))
;Moderation2ModerateInflo Exists
(assert	(exists ((c DependeeLinkConcretization)) (edge Moderation2ModerateInflo c)))
;Moderation2ModerateInflo is Unique
(assert	(forall ((c1 DependeeLinkConcretization) (c2 DependeeLinkConcretization)) (=>
	(and (edge Moderation2ModerateInflo c1) (edge Moderation2ModerateInflo c2))
	(= c1 c2)
)))
;Graphing2BeInflo srcEndpoint constant
(assert (forall ((c DependeeLinkConcretization)) (=>
	(edge Graphing2BeInflo c)
	(= (srcEndpoint c) ENDPOINT_RESOURCE)
)))
;Graphing2BeInflo tgtEndpoint constant
(assert (forall ((c DependeeLinkConcretization)) (=>
	(edge Graphing2BeInflo c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;Graphing2BeInflo endpoints
(assert (forall ((c DependeeLinkConcretization)) (=>
	(edge Graphing2BeInflo c)
	(and
		(node Graphing ((as src (ResourceConcretization)) c))
		(node BeInflo ((as tgt (TaskConcretization)) c))
	)
)))
;Graphing2BeInflo Exists
(assert	(exists ((c DependeeLinkConcretization)) (edge Graphing2BeInflo c)))
;Graphing2BeInflo is Unique
(assert	(forall ((c1 DependeeLinkConcretization) (c2 DependeeLinkConcretization)) (=>
	(and (edge Graphing2BeInflo c1) (edge Graphing2BeInflo c2))
	(= c1 c2)
)))
;Graphing2BeInflo is Distinct from ReputationValues2ProvideReputations
(assert	(forall ((c DependeeLinkConcretization)) (=>
	(edge Graphing2BeInflo c)
	(not (edge ReputationValues2ProvideReputations c))
)))
;ReputationValues2ProvideReputations srcEndpoint constant
(assert (forall ((c DependeeLinkConcretization)) (=>
	(edge ReputationValues2ProvideReputations c)
	(= (srcEndpoint c) ENDPOINT_RESOURCE)
)))
;ReputationValues2ProvideReputations tgtEndpoint constant
(assert (forall ((c DependeeLinkConcretization)) (=>
	(edge ReputationValues2ProvideReputations c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;ReputationValues2ProvideReputations endpoints
(assert (forall ((c DependeeLinkConcretization)) (=>
	(edge ReputationValues2ProvideReputations c)
	(and
		(node ReputationValues ((as src (ResourceConcretization)) c))
		(node ProvideReputations ((as tgt (TaskConcretization)) c))
	)
)))
;ReputationValues2ProvideReputations Exists
(assert	(exists ((c DependeeLinkConcretization)) (edge ReputationValues2ProvideReputations c)))
;ReputationValues2ProvideReputations is Unique
(assert	(forall ((c1 DependeeLinkConcretization) (c2 DependeeLinkConcretization)) (=>
	(and (edge ReputationValues2ProvideReputations c1) (edge ReputationValues2ProvideReputations c2))
	(= c1 c2)
)))
;ReputationValues2ProvideReputations is Distinct from Graphing2BeInflo
(assert	(forall ((c DependeeLinkConcretization)) (=>
	(edge ReputationValues2ProvideReputations c)
	(not (edge Graphing2BeInflo c))
)))


;Goal propagation (MeansEnd + Depender + Dependee)
(assert	(forall ((c GoalConcretization)) (=> (not (inited c)) (= (fs c) (ite
	(or
		(and (exists ((mec MeansEndConcretization)) (and (= (tgt mec) c) (fs mec))) (not (exists ((dc DependerLinkConcretization)) (and (= (srcEndpoint dc) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc) c) (or (fd dc) (pd dc) (co dc) (un dc) (n dc) (ps dc))))))
		(and (exists ((dc1 DependerLinkConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc1) c) (fs dc1))) (not (exists ((dc2 DependerLinkConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (n dc2) (ps dc2))))))
		(and (exists ((dc1 DependeeLinkConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc1) c) (fs dc1))) (not (exists ((dc2 DependeeLinkConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (n dc2) (ps dc2))))))
	)
	true
	false
)))))
(assert	(forall ((c GoalConcretization)) (=> (and (not (inited c)) (fs c)) (= (ps c) false))))
(assert	(forall ((c GoalConcretization)) (=> (and (not (inited c)) (not (fs c))) (= (ps c) (ite
	(or
		(and (exists ((mec1 MeansEndConcretization)) (and (= (tgt mec1) c) (ps mec1))) (and (not (exists ((mec2 MeansEndConcretization)) (and (= (tgt mec2) c) (fs mec2)))) (not (exists ((dc DependerLinkConcretization)) (and (= (srcEndpoint dc) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc) c) (or (fd dc) (pd dc) (co dc) (un dc) (n dc)))))))
		(and (exists ((dc1 DependerLinkConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc1) c) (ps dc1))) (not (exists ((dc2 DependerLinkConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (n dc2))))))
		(and (exists ((dc1 DependeeLinkConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc1) c) (ps dc1))) (not (exists ((dc2 DependeeLinkConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (n dc2))))))
	)
	true
	false
)))))
(assert	(forall ((c GoalConcretization)) (=> (and (not (inited c)) (or (fs c) (ps c))) (= (n c) false))))
(assert	(forall ((c GoalConcretization)) (=> (and (not (inited c)) (not (fs c)) (not (ps c))) (= (n c) (ite
	(or
		(and (not (exists ((mec MeansEndConcretization)) (= (tgt mec) c))) (not (exists ((dc1 DependerLinkConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc1) c)))) (not (exists ((dc2 DependeeLinkConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc2) c)))))
		(and (exists ((mec1 MeansEndConcretization)) (and (= (tgt mec1) c) (n mec1))) (and (not (exists ((mec2 MeansEndConcretization)) (and (= (tgt mec2) c) (or (fs mec2) (ps mec2) (un mec2) (co mec2) (pd mec2) (fd mec2))))) (not (exists ((dc DependerLinkConcretization)) (and (= (srcEndpoint dc) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc) c) (or (fd dc) (pd dc) (co dc) (un dc)))))))
		(and (exists ((dc1 DependerLinkConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc1) c) (n dc1))) (not (exists ((dc2 DependerLinkConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2))))))
		(and (exists ((dc1 DependeeLinkConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc1) c) (n dc1))) (not (exists ((dc2 DependeeLinkConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2))))))
	)
	true
	false
)))))
(assert	(forall ((c GoalConcretization)) (=> (and (not (inited c)) (or (fs c) (ps c) (n c))) (= (un c) false))))
(assert	(forall ((c GoalConcretization)) (=> (and (not (inited c)) (not (fs c)) (not (ps c)) (not (n c))) (= (un c) (ite
	(or
		(and (exists ((mec1 MeansEndConcretization)) (and (= (tgt mec1) c) (un mec1))) (and (not (exists ((mec2 MeansEndConcretization)) (and (= (tgt mec2) c) (or (fs mec2) (ps mec2))))) (not (exists ((dc DependerLinkConcretization)) (and (= (srcEndpoint dc) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc) c) (or (fd dc) (pd dc) (co dc)))))))
		(and (exists ((dc1 DependerLinkConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc1) c) (un dc1))) (not (exists ((dc2 DependerLinkConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc2) c) (or (fd dc2) (pd dc2) (co dc2))))))
		(and (exists ((dc1 DependeeLinkConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc1) c) (un dc1))) (not (exists ((dc2 DependeeLinkConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc2) c) (or (fd dc2) (pd dc2) (co dc2))))))
	)
	true
	false
)))))
(assert	(forall ((c GoalConcretization)) (=> (and (not (inited c)) (or (fs c) (ps c) (n c) (un c))) (= (co c) false))))
(assert	(forall ((c GoalConcretization)) (=> (and (not (inited c)) (not (fs c)) (not (ps c)) (not (n c)) (not (un c))) (= (co c) (ite
	(or
		(and (exists ((mec1 MeansEndConcretization)) (and (= (tgt mec1) c) (co mec1))) (and (not (exists ((mec2 MeansEndConcretization)) (and (= (tgt mec2) c) (or (fs mec2) (ps mec2) (un mec2))))) (not (exists ((dc DependerLinkConcretization)) (and (= (srcEndpoint dc) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc) c) (or (fd dc) (pd dc)))))))
		(and (exists ((dc1 DependerLinkConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc1) c) (co dc1))) (not (exists ((dc2 DependerLinkConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc2) c) (or (fd dc2) (pd dc2))))))
		(and (exists ((dc1 DependeeLinkConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc1) c) (co dc1))) (not (exists ((dc2 DependeeLinkConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc2) c) (or (fd dc2) (pd dc2))))))
	)
	true
	false
)))))
(assert	(forall ((c GoalConcretization)) (=> (and (not (inited c)) (or (fs c) (ps c) (n c) (un c) (co c))) (= (pd c) false))))
(assert	(forall ((c GoalConcretization)) (=> (and (not (inited c)) (not (fs c)) (not (ps c)) (not (n c)) (not (un c)) (not (co c))) (= (pd c) (ite
	(or
		(and (exists ((mec1 MeansEndConcretization)) (and (= (tgt mec1) c) (pd mec1))) (and (not (exists ((mec2 MeansEndConcretization)) (and (= (tgt mec2) c) (or (fs mec2) (ps mec2) (un mec2) (co mec2))))) (not (exists ((dc DependerLinkConcretization)) (and (= (srcEndpoint dc) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc) c) (fd dc))))))
		(and (exists ((dc1 DependerLinkConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc1) c) (pd dc1))) (not (exists ((dc2 DependerLinkConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc2) c) (fd dc2)))))
		(and (exists ((dc1 DependeeLinkConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc1) c) (pd dc1))) (not (exists ((dc2 DependeeLinkConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc2) c) (fd dc2)))))
	)
	true
	false
)))))
(assert	(forall ((c GoalConcretization)) (=> (and (not (inited c)) (or (fs c) (ps c) (n c) (un c) (co c) (pd c))) (= (fd c) false))))
(assert	(forall ((c GoalConcretization)) (=> (and (not (inited c)) (not (fs c)) (not (ps c)) (not (n c)) (not (un c)) (not (co c)) (not (pd c))) (= (fd c) true))))
;(assert	(forall ((c GoalConcretization)) (=> (not (inited c)) (= (fd c) (ite
;	(or
;		(and (exists ((mec1 MeansEndConcretization)) (and (= (tgt mec1) c) (fd mec1))) (not (exists ((mec2 MeansEndConcretization)) (and (= (tgt mec2) c) (or (fs mec2) (ps mec2) (un mec2) (co mec2) (pd mec2))))))
;		(exists ((dc DependerLinkConcretization)) (and (= (srcEndpoint dc) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc) c) (fd dc)))
;		(exists ((dc DependeeLinkConcretization)) (and (= (srcEndpoint dc) ENDPOINT_GOAL) (= ((as src (GoalConcretization)) dc) c) (fd dc)))
;	)
;	true
;	false
;)))))

;Task propagation (Decomposition + Depender)
(assert (forall ((c TaskConcretization)) (=> (not (inited c)) (= (fd c) (ite
	(or
		(exists ((dc DecompositionConcretization)) (and (= (tgt dc) c) (fd dc)))
		(exists ((dc DependerLinkConcretization)) (and (= (srcEndpoint dc) ENDPOINT_TASK) (= ((as src (TaskConcretization)) dc) c) (fd dc)))
	)
	true
	false
)))))
(assert (forall ((c TaskConcretization)) (=> (and (not (inited c)) (fd c))  (= (pd c) false))))
(assert (forall ((c TaskConcretization)) (=> (and (not (inited c)) (not (fd c)))  (= (pd c) (ite
	(or
		(and (exists ((dc1 DecompositionConcretization)) (and (= (tgt dc1) c) (pd dc1))) (not (exists ((dc2 DecompositionConcretization)) (and (= (tgt dc2) c) (fd dc2)))) (not (exists ((dc3 DependerLinkConcretization)) (and (= (srcEndpoint dc3) ENDPOINT_TASK) (= ((as src (TaskConcretization)) dc3) c) (fd dc3)))))
		(and (exists ((dc1 DependerLinkConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_TASK) (= ((as src (TaskConcretization)) dc1) c) (pd dc1))) (not (exists ((dc2 DependerLinkConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_TASK) (= ((as src (TaskConcretization)) dc2) c) (fd dc2)))) (not (exists ((dc3 DecompositionConcretization)) (and (= (tgt dc3) c) (fd dc3)))))
	)
	true
	false
)))))
(assert (forall ((c TaskConcretization)) (=> (and (not (inited c)) (or (fd c) (pd c)))  (= (co c) false))))
(assert (forall ((c TaskConcretization)) (=> (and (not (inited c)) (not (fd c)) (not (pd c)))  (= (co c) (ite
	(or
		(and (exists ((dc1 DecompositionConcretization)) (and (= (tgt dc1) c) (co dc1))) (not (exists ((dc2 DecompositionConcretization)) (and (= (tgt dc2) c) (or (fd dc2) (pd dc2))))) (not (exists ((dc3 DependerLinkConcretization)) (and (= (srcEndpoint dc3) ENDPOINT_TASK) (= ((as src (TaskConcretization)) dc3) c) (or (fd dc3) (pd dc3))))))
		(and (exists ((dc1 DependerLinkConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_TASK) (= ((as src (TaskConcretization)) dc1) c) (co dc1))) (not (exists ((dc2 DependerLinkConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_TASK) (= ((as src (TaskConcretization)) dc2) c) (or (fd dc2) (pd dc2))))) (not (exists ((dc3 DecompositionConcretization)) (and (= (tgt dc3) c) (or (fd dc3) (pd dc3))))))
	)
	true
	false
)))))
(assert (forall ((c TaskConcretization)) (=> (and (not (inited c)) (or (fd c) (pd c) (co c)))  (= (un c) false))))
(assert (forall ((c TaskConcretization)) (=> (and (not (inited c)) (not (fd c)) (not (pd c)) (not (co c)))  (= (un c) (ite
	(or
		(and (exists ((dc1 DecompositionConcretization)) (and (= (tgt dc1) c) (un dc1))) (not (exists ((dc2 DecompositionConcretization)) (and (= (tgt dc2) c) (or (fd dc2) (pd dc2) (co dc2))))) (not (exists ((dc3 DependerLinkConcretization)) (and (= (srcEndpoint dc3) ENDPOINT_TASK) (= ((as src (TaskConcretization)) dc3) c) (or (fd dc3) (pd dc3) (co dc3))))))
		(and (exists ((dc1 DependerLinkConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_TASK) (= ((as src (TaskConcretization)) dc1) c) (un dc1))) (not (exists ((dc2 DependerLinkConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_TASK) (= ((as src (TaskConcretization)) dc2) c) (or (fd dc2) (pd dc2) (co dc2))))) (not (exists ((dc3 DecompositionConcretization)) (and (= (tgt dc3) c) (or (fd dc3) (pd dc3) (co dc3))))))
	)
	true
	false
)))))
(assert (forall ((c TaskConcretization)) (=> (and (not (inited c)) (or (fd c) (pd c) (co c) (un c)))  (= (n c) false))))
(assert (forall ((c TaskConcretization)) (=> (and (not (inited c)) (not (fd c)) (not (pd c)) (not (co c)) (not (un c)))  (= (n c) (ite
	(or
		(and (not (exists ((dc1 DecompositionConcretization)) (= (tgt dc1) c))) (not (exists ((dc2 DependerLinkConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_TASK) (= ((as src (TaskConcretization)) dc2) c)))))
		(and (exists ((dc1 DecompositionConcretization)) (and (= (tgt dc1) c) (n dc1))) (not (exists ((dc2 DecompositionConcretization)) (and (= (tgt dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2))))) (not (exists ((dc3 DependerLinkConcretization)) (and (= (srcEndpoint dc3) ENDPOINT_TASK) (= ((as src (TaskConcretization)) dc3) c) (or (fd dc3) (pd dc3) (co dc3) (un dc3))))))
		(and (exists ((dc1 DependerLinkConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_TASK) (= ((as src (TaskConcretization)) dc1) c) (n dc1))) (not (exists ((dc2 DependerLinkConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_TASK) (= ((as src (TaskConcretization)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2))))) (not (exists ((dc3 DecompositionConcretization)) (and (= (tgt dc3) c) (or (fd dc3) (pd dc3) (co dc3) (un dc3))))))
	)
	true
	false
)))))
(assert (forall ((c TaskConcretization)) (=> (and (not (inited c)) (or (fd c) (pd c) (co c) (un c) (n c)))  (= (ps c) false))))
(assert (forall ((c TaskConcretization)) (=> (and (not (inited c)) (not (fd c)) (not (pd c)) (not (co c)) (not (un c)) (not (n c)))  (= (ps c) (ite
	(or
		(and (exists ((dc1 DecompositionConcretization)) (and (= (tgt dc1) c) (ps dc1))) (not (exists ((dc2 DecompositionConcretization)) (and (= (tgt dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (n dc2))))) (not (exists ((dc3 DependerLinkConcretization)) (and (= (srcEndpoint dc3) ENDPOINT_TASK) (= ((as src (TaskConcretization)) dc3) c) (or (fd dc3) (pd dc3) (co dc3) (un dc3) (n dc3))))))
		(and (exists ((dc1 DependerLinkConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_TASK) (= ((as src (TaskConcretization)) dc1) c) (ps dc1))) (not (exists ((dc2 DependerLinkConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_TASK) (= ((as src (TaskConcretization)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (n dc2))))) (not (exists ((dc3 DecompositionConcretization)) (and (= (tgt dc3) c) (or (fd dc3) (pd dc3) (co dc3) (un dc3) (n dc3))))))
	)
	true
	false
)))))
(assert (forall ((c TaskConcretization)) (=> (and (not (inited c)) (or (fd c) (pd c) (co c) (un c) (n c) (ps c)))  (= (fs c) false))))
(assert (forall ((c TaskConcretization)) (=> (and (not (inited c)) (not (fd c)) (not (pd c)) (not (co c)) (not (un c)) (not (n c)) (not (ps c)))  (= (fs c) true))))
;(assert (forall ((c TaskConcretization)) (=> (not (inited c))  (= (fs c) (ite
;	(or
;		(and (exists ((dc1 DecompositionConcretization)) (and (= (tgt dc1) c) (fs dc1))) (not (exists ((dc2 DecompositionConcretization)) (and (= (tgt dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (n dc2) (ps dc2))))) (not (exists ((dc3 DependerLinkConcretization)) (and (= (srcEndpoint dc3) ENDPOINT_TASK) (= ((as src (TaskConcretization)) dc3) c) (or (fd dc3) (pd dc3) (co dc3) (un dc3) (n dc3) (ps dc3))))))
;		(and (exists ((dc1 DependerLinkConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_TASK) (= ((as src (TaskConcretization)) dc1) c) (fs dc1))) (not (exists ((dc2 DependerLinkConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_TASK) (= ((as src (TaskConcretization)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (n dc2) (ps dc2))))) (not (exists ((dc3 DecompositionConcretization)) (and (= (tgt dc3) c) (or (fd dc3) (pd dc3) (co dc3) (un dc3) (n dc3) (ps dc3))))))
;	)
;	true
;	false
;)))))

;SoftGoal propagation (only Contribution)
(assert (forall ((c SoftGoalConcretization)) (=> (not (inited c)) (= (co c) (ite
	(or (exists ((cc1 ContributionConcretization)) (and (= (tgt cc1) c) (co cc1))) (exists ((cc2 ContributionConcretization) (cc3 ContributionConcretization)) (and (= (tgt cc2) c) (and (= (tgt cc3) c) (and (or (fs cc2) (ps cc2)) (or (pd cc3) (fd cc3)))))))
	true
	false
)))))
(assert (forall ((c SoftGoalConcretization)) (=> (and (not (inited c)) (co c)) (= (un c) false))))
(assert (forall ((c SoftGoalConcretization)) (=> (and (not (inited c)) (not (co c))) (= (un c) (ite
	(and (exists ((cc1 ContributionConcretization)) (and (= (tgt cc1) c) (un cc1))) (not (exists ((cc2 ContributionConcretization)) (and (= (tgt cc2) c) (co cc2)))) (not (exists ((cc3 ContributionConcretization) (cc4 ContributionConcretization)) (and (= (tgt cc3) c) (and (= (tgt cc4) c) (and (or (fs cc3) (ps cc3)) (or (pd cc4) (fd cc4))))))))
	true
	false
)))))
(assert (forall ((c SoftGoalConcretization)) (=> (and (not (inited c)) (or (co c) (un c))) (= (fs c) false))))
(assert (forall ((c SoftGoalConcretization)) (=> (and (not (inited c)) (not (co c)) (not (un c))) (= (fs c) (ite
	(and (exists ((cc1 ContributionConcretization)) (and (= (tgt cc1) c) (fs cc1))) (not (exists ((cc2 ContributionConcretization)) (and (= (tgt cc2) c) (or (un cc2) (co cc2) (pd cc2) (fd cc2))))))
	true
	false
)))))
(assert (forall ((c SoftGoalConcretization)) (=> (and (not (inited c)) (or (co c) (un c) (fs c))) (= (ps c) false))))
(assert (forall ((c SoftGoalConcretization)) (=> (and (not (inited c)) (not (co c)) (not (un c)) (not (fs c))) (= (ps c) (ite
	(and (exists ((cc1 ContributionConcretization)) (and (= (tgt cc1) c) (ps cc1))) (not (exists ((cc2 ContributionConcretization)) (and (= (tgt cc2) c) (or (fs cc2) (un cc2) (co cc2) (pd cc2) (fd cc2))))))
	true
	false
)))))
(assert (forall ((c SoftGoalConcretization)) (=> (and (not (inited c)) (or (co c) (un c) (fs c) (ps c))) (= (fd c) false))))
(assert (forall ((c SoftGoalConcretization)) (=> (and (not (inited c)) (not (co c)) (not (un c)) (not (fs c)) (not (ps c))) (= (fd c) (ite
	(and (exists ((cc1 ContributionConcretization)) (and (= (tgt cc1) c) (fd cc1))) (not (exists ((cc2 ContributionConcretization)) (and (= (tgt cc2) c) (or (fs cc2) (ps cc2) (un cc2) (co cc2))))))
	true
	false
)))))
(assert (forall ((c SoftGoalConcretization)) (=> (and (not (inited c)) (or (co c) (un c) (fs c) (ps c) (fd c))) (= (pd c) false))))
(assert (forall ((c SoftGoalConcretization)) (=> (and (not (inited c)) (not (co c)) (not (un c)) (not (fs c)) (not (ps c)) (not (fd c))) (= (pd c) (ite
	(and (exists ((cc1 ContributionConcretization)) (and (= (tgt cc1) c) (pd cc1))) (not (exists ((cc2 ContributionConcretization)) (and (= (tgt cc2) c) (or (fs cc2) (ps cc2) (un cc2) (co cc2) (fd cc2))))))
	true
	false
)))))
(assert (forall ((c SoftGoalConcretization)) (=> (and (not (inited c)) (or (co c) (un c) (fs c) (ps c) (fd c) (pd c))) (= (n c) false))))
(assert (forall ((c SoftGoalConcretization)) (=> (and (not (inited c)) (not (co c)) (not (un c)) (not (fs c)) (not (ps c)) (not (fd c)) (not (pd c))) (= (n c) true))))
;(assert (forall ((c SoftGoalConcretization)) (=> (not (inited c)) (= (n c) (ite
;	(or
;		(not (exists ((cc ContributionConcretization)) (= (tgt cc) c)))
;		(and (exists ((cc1 ContributionConcretization)) (and (= (tgt cc1) c) (n cc1))) (not (exists ((cc2 ContributionConcretization)) (and (= (tgt cc2) c) (or (fs cc2) (ps cc2) (un cc2) (co cc2) (pd cc2) (fd cc2))))))
;	)
;	true
;	false
;)))))

;Resource propagation (only Dependee)
(assert (forall ((c ResourceConcretization)) (=> (not (inited c)) (= (fd c) (ite
	(exists ((dc DependeeLinkConcretization)) (and (= (srcEndpoint dc) ENDPOINT_RESOURCE) (= ((as src (ResourceConcretization)) dc) c) (fd dc)))
	true
	false
)))))
(assert (forall ((c ResourceConcretization)) (=> (and (not (inited c)) (fd c))  (= (pd c) false))))
(assert (forall ((c ResourceConcretization)) (=> (and (not (inited c)) (not (fd c)))  (= (pd c) (ite
	(and (exists ((dc1 DependeeLinkConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_RESOURCE) (= ((as src (ResourceConcretization)) dc1) c) (pd dc1))) (not (exists ((dc2 DependeeLinkConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_RESOURCE) (= ((as src (ResourceConcretization)) dc2) c) (fd dc2)))))
	true
	false
)))))
(assert (forall ((c ResourceConcretization)) (=> (and (not (inited c)) (or (fd c) (pd c)))  (= (co c) false))))
(assert (forall ((c ResourceConcretization)) (=> (and (not (inited c)) (not (fd c)) (not (pd c)))  (= (co c) (ite
	(and (exists ((dc1 DependeeLinkConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_RESOURCE) (= ((as src (ResourceConcretization)) dc1) c) (co dc1))) (not (exists ((dc2 DependeeLinkConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_RESOURCE) (= ((as src (ResourceConcretization)) dc2) c) (or (fd dc2) (pd dc2))))))
	true
	false
)))))
(assert (forall ((c ResourceConcretization)) (=> (and (not (inited c)) (or (fd c) (pd c) (co c)))  (= (un c) false))))
(assert (forall ((c ResourceConcretization)) (=> (and (not (inited c)) (not (fd c)) (not (pd c)) (not (co c)))  (= (un c) (ite
	(and (exists ((dc1 DependeeLinkConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_RESOURCE) (= ((as src (ResourceConcretization)) dc1) c) (un dc1))) (not (exists ((dc2 DependeeLinkConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_RESOURCE) (= ((as src (ResourceConcretization)) dc2) c) (or (fd dc2) (pd dc2) (co dc2))))))
	true
	false
)))))
(assert (forall ((c ResourceConcretization)) (=> (and (not (inited c)) (or (fd c) (pd c) (co c) (un c)))  (= (n c) false))))
(assert (forall ((c ResourceConcretization)) (=> (and (not (inited c)) (not (fd c)) (not (pd c)) (not (co c)) (not (un c)))  (= (n c) (ite
	(or
		(not (exists ((dc DependeeLinkConcretization)) (and (= (srcEndpoint dc) ENDPOINT_RESOURCE) (= ((as src (ResourceConcretization)) dc) c))))
		(and (exists ((dc1 DependeeLinkConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_RESOURCE) (= ((as src (ResourceConcretization)) dc1) c) (n dc1))) (not (exists ((dc2 DependeeLinkConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_RESOURCE) (= ((as src (ResourceConcretization)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2))))))
	)
	true
	false
)))))
(assert (forall ((c ResourceConcretization)) (=> (and (not (inited c)) (or (fd c) (pd c) (co c) (un c) (n c)))  (= (ps c) false))))
(assert (forall ((c ResourceConcretization)) (=> (and (not (inited c)) (not (fd c)) (not (pd c)) (not (co c)) (not (un c)) (not (n c)))  (= (ps c) (ite
	(and (exists ((dc1 DependeeLinkConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_RESOURCE) (= ((as src (ResourceConcretization)) dc1) c) (ps dc1))) (not (exists ((dc2 DependeeLinkConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_RESOURCE) (= ((as src (ResourceConcretization)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (n dc2))))))
	true
	false
)))))
(assert (forall ((c ResourceConcretization)) (=> (and (not (inited c)) (or (fd c) (pd c) (co c) (un c) (n c) (ps c)))  (= (fs c) false))))
(assert (forall ((c ResourceConcretization)) (=> (and (not (inited c)) (not (fd c)) (not (pd c)) (not (co c)) (not (un c)) (not (n c)) (not (ps c)))  (= (fs c) true))))
;(assert (forall ((c ResourceConcretization)) (=> (not (inited c))  (= (fs c) (ite
;	(and (exists ((dc1 DependeeLinkConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_RESOURCE) (= ((as src (ResourceConcretization)) dc1) c) (fs dc1))) (not (exists ((dc2 DependeeLinkConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_RESOURCE) (= ((as src (ResourceConcretization)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (n dc2) (ps dc2))))))
;	true
;	false
;)))))
