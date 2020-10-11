
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
(declare-const InfloUser Node);Node
(assert (= InfloUser 11))
(declare-const MakeModelsTrustworthy Node);Node
(assert (= MakeModelsTrustworthy 12))
(declare-const UseInflo Node);Node
(assert (= UseInflo 13))
(declare-const ValidateModel Node);Node
(assert (= ValidateModel 14))
(declare-const ValidateModel2MakeModelsTrustworthy Edge)
(assert (= ValidateModel2MakeModelsTrustworthy 15))
(declare-const GetFeedback Node);Node
(assert (= GetFeedback 16))
(declare-const GetFeedback2MakeModelsTrustworthy Edge)
(assert (= GetFeedback2MakeModelsTrustworthy 17))
(declare-const Browsing Node);Node
(assert (= Browsing 18))
(declare-const Browsing2UseInflo Edge)
(assert (= Browsing2UseInflo 19))
(declare-const CreateGraph Node);Node
(assert (= CreateGraph 20))
(declare-const CreateGraph2UseInflo Edge)
(assert (= CreateGraph2UseInflo 21))
(declare-const UseDiscussions Node);Node
(assert (= UseDiscussions 22))
(declare-const UseDiscussions2UseInflo Edge)
(assert (= UseDiscussions2UseInflo 23))
(declare-const UseDiscussions2ValidateModel Edge)
(assert (= UseDiscussions2ValidateModel 24))
(declare-const InfloBeModerated Node);Node
(assert (= InfloBeModerated 25))
(declare-const InfloBeModerated2GetFeedback Edge)
(assert (= InfloBeModerated2GetFeedback 26))
(declare-const MakeViews Node);Node
(assert (= MakeViews 27))
(declare-const MakeViews2Browsing Edge)
(assert (= MakeViews2Browsing 28))
(declare-const AddSourceInDescription Node);Node
(assert (= AddSourceInDescription 29))
(declare-const AddSourceInDescription2CreateGraph Edge)
(assert (= AddSourceInDescription2CreateGraph 30))
(declare-const IntegrityOfModelsIU Node);Node
(assert (= IntegrityOfModelsIU 31))
(declare-const IntegrityOfModelsIU2MakeModelsTrustworthy Edge)
(assert (= IntegrityOfModelsIU2MakeModelsTrustworthy 32))
(declare-const InfloManagerEditors Node);Node
(assert (= InfloManagerEditors 33))
(declare-const ExtensiveModeration Node);Node
(assert (= ExtensiveModeration 34))
(declare-const ExtensiveModeration2IntegrityOfModelsIME Edge)
(assert (= ExtensiveModeration2IntegrityOfModelsIME 35))
(declare-const ExtensiveModeration2MinimizeModeratorEffort Edge)
(assert (= ExtensiveModeration2MinimizeModeratorEffort 36))
(declare-const UseAutomatedReputationSystem Node);Node
(assert (= UseAutomatedReputationSystem 37))
(declare-const UseAutomatedReputationSystem2MinimizeModeratorEffort Edge)
(assert (= UseAutomatedReputationSystem2MinimizeModeratorEffort 38))
(declare-const ModerateInflo Node);Node
(assert (= ModerateInflo 39))
(declare-const IntegrityOfModelsIME Node);Node
(assert (= IntegrityOfModelsIME 40))
(declare-const MinimizeModeratorEffort Node);Node
(assert (= MinimizeModeratorEffort 41))
(declare-const Source Node);Node
(assert (= Source 42))
(declare-const AutomatedReputationSystem Node);Node
(assert (= AutomatedReputationSystem 43))
(declare-const ProvideReputations Node);Node
(assert (= ProvideReputations 44))
(declare-const Inflo Node);Node
(assert (= Inflo 45))
(declare-const AllowModeration Node);Node
(assert (= AllowModeration 46))
(declare-const TrackAuthorship Node);Node
(assert (= TrackAuthorship 47))
(declare-const TrackAuthorship2BeInflo Edge)
(assert (= TrackAuthorship2BeInflo 48))
(declare-const DisplayGraphs Node);Node
(assert (= DisplayGraphs 49))
(declare-const DisplayGraphs2BeInflo Edge)
(assert (= DisplayGraphs2BeInflo 50))
(declare-const TrackRevisions Node);Node
(assert (= TrackRevisions 51))
(declare-const TrackRevisions2BeInflo Edge)
(assert (= TrackRevisions2BeInflo 52))
(declare-const CreateGraphs Node);Node
(assert (= CreateGraphs 53))
(declare-const CreateGraphs2BeInflo Edge)
(assert (= CreateGraphs2BeInflo 54))
(declare-const BeInflo Node);Node
(assert (= BeInflo 55))
(declare-const Moderation Node);Node
(assert (= Moderation 56))
(declare-const InfloBeModerated2Moderation Edge)
(assert (= InfloBeModerated2Moderation 57))
(declare-const AllowModeration2Moderation Edge)
(assert (= AllowModeration2Moderation 58))
(declare-const Moderation2ModerateInflo Edge)
(assert (= Moderation2ModerateInflo 59))
(declare-const Graphing Node);Node
(assert (= Graphing 60))
(declare-const UseInflo2Graphing Edge)
(assert (= UseInflo2Graphing 61))
(declare-const Graphing2BeInflo Edge)
(assert (= Graphing2BeInflo 62))
(declare-const ReputationValues Node);Node
(assert (= ReputationValues 63))
(declare-const UseAutomatedReputationSystem2ReputationValues Edge)
(assert (= UseAutomatedReputationSystem2ReputationValues 64))
(declare-const ReputationValues2ProvideReputations Edge)
(assert (= ReputationValues2ProvideReputations 65))
(declare-const Info Node);Node
(assert (= Info 66))
(declare-const AddSourceInDescription2Info Edge)
(assert (= AddSourceInDescription2Info 67))
(declare-const Info2Source Edge)
(assert (= Info2Source 68))
(declare-const IntegrityOfModels Node);Node
(assert (= IntegrityOfModels 69))
(declare-const IntegrityOfModelsIU2IntegrityOfModels Edge)
(assert (= IntegrityOfModelsIU2IntegrityOfModels 70))
(declare-const IntegrityOfModels2IntegrityOfModelsIME Edge)
(assert (= IntegrityOfModels2IntegrityOfModelsIME 71))
;End Nodes
(assert (forall ((c Contribution)) (=>
	(edge ValidateModel2MakeModelsTrustworthy c)
	(and
		(= (srcType c) SOFTGOAL)
		(= (tgtType c) SOFTGOAL)
		(node ValidateModel ((as src (SoftGoal)) c))
		(node MakeModelsTrustworthy ((as tgt (SoftGoal)) c))
	)
)))
(assert (forall ((c Contribution)) (=>
	(edge GetFeedback2MakeModelsTrustworthy c)
	(and
		(= (srcType c) SOFTGOAL)
		(= (tgtType c) SOFTGOAL)
		(node GetFeedback ((as src (SoftGoal)) c))
		(node MakeModelsTrustworthy ((as tgt (SoftGoal)) c))
	)
)))
(assert (forall ((c MeansEnd)) (=>
	(edge Browsing2UseInflo c)
	(and
		(= (srcType c) TASK)
		(= (tgtType c) GOAL)
		(node Browsing ((as src (Task)) c))
		(node UseInflo ((as tgt (Goal)) c))
	)
)))
(assert (forall ((c MeansEnd)) (=>
	(edge CreateGraph2UseInflo c)
	(and
		(= (srcType c) TASK)
		(= (tgtType c) GOAL)
		(node CreateGraph ((as src (Task)) c))
		(node UseInflo ((as tgt (Goal)) c))
	)
)))
(assert (forall ((c MeansEnd)) (=>
	(edge UseDiscussions2UseInflo c)
	(and
		(= (srcType c) TASK)
		(= (tgtType c) GOAL)
		(node UseDiscussions ((as src (Task)) c))
		(node UseInflo ((as tgt (Goal)) c))
	)
)))
(assert (forall ((c Contribution)) (=>
	(edge UseDiscussions2ValidateModel c)
	(and
		(= (srcType c) TASK)
		(= (tgtType c) SOFTGOAL)
		(node UseDiscussions ((as src (Task)) c))
		(node ValidateModel ((as tgt (SoftGoal)) c))
	)
)))
(assert (forall ((c Contribution)) (=>
	(edge InfloBeModerated2GetFeedback c)
	(and
		(= (srcType c) GOAL)
		(= (tgtType c) SOFTGOAL)
		(node InfloBeModerated ((as src (Goal)) c))
		(node GetFeedback ((as tgt (SoftGoal)) c))
	)
)))
(assert (forall ((c Decomposition)) (=>
	(edge MakeViews2Browsing c)
	(and
		(= (srcType c) TASK)
		(= (tgtType c) TASK)
		(node MakeViews ((as src (Task)) c))
		(node Browsing ((as tgt (Task)) c))
	)
)))
(assert (forall ((c Decomposition)) (=>
	(edge AddSourceInDescription2CreateGraph c)
	(and
		(= (srcType c) TASK)
		(= (tgtType c) TASK)
		(node AddSourceInDescription ((as src (Task)) c))
		(node CreateGraph ((as tgt (Task)) c))
	)
)))
(assert (forall ((c Contribution)) (=>
	(edge IntegrityOfModelsIU2MakeModelsTrustworthy c)
	(and
		(= (srcType c) SOFTGOAL)
		(= (tgtType c) SOFTGOAL)
		(node IntegrityOfModelsIU ((as src (SoftGoal)) c))
		(node MakeModelsTrustworthy ((as tgt (SoftGoal)) c))
	)
)))
(assert (forall ((c Contribution)) (=>
	(edge ExtensiveModeration2IntegrityOfModelsIME c)
	(and
		(= (srcType c) TASK)
		(= (tgtType c) SOFTGOAL)
		(node ExtensiveModeration ((as src (Task)) c))
		(node IntegrityOfModelsIME ((as tgt (SoftGoal)) c))
	)
)))
(assert (forall ((c Contribution)) (=>
	(edge ExtensiveModeration2MinimizeModeratorEffort c)
	(and
		(= (srcType c) TASK)
		(= (tgtType c) SOFTGOAL)
		(node ExtensiveModeration ((as src (Task)) c))
		(node MinimizeModeratorEffort ((as tgt (SoftGoal)) c))
	)
)))
(assert (forall ((c Contribution)) (=>
	(edge UseAutomatedReputationSystem2MinimizeModeratorEffort c)
	(and
		(= (srcType c) TASK)
		(= (tgtType c) SOFTGOAL)
		(node UseAutomatedReputationSystem ((as src (Task)) c))
		(node MinimizeModeratorEffort ((as tgt (SoftGoal)) c))
	)
)))
(assert (forall ((c Decomposition)) (=>
	(edge TrackAuthorship2BeInflo c)
	(and
		(= (srcType c) TASK)
		(= (tgtType c) TASK)
		(node TrackAuthorship ((as src (Task)) c))
		(node BeInflo ((as tgt (Task)) c))
	)
)))
(assert (forall ((c Decomposition)) (=>
	(edge DisplayGraphs2BeInflo c)
	(and
		(= (srcType c) TASK)
		(= (tgtType c) TASK)
		(node DisplayGraphs ((as src (Task)) c))
		(node BeInflo ((as tgt (Task)) c))
	)
)))
(assert (forall ((c Decomposition)) (=>
	(edge TrackRevisions2BeInflo c)
	(and
		(= (srcType c) TASK)
		(= (tgtType c) TASK)
		(node TrackRevisions ((as src (Task)) c))
		(node BeInflo ((as tgt (Task)) c))
	)
)))
(assert (forall ((c Decomposition)) (=>
	(edge CreateGraphs2BeInflo c)
	(and
		(= (srcType c) TASK)
		(= (tgtType c) TASK)
		(node CreateGraphs ((as src (Task)) c))
		(node BeInflo ((as tgt (Task)) c))
	)
)))
(assert (forall ((c DependerLink)) (=>
	(edge InfloBeModerated2Moderation c)
	(and
		(= (srcType c) GOAL)
		(= (tgtType c) RESOURCE)
		(node InfloBeModerated ((as src (Goal)) c))
		(node Moderation ((as tgt (Resource)) c))
	)
)))
(assert (forall ((c DependerLink)) (=>
	(edge AllowModeration2Moderation c)
	(and
		(= (srcType c) GOAL)
		(= (tgtType c) RESOURCE)
		(node AllowModeration ((as src (Goal)) c))
		(node Moderation ((as tgt (Resource)) c))
	)
)))
(assert (forall ((c DependeeLink)) (=>
	(edge Moderation2ModerateInflo c)
	(and
		(= (srcType c) RESOURCE)
		(= (tgtType c) GOAL)
		(node Moderation ((as src (Resource)) c))
		(node ModerateInflo ((as tgt (Goal)) c))
	)
)))
(assert (forall ((c DependerLink)) (=>
	(edge UseInflo2Graphing c)
	(and
		(= (srcType c) GOAL)
		(= (tgtType c) RESOURCE)
		(node UseInflo ((as src (Goal)) c))
		(node Graphing ((as tgt (Resource)) c))
	)
)))
(assert (forall ((c DependeeLink)) (=>
	(edge Graphing2BeInflo c)
	(and
		(= (srcType c) RESOURCE)
		(= (tgtType c) TASK)
		(node Graphing ((as src (Resource)) c))
		(node BeInflo ((as tgt (Task)) c))
	)
)))
(assert (forall ((c DependerLink)) (=>
	(edge UseAutomatedReputationSystem2ReputationValues c)
	(and
		(= (srcType c) TASK)
		(= (tgtType c) RESOURCE)
		(node UseAutomatedReputationSystem ((as src (Task)) c))
		(node ReputationValues ((as tgt (Resource)) c))
	)
)))
(assert (forall ((c DependeeLink)) (=>
	(edge ReputationValues2ProvideReputations c)
	(and
		(= (srcType c) RESOURCE)
		(= (tgtType c) TASK)
		(node ReputationValues ((as src (Resource)) c))
		(node ProvideReputations ((as tgt (Task)) c))
	)
)))
(assert (forall ((c DependerLink)) (=>
	(edge AddSourceInDescription2Info c)
	(and
		(= (srcType c) TASK)
		(= (tgtType c) RESOURCE)
		(node AddSourceInDescription ((as src (Task)) c))
		(node Info ((as tgt (Resource)) c))
	)
)))
(assert (forall ((c DependeeLink)) (=>
	(edge Info2Source c)
	(and
		(= (srcType c) RESOURCE)
		(= (tgtType c) ACTOR)
		(node Info ((as src (Resource)) c))
		(node Source ((as tgt (Actor)) c))
	)
)))
(assert (forall ((c DependerLink)) (=>
	(edge IntegrityOfModelsIU2IntegrityOfModels c)
	(and
		(= (srcType c) SOFTGOAL)
		(= (tgtType c) SOFTGOAL)
		(node IntegrityOfModelsIU ((as src (SoftGoal)) c))
		(node IntegrityOfModels ((as tgt (SoftGoal)) c))
	)
)))
(assert (forall ((c DependeeLink)) (=>
	(edge IntegrityOfModels2IntegrityOfModelsIME c)
	(and
		(= (srcType c) SOFTGOAL)
		(= (tgtType c) SOFTGOAL)
		(node IntegrityOfModels ((as src (SoftGoal)) c))
		(node IntegrityOfModelsIME ((as tgt (SoftGoal)) c))
	)
)))

;Model is Complete
(assert	(forall ((c Actor)) (or
	(node InfloUser c)
	(node InfloManagerEditors c)
	(node Source c)
	(node AutomatedReputationSystem c)
	(node Inflo c)
)))
(assert	(forall ((c Task)) (or
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
(assert	(forall ((c Resource)) (or
	(node Moderation c)
	(node Graphing c)
	(node ReputationValues c)
	(node Info c)
)))
(assert	(forall ((c Goal)) (or
	(node UseInflo c)
	(node InfloBeModerated c)
	(node ModerateInflo c)
	(node AllowModeration c)
)))
(assert	(forall ((c SoftGoal)) (or
	(node MakeModelsTrustworthy c)
	(node ValidateModel c)
	(node GetFeedback c)
	(node IntegrityOfModelsIU c)
	(node IntegrityOfModelsIME c)
	(node MinimizeModeratorEffort c)
	(node IntegrityOfModels c)
)))
(assert	(forall ((c MeansEnd)) (or
	(edge Browsing2UseInflo c)
	(edge CreateGraph2UseInflo c)
	(edge UseDiscussions2UseInflo c)
)))
(assert	(forall ((c Decomposition)) (or
	(edge MakeViews2Browsing c)
	(edge AddSourceInDescription2CreateGraph c)
	(edge TrackAuthorship2BeInflo c)
	(edge DisplayGraphs2BeInflo c)
	(edge TrackRevisions2BeInflo c)
	(edge CreateGraphs2BeInflo c)
)))
(assert	(forall ((c Contribution)) (or
	(edge ValidateModel2MakeModelsTrustworthy c)
	(edge GetFeedback2MakeModelsTrustworthy c)
	(edge UseDiscussions2ValidateModel c)
	(edge InfloBeModerated2GetFeedback c)
	(edge IntegrityOfModelsIU2MakeModelsTrustworthy c)
	(edge ExtensiveModeration2IntegrityOfModelsIME c)
	(edge ExtensiveModeration2MinimizeModeratorEffort c)
	(edge UseAutomatedReputationSystem2MinimizeModeratorEffort c)
)))
(assert	(forall ((c DependerLink)) (or
	(edge InfloBeModerated2Moderation c)
	(edge AllowModeration2Moderation c)
	(edge UseInflo2Graphing c)
	(edge UseAutomatedReputationSystem2ReputationValues c)
	(edge AddSourceInDescription2Info c)
	(edge IntegrityOfModelsIU2IntegrityOfModels c)
)))
(assert	(forall ((c DependeeLink)) (or
	(edge Moderation2ModerateInflo c)
	(edge Graphing2BeInflo c)
	(edge ReputationValues2ProvideReputations c)
	(edge Info2Source c)
	(edge IntegrityOfModels2IntegrityOfModelsIME c)
)))
;InfloUser Exists
(assert (exists ((c Actor)) (node InfloUser c)))
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
;MakeModelsTrustworthy Exists
(assert (exists ((c SoftGoal)) (node MakeModelsTrustworthy c)))
;MakeModelsTrustworthy is Unique
(assert	(forall ((c1 SoftGoal) (c2 SoftGoal)) (=>
	(and (node MakeModelsTrustworthy c1) (node MakeModelsTrustworthy c2))
	(= c1 c2)
)))
;MakeModelsTrustworthy is Distinct
(assert	(forall ((c SoftGoal)) (=>
	(node MakeModelsTrustworthy c)
	(not (or
		(node ValidateModel c)
		(node GetFeedback c)
		(node IntegrityOfModelsIU c)
		(node IntegrityOfModelsIME c)
		(node MinimizeModeratorEffort c)
		(node IntegrityOfModels c)
	))
)))
;UseInflo Exists
(assert (exists ((c Goal)) (node UseInflo c)))
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
;ValidateModel Exists
(assert (exists ((c SoftGoal)) (node ValidateModel c)))
;ValidateModel is Unique
(assert	(forall ((c1 SoftGoal) (c2 SoftGoal)) (=>
	(and (node ValidateModel c1) (node ValidateModel c2))
	(= c1 c2)
)))
;ValidateModel is Distinct
(assert	(forall ((c SoftGoal)) (=>
	(node ValidateModel c)
	(not (or
		(node MakeModelsTrustworthy c)
		(node GetFeedback c)
		(node IntegrityOfModelsIU c)
		(node IntegrityOfModelsIME c)
		(node MinimizeModeratorEffort c)
		(node IntegrityOfModels c)
	))
)))
;ValidateModel2MakeModelsTrustworthy Exists
(assert (exists ((c Contribution)) (edge ValidateModel2MakeModelsTrustworthy c)))
;ValidateModel2MakeModelsTrustworthy is Unique
(assert	(forall ((c1 Contribution) (c2 Contribution)) (=>
	(and (edge ValidateModel2MakeModelsTrustworthy c1) (edge ValidateModel2MakeModelsTrustworthy c2))
	(= c1 c2)
)))
;ValidateModel2MakeModelsTrustworthy is Distinct
(assert	(forall ((c Contribution)) (=>
	(edge ValidateModel2MakeModelsTrustworthy c)
	(not (or
		(edge GetFeedback2MakeModelsTrustworthy c)
		(edge UseDiscussions2ValidateModel c)
		(edge InfloBeModerated2GetFeedback c)
		(edge IntegrityOfModelsIU2MakeModelsTrustworthy c)
		(edge ExtensiveModeration2IntegrityOfModelsIME c)
		(edge ExtensiveModeration2MinimizeModeratorEffort c)
		(edge UseAutomatedReputationSystem2MinimizeModeratorEffort c)
	))
)))
;GetFeedback Exists
(assert (exists ((c SoftGoal)) (node GetFeedback c)))
;GetFeedback is Unique
(assert	(forall ((c1 SoftGoal) (c2 SoftGoal)) (=>
	(and (node GetFeedback c1) (node GetFeedback c2))
	(= c1 c2)
)))
;GetFeedback is Distinct
(assert	(forall ((c SoftGoal)) (=>
	(node GetFeedback c)
	(not (or
		(node MakeModelsTrustworthy c)
		(node ValidateModel c)
		(node IntegrityOfModelsIU c)
		(node IntegrityOfModelsIME c)
		(node MinimizeModeratorEffort c)
		(node IntegrityOfModels c)
	))
)))
;GetFeedback2MakeModelsTrustworthy Exists
(assert (exists ((c Contribution)) (edge GetFeedback2MakeModelsTrustworthy c)))
;GetFeedback2MakeModelsTrustworthy is Unique
(assert	(forall ((c1 Contribution) (c2 Contribution)) (=>
	(and (edge GetFeedback2MakeModelsTrustworthy c1) (edge GetFeedback2MakeModelsTrustworthy c2))
	(= c1 c2)
)))
;GetFeedback2MakeModelsTrustworthy is Distinct
(assert	(forall ((c Contribution)) (=>
	(edge GetFeedback2MakeModelsTrustworthy c)
	(not (or
		(edge ValidateModel2MakeModelsTrustworthy c)
		(edge UseDiscussions2ValidateModel c)
		(edge InfloBeModerated2GetFeedback c)
		(edge IntegrityOfModelsIU2MakeModelsTrustworthy c)
		(edge ExtensiveModeration2IntegrityOfModelsIME c)
		(edge ExtensiveModeration2MinimizeModeratorEffort c)
		(edge UseAutomatedReputationSystem2MinimizeModeratorEffort c)
	))
)))
;Browsing Exists
(assert (exists ((c Task)) (node Browsing c)))
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
		(node ProvideReputations c)
		(node TrackAuthorship c)
		(node DisplayGraphs c)
		(node TrackRevisions c)
		(node CreateGraphs c)
		(node BeInflo c)
	))
)))
;Browsing2UseInflo Exists
(assert (exists ((c MeansEnd)) (edge Browsing2UseInflo c)))
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
	))
)))
;CreateGraph Exists
(assert (exists ((c Task)) (node CreateGraph c)))
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
		(node ProvideReputations c)
		(node TrackAuthorship c)
		(node DisplayGraphs c)
		(node TrackRevisions c)
		(node CreateGraphs c)
		(node BeInflo c)
	))
)))
;CreateGraph2UseInflo Exists
(assert (exists ((c MeansEnd)) (edge CreateGraph2UseInflo c)))
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
	))
)))
;UseDiscussions Exists
(assert (exists ((c Task)) (node UseDiscussions c)))
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
		(node ProvideReputations c)
		(node TrackAuthorship c)
		(node DisplayGraphs c)
		(node TrackRevisions c)
		(node CreateGraphs c)
		(node BeInflo c)
	))
)))
;UseDiscussions2UseInflo Exists
(assert (exists ((c MeansEnd)) (edge UseDiscussions2UseInflo c)))
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
	))
)))
;UseDiscussions2ValidateModel Exists
(assert (exists ((c Contribution)) (edge UseDiscussions2ValidateModel c)))
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
		(edge InfloBeModerated2GetFeedback c)
		(edge IntegrityOfModelsIU2MakeModelsTrustworthy c)
		(edge ExtensiveModeration2IntegrityOfModelsIME c)
		(edge ExtensiveModeration2MinimizeModeratorEffort c)
		(edge UseAutomatedReputationSystem2MinimizeModeratorEffort c)
	))
)))
;InfloBeModerated Exists
(assert (exists ((c Goal)) (node InfloBeModerated c)))
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
;InfloBeModerated2GetFeedback Exists
(assert (exists ((c Contribution)) (edge InfloBeModerated2GetFeedback c)))
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
		(edge IntegrityOfModelsIU2MakeModelsTrustworthy c)
		(edge ExtensiveModeration2IntegrityOfModelsIME c)
		(edge ExtensiveModeration2MinimizeModeratorEffort c)
		(edge UseAutomatedReputationSystem2MinimizeModeratorEffort c)
	))
)))
;MakeViews Exists
(assert (exists ((c Task)) (node MakeViews c)))
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
		(node ProvideReputations c)
		(node TrackAuthorship c)
		(node DisplayGraphs c)
		(node TrackRevisions c)
		(node CreateGraphs c)
		(node BeInflo c)
	))
)))
;MakeViews2Browsing Exists
(assert (exists ((c Decomposition)) (edge MakeViews2Browsing c)))
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
		(edge TrackAuthorship2BeInflo c)
		(edge DisplayGraphs2BeInflo c)
		(edge TrackRevisions2BeInflo c)
		(edge CreateGraphs2BeInflo c)
	))
)))
;AddSourceInDescription Exists
(assert (exists ((c Task)) (node AddSourceInDescription c)))
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
		(node ProvideReputations c)
		(node TrackAuthorship c)
		(node DisplayGraphs c)
		(node TrackRevisions c)
		(node CreateGraphs c)
		(node BeInflo c)
	))
)))
;AddSourceInDescription2CreateGraph Exists
(assert (exists ((c Decomposition)) (edge AddSourceInDescription2CreateGraph c)))
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
		(edge TrackAuthorship2BeInflo c)
		(edge DisplayGraphs2BeInflo c)
		(edge TrackRevisions2BeInflo c)
		(edge CreateGraphs2BeInflo c)
	))
)))
;IntegrityOfModelsIU Exists
(assert (exists ((c SoftGoal)) (node IntegrityOfModelsIU c)))
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
		(node ValidateModel c)
		(node GetFeedback c)
		(node IntegrityOfModelsIME c)
		(node MinimizeModeratorEffort c)
		(node IntegrityOfModels c)
	))
)))
;IntegrityOfModelsIU2MakeModelsTrustworthy Exists
(assert (exists ((c Contribution)) (edge IntegrityOfModelsIU2MakeModelsTrustworthy c)))
;IntegrityOfModelsIU2MakeModelsTrustworthy is Unique
(assert	(forall ((c1 Contribution) (c2 Contribution)) (=>
	(and (edge IntegrityOfModelsIU2MakeModelsTrustworthy c1) (edge IntegrityOfModelsIU2MakeModelsTrustworthy c2))
	(= c1 c2)
)))
;IntegrityOfModelsIU2MakeModelsTrustworthy is Distinct
(assert	(forall ((c Contribution)) (=>
	(edge IntegrityOfModelsIU2MakeModelsTrustworthy c)
	(not (or
		(edge ValidateModel2MakeModelsTrustworthy c)
		(edge GetFeedback2MakeModelsTrustworthy c)
		(edge UseDiscussions2ValidateModel c)
		(edge InfloBeModerated2GetFeedback c)
		(edge ExtensiveModeration2IntegrityOfModelsIME c)
		(edge ExtensiveModeration2MinimizeModeratorEffort c)
		(edge UseAutomatedReputationSystem2MinimizeModeratorEffort c)
	))
)))
;InfloManagerEditors Exists
(assert (exists ((c Actor)) (node InfloManagerEditors c)))
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
;ExtensiveModeration Exists
(assert (exists ((c Task)) (node ExtensiveModeration c)))
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
		(node UseAutomatedReputationSystem c)
		(node ProvideReputations c)
		(node TrackAuthorship c)
		(node DisplayGraphs c)
		(node TrackRevisions c)
		(node CreateGraphs c)
		(node BeInflo c)
	))
)))
;ExtensiveModeration2IntegrityOfModelsIME Exists
(assert (exists ((c Contribution)) (edge ExtensiveModeration2IntegrityOfModelsIME c)))
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
		(edge InfloBeModerated2GetFeedback c)
		(edge IntegrityOfModelsIU2MakeModelsTrustworthy c)
		(edge ExtensiveModeration2MinimizeModeratorEffort c)
		(edge UseAutomatedReputationSystem2MinimizeModeratorEffort c)
	))
)))
;ExtensiveModeration2MinimizeModeratorEffort Exists
(assert (exists ((c Contribution)) (edge ExtensiveModeration2MinimizeModeratorEffort c)))
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
		(edge InfloBeModerated2GetFeedback c)
		(edge IntegrityOfModelsIU2MakeModelsTrustworthy c)
		(edge ExtensiveModeration2IntegrityOfModelsIME c)
		(edge UseAutomatedReputationSystem2MinimizeModeratorEffort c)
	))
)))
;UseAutomatedReputationSystem Exists
(assert (exists ((c Task)) (node UseAutomatedReputationSystem c)))
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
		(node ExtensiveModeration c)
		(node ProvideReputations c)
		(node TrackAuthorship c)
		(node DisplayGraphs c)
		(node TrackRevisions c)
		(node CreateGraphs c)
		(node BeInflo c)
	))
)))
;UseAutomatedReputationSystem2MinimizeModeratorEffort Exists
(assert (exists ((c Contribution)) (edge UseAutomatedReputationSystem2MinimizeModeratorEffort c)))
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
		(edge InfloBeModerated2GetFeedback c)
		(edge IntegrityOfModelsIU2MakeModelsTrustworthy c)
		(edge ExtensiveModeration2IntegrityOfModelsIME c)
		(edge ExtensiveModeration2MinimizeModeratorEffort c)
	))
)))
;ModerateInflo Exists
(assert (exists ((c Goal)) (node ModerateInflo c)))
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
;IntegrityOfModelsIME Exists
(assert (exists ((c SoftGoal)) (node IntegrityOfModelsIME c)))
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
;MinimizeModeratorEffort Exists
(assert (exists ((c SoftGoal)) (node MinimizeModeratorEffort c)))
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
;Source Exists
(assert (exists ((c Actor)) (node Source c)))
;Source is Unique
(assert	(forall ((c1 Actor) (c2 Actor)) (=>
	(and (node Source c1) (node Source c2))
	(= c1 c2)
)))
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
(assert (exists ((c Actor)) (node AutomatedReputationSystem c)))
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
;ProvideReputations Exists
(assert (exists ((c Task)) (node ProvideReputations c)))
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
		(node ExtensiveModeration c)
		(node UseAutomatedReputationSystem c)
		(node TrackAuthorship c)
		(node DisplayGraphs c)
		(node TrackRevisions c)
		(node CreateGraphs c)
		(node BeInflo c)
	))
)))
;Inflo Exists
(assert (exists ((c Actor)) (node Inflo c)))
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
;AllowModeration Exists
(assert (exists ((c Goal)) (node AllowModeration c)))
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
;TrackAuthorship Exists
(assert (exists ((c Task)) (node TrackAuthorship c)))
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
		(node ExtensiveModeration c)
		(node UseAutomatedReputationSystem c)
		(node ProvideReputations c)
		(node DisplayGraphs c)
		(node TrackRevisions c)
		(node CreateGraphs c)
		(node BeInflo c)
	))
)))
;TrackAuthorship2BeInflo Exists
(assert (exists ((c Decomposition)) (edge TrackAuthorship2BeInflo c)))
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
		(edge DisplayGraphs2BeInflo c)
		(edge TrackRevisions2BeInflo c)
		(edge CreateGraphs2BeInflo c)
	))
)))
;DisplayGraphs Exists
(assert (exists ((c Task)) (node DisplayGraphs c)))
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
		(node ExtensiveModeration c)
		(node UseAutomatedReputationSystem c)
		(node ProvideReputations c)
		(node TrackAuthorship c)
		(node TrackRevisions c)
		(node CreateGraphs c)
		(node BeInflo c)
	))
)))
;DisplayGraphs2BeInflo Exists
(assert (exists ((c Decomposition)) (edge DisplayGraphs2BeInflo c)))
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
		(edge TrackAuthorship2BeInflo c)
		(edge TrackRevisions2BeInflo c)
		(edge CreateGraphs2BeInflo c)
	))
)))
;TrackRevisions Exists
(assert (exists ((c Task)) (node TrackRevisions c)))
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
		(node ExtensiveModeration c)
		(node UseAutomatedReputationSystem c)
		(node ProvideReputations c)
		(node TrackAuthorship c)
		(node DisplayGraphs c)
		(node CreateGraphs c)
		(node BeInflo c)
	))
)))
;TrackRevisions2BeInflo Exists
(assert (exists ((c Decomposition)) (edge TrackRevisions2BeInflo c)))
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
		(edge TrackAuthorship2BeInflo c)
		(edge DisplayGraphs2BeInflo c)
		(edge CreateGraphs2BeInflo c)
	))
)))
;CreateGraphs Exists
(assert (exists ((c Task)) (node CreateGraphs c)))
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
		(node ExtensiveModeration c)
		(node UseAutomatedReputationSystem c)
		(node ProvideReputations c)
		(node TrackAuthorship c)
		(node DisplayGraphs c)
		(node TrackRevisions c)
		(node BeInflo c)
	))
)))
;CreateGraphs2BeInflo Exists
(assert (exists ((c Decomposition)) (edge CreateGraphs2BeInflo c)))
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
		(edge TrackAuthorship2BeInflo c)
		(edge DisplayGraphs2BeInflo c)
		(edge TrackRevisions2BeInflo c)
	))
)))
;BeInflo Exists
(assert (exists ((c Task)) (node BeInflo c)))
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
		(node ExtensiveModeration c)
		(node UseAutomatedReputationSystem c)
		(node ProvideReputations c)
		(node TrackAuthorship c)
		(node DisplayGraphs c)
		(node TrackRevisions c)
		(node CreateGraphs c)
	))
)))
;Moderation Exists
(assert (exists ((c Resource)) (node Moderation c)))
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
	))
)))
;InfloBeModerated2Moderation Exists
(assert (exists ((c DependerLink)) (edge InfloBeModerated2Moderation c)))
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
		(edge IntegrityOfModelsIU2IntegrityOfModels c)
	))
)))
;AllowModeration2Moderation Exists
(assert (exists ((c DependerLink)) (edge AllowModeration2Moderation c)))
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
		(edge IntegrityOfModelsIU2IntegrityOfModels c)
	))
)))
;Moderation2ModerateInflo Exists
(assert (exists ((c DependeeLink)) (edge Moderation2ModerateInflo c)))
;Moderation2ModerateInflo is Unique
(assert	(forall ((c1 DependeeLink) (c2 DependeeLink)) (=>
	(and (edge Moderation2ModerateInflo c1) (edge Moderation2ModerateInflo c2))
	(= c1 c2)
)))
;Moderation2ModerateInflo is Distinct
(assert	(forall ((c DependeeLink)) (=>
	(edge Moderation2ModerateInflo c)
	(not (or
		(edge Graphing2BeInflo c)
		(edge ReputationValues2ProvideReputations c)
		(edge Info2Source c)
		(edge IntegrityOfModels2IntegrityOfModelsIME c)
	))
)))
;Graphing Exists
(assert (exists ((c Resource)) (node Graphing c)))
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
	))
)))
;UseInflo2Graphing Exists
(assert (exists ((c DependerLink)) (edge UseInflo2Graphing c)))
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
		(edge IntegrityOfModelsIU2IntegrityOfModels c)
	))
)))
;Graphing2BeInflo Exists
(assert (exists ((c DependeeLink)) (edge Graphing2BeInflo c)))
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
		(edge ReputationValues2ProvideReputations c)
		(edge Info2Source c)
		(edge IntegrityOfModels2IntegrityOfModelsIME c)
	))
)))
;ReputationValues Exists
(assert (exists ((c Resource)) (node ReputationValues c)))
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
	))
)))
;UseAutomatedReputationSystem2ReputationValues Exists
(assert (exists ((c DependerLink)) (edge UseAutomatedReputationSystem2ReputationValues c)))
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
		(edge IntegrityOfModelsIU2IntegrityOfModels c)
	))
)))
;ReputationValues2ProvideReputations Exists
(assert (exists ((c DependeeLink)) (edge ReputationValues2ProvideReputations c)))
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
		(edge Graphing2BeInflo c)
		(edge Info2Source c)
		(edge IntegrityOfModels2IntegrityOfModelsIME c)
	))
)))
;Info Exists
(assert (exists ((c Resource)) (node Info c)))
;Info is Unique
(assert	(forall ((c1 Resource) (c2 Resource)) (=>
	(and (node Info c1) (node Info c2))
	(= c1 c2)
)))
;Info is Distinct
(assert	(forall ((c Resource)) (=>
	(node Info c)
	(not (or
		(node Moderation c)
		(node Graphing c)
		(node ReputationValues c)
	))
)))
;AddSourceInDescription2Info Exists
(assert (exists ((c DependerLink)) (edge AddSourceInDescription2Info c)))
;AddSourceInDescription2Info is Unique
(assert	(forall ((c1 DependerLink) (c2 DependerLink)) (=>
	(and (edge AddSourceInDescription2Info c1) (edge AddSourceInDescription2Info c2))
	(= c1 c2)
)))
;AddSourceInDescription2Info is Distinct
(assert	(forall ((c DependerLink)) (=>
	(edge AddSourceInDescription2Info c)
	(not (or
		(edge InfloBeModerated2Moderation c)
		(edge AllowModeration2Moderation c)
		(edge UseInflo2Graphing c)
		(edge UseAutomatedReputationSystem2ReputationValues c)
		(edge IntegrityOfModelsIU2IntegrityOfModels c)
	))
)))
;Info2Source Exists
(assert (exists ((c DependeeLink)) (edge Info2Source c)))
;Info2Source is Unique
(assert	(forall ((c1 DependeeLink) (c2 DependeeLink)) (=>
	(and (edge Info2Source c1) (edge Info2Source c2))
	(= c1 c2)
)))
;Info2Source is Distinct
(assert	(forall ((c DependeeLink)) (=>
	(edge Info2Source c)
	(not (or
		(edge Moderation2ModerateInflo c)
		(edge Graphing2BeInflo c)
		(edge ReputationValues2ProvideReputations c)
		(edge IntegrityOfModels2IntegrityOfModelsIME c)
	))
)))
;IntegrityOfModels Exists
(assert (exists ((c SoftGoal)) (node IntegrityOfModels c)))
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
;IntegrityOfModelsIU2IntegrityOfModels Exists
(assert (exists ((c DependerLink)) (edge IntegrityOfModelsIU2IntegrityOfModels c)))
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
	))
)))
;IntegrityOfModels2IntegrityOfModelsIME Exists
(assert (exists ((c DependeeLink)) (edge IntegrityOfModels2IntegrityOfModelsIME c)))
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
		(edge Graphing2BeInflo c)
		(edge ReputationValues2ProvideReputations c)
		(edge Info2Source c)
	))
)))

;Contribution Types
(define-sort ContributionType () Int)
(declare-const MAKE ContributionType)
(assert (= MAKE 72))
(declare-const HELP ContributionType)
(assert (= HELP 73))
(declare-const SOMEPLUS ContributionType)
(assert (= SOMEPLUS 74))
(declare-const BREAK ContributionType)
(assert (= BREAK 75))
(declare-const HURT ContributionType)
(assert (= HURT 76))
(declare-const SOMEMINUS ContributionType)
(assert (= SOMEMINUS 77))
(declare-const UNKNOWN ContributionType)
(assert (= UNKNOWN 78))
(declare-fun type (Contribution) ContributionType)
(assert (forall ((c Contribution)) (=>
	(edge ValidateModel2MakeModelsTrustworthy c)
	(= (type c) HELP)
)))
(assert (forall ((c Contribution)) (=>
	(edge GetFeedback2MakeModelsTrustworthy c)
	(= (type c) HELP)
)))
(assert (forall ((c Contribution)) (=>
	(edge UseDiscussions2ValidateModel c)
	(= (type c) SOMEPLUS)
)))
(assert (forall ((c Contribution)) (=>
	(edge InfloBeModerated2GetFeedback c)
	(= (type c) HURT)
)))
(assert (forall ((c Contribution)) (=>
	(edge IntegrityOfModelsIU2MakeModelsTrustworthy c)
	(= (type c) HELP)
)))
(assert (forall ((c Contribution)) (=>
	(edge ExtensiveModeration2IntegrityOfModelsIME c)
	(= (type c) HELP)
)))
(assert (forall ((c Contribution)) (=>
	(edge ExtensiveModeration2MinimizeModeratorEffort c)
	(= (type c) HURT)
)))
(assert (forall ((c Contribution)) (=>
	(edge UseAutomatedReputationSystem2MinimizeModeratorEffort c)
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
(assert (forall ((c SoftGoal)) (=>
	(node MakeModelsTrustworthy c)
	(= (inited c) false)
)))
(assert (forall ((c Goal)) (=>
	(node UseInflo c)
	(= (inited c) false)
)))
(assert (forall ((c SoftGoal)) (=>
	(node ValidateModel c)
	(= (inited c) false)
)))
(assert (forall ((c SoftGoal)) (=>
	(node GetFeedback c)
	(= (inited c) false)
)))
(assert (forall ((c Task)) (=>
	(node Browsing c)
	(= (inited c) false)
)))
(assert (forall ((c Task)) (=>
	(node CreateGraph c)
	(= (inited c) false)
)))
(assert (forall ((c Task)) (=>
	(node UseDiscussions c)
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
	(node InfloBeModerated c)
	(= (inited c) false)
)))
(assert (forall ((c Task)) (=>
	(node MakeViews c)
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
	(node AddSourceInDescription c)
	(= (inited c) false)
)))
(assert (forall ((c SoftGoal)) (=>
	(node IntegrityOfModelsIU c)
	(= (inited c) false)
)))
(assert (forall ((c Task)) (=>
	(node ExtensiveModeration c)
	(and
		(= (fs c) false)
		(= (ps c) false)
		(= (un c) false)
		(= (co c) false)
		(= (pd c) false)
		(= (fd c) true)
		(= (no c) false)
		(= (inited c) true)
	)
)))
(assert (forall ((c Task)) (=>
	(node UseAutomatedReputationSystem c)
	(= (inited c) false)
)))
(assert (forall ((c Goal)) (=>
	(node ModerateInflo c)
	(and
		(= (fs c) false)
		(= (ps c) false)
		(= (un c) false)
		(= (co c) false)
		(= (pd c) false)
		(= (fd c) true)
		(= (no c) false)
		(= (inited c) true)
	)
)))
(assert (forall ((c SoftGoal)) (=>
	(node IntegrityOfModelsIME c)
	(= (inited c) false)
)))
(assert (forall ((c SoftGoal)) (=>
	(node MinimizeModeratorEffort c)
	(= (inited c) false)
)))
(assert (forall ((c Task)) (=>
	(node ProvideReputations c)
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
	(node AllowModeration c)
	(= (inited c) false)
)))
(assert (forall ((c Task)) (=>
	(node TrackAuthorship c)
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
	(node DisplayGraphs c)
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
	(node TrackRevisions c)
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
	(node CreateGraphs c)
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
	(node BeInflo c)
	(= (inited c) false)
)))
(assert (forall ((c Resource)) (=>
	(node Moderation c)
	(= (inited c) false)
)))
(assert (forall ((c Resource)) (=>
	(node Graphing c)
	(= (inited c) false)
)))
(assert (forall ((c Resource)) (=>
	(node ReputationValues c)
	(= (inited c) false)
)))
(assert (forall ((c Resource)) (=>
	(node Info c)
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
(assert (forall ((c SoftGoal)) (=>
	(node IntegrityOfModels c)
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
