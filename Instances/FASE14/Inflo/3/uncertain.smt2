
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

(declare-const InfloUser Node)
(assert (= InfloUser 101))
(declare-const InfloManagerEditors Node)
(assert (= InfloManagerEditors 102))
(declare-const Source Node)
(assert (= Source 103))
(declare-const AutomatedReputationSystem Node)
(assert (= AutomatedReputationSystem 104))
(declare-const Inflo Node)
(assert (= Inflo 105))
(declare-const Browsing Node)
(assert (= Browsing 106))
(declare-const CreateGraph Node)
(assert (= CreateGraph 107))
(declare-const UseDiscussions Node)
(assert (= UseDiscussions 108))
(declare-const MakeViews Node)
(assert (= MakeViews 109))
(declare-const AddSourceInDescription Node)
(assert (= AddSourceInDescription 110))
(declare-const CreateDiscussions Node)
(assert (= CreateDiscussions 111))
(declare-const ExtensiveModeration Node)
(assert (= ExtensiveModeration 112))
(declare-const UseAutomatedReputationSystem Node)
(assert (= UseAutomatedReputationSystem 113))
(declare-const LessExtensiveModeration Node)
(assert (= LessExtensiveModeration 114))
(declare-const ProvideReputations Node)
(assert (= ProvideReputations 115))
(declare-const ModerationARS Node)
(assert (= ModerationARS 116))
(declare-const TrackAuthorship Node)
(assert (= TrackAuthorship 117))
(declare-const DisplayGraphs Node)
(assert (= DisplayGraphs 118))
(declare-const TrackRevisions Node)
(assert (= TrackRevisions 119))
(declare-const CreateGraphs Node)
(assert (= CreateGraphs 120))
(declare-const BeInflo Node)
(assert (= BeInflo 121))
(declare-const ModerationTasks Node)
(assert (= ModerationTasks 122))

(declare-const UseInflo Node)
(assert (= UseInflo 123))
(declare-const InfloBeModerated Node)
(assert (= InfloBeModerated 124))
(declare-const ModerateInflo Node)
(assert (= ModerateInflo 125))
(declare-const AllowModeration Node)
(assert (= AllowModeration 126))

(declare-const MakeModelsTrustworthy Node)
(assert (= MakeModelsTrustworthy 127))
(declare-const ValidateModel Node)
(assert (= ValidateModel 128))
(declare-const GetFeedback Node)
(assert (= GetFeedback 129))
(declare-const IntegrityOfModelsIU Node)
(assert (= IntegrityOfModelsIU 130))
(declare-const IntegrityOfModelsIME Node)
(assert (= IntegrityOfModelsIME 131))
(declare-const MinimizeModeratorEffort Node)
(assert (= MinimizeModeratorEffort 132))
(declare-const IntegrityOfModels Node)
(assert (= IntegrityOfModels 133))

(declare-const Moderation Node)
(assert (= Moderation 134))
(declare-const Graphing Node)
(assert (= Graphing 135))
(declare-const ReputationValues Node)
(assert (= ReputationValues 136))
(declare-const Info Node)
(assert (= Info 137))
(declare-const Authorship Node)
(assert (= Authorship 138))

(declare-const InfloUser2MakeModelsTrustworthy Edge)
(assert (= InfloUser2MakeModelsTrustworthy 139))
(declare-const InfloUser2UseInflo Edge)
(assert (= InfloUser2UseInflo 140))
(declare-const InfloUser2ValidateModel Edge)
(assert (= InfloUser2ValidateModel 141))
(declare-const InfloUser2GetFeedback Edge)
(assert (= InfloUser2GetFeedback 142))
(declare-const InfloUser2Browsing Edge)
(assert (= InfloUser2Browsing 143))
(declare-const InfloUser2CreateGraph Edge)
(assert (= InfloUser2CreateGraph 144))
(declare-const InfloUser2UseDiscussions Edge)
(assert (= InfloUser2UseDiscussions 145))
(declare-const InfloUser2InfloBeModerated Edge)
(assert (= InfloUser2InfloBeModerated 146))
(declare-const InfloUser2MakeViews Edge)
(assert (= InfloUser2MakeViews 147))
(declare-const InfloUser2AddSourceInDescription Edge)
(assert (= InfloUser2AddSourceInDescription 148))
(declare-const InfloUser2CreateDiscussions Edge)
(assert (= InfloUser2CreateDiscussions 149))
(declare-const InfloUser2IntegrityOfModelsIU Edge)
(assert (= InfloUser2IntegrityOfModelsIU 150))
(declare-const InfloManagerEditors2ExtensiveModeration Edge)
(assert (= InfloManagerEditors2ExtensiveModeration 151))
(declare-const InfloManagerEditors2UseAutomatedReputationSystem Edge)
(assert (= InfloManagerEditors2UseAutomatedReputationSystem 152))
(declare-const InfloManagerEditors2ModerateInflo Edge)
(assert (= InfloManagerEditors2ModerateInflo 153))
(declare-const InfloManagerEditors2LessExtensiveModeration Edge)
(assert (= InfloManagerEditors2LessExtensiveModeration 154))
(declare-const InfloManagerEditors2IntegrityOfModelsIME Edge)
(assert (= InfloManagerEditors2IntegrityOfModelsIME 155))
(declare-const InfloManagerEditors2MinimizeModeratorEffort Edge)
(assert (= InfloManagerEditors2MinimizeModeratorEffort 156))
(declare-const AutomatedReputationSystem2ProvideReputations Edge)
(assert (= AutomatedReputationSystem2ProvideReputations 157))
(declare-const AutomatedReputationSystem2ModerationARS Edge)
(assert (= AutomatedReputationSystem2ModerationARS 158))
(declare-const Inflo2AllowModeration Edge)
(assert (= Inflo2AllowModeration 159))
(declare-const Inflo2TrackAuthorship Edge)
(assert (= Inflo2TrackAuthorship 160))
(declare-const Inflo2DisplayGraphs Edge)
(assert (= Inflo2DisplayGraphs 161))
(declare-const Inflo2TrackRevisions Edge)
(assert (= Inflo2TrackRevisions 162))
(declare-const Inflo2CreateGraphs Edge)
(assert (= Inflo2CreateGraphs 163))
(declare-const Inflo2BeInflo Edge)
(assert (= Inflo2BeInflo 164))
(declare-const Inflo2ModerationTasks Edge)
(assert (= Inflo2ModerationTasks 165))
(declare-const Browsing2UseInflo Edge)
(assert (= Browsing2UseInflo 166))
(declare-const CreateGraph2UseInflo Edge)
(assert (= CreateGraph2UseInflo 167))
(declare-const UseDiscussions2UseInflo Edge)
(assert (= UseDiscussions2UseInflo 168))
(declare-const ExtensiveModeration2ModerateInflo Edge)
(assert (= ExtensiveModeration2ModerateInflo 169))
(declare-const UseAutomatedReputationSystem2ModerateInflo Edge)
(assert (= UseAutomatedReputationSystem2ModerateInflo 170))
(declare-const LessExtensiveModeration2ModerateInflo Edge)
(assert (= LessExtensiveModeration2ModerateInflo 171))
(declare-const ModerationTasks2AllowModeration Edge)
(assert (= ModerationTasks2AllowModeration 172))

(declare-const MakeViews2Browsing Edge)
(assert (= MakeViews2Browsing 173))
(declare-const AddSourceInDescription2CreateGraph Edge)
(assert (= AddSourceInDescription2CreateGraph 174))
(declare-const CreateDiscussions2UseDiscussions Edge)
(assert (= CreateDiscussions2UseDiscussions 175))
(declare-const UseAutomatedReputationSystem2ExtensiveModeration Edge)
(assert (= UseAutomatedReputationSystem2ExtensiveModeration 176))
(declare-const UseAutomatedReputationSystem2LessExtensiveModeration Edge)
(assert (= UseAutomatedReputationSystem2LessExtensiveModeration 177))
(declare-const TrackAuthorship2BeInflo Edge)
(assert (= TrackAuthorship2BeInflo 178))
(declare-const DisplayGraphs2BeInflo Edge)
(assert (= DisplayGraphs2BeInflo 179))
(declare-const TrackRevisions2BeInflo Edge)
(assert (= TrackRevisions2BeInflo 180))
(declare-const CreateGraphs2BeInflo Edge)
(assert (= CreateGraphs2BeInflo 181))

(declare-const ValidateModel2MakeModelsTrustworthy Edge)
(assert (= ValidateModel2MakeModelsTrustworthy 182))
(declare-const GetFeedback2MakeModelsTrustworthy Edge)
(assert (= GetFeedback2MakeModelsTrustworthy 183))
(declare-const UseDiscussions2ValidateModel Edge)
(assert (= UseDiscussions2ValidateModel 184))
(declare-const UseDiscussions2GetFeedback Edge)
(assert (= UseDiscussions2GetFeedback 185))
(declare-const InfloBeModerated2GetFeedback Edge)
(assert (= InfloBeModerated2GetFeedback 186))
(declare-const IntegrityOfModelsIU2MakeModelsTrustworthy Edge)
(assert (= IntegrityOfModelsIU2MakeModelsTrustworthy 187))
(declare-const ExtensiveModeration2IntegrityOfModelsIME Edge)
(assert (= ExtensiveModeration2IntegrityOfModelsIME 188))
(declare-const ExtensiveModeration2MinimizeModeratorEffort Edge)
(assert (= ExtensiveModeration2MinimizeModeratorEffort 189))
(declare-const UseAutomatedReputationSystem2MinimizeModeratorEffort Edge)
(assert (= UseAutomatedReputationSystem2MinimizeModeratorEffort 190))
(declare-const LessExtensiveModeration2MinimizeModeratorEffort Edge)
(assert (= LessExtensiveModeration2MinimizeModeratorEffort 191))

(declare-const InfloBeModerated2Moderation Edge)
(assert (= InfloBeModerated2Moderation 192))
(declare-const AllowModeration2Moderation Edge)
(assert (= AllowModeration2Moderation 193))
(declare-const UseInflo2Graphing Edge)
(assert (= UseInflo2Graphing 194))
(declare-const UseAutomatedReputationSystem2ReputationValues Edge)
(assert (= UseAutomatedReputationSystem2ReputationValues 195))
(declare-const AddSourceInDescription2Info Edge)
(assert (= AddSourceInDescription2Info 196))
(declare-const TrackAuthorship2Authorship Edge)
(assert (= TrackAuthorship2Authorship 197))
(declare-const IntegrityOfModelsIU2IntegrityOfModels Edge)
(assert (= IntegrityOfModelsIU2IntegrityOfModels 198))
(declare-const Moderation2ModerateInflo Edge)
(assert (= Moderation2ModerateInflo 199))
(declare-const Moderation2ModerationARS Edge)
(assert (= Moderation2ModerationARS 200))
(declare-const Graphing2BeInflo Edge)
(assert (= Graphing2BeInflo 201))
(declare-const ReputationValues2ProvideReputations Edge)
(assert (= ReputationValues2ProvideReputations 202))
(declare-const Authorship2CreateGraph Edge)
(assert (= Authorship2CreateGraph 203))
(declare-const Authorship2CreateDiscussions Edge)
(assert (= Authorship2CreateDiscussions 204))
(declare-const IntegrityOfModels2IntegrityOfModelsIME Edge)
(assert (= IntegrityOfModels2IntegrityOfModelsIME 205))

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
	(node InfloUser c)
	(node InfloManagerEditors c)
	(node Source c)
	(node AutomatedReputationSystem c)
	(node Inflo c)
)))
;Tasks are Complete
(assert (forall ((c Task)) (or
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
;Goals are Complete
(assert (forall ((c Goal)) (or
	(node UseInflo c)
	(node InfloBeModerated c)
	(node ModerateInflo c)
	(node AllowModeration c)
)))
;SoftGoals are Complete
(assert (forall ((c SoftGoal)) (or
	(node MakeModelsTrustworthy c)
	(node ValidateModel c)
	(node GetFeedback c)
	(node IntegrityOfModelsIU c)
	(node IntegrityOfModelsIME c)
	(node MinimizeModeratorEffort c)
	(node IntegrityOfModels c)
)))
;Resources are Complete
(assert (forall ((c Resource)) (or
	(node Moderation c)
	(node Graphing c)
	(node ReputationValues c)
	(node Info c)
	(node Authorship c)
)))
(assert (forall ((c Containment)) (or
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
	(edge InfloUser2IntegrityOfModelsIU c)
	(edge InfloManagerEditors2ExtensiveModeration c)
	(edge InfloManagerEditors2UseAutomatedReputationSystem c)
	(edge InfloManagerEditors2ModerateInflo c)
	(edge InfloManagerEditors2LessExtensiveModeration c)
	(edge InfloManagerEditors2IntegrityOfModelsIME c)
	(edge InfloManagerEditors2MinimizeModeratorEffort c)
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
;MeansEnds are Complete
(assert (forall ((c MeansEnd)) (or
	(edge Browsing2UseInflo c)
	(edge CreateGraph2UseInflo c)
	(edge UseDiscussions2UseInflo c)
	(edge ExtensiveModeration2ModerateInflo c)
	(edge UseAutomatedReputationSystem2ModerateInflo c)
	(edge LessExtensiveModeration2ModerateInflo c)
	(edge ModerationTasks2AllowModeration c)
)))
;Decompositions are Complete
(assert (forall ((c Decomposition)) (or
	(edge MakeViews2Browsing c)
	(edge AddSourceInDescription2CreateGraph c)
	(edge CreateDiscussions2UseDiscussions c)
	(edge UseAutomatedReputationSystem2ExtensiveModeration c)
	(edge UseAutomatedReputationSystem2LessExtensiveModeration c)
	(edge TrackAuthorship2BeInflo c)
	(edge DisplayGraphs2BeInflo c)
	(edge TrackRevisions2BeInflo c)
	(edge CreateGraphs2BeInflo c)
)))
;Contributions are Complete
(assert (forall ((c Contribution)) (or
	(edge ValidateModel2MakeModelsTrustworthy c)
	(edge GetFeedback2MakeModelsTrustworthy c)
	(edge UseDiscussions2ValidateModel c)
	(edge UseDiscussions2GetFeedback c)
	(edge InfloBeModerated2GetFeedback c)
	(edge IntegrityOfModelsIU2MakeModelsTrustworthy c)
	(edge ExtensiveModeration2IntegrityOfModelsIME c)
	(edge ExtensiveModeration2MinimizeModeratorEffort c)
	(edge UseAutomatedReputationSystem2MinimizeModeratorEffort c)
	(edge LessExtensiveModeration2MinimizeModeratorEffort c)
)))
(assert (forall ((c DependerLink)) (or
	(edge InfloBeModerated2Moderation c)
	(edge AllowModeration2Moderation c)
	(edge UseInflo2Graphing c)
	(edge UseAutomatedReputationSystem2ReputationValues c)
	(edge AddSourceInDescription2Info c)
	(edge TrackAuthorship2Authorship c)
	(edge IntegrityOfModelsIU2IntegrityOfModels c)
)))
(assert (forall ((c DependeeLink)) (or
	(edge Moderation2ModerateInflo c)
	(edge Moderation2ModerationARS c)
	(edge Graphing2BeInflo c)
	(edge ReputationValues2ProvideReputations c)
	(edge Authorship2CreateGraph c)
	(edge Authorship2CreateDiscussions c)
	(edge IntegrityOfModels2IntegrityOfModelsIME c)
)))

;Model Elements
;InfloUser Exists
(assert	(exists ((c Actor)) (node InfloUser c)))
;InfloUser is Unique
(assert	(forall ((c1 Actor) (c2 Actor)) (=>
	(and (node InfloUser c1) (node InfloUser c2))
	(= c1 c2)
)))
;InfloUser is Distinct
(assert	(forall ((c Actor)) (=>
	(node InfloUser c)
	(not (or
		(node InfloManagerEditors c)
		(node Source c)
		(node AutomatedReputationSystem c)
		(node Inflo c)
	))
)))
;InfloManagerEditors Exists
(assert	(exists ((c Actor)) (node InfloManagerEditors c)))
;InfloManagerEditors is Unique
(assert	(forall ((c1 Actor) (c2 Actor)) (=>
	(and (node InfloManagerEditors c1) (node InfloManagerEditors c2))
	(= c1 c2)
)))
;InfloManagerEditors is Distinct
(assert	(forall ((c Actor)) (=>
	(node InfloManagerEditors c)
	(not (or
		(node InfloUser c)
		(node Source c)
		(node AutomatedReputationSystem c)
		(node Inflo c)
	))
)))
;Source Exists
(assert	(exists ((c Actor)) (node Source c)))
;Source is Distinct
(assert	(forall ((c Actor)) (=>
	(node Source c)
	(not (or
		(node InfloUser c)
		(node InfloManagerEditors c)
		(node AutomatedReputationSystem c)
		(node Inflo c)
	))
)))
;AutomatedReputationSystem Exists
(assert	(exists ((c Actor)) (node AutomatedReputationSystem c)))
;AutomatedReputationSystem is Unique
(assert	(forall ((c1 Actor) (c2 Actor)) (=>
	(and (node AutomatedReputationSystem c1) (node AutomatedReputationSystem c2))
	(= c1 c2)
)))
;AutomatedReputationSystem is Distinct
(assert	(forall ((c Actor)) (=>
	(node AutomatedReputationSystem c)
	(not (or
		(node InfloUser c)
		(node InfloManagerEditors c)
		(node Source c)
		(node Inflo c)
	))
)))
;Inflo Exists
(assert	(exists ((c Actor)) (node Inflo c)))
;Inflo is Unique
(assert	(forall ((c1 Actor) (c2 Actor)) (=>
	(and (node Inflo c1) (node Inflo c2))
	(= c1 c2)
)))
;Inflo is Distinct
(assert	(forall ((c Actor)) (=>
	(node Inflo c)
	(not (or
		(node InfloUser c)
		(node InfloManagerEditors c)
		(node Source c)
		(node AutomatedReputationSystem c)
	))
)))
;MakeModelsTrustworthy initial analysis tag
(assert (forall ((c SoftGoal)) (=>
	(node MakeModelsTrustworthy c)
	(= (inited c) false)
)))
;MakeModelsTrustworthy Exists
(assert	(exists ((c SoftGoal)) (node MakeModelsTrustworthy c)))
;MakeModelsTrustworthy is Unique
(assert	(forall ((c1 SoftGoal) (c2 SoftGoal)) (=>
	(and (node MakeModelsTrustworthy c1) (node MakeModelsTrustworthy c2))
	(= c1 c2)
)))
;MakeModelsTrustworthy is Distinct
(assert	(forall ((c SoftGoal)) (=>
	(node MakeModelsTrustworthy c)
	(not (or
		(node IntegrityOfModelsIU c)
		(node IntegrityOfModelsIME c)
		(node MinimizeModeratorEffort c)
		(node IntegrityOfModels c)
	))
)))

;UseInflo initial analysis tag
(assert (forall ((c Goal)) (=>
	(node UseInflo c)
	(= (inited c) false)
)))
;UseInflo Exists
(assert	(exists ((c Goal)) (node UseInflo c)))
;UseInflo is Unique
(assert	(forall ((c1 Goal) (c2 Goal)) (=>
	(and (node UseInflo c1) (node UseInflo c2))
	(= c1 c2)
)))
;UseInflo is Distinct
(assert	(forall ((c Goal)) (=>
	(node UseInflo c)
	(not (or
		(node InfloBeModerated c)
		(node ModerateInflo c)
		(node AllowModeration c)
	))
)))

;ValidateModel initial analysis tag
(assert (forall ((c SoftGoal)) (=>
	(node ValidateModel c)
	(= (inited c) false)
)))
;ValidateModel Exists
(assert	(exists ((c SoftGoal)) (node ValidateModel c)))
;ValidateModel is Unique
(assert	(forall ((c1 SoftGoal) (c2 SoftGoal)) (=>
	(and (node ValidateModel c1) (node ValidateModel c2))
	(= c1 c2)
)))
;ValidateModel is Distinct
(assert	(forall ((c SoftGoal)) (=>
	(node ValidateModel c)
	(not (or
		(node IntegrityOfModelsIME c)
		(node MinimizeModeratorEffort c)
		(node IntegrityOfModels c)
	))
)))

;GetFeedback initial analysis tag
(assert (forall ((c SoftGoal)) (=>
	(node GetFeedback c)
	(= (inited c) false)
)))
;GetFeedback Exists
(assert	(exists ((c SoftGoal)) (node GetFeedback c)))
;GetFeedback is Unique
(assert	(forall ((c1 SoftGoal) (c2 SoftGoal)) (=>
	(and (node GetFeedback c1) (node GetFeedback c2))
	(= c1 c2)
)))
;GetFeedback is Distinct
(assert	(forall ((c SoftGoal)) (=>
	(node GetFeedback c)
	(not (or
		(node IntegrityOfModelsIME c)
		(node MinimizeModeratorEffort c)
		(node IntegrityOfModels c)
	))
)))

;Browsing initial analysis tag
(assert (forall ((c Task)) (=>
	(node Browsing c)
	(= (inited c) false)
)))
;Browsing Exists
(assert	(exists ((c Task)) (node Browsing c)))
;Browsing is Unique
(assert	(forall ((c1 Task) (c2 Task)) (=>
	(and (node Browsing c1) (node Browsing c2))
	(= c1 c2)
)))
;Browsing is Distinct
(assert	(forall ((c Task)) (=>
	(node Browsing c)
	(not (or
		(node CreateGraph c)
		(node UseDiscussions c)
		(node MakeViews c)
		(node AddSourceInDescription c)
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
	))
)))

;CreateGraph initial analysis tag
(assert (forall ((c Task)) (=>
	(node CreateGraph c)
	(= (inited c) false)
)))
;CreateGraph Exists
(assert	(exists ((c Task)) (node CreateGraph c)))
;CreateGraph is Unique
(assert	(forall ((c1 Task) (c2 Task)) (=>
	(and (node CreateGraph c1) (node CreateGraph c2))
	(= c1 c2)
)))
;CreateGraph is Distinct
(assert	(forall ((c Task)) (=>
	(node CreateGraph c)
	(not (or
		(node Browsing c)
		(node UseDiscussions c)
		(node MakeViews c)
		(node AddSourceInDescription c)
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
	))
)))

;UseDiscussions initial analysis tag
(assert (forall ((c Task)) (=>
	(node UseDiscussions c)
	(= (inited c) false)
)))
;UseDiscussions Exists
(assert	(exists ((c Task)) (node UseDiscussions c)))
;UseDiscussions is Unique
(assert	(forall ((c1 Task) (c2 Task)) (=>
	(and (node UseDiscussions c1) (node UseDiscussions c2))
	(= c1 c2)
)))
;UseDiscussions is Distinct
(assert	(forall ((c Task)) (=>
	(node UseDiscussions c)
	(not (or
		(node Browsing c)
		(node CreateGraph c)
		(node MakeViews c)
		(node AddSourceInDescription c)
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
	))
)))

;InfloBeModerated initial analysis tag
(assert (forall ((c Goal)) (=>
	(node InfloBeModerated c)
	(= (inited c) false)
)))
;InfloBeModerated Exists
(assert	(exists ((c Goal)) (node InfloBeModerated c)))
;InfloBeModerated is Unique
(assert	(forall ((c1 Goal) (c2 Goal)) (=>
	(and (node InfloBeModerated c1) (node InfloBeModerated c2))
	(= c1 c2)
)))
;InfloBeModerated is Distinct
(assert	(forall ((c Goal)) (=>
	(node InfloBeModerated c)
	(not (or
		(node UseInflo c)
		(node ModerateInflo c)
		(node AllowModeration c)
	))
)))

;MakeViews initial analysis tag
(assert (forall ((c Task)) (=>
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
(assert	(exists ((c Task)) (node MakeViews c)))
;MakeViews is Unique
(assert	(forall ((c1 Task) (c2 Task)) (=>
	(and (node MakeViews c1) (node MakeViews c2))
	(= c1 c2)
)))
;MakeViews is Distinct
(assert	(forall ((c Task)) (=>
	(node MakeViews c)
	(not (or
		(node Browsing c)
		(node CreateGraph c)
		(node UseDiscussions c)
		(node AddSourceInDescription c)
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
	))
)))

;AddSourceInDescription initial analysis tag
(assert (forall ((c Task)) (=>
	(node AddSourceInDescription c)
	(= (inited c) false)
)))
;AddSourceInDescription Exists
(assert	(exists ((c Task)) (node AddSourceInDescription c)))
;AddSourceInDescription is Unique
(assert	(forall ((c1 Task) (c2 Task)) (=>
	(and (node AddSourceInDescription c1) (node AddSourceInDescription c2))
	(= c1 c2)
)))
;AddSourceInDescription is Distinct
(assert	(forall ((c Task)) (=>
	(node AddSourceInDescription c)
	(not (or
		(node Browsing c)
		(node CreateGraph c)
		(node UseDiscussions c)
		(node MakeViews c)
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
	))
)))

;CreateDiscussions initial analysis tag
(assert (forall ((c Task)) (=>
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
(assert	(forall ((c1 Task) (c2 Task)) (=>
	(and (node CreateDiscussions c1) (node CreateDiscussions c2))
	(= c1 c2)
)))
;CreateDiscussions is Distinct
(assert	(forall ((c Task)) (=>
	(node CreateDiscussions c)
	(not (or
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
	))
)))

;IntegrityOfModelsIU initial analysis tag
(assert (forall ((c SoftGoal)) (=>
	(node IntegrityOfModelsIU c)
	(= (inited c) false)
)))
;IntegrityOfModelsIU Exists
(assert	(exists ((c SoftGoal)) (node IntegrityOfModelsIU c)))
;IntegrityOfModelsIU is Unique
(assert	(forall ((c1 SoftGoal) (c2 SoftGoal)) (=>
	(and (node IntegrityOfModelsIU c1) (node IntegrityOfModelsIU c2))
	(= c1 c2)
)))
;IntegrityOfModelsIU is Distinct
(assert	(forall ((c SoftGoal)) (=>
	(node IntegrityOfModelsIU c)
	(not (or
		(node MakeModelsTrustworthy c)
		(node IntegrityOfModelsIME c)
		(node MinimizeModeratorEffort c)
		(node IntegrityOfModels c)
	))
)))

;ExtensiveModeration initial analysis tag
(assert (forall ((c Task)) (=>
	(node ExtensiveModeration c)
	(= (inited c) false)
)))
;ExtensiveModeration Exists
(assert	(exists ((c Task)) (node ExtensiveModeration c)))
;ExtensiveModeration is Unique
(assert	(forall ((c1 Task) (c2 Task)) (=>
	(and (node ExtensiveModeration c1) (node ExtensiveModeration c2))
	(= c1 c2)
)))
;ExtensiveModeration is Distinct
(assert	(forall ((c Task)) (=>
	(node ExtensiveModeration c)
	(not (or
		(node Browsing c)
		(node CreateGraph c)
		(node UseDiscussions c)
		(node MakeViews c)
		(node AddSourceInDescription c)
		(node CreateDiscussions c)
		(node UseAutomatedReputationSystem c)
		(node ProvideReputations c)
		(node ModerationARS c)
		(node TrackAuthorship c)
		(node DisplayGraphs c)
		(node TrackRevisions c)
		(node CreateGraphs c)
		(node BeInflo c)
		(node ModerationTasks c)
	))
)))

;UseAutomatedReputationSystem initial analysis tag
(assert (forall ((c Task)) (=>
	(node UseAutomatedReputationSystem c)
	(= (inited c) false)
)))
;UseAutomatedReputationSystem Exists
(assert	(exists ((c Task)) (node UseAutomatedReputationSystem c)))
;UseAutomatedReputationSystem is Unique
(assert	(forall ((c1 Task) (c2 Task)) (=>
	(and (node UseAutomatedReputationSystem c1) (node UseAutomatedReputationSystem c2))
	(= c1 c2)
)))
;UseAutomatedReputationSystem is Distinct
(assert	(forall ((c Task)) (=>
	(node UseAutomatedReputationSystem c)
	(not (or
		(node Browsing c)
		(node CreateGraph c)
		(node UseDiscussions c)
		(node MakeViews c)
		(node AddSourceInDescription c)
		(node CreateDiscussions c)
		(node ExtensiveModeration c)
		(node ProvideReputations c)
		(node ModerationARS c)
		(node TrackAuthorship c)
		(node DisplayGraphs c)
		(node TrackRevisions c)
		(node CreateGraphs c)
		(node BeInflo c)
		(node ModerationTasks c)
	))
)))

;ModerateInflo initial analysis tag
(assert (forall ((c Goal)) (=>
	(node ModerateInflo c)
	(= (inited c) false)
)))
;ModerateInflo Exists
(assert	(exists ((c Goal)) (node ModerateInflo c)))
;ModerateInflo is Unique
(assert	(forall ((c1 Goal) (c2 Goal)) (=>
	(and (node ModerateInflo c1) (node ModerateInflo c2))
	(= c1 c2)
)))
;ModerateInflo is Distinct
(assert	(forall ((c Goal)) (=>
	(node ModerateInflo c)
	(not (or
		(node UseInflo c)
		(node InfloBeModerated c)
		(node AllowModeration c)
	))
)))

;LessExtensiveModeration initial analysis tag
(assert (forall ((c Task)) (=>
	(node LessExtensiveModeration c)
	(= (inited c) false)
)))
;LessExtensiveModeration is Unique
(assert	(forall ((c1 Task) (c2 Task)) (=>
	(and (node LessExtensiveModeration c1) (node LessExtensiveModeration c2))
	(= c1 c2)
)))
;LessExtensiveModeration is Distinct
(assert	(forall ((c Task)) (=>
	(node LessExtensiveModeration c)
	(not (or
		(node Browsing c)
		(node CreateGraph c)
		(node UseDiscussions c)
		(node MakeViews c)
		(node AddSourceInDescription c)
		(node CreateDiscussions c)
		(node ProvideReputations c)
		(node ModerationARS c)
		(node TrackAuthorship c)
		(node DisplayGraphs c)
		(node TrackRevisions c)
		(node CreateGraphs c)
		(node BeInflo c)
		(node ModerationTasks c)
	))
)))

;IntegrityOfModelsIME initial analysis tag
(assert (forall ((c SoftGoal)) (=>
	(node IntegrityOfModelsIME c)
	(= (inited c) false)
)))
;IntegrityOfModelsIME Exists
(assert	(exists ((c SoftGoal)) (node IntegrityOfModelsIME c)))
;IntegrityOfModelsIME is Unique
(assert	(forall ((c1 SoftGoal) (c2 SoftGoal)) (=>
	(and (node IntegrityOfModelsIME c1) (node IntegrityOfModelsIME c2))
	(= c1 c2)
)))
;IntegrityOfModelsIME is Distinct
(assert	(forall ((c SoftGoal)) (=>
	(node IntegrityOfModelsIME c)
	(not (or
		(node MakeModelsTrustworthy c)
		(node ValidateModel c)
		(node GetFeedback c)
		(node IntegrityOfModelsIU c)
		(node MinimizeModeratorEffort c)
		(node IntegrityOfModels c)
	))
)))

;MinimizeModeratorEffort initial analysis tag
(assert (forall ((c SoftGoal)) (=>
	(node MinimizeModeratorEffort c)
	(= (inited c) false)
)))
;MinimizeModeratorEffort Exists
(assert	(exists ((c SoftGoal)) (node MinimizeModeratorEffort c)))
;MinimizeModeratorEffort is Unique
(assert	(forall ((c1 SoftGoal) (c2 SoftGoal)) (=>
	(and (node MinimizeModeratorEffort c1) (node MinimizeModeratorEffort c2))
	(= c1 c2)
)))
;MinimizeModeratorEffort is Distinct
(assert	(forall ((c SoftGoal)) (=>
	(node MinimizeModeratorEffort c)
	(not (or
		(node MakeModelsTrustworthy c)
		(node ValidateModel c)
		(node GetFeedback c)
		(node IntegrityOfModelsIU c)
		(node IntegrityOfModelsIME c)
		(node IntegrityOfModels c)
	))
)))

;ProvideReputations initial analysis tag
(assert (forall ((c Task)) (=>
	(node ProvideReputations c)
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
;ProvideReputations Exists
(assert	(exists ((c Task)) (node ProvideReputations c)))
;ProvideReputations is Unique
(assert	(forall ((c1 Task) (c2 Task)) (=>
	(and (node ProvideReputations c1) (node ProvideReputations c2))
	(= c1 c2)
)))
;ProvideReputations is Distinct
(assert	(forall ((c Task)) (=>
	(node ProvideReputations c)
	(not (or
		(node Browsing c)
		(node CreateGraph c)
		(node UseDiscussions c)
		(node MakeViews c)
		(node AddSourceInDescription c)
		(node CreateDiscussions c)
		(node ExtensiveModeration c)
		(node UseAutomatedReputationSystem c)
		(node LessExtensiveModeration c)
		(node ModerationARS c)
		(node TrackAuthorship c)
		(node DisplayGraphs c)
		(node TrackRevisions c)
		(node CreateGraphs c)
		(node BeInflo c)
		(node ModerationTasks c)
	))
)))

;ModerationARS initial analysis tag
(assert (forall ((c Task)) (=>
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
(assert	(forall ((c1 Task) (c2 Task)) (=>
	(and (node ModerationARS c1) (node ModerationARS c2))
	(= c1 c2)
)))
;ModerationARS is Distinct
(assert	(forall ((c Task)) (=>
	(node ModerationARS c)
	(not (or
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
		(node TrackAuthorship c)
		(node DisplayGraphs c)
		(node TrackRevisions c)
		(node CreateGraphs c)
		(node BeInflo c)
		(node ModerationTasks c)
	))
)))

;AllowModeration initial analysis tag
(assert (forall ((c Goal)) (=>
	(node AllowModeration c)
	(= (inited c) false)
)))
;AllowModeration Exists
(assert	(exists ((c Goal)) (node AllowModeration c)))
;AllowModeration is Unique
(assert	(forall ((c1 Goal) (c2 Goal)) (=>
	(and (node AllowModeration c1) (node AllowModeration c2))
	(= c1 c2)
)))
;AllowModeration is Distinct
(assert	(forall ((c Goal)) (=>
	(node AllowModeration c)
	(not (or
		(node UseInflo c)
		(node InfloBeModerated c)
		(node ModerateInflo c)
	))
)))

;TrackAuthorship initial analysis tag
(assert (forall ((c Task)) (=>
	(node TrackAuthorship c)
	(= (inited c) false)
)))
;TrackAuthorship Exists
(assert	(exists ((c Task)) (node TrackAuthorship c)))
;TrackAuthorship is Unique
(assert	(forall ((c1 Task) (c2 Task)) (=>
	(and (node TrackAuthorship c1) (node TrackAuthorship c2))
	(= c1 c2)
)))
;TrackAuthorship is Distinct
(assert	(forall ((c Task)) (=>
	(node TrackAuthorship c)
	(not (or
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
		(node DisplayGraphs c)
		(node TrackRevisions c)
		(node CreateGraphs c)
		(node BeInflo c)
		(node ModerationTasks c)
	))
)))

;DisplayGraphs initial analysis tag
(assert (forall ((c Task)) (=>
	(node DisplayGraphs c)
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
;DisplayGraphs Exists
(assert	(exists ((c Task)) (node DisplayGraphs c)))
;DisplayGraphs is Unique
(assert	(forall ((c1 Task) (c2 Task)) (=>
	(and (node DisplayGraphs c1) (node DisplayGraphs c2))
	(= c1 c2)
)))
;DisplayGraphs is Distinct
(assert	(forall ((c Task)) (=>
	(node DisplayGraphs c)
	(not (or
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
		(node TrackRevisions c)
		(node CreateGraphs c)
		(node BeInflo c)
		(node ModerationTasks c)
	))
)))

;TrackRevisions initial analysis tag
(assert (forall ((c Task)) (=>
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
(assert	(exists ((c Task)) (node TrackRevisions c)))
;TrackRevisions is Unique
(assert	(forall ((c1 Task) (c2 Task)) (=>
	(and (node TrackRevisions c1) (node TrackRevisions c2))
	(= c1 c2)
)))
;TrackRevisions is Distinct
(assert	(forall ((c Task)) (=>
	(node TrackRevisions c)
	(not (or
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
		(node CreateGraphs c)
		(node BeInflo c)
		(node ModerationTasks c)
	))
)))

;CreateGraphs initial analysis tag
(assert (forall ((c Task)) (=>
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
(assert	(exists ((c Task)) (node CreateGraphs c)))
;CreateGraphs is Unique
(assert	(forall ((c1 Task) (c2 Task)) (=>
	(and (node CreateGraphs c1) (node CreateGraphs c2))
	(= c1 c2)
)))
;CreateGraphs is Distinct
(assert	(forall ((c Task)) (=>
	(node CreateGraphs c)
	(not (or
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
		(node BeInflo c)
		(node ModerationTasks c)
	))
)))

;BeInflo initial analysis tag
(assert (forall ((c Task)) (=>
	(node BeInflo c)
	(= (inited c) false)
)))
;BeInflo Exists
(assert	(exists ((c Task)) (node BeInflo c)))
;BeInflo is Unique
(assert	(forall ((c1 Task) (c2 Task)) (=>
	(and (node BeInflo c1) (node BeInflo c2))
	(= c1 c2)
)))
;BeInflo is Distinct
(assert	(forall ((c Task)) (=>
	(node BeInflo c)
	(not (or
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
		(node ModerationTasks c)
	))
)))

;ModerationTasks initial analysis tag
(assert (forall ((c Task)) (=>
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
;ModerationTasks is Distinct
(assert	(forall ((c Task)) (=>
	(node ModerationTasks c)
	(not (or
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
	))
)))

;Moderation initial analysis tag
(assert (forall ((c Resource)) (=>
	(node Moderation c)
	(= (inited c) false)
)))
;Moderation Exists
(assert	(exists ((c Resource)) (node Moderation c)))
;Moderation is Unique
(assert	(forall ((c1 Resource) (c2 Resource)) (=>
	(and (node Moderation c1) (node Moderation c2))
	(= c1 c2)
)))
;Moderation is Distinct
(assert	(forall ((c Resource)) (=>
	(node Moderation c)
	(not (or
		(node Graphing c)
		(node ReputationValues c)
		(node Info c)
		(node Authorship c)
	))
)))

;Graphing initial analysis tag
(assert (forall ((c Resource)) (=>
	(node Graphing c)
	(= (inited c) false)
)))
;Graphing Exists
(assert	(exists ((c Resource)) (node Graphing c)))
;Graphing is Unique
(assert	(forall ((c1 Resource) (c2 Resource)) (=>
	(and (node Graphing c1) (node Graphing c2))
	(= c1 c2)
)))
;Graphing is Distinct
(assert	(forall ((c Resource)) (=>
	(node Graphing c)
	(not (or
		(node Moderation c)
		(node ReputationValues c)
		(node Info c)
		(node Authorship c)
	))
)))

;ReputationValues initial analysis tag
(assert (forall ((c Resource)) (=>
	(node ReputationValues c)
	(= (inited c) false)
)))
;ReputationValues Exists
(assert	(exists ((c Resource)) (node ReputationValues c)))
;ReputationValues is Unique
(assert	(forall ((c1 Resource) (c2 Resource)) (=>
	(and (node ReputationValues c1) (node ReputationValues c2))
	(= c1 c2)
)))
;ReputationValues is Distinct
(assert	(forall ((c Resource)) (=>
	(node ReputationValues c)
	(not (or
		(node Moderation c)
		(node Graphing c)
		(node Info c)
		(node Authorship c)
	))
)))

;Info initial analysis tag
(assert (forall ((c Resource)) (=>
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
(assert	(exists ((c Resource)) (node Info c)))
;Info is Distinct
(assert	(forall ((c Resource)) (=>
	(node Info c)
	(not (or
		(node Moderation c)
		(node Graphing c)
		(node ReputationValues c)
		(node Authorship c)
	))
)))

;Authorship initial analysis tag
(assert (forall ((c Resource)) (=>
	(node Authorship c)
	(= (inited c) false)
)))
;Authorship is Unique
(assert	(forall ((c1 Resource) (c2 Resource)) (=>
	(and (node Authorship c1) (node Authorship c2))
	(= c1 c2)
)))
;Authorship is Distinct
(assert	(forall ((c Resource)) (=>
	(node Authorship c)
	(not (or
		(node Moderation c)
		(node Graphing c)
		(node ReputationValues c)
		(node Info c)
	))
)))

;IntegrityOfModels initial analysis tag
(assert (forall ((c SoftGoal)) (=>
	(node IntegrityOfModels c)
	(= (inited c) false)
)))
;IntegrityOfModels Exists
(assert	(exists ((c SoftGoal)) (node IntegrityOfModels c)))
;IntegrityOfModels is Unique
(assert	(forall ((c1 SoftGoal) (c2 SoftGoal)) (=>
	(and (node IntegrityOfModels c1) (node IntegrityOfModels c2))
	(= c1 c2)
)))
;IntegrityOfModels is Distinct
(assert	(forall ((c SoftGoal)) (=>
	(node IntegrityOfModels c)
	(not (or
		(node MakeModelsTrustworthy c)
		(node ValidateModel c)
		(node GetFeedback c)
		(node IntegrityOfModelsIU c)
		(node IntegrityOfModelsIME c)
		(node MinimizeModeratorEffort c)
	))
)))

;InfloUser2MakeModelsTrustworthy tgtType constant
(assert (forall ((c Containment)) (=>
	(edge InfloUser2MakeModelsTrustworthy c)
	(= (tgtType c) SOFTGOAL)
)))
;InfloUser2MakeModelsTrustworthy endpoints
(assert (forall ((c Containment)) (=>
	(edge InfloUser2MakeModelsTrustworthy c)
	(and
		(node InfloUser (src c))
		(node MakeModelsTrustworthy ((as tgt (SoftGoal)) c))
	)
)))
;InfloUser2MakeModelsTrustworthy Exists
(assert	(exists ((c Containment)) (edge InfloUser2MakeModelsTrustworthy c)))
;InfloUser2MakeModelsTrustworthy is Unique
(assert	(forall ((c1 Containment) (c2 Containment)) (=>
	(and (edge InfloUser2MakeModelsTrustworthy c1) (edge InfloUser2MakeModelsTrustworthy c2))
	(= c1 c2)
)))
;InfloUser2MakeModelsTrustworthy is Distinct
(assert	(forall ((c Containment)) (=>
	(edge InfloUser2MakeModelsTrustworthy c)
	(not (or
		(edge InfloUser2IntegrityOfModelsIU c)
		(edge InfloManagerEditors2IntegrityOfModelsIME c)
		(edge InfloManagerEditors2MinimizeModeratorEffort c)
	))
)))
;InfloUser2UseInflo tgtType constant
(assert (forall ((c Containment)) (=>
	(edge InfloUser2UseInflo c)
	(= (tgtType c) GOAL)
)))
;InfloUser2UseInflo endpoints
(assert (forall ((c Containment)) (=>
	(edge InfloUser2UseInflo c)
	(and
		(node InfloUser (src c))
		(node UseInflo ((as tgt (Goal)) c))
	)
)))
;InfloUser2UseInflo Exists
(assert	(exists ((c Containment)) (edge InfloUser2UseInflo c)))
;InfloUser2UseInflo is Unique
(assert	(forall ((c1 Containment) (c2 Containment)) (=>
	(and (edge InfloUser2UseInflo c1) (edge InfloUser2UseInflo c2))
	(= c1 c2)
)))
;InfloUser2UseInflo is Distinct
(assert	(forall ((c Containment)) (=>
	(edge InfloUser2UseInflo c)
	(not (or
		(edge InfloUser2InfloBeModerated c)
		(edge InfloManagerEditors2ModerateInflo c)
		(edge Inflo2AllowModeration c)
	))
)))
;InfloUser2ValidateModel tgtType constant
(assert (forall ((c Containment)) (=>
	(edge InfloUser2ValidateModel c)
	(= (tgtType c) SOFTGOAL)
)))
;InfloUser2ValidateModel endpoints
(assert (forall ((c Containment)) (=>
	(edge InfloUser2ValidateModel c)
	(and
		(node InfloUser (src c))
		(node ValidateModel ((as tgt (SoftGoal)) c))
	)
)))
;InfloUser2ValidateModel Exists
(assert	(exists ((c Containment)) (edge InfloUser2ValidateModel c)))
;InfloUser2ValidateModel is Unique
(assert	(forall ((c1 Containment) (c2 Containment)) (=>
	(and (edge InfloUser2ValidateModel c1) (edge InfloUser2ValidateModel c2))
	(= c1 c2)
)))
;InfloUser2ValidateModel is Distinct
(assert	(forall ((c Containment)) (=>
	(edge InfloUser2ValidateModel c)
	(not (or
		(edge InfloManagerEditors2IntegrityOfModelsIME c)
		(edge InfloManagerEditors2MinimizeModeratorEffort c)
	))
)))
;InfloUser2GetFeedback tgtType constant
(assert (forall ((c Containment)) (=>
	(edge InfloUser2GetFeedback c)
	(= (tgtType c) SOFTGOAL)
)))
;InfloUser2GetFeedback endpoints
(assert (forall ((c Containment)) (=>
	(edge InfloUser2GetFeedback c)
	(and
		(node InfloUser (src c))
		(node GetFeedback ((as tgt (SoftGoal)) c))
	)
)))
;InfloUser2GetFeedback Exists
(assert	(exists ((c Containment)) (edge InfloUser2GetFeedback c)))
;InfloUser2GetFeedback is Unique
(assert	(forall ((c1 Containment) (c2 Containment)) (=>
	(and (edge InfloUser2GetFeedback c1) (edge InfloUser2GetFeedback c2))
	(= c1 c2)
)))
;InfloUser2GetFeedback is Distinct
(assert	(forall ((c Containment)) (=>
	(edge InfloUser2GetFeedback c)
	(not (or
		(edge InfloManagerEditors2IntegrityOfModelsIME c)
		(edge InfloManagerEditors2MinimizeModeratorEffort c)
	))
)))
;InfloUser2Browsing tgtType constant
(assert (forall ((c Containment)) (=>
	(edge InfloUser2Browsing c)
	(= (tgtType c) TASK)
)))
;InfloUser2Browsing endpoints
(assert (forall ((c Containment)) (=>
	(edge InfloUser2Browsing c)
	(and
		(node InfloUser (src c))
		(node Browsing ((as tgt (Task)) c))
	)
)))
;InfloUser2Browsing Exists
(assert	(exists ((c Containment)) (edge InfloUser2Browsing c)))
;InfloUser2Browsing is Unique
(assert	(forall ((c1 Containment) (c2 Containment)) (=>
	(and (edge InfloUser2Browsing c1) (edge InfloUser2Browsing c2))
	(= c1 c2)
)))
;InfloUser2Browsing is Distinct
(assert	(forall ((c Containment)) (=>
	(edge InfloUser2Browsing c)
	(not (or
		(edge InfloUser2CreateGraph c)
		(edge InfloUser2UseDiscussions c)
		(edge InfloUser2MakeViews c)
		(edge InfloUser2AddSourceInDescription c)
		(edge InfloManagerEditors2ExtensiveModeration c)
		(edge InfloManagerEditors2UseAutomatedReputationSystem c)
		(edge InfloManagerEditors2LessExtensiveModeration c)
		(edge AutomatedReputationSystem2ProvideReputations c)
		(edge AutomatedReputationSystem2ModerationARS c)
		(edge Inflo2TrackAuthorship c)
		(edge Inflo2DisplayGraphs c)
		(edge Inflo2TrackRevisions c)
		(edge Inflo2CreateGraphs c)
		(edge Inflo2BeInflo c)
		(edge Inflo2ModerationTasks c)
	))
)))
;InfloUser2CreateGraph tgtType constant
(assert (forall ((c Containment)) (=>
	(edge InfloUser2CreateGraph c)
	(= (tgtType c) TASK)
)))
;InfloUser2CreateGraph endpoints
(assert (forall ((c Containment)) (=>
	(edge InfloUser2CreateGraph c)
	(and
		(node InfloUser (src c))
		(node CreateGraph ((as tgt (Task)) c))
	)
)))
;InfloUser2CreateGraph Exists
(assert	(exists ((c Containment)) (edge InfloUser2CreateGraph c)))
;InfloUser2CreateGraph is Unique
(assert	(forall ((c1 Containment) (c2 Containment)) (=>
	(and (edge InfloUser2CreateGraph c1) (edge InfloUser2CreateGraph c2))
	(= c1 c2)
)))
;InfloUser2CreateGraph is Distinct
(assert	(forall ((c Containment)) (=>
	(edge InfloUser2CreateGraph c)
	(not (or
		(edge InfloUser2Browsing c)
		(edge InfloUser2UseDiscussions c)
		(edge InfloUser2MakeViews c)
		(edge InfloUser2AddSourceInDescription c)
		(edge InfloManagerEditors2ExtensiveModeration c)
		(edge InfloManagerEditors2UseAutomatedReputationSystem c)
		(edge InfloManagerEditors2LessExtensiveModeration c)
		(edge AutomatedReputationSystem2ProvideReputations c)
		(edge AutomatedReputationSystem2ModerationARS c)
		(edge Inflo2TrackAuthorship c)
		(edge Inflo2DisplayGraphs c)
		(edge Inflo2TrackRevisions c)
		(edge Inflo2CreateGraphs c)
		(edge Inflo2BeInflo c)
		(edge Inflo2ModerationTasks c)
	))
)))
;InfloUser2UseDiscussions tgtType constant
(assert (forall ((c Containment)) (=>
	(edge InfloUser2UseDiscussions c)
	(= (tgtType c) TASK)
)))
;InfloUser2UseDiscussions endpoints
(assert (forall ((c Containment)) (=>
	(edge InfloUser2UseDiscussions c)
	(and
		(node InfloUser (src c))
		(node UseDiscussions ((as tgt (Task)) c))
	)
)))
;InfloUser2UseDiscussions Exists
(assert	(exists ((c Containment)) (edge InfloUser2UseDiscussions c)))
;InfloUser2UseDiscussions is Unique
(assert	(forall ((c1 Containment) (c2 Containment)) (=>
	(and (edge InfloUser2UseDiscussions c1) (edge InfloUser2UseDiscussions c2))
	(= c1 c2)
)))
;InfloUser2UseDiscussions is Distinct
(assert	(forall ((c Containment)) (=>
	(edge InfloUser2UseDiscussions c)
	(not (or
		(edge InfloUser2Browsing c)
		(edge InfloUser2CreateGraph c)
		(edge InfloUser2MakeViews c)
		(edge InfloUser2AddSourceInDescription c)
		(edge InfloManagerEditors2ExtensiveModeration c)
		(edge InfloManagerEditors2UseAutomatedReputationSystem c)
		(edge InfloManagerEditors2LessExtensiveModeration c)
		(edge AutomatedReputationSystem2ProvideReputations c)
		(edge AutomatedReputationSystem2ModerationARS c)
		(edge Inflo2TrackAuthorship c)
		(edge Inflo2DisplayGraphs c)
		(edge Inflo2TrackRevisions c)
		(edge Inflo2CreateGraphs c)
		(edge Inflo2BeInflo c)
		(edge Inflo2ModerationTasks c)
	))
)))
;InfloUser2InfloBeModerated tgtType constant
(assert (forall ((c Containment)) (=>
	(edge InfloUser2InfloBeModerated c)
	(= (tgtType c) GOAL)
)))
;InfloUser2InfloBeModerated endpoints
(assert (forall ((c Containment)) (=>
	(edge InfloUser2InfloBeModerated c)
	(and
		(node InfloUser (src c))
		(node InfloBeModerated ((as tgt (Goal)) c))
	)
)))
;InfloUser2InfloBeModerated Exists
(assert	(exists ((c Containment)) (edge InfloUser2InfloBeModerated c)))
;InfloUser2InfloBeModerated is Unique
(assert	(forall ((c1 Containment) (c2 Containment)) (=>
	(and (edge InfloUser2InfloBeModerated c1) (edge InfloUser2InfloBeModerated c2))
	(= c1 c2)
)))
;InfloUser2InfloBeModerated is Distinct
(assert	(forall ((c Containment)) (=>
	(edge InfloUser2InfloBeModerated c)
	(not (or
		(edge InfloUser2UseInflo c)
		(edge InfloManagerEditors2ModerateInflo c)
		(edge Inflo2AllowModeration c)
	))
)))
;InfloUser2MakeViews tgtType constant
(assert (forall ((c Containment)) (=>
	(edge InfloUser2MakeViews c)
	(= (tgtType c) TASK)
)))
;InfloUser2MakeViews endpoints
(assert (forall ((c Containment)) (=>
	(edge InfloUser2MakeViews c)
	(and
		(node InfloUser (src c))
		(node MakeViews ((as tgt (Task)) c))
	)
)))
;InfloUser2MakeViews Exists
(assert	(exists ((c Containment)) (edge InfloUser2MakeViews c)))
;InfloUser2MakeViews is Unique
(assert	(forall ((c1 Containment) (c2 Containment)) (=>
	(and (edge InfloUser2MakeViews c1) (edge InfloUser2MakeViews c2))
	(= c1 c2)
)))
;InfloUser2MakeViews is Distinct
(assert	(forall ((c Containment)) (=>
	(edge InfloUser2MakeViews c)
	(not (or
		(edge InfloUser2Browsing c)
		(edge InfloUser2CreateGraph c)
		(edge InfloUser2UseDiscussions c)
		(edge InfloUser2AddSourceInDescription c)
		(edge InfloManagerEditors2ExtensiveModeration c)
		(edge InfloManagerEditors2UseAutomatedReputationSystem c)
		(edge InfloManagerEditors2LessExtensiveModeration c)
		(edge AutomatedReputationSystem2ProvideReputations c)
		(edge AutomatedReputationSystem2ModerationARS c)
		(edge Inflo2TrackAuthorship c)
		(edge Inflo2DisplayGraphs c)
		(edge Inflo2TrackRevisions c)
		(edge Inflo2CreateGraphs c)
		(edge Inflo2BeInflo c)
		(edge Inflo2ModerationTasks c)
	))
)))
;InfloUser2AddSourceInDescription tgtType constant
(assert (forall ((c Containment)) (=>
	(edge InfloUser2AddSourceInDescription c)
	(= (tgtType c) TASK)
)))
;InfloUser2AddSourceInDescription endpoints
(assert (forall ((c Containment)) (=>
	(edge InfloUser2AddSourceInDescription c)
	(and
		(node InfloUser (src c))
		(node AddSourceInDescription ((as tgt (Task)) c))
	)
)))
;InfloUser2AddSourceInDescription Exists
(assert	(exists ((c Containment)) (edge InfloUser2AddSourceInDescription c)))
;InfloUser2AddSourceInDescription is Unique
(assert	(forall ((c1 Containment) (c2 Containment)) (=>
	(and (edge InfloUser2AddSourceInDescription c1) (edge InfloUser2AddSourceInDescription c2))
	(= c1 c2)
)))
;InfloUser2AddSourceInDescription is Distinct
(assert	(forall ((c Containment)) (=>
	(edge InfloUser2AddSourceInDescription c)
	(not (or
		(edge InfloUser2Browsing c)
		(edge InfloUser2CreateGraph c)
		(edge InfloUser2UseDiscussions c)
		(edge InfloUser2MakeViews c)
		(edge InfloManagerEditors2ExtensiveModeration c)
		(edge InfloManagerEditors2UseAutomatedReputationSystem c)
		(edge InfloManagerEditors2LessExtensiveModeration c)
		(edge AutomatedReputationSystem2ProvideReputations c)
		(edge AutomatedReputationSystem2ModerationARS c)
		(edge Inflo2TrackAuthorship c)
		(edge Inflo2DisplayGraphs c)
		(edge Inflo2TrackRevisions c)
		(edge Inflo2CreateGraphs c)
		(edge Inflo2BeInflo c)
		(edge Inflo2ModerationTasks c)
	))
)))
;InfloUser2CreateDiscussions tgtType constant
(assert (forall ((c Containment)) (=>
	(edge InfloUser2CreateDiscussions c)
	(= (tgtType c) TASK)
)))
;InfloUser2CreateDiscussions endpoints
(assert (forall ((c Containment)) (=>
	(edge InfloUser2CreateDiscussions c)
	(and
		(node InfloUser (src c))
		(node CreateDiscussions ((as tgt (Task)) c))
	)
)))
;InfloUser2CreateDiscussions is Unique
(assert	(forall ((c1 Containment) (c2 Containment)) (=>
	(and (edge InfloUser2CreateDiscussions c1) (edge InfloUser2CreateDiscussions c2))
	(= c1 c2)
)))
;InfloUser2CreateDiscussions is Distinct
(assert	(forall ((c Containment)) (=>
	(edge InfloUser2CreateDiscussions c)
	(not (or
		(edge InfloManagerEditors2ExtensiveModeration c)
		(edge InfloManagerEditors2UseAutomatedReputationSystem c)
		(edge InfloManagerEditors2LessExtensiveModeration c)
		(edge AutomatedReputationSystem2ProvideReputations c)
		(edge AutomatedReputationSystem2ModerationARS c)
		(edge Inflo2TrackAuthorship c)
		(edge Inflo2DisplayGraphs c)
		(edge Inflo2TrackRevisions c)
		(edge Inflo2CreateGraphs c)
		(edge Inflo2BeInflo c)
		(edge Inflo2ModerationTasks c)
	))
)))
;InfloUser2IntegrityOfModelsIU tgtType constant
(assert (forall ((c Containment)) (=>
	(edge InfloUser2IntegrityOfModelsIU c)
	(= (tgtType c) SOFTGOAL)
)))
;InfloUser2IntegrityOfModelsIU endpoints
(assert (forall ((c Containment)) (=>
	(edge InfloUser2IntegrityOfModelsIU c)
	(and
		(node InfloUser (src c))
		(node IntegrityOfModelsIU ((as tgt (SoftGoal)) c))
	)
)))
;InfloUser2IntegrityOfModelsIU Exists
(assert	(exists ((c Containment)) (edge InfloUser2IntegrityOfModelsIU c)))
;InfloUser2IntegrityOfModelsIU is Unique
(assert	(forall ((c1 Containment) (c2 Containment)) (=>
	(and (edge InfloUser2IntegrityOfModelsIU c1) (edge InfloUser2IntegrityOfModelsIU c2))
	(= c1 c2)
)))
;InfloUser2IntegrityOfModelsIU is Distinct
(assert	(forall ((c Containment)) (=>
	(edge InfloUser2IntegrityOfModelsIU c)
	(not (or
		(edge InfloUser2MakeModelsTrustworthy c)
		(edge InfloManagerEditors2IntegrityOfModelsIME c)
		(edge InfloManagerEditors2MinimizeModeratorEffort c)
	))
)))
;InfloManagerEditors2ExtensiveModeration tgtType constant
(assert (forall ((c Containment)) (=>
	(edge InfloManagerEditors2ExtensiveModeration c)
	(= (tgtType c) TASK)
)))
;InfloManagerEditors2ExtensiveModeration endpoints
(assert (forall ((c Containment)) (=>
	(edge InfloManagerEditors2ExtensiveModeration c)
	(and
		(node InfloManagerEditors (src c))
		(node ExtensiveModeration ((as tgt (Task)) c))
	)
)))
;InfloManagerEditors2ExtensiveModeration Exists
(assert	(exists ((c Containment)) (edge InfloManagerEditors2ExtensiveModeration c)))
;InfloManagerEditors2ExtensiveModeration is Unique
(assert	(forall ((c1 Containment) (c2 Containment)) (=>
	(and (edge InfloManagerEditors2ExtensiveModeration c1) (edge InfloManagerEditors2ExtensiveModeration c2))
	(= c1 c2)
)))
;InfloManagerEditors2ExtensiveModeration is Distinct
(assert	(forall ((c Containment)) (=>
	(edge InfloManagerEditors2ExtensiveModeration c)
	(not (or
		(edge InfloUser2Browsing c)
		(edge InfloUser2CreateGraph c)
		(edge InfloUser2UseDiscussions c)
		(edge InfloUser2MakeViews c)
		(edge InfloUser2AddSourceInDescription c)
		(edge InfloUser2CreateDiscussions c)
		(edge InfloManagerEditors2UseAutomatedReputationSystem c)
		(edge AutomatedReputationSystem2ProvideReputations c)
		(edge AutomatedReputationSystem2ModerationARS c)
		(edge Inflo2TrackAuthorship c)
		(edge Inflo2DisplayGraphs c)
		(edge Inflo2TrackRevisions c)
		(edge Inflo2CreateGraphs c)
		(edge Inflo2BeInflo c)
		(edge Inflo2ModerationTasks c)
	))
)))
;InfloManagerEditors2UseAutomatedReputationSystem tgtType constant
(assert (forall ((c Containment)) (=>
	(edge InfloManagerEditors2UseAutomatedReputationSystem c)
	(= (tgtType c) TASK)
)))
;InfloManagerEditors2UseAutomatedReputationSystem endpoints
(assert (forall ((c Containment)) (=>
	(edge InfloManagerEditors2UseAutomatedReputationSystem c)
	(and
		(node InfloManagerEditors (src c))
		(node UseAutomatedReputationSystem ((as tgt (Task)) c))
	)
)))
;InfloManagerEditors2UseAutomatedReputationSystem Exists
(assert	(exists ((c Containment)) (edge InfloManagerEditors2UseAutomatedReputationSystem c)))
;InfloManagerEditors2UseAutomatedReputationSystem is Unique
(assert	(forall ((c1 Containment) (c2 Containment)) (=>
	(and (edge InfloManagerEditors2UseAutomatedReputationSystem c1) (edge InfloManagerEditors2UseAutomatedReputationSystem c2))
	(= c1 c2)
)))
;InfloManagerEditors2UseAutomatedReputationSystem is Distinct
(assert	(forall ((c Containment)) (=>
	(edge InfloManagerEditors2UseAutomatedReputationSystem c)
	(not (or
		(edge InfloUser2Browsing c)
		(edge InfloUser2CreateGraph c)
		(edge InfloUser2UseDiscussions c)
		(edge InfloUser2MakeViews c)
		(edge InfloUser2AddSourceInDescription c)
		(edge InfloUser2CreateDiscussions c)
		(edge InfloManagerEditors2ExtensiveModeration c)
		(edge AutomatedReputationSystem2ProvideReputations c)
		(edge AutomatedReputationSystem2ModerationARS c)
		(edge Inflo2TrackAuthorship c)
		(edge Inflo2DisplayGraphs c)
		(edge Inflo2TrackRevisions c)
		(edge Inflo2CreateGraphs c)
		(edge Inflo2BeInflo c)
		(edge Inflo2ModerationTasks c)
	))
)))
;InfloManagerEditors2ModerateInflo tgtType constant
(assert (forall ((c Containment)) (=>
	(edge InfloManagerEditors2ModerateInflo c)
	(= (tgtType c) GOAL)
)))
;InfloManagerEditors2ModerateInflo endpoints
(assert (forall ((c Containment)) (=>
	(edge InfloManagerEditors2ModerateInflo c)
	(and
		(node InfloManagerEditors (src c))
		(node ModerateInflo ((as tgt (Goal)) c))
	)
)))
;InfloManagerEditors2ModerateInflo Exists
(assert	(exists ((c Containment)) (edge InfloManagerEditors2ModerateInflo c)))
;InfloManagerEditors2ModerateInflo is Unique
(assert	(forall ((c1 Containment) (c2 Containment)) (=>
	(and (edge InfloManagerEditors2ModerateInflo c1) (edge InfloManagerEditors2ModerateInflo c2))
	(= c1 c2)
)))
;InfloManagerEditors2ModerateInflo is Distinct
(assert	(forall ((c Containment)) (=>
	(edge InfloManagerEditors2ModerateInflo c)
	(not (or
		(edge InfloUser2UseInflo c)
		(edge InfloUser2InfloBeModerated c)
		(edge Inflo2AllowModeration c)
	))
)))
;InfloManagerEditors2LessExtensiveModeration tgtType constant
(assert (forall ((c Containment)) (=>
	(edge InfloManagerEditors2LessExtensiveModeration c)
	(= (tgtType c) TASK)
)))
;InfloManagerEditors2LessExtensiveModeration endpoints
(assert (forall ((c Containment)) (=>
	(edge InfloManagerEditors2LessExtensiveModeration c)
	(and
		(node InfloManagerEditors (src c))
		(node LessExtensiveModeration ((as tgt (Task)) c))
	)
)))
;InfloManagerEditors2LessExtensiveModeration is Unique
(assert	(forall ((c1 Containment) (c2 Containment)) (=>
	(and (edge InfloManagerEditors2LessExtensiveModeration c1) (edge InfloManagerEditors2LessExtensiveModeration c2))
	(= c1 c2)
)))
;InfloManagerEditors2LessExtensiveModeration is Distinct
(assert	(forall ((c Containment)) (=>
	(edge InfloManagerEditors2LessExtensiveModeration c)
	(not (or
		(edge InfloUser2Browsing c)
		(edge InfloUser2CreateGraph c)
		(edge InfloUser2UseDiscussions c)
		(edge InfloUser2MakeViews c)
		(edge InfloUser2AddSourceInDescription c)
		(edge InfloUser2CreateDiscussions c)
		(edge AutomatedReputationSystem2ProvideReputations c)
		(edge AutomatedReputationSystem2ModerationARS c)
		(edge Inflo2TrackAuthorship c)
		(edge Inflo2DisplayGraphs c)
		(edge Inflo2TrackRevisions c)
		(edge Inflo2CreateGraphs c)
		(edge Inflo2BeInflo c)
		(edge Inflo2ModerationTasks c)
	))
)))
;InfloManagerEditors2IntegrityOfModelsIME tgtType constant
(assert (forall ((c Containment)) (=>
	(edge InfloManagerEditors2IntegrityOfModelsIME c)
	(= (tgtType c) SOFTGOAL)
)))
;InfloManagerEditors2IntegrityOfModelsIME endpoints
(assert (forall ((c Containment)) (=>
	(edge InfloManagerEditors2IntegrityOfModelsIME c)
	(and
		(node InfloManagerEditors (src c))
		(node IntegrityOfModelsIME ((as tgt (SoftGoal)) c))
	)
)))
;InfloManagerEditors2IntegrityOfModelsIME Exists
(assert	(exists ((c Containment)) (edge InfloManagerEditors2IntegrityOfModelsIME c)))
;InfloManagerEditors2IntegrityOfModelsIME is Unique
(assert	(forall ((c1 Containment) (c2 Containment)) (=>
	(and (edge InfloManagerEditors2IntegrityOfModelsIME c1) (edge InfloManagerEditors2IntegrityOfModelsIME c2))
	(= c1 c2)
)))
;InfloManagerEditors2IntegrityOfModelsIME is Distinct
(assert	(forall ((c Containment)) (=>
	(edge InfloManagerEditors2IntegrityOfModelsIME c)
	(not (or
		(edge InfloUser2MakeModelsTrustworthy c)
		(edge InfloUser2ValidateModel c)
		(edge InfloUser2GetFeedback c)
		(edge InfloUser2IntegrityOfModelsIU c)
		(edge InfloManagerEditors2MinimizeModeratorEffort c)
	))
)))
;InfloManagerEditors2MinimizeModeratorEffort tgtType constant
(assert (forall ((c Containment)) (=>
	(edge InfloManagerEditors2MinimizeModeratorEffort c)
	(= (tgtType c) SOFTGOAL)
)))
;InfloManagerEditors2MinimizeModeratorEffort endpoints
(assert (forall ((c Containment)) (=>
	(edge InfloManagerEditors2MinimizeModeratorEffort c)
	(and
		(node InfloManagerEditors (src c))
		(node MinimizeModeratorEffort ((as tgt (SoftGoal)) c))
	)
)))
;InfloManagerEditors2MinimizeModeratorEffort Exists
(assert	(exists ((c Containment)) (edge InfloManagerEditors2MinimizeModeratorEffort c)))
;InfloManagerEditors2MinimizeModeratorEffort is Unique
(assert	(forall ((c1 Containment) (c2 Containment)) (=>
	(and (edge InfloManagerEditors2MinimizeModeratorEffort c1) (edge InfloManagerEditors2MinimizeModeratorEffort c2))
	(= c1 c2)
)))
;InfloManagerEditors2MinimizeModeratorEffort is Distinct
(assert	(forall ((c Containment)) (=>
	(edge InfloManagerEditors2MinimizeModeratorEffort c)
	(not (or
		(edge InfloUser2MakeModelsTrustworthy c)
		(edge InfloUser2ValidateModel c)
		(edge InfloUser2GetFeedback c)
		(edge InfloUser2IntegrityOfModelsIU c)
		(edge InfloManagerEditors2IntegrityOfModelsIME c)
	))
)))
;AutomatedReputationSystem2ProvideReputations tgtType constant
(assert (forall ((c Containment)) (=>
	(edge AutomatedReputationSystem2ProvideReputations c)
	(= (tgtType c) TASK)
)))
;AutomatedReputationSystem2ProvideReputations endpoints
(assert (forall ((c Containment)) (=>
	(edge AutomatedReputationSystem2ProvideReputations c)
	(and
		(node AutomatedReputationSystem (src c))
		(node ProvideReputations ((as tgt (Task)) c))
	)
)))
;AutomatedReputationSystem2ProvideReputations Exists
(assert	(exists ((c Containment)) (edge AutomatedReputationSystem2ProvideReputations c)))
;AutomatedReputationSystem2ProvideReputations is Unique
(assert	(forall ((c1 Containment) (c2 Containment)) (=>
	(and (edge AutomatedReputationSystem2ProvideReputations c1) (edge AutomatedReputationSystem2ProvideReputations c2))
	(= c1 c2)
)))
;AutomatedReputationSystem2ProvideReputations is Distinct
(assert	(forall ((c Containment)) (=>
	(edge AutomatedReputationSystem2ProvideReputations c)
	(not (or
		(edge InfloUser2Browsing c)
		(edge InfloUser2CreateGraph c)
		(edge InfloUser2UseDiscussions c)
		(edge InfloUser2MakeViews c)
		(edge InfloUser2AddSourceInDescription c)
		(edge InfloUser2CreateDiscussions c)
		(edge InfloManagerEditors2ExtensiveModeration c)
		(edge InfloManagerEditors2UseAutomatedReputationSystem c)
		(edge InfloManagerEditors2LessExtensiveModeration c)
		(edge AutomatedReputationSystem2ModerationARS c)
		(edge Inflo2TrackAuthorship c)
		(edge Inflo2DisplayGraphs c)
		(edge Inflo2TrackRevisions c)
		(edge Inflo2CreateGraphs c)
		(edge Inflo2BeInflo c)
		(edge Inflo2ModerationTasks c)
	))
)))
;AutomatedReputationSystem2ModerationARS tgtType constant
(assert (forall ((c Containment)) (=>
	(edge AutomatedReputationSystem2ModerationARS c)
	(= (tgtType c) TASK)
)))
;AutomatedReputationSystem2ModerationARS endpoints
(assert (forall ((c Containment)) (=>
	(edge AutomatedReputationSystem2ModerationARS c)
	(and
		(node AutomatedReputationSystem (src c))
		(node ModerationARS ((as tgt (Task)) c))
	)
)))
;AutomatedReputationSystem2ModerationARS is Unique
(assert	(forall ((c1 Containment) (c2 Containment)) (=>
	(and (edge AutomatedReputationSystem2ModerationARS c1) (edge AutomatedReputationSystem2ModerationARS c2))
	(= c1 c2)
)))
;AutomatedReputationSystem2ModerationARS is Distinct
(assert	(forall ((c Containment)) (=>
	(edge AutomatedReputationSystem2ModerationARS c)
	(not (or
		(edge InfloUser2Browsing c)
		(edge InfloUser2CreateGraph c)
		(edge InfloUser2UseDiscussions c)
		(edge InfloUser2MakeViews c)
		(edge InfloUser2AddSourceInDescription c)
		(edge InfloUser2CreateDiscussions c)
		(edge InfloManagerEditors2ExtensiveModeration c)
		(edge InfloManagerEditors2UseAutomatedReputationSystem c)
		(edge InfloManagerEditors2LessExtensiveModeration c)
		(edge AutomatedReputationSystem2ProvideReputations c)
		(edge Inflo2TrackAuthorship c)
		(edge Inflo2DisplayGraphs c)
		(edge Inflo2TrackRevisions c)
		(edge Inflo2CreateGraphs c)
		(edge Inflo2BeInflo c)
		(edge Inflo2ModerationTasks c)
	))
)))
;Inflo2AllowModeration tgtType constant
(assert (forall ((c Containment)) (=>
	(edge Inflo2AllowModeration c)
	(= (tgtType c) GOAL)
)))
;Inflo2AllowModeration endpoints
(assert (forall ((c Containment)) (=>
	(edge Inflo2AllowModeration c)
	(and
		(node Inflo (src c))
		(node AllowModeration ((as tgt (Goal)) c))
	)
)))
;Inflo2AllowModeration Exists
(assert	(exists ((c Containment)) (edge Inflo2AllowModeration c)))
;Inflo2AllowModeration is Unique
(assert	(forall ((c1 Containment) (c2 Containment)) (=>
	(and (edge Inflo2AllowModeration c1) (edge Inflo2AllowModeration c2))
	(= c1 c2)
)))
;Inflo2AllowModeration is Distinct
(assert	(forall ((c Containment)) (=>
	(edge Inflo2AllowModeration c)
	(not (or
		(edge InfloUser2UseInflo c)
		(edge InfloUser2InfloBeModerated c)
		(edge InfloManagerEditors2ModerateInflo c)
	))
)))
;Inflo2TrackAuthorship tgtType constant
(assert (forall ((c Containment)) (=>
	(edge Inflo2TrackAuthorship c)
	(= (tgtType c) TASK)
)))
;Inflo2TrackAuthorship endpoints
(assert (forall ((c Containment)) (=>
	(edge Inflo2TrackAuthorship c)
	(and
		(node Inflo (src c))
		(node TrackAuthorship ((as tgt (Task)) c))
	)
)))
;Inflo2TrackAuthorship Exists
(assert	(exists ((c Containment)) (edge Inflo2TrackAuthorship c)))
;Inflo2TrackAuthorship is Unique
(assert	(forall ((c1 Containment) (c2 Containment)) (=>
	(and (edge Inflo2TrackAuthorship c1) (edge Inflo2TrackAuthorship c2))
	(= c1 c2)
)))
;Inflo2TrackAuthorship is Distinct
(assert	(forall ((c Containment)) (=>
	(edge Inflo2TrackAuthorship c)
	(not (or
		(edge InfloUser2Browsing c)
		(edge InfloUser2CreateGraph c)
		(edge InfloUser2UseDiscussions c)
		(edge InfloUser2MakeViews c)
		(edge InfloUser2AddSourceInDescription c)
		(edge InfloUser2CreateDiscussions c)
		(edge InfloManagerEditors2ExtensiveModeration c)
		(edge InfloManagerEditors2UseAutomatedReputationSystem c)
		(edge InfloManagerEditors2LessExtensiveModeration c)
		(edge AutomatedReputationSystem2ProvideReputations c)
		(edge AutomatedReputationSystem2ModerationARS c)
		(edge Inflo2DisplayGraphs c)
		(edge Inflo2TrackRevisions c)
		(edge Inflo2CreateGraphs c)
		(edge Inflo2BeInflo c)
		(edge Inflo2ModerationTasks c)
	))
)))
;Inflo2DisplayGraphs tgtType constant
(assert (forall ((c Containment)) (=>
	(edge Inflo2DisplayGraphs c)
	(= (tgtType c) TASK)
)))
;Inflo2DisplayGraphs endpoints
(assert (forall ((c Containment)) (=>
	(edge Inflo2DisplayGraphs c)
	(and
		(node Inflo (src c))
		(node DisplayGraphs ((as tgt (Task)) c))
	)
)))
;Inflo2DisplayGraphs Exists
(assert	(exists ((c Containment)) (edge Inflo2DisplayGraphs c)))
;Inflo2DisplayGraphs is Unique
(assert	(forall ((c1 Containment) (c2 Containment)) (=>
	(and (edge Inflo2DisplayGraphs c1) (edge Inflo2DisplayGraphs c2))
	(= c1 c2)
)))
;Inflo2DisplayGraphs is Distinct
(assert	(forall ((c Containment)) (=>
	(edge Inflo2DisplayGraphs c)
	(not (or
		(edge InfloUser2Browsing c)
		(edge InfloUser2CreateGraph c)
		(edge InfloUser2UseDiscussions c)
		(edge InfloUser2MakeViews c)
		(edge InfloUser2AddSourceInDescription c)
		(edge InfloUser2CreateDiscussions c)
		(edge InfloManagerEditors2ExtensiveModeration c)
		(edge InfloManagerEditors2UseAutomatedReputationSystem c)
		(edge InfloManagerEditors2LessExtensiveModeration c)
		(edge AutomatedReputationSystem2ProvideReputations c)
		(edge AutomatedReputationSystem2ModerationARS c)
		(edge Inflo2TrackAuthorship c)
		(edge Inflo2TrackRevisions c)
		(edge Inflo2CreateGraphs c)
		(edge Inflo2BeInflo c)
		(edge Inflo2ModerationTasks c)
	))
)))
;Inflo2TrackRevisions tgtType constant
(assert (forall ((c Containment)) (=>
	(edge Inflo2TrackRevisions c)
	(= (tgtType c) TASK)
)))
;Inflo2TrackRevisions endpoints
(assert (forall ((c Containment)) (=>
	(edge Inflo2TrackRevisions c)
	(and
		(node Inflo (src c))
		(node TrackRevisions ((as tgt (Task)) c))
	)
)))
;Inflo2TrackRevisions Exists
(assert	(exists ((c Containment)) (edge Inflo2TrackRevisions c)))
;Inflo2TrackRevisions is Unique
(assert	(forall ((c1 Containment) (c2 Containment)) (=>
	(and (edge Inflo2TrackRevisions c1) (edge Inflo2TrackRevisions c2))
	(= c1 c2)
)))
;Inflo2TrackRevisions is Distinct
(assert	(forall ((c Containment)) (=>
	(edge Inflo2TrackRevisions c)
	(not (or
		(edge InfloUser2Browsing c)
		(edge InfloUser2CreateGraph c)
		(edge InfloUser2UseDiscussions c)
		(edge InfloUser2MakeViews c)
		(edge InfloUser2AddSourceInDescription c)
		(edge InfloUser2CreateDiscussions c)
		(edge InfloManagerEditors2ExtensiveModeration c)
		(edge InfloManagerEditors2UseAutomatedReputationSystem c)
		(edge InfloManagerEditors2LessExtensiveModeration c)
		(edge AutomatedReputationSystem2ProvideReputations c)
		(edge AutomatedReputationSystem2ModerationARS c)
		(edge Inflo2TrackAuthorship c)
		(edge Inflo2DisplayGraphs c)
		(edge Inflo2CreateGraphs c)
		(edge Inflo2BeInflo c)
		(edge Inflo2ModerationTasks c)
	))
)))
;Inflo2CreateGraphs tgtType constant
(assert (forall ((c Containment)) (=>
	(edge Inflo2CreateGraphs c)
	(= (tgtType c) TASK)
)))
;Inflo2CreateGraphs endpoints
(assert (forall ((c Containment)) (=>
	(edge Inflo2CreateGraphs c)
	(and
		(node Inflo (src c))
		(node CreateGraphs ((as tgt (Task)) c))
	)
)))
;Inflo2CreateGraphs Exists
(assert	(exists ((c Containment)) (edge Inflo2CreateGraphs c)))
;Inflo2CreateGraphs is Unique
(assert	(forall ((c1 Containment) (c2 Containment)) (=>
	(and (edge Inflo2CreateGraphs c1) (edge Inflo2CreateGraphs c2))
	(= c1 c2)
)))
;Inflo2CreateGraphs is Distinct
(assert	(forall ((c Containment)) (=>
	(edge Inflo2CreateGraphs c)
	(not (or
		(edge InfloUser2Browsing c)
		(edge InfloUser2CreateGraph c)
		(edge InfloUser2UseDiscussions c)
		(edge InfloUser2MakeViews c)
		(edge InfloUser2AddSourceInDescription c)
		(edge InfloUser2CreateDiscussions c)
		(edge InfloManagerEditors2ExtensiveModeration c)
		(edge InfloManagerEditors2UseAutomatedReputationSystem c)
		(edge InfloManagerEditors2LessExtensiveModeration c)
		(edge AutomatedReputationSystem2ProvideReputations c)
		(edge AutomatedReputationSystem2ModerationARS c)
		(edge Inflo2TrackAuthorship c)
		(edge Inflo2DisplayGraphs c)
		(edge Inflo2TrackRevisions c)
		(edge Inflo2BeInflo c)
		(edge Inflo2ModerationTasks c)
	))
)))
;Inflo2BeInflo tgtType constant
(assert (forall ((c Containment)) (=>
	(edge Inflo2BeInflo c)
	(= (tgtType c) TASK)
)))
;Inflo2BeInflo endpoints
(assert (forall ((c Containment)) (=>
	(edge Inflo2BeInflo c)
	(and
		(node Inflo (src c))
		(node BeInflo ((as tgt (Task)) c))
	)
)))
;Inflo2BeInflo Exists
(assert	(exists ((c Containment)) (edge Inflo2BeInflo c)))
;Inflo2BeInflo is Unique
(assert	(forall ((c1 Containment) (c2 Containment)) (=>
	(and (edge Inflo2BeInflo c1) (edge Inflo2BeInflo c2))
	(= c1 c2)
)))
;Inflo2BeInflo is Distinct
(assert	(forall ((c Containment)) (=>
	(edge Inflo2BeInflo c)
	(not (or
		(edge InfloUser2Browsing c)
		(edge InfloUser2CreateGraph c)
		(edge InfloUser2UseDiscussions c)
		(edge InfloUser2MakeViews c)
		(edge InfloUser2AddSourceInDescription c)
		(edge InfloUser2CreateDiscussions c)
		(edge InfloManagerEditors2ExtensiveModeration c)
		(edge InfloManagerEditors2UseAutomatedReputationSystem c)
		(edge InfloManagerEditors2LessExtensiveModeration c)
		(edge AutomatedReputationSystem2ProvideReputations c)
		(edge AutomatedReputationSystem2ModerationARS c)
		(edge Inflo2TrackAuthorship c)
		(edge Inflo2DisplayGraphs c)
		(edge Inflo2TrackRevisions c)
		(edge Inflo2CreateGraphs c)
		(edge Inflo2ModerationTasks c)
	))
)))
;Inflo2ModerationTasks tgtType constant
(assert (forall ((c Containment)) (=>
	(edge Inflo2ModerationTasks c)
	(= (tgtType c) TASK)
)))
;Inflo2ModerationTasks endpoints
(assert (forall ((c Containment)) (=>
	(edge Inflo2ModerationTasks c)
	(and
		(node Inflo (src c))
		(node ModerationTasks ((as tgt (Task)) c))
	)
)))
;Inflo2ModerationTasks is Distinct
(assert	(forall ((c Containment)) (=>
	(edge Inflo2ModerationTasks c)
	(not (or
		(edge InfloUser2Browsing c)
		(edge InfloUser2CreateGraph c)
		(edge InfloUser2UseDiscussions c)
		(edge InfloUser2MakeViews c)
		(edge InfloUser2AddSourceInDescription c)
		(edge InfloUser2CreateDiscussions c)
		(edge InfloManagerEditors2ExtensiveModeration c)
		(edge InfloManagerEditors2UseAutomatedReputationSystem c)
		(edge InfloManagerEditors2LessExtensiveModeration c)
		(edge AutomatedReputationSystem2ProvideReputations c)
		(edge AutomatedReputationSystem2ModerationARS c)
		(edge Inflo2TrackAuthorship c)
		(edge Inflo2DisplayGraphs c)
		(edge Inflo2TrackRevisions c)
		(edge Inflo2CreateGraphs c)
		(edge Inflo2BeInflo c)
	))
)))
;ValidateModel2MakeModelsTrustworthy Exists
(assert	(exists ((c Contribution)) (edge ValidateModel2MakeModelsTrustworthy c)))
;ValidateModel2MakeModelsTrustworthy is Unique
(assert	(forall ((c1 Contribution) (c2 Contribution)) (=>
	(and (edge ValidateModel2MakeModelsTrustworthy c1) (edge ValidateModel2MakeModelsTrustworthy c2))
	(= c1 c2)
)))
;ValidateModel2MakeModelsTrustworthy is Distinct
(assert	(forall ((c Contribution)) (=>
	(edge ValidateModel2MakeModelsTrustworthy c)
	(not (or
		(edge UseDiscussions2ValidateModel c)
		(edge UseDiscussions2GetFeedback c)
		(edge InfloBeModerated2GetFeedback c)
		(edge ExtensiveModeration2IntegrityOfModelsIME c)
		(edge ExtensiveModeration2MinimizeModeratorEffort c)
		(edge UseAutomatedReputationSystem2MinimizeModeratorEffort c)
		(edge LessExtensiveModeration2MinimizeModeratorEffort c)
	))
)))

;ValidateModel2MakeModelsTrustworthy endpoints
(assert (forall ((c Contribution)) (=>
	(edge ValidateModel2MakeModelsTrustworthy c)
	(and
		(node ValidateModel ((as src (SoftGoal)) c))
		(node MakeModelsTrustworthy (tgt c))
	)
)))
;ValidateModel2MakeModelsTrustworthy srcType constant
(assert (forall ((c Contribution)) (=>
	(edge ValidateModel2MakeModelsTrustworthy c)
	(= (srcType c) SOFTGOAL)
)))

;ValidateModel2MakeModelsTrustworthy type constant
(assert (forall ((c Contribution)) (=>
	(edge ValidateModel2MakeModelsTrustworthy c)
	(= (type c) HELP)
)))
;GetFeedback2MakeModelsTrustworthy Exists
(assert	(exists ((c Contribution)) (edge GetFeedback2MakeModelsTrustworthy c)))
;GetFeedback2MakeModelsTrustworthy is Unique
(assert	(forall ((c1 Contribution) (c2 Contribution)) (=>
	(and (edge GetFeedback2MakeModelsTrustworthy c1) (edge GetFeedback2MakeModelsTrustworthy c2))
	(= c1 c2)
)))
;GetFeedback2MakeModelsTrustworthy is Distinct
(assert	(forall ((c Contribution)) (=>
	(edge GetFeedback2MakeModelsTrustworthy c)
	(not (or
		(edge UseDiscussions2ValidateModel c)
		(edge UseDiscussions2GetFeedback c)
		(edge InfloBeModerated2GetFeedback c)
		(edge ExtensiveModeration2IntegrityOfModelsIME c)
		(edge ExtensiveModeration2MinimizeModeratorEffort c)
		(edge UseAutomatedReputationSystem2MinimizeModeratorEffort c)
		(edge LessExtensiveModeration2MinimizeModeratorEffort c)
	))
)))

;GetFeedback2MakeModelsTrustworthy endpoints
(assert (forall ((c Contribution)) (=>
	(edge GetFeedback2MakeModelsTrustworthy c)
	(and
		(node GetFeedback ((as src (SoftGoal)) c))
		(node MakeModelsTrustworthy (tgt c))
	)
)))
;GetFeedback2MakeModelsTrustworthy srcType constant
(assert (forall ((c Contribution)) (=>
	(edge GetFeedback2MakeModelsTrustworthy c)
	(= (srcType c) SOFTGOAL)
)))

;GetFeedback2MakeModelsTrustworthy type constant
(assert (forall ((c Contribution)) (=>
	(edge GetFeedback2MakeModelsTrustworthy c)
	(= (type c) HELP)
)))
;Browsing2UseInflo Exists
(assert	(exists ((c MeansEnd)) (edge Browsing2UseInflo c)))
;Browsing2UseInflo is Unique
(assert	(forall ((c1 MeansEnd) (c2 MeansEnd)) (=>
	(and (edge Browsing2UseInflo c1) (edge Browsing2UseInflo c2))
	(= c1 c2)
)))
;Browsing2UseInflo is Distinct
(assert	(forall ((c MeansEnd)) (=>
	(edge Browsing2UseInflo c)
	(not (or
		(edge CreateGraph2UseInflo c)
		(edge UseDiscussions2UseInflo c)
		(edge ExtensiveModeration2ModerateInflo c)
		(edge UseAutomatedReputationSystem2ModerateInflo c)
		(edge LessExtensiveModeration2ModerateInflo c)
		(edge ModerationTasks2AllowModeration c)
	))
)))

;Browsing2UseInflo endpoints
(assert (forall ((c MeansEnd)) (=>
	(edge Browsing2UseInflo c)
	(and
		(node Browsing (src c))
		(node UseInflo (tgt c))
	)
)))

;CreateGraph2UseInflo Exists
(assert	(exists ((c MeansEnd)) (edge CreateGraph2UseInflo c)))
;CreateGraph2UseInflo is Unique
(assert	(forall ((c1 MeansEnd) (c2 MeansEnd)) (=>
	(and (edge CreateGraph2UseInflo c1) (edge CreateGraph2UseInflo c2))
	(= c1 c2)
)))
;CreateGraph2UseInflo is Distinct
(assert	(forall ((c MeansEnd)) (=>
	(edge CreateGraph2UseInflo c)
	(not (or
		(edge Browsing2UseInflo c)
		(edge UseDiscussions2UseInflo c)
		(edge ExtensiveModeration2ModerateInflo c)
		(edge UseAutomatedReputationSystem2ModerateInflo c)
		(edge LessExtensiveModeration2ModerateInflo c)
		(edge ModerationTasks2AllowModeration c)
	))
)))

;CreateGraph2UseInflo endpoints
(assert (forall ((c MeansEnd)) (=>
	(edge CreateGraph2UseInflo c)
	(and
		(node CreateGraph (src c))
		(node UseInflo (tgt c))
	)
)))

;UseDiscussions2UseInflo Exists
(assert	(exists ((c MeansEnd)) (edge UseDiscussions2UseInflo c)))
;UseDiscussions2UseInflo is Unique
(assert	(forall ((c1 MeansEnd) (c2 MeansEnd)) (=>
	(and (edge UseDiscussions2UseInflo c1) (edge UseDiscussions2UseInflo c2))
	(= c1 c2)
)))
;UseDiscussions2UseInflo is Distinct
(assert	(forall ((c MeansEnd)) (=>
	(edge UseDiscussions2UseInflo c)
	(not (or
		(edge Browsing2UseInflo c)
		(edge CreateGraph2UseInflo c)
		(edge ExtensiveModeration2ModerateInflo c)
		(edge UseAutomatedReputationSystem2ModerateInflo c)
		(edge LessExtensiveModeration2ModerateInflo c)
		(edge ModerationTasks2AllowModeration c)
	))
)))

;UseDiscussions2UseInflo endpoints
(assert (forall ((c MeansEnd)) (=>
	(edge UseDiscussions2UseInflo c)
	(and
		(node UseDiscussions (src c))
		(node UseInflo (tgt c))
	)
)))

;UseDiscussions2ValidateModel Exists
(assert	(exists ((c Contribution)) (edge UseDiscussions2ValidateModel c)))
;UseDiscussions2ValidateModel is Unique
(assert	(forall ((c1 Contribution) (c2 Contribution)) (=>
	(and (edge UseDiscussions2ValidateModel c1) (edge UseDiscussions2ValidateModel c2))
	(= c1 c2)
)))
;UseDiscussions2ValidateModel is Distinct
(assert	(forall ((c Contribution)) (=>
	(edge UseDiscussions2ValidateModel c)
	(not (or
		(edge ValidateModel2MakeModelsTrustworthy c)
		(edge GetFeedback2MakeModelsTrustworthy c)
		(edge UseDiscussions2GetFeedback c)
		(edge InfloBeModerated2GetFeedback c)
		(edge IntegrityOfModelsIU2MakeModelsTrustworthy c)
		(edge ExtensiveModeration2IntegrityOfModelsIME c)
		(edge ExtensiveModeration2MinimizeModeratorEffort c)
		(edge UseAutomatedReputationSystem2MinimizeModeratorEffort c)
		(edge LessExtensiveModeration2MinimizeModeratorEffort c)
	))
)))

;UseDiscussions2ValidateModel endpoints
(assert (forall ((c Contribution)) (=>
	(edge UseDiscussions2ValidateModel c)
	(and
		(node UseDiscussions ((as src (Task)) c))
		(node ValidateModel (tgt c))
	)
)))
;UseDiscussions2ValidateModel srcType constant
(assert (forall ((c Contribution)) (=>
	(edge UseDiscussions2ValidateModel c)
	(= (srcType c) TASK)
)))

;UseDiscussions2ValidateModel type constant
(assert (forall ((c Contribution)) (=>
	(edge UseDiscussions2ValidateModel c)
	(= (type c) SOMEPLUS)
)))
;UseDiscussions2GetFeedback is Unique
(assert	(forall ((c1 Contribution) (c2 Contribution)) (=>
	(and (edge UseDiscussions2GetFeedback c1) (edge UseDiscussions2GetFeedback c2))
	(= c1 c2)
)))
;UseDiscussions2GetFeedback is Distinct
(assert	(forall ((c Contribution)) (=>
	(edge UseDiscussions2GetFeedback c)
	(not (or
		(edge ValidateModel2MakeModelsTrustworthy c)
		(edge GetFeedback2MakeModelsTrustworthy c)
		(edge UseDiscussions2ValidateModel c)
		(edge InfloBeModerated2GetFeedback c)
		(edge IntegrityOfModelsIU2MakeModelsTrustworthy c)
		(edge ExtensiveModeration2IntegrityOfModelsIME c)
		(edge ExtensiveModeration2MinimizeModeratorEffort c)
		(edge UseAutomatedReputationSystem2MinimizeModeratorEffort c)
		(edge LessExtensiveModeration2MinimizeModeratorEffort c)
	))
)))

;UseDiscussions2GetFeedback endpoints
(assert (forall ((c Contribution)) (=>
	(edge UseDiscussions2GetFeedback c)
	(and
		(node UseDiscussions ((as src (Task)) c))
		(node GetFeedback (tgt c))
	)
)))
;UseDiscussions2GetFeedback srcType constant
(assert (forall ((c Contribution)) (=>
	(edge UseDiscussions2GetFeedback c)
	(= (srcType c) TASK)
)))

;UseDiscussions2GetFeedback type constant
(assert (forall ((c Contribution)) (=>
	(edge UseDiscussions2GetFeedback c)
	(= (type c) HELP)
)))
;InfloBeModerated2GetFeedback Exists
(assert	(exists ((c Contribution)) (edge InfloBeModerated2GetFeedback c)))
;InfloBeModerated2GetFeedback is Unique
(assert	(forall ((c1 Contribution) (c2 Contribution)) (=>
	(and (edge InfloBeModerated2GetFeedback c1) (edge InfloBeModerated2GetFeedback c2))
	(= c1 c2)
)))
;InfloBeModerated2GetFeedback is Distinct
(assert	(forall ((c Contribution)) (=>
	(edge InfloBeModerated2GetFeedback c)
	(not (or
		(edge ValidateModel2MakeModelsTrustworthy c)
		(edge GetFeedback2MakeModelsTrustworthy c)
		(edge UseDiscussions2ValidateModel c)
		(edge UseDiscussions2GetFeedback c)
		(edge IntegrityOfModelsIU2MakeModelsTrustworthy c)
		(edge ExtensiveModeration2IntegrityOfModelsIME c)
		(edge ExtensiveModeration2MinimizeModeratorEffort c)
		(edge UseAutomatedReputationSystem2MinimizeModeratorEffort c)
		(edge LessExtensiveModeration2MinimizeModeratorEffort c)
	))
)))

;InfloBeModerated2GetFeedback endpoints
(assert (forall ((c Contribution)) (=>
	(edge InfloBeModerated2GetFeedback c)
	(and
		(node InfloBeModerated ((as src (Goal)) c))
		(node GetFeedback (tgt c))
	)
)))
;InfloBeModerated2GetFeedback srcType constant
(assert (forall ((c Contribution)) (=>
	(edge InfloBeModerated2GetFeedback c)
	(= (srcType c) GOAL)
)))

;InfloBeModerated2GetFeedback type constant
(assert (forall ((c Contribution)) (=>
	(edge InfloBeModerated2GetFeedback c)
	(= (type c) HURT)
)))
;MakeViews2Browsing Exists
(assert	(exists ((c Decomposition)) (edge MakeViews2Browsing c)))
;MakeViews2Browsing is Unique
(assert	(forall ((c1 Decomposition) (c2 Decomposition)) (=>
	(and (edge MakeViews2Browsing c1) (edge MakeViews2Browsing c2))
	(= c1 c2)
)))
;MakeViews2Browsing is Distinct
(assert	(forall ((c Decomposition)) (=>
	(edge MakeViews2Browsing c)
	(not (or
		(edge AddSourceInDescription2CreateGraph c)
		(edge UseAutomatedReputationSystem2ExtensiveModeration c)
		(edge UseAutomatedReputationSystem2LessExtensiveModeration c)
		(edge TrackAuthorship2BeInflo c)
		(edge DisplayGraphs2BeInflo c)
		(edge TrackRevisions2BeInflo c)
		(edge CreateGraphs2BeInflo c)
	))
)))

;MakeViews2Browsing endpoints
(assert (forall ((c Decomposition)) (=>
	(edge MakeViews2Browsing c)
	(and
		(node MakeViews ((as src (Task)) c))
		(node Browsing (tgt c))
	)
)))
;MakeViews2Browsing srcType constant
(assert (forall ((c Decomposition)) (=>
	(edge MakeViews2Browsing c)
	(= (srcType c) TASK)
)))

;AddSourceInDescription2CreateGraph Exists
(assert	(exists ((c Decomposition)) (edge AddSourceInDescription2CreateGraph c)))
;AddSourceInDescription2CreateGraph is Unique
(assert	(forall ((c1 Decomposition) (c2 Decomposition)) (=>
	(and (edge AddSourceInDescription2CreateGraph c1) (edge AddSourceInDescription2CreateGraph c2))
	(= c1 c2)
)))
;AddSourceInDescription2CreateGraph is Distinct
(assert	(forall ((c Decomposition)) (=>
	(edge AddSourceInDescription2CreateGraph c)
	(not (or
		(edge MakeViews2Browsing c)
		(edge UseAutomatedReputationSystem2ExtensiveModeration c)
		(edge UseAutomatedReputationSystem2LessExtensiveModeration c)
		(edge TrackAuthorship2BeInflo c)
		(edge DisplayGraphs2BeInflo c)
		(edge TrackRevisions2BeInflo c)
		(edge CreateGraphs2BeInflo c)
	))
)))

;AddSourceInDescription2CreateGraph endpoints
(assert (forall ((c Decomposition)) (=>
	(edge AddSourceInDescription2CreateGraph c)
	(and
		(node AddSourceInDescription ((as src (Task)) c))
		(node CreateGraph (tgt c))
	)
)))
;AddSourceInDescription2CreateGraph srcType constant
(assert (forall ((c Decomposition)) (=>
	(edge AddSourceInDescription2CreateGraph c)
	(= (srcType c) TASK)
)))

;CreateDiscussions2UseDiscussions is Unique
(assert	(forall ((c1 Decomposition) (c2 Decomposition)) (=>
	(and (edge CreateDiscussions2UseDiscussions c1) (edge CreateDiscussions2UseDiscussions c2))
	(= c1 c2)
)))
;CreateDiscussions2UseDiscussions is Distinct
(assert	(forall ((c Decomposition)) (=>
	(edge CreateDiscussions2UseDiscussions c)
	(not (or
		(edge UseAutomatedReputationSystem2ExtensiveModeration c)
		(edge UseAutomatedReputationSystem2LessExtensiveModeration c)
		(edge TrackAuthorship2BeInflo c)
		(edge DisplayGraphs2BeInflo c)
		(edge TrackRevisions2BeInflo c)
		(edge CreateGraphs2BeInflo c)
	))
)))

;CreateDiscussions2UseDiscussions endpoints
(assert (forall ((c Decomposition)) (=>
	(edge CreateDiscussions2UseDiscussions c)
	(and
		(node CreateDiscussions ((as src (Task)) c))
		(node UseDiscussions (tgt c))
	)
)))
;CreateDiscussions2UseDiscussions srcType constant
(assert (forall ((c Decomposition)) (=>
	(edge CreateDiscussions2UseDiscussions c)
	(= (srcType c) TASK)
)))

;IntegrityOfModelsIU2MakeModelsTrustworthy Exists
(assert	(exists ((c Contribution)) (edge IntegrityOfModelsIU2MakeModelsTrustworthy c)))
;IntegrityOfModelsIU2MakeModelsTrustworthy is Unique
(assert	(forall ((c1 Contribution) (c2 Contribution)) (=>
	(and (edge IntegrityOfModelsIU2MakeModelsTrustworthy c1) (edge IntegrityOfModelsIU2MakeModelsTrustworthy c2))
	(= c1 c2)
)))
;IntegrityOfModelsIU2MakeModelsTrustworthy is Distinct
(assert	(forall ((c Contribution)) (=>
	(edge IntegrityOfModelsIU2MakeModelsTrustworthy c)
	(not (or
		(edge UseDiscussions2ValidateModel c)
		(edge UseDiscussions2GetFeedback c)
		(edge InfloBeModerated2GetFeedback c)
		(edge ExtensiveModeration2IntegrityOfModelsIME c)
		(edge ExtensiveModeration2MinimizeModeratorEffort c)
		(edge UseAutomatedReputationSystem2MinimizeModeratorEffort c)
		(edge LessExtensiveModeration2MinimizeModeratorEffort c)
	))
)))

;IntegrityOfModelsIU2MakeModelsTrustworthy endpoints
(assert (forall ((c Contribution)) (=>
	(edge IntegrityOfModelsIU2MakeModelsTrustworthy c)
	(and
		(node IntegrityOfModelsIU ((as src (SoftGoal)) c))
		(node MakeModelsTrustworthy (tgt c))
	)
)))
;IntegrityOfModelsIU2MakeModelsTrustworthy srcType constant
(assert (forall ((c Contribution)) (=>
	(edge IntegrityOfModelsIU2MakeModelsTrustworthy c)
	(= (srcType c) SOFTGOAL)
)))

;IntegrityOfModelsIU2MakeModelsTrustworthy type constant
(assert (forall ((c Contribution)) (=>
	(edge IntegrityOfModelsIU2MakeModelsTrustworthy c)
	(= (type c) HELP)
)))
;ExtensiveModeration2ModerateInflo is Unique
(assert	(forall ((c1 MeansEnd) (c2 MeansEnd)) (=>
	(and (edge ExtensiveModeration2ModerateInflo c1) (edge ExtensiveModeration2ModerateInflo c2))
	(= c1 c2)
)))
;ExtensiveModeration2ModerateInflo is Distinct
(assert	(forall ((c MeansEnd)) (=>
	(edge ExtensiveModeration2ModerateInflo c)
	(not (or
		(edge Browsing2UseInflo c)
		(edge CreateGraph2UseInflo c)
		(edge UseDiscussions2UseInflo c)
		(edge UseAutomatedReputationSystem2ModerateInflo c)
		(edge ModerationTasks2AllowModeration c)
	))
)))

;ExtensiveModeration2ModerateInflo endpoints
(assert (forall ((c MeansEnd)) (=>
	(edge ExtensiveModeration2ModerateInflo c)
	(and
		(node ExtensiveModeration (src c))
		(node ModerateInflo (tgt c))
	)
)))

;ExtensiveModeration2IntegrityOfModelsIME Exists
(assert	(exists ((c Contribution)) (edge ExtensiveModeration2IntegrityOfModelsIME c)))
;ExtensiveModeration2IntegrityOfModelsIME is Unique
(assert	(forall ((c1 Contribution) (c2 Contribution)) (=>
	(and (edge ExtensiveModeration2IntegrityOfModelsIME c1) (edge ExtensiveModeration2IntegrityOfModelsIME c2))
	(= c1 c2)
)))
;ExtensiveModeration2IntegrityOfModelsIME is Distinct
(assert	(forall ((c Contribution)) (=>
	(edge ExtensiveModeration2IntegrityOfModelsIME c)
	(not (or
		(edge ValidateModel2MakeModelsTrustworthy c)
		(edge GetFeedback2MakeModelsTrustworthy c)
		(edge UseDiscussions2ValidateModel c)
		(edge UseDiscussions2GetFeedback c)
		(edge InfloBeModerated2GetFeedback c)
		(edge IntegrityOfModelsIU2MakeModelsTrustworthy c)
		(edge ExtensiveModeration2MinimizeModeratorEffort c)
		(edge UseAutomatedReputationSystem2MinimizeModeratorEffort c)
		(edge LessExtensiveModeration2MinimizeModeratorEffort c)
	))
)))

;ExtensiveModeration2IntegrityOfModelsIME endpoints
(assert (forall ((c Contribution)) (=>
	(edge ExtensiveModeration2IntegrityOfModelsIME c)
	(and
		(node ExtensiveModeration ((as src (Task)) c))
		(node IntegrityOfModelsIME (tgt c))
	)
)))
;ExtensiveModeration2IntegrityOfModelsIME srcType constant
(assert (forall ((c Contribution)) (=>
	(edge ExtensiveModeration2IntegrityOfModelsIME c)
	(= (srcType c) TASK)
)))

;ExtensiveModeration2IntegrityOfModelsIME type constant
(assert (forall ((c Contribution)) (=>
	(edge ExtensiveModeration2IntegrityOfModelsIME c)
	(= (type c) HELP)
)))
;ExtensiveModeration2MinimizeModeratorEffort Exists
(assert	(exists ((c Contribution)) (edge ExtensiveModeration2MinimizeModeratorEffort c)))
;ExtensiveModeration2MinimizeModeratorEffort is Unique
(assert	(forall ((c1 Contribution) (c2 Contribution)) (=>
	(and (edge ExtensiveModeration2MinimizeModeratorEffort c1) (edge ExtensiveModeration2MinimizeModeratorEffort c2))
	(= c1 c2)
)))
;ExtensiveModeration2MinimizeModeratorEffort is Distinct
(assert	(forall ((c Contribution)) (=>
	(edge ExtensiveModeration2MinimizeModeratorEffort c)
	(not (or
		(edge ValidateModel2MakeModelsTrustworthy c)
		(edge GetFeedback2MakeModelsTrustworthy c)
		(edge UseDiscussions2ValidateModel c)
		(edge UseDiscussions2GetFeedback c)
		(edge InfloBeModerated2GetFeedback c)
		(edge IntegrityOfModelsIU2MakeModelsTrustworthy c)
		(edge ExtensiveModeration2IntegrityOfModelsIME c)
		(edge UseAutomatedReputationSystem2MinimizeModeratorEffort c)
		(edge LessExtensiveModeration2MinimizeModeratorEffort c)
	))
)))

;ExtensiveModeration2MinimizeModeratorEffort endpoints
(assert (forall ((c Contribution)) (=>
	(edge ExtensiveModeration2MinimizeModeratorEffort c)
	(and
		(node ExtensiveModeration ((as src (Task)) c))
		(node MinimizeModeratorEffort (tgt c))
	)
)))
;ExtensiveModeration2MinimizeModeratorEffort srcType constant
(assert (forall ((c Contribution)) (=>
	(edge ExtensiveModeration2MinimizeModeratorEffort c)
	(= (srcType c) TASK)
)))

;ExtensiveModeration2MinimizeModeratorEffort type constant
(assert (forall ((c Contribution)) (=>
	(edge ExtensiveModeration2MinimizeModeratorEffort c)
	(= (type c) HURT)
)))
;UseAutomatedReputationSystem2ExtensiveModeration is Unique
(assert	(forall ((c1 Decomposition) (c2 Decomposition)) (=>
	(and (edge UseAutomatedReputationSystem2ExtensiveModeration c1) (edge UseAutomatedReputationSystem2ExtensiveModeration c2))
	(= c1 c2)
)))
;UseAutomatedReputationSystem2ExtensiveModeration is Distinct
(assert	(forall ((c Decomposition)) (=>
	(edge UseAutomatedReputationSystem2ExtensiveModeration c)
	(not (or
		(edge MakeViews2Browsing c)
		(edge AddSourceInDescription2CreateGraph c)
		(edge CreateDiscussions2UseDiscussions c)
		(edge UseAutomatedReputationSystem2LessExtensiveModeration c)
		(edge TrackAuthorship2BeInflo c)
		(edge DisplayGraphs2BeInflo c)
		(edge TrackRevisions2BeInflo c)
		(edge CreateGraphs2BeInflo c)
	))
)))

;UseAutomatedReputationSystem2ExtensiveModeration endpoints
(assert (forall ((c Decomposition)) (=>
	(edge UseAutomatedReputationSystem2ExtensiveModeration c)
	(and
		(node UseAutomatedReputationSystem ((as src (Task)) c))
		(node ExtensiveModeration (tgt c))
	)
)))
;UseAutomatedReputationSystem2ExtensiveModeration srcType constant
(assert (forall ((c Decomposition)) (=>
	(edge UseAutomatedReputationSystem2ExtensiveModeration c)
	(= (srcType c) TASK)
)))

;UseAutomatedReputationSystem2ModerateInflo is Unique
(assert	(forall ((c1 MeansEnd) (c2 MeansEnd)) (=>
	(and (edge UseAutomatedReputationSystem2ModerateInflo c1) (edge UseAutomatedReputationSystem2ModerateInflo c2))
	(= c1 c2)
)))
;UseAutomatedReputationSystem2ModerateInflo is Distinct
(assert	(forall ((c MeansEnd)) (=>
	(edge UseAutomatedReputationSystem2ModerateInflo c)
	(not (or
		(edge Browsing2UseInflo c)
		(edge CreateGraph2UseInflo c)
		(edge UseDiscussions2UseInflo c)
		(edge ExtensiveModeration2ModerateInflo c)
		(edge ModerationTasks2AllowModeration c)
	))
)))

;UseAutomatedReputationSystem2ModerateInflo endpoints
(assert (forall ((c MeansEnd)) (=>
	(edge UseAutomatedReputationSystem2ModerateInflo c)
	(and
		(node UseAutomatedReputationSystem (src c))
		(node ModerateInflo (tgt c))
	)
)))

;UseAutomatedReputationSystem2LessExtensiveModeration is Unique
(assert	(forall ((c1 Decomposition) (c2 Decomposition)) (=>
	(and (edge UseAutomatedReputationSystem2LessExtensiveModeration c1) (edge UseAutomatedReputationSystem2LessExtensiveModeration c2))
	(= c1 c2)
)))
;UseAutomatedReputationSystem2LessExtensiveModeration is Distinct
(assert	(forall ((c Decomposition)) (=>
	(edge UseAutomatedReputationSystem2LessExtensiveModeration c)
	(not (or
		(edge MakeViews2Browsing c)
		(edge AddSourceInDescription2CreateGraph c)
		(edge CreateDiscussions2UseDiscussions c)
		(edge UseAutomatedReputationSystem2ExtensiveModeration c)
		(edge TrackAuthorship2BeInflo c)
		(edge DisplayGraphs2BeInflo c)
		(edge TrackRevisions2BeInflo c)
		(edge CreateGraphs2BeInflo c)
	))
)))

;UseAutomatedReputationSystem2LessExtensiveModeration endpoints
(assert (forall ((c Decomposition)) (=>
	(edge UseAutomatedReputationSystem2LessExtensiveModeration c)
	(and
		(node UseAutomatedReputationSystem ((as src (Task)) c))
		(node LessExtensiveModeration (tgt c))
	)
)))
;UseAutomatedReputationSystem2LessExtensiveModeration srcType constant
(assert (forall ((c Decomposition)) (=>
	(edge UseAutomatedReputationSystem2LessExtensiveModeration c)
	(= (srcType c) TASK)
)))

;UseAutomatedReputationSystem2MinimizeModeratorEffort Exists
(assert	(exists ((c Contribution)) (edge UseAutomatedReputationSystem2MinimizeModeratorEffort c)))
;UseAutomatedReputationSystem2MinimizeModeratorEffort is Unique
(assert	(forall ((c1 Contribution) (c2 Contribution)) (=>
	(and (edge UseAutomatedReputationSystem2MinimizeModeratorEffort c1) (edge UseAutomatedReputationSystem2MinimizeModeratorEffort c2))
	(= c1 c2)
)))
;UseAutomatedReputationSystem2MinimizeModeratorEffort is Distinct
(assert	(forall ((c Contribution)) (=>
	(edge UseAutomatedReputationSystem2MinimizeModeratorEffort c)
	(not (or
		(edge ValidateModel2MakeModelsTrustworthy c)
		(edge GetFeedback2MakeModelsTrustworthy c)
		(edge UseDiscussions2ValidateModel c)
		(edge UseDiscussions2GetFeedback c)
		(edge InfloBeModerated2GetFeedback c)
		(edge IntegrityOfModelsIU2MakeModelsTrustworthy c)
		(edge ExtensiveModeration2IntegrityOfModelsIME c)
		(edge ExtensiveModeration2MinimizeModeratorEffort c)
		(edge LessExtensiveModeration2MinimizeModeratorEffort c)
	))
)))

;UseAutomatedReputationSystem2MinimizeModeratorEffort endpoints
(assert (forall ((c Contribution)) (=>
	(edge UseAutomatedReputationSystem2MinimizeModeratorEffort c)
	(and
		(node UseAutomatedReputationSystem ((as src (Task)) c))
		(node MinimizeModeratorEffort (tgt c))
	)
)))
;UseAutomatedReputationSystem2MinimizeModeratorEffort srcType constant
(assert (forall ((c Contribution)) (=>
	(edge UseAutomatedReputationSystem2MinimizeModeratorEffort c)
	(= (srcType c) TASK)
)))

;UseAutomatedReputationSystem2MinimizeModeratorEffort type constant
(assert (forall ((c Contribution)) (=>
	(edge UseAutomatedReputationSystem2MinimizeModeratorEffort c)
	(= (type c) HELP)
)))
;LessExtensiveModeration2ModerateInflo is Unique
(assert	(forall ((c1 MeansEnd) (c2 MeansEnd)) (=>
	(and (edge LessExtensiveModeration2ModerateInflo c1) (edge LessExtensiveModeration2ModerateInflo c2))
	(= c1 c2)
)))
;LessExtensiveModeration2ModerateInflo is Distinct
(assert	(forall ((c MeansEnd)) (=>
	(edge LessExtensiveModeration2ModerateInflo c)
	(not (or
		(edge Browsing2UseInflo c)
		(edge CreateGraph2UseInflo c)
		(edge UseDiscussions2UseInflo c)
		(edge ModerationTasks2AllowModeration c)
	))
)))

;LessExtensiveModeration2ModerateInflo endpoints
(assert (forall ((c MeansEnd)) (=>
	(edge LessExtensiveModeration2ModerateInflo c)
	(and
		(node LessExtensiveModeration (src c))
		(node ModerateInflo (tgt c))
	)
)))

;LessExtensiveModeration2MinimizeModeratorEffort is Unique
(assert	(forall ((c1 Contribution) (c2 Contribution)) (=>
	(and (edge LessExtensiveModeration2MinimizeModeratorEffort c1) (edge LessExtensiveModeration2MinimizeModeratorEffort c2))
	(= c1 c2)
)))
;LessExtensiveModeration2MinimizeModeratorEffort is Distinct
(assert	(forall ((c Contribution)) (=>
	(edge LessExtensiveModeration2MinimizeModeratorEffort c)
	(not (or
		(edge ValidateModel2MakeModelsTrustworthy c)
		(edge GetFeedback2MakeModelsTrustworthy c)
		(edge UseDiscussions2ValidateModel c)
		(edge UseDiscussions2GetFeedback c)
		(edge InfloBeModerated2GetFeedback c)
		(edge IntegrityOfModelsIU2MakeModelsTrustworthy c)
		(edge ExtensiveModeration2IntegrityOfModelsIME c)
		(edge ExtensiveModeration2MinimizeModeratorEffort c)
		(edge UseAutomatedReputationSystem2MinimizeModeratorEffort c)
	))
)))

;LessExtensiveModeration2MinimizeModeratorEffort endpoints
(assert (forall ((c Contribution)) (=>
	(edge LessExtensiveModeration2MinimizeModeratorEffort c)
	(and
		(node LessExtensiveModeration ((as src (Task)) c))
		(node MinimizeModeratorEffort (tgt c))
	)
)))
;LessExtensiveModeration2MinimizeModeratorEffort srcType constant
(assert (forall ((c Contribution)) (=>
	(edge LessExtensiveModeration2MinimizeModeratorEffort c)
	(= (srcType c) TASK)
)))

;LessExtensiveModeration2MinimizeModeratorEffort type constant
(assert (forall ((c Contribution)) (=>
	(edge LessExtensiveModeration2MinimizeModeratorEffort c)
	(= (type c) HELP)
)))
;TrackAuthorship2BeInflo Exists
(assert	(exists ((c Decomposition)) (edge TrackAuthorship2BeInflo c)))
;TrackAuthorship2BeInflo is Unique
(assert	(forall ((c1 Decomposition) (c2 Decomposition)) (=>
	(and (edge TrackAuthorship2BeInflo c1) (edge TrackAuthorship2BeInflo c2))
	(= c1 c2)
)))
;TrackAuthorship2BeInflo is Distinct
(assert	(forall ((c Decomposition)) (=>
	(edge TrackAuthorship2BeInflo c)
	(not (or
		(edge MakeViews2Browsing c)
		(edge AddSourceInDescription2CreateGraph c)
		(edge CreateDiscussions2UseDiscussions c)
		(edge UseAutomatedReputationSystem2ExtensiveModeration c)
		(edge UseAutomatedReputationSystem2LessExtensiveModeration c)
		(edge DisplayGraphs2BeInflo c)
		(edge TrackRevisions2BeInflo c)
		(edge CreateGraphs2BeInflo c)
	))
)))

;TrackAuthorship2BeInflo endpoints
(assert (forall ((c Decomposition)) (=>
	(edge TrackAuthorship2BeInflo c)
	(and
		(node TrackAuthorship ((as src (Task)) c))
		(node BeInflo (tgt c))
	)
)))
;TrackAuthorship2BeInflo srcType constant
(assert (forall ((c Decomposition)) (=>
	(edge TrackAuthorship2BeInflo c)
	(= (srcType c) TASK)
)))

;DisplayGraphs2BeInflo Exists
(assert	(exists ((c Decomposition)) (edge DisplayGraphs2BeInflo c)))
;DisplayGraphs2BeInflo is Unique
(assert	(forall ((c1 Decomposition) (c2 Decomposition)) (=>
	(and (edge DisplayGraphs2BeInflo c1) (edge DisplayGraphs2BeInflo c2))
	(= c1 c2)
)))
;DisplayGraphs2BeInflo is Distinct
(assert	(forall ((c Decomposition)) (=>
	(edge DisplayGraphs2BeInflo c)
	(not (or
		(edge MakeViews2Browsing c)
		(edge AddSourceInDescription2CreateGraph c)
		(edge CreateDiscussions2UseDiscussions c)
		(edge UseAutomatedReputationSystem2ExtensiveModeration c)
		(edge UseAutomatedReputationSystem2LessExtensiveModeration c)
		(edge TrackAuthorship2BeInflo c)
		(edge TrackRevisions2BeInflo c)
		(edge CreateGraphs2BeInflo c)
	))
)))

;DisplayGraphs2BeInflo endpoints
(assert (forall ((c Decomposition)) (=>
	(edge DisplayGraphs2BeInflo c)
	(and
		(node DisplayGraphs ((as src (Task)) c))
		(node BeInflo (tgt c))
	)
)))
;DisplayGraphs2BeInflo srcType constant
(assert (forall ((c Decomposition)) (=>
	(edge DisplayGraphs2BeInflo c)
	(= (srcType c) TASK)
)))

;TrackRevisions2BeInflo Exists
(assert	(exists ((c Decomposition)) (edge TrackRevisions2BeInflo c)))
;TrackRevisions2BeInflo is Unique
(assert	(forall ((c1 Decomposition) (c2 Decomposition)) (=>
	(and (edge TrackRevisions2BeInflo c1) (edge TrackRevisions2BeInflo c2))
	(= c1 c2)
)))
;TrackRevisions2BeInflo is Distinct
(assert	(forall ((c Decomposition)) (=>
	(edge TrackRevisions2BeInflo c)
	(not (or
		(edge MakeViews2Browsing c)
		(edge AddSourceInDescription2CreateGraph c)
		(edge CreateDiscussions2UseDiscussions c)
		(edge UseAutomatedReputationSystem2ExtensiveModeration c)
		(edge UseAutomatedReputationSystem2LessExtensiveModeration c)
		(edge TrackAuthorship2BeInflo c)
		(edge DisplayGraphs2BeInflo c)
		(edge CreateGraphs2BeInflo c)
	))
)))

;TrackRevisions2BeInflo endpoints
(assert (forall ((c Decomposition)) (=>
	(edge TrackRevisions2BeInflo c)
	(and
		(node TrackRevisions ((as src (Task)) c))
		(node BeInflo (tgt c))
	)
)))
;TrackRevisions2BeInflo srcType constant
(assert (forall ((c Decomposition)) (=>
	(edge TrackRevisions2BeInflo c)
	(= (srcType c) TASK)
)))

;CreateGraphs2BeInflo Exists
(assert	(exists ((c Decomposition)) (edge CreateGraphs2BeInflo c)))
;CreateGraphs2BeInflo is Unique
(assert	(forall ((c1 Decomposition) (c2 Decomposition)) (=>
	(and (edge CreateGraphs2BeInflo c1) (edge CreateGraphs2BeInflo c2))
	(= c1 c2)
)))
;CreateGraphs2BeInflo is Distinct
(assert	(forall ((c Decomposition)) (=>
	(edge CreateGraphs2BeInflo c)
	(not (or
		(edge MakeViews2Browsing c)
		(edge AddSourceInDescription2CreateGraph c)
		(edge CreateDiscussions2UseDiscussions c)
		(edge UseAutomatedReputationSystem2ExtensiveModeration c)
		(edge UseAutomatedReputationSystem2LessExtensiveModeration c)
		(edge TrackAuthorship2BeInflo c)
		(edge DisplayGraphs2BeInflo c)
		(edge TrackRevisions2BeInflo c)
	))
)))

;CreateGraphs2BeInflo endpoints
(assert (forall ((c Decomposition)) (=>
	(edge CreateGraphs2BeInflo c)
	(and
		(node CreateGraphs ((as src (Task)) c))
		(node BeInflo (tgt c))
	)
)))
;CreateGraphs2BeInflo srcType constant
(assert (forall ((c Decomposition)) (=>
	(edge CreateGraphs2BeInflo c)
	(= (srcType c) TASK)
)))

;ModerationTasks2AllowModeration is Distinct
(assert	(forall ((c MeansEnd)) (=>
	(edge ModerationTasks2AllowModeration c)
	(not (or
		(edge Browsing2UseInflo c)
		(edge CreateGraph2UseInflo c)
		(edge UseDiscussions2UseInflo c)
		(edge ExtensiveModeration2ModerateInflo c)
		(edge UseAutomatedReputationSystem2ModerateInflo c)
		(edge LessExtensiveModeration2ModerateInflo c)
	))
)))

;ModerationTasks2AllowModeration endpoints
(assert (forall ((c MeansEnd)) (=>
	(edge ModerationTasks2AllowModeration c)
	(and
		(node ModerationTasks (src c))
		(node AllowModeration (tgt c))
	)
)))

;InfloBeModerated2Moderation srcType constant
(assert (forall ((c DependerLink)) (=>
	(edge InfloBeModerated2Moderation c)
	(= (srcType c) GOAL)
)))
;InfloBeModerated2Moderation tgtType constant
(assert (forall ((c DependerLink)) (=>
	(edge InfloBeModerated2Moderation c)
	(= (tgtType c) RESOURCE)
)))
;InfloBeModerated2Moderation endpoints
(assert (forall ((c DependerLink)) (=>
	(edge InfloBeModerated2Moderation c)
	(and
		(node InfloBeModerated ((as src (Goal)) c))
		(node Moderation ((as tgt (Resource)) c))
	)
)))
;InfloBeModerated2Moderation Exists
(assert	(exists ((c DependerLink)) (edge InfloBeModerated2Moderation c)))
;InfloBeModerated2Moderation is Unique
(assert	(forall ((c1 DependerLink) (c2 DependerLink)) (=>
	(and (edge InfloBeModerated2Moderation c1) (edge InfloBeModerated2Moderation c2))
	(= c1 c2)
)))
;InfloBeModerated2Moderation is Distinct
(assert	(forall ((c DependerLink)) (=>
	(edge InfloBeModerated2Moderation c)
	(not (or
		(edge AllowModeration2Moderation c)
		(edge UseInflo2Graphing c)
		(edge UseAutomatedReputationSystem2ReputationValues c)
		(edge AddSourceInDescription2Info c)
		(edge TrackAuthorship2Authorship c)
		(edge IntegrityOfModelsIU2IntegrityOfModels c)
	))
)))
;AllowModeration2Moderation srcType constant
(assert (forall ((c DependerLink)) (=>
	(edge AllowModeration2Moderation c)
	(= (srcType c) GOAL)
)))
;AllowModeration2Moderation tgtType constant
(assert (forall ((c DependerLink)) (=>
	(edge AllowModeration2Moderation c)
	(= (tgtType c) RESOURCE)
)))
;AllowModeration2Moderation endpoints
(assert (forall ((c DependerLink)) (=>
	(edge AllowModeration2Moderation c)
	(and
		(node AllowModeration ((as src (Goal)) c))
		(node Moderation ((as tgt (Resource)) c))
	)
)))
;AllowModeration2Moderation Exists
(assert	(exists ((c DependerLink)) (edge AllowModeration2Moderation c)))
;AllowModeration2Moderation is Unique
(assert	(forall ((c1 DependerLink) (c2 DependerLink)) (=>
	(and (edge AllowModeration2Moderation c1) (edge AllowModeration2Moderation c2))
	(= c1 c2)
)))
;AllowModeration2Moderation is Distinct
(assert	(forall ((c DependerLink)) (=>
	(edge AllowModeration2Moderation c)
	(not (or
		(edge InfloBeModerated2Moderation c)
		(edge UseInflo2Graphing c)
		(edge UseAutomatedReputationSystem2ReputationValues c)
		(edge AddSourceInDescription2Info c)
		(edge TrackAuthorship2Authorship c)
		(edge IntegrityOfModelsIU2IntegrityOfModels c)
	))
)))
;UseInflo2Graphing srcType constant
(assert (forall ((c DependerLink)) (=>
	(edge UseInflo2Graphing c)
	(= (srcType c) GOAL)
)))
;UseInflo2Graphing tgtType constant
(assert (forall ((c DependerLink)) (=>
	(edge UseInflo2Graphing c)
	(= (tgtType c) RESOURCE)
)))
;UseInflo2Graphing endpoints
(assert (forall ((c DependerLink)) (=>
	(edge UseInflo2Graphing c)
	(and
		(node UseInflo ((as src (Goal)) c))
		(node Graphing ((as tgt (Resource)) c))
	)
)))
;UseInflo2Graphing Exists
(assert	(exists ((c DependerLink)) (edge UseInflo2Graphing c)))
;UseInflo2Graphing is Unique
(assert	(forall ((c1 DependerLink) (c2 DependerLink)) (=>
	(and (edge UseInflo2Graphing c1) (edge UseInflo2Graphing c2))
	(= c1 c2)
)))
;UseInflo2Graphing is Distinct
(assert	(forall ((c DependerLink)) (=>
	(edge UseInflo2Graphing c)
	(not (or
		(edge InfloBeModerated2Moderation c)
		(edge AllowModeration2Moderation c)
		(edge UseAutomatedReputationSystem2ReputationValues c)
		(edge AddSourceInDescription2Info c)
		(edge TrackAuthorship2Authorship c)
		(edge IntegrityOfModelsIU2IntegrityOfModels c)
	))
)))
;UseAutomatedReputationSystem2ReputationValues srcType constant
(assert (forall ((c DependerLink)) (=>
	(edge UseAutomatedReputationSystem2ReputationValues c)
	(= (srcType c) TASK)
)))
;UseAutomatedReputationSystem2ReputationValues tgtType constant
(assert (forall ((c DependerLink)) (=>
	(edge UseAutomatedReputationSystem2ReputationValues c)
	(= (tgtType c) RESOURCE)
)))
;UseAutomatedReputationSystem2ReputationValues endpoints
(assert (forall ((c DependerLink)) (=>
	(edge UseAutomatedReputationSystem2ReputationValues c)
	(and
		(node UseAutomatedReputationSystem ((as src (Task)) c))
		(node ReputationValues ((as tgt (Resource)) c))
	)
)))
;UseAutomatedReputationSystem2ReputationValues Exists
(assert	(exists ((c DependerLink)) (edge UseAutomatedReputationSystem2ReputationValues c)))
;UseAutomatedReputationSystem2ReputationValues is Unique
(assert	(forall ((c1 DependerLink) (c2 DependerLink)) (=>
	(and (edge UseAutomatedReputationSystem2ReputationValues c1) (edge UseAutomatedReputationSystem2ReputationValues c2))
	(= c1 c2)
)))
;UseAutomatedReputationSystem2ReputationValues is Distinct
(assert	(forall ((c DependerLink)) (=>
	(edge UseAutomatedReputationSystem2ReputationValues c)
	(not (or
		(edge InfloBeModerated2Moderation c)
		(edge AllowModeration2Moderation c)
		(edge UseInflo2Graphing c)
		(edge AddSourceInDescription2Info c)
		(edge TrackAuthorship2Authorship c)
		(edge IntegrityOfModelsIU2IntegrityOfModels c)
	))
)))
;AddSourceInDescription2Info srcType constant
(assert (forall ((c DependerLink)) (=>
	(edge AddSourceInDescription2Info c)
	(= (srcType c) TASK)
)))
;AddSourceInDescription2Info tgtType constant
(assert (forall ((c DependerLink)) (=>
	(edge AddSourceInDescription2Info c)
	(= (tgtType c) RESOURCE)
)))
;AddSourceInDescription2Info endpoints
(assert (forall ((c DependerLink)) (=>
	(edge AddSourceInDescription2Info c)
	(and
		(node AddSourceInDescription ((as src (Task)) c))
		(node Info ((as tgt (Resource)) c))
	)
)))
;AddSourceInDescription2Info Exists
(assert	(exists ((c DependerLink)) (edge AddSourceInDescription2Info c)))
;AddSourceInDescription2Info is Distinct
(assert	(forall ((c DependerLink)) (=>
	(edge AddSourceInDescription2Info c)
	(not (or
		(edge InfloBeModerated2Moderation c)
		(edge AllowModeration2Moderation c)
		(edge UseInflo2Graphing c)
		(edge UseAutomatedReputationSystem2ReputationValues c)
		(edge TrackAuthorship2Authorship c)
		(edge IntegrityOfModelsIU2IntegrityOfModels c)
	))
)))
;TrackAuthorship2Authorship srcType constant
(assert (forall ((c DependerLink)) (=>
	(edge TrackAuthorship2Authorship c)
	(= (srcType c) TASK)
)))
;TrackAuthorship2Authorship tgtType constant
(assert (forall ((c DependerLink)) (=>
	(edge TrackAuthorship2Authorship c)
	(= (tgtType c) RESOURCE)
)))
;TrackAuthorship2Authorship endpoints
(assert (forall ((c DependerLink)) (=>
	(edge TrackAuthorship2Authorship c)
	(and
		(node TrackAuthorship ((as src (Task)) c))
		(node Authorship ((as tgt (Resource)) c))
	)
)))
;TrackAuthorship2Authorship is Unique
(assert	(forall ((c1 DependerLink) (c2 DependerLink)) (=>
	(and (edge TrackAuthorship2Authorship c1) (edge TrackAuthorship2Authorship c2))
	(= c1 c2)
)))
;TrackAuthorship2Authorship is Distinct
(assert	(forall ((c DependerLink)) (=>
	(edge TrackAuthorship2Authorship c)
	(not (or
		(edge InfloBeModerated2Moderation c)
		(edge AllowModeration2Moderation c)
		(edge UseInflo2Graphing c)
		(edge UseAutomatedReputationSystem2ReputationValues c)
		(edge AddSourceInDescription2Info c)
		(edge IntegrityOfModelsIU2IntegrityOfModels c)
	))
)))
;IntegrityOfModelsIU2IntegrityOfModels srcType constant
(assert (forall ((c DependerLink)) (=>
	(edge IntegrityOfModelsIU2IntegrityOfModels c)
	(= (srcType c) SOFTGOAL)
)))
;IntegrityOfModelsIU2IntegrityOfModels tgtType constant
(assert (forall ((c DependerLink)) (=>
	(edge IntegrityOfModelsIU2IntegrityOfModels c)
	(= (tgtType c) SOFTGOAL)
)))
;IntegrityOfModelsIU2IntegrityOfModels endpoints
(assert (forall ((c DependerLink)) (=>
	(edge IntegrityOfModelsIU2IntegrityOfModels c)
	(and
		(node IntegrityOfModelsIU ((as src (SoftGoal)) c))
		(node IntegrityOfModels ((as tgt (SoftGoal)) c))
	)
)))
;IntegrityOfModelsIU2IntegrityOfModels Exists
(assert	(exists ((c DependerLink)) (edge IntegrityOfModelsIU2IntegrityOfModels c)))
;IntegrityOfModelsIU2IntegrityOfModels is Unique
(assert	(forall ((c1 DependerLink) (c2 DependerLink)) (=>
	(and (edge IntegrityOfModelsIU2IntegrityOfModels c1) (edge IntegrityOfModelsIU2IntegrityOfModels c2))
	(= c1 c2)
)))
;IntegrityOfModelsIU2IntegrityOfModels is Distinct
(assert	(forall ((c DependerLink)) (=>
	(edge IntegrityOfModelsIU2IntegrityOfModels c)
	(not (or
		(edge InfloBeModerated2Moderation c)
		(edge AllowModeration2Moderation c)
		(edge UseInflo2Graphing c)
		(edge UseAutomatedReputationSystem2ReputationValues c)
		(edge AddSourceInDescription2Info c)
		(edge TrackAuthorship2Authorship c)
	))
)))
;Moderation2ModerateInflo srcType constant
(assert (forall ((c DependeeLink)) (=>
	(edge Moderation2ModerateInflo c)
	(= (srcType c) RESOURCE)
)))
;Moderation2ModerateInflo tgtType constant
(assert (forall ((c DependeeLink)) (=>
	(edge Moderation2ModerateInflo c)
	(= (tgtType c) GOAL)
)))
;Moderation2ModerateInflo endpoints
(assert (forall ((c DependeeLink)) (=>
	(edge Moderation2ModerateInflo c)
	(and
		(node Moderation ((as src (Resource)) c))
		(node ModerateInflo ((as tgt (Goal)) c))
	)
)))
;Moderation2ModerateInflo is Unique
(assert	(forall ((c1 DependeeLink) (c2 DependeeLink)) (=>
	(and (edge Moderation2ModerateInflo c1) (edge Moderation2ModerateInflo c2))
	(= c1 c2)
)))
;Moderation2ModerateInflo is Distinct
(assert	(forall ((c DependeeLink)) (=>
	(edge Moderation2ModerateInflo c)
	(not (or
		(edge Moderation2ModerationARS c)
		(edge Graphing2BeInflo c)
		(edge ReputationValues2ProvideReputations c)
		(edge Authorship2CreateGraph c)
		(edge Authorship2CreateDiscussions c)
		(edge IntegrityOfModels2IntegrityOfModelsIME c)
	))
)))
;Moderation2ModerationARS srcType constant
(assert (forall ((c DependeeLink)) (=>
	(edge Moderation2ModerationARS c)
	(= (srcType c) RESOURCE)
)))
;Moderation2ModerationARS tgtType constant
(assert (forall ((c DependeeLink)) (=>
	(edge Moderation2ModerationARS c)
	(= (tgtType c) TASK)
)))
;Moderation2ModerationARS endpoints
(assert (forall ((c DependeeLink)) (=>
	(edge Moderation2ModerationARS c)
	(and
		(node Moderation ((as src (Resource)) c))
		(node ModerationARS ((as tgt (Task)) c))
	)
)))
;Moderation2ModerationARS is Unique
(assert	(forall ((c1 DependeeLink) (c2 DependeeLink)) (=>
	(and (edge Moderation2ModerationARS c1) (edge Moderation2ModerationARS c2))
	(= c1 c2)
)))
;Moderation2ModerationARS is Distinct
(assert	(forall ((c DependeeLink)) (=>
	(edge Moderation2ModerationARS c)
	(not (or
		(edge Moderation2ModerateInflo c)
		(edge Graphing2BeInflo c)
		(edge ReputationValues2ProvideReputations c)
		(edge Authorship2CreateGraph c)
		(edge Authorship2CreateDiscussions c)
		(edge IntegrityOfModels2IntegrityOfModelsIME c)
	))
)))
;Graphing2BeInflo srcType constant
(assert (forall ((c DependeeLink)) (=>
	(edge Graphing2BeInflo c)
	(= (srcType c) RESOURCE)
)))
;Graphing2BeInflo tgtType constant
(assert (forall ((c DependeeLink)) (=>
	(edge Graphing2BeInflo c)
	(= (tgtType c) TASK)
)))
;Graphing2BeInflo endpoints
(assert (forall ((c DependeeLink)) (=>
	(edge Graphing2BeInflo c)
	(and
		(node Graphing ((as src (Resource)) c))
		(node BeInflo ((as tgt (Task)) c))
	)
)))
;Graphing2BeInflo Exists
(assert	(exists ((c DependeeLink)) (edge Graphing2BeInflo c)))
;Graphing2BeInflo is Unique
(assert	(forall ((c1 DependeeLink) (c2 DependeeLink)) (=>
	(and (edge Graphing2BeInflo c1) (edge Graphing2BeInflo c2))
	(= c1 c2)
)))
;Graphing2BeInflo is Distinct
(assert	(forall ((c DependeeLink)) (=>
	(edge Graphing2BeInflo c)
	(not (or
		(edge Moderation2ModerateInflo c)
		(edge Moderation2ModerationARS c)
		(edge ReputationValues2ProvideReputations c)
		(edge Authorship2CreateGraph c)
		(edge Authorship2CreateDiscussions c)
		(edge IntegrityOfModels2IntegrityOfModelsIME c)
	))
)))
;ReputationValues2ProvideReputations srcType constant
(assert (forall ((c DependeeLink)) (=>
	(edge ReputationValues2ProvideReputations c)
	(= (srcType c) RESOURCE)
)))
;ReputationValues2ProvideReputations tgtType constant
(assert (forall ((c DependeeLink)) (=>
	(edge ReputationValues2ProvideReputations c)
	(= (tgtType c) TASK)
)))
;ReputationValues2ProvideReputations endpoints
(assert (forall ((c DependeeLink)) (=>
	(edge ReputationValues2ProvideReputations c)
	(and
		(node ReputationValues ((as src (Resource)) c))
		(node ProvideReputations ((as tgt (Task)) c))
	)
)))
;ReputationValues2ProvideReputations Exists
(assert	(exists ((c DependeeLink)) (edge ReputationValues2ProvideReputations c)))
;ReputationValues2ProvideReputations is Unique
(assert	(forall ((c1 DependeeLink) (c2 DependeeLink)) (=>
	(and (edge ReputationValues2ProvideReputations c1) (edge ReputationValues2ProvideReputations c2))
	(= c1 c2)
)))
;ReputationValues2ProvideReputations is Distinct
(assert	(forall ((c DependeeLink)) (=>
	(edge ReputationValues2ProvideReputations c)
	(not (or
		(edge Moderation2ModerateInflo c)
		(edge Moderation2ModerationARS c)
		(edge Graphing2BeInflo c)
		(edge Authorship2CreateGraph c)
		(edge Authorship2CreateDiscussions c)
		(edge IntegrityOfModels2IntegrityOfModelsIME c)
	))
)))
;Authorship2CreateGraph srcType constant
(assert (forall ((c DependeeLink)) (=>
	(edge Authorship2CreateGraph c)
	(= (srcType c) RESOURCE)
)))
;Authorship2CreateGraph tgtType constant
(assert (forall ((c DependeeLink)) (=>
	(edge Authorship2CreateGraph c)
	(= (tgtType c) TASK)
)))
;Authorship2CreateGraph endpoints
(assert (forall ((c DependeeLink)) (=>
	(edge Authorship2CreateGraph c)
	(and
		(node Authorship ((as src (Resource)) c))
		(node CreateGraph ((as tgt (Task)) c))
	)
)))
;Authorship2CreateGraph is Unique
(assert	(forall ((c1 DependeeLink) (c2 DependeeLink)) (=>
	(and (edge Authorship2CreateGraph c1) (edge Authorship2CreateGraph c2))
	(= c1 c2)
)))
;Authorship2CreateGraph is Distinct
(assert	(forall ((c DependeeLink)) (=>
	(edge Authorship2CreateGraph c)
	(not (or
		(edge Moderation2ModerateInflo c)
		(edge Moderation2ModerationARS c)
		(edge Graphing2BeInflo c)
		(edge ReputationValues2ProvideReputations c)
		(edge Authorship2CreateDiscussions c)
		(edge IntegrityOfModels2IntegrityOfModelsIME c)
	))
)))
;Authorship2CreateDiscussions srcType constant
(assert (forall ((c DependeeLink)) (=>
	(edge Authorship2CreateDiscussions c)
	(= (srcType c) RESOURCE)
)))
;Authorship2CreateDiscussions tgtType constant
(assert (forall ((c DependeeLink)) (=>
	(edge Authorship2CreateDiscussions c)
	(= (tgtType c) TASK)
)))
;Authorship2CreateDiscussions endpoints
(assert (forall ((c DependeeLink)) (=>
	(edge Authorship2CreateDiscussions c)
	(and
		(node Authorship ((as src (Resource)) c))
		(node CreateDiscussions ((as tgt (Task)) c))
	)
)))
;Authorship2CreateDiscussions is Unique
(assert	(forall ((c1 DependeeLink) (c2 DependeeLink)) (=>
	(and (edge Authorship2CreateDiscussions c1) (edge Authorship2CreateDiscussions c2))
	(= c1 c2)
)))
;Authorship2CreateDiscussions is Distinct
(assert	(forall ((c DependeeLink)) (=>
	(edge Authorship2CreateDiscussions c)
	(not (or
		(edge Moderation2ModerateInflo c)
		(edge Moderation2ModerationARS c)
		(edge Graphing2BeInflo c)
		(edge ReputationValues2ProvideReputations c)
		(edge Authorship2CreateGraph c)
		(edge IntegrityOfModels2IntegrityOfModelsIME c)
	))
)))
;IntegrityOfModels2IntegrityOfModelsIME srcType constant
(assert (forall ((c DependeeLink)) (=>
	(edge IntegrityOfModels2IntegrityOfModelsIME c)
	(= (srcType c) SOFTGOAL)
)))
;IntegrityOfModels2IntegrityOfModelsIME tgtType constant
(assert (forall ((c DependeeLink)) (=>
	(edge IntegrityOfModels2IntegrityOfModelsIME c)
	(= (tgtType c) SOFTGOAL)
)))
;IntegrityOfModels2IntegrityOfModelsIME endpoints
(assert (forall ((c DependeeLink)) (=>
	(edge IntegrityOfModels2IntegrityOfModelsIME c)
	(and
		(node IntegrityOfModels ((as src (SoftGoal)) c))
		(node IntegrityOfModelsIME ((as tgt (SoftGoal)) c))
	)
)))
;IntegrityOfModels2IntegrityOfModelsIME Exists
(assert	(exists ((c DependeeLink)) (edge IntegrityOfModels2IntegrityOfModelsIME c)))
;IntegrityOfModels2IntegrityOfModelsIME is Unique
(assert	(forall ((c1 DependeeLink) (c2 DependeeLink)) (=>
	(and (edge IntegrityOfModels2IntegrityOfModelsIME c1) (edge IntegrityOfModels2IntegrityOfModelsIME c2))
	(= c1 c2)
)))
;IntegrityOfModels2IntegrityOfModelsIME is Distinct
(assert	(forall ((c DependeeLink)) (=>
	(edge IntegrityOfModels2IntegrityOfModelsIME c)
	(not (or
		(edge Moderation2ModerateInflo c)
		(edge Moderation2ModerationARS c)
		(edge Graphing2BeInflo c)
		(edge ReputationValues2ProvideReputations c)
		(edge Authorship2CreateGraph c)
		(edge Authorship2CreateDiscussions c)
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
