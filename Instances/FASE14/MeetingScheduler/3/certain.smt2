
;Endpoint Types
(define-sort NodeType () Int)
(declare-const TASK NodeType)
(declare-const GOAL NodeType)
(declare-const SOFTGOAL NodeType)
(declare-const RESOURCE NodeType)
(assert (= TASK 1))
(assert (= GOAL 2))
(assert (= SOFTGOAL 3))
(assert (= RESOURCE 4))

;Contribution Types
(define-sort ContributionType () Int)
(declare-const MAKE ContributionType)
(declare-const HELP ContributionType)
(declare-const SOMEPLUS ContributionType)
(declare-const BREAK ContributionType)
(declare-const HURT ContributionType)
(declare-const SOMEMINUS ContributionType)
(declare-const UNKNOWN ContributionType)
(assert (= MAKE 11))
(assert (= HELP 12))
(assert (= SOMEPLUS 13))
(assert (= BREAK 14))
(assert (= HURT 15))
(assert (= SOMEMINUS 16))
(assert (= UNKNOWN 17))

;Model
(define-sort Node () Int)
(define-sort Edge () Int)

(declare-const MeetingInitiator Node)
(assert (= MeetingInitiator 101))
(declare-const MeetingScheduler Node)
(assert (= MeetingScheduler 102))
(declare-const MeetingParticipant Node)
(assert (= MeetingParticipant 103))
(declare-const OtherWaysToOrganizeMeeting Node)
(assert (= OtherWaysToOrganizeMeeting 104))
(declare-const LetSchedulerScheduleMeeting Node)
(assert (= LetSchedulerScheduleMeeting 105))
(declare-const OrganizeMeeting Node)
(assert (= OrganizeMeeting 106))
(declare-const DetermineMeetingDate Node)
(assert (= DetermineMeetingDate 107))
(declare-const ScheduleMeeting Node)
(assert (= ScheduleMeeting 108))
(declare-const ParticipateInMeeting Node)
(assert (= ParticipateInMeeting 109))
(declare-const AttendMeeting Node)
(assert (= AttendMeeting 110))
(declare-const ProvideDetails Node)
(assert (= ProvideDetails 111))
(declare-const DecideConvenientDates Node)
(assert (= DecideConvenientDates 112))
(declare-const UseProfiles Node)
(assert (= UseProfiles 113))

(declare-const MeetingBeScheduledMI Node)
(assert (= MeetingBeScheduledMI 114))
(declare-const AgreeableMeetingDate Node)
(assert (= AgreeableMeetingDate 115))
(declare-const ConvenientMeetingDate Node)
(assert (= ConvenientMeetingDate 116))
(declare-const Dependencies Node)
(assert (= Dependencies 117))
(declare-const MeetingBeScheduled Node)
(assert (= MeetingBeScheduled 118))

(declare-const Quick Node)
(assert (= Quick 119))
(declare-const LowEffortMI Node)
(assert (= LowEffortMI 120))
(declare-const LowEffortMP Node)
(assert (= LowEffortMP 121))

(declare-const Details Node)
(assert (= Details 122))

(declare-const MeetingInitiator2MeetingBeScheduledMI Edge)
(assert (= MeetingInitiator2MeetingBeScheduledMI 123))
(declare-const MeetingInitiator2OtherWaysToOrganizeMeeting Edge)
(assert (= MeetingInitiator2OtherWaysToOrganizeMeeting 124))
(declare-const MeetingInitiator2LetSchedulerScheduleMeeting Edge)
(assert (= MeetingInitiator2LetSchedulerScheduleMeeting 125))
(declare-const MeetingInitiator2OrganizeMeeting Edge)
(assert (= MeetingInitiator2OrganizeMeeting 126))
(declare-const MeetingInitiator2Quick Edge)
(assert (= MeetingInitiator2Quick 127))
(declare-const MeetingInitiator2LowEffortMI Edge)
(assert (= MeetingInitiator2LowEffortMI 128))
(declare-const MeetingInitiator2DetermineMeetingDate Edge)
(assert (= MeetingInitiator2DetermineMeetingDate 129))
(declare-const MeetingScheduler2ScheduleMeeting Edge)
(assert (= MeetingScheduler2ScheduleMeeting 130))
(declare-const MeetingParticipant2ParticipateInMeeting Edge)
(assert (= MeetingParticipant2ParticipateInMeeting 131))
(declare-const MeetingParticipant2AttendMeeting Edge)
(assert (= MeetingParticipant2AttendMeeting 132))
(declare-const MeetingParticipant2ProvideDetails Edge)
(assert (= MeetingParticipant2ProvideDetails 133))
(declare-const MeetingParticipant2AgreeableMeetingDate Edge)
(assert (= MeetingParticipant2AgreeableMeetingDate 134))
(declare-const MeetingParticipant2ConvenientMeetingDate Edge)
(assert (= MeetingParticipant2ConvenientMeetingDate 135))
(declare-const MeetingParticipant2DecideConvenientDates Edge)
(assert (= MeetingParticipant2DecideConvenientDates 136))
(declare-const MeetingParticipant2LowEffortMP Edge)
(assert (= MeetingParticipant2LowEffortMP 137))
(declare-const MeetingParticipant2UseProfiles Edge)
(assert (= MeetingParticipant2UseProfiles 138))
(declare-const OtherWaysToOrganizeMeeting2MeetingBeScheduledMI Edge)
(assert (= OtherWaysToOrganizeMeeting2MeetingBeScheduledMI 139))
(declare-const LetSchedulerScheduleMeeting2MeetingBeScheduledMI Edge)
(assert (= LetSchedulerScheduleMeeting2MeetingBeScheduledMI 140))
(declare-const DecideConvenientDates2ConvenientMeetingDate Edge)
(assert (= DecideConvenientDates2ConvenientMeetingDate 141))

(declare-const MeetingBeScheduledMI2OrganizeMeeting Edge)
(assert (= MeetingBeScheduledMI2OrganizeMeeting 142))
(declare-const Quick2OrganizeMeeting Edge)
(assert (= Quick2OrganizeMeeting 143))
(declare-const LowEffortMI2OrganizeMeeting Edge)
(assert (= LowEffortMI2OrganizeMeeting 144))
(declare-const DetermineMeetingDate2OrganizeMeeting Edge)
(assert (= DetermineMeetingDate2OrganizeMeeting 145))
(declare-const AttendMeeting2ParticipateInMeeting Edge)
(assert (= AttendMeeting2ParticipateInMeeting 146))
(declare-const ProvideDetails2ParticipateInMeeting Edge)
(assert (= ProvideDetails2ParticipateInMeeting 147))
(declare-const AgreeableMeetingDate2ParticipateInMeeting Edge)
(assert (= AgreeableMeetingDate2ParticipateInMeeting 148))
(declare-const ConvenientMeetingDate2ParticipateInMeeting Edge)
(assert (= ConvenientMeetingDate2ParticipateInMeeting 149))
(declare-const LowEffortMP2ProvideDetails Edge)
(assert (= LowEffortMP2ProvideDetails 150))
(declare-const UseProfiles2ParticipateInMeeting Edge)
(assert (= UseProfiles2ParticipateInMeeting 151))

(declare-const OtherWaysToOrganizeMeeting2Quick Edge)
(assert (= OtherWaysToOrganizeMeeting2Quick 152))
(declare-const OtherWaysToOrganizeMeeting2LowEffortMI Edge)
(assert (= OtherWaysToOrganizeMeeting2LowEffortMI 153))
(declare-const LetSchedulerScheduleMeeting2Quick Edge)
(assert (= LetSchedulerScheduleMeeting2Quick 154))
(declare-const LetSchedulerScheduleMeeting2LowEffortMI Edge)
(assert (= LetSchedulerScheduleMeeting2LowEffortMI 155))

(declare-const OrganizeMeeting2Dependencies Edge)
(assert (= OrganizeMeeting2Dependencies 156))
(declare-const LetSchedulerScheduleMeeting2MeetingBeScheduled Edge)
(assert (= LetSchedulerScheduleMeeting2MeetingBeScheduled 157))
(declare-const ScheduleMeeting2Details Edge)
(assert (= ScheduleMeeting2Details 158))
(declare-const Dependencies2ParticipateInMeeting Edge)
(assert (= Dependencies2ParticipateInMeeting 159))
(declare-const MeetingBeScheduled2ScheduleMeeting Edge)
(assert (= MeetingBeScheduled2ScheduleMeeting 160))
(declare-const Details2ProvideDetails Edge)
(assert (= Details2ProvideDetails 161))

;Concretizations
(declare-sort Actor)
(declare-sort Task)
(declare-sort Goal)
(declare-sort SoftGoal)
(declare-sort Resource)
(declare-sort Containment)
(declare-sort MeansEnd)
(declare-sort Decomposition)
(declare-sort Contribution)
(declare-sort DependerLink)
(declare-sort DependeeLink)
(declare-fun node (Node Actor) Bool)
(declare-fun node (Node Task) Bool)
(declare-fun node (Node Goal) Bool)
(declare-fun node (Node SoftGoal) Bool)
(declare-fun node (Node Resource) Bool)
(declare-fun edge (Edge Containment) Bool)
(declare-fun tgtType (Containment) NodeType)
(declare-fun src (Containment) Actor)
(declare-fun tgt (Containment) Task)
(declare-fun tgt (Containment) Goal)
(declare-fun tgt (Containment) SoftGoal)
(declare-fun tgt (Containment) Resource)
(declare-fun edge (Edge MeansEnd) Bool)
(declare-fun src (MeansEnd) Task)
(declare-fun tgt (MeansEnd) Goal)
(declare-fun edge (Edge Decomposition) Bool)
(declare-fun srcType (Decomposition) NodeType)
(declare-fun src (Decomposition) Task)
(declare-fun src (Decomposition) Goal)
(declare-fun src (Decomposition) SoftGoal)
(declare-fun src (Decomposition) Resource)
(declare-fun tgt (Decomposition) Task)
(declare-fun edge (Edge Contribution) Bool)
(declare-fun srcType (Contribution) NodeType)
(declare-fun type (Contribution) ContributionType)
(declare-fun src (Contribution) Task)
(declare-fun src (Contribution) Goal)
(declare-fun src (Contribution) SoftGoal)
(declare-fun src (Contribution) Resource)
(declare-fun tgt (Contribution) SoftGoal)
(declare-fun edge (Edge DependerLink) Bool)
(declare-fun srcType (DependerLink) NodeType)
(declare-fun tgtType (DependerLink) NodeType)
(declare-fun src (DependerLink) Task)
(declare-fun src (DependerLink) Goal)
(declare-fun src (DependerLink) SoftGoal)
(declare-fun src (DependerLink) Resource)
(declare-fun tgt (DependerLink) Task)
(declare-fun tgt (DependerLink) Goal)
(declare-fun tgt (DependerLink) SoftGoal)
(declare-fun tgt (DependerLink) Resource)
(declare-fun edge (Edge DependeeLink) Bool)
(declare-fun srcType (DependeeLink) NodeType)
(declare-fun tgtType (DependeeLink) NodeType)
(declare-fun src (DependeeLink) Task)
(declare-fun src (DependeeLink) Goal)
(declare-fun src (DependeeLink) SoftGoal)
(declare-fun src (DependeeLink) Resource)
(declare-fun tgt (DependeeLink) Task)
(declare-fun tgt (DependeeLink) Goal)
(declare-fun tgt (DependeeLink) SoftGoal)
(declare-fun tgt (DependeeLink) Resource)

;Analysis labels
(declare-fun inited (Task) Bool)
(declare-fun inited (Goal) Bool)
(declare-fun inited (SoftGoal) Bool)
(declare-fun inited (Resource) Bool)
(declare-fun fsSrc (Contribution) Bool)
(declare-fun psSrc (Contribution) Bool)
(declare-fun unSrc (Contribution) Bool)
(declare-fun coSrc (Contribution) Bool)
(declare-fun pdSrc (Contribution) Bool)
(declare-fun fdSrc (Contribution) Bool)
(declare-fun fs (Task) Bool)
(declare-fun fs (Goal) Bool)
(declare-fun fs (SoftGoal) Bool)
(declare-fun fs (Resource) Bool)
(declare-fun fs (MeansEnd) Bool)
(declare-fun fs (Decomposition) Bool)
(declare-fun fs (Contribution) Bool)
(declare-fun fs (DependerLink) Bool)
(declare-fun fs (DependeeLink) Bool)
(declare-fun ps (Task) Bool)
(declare-fun ps (Goal) Bool)
(declare-fun ps (SoftGoal) Bool)
(declare-fun ps (Resource) Bool)
(declare-fun ps (MeansEnd) Bool)
(declare-fun ps (Decomposition) Bool)
(declare-fun ps (Contribution) Bool)
(declare-fun ps (DependerLink) Bool)
(declare-fun ps (DependeeLink) Bool)
(declare-fun un (Task) Bool)
(declare-fun un (Goal) Bool)
(declare-fun un (SoftGoal) Bool)
(declare-fun un (Resource) Bool)
(declare-fun un (MeansEnd) Bool)
(declare-fun un (Decomposition) Bool)
(declare-fun un (Contribution) Bool)
(declare-fun un (DependerLink) Bool)
(declare-fun un (DependeeLink) Bool)
(declare-fun co (Task) Bool)
(declare-fun co (Goal) Bool)
(declare-fun co (SoftGoal) Bool)
(declare-fun co (Resource) Bool)
(declare-fun co (MeansEnd) Bool)
(declare-fun co (Decomposition) Bool)
(declare-fun co (Contribution) Bool)
(declare-fun co (DependerLink) Bool)
(declare-fun co (DependeeLink) Bool)
(declare-fun pd (Task) Bool)
(declare-fun pd (Goal) Bool)
(declare-fun pd (SoftGoal) Bool)
(declare-fun pd (Resource) Bool)
(declare-fun pd (MeansEnd) Bool)
(declare-fun pd (Decomposition) Bool)
(declare-fun pd (Contribution) Bool)
(declare-fun pd (DependerLink) Bool)
(declare-fun pd (DependeeLink) Bool)
(declare-fun fd (Task) Bool)
(declare-fun fd (Goal) Bool)
(declare-fun fd (SoftGoal) Bool)
(declare-fun fd (Resource) Bool)
(declare-fun fd (MeansEnd) Bool)
(declare-fun fd (Decomposition) Bool)
(declare-fun fd (Contribution) Bool)
(declare-fun fd (DependerLink) Bool)
(declare-fun fd (DependeeLink) Bool)
(assert (forall ((c MeansEnd)) (= (fs c) (fs (src c)))))
(assert (forall ((c MeansEnd)) (= (ps c) (ps (src c)))))
(assert (forall ((c MeansEnd)) (= (un c) (un (src c)))))
(assert (forall ((c MeansEnd)) (= (co c) (co (src c)))))
(assert (forall ((c MeansEnd)) (= (pd c) (pd (src c)))))
(assert (forall ((c MeansEnd)) (= (fd c) (fd (src c)))))
(assert (forall ((c Decomposition)) (= (fs c)
	(ite (= (srcType c) TASK)
		(fs ((as src (Task)) c))
		(ite (= (srcType c) GOAL)
			(fs ((as src (Goal)) c))
			(ite (= (srcType c) SOFTGOAL)
				(fs ((as src (SoftGoal)) c))
				(fs ((as src (Resource)) c))
			)
		)
	)
)))
(assert (forall ((c Decomposition)) (= (ps c)
	(ite (= (srcType c) TASK)
		(ps ((as src (Task)) c))
		(ite (= (srcType c) GOAL)
			(ps ((as src (Goal)) c))
			(ite (= (srcType c) SOFTGOAL)
				(ps ((as src (SoftGoal)) c))
				(ps ((as src (Resource)) c))
			)
		)
	)
)))
(assert (forall ((c Decomposition)) (= (un c)
	(ite (= (srcType c) TASK)
		(un ((as src (Task)) c))
		(ite (= (srcType c) GOAL)
			(un ((as src (Goal)) c))
			(ite (= (srcType c) SOFTGOAL)
				(un ((as src (SoftGoal)) c))
				(un ((as src (Resource)) c))
			)
		)
	)
)))
(assert (forall ((c Decomposition)) (= (co c)
	(ite (= (srcType c) TASK)
		(co ((as src (Task)) c))
		(ite (= (srcType c) GOAL)
			(co ((as src (Goal)) c))
			(ite (= (srcType c) SOFTGOAL)
				(co ((as src (SoftGoal)) c))
				(co ((as src (Resource)) c))
			)
		)
	)
)))
(assert (forall ((dc Decomposition)) (= (pd dc)
	(ite (= (srcType dc) TASK)
		(pd ((as src (Task)) dc))
		(ite (= (srcType dc) GOAL)
			(pd ((as src (Goal)) dc))
			(ite (= (srcType dc) SOFTGOAL)
				(pd ((as src (SoftGoal)) dc))
				(pd ((as src (Resource)) dc))
			)
		)
	)
)))
(assert (forall ((c Decomposition)) (= (fd c)
	(ite (= (srcType c) TASK)
		(fd ((as src (Task)) c))
		(ite (= (srcType c) GOAL)
			(fd ((as src (Goal)) c))
			(ite (= (srcType c) SOFTGOAL)
				(fd ((as src (SoftGoal)) c))
				(fd ((as src (Resource)) c))
			)
		)
	)
)))
(assert (forall ((c Contribution)) (= (fsSrc c)
	(ite (= (srcType c) TASK)
		(fs ((as src (Task)) c))
		(ite (= (srcType c) GOAL)
			(fs ((as src (Goal)) c))
			(ite (= (srcType c) SOFTGOAL)
				(fs ((as src (SoftGoal)) c))
				(fs ((as src (Resource)) c))
			)
		)
	)
)))
(assert (forall ((c Contribution)) (= (psSrc c)
	(ite (= (srcType c) TASK)
		(ps ((as src (Task)) c))
		(ite (= (srcType c) GOAL)
			(ps ((as src (Goal)) c))
			(ite (= (srcType c) SOFTGOAL)
				(ps ((as src (SoftGoal)) c))
				(ps ((as src (Resource)) c))
			)
		)
	)
)))
(assert (forall ((c Contribution)) (= (unSrc c)
	(ite (= (srcType c) TASK)
		(un ((as src (Task)) c))
		(ite (= (srcType c) GOAL)
			(un ((as src (Goal)) c))
			(ite (= (srcType c) SOFTGOAL)
				(un ((as src (SoftGoal)) c))
				(un ((as src (Resource)) c))
			)
		)
	)
)))
(assert (forall ((c Contribution)) (= (coSrc c)
	(ite (= (srcType c) TASK)
		(co ((as src (Task)) c))
		(ite (= (srcType c) GOAL)
			(co ((as src (Goal)) c))
			(ite (= (srcType c) SOFTGOAL)
				(co ((as src (SoftGoal)) c))
				(co ((as src (Resource)) c))
			)
		)
	)
)))
(assert (forall ((c Contribution)) (= (pdSrc c)
	(ite (= (srcType c) TASK)
		(pd ((as src (Task)) c))
		(ite (= (srcType c) GOAL)
			(pd ((as src (Goal)) c))
			(ite (= (srcType c) SOFTGOAL)
				(pd ((as src (SoftGoal)) c))
				(pd ((as src (Resource)) c))
			)
		)
	)
)))
(assert (forall ((c Contribution)) (= (fdSrc c)
	(ite (= (srcType c) TASK)
		(fd ((as src (Task)) c))
		(ite (= (srcType c) GOAL)
			(fd ((as src (Goal)) c))
			(ite (= (srcType c) SOFTGOAL)
				(fd ((as src (SoftGoal)) c))
				(fd ((as src (Resource)) c))
			)
		)
	)
)))
(assert (forall ((c Contribution)) (= (fs c)
	(ite (= (type c) MAKE)
		(ite (fsSrc c)
			true
			false
		)
		false
	)
)))
(assert (forall ((c Contribution)) (= (ps c)
	(ite (= (type c) MAKE)
		(ite (psSrc c)
			true
			false
		)
		(ite (or (= (type c) HELP) (= (type c) SOMEPLUS))
			(ite (or (fsSrc c) (psSrc c))
				true
				false
			)
			(ite (or (= (type c) BREAK) (= (type c) HURT) (= (type c) SOMEMINUS))
				(ite (or (pdSrc c) (fdSrc c))
					true
					false
				)
				false
			)
		)
	)
)))
(assert (forall ((c Contribution)) (= (un c)
	(ite (= (type c) UNKNOWN)
		true
		(ite (unSrc c)
			true
			false
		)
	)
)))
(assert (forall ((c Contribution)) (= (co c)
	(ite (= (type c) UNKNOWN)
		false
		(ite (coSrc c)
			true
			false
		)
	)
)))
(assert (forall ((c Contribution)) (= (pd c)
	(ite (= (type c) MAKE)
		(ite (pdSrc c)
			true
			false
		)
		(ite (or (= (type c) HELP) (= (type c) SOMEPLUS))
			(ite (or (pdSrc c) (fdSrc c))
				true
				false
			)
			(ite (= (type c) BREAK)
				(ite (psSrc c)
					true
					false
				)
				(ite (or (= (type c) HURT) (= (type c) SOMEMINUS))
					(ite (or (fsSrc c) (psSrc c))
						true
						false
					)
					false
				)
			)
		)
	)
)))
(assert (forall ((c Contribution)) (= (fd c)
	(ite (= (type c) MAKE)
		(ite (fdSrc c)
			true
			false
		)
		(ite (= (type c) BREAK)
			(ite (fsSrc c)
				true
				false
			)
			false
		)
	)
)))
(assert (forall ((c DependerLink)) (= (fs c)
	(ite (= (tgtType c) TASK)
		(fs ((as tgt (Task)) c))
		(ite (= (tgtType c) GOAL)
			(fs ((as tgt (Goal)) c))
			(ite (= (tgtType c) SOFTGOAL)
				(fs ((as tgt (SoftGoal)) c))
				(fs ((as tgt (Resource)) c))
			)
		)
	)
)))
(assert (forall ((c DependerLink)) (= (ps c)
	(ite (= (tgtType c) TASK)
		(ps ((as tgt (Task)) c))
		(ite (= (tgtType c) GOAL)
			(ps ((as tgt (Goal)) c))
			(ite (= (tgtType c) SOFTGOAL)
				(ps ((as tgt (SoftGoal)) c))
				(ps ((as tgt (Resource)) c))
			)
		)
	)
)))
(assert (forall ((c DependerLink)) (= (un c)
	(ite (= (tgtType c) TASK)
		(un ((as tgt (Task)) c))
		(ite (= (tgtType c) GOAL)
			(un ((as tgt (Goal)) c))
			(ite (= (tgtType c) SOFTGOAL)
				(un ((as tgt (SoftGoal)) c))
				(un ((as tgt (Resource)) c))
			)
		)
	)
)))
(assert (forall ((c DependerLink)) (= (co c)
	(ite (= (tgtType c) TASK)
		(co ((as tgt (Task)) c))
		(ite (= (tgtType c) GOAL)
			(co ((as tgt (Goal)) c))
			(ite (= (tgtType c) SOFTGOAL)
				(co ((as tgt (SoftGoal)) c))
				(co ((as tgt (Resource)) c))
			)
		)
	)
)))
(assert (forall ((c DependerLink)) (= (pd c)
	(ite (= (tgtType c) TASK)
		(pd ((as tgt (Task)) c))
		(ite (= (tgtType c) GOAL)
			(pd ((as tgt (Goal)) c))
			(ite (= (tgtType c) SOFTGOAL)
				(pd ((as tgt (SoftGoal)) c))
				(pd ((as tgt (Resource)) c))
			)
		)
	)
)))
(assert (forall ((c DependerLink)) (= (fd c)
	(ite (= (tgtType c) TASK)
		(fd ((as tgt (Task)) c))
		(ite (= (tgtType c) GOAL)
			(fd ((as tgt (Goal)) c))
			(ite (= (tgtType c) SOFTGOAL)
				(fd ((as tgt (SoftGoal)) c))
				(fd ((as tgt (Resource)) c))
			)
		)
	)
)))
(assert (forall ((c DependeeLink)) (= (fs c)
	(ite (= (tgtType c) TASK)
		(fs ((as tgt (Task)) c))
		(ite (= (tgtType c) GOAL)
			(fs ((as tgt (Goal)) c))
			(ite (= (tgtType c) SOFTGOAL)
				(fs ((as tgt (SoftGoal)) c))
				(fs ((as tgt (Resource)) c))
			)
		)
	)
)))
(assert (forall ((c DependeeLink)) (= (ps c)
	(ite (= (tgtType c) TASK)
		(ps ((as tgt (Task)) c))
		(ite (= (tgtType c) GOAL)
			(ps ((as tgt (Goal)) c))
			(ite (= (tgtType c) SOFTGOAL)
				(ps ((as tgt (SoftGoal)) c))
				(ps ((as tgt (Resource)) c))
			)
		)
	)
)))
(assert (forall ((c DependeeLink)) (= (un c)
	(ite (= (tgtType c) TASK)
		(un ((as tgt (Task)) c))
		(ite (= (tgtType c) GOAL)
			(un ((as tgt (Goal)) c))
			(ite (= (tgtType c) SOFTGOAL)
				(un ((as tgt (SoftGoal)) c))
				(un ((as tgt (Resource)) c))
			)
		)
	)
)))
(assert (forall ((c DependeeLink)) (= (co c)
	(ite (= (tgtType c) TASK)
		(co ((as tgt (Task)) c))
		(ite (= (tgtType c) GOAL)
			(co ((as tgt (Goal)) c))
			(ite (= (tgtType c) SOFTGOAL)
				(co ((as tgt (SoftGoal)) c))
				(co ((as tgt (Resource)) c))
			)
		)
	)
)))
(assert (forall ((c DependeeLink)) (= (pd c)
	(ite (= (tgtType c) TASK)
		(pd ((as tgt (Task)) c))
		(ite (= (tgtType c) GOAL)
			(pd ((as tgt (Goal)) c))
			(ite (= (tgtType c) SOFTGOAL)
				(pd ((as tgt (SoftGoal)) c))
				(pd ((as tgt (Resource)) c))
			)
		)
	)
)))
(assert (forall ((c DependeeLink)) (= (fd c)
	(ite (= (tgtType c) TASK)
		(fd ((as tgt (Task)) c))
		(ite (= (tgtType c) GOAL)
			(fd ((as tgt (Goal)) c))
			(ite (= (tgtType c) SOFTGOAL)
				(fd ((as tgt (SoftGoal)) c))
				(fd ((as tgt (Resource)) c))
			)
		)
	)
)))

;Uninitialized labels
(declare-fun n (Task) Bool)
(declare-fun n (Goal) Bool)
(declare-fun n (SoftGoal) Bool)
(declare-fun n (Resource) Bool)
(declare-fun n (MeansEnd) Bool)
(declare-fun n (Decomposition) Bool)
(declare-fun n (Contribution) Bool)
(declare-fun n (DependerLink) Bool)
(declare-fun n (DependeeLink) Bool)
(assert (forall ((c MeansEnd)) (= (n c) (n (src c)))))
(assert (forall ((c Decomposition)) (= (n c)
	(ite (= (srcType c) TASK)
		(n ((as src (Task)) c))
		(ite (= (srcType c) GOAL)
			(n ((as src (Goal)) c))
			(ite (= (srcType c) SOFTGOAL)
				(n ((as src (SoftGoal)) c))
				(n ((as src (Resource)) c))
			)
		)
	)
)))
(assert (forall ((c Contribution)) (= (n c)
	(ite (= (srcType c) TASK)
		(n ((as src (Task)) c))
		(ite (= (srcType c) GOAL)
			(n ((as src (Goal)) c))
			(ite (= (srcType c) SOFTGOAL)
				(n ((as src (SoftGoal)) c))
				(n ((as src (Resource)) c))
			)
		)
	)
)))
(assert (forall ((c DependerLink)) (= (n c)
	(ite (= (tgtType c) TASK)
		(n ((as tgt (Task)) c))
		(ite (= (tgtType c) GOAL)
			(n ((as tgt (Goal)) c))
			(ite (= (tgtType c) SOFTGOAL)
				(n ((as tgt (SoftGoal)) c))
				(n ((as tgt (Resource)) c))
			)
		)
	)
)))
(assert (forall ((c DependeeLink)) (= (n c)
	(ite (= (tgtType c) TASK)
		(n ((as tgt (Task)) c))
		(ite (= (tgtType c) GOAL)
			(n ((as tgt (Goal)) c))
			(ite (= (tgtType c) SOFTGOAL)
				(n ((as tgt (SoftGoal)) c))
				(n ((as tgt (Resource)) c))
			)
		)
	)
)))

;Only one analysis label
(assert (forall ((c Task)) (xor (fs c) (ps c) (un c) (co c) (pd c) (fd c) (n c))))
(assert (forall ((c Goal)) (xor (fs c) (ps c) (un c) (co c) (pd c) (fd c) (n c))))
(assert (forall ((c SoftGoal)) (xor (fs c) (ps c) (un c) (co c) (pd c) (fd c) (n c))))
(assert (forall ((c Resource)) (xor (fs c) (ps c) (un c) (co c) (pd c) (fd c) (n c))))

;No self-loops:
;;MeansEnd can't
;;Decomposition only from Task to Task
;;Contribution only from SoftGoal to SoftGoal
;;Depender and Dependee only if there are dependencies among dependums
(assert (forall ((c Decomposition)) (=>
	(= (srcType c) TASK)
	(not (= ((as src (Task)) c) (tgt c)))
)))
(assert (forall ((c Contribution)) (=>
	(= (srcType c) SOFTGOAL)
	(not (= ((as src (SoftGoal)) c) (tgt c)))
)))

;Complete Model
(assert	(forall ((c Actor)) (or
	(node MeetingInitiator c)
	(node MeetingScheduler c)
	(node MeetingParticipant c)
)))
;Tasks are Complete
(assert (forall ((c Task)) (or
	(node OtherWaysToOrganizeMeeting c)
	(node LetSchedulerScheduleMeeting c)
	(node OrganizeMeeting c)
	(node DetermineMeetingDate c)
	(node ScheduleMeeting c)
	(node ParticipateInMeeting c)
	(node AttendMeeting c)
	(node ProvideDetails c)
	(node DecideConvenientDates c)
	(node UseProfiles c)
)))
;Goals are Complete
(assert (forall ((c Goal)) (or
	(node MeetingBeScheduledMI c)
	(node AgreeableMeetingDate c)
	(node ConvenientMeetingDate c)
	(node Dependencies c)
	(node MeetingBeScheduled c)
)))
;SoftGoals are Complete
(assert (forall ((c SoftGoal)) (or
	(node Quick c)
	(node LowEffortMI c)
	(node LowEffortMP c)
)))
;Resources are Complete
(assert (forall ((c Resource)) (or
	(node Details c)
)))
(assert (forall ((c Containment)) (or
	(edge MeetingInitiator2MeetingBeScheduledMI c)
	(edge MeetingInitiator2OtherWaysToOrganizeMeeting c)
	(edge MeetingInitiator2LetSchedulerScheduleMeeting c)
	(edge MeetingInitiator2OrganizeMeeting c)
	(edge MeetingInitiator2Quick c)
	(edge MeetingInitiator2LowEffortMI c)
	(edge MeetingInitiator2DetermineMeetingDate c)
	(edge MeetingScheduler2ScheduleMeeting c)
	(edge MeetingParticipant2ParticipateInMeeting c)
	(edge MeetingParticipant2AttendMeeting c)
	(edge MeetingParticipant2ProvideDetails c)
	(edge MeetingParticipant2AgreeableMeetingDate c)
	(edge MeetingParticipant2ConvenientMeetingDate c)
	(edge MeetingParticipant2DecideConvenientDates c)
	(edge MeetingParticipant2LowEffortMP c)
	(edge MeetingParticipant2UseProfiles c)
)))
;MeansEnds are Complete
(assert (forall ((c MeansEnd)) (or
	(edge OtherWaysToOrganizeMeeting2MeetingBeScheduledMI c)
	(edge LetSchedulerScheduleMeeting2MeetingBeScheduledMI c)
	(edge DecideConvenientDates2ConvenientMeetingDate c)
)))
;Decompositions are Complete
(assert (forall ((c Decomposition)) (or
	(edge MeetingBeScheduledMI2OrganizeMeeting c)
	(edge Quick2OrganizeMeeting c)
	(edge LowEffortMI2OrganizeMeeting c)
	(edge DetermineMeetingDate2OrganizeMeeting c)
	(edge AttendMeeting2ParticipateInMeeting c)
	(edge ProvideDetails2ParticipateInMeeting c)
	(edge AgreeableMeetingDate2ParticipateInMeeting c)
	(edge ConvenientMeetingDate2ParticipateInMeeting c)
	(edge LowEffortMP2ProvideDetails c)
	(edge UseProfiles2ParticipateInMeeting c)
)))
;Contributions are Complete
(assert (forall ((c Contribution)) (or
	(edge OtherWaysToOrganizeMeeting2Quick c)
	(edge OtherWaysToOrganizeMeeting2LowEffortMI c)
	(edge LetSchedulerScheduleMeeting2Quick c)
	(edge LetSchedulerScheduleMeeting2LowEffortMI c)
)))
(assert (forall ((c DependerLink)) (or
	(edge OrganizeMeeting2Dependencies c)
	(edge LetSchedulerScheduleMeeting2MeetingBeScheduled c)
	(edge ScheduleMeeting2Details c)
)))
(assert (forall ((c DependeeLink)) (or
	(edge Dependencies2ParticipateInMeeting c)
	(edge MeetingBeScheduled2ScheduleMeeting c)
	(edge Details2ProvideDetails c)
)))

;Model Elements
;MeetingInitiator Exists
(assert	(exists ((c Actor)) (node MeetingInitiator c)))
;MeetingInitiator is Unique
(assert	(forall ((c1 Actor) (c2 Actor)) (=>
	(and (node MeetingInitiator c1) (node MeetingInitiator c2))
	(= c1 c2)
)))
;MeetingInitiator is Distinct
(assert	(forall ((c Actor)) (=>
	(node MeetingInitiator c)
	(not (or
		(node MeetingScheduler c)
		(node MeetingParticipant c)
	))
)))
;MeetingScheduler Exists
(assert	(exists ((c Actor)) (node MeetingScheduler c)))
;MeetingScheduler is Unique
(assert	(forall ((c1 Actor) (c2 Actor)) (=>
	(and (node MeetingScheduler c1) (node MeetingScheduler c2))
	(= c1 c2)
)))
;MeetingScheduler is Distinct
(assert	(forall ((c Actor)) (=>
	(node MeetingScheduler c)
	(not (or
		(node MeetingInitiator c)
		(node MeetingParticipant c)
	))
)))
;MeetingParticipant Exists
(assert	(exists ((c Actor)) (node MeetingParticipant c)))
;MeetingParticipant is Unique
(assert	(forall ((c1 Actor) (c2 Actor)) (=>
	(and (node MeetingParticipant c1) (node MeetingParticipant c2))
	(= c1 c2)
)))
;MeetingParticipant is Distinct
(assert	(forall ((c Actor)) (=>
	(node MeetingParticipant c)
	(not (or
		(node MeetingInitiator c)
		(node MeetingScheduler c)
	))
)))
;MeetingBeScheduledMI initial analysis tag
(assert (forall ((c Goal)) (=>
	(node MeetingBeScheduledMI c)
	(= (inited c) false)
)))
;MeetingBeScheduledMI Exists
(assert	(exists ((c Goal)) (node MeetingBeScheduledMI c)))
;MeetingBeScheduledMI is Unique
(assert	(forall ((c1 Goal) (c2 Goal)) (=>
	(and (node MeetingBeScheduledMI c1) (node MeetingBeScheduledMI c2))
	(= c1 c2)
)))
;MeetingBeScheduledMI is Distinct
(assert	(forall ((c Goal)) (=>
	(node MeetingBeScheduledMI c)
	(not (or
		(node AgreeableMeetingDate c)
		(node ConvenientMeetingDate c)
		(node Dependencies c)
		(node MeetingBeScheduled c)
	))
)))

;OtherWaysToOrganizeMeeting initial analysis tag
(assert (forall ((c Task)) (=>
	(node OtherWaysToOrganizeMeeting c)
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
;OtherWaysToOrganizeMeeting Exists
(assert	(exists ((c Task)) (node OtherWaysToOrganizeMeeting c)))
;OtherWaysToOrganizeMeeting is Unique
(assert	(forall ((c1 Task) (c2 Task)) (=>
	(and (node OtherWaysToOrganizeMeeting c1) (node OtherWaysToOrganizeMeeting c2))
	(= c1 c2)
)))
;OtherWaysToOrganizeMeeting is Distinct
(assert	(forall ((c Task)) (=>
	(node OtherWaysToOrganizeMeeting c)
	(not (or
		(node LetSchedulerScheduleMeeting c)
		(node OrganizeMeeting c)
		(node DetermineMeetingDate c)
		(node ScheduleMeeting c)
		(node ParticipateInMeeting c)
		(node AttendMeeting c)
		(node ProvideDetails c)
		(node DecideConvenientDates c)
		(node UseProfiles c)
	))
)))

;LetSchedulerScheduleMeeting initial analysis tag
(assert (forall ((c Task)) (=>
	(node LetSchedulerScheduleMeeting c)
	(= (inited c) false)
)))
;LetSchedulerScheduleMeeting Exists
(assert	(exists ((c Task)) (node LetSchedulerScheduleMeeting c)))
;LetSchedulerScheduleMeeting is Unique
(assert	(forall ((c1 Task) (c2 Task)) (=>
	(and (node LetSchedulerScheduleMeeting c1) (node LetSchedulerScheduleMeeting c2))
	(= c1 c2)
)))
;LetSchedulerScheduleMeeting is Distinct
(assert	(forall ((c Task)) (=>
	(node LetSchedulerScheduleMeeting c)
	(not (or
		(node OtherWaysToOrganizeMeeting c)
		(node OrganizeMeeting c)
		(node DetermineMeetingDate c)
		(node ScheduleMeeting c)
		(node ParticipateInMeeting c)
		(node AttendMeeting c)
		(node ProvideDetails c)
		(node DecideConvenientDates c)
		(node UseProfiles c)
	))
)))

;OrganizeMeeting initial analysis tag
(assert (forall ((c Task)) (=>
	(node OrganizeMeeting c)
	(= (inited c) false)
)))
;OrganizeMeeting Exists
(assert	(exists ((c Task)) (node OrganizeMeeting c)))
;OrganizeMeeting is Unique
(assert	(forall ((c1 Task) (c2 Task)) (=>
	(and (node OrganizeMeeting c1) (node OrganizeMeeting c2))
	(= c1 c2)
)))
;OrganizeMeeting is Distinct
(assert	(forall ((c Task)) (=>
	(node OrganizeMeeting c)
	(not (or
		(node OtherWaysToOrganizeMeeting c)
		(node LetSchedulerScheduleMeeting c)
		(node DetermineMeetingDate c)
		(node ScheduleMeeting c)
		(node ParticipateInMeeting c)
		(node AttendMeeting c)
		(node ProvideDetails c)
		(node DecideConvenientDates c)
		(node UseProfiles c)
	))
)))

;Quick initial analysis tag
(assert (forall ((c SoftGoal)) (=>
	(node Quick c)
	(= (inited c) false)
)))
;Quick Exists
(assert	(exists ((c SoftGoal)) (node Quick c)))
;Quick is Unique
(assert	(forall ((c1 SoftGoal) (c2 SoftGoal)) (=>
	(and (node Quick c1) (node Quick c2))
	(= c1 c2)
)))
;Quick is Distinct
(assert	(forall ((c SoftGoal)) (=>
	(node Quick c)
	(not (or
		(node LowEffortMI c)
		(node LowEffortMP c)
	))
)))

;LowEffortMI initial analysis tag
(assert (forall ((c SoftGoal)) (=>
	(node LowEffortMI c)
	(= (inited c) false)
)))
;LowEffortMI Exists
(assert	(exists ((c SoftGoal)) (node LowEffortMI c)))
;LowEffortMI is Unique
(assert	(forall ((c1 SoftGoal) (c2 SoftGoal)) (=>
	(and (node LowEffortMI c1) (node LowEffortMI c2))
	(= c1 c2)
)))
;LowEffortMI is Distinct
(assert	(forall ((c SoftGoal)) (=>
	(node LowEffortMI c)
	(not (or
		(node Quick c)
		(node LowEffortMP c)
	))
)))

;DetermineMeetingDate initial analysis tag
(assert (forall ((c Task)) (=>
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
(assert	(exists ((c Task)) (node DetermineMeetingDate c)))
;DetermineMeetingDate is Unique
(assert	(forall ((c1 Task) (c2 Task)) (=>
	(and (node DetermineMeetingDate c1) (node DetermineMeetingDate c2))
	(= c1 c2)
)))
;DetermineMeetingDate is Distinct
(assert	(forall ((c Task)) (=>
	(node DetermineMeetingDate c)
	(not (or
		(node OtherWaysToOrganizeMeeting c)
		(node LetSchedulerScheduleMeeting c)
		(node OrganizeMeeting c)
		(node ScheduleMeeting c)
		(node ParticipateInMeeting c)
		(node AttendMeeting c)
		(node ProvideDetails c)
		(node DecideConvenientDates c)
		(node UseProfiles c)
	))
)))

;ScheduleMeeting initial analysis tag
(assert (forall ((c Task)) (=>
	(node ScheduleMeeting c)
	(= (inited c) false)
)))
;ScheduleMeeting Exists
(assert	(exists ((c Task)) (node ScheduleMeeting c)))
;ScheduleMeeting is Unique
(assert	(forall ((c1 Task) (c2 Task)) (=>
	(and (node ScheduleMeeting c1) (node ScheduleMeeting c2))
	(= c1 c2)
)))
;ScheduleMeeting is Distinct
(assert	(forall ((c Task)) (=>
	(node ScheduleMeeting c)
	(not (or
		(node OtherWaysToOrganizeMeeting c)
		(node LetSchedulerScheduleMeeting c)
		(node OrganizeMeeting c)
		(node DetermineMeetingDate c)
		(node ParticipateInMeeting c)
		(node AttendMeeting c)
		(node ProvideDetails c)
		(node DecideConvenientDates c)
		(node UseProfiles c)
	))
)))

;ParticipateInMeeting initial analysis tag
(assert (forall ((c Task)) (=>
	(node ParticipateInMeeting c)
	(= (inited c) false)
)))
;ParticipateInMeeting Exists
(assert	(exists ((c Task)) (node ParticipateInMeeting c)))
;ParticipateInMeeting is Unique
(assert	(forall ((c1 Task) (c2 Task)) (=>
	(and (node ParticipateInMeeting c1) (node ParticipateInMeeting c2))
	(= c1 c2)
)))
;ParticipateInMeeting is Distinct
(assert	(forall ((c Task)) (=>
	(node ParticipateInMeeting c)
	(not (or
		(node OtherWaysToOrganizeMeeting c)
		(node LetSchedulerScheduleMeeting c)
		(node OrganizeMeeting c)
		(node DetermineMeetingDate c)
		(node ScheduleMeeting c)
		(node AttendMeeting c)
		(node ProvideDetails c)
		(node DecideConvenientDates c)
		(node UseProfiles c)
	))
)))

;AttendMeeting initial analysis tag
(assert (forall ((c Task)) (=>
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
(assert	(exists ((c Task)) (node AttendMeeting c)))
;AttendMeeting is Unique
(assert	(forall ((c1 Task) (c2 Task)) (=>
	(and (node AttendMeeting c1) (node AttendMeeting c2))
	(= c1 c2)
)))
;AttendMeeting is Distinct
(assert	(forall ((c Task)) (=>
	(node AttendMeeting c)
	(not (or
		(node OtherWaysToOrganizeMeeting c)
		(node LetSchedulerScheduleMeeting c)
		(node OrganizeMeeting c)
		(node DetermineMeetingDate c)
		(node ScheduleMeeting c)
		(node ParticipateInMeeting c)
		(node ProvideDetails c)
		(node DecideConvenientDates c)
		(node UseProfiles c)
	))
)))

;ProvideDetails initial analysis tag
(assert (forall ((c Task)) (=>
	(node ProvideDetails c)
	(= (inited c) false)
)))
;ProvideDetails Exists
(assert	(exists ((c Task)) (node ProvideDetails c)))
;ProvideDetails is Unique
(assert	(forall ((c1 Task) (c2 Task)) (=>
	(and (node ProvideDetails c1) (node ProvideDetails c2))
	(= c1 c2)
)))
;ProvideDetails is Distinct
(assert	(forall ((c Task)) (=>
	(node ProvideDetails c)
	(not (or
		(node OtherWaysToOrganizeMeeting c)
		(node LetSchedulerScheduleMeeting c)
		(node OrganizeMeeting c)
		(node DetermineMeetingDate c)
		(node ScheduleMeeting c)
		(node ParticipateInMeeting c)
		(node AttendMeeting c)
		(node DecideConvenientDates c)
		(node UseProfiles c)
	))
)))

;AgreeableMeetingDate initial analysis tag
(assert (forall ((c Goal)) (=>
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
(assert	(exists ((c Goal)) (node AgreeableMeetingDate c)))
;AgreeableMeetingDate is Unique
(assert	(forall ((c1 Goal) (c2 Goal)) (=>
	(and (node AgreeableMeetingDate c1) (node AgreeableMeetingDate c2))
	(= c1 c2)
)))
;AgreeableMeetingDate is Distinct
(assert	(forall ((c Goal)) (=>
	(node AgreeableMeetingDate c)
	(not (or
		(node MeetingBeScheduledMI c)
		(node ConvenientMeetingDate c)
		(node Dependencies c)
		(node MeetingBeScheduled c)
	))
)))

;ConvenientMeetingDate initial analysis tag
(assert (forall ((c Goal)) (=>
	(node ConvenientMeetingDate c)
	(= (inited c) false)
)))
;ConvenientMeetingDate Exists
(assert	(exists ((c Goal)) (node ConvenientMeetingDate c)))
;ConvenientMeetingDate is Unique
(assert	(forall ((c1 Goal) (c2 Goal)) (=>
	(and (node ConvenientMeetingDate c1) (node ConvenientMeetingDate c2))
	(= c1 c2)
)))
;ConvenientMeetingDate is Distinct
(assert	(forall ((c Goal)) (=>
	(node ConvenientMeetingDate c)
	(not (or
		(node MeetingBeScheduledMI c)
		(node AgreeableMeetingDate c)
		(node Dependencies c)
		(node MeetingBeScheduled c)
	))
)))

;DecideConvenientDates initial analysis tag
(assert (forall ((c Task)) (=>
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
;DecideConvenientDates Exists
(assert	(exists ((c Task)) (node DecideConvenientDates c)))
;DecideConvenientDates is Unique
(assert	(forall ((c1 Task) (c2 Task)) (=>
	(and (node DecideConvenientDates c1) (node DecideConvenientDates c2))
	(= c1 c2)
)))
;DecideConvenientDates is Distinct
(assert	(forall ((c Task)) (=>
	(node DecideConvenientDates c)
	(not (or
		(node OtherWaysToOrganizeMeeting c)
		(node LetSchedulerScheduleMeeting c)
		(node OrganizeMeeting c)
		(node DetermineMeetingDate c)
		(node ScheduleMeeting c)
		(node ParticipateInMeeting c)
		(node AttendMeeting c)
		(node ProvideDetails c)
		(node UseProfiles c)
	))
)))

;LowEffortMP initial analysis tag
(assert (forall ((c SoftGoal)) (=>
	(node LowEffortMP c)
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
;LowEffortMP Exists
(assert	(exists ((c SoftGoal)) (node LowEffortMP c)))
;LowEffortMP is Unique
(assert	(forall ((c1 SoftGoal) (c2 SoftGoal)) (=>
	(and (node LowEffortMP c1) (node LowEffortMP c2))
	(= c1 c2)
)))
;LowEffortMP is Distinct
(assert	(forall ((c SoftGoal)) (=>
	(node LowEffortMP c)
	(not (or
		(node Quick c)
		(node LowEffortMI c)
	))
)))

;UseProfiles initial analysis tag
(assert (forall ((c Task)) (=>
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
;UseProfiles Exists
(assert	(exists ((c Task)) (node UseProfiles c)))
;UseProfiles is Unique
(assert	(forall ((c1 Task) (c2 Task)) (=>
	(and (node UseProfiles c1) (node UseProfiles c2))
	(= c1 c2)
)))
;UseProfiles is Distinct
(assert	(forall ((c Task)) (=>
	(node UseProfiles c)
	(not (or
		(node OtherWaysToOrganizeMeeting c)
		(node LetSchedulerScheduleMeeting c)
		(node OrganizeMeeting c)
		(node DetermineMeetingDate c)
		(node ScheduleMeeting c)
		(node ParticipateInMeeting c)
		(node AttendMeeting c)
		(node ProvideDetails c)
		(node DecideConvenientDates c)
	))
)))

;Dependencies initial analysis tag
(assert (forall ((c Goal)) (=>
	(node Dependencies c)
	(= (inited c) false)
)))
;Dependencies Exists
(assert	(exists ((c Goal)) (node Dependencies c)))
;Dependencies is Unique
(assert	(forall ((c1 Goal) (c2 Goal)) (=>
	(and (node Dependencies c1) (node Dependencies c2))
	(= c1 c2)
)))
;Dependencies is Distinct
(assert	(forall ((c Goal)) (=>
	(node Dependencies c)
	(not (or
		(node MeetingBeScheduledMI c)
		(node AgreeableMeetingDate c)
		(node ConvenientMeetingDate c)
		(node MeetingBeScheduled c)
	))
)))

;MeetingBeScheduled initial analysis tag
(assert (forall ((c Goal)) (=>
	(node MeetingBeScheduled c)
	(= (inited c) false)
)))
;MeetingBeScheduled Exists
(assert	(exists ((c Goal)) (node MeetingBeScheduled c)))
;MeetingBeScheduled is Unique
(assert	(forall ((c1 Goal) (c2 Goal)) (=>
	(and (node MeetingBeScheduled c1) (node MeetingBeScheduled c2))
	(= c1 c2)
)))
;MeetingBeScheduled is Distinct
(assert	(forall ((c Goal)) (=>
	(node MeetingBeScheduled c)
	(not (or
		(node MeetingBeScheduledMI c)
		(node AgreeableMeetingDate c)
		(node ConvenientMeetingDate c)
		(node Dependencies c)
	))
)))

;Details initial analysis tag
(assert (forall ((c Resource)) (=>
	(node Details c)
	(= (inited c) false)
)))
;Details Exists
(assert	(exists ((c Resource)) (node Details c)))
;Details is Unique
(assert	(forall ((c1 Resource) (c2 Resource)) (=>
	(and (node Details c1) (node Details c2))
	(= c1 c2)
)))

;MeetingInitiator2MeetingBeScheduledMI tgtType constant
(assert (forall ((c Containment)) (=>
	(edge MeetingInitiator2MeetingBeScheduledMI c)
	(= (tgtType c) GOAL)
)))
;MeetingInitiator2MeetingBeScheduledMI endpoints
(assert (forall ((c Containment)) (=>
	(edge MeetingInitiator2MeetingBeScheduledMI c)
	(and
		(node MeetingInitiator (src c))
		(node MeetingBeScheduledMI ((as tgt (Goal)) c))
	)
)))
;MeetingInitiator2MeetingBeScheduledMI Exists
(assert	(exists ((c Containment)) (edge MeetingInitiator2MeetingBeScheduledMI c)))
;MeetingInitiator2MeetingBeScheduledMI is Unique
(assert	(forall ((c1 Containment) (c2 Containment)) (=>
	(and (edge MeetingInitiator2MeetingBeScheduledMI c1) (edge MeetingInitiator2MeetingBeScheduledMI c2))
	(= c1 c2)
)))
;MeetingInitiator2MeetingBeScheduledMI is Distinct
(assert	(forall ((c Containment)) (=>
	(edge MeetingInitiator2MeetingBeScheduledMI c)
	(not (or
		(edge MeetingParticipant2AgreeableMeetingDate c)
		(edge MeetingParticipant2ConvenientMeetingDate c)
	))
)))
;MeetingInitiator2OtherWaysToOrganizeMeeting tgtType constant
(assert (forall ((c Containment)) (=>
	(edge MeetingInitiator2OtherWaysToOrganizeMeeting c)
	(= (tgtType c) TASK)
)))
;MeetingInitiator2OtherWaysToOrganizeMeeting endpoints
(assert (forall ((c Containment)) (=>
	(edge MeetingInitiator2OtherWaysToOrganizeMeeting c)
	(and
		(node MeetingInitiator (src c))
		(node OtherWaysToOrganizeMeeting ((as tgt (Task)) c))
	)
)))
;MeetingInitiator2OtherWaysToOrganizeMeeting Exists
(assert	(exists ((c Containment)) (edge MeetingInitiator2OtherWaysToOrganizeMeeting c)))
;MeetingInitiator2OtherWaysToOrganizeMeeting is Unique
(assert	(forall ((c1 Containment) (c2 Containment)) (=>
	(and (edge MeetingInitiator2OtherWaysToOrganizeMeeting c1) (edge MeetingInitiator2OtherWaysToOrganizeMeeting c2))
	(= c1 c2)
)))
;MeetingInitiator2OtherWaysToOrganizeMeeting is Distinct
(assert	(forall ((c Containment)) (=>
	(edge MeetingInitiator2OtherWaysToOrganizeMeeting c)
	(not (or
		(edge MeetingInitiator2LetSchedulerScheduleMeeting c)
		(edge MeetingInitiator2OrganizeMeeting c)
		(edge MeetingInitiator2DetermineMeetingDate c)
		(edge MeetingScheduler2ScheduleMeeting c)
		(edge MeetingParticipant2ParticipateInMeeting c)
		(edge MeetingParticipant2AttendMeeting c)
		(edge MeetingParticipant2ProvideDetails c)
		(edge MeetingParticipant2DecideConvenientDates c)
		(edge MeetingParticipant2UseProfiles c)
	))
)))
;MeetingInitiator2LetSchedulerScheduleMeeting tgtType constant
(assert (forall ((c Containment)) (=>
	(edge MeetingInitiator2LetSchedulerScheduleMeeting c)
	(= (tgtType c) TASK)
)))
;MeetingInitiator2LetSchedulerScheduleMeeting endpoints
(assert (forall ((c Containment)) (=>
	(edge MeetingInitiator2LetSchedulerScheduleMeeting c)
	(and
		(node MeetingInitiator (src c))
		(node LetSchedulerScheduleMeeting ((as tgt (Task)) c))
	)
)))
;MeetingInitiator2LetSchedulerScheduleMeeting Exists
(assert	(exists ((c Containment)) (edge MeetingInitiator2LetSchedulerScheduleMeeting c)))
;MeetingInitiator2LetSchedulerScheduleMeeting is Unique
(assert	(forall ((c1 Containment) (c2 Containment)) (=>
	(and (edge MeetingInitiator2LetSchedulerScheduleMeeting c1) (edge MeetingInitiator2LetSchedulerScheduleMeeting c2))
	(= c1 c2)
)))
;MeetingInitiator2LetSchedulerScheduleMeeting is Distinct
(assert	(forall ((c Containment)) (=>
	(edge MeetingInitiator2LetSchedulerScheduleMeeting c)
	(not (or
		(edge MeetingInitiator2OtherWaysToOrganizeMeeting c)
		(edge MeetingInitiator2OrganizeMeeting c)
		(edge MeetingInitiator2DetermineMeetingDate c)
		(edge MeetingScheduler2ScheduleMeeting c)
		(edge MeetingParticipant2ParticipateInMeeting c)
		(edge MeetingParticipant2AttendMeeting c)
		(edge MeetingParticipant2ProvideDetails c)
		(edge MeetingParticipant2DecideConvenientDates c)
		(edge MeetingParticipant2UseProfiles c)
	))
)))
;MeetingInitiator2OrganizeMeeting tgtType constant
(assert (forall ((c Containment)) (=>
	(edge MeetingInitiator2OrganizeMeeting c)
	(= (tgtType c) TASK)
)))
;MeetingInitiator2OrganizeMeeting endpoints
(assert (forall ((c Containment)) (=>
	(edge MeetingInitiator2OrganizeMeeting c)
	(and
		(node MeetingInitiator (src c))
		(node OrganizeMeeting ((as tgt (Task)) c))
	)
)))
;MeetingInitiator2OrganizeMeeting Exists
(assert	(exists ((c Containment)) (edge MeetingInitiator2OrganizeMeeting c)))
;MeetingInitiator2OrganizeMeeting is Unique
(assert	(forall ((c1 Containment) (c2 Containment)) (=>
	(and (edge MeetingInitiator2OrganizeMeeting c1) (edge MeetingInitiator2OrganizeMeeting c2))
	(= c1 c2)
)))
;MeetingInitiator2OrganizeMeeting is Distinct
(assert	(forall ((c Containment)) (=>
	(edge MeetingInitiator2OrganizeMeeting c)
	(not (or
		(edge MeetingInitiator2OtherWaysToOrganizeMeeting c)
		(edge MeetingInitiator2LetSchedulerScheduleMeeting c)
		(edge MeetingInitiator2DetermineMeetingDate c)
		(edge MeetingScheduler2ScheduleMeeting c)
		(edge MeetingParticipant2ParticipateInMeeting c)
		(edge MeetingParticipant2AttendMeeting c)
		(edge MeetingParticipant2ProvideDetails c)
		(edge MeetingParticipant2DecideConvenientDates c)
		(edge MeetingParticipant2UseProfiles c)
	))
)))
;MeetingInitiator2Quick tgtType constant
(assert (forall ((c Containment)) (=>
	(edge MeetingInitiator2Quick c)
	(= (tgtType c) SOFTGOAL)
)))
;MeetingInitiator2Quick endpoints
(assert (forall ((c Containment)) (=>
	(edge MeetingInitiator2Quick c)
	(and
		(node MeetingInitiator (src c))
		(node Quick ((as tgt (SoftGoal)) c))
	)
)))
;MeetingInitiator2Quick Exists
(assert	(exists ((c Containment)) (edge MeetingInitiator2Quick c)))
;MeetingInitiator2Quick is Unique
(assert	(forall ((c1 Containment) (c2 Containment)) (=>
	(and (edge MeetingInitiator2Quick c1) (edge MeetingInitiator2Quick c2))
	(= c1 c2)
)))
;MeetingInitiator2Quick is Distinct
(assert	(forall ((c Containment)) (=>
	(edge MeetingInitiator2Quick c)
	(not (or
		(edge MeetingInitiator2LowEffortMI c)
		(edge MeetingParticipant2LowEffortMP c)
	))
)))
;MeetingInitiator2LowEffortMI tgtType constant
(assert (forall ((c Containment)) (=>
	(edge MeetingInitiator2LowEffortMI c)
	(= (tgtType c) SOFTGOAL)
)))
;MeetingInitiator2LowEffortMI endpoints
(assert (forall ((c Containment)) (=>
	(edge MeetingInitiator2LowEffortMI c)
	(and
		(node MeetingInitiator (src c))
		(node LowEffortMI ((as tgt (SoftGoal)) c))
	)
)))
;MeetingInitiator2LowEffortMI Exists
(assert	(exists ((c Containment)) (edge MeetingInitiator2LowEffortMI c)))
;MeetingInitiator2LowEffortMI is Unique
(assert	(forall ((c1 Containment) (c2 Containment)) (=>
	(and (edge MeetingInitiator2LowEffortMI c1) (edge MeetingInitiator2LowEffortMI c2))
	(= c1 c2)
)))
;MeetingInitiator2LowEffortMI is Distinct
(assert	(forall ((c Containment)) (=>
	(edge MeetingInitiator2LowEffortMI c)
	(not (or
		(edge MeetingInitiator2Quick c)
		(edge MeetingParticipant2LowEffortMP c)
	))
)))
;MeetingInitiator2DetermineMeetingDate tgtType constant
(assert (forall ((c Containment)) (=>
	(edge MeetingInitiator2DetermineMeetingDate c)
	(= (tgtType c) TASK)
)))
;MeetingInitiator2DetermineMeetingDate endpoints
(assert (forall ((c Containment)) (=>
	(edge MeetingInitiator2DetermineMeetingDate c)
	(and
		(node MeetingInitiator (src c))
		(node DetermineMeetingDate ((as tgt (Task)) c))
	)
)))
;MeetingInitiator2DetermineMeetingDate Exists
(assert	(exists ((c Containment)) (edge MeetingInitiator2DetermineMeetingDate c)))
;MeetingInitiator2DetermineMeetingDate is Unique
(assert	(forall ((c1 Containment) (c2 Containment)) (=>
	(and (edge MeetingInitiator2DetermineMeetingDate c1) (edge MeetingInitiator2DetermineMeetingDate c2))
	(= c1 c2)
)))
;MeetingInitiator2DetermineMeetingDate is Distinct
(assert	(forall ((c Containment)) (=>
	(edge MeetingInitiator2DetermineMeetingDate c)
	(not (or
		(edge MeetingInitiator2OtherWaysToOrganizeMeeting c)
		(edge MeetingInitiator2LetSchedulerScheduleMeeting c)
		(edge MeetingInitiator2OrganizeMeeting c)
		(edge MeetingScheduler2ScheduleMeeting c)
		(edge MeetingParticipant2ParticipateInMeeting c)
		(edge MeetingParticipant2AttendMeeting c)
		(edge MeetingParticipant2ProvideDetails c)
		(edge MeetingParticipant2DecideConvenientDates c)
		(edge MeetingParticipant2UseProfiles c)
	))
)))
;MeetingScheduler2ScheduleMeeting tgtType constant
(assert (forall ((c Containment)) (=>
	(edge MeetingScheduler2ScheduleMeeting c)
	(= (tgtType c) TASK)
)))
;MeetingScheduler2ScheduleMeeting endpoints
(assert (forall ((c Containment)) (=>
	(edge MeetingScheduler2ScheduleMeeting c)
	(and
		(node MeetingScheduler (src c))
		(node ScheduleMeeting ((as tgt (Task)) c))
	)
)))
;MeetingScheduler2ScheduleMeeting Exists
(assert	(exists ((c Containment)) (edge MeetingScheduler2ScheduleMeeting c)))
;MeetingScheduler2ScheduleMeeting is Unique
(assert	(forall ((c1 Containment) (c2 Containment)) (=>
	(and (edge MeetingScheduler2ScheduleMeeting c1) (edge MeetingScheduler2ScheduleMeeting c2))
	(= c1 c2)
)))
;MeetingScheduler2ScheduleMeeting is Distinct
(assert	(forall ((c Containment)) (=>
	(edge MeetingScheduler2ScheduleMeeting c)
	(not (or
		(edge MeetingInitiator2OtherWaysToOrganizeMeeting c)
		(edge MeetingInitiator2LetSchedulerScheduleMeeting c)
		(edge MeetingInitiator2OrganizeMeeting c)
		(edge MeetingInitiator2DetermineMeetingDate c)
		(edge MeetingParticipant2ParticipateInMeeting c)
		(edge MeetingParticipant2AttendMeeting c)
		(edge MeetingParticipant2ProvideDetails c)
		(edge MeetingParticipant2DecideConvenientDates c)
		(edge MeetingParticipant2UseProfiles c)
	))
)))
;MeetingParticipant2ParticipateInMeeting tgtType constant
(assert (forall ((c Containment)) (=>
	(edge MeetingParticipant2ParticipateInMeeting c)
	(= (tgtType c) TASK)
)))
;MeetingParticipant2ParticipateInMeeting endpoints
(assert (forall ((c Containment)) (=>
	(edge MeetingParticipant2ParticipateInMeeting c)
	(and
		(node MeetingParticipant (src c))
		(node ParticipateInMeeting ((as tgt (Task)) c))
	)
)))
;MeetingParticipant2ParticipateInMeeting Exists
(assert	(exists ((c Containment)) (edge MeetingParticipant2ParticipateInMeeting c)))
;MeetingParticipant2ParticipateInMeeting is Unique
(assert	(forall ((c1 Containment) (c2 Containment)) (=>
	(and (edge MeetingParticipant2ParticipateInMeeting c1) (edge MeetingParticipant2ParticipateInMeeting c2))
	(= c1 c2)
)))
;MeetingParticipant2ParticipateInMeeting is Distinct
(assert	(forall ((c Containment)) (=>
	(edge MeetingParticipant2ParticipateInMeeting c)
	(not (or
		(edge MeetingInitiator2OtherWaysToOrganizeMeeting c)
		(edge MeetingInitiator2LetSchedulerScheduleMeeting c)
		(edge MeetingInitiator2OrganizeMeeting c)
		(edge MeetingInitiator2DetermineMeetingDate c)
		(edge MeetingScheduler2ScheduleMeeting c)
		(edge MeetingParticipant2AttendMeeting c)
		(edge MeetingParticipant2ProvideDetails c)
		(edge MeetingParticipant2DecideConvenientDates c)
		(edge MeetingParticipant2UseProfiles c)
	))
)))
;MeetingParticipant2AttendMeeting tgtType constant
(assert (forall ((c Containment)) (=>
	(edge MeetingParticipant2AttendMeeting c)
	(= (tgtType c) TASK)
)))
;MeetingParticipant2AttendMeeting endpoints
(assert (forall ((c Containment)) (=>
	(edge MeetingParticipant2AttendMeeting c)
	(and
		(node MeetingParticipant (src c))
		(node AttendMeeting ((as tgt (Task)) c))
	)
)))
;MeetingParticipant2AttendMeeting Exists
(assert	(exists ((c Containment)) (edge MeetingParticipant2AttendMeeting c)))
;MeetingParticipant2AttendMeeting is Unique
(assert	(forall ((c1 Containment) (c2 Containment)) (=>
	(and (edge MeetingParticipant2AttendMeeting c1) (edge MeetingParticipant2AttendMeeting c2))
	(= c1 c2)
)))
;MeetingParticipant2AttendMeeting is Distinct
(assert	(forall ((c Containment)) (=>
	(edge MeetingParticipant2AttendMeeting c)
	(not (or
		(edge MeetingInitiator2OtherWaysToOrganizeMeeting c)
		(edge MeetingInitiator2LetSchedulerScheduleMeeting c)
		(edge MeetingInitiator2OrganizeMeeting c)
		(edge MeetingInitiator2DetermineMeetingDate c)
		(edge MeetingScheduler2ScheduleMeeting c)
		(edge MeetingParticipant2ParticipateInMeeting c)
		(edge MeetingParticipant2ProvideDetails c)
		(edge MeetingParticipant2DecideConvenientDates c)
		(edge MeetingParticipant2UseProfiles c)
	))
)))
;MeetingParticipant2ProvideDetails tgtType constant
(assert (forall ((c Containment)) (=>
	(edge MeetingParticipant2ProvideDetails c)
	(= (tgtType c) TASK)
)))
;MeetingParticipant2ProvideDetails endpoints
(assert (forall ((c Containment)) (=>
	(edge MeetingParticipant2ProvideDetails c)
	(and
		(node MeetingParticipant (src c))
		(node ProvideDetails ((as tgt (Task)) c))
	)
)))
;MeetingParticipant2ProvideDetails Exists
(assert	(exists ((c Containment)) (edge MeetingParticipant2ProvideDetails c)))
;MeetingParticipant2ProvideDetails is Unique
(assert	(forall ((c1 Containment) (c2 Containment)) (=>
	(and (edge MeetingParticipant2ProvideDetails c1) (edge MeetingParticipant2ProvideDetails c2))
	(= c1 c2)
)))
;MeetingParticipant2ProvideDetails is Distinct
(assert	(forall ((c Containment)) (=>
	(edge MeetingParticipant2ProvideDetails c)
	(not (or
		(edge MeetingInitiator2OtherWaysToOrganizeMeeting c)
		(edge MeetingInitiator2LetSchedulerScheduleMeeting c)
		(edge MeetingInitiator2OrganizeMeeting c)
		(edge MeetingInitiator2DetermineMeetingDate c)
		(edge MeetingScheduler2ScheduleMeeting c)
		(edge MeetingParticipant2ParticipateInMeeting c)
		(edge MeetingParticipant2AttendMeeting c)
		(edge MeetingParticipant2DecideConvenientDates c)
		(edge MeetingParticipant2UseProfiles c)
	))
)))
;MeetingParticipant2AgreeableMeetingDate tgtType constant
(assert (forall ((c Containment)) (=>
	(edge MeetingParticipant2AgreeableMeetingDate c)
	(= (tgtType c) GOAL)
)))
;MeetingParticipant2AgreeableMeetingDate endpoints
(assert (forall ((c Containment)) (=>
	(edge MeetingParticipant2AgreeableMeetingDate c)
	(and
		(node MeetingParticipant (src c))
		(node AgreeableMeetingDate ((as tgt (Goal)) c))
	)
)))
;MeetingParticipant2AgreeableMeetingDate Exists
(assert	(exists ((c Containment)) (edge MeetingParticipant2AgreeableMeetingDate c)))
;MeetingParticipant2AgreeableMeetingDate is Unique
(assert	(forall ((c1 Containment) (c2 Containment)) (=>
	(and (edge MeetingParticipant2AgreeableMeetingDate c1) (edge MeetingParticipant2AgreeableMeetingDate c2))
	(= c1 c2)
)))
;MeetingParticipant2AgreeableMeetingDate is Distinct
(assert	(forall ((c Containment)) (=>
	(edge MeetingParticipant2AgreeableMeetingDate c)
	(not (or
		(edge MeetingInitiator2MeetingBeScheduledMI c)
		(edge MeetingParticipant2ConvenientMeetingDate c)
	))
)))
;MeetingParticipant2ConvenientMeetingDate tgtType constant
(assert (forall ((c Containment)) (=>
	(edge MeetingParticipant2ConvenientMeetingDate c)
	(= (tgtType c) GOAL)
)))
;MeetingParticipant2ConvenientMeetingDate endpoints
(assert (forall ((c Containment)) (=>
	(edge MeetingParticipant2ConvenientMeetingDate c)
	(and
		(node MeetingParticipant (src c))
		(node ConvenientMeetingDate ((as tgt (Goal)) c))
	)
)))
;MeetingParticipant2ConvenientMeetingDate Exists
(assert	(exists ((c Containment)) (edge MeetingParticipant2ConvenientMeetingDate c)))
;MeetingParticipant2ConvenientMeetingDate is Unique
(assert	(forall ((c1 Containment) (c2 Containment)) (=>
	(and (edge MeetingParticipant2ConvenientMeetingDate c1) (edge MeetingParticipant2ConvenientMeetingDate c2))
	(= c1 c2)
)))
;MeetingParticipant2ConvenientMeetingDate is Distinct
(assert	(forall ((c Containment)) (=>
	(edge MeetingParticipant2ConvenientMeetingDate c)
	(not (or
		(edge MeetingInitiator2MeetingBeScheduledMI c)
		(edge MeetingParticipant2AgreeableMeetingDate c)
	))
)))
;MeetingParticipant2DecideConvenientDates tgtType constant
(assert (forall ((c Containment)) (=>
	(edge MeetingParticipant2DecideConvenientDates c)
	(= (tgtType c) TASK)
)))
;MeetingParticipant2DecideConvenientDates endpoints
(assert (forall ((c Containment)) (=>
	(edge MeetingParticipant2DecideConvenientDates c)
	(and
		(node MeetingParticipant (src c))
		(node DecideConvenientDates ((as tgt (Task)) c))
	)
)))
;MeetingParticipant2DecideConvenientDates Exists
(assert	(exists ((c Containment)) (edge MeetingParticipant2DecideConvenientDates c)))
;MeetingParticipant2DecideConvenientDates is Unique
(assert	(forall ((c1 Containment) (c2 Containment)) (=>
	(and (edge MeetingParticipant2DecideConvenientDates c1) (edge MeetingParticipant2DecideConvenientDates c2))
	(= c1 c2)
)))
;MeetingParticipant2DecideConvenientDates is Distinct
(assert	(forall ((c Containment)) (=>
	(edge MeetingParticipant2DecideConvenientDates c)
	(not (or
		(edge MeetingInitiator2OtherWaysToOrganizeMeeting c)
		(edge MeetingInitiator2LetSchedulerScheduleMeeting c)
		(edge MeetingInitiator2OrganizeMeeting c)
		(edge MeetingInitiator2DetermineMeetingDate c)
		(edge MeetingScheduler2ScheduleMeeting c)
		(edge MeetingParticipant2ParticipateInMeeting c)
		(edge MeetingParticipant2AttendMeeting c)
		(edge MeetingParticipant2ProvideDetails c)
		(edge MeetingParticipant2UseProfiles c)
	))
)))
;MeetingParticipant2LowEffortMP tgtType constant
(assert (forall ((c Containment)) (=>
	(edge MeetingParticipant2LowEffortMP c)
	(= (tgtType c) SOFTGOAL)
)))
;MeetingParticipant2LowEffortMP endpoints
(assert (forall ((c Containment)) (=>
	(edge MeetingParticipant2LowEffortMP c)
	(and
		(node MeetingParticipant (src c))
		(node LowEffortMP ((as tgt (SoftGoal)) c))
	)
)))
;MeetingParticipant2LowEffortMP Exists
(assert	(exists ((c Containment)) (edge MeetingParticipant2LowEffortMP c)))
;MeetingParticipant2LowEffortMP is Unique
(assert	(forall ((c1 Containment) (c2 Containment)) (=>
	(and (edge MeetingParticipant2LowEffortMP c1) (edge MeetingParticipant2LowEffortMP c2))
	(= c1 c2)
)))
;MeetingParticipant2LowEffortMP is Distinct
(assert	(forall ((c Containment)) (=>
	(edge MeetingParticipant2LowEffortMP c)
	(not (or
		(edge MeetingInitiator2Quick c)
		(edge MeetingInitiator2LowEffortMI c)
	))
)))
;MeetingParticipant2UseProfiles tgtType constant
(assert (forall ((c Containment)) (=>
	(edge MeetingParticipant2UseProfiles c)
	(= (tgtType c) TASK)
)))
;MeetingParticipant2UseProfiles endpoints
(assert (forall ((c Containment)) (=>
	(edge MeetingParticipant2UseProfiles c)
	(and
		(node MeetingParticipant (src c))
		(node UseProfiles ((as tgt (Task)) c))
	)
)))
;MeetingParticipant2UseProfiles Exists
(assert	(exists ((c Containment)) (edge MeetingParticipant2UseProfiles c)))
;MeetingParticipant2UseProfiles is Unique
(assert	(forall ((c1 Containment) (c2 Containment)) (=>
	(and (edge MeetingParticipant2UseProfiles c1) (edge MeetingParticipant2UseProfiles c2))
	(= c1 c2)
)))
;MeetingParticipant2UseProfiles is Distinct
(assert	(forall ((c Containment)) (=>
	(edge MeetingParticipant2UseProfiles c)
	(not (or
		(edge MeetingInitiator2OtherWaysToOrganizeMeeting c)
		(edge MeetingInitiator2LetSchedulerScheduleMeeting c)
		(edge MeetingInitiator2OrganizeMeeting c)
		(edge MeetingInitiator2DetermineMeetingDate c)
		(edge MeetingScheduler2ScheduleMeeting c)
		(edge MeetingParticipant2ParticipateInMeeting c)
		(edge MeetingParticipant2AttendMeeting c)
		(edge MeetingParticipant2ProvideDetails c)
		(edge MeetingParticipant2DecideConvenientDates c)
	))
)))
;MeetingBeScheduledMI2OrganizeMeeting Exists
(assert	(exists ((c Decomposition)) (edge MeetingBeScheduledMI2OrganizeMeeting c)))
;MeetingBeScheduledMI2OrganizeMeeting is Unique
(assert	(forall ((c1 Decomposition) (c2 Decomposition)) (=>
	(and (edge MeetingBeScheduledMI2OrganizeMeeting c1) (edge MeetingBeScheduledMI2OrganizeMeeting c2))
	(= c1 c2)
)))
;MeetingBeScheduledMI2OrganizeMeeting is Distinct
(assert	(forall ((c Decomposition)) (=>
	(edge MeetingBeScheduledMI2OrganizeMeeting c)
	(not (or
		(edge Quick2OrganizeMeeting c)
		(edge LowEffortMI2OrganizeMeeting c)
		(edge DetermineMeetingDate2OrganizeMeeting c)
		(edge AttendMeeting2ParticipateInMeeting c)
		(edge ProvideDetails2ParticipateInMeeting c)
		(edge AgreeableMeetingDate2ParticipateInMeeting c)
		(edge ConvenientMeetingDate2ParticipateInMeeting c)
		(edge LowEffortMP2ProvideDetails c)
		(edge UseProfiles2ParticipateInMeeting c)
	))
)))

;MeetingBeScheduledMI2OrganizeMeeting endpoints
(assert (forall ((c Decomposition)) (=>
	(edge MeetingBeScheduledMI2OrganizeMeeting c)
	(and
		(node MeetingBeScheduledMI ((as src (Goal)) c))
		(node OrganizeMeeting (tgt c))
	)
)))
;MeetingBeScheduledMI2OrganizeMeeting srcType constant
(assert (forall ((c Decomposition)) (=>
	(edge MeetingBeScheduledMI2OrganizeMeeting c)
	(= (srcType c) GOAL)
)))

;OtherWaysToOrganizeMeeting2MeetingBeScheduledMI Exists
(assert	(exists ((c MeansEnd)) (edge OtherWaysToOrganizeMeeting2MeetingBeScheduledMI c)))
;OtherWaysToOrganizeMeeting2MeetingBeScheduledMI is Unique
(assert	(forall ((c1 MeansEnd) (c2 MeansEnd)) (=>
	(and (edge OtherWaysToOrganizeMeeting2MeetingBeScheduledMI c1) (edge OtherWaysToOrganizeMeeting2MeetingBeScheduledMI c2))
	(= c1 c2)
)))
;OtherWaysToOrganizeMeeting2MeetingBeScheduledMI is Distinct
(assert	(forall ((c MeansEnd)) (=>
	(edge OtherWaysToOrganizeMeeting2MeetingBeScheduledMI c)
	(not (or
		(edge LetSchedulerScheduleMeeting2MeetingBeScheduledMI c)
		(edge DecideConvenientDates2ConvenientMeetingDate c)
	))
)))

;OtherWaysToOrganizeMeeting2MeetingBeScheduledMI endpoints
(assert (forall ((c MeansEnd)) (=>
	(edge OtherWaysToOrganizeMeeting2MeetingBeScheduledMI c)
	(and
		(node OtherWaysToOrganizeMeeting (src c))
		(node MeetingBeScheduledMI (tgt c))
	)
)))

;OtherWaysToOrganizeMeeting2Quick Exists
(assert	(exists ((c Contribution)) (edge OtherWaysToOrganizeMeeting2Quick c)))
;OtherWaysToOrganizeMeeting2Quick is Unique
(assert	(forall ((c1 Contribution) (c2 Contribution)) (=>
	(and (edge OtherWaysToOrganizeMeeting2Quick c1) (edge OtherWaysToOrganizeMeeting2Quick c2))
	(= c1 c2)
)))
;OtherWaysToOrganizeMeeting2Quick is Distinct
(assert	(forall ((c Contribution)) (=>
	(edge OtherWaysToOrganizeMeeting2Quick c)
	(not (or
		(edge OtherWaysToOrganizeMeeting2LowEffortMI c)
		(edge LetSchedulerScheduleMeeting2Quick c)
		(edge LetSchedulerScheduleMeeting2LowEffortMI c)
	))
)))

;OtherWaysToOrganizeMeeting2Quick endpoints
(assert (forall ((c Contribution)) (=>
	(edge OtherWaysToOrganizeMeeting2Quick c)
	(and
		(node OtherWaysToOrganizeMeeting ((as src (Task)) c))
		(node Quick (tgt c))
	)
)))
;OtherWaysToOrganizeMeeting2Quick srcType constant
(assert (forall ((c Contribution)) (=>
	(edge OtherWaysToOrganizeMeeting2Quick c)
	(= (srcType c) TASK)
)))

;OtherWaysToOrganizeMeeting2Quick type constant
(assert (forall ((c Contribution)) (=>
	(edge OtherWaysToOrganizeMeeting2Quick c)
	(= (type c) UNKNOWN)
)))
;OtherWaysToOrganizeMeeting2LowEffortMI Exists
(assert	(exists ((c Contribution)) (edge OtherWaysToOrganizeMeeting2LowEffortMI c)))
;OtherWaysToOrganizeMeeting2LowEffortMI is Unique
(assert	(forall ((c1 Contribution) (c2 Contribution)) (=>
	(and (edge OtherWaysToOrganizeMeeting2LowEffortMI c1) (edge OtherWaysToOrganizeMeeting2LowEffortMI c2))
	(= c1 c2)
)))
;OtherWaysToOrganizeMeeting2LowEffortMI is Distinct
(assert	(forall ((c Contribution)) (=>
	(edge OtherWaysToOrganizeMeeting2LowEffortMI c)
	(not (or
		(edge OtherWaysToOrganizeMeeting2Quick c)
		(edge LetSchedulerScheduleMeeting2Quick c)
		(edge LetSchedulerScheduleMeeting2LowEffortMI c)
	))
)))

;OtherWaysToOrganizeMeeting2LowEffortMI endpoints
(assert (forall ((c Contribution)) (=>
	(edge OtherWaysToOrganizeMeeting2LowEffortMI c)
	(and
		(node OtherWaysToOrganizeMeeting ((as src (Task)) c))
		(node LowEffortMI (tgt c))
	)
)))
;OtherWaysToOrganizeMeeting2LowEffortMI srcType constant
(assert (forall ((c Contribution)) (=>
	(edge OtherWaysToOrganizeMeeting2LowEffortMI c)
	(= (srcType c) TASK)
)))

;OtherWaysToOrganizeMeeting2LowEffortMI type constant
(assert (forall ((c Contribution)) (=>
	(edge OtherWaysToOrganizeMeeting2LowEffortMI c)
	(= (type c) UNKNOWN)
)))
;LetSchedulerScheduleMeeting2MeetingBeScheduledMI Exists
(assert	(exists ((c MeansEnd)) (edge LetSchedulerScheduleMeeting2MeetingBeScheduledMI c)))
;LetSchedulerScheduleMeeting2MeetingBeScheduledMI is Unique
(assert	(forall ((c1 MeansEnd) (c2 MeansEnd)) (=>
	(and (edge LetSchedulerScheduleMeeting2MeetingBeScheduledMI c1) (edge LetSchedulerScheduleMeeting2MeetingBeScheduledMI c2))
	(= c1 c2)
)))
;LetSchedulerScheduleMeeting2MeetingBeScheduledMI is Distinct
(assert	(forall ((c MeansEnd)) (=>
	(edge LetSchedulerScheduleMeeting2MeetingBeScheduledMI c)
	(not (or
		(edge OtherWaysToOrganizeMeeting2MeetingBeScheduledMI c)
		(edge DecideConvenientDates2ConvenientMeetingDate c)
	))
)))

;LetSchedulerScheduleMeeting2MeetingBeScheduledMI endpoints
(assert (forall ((c MeansEnd)) (=>
	(edge LetSchedulerScheduleMeeting2MeetingBeScheduledMI c)
	(and
		(node LetSchedulerScheduleMeeting (src c))
		(node MeetingBeScheduledMI (tgt c))
	)
)))

;LetSchedulerScheduleMeeting2Quick Exists
(assert	(exists ((c Contribution)) (edge LetSchedulerScheduleMeeting2Quick c)))
;LetSchedulerScheduleMeeting2Quick is Unique
(assert	(forall ((c1 Contribution) (c2 Contribution)) (=>
	(and (edge LetSchedulerScheduleMeeting2Quick c1) (edge LetSchedulerScheduleMeeting2Quick c2))
	(= c1 c2)
)))
;LetSchedulerScheduleMeeting2Quick is Distinct
(assert	(forall ((c Contribution)) (=>
	(edge LetSchedulerScheduleMeeting2Quick c)
	(not (or
		(edge OtherWaysToOrganizeMeeting2Quick c)
		(edge OtherWaysToOrganizeMeeting2LowEffortMI c)
		(edge LetSchedulerScheduleMeeting2LowEffortMI c)
	))
)))

;LetSchedulerScheduleMeeting2Quick endpoints
(assert (forall ((c Contribution)) (=>
	(edge LetSchedulerScheduleMeeting2Quick c)
	(and
		(node LetSchedulerScheduleMeeting ((as src (Task)) c))
		(node Quick (tgt c))
	)
)))
;LetSchedulerScheduleMeeting2Quick srcType constant
(assert (forall ((c Contribution)) (=>
	(edge LetSchedulerScheduleMeeting2Quick c)
	(= (srcType c) TASK)
)))

;LetSchedulerScheduleMeeting2Quick type constant
(assert (forall ((c Contribution)) (=>
	(edge LetSchedulerScheduleMeeting2Quick c)
	(= (type c) HELP)
)))
;LetSchedulerScheduleMeeting2LowEffortMI Exists
(assert	(exists ((c Contribution)) (edge LetSchedulerScheduleMeeting2LowEffortMI c)))
;LetSchedulerScheduleMeeting2LowEffortMI is Unique
(assert	(forall ((c1 Contribution) (c2 Contribution)) (=>
	(and (edge LetSchedulerScheduleMeeting2LowEffortMI c1) (edge LetSchedulerScheduleMeeting2LowEffortMI c2))
	(= c1 c2)
)))
;LetSchedulerScheduleMeeting2LowEffortMI is Distinct
(assert	(forall ((c Contribution)) (=>
	(edge LetSchedulerScheduleMeeting2LowEffortMI c)
	(not (or
		(edge OtherWaysToOrganizeMeeting2Quick c)
		(edge OtherWaysToOrganizeMeeting2LowEffortMI c)
		(edge LetSchedulerScheduleMeeting2Quick c)
	))
)))

;LetSchedulerScheduleMeeting2LowEffortMI endpoints
(assert (forall ((c Contribution)) (=>
	(edge LetSchedulerScheduleMeeting2LowEffortMI c)
	(and
		(node LetSchedulerScheduleMeeting ((as src (Task)) c))
		(node LowEffortMI (tgt c))
	)
)))
;LetSchedulerScheduleMeeting2LowEffortMI srcType constant
(assert (forall ((c Contribution)) (=>
	(edge LetSchedulerScheduleMeeting2LowEffortMI c)
	(= (srcType c) TASK)
)))

;LetSchedulerScheduleMeeting2LowEffortMI type constant
(assert (forall ((c Contribution)) (=>
	(edge LetSchedulerScheduleMeeting2LowEffortMI c)
	(= (type c) HELP)
)))
;Quick2OrganizeMeeting Exists
(assert	(exists ((c Decomposition)) (edge Quick2OrganizeMeeting c)))
;Quick2OrganizeMeeting is Unique
(assert	(forall ((c1 Decomposition) (c2 Decomposition)) (=>
	(and (edge Quick2OrganizeMeeting c1) (edge Quick2OrganizeMeeting c2))
	(= c1 c2)
)))
;Quick2OrganizeMeeting is Distinct
(assert	(forall ((c Decomposition)) (=>
	(edge Quick2OrganizeMeeting c)
	(not (or
		(edge MeetingBeScheduledMI2OrganizeMeeting c)
		(edge LowEffortMI2OrganizeMeeting c)
		(edge DetermineMeetingDate2OrganizeMeeting c)
		(edge AttendMeeting2ParticipateInMeeting c)
		(edge ProvideDetails2ParticipateInMeeting c)
		(edge AgreeableMeetingDate2ParticipateInMeeting c)
		(edge ConvenientMeetingDate2ParticipateInMeeting c)
		(edge LowEffortMP2ProvideDetails c)
		(edge UseProfiles2ParticipateInMeeting c)
	))
)))

;Quick2OrganizeMeeting endpoints
(assert (forall ((c Decomposition)) (=>
	(edge Quick2OrganizeMeeting c)
	(and
		(node Quick ((as src (SoftGoal)) c))
		(node OrganizeMeeting (tgt c))
	)
)))
;Quick2OrganizeMeeting srcType constant
(assert (forall ((c Decomposition)) (=>
	(edge Quick2OrganizeMeeting c)
	(= (srcType c) SOFTGOAL)
)))

;LowEffortMI2OrganizeMeeting Exists
(assert	(exists ((c Decomposition)) (edge LowEffortMI2OrganizeMeeting c)))
;LowEffortMI2OrganizeMeeting is Unique
(assert	(forall ((c1 Decomposition) (c2 Decomposition)) (=>
	(and (edge LowEffortMI2OrganizeMeeting c1) (edge LowEffortMI2OrganizeMeeting c2))
	(= c1 c2)
)))
;LowEffortMI2OrganizeMeeting is Distinct
(assert	(forall ((c Decomposition)) (=>
	(edge LowEffortMI2OrganizeMeeting c)
	(not (or
		(edge MeetingBeScheduledMI2OrganizeMeeting c)
		(edge Quick2OrganizeMeeting c)
		(edge DetermineMeetingDate2OrganizeMeeting c)
		(edge AttendMeeting2ParticipateInMeeting c)
		(edge ProvideDetails2ParticipateInMeeting c)
		(edge AgreeableMeetingDate2ParticipateInMeeting c)
		(edge ConvenientMeetingDate2ParticipateInMeeting c)
		(edge LowEffortMP2ProvideDetails c)
		(edge UseProfiles2ParticipateInMeeting c)
	))
)))

;LowEffortMI2OrganizeMeeting endpoints
(assert (forall ((c Decomposition)) (=>
	(edge LowEffortMI2OrganizeMeeting c)
	(and
		(node LowEffortMI ((as src (SoftGoal)) c))
		(node OrganizeMeeting (tgt c))
	)
)))
;LowEffortMI2OrganizeMeeting srcType constant
(assert (forall ((c Decomposition)) (=>
	(edge LowEffortMI2OrganizeMeeting c)
	(= (srcType c) SOFTGOAL)
)))

;DetermineMeetingDate2OrganizeMeeting Exists
(assert	(exists ((c Decomposition)) (edge DetermineMeetingDate2OrganizeMeeting c)))
;DetermineMeetingDate2OrganizeMeeting is Unique
(assert	(forall ((c1 Decomposition) (c2 Decomposition)) (=>
	(and (edge DetermineMeetingDate2OrganizeMeeting c1) (edge DetermineMeetingDate2OrganizeMeeting c2))
	(= c1 c2)
)))
;DetermineMeetingDate2OrganizeMeeting is Distinct
(assert	(forall ((c Decomposition)) (=>
	(edge DetermineMeetingDate2OrganizeMeeting c)
	(not (or
		(edge MeetingBeScheduledMI2OrganizeMeeting c)
		(edge Quick2OrganizeMeeting c)
		(edge LowEffortMI2OrganizeMeeting c)
		(edge AttendMeeting2ParticipateInMeeting c)
		(edge ProvideDetails2ParticipateInMeeting c)
		(edge AgreeableMeetingDate2ParticipateInMeeting c)
		(edge ConvenientMeetingDate2ParticipateInMeeting c)
		(edge LowEffortMP2ProvideDetails c)
		(edge UseProfiles2ParticipateInMeeting c)
	))
)))

;DetermineMeetingDate2OrganizeMeeting endpoints
(assert (forall ((c Decomposition)) (=>
	(edge DetermineMeetingDate2OrganizeMeeting c)
	(and
		(node DetermineMeetingDate ((as src (Task)) c))
		(node OrganizeMeeting (tgt c))
	)
)))
;DetermineMeetingDate2OrganizeMeeting srcType constant
(assert (forall ((c Decomposition)) (=>
	(edge DetermineMeetingDate2OrganizeMeeting c)
	(= (srcType c) TASK)
)))

;AttendMeeting2ParticipateInMeeting Exists
(assert	(exists ((c Decomposition)) (edge AttendMeeting2ParticipateInMeeting c)))
;AttendMeeting2ParticipateInMeeting is Unique
(assert	(forall ((c1 Decomposition) (c2 Decomposition)) (=>
	(and (edge AttendMeeting2ParticipateInMeeting c1) (edge AttendMeeting2ParticipateInMeeting c2))
	(= c1 c2)
)))
;AttendMeeting2ParticipateInMeeting is Distinct
(assert	(forall ((c Decomposition)) (=>
	(edge AttendMeeting2ParticipateInMeeting c)
	(not (or
		(edge MeetingBeScheduledMI2OrganizeMeeting c)
		(edge Quick2OrganizeMeeting c)
		(edge LowEffortMI2OrganizeMeeting c)
		(edge DetermineMeetingDate2OrganizeMeeting c)
		(edge ProvideDetails2ParticipateInMeeting c)
		(edge AgreeableMeetingDate2ParticipateInMeeting c)
		(edge ConvenientMeetingDate2ParticipateInMeeting c)
		(edge LowEffortMP2ProvideDetails c)
		(edge UseProfiles2ParticipateInMeeting c)
	))
)))

;AttendMeeting2ParticipateInMeeting endpoints
(assert (forall ((c Decomposition)) (=>
	(edge AttendMeeting2ParticipateInMeeting c)
	(and
		(node AttendMeeting ((as src (Task)) c))
		(node ParticipateInMeeting (tgt c))
	)
)))
;AttendMeeting2ParticipateInMeeting srcType constant
(assert (forall ((c Decomposition)) (=>
	(edge AttendMeeting2ParticipateInMeeting c)
	(= (srcType c) TASK)
)))

;ProvideDetails2ParticipateInMeeting Exists
(assert	(exists ((c Decomposition)) (edge ProvideDetails2ParticipateInMeeting c)))
;ProvideDetails2ParticipateInMeeting is Unique
(assert	(forall ((c1 Decomposition) (c2 Decomposition)) (=>
	(and (edge ProvideDetails2ParticipateInMeeting c1) (edge ProvideDetails2ParticipateInMeeting c2))
	(= c1 c2)
)))
;ProvideDetails2ParticipateInMeeting is Distinct
(assert	(forall ((c Decomposition)) (=>
	(edge ProvideDetails2ParticipateInMeeting c)
	(not (or
		(edge MeetingBeScheduledMI2OrganizeMeeting c)
		(edge Quick2OrganizeMeeting c)
		(edge LowEffortMI2OrganizeMeeting c)
		(edge DetermineMeetingDate2OrganizeMeeting c)
		(edge AttendMeeting2ParticipateInMeeting c)
		(edge AgreeableMeetingDate2ParticipateInMeeting c)
		(edge ConvenientMeetingDate2ParticipateInMeeting c)
		(edge LowEffortMP2ProvideDetails c)
		(edge UseProfiles2ParticipateInMeeting c)
	))
)))

;ProvideDetails2ParticipateInMeeting endpoints
(assert (forall ((c Decomposition)) (=>
	(edge ProvideDetails2ParticipateInMeeting c)
	(and
		(node ProvideDetails ((as src (Task)) c))
		(node ParticipateInMeeting (tgt c))
	)
)))
;ProvideDetails2ParticipateInMeeting srcType constant
(assert (forall ((c Decomposition)) (=>
	(edge ProvideDetails2ParticipateInMeeting c)
	(= (srcType c) TASK)
)))

;AgreeableMeetingDate2ParticipateInMeeting Exists
(assert	(exists ((c Decomposition)) (edge AgreeableMeetingDate2ParticipateInMeeting c)))
;AgreeableMeetingDate2ParticipateInMeeting is Unique
(assert	(forall ((c1 Decomposition) (c2 Decomposition)) (=>
	(and (edge AgreeableMeetingDate2ParticipateInMeeting c1) (edge AgreeableMeetingDate2ParticipateInMeeting c2))
	(= c1 c2)
)))
;AgreeableMeetingDate2ParticipateInMeeting is Distinct
(assert	(forall ((c Decomposition)) (=>
	(edge AgreeableMeetingDate2ParticipateInMeeting c)
	(not (or
		(edge MeetingBeScheduledMI2OrganizeMeeting c)
		(edge Quick2OrganizeMeeting c)
		(edge LowEffortMI2OrganizeMeeting c)
		(edge DetermineMeetingDate2OrganizeMeeting c)
		(edge AttendMeeting2ParticipateInMeeting c)
		(edge ProvideDetails2ParticipateInMeeting c)
		(edge ConvenientMeetingDate2ParticipateInMeeting c)
		(edge LowEffortMP2ProvideDetails c)
		(edge UseProfiles2ParticipateInMeeting c)
	))
)))

;AgreeableMeetingDate2ParticipateInMeeting endpoints
(assert (forall ((c Decomposition)) (=>
	(edge AgreeableMeetingDate2ParticipateInMeeting c)
	(and
		(node AgreeableMeetingDate ((as src (Goal)) c))
		(node ParticipateInMeeting (tgt c))
	)
)))
;AgreeableMeetingDate2ParticipateInMeeting srcType constant
(assert (forall ((c Decomposition)) (=>
	(edge AgreeableMeetingDate2ParticipateInMeeting c)
	(= (srcType c) GOAL)
)))

;ConvenientMeetingDate2ParticipateInMeeting Exists
(assert	(exists ((c Decomposition)) (edge ConvenientMeetingDate2ParticipateInMeeting c)))
;ConvenientMeetingDate2ParticipateInMeeting is Unique
(assert	(forall ((c1 Decomposition) (c2 Decomposition)) (=>
	(and (edge ConvenientMeetingDate2ParticipateInMeeting c1) (edge ConvenientMeetingDate2ParticipateInMeeting c2))
	(= c1 c2)
)))
;ConvenientMeetingDate2ParticipateInMeeting is Distinct
(assert	(forall ((c Decomposition)) (=>
	(edge ConvenientMeetingDate2ParticipateInMeeting c)
	(not (or
		(edge MeetingBeScheduledMI2OrganizeMeeting c)
		(edge Quick2OrganizeMeeting c)
		(edge LowEffortMI2OrganizeMeeting c)
		(edge DetermineMeetingDate2OrganizeMeeting c)
		(edge AttendMeeting2ParticipateInMeeting c)
		(edge ProvideDetails2ParticipateInMeeting c)
		(edge AgreeableMeetingDate2ParticipateInMeeting c)
		(edge LowEffortMP2ProvideDetails c)
		(edge UseProfiles2ParticipateInMeeting c)
	))
)))

;ConvenientMeetingDate2ParticipateInMeeting endpoints
(assert (forall ((c Decomposition)) (=>
	(edge ConvenientMeetingDate2ParticipateInMeeting c)
	(and
		(node ConvenientMeetingDate ((as src (Goal)) c))
		(node ParticipateInMeeting (tgt c))
	)
)))
;ConvenientMeetingDate2ParticipateInMeeting srcType constant
(assert (forall ((c Decomposition)) (=>
	(edge ConvenientMeetingDate2ParticipateInMeeting c)
	(= (srcType c) GOAL)
)))

;DecideConvenientDates2ConvenientMeetingDate Exists
(assert	(exists ((c MeansEnd)) (edge DecideConvenientDates2ConvenientMeetingDate c)))
;DecideConvenientDates2ConvenientMeetingDate is Unique
(assert	(forall ((c1 MeansEnd) (c2 MeansEnd)) (=>
	(and (edge DecideConvenientDates2ConvenientMeetingDate c1) (edge DecideConvenientDates2ConvenientMeetingDate c2))
	(= c1 c2)
)))
;DecideConvenientDates2ConvenientMeetingDate is Distinct
(assert	(forall ((c MeansEnd)) (=>
	(edge DecideConvenientDates2ConvenientMeetingDate c)
	(not (or
		(edge OtherWaysToOrganizeMeeting2MeetingBeScheduledMI c)
		(edge LetSchedulerScheduleMeeting2MeetingBeScheduledMI c)
	))
)))

;DecideConvenientDates2ConvenientMeetingDate endpoints
(assert (forall ((c MeansEnd)) (=>
	(edge DecideConvenientDates2ConvenientMeetingDate c)
	(and
		(node DecideConvenientDates (src c))
		(node ConvenientMeetingDate (tgt c))
	)
)))

;LowEffortMP2ProvideDetails Exists
(assert	(exists ((c Decomposition)) (edge LowEffortMP2ProvideDetails c)))
;LowEffortMP2ProvideDetails is Unique
(assert	(forall ((c1 Decomposition) (c2 Decomposition)) (=>
	(and (edge LowEffortMP2ProvideDetails c1) (edge LowEffortMP2ProvideDetails c2))
	(= c1 c2)
)))
;LowEffortMP2ProvideDetails is Distinct
(assert	(forall ((c Decomposition)) (=>
	(edge LowEffortMP2ProvideDetails c)
	(not (or
		(edge MeetingBeScheduledMI2OrganizeMeeting c)
		(edge Quick2OrganizeMeeting c)
		(edge LowEffortMI2OrganizeMeeting c)
		(edge DetermineMeetingDate2OrganizeMeeting c)
		(edge AttendMeeting2ParticipateInMeeting c)
		(edge ProvideDetails2ParticipateInMeeting c)
		(edge AgreeableMeetingDate2ParticipateInMeeting c)
		(edge ConvenientMeetingDate2ParticipateInMeeting c)
		(edge UseProfiles2ParticipateInMeeting c)
	))
)))

;LowEffortMP2ProvideDetails endpoints
(assert (forall ((c Decomposition)) (=>
	(edge LowEffortMP2ProvideDetails c)
	(and
		(node LowEffortMP ((as src (SoftGoal)) c))
		(node ProvideDetails (tgt c))
	)
)))
;LowEffortMP2ProvideDetails srcType constant
(assert (forall ((c Decomposition)) (=>
	(edge LowEffortMP2ProvideDetails c)
	(= (srcType c) SOFTGOAL)
)))

;UseProfiles2ParticipateInMeeting Exists
(assert	(exists ((c Decomposition)) (edge UseProfiles2ParticipateInMeeting c)))
;UseProfiles2ParticipateInMeeting is Unique
(assert	(forall ((c1 Decomposition) (c2 Decomposition)) (=>
	(and (edge UseProfiles2ParticipateInMeeting c1) (edge UseProfiles2ParticipateInMeeting c2))
	(= c1 c2)
)))
;UseProfiles2ParticipateInMeeting is Distinct
(assert	(forall ((c Decomposition)) (=>
	(edge UseProfiles2ParticipateInMeeting c)
	(not (or
		(edge MeetingBeScheduledMI2OrganizeMeeting c)
		(edge Quick2OrganizeMeeting c)
		(edge LowEffortMI2OrganizeMeeting c)
		(edge DetermineMeetingDate2OrganizeMeeting c)
		(edge AttendMeeting2ParticipateInMeeting c)
		(edge ProvideDetails2ParticipateInMeeting c)
		(edge AgreeableMeetingDate2ParticipateInMeeting c)
		(edge ConvenientMeetingDate2ParticipateInMeeting c)
		(edge LowEffortMP2ProvideDetails c)
	))
)))

;UseProfiles2ParticipateInMeeting endpoints
(assert (forall ((c Decomposition)) (=>
	(edge UseProfiles2ParticipateInMeeting c)
	(and
		(node UseProfiles ((as src (Task)) c))
		(node ParticipateInMeeting (tgt c))
	)
)))
;UseProfiles2ParticipateInMeeting srcType constant
(assert (forall ((c Decomposition)) (=>
	(edge UseProfiles2ParticipateInMeeting c)
	(= (srcType c) TASK)
)))

;OrganizeMeeting2Dependencies srcType constant
(assert (forall ((c DependerLink)) (=>
	(edge OrganizeMeeting2Dependencies c)
	(= (srcType c) TASK)
)))
;OrganizeMeeting2Dependencies tgtType constant
(assert (forall ((c DependerLink)) (=>
	(edge OrganizeMeeting2Dependencies c)
	(= (tgtType c) GOAL)
)))
;OrganizeMeeting2Dependencies endpoints
(assert (forall ((c DependerLink)) (=>
	(edge OrganizeMeeting2Dependencies c)
	(and
		(node OrganizeMeeting ((as src (Task)) c))
		(node Dependencies ((as tgt (Goal)) c))
	)
)))
;OrganizeMeeting2Dependencies Exists
(assert	(exists ((c DependerLink)) (edge OrganizeMeeting2Dependencies c)))
;OrganizeMeeting2Dependencies is Unique
(assert	(forall ((c1 DependerLink) (c2 DependerLink)) (=>
	(and (edge OrganizeMeeting2Dependencies c1) (edge OrganizeMeeting2Dependencies c2))
	(= c1 c2)
)))
;OrganizeMeeting2Dependencies is Distinct
(assert	(forall ((c DependerLink)) (=>
	(edge OrganizeMeeting2Dependencies c)
	(not (or
		(edge LetSchedulerScheduleMeeting2MeetingBeScheduled c)
		(edge ScheduleMeeting2Details c)
	))
)))
;LetSchedulerScheduleMeeting2MeetingBeScheduled srcType constant
(assert (forall ((c DependerLink)) (=>
	(edge LetSchedulerScheduleMeeting2MeetingBeScheduled c)
	(= (srcType c) TASK)
)))
;LetSchedulerScheduleMeeting2MeetingBeScheduled tgtType constant
(assert (forall ((c DependerLink)) (=>
	(edge LetSchedulerScheduleMeeting2MeetingBeScheduled c)
	(= (tgtType c) GOAL)
)))
;LetSchedulerScheduleMeeting2MeetingBeScheduled endpoints
(assert (forall ((c DependerLink)) (=>
	(edge LetSchedulerScheduleMeeting2MeetingBeScheduled c)
	(and
		(node LetSchedulerScheduleMeeting ((as src (Task)) c))
		(node MeetingBeScheduled ((as tgt (Goal)) c))
	)
)))
;LetSchedulerScheduleMeeting2MeetingBeScheduled Exists
(assert	(exists ((c DependerLink)) (edge LetSchedulerScheduleMeeting2MeetingBeScheduled c)))
;LetSchedulerScheduleMeeting2MeetingBeScheduled is Unique
(assert	(forall ((c1 DependerLink) (c2 DependerLink)) (=>
	(and (edge LetSchedulerScheduleMeeting2MeetingBeScheduled c1) (edge LetSchedulerScheduleMeeting2MeetingBeScheduled c2))
	(= c1 c2)
)))
;LetSchedulerScheduleMeeting2MeetingBeScheduled is Distinct
(assert	(forall ((c DependerLink)) (=>
	(edge LetSchedulerScheduleMeeting2MeetingBeScheduled c)
	(not (or
		(edge OrganizeMeeting2Dependencies c)
		(edge ScheduleMeeting2Details c)
	))
)))
;ScheduleMeeting2Details srcType constant
(assert (forall ((c DependerLink)) (=>
	(edge ScheduleMeeting2Details c)
	(= (srcType c) TASK)
)))
;ScheduleMeeting2Details tgtType constant
(assert (forall ((c DependerLink)) (=>
	(edge ScheduleMeeting2Details c)
	(= (tgtType c) RESOURCE)
)))
;ScheduleMeeting2Details endpoints
(assert (forall ((c DependerLink)) (=>
	(edge ScheduleMeeting2Details c)
	(and
		(node ScheduleMeeting ((as src (Task)) c))
		(node Details ((as tgt (Resource)) c))
	)
)))
;ScheduleMeeting2Details Exists
(assert	(exists ((c DependerLink)) (edge ScheduleMeeting2Details c)))
;ScheduleMeeting2Details is Unique
(assert	(forall ((c1 DependerLink) (c2 DependerLink)) (=>
	(and (edge ScheduleMeeting2Details c1) (edge ScheduleMeeting2Details c2))
	(= c1 c2)
)))
;ScheduleMeeting2Details is Distinct
(assert	(forall ((c DependerLink)) (=>
	(edge ScheduleMeeting2Details c)
	(not (or
		(edge OrganizeMeeting2Dependencies c)
		(edge LetSchedulerScheduleMeeting2MeetingBeScheduled c)
	))
)))
;Dependencies2ParticipateInMeeting srcType constant
(assert (forall ((c DependeeLink)) (=>
	(edge Dependencies2ParticipateInMeeting c)
	(= (srcType c) GOAL)
)))
;Dependencies2ParticipateInMeeting tgtType constant
(assert (forall ((c DependeeLink)) (=>
	(edge Dependencies2ParticipateInMeeting c)
	(= (tgtType c) TASK)
)))
;Dependencies2ParticipateInMeeting endpoints
(assert (forall ((c DependeeLink)) (=>
	(edge Dependencies2ParticipateInMeeting c)
	(and
		(node Dependencies ((as src (Goal)) c))
		(node ParticipateInMeeting ((as tgt (Task)) c))
	)
)))
;Dependencies2ParticipateInMeeting Exists
(assert	(exists ((c DependeeLink)) (edge Dependencies2ParticipateInMeeting c)))
;Dependencies2ParticipateInMeeting is Unique
(assert	(forall ((c1 DependeeLink) (c2 DependeeLink)) (=>
	(and (edge Dependencies2ParticipateInMeeting c1) (edge Dependencies2ParticipateInMeeting c2))
	(= c1 c2)
)))
;Dependencies2ParticipateInMeeting is Distinct
(assert	(forall ((c DependeeLink)) (=>
	(edge Dependencies2ParticipateInMeeting c)
	(not (or
		(edge MeetingBeScheduled2ScheduleMeeting c)
		(edge Details2ProvideDetails c)
	))
)))
;MeetingBeScheduled2ScheduleMeeting srcType constant
(assert (forall ((c DependeeLink)) (=>
	(edge MeetingBeScheduled2ScheduleMeeting c)
	(= (srcType c) GOAL)
)))
;MeetingBeScheduled2ScheduleMeeting tgtType constant
(assert (forall ((c DependeeLink)) (=>
	(edge MeetingBeScheduled2ScheduleMeeting c)
	(= (tgtType c) TASK)
)))
;MeetingBeScheduled2ScheduleMeeting endpoints
(assert (forall ((c DependeeLink)) (=>
	(edge MeetingBeScheduled2ScheduleMeeting c)
	(and
		(node MeetingBeScheduled ((as src (Goal)) c))
		(node ScheduleMeeting ((as tgt (Task)) c))
	)
)))
;MeetingBeScheduled2ScheduleMeeting Exists
(assert	(exists ((c DependeeLink)) (edge MeetingBeScheduled2ScheduleMeeting c)))
;MeetingBeScheduled2ScheduleMeeting is Unique
(assert	(forall ((c1 DependeeLink) (c2 DependeeLink)) (=>
	(and (edge MeetingBeScheduled2ScheduleMeeting c1) (edge MeetingBeScheduled2ScheduleMeeting c2))
	(= c1 c2)
)))
;MeetingBeScheduled2ScheduleMeeting is Distinct
(assert	(forall ((c DependeeLink)) (=>
	(edge MeetingBeScheduled2ScheduleMeeting c)
	(not (or
		(edge Dependencies2ParticipateInMeeting c)
		(edge Details2ProvideDetails c)
	))
)))
;Details2ProvideDetails srcType constant
(assert (forall ((c DependeeLink)) (=>
	(edge Details2ProvideDetails c)
	(= (srcType c) RESOURCE)
)))
;Details2ProvideDetails tgtType constant
(assert (forall ((c DependeeLink)) (=>
	(edge Details2ProvideDetails c)
	(= (tgtType c) TASK)
)))
;Details2ProvideDetails endpoints
(assert (forall ((c DependeeLink)) (=>
	(edge Details2ProvideDetails c)
	(and
		(node Details ((as src (Resource)) c))
		(node ProvideDetails ((as tgt (Task)) c))
	)
)))
;Details2ProvideDetails Exists
(assert	(exists ((c DependeeLink)) (edge Details2ProvideDetails c)))
;Details2ProvideDetails is Unique
(assert	(forall ((c1 DependeeLink) (c2 DependeeLink)) (=>
	(and (edge Details2ProvideDetails c1) (edge Details2ProvideDetails c2))
	(= c1 c2)
)))
;Details2ProvideDetails is Distinct
(assert	(forall ((c DependeeLink)) (=>
	(edge Details2ProvideDetails c)
	(not (or
		(edge Dependencies2ParticipateInMeeting c)
		(edge MeetingBeScheduled2ScheduleMeeting c)
	))
)))


;Goal propagation (MeansEnd + Depender + Dependee)
(assert	(forall ((c Goal)) (=> (not (inited c)) (= (fs c) (ite
	(or
		(and (exists ((mec MeansEnd)) (and (= (tgt mec) c) (fs mec))) (not (exists ((dc DependerLink)) (and (= (srcType dc) GOAL) (= ((as src (Goal)) dc) c) (or (fd dc) (pd dc) (co dc) (un dc) (n dc) (ps dc))))))
		(and (exists ((dc1 DependerLink)) (and (= (srcType dc1) GOAL) (= ((as src (Goal)) dc1) c) (fs dc1))) (not (exists ((dc2 DependerLink)) (and (= (srcType dc2) GOAL) (= ((as src (Goal)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (n dc2) (ps dc2))))))
		(and (exists ((dc1 DependeeLink)) (and (= (srcType dc1) GOAL) (= ((as src (Goal)) dc1) c) (fs dc1))) (not (exists ((dc2 DependeeLink)) (and (= (srcType dc2) GOAL) (= ((as src (Goal)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (n dc2) (ps dc2))))))
	)
	true
	false
)))))
(assert	(forall ((c Goal)) (=> (and (not (inited c)) (fs c)) (= (ps c) false))))
(assert	(forall ((c Goal)) (=> (and (not (inited c)) (not (fs c))) (= (ps c) (ite
	(or
		(and (exists ((mec1 MeansEnd)) (and (= (tgt mec1) c) (ps mec1))) (and (not (exists ((mec2 MeansEnd)) (and (= (tgt mec2) c) (fs mec2)))) (not (exists ((dc DependerLink)) (and (= (srcType dc) GOAL) (= ((as src (Goal)) dc) c) (or (fd dc) (pd dc) (co dc) (un dc) (n dc)))))))
		(and (exists ((dc1 DependerLink)) (and (= (srcType dc1) GOAL) (= ((as src (Goal)) dc1) c) (ps dc1))) (not (exists ((dc2 DependerLink)) (and (= (srcType dc2) GOAL) (= ((as src (Goal)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (n dc2))))))
		(and (exists ((dc1 DependeeLink)) (and (= (srcType dc1) GOAL) (= ((as src (Goal)) dc1) c) (ps dc1))) (not (exists ((dc2 DependeeLink)) (and (= (srcType dc2) GOAL) (= ((as src (Goal)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (n dc2))))))
	)
	true
	false
)))))
(assert	(forall ((c Goal)) (=> (and (not (inited c)) (or (fs c) (ps c))) (= (n c) false))))
(assert	(forall ((c Goal)) (=> (and (not (inited c)) (not (fs c)) (not (ps c))) (= (n c) (ite
	(or
		(and (not (exists ((mec MeansEnd)) (= (tgt mec) c))) (not (exists ((dc1 DependerLink)) (and (= (srcType dc1) GOAL) (= ((as src (Goal)) dc1) c)))) (not (exists ((dc2 DependeeLink)) (and (= (srcType dc2) GOAL) (= ((as src (Goal)) dc2) c)))))
		(and (exists ((mec1 MeansEnd)) (and (= (tgt mec1) c) (n mec1))) (and (not (exists ((mec2 MeansEnd)) (and (= (tgt mec2) c) (or (fs mec2) (ps mec2) (un mec2) (co mec2) (pd mec2) (fd mec2))))) (not (exists ((dc DependerLink)) (and (= (srcType dc) GOAL) (= ((as src (Goal)) dc) c) (or (fd dc) (pd dc) (co dc) (un dc)))))))
		(and (exists ((dc1 DependerLink)) (and (= (srcType dc1) GOAL) (= ((as src (Goal)) dc1) c) (n dc1))) (not (exists ((dc2 DependerLink)) (and (= (srcType dc2) GOAL) (= ((as src (Goal)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2))))))
		(and (exists ((dc1 DependeeLink)) (and (= (srcType dc1) GOAL) (= ((as src (Goal)) dc1) c) (n dc1))) (not (exists ((dc2 DependeeLink)) (and (= (srcType dc2) GOAL) (= ((as src (Goal)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2))))))
	)
	true
	false
)))))
(assert	(forall ((c Goal)) (=> (and (not (inited c)) (or (fs c) (ps c) (n c))) (= (un c) false))))
(assert	(forall ((c Goal)) (=> (and (not (inited c)) (not (fs c)) (not (ps c)) (not (n c))) (= (un c) (ite
	(or
		(and (exists ((mec1 MeansEnd)) (and (= (tgt mec1) c) (un mec1))) (and (not (exists ((mec2 MeansEnd)) (and (= (tgt mec2) c) (or (fs mec2) (ps mec2))))) (not (exists ((dc DependerLink)) (and (= (srcType dc) GOAL) (= ((as src (Goal)) dc) c) (or (fd dc) (pd dc) (co dc)))))))
		(and (exists ((dc1 DependerLink)) (and (= (srcType dc1) GOAL) (= ((as src (Goal)) dc1) c) (un dc1))) (not (exists ((dc2 DependerLink)) (and (= (srcType dc2) GOAL) (= ((as src (Goal)) dc2) c) (or (fd dc2) (pd dc2) (co dc2))))))
		(and (exists ((dc1 DependeeLink)) (and (= (srcType dc1) GOAL) (= ((as src (Goal)) dc1) c) (un dc1))) (not (exists ((dc2 DependeeLink)) (and (= (srcType dc2) GOAL) (= ((as src (Goal)) dc2) c) (or (fd dc2) (pd dc2) (co dc2))))))
	)
	true
	false
)))))
(assert	(forall ((c Goal)) (=> (and (not (inited c)) (or (fs c) (ps c) (n c) (un c))) (= (co c) false))))
(assert	(forall ((c Goal)) (=> (and (not (inited c)) (not (fs c)) (not (ps c)) (not (n c)) (not (un c))) (= (co c) (ite
	(or
		(and (exists ((mec1 MeansEnd)) (and (= (tgt mec1) c) (co mec1))) (and (not (exists ((mec2 MeansEnd)) (and (= (tgt mec2) c) (or (fs mec2) (ps mec2) (un mec2))))) (not (exists ((dc DependerLink)) (and (= (srcType dc) GOAL) (= ((as src (Goal)) dc) c) (or (fd dc) (pd dc)))))))
		(and (exists ((dc1 DependerLink)) (and (= (srcType dc1) GOAL) (= ((as src (Goal)) dc1) c) (co dc1))) (not (exists ((dc2 DependerLink)) (and (= (srcType dc2) GOAL) (= ((as src (Goal)) dc2) c) (or (fd dc2) (pd dc2))))))
		(and (exists ((dc1 DependeeLink)) (and (= (srcType dc1) GOAL) (= ((as src (Goal)) dc1) c) (co dc1))) (not (exists ((dc2 DependeeLink)) (and (= (srcType dc2) GOAL) (= ((as src (Goal)) dc2) c) (or (fd dc2) (pd dc2))))))
	)
	true
	false
)))))
(assert	(forall ((c Goal)) (=> (and (not (inited c)) (or (fs c) (ps c) (n c) (un c) (co c))) (= (pd c) false))))
(assert	(forall ((c Goal)) (=> (and (not (inited c)) (not (fs c)) (not (ps c)) (not (n c)) (not (un c)) (not (co c))) (= (pd c) (ite
	(or
		(and (exists ((mec1 MeansEnd)) (and (= (tgt mec1) c) (pd mec1))) (and (not (exists ((mec2 MeansEnd)) (and (= (tgt mec2) c) (or (fs mec2) (ps mec2) (un mec2) (co mec2))))) (not (exists ((dc DependerLink)) (and (= (srcType dc) GOAL) (= ((as src (Goal)) dc) c) (fd dc))))))
		(and (exists ((dc1 DependerLink)) (and (= (srcType dc1) GOAL) (= ((as src (Goal)) dc1) c) (pd dc1))) (not (exists ((dc2 DependerLink)) (and (= (srcType dc2) GOAL) (= ((as src (Goal)) dc2) c) (fd dc2)))))
		(and (exists ((dc1 DependeeLink)) (and (= (srcType dc1) GOAL) (= ((as src (Goal)) dc1) c) (pd dc1))) (not (exists ((dc2 DependeeLink)) (and (= (srcType dc2) GOAL) (= ((as src (Goal)) dc2) c) (fd dc2)))))
	)
	true
	false
)))))
(assert	(forall ((c Goal)) (=> (and (not (inited c)) (or (fs c) (ps c) (n c) (un c) (co c) (pd c))) (= (fd c) false))))
(assert	(forall ((c Goal)) (=> (and (not (inited c)) (not (fs c)) (not (ps c)) (not (n c)) (not (un c)) (not (co c)) (not (pd c))) (= (fd c) true))))
;(assert	(forall ((c Goal)) (=> (not (inited c)) (= (fd c) (ite
;	(or
;		(and (exists ((mec1 MeansEnd)) (and (= (tgt mec1) c) (fd mec1))) (not (exists ((mec2 MeansEnd)) (and (= (tgt mec2) c) (or (fs mec2) (ps mec2) (un mec2) (co mec2) (pd mec2))))))
;		(exists ((dc DependerLink)) (and (= (srcType dc) GOAL) (= ((as src (Goal)) dc) c) (fd dc)))
;		(exists ((dc DependeeLink)) (and (= (srcType dc) GOAL) (= ((as src (Goal)) dc) c) (fd dc)))
;	)
;	true
;	false
;)))))

;Task propagation (Decomposition + Depender)
(assert (forall ((c Task)) (=> (not (inited c)) (= (fd c) (ite
	(or
		(exists ((dc Decomposition)) (and (= (tgt dc) c) (fd dc)))
		(exists ((dc DependerLink)) (and (= (srcType dc) TASK) (= ((as src (Task)) dc) c) (fd dc)))
	)
	true
	false
)))))
(assert (forall ((c Task)) (=> (and (not (inited c)) (fd c))  (= (pd c) false))))
(assert (forall ((c Task)) (=> (and (not (inited c)) (not (fd c)))  (= (pd c) (ite
	(or
		(and (exists ((dc1 Decomposition)) (and (= (tgt dc1) c) (pd dc1))) (not (exists ((dc2 Decomposition)) (and (= (tgt dc2) c) (fd dc2)))) (not (exists ((dc3 DependerLink)) (and (= (srcType dc3) TASK) (= ((as src (Task)) dc3) c) (fd dc3)))))
		(and (exists ((dc1 DependerLink)) (and (= (srcType dc1) TASK) (= ((as src (Task)) dc1) c) (pd dc1))) (not (exists ((dc2 DependerLink)) (and (= (srcType dc2) TASK) (= ((as src (Task)) dc2) c) (fd dc2)))) (not (exists ((dc3 Decomposition)) (and (= (tgt dc3) c) (fd dc3)))))
	)
	true
	false
)))))
(assert (forall ((c Task)) (=> (and (not (inited c)) (or (fd c) (pd c)))  (= (co c) false))))
(assert (forall ((c Task)) (=> (and (not (inited c)) (not (fd c)) (not (pd c)))  (= (co c) (ite
	(or
		(and (exists ((dc1 Decomposition)) (and (= (tgt dc1) c) (co dc1))) (not (exists ((dc2 Decomposition)) (and (= (tgt dc2) c) (or (fd dc2) (pd dc2))))) (not (exists ((dc3 DependerLink)) (and (= (srcType dc3) TASK) (= ((as src (Task)) dc3) c) (or (fd dc3) (pd dc3))))))
		(and (exists ((dc1 DependerLink)) (and (= (srcType dc1) TASK) (= ((as src (Task)) dc1) c) (co dc1))) (not (exists ((dc2 DependerLink)) (and (= (srcType dc2) TASK) (= ((as src (Task)) dc2) c) (or (fd dc2) (pd dc2))))) (not (exists ((dc3 Decomposition)) (and (= (tgt dc3) c) (or (fd dc3) (pd dc3))))))
	)
	true
	false
)))))
(assert (forall ((c Task)) (=> (and (not (inited c)) (or (fd c) (pd c) (co c)))  (= (un c) false))))
(assert (forall ((c Task)) (=> (and (not (inited c)) (not (fd c)) (not (pd c)) (not (co c)))  (= (un c) (ite
	(or
		(and (exists ((dc1 Decomposition)) (and (= (tgt dc1) c) (un dc1))) (not (exists ((dc2 Decomposition)) (and (= (tgt dc2) c) (or (fd dc2) (pd dc2) (co dc2))))) (not (exists ((dc3 DependerLink)) (and (= (srcType dc3) TASK) (= ((as src (Task)) dc3) c) (or (fd dc3) (pd dc3) (co dc3))))))
		(and (exists ((dc1 DependerLink)) (and (= (srcType dc1) TASK) (= ((as src (Task)) dc1) c) (un dc1))) (not (exists ((dc2 DependerLink)) (and (= (srcType dc2) TASK) (= ((as src (Task)) dc2) c) (or (fd dc2) (pd dc2) (co dc2))))) (not (exists ((dc3 Decomposition)) (and (= (tgt dc3) c) (or (fd dc3) (pd dc3) (co dc3))))))
	)
	true
	false
)))))
(assert (forall ((c Task)) (=> (and (not (inited c)) (or (fd c) (pd c) (co c) (un c)))  (= (n c) false))))
(assert (forall ((c Task)) (=> (and (not (inited c)) (not (fd c)) (not (pd c)) (not (co c)) (not (un c)))  (= (n c) (ite
	(or
		(and (not (exists ((dc1 Decomposition)) (= (tgt dc1) c))) (not (exists ((dc2 DependerLink)) (and (= (srcType dc2) TASK) (= ((as src (Task)) dc2) c)))))
		(and (exists ((dc1 Decomposition)) (and (= (tgt dc1) c) (n dc1))) (not (exists ((dc2 Decomposition)) (and (= (tgt dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2))))) (not (exists ((dc3 DependerLink)) (and (= (srcType dc3) TASK) (= ((as src (Task)) dc3) c) (or (fd dc3) (pd dc3) (co dc3) (un dc3))))))
		(and (exists ((dc1 DependerLink)) (and (= (srcType dc1) TASK) (= ((as src (Task)) dc1) c) (n dc1))) (not (exists ((dc2 DependerLink)) (and (= (srcType dc2) TASK) (= ((as src (Task)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2))))) (not (exists ((dc3 Decomposition)) (and (= (tgt dc3) c) (or (fd dc3) (pd dc3) (co dc3) (un dc3))))))
	)
	true
	false
)))))
(assert (forall ((c Task)) (=> (and (not (inited c)) (or (fd c) (pd c) (co c) (un c) (n c)))  (= (ps c) false))))
(assert (forall ((c Task)) (=> (and (not (inited c)) (not (fd c)) (not (pd c)) (not (co c)) (not (un c)) (not (n c)))  (= (ps c) (ite
	(or
		(and (exists ((dc1 Decomposition)) (and (= (tgt dc1) c) (ps dc1))) (not (exists ((dc2 Decomposition)) (and (= (tgt dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (n dc2))))) (not (exists ((dc3 DependerLink)) (and (= (srcType dc3) TASK) (= ((as src (Task)) dc3) c) (or (fd dc3) (pd dc3) (co dc3) (un dc3) (n dc3))))))
		(and (exists ((dc1 DependerLink)) (and (= (srcType dc1) TASK) (= ((as src (Task)) dc1) c) (ps dc1))) (not (exists ((dc2 DependerLink)) (and (= (srcType dc2) TASK) (= ((as src (Task)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (n dc2))))) (not (exists ((dc3 Decomposition)) (and (= (tgt dc3) c) (or (fd dc3) (pd dc3) (co dc3) (un dc3) (n dc3))))))
	)
	true
	false
)))))
(assert (forall ((c Task)) (=> (and (not (inited c)) (or (fd c) (pd c) (co c) (un c) (n c) (ps c)))  (= (fs c) false))))
(assert (forall ((c Task)) (=> (and (not (inited c)) (not (fd c)) (not (pd c)) (not (co c)) (not (un c)) (not (n c)) (not (ps c)))  (= (fs c) true))))
;(assert (forall ((c Task)) (=> (not (inited c))  (= (fs c) (ite
;	(or
;		(and (exists ((dc1 Decomposition)) (and (= (tgt dc1) c) (fs dc1))) (not (exists ((dc2 Decomposition)) (and (= (tgt dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (n dc2) (ps dc2))))) (not (exists ((dc3 DependerLink)) (and (= (srcType dc3) TASK) (= ((as src (Task)) dc3) c) (or (fd dc3) (pd dc3) (co dc3) (un dc3) (n dc3) (ps dc3))))))
;		(and (exists ((dc1 DependerLink)) (and (= (srcType dc1) TASK) (= ((as src (Task)) dc1) c) (fs dc1))) (not (exists ((dc2 DependerLink)) (and (= (srcType dc2) TASK) (= ((as src (Task)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (n dc2) (ps dc2))))) (not (exists ((dc3 Decomposition)) (and (= (tgt dc3) c) (or (fd dc3) (pd dc3) (co dc3) (un dc3) (n dc3) (ps dc3))))))
;	)
;	true
;	false
;)))))

;SoftGoal propagation (Contribution + Depender + Dependee)
(assert (forall ((c SoftGoal)) (=> (not (inited c)) (= (co c) (ite
	(or
		(and
			(or
				(exists ((cc1 Contribution)) (and (= (tgt cc1) c) (co cc1)))
				(exists ((cc2 Contribution) (cc3 Contribution)) (and (= (tgt cc2) c) (= (tgt cc3) c) (or (fs cc2) (ps cc2)) (or (pd cc3) (fd cc3))))
			)
			(not (exists ((dc DependerLink)) (and (= (srcType dc) SOFTGOAL) (= ((as src (SoftGoal)) dc) c) (or (fd dc) (pd dc)))))
		)
		(and
			(exists ((dc1 DependerLink)) (and (= (srcType dc1) SOFTGOAL) (= ((as src (SoftGoal)) dc1) c) (co dc1)))
			(not (exists ((dc2 DependerLink)) (and (= (srcType dc2) SOFTGOAL) (= ((as src (SoftGoal)) dc2) c) (or (fd dc2) (pd dc2)))))
			;not exists fd|pd
			(not (and
				(exists ((cc1 Contribution)) (and (= (tgt cc1) c) (or (fd cc1) (pd cc1))))
				(not (exists ((cc2 Contribution)) (and (= (tgt cc2) c) (or (co cc2) (un cc2) (fs cc2) (ps cc2)))))
			))
		)
		(and
			(exists ((dc1 DependeeLink)) (and (= (srcType dc1) SOFTGOAL) (= ((as src (SoftGoal)) dc1) c) (co dc1)))
			(not (exists ((dc2 DependeeLink)) (and (= (srcType dc2) SOFTGOAL) (= ((as src (SoftGoal)) dc2) c) (or (fd dc2) (pd dc2)))))
		)
	)
	true
	false
)))))
(assert (forall ((c SoftGoal)) (=> (and (not (inited c)) (co c)) (= (un c) false))))
(assert (forall ((c SoftGoal)) (=> (and (not (inited c)) (not (co c))) (= (un c) (ite
	(or
		(and
			(exists ((cc1 Contribution)) (and (= (tgt cc1) c) (un cc1)))
			(not (exists ((cc2 Contribution)) (and (= (tgt cc2) c) (co cc2))))
			(not (exists ((cc3 Contribution) (cc4 Contribution)) (and (= (tgt cc3) c) (= (tgt cc4) c) (or (fs cc3) (ps cc3)) (or (pd cc4) (fd cc4)))))
			(not (exists ((dc DependerLink)) (and (= (srcType dc) SOFTGOAL) (= ((as src (SoftGoal)) dc) c) (or (fd dc) (pd dc) (co dc)))))
		)
		(and
			(exists ((dc1 DependerLink)) (and (= (srcType dc1) SOFTGOAL) (= ((as src (SoftGoal)) dc1) c) (un dc1)))
			(not (exists ((dc2 DependerLink)) (and (= (srcType dc2) SOFTGOAL) (= ((as src (SoftGoal)) dc2) c) (or (fd dc2) (pd dc2) (co dc2)))))
			;not exists fd|pd|co_
			(not (and
				(exists ((cc1 Contribution)) (and (= (tgt cc1) c) (or (fd cc1) (pd cc1))))
				(not (exists ((cc2 Contribution)) (and (= (tgt cc2) c) (un cc2))))
			))
			;not exists co
			(not (exists ((cc3 Contribution)) (and (= (tgt cc3) c) (co cc3))))
		)
		(and
			(exists ((dc1 DependeeLink)) (and (= (srcType dc1) SOFTGOAL) (= ((as src (SoftGoal)) dc1) c) (un dc1)))
			(not (exists ((dc2 DependeeLink)) (and (= (srcType dc2) SOFTGOAL) (= ((as src (SoftGoal)) dc2) c) (or (fd dc2) (pd dc2) (co dc2)))))
		)
	)
	true
	false
)))))
(assert (forall ((c SoftGoal)) (=> (and (not (inited c)) (or (co c) (un c))) (= (fd c) false))))
(assert (forall ((c SoftGoal)) (=> (and (not (inited c)) (not (co c)) (not (un c))) (= (fd c) (ite
	(or
		(and
			(exists ((cc1 Contribution)) (and (= (tgt cc1) c) (fd cc1)))
			(not (exists ((cc2 Contribution)) (and (= (tgt cc2) c) (or (co cc2) (un cc2) (fs cc2) (ps cc2)))))
		)
		(exists ((dc DependerLink)) (and (= (srcType dc) SOFTGOAL) (= ((as src (SoftGoal)) dc) c) (fd dc)))
		(exists ((dc DependeeLink)) (and (= (srcType dc) SOFTGOAL) (= ((as src (SoftGoal)) dc) c) (fd dc)))
	)
	true
	false
)))))
(assert (forall ((c SoftGoal)) (=> (and (not (inited c)) (or (co c) (un c) (fd c))) (= (pd c) false))))
(assert (forall ((c SoftGoal)) (=> (and (not (inited c)) (not (co c)) (not (un c)) (not (fd c))) (= (pd c) (ite
	(or
		(and
			(exists ((cc1 Contribution)) (and (= (tgt cc1) c) (pd cc1)))
			(not (exists ((cc2 Contribution)) (and (= (tgt cc2) c) (or (co cc2) (un cc2) (fd cc2) (fs cc2) (ps cc2)))))
			(not (exists ((dc DependerLink)) (and (= (srcType dc) SOFTGOAL) (= ((as src (SoftGoal)) dc) c) (fd dc))))
		)
		(and
			(exists ((dc1 DependerLink)) (and (= (srcType dc1) SOFTGOAL) (= ((as src (SoftGoal)) dc1) c) (pd dc1)))
			(not (exists ((dc2 DependerLink)) (and (= (srcType dc2) SOFTGOAL) (= ((as src (SoftGoal)) dc2) c) (fd dc2))))
			;not exists fd
			(not (and
				(exists ((cc1 Contribution)) (and (= (tgt cc1) c) (fd cc1)))
				(not (exists ((cc2 Contribution)) (and (= (tgt cc2) c) (or (co cc2) (un cc2) (fs cc2) (ps cc2)))))
			))
		)
		(and
			(exists ((dc1 DependeeLink)) (and (= (srcType dc1) SOFTGOAL) (= ((as src (SoftGoal)) dc1) c) (pd dc1)))
			(not (exists ((dc2 DependeeLink)) (and (= (srcType dc2) SOFTGOAL) (= ((as src (SoftGoal)) dc2) c) (fd dc2))))
		)
	)
	true
	false
)))))
(assert (forall ((c SoftGoal)) (=> (and (not (inited c)) (or (co c) (un c) (fd c) (pd c))) (= (fs c) false))))
(assert (forall ((c SoftGoal)) (=> (and (not (inited c)) (not (co c)) (not (un c)) (not (fd c)) (not (pd c))) (= (fs c) (ite
	(or
		(and
			(exists ((cc1 Contribution)) (and (= (tgt cc1) c) (fs cc1)))
			(not (exists ((cc2 Contribution)) (and (= (tgt cc2) c) (or (co cc2) (un cc2) (fd cc2) (pd cc2)))))
			(not (exists ((dc DependerLink)) (and (= (srcType dc) SOFTGOAL) (= ((as src (SoftGoal)) dc) c) (or (fd dc) (pd dc) (co dc) (un dc) (n dc) (ps dc)))))
		)
		(and
			(exists ((dc1 DependerLink)) (and (= (srcType dc1) SOFTGOAL) (= ((as src (SoftGoal)) dc1) c) (fs dc1)))
			(not (exists ((dc2 DependerLink)) (and (= (srcType dc2) SOFTGOAL) (= ((as src (SoftGoal)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (n dc2) (ps dc2)))))
			;not exists fd|pd|co|co_|un
			(not (exists ((cc1 Contribution)) (and (= (tgt cc1) c) (or (co cc1) (un cc1) (fd cc1) (pd cc1)))))
			;not exists n
			(not (and
				(exists ((cc2 Contribution)) (and (= (tgt cc2) c) (n cc2)))
				(not (exists ((cc3 Contribution)) (and (= (tgt cc3) c) (or (co cc3) (un cc3) (fd cc3) (pd cc3) (fs cc3) (ps cc3)))))
			))
			;not exists ps
			(not (and
				(exists ((cc4 Contribution)) (and (= (tgt cc4) c) (ps cc4)))
				(not (exists ((cc5 Contribution)) (and (= (tgt cc5) c) (or (co cc5) (un cc5) (fd cc5) (pd cc5) (fs cc5)))))
			))
		)
		(and
			(exists ((dc1 DependeeLink)) (and (= (srcType dc1) SOFTGOAL) (= ((as src (SoftGoal)) dc1) c) (fs dc1)))
			(not (exists ((dc2 DependeeLink)) (and (= (srcType dc2) SOFTGOAL) (= ((as src (SoftGoal)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (n dc2) (ps dc2)))))
		)
	)
	true
	false
)))))
(assert (forall ((c SoftGoal)) (=> (and (not (inited c)) (or (co c) (un c) (fd c) (pd c) (fs c))) (= (ps c) false))))
(assert (forall ((c SoftGoal)) (=> (and (not (inited c)) (not (co c)) (not (un c)) (not (fd c)) (not (pd c)) (not (fs c))) (= (ps c) (ite
	(or
		(and
			(exists ((cc1 Contribution)) (and (= (tgt cc1) c) (ps cc1)))
			(not (exists ((cc2 Contribution)) (and (= (tgt cc2) c) (or (co cc2) (un cc2) (fd cc2) (pd cc2) (fs cc2)))))
			(not (exists ((dc DependerLink)) (and (= (srcType dc) SOFTGOAL) (= ((as src (SoftGoal)) dc) c) (or (fd dc) (pd dc) (co dc) (un dc) (n dc)))))
		)
		(and
			(exists ((dc1 DependerLink)) (and (= (srcType dc1) SOFTGOAL) (= ((as src (SoftGoal)) dc1) c) (ps dc1)))
			(not (exists ((dc2 DependerLink)) (and (= (srcType dc2) SOFTGOAL) (= ((as src (SoftGoal)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (n dc2)))))
			;not exists fd|pd|co|co_|un
			(not (exists ((cc1 Contribution)) (and (= (tgt cc1) c) (or (co cc1) (un cc1) (fd cc1) (pd cc1)))))
			;not exists n
			(not (and
				(exists ((cc2 Contribution)) (and (= (tgt cc2) c) (n cc2)))
				(not (exists ((cc3 Contribution)) (and (= (tgt cc3) c) (or (co cc3) (un cc3) (fd cc3) (pd cc3) (fs cc3) (ps cc3)))))
			))
		)
		(and
			(exists ((dc1 DependeeLink)) (and (= (srcType dc1) SOFTGOAL) (= ((as src (SoftGoal)) dc1) c) (ps dc1)))
			(not (exists ((dc2 DependeeLink)) (and (= (srcType dc2) SOFTGOAL) (= ((as src (SoftGoal)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (n dc2)))))
		)
	)
	true
	false
)))))
(assert (forall ((c SoftGoal)) (=> (and (not (inited c)) (or (co c) (un c) (fd c) (pd c) (fs c) (ps c))) (= (n c) false))))
(assert (forall ((c SoftGoal)) (=> (and (not (inited c)) (not (co c)) (not (un c)) (not (fd c)) (not (pd c)) (not (fs c)) (not (ps c))) (= (n c) true))))
;(assert (forall ((c SoftGoal)) (=> (and (not (inited c)) (not (co c)) (not (un c)) (not (fd c)) (not (pd c)) (not (fs c)) (not (ps c))) (= (n c) (ite
;	(or
;		(and
;			(not (exists ((cc Contribution)) (= (tgt cc) c)))
;			(not (exists ((dc1 DependerLink)) (and (= (srcType dc1) SOFTGOAL) (= ((as src (SoftGoal)) dc1) c))))
;			(not (exists ((dc2 DependeeLink)) (and (= (srcType dc2) SOFTGOAL) (= ((as src (SoftGoal)) dc2) c))))
;		)
;		(and
;			(exists ((cc1 Contribution)) (and (= (tgt cc1) c) (n cc1)))
;			(not (exists ((cc2 Contribution)) (and (= (tgt cc2) c) (or (co cc2) (un cc2) (fd cc2) (pd cc2) (fs cc2) (ps cc2)))))
;			(not (exists ((dc DependerLink)) (and (= (srcType dc) SOFTGOAL) (= ((as src (SoftGoal)) dc) c) (or (fd dc) (pd dc) (co dc) (un dc)))))
;		)
;		(and
;			(exists ((dc1 DependerLink)) (and (= (srcType dc1) SOFTGOAL) (= ((as src (SoftGoal)) dc1) c) (n dc1)))
;			(not (exists ((dc2 DependerLink)) (and (= (srcType dc2) SOFTGOAL) (= ((as src (SoftGoal)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2)))))
;			;not exists fd|pd|co|co_|un
;			(not (exists ((cc1 Contribution)) (and (= (tgt cc1) c) (or (co cc1) (un cc1) (fd cc1) (pd cc1)))))
;		)
;		(and
;			(exists ((dc1 DependeeLink)) (and (= (srcType dc1) SOFTGOAL) (= ((as src (SoftGoal)) dc1) c) (n dc1)))
;			(not (exists ((dc2 DependeeLink)) (and (= (srcType dc2) SOFTGOAL) (= ((as src (SoftGoal)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2)))))
;		)
;	)
;	true
;	false
;)))))

;Resource propagation (only Dependee)
(assert (forall ((c Resource)) (=> (not (inited c)) (= (fd c) (ite
	(exists ((dc DependeeLink)) (and (= (srcType dc) RESOURCE) (= ((as src (Resource)) dc) c) (fd dc)))
	true
	false
)))))
(assert (forall ((c Resource)) (=> (and (not (inited c)) (fd c))  (= (pd c) false))))
(assert (forall ((c Resource)) (=> (and (not (inited c)) (not (fd c)))  (= (pd c) (ite
	(and (exists ((dc1 DependeeLink)) (and (= (srcType dc1) RESOURCE) (= ((as src (Resource)) dc1) c) (pd dc1))) (not (exists ((dc2 DependeeLink)) (and (= (srcType dc2) RESOURCE) (= ((as src (Resource)) dc2) c) (fd dc2)))))
	true
	false
)))))
(assert (forall ((c Resource)) (=> (and (not (inited c)) (or (fd c) (pd c)))  (= (co c) false))))
(assert (forall ((c Resource)) (=> (and (not (inited c)) (not (fd c)) (not (pd c)))  (= (co c) (ite
	(and (exists ((dc1 DependeeLink)) (and (= (srcType dc1) RESOURCE) (= ((as src (Resource)) dc1) c) (co dc1))) (not (exists ((dc2 DependeeLink)) (and (= (srcType dc2) RESOURCE) (= ((as src (Resource)) dc2) c) (or (fd dc2) (pd dc2))))))
	true
	false
)))))
(assert (forall ((c Resource)) (=> (and (not (inited c)) (or (fd c) (pd c) (co c)))  (= (un c) false))))
(assert (forall ((c Resource)) (=> (and (not (inited c)) (not (fd c)) (not (pd c)) (not (co c)))  (= (un c) (ite
	(and (exists ((dc1 DependeeLink)) (and (= (srcType dc1) RESOURCE) (= ((as src (Resource)) dc1) c) (un dc1))) (not (exists ((dc2 DependeeLink)) (and (= (srcType dc2) RESOURCE) (= ((as src (Resource)) dc2) c) (or (fd dc2) (pd dc2) (co dc2))))))
	true
	false
)))))
(assert (forall ((c Resource)) (=> (and (not (inited c)) (or (fd c) (pd c) (co c) (un c)))  (= (n c) false))))
(assert (forall ((c Resource)) (=> (and (not (inited c)) (not (fd c)) (not (pd c)) (not (co c)) (not (un c)))  (= (n c) (ite
	(or
		(not (exists ((dc DependeeLink)) (and (= (srcType dc) RESOURCE) (= ((as src (Resource)) dc) c))))
		(and (exists ((dc1 DependeeLink)) (and (= (srcType dc1) RESOURCE) (= ((as src (Resource)) dc1) c) (n dc1))) (not (exists ((dc2 DependeeLink)) (and (= (srcType dc2) RESOURCE) (= ((as src (Resource)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2))))))
	)
	true
	false
)))))
(assert (forall ((c Resource)) (=> (and (not (inited c)) (or (fd c) (pd c) (co c) (un c) (n c)))  (= (ps c) false))))
(assert (forall ((c Resource)) (=> (and (not (inited c)) (not (fd c)) (not (pd c)) (not (co c)) (not (un c)) (not (n c)))  (= (ps c) (ite
	(and (exists ((dc1 DependeeLink)) (and (= (srcType dc1) RESOURCE) (= ((as src (Resource)) dc1) c) (ps dc1))) (not (exists ((dc2 DependeeLink)) (and (= (srcType dc2) RESOURCE) (= ((as src (Resource)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (n dc2))))))
	true
	false
)))))
(assert (forall ((c Resource)) (=> (and (not (inited c)) (or (fd c) (pd c) (co c) (un c) (n c) (ps c)))  (= (fs c) false))))
(assert (forall ((c Resource)) (=> (and (not (inited c)) (not (fd c)) (not (pd c)) (not (co c)) (not (un c)) (not (n c)) (not (ps c)))  (= (fs c) true))))
;(assert (forall ((c Resource)) (=> (not (inited c))  (= (fs c) (ite
;	(and (exists ((dc1 DependeeLink)) (and (= (srcType dc1) RESOURCE) (= ((as src (Resource)) dc1) c) (fs dc1))) (not (exists ((dc2 DependeeLink)) (and (= (srcType dc2) RESOURCE) (= ((as src (Resource)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (n dc2) (ps dc2))))))
;	true
;	false
;)))))
