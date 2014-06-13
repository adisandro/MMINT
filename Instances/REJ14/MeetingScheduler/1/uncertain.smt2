;Concretizations
(define-sort Node () Int)
(define-sort NodeType () Int)
(define-sort Edge () Int)
(declare-sort Actor)
(declare-fun node (Node Actor) Bool)
(declare-const ACTOR NodeType)
(assert (= ACTOR 1))
(declare-sort Task)
(declare-fun node (Node Task) Bool)
(declare-const TASK NodeType)
(assert (= TASK 2))
(declare-sort Resource)
(declare-fun node (Node Resource) Bool)
(declare-const RESOURCE NodeType)
(assert (= RESOURCE 3))
(declare-sort Goal)
(declare-fun node (Node Goal) Bool)
(declare-const GOAL NodeType)
(assert (= GOAL 4))
(declare-sort SoftGoal)
(declare-fun node (Node SoftGoal) Bool)
(declare-const SOFTGOAL NodeType)
(assert (= SOFTGOAL 5))
(declare-sort MeansEnd)
(declare-fun edge (Edge MeansEnd) Bool)
(declare-fun srcType (MeansEnd) NodeType)
(declare-fun tgtType (MeansEnd) NodeType)
(declare-fun src (MeansEnd) Task)
(declare-fun tgt (MeansEnd) Task)
(declare-fun src (MeansEnd) Resource)
(declare-fun tgt (MeansEnd) Resource)
(declare-fun src (MeansEnd) Goal)
(declare-fun tgt (MeansEnd) Goal)
(declare-fun src (MeansEnd) SoftGoal)
(declare-fun tgt (MeansEnd) SoftGoal)
(declare-sort Decomposition)
(declare-fun edge (Edge Decomposition) Bool)
(declare-fun srcType (Decomposition) NodeType)
(declare-fun tgtType (Decomposition) NodeType)
(declare-fun src (Decomposition) Task)
(declare-fun tgt (Decomposition) Task)
(declare-fun src (Decomposition) Resource)
(declare-fun tgt (Decomposition) Resource)
(declare-fun src (Decomposition) Goal)
(declare-fun tgt (Decomposition) Goal)
(declare-fun src (Decomposition) SoftGoal)
(declare-fun tgt (Decomposition) SoftGoal)
(declare-sort Contribution)
(declare-fun edge (Edge Contribution) Bool)
(declare-fun srcType (Contribution) NodeType)
(declare-fun tgtType (Contribution) NodeType)
(declare-fun src (Contribution) Task)
(declare-fun tgt (Contribution) Task)
(declare-fun src (Contribution) Resource)
(declare-fun tgt (Contribution) Resource)
(declare-fun src (Contribution) Goal)
(declare-fun tgt (Contribution) Goal)
(declare-fun src (Contribution) SoftGoal)
(declare-fun tgt (Contribution) SoftGoal)
(declare-sort DependerLink)
(declare-fun edge (Edge DependerLink) Bool)
(declare-fun srcType (DependerLink) NodeType)
(declare-fun tgtType (DependerLink) NodeType)
(declare-fun src (DependerLink) Actor)
(declare-fun src (DependerLink) Task)
(declare-fun tgt (DependerLink) Task)
(declare-fun src (DependerLink) Resource)
(declare-fun tgt (DependerLink) Resource)
(declare-fun src (DependerLink) Goal)
(declare-fun tgt (DependerLink) Goal)
(declare-fun src (DependerLink) SoftGoal)
(declare-fun tgt (DependerLink) SoftGoal)
(declare-sort DependeeLink)
(declare-fun edge (Edge DependeeLink) Bool)
(declare-fun srcType (DependeeLink) NodeType)
(declare-fun tgtType (DependeeLink) NodeType)
(declare-fun tgt (DependeeLink) Actor)
(declare-fun src (DependeeLink) Task)
(declare-fun tgt (DependeeLink) Task)
(declare-fun src (DependeeLink) Resource)
(declare-fun tgt (DependeeLink) Resource)
(declare-fun src (DependeeLink) Goal)
(declare-fun tgt (DependeeLink) Goal)
(declare-fun src (DependeeLink) SoftGoal)
(declare-fun tgt (DependeeLink) SoftGoal)

;Model
(declare-const MeetingInitiator Node);Node
(assert (= MeetingInitiator 11))
(declare-const MeetingBeScheduledMI Node);Node
(assert (= MeetingBeScheduledMI 12))
(declare-const MeetingBeScheduledMI2OrganizeMeeting Edge);Edge
(assert (= MeetingBeScheduledMI2OrganizeMeeting 13))
(declare-const WaysToOrganizeMeeting Node);Node
(assert (= WaysToOrganizeMeeting 14))
(declare-const WaysToOrganizeMeeting2MeetingBeScheduledMI Edge);Edge
(assert (= WaysToOrganizeMeeting2MeetingBeScheduledMI 15))
(declare-const WaysToOrganizeMeeting2Quick Edge);Edge
(assert (= WaysToOrganizeMeeting2Quick 16))
(declare-const WaysToOrganizeMeeting2LowEffortMI Edge);Edge
(assert (= WaysToOrganizeMeeting2LowEffortMI 17))
(declare-const LetSchedulerScheduleMeeting Node);Node
(assert (= LetSchedulerScheduleMeeting 18))
(declare-const LetSchedulerScheduleMeeting2MeetingBeScheduledMI Edge);Edge
(assert (= LetSchedulerScheduleMeeting2MeetingBeScheduledMI 19))
(declare-const LetSchedulerScheduleMeeting2Quick Edge);Edge
(assert (= LetSchedulerScheduleMeeting2Quick 20))
(declare-const LetSchedulerScheduleMeeting2LowEffortMI Edge);Edge
(assert (= LetSchedulerScheduleMeeting2LowEffortMI 21))
(declare-const OrganizeMeeting Node);Node
(assert (= OrganizeMeeting 22))
(declare-const Quick Node);Node
(assert (= Quick 23))
(declare-const Quick2OrganizeMeeting Edge);Edge
(assert (= Quick2OrganizeMeeting 24))
(declare-const LowEffortMI Node);Node
(assert (= LowEffortMI 25))
(declare-const LowEffortMI2OrganizeMeeting Edge);Edge
(assert (= LowEffortMI2OrganizeMeeting 26))
(declare-const MeetingScheduler Node);Node
(assert (= MeetingScheduler 27))
(declare-const ScheduleMeeting Node);Node
(assert (= ScheduleMeeting 28))
(declare-const MeetingParticipant Node);Node
(assert (= MeetingParticipant 29))
(declare-const ParticipateInMeeting Node);Node
(assert (= ParticipateInMeeting 30))
(declare-const AttendMeeting Node);Node
(assert (= AttendMeeting 31))
(declare-const AttendMeeting2ParticipateInMeeting Edge);Edge
(assert (= AttendMeeting2ParticipateInMeeting 32))
(declare-const ProvideDetails Node);Node
(assert (= ProvideDetails 33))
(declare-const ProvideDetails2ParticipateInMeeting Edge);Edge
(assert (= ProvideDetails2ParticipateInMeeting 34))
(declare-const AgreeableMeetingDate Node);Node
(assert (= AgreeableMeetingDate 35))
(declare-const AgreeableMeetingDate2ParticipateInMeeting Edge);Edge
(assert (= AgreeableMeetingDate2ParticipateInMeeting 36))
(declare-const ConvenientMeetingDate Node);Node
(assert (= ConvenientMeetingDate 37))
(declare-const ConvenientMeetingDate2ParticipateInMeeting Edge);Edge
(assert (= ConvenientMeetingDate2ParticipateInMeeting 38))
(declare-const DecideConvenientDates Node);Node
(assert (= DecideConvenientDates 39))
(declare-const DecideConvenientDates2ConvenientMeetingDate Edge);Edge
(assert (= DecideConvenientDates2ConvenientMeetingDate 40))
(declare-const LowEffortMP Node);Node
(assert (= LowEffortMP 41))
(declare-const LowEffortMP2ProvideDetails Edge);Edge
(assert (= LowEffortMP2ProvideDetails 42))
(declare-const UseProfiles Node);Node
(assert (= UseProfiles 43))
(declare-const UseProfiles2ParticipateInMeeting Edge);Edge
(assert (= UseProfiles2ParticipateInMeeting 44))
(declare-const DateDeterminer Node);Node
(assert (= DateDeterminer 45))
(declare-const DetermineMeetingDate Node);Node
(assert (= DetermineMeetingDate 46))
(declare-const Dependencies Node);Node
(assert (= Dependencies 47))
(declare-const OrganizeMeeting2Dependencies Edge);Edge
(assert (= OrganizeMeeting2Dependencies 48))
(declare-const Dependencies2ParticipateInMeeting Edge);Edge
(assert (= Dependencies2ParticipateInMeeting 49))
(declare-const MeetingBeScheduled Node);Node
(assert (= MeetingBeScheduled 50))
(declare-const LetSchedulerScheduleMeeting2MeetingBeScheduled Edge);Edge
(assert (= LetSchedulerScheduleMeeting2MeetingBeScheduled 51))
(declare-const MeetingBeScheduled2ScheduleMeeting Edge);Edge
(assert (= MeetingBeScheduled2ScheduleMeeting 52))
(declare-const Details Node);Node
(assert (= Details 53))
(declare-const ScheduleMeeting2Details Edge);Edge
(assert (= ScheduleMeeting2Details 54))
(declare-const Details2ProvideDetails Edge);Edge
(assert (= Details2ProvideDetails 55))
;End Model
(assert (forall ((c Decomposition)) (=>
	(edge MeetingBeScheduledMI2OrganizeMeeting c)
	(and
		(= (srcType c) GOAL)
		(= (tgtType c) TASK)
		(node MeetingBeScheduledMI ((as src (Goal)) c))
		(node OrganizeMeeting ((as tgt (Task)) c))
	)
)))
(assert (forall ((c MeansEnd)) (=>
	(edge WaysToOrganizeMeeting2MeetingBeScheduledMI c)
	(and
		(= (srcType c) TASK)
		(= (tgtType c) GOAL)
		(node WaysToOrganizeMeeting ((as src (Task)) c))
		(node MeetingBeScheduledMI ((as tgt (Goal)) c))
	)
)))
(assert (forall ((c Contribution)) (=>
	(edge WaysToOrganizeMeeting2Quick c)
	(and
		(= (srcType c) TASK)
		(= (tgtType c) SOFTGOAL)
		(node WaysToOrganizeMeeting ((as src (Task)) c))
		(node Quick ((as tgt (SoftGoal)) c))
	)
)))
(assert (forall ((c Contribution)) (=>
	(edge WaysToOrganizeMeeting2LowEffortMI c)
	(and
		(= (srcType c) TASK)
		(= (tgtType c) SOFTGOAL)
		(node WaysToOrganizeMeeting ((as src (Task)) c))
		(node LowEffortMI ((as tgt (SoftGoal)) c))
	)
)))
(assert (forall ((c MeansEnd)) (=>
	(edge LetSchedulerScheduleMeeting2MeetingBeScheduledMI c)
	(and
		(= (srcType c) TASK)
		(= (tgtType c) GOAL)
		(node LetSchedulerScheduleMeeting ((as src (Task)) c))
		(node MeetingBeScheduledMI ((as tgt (Goal)) c))
	)
)))
(assert (forall ((c Contribution)) (=>
	(edge LetSchedulerScheduleMeeting2Quick c)
	(and
		(= (srcType c) TASK)
		(= (tgtType c) SOFTGOAL)
		(node LetSchedulerScheduleMeeting ((as src (Task)) c))
		(node Quick ((as tgt (SoftGoal)) c))
	)
)))
(assert (forall ((c Contribution)) (=>
	(edge LetSchedulerScheduleMeeting2LowEffortMI c)
	(and
		(= (srcType c) TASK)
		(= (tgtType c) SOFTGOAL)
		(node LetSchedulerScheduleMeeting ((as src (Task)) c))
		(node LowEffortMI ((as tgt (SoftGoal)) c))
	)
)))
(assert (forall ((c Decomposition)) (=>
	(edge Quick2OrganizeMeeting c)
	(and
		(= (srcType c) SOFTGOAL)
		(= (tgtType c) TASK)
		(node Quick ((as src (SoftGoal)) c))
		(node OrganizeMeeting ((as tgt (Task)) c))
	)
)))
(assert (forall ((c Decomposition)) (=>
	(edge LowEffortMI2OrganizeMeeting c)
	(and
		(= (srcType c) SOFTGOAL)
		(= (tgtType c) TASK)
		(node LowEffortMI ((as src (SoftGoal)) c))
		(node OrganizeMeeting ((as tgt (Task)) c))
	)
)))
(assert (forall ((c Decomposition)) (=>
	(edge AttendMeeting2ParticipateInMeeting c)
	(and
		(= (srcType c) TASK)
		(= (tgtType c) TASK)
		(node AttendMeeting ((as src (Task)) c))
		(node ParticipateInMeeting ((as tgt (Task)) c))
	)
)))
(assert (forall ((c Decomposition)) (=>
	(edge ProvideDetails2ParticipateInMeeting c)
	(and
		(= (srcType c) TASK)
		(= (tgtType c) TASK)
		(node ProvideDetails ((as src (Task)) c))
		(node ParticipateInMeeting ((as tgt (Task)) c))
	)
)))
(assert (forall ((c Decomposition)) (=>
	(edge AgreeableMeetingDate2ParticipateInMeeting c)
	(and
		(= (srcType c) GOAL)
		(= (tgtType c) TASK)
		(node AgreeableMeetingDate ((as src (Goal)) c))
		(node ParticipateInMeeting ((as tgt (Task)) c))
	)
)))
(assert (forall ((c Decomposition)) (=>
	(edge ConvenientMeetingDate2ParticipateInMeeting c)
	(and
		(= (srcType c) GOAL)
		(= (tgtType c) TASK)
		(node ConvenientMeetingDate ((as src (Goal)) c))
		(node ParticipateInMeeting ((as tgt (Task)) c))
	)
)))
(assert (forall ((c MeansEnd)) (=>
	(edge DecideConvenientDates2ConvenientMeetingDate c)
	(and
		(= (srcType c) TASK)
		(= (tgtType c) GOAL)
		(node DecideConvenientDates ((as src (Task)) c))
		(node ConvenientMeetingDate ((as tgt (Goal)) c))
	)
)))
(assert (forall ((c Decomposition)) (=>
	(edge LowEffortMP2ProvideDetails c)
	(and
		(= (srcType c) SOFTGOAL)
		(= (tgtType c) TASK)
		(node LowEffortMP ((as src (SoftGoal)) c))
		(node ProvideDetails ((as tgt (Task)) c))
	)
)))
(assert (forall ((c Decomposition)) (=>
	(edge UseProfiles2ParticipateInMeeting c)
	(and
		(= (srcType c) TASK)
		(= (tgtType c) TASK)
		(node UseProfiles ((as src (Task)) c))
		(node ParticipateInMeeting ((as tgt (Task)) c))
	)
)))
(assert (forall ((c DependerLink)) (=>
	(edge OrganizeMeeting2Dependencies c)
	(and
		(= (srcType c) TASK)
		(= (tgtType c) GOAL)
		(node OrganizeMeeting ((as src (Task)) c))
		(node Dependencies ((as tgt (Goal)) c))
	)
)))
(assert (forall ((c DependeeLink)) (=>
	(edge Dependencies2ParticipateInMeeting c)
	(and
		(= (srcType c) GOAL)
		(= (tgtType c) TASK)
		(node Dependencies ((as src (Goal)) c))
		(node ParticipateInMeeting ((as tgt (Task)) c))
	)
)))
(assert (forall ((c DependerLink)) (=>
	(edge LetSchedulerScheduleMeeting2MeetingBeScheduled c)
	(and
		(= (srcType c) TASK)
		(= (tgtType c) GOAL)
		(node LetSchedulerScheduleMeeting ((as src (Task)) c))
		(node MeetingBeScheduled ((as tgt (Goal)) c))
	)
)))
(assert (forall ((c DependeeLink)) (=>
	(edge MeetingBeScheduled2ScheduleMeeting c)
	(and
		(= (srcType c) GOAL)
		(= (tgtType c) TASK)
		(node MeetingBeScheduled ((as src (Goal)) c))
		(node ScheduleMeeting ((as tgt (Task)) c))
	)
)))
(assert (forall ((c DependerLink)) (=>
	(edge ScheduleMeeting2Details c)
	(and
		(= (srcType c) TASK)
		(= (tgtType c) RESOURCE)
		(node ScheduleMeeting ((as src (Task)) c))
		(node Details ((as tgt (Resource)) c))
	)
)))
(assert (forall ((c DependeeLink)) (=>
	(edge Details2ProvideDetails c)
	(and
		(= (srcType c) RESOURCE)
		(= (tgtType c) TASK)
		(node Details ((as src (Resource)) c))
		(node ProvideDetails ((as tgt (Task)) c))
	)
)))

;Model is Complete
(assert	(forall ((c Actor)) (or
	(node MeetingInitiator c)
	(node MeetingScheduler c)
	(node MeetingParticipant c)
	(node DateDeterminer c)
)))
(assert	(forall ((c Task)) (or
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
(assert	(forall ((c Resource)) (or
	(node Details c)
)))
(assert	(forall ((c Goal)) (or
	(node MeetingBeScheduledMI c)
	(node AgreeableMeetingDate c)
	(node ConvenientMeetingDate c)
	(node Dependencies c)
	(node MeetingBeScheduled c)
)))
(assert	(forall ((c SoftGoal)) (or
	(node Quick c)
	(node LowEffortMI c)
	(node LowEffortMP c)
)))
(assert	(forall ((c MeansEnd)) (or
	(edge WaysToOrganizeMeeting2MeetingBeScheduledMI c)
	(edge LetSchedulerScheduleMeeting2MeetingBeScheduledMI c)
	(edge DecideConvenientDates2ConvenientMeetingDate c)
)))
(assert	(forall ((c Decomposition)) (or
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
(assert	(forall ((c Contribution)) (or
	(edge WaysToOrganizeMeeting2Quick c)
	(edge WaysToOrganizeMeeting2LowEffortMI c)
	(edge LetSchedulerScheduleMeeting2Quick c)
	(edge LetSchedulerScheduleMeeting2LowEffortMI c)
)))
(assert	(forall ((c DependerLink)) (or
	(edge OrganizeMeeting2Dependencies c)
	(edge LetSchedulerScheduleMeeting2MeetingBeScheduled c)
	(edge ScheduleMeeting2Details c)
)))
(assert	(forall ((c DependeeLink)) (or
	(edge Dependencies2ParticipateInMeeting c)
	(edge MeetingBeScheduled2ScheduleMeeting c)
	(edge Details2ProvideDetails c)
)))
;MeetingInitiator Exists
(assert (exists ((c Actor)) (node MeetingInitiator c)))
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
;MeetingBeScheduledMI Exists
(assert (exists ((c Goal)) (node MeetingBeScheduledMI c)))
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
;MeetingBeScheduledMI2OrganizeMeeting Exists
(assert (exists ((c Decomposition)) (edge MeetingBeScheduledMI2OrganizeMeeting c)))
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
		(edge AttendMeeting2ParticipateInMeeting c)
		(edge ProvideDetails2ParticipateInMeeting c)
		(edge AgreeableMeetingDate2ParticipateInMeeting c)
		(edge ConvenientMeetingDate2ParticipateInMeeting c)
		(edge LowEffortMP2ProvideDetails c)
		(edge UseProfiles2ParticipateInMeeting c)
	))
)))
;WaysToOrganizeMeeting Exists
(assert (exists ((c Task)) (node WaysToOrganizeMeeting c)))
;WaysToOrganizeMeeting is Distinct
(assert	(forall ((c Task)) (=>
	(node WaysToOrganizeMeeting c)
	(not (or
		(node LetSchedulerScheduleMeeting c)
		(node OrganizeMeeting c)
		(node ScheduleMeeting c)
		(node ParticipateInMeeting c)
		(node AttendMeeting c)
		(node ProvideDetails c)
		(node DecideConvenientDates c)
		(node UseProfiles c)
		(node DetermineMeetingDate c)
	))
)))
;WaysToOrganizeMeeting2MeetingBeScheduledMI Exists
(assert (exists ((c MeansEnd)) (edge WaysToOrganizeMeeting2MeetingBeScheduledMI c)))
;WaysToOrganizeMeeting2MeetingBeScheduledMI is Distinct
(assert	(forall ((c MeansEnd)) (=>
	(edge WaysToOrganizeMeeting2MeetingBeScheduledMI c)
	(not (or
		(edge LetSchedulerScheduleMeeting2MeetingBeScheduledMI c)
		(edge DecideConvenientDates2ConvenientMeetingDate c)
	))
)))
;WaysToOrganizeMeeting2Quick Exists
(assert (exists ((c Contribution)) (edge WaysToOrganizeMeeting2Quick c)))
;WaysToOrganizeMeeting2Quick is Distinct
(assert	(forall ((c Contribution)) (=>
	(edge WaysToOrganizeMeeting2Quick c)
	(not (or
		(edge WaysToOrganizeMeeting2LowEffortMI c)
		(edge LetSchedulerScheduleMeeting2Quick c)
		(edge LetSchedulerScheduleMeeting2LowEffortMI c)
	))
)))
;WaysToOrganizeMeeting2LowEffortMI Exists
(assert (exists ((c Contribution)) (edge WaysToOrganizeMeeting2LowEffortMI c)))
;WaysToOrganizeMeeting2LowEffortMI is Distinct
(assert	(forall ((c Contribution)) (=>
	(edge WaysToOrganizeMeeting2LowEffortMI c)
	(not (or
		(edge WaysToOrganizeMeeting2Quick c)
		(edge LetSchedulerScheduleMeeting2Quick c)
		(edge LetSchedulerScheduleMeeting2LowEffortMI c)
	))
)))
;LetSchedulerScheduleMeeting Exists
(assert (exists ((c Task)) (node LetSchedulerScheduleMeeting c)))
;LetSchedulerScheduleMeeting is Unique
(assert	(forall ((c1 Task) (c2 Task)) (=>
	(and (node LetSchedulerScheduleMeeting c1) (node LetSchedulerScheduleMeeting c2))
	(= c1 c2)
)))
;LetSchedulerScheduleMeeting is Distinct
(assert	(forall ((c Task)) (=>
	(node LetSchedulerScheduleMeeting c)
	(not (or
		(node WaysToOrganizeMeeting c)
		(node OrganizeMeeting c)
		(node ScheduleMeeting c)
		(node ParticipateInMeeting c)
		(node AttendMeeting c)
		(node ProvideDetails c)
		(node DecideConvenientDates c)
		(node UseProfiles c)
		(node DetermineMeetingDate c)
	))
)))
;LetSchedulerScheduleMeeting2MeetingBeScheduledMI Exists
(assert (exists ((c MeansEnd)) (edge LetSchedulerScheduleMeeting2MeetingBeScheduledMI c)))
;LetSchedulerScheduleMeeting2MeetingBeScheduledMI is Unique
(assert	(forall ((c1 MeansEnd) (c2 MeansEnd)) (=>
	(and (edge LetSchedulerScheduleMeeting2MeetingBeScheduledMI c1) (edge LetSchedulerScheduleMeeting2MeetingBeScheduledMI c2))
	(= c1 c2)
)))
;LetSchedulerScheduleMeeting2MeetingBeScheduledMI is Distinct
(assert	(forall ((c MeansEnd)) (=>
	(edge LetSchedulerScheduleMeeting2MeetingBeScheduledMI c)
	(not (or
		(edge WaysToOrganizeMeeting2MeetingBeScheduledMI c)
		(edge DecideConvenientDates2ConvenientMeetingDate c)
	))
)))
;LetSchedulerScheduleMeeting2Quick Exists
(assert (exists ((c Contribution)) (edge LetSchedulerScheduleMeeting2Quick c)))
;LetSchedulerScheduleMeeting2Quick is Unique
(assert	(forall ((c1 Contribution) (c2 Contribution)) (=>
	(and (edge LetSchedulerScheduleMeeting2Quick c1) (edge LetSchedulerScheduleMeeting2Quick c2))
	(= c1 c2)
)))
;LetSchedulerScheduleMeeting2Quick is Distinct
(assert	(forall ((c Contribution)) (=>
	(edge LetSchedulerScheduleMeeting2Quick c)
	(not (or
		(edge WaysToOrganizeMeeting2Quick c)
		(edge WaysToOrganizeMeeting2LowEffortMI c)
		(edge LetSchedulerScheduleMeeting2LowEffortMI c)
	))
)))
;LetSchedulerScheduleMeeting2LowEffortMI Exists
(assert (exists ((c Contribution)) (edge LetSchedulerScheduleMeeting2LowEffortMI c)))
;LetSchedulerScheduleMeeting2LowEffortMI is Unique
(assert	(forall ((c1 Contribution) (c2 Contribution)) (=>
	(and (edge LetSchedulerScheduleMeeting2LowEffortMI c1) (edge LetSchedulerScheduleMeeting2LowEffortMI c2))
	(= c1 c2)
)))
;LetSchedulerScheduleMeeting2LowEffortMI is Distinct
(assert	(forall ((c Contribution)) (=>
	(edge LetSchedulerScheduleMeeting2LowEffortMI c)
	(not (or
		(edge WaysToOrganizeMeeting2Quick c)
		(edge WaysToOrganizeMeeting2LowEffortMI c)
		(edge LetSchedulerScheduleMeeting2Quick c)
	))
)))
;OrganizeMeeting Exists
(assert (exists ((c Task)) (node OrganizeMeeting c)))
;OrganizeMeeting is Unique
(assert	(forall ((c1 Task) (c2 Task)) (=>
	(and (node OrganizeMeeting c1) (node OrganizeMeeting c2))
	(= c1 c2)
)))
;OrganizeMeeting is Distinct
(assert	(forall ((c Task)) (=>
	(node OrganizeMeeting c)
	(not (or
		(node WaysToOrganizeMeeting c)
		(node LetSchedulerScheduleMeeting c)
		(node ScheduleMeeting c)
		(node ParticipateInMeeting c)
		(node AttendMeeting c)
		(node ProvideDetails c)
		(node DecideConvenientDates c)
		(node UseProfiles c)
		(node DetermineMeetingDate c)
	))
)))
;Quick Exists
(assert (exists ((c SoftGoal)) (node Quick c)))
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
;Quick2OrganizeMeeting Exists
(assert (exists ((c Decomposition)) (edge Quick2OrganizeMeeting c)))
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
		(edge AttendMeeting2ParticipateInMeeting c)
		(edge ProvideDetails2ParticipateInMeeting c)
		(edge AgreeableMeetingDate2ParticipateInMeeting c)
		(edge ConvenientMeetingDate2ParticipateInMeeting c)
		(edge LowEffortMP2ProvideDetails c)
		(edge UseProfiles2ParticipateInMeeting c)
	))
)))
;LowEffortMI Exists
(assert (exists ((c SoftGoal)) (node LowEffortMI c)))
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
;LowEffortMI2OrganizeMeeting Exists
(assert (exists ((c Decomposition)) (edge LowEffortMI2OrganizeMeeting c)))
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
		(edge AttendMeeting2ParticipateInMeeting c)
		(edge ProvideDetails2ParticipateInMeeting c)
		(edge AgreeableMeetingDate2ParticipateInMeeting c)
		(edge ConvenientMeetingDate2ParticipateInMeeting c)
		(edge LowEffortMP2ProvideDetails c)
		(edge UseProfiles2ParticipateInMeeting c)
	))
)))
;MeetingScheduler Exists
(assert (exists ((c Actor)) (node MeetingScheduler c)))
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
;ScheduleMeeting Exists
(assert (exists ((c Task)) (node ScheduleMeeting c)))
;ScheduleMeeting is Unique
(assert	(forall ((c1 Task) (c2 Task)) (=>
	(and (node ScheduleMeeting c1) (node ScheduleMeeting c2))
	(= c1 c2)
)))
;ScheduleMeeting is Distinct
(assert	(forall ((c Task)) (=>
	(node ScheduleMeeting c)
	(not (or
		(node WaysToOrganizeMeeting c)
		(node LetSchedulerScheduleMeeting c)
		(node OrganizeMeeting c)
		(node ParticipateInMeeting c)
		(node AttendMeeting c)
		(node ProvideDetails c)
		(node DecideConvenientDates c)
		(node UseProfiles c)
		(node DetermineMeetingDate c)
	))
)))
;MeetingParticipant Exists
(assert (exists ((c Actor)) (node MeetingParticipant c)))
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
;ParticipateInMeeting Exists
(assert (exists ((c Task)) (node ParticipateInMeeting c)))
;ParticipateInMeeting is Unique
(assert	(forall ((c1 Task) (c2 Task)) (=>
	(and (node ParticipateInMeeting c1) (node ParticipateInMeeting c2))
	(= c1 c2)
)))
;ParticipateInMeeting is Distinct
(assert	(forall ((c Task)) (=>
	(node ParticipateInMeeting c)
	(not (or
		(node WaysToOrganizeMeeting c)
		(node LetSchedulerScheduleMeeting c)
		(node OrganizeMeeting c)
		(node ScheduleMeeting c)
		(node AttendMeeting c)
		(node ProvideDetails c)
		(node DecideConvenientDates c)
		(node UseProfiles c)
		(node DetermineMeetingDate c)
	))
)))
;AttendMeeting Exists
(assert (exists ((c Task)) (node AttendMeeting c)))
;AttendMeeting is Unique
(assert	(forall ((c1 Task) (c2 Task)) (=>
	(and (node AttendMeeting c1) (node AttendMeeting c2))
	(= c1 c2)
)))
;AttendMeeting is Distinct
(assert	(forall ((c Task)) (=>
	(node AttendMeeting c)
	(not (or
		(node WaysToOrganizeMeeting c)
		(node LetSchedulerScheduleMeeting c)
		(node OrganizeMeeting c)
		(node ScheduleMeeting c)
		(node ParticipateInMeeting c)
		(node ProvideDetails c)
		(node DecideConvenientDates c)
		(node UseProfiles c)
		(node DetermineMeetingDate c)
	))
)))
;AttendMeeting2ParticipateInMeeting Exists
(assert (exists ((c Decomposition)) (edge AttendMeeting2ParticipateInMeeting c)))
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
		(edge ProvideDetails2ParticipateInMeeting c)
		(edge AgreeableMeetingDate2ParticipateInMeeting c)
		(edge ConvenientMeetingDate2ParticipateInMeeting c)
		(edge LowEffortMP2ProvideDetails c)
		(edge UseProfiles2ParticipateInMeeting c)
	))
)))
;ProvideDetails is Distinct
(assert	(forall ((c Task)) (=>
	(node ProvideDetails c)
	(not (or
		(node WaysToOrganizeMeeting c)
		(node LetSchedulerScheduleMeeting c)
		(node OrganizeMeeting c)
		(node ScheduleMeeting c)
		(node ParticipateInMeeting c)
		(node AttendMeeting c)
		(node DecideConvenientDates c)
		(node UseProfiles c)
		(node DetermineMeetingDate c)
	))
)))
;ProvideDetails2ParticipateInMeeting is Distinct
(assert	(forall ((c Decomposition)) (=>
	(edge ProvideDetails2ParticipateInMeeting c)
	(not (or
		(edge MeetingBeScheduledMI2OrganizeMeeting c)
		(edge Quick2OrganizeMeeting c)
		(edge LowEffortMI2OrganizeMeeting c)
		(edge AttendMeeting2ParticipateInMeeting c)
		(edge AgreeableMeetingDate2ParticipateInMeeting c)
		(edge ConvenientMeetingDate2ParticipateInMeeting c)
		(edge LowEffortMP2ProvideDetails c)
		(edge UseProfiles2ParticipateInMeeting c)
	))
)))
;AgreeableMeetingDate Exists
(assert (exists ((c Goal)) (node AgreeableMeetingDate c)))
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
		(node Dependencies c)
		(node MeetingBeScheduled c)
	))
)))
;AgreeableMeetingDate2ParticipateInMeeting Exists
(assert (exists ((c Decomposition)) (edge AgreeableMeetingDate2ParticipateInMeeting c)))
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
		(edge AttendMeeting2ParticipateInMeeting c)
		(edge ProvideDetails2ParticipateInMeeting c)
		(edge LowEffortMP2ProvideDetails c)
		(edge UseProfiles2ParticipateInMeeting c)
	))
)))
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
		(node Dependencies c)
		(node MeetingBeScheduled c)
	))
)))
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
		(edge AttendMeeting2ParticipateInMeeting c)
		(edge ProvideDetails2ParticipateInMeeting c)
		(edge LowEffortMP2ProvideDetails c)
		(edge UseProfiles2ParticipateInMeeting c)
	))
)))
;DecideConvenientDates is Unique
(assert	(forall ((c1 Task) (c2 Task)) (=>
	(and (node DecideConvenientDates c1) (node DecideConvenientDates c2))
	(= c1 c2)
)))
;DecideConvenientDates is Distinct
(assert	(forall ((c Task)) (=>
	(node DecideConvenientDates c)
	(not (or
		(node WaysToOrganizeMeeting c)
		(node LetSchedulerScheduleMeeting c)
		(node OrganizeMeeting c)
		(node ScheduleMeeting c)
		(node ParticipateInMeeting c)
		(node AttendMeeting c)
		(node ProvideDetails c)
		(node UseProfiles c)
		(node DetermineMeetingDate c)
	))
)))
;DecideConvenientDates2ConvenientMeetingDate is Unique
(assert	(forall ((c1 MeansEnd) (c2 MeansEnd)) (=>
	(and (edge DecideConvenientDates2ConvenientMeetingDate c1) (edge DecideConvenientDates2ConvenientMeetingDate c2))
	(= c1 c2)
)))
;DecideConvenientDates2ConvenientMeetingDate is Distinct
(assert	(forall ((c MeansEnd)) (=>
	(edge DecideConvenientDates2ConvenientMeetingDate c)
	(not (or
		(edge WaysToOrganizeMeeting2MeetingBeScheduledMI c)
		(edge LetSchedulerScheduleMeeting2MeetingBeScheduledMI c)
	))
)))
;LowEffortMP Exists
(assert (exists ((c SoftGoal)) (node LowEffortMP c)))
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
;LowEffortMP2ProvideDetails is Distinct
(assert	(forall ((c Decomposition)) (=>
	(edge LowEffortMP2ProvideDetails c)
	(not (or
		(edge MeetingBeScheduledMI2OrganizeMeeting c)
		(edge Quick2OrganizeMeeting c)
		(edge LowEffortMI2OrganizeMeeting c)
		(edge AttendMeeting2ParticipateInMeeting c)
		(edge ProvideDetails2ParticipateInMeeting c)
		(edge AgreeableMeetingDate2ParticipateInMeeting c)
		(edge ConvenientMeetingDate2ParticipateInMeeting c)
		(edge UseProfiles2ParticipateInMeeting c)
	))
)))
;UseProfiles is Unique
(assert	(forall ((c1 Task) (c2 Task)) (=>
	(and (node UseProfiles c1) (node UseProfiles c2))
	(= c1 c2)
)))
;UseProfiles is Distinct
(assert	(forall ((c Task)) (=>
	(node UseProfiles c)
	(not (or
		(node WaysToOrganizeMeeting c)
		(node LetSchedulerScheduleMeeting c)
		(node OrganizeMeeting c)
		(node ScheduleMeeting c)
		(node ParticipateInMeeting c)
		(node AttendMeeting c)
		(node ProvideDetails c)
		(node DecideConvenientDates c)
		(node DetermineMeetingDate c)
	))
)))
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
		(edge AttendMeeting2ParticipateInMeeting c)
		(edge ProvideDetails2ParticipateInMeeting c)
		(edge AgreeableMeetingDate2ParticipateInMeeting c)
		(edge ConvenientMeetingDate2ParticipateInMeeting c)
		(edge LowEffortMP2ProvideDetails c)
	))
)))
;DateDeterminer Exists
(assert (exists ((c Actor)) (node DateDeterminer c)))
;DateDeterminer is Unique
(assert	(forall ((c1 Actor) (c2 Actor)) (=>
	(and (node DateDeterminer c1) (node DateDeterminer c2))
	(= c1 c2)
)))
;DetermineMeetingDate Exists
(assert (exists ((c Task)) (node DetermineMeetingDate c)))
;DetermineMeetingDate is Unique
(assert	(forall ((c1 Task) (c2 Task)) (=>
	(and (node DetermineMeetingDate c1) (node DetermineMeetingDate c2))
	(= c1 c2)
)))
;DetermineMeetingDate is Distinct
(assert	(forall ((c Task)) (=>
	(node DetermineMeetingDate c)
	(not (or
		(node WaysToOrganizeMeeting c)
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
;OrganizeMeeting2Dependencies is Distinct
(assert	(forall ((c DependerLink)) (=>
	(edge OrganizeMeeting2Dependencies c)
	(not (or
		(edge LetSchedulerScheduleMeeting2MeetingBeScheduled c)
		(edge ScheduleMeeting2Details c)
	))
)))
;Dependencies2ParticipateInMeeting is Distinct
(assert	(forall ((c DependeeLink)) (=>
	(edge Dependencies2ParticipateInMeeting c)
	(not (or
		(edge MeetingBeScheduled2ScheduleMeeting c)
		(edge Details2ProvideDetails c)
	))
)))
;MeetingBeScheduled Exists
(assert (exists ((c Goal)) (node MeetingBeScheduled c)))
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
;LetSchedulerScheduleMeeting2MeetingBeScheduled Exists
(assert (exists ((c DependerLink)) (edge LetSchedulerScheduleMeeting2MeetingBeScheduled c)))
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
;MeetingBeScheduled2ScheduleMeeting Exists
(assert (exists ((c DependeeLink)) (edge MeetingBeScheduled2ScheduleMeeting c)))
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
;Details Exists
(assert (exists ((c Resource)) (node Details c)))
;ScheduleMeeting2Details Exists
(assert (exists ((c DependerLink)) (edge ScheduleMeeting2Details c)))
;ScheduleMeeting2Details is Distinct
(assert	(forall ((c DependerLink)) (=>
	(edge ScheduleMeeting2Details c)
	(not (or
		(edge OrganizeMeeting2Dependencies c)
		(edge LetSchedulerScheduleMeeting2MeetingBeScheduled c)
	))
)))
;Details2ProvideDetails is Distinct
(assert	(forall ((c DependeeLink)) (=>
	(edge Details2ProvideDetails c)
	(not (or
		(edge Dependencies2ParticipateInMeeting c)
		(edge MeetingBeScheduled2ScheduleMeeting c)
	))
)))

;Contribution Types
(define-sort ContributionType () Int)
(declare-const MAKE ContributionType)
(assert (= MAKE 56))
(declare-const HELP ContributionType)
(assert (= HELP 57))
(declare-const SOMEPLUS ContributionType)
(assert (= SOMEPLUS 58))
(declare-const BREAK ContributionType)
(assert (= BREAK 59))
(declare-const HURT ContributionType)
(assert (= HURT 60))
(declare-const SOMEMINUS ContributionType)
(assert (= SOMEMINUS 61))
(declare-const UNKNOWN ContributionType)
(assert (= UNKNOWN 62))
(declare-fun type (Contribution) ContributionType)
(assert (forall ((c Contribution)) (=>
	(edge WaysToOrganizeMeeting2Quick c)
	(= (type c) UNKNOWN)
)))
(assert (forall ((c Contribution)) (=>
	(edge WaysToOrganizeMeeting2LowEffortMI c)
	(= (type c) UNKNOWN)
)))
(assert (forall ((c Contribution)) (=>
	(edge LetSchedulerScheduleMeeting2Quick c)
	(= (type c) HELP)
)))
(assert (forall ((c Contribution)) (=>
	(edge LetSchedulerScheduleMeeting2LowEffortMI c)
	(= (type c) HELP)
)))

;No self-loops:
;;MeansEnd can't
;;Decomposition only from Task to Task
;;Contribution only from SoftGoal to SoftGoal
;;Depender and Dependee only if there are dependencies among dependums
(assert (forall ((c Decomposition)) (=>
	(and (= (srcType c) TASK) (= (tgtType c) TASK))
	(not (= ((as src (Task)) c) ((as tgt (Task)) c)))
)))
(assert (forall ((c Contribution)) (=>
	(and (= (srcType c) SOFTGOAL) (= (tgtType c) SOFTGOAL))
	(not (= ((as src (SoftGoal)) c) ((as tgt (SoftGoal)) c)))
)))
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
(declare-fun no (Task) Bool)
(declare-fun no (Goal) Bool)
(declare-fun no (SoftGoal) Bool)
(declare-fun no (Resource) Bool)
(declare-fun no (MeansEnd) Bool)
(declare-fun no (Decomposition) Bool)
(declare-fun no (Contribution) Bool)
(declare-fun no (DependerLink) Bool)
(declare-fun no (DependeeLink) Bool)
(assert (forall ((c MeansEnd)) (= (fs c)
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
(assert (forall ((c MeansEnd)) (= (ps c)
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
(assert (forall ((c MeansEnd)) (= (un c)
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
(assert (forall ((c MeansEnd)) (= (co c)
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
(assert (forall ((dc MeansEnd)) (= (pd dc)
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
(assert (forall ((c MeansEnd)) (= (fd c)
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
(assert (forall ((c MeansEnd)) (= (no c)
	(ite (= (srcType c) TASK)
		(no ((as src (Task)) c))
		(ite (= (srcType c) GOAL)
			(no ((as src (Goal)) c))
			(ite (= (srcType c) SOFTGOAL)
				(no ((as src (SoftGoal)) c))
				(no ((as src (Resource)) c))
			)
		)
	)
)))
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
(assert (forall ((c Decomposition)) (= (no c)
	(ite (= (srcType c) TASK)
		(no ((as src (Task)) c))
		(ite (= (srcType c) GOAL)
			(no ((as src (Goal)) c))
			(ite (= (srcType c) SOFTGOAL)
				(no ((as src (SoftGoal)) c))
				(no ((as src (Resource)) c))
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
(assert (forall ((c Contribution)) (= (no c)
	(ite (= (srcType c) TASK)
		(no ((as src (Task)) c))
		(ite (= (srcType c) GOAL)
			(no ((as src (Goal)) c))
			(ite (= (srcType c) SOFTGOAL)
				(no ((as src (SoftGoal)) c))
				(no ((as src (Resource)) c))
			)
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
(assert (forall ((c DependerLink)) (= (no c)
	(ite (= (tgtType c) TASK)
		(no ((as tgt (Task)) c))
		(ite (= (tgtType c) GOAL)
			(no ((as tgt (Goal)) c))
			(ite (= (tgtType c) SOFTGOAL)
				(no ((as tgt (SoftGoal)) c))
				(no ((as tgt (Resource)) c))
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
(assert (forall ((c DependeeLink)) (= (no c)
	(ite (= (tgtType c) TASK)
		(no ((as tgt (Task)) c))
		(ite (= (tgtType c) GOAL)
			(no ((as tgt (Goal)) c))
			(ite (= (tgtType c) SOFTGOAL)
				(no ((as tgt (SoftGoal)) c))
				(no ((as tgt (Resource)) c))
			)
		)
	)
)))

;Only one analysis label
(assert (forall ((c Task)) (xor (fs c) (ps c) (un c) (co c) (pd c) (fd c) (no c))))
(assert (forall ((c Goal)) (xor (fs c) (ps c) (un c) (co c) (pd c) (fd c) (no c))))
(assert (forall ((c SoftGoal)) (xor (fs c) (ps c) (un c) (co c) (pd c) (fd c) (no c))))
(assert (forall ((c Resource)) (xor (fs c) (ps c) (un c) (co c) (pd c) (fd c) (no c))))

;Initial labels
(assert (forall ((c Goal)) (=>
	(node MeetingBeScheduledMI c)
	(= (inited c) false)
)))
(assert (forall ((c Task)) (=>
	(node WaysToOrganizeMeeting c)
	(= (inited c) false)
)))
(assert (forall ((c Task)) (=>
	(node LetSchedulerScheduleMeeting c)
	(= (inited c) false)
)))
(assert (forall ((c Task)) (=>
	(node OrganizeMeeting c)
	(and
		(= (fs c) false)
		(= (ps c) false)
		(= (un c) true)
		(= (co c) false)
		(= (pd c) false)
		(= (fd c) false)
		(= (no c) false)
		(= (inited c) true)
	)
)))
(assert (forall ((c SoftGoal)) (=>
	(node Quick c)
	(= (inited c) false)
)))
(assert (forall ((c SoftGoal)) (=>
	(node LowEffortMI c)
	(= (inited c) false)
)))
(assert (forall ((c Task)) (=>
	(node ScheduleMeeting c)
	(= (inited c) false)
)))
(assert (forall ((c Task)) (=>
	(node ParticipateInMeeting c)
	(and
		(= (fs c) true)
		(= (ps c) false)
		(= (un c) false)
		(= (co c) false)
		(= (pd c) false)
		(= (fd c) false)
		(= (no c) false)
		(= (inited c) true)
	)
)))
(assert (forall ((c Task)) (=>
	(node AttendMeeting c)
	(= (inited c) false)
)))
(assert (forall ((c Task)) (=>
	(node ProvideDetails c)
	(= (inited c) false)
)))
(assert (forall ((c Goal)) (=>
	(node AgreeableMeetingDate c)
	(= (inited c) false)
)))
(assert (forall ((c Goal)) (=>
	(node ConvenientMeetingDate c)
	(= (inited c) false)
)))
(assert (forall ((c Task)) (=>
	(node DecideConvenientDates c)
	(= (inited c) false)
)))
(assert (forall ((c SoftGoal)) (=>
	(node LowEffortMP c)
	(= (inited c) false)
)))
(assert (forall ((c Task)) (=>
	(node UseProfiles c)
	(= (inited c) false)
)))
(assert (forall ((c Task)) (=>
	(node DetermineMeetingDate c)
	(and
		(= (fs c) true)
		(= (ps c) false)
		(= (un c) false)
		(= (co c) false)
		(= (pd c) false)
		(= (fd c) false)
		(= (no c) false)
		(= (inited c) true)
	)
)))
(assert (forall ((c Goal)) (=>
	(node Dependencies c)
	(= (inited c) false)
)))
(assert (forall ((c Goal)) (=>
	(node MeetingBeScheduled c)
	(= (inited c) false)
)))
(assert (forall ((c Resource)) (=>
	(node Details c)
	(= (inited c) false)
)))

;Goal propagation (MeansEnd + Depender + Dependee)
(assert	(forall ((c Goal)) (=> (not (inited c)) (= (fs c) (ite
	(or
		(and (exists ((mec MeansEnd)) (and (= (tgtType mec) GOAL) (= ((as tgt (Goal)) mec) c) (fs mec))) (not (exists ((dc DependerLink)) (and (= (srcType dc) GOAL) (= ((as src (Goal)) dc) c) (or (fd dc) (pd dc) (co dc) (un dc) (no dc) (ps dc))))))
		(and (exists ((dc1 DependerLink)) (and (= (srcType dc1) GOAL) (= ((as src (Goal)) dc1) c) (fs dc1))) (not (exists ((dc2 DependerLink)) (and (= (srcType dc2) GOAL) (= ((as src (Goal)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (no dc2) (ps dc2))))))
		(and (exists ((dc1 DependeeLink)) (and (= (srcType dc1) GOAL) (= ((as src (Goal)) dc1) c) (fs dc1))) (not (exists ((dc2 DependeeLink)) (and (= (srcType dc2) GOAL) (= ((as src (Goal)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (no dc2) (ps dc2))))))
	)
	true
	false
)))))
(assert	(forall ((c Goal)) (=> (and (not (inited c)) (fs c)) (= (ps c) false))))
(assert	(forall ((c Goal)) (=> (and (not (inited c)) (not (fs c))) (= (ps c) (ite
	(or
		(and (exists ((mec1 MeansEnd)) (and (= (tgtType mec1) GOAL) (= ((as tgt (Goal)) mec1) c) (ps mec1))) (and (not (exists ((mec2 MeansEnd)) (and (= (tgtType mec2) GOAL) (= ((as tgt (Goal)) mec2) c) (fs mec2)))) (not (exists ((dc DependerLink)) (and (= (srcType dc) GOAL) (= ((as src (Goal)) dc) c) (or (fd dc) (pd dc) (co dc) (un dc) (no dc)))))))
		(and (exists ((dc1 DependerLink)) (and (= (srcType dc1) GOAL) (= ((as src (Goal)) dc1) c) (ps dc1))) (not (exists ((dc2 DependerLink)) (and (= (srcType dc2) GOAL) (= ((as src (Goal)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (no dc2))))))
		(and (exists ((dc1 DependeeLink)) (and (= (srcType dc1) GOAL) (= ((as src (Goal)) dc1) c) (ps dc1))) (not (exists ((dc2 DependeeLink)) (and (= (srcType dc2) GOAL) (= ((as src (Goal)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (no dc2))))))
	)
	true
	false
)))))
(assert	(forall ((c Goal)) (=> (and (not (inited c)) (or (fs c) (ps c))) (= (no c) false))))
(assert	(forall ((c Goal)) (=> (and (not (inited c)) (not (fs c)) (not (ps c))) (= (no c) (ite
	(or
		(and (not (exists ((mec MeansEnd)) (and (= (tgtType mec) GOAL) (= ((as tgt (Goal)) mec) c)))) (not (exists ((dc1 DependerLink)) (and (= (srcType dc1) GOAL) (= ((as src (Goal)) dc1) c)))) (not (exists ((dc2 DependeeLink)) (and (= (srcType dc2) GOAL) (= ((as src (Goal)) dc2) c)))))
		(and (exists ((mec1 MeansEnd)) (and (= (tgtType mec1) GOAL) (= ((as tgt (Goal)) mec1) c) (no mec1))) (and (not (exists ((mec2 MeansEnd)) (and (= (tgtType mec2) GOAL) (= ((as tgt (Goal)) mec2) c) (or (fs mec2) (ps mec2) (un mec2) (co mec2) (pd mec2) (fd mec2))))) (not (exists ((dc DependerLink)) (and (= (srcType dc) GOAL) (= ((as src (Goal)) dc) c) (or (fd dc) (pd dc) (co dc) (un dc)))))))
		(and (exists ((dc1 DependerLink)) (and (= (srcType dc1) GOAL) (= ((as src (Goal)) dc1) c) (no dc1))) (not (exists ((dc2 DependerLink)) (and (= (srcType dc2) GOAL) (= ((as src (Goal)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2))))))
		(and (exists ((dc1 DependeeLink)) (and (= (srcType dc1) GOAL) (= ((as src (Goal)) dc1) c) (no dc1))) (not (exists ((dc2 DependeeLink)) (and (= (srcType dc2) GOAL) (= ((as src (Goal)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2))))))
	)
	true
	false
)))))
(assert	(forall ((c Goal)) (=> (and (not (inited c)) (or (fs c) (ps c) (no c))) (= (un c) false))))
(assert	(forall ((c Goal)) (=> (and (not (inited c)) (not (fs c)) (not (ps c)) (not (no c))) (= (un c) (ite
	(or
		(and (exists ((mec1 MeansEnd)) (and (= (tgtType mec1) GOAL) (= ((as tgt (Goal)) mec1) c) (un mec1))) (and (not (exists ((mec2 MeansEnd)) (and (= (tgtType mec2) GOAL) (= ((as tgt (Goal)) mec2) c) (or (fs mec2) (ps mec2))))) (not (exists ((dc DependerLink)) (and (= (srcType dc) GOAL) (= ((as src (Goal)) dc) c) (or (fd dc) (pd dc) (co dc)))))))
		(and (exists ((dc1 DependerLink)) (and (= (srcType dc1) GOAL) (= ((as src (Goal)) dc1) c) (un dc1))) (not (exists ((dc2 DependerLink)) (and (= (srcType dc2) GOAL) (= ((as src (Goal)) dc2) c) (or (fd dc2) (pd dc2) (co dc2))))))
		(and (exists ((dc1 DependeeLink)) (and (= (srcType dc1) GOAL) (= ((as src (Goal)) dc1) c) (un dc1))) (not (exists ((dc2 DependeeLink)) (and (= (srcType dc2) GOAL) (= ((as src (Goal)) dc2) c) (or (fd dc2) (pd dc2) (co dc2))))))
	)
	true
	false
)))))
(assert	(forall ((c Goal)) (=> (and (not (inited c)) (or (fs c) (ps c) (no c) (un c))) (= (co c) false))))
(assert	(forall ((c Goal)) (=> (and (not (inited c)) (not (fs c)) (not (ps c)) (not (no c)) (not (un c))) (= (co c) (ite
	(or
		(and (exists ((mec1 MeansEnd)) (and (= (tgtType mec1) GOAL) (= ((as tgt (Goal)) mec1) c) (co mec1))) (and (not (exists ((mec2 MeansEnd)) (and (= (tgtType mec2) GOAL) (= ((as tgt (Goal)) mec2) c) (or (fs mec2) (ps mec2) (un mec2))))) (not (exists ((dc DependerLink)) (and (= (srcType dc) GOAL) (= ((as src (Goal)) dc) c) (or (fd dc) (pd dc)))))))
		(and (exists ((dc1 DependerLink)) (and (= (srcType dc1) GOAL) (= ((as src (Goal)) dc1) c) (co dc1))) (not (exists ((dc2 DependerLink)) (and (= (srcType dc2) GOAL) (= ((as src (Goal)) dc2) c) (or (fd dc2) (pd dc2))))))
		(and (exists ((dc1 DependeeLink)) (and (= (srcType dc1) GOAL) (= ((as src (Goal)) dc1) c) (co dc1))) (not (exists ((dc2 DependeeLink)) (and (= (srcType dc2) GOAL) (= ((as src (Goal)) dc2) c) (or (fd dc2) (pd dc2))))))
	)
	true
	false
)))))
(assert	(forall ((c Goal)) (=> (and (not (inited c)) (or (fs c) (ps c) (no c) (un c) (co c))) (= (pd c) false))))
(assert	(forall ((c Goal)) (=> (and (not (inited c)) (not (fs c)) (not (ps c)) (not (no c)) (not (un c)) (not (co c))) (= (pd c) (ite
	(or
		(and (exists ((mec1 MeansEnd)) (and (= (tgtType mec1) GOAL) (= ((as tgt (Goal)) mec1) c) (pd mec1))) (and (not (exists ((mec2 MeansEnd)) (and (= (tgtType mec2) GOAL) (= ((as tgt (Goal)) mec2) c) (or (fs mec2) (ps mec2) (un mec2) (co mec2))))) (not (exists ((dc DependerLink)) (and (= (srcType dc) GOAL) (= ((as src (Goal)) dc) c) (fd dc))))))
		(and (exists ((dc1 DependerLink)) (and (= (srcType dc1) GOAL) (= ((as src (Goal)) dc1) c) (pd dc1))) (not (exists ((dc2 DependerLink)) (and (= (srcType dc2) GOAL) (= ((as src (Goal)) dc2) c) (fd dc2)))))
		(and (exists ((dc1 DependeeLink)) (and (= (srcType dc1) GOAL) (= ((as src (Goal)) dc1) c) (pd dc1))) (not (exists ((dc2 DependeeLink)) (and (= (srcType dc2) GOAL) (= ((as src (Goal)) dc2) c) (fd dc2)))))
	)
	true
	false
)))))
(assert	(forall ((c Goal)) (=> (and (not (inited c)) (or (fs c) (ps c) (no c) (un c) (co c) (pd c))) (= (fd c) false))))
(assert	(forall ((c Goal)) (=> (and (not (inited c)) (not (fs c)) (not (ps c)) (not (no c)) (not (un c)) (not (co c)) (not (pd c))) (= (fd c) true))))
;(assert	(forall ((c Goal)) (=> (not (inited c)) (= (fd c) (ite
;	(or
;		(and (exists ((mec1 MeansEnd)) (and (= (tgtType mec1) GOAL) (= ((as tgt (Goal)) mec1) c) (fd mec1))) (not (exists ((mec2 MeansEnd)) (and (= (tgtType mec2) GOAL) (= ((as tgt (Goal)) mec2) c) (or (fs mec2) (ps mec2) (un mec2) (co mec2) (pd mec2))))))
;		(exists ((dc DependerLink)) (and (= (srcType dc) GOAL) (= ((as src (Goal)) dc) c) (fd dc)))
;		(exists ((dc DependeeLink)) (and (= (srcType dc) GOAL) (= ((as src (Goal)) dc) c) (fd dc)))
;	)
;	true
;	false
;)))))

;Task propagation (Decomposition + Depender)
(assert (forall ((c Task)) (=> (not (inited c)) (= (fd c) (ite
	(or
		(exists ((dc Decomposition)) (and (= (tgtType dc) TASK) (= ((as tgt (Task)) dc) c) (fd dc)))
		(exists ((dc DependerLink)) (and (= (srcType dc) TASK) (= ((as src (Task)) dc) c) (fd dc)))
	)
	true
	false
)))))
(assert (forall ((c Task)) (=> (and (not (inited c)) (fd c))  (= (pd c) false))))
(assert (forall ((c Task)) (=> (and (not (inited c)) (not (fd c)))  (= (pd c) (ite
	(or
		(and (exists ((dc1 Decomposition)) (and (= (tgtType dc1) TASK) (= ((as tgt (Task)) dc1) c) (pd dc1))) (not (exists ((dc2 Decomposition)) (and (= (tgtType dc2) TASK) (= ((as tgt (Task)) dc2) c) (fd dc2)))) (not (exists ((dc3 DependerLink)) (and (= (srcType dc3) TASK) (= ((as src (Task)) dc3) c) (fd dc3)))))
		(and (exists ((dc1 DependerLink)) (and (= (srcType dc1) TASK) (= ((as src (Task)) dc1) c) (pd dc1))) (not (exists ((dc2 DependerLink)) (and (= (srcType dc2) TASK) (= ((as src (Task)) dc2) c) (fd dc2)))) (not (exists ((dc3 Decomposition)) (and (= (tgtType dc3) TASK) (= ((as tgt (Task)) dc3) c) (fd dc3)))))
	)
	true
	false
)))))
(assert (forall ((c Task)) (=> (and (not (inited c)) (or (fd c) (pd c)))  (= (co c) false))))
(assert (forall ((c Task)) (=> (and (not (inited c)) (not (fd c)) (not (pd c)))  (= (co c) (ite
	(or
		(and (exists ((dc1 Decomposition)) (and (= (tgtType dc1) TASK) (= ((as tgt (Task)) dc1) c) (co dc1))) (not (exists ((dc2 Decomposition)) (and (= (tgtType dc2) TASK) (= ((as tgt (Task)) dc2) c) (or (fd dc2) (pd dc2))))) (not (exists ((dc3 DependerLink)) (and (= (srcType dc3) TASK) (= ((as src (Task)) dc3) c) (or (fd dc3) (pd dc3))))))
		(and (exists ((dc1 DependerLink)) (and (= (srcType dc1) TASK) (= ((as src (Task)) dc1) c) (co dc1))) (not (exists ((dc2 DependerLink)) (and (= (srcType dc2) TASK) (= ((as src (Task)) dc2) c) (or (fd dc2) (pd dc2))))) (not (exists ((dc3 Decomposition)) (and (= (tgtType dc3) TASK) (= ((as tgt (Task)) dc3) c) (or (fd dc3) (pd dc3))))))
	)
	true
	false
)))))
(assert (forall ((c Task)) (=> (and (not (inited c)) (or (fd c) (pd c) (co c)))  (= (un c) false))))
(assert (forall ((c Task)) (=> (and (not (inited c)) (not (fd c)) (not (pd c)) (not (co c)))  (= (un c) (ite
	(or
		(and (exists ((dc1 Decomposition)) (and (= (tgtType dc1) TASK) (= ((as tgt (Task)) dc1) c) (un dc1))) (not (exists ((dc2 Decomposition)) (and (= (tgtType dc2) TASK) (= ((as tgt (Task)) dc2) c) (or (fd dc2) (pd dc2) (co dc2))))) (not (exists ((dc3 DependerLink)) (and (= (srcType dc3) TASK) (= ((as src (Task)) dc3) c) (or (fd dc3) (pd dc3) (co dc3))))))
		(and (exists ((dc1 DependerLink)) (and (= (srcType dc1) TASK) (= ((as src (Task)) dc1) c) (un dc1))) (not (exists ((dc2 DependerLink)) (and (= (srcType dc2) TASK) (= ((as src (Task)) dc2) c) (or (fd dc2) (pd dc2) (co dc2))))) (not (exists ((dc3 Decomposition)) (and (= (tgtType dc3) TASK) (= ((as tgt (Task)) dc3) c) (or (fd dc3) (pd dc3) (co dc3))))))
	)
	true
	false
)))))
(assert (forall ((c Task)) (=> (and (not (inited c)) (or (fd c) (pd c) (co c) (un c)))  (= (no c) false))))
(assert (forall ((c Task)) (=> (and (not (inited c)) (not (fd c)) (not (pd c)) (not (co c)) (not (un c)))  (= (no c) (ite
	(or
		(and (not (exists ((dc1 Decomposition)) (and (= (tgtType dc1) TASK) (= ((as tgt (Task)) dc1) c)))) (not (exists ((dc2 DependerLink)) (and (= (srcType dc2) TASK) (= ((as src (Task)) dc2) c)))))
		(and (exists ((dc1 Decomposition)) (and (= (tgtType dc1) TASK) (= ((as tgt (Task)) dc1) c) (no dc1))) (not (exists ((dc2 Decomposition)) (and (= (tgtType dc2) TASK) (= ((as tgt (Task)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2))))) (not (exists ((dc3 DependerLink)) (and (= (srcType dc3) TASK) (= ((as src (Task)) dc3) c) (or (fd dc3) (pd dc3) (co dc3) (un dc3))))))
		(and (exists ((dc1 DependerLink)) (and (= (srcType dc1) TASK) (= ((as src (Task)) dc1) c) (no dc1))) (not (exists ((dc2 DependerLink)) (and (= (srcType dc2) TASK) (= ((as src (Task)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2))))) (not (exists ((dc3 Decomposition)) (and (= (tgtType dc3) TASK) (= ((as tgt (Task)) dc3) c) (or (fd dc3) (pd dc3) (co dc3) (un dc3))))))
	)
	true
	false
)))))
(assert (forall ((c Task)) (=> (and (not (inited c)) (or (fd c) (pd c) (co c) (un c) (no c)))  (= (ps c) false))))
(assert (forall ((c Task)) (=> (and (not (inited c)) (not (fd c)) (not (pd c)) (not (co c)) (not (un c)) (not (no c)))  (= (ps c) (ite
	(or
		(and (exists ((dc1 Decomposition)) (and (= (tgtType dc1) TASK) (= ((as tgt (Task)) dc1) c) (ps dc1))) (not (exists ((dc2 Decomposition)) (and (= (tgtType dc2) TASK) (= ((as tgt (Task)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (no dc2))))) (not (exists ((dc3 DependerLink)) (and (= (srcType dc3) TASK) (= ((as src (Task)) dc3) c) (or (fd dc3) (pd dc3) (co dc3) (un dc3) (no dc3))))))
		(and (exists ((dc1 DependerLink)) (and (= (srcType dc1) TASK) (= ((as src (Task)) dc1) c) (ps dc1))) (not (exists ((dc2 DependerLink)) (and (= (srcType dc2) TASK) (= ((as src (Task)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (no dc2))))) (not (exists ((dc3 Decomposition)) (and (= (tgtType dc3) TASK) (= ((as tgt (Task)) dc3) c) (or (fd dc3) (pd dc3) (co dc3) (un dc3) (no dc3))))))
	)
	true
	false
)))))
(assert (forall ((c Task)) (=> (and (not (inited c)) (or (fd c) (pd c) (co c) (un c) (no c) (ps c)))  (= (fs c) false))))
(assert (forall ((c Task)) (=> (and (not (inited c)) (not (fd c)) (not (pd c)) (not (co c)) (not (un c)) (not (no c)) (not (ps c)))  (= (fs c) true))))
;(assert (forall ((c Task)) (=> (not (inited c))  (= (fs c) (ite
;	(or
;		(and (exists ((dc1 Decomposition)) (and (= (tgtType dc1) TASK) (= ((as tgt (Task)) dc1) c) (fs dc1))) (not (exists ((dc2 Decomposition)) (and (= (tgtType dc2) TASK) (= ((as tgt (Task)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (no dc2) (ps dc2))))) (not (exists ((dc3 DependerLink)) (and (= (srcType dc3) TASK) (= ((as src (Task)) dc3) c) (or (fd dc3) (pd dc3) (co dc3) (un dc3) (no dc3) (ps dc3))))))
;		(and (exists ((dc1 DependerLink)) (and (= (srcType dc1) TASK) (= ((as src (Task)) dc1) c) (fs dc1))) (not (exists ((dc2 DependerLink)) (and (= (srcType dc2) TASK) (= ((as src (Task)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (no dc2) (ps dc2))))) (not (exists ((dc3 Decomposition)) (and (= (tgtType dc3) TASK) (= ((as tgt (Task)) dc3) c) (or (fd dc3) (pd dc3) (co dc3) (un dc3) (no dc3) (ps dc3))))))
;	)
;	true
;	false
;)))))

;SoftGoal propagation (Contribution + Depender + Dependee)
(assert (forall ((c SoftGoal)) (=> (not (inited c)) (= (co c) (ite
	(or
		(and
			(or
				(exists ((cc1 Contribution)) (and (= (tgtType cc1) SOFTGOAL) (= ((as tgt (SoftGoal)) cc1) c) (co cc1)))
				(exists ((cc2 Contribution) (cc3 Contribution)) (and (= (tgtType cc2) SOFTGOAL) (= ((as tgt (SoftGoal)) cc2) c) (= (tgtType cc3) SOFTGOAL) (= ((as tgt (SoftGoal)) cc3) c) (or (fs cc2) (ps cc2)) (or (pd cc3) (fd cc3))))
			)
			(not (exists ((dc DependerLink)) (and (= (srcType dc) SOFTGOAL) (= ((as src (SoftGoal)) dc) c) (or (fd dc) (pd dc)))))
		)
		(and
			(exists ((dc1 DependerLink)) (and (= (srcType dc1) SOFTGOAL) (= ((as src (SoftGoal)) dc1) c) (co dc1)))
			(not (exists ((dc2 DependerLink)) (and (= (srcType dc2) SOFTGOAL) (= ((as src (SoftGoal)) dc2) c) (or (fd dc2) (pd dc2)))))
			;not exists fd|pd
			(not (and
				(exists ((cc1 Contribution)) (and (= (tgtType cc1) SOFTGOAL) (= ((as tgt (SoftGoal)) cc1) c) (or (fd cc1) (pd cc1))))
				(not (exists ((cc2 Contribution)) (and (= (tgtType cc2) SOFTGOAL) (= ((as tgt (SoftGoal)) cc2) c) (or (co cc2) (un cc2) (fs cc2) (ps cc2)))))
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
			(exists ((cc1 Contribution)) (and (= (tgtType cc1) SOFTGOAL) (= ((as tgt (SoftGoal)) cc1) c) (un cc1)))
			(not (exists ((cc2 Contribution)) (and (= (tgtType cc2) SOFTGOAL) (= ((as tgt (SoftGoal)) cc2) c) (co cc2))))
			(not (exists ((cc3 Contribution) (cc4 Contribution)) (and (= (tgtType cc3) SOFTGOAL) (= ((as tgt (SoftGoal)) cc3) c) (= (tgtType cc4) SOFTGOAL) (= ((as tgt (SoftGoal)) cc4) c) (or (fs cc3) (ps cc3)) (or (pd cc4) (fd cc4)))))
			(not (exists ((dc DependerLink)) (and (= (srcType dc) SOFTGOAL) (= ((as src (SoftGoal)) dc) c) (or (fd dc) (pd dc) (co dc)))))
		)
		(and
			(exists ((dc1 DependerLink)) (and (= (srcType dc1) SOFTGOAL) (= ((as src (SoftGoal)) dc1) c) (un dc1)))
			(not (exists ((dc2 DependerLink)) (and (= (srcType dc2) SOFTGOAL) (= ((as src (SoftGoal)) dc2) c) (or (fd dc2) (pd dc2) (co dc2)))))
			;not exists fd|pd|co_
			(not (and
				(exists ((cc1 Contribution)) (and (= (tgtType cc1) SOFTGOAL) (= ((as tgt (SoftGoal)) cc1) c) (or (fd cc1) (pd cc1))))
				(not (exists ((cc2 Contribution)) (and (= (tgtType cc2) SOFTGOAL) (= ((as tgt (SoftGoal)) cc2) c) (un cc2))))
			))
			;not exists co
			(not (exists ((cc3 Contribution)) (and (= (tgtType cc3) SOFTGOAL) (= ((as tgt (SoftGoal)) cc3) c) (co cc3))))
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
			(exists ((cc1 Contribution)) (and (= (tgtType cc1) SOFTGOAL) (= ((as tgt (SoftGoal)) cc1) c) (fd cc1)))
			(not (exists ((cc2 Contribution)) (and (= (tgtType cc2) SOFTGOAL) (= ((as tgt (SoftGoal)) cc2) c) (or (co cc2) (un cc2) (fs cc2) (ps cc2)))))
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
			(exists ((cc1 Contribution)) (and (= (tgtType cc1) SOFTGOAL) (= ((as tgt (SoftGoal)) cc1) c) (pd cc1)))
			(not (exists ((cc2 Contribution)) (and (= (tgtType cc2) SOFTGOAL) (= ((as tgt (SoftGoal)) cc2) c) (or (co cc2) (un cc2) (fd cc2) (fs cc2) (ps cc2)))))
			(not (exists ((dc DependerLink)) (and (= (srcType dc) SOFTGOAL) (= ((as src (SoftGoal)) dc) c) (fd dc))))
		)
		(and
			(exists ((dc1 DependerLink)) (and (= (srcType dc1) SOFTGOAL) (= ((as src (SoftGoal)) dc1) c) (pd dc1)))
			(not (exists ((dc2 DependerLink)) (and (= (srcType dc2) SOFTGOAL) (= ((as src (SoftGoal)) dc2) c) (fd dc2))))
			;not exists fd
			(not (and
				(exists ((cc1 Contribution)) (and (= (tgtType cc1) SOFTGOAL) (= ((as tgt (SoftGoal)) cc1) c) (fd cc1)))
				(not (exists ((cc2 Contribution)) (and (= (tgtType cc2) SOFTGOAL) (= ((as tgt (SoftGoal)) cc2) c) (or (co cc2) (un cc2) (fs cc2) (ps cc2)))))
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
			(exists ((cc1 Contribution)) (and (= (tgtType cc1) SOFTGOAL) (= ((as tgt (SoftGoal)) cc1) c) (fs cc1)))
			(not (exists ((cc2 Contribution)) (and (= (tgtType cc2) SOFTGOAL) (= ((as tgt (SoftGoal)) cc2) c) (or (co cc2) (un cc2) (fd cc2) (pd cc2)))))
			(not (exists ((dc DependerLink)) (and (= (srcType dc) SOFTGOAL) (= ((as src (SoftGoal)) dc) c) (or (fd dc) (pd dc) (co dc) (un dc) (no dc) (ps dc)))))
		)
		(and
			(exists ((dc1 DependerLink)) (and (= (srcType dc1) SOFTGOAL) (= ((as src (SoftGoal)) dc1) c) (fs dc1)))
			(not (exists ((dc2 DependerLink)) (and (= (srcType dc2) SOFTGOAL) (= ((as src (SoftGoal)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (no dc2) (ps dc2)))))
			;not exists fd|pd|co|co_|un
			(not (exists ((cc1 Contribution)) (and (= (tgtType cc1) SOFTGOAL) (= ((as tgt (SoftGoal)) cc1) c) (or (co cc1) (un cc1) (fd cc1) (pd cc1)))))
			;not exists no
			(not (and
				(exists ((cc2 Contribution)) (and (= (tgtType cc2) SOFTGOAL) (= ((as tgt (SoftGoal)) cc2) c) (no cc2)))
				(not (exists ((cc3 Contribution)) (and (= (tgtType cc3) SOFTGOAL) (= ((as tgt (SoftGoal)) cc3) c) (or (co cc3) (un cc3) (fd cc3) (pd cc3) (fs cc3) (ps cc3)))))
			))
			;not exists ps
			(not (and
				(exists ((cc4 Contribution)) (and (= (tgtType cc4) SOFTGOAL) (= ((as tgt (SoftGoal)) cc4) c) (ps cc4)))
				(not (exists ((cc5 Contribution)) (and (= (tgtType cc5) SOFTGOAL) (= ((as tgt (SoftGoal)) cc5) c) (or (co cc5) (un cc5) (fd cc5) (pd cc5) (fs cc5)))))
			))
		)
		(and
			(exists ((dc1 DependeeLink)) (and (= (srcType dc1) SOFTGOAL) (= ((as src (SoftGoal)) dc1) c) (fs dc1)))
			(not (exists ((dc2 DependeeLink)) (and (= (srcType dc2) SOFTGOAL) (= ((as src (SoftGoal)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (no dc2) (ps dc2)))))
		)
	)
	true
	false
)))))
(assert (forall ((c SoftGoal)) (=> (and (not (inited c)) (or (co c) (un c) (fd c) (pd c) (fs c))) (= (ps c) false))))
(assert (forall ((c SoftGoal)) (=> (and (not (inited c)) (not (co c)) (not (un c)) (not (fd c)) (not (pd c)) (not (fs c))) (= (ps c) (ite
	(or
		(and
			(exists ((cc1 Contribution)) (and (= (tgtType cc1) SOFTGOAL) (= ((as tgt (SoftGoal)) cc1) c) (ps cc1)))
			(not (exists ((cc2 Contribution)) (and (= (tgtType cc2) SOFTGOAL) (= ((as tgt (SoftGoal)) cc2) c) (or (co cc2) (un cc2) (fd cc2) (pd cc2) (fs cc2)))))
			(not (exists ((dc DependerLink)) (and (= (srcType dc) SOFTGOAL) (= ((as src (SoftGoal)) dc) c) (or (fd dc) (pd dc) (co dc) (un dc) (no dc)))))
		)
		(and
			(exists ((dc1 DependerLink)) (and (= (srcType dc1) SOFTGOAL) (= ((as src (SoftGoal)) dc1) c) (ps dc1)))
			(not (exists ((dc2 DependerLink)) (and (= (srcType dc2) SOFTGOAL) (= ((as src (SoftGoal)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (no dc2)))))
			;not exists fd|pd|co|co_|un
			(not (exists ((cc1 Contribution)) (and (= (tgtType cc1) SOFTGOAL) (= ((as tgt (SoftGoal)) cc1) c) (or (co cc1) (un cc1) (fd cc1) (pd cc1)))))
			;not exists no
			(not (and
				(exists ((cc2 Contribution)) (and (= (tgtType cc2) SOFTGOAL) (= ((as tgt (SoftGoal)) cc2) c) (no cc2)))
				(not (exists ((cc3 Contribution)) (and (= (tgtType cc3) SOFTGOAL) (= ((as tgt (SoftGoal)) cc3) c) (or (co cc3) (un cc3) (fd cc3) (pd cc3) (fs cc3) (ps cc3)))))
			))
		)
		(and
			(exists ((dc1 DependeeLink)) (and (= (srcType dc1) SOFTGOAL) (= ((as src (SoftGoal)) dc1) c) (ps dc1)))
			(not (exists ((dc2 DependeeLink)) (and (= (srcType dc2) SOFTGOAL) (= ((as src (SoftGoal)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (no dc2)))))
		)
	)
	true
	false
)))))
(assert (forall ((c SoftGoal)) (=> (and (not (inited c)) (or (co c) (un c) (fd c) (pd c) (fs c) (ps c))) (= (no c) false))))
(assert (forall ((c SoftGoal)) (=> (and (not (inited c)) (not (co c)) (not (un c)) (not (fd c)) (not (pd c)) (not (fs c)) (not (ps c))) (= (no c) true))))
;(assert (forall ((c SoftGoal)) (=> (and (not (inited c)) (not (co c)) (not (un c)) (not (fd c)) (not (pd c)) (not (fs c)) (not (ps c))) (= (no c) (ite
;	(or
;		(and
;			(not (exists ((cc Contribution)) (= (tgtType cc) SOFTGOAL) (= ((as tgt (SoftGoal)) cc) c)))
;			(not (exists ((dc1 DependerLink)) (and (= (srcType dc1) SOFTGOAL) (= ((as src (SoftGoal)) dc1) c))))
;			(not (exists ((dc2 DependeeLink)) (and (= (srcType dc2) SOFTGOAL) (= ((as src (SoftGoal)) dc2) c))))
;		)
;		(and
;			(exists ((cc1 Contribution)) (and (= (tgtType cc1) SOFTGOAL) (= ((as tgt (SoftGoal)) cc1) c) (no cc1)))
;			(not (exists ((cc2 Contribution)) (and (= (tgtType cc2) SOFTGOAL) (= ((as tgt (SoftGoal)) cc2) c) (or (co cc2) (un cc2) (fd cc2) (pd cc2) (fs cc2) (ps cc2)))))
;			(not (exists ((dc DependerLink)) (and (= (srcType dc) SOFTGOAL) (= ((as src (SoftGoal)) dc) c) (or (fd dc) (pd dc) (co dc) (un dc)))))
;		)
;		(and
;			(exists ((dc1 DependerLink)) (and (= (srcType dc1) SOFTGOAL) (= ((as src (SoftGoal)) dc1) c) (no dc1)))
;			(not (exists ((dc2 DependerLink)) (and (= (srcType dc2) SOFTGOAL) (= ((as src (SoftGoal)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2)))))
;			;not exists fd|pd|co|co_|un
;			(not (exists ((cc1 Contribution)) (and (= (tgtType cc1) SOFTGOAL) (= ((as tgt (SoftGoal)) cc1) c) (or (co cc1) (un cc1) (fd cc1) (pd cc1)))))
;		)
;		(and
;			(exists ((dc1 DependeeLink)) (and (= (srcType dc1) SOFTGOAL) (= ((as src (SoftGoal)) dc1) c) (no dc1)))
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
(assert (forall ((c Resource)) (=> (and (not (inited c)) (or (fd c) (pd c) (co c) (un c)))  (= (no c) false))))
(assert (forall ((c Resource)) (=> (and (not (inited c)) (not (fd c)) (not (pd c)) (not (co c)) (not (un c)))  (= (no c) (ite
	(or
		(not (exists ((dc DependeeLink)) (and (= (srcType dc) RESOURCE) (= ((as src (Resource)) dc) c))))
		(and (exists ((dc1 DependeeLink)) (and (= (srcType dc1) RESOURCE) (= ((as src (Resource)) dc1) c) (no dc1))) (not (exists ((dc2 DependeeLink)) (and (= (srcType dc2) RESOURCE) (= ((as src (Resource)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2))))))
	)
	true
	false
)))))
(assert (forall ((c Resource)) (=> (and (not (inited c)) (or (fd c) (pd c) (co c) (un c) (no c)))  (= (ps c) false))))
(assert (forall ((c Resource)) (=> (and (not (inited c)) (not (fd c)) (not (pd c)) (not (co c)) (not (un c)) (not (no c)))  (= (ps c) (ite
	(and (exists ((dc1 DependeeLink)) (and (= (srcType dc1) RESOURCE) (= ((as src (Resource)) dc1) c) (ps dc1))) (not (exists ((dc2 DependeeLink)) (and (= (srcType dc2) RESOURCE) (= ((as src (Resource)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (no dc2))))))
	true
	false
)))))
(assert (forall ((c Resource)) (=> (and (not (inited c)) (or (fd c) (pd c) (co c) (un c) (no c) (ps c)))  (= (fs c) false))))
(assert (forall ((c Resource)) (=> (and (not (inited c)) (not (fd c)) (not (pd c)) (not (co c)) (not (un c)) (not (no c)) (not (ps c)))  (= (fs c) true))))
;(assert (forall ((c Resource)) (=> (not (inited c))  (= (fs c) (ite
;	(and (exists ((dc1 DependeeLink)) (and (= (srcType dc1) RESOURCE) (= ((as src (Resource)) dc1) c) (fs dc1))) (not (exists ((dc2 DependeeLink)) (and (= (srcType dc2) RESOURCE) (= ((as src (Resource)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (no dc2) (ps dc2))))))
;	true
;	false
;)))))
