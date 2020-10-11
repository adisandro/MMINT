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
	MeetingInitiator
	MeetingScheduler
	MeetingParticipant
	DateDeterminer
)))
(declare-datatypes () ((Task
	WaysToOrganizeMeeting
	LetSchedulerScheduleMeeting
	OrganizeMeeting
	ScheduleMeeting
	ParticipateInMeeting
	AttendMeeting
	ProvideDetails
	DecideConvenientDates
	UseProfiles
	DetermineMeetingDate
)))
(declare-datatypes () ((Goal
	MeetingBeScheduledMI
	AgreeableMeetingDate
	ConvenientMeetingDate
	Dependencies
	MeetingBeScheduled
)))
(declare-datatypes () ((SoftGoal
	Quick
	LowEffortMI
	LowEffortMP
)))
(declare-datatypes () ((Resource
	Details
)))
(declare-datatypes () ((Intention
	MeetingInitiator2MeetingBeScheduledMI
	MeetingInitiator2WaysToOrganizeMeeting
	MeetingInitiator2LetSchedulerScheduleMeeting
	MeetingInitiator2OrganizeMeeting
	MeetingInitiator2Quick
	MeetingInitiator2LowEffortMI
	MeetingScheduler2ScheduleMeeting
	MeetingParticipant2ParticipateInMeeting
	MeetingParticipant2AttendMeeting
	MeetingParticipant2ProvideDetails
	MeetingParticipant2AgreeableMeetingDate
	MeetingParticipant2ConvenientMeetingDate
	MeetingParticipant2DecideConvenientDates
	MeetingParticipant2LowEffortMP
	MeetingParticipant2UseProfiles
	DateDeterminer2DetermineMeetingDate
)))
(declare-datatypes () ((MeansEnd
	WaysToOrganizeMeeting2MeetingBeScheduledMI
	LetSchedulerScheduleMeeting2MeetingBeScheduledMI
	DecideConvenientDates2ConvenientMeetingDate
)))
(declare-datatypes () ((Decomposition
	MeetingBeScheduledMI2OrganizeMeeting
	Quick2OrganizeMeeting
	LowEffortMI2OrganizeMeeting
	AttendMeeting2ParticipateInMeeting
	ProvideDetails2ParticipateInMeeting
	AgreeableMeetingDate2ParticipateInMeeting
	ConvenientMeetingDate2ParticipateInMeeting
	LowEffortMP2ProvideDetails
	UseProfiles2ParticipateInMeeting
)))
(declare-datatypes () ((Contribution
	WaysToOrganizeMeeting2Quick
	WaysToOrganizeMeeting2LowEffortMI
	LetSchedulerScheduleMeeting2Quick
	LetSchedulerScheduleMeeting2LowEffortMI
)))
(declare-datatypes () ((DependerLink
	OrganizeMeeting2Dependencies
	LetSchedulerScheduleMeeting2MeetingBeScheduled
	ScheduleMeeting2Details
)))
(declare-datatypes () ((DependeeLink
	Dependencies2ParticipateInMeeting
	MeetingBeScheduled2ScheduleMeeting
	Details2ProvideDetails
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
	(node MeetingInitiator c)
	(node MeetingScheduler c)
	(node MeetingParticipant c)
	(node DateDeterminer c)
)))
;Tasks are Complete
(assert (forall ((c TaskConcretization)) (or
	(node WaysToOrganizeMeeting c)
	(node LetSchedulerScheduleMeeting c)
	(node OrganizeMeeting c)
	(node ScheduleMeeting c)
	(node ParticipateInMeeting c)
	(node AttendMeeting c)
	(node ProvideDetails c)
	(node DecideConvenientDates c)
	(node UseProfiles c)
	(node DetermineMeetingDate c)
)))
;Goals are Complete
(assert (forall ((c GoalConcretization)) (or
	(node MeetingBeScheduledMI c)
	(node AgreeableMeetingDate c)
	(node ConvenientMeetingDate c)
	(node Dependencies c)
	(node MeetingBeScheduled c)
)))
;SoftGoals are Complete
(assert (forall ((c SoftGoalConcretization)) (or
	(node Quick c)
	(node LowEffortMI c)
	(node LowEffortMP c)
)))
;Resources are Complete
(assert (forall ((c ResourceConcretization)) (or
	(node Details c)
)))
(assert (forall ((c IntentionConcretization)) (or
	(edge MeetingInitiator2MeetingBeScheduledMI c)
	(edge MeetingInitiator2WaysToOrganizeMeeting c)
	(edge MeetingInitiator2LetSchedulerScheduleMeeting c)
	(edge MeetingInitiator2OrganizeMeeting c)
	(edge MeetingInitiator2Quick c)
	(edge MeetingInitiator2LowEffortMI c)
	(edge MeetingScheduler2ScheduleMeeting c)
	(edge MeetingParticipant2ParticipateInMeeting c)
	(edge MeetingParticipant2AttendMeeting c)
	(edge MeetingParticipant2ProvideDetails c)
	(edge MeetingParticipant2AgreeableMeetingDate c)
	(edge MeetingParticipant2ConvenientMeetingDate c)
	(edge MeetingParticipant2DecideConvenientDates c)
	(edge MeetingParticipant2LowEffortMP c)
	(edge MeetingParticipant2UseProfiles c)
	(edge DateDeterminer2DetermineMeetingDate c)
)))
;MeansEnds are Complete
(assert (forall ((c MeansEndConcretization)) (or
	(edge WaysToOrganizeMeeting2MeetingBeScheduledMI c)
	(edge LetSchedulerScheduleMeeting2MeetingBeScheduledMI c)
	(edge DecideConvenientDates2ConvenientMeetingDate c)
)))
;Decompositions are Complete
(assert (forall ((c DecompositionConcretization)) (or
	(edge MeetingBeScheduledMI2OrganizeMeeting c)
	(edge Quick2OrganizeMeeting c)
	(edge LowEffortMI2OrganizeMeeting c)
	(edge AttendMeeting2ParticipateInMeeting c)
	(edge ProvideDetails2ParticipateInMeeting c)
	(edge AgreeableMeetingDate2ParticipateInMeeting c)
	(edge ConvenientMeetingDate2ParticipateInMeeting c)
	(edge LowEffortMP2ProvideDetails c)
	(edge UseProfiles2ParticipateInMeeting c)
)))
;Contributions are Complete
(assert (forall ((c ContributionConcretization)) (or
	(edge WaysToOrganizeMeeting2Quick c)
	(edge WaysToOrganizeMeeting2LowEffortMI c)
	(edge LetSchedulerScheduleMeeting2Quick c)
	(edge LetSchedulerScheduleMeeting2LowEffortMI c)
)))
(assert (forall ((c DependerLinkConcretization)) (or
	(edge OrganizeMeeting2Dependencies c)
	(edge LetSchedulerScheduleMeeting2MeetingBeScheduled c)
	(edge ScheduleMeeting2Details c)
)))
(assert (forall ((c DependeeLinkConcretization)) (or
	(edge Dependencies2ParticipateInMeeting c)
	(edge MeetingBeScheduled2ScheduleMeeting c)
	(edge Details2ProvideDetails c)
)))

;Model Elements
;MeetingInitiator Exists
(assert	(exists ((c ActorConcretization)) (node MeetingInitiator c)))
;MeetingInitiator is Unique
(assert	(forall ((c1 ActorConcretization) (c2 ActorConcretization)) (=>
	(and (node MeetingInitiator c1) (node MeetingInitiator c2))
	(= c1 c2)
)))
;MeetingInitiator is Distinct from MeetingScheduler
(assert	(forall ((c ActorConcretization)) (=>
	(node MeetingInitiator c)
	(not (node MeetingScheduler c))
)))
;MeetingInitiator is Distinct from MeetingParticipant
(assert	(forall ((c ActorConcretization)) (=>
	(node MeetingInitiator c)
	(not (node MeetingParticipant c))
)))
;MeetingScheduler Exists
(assert	(exists ((c ActorConcretization)) (node MeetingScheduler c)))
;MeetingScheduler is Unique
(assert	(forall ((c1 ActorConcretization) (c2 ActorConcretization)) (=>
	(and (node MeetingScheduler c1) (node MeetingScheduler c2))
	(= c1 c2)
)))
;MeetingScheduler is Distinct from MeetingInitiator
(assert	(forall ((c ActorConcretization)) (=>
	(node MeetingScheduler c)
	(not (node MeetingInitiator c))
)))
;MeetingScheduler is Distinct from MeetingParticipant
(assert	(forall ((c ActorConcretization)) (=>
	(node MeetingScheduler c)
	(not (node MeetingParticipant c))
)))
;MeetingParticipant Exists
(assert	(exists ((c ActorConcretization)) (node MeetingParticipant c)))
;MeetingParticipant is Unique
(assert	(forall ((c1 ActorConcretization) (c2 ActorConcretization)) (=>
	(and (node MeetingParticipant c1) (node MeetingParticipant c2))
	(= c1 c2)
)))
;MeetingParticipant is Distinct from MeetingInitiator
(assert	(forall ((c ActorConcretization)) (=>
	(node MeetingParticipant c)
	(not (node MeetingInitiator c))
)))
;MeetingParticipant is Distinct from MeetingScheduler
(assert	(forall ((c ActorConcretization)) (=>
	(node MeetingParticipant c)
	(not (node MeetingScheduler c))
)))
;DateDeterminer Exists
(assert	(exists ((c ActorConcretization)) (node DateDeterminer c)))
;DateDeterminer is Unique
(assert	(forall ((c1 ActorConcretization) (c2 ActorConcretization)) (=>
	(and (node DateDeterminer c1) (node DateDeterminer c2))
	(= c1 c2)
)))
;MeetingBeScheduledMI initial analysis tag
(assert (forall ((c GoalConcretization)) (=>
	(node MeetingBeScheduledMI c)
	(= (inited c) false)
)))
;MeetingBeScheduledMI Exists
(assert	(exists ((c GoalConcretization)) (node MeetingBeScheduledMI c)))
;MeetingBeScheduledMI is Unique
(assert	(forall ((c1 GoalConcretization) (c2 GoalConcretization)) (=>
	(and (node MeetingBeScheduledMI c1) (node MeetingBeScheduledMI c2))
	(= c1 c2)
)))
;MeetingBeScheduledMI is Distinct from Dependencies
(assert	(forall ((c GoalConcretization)) (=>
	(node MeetingBeScheduledMI c)
	(not (node Dependencies c))
)))
;MeetingBeScheduledMI is Distinct from MeetingBeScheduled
(assert	(forall ((c GoalConcretization)) (=>
	(node MeetingBeScheduledMI c)
	(not (node MeetingBeScheduled c))
)))
;MeetingBeScheduledMI is Distinct from AgreeableMeetingDate
(assert	(forall ((c GoalConcretization)) (=>
	(node MeetingBeScheduledMI c)
	(not (node AgreeableMeetingDate c))
)))
;MeetingBeScheduledMI is Distinct from ConvenientMeetingDate
(assert	(forall ((c GoalConcretization)) (=>
	(node MeetingBeScheduledMI c)
	(not (node ConvenientMeetingDate c))
)))

;WaysToOrganizeMeeting initial analysis tag
(assert (forall ((c TaskConcretization)) (=>
	(node WaysToOrganizeMeeting c)
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
;WaysToOrganizeMeeting Exists
(assert	(exists ((c TaskConcretization)) (node WaysToOrganizeMeeting c)))
;WaysToOrganizeMeeting is Distinct from ScheduleMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node WaysToOrganizeMeeting c)
	(not (node ScheduleMeeting c))
)))
;WaysToOrganizeMeeting is Distinct from ParticipateInMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node WaysToOrganizeMeeting c)
	(not (node ParticipateInMeeting c))
)))
;WaysToOrganizeMeeting is Distinct from AttendMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node WaysToOrganizeMeeting c)
	(not (node AttendMeeting c))
)))
;WaysToOrganizeMeeting is Distinct from ProvideDetails
(assert	(forall ((c TaskConcretization)) (=>
	(node WaysToOrganizeMeeting c)
	(not (node ProvideDetails c))
)))
;WaysToOrganizeMeeting is Distinct from DecideConvenientDates
(assert	(forall ((c TaskConcretization)) (=>
	(node WaysToOrganizeMeeting c)
	(not (node DecideConvenientDates c))
)))
;WaysToOrganizeMeeting is Distinct from UseProfiles
(assert	(forall ((c TaskConcretization)) (=>
	(node WaysToOrganizeMeeting c)
	(not (node UseProfiles c))
)))
;WaysToOrganizeMeeting is Distinct from DetermineMeetingDate
(assert	(forall ((c TaskConcretization)) (=>
	(node WaysToOrganizeMeeting c)
	(not (node DetermineMeetingDate c))
)))
;WaysToOrganizeMeeting is Distinct from LetSchedulerScheduleMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node WaysToOrganizeMeeting c)
	(not (node LetSchedulerScheduleMeeting c))
)))
;WaysToOrganizeMeeting is Distinct from OrganizeMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node WaysToOrganizeMeeting c)
	(not (node OrganizeMeeting c))
)))

;LetSchedulerScheduleMeeting initial analysis tag
(assert (forall ((c TaskConcretization)) (=>
	(node LetSchedulerScheduleMeeting c)
	(= (inited c) false)
)))
;LetSchedulerScheduleMeeting Exists
(assert	(exists ((c TaskConcretization)) (node LetSchedulerScheduleMeeting c)))
;LetSchedulerScheduleMeeting is Unique
(assert	(forall ((c1 TaskConcretization) (c2 TaskConcretization)) (=>
	(and (node LetSchedulerScheduleMeeting c1) (node LetSchedulerScheduleMeeting c2))
	(= c1 c2)
)))
;LetSchedulerScheduleMeeting is Distinct from ScheduleMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node LetSchedulerScheduleMeeting c)
	(not (node ScheduleMeeting c))
)))
;LetSchedulerScheduleMeeting is Distinct from ParticipateInMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node LetSchedulerScheduleMeeting c)
	(not (node ParticipateInMeeting c))
)))
;LetSchedulerScheduleMeeting is Distinct from AttendMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node LetSchedulerScheduleMeeting c)
	(not (node AttendMeeting c))
)))
;LetSchedulerScheduleMeeting is Distinct from ProvideDetails
(assert	(forall ((c TaskConcretization)) (=>
	(node LetSchedulerScheduleMeeting c)
	(not (node ProvideDetails c))
)))
;LetSchedulerScheduleMeeting is Distinct from DecideConvenientDates
(assert	(forall ((c TaskConcretization)) (=>
	(node LetSchedulerScheduleMeeting c)
	(not (node DecideConvenientDates c))
)))
;LetSchedulerScheduleMeeting is Distinct from UseProfiles
(assert	(forall ((c TaskConcretization)) (=>
	(node LetSchedulerScheduleMeeting c)
	(not (node UseProfiles c))
)))
;LetSchedulerScheduleMeeting is Distinct from DetermineMeetingDate
(assert	(forall ((c TaskConcretization)) (=>
	(node LetSchedulerScheduleMeeting c)
	(not (node DetermineMeetingDate c))
)))
;LetSchedulerScheduleMeeting is Distinct from WaysToOrganizeMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node LetSchedulerScheduleMeeting c)
	(not (node WaysToOrganizeMeeting c))
)))
;LetSchedulerScheduleMeeting is Distinct from OrganizeMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node LetSchedulerScheduleMeeting c)
	(not (node OrganizeMeeting c))
)))

;OrganizeMeeting initial analysis tag
(assert (forall ((c TaskConcretization)) (=>
	(node OrganizeMeeting c)
	(= (inited c) false)
)))
;OrganizeMeeting Exists
(assert	(exists ((c TaskConcretization)) (node OrganizeMeeting c)))
;OrganizeMeeting is Unique
(assert	(forall ((c1 TaskConcretization) (c2 TaskConcretization)) (=>
	(and (node OrganizeMeeting c1) (node OrganizeMeeting c2))
	(= c1 c2)
)))
;OrganizeMeeting is Distinct from ScheduleMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node OrganizeMeeting c)
	(not (node ScheduleMeeting c))
)))
;OrganizeMeeting is Distinct from ParticipateInMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node OrganizeMeeting c)
	(not (node ParticipateInMeeting c))
)))
;OrganizeMeeting is Distinct from AttendMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node OrganizeMeeting c)
	(not (node AttendMeeting c))
)))
;OrganizeMeeting is Distinct from ProvideDetails
(assert	(forall ((c TaskConcretization)) (=>
	(node OrganizeMeeting c)
	(not (node ProvideDetails c))
)))
;OrganizeMeeting is Distinct from DecideConvenientDates
(assert	(forall ((c TaskConcretization)) (=>
	(node OrganizeMeeting c)
	(not (node DecideConvenientDates c))
)))
;OrganizeMeeting is Distinct from UseProfiles
(assert	(forall ((c TaskConcretization)) (=>
	(node OrganizeMeeting c)
	(not (node UseProfiles c))
)))
;OrganizeMeeting is Distinct from DetermineMeetingDate
(assert	(forall ((c TaskConcretization)) (=>
	(node OrganizeMeeting c)
	(not (node DetermineMeetingDate c))
)))
;OrganizeMeeting is Distinct from WaysToOrganizeMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node OrganizeMeeting c)
	(not (node WaysToOrganizeMeeting c))
)))
;OrganizeMeeting is Distinct from LetSchedulerScheduleMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node OrganizeMeeting c)
	(not (node LetSchedulerScheduleMeeting c))
)))

;Quick initial analysis tag
(assert (forall ((c SoftGoalConcretization)) (=>
	(node Quick c)
	(= (inited c) false)
)))
;Quick Exists
(assert	(exists ((c SoftGoalConcretization)) (node Quick c)))
;Quick is Unique
(assert	(forall ((c1 SoftGoalConcretization) (c2 SoftGoalConcretization)) (=>
	(and (node Quick c1) (node Quick c2))
	(= c1 c2)
)))
;Quick is Distinct from LowEffortMP
(assert	(forall ((c SoftGoalConcretization)) (=>
	(node Quick c)
	(not (node LowEffortMP c))
)))
;Quick is Distinct from LowEffortMI
(assert	(forall ((c SoftGoalConcretization)) (=>
	(node Quick c)
	(not (node LowEffortMI c))
)))

;LowEffortMI initial analysis tag
(assert (forall ((c SoftGoalConcretization)) (=>
	(node LowEffortMI c)
	(= (inited c) false)
)))
;LowEffortMI Exists
(assert	(exists ((c SoftGoalConcretization)) (node LowEffortMI c)))
;LowEffortMI is Unique
(assert	(forall ((c1 SoftGoalConcretization) (c2 SoftGoalConcretization)) (=>
	(and (node LowEffortMI c1) (node LowEffortMI c2))
	(= c1 c2)
)))
;LowEffortMI is Distinct from LowEffortMP
(assert	(forall ((c SoftGoalConcretization)) (=>
	(node LowEffortMI c)
	(not (node LowEffortMP c))
)))
;LowEffortMI is Distinct from Quick
(assert	(forall ((c SoftGoalConcretization)) (=>
	(node LowEffortMI c)
	(not (node Quick c))
)))

;ScheduleMeeting initial analysis tag
(assert (forall ((c TaskConcretization)) (=>
	(node ScheduleMeeting c)
	(= (inited c) false)
)))
;ScheduleMeeting Exists
(assert	(exists ((c TaskConcretization)) (node ScheduleMeeting c)))
;ScheduleMeeting is Unique
(assert	(forall ((c1 TaskConcretization) (c2 TaskConcretization)) (=>
	(and (node ScheduleMeeting c1) (node ScheduleMeeting c2))
	(= c1 c2)
)))
;ScheduleMeeting is Distinct from WaysToOrganizeMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node ScheduleMeeting c)
	(not (node WaysToOrganizeMeeting c))
)))
;ScheduleMeeting is Distinct from LetSchedulerScheduleMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node ScheduleMeeting c)
	(not (node LetSchedulerScheduleMeeting c))
)))
;ScheduleMeeting is Distinct from OrganizeMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node ScheduleMeeting c)
	(not (node OrganizeMeeting c))
)))
;ScheduleMeeting is Distinct from ParticipateInMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node ScheduleMeeting c)
	(not (node ParticipateInMeeting c))
)))
;ScheduleMeeting is Distinct from AttendMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node ScheduleMeeting c)
	(not (node AttendMeeting c))
)))
;ScheduleMeeting is Distinct from ProvideDetails
(assert	(forall ((c TaskConcretization)) (=>
	(node ScheduleMeeting c)
	(not (node ProvideDetails c))
)))
;ScheduleMeeting is Distinct from DecideConvenientDates
(assert	(forall ((c TaskConcretization)) (=>
	(node ScheduleMeeting c)
	(not (node DecideConvenientDates c))
)))
;ScheduleMeeting is Distinct from UseProfiles
(assert	(forall ((c TaskConcretization)) (=>
	(node ScheduleMeeting c)
	(not (node UseProfiles c))
)))
;ScheduleMeeting is Distinct from DetermineMeetingDate
(assert	(forall ((c TaskConcretization)) (=>
	(node ScheduleMeeting c)
	(not (node DetermineMeetingDate c))
)))

;ParticipateInMeeting initial analysis tag
(assert (forall ((c TaskConcretization)) (=>
	(node ParticipateInMeeting c)
	(= (inited c) false)
)))
;ParticipateInMeeting Exists
(assert	(exists ((c TaskConcretization)) (node ParticipateInMeeting c)))
;ParticipateInMeeting is Unique
(assert	(forall ((c1 TaskConcretization) (c2 TaskConcretization)) (=>
	(and (node ParticipateInMeeting c1) (node ParticipateInMeeting c2))
	(= c1 c2)
)))
;ParticipateInMeeting is Distinct from WaysToOrganizeMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node ParticipateInMeeting c)
	(not (node WaysToOrganizeMeeting c))
)))
;ParticipateInMeeting is Distinct from LetSchedulerScheduleMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node ParticipateInMeeting c)
	(not (node LetSchedulerScheduleMeeting c))
)))
;ParticipateInMeeting is Distinct from OrganizeMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node ParticipateInMeeting c)
	(not (node OrganizeMeeting c))
)))
;ParticipateInMeeting is Distinct from ScheduleMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node ParticipateInMeeting c)
	(not (node ScheduleMeeting c))
)))
;ParticipateInMeeting is Distinct from DetermineMeetingDate
(assert	(forall ((c TaskConcretization)) (=>
	(node ParticipateInMeeting c)
	(not (node DetermineMeetingDate c))
)))
;ParticipateInMeeting is Distinct from AttendMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node ParticipateInMeeting c)
	(not (node AttendMeeting c))
)))
;ParticipateInMeeting is Distinct from ProvideDetails
(assert	(forall ((c TaskConcretization)) (=>
	(node ParticipateInMeeting c)
	(not (node ProvideDetails c))
)))
;ParticipateInMeeting is Distinct from DecideConvenientDates
(assert	(forall ((c TaskConcretization)) (=>
	(node ParticipateInMeeting c)
	(not (node DecideConvenientDates c))
)))
;ParticipateInMeeting is Distinct from UseProfiles
(assert	(forall ((c TaskConcretization)) (=>
	(node ParticipateInMeeting c)
	(not (node UseProfiles c))
)))

;AttendMeeting initial analysis tag
(assert (forall ((c TaskConcretization)) (=>
	(node AttendMeeting c)
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
;AttendMeeting Exists
(assert	(exists ((c TaskConcretization)) (node AttendMeeting c)))
;AttendMeeting is Unique
(assert	(forall ((c1 TaskConcretization) (c2 TaskConcretization)) (=>
	(and (node AttendMeeting c1) (node AttendMeeting c2))
	(= c1 c2)
)))
;AttendMeeting is Distinct from WaysToOrganizeMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node AttendMeeting c)
	(not (node WaysToOrganizeMeeting c))
)))
;AttendMeeting is Distinct from LetSchedulerScheduleMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node AttendMeeting c)
	(not (node LetSchedulerScheduleMeeting c))
)))
;AttendMeeting is Distinct from OrganizeMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node AttendMeeting c)
	(not (node OrganizeMeeting c))
)))
;AttendMeeting is Distinct from ScheduleMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node AttendMeeting c)
	(not (node ScheduleMeeting c))
)))
;AttendMeeting is Distinct from DetermineMeetingDate
(assert	(forall ((c TaskConcretization)) (=>
	(node AttendMeeting c)
	(not (node DetermineMeetingDate c))
)))
;AttendMeeting is Distinct from ParticipateInMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node AttendMeeting c)
	(not (node ParticipateInMeeting c))
)))
;AttendMeeting is Distinct from ProvideDetails
(assert	(forall ((c TaskConcretization)) (=>
	(node AttendMeeting c)
	(not (node ProvideDetails c))
)))
;AttendMeeting is Distinct from DecideConvenientDates
(assert	(forall ((c TaskConcretization)) (=>
	(node AttendMeeting c)
	(not (node DecideConvenientDates c))
)))
;AttendMeeting is Distinct from UseProfiles
(assert	(forall ((c TaskConcretization)) (=>
	(node AttendMeeting c)
	(not (node UseProfiles c))
)))

;ProvideDetails initial analysis tag
(assert (forall ((c TaskConcretization)) (=>
	(node ProvideDetails c)
	(= (inited c) false)
)))
;ProvideDetails is Distinct from WaysToOrganizeMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node ProvideDetails c)
	(not (node WaysToOrganizeMeeting c))
)))
;ProvideDetails is Distinct from LetSchedulerScheduleMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node ProvideDetails c)
	(not (node LetSchedulerScheduleMeeting c))
)))
;ProvideDetails is Distinct from OrganizeMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node ProvideDetails c)
	(not (node OrganizeMeeting c))
)))
;ProvideDetails is Distinct from ScheduleMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node ProvideDetails c)
	(not (node ScheduleMeeting c))
)))
;ProvideDetails is Distinct from DetermineMeetingDate
(assert	(forall ((c TaskConcretization)) (=>
	(node ProvideDetails c)
	(not (node DetermineMeetingDate c))
)))
;ProvideDetails is Distinct from ParticipateInMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node ProvideDetails c)
	(not (node ParticipateInMeeting c))
)))
;ProvideDetails is Distinct from AttendMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node ProvideDetails c)
	(not (node AttendMeeting c))
)))
;ProvideDetails is Distinct from DecideConvenientDates
(assert	(forall ((c TaskConcretization)) (=>
	(node ProvideDetails c)
	(not (node DecideConvenientDates c))
)))
;ProvideDetails is Distinct from UseProfiles
(assert	(forall ((c TaskConcretization)) (=>
	(node ProvideDetails c)
	(not (node UseProfiles c))
)))

;AgreeableMeetingDate initial analysis tag
(assert (forall ((c GoalConcretization)) (=>
	(node AgreeableMeetingDate c)
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
;AgreeableMeetingDate Exists
(assert	(exists ((c GoalConcretization)) (node AgreeableMeetingDate c)))
;AgreeableMeetingDate is Unique
(assert	(forall ((c1 GoalConcretization) (c2 GoalConcretization)) (=>
	(and (node AgreeableMeetingDate c1) (node AgreeableMeetingDate c2))
	(= c1 c2)
)))
;AgreeableMeetingDate is Distinct from Dependencies
(assert	(forall ((c GoalConcretization)) (=>
	(node AgreeableMeetingDate c)
	(not (node Dependencies c))
)))
;AgreeableMeetingDate is Distinct from MeetingBeScheduled
(assert	(forall ((c GoalConcretization)) (=>
	(node AgreeableMeetingDate c)
	(not (node MeetingBeScheduled c))
)))
;AgreeableMeetingDate is Distinct from MeetingBeScheduledMI
(assert	(forall ((c GoalConcretization)) (=>
	(node AgreeableMeetingDate c)
	(not (node MeetingBeScheduledMI c))
)))

;ConvenientMeetingDate initial analysis tag
(assert (forall ((c GoalConcretization)) (=>
	(node ConvenientMeetingDate c)
	(= (inited c) false)
)))
;ConvenientMeetingDate is Unique
(assert	(forall ((c1 GoalConcretization) (c2 GoalConcretization)) (=>
	(and (node ConvenientMeetingDate c1) (node ConvenientMeetingDate c2))
	(= c1 c2)
)))
;ConvenientMeetingDate is Distinct from Dependencies
(assert	(forall ((c GoalConcretization)) (=>
	(node ConvenientMeetingDate c)
	(not (node Dependencies c))
)))
;ConvenientMeetingDate is Distinct from MeetingBeScheduled
(assert	(forall ((c GoalConcretization)) (=>
	(node ConvenientMeetingDate c)
	(not (node MeetingBeScheduled c))
)))
;ConvenientMeetingDate is Distinct from MeetingBeScheduledMI
(assert	(forall ((c GoalConcretization)) (=>
	(node ConvenientMeetingDate c)
	(not (node MeetingBeScheduledMI c))
)))

;DecideConvenientDates initial analysis tag
(assert (forall ((c TaskConcretization)) (=>
	(node DecideConvenientDates c)
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
;DecideConvenientDates is Unique
(assert	(forall ((c1 TaskConcretization) (c2 TaskConcretization)) (=>
	(and (node DecideConvenientDates c1) (node DecideConvenientDates c2))
	(= c1 c2)
)))
;DecideConvenientDates is Distinct from WaysToOrganizeMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node DecideConvenientDates c)
	(not (node WaysToOrganizeMeeting c))
)))
;DecideConvenientDates is Distinct from LetSchedulerScheduleMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node DecideConvenientDates c)
	(not (node LetSchedulerScheduleMeeting c))
)))
;DecideConvenientDates is Distinct from OrganizeMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node DecideConvenientDates c)
	(not (node OrganizeMeeting c))
)))
;DecideConvenientDates is Distinct from ScheduleMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node DecideConvenientDates c)
	(not (node ScheduleMeeting c))
)))
;DecideConvenientDates is Distinct from DetermineMeetingDate
(assert	(forall ((c TaskConcretization)) (=>
	(node DecideConvenientDates c)
	(not (node DetermineMeetingDate c))
)))
;DecideConvenientDates is Distinct from ParticipateInMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node DecideConvenientDates c)
	(not (node ParticipateInMeeting c))
)))
;DecideConvenientDates is Distinct from AttendMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node DecideConvenientDates c)
	(not (node AttendMeeting c))
)))
;DecideConvenientDates is Distinct from ProvideDetails
(assert	(forall ((c TaskConcretization)) (=>
	(node DecideConvenientDates c)
	(not (node ProvideDetails c))
)))
;DecideConvenientDates is Distinct from UseProfiles
(assert	(forall ((c TaskConcretization)) (=>
	(node DecideConvenientDates c)
	(not (node UseProfiles c))
)))

;LowEffortMP initial analysis tag
(assert (forall ((c SoftGoalConcretization)) (=>
	(node LowEffortMP c)
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
;LowEffortMP Exists
(assert	(exists ((c SoftGoalConcretization)) (node LowEffortMP c)))
;LowEffortMP is Unique
(assert	(forall ((c1 SoftGoalConcretization) (c2 SoftGoalConcretization)) (=>
	(and (node LowEffortMP c1) (node LowEffortMP c2))
	(= c1 c2)
)))
;LowEffortMP is Distinct from Quick
(assert	(forall ((c SoftGoalConcretization)) (=>
	(node LowEffortMP c)
	(not (node Quick c))
)))
;LowEffortMP is Distinct from LowEffortMI
(assert	(forall ((c SoftGoalConcretization)) (=>
	(node LowEffortMP c)
	(not (node LowEffortMI c))
)))

;UseProfiles initial analysis tag
(assert (forall ((c TaskConcretization)) (=>
	(node UseProfiles c)
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
;UseProfiles is Unique
(assert	(forall ((c1 TaskConcretization) (c2 TaskConcretization)) (=>
	(and (node UseProfiles c1) (node UseProfiles c2))
	(= c1 c2)
)))
;UseProfiles is Distinct from WaysToOrganizeMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node UseProfiles c)
	(not (node WaysToOrganizeMeeting c))
)))
;UseProfiles is Distinct from LetSchedulerScheduleMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node UseProfiles c)
	(not (node LetSchedulerScheduleMeeting c))
)))
;UseProfiles is Distinct from OrganizeMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node UseProfiles c)
	(not (node OrganizeMeeting c))
)))
;UseProfiles is Distinct from ScheduleMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node UseProfiles c)
	(not (node ScheduleMeeting c))
)))
;UseProfiles is Distinct from DetermineMeetingDate
(assert	(forall ((c TaskConcretization)) (=>
	(node UseProfiles c)
	(not (node DetermineMeetingDate c))
)))
;UseProfiles is Distinct from ParticipateInMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node UseProfiles c)
	(not (node ParticipateInMeeting c))
)))
;UseProfiles is Distinct from AttendMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node UseProfiles c)
	(not (node AttendMeeting c))
)))
;UseProfiles is Distinct from ProvideDetails
(assert	(forall ((c TaskConcretization)) (=>
	(node UseProfiles c)
	(not (node ProvideDetails c))
)))
;UseProfiles is Distinct from DecideConvenientDates
(assert	(forall ((c TaskConcretization)) (=>
	(node UseProfiles c)
	(not (node DecideConvenientDates c))
)))

;DetermineMeetingDate initial analysis tag
(assert (forall ((c TaskConcretization)) (=>
	(node DetermineMeetingDate c)
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
;DetermineMeetingDate Exists
(assert	(exists ((c TaskConcretization)) (node DetermineMeetingDate c)))
;DetermineMeetingDate is Unique
(assert	(forall ((c1 TaskConcretization) (c2 TaskConcretization)) (=>
	(and (node DetermineMeetingDate c1) (node DetermineMeetingDate c2))
	(= c1 c2)
)))
;DetermineMeetingDate is Distinct from WaysToOrganizeMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node DetermineMeetingDate c)
	(not (node WaysToOrganizeMeeting c))
)))
;DetermineMeetingDate is Distinct from LetSchedulerScheduleMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node DetermineMeetingDate c)
	(not (node LetSchedulerScheduleMeeting c))
)))
;DetermineMeetingDate is Distinct from OrganizeMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node DetermineMeetingDate c)
	(not (node OrganizeMeeting c))
)))
;DetermineMeetingDate is Distinct from ScheduleMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node DetermineMeetingDate c)
	(not (node ScheduleMeeting c))
)))
;DetermineMeetingDate is Distinct from ParticipateInMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node DetermineMeetingDate c)
	(not (node ParticipateInMeeting c))
)))
;DetermineMeetingDate is Distinct from AttendMeeting
(assert	(forall ((c TaskConcretization)) (=>
	(node DetermineMeetingDate c)
	(not (node AttendMeeting c))
)))
;DetermineMeetingDate is Distinct from ProvideDetails
(assert	(forall ((c TaskConcretization)) (=>
	(node DetermineMeetingDate c)
	(not (node ProvideDetails c))
)))
;DetermineMeetingDate is Distinct from DecideConvenientDates
(assert	(forall ((c TaskConcretization)) (=>
	(node DetermineMeetingDate c)
	(not (node DecideConvenientDates c))
)))
;DetermineMeetingDate is Distinct from UseProfiles
(assert	(forall ((c TaskConcretization)) (=>
	(node DetermineMeetingDate c)
	(not (node UseProfiles c))
)))

;Dependencies initial analysis tag
(assert (forall ((c GoalConcretization)) (=>
	(node Dependencies c)
	(= (inited c) false)
)))
;Dependencies is Distinct from MeetingBeScheduledMI
(assert	(forall ((c GoalConcretization)) (=>
	(node Dependencies c)
	(not (node MeetingBeScheduledMI c))
)))
;Dependencies is Distinct from AgreeableMeetingDate
(assert	(forall ((c GoalConcretization)) (=>
	(node Dependencies c)
	(not (node AgreeableMeetingDate c))
)))
;Dependencies is Distinct from ConvenientMeetingDate
(assert	(forall ((c GoalConcretization)) (=>
	(node Dependencies c)
	(not (node ConvenientMeetingDate c))
)))
;Dependencies is Distinct from MeetingBeScheduled
(assert	(forall ((c GoalConcretization)) (=>
	(node Dependencies c)
	(not (node MeetingBeScheduled c))
)))

;MeetingBeScheduled initial analysis tag
(assert (forall ((c GoalConcretization)) (=>
	(node MeetingBeScheduled c)
	(= (inited c) false)
)))
;MeetingBeScheduled Exists
(assert	(exists ((c GoalConcretization)) (node MeetingBeScheduled c)))
;MeetingBeScheduled is Unique
(assert	(forall ((c1 GoalConcretization) (c2 GoalConcretization)) (=>
	(and (node MeetingBeScheduled c1) (node MeetingBeScheduled c2))
	(= c1 c2)
)))
;MeetingBeScheduled is Distinct from MeetingBeScheduledMI
(assert	(forall ((c GoalConcretization)) (=>
	(node MeetingBeScheduled c)
	(not (node MeetingBeScheduledMI c))
)))
;MeetingBeScheduled is Distinct from AgreeableMeetingDate
(assert	(forall ((c GoalConcretization)) (=>
	(node MeetingBeScheduled c)
	(not (node AgreeableMeetingDate c))
)))
;MeetingBeScheduled is Distinct from ConvenientMeetingDate
(assert	(forall ((c GoalConcretization)) (=>
	(node MeetingBeScheduled c)
	(not (node ConvenientMeetingDate c))
)))
;MeetingBeScheduled is Distinct from Dependencies
(assert	(forall ((c GoalConcretization)) (=>
	(node MeetingBeScheduled c)
	(not (node Dependencies c))
)))

;Details initial analysis tag
(assert (forall ((c ResourceConcretization)) (=>
	(node Details c)
	(= (inited c) false)
)))
;Details Exists
(assert	(exists ((c ResourceConcretization)) (node Details c)))

;MeetingInitiator2MeetingBeScheduledMI tgtEndpoint constant
(assert (forall ((c IntentionConcretization)) (=>
	(edge MeetingInitiator2MeetingBeScheduledMI c)
	(= (tgtEndpoint c) ENDPOINT_GOAL)
)))
;MeetingInitiator2MeetingBeScheduledMI endpoints
(assert (forall ((c IntentionConcretization)) (=>
	(edge MeetingInitiator2MeetingBeScheduledMI c)
	(and
		(node MeetingInitiator (src c))
		(node MeetingBeScheduledMI ((as tgt (GoalConcretization)) c))
	)
)))
;MeetingInitiator2MeetingBeScheduledMI Exists
(assert	(exists ((c IntentionConcretization)) (edge MeetingInitiator2MeetingBeScheduledMI c)))
;MeetingInitiator2MeetingBeScheduledMI is Unique
(assert	(forall ((c1 IntentionConcretization) (c2 IntentionConcretization)) (=>
	(and (edge MeetingInitiator2MeetingBeScheduledMI c1) (edge MeetingInitiator2MeetingBeScheduledMI c2))
	(= c1 c2)
)))
;MeetingInitiator2MeetingBeScheduledMI is Distinct from MeetingParticipant2AgreeableMeetingDate
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingInitiator2MeetingBeScheduledMI c)
	(not (edge MeetingParticipant2AgreeableMeetingDate c))
)))
;MeetingInitiator2MeetingBeScheduledMI is Distinct from MeetingParticipant2ConvenientMeetingDate
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingInitiator2MeetingBeScheduledMI c)
	(not (edge MeetingParticipant2ConvenientMeetingDate c))
)))
;MeetingInitiator2WaysToOrganizeMeeting tgtEndpoint constant
(assert (forall ((c IntentionConcretization)) (=>
	(edge MeetingInitiator2WaysToOrganizeMeeting c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;MeetingInitiator2WaysToOrganizeMeeting endpoints
(assert (forall ((c IntentionConcretization)) (=>
	(edge MeetingInitiator2WaysToOrganizeMeeting c)
	(and
		(node MeetingInitiator (src c))
		(node WaysToOrganizeMeeting ((as tgt (TaskConcretization)) c))
	)
)))
;MeetingInitiator2WaysToOrganizeMeeting Exists
(assert	(exists ((c IntentionConcretization)) (edge MeetingInitiator2WaysToOrganizeMeeting c)))
;MeetingInitiator2WaysToOrganizeMeeting is Distinct from MeetingScheduler2ScheduleMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingInitiator2WaysToOrganizeMeeting c)
	(not (edge MeetingScheduler2ScheduleMeeting c))
)))
;MeetingInitiator2WaysToOrganizeMeeting is Distinct from MeetingParticipant2ParticipateInMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingInitiator2WaysToOrganizeMeeting c)
	(not (edge MeetingParticipant2ParticipateInMeeting c))
)))
;MeetingInitiator2WaysToOrganizeMeeting is Distinct from MeetingParticipant2AttendMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingInitiator2WaysToOrganizeMeeting c)
	(not (edge MeetingParticipant2AttendMeeting c))
)))
;MeetingInitiator2WaysToOrganizeMeeting is Distinct from MeetingParticipant2ProvideDetails
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingInitiator2WaysToOrganizeMeeting c)
	(not (edge MeetingParticipant2ProvideDetails c))
)))
;MeetingInitiator2WaysToOrganizeMeeting is Distinct from MeetingParticipant2DecideConvenientDates
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingInitiator2WaysToOrganizeMeeting c)
	(not (edge MeetingParticipant2DecideConvenientDates c))
)))
;MeetingInitiator2WaysToOrganizeMeeting is Distinct from MeetingParticipant2UseProfiles
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingInitiator2WaysToOrganizeMeeting c)
	(not (edge MeetingParticipant2UseProfiles c))
)))
;MeetingInitiator2WaysToOrganizeMeeting is Distinct from DateDeterminer2DetermineMeetingDate
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingInitiator2WaysToOrganizeMeeting c)
	(not (edge DateDeterminer2DetermineMeetingDate c))
)))
;MeetingInitiator2WaysToOrganizeMeeting is Distinct from MeetingInitiator2LetSchedulerScheduleMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingInitiator2WaysToOrganizeMeeting c)
	(not (edge MeetingInitiator2LetSchedulerScheduleMeeting c))
)))
;MeetingInitiator2WaysToOrganizeMeeting is Distinct from MeetingInitiator2OrganizeMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingInitiator2WaysToOrganizeMeeting c)
	(not (edge MeetingInitiator2OrganizeMeeting c))
)))
;MeetingInitiator2LetSchedulerScheduleMeeting tgtEndpoint constant
(assert (forall ((c IntentionConcretization)) (=>
	(edge MeetingInitiator2LetSchedulerScheduleMeeting c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;MeetingInitiator2LetSchedulerScheduleMeeting endpoints
(assert (forall ((c IntentionConcretization)) (=>
	(edge MeetingInitiator2LetSchedulerScheduleMeeting c)
	(and
		(node MeetingInitiator (src c))
		(node LetSchedulerScheduleMeeting ((as tgt (TaskConcretization)) c))
	)
)))
;MeetingInitiator2LetSchedulerScheduleMeeting Exists
(assert	(exists ((c IntentionConcretization)) (edge MeetingInitiator2LetSchedulerScheduleMeeting c)))
;MeetingInitiator2LetSchedulerScheduleMeeting is Unique
(assert	(forall ((c1 IntentionConcretization) (c2 IntentionConcretization)) (=>
	(and (edge MeetingInitiator2LetSchedulerScheduleMeeting c1) (edge MeetingInitiator2LetSchedulerScheduleMeeting c2))
	(= c1 c2)
)))
;MeetingInitiator2LetSchedulerScheduleMeeting is Distinct from MeetingScheduler2ScheduleMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingInitiator2LetSchedulerScheduleMeeting c)
	(not (edge MeetingScheduler2ScheduleMeeting c))
)))
;MeetingInitiator2LetSchedulerScheduleMeeting is Distinct from MeetingParticipant2ParticipateInMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingInitiator2LetSchedulerScheduleMeeting c)
	(not (edge MeetingParticipant2ParticipateInMeeting c))
)))
;MeetingInitiator2LetSchedulerScheduleMeeting is Distinct from MeetingParticipant2AttendMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingInitiator2LetSchedulerScheduleMeeting c)
	(not (edge MeetingParticipant2AttendMeeting c))
)))
;MeetingInitiator2LetSchedulerScheduleMeeting is Distinct from MeetingParticipant2ProvideDetails
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingInitiator2LetSchedulerScheduleMeeting c)
	(not (edge MeetingParticipant2ProvideDetails c))
)))
;MeetingInitiator2LetSchedulerScheduleMeeting is Distinct from MeetingParticipant2DecideConvenientDates
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingInitiator2LetSchedulerScheduleMeeting c)
	(not (edge MeetingParticipant2DecideConvenientDates c))
)))
;MeetingInitiator2LetSchedulerScheduleMeeting is Distinct from MeetingParticipant2UseProfiles
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingInitiator2LetSchedulerScheduleMeeting c)
	(not (edge MeetingParticipant2UseProfiles c))
)))
;MeetingInitiator2LetSchedulerScheduleMeeting is Distinct from DateDeterminer2DetermineMeetingDate
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingInitiator2LetSchedulerScheduleMeeting c)
	(not (edge DateDeterminer2DetermineMeetingDate c))
)))
;MeetingInitiator2LetSchedulerScheduleMeeting is Distinct from MeetingInitiator2WaysToOrganizeMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingInitiator2LetSchedulerScheduleMeeting c)
	(not (edge MeetingInitiator2WaysToOrganizeMeeting c))
)))
;MeetingInitiator2LetSchedulerScheduleMeeting is Distinct from MeetingInitiator2OrganizeMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingInitiator2LetSchedulerScheduleMeeting c)
	(not (edge MeetingInitiator2OrganizeMeeting c))
)))
;MeetingInitiator2OrganizeMeeting tgtEndpoint constant
(assert (forall ((c IntentionConcretization)) (=>
	(edge MeetingInitiator2OrganizeMeeting c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;MeetingInitiator2OrganizeMeeting endpoints
(assert (forall ((c IntentionConcretization)) (=>
	(edge MeetingInitiator2OrganizeMeeting c)
	(and
		(node MeetingInitiator (src c))
		(node OrganizeMeeting ((as tgt (TaskConcretization)) c))
	)
)))
;MeetingInitiator2OrganizeMeeting Exists
(assert	(exists ((c IntentionConcretization)) (edge MeetingInitiator2OrganizeMeeting c)))
;MeetingInitiator2OrganizeMeeting is Unique
(assert	(forall ((c1 IntentionConcretization) (c2 IntentionConcretization)) (=>
	(and (edge MeetingInitiator2OrganizeMeeting c1) (edge MeetingInitiator2OrganizeMeeting c2))
	(= c1 c2)
)))
;MeetingInitiator2OrganizeMeeting is Distinct from MeetingScheduler2ScheduleMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingInitiator2OrganizeMeeting c)
	(not (edge MeetingScheduler2ScheduleMeeting c))
)))
;MeetingInitiator2OrganizeMeeting is Distinct from MeetingParticipant2ParticipateInMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingInitiator2OrganizeMeeting c)
	(not (edge MeetingParticipant2ParticipateInMeeting c))
)))
;MeetingInitiator2OrganizeMeeting is Distinct from MeetingParticipant2AttendMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingInitiator2OrganizeMeeting c)
	(not (edge MeetingParticipant2AttendMeeting c))
)))
;MeetingInitiator2OrganizeMeeting is Distinct from MeetingParticipant2ProvideDetails
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingInitiator2OrganizeMeeting c)
	(not (edge MeetingParticipant2ProvideDetails c))
)))
;MeetingInitiator2OrganizeMeeting is Distinct from MeetingParticipant2DecideConvenientDates
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingInitiator2OrganizeMeeting c)
	(not (edge MeetingParticipant2DecideConvenientDates c))
)))
;MeetingInitiator2OrganizeMeeting is Distinct from MeetingParticipant2UseProfiles
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingInitiator2OrganizeMeeting c)
	(not (edge MeetingParticipant2UseProfiles c))
)))
;MeetingInitiator2OrganizeMeeting is Distinct from DateDeterminer2DetermineMeetingDate
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingInitiator2OrganizeMeeting c)
	(not (edge DateDeterminer2DetermineMeetingDate c))
)))
;MeetingInitiator2OrganizeMeeting is Distinct from MeetingInitiator2WaysToOrganizeMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingInitiator2OrganizeMeeting c)
	(not (edge MeetingInitiator2WaysToOrganizeMeeting c))
)))
;MeetingInitiator2OrganizeMeeting is Distinct from MeetingInitiator2LetSchedulerScheduleMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingInitiator2OrganizeMeeting c)
	(not (edge MeetingInitiator2LetSchedulerScheduleMeeting c))
)))
;MeetingInitiator2Quick tgtEndpoint constant
(assert (forall ((c IntentionConcretization)) (=>
	(edge MeetingInitiator2Quick c)
	(= (tgtEndpoint c) ENDPOINT_SOFTGOAL)
)))
;MeetingInitiator2Quick endpoints
(assert (forall ((c IntentionConcretization)) (=>
	(edge MeetingInitiator2Quick c)
	(and
		(node MeetingInitiator (src c))
		(node Quick ((as tgt (SoftGoalConcretization)) c))
	)
)))
;MeetingInitiator2Quick Exists
(assert	(exists ((c IntentionConcretization)) (edge MeetingInitiator2Quick c)))
;MeetingInitiator2Quick is Unique
(assert	(forall ((c1 IntentionConcretization) (c2 IntentionConcretization)) (=>
	(and (edge MeetingInitiator2Quick c1) (edge MeetingInitiator2Quick c2))
	(= c1 c2)
)))
;MeetingInitiator2Quick is Distinct from MeetingParticipant2LowEffortMP
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingInitiator2Quick c)
	(not (edge MeetingParticipant2LowEffortMP c))
)))
;MeetingInitiator2Quick is Distinct from MeetingInitiator2LowEffortMI
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingInitiator2Quick c)
	(not (edge MeetingInitiator2LowEffortMI c))
)))
;MeetingInitiator2LowEffortMI tgtEndpoint constant
(assert (forall ((c IntentionConcretization)) (=>
	(edge MeetingInitiator2LowEffortMI c)
	(= (tgtEndpoint c) ENDPOINT_SOFTGOAL)
)))
;MeetingInitiator2LowEffortMI endpoints
(assert (forall ((c IntentionConcretization)) (=>
	(edge MeetingInitiator2LowEffortMI c)
	(and
		(node MeetingInitiator (src c))
		(node LowEffortMI ((as tgt (SoftGoalConcretization)) c))
	)
)))
;MeetingInitiator2LowEffortMI Exists
(assert	(exists ((c IntentionConcretization)) (edge MeetingInitiator2LowEffortMI c)))
;MeetingInitiator2LowEffortMI is Unique
(assert	(forall ((c1 IntentionConcretization) (c2 IntentionConcretization)) (=>
	(and (edge MeetingInitiator2LowEffortMI c1) (edge MeetingInitiator2LowEffortMI c2))
	(= c1 c2)
)))
;MeetingInitiator2LowEffortMI is Distinct from MeetingParticipant2LowEffortMP
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingInitiator2LowEffortMI c)
	(not (edge MeetingParticipant2LowEffortMP c))
)))
;MeetingInitiator2LowEffortMI is Distinct from MeetingInitiator2Quick
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingInitiator2LowEffortMI c)
	(not (edge MeetingInitiator2Quick c))
)))
;MeetingScheduler2ScheduleMeeting tgtEndpoint constant
(assert (forall ((c IntentionConcretization)) (=>
	(edge MeetingScheduler2ScheduleMeeting c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;MeetingScheduler2ScheduleMeeting endpoints
(assert (forall ((c IntentionConcretization)) (=>
	(edge MeetingScheduler2ScheduleMeeting c)
	(and
		(node MeetingScheduler (src c))
		(node ScheduleMeeting ((as tgt (TaskConcretization)) c))
	)
)))
;MeetingScheduler2ScheduleMeeting Exists
(assert	(exists ((c IntentionConcretization)) (edge MeetingScheduler2ScheduleMeeting c)))
;MeetingScheduler2ScheduleMeeting is Unique
(assert	(forall ((c1 IntentionConcretization) (c2 IntentionConcretization)) (=>
	(and (edge MeetingScheduler2ScheduleMeeting c1) (edge MeetingScheduler2ScheduleMeeting c2))
	(= c1 c2)
)))
;MeetingScheduler2ScheduleMeeting is Distinct from MeetingInitiator2WaysToOrganizeMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingScheduler2ScheduleMeeting c)
	(not (edge MeetingInitiator2WaysToOrganizeMeeting c))
)))
;MeetingScheduler2ScheduleMeeting is Distinct from MeetingInitiator2LetSchedulerScheduleMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingScheduler2ScheduleMeeting c)
	(not (edge MeetingInitiator2LetSchedulerScheduleMeeting c))
)))
;MeetingScheduler2ScheduleMeeting is Distinct from MeetingInitiator2OrganizeMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingScheduler2ScheduleMeeting c)
	(not (edge MeetingInitiator2OrganizeMeeting c))
)))
;MeetingScheduler2ScheduleMeeting is Distinct from MeetingParticipant2ParticipateInMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingScheduler2ScheduleMeeting c)
	(not (edge MeetingParticipant2ParticipateInMeeting c))
)))
;MeetingScheduler2ScheduleMeeting is Distinct from MeetingParticipant2AttendMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingScheduler2ScheduleMeeting c)
	(not (edge MeetingParticipant2AttendMeeting c))
)))
;MeetingScheduler2ScheduleMeeting is Distinct from MeetingParticipant2ProvideDetails
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingScheduler2ScheduleMeeting c)
	(not (edge MeetingParticipant2ProvideDetails c))
)))
;MeetingScheduler2ScheduleMeeting is Distinct from MeetingParticipant2DecideConvenientDates
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingScheduler2ScheduleMeeting c)
	(not (edge MeetingParticipant2DecideConvenientDates c))
)))
;MeetingScheduler2ScheduleMeeting is Distinct from MeetingParticipant2UseProfiles
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingScheduler2ScheduleMeeting c)
	(not (edge MeetingParticipant2UseProfiles c))
)))
;MeetingScheduler2ScheduleMeeting is Distinct from DateDeterminer2DetermineMeetingDate
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingScheduler2ScheduleMeeting c)
	(not (edge DateDeterminer2DetermineMeetingDate c))
)))
;MeetingParticipant2ParticipateInMeeting tgtEndpoint constant
(assert (forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2ParticipateInMeeting c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;MeetingParticipant2ParticipateInMeeting endpoints
(assert (forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2ParticipateInMeeting c)
	(and
		(node MeetingParticipant (src c))
		(node ParticipateInMeeting ((as tgt (TaskConcretization)) c))
	)
)))
;MeetingParticipant2ParticipateInMeeting Exists
(assert	(exists ((c IntentionConcretization)) (edge MeetingParticipant2ParticipateInMeeting c)))
;MeetingParticipant2ParticipateInMeeting is Unique
(assert	(forall ((c1 IntentionConcretization) (c2 IntentionConcretization)) (=>
	(and (edge MeetingParticipant2ParticipateInMeeting c1) (edge MeetingParticipant2ParticipateInMeeting c2))
	(= c1 c2)
)))
;MeetingParticipant2ParticipateInMeeting is Distinct from MeetingInitiator2WaysToOrganizeMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2ParticipateInMeeting c)
	(not (edge MeetingInitiator2WaysToOrganizeMeeting c))
)))
;MeetingParticipant2ParticipateInMeeting is Distinct from MeetingInitiator2LetSchedulerScheduleMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2ParticipateInMeeting c)
	(not (edge MeetingInitiator2LetSchedulerScheduleMeeting c))
)))
;MeetingParticipant2ParticipateInMeeting is Distinct from MeetingInitiator2OrganizeMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2ParticipateInMeeting c)
	(not (edge MeetingInitiator2OrganizeMeeting c))
)))
;MeetingParticipant2ParticipateInMeeting is Distinct from MeetingScheduler2ScheduleMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2ParticipateInMeeting c)
	(not (edge MeetingScheduler2ScheduleMeeting c))
)))
;MeetingParticipant2ParticipateInMeeting is Distinct from DateDeterminer2DetermineMeetingDate
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2ParticipateInMeeting c)
	(not (edge DateDeterminer2DetermineMeetingDate c))
)))
;MeetingParticipant2ParticipateInMeeting is Distinct from MeetingParticipant2AttendMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2ParticipateInMeeting c)
	(not (edge MeetingParticipant2AttendMeeting c))
)))
;MeetingParticipant2ParticipateInMeeting is Distinct from MeetingParticipant2ProvideDetails
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2ParticipateInMeeting c)
	(not (edge MeetingParticipant2ProvideDetails c))
)))
;MeetingParticipant2ParticipateInMeeting is Distinct from MeetingParticipant2DecideConvenientDates
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2ParticipateInMeeting c)
	(not (edge MeetingParticipant2DecideConvenientDates c))
)))
;MeetingParticipant2ParticipateInMeeting is Distinct from MeetingParticipant2UseProfiles
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2ParticipateInMeeting c)
	(not (edge MeetingParticipant2UseProfiles c))
)))
;MeetingParticipant2AttendMeeting tgtEndpoint constant
(assert (forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2AttendMeeting c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;MeetingParticipant2AttendMeeting endpoints
(assert (forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2AttendMeeting c)
	(and
		(node MeetingParticipant (src c))
		(node AttendMeeting ((as tgt (TaskConcretization)) c))
	)
)))
;MeetingParticipant2AttendMeeting Exists
(assert	(exists ((c IntentionConcretization)) (edge MeetingParticipant2AttendMeeting c)))
;MeetingParticipant2AttendMeeting is Unique
(assert	(forall ((c1 IntentionConcretization) (c2 IntentionConcretization)) (=>
	(and (edge MeetingParticipant2AttendMeeting c1) (edge MeetingParticipant2AttendMeeting c2))
	(= c1 c2)
)))
;MeetingParticipant2AttendMeeting is Distinct from MeetingInitiator2WaysToOrganizeMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2AttendMeeting c)
	(not (edge MeetingInitiator2WaysToOrganizeMeeting c))
)))
;MeetingParticipant2AttendMeeting is Distinct from MeetingInitiator2LetSchedulerScheduleMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2AttendMeeting c)
	(not (edge MeetingInitiator2LetSchedulerScheduleMeeting c))
)))
;MeetingParticipant2AttendMeeting is Distinct from MeetingInitiator2OrganizeMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2AttendMeeting c)
	(not (edge MeetingInitiator2OrganizeMeeting c))
)))
;MeetingParticipant2AttendMeeting is Distinct from MeetingScheduler2ScheduleMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2AttendMeeting c)
	(not (edge MeetingScheduler2ScheduleMeeting c))
)))
;MeetingParticipant2AttendMeeting is Distinct from DateDeterminer2DetermineMeetingDate
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2AttendMeeting c)
	(not (edge DateDeterminer2DetermineMeetingDate c))
)))
;MeetingParticipant2AttendMeeting is Distinct from MeetingParticipant2ParticipateInMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2AttendMeeting c)
	(not (edge MeetingParticipant2ParticipateInMeeting c))
)))
;MeetingParticipant2AttendMeeting is Distinct from MeetingParticipant2ProvideDetails
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2AttendMeeting c)
	(not (edge MeetingParticipant2ProvideDetails c))
)))
;MeetingParticipant2AttendMeeting is Distinct from MeetingParticipant2DecideConvenientDates
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2AttendMeeting c)
	(not (edge MeetingParticipant2DecideConvenientDates c))
)))
;MeetingParticipant2AttendMeeting is Distinct from MeetingParticipant2UseProfiles
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2AttendMeeting c)
	(not (edge MeetingParticipant2UseProfiles c))
)))
;MeetingParticipant2ProvideDetails tgtEndpoint constant
(assert (forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2ProvideDetails c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;MeetingParticipant2ProvideDetails endpoints
(assert (forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2ProvideDetails c)
	(and
		(node MeetingParticipant (src c))
		(node ProvideDetails ((as tgt (TaskConcretization)) c))
	)
)))
;MeetingParticipant2ProvideDetails is Distinct from MeetingInitiator2WaysToOrganizeMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2ProvideDetails c)
	(not (edge MeetingInitiator2WaysToOrganizeMeeting c))
)))
;MeetingParticipant2ProvideDetails is Distinct from MeetingInitiator2LetSchedulerScheduleMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2ProvideDetails c)
	(not (edge MeetingInitiator2LetSchedulerScheduleMeeting c))
)))
;MeetingParticipant2ProvideDetails is Distinct from MeetingInitiator2OrganizeMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2ProvideDetails c)
	(not (edge MeetingInitiator2OrganizeMeeting c))
)))
;MeetingParticipant2ProvideDetails is Distinct from MeetingScheduler2ScheduleMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2ProvideDetails c)
	(not (edge MeetingScheduler2ScheduleMeeting c))
)))
;MeetingParticipant2ProvideDetails is Distinct from DateDeterminer2DetermineMeetingDate
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2ProvideDetails c)
	(not (edge DateDeterminer2DetermineMeetingDate c))
)))
;MeetingParticipant2ProvideDetails is Distinct from MeetingParticipant2ParticipateInMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2ProvideDetails c)
	(not (edge MeetingParticipant2ParticipateInMeeting c))
)))
;MeetingParticipant2ProvideDetails is Distinct from MeetingParticipant2AttendMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2ProvideDetails c)
	(not (edge MeetingParticipant2AttendMeeting c))
)))
;MeetingParticipant2ProvideDetails is Distinct from MeetingParticipant2DecideConvenientDates
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2ProvideDetails c)
	(not (edge MeetingParticipant2DecideConvenientDates c))
)))
;MeetingParticipant2ProvideDetails is Distinct from MeetingParticipant2UseProfiles
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2ProvideDetails c)
	(not (edge MeetingParticipant2UseProfiles c))
)))
;MeetingParticipant2AgreeableMeetingDate tgtEndpoint constant
(assert (forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2AgreeableMeetingDate c)
	(= (tgtEndpoint c) ENDPOINT_GOAL)
)))
;MeetingParticipant2AgreeableMeetingDate endpoints
(assert (forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2AgreeableMeetingDate c)
	(and
		(node MeetingParticipant (src c))
		(node AgreeableMeetingDate ((as tgt (GoalConcretization)) c))
	)
)))
;MeetingParticipant2AgreeableMeetingDate Exists
(assert	(exists ((c IntentionConcretization)) (edge MeetingParticipant2AgreeableMeetingDate c)))
;MeetingParticipant2AgreeableMeetingDate is Unique
(assert	(forall ((c1 IntentionConcretization) (c2 IntentionConcretization)) (=>
	(and (edge MeetingParticipant2AgreeableMeetingDate c1) (edge MeetingParticipant2AgreeableMeetingDate c2))
	(= c1 c2)
)))
;MeetingParticipant2AgreeableMeetingDate is Distinct from MeetingInitiator2MeetingBeScheduledMI
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2AgreeableMeetingDate c)
	(not (edge MeetingInitiator2MeetingBeScheduledMI c))
)))
;MeetingParticipant2ConvenientMeetingDate tgtEndpoint constant
(assert (forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2ConvenientMeetingDate c)
	(= (tgtEndpoint c) ENDPOINT_GOAL)
)))
;MeetingParticipant2ConvenientMeetingDate endpoints
(assert (forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2ConvenientMeetingDate c)
	(and
		(node MeetingParticipant (src c))
		(node ConvenientMeetingDate ((as tgt (GoalConcretization)) c))
	)
)))
;MeetingParticipant2ConvenientMeetingDate is Unique
(assert	(forall ((c1 IntentionConcretization) (c2 IntentionConcretization)) (=>
	(and (edge MeetingParticipant2ConvenientMeetingDate c1) (edge MeetingParticipant2ConvenientMeetingDate c2))
	(= c1 c2)
)))
;MeetingParticipant2ConvenientMeetingDate is Distinct from MeetingInitiator2MeetingBeScheduledMI
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2ConvenientMeetingDate c)
	(not (edge MeetingInitiator2MeetingBeScheduledMI c))
)))
;MeetingParticipant2DecideConvenientDates tgtEndpoint constant
(assert (forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2DecideConvenientDates c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;MeetingParticipant2DecideConvenientDates endpoints
(assert (forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2DecideConvenientDates c)
	(and
		(node MeetingParticipant (src c))
		(node DecideConvenientDates ((as tgt (TaskConcretization)) c))
	)
)))
;MeetingParticipant2DecideConvenientDates is Unique
(assert	(forall ((c1 IntentionConcretization) (c2 IntentionConcretization)) (=>
	(and (edge MeetingParticipant2DecideConvenientDates c1) (edge MeetingParticipant2DecideConvenientDates c2))
	(= c1 c2)
)))
;MeetingParticipant2DecideConvenientDates is Distinct from MeetingInitiator2WaysToOrganizeMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2DecideConvenientDates c)
	(not (edge MeetingInitiator2WaysToOrganizeMeeting c))
)))
;MeetingParticipant2DecideConvenientDates is Distinct from MeetingInitiator2LetSchedulerScheduleMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2DecideConvenientDates c)
	(not (edge MeetingInitiator2LetSchedulerScheduleMeeting c))
)))
;MeetingParticipant2DecideConvenientDates is Distinct from MeetingInitiator2OrganizeMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2DecideConvenientDates c)
	(not (edge MeetingInitiator2OrganizeMeeting c))
)))
;MeetingParticipant2DecideConvenientDates is Distinct from MeetingScheduler2ScheduleMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2DecideConvenientDates c)
	(not (edge MeetingScheduler2ScheduleMeeting c))
)))
;MeetingParticipant2DecideConvenientDates is Distinct from DateDeterminer2DetermineMeetingDate
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2DecideConvenientDates c)
	(not (edge DateDeterminer2DetermineMeetingDate c))
)))
;MeetingParticipant2DecideConvenientDates is Distinct from MeetingParticipant2ParticipateInMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2DecideConvenientDates c)
	(not (edge MeetingParticipant2ParticipateInMeeting c))
)))
;MeetingParticipant2DecideConvenientDates is Distinct from MeetingParticipant2AttendMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2DecideConvenientDates c)
	(not (edge MeetingParticipant2AttendMeeting c))
)))
;MeetingParticipant2DecideConvenientDates is Distinct from MeetingParticipant2ProvideDetails
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2DecideConvenientDates c)
	(not (edge MeetingParticipant2ProvideDetails c))
)))
;MeetingParticipant2DecideConvenientDates is Distinct from MeetingParticipant2UseProfiles
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2DecideConvenientDates c)
	(not (edge MeetingParticipant2UseProfiles c))
)))
;MeetingParticipant2LowEffortMP tgtEndpoint constant
(assert (forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2LowEffortMP c)
	(= (tgtEndpoint c) ENDPOINT_SOFTGOAL)
)))
;MeetingParticipant2LowEffortMP endpoints
(assert (forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2LowEffortMP c)
	(and
		(node MeetingParticipant (src c))
		(node LowEffortMP ((as tgt (SoftGoalConcretization)) c))
	)
)))
;MeetingParticipant2LowEffortMP Exists
(assert	(exists ((c IntentionConcretization)) (edge MeetingParticipant2LowEffortMP c)))
;MeetingParticipant2LowEffortMP is Unique
(assert	(forall ((c1 IntentionConcretization) (c2 IntentionConcretization)) (=>
	(and (edge MeetingParticipant2LowEffortMP c1) (edge MeetingParticipant2LowEffortMP c2))
	(= c1 c2)
)))
;MeetingParticipant2LowEffortMP is Distinct from MeetingInitiator2Quick
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2LowEffortMP c)
	(not (edge MeetingInitiator2Quick c))
)))
;MeetingParticipant2LowEffortMP is Distinct from MeetingInitiator2LowEffortMI
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2LowEffortMP c)
	(not (edge MeetingInitiator2LowEffortMI c))
)))
;MeetingParticipant2UseProfiles tgtEndpoint constant
(assert (forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2UseProfiles c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;MeetingParticipant2UseProfiles endpoints
(assert (forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2UseProfiles c)
	(and
		(node MeetingParticipant (src c))
		(node UseProfiles ((as tgt (TaskConcretization)) c))
	)
)))
;MeetingParticipant2UseProfiles is Unique
(assert	(forall ((c1 IntentionConcretization) (c2 IntentionConcretization)) (=>
	(and (edge MeetingParticipant2UseProfiles c1) (edge MeetingParticipant2UseProfiles c2))
	(= c1 c2)
)))
;MeetingParticipant2UseProfiles is Distinct from MeetingInitiator2WaysToOrganizeMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2UseProfiles c)
	(not (edge MeetingInitiator2WaysToOrganizeMeeting c))
)))
;MeetingParticipant2UseProfiles is Distinct from MeetingInitiator2LetSchedulerScheduleMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2UseProfiles c)
	(not (edge MeetingInitiator2LetSchedulerScheduleMeeting c))
)))
;MeetingParticipant2UseProfiles is Distinct from MeetingInitiator2OrganizeMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2UseProfiles c)
	(not (edge MeetingInitiator2OrganizeMeeting c))
)))
;MeetingParticipant2UseProfiles is Distinct from MeetingScheduler2ScheduleMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2UseProfiles c)
	(not (edge MeetingScheduler2ScheduleMeeting c))
)))
;MeetingParticipant2UseProfiles is Distinct from DateDeterminer2DetermineMeetingDate
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2UseProfiles c)
	(not (edge DateDeterminer2DetermineMeetingDate c))
)))
;MeetingParticipant2UseProfiles is Distinct from MeetingParticipant2ParticipateInMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2UseProfiles c)
	(not (edge MeetingParticipant2ParticipateInMeeting c))
)))
;MeetingParticipant2UseProfiles is Distinct from MeetingParticipant2AttendMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2UseProfiles c)
	(not (edge MeetingParticipant2AttendMeeting c))
)))
;MeetingParticipant2UseProfiles is Distinct from MeetingParticipant2ProvideDetails
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2UseProfiles c)
	(not (edge MeetingParticipant2ProvideDetails c))
)))
;MeetingParticipant2UseProfiles is Distinct from MeetingParticipant2DecideConvenientDates
(assert	(forall ((c IntentionConcretization)) (=>
	(edge MeetingParticipant2UseProfiles c)
	(not (edge MeetingParticipant2DecideConvenientDates c))
)))
;DateDeterminer2DetermineMeetingDate tgtEndpoint constant
(assert (forall ((c IntentionConcretization)) (=>
	(edge DateDeterminer2DetermineMeetingDate c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;DateDeterminer2DetermineMeetingDate endpoints
(assert (forall ((c IntentionConcretization)) (=>
	(edge DateDeterminer2DetermineMeetingDate c)
	(and
		(node DateDeterminer (src c))
		(node DetermineMeetingDate ((as tgt (TaskConcretization)) c))
	)
)))
;DateDeterminer2DetermineMeetingDate Exists
(assert	(exists ((c IntentionConcretization)) (edge DateDeterminer2DetermineMeetingDate c)))
;DateDeterminer2DetermineMeetingDate is Unique
(assert	(forall ((c1 IntentionConcretization) (c2 IntentionConcretization)) (=>
	(and (edge DateDeterminer2DetermineMeetingDate c1) (edge DateDeterminer2DetermineMeetingDate c2))
	(= c1 c2)
)))
;DateDeterminer2DetermineMeetingDate is Distinct from MeetingInitiator2WaysToOrganizeMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge DateDeterminer2DetermineMeetingDate c)
	(not (edge MeetingInitiator2WaysToOrganizeMeeting c))
)))
;DateDeterminer2DetermineMeetingDate is Distinct from MeetingInitiator2LetSchedulerScheduleMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge DateDeterminer2DetermineMeetingDate c)
	(not (edge MeetingInitiator2LetSchedulerScheduleMeeting c))
)))
;DateDeterminer2DetermineMeetingDate is Distinct from MeetingInitiator2OrganizeMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge DateDeterminer2DetermineMeetingDate c)
	(not (edge MeetingInitiator2OrganizeMeeting c))
)))
;DateDeterminer2DetermineMeetingDate is Distinct from MeetingScheduler2ScheduleMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge DateDeterminer2DetermineMeetingDate c)
	(not (edge MeetingScheduler2ScheduleMeeting c))
)))
;DateDeterminer2DetermineMeetingDate is Distinct from MeetingParticipant2ParticipateInMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge DateDeterminer2DetermineMeetingDate c)
	(not (edge MeetingParticipant2ParticipateInMeeting c))
)))
;DateDeterminer2DetermineMeetingDate is Distinct from MeetingParticipant2AttendMeeting
(assert	(forall ((c IntentionConcretization)) (=>
	(edge DateDeterminer2DetermineMeetingDate c)
	(not (edge MeetingParticipant2AttendMeeting c))
)))
;DateDeterminer2DetermineMeetingDate is Distinct from MeetingParticipant2ProvideDetails
(assert	(forall ((c IntentionConcretization)) (=>
	(edge DateDeterminer2DetermineMeetingDate c)
	(not (edge MeetingParticipant2ProvideDetails c))
)))
;DateDeterminer2DetermineMeetingDate is Distinct from MeetingParticipant2DecideConvenientDates
(assert	(forall ((c IntentionConcretization)) (=>
	(edge DateDeterminer2DetermineMeetingDate c)
	(not (edge MeetingParticipant2DecideConvenientDates c))
)))
;DateDeterminer2DetermineMeetingDate is Distinct from MeetingParticipant2UseProfiles
(assert	(forall ((c IntentionConcretization)) (=>
	(edge DateDeterminer2DetermineMeetingDate c)
	(not (edge MeetingParticipant2UseProfiles c))
)))
;MeetingBeScheduledMI2OrganizeMeeting Exists
(assert	(exists ((c DecompositionConcretization)) (edge MeetingBeScheduledMI2OrganizeMeeting c)))
;MeetingBeScheduledMI2OrganizeMeeting is Unique
(assert	(forall ((c1 DecompositionConcretization) (c2 DecompositionConcretization)) (=>
	(and (edge MeetingBeScheduledMI2OrganizeMeeting c1) (edge MeetingBeScheduledMI2OrganizeMeeting c2))
	(= c1 c2)
)))
;MeetingBeScheduledMI2OrganizeMeeting is Distinct from AttendMeeting2ParticipateInMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge MeetingBeScheduledMI2OrganizeMeeting c)
	(not (edge AttendMeeting2ParticipateInMeeting c))
)))
;MeetingBeScheduledMI2OrganizeMeeting is Distinct from ProvideDetails2ParticipateInMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge MeetingBeScheduledMI2OrganizeMeeting c)
	(not (edge ProvideDetails2ParticipateInMeeting c))
)))
;MeetingBeScheduledMI2OrganizeMeeting is Distinct from AgreeableMeetingDate2ParticipateInMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge MeetingBeScheduledMI2OrganizeMeeting c)
	(not (edge AgreeableMeetingDate2ParticipateInMeeting c))
)))
;MeetingBeScheduledMI2OrganizeMeeting is Distinct from ConvenientMeetingDate2ParticipateInMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge MeetingBeScheduledMI2OrganizeMeeting c)
	(not (edge ConvenientMeetingDate2ParticipateInMeeting c))
)))
;MeetingBeScheduledMI2OrganizeMeeting is Distinct from LowEffortMP2ProvideDetails
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge MeetingBeScheduledMI2OrganizeMeeting c)
	(not (edge LowEffortMP2ProvideDetails c))
)))
;MeetingBeScheduledMI2OrganizeMeeting is Distinct from UseProfiles2ParticipateInMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge MeetingBeScheduledMI2OrganizeMeeting c)
	(not (edge UseProfiles2ParticipateInMeeting c))
)))
;MeetingBeScheduledMI2OrganizeMeeting is Distinct from Quick2OrganizeMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge MeetingBeScheduledMI2OrganizeMeeting c)
	(not (edge Quick2OrganizeMeeting c))
)))
;MeetingBeScheduledMI2OrganizeMeeting is Distinct from LowEffortMI2OrganizeMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge MeetingBeScheduledMI2OrganizeMeeting c)
	(not (edge LowEffortMI2OrganizeMeeting c))
)))

;MeetingBeScheduledMI2OrganizeMeeting endpoints
(assert (forall ((c DecompositionConcretization)) (=>
	(edge MeetingBeScheduledMI2OrganizeMeeting c)
	(and
		(node MeetingBeScheduledMI ((as src (GoalConcretization)) c))
		(node OrganizeMeeting (tgt c))
	)
)))
;MeetingBeScheduledMI2OrganizeMeeting srcEndpoint constant
(assert (forall ((c DecompositionConcretization)) (=>
	(edge MeetingBeScheduledMI2OrganizeMeeting c)
	(= (srcEndpoint c) ENDPOINT_GOAL)
)))

;WaysToOrganizeMeeting2MeetingBeScheduledMI Exists
(assert	(exists ((c MeansEndConcretization)) (edge WaysToOrganizeMeeting2MeetingBeScheduledMI c)))
;WaysToOrganizeMeeting2MeetingBeScheduledMI is Distinct from DecideConvenientDates2ConvenientMeetingDate
(assert	(forall ((c MeansEndConcretization)) (=>
	(edge WaysToOrganizeMeeting2MeetingBeScheduledMI c)
	(not (edge DecideConvenientDates2ConvenientMeetingDate c))
)))
;WaysToOrganizeMeeting2MeetingBeScheduledMI is Distinct from LetSchedulerScheduleMeeting2MeetingBeScheduledMI
(assert	(forall ((c MeansEndConcretization)) (=>
	(edge WaysToOrganizeMeeting2MeetingBeScheduledMI c)
	(not (edge LetSchedulerScheduleMeeting2MeetingBeScheduledMI c))
)))

;WaysToOrganizeMeeting2MeetingBeScheduledMI endpoints
(assert (forall ((c MeansEndConcretization)) (=>
	(edge WaysToOrganizeMeeting2MeetingBeScheduledMI c)
	(and
		(node WaysToOrganizeMeeting (src c))
		(node MeetingBeScheduledMI (tgt c))
	)
)))

;WaysToOrganizeMeeting2Quick Exists
(assert	(exists ((c ContributionConcretization)) (edge WaysToOrganizeMeeting2Quick c)))
;WaysToOrganizeMeeting2Quick is Distinct from WaysToOrganizeMeeting2LowEffortMI
(assert	(forall ((c ContributionConcretization)) (=>
	(edge WaysToOrganizeMeeting2Quick c)
	(not (edge WaysToOrganizeMeeting2LowEffortMI c))
)))
;WaysToOrganizeMeeting2Quick is Distinct from LetSchedulerScheduleMeeting2Quick
(assert	(forall ((c ContributionConcretization)) (=>
	(edge WaysToOrganizeMeeting2Quick c)
	(not (edge LetSchedulerScheduleMeeting2Quick c))
)))
;WaysToOrganizeMeeting2Quick is Distinct from LetSchedulerScheduleMeeting2LowEffortMI
(assert	(forall ((c ContributionConcretization)) (=>
	(edge WaysToOrganizeMeeting2Quick c)
	(not (edge LetSchedulerScheduleMeeting2LowEffortMI c))
)))

;WaysToOrganizeMeeting2Quick endpoints
(assert (forall ((c ContributionConcretization)) (=>
	(edge WaysToOrganizeMeeting2Quick c)
	(and
		(node WaysToOrganizeMeeting ((as src (TaskConcretization)) c))
		(node Quick (tgt c))
	)
)))
;WaysToOrganizeMeeting2Quick srcEndpoint constant
(assert (forall ((c ContributionConcretization)) (=>
	(edge WaysToOrganizeMeeting2Quick c)
	(= (srcEndpoint c) ENDPOINT_TASK)
)))

;WaysToOrganizeMeeting2Quick type constant
(assert (forall ((c ContributionConcretization)) (=>
	(edge WaysToOrganizeMeeting2Quick c)
	(= (type c) CONTRIBUTION_UNKNOWN)
)))
;WaysToOrganizeMeeting2LowEffortMI Exists
(assert	(exists ((c ContributionConcretization)) (edge WaysToOrganizeMeeting2LowEffortMI c)))
;WaysToOrganizeMeeting2LowEffortMI is Distinct from WaysToOrganizeMeeting2Quick
(assert	(forall ((c ContributionConcretization)) (=>
	(edge WaysToOrganizeMeeting2LowEffortMI c)
	(not (edge WaysToOrganizeMeeting2Quick c))
)))
;WaysToOrganizeMeeting2LowEffortMI is Distinct from LetSchedulerScheduleMeeting2Quick
(assert	(forall ((c ContributionConcretization)) (=>
	(edge WaysToOrganizeMeeting2LowEffortMI c)
	(not (edge LetSchedulerScheduleMeeting2Quick c))
)))
;WaysToOrganizeMeeting2LowEffortMI is Distinct from LetSchedulerScheduleMeeting2LowEffortMI
(assert	(forall ((c ContributionConcretization)) (=>
	(edge WaysToOrganizeMeeting2LowEffortMI c)
	(not (edge LetSchedulerScheduleMeeting2LowEffortMI c))
)))

;WaysToOrganizeMeeting2LowEffortMI endpoints
(assert (forall ((c ContributionConcretization)) (=>
	(edge WaysToOrganizeMeeting2LowEffortMI c)
	(and
		(node WaysToOrganizeMeeting ((as src (TaskConcretization)) c))
		(node LowEffortMI (tgt c))
	)
)))
;WaysToOrganizeMeeting2LowEffortMI srcEndpoint constant
(assert (forall ((c ContributionConcretization)) (=>
	(edge WaysToOrganizeMeeting2LowEffortMI c)
	(= (srcEndpoint c) ENDPOINT_TASK)
)))

;WaysToOrganizeMeeting2LowEffortMI type constant
(assert (forall ((c ContributionConcretization)) (=>
	(edge WaysToOrganizeMeeting2LowEffortMI c)
	(= (type c) CONTRIBUTION_UNKNOWN)
)))
;LetSchedulerScheduleMeeting2MeetingBeScheduledMI Exists
(assert	(exists ((c MeansEndConcretization)) (edge LetSchedulerScheduleMeeting2MeetingBeScheduledMI c)))
;LetSchedulerScheduleMeeting2MeetingBeScheduledMI is Unique
(assert	(forall ((c1 MeansEndConcretization) (c2 MeansEndConcretization)) (=>
	(and (edge LetSchedulerScheduleMeeting2MeetingBeScheduledMI c1) (edge LetSchedulerScheduleMeeting2MeetingBeScheduledMI c2))
	(= c1 c2)
)))
;LetSchedulerScheduleMeeting2MeetingBeScheduledMI is Distinct from DecideConvenientDates2ConvenientMeetingDate
(assert	(forall ((c MeansEndConcretization)) (=>
	(edge LetSchedulerScheduleMeeting2MeetingBeScheduledMI c)
	(not (edge DecideConvenientDates2ConvenientMeetingDate c))
)))
;LetSchedulerScheduleMeeting2MeetingBeScheduledMI is Distinct from WaysToOrganizeMeeting2MeetingBeScheduledMI
(assert	(forall ((c MeansEndConcretization)) (=>
	(edge LetSchedulerScheduleMeeting2MeetingBeScheduledMI c)
	(not (edge WaysToOrganizeMeeting2MeetingBeScheduledMI c))
)))

;LetSchedulerScheduleMeeting2MeetingBeScheduledMI endpoints
(assert (forall ((c MeansEndConcretization)) (=>
	(edge LetSchedulerScheduleMeeting2MeetingBeScheduledMI c)
	(and
		(node LetSchedulerScheduleMeeting (src c))
		(node MeetingBeScheduledMI (tgt c))
	)
)))

;LetSchedulerScheduleMeeting2Quick Exists
(assert	(exists ((c ContributionConcretization)) (edge LetSchedulerScheduleMeeting2Quick c)))
;LetSchedulerScheduleMeeting2Quick is Unique
(assert	(forall ((c1 ContributionConcretization) (c2 ContributionConcretization)) (=>
	(and (edge LetSchedulerScheduleMeeting2Quick c1) (edge LetSchedulerScheduleMeeting2Quick c2))
	(= c1 c2)
)))
;LetSchedulerScheduleMeeting2Quick is Distinct from WaysToOrganizeMeeting2Quick
(assert	(forall ((c ContributionConcretization)) (=>
	(edge LetSchedulerScheduleMeeting2Quick c)
	(not (edge WaysToOrganizeMeeting2Quick c))
)))
;LetSchedulerScheduleMeeting2Quick is Distinct from WaysToOrganizeMeeting2LowEffortMI
(assert	(forall ((c ContributionConcretization)) (=>
	(edge LetSchedulerScheduleMeeting2Quick c)
	(not (edge WaysToOrganizeMeeting2LowEffortMI c))
)))
;LetSchedulerScheduleMeeting2Quick is Distinct from LetSchedulerScheduleMeeting2LowEffortMI
(assert	(forall ((c ContributionConcretization)) (=>
	(edge LetSchedulerScheduleMeeting2Quick c)
	(not (edge LetSchedulerScheduleMeeting2LowEffortMI c))
)))

;LetSchedulerScheduleMeeting2Quick endpoints
(assert (forall ((c ContributionConcretization)) (=>
	(edge LetSchedulerScheduleMeeting2Quick c)
	(and
		(node LetSchedulerScheduleMeeting ((as src (TaskConcretization)) c))
		(node Quick (tgt c))
	)
)))
;LetSchedulerScheduleMeeting2Quick srcEndpoint constant
(assert (forall ((c ContributionConcretization)) (=>
	(edge LetSchedulerScheduleMeeting2Quick c)
	(= (srcEndpoint c) ENDPOINT_TASK)
)))

;LetSchedulerScheduleMeeting2Quick type constant
(assert (forall ((c ContributionConcretization)) (=>
	(edge LetSchedulerScheduleMeeting2Quick c)
	(= (type c) CONTRIBUTION_HELP)
)))
;LetSchedulerScheduleMeeting2LowEffortMI Exists
(assert	(exists ((c ContributionConcretization)) (edge LetSchedulerScheduleMeeting2LowEffortMI c)))
;LetSchedulerScheduleMeeting2LowEffortMI is Unique
(assert	(forall ((c1 ContributionConcretization) (c2 ContributionConcretization)) (=>
	(and (edge LetSchedulerScheduleMeeting2LowEffortMI c1) (edge LetSchedulerScheduleMeeting2LowEffortMI c2))
	(= c1 c2)
)))
;LetSchedulerScheduleMeeting2LowEffortMI is Distinct from WaysToOrganizeMeeting2Quick
(assert	(forall ((c ContributionConcretization)) (=>
	(edge LetSchedulerScheduleMeeting2LowEffortMI c)
	(not (edge WaysToOrganizeMeeting2Quick c))
)))
;LetSchedulerScheduleMeeting2LowEffortMI is Distinct from WaysToOrganizeMeeting2LowEffortMI
(assert	(forall ((c ContributionConcretization)) (=>
	(edge LetSchedulerScheduleMeeting2LowEffortMI c)
	(not (edge WaysToOrganizeMeeting2LowEffortMI c))
)))
;LetSchedulerScheduleMeeting2LowEffortMI is Distinct from LetSchedulerScheduleMeeting2Quick
(assert	(forall ((c ContributionConcretization)) (=>
	(edge LetSchedulerScheduleMeeting2LowEffortMI c)
	(not (edge LetSchedulerScheduleMeeting2Quick c))
)))

;LetSchedulerScheduleMeeting2LowEffortMI endpoints
(assert (forall ((c ContributionConcretization)) (=>
	(edge LetSchedulerScheduleMeeting2LowEffortMI c)
	(and
		(node LetSchedulerScheduleMeeting ((as src (TaskConcretization)) c))
		(node LowEffortMI (tgt c))
	)
)))
;LetSchedulerScheduleMeeting2LowEffortMI srcEndpoint constant
(assert (forall ((c ContributionConcretization)) (=>
	(edge LetSchedulerScheduleMeeting2LowEffortMI c)
	(= (srcEndpoint c) ENDPOINT_TASK)
)))

;LetSchedulerScheduleMeeting2LowEffortMI type constant
(assert (forall ((c ContributionConcretization)) (=>
	(edge LetSchedulerScheduleMeeting2LowEffortMI c)
	(= (type c) CONTRIBUTION_HELP)
)))
;Quick2OrganizeMeeting Exists
(assert	(exists ((c DecompositionConcretization)) (edge Quick2OrganizeMeeting c)))
;Quick2OrganizeMeeting is Unique
(assert	(forall ((c1 DecompositionConcretization) (c2 DecompositionConcretization)) (=>
	(and (edge Quick2OrganizeMeeting c1) (edge Quick2OrganizeMeeting c2))
	(= c1 c2)
)))
;Quick2OrganizeMeeting is Distinct from AttendMeeting2ParticipateInMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge Quick2OrganizeMeeting c)
	(not (edge AttendMeeting2ParticipateInMeeting c))
)))
;Quick2OrganizeMeeting is Distinct from ProvideDetails2ParticipateInMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge Quick2OrganizeMeeting c)
	(not (edge ProvideDetails2ParticipateInMeeting c))
)))
;Quick2OrganizeMeeting is Distinct from AgreeableMeetingDate2ParticipateInMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge Quick2OrganizeMeeting c)
	(not (edge AgreeableMeetingDate2ParticipateInMeeting c))
)))
;Quick2OrganizeMeeting is Distinct from ConvenientMeetingDate2ParticipateInMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge Quick2OrganizeMeeting c)
	(not (edge ConvenientMeetingDate2ParticipateInMeeting c))
)))
;Quick2OrganizeMeeting is Distinct from LowEffortMP2ProvideDetails
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge Quick2OrganizeMeeting c)
	(not (edge LowEffortMP2ProvideDetails c))
)))
;Quick2OrganizeMeeting is Distinct from UseProfiles2ParticipateInMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge Quick2OrganizeMeeting c)
	(not (edge UseProfiles2ParticipateInMeeting c))
)))
;Quick2OrganizeMeeting is Distinct from MeetingBeScheduledMI2OrganizeMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge Quick2OrganizeMeeting c)
	(not (edge MeetingBeScheduledMI2OrganizeMeeting c))
)))
;Quick2OrganizeMeeting is Distinct from LowEffortMI2OrganizeMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge Quick2OrganizeMeeting c)
	(not (edge LowEffortMI2OrganizeMeeting c))
)))

;Quick2OrganizeMeeting endpoints
(assert (forall ((c DecompositionConcretization)) (=>
	(edge Quick2OrganizeMeeting c)
	(and
		(node Quick ((as src (SoftGoalConcretization)) c))
		(node OrganizeMeeting (tgt c))
	)
)))
;Quick2OrganizeMeeting srcEndpoint constant
(assert (forall ((c DecompositionConcretization)) (=>
	(edge Quick2OrganizeMeeting c)
	(= (srcEndpoint c) ENDPOINT_SOFTGOAL)
)))

;LowEffortMI2OrganizeMeeting Exists
(assert	(exists ((c DecompositionConcretization)) (edge LowEffortMI2OrganizeMeeting c)))
;LowEffortMI2OrganizeMeeting is Unique
(assert	(forall ((c1 DecompositionConcretization) (c2 DecompositionConcretization)) (=>
	(and (edge LowEffortMI2OrganizeMeeting c1) (edge LowEffortMI2OrganizeMeeting c2))
	(= c1 c2)
)))
;LowEffortMI2OrganizeMeeting is Distinct from AttendMeeting2ParticipateInMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge LowEffortMI2OrganizeMeeting c)
	(not (edge AttendMeeting2ParticipateInMeeting c))
)))
;LowEffortMI2OrganizeMeeting is Distinct from ProvideDetails2ParticipateInMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge LowEffortMI2OrganizeMeeting c)
	(not (edge ProvideDetails2ParticipateInMeeting c))
)))
;LowEffortMI2OrganizeMeeting is Distinct from AgreeableMeetingDate2ParticipateInMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge LowEffortMI2OrganizeMeeting c)
	(not (edge AgreeableMeetingDate2ParticipateInMeeting c))
)))
;LowEffortMI2OrganizeMeeting is Distinct from ConvenientMeetingDate2ParticipateInMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge LowEffortMI2OrganizeMeeting c)
	(not (edge ConvenientMeetingDate2ParticipateInMeeting c))
)))
;LowEffortMI2OrganizeMeeting is Distinct from LowEffortMP2ProvideDetails
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge LowEffortMI2OrganizeMeeting c)
	(not (edge LowEffortMP2ProvideDetails c))
)))
;LowEffortMI2OrganizeMeeting is Distinct from UseProfiles2ParticipateInMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge LowEffortMI2OrganizeMeeting c)
	(not (edge UseProfiles2ParticipateInMeeting c))
)))
;LowEffortMI2OrganizeMeeting is Distinct from MeetingBeScheduledMI2OrganizeMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge LowEffortMI2OrganizeMeeting c)
	(not (edge MeetingBeScheduledMI2OrganizeMeeting c))
)))
;LowEffortMI2OrganizeMeeting is Distinct from Quick2OrganizeMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge LowEffortMI2OrganizeMeeting c)
	(not (edge Quick2OrganizeMeeting c))
)))

;LowEffortMI2OrganizeMeeting endpoints
(assert (forall ((c DecompositionConcretization)) (=>
	(edge LowEffortMI2OrganizeMeeting c)
	(and
		(node LowEffortMI ((as src (SoftGoalConcretization)) c))
		(node OrganizeMeeting (tgt c))
	)
)))
;LowEffortMI2OrganizeMeeting srcEndpoint constant
(assert (forall ((c DecompositionConcretization)) (=>
	(edge LowEffortMI2OrganizeMeeting c)
	(= (srcEndpoint c) ENDPOINT_SOFTGOAL)
)))

;AttendMeeting2ParticipateInMeeting Exists
(assert	(exists ((c DecompositionConcretization)) (edge AttendMeeting2ParticipateInMeeting c)))
;AttendMeeting2ParticipateInMeeting is Unique
(assert	(forall ((c1 DecompositionConcretization) (c2 DecompositionConcretization)) (=>
	(and (edge AttendMeeting2ParticipateInMeeting c1) (edge AttendMeeting2ParticipateInMeeting c2))
	(= c1 c2)
)))
;AttendMeeting2ParticipateInMeeting is Distinct from MeetingBeScheduledMI2OrganizeMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge AttendMeeting2ParticipateInMeeting c)
	(not (edge MeetingBeScheduledMI2OrganizeMeeting c))
)))
;AttendMeeting2ParticipateInMeeting is Distinct from Quick2OrganizeMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge AttendMeeting2ParticipateInMeeting c)
	(not (edge Quick2OrganizeMeeting c))
)))
;AttendMeeting2ParticipateInMeeting is Distinct from LowEffortMI2OrganizeMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge AttendMeeting2ParticipateInMeeting c)
	(not (edge LowEffortMI2OrganizeMeeting c))
)))
;AttendMeeting2ParticipateInMeeting is Distinct from ProvideDetails2ParticipateInMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge AttendMeeting2ParticipateInMeeting c)
	(not (edge ProvideDetails2ParticipateInMeeting c))
)))
;AttendMeeting2ParticipateInMeeting is Distinct from LowEffortMP2ProvideDetails
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge AttendMeeting2ParticipateInMeeting c)
	(not (edge LowEffortMP2ProvideDetails c))
)))
;AttendMeeting2ParticipateInMeeting is Distinct from UseProfiles2ParticipateInMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge AttendMeeting2ParticipateInMeeting c)
	(not (edge UseProfiles2ParticipateInMeeting c))
)))

;AttendMeeting2ParticipateInMeeting endpoints
(assert (forall ((c DecompositionConcretization)) (=>
	(edge AttendMeeting2ParticipateInMeeting c)
	(and
		(node AttendMeeting ((as src (TaskConcretization)) c))
		(node ParticipateInMeeting (tgt c))
	)
)))
;AttendMeeting2ParticipateInMeeting srcEndpoint constant
(assert (forall ((c DecompositionConcretization)) (=>
	(edge AttendMeeting2ParticipateInMeeting c)
	(= (srcEndpoint c) ENDPOINT_TASK)
)))

;ProvideDetails2ParticipateInMeeting is Distinct from MeetingBeScheduledMI2OrganizeMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge ProvideDetails2ParticipateInMeeting c)
	(not (edge MeetingBeScheduledMI2OrganizeMeeting c))
)))
;ProvideDetails2ParticipateInMeeting is Distinct from Quick2OrganizeMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge ProvideDetails2ParticipateInMeeting c)
	(not (edge Quick2OrganizeMeeting c))
)))
;ProvideDetails2ParticipateInMeeting is Distinct from LowEffortMI2OrganizeMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge ProvideDetails2ParticipateInMeeting c)
	(not (edge LowEffortMI2OrganizeMeeting c))
)))
;ProvideDetails2ParticipateInMeeting is Distinct from AttendMeeting2ParticipateInMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge ProvideDetails2ParticipateInMeeting c)
	(not (edge AttendMeeting2ParticipateInMeeting c))
)))
;ProvideDetails2ParticipateInMeeting is Distinct from LowEffortMP2ProvideDetails
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge ProvideDetails2ParticipateInMeeting c)
	(not (edge LowEffortMP2ProvideDetails c))
)))
;ProvideDetails2ParticipateInMeeting is Distinct from UseProfiles2ParticipateInMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge ProvideDetails2ParticipateInMeeting c)
	(not (edge UseProfiles2ParticipateInMeeting c))
)))

;ProvideDetails2ParticipateInMeeting endpoints
(assert (forall ((c DecompositionConcretization)) (=>
	(edge ProvideDetails2ParticipateInMeeting c)
	(and
		(node ProvideDetails ((as src (TaskConcretization)) c))
		(node ParticipateInMeeting (tgt c))
	)
)))
;ProvideDetails2ParticipateInMeeting srcEndpoint constant
(assert (forall ((c DecompositionConcretization)) (=>
	(edge ProvideDetails2ParticipateInMeeting c)
	(= (srcEndpoint c) ENDPOINT_TASK)
)))

;AgreeableMeetingDate2ParticipateInMeeting Exists
(assert	(exists ((c DecompositionConcretization)) (edge AgreeableMeetingDate2ParticipateInMeeting c)))
;AgreeableMeetingDate2ParticipateInMeeting is Unique
(assert	(forall ((c1 DecompositionConcretization) (c2 DecompositionConcretization)) (=>
	(and (edge AgreeableMeetingDate2ParticipateInMeeting c1) (edge AgreeableMeetingDate2ParticipateInMeeting c2))
	(= c1 c2)
)))
;AgreeableMeetingDate2ParticipateInMeeting is Distinct from MeetingBeScheduledMI2OrganizeMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge AgreeableMeetingDate2ParticipateInMeeting c)
	(not (edge MeetingBeScheduledMI2OrganizeMeeting c))
)))
;AgreeableMeetingDate2ParticipateInMeeting is Distinct from Quick2OrganizeMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge AgreeableMeetingDate2ParticipateInMeeting c)
	(not (edge Quick2OrganizeMeeting c))
)))
;AgreeableMeetingDate2ParticipateInMeeting is Distinct from LowEffortMI2OrganizeMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge AgreeableMeetingDate2ParticipateInMeeting c)
	(not (edge LowEffortMI2OrganizeMeeting c))
)))

;AgreeableMeetingDate2ParticipateInMeeting endpoints
(assert (forall ((c DecompositionConcretization)) (=>
	(edge AgreeableMeetingDate2ParticipateInMeeting c)
	(and
		(node AgreeableMeetingDate ((as src (GoalConcretization)) c))
		(node ParticipateInMeeting (tgt c))
	)
)))
;AgreeableMeetingDate2ParticipateInMeeting srcEndpoint constant
(assert (forall ((c DecompositionConcretization)) (=>
	(edge AgreeableMeetingDate2ParticipateInMeeting c)
	(= (srcEndpoint c) ENDPOINT_GOAL)
)))

;ConvenientMeetingDate2ParticipateInMeeting is Unique
(assert	(forall ((c1 DecompositionConcretization) (c2 DecompositionConcretization)) (=>
	(and (edge ConvenientMeetingDate2ParticipateInMeeting c1) (edge ConvenientMeetingDate2ParticipateInMeeting c2))
	(= c1 c2)
)))
;ConvenientMeetingDate2ParticipateInMeeting is Distinct from MeetingBeScheduledMI2OrganizeMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge ConvenientMeetingDate2ParticipateInMeeting c)
	(not (edge MeetingBeScheduledMI2OrganizeMeeting c))
)))
;ConvenientMeetingDate2ParticipateInMeeting is Distinct from Quick2OrganizeMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge ConvenientMeetingDate2ParticipateInMeeting c)
	(not (edge Quick2OrganizeMeeting c))
)))
;ConvenientMeetingDate2ParticipateInMeeting is Distinct from LowEffortMI2OrganizeMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge ConvenientMeetingDate2ParticipateInMeeting c)
	(not (edge LowEffortMI2OrganizeMeeting c))
)))

;ConvenientMeetingDate2ParticipateInMeeting endpoints
(assert (forall ((c DecompositionConcretization)) (=>
	(edge ConvenientMeetingDate2ParticipateInMeeting c)
	(and
		(node ConvenientMeetingDate ((as src (GoalConcretization)) c))
		(node ParticipateInMeeting (tgt c))
	)
)))
;ConvenientMeetingDate2ParticipateInMeeting srcEndpoint constant
(assert (forall ((c DecompositionConcretization)) (=>
	(edge ConvenientMeetingDate2ParticipateInMeeting c)
	(= (srcEndpoint c) ENDPOINT_GOAL)
)))

;DecideConvenientDates2ConvenientMeetingDate is Unique
(assert	(forall ((c1 MeansEndConcretization) (c2 MeansEndConcretization)) (=>
	(and (edge DecideConvenientDates2ConvenientMeetingDate c1) (edge DecideConvenientDates2ConvenientMeetingDate c2))
	(= c1 c2)
)))
;DecideConvenientDates2ConvenientMeetingDate is Distinct from WaysToOrganizeMeeting2MeetingBeScheduledMI
(assert	(forall ((c MeansEndConcretization)) (=>
	(edge DecideConvenientDates2ConvenientMeetingDate c)
	(not (edge WaysToOrganizeMeeting2MeetingBeScheduledMI c))
)))
;DecideConvenientDates2ConvenientMeetingDate is Distinct from LetSchedulerScheduleMeeting2MeetingBeScheduledMI
(assert	(forall ((c MeansEndConcretization)) (=>
	(edge DecideConvenientDates2ConvenientMeetingDate c)
	(not (edge LetSchedulerScheduleMeeting2MeetingBeScheduledMI c))
)))

;DecideConvenientDates2ConvenientMeetingDate endpoints
(assert (forall ((c MeansEndConcretization)) (=>
	(edge DecideConvenientDates2ConvenientMeetingDate c)
	(and
		(node DecideConvenientDates (src c))
		(node ConvenientMeetingDate (tgt c))
	)
)))

;LowEffortMP2ProvideDetails is Distinct from MeetingBeScheduledMI2OrganizeMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge LowEffortMP2ProvideDetails c)
	(not (edge MeetingBeScheduledMI2OrganizeMeeting c))
)))
;LowEffortMP2ProvideDetails is Distinct from Quick2OrganizeMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge LowEffortMP2ProvideDetails c)
	(not (edge Quick2OrganizeMeeting c))
)))
;LowEffortMP2ProvideDetails is Distinct from LowEffortMI2OrganizeMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge LowEffortMP2ProvideDetails c)
	(not (edge LowEffortMI2OrganizeMeeting c))
)))
;LowEffortMP2ProvideDetails is Distinct from AttendMeeting2ParticipateInMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge LowEffortMP2ProvideDetails c)
	(not (edge AttendMeeting2ParticipateInMeeting c))
)))
;LowEffortMP2ProvideDetails is Distinct from ProvideDetails2ParticipateInMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge LowEffortMP2ProvideDetails c)
	(not (edge ProvideDetails2ParticipateInMeeting c))
)))
;LowEffortMP2ProvideDetails is Distinct from UseProfiles2ParticipateInMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge LowEffortMP2ProvideDetails c)
	(not (edge UseProfiles2ParticipateInMeeting c))
)))

;LowEffortMP2ProvideDetails endpoints
(assert (forall ((c DecompositionConcretization)) (=>
	(edge LowEffortMP2ProvideDetails c)
	(and
		(node LowEffortMP ((as src (SoftGoalConcretization)) c))
		(node ProvideDetails (tgt c))
	)
)))
;LowEffortMP2ProvideDetails srcEndpoint constant
(assert (forall ((c DecompositionConcretization)) (=>
	(edge LowEffortMP2ProvideDetails c)
	(= (srcEndpoint c) ENDPOINT_SOFTGOAL)
)))

;UseProfiles2ParticipateInMeeting is Unique
(assert	(forall ((c1 DecompositionConcretization) (c2 DecompositionConcretization)) (=>
	(and (edge UseProfiles2ParticipateInMeeting c1) (edge UseProfiles2ParticipateInMeeting c2))
	(= c1 c2)
)))
;UseProfiles2ParticipateInMeeting is Distinct from MeetingBeScheduledMI2OrganizeMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge UseProfiles2ParticipateInMeeting c)
	(not (edge MeetingBeScheduledMI2OrganizeMeeting c))
)))
;UseProfiles2ParticipateInMeeting is Distinct from Quick2OrganizeMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge UseProfiles2ParticipateInMeeting c)
	(not (edge Quick2OrganizeMeeting c))
)))
;UseProfiles2ParticipateInMeeting is Distinct from LowEffortMI2OrganizeMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge UseProfiles2ParticipateInMeeting c)
	(not (edge LowEffortMI2OrganizeMeeting c))
)))
;UseProfiles2ParticipateInMeeting is Distinct from AttendMeeting2ParticipateInMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge UseProfiles2ParticipateInMeeting c)
	(not (edge AttendMeeting2ParticipateInMeeting c))
)))
;UseProfiles2ParticipateInMeeting is Distinct from ProvideDetails2ParticipateInMeeting
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge UseProfiles2ParticipateInMeeting c)
	(not (edge ProvideDetails2ParticipateInMeeting c))
)))
;UseProfiles2ParticipateInMeeting is Distinct from LowEffortMP2ProvideDetails
(assert	(forall ((c DecompositionConcretization)) (=>
	(edge UseProfiles2ParticipateInMeeting c)
	(not (edge LowEffortMP2ProvideDetails c))
)))

;UseProfiles2ParticipateInMeeting endpoints
(assert (forall ((c DecompositionConcretization)) (=>
	(edge UseProfiles2ParticipateInMeeting c)
	(and
		(node UseProfiles ((as src (TaskConcretization)) c))
		(node ParticipateInMeeting (tgt c))
	)
)))
;UseProfiles2ParticipateInMeeting srcEndpoint constant
(assert (forall ((c DecompositionConcretization)) (=>
	(edge UseProfiles2ParticipateInMeeting c)
	(= (srcEndpoint c) ENDPOINT_TASK)
)))

;OrganizeMeeting2Dependencies srcEndpoint constant
(assert (forall ((c DependerLinkConcretization)) (=>
	(edge OrganizeMeeting2Dependencies c)
	(= (srcEndpoint c) ENDPOINT_TASK)
)))
;OrganizeMeeting2Dependencies tgtEndpoint constant
(assert (forall ((c DependerLinkConcretization)) (=>
	(edge OrganizeMeeting2Dependencies c)
	(= (tgtEndpoint c) ENDPOINT_GOAL)
)))
;OrganizeMeeting2Dependencies endpoints
(assert (forall ((c DependerLinkConcretization)) (=>
	(edge OrganizeMeeting2Dependencies c)
	(and
		(node OrganizeMeeting ((as src (TaskConcretization)) c))
		(node Dependencies ((as tgt (GoalConcretization)) c))
	)
)))
;OrganizeMeeting2Dependencies is Distinct from LetSchedulerScheduleMeeting2MeetingBeScheduled
(assert	(forall ((c DependerLinkConcretization)) (=>
	(edge OrganizeMeeting2Dependencies c)
	(not (edge LetSchedulerScheduleMeeting2MeetingBeScheduled c))
)))
;LetSchedulerScheduleMeeting2MeetingBeScheduled srcEndpoint constant
(assert (forall ((c DependerLinkConcretization)) (=>
	(edge LetSchedulerScheduleMeeting2MeetingBeScheduled c)
	(= (srcEndpoint c) ENDPOINT_TASK)
)))
;LetSchedulerScheduleMeeting2MeetingBeScheduled tgtEndpoint constant
(assert (forall ((c DependerLinkConcretization)) (=>
	(edge LetSchedulerScheduleMeeting2MeetingBeScheduled c)
	(= (tgtEndpoint c) ENDPOINT_GOAL)
)))
;LetSchedulerScheduleMeeting2MeetingBeScheduled endpoints
(assert (forall ((c DependerLinkConcretization)) (=>
	(edge LetSchedulerScheduleMeeting2MeetingBeScheduled c)
	(and
		(node LetSchedulerScheduleMeeting ((as src (TaskConcretization)) c))
		(node MeetingBeScheduled ((as tgt (GoalConcretization)) c))
	)
)))
;LetSchedulerScheduleMeeting2MeetingBeScheduled Exists
(assert	(exists ((c DependerLinkConcretization)) (edge LetSchedulerScheduleMeeting2MeetingBeScheduled c)))
;LetSchedulerScheduleMeeting2MeetingBeScheduled is Unique
(assert	(forall ((c1 DependerLinkConcretization) (c2 DependerLinkConcretization)) (=>
	(and (edge LetSchedulerScheduleMeeting2MeetingBeScheduled c1) (edge LetSchedulerScheduleMeeting2MeetingBeScheduled c2))
	(= c1 c2)
)))
;LetSchedulerScheduleMeeting2MeetingBeScheduled is Distinct from OrganizeMeeting2Dependencies
(assert	(forall ((c DependerLinkConcretization)) (=>
	(edge LetSchedulerScheduleMeeting2MeetingBeScheduled c)
	(not (edge OrganizeMeeting2Dependencies c))
)))
;ScheduleMeeting2Details srcEndpoint constant
(assert (forall ((c DependerLinkConcretization)) (=>
	(edge ScheduleMeeting2Details c)
	(= (srcEndpoint c) ENDPOINT_TASK)
)))
;ScheduleMeeting2Details tgtEndpoint constant
(assert (forall ((c DependerLinkConcretization)) (=>
	(edge ScheduleMeeting2Details c)
	(= (tgtEndpoint c) ENDPOINT_RESOURCE)
)))
;ScheduleMeeting2Details endpoints
(assert (forall ((c DependerLinkConcretization)) (=>
	(edge ScheduleMeeting2Details c)
	(and
		(node ScheduleMeeting ((as src (TaskConcretization)) c))
		(node Details ((as tgt (ResourceConcretization)) c))
	)
)))
;ScheduleMeeting2Details Exists
(assert	(exists ((c DependerLinkConcretization)) (edge ScheduleMeeting2Details c)))
;Dependencies2ParticipateInMeeting srcEndpoint constant
(assert (forall ((c DependeeLinkConcretization)) (=>
	(edge Dependencies2ParticipateInMeeting c)
	(= (srcEndpoint c) ENDPOINT_GOAL)
)))
;Dependencies2ParticipateInMeeting tgtEndpoint constant
(assert (forall ((c DependeeLinkConcretization)) (=>
	(edge Dependencies2ParticipateInMeeting c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;Dependencies2ParticipateInMeeting endpoints
(assert (forall ((c DependeeLinkConcretization)) (=>
	(edge Dependencies2ParticipateInMeeting c)
	(and
		(node Dependencies ((as src (GoalConcretization)) c))
		(node ParticipateInMeeting ((as tgt (TaskConcretization)) c))
	)
)))
;Dependencies2ParticipateInMeeting is Distinct from MeetingBeScheduled2ScheduleMeeting
(assert	(forall ((c DependeeLinkConcretization)) (=>
	(edge Dependencies2ParticipateInMeeting c)
	(not (edge MeetingBeScheduled2ScheduleMeeting c))
)))
;MeetingBeScheduled2ScheduleMeeting srcEndpoint constant
(assert (forall ((c DependeeLinkConcretization)) (=>
	(edge MeetingBeScheduled2ScheduleMeeting c)
	(= (srcEndpoint c) ENDPOINT_GOAL)
)))
;MeetingBeScheduled2ScheduleMeeting tgtEndpoint constant
(assert (forall ((c DependeeLinkConcretization)) (=>
	(edge MeetingBeScheduled2ScheduleMeeting c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;MeetingBeScheduled2ScheduleMeeting endpoints
(assert (forall ((c DependeeLinkConcretization)) (=>
	(edge MeetingBeScheduled2ScheduleMeeting c)
	(and
		(node MeetingBeScheduled ((as src (GoalConcretization)) c))
		(node ScheduleMeeting ((as tgt (TaskConcretization)) c))
	)
)))
;MeetingBeScheduled2ScheduleMeeting Exists
(assert	(exists ((c DependeeLinkConcretization)) (edge MeetingBeScheduled2ScheduleMeeting c)))
;MeetingBeScheduled2ScheduleMeeting is Unique
(assert	(forall ((c1 DependeeLinkConcretization) (c2 DependeeLinkConcretization)) (=>
	(and (edge MeetingBeScheduled2ScheduleMeeting c1) (edge MeetingBeScheduled2ScheduleMeeting c2))
	(= c1 c2)
)))
;MeetingBeScheduled2ScheduleMeeting is Distinct from Dependencies2ParticipateInMeeting
(assert	(forall ((c DependeeLinkConcretization)) (=>
	(edge MeetingBeScheduled2ScheduleMeeting c)
	(not (edge Dependencies2ParticipateInMeeting c))
)))
;Details2ProvideDetails srcEndpoint constant
(assert (forall ((c DependeeLinkConcretization)) (=>
	(edge Details2ProvideDetails c)
	(= (srcEndpoint c) ENDPOINT_RESOURCE)
)))
;Details2ProvideDetails tgtEndpoint constant
(assert (forall ((c DependeeLinkConcretization)) (=>
	(edge Details2ProvideDetails c)
	(= (tgtEndpoint c) ENDPOINT_TASK)
)))
;Details2ProvideDetails endpoints
(assert (forall ((c DependeeLinkConcretization)) (=>
	(edge Details2ProvideDetails c)
	(and
		(node Details ((as src (ResourceConcretization)) c))
		(node ProvideDetails ((as tgt (TaskConcretization)) c))
	)
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

;SoftGoal propagation (Contribution + Depender + Dependee)
(assert (forall ((c SoftGoalConcretization)) (=> (not (inited c)) (= (co c) (ite
	(or
		(and
			(or
				(exists ((cc1 ContributionConcretization)) (and (= (tgt cc1) c) (co cc1)))
				(exists ((cc2 ContributionConcretization) (cc3 ContributionConcretization)) (and (= (tgt cc2) c) (= (tgt cc3) c) (or (fs cc2) (ps cc2)) (or (pd cc3) (fd cc3))))
			)
			(not (exists ((dc DependerLinkConcretization)) (and (= (srcEndpoint dc) ENDPOINT_SOFTGOAL) (= ((as src (SoftGoalConcretization)) dc) c) (or (fd dc) (pd dc)))))
		)
		(and
			(exists ((dc1 DependerLinkConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_SOFTGOAL) (= ((as src (SoftGoalConcretization)) dc1) c) (co dc1)))
			(not (exists ((dc2 DependerLinkConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_SOFTGOAL) (= ((as src (SoftGoalConcretization)) dc2) c) (or (fd dc2) (pd dc2)))))
			;not exists fd|pd
			(not (and
				(exists ((cc1 ContributionConcretization)) (and (= (tgt cc1) c) (or (fd cc1) (pd cc1))))
				(not (exists ((cc2 ContributionConcretization)) (and (= (tgt cc2) c) (or (co cc2) (un cc2) (fs cc2) (ps cc2)))))
			))
		)
		(and
			(exists ((dc1 DependeeLinkConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_SOFTGOAL) (= ((as src (SoftGoalConcretization)) dc1) c) (co dc1)))
			(not (exists ((dc2 DependeeLinkConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_SOFTGOAL) (= ((as src (SoftGoalConcretization)) dc2) c) (or (fd dc2) (pd dc2)))))
		)
	)
	true
	false
)))))
(assert (forall ((c SoftGoalConcretization)) (=> (and (not (inited c)) (co c)) (= (un c) false))))
(assert (forall ((c SoftGoalConcretization)) (=> (and (not (inited c)) (not (co c))) (= (un c) (ite
	(or
		(and
			(exists ((cc1 ContributionConcretization)) (and (= (tgt cc1) c) (un cc1)))
			(not (exists ((cc2 ContributionConcretization)) (and (= (tgt cc2) c) (co cc2))))
			(not (exists ((cc3 ContributionConcretization) (cc4 ContributionConcretization)) (and (= (tgt cc3) c) (= (tgt cc4) c) (or (fs cc3) (ps cc3)) (or (pd cc4) (fd cc4)))))
			(not (exists ((dc DependerLinkConcretization)) (and (= (srcEndpoint dc) ENDPOINT_SOFTGOAL) (= ((as src (SoftGoalConcretization)) dc) c) (or (fd dc) (pd dc) (co dc)))))
		)
		(and
			(exists ((dc1 DependerLinkConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_SOFTGOAL) (= ((as src (SoftGoalConcretization)) dc1) c) (un dc1)))
			(not (exists ((dc2 DependerLinkConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_SOFTGOAL) (= ((as src (SoftGoalConcretization)) dc2) c) (or (fd dc2) (pd dc2) (co dc2)))))
			;not exists fd|pd|co_
			(not (and
				(exists ((cc1 ContributionConcretization)) (and (= (tgt cc1) c) (or (fd cc1) (pd cc1))))
				(not (exists ((cc2 ContributionConcretization)) (and (= (tgt cc2) c) (un cc2))))
			))
			;not exists co
			(not (exists ((cc3 ContributionConcretization)) (and (= (tgt cc3) c) (co cc3))))
		)
		(and
			(exists ((dc1 DependeeLinkConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_SOFTGOAL) (= ((as src (SoftGoalConcretization)) dc1) c) (un dc1)))
			(not (exists ((dc2 DependeeLinkConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_SOFTGOAL) (= ((as src (SoftGoalConcretization)) dc2) c) (or (fd dc2) (pd dc2) (co dc2)))))
		)
	)
	true
	false
)))))
(assert (forall ((c SoftGoalConcretization)) (=> (and (not (inited c)) (or (co c) (un c))) (= (fd c) false))))
(assert (forall ((c SoftGoalConcretization)) (=> (and (not (inited c)) (not (co c)) (not (un c))) (= (fd c) (ite
	(or
		(and
			(exists ((cc1 ContributionConcretization)) (and (= (tgt cc1) c) (fd cc1)))
			(not (exists ((cc2 ContributionConcretization)) (and (= (tgt cc2) c) (or (co cc2) (un cc2) (fs cc2) (ps cc2)))))
		)
		(exists ((dc DependerLinkConcretization)) (and (= (srcEndpoint dc) ENDPOINT_SOFTGOAL) (= ((as src (SoftGoalConcretization)) dc) c) (fd dc)))
		(exists ((dc DependeeLinkConcretization)) (and (= (srcEndpoint dc) ENDPOINT_SOFTGOAL) (= ((as src (SoftGoalConcretization)) dc) c) (fd dc)))
	)
	true
	false
)))))
(assert (forall ((c SoftGoalConcretization)) (=> (and (not (inited c)) (or (co c) (un c) (fd c))) (= (pd c) false))))
(assert (forall ((c SoftGoalConcretization)) (=> (and (not (inited c)) (not (co c)) (not (un c)) (not (fd c))) (= (pd c) (ite
	(or
		(and
			(exists ((cc1 ContributionConcretization)) (and (= (tgt cc1) c) (pd cc1)))
			(not (exists ((cc2 ContributionConcretization)) (and (= (tgt cc2) c) (or (co cc2) (un cc2) (fd cc2) (fs cc2) (ps cc2)))))
			(not (exists ((dc DependerLinkConcretization)) (and (= (srcEndpoint dc) ENDPOINT_SOFTGOAL) (= ((as src (SoftGoalConcretization)) dc) c) (fd dc))))
		)
		(and
			(exists ((dc1 DependerLinkConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_SOFTGOAL) (= ((as src (SoftGoalConcretization)) dc1) c) (pd dc1)))
			(not (exists ((dc2 DependerLinkConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_SOFTGOAL) (= ((as src (SoftGoalConcretization)) dc2) c) (fd dc2))))
			;not exists fd
			(not (and
				(exists ((cc1 ContributionConcretization)) (and (= (tgt cc1) c) (fd cc1)))
				(not (exists ((cc2 ContributionConcretization)) (and (= (tgt cc2) c) (or (co cc2) (un cc2) (fs cc2) (ps cc2)))))
			))
		)
		(and
			(exists ((dc1 DependeeLinkConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_SOFTGOAL) (= ((as src (SoftGoalConcretization)) dc1) c) (pd dc1)))
			(not (exists ((dc2 DependeeLinkConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_SOFTGOAL) (= ((as src (SoftGoalConcretization)) dc2) c) (fd dc2))))
		)
	)
	true
	false
)))))
(assert (forall ((c SoftGoalConcretization)) (=> (and (not (inited c)) (or (co c) (un c) (fd c) (pd c))) (= (fs c) false))))
(assert (forall ((c SoftGoalConcretization)) (=> (and (not (inited c)) (not (co c)) (not (un c)) (not (fd c)) (not (pd c))) (= (fs c) (ite
	(or
		(and
			(exists ((cc1 ContributionConcretization)) (and (= (tgt cc1) c) (fs cc1)))
			(not (exists ((cc2 ContributionConcretization)) (and (= (tgt cc2) c) (or (co cc2) (un cc2) (fd cc2) (pd cc2)))))
			(not (exists ((dc DependerLinkConcretization)) (and (= (srcEndpoint dc) ENDPOINT_SOFTGOAL) (= ((as src (SoftGoalConcretization)) dc) c) (or (fd dc) (pd dc) (co dc) (un dc) (n dc) (ps dc)))))
		)
		(and
			(exists ((dc1 DependerLinkConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_SOFTGOAL) (= ((as src (SoftGoalConcretization)) dc1) c) (fs dc1)))
			(not (exists ((dc2 DependerLinkConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_SOFTGOAL) (= ((as src (SoftGoalConcretization)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (n dc2) (ps dc2)))))
			;not exists fd|pd|co|co_|un
			(not (exists ((cc1 ContributionConcretization)) (and (= (tgt cc1) c) (or (co cc1) (un cc1) (fd cc1) (pd cc1)))))
			;not exists n
			(not (and
				(exists ((cc2 ContributionConcretization)) (and (= (tgt cc2) c) (n cc2)))
				(not (exists ((cc3 ContributionConcretization)) (and (= (tgt cc3) c) (or (co cc3) (un cc3) (fd cc3) (pd cc3) (fs cc3) (ps cc3)))))
			))
			;not exists ps
			(not (and
				(exists ((cc4 ContributionConcretization)) (and (= (tgt cc4) c) (ps cc4)))
				(not (exists ((cc5 ContributionConcretization)) (and (= (tgt cc5) c) (or (co cc5) (un cc5) (fd cc5) (pd cc5) (fs cc5)))))
			))
		)
		(and
			(exists ((dc1 DependeeLinkConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_SOFTGOAL) (= ((as src (SoftGoalConcretization)) dc1) c) (fs dc1)))
			(not (exists ((dc2 DependeeLinkConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_SOFTGOAL) (= ((as src (SoftGoalConcretization)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (n dc2) (ps dc2)))))
		)
	)
	true
	false
)))))
(assert (forall ((c SoftGoalConcretization)) (=> (and (not (inited c)) (or (co c) (un c) (fd c) (pd c) (fs c))) (= (ps c) false))))
(assert (forall ((c SoftGoalConcretization)) (=> (and (not (inited c)) (not (co c)) (not (un c)) (not (fd c)) (not (pd c)) (not (fs c))) (= (ps c) (ite
	(or
		(and
			(exists ((cc1 ContributionConcretization)) (and (= (tgt cc1) c) (ps cc1)))
			(not (exists ((cc2 ContributionConcretization)) (and (= (tgt cc2) c) (or (co cc2) (un cc2) (fd cc2) (pd cc2) (fs cc2)))))
			(not (exists ((dc DependerLinkConcretization)) (and (= (srcEndpoint dc) ENDPOINT_SOFTGOAL) (= ((as src (SoftGoalConcretization)) dc) c) (or (fd dc) (pd dc) (co dc) (un dc) (n dc)))))
		)
		(and
			(exists ((dc1 DependerLinkConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_SOFTGOAL) (= ((as src (SoftGoalConcretization)) dc1) c) (ps dc1)))
			(not (exists ((dc2 DependerLinkConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_SOFTGOAL) (= ((as src (SoftGoalConcretization)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (n dc2)))))
			;not exists fd|pd|co|co_|un
			(not (exists ((cc1 ContributionConcretization)) (and (= (tgt cc1) c) (or (co cc1) (un cc1) (fd cc1) (pd cc1)))))
			;not exists n
			(not (and
				(exists ((cc2 ContributionConcretization)) (and (= (tgt cc2) c) (n cc2)))
				(not (exists ((cc3 ContributionConcretization)) (and (= (tgt cc3) c) (or (co cc3) (un cc3) (fd cc3) (pd cc3) (fs cc3) (ps cc3)))))
			))
		)
		(and
			(exists ((dc1 DependeeLinkConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_SOFTGOAL) (= ((as src (SoftGoalConcretization)) dc1) c) (ps dc1)))
			(not (exists ((dc2 DependeeLinkConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_SOFTGOAL) (= ((as src (SoftGoalConcretization)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (n dc2)))))
		)
	)
	true
	false
)))))
(assert (forall ((c SoftGoalConcretization)) (=> (and (not (inited c)) (or (co c) (un c) (fd c) (pd c) (fs c) (ps c))) (= (n c) false))))
(assert (forall ((c SoftGoalConcretization)) (=> (and (not (inited c)) (not (co c)) (not (un c)) (not (fd c)) (not (pd c)) (not (fs c)) (not (ps c))) (= (n c) true))))
;(assert (forall ((c SoftGoalConcretization)) (=> (and (not (inited c)) (not (co c)) (not (un c)) (not (fd c)) (not (pd c)) (not (fs c)) (not (ps c))) (= (n c) (ite
;	(or
;		(and
;			(not (exists ((cc ContributionConcretization)) (= (tgt cc) c)))
;			(not (exists ((dc1 DependerLinkConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_SOFTGOAL) (= ((as src (SoftGoalConcretization)) dc1) c))))
;			(not (exists ((dc2 DependeeLinkConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_SOFTGOAL) (= ((as src (SoftGoalConcretization)) dc2) c))))
;		)
;		(and
;			(exists ((cc1 ContributionConcretization)) (and (= (tgt cc1) c) (n cc1)))
;			(not (exists ((cc2 ContributionConcretization)) (and (= (tgt cc2) c) (or (co cc2) (un cc2) (fd cc2) (pd cc2) (fs cc2) (ps cc2)))))
;			(not (exists ((dc DependerLinkConcretization)) (and (= (srcEndpoint dc) ENDPOINT_SOFTGOAL) (= ((as src (SoftGoalConcretization)) dc) c) (or (fd dc) (pd dc) (co dc) (un dc)))))
;		)
;		(and
;			(exists ((dc1 DependerLinkConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_SOFTGOAL) (= ((as src (SoftGoalConcretization)) dc1) c) (n dc1)))
;			(not (exists ((dc2 DependerLinkConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_SOFTGOAL) (= ((as src (SoftGoalConcretization)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2)))))
;			;not exists fd|pd|co|co_|un
;			(not (exists ((cc1 ContributionConcretization)) (and (= (tgt cc1) c) (or (co cc1) (un cc1) (fd cc1) (pd cc1)))))
;		)
;		(and
;			(exists ((dc1 DependeeLinkConcretization)) (and (= (srcEndpoint dc1) ENDPOINT_SOFTGOAL) (= ((as src (SoftGoalConcretization)) dc1) c) (n dc1)))
;			(not (exists ((dc2 DependeeLinkConcretization)) (and (= (srcEndpoint dc2) ENDPOINT_SOFTGOAL) (= ((as src (SoftGoalConcretization)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2)))))
;		)
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
