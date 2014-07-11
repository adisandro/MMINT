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
(declare-const Consumer Node);Node
(assert (= Consumer 11))
(declare-const ProtectPersonalInformationC Node);Node
(assert (= ProtectPersonalInformationC 12))
(declare-const ConserveEnergyC Node);Node
(assert (= ConserveEnergyC 13))
(declare-const SaveTimeC Node);Node
(assert (= SaveTimeC 14))
(declare-const ConsumeEnergyC Node);Node
(assert (= ConsumeEnergyC 15))
(declare-const BeInformedOfUsage Node);Node
(assert (= BeInformedOfUsage 16))
(declare-const BeInformedOfUsage2ConserveEnergyC Edge);Edge
(assert (= BeInformedOfUsage2ConserveEnergyC 17))
(declare-const BeInformedOfUsage2ConsumeEnergyC Edge);Edge
(assert (= BeInformedOfUsage2ConsumeEnergyC 18))
(declare-const DefinePolicies Node);Node
(assert (= DefinePolicies 19))
(declare-const DefinePolicies2ConserveEnergyC Edge);Edge
(assert (= DefinePolicies2ConserveEnergyC 20))
(declare-const DefinePolicies2ConsumeEnergyC Edge);Edge
(assert (= DefinePolicies2ConsumeEnergyC 21))
(declare-const ManageEncryptionKeys Node);Node
(assert (= ManageEncryptionKeys 22))
(declare-const ManageEncryptionKeys2ProtectPersonalInformationC Edge);Edge
(assert (= ManageEncryptionKeys2ProtectPersonalInformationC 23))
(declare-const ManageEncryptionKeys2SaveTimeC Edge);Edge
(assert (= ManageEncryptionKeys2SaveTimeC 24))
(declare-const EnergyManagementSystem Node);Node
(assert (= EnergyManagementSystem 25))
(declare-const ReduceCosts Node);Node
(assert (= ReduceCosts 26))
(declare-const StoreAndExecutePolicies Node);Node
(assert (= StoreAndExecutePolicies 27))
(declare-const DisplayData Node);Node
(assert (= DisplayData 28))
(declare-const CommunicateWithTheHouse Node);Node
(assert (= CommunicateWithTheHouse 29))
(declare-const CommunicateWithTheHouse2DisplayData Edge);Edge
(assert (= CommunicateWithTheHouse2DisplayData 30))
(declare-const CommunicateWithTheHouse2StoreAndExecutePolicies Edge);Edge
(assert (= CommunicateWithTheHouse2StoreAndExecutePolicies 31))
(declare-const ProtectPersonalInformationEMS Node);Node
(assert (= ProtectPersonalInformationEMS 32))
(declare-const SaveTimeEMS Node);Node
(assert (= SaveTimeEMS 33))
(declare-const ConserveEnergyEMS Node);Node
(assert (= ConserveEnergyEMS 34))
(declare-const ConserveEnergyEMS2ReduceCosts Edge);Edge
(assert (= ConserveEnergyEMS2ReduceCosts 35))
(declare-const ControlSmartAppliancesEMS Node);Node
(assert (= ControlSmartAppliancesEMS 36))
(declare-const ControlSmartAppliancesEMS2StoreAndExecutePolicies Edge);Edge
(assert (= ControlSmartAppliancesEMS2StoreAndExecutePolicies 37))
(declare-const Directly Node);Node
(assert (= Directly 38))
(declare-const Directly2ControlSmartAppliancesEMS Edge);Edge
(assert (= Directly2ControlSmartAppliancesEMS 39))
(declare-const Directly2SaveTimeEMS Edge);Edge
(assert (= Directly2SaveTimeEMS 40))
(declare-const Directly2HURTConserveEnergyEMS Edge);Edge
(assert (= Directly2HURTConserveEnergyEMS 41))
(declare-const Directly2HELPConserveEnergyEMS Edge);Edge
(assert (= Directly2HELPConserveEnergyEMS 42))
(declare-const Indirectly Node);Node
(assert (= Indirectly 43))
(declare-const Indirectly2ControlSmartAppliancesEMS Edge);Edge
(assert (= Indirectly2ControlSmartAppliancesEMS 44))
(declare-const Indirectly2SaveTimeEMS Edge);Edge
(assert (= Indirectly2SaveTimeEMS 45))
(declare-const HandleSecurity Node);Node
(assert (= HandleSecurity 46))
(declare-const HandleSecurity2CommunicateWithTheHouse Edge);Edge
(assert (= HandleSecurity2CommunicateWithTheHouse 47))
(declare-const EncryptData Node);Node
(assert (= EncryptData 48))
(declare-const EncryptData2HandleSecurity Edge);Edge
(assert (= EncryptData2HandleSecurity 49))
(declare-const EncryptData2MAKEProtectPersonalInformationEMS Edge);Edge
(assert (= EncryptData2MAKEProtectPersonalInformationEMS 50))
(declare-const EncryptData2HELPProtectPersonalInformationEMS Edge);Edge
(assert (= EncryptData2HELPProtectPersonalInformationEMS 51))
(declare-const NoEncryption Node);Node
(assert (= NoEncryption 52))
(declare-const NoEncryption2ReduceCosts Edge);Edge
(assert (= NoEncryption2ReduceCosts 53))
(declare-const NoEncryption2HandleSecurity Edge);Edge
(assert (= NoEncryption2HandleSecurity 54))
(declare-const HomeAreaNetworkEMS Node);Node
(assert (= HomeAreaNetworkEMS 55))
(declare-const HomeAreaNetworkEMS2CommunicateWithTheHouse Edge);Edge
(assert (= HomeAreaNetworkEMS2CommunicateWithTheHouse 56))
(declare-const HomeGatewayEMS Node);Node
(assert (= HomeGatewayEMS 57))
(declare-const HomeGatewayEMS2CommunicateWithTheHouse Edge);Edge
(assert (= HomeGatewayEMS2CommunicateWithTheHouse 58))
(declare-const MeterPointOperator Node);Node
(assert (= MeterPointOperator 59))
(declare-const HomeAreaNetwork Node);Node
(assert (= HomeAreaNetwork 60))
(declare-const HomeGateway Node);Node
(assert (= HomeGateway 61))
(declare-const SmartMeter Node);Node
(assert (= SmartMeter 62))
(declare-const EnergySupplierServer Node);Node
(assert (= EnergySupplierServer 63))
(declare-const StoreAggregatedBillingDataESS Node);Node
(assert (= StoreAggregatedBillingDataESS 64))
(declare-const ProvideAddedValueServices Node);Node
(assert (= ProvideAddedValueServices 65))
(declare-const AnotherServer Node);Node
(assert (= AnotherServer 66))
(declare-const StoreAggregatedBillingDataAS Node);Node
(assert (= StoreAggregatedBillingDataAS 67))
(declare-const ProtectPersonalInformation Node);Node
(assert (= ProtectPersonalInformation 68))
(declare-const ProtectPersonalInformationC2ProtectPersonalInformation Edge);Edge
(assert (= ProtectPersonalInformationC2ProtectPersonalInformation 69))
(declare-const ProtectPersonalInformation2ProtectPersonalInformationEMS Edge);Edge
(assert (= ProtectPersonalInformation2ProtectPersonalInformationEMS 70))
(declare-const SaveTime Node);Node
(assert (= SaveTime 71))
(declare-const SaveTimeC2SaveTime Edge);Edge
(assert (= SaveTimeC2SaveTime 72))
(declare-const SaveTime2SaveTimeEMS Edge);Edge
(assert (= SaveTime2SaveTimeEMS 73))
(declare-const ConserveEnergy Node);Node
(assert (= ConserveEnergy 74))
(declare-const ConserveEnergyC2ConserveEnergy Edge);Edge
(assert (= ConserveEnergyC2ConserveEnergy 75))
(declare-const ConserveEnergy2ConserveEnergyEMS Edge);Edge
(assert (= ConserveEnergy2ConserveEnergyEMS 76))
(declare-const Data Node);Node
(assert (= Data 77))
(declare-const BeInformedOfUsage2Data Edge);Edge
(assert (= BeInformedOfUsage2Data 78))
(declare-const Data2DisplayData Edge);Edge
(assert (= Data2DisplayData 79))
(declare-const BillingDataFeedback Node);Node
(assert (= BillingDataFeedback 80))
(declare-const BeInformedOfUsage2BillingDataFeedback Edge);Edge
(assert (= BeInformedOfUsage2BillingDataFeedback 81))
(declare-const BillingDataFeedback2DisplayData Edge);Edge
(assert (= BillingDataFeedback2DisplayData 82))
(declare-const Policies Node);Node
(assert (= Policies 83))
(declare-const StoreAndExecutePolicies2Policies Edge);Edge
(assert (= StoreAndExecutePolicies2Policies 84))
(declare-const Policies2DefinePolicies Edge);Edge
(assert (= Policies2DefinePolicies 85))
(declare-const EncryptionKeys1 Node);Node
(assert (= EncryptionKeys1 86))
(declare-const EncryptData2EncryptionKeys1 Edge);Edge
(assert (= EncryptData2EncryptionKeys1 87))
(declare-const EncryptionKeys12ManageEncryptionKeys Edge);Edge
(assert (= EncryptionKeys12ManageEncryptionKeys 88))
(declare-const EncryptionKeys2 Node);Node
(assert (= EncryptionKeys2 89))
(declare-const EncryptData2EncryptionKeys2 Edge);Edge
(assert (= EncryptData2EncryptionKeys2 90))
(declare-const EncryptionKeys22MeterPointOperator Edge);Edge
(assert (= EncryptionKeys22MeterPointOperator 91))
(declare-const UseHANToCommunicate Node);Node
(assert (= UseHANToCommunicate 92))
(declare-const CommunicateWithTheHouse2UseHANToCommunicate Edge);Edge
(assert (= CommunicateWithTheHouse2UseHANToCommunicate 93))
(declare-const UseHANToCommunicate2HomeAreaNetwork Edge);Edge
(assert (= UseHANToCommunicate2HomeAreaNetwork 94))
(declare-const UseHGToCommunicate Node);Node
(assert (= UseHGToCommunicate 95))
(declare-const CommunicateWithTheHouse2UseHGToCommunicate Edge);Edge
(assert (= CommunicateWithTheHouse2UseHGToCommunicate 96))
(declare-const UseHGToCommunicate2HomeGateway Edge);Edge
(assert (= UseHGToCommunicate2HomeGateway 97))
(declare-const OtherData Node);Node
(assert (= OtherData 98))
(declare-const ProvideAddedValueServices2OtherData Edge);Edge
(assert (= ProvideAddedValueServices2OtherData 99))
(declare-const OtherData2HomeGateway Edge);Edge
(assert (= OtherData2HomeGateway 100))
(declare-const AggregatedBillingData Node);Node
(assert (= AggregatedBillingData 101))
(declare-const StoreAggregatedBillingDataESS2AggregatedBillingData Edge);Edge
(assert (= StoreAggregatedBillingDataESS2AggregatedBillingData 102))
(declare-const StoreAggregatedBillingDataAS2AggregatedBillingData Edge);Edge
(assert (= StoreAggregatedBillingDataAS2AggregatedBillingData 103))
(declare-const AggregatedBillingData2SmartMeter Edge);Edge
(assert (= AggregatedBillingData2SmartMeter 104))
(declare-const ControlSmartAppliances Node);Node
(assert (= ControlSmartAppliances 105))
(declare-const Indirectly2ControlSmartAppliances Edge);Edge
(assert (= Indirectly2ControlSmartAppliances 106))
(declare-const ControlSmartAppliances2SmartMeter Edge);Edge
(assert (= ControlSmartAppliances2SmartMeter 107))
(declare-const BillingData Node);Node
(assert (= BillingData 108))
(declare-const DisplayData2BillingData Edge);Edge
(assert (= DisplayData2BillingData 109))
(declare-const BillingData2SmartMeter Edge);Edge
(assert (= BillingData2SmartMeter 110))
;End Model
(assert (forall ((c Contribution)) (=>
	(edge BeInformedOfUsage2ConserveEnergyC c)
	(and
		(= (srcType c) GOAL)
		(= (tgtType c) SOFTGOAL)
		(node BeInformedOfUsage ((as src (Goal)) c))
		(node ConserveEnergyC ((as tgt (SoftGoal)) c))
	)
)))
(assert (forall ((c Decomposition)) (=>
	(edge BeInformedOfUsage2ConsumeEnergyC c)
	(and
		(= (srcType c) GOAL)
		(= (tgtType c) GOAL)
		(node BeInformedOfUsage ((as src (Goal)) c))
		(node ConsumeEnergyC ((as tgt (Goal)) c))
	)
)))
(assert (forall ((c Contribution)) (=>
	(edge DefinePolicies2ConserveEnergyC c)
	(and
		(= (srcType c) TASK)
		(= (tgtType c) SOFTGOAL)
		(node DefinePolicies ((as src (Task)) c))
		(node ConserveEnergyC ((as tgt (SoftGoal)) c))
	)
)))
(assert (forall ((c Decomposition)) (=>
	(edge DefinePolicies2ConsumeEnergyC c)
	(and
		(= (srcType c) TASK)
		(= (tgtType c) GOAL)
		(node DefinePolicies ((as src (Task)) c))
		(node ConsumeEnergyC ((as tgt (Goal)) c))
	)
)))
(assert (forall ((c Contribution)) (=>
	(edge ManageEncryptionKeys2ProtectPersonalInformationC c)
	(and
		(= (srcType c) TASK)
		(= (tgtType c) SOFTGOAL)
		(node ManageEncryptionKeys ((as src (Task)) c))
		(node ProtectPersonalInformationC ((as tgt (SoftGoal)) c))
	)
)))
(assert (forall ((c Contribution)) (=>
	(edge ManageEncryptionKeys2SaveTimeC c)
	(and
		(= (srcType c) TASK)
		(= (tgtType c) SOFTGOAL)
		(node ManageEncryptionKeys ((as src (Task)) c))
		(node SaveTimeC ((as tgt (SoftGoal)) c))
	)
)))
(assert (forall ((c Decomposition)) (=>
	(edge CommunicateWithTheHouse2DisplayData c)
	(and
		(= (srcType c) GOAL)
		(= (tgtType c) TASK)
		(node CommunicateWithTheHouse ((as src (Goal)) c))
		(node DisplayData ((as tgt (Task)) c))
	)
)))
(assert (forall ((c Decomposition)) (=>
	(edge CommunicateWithTheHouse2StoreAndExecutePolicies c)
	(and
		(= (srcType c) GOAL)
		(= (tgtType c) GOAL)
		(node CommunicateWithTheHouse ((as src (Goal)) c))
		(node StoreAndExecutePolicies ((as tgt (Goal)) c))
	)
)))
(assert (forall ((c Contribution)) (=>
	(edge ConserveEnergyEMS2ReduceCosts c)
	(and
		(= (srcType c) SOFTGOAL)
		(= (tgtType c) SOFTGOAL)
		(node ConserveEnergyEMS ((as src (SoftGoal)) c))
		(node ReduceCosts ((as tgt (SoftGoal)) c))
	)
)))
(assert (forall ((c Decomposition)) (=>
	(edge ControlSmartAppliancesEMS2StoreAndExecutePolicies c)
	(and
		(= (srcType c) GOAL)
		(= (tgtType c) GOAL)
		(node ControlSmartAppliancesEMS ((as src (Goal)) c))
		(node StoreAndExecutePolicies ((as tgt (Goal)) c))
	)
)))
(assert (forall ((c MeansEnd)) (=>
	(edge Directly2ControlSmartAppliancesEMS c)
	(and
		(= (srcType c) TASK)
		(= (tgtType c) GOAL)
		(node Directly ((as src (Task)) c))
		(node ControlSmartAppliancesEMS ((as tgt (Goal)) c))
	)
)))
(assert (forall ((c Contribution)) (=>
	(edge Directly2SaveTimeEMS c)
	(and
		(= (srcType c) TASK)
		(= (tgtType c) SOFTGOAL)
		(node Directly ((as src (Task)) c))
		(node SaveTimeEMS ((as tgt (SoftGoal)) c))
	)
)))
(assert (forall ((c Contribution)) (=>
	(edge Directly2HURTConserveEnergyEMS c)
	(and
		(= (srcType c) TASK)
		(= (tgtType c) SOFTGOAL)
		(node Directly ((as src (Task)) c))
		(node ConserveEnergyEMS ((as tgt (SoftGoal)) c))
	)
)))
(assert (forall ((c Contribution)) (=>
	(edge Directly2HELPConserveEnergyEMS c)
	(and
		(= (srcType c) TASK)
		(= (tgtType c) SOFTGOAL)
		(node Directly ((as src (Task)) c))
		(node ConserveEnergyEMS ((as tgt (SoftGoal)) c))
	)
)))
(assert (forall ((c MeansEnd)) (=>
	(edge Indirectly2ControlSmartAppliancesEMS c)
	(and
		(= (srcType c) TASK)
		(= (tgtType c) GOAL)
		(node Indirectly ((as src (Task)) c))
		(node ControlSmartAppliancesEMS ((as tgt (Goal)) c))
	)
)))
(assert (forall ((c Contribution)) (=>
	(edge Indirectly2SaveTimeEMS c)
	(and
		(= (srcType c) TASK)
		(= (tgtType c) SOFTGOAL)
		(node Indirectly ((as src (Task)) c))
		(node SaveTimeEMS ((as tgt (SoftGoal)) c))
	)
)))
(assert (forall ((c Decomposition)) (=>
	(edge HandleSecurity2CommunicateWithTheHouse c)
	(and
		(= (srcType c) GOAL)
		(= (tgtType c) GOAL)
		(node HandleSecurity ((as src (Goal)) c))
		(node CommunicateWithTheHouse ((as tgt (Goal)) c))
	)
)))
(assert (forall ((c MeansEnd)) (=>
	(edge EncryptData2HandleSecurity c)
	(and
		(= (srcType c) TASK)
		(= (tgtType c) GOAL)
		(node EncryptData ((as src (Task)) c))
		(node HandleSecurity ((as tgt (Goal)) c))
	)
)))
(assert (forall ((c Contribution)) (=>
	(edge EncryptData2MAKEProtectPersonalInformationEMS c)
	(and
		(= (srcType c) TASK)
		(= (tgtType c) SOFTGOAL)
		(node EncryptData ((as src (Task)) c))
		(node ProtectPersonalInformationEMS ((as tgt (SoftGoal)) c))
	)
)))
(assert (forall ((c Contribution)) (=>
	(edge EncryptData2HELPProtectPersonalInformationEMS c)
	(and
		(= (srcType c) TASK)
		(= (tgtType c) SOFTGOAL)
		(node EncryptData ((as src (Task)) c))
		(node ProtectPersonalInformationEMS ((as tgt (SoftGoal)) c))
	)
)))
(assert (forall ((c Contribution)) (=>
	(edge NoEncryption2ReduceCosts c)
	(and
		(= (srcType c) TASK)
		(= (tgtType c) SOFTGOAL)
		(node NoEncryption ((as src (Task)) c))
		(node ReduceCosts ((as tgt (SoftGoal)) c))
	)
)))
(assert (forall ((c MeansEnd)) (=>
	(edge NoEncryption2HandleSecurity c)
	(and
		(= (srcType c) TASK)
		(= (tgtType c) GOAL)
		(node NoEncryption ((as src (Task)) c))
		(node HandleSecurity ((as tgt (Goal)) c))
	)
)))
(assert (forall ((c Decomposition)) (=>
	(edge HomeAreaNetworkEMS2CommunicateWithTheHouse c)
	(and
		(= (srcType c) RESOURCE)
		(= (tgtType c) GOAL)
		(node HomeAreaNetworkEMS ((as src (Resource)) c))
		(node CommunicateWithTheHouse ((as tgt (Goal)) c))
	)
)))
(assert (forall ((c Decomposition)) (=>
	(edge HomeGatewayEMS2CommunicateWithTheHouse c)
	(and
		(= (srcType c) RESOURCE)
		(= (tgtType c) GOAL)
		(node HomeGatewayEMS ((as src (Resource)) c))
		(node CommunicateWithTheHouse ((as tgt (Goal)) c))
	)
)))
(assert (forall ((c DependerLink)) (=>
	(edge ProtectPersonalInformationC2ProtectPersonalInformation c)
	(and
		(= (srcType c) SOFTGOAL)
		(= (tgtType c) SOFTGOAL)
		(node ProtectPersonalInformationC ((as src (SoftGoal)) c))
		(node ProtectPersonalInformation ((as tgt (SoftGoal)) c))
	)
)))
(assert (forall ((c DependeeLink)) (=>
	(edge ProtectPersonalInformation2ProtectPersonalInformationEMS c)
	(and
		(= (srcType c) SOFTGOAL)
		(= (tgtType c) SOFTGOAL)
		(node ProtectPersonalInformation ((as src (SoftGoal)) c))
		(node ProtectPersonalInformationEMS ((as tgt (SoftGoal)) c))
	)
)))
(assert (forall ((c DependerLink)) (=>
	(edge SaveTimeC2SaveTime c)
	(and
		(= (srcType c) SOFTGOAL)
		(= (tgtType c) SOFTGOAL)
		(node SaveTimeC ((as src (SoftGoal)) c))
		(node SaveTime ((as tgt (SoftGoal)) c))
	)
)))
(assert (forall ((c DependeeLink)) (=>
	(edge SaveTime2SaveTimeEMS c)
	(and
		(= (srcType c) SOFTGOAL)
		(= (tgtType c) SOFTGOAL)
		(node SaveTime ((as src (SoftGoal)) c))
		(node SaveTimeEMS ((as tgt (SoftGoal)) c))
	)
)))
(assert (forall ((c DependerLink)) (=>
	(edge ConserveEnergyC2ConserveEnergy c)
	(and
		(= (srcType c) SOFTGOAL)
		(= (tgtType c) SOFTGOAL)
		(node ConserveEnergyC ((as src (SoftGoal)) c))
		(node ConserveEnergy ((as tgt (SoftGoal)) c))
	)
)))
(assert (forall ((c DependeeLink)) (=>
	(edge ConserveEnergy2ConserveEnergyEMS c)
	(and
		(= (srcType c) SOFTGOAL)
		(= (tgtType c) SOFTGOAL)
		(node ConserveEnergy ((as src (SoftGoal)) c))
		(node ConserveEnergyEMS ((as tgt (SoftGoal)) c))
	)
)))
(assert (forall ((c DependerLink)) (=>
	(edge BeInformedOfUsage2Data c)
	(and
		(= (srcType c) GOAL)
		(= (tgtType c) RESOURCE)
		(node BeInformedOfUsage ((as src (Goal)) c))
		(node Data ((as tgt (Resource)) c))
	)
)))
(assert (forall ((c DependeeLink)) (=>
	(edge Data2DisplayData c)
	(and
		(= (srcType c) RESOURCE)
		(= (tgtType c) TASK)
		(node Data ((as src (Resource)) c))
		(node DisplayData ((as tgt (Task)) c))
	)
)))
(assert (forall ((c DependerLink)) (=>
	(edge BeInformedOfUsage2BillingDataFeedback c)
	(and
		(= (srcType c) GOAL)
		(= (tgtType c) RESOURCE)
		(node BeInformedOfUsage ((as src (Goal)) c))
		(node BillingDataFeedback ((as tgt (Resource)) c))
	)
)))
(assert (forall ((c DependeeLink)) (=>
	(edge BillingDataFeedback2DisplayData c)
	(and
		(= (srcType c) RESOURCE)
		(= (tgtType c) TASK)
		(node BillingDataFeedback ((as src (Resource)) c))
		(node DisplayData ((as tgt (Task)) c))
	)
)))
(assert (forall ((c DependerLink)) (=>
	(edge StoreAndExecutePolicies2Policies c)
	(and
		(= (srcType c) GOAL)
		(= (tgtType c) RESOURCE)
		(node StoreAndExecutePolicies ((as src (Goal)) c))
		(node Policies ((as tgt (Resource)) c))
	)
)))
(assert (forall ((c DependeeLink)) (=>
	(edge Policies2DefinePolicies c)
	(and
		(= (srcType c) RESOURCE)
		(= (tgtType c) TASK)
		(node Policies ((as src (Resource)) c))
		(node DefinePolicies ((as tgt (Task)) c))
	)
)))
(assert (forall ((c DependerLink)) (=>
	(edge EncryptData2EncryptionKeys1 c)
	(and
		(= (srcType c) TASK)
		(= (tgtType c) RESOURCE)
		(node EncryptData ((as src (Task)) c))
		(node EncryptionKeys1 ((as tgt (Resource)) c))
	)
)))
(assert (forall ((c DependeeLink)) (=>
	(edge EncryptionKeys12ManageEncryptionKeys c)
	(and
		(= (srcType c) RESOURCE)
		(= (tgtType c) TASK)
		(node EncryptionKeys1 ((as src (Resource)) c))
		(node ManageEncryptionKeys ((as tgt (Task)) c))
	)
)))
(assert (forall ((c DependerLink)) (=>
	(edge EncryptData2EncryptionKeys2 c)
	(and
		(= (srcType c) TASK)
		(= (tgtType c) RESOURCE)
		(node EncryptData ((as src (Task)) c))
		(node EncryptionKeys2 ((as tgt (Resource)) c))
	)
)))
(assert (forall ((c DependeeLink)) (=>
	(edge EncryptionKeys22MeterPointOperator c)
	(and
		(= (srcType c) RESOURCE)
		(= (tgtType c) ACTOR)
		(node EncryptionKeys2 ((as src (Resource)) c))
		(node MeterPointOperator ((as tgt (Actor)) c))
	)
)))
(assert (forall ((c DependerLink)) (=>
	(edge CommunicateWithTheHouse2UseHANToCommunicate c)
	(and
		(= (srcType c) GOAL)
		(= (tgtType c) GOAL)
		(node CommunicateWithTheHouse ((as src (Goal)) c))
		(node UseHANToCommunicate ((as tgt (Goal)) c))
	)
)))
(assert (forall ((c DependeeLink)) (=>
	(edge UseHANToCommunicate2HomeAreaNetwork c)
	(and
		(= (srcType c) GOAL)
		(= (tgtType c) ACTOR)
		(node UseHANToCommunicate ((as src (Goal)) c))
		(node HomeAreaNetwork ((as tgt (Actor)) c))
	)
)))
(assert (forall ((c DependerLink)) (=>
	(edge CommunicateWithTheHouse2UseHGToCommunicate c)
	(and
		(= (srcType c) GOAL)
		(= (tgtType c) GOAL)
		(node CommunicateWithTheHouse ((as src (Goal)) c))
		(node UseHGToCommunicate ((as tgt (Goal)) c))
	)
)))
(assert (forall ((c DependeeLink)) (=>
	(edge UseHGToCommunicate2HomeGateway c)
	(and
		(= (srcType c) GOAL)
		(= (tgtType c) ACTOR)
		(node UseHGToCommunicate ((as src (Goal)) c))
		(node HomeGateway ((as tgt (Actor)) c))
	)
)))
(assert (forall ((c DependerLink)) (=>
	(edge ProvideAddedValueServices2OtherData c)
	(and
		(= (srcType c) GOAL)
		(= (tgtType c) RESOURCE)
		(node ProvideAddedValueServices ((as src (Goal)) c))
		(node OtherData ((as tgt (Resource)) c))
	)
)))
(assert (forall ((c DependeeLink)) (=>
	(edge OtherData2HomeGateway c)
	(and
		(= (srcType c) RESOURCE)
		(= (tgtType c) ACTOR)
		(node OtherData ((as src (Resource)) c))
		(node HomeGateway ((as tgt (Actor)) c))
	)
)))
(assert (forall ((c DependerLink)) (=>
	(edge StoreAggregatedBillingDataESS2AggregatedBillingData c)
	(and
		(= (srcType c) GOAL)
		(= (tgtType c) RESOURCE)
		(node StoreAggregatedBillingDataESS ((as src (Goal)) c))
		(node AggregatedBillingData ((as tgt (Resource)) c))
	)
)))
(assert (forall ((c DependerLink)) (=>
	(edge StoreAggregatedBillingDataAS2AggregatedBillingData c)
	(and
		(= (srcType c) GOAL)
		(= (tgtType c) RESOURCE)
		(node StoreAggregatedBillingDataAS ((as src (Goal)) c))
		(node AggregatedBillingData ((as tgt (Resource)) c))
	)
)))
(assert (forall ((c DependeeLink)) (=>
	(edge AggregatedBillingData2SmartMeter c)
	(and
		(= (srcType c) RESOURCE)
		(= (tgtType c) ACTOR)
		(node AggregatedBillingData ((as src (Resource)) c))
		(node SmartMeter ((as tgt (Actor)) c))
	)
)))
(assert (forall ((c DependerLink)) (=>
	(edge Indirectly2ControlSmartAppliances c)
	(and
		(= (srcType c) TASK)
		(= (tgtType c) GOAL)
		(node Indirectly ((as src (Task)) c))
		(node ControlSmartAppliances ((as tgt (Goal)) c))
	)
)))
(assert (forall ((c DependeeLink)) (=>
	(edge ControlSmartAppliances2SmartMeter c)
	(and
		(= (srcType c) GOAL)
		(= (tgtType c) ACTOR)
		(node ControlSmartAppliances ((as src (Goal)) c))
		(node SmartMeter ((as tgt (Actor)) c))
	)
)))
(assert (forall ((c DependerLink)) (=>
	(edge DisplayData2BillingData c)
	(and
		(= (srcType c) TASK)
		(= (tgtType c) RESOURCE)
		(node DisplayData ((as src (Task)) c))
		(node BillingData ((as tgt (Resource)) c))
	)
)))
(assert (forall ((c DependeeLink)) (=>
	(edge BillingData2SmartMeter c)
	(and
		(= (srcType c) RESOURCE)
		(= (tgtType c) ACTOR)
		(node BillingData ((as src (Resource)) c))
		(node SmartMeter ((as tgt (Actor)) c))
	)
)))

;Model is Complete
(assert	(forall ((c Actor)) (or
	(node Consumer c)
	(node EnergyManagementSystem c)
	(node MeterPointOperator c)
	(node HomeAreaNetwork c)
	(node HomeGateway c)
	(node SmartMeter c)
	(node EnergySupplierServer c)
	(node AnotherServer c)
)))
(assert	(forall ((c Task)) (or
	(node DefinePolicies c)
	(node ManageEncryptionKeys c)
	(node DisplayData c)
	(node Directly c)
	(node Indirectly c)
	(node EncryptData c)
	(node NoEncryption c)
)))
(assert	(forall ((c Resource)) (or
	(node HomeAreaNetworkEMS c)
	(node HomeGatewayEMS c)
	(node Data c)
	(node BillingDataFeedback c)
	(node Policies c)
	(node EncryptionKeys1 c)
	(node EncryptionKeys2 c)
	(node OtherData c)
	(node AggregatedBillingData c)
	(node BillingData c)
)))
(assert	(forall ((c Goal)) (or
	(node ConsumeEnergyC c)
	(node BeInformedOfUsage c)
	(node StoreAndExecutePolicies c)
	(node CommunicateWithTheHouse c)
	(node ControlSmartAppliancesEMS c)
	(node HandleSecurity c)
	(node StoreAggregatedBillingDataESS c)
	(node ProvideAddedValueServices c)
	(node StoreAggregatedBillingDataAS c)
	(node UseHANToCommunicate c)
	(node UseHGToCommunicate c)
	(node ControlSmartAppliances c)
)))
(assert	(forall ((c SoftGoal)) (or
	(node ProtectPersonalInformationC c)
	(node ConserveEnergyC c)
	(node SaveTimeC c)
	(node ReduceCosts c)
	(node ProtectPersonalInformationEMS c)
	(node SaveTimeEMS c)
	(node ConserveEnergyEMS c)
	(node ProtectPersonalInformation c)
	(node SaveTime c)
	(node ConserveEnergy c)
)))
(assert	(forall ((c MeansEnd)) (or
	(edge Directly2ControlSmartAppliancesEMS c)
	(edge Indirectly2ControlSmartAppliancesEMS c)
	(edge EncryptData2HandleSecurity c)
	(edge NoEncryption2HandleSecurity c)
)))
(assert	(forall ((c Decomposition)) (or
	(edge BeInformedOfUsage2ConsumeEnergyC c)
	(edge DefinePolicies2ConsumeEnergyC c)
	(edge CommunicateWithTheHouse2DisplayData c)
	(edge CommunicateWithTheHouse2StoreAndExecutePolicies c)
	(edge ControlSmartAppliancesEMS2StoreAndExecutePolicies c)
	(edge HandleSecurity2CommunicateWithTheHouse c)
	(edge HomeAreaNetworkEMS2CommunicateWithTheHouse c)
	(edge HomeGatewayEMS2CommunicateWithTheHouse c)
)))
(assert	(forall ((c Contribution)) (or
	(edge BeInformedOfUsage2ConserveEnergyC c)
	(edge DefinePolicies2ConserveEnergyC c)
	(edge ManageEncryptionKeys2ProtectPersonalInformationC c)
	(edge ManageEncryptionKeys2SaveTimeC c)
	(edge ConserveEnergyEMS2ReduceCosts c)
	(edge Directly2SaveTimeEMS c)
	(edge Directly2HURTConserveEnergyEMS c)
	(edge Directly2HELPConserveEnergyEMS c)
	(edge Indirectly2SaveTimeEMS c)
	(edge EncryptData2MAKEProtectPersonalInformationEMS c)
	(edge EncryptData2HELPProtectPersonalInformationEMS c)
	(edge NoEncryption2ReduceCosts c)
)))
(assert	(forall ((c DependerLink)) (or
	(edge ProtectPersonalInformationC2ProtectPersonalInformation c)
	(edge SaveTimeC2SaveTime c)
	(edge ConserveEnergyC2ConserveEnergy c)
	(edge BeInformedOfUsage2Data c)
	(edge BeInformedOfUsage2BillingDataFeedback c)
	(edge StoreAndExecutePolicies2Policies c)
	(edge EncryptData2EncryptionKeys1 c)
	(edge EncryptData2EncryptionKeys2 c)
	(edge CommunicateWithTheHouse2UseHANToCommunicate c)
	(edge CommunicateWithTheHouse2UseHGToCommunicate c)
	(edge ProvideAddedValueServices2OtherData c)
	(edge StoreAggregatedBillingDataESS2AggregatedBillingData c)
	(edge StoreAggregatedBillingDataAS2AggregatedBillingData c)
	(edge Indirectly2ControlSmartAppliances c)
	(edge DisplayData2BillingData c)
)))
(assert	(forall ((c DependeeLink)) (or
	(edge ProtectPersonalInformation2ProtectPersonalInformationEMS c)
	(edge SaveTime2SaveTimeEMS c)
	(edge ConserveEnergy2ConserveEnergyEMS c)
	(edge Data2DisplayData c)
	(edge BillingDataFeedback2DisplayData c)
	(edge Policies2DefinePolicies c)
	(edge EncryptionKeys12ManageEncryptionKeys c)
	(edge EncryptionKeys22MeterPointOperator c)
	(edge UseHANToCommunicate2HomeAreaNetwork c)
	(edge UseHGToCommunicate2HomeGateway c)
	(edge OtherData2HomeGateway c)
	(edge AggregatedBillingData2SmartMeter c)
	(edge ControlSmartAppliances2SmartMeter c)
	(edge BillingData2SmartMeter c)
)))
;Consumer Exists
(assert (exists ((c Actor)) (node Consumer c)))
;Consumer is Unique
(assert	(forall ((c1 Actor) (c2 Actor)) (=>
	(and (node Consumer c1) (node Consumer c2))
	(= c1 c2)
)))
;Consumer is Distinct
(assert	(forall ((c Actor)) (=>
	(node Consumer c)
	(not (or
		(node EnergyManagementSystem c)
		(node MeterPointOperator c)
		(node HomeAreaNetwork c)
		(node HomeGateway c)
		(node SmartMeter c)
	))
)))
;ProtectPersonalInformationC Exists
(assert (exists ((c SoftGoal)) (node ProtectPersonalInformationC c)))
;ProtectPersonalInformationC is Unique
(assert	(forall ((c1 SoftGoal) (c2 SoftGoal)) (=>
	(and (node ProtectPersonalInformationC c1) (node ProtectPersonalInformationC c2))
	(= c1 c2)
)))
;ProtectPersonalInformationC is Distinct
(assert	(forall ((c SoftGoal)) (=>
	(node ProtectPersonalInformationC c)
	(not (or
		(node ConserveEnergyC c)
		(node SaveTimeC c)
		(node ReduceCosts c)
		(node ProtectPersonalInformationEMS c)
		(node SaveTimeEMS c)
		(node ConserveEnergyEMS c)
		(node ProtectPersonalInformation c)
		(node SaveTime c)
		(node ConserveEnergy c)
	))
)))
;ConserveEnergyC Exists
(assert (exists ((c SoftGoal)) (node ConserveEnergyC c)))
;ConserveEnergyC is Unique
(assert	(forall ((c1 SoftGoal) (c2 SoftGoal)) (=>
	(and (node ConserveEnergyC c1) (node ConserveEnergyC c2))
	(= c1 c2)
)))
;ConserveEnergyC is Distinct
(assert	(forall ((c SoftGoal)) (=>
	(node ConserveEnergyC c)
	(not (or
		(node ProtectPersonalInformationC c)
		(node SaveTimeC c)
		(node ReduceCosts c)
		(node ProtectPersonalInformationEMS c)
		(node SaveTimeEMS c)
		(node ConserveEnergyEMS c)
		(node ProtectPersonalInformation c)
		(node SaveTime c)
		(node ConserveEnergy c)
	))
)))
;SaveTimeC Exists
(assert (exists ((c SoftGoal)) (node SaveTimeC c)))
;SaveTimeC is Unique
(assert	(forall ((c1 SoftGoal) (c2 SoftGoal)) (=>
	(and (node SaveTimeC c1) (node SaveTimeC c2))
	(= c1 c2)
)))
;SaveTimeC is Distinct
(assert	(forall ((c SoftGoal)) (=>
	(node SaveTimeC c)
	(not (or
		(node ProtectPersonalInformationC c)
		(node ConserveEnergyC c)
		(node ReduceCosts c)
		(node ProtectPersonalInformationEMS c)
		(node SaveTimeEMS c)
		(node ConserveEnergyEMS c)
		(node ProtectPersonalInformation c)
		(node SaveTime c)
		(node ConserveEnergy c)
	))
)))
;ConsumeEnergyC Exists
(assert (exists ((c Goal)) (node ConsumeEnergyC c)))
;ConsumeEnergyC is Unique
(assert	(forall ((c1 Goal) (c2 Goal)) (=>
	(and (node ConsumeEnergyC c1) (node ConsumeEnergyC c2))
	(= c1 c2)
)))
;ConsumeEnergyC is Distinct
(assert	(forall ((c Goal)) (=>
	(node ConsumeEnergyC c)
	(not (or
		(node BeInformedOfUsage c)
		(node StoreAndExecutePolicies c)
		(node CommunicateWithTheHouse c)
		(node ControlSmartAppliancesEMS c)
		(node HandleSecurity c)
		(node ProvideAddedValueServices c)
		(node UseHANToCommunicate c)
		(node UseHGToCommunicate c)
		(node ControlSmartAppliances c)
	))
)))
;BeInformedOfUsage Exists
(assert (exists ((c Goal)) (node BeInformedOfUsage c)))
;BeInformedOfUsage is Unique
(assert	(forall ((c1 Goal) (c2 Goal)) (=>
	(and (node BeInformedOfUsage c1) (node BeInformedOfUsage c2))
	(= c1 c2)
)))
;BeInformedOfUsage is Distinct
(assert	(forall ((c Goal)) (=>
	(node BeInformedOfUsage c)
	(not (or
		(node ConsumeEnergyC c)
		(node StoreAndExecutePolicies c)
		(node CommunicateWithTheHouse c)
		(node ControlSmartAppliancesEMS c)
		(node HandleSecurity c)
		(node ProvideAddedValueServices c)
		(node UseHANToCommunicate c)
		(node UseHGToCommunicate c)
		(node ControlSmartAppliances c)
	))
)))
;BeInformedOfUsage2ConserveEnergyC Exists
(assert (exists ((c Contribution)) (edge BeInformedOfUsage2ConserveEnergyC c)))
;BeInformedOfUsage2ConserveEnergyC is Unique
(assert	(forall ((c1 Contribution) (c2 Contribution)) (=>
	(and (edge BeInformedOfUsage2ConserveEnergyC c1) (edge BeInformedOfUsage2ConserveEnergyC c2))
	(= c1 c2)
)))
;BeInformedOfUsage2ConserveEnergyC is Distinct
(assert	(forall ((c Contribution)) (=>
	(edge BeInformedOfUsage2ConserveEnergyC c)
	(not (or
		(edge DefinePolicies2ConserveEnergyC c)
		(edge ManageEncryptionKeys2ProtectPersonalInformationC c)
		(edge ManageEncryptionKeys2SaveTimeC c)
		(edge ConserveEnergyEMS2ReduceCosts c)
		(edge Directly2SaveTimeEMS c)
		(edge Directly2HURTConserveEnergyEMS c)
		(edge Directly2HELPConserveEnergyEMS c)
		(edge Indirectly2SaveTimeEMS c)
		(edge EncryptData2MAKEProtectPersonalInformationEMS c)
		(edge EncryptData2HELPProtectPersonalInformationEMS c)
		(edge NoEncryption2ReduceCosts c)
	))
)))
;BeInformedOfUsage2ConsumeEnergyC Exists
(assert (exists ((c Decomposition)) (edge BeInformedOfUsage2ConsumeEnergyC c)))
;BeInformedOfUsage2ConsumeEnergyC is Unique
(assert	(forall ((c1 Decomposition) (c2 Decomposition)) (=>
	(and (edge BeInformedOfUsage2ConsumeEnergyC c1) (edge BeInformedOfUsage2ConsumeEnergyC c2))
	(= c1 c2)
)))
;BeInformedOfUsage2ConsumeEnergyC is Distinct
(assert	(forall ((c Decomposition)) (=>
	(edge BeInformedOfUsage2ConsumeEnergyC c)
	(not (or
		(edge DefinePolicies2ConsumeEnergyC c)
		(edge CommunicateWithTheHouse2DisplayData c)
		(edge CommunicateWithTheHouse2StoreAndExecutePolicies c)
		(edge ControlSmartAppliancesEMS2StoreAndExecutePolicies c)
		(edge HandleSecurity2CommunicateWithTheHouse c)
		(edge HomeAreaNetworkEMS2CommunicateWithTheHouse c)
		(edge HomeGatewayEMS2CommunicateWithTheHouse c)
	))
)))
;DefinePolicies Exists
(assert (exists ((c Task)) (node DefinePolicies c)))
;DefinePolicies is Unique
(assert	(forall ((c1 Task) (c2 Task)) (=>
	(and (node DefinePolicies c1) (node DefinePolicies c2))
	(= c1 c2)
)))
;DefinePolicies is Distinct
(assert	(forall ((c Task)) (=>
	(node DefinePolicies c)
	(not (or
		(node ManageEncryptionKeys c)
		(node DisplayData c)
		(node Directly c)
		(node Indirectly c)
		(node EncryptData c)
		(node NoEncryption c)
	))
)))
;DefinePolicies2ConserveEnergyC Exists
(assert (exists ((c Contribution)) (edge DefinePolicies2ConserveEnergyC c)))
;DefinePolicies2ConserveEnergyC is Unique
(assert	(forall ((c1 Contribution) (c2 Contribution)) (=>
	(and (edge DefinePolicies2ConserveEnergyC c1) (edge DefinePolicies2ConserveEnergyC c2))
	(= c1 c2)
)))
;DefinePolicies2ConserveEnergyC is Distinct
(assert	(forall ((c Contribution)) (=>
	(edge DefinePolicies2ConserveEnergyC c)
	(not (or
		(edge BeInformedOfUsage2ConserveEnergyC c)
		(edge ManageEncryptionKeys2ProtectPersonalInformationC c)
		(edge ManageEncryptionKeys2SaveTimeC c)
		(edge ConserveEnergyEMS2ReduceCosts c)
		(edge Directly2SaveTimeEMS c)
		(edge Directly2HURTConserveEnergyEMS c)
		(edge Directly2HELPConserveEnergyEMS c)
		(edge Indirectly2SaveTimeEMS c)
		(edge EncryptData2MAKEProtectPersonalInformationEMS c)
		(edge EncryptData2HELPProtectPersonalInformationEMS c)
		(edge NoEncryption2ReduceCosts c)
	))
)))
;DefinePolicies2ConsumeEnergyC Exists
(assert (exists ((c Decomposition)) (edge DefinePolicies2ConsumeEnergyC c)))
;DefinePolicies2ConsumeEnergyC is Unique
(assert	(forall ((c1 Decomposition) (c2 Decomposition)) (=>
	(and (edge DefinePolicies2ConsumeEnergyC c1) (edge DefinePolicies2ConsumeEnergyC c2))
	(= c1 c2)
)))
;DefinePolicies2ConsumeEnergyC is Distinct
(assert	(forall ((c Decomposition)) (=>
	(edge DefinePolicies2ConsumeEnergyC c)
	(not (or
		(edge BeInformedOfUsage2ConsumeEnergyC c)
		(edge CommunicateWithTheHouse2DisplayData c)
		(edge CommunicateWithTheHouse2StoreAndExecutePolicies c)
		(edge ControlSmartAppliancesEMS2StoreAndExecutePolicies c)
		(edge HandleSecurity2CommunicateWithTheHouse c)
		(edge HomeAreaNetworkEMS2CommunicateWithTheHouse c)
		(edge HomeGatewayEMS2CommunicateWithTheHouse c)
	))
)))
;ManageEncryptionKeys is Unique
(assert	(forall ((c1 Task) (c2 Task)) (=>
	(and (node ManageEncryptionKeys c1) (node ManageEncryptionKeys c2))
	(= c1 c2)
)))
;ManageEncryptionKeys is Distinct
(assert	(forall ((c Task)) (=>
	(node ManageEncryptionKeys c)
	(not (or
		(node DefinePolicies c)
		(node DisplayData c)
		(node Directly c)
		(node Indirectly c)
		(node EncryptData c)
		(node NoEncryption c)
	))
)))
;ManageEncryptionKeys2ProtectPersonalInformationC is Unique
(assert	(forall ((c1 Contribution) (c2 Contribution)) (=>
	(and (edge ManageEncryptionKeys2ProtectPersonalInformationC c1) (edge ManageEncryptionKeys2ProtectPersonalInformationC c2))
	(= c1 c2)
)))
;ManageEncryptionKeys2ProtectPersonalInformationC is Distinct
(assert	(forall ((c Contribution)) (=>
	(edge ManageEncryptionKeys2ProtectPersonalInformationC c)
	(not (or
		(edge BeInformedOfUsage2ConserveEnergyC c)
		(edge DefinePolicies2ConserveEnergyC c)
		(edge ManageEncryptionKeys2SaveTimeC c)
		(edge ConserveEnergyEMS2ReduceCosts c)
		(edge Directly2SaveTimeEMS c)
		(edge Directly2HURTConserveEnergyEMS c)
		(edge Directly2HELPConserveEnergyEMS c)
		(edge Indirectly2SaveTimeEMS c)
		(edge EncryptData2MAKEProtectPersonalInformationEMS c)
		(edge EncryptData2HELPProtectPersonalInformationEMS c)
		(edge NoEncryption2ReduceCosts c)
	))
)))
;ManageEncryptionKeys2SaveTimeC is Unique
(assert	(forall ((c1 Contribution) (c2 Contribution)) (=>
	(and (edge ManageEncryptionKeys2SaveTimeC c1) (edge ManageEncryptionKeys2SaveTimeC c2))
	(= c1 c2)
)))
;ManageEncryptionKeys2SaveTimeC is Distinct
(assert	(forall ((c Contribution)) (=>
	(edge ManageEncryptionKeys2SaveTimeC c)
	(not (or
		(edge BeInformedOfUsage2ConserveEnergyC c)
		(edge DefinePolicies2ConserveEnergyC c)
		(edge ManageEncryptionKeys2ProtectPersonalInformationC c)
		(edge ConserveEnergyEMS2ReduceCosts c)
		(edge Directly2SaveTimeEMS c)
		(edge Directly2HURTConserveEnergyEMS c)
		(edge Directly2HELPConserveEnergyEMS c)
		(edge Indirectly2SaveTimeEMS c)
		(edge EncryptData2MAKEProtectPersonalInformationEMS c)
		(edge EncryptData2HELPProtectPersonalInformationEMS c)
		(edge NoEncryption2ReduceCosts c)
	))
)))
;EnergyManagementSystem Exists
(assert (exists ((c Actor)) (node EnergyManagementSystem c)))
;EnergyManagementSystem is Unique
(assert	(forall ((c1 Actor) (c2 Actor)) (=>
	(and (node EnergyManagementSystem c1) (node EnergyManagementSystem c2))
	(= c1 c2)
)))
;EnergyManagementSystem is Distinct
(assert	(forall ((c Actor)) (=>
	(node EnergyManagementSystem c)
	(not (or
		(node Consumer c)
		(node MeterPointOperator c)
		(node HomeAreaNetwork c)
		(node HomeGateway c)
		(node SmartMeter c)
	))
)))
;ReduceCosts Exists
(assert (exists ((c SoftGoal)) (node ReduceCosts c)))
;ReduceCosts is Unique
(assert	(forall ((c1 SoftGoal) (c2 SoftGoal)) (=>
	(and (node ReduceCosts c1) (node ReduceCosts c2))
	(= c1 c2)
)))
;ReduceCosts is Distinct
(assert	(forall ((c SoftGoal)) (=>
	(node ReduceCosts c)
	(not (or
		(node ProtectPersonalInformationC c)
		(node ConserveEnergyC c)
		(node SaveTimeC c)
		(node ProtectPersonalInformationEMS c)
		(node SaveTimeEMS c)
		(node ConserveEnergyEMS c)
		(node ProtectPersonalInformation c)
		(node SaveTime c)
		(node ConserveEnergy c)
	))
)))
;StoreAndExecutePolicies Exists
(assert (exists ((c Goal)) (node StoreAndExecutePolicies c)))
;StoreAndExecutePolicies is Unique
(assert	(forall ((c1 Goal) (c2 Goal)) (=>
	(and (node StoreAndExecutePolicies c1) (node StoreAndExecutePolicies c2))
	(= c1 c2)
)))
;StoreAndExecutePolicies is Distinct
(assert	(forall ((c Goal)) (=>
	(node StoreAndExecutePolicies c)
	(not (or
		(node ConsumeEnergyC c)
		(node BeInformedOfUsage c)
		(node CommunicateWithTheHouse c)
		(node ControlSmartAppliancesEMS c)
		(node HandleSecurity c)
		(node ProvideAddedValueServices c)
		(node UseHANToCommunicate c)
		(node UseHGToCommunicate c)
		(node ControlSmartAppliances c)
	))
)))
;DisplayData Exists
(assert (exists ((c Task)) (node DisplayData c)))
;DisplayData is Unique
(assert	(forall ((c1 Task) (c2 Task)) (=>
	(and (node DisplayData c1) (node DisplayData c2))
	(= c1 c2)
)))
;DisplayData is Distinct
(assert	(forall ((c Task)) (=>
	(node DisplayData c)
	(not (or
		(node DefinePolicies c)
		(node ManageEncryptionKeys c)
		(node Directly c)
		(node Indirectly c)
		(node EncryptData c)
		(node NoEncryption c)
	))
)))
;CommunicateWithTheHouse Exists
(assert (exists ((c Goal)) (node CommunicateWithTheHouse c)))
;CommunicateWithTheHouse is Unique
(assert	(forall ((c1 Goal) (c2 Goal)) (=>
	(and (node CommunicateWithTheHouse c1) (node CommunicateWithTheHouse c2))
	(= c1 c2)
)))
;CommunicateWithTheHouse is Distinct
(assert	(forall ((c Goal)) (=>
	(node CommunicateWithTheHouse c)
	(not (or
		(node ConsumeEnergyC c)
		(node BeInformedOfUsage c)
		(node StoreAndExecutePolicies c)
		(node ControlSmartAppliancesEMS c)
		(node HandleSecurity c)
		(node ProvideAddedValueServices c)
		(node UseHANToCommunicate c)
		(node UseHGToCommunicate c)
		(node ControlSmartAppliances c)
	))
)))
;CommunicateWithTheHouse2DisplayData Exists
(assert (exists ((c Decomposition)) (edge CommunicateWithTheHouse2DisplayData c)))
;CommunicateWithTheHouse2DisplayData is Unique
(assert	(forall ((c1 Decomposition) (c2 Decomposition)) (=>
	(and (edge CommunicateWithTheHouse2DisplayData c1) (edge CommunicateWithTheHouse2DisplayData c2))
	(= c1 c2)
)))
;CommunicateWithTheHouse2DisplayData is Distinct
(assert	(forall ((c Decomposition)) (=>
	(edge CommunicateWithTheHouse2DisplayData c)
	(not (or
		(edge BeInformedOfUsage2ConsumeEnergyC c)
		(edge DefinePolicies2ConsumeEnergyC c)
		(edge CommunicateWithTheHouse2StoreAndExecutePolicies c)
		(edge ControlSmartAppliancesEMS2StoreAndExecutePolicies c)
		(edge HandleSecurity2CommunicateWithTheHouse c)
		(edge HomeAreaNetworkEMS2CommunicateWithTheHouse c)
		(edge HomeGatewayEMS2CommunicateWithTheHouse c)
	))
)))
;CommunicateWithTheHouse2StoreAndExecutePolicies Exists
(assert (exists ((c Decomposition)) (edge CommunicateWithTheHouse2StoreAndExecutePolicies c)))
;CommunicateWithTheHouse2StoreAndExecutePolicies is Unique
(assert	(forall ((c1 Decomposition) (c2 Decomposition)) (=>
	(and (edge CommunicateWithTheHouse2StoreAndExecutePolicies c1) (edge CommunicateWithTheHouse2StoreAndExecutePolicies c2))
	(= c1 c2)
)))
;CommunicateWithTheHouse2StoreAndExecutePolicies is Distinct
(assert	(forall ((c Decomposition)) (=>
	(edge CommunicateWithTheHouse2StoreAndExecutePolicies c)
	(not (or
		(edge BeInformedOfUsage2ConsumeEnergyC c)
		(edge DefinePolicies2ConsumeEnergyC c)
		(edge CommunicateWithTheHouse2DisplayData c)
		(edge ControlSmartAppliancesEMS2StoreAndExecutePolicies c)
		(edge HandleSecurity2CommunicateWithTheHouse c)
		(edge HomeAreaNetworkEMS2CommunicateWithTheHouse c)
		(edge HomeGatewayEMS2CommunicateWithTheHouse c)
	))
)))
;ProtectPersonalInformationEMS Exists
(assert (exists ((c SoftGoal)) (node ProtectPersonalInformationEMS c)))
;ProtectPersonalInformationEMS is Unique
(assert	(forall ((c1 SoftGoal) (c2 SoftGoal)) (=>
	(and (node ProtectPersonalInformationEMS c1) (node ProtectPersonalInformationEMS c2))
	(= c1 c2)
)))
;ProtectPersonalInformationEMS is Distinct
(assert	(forall ((c SoftGoal)) (=>
	(node ProtectPersonalInformationEMS c)
	(not (or
		(node ProtectPersonalInformationC c)
		(node ConserveEnergyC c)
		(node SaveTimeC c)
		(node ReduceCosts c)
		(node SaveTimeEMS c)
		(node ConserveEnergyEMS c)
		(node ProtectPersonalInformation c)
		(node SaveTime c)
		(node ConserveEnergy c)
	))
)))
;SaveTimeEMS Exists
(assert (exists ((c SoftGoal)) (node SaveTimeEMS c)))
;SaveTimeEMS is Unique
(assert	(forall ((c1 SoftGoal) (c2 SoftGoal)) (=>
	(and (node SaveTimeEMS c1) (node SaveTimeEMS c2))
	(= c1 c2)
)))
;SaveTimeEMS is Distinct
(assert	(forall ((c SoftGoal)) (=>
	(node SaveTimeEMS c)
	(not (or
		(node ProtectPersonalInformationC c)
		(node ConserveEnergyC c)
		(node SaveTimeC c)
		(node ReduceCosts c)
		(node ProtectPersonalInformationEMS c)
		(node ConserveEnergyEMS c)
		(node ProtectPersonalInformation c)
		(node SaveTime c)
		(node ConserveEnergy c)
	))
)))
;ConserveEnergyEMS Exists
(assert (exists ((c SoftGoal)) (node ConserveEnergyEMS c)))
;ConserveEnergyEMS is Unique
(assert	(forall ((c1 SoftGoal) (c2 SoftGoal)) (=>
	(and (node ConserveEnergyEMS c1) (node ConserveEnergyEMS c2))
	(= c1 c2)
)))
;ConserveEnergyEMS is Distinct
(assert	(forall ((c SoftGoal)) (=>
	(node ConserveEnergyEMS c)
	(not (or
		(node ProtectPersonalInformationC c)
		(node ConserveEnergyC c)
		(node SaveTimeC c)
		(node ReduceCosts c)
		(node ProtectPersonalInformationEMS c)
		(node SaveTimeEMS c)
		(node ProtectPersonalInformation c)
		(node SaveTime c)
		(node ConserveEnergy c)
	))
)))
;ConserveEnergyEMS2ReduceCosts Exists
(assert (exists ((c Contribution)) (edge ConserveEnergyEMS2ReduceCosts c)))
;ConserveEnergyEMS2ReduceCosts is Unique
(assert	(forall ((c1 Contribution) (c2 Contribution)) (=>
	(and (edge ConserveEnergyEMS2ReduceCosts c1) (edge ConserveEnergyEMS2ReduceCosts c2))
	(= c1 c2)
)))
;ConserveEnergyEMS2ReduceCosts is Distinct
(assert	(forall ((c Contribution)) (=>
	(edge ConserveEnergyEMS2ReduceCosts c)
	(not (or
		(edge BeInformedOfUsage2ConserveEnergyC c)
		(edge DefinePolicies2ConserveEnergyC c)
		(edge ManageEncryptionKeys2ProtectPersonalInformationC c)
		(edge ManageEncryptionKeys2SaveTimeC c)
		(edge Directly2SaveTimeEMS c)
		(edge Directly2HURTConserveEnergyEMS c)
		(edge Directly2HELPConserveEnergyEMS c)
		(edge Indirectly2SaveTimeEMS c)
		(edge EncryptData2MAKEProtectPersonalInformationEMS c)
		(edge EncryptData2HELPProtectPersonalInformationEMS c)
		(edge NoEncryption2ReduceCosts c)
	))
)))
;ControlSmartAppliancesEMS Exists
(assert (exists ((c Goal)) (node ControlSmartAppliancesEMS c)))
;ControlSmartAppliancesEMS is Unique
(assert	(forall ((c1 Goal) (c2 Goal)) (=>
	(and (node ControlSmartAppliancesEMS c1) (node ControlSmartAppliancesEMS c2))
	(= c1 c2)
)))
;ControlSmartAppliancesEMS is Distinct
(assert	(forall ((c Goal)) (=>
	(node ControlSmartAppliancesEMS c)
	(not (or
		(node ConsumeEnergyC c)
		(node BeInformedOfUsage c)
		(node StoreAndExecutePolicies c)
		(node CommunicateWithTheHouse c)
		(node HandleSecurity c)
		(node ProvideAddedValueServices c)
		(node UseHANToCommunicate c)
		(node UseHGToCommunicate c)
		(node ControlSmartAppliances c)
	))
)))
;ControlSmartAppliancesEMS2StoreAndExecutePolicies Exists
(assert (exists ((c Decomposition)) (edge ControlSmartAppliancesEMS2StoreAndExecutePolicies c)))
;ControlSmartAppliancesEMS2StoreAndExecutePolicies is Unique
(assert	(forall ((c1 Decomposition) (c2 Decomposition)) (=>
	(and (edge ControlSmartAppliancesEMS2StoreAndExecutePolicies c1) (edge ControlSmartAppliancesEMS2StoreAndExecutePolicies c2))
	(= c1 c2)
)))
;ControlSmartAppliancesEMS2StoreAndExecutePolicies is Distinct
(assert	(forall ((c Decomposition)) (=>
	(edge ControlSmartAppliancesEMS2StoreAndExecutePolicies c)
	(not (or
		(edge BeInformedOfUsage2ConsumeEnergyC c)
		(edge DefinePolicies2ConsumeEnergyC c)
		(edge CommunicateWithTheHouse2DisplayData c)
		(edge CommunicateWithTheHouse2StoreAndExecutePolicies c)
		(edge HandleSecurity2CommunicateWithTheHouse c)
		(edge HomeAreaNetworkEMS2CommunicateWithTheHouse c)
		(edge HomeGatewayEMS2CommunicateWithTheHouse c)
	))
)))
;Directly Exists
(assert (exists ((c Task)) (node Directly c)))
;Directly is Unique
(assert	(forall ((c1 Task) (c2 Task)) (=>
	(and (node Directly c1) (node Directly c2))
	(= c1 c2)
)))
;Directly is Distinct
(assert	(forall ((c Task)) (=>
	(node Directly c)
	(not (or
		(node DefinePolicies c)
		(node ManageEncryptionKeys c)
		(node DisplayData c)
		(node Indirectly c)
		(node EncryptData c)
		(node NoEncryption c)
	))
)))
;Directly2ControlSmartAppliancesEMS Exists
(assert (exists ((c MeansEnd)) (edge Directly2ControlSmartAppliancesEMS c)))
;Directly2ControlSmartAppliancesEMS is Unique
(assert	(forall ((c1 MeansEnd) (c2 MeansEnd)) (=>
	(and (edge Directly2ControlSmartAppliancesEMS c1) (edge Directly2ControlSmartAppliancesEMS c2))
	(= c1 c2)
)))
;Directly2ControlSmartAppliancesEMS is Distinct
(assert	(forall ((c MeansEnd)) (=>
	(edge Directly2ControlSmartAppliancesEMS c)
	(not (or
		(edge Indirectly2ControlSmartAppliancesEMS c)
		(edge EncryptData2HandleSecurity c)
		(edge NoEncryption2HandleSecurity c)
	))
)))
;Directly2SaveTimeEMS Exists
(assert (exists ((c Contribution)) (edge Directly2SaveTimeEMS c)))
;Directly2SaveTimeEMS is Unique
(assert	(forall ((c1 Contribution) (c2 Contribution)) (=>
	(and (edge Directly2SaveTimeEMS c1) (edge Directly2SaveTimeEMS c2))
	(= c1 c2)
)))
;Directly2SaveTimeEMS is Distinct
(assert	(forall ((c Contribution)) (=>
	(edge Directly2SaveTimeEMS c)
	(not (or
		(edge BeInformedOfUsage2ConserveEnergyC c)
		(edge DefinePolicies2ConserveEnergyC c)
		(edge ManageEncryptionKeys2ProtectPersonalInformationC c)
		(edge ManageEncryptionKeys2SaveTimeC c)
		(edge ConserveEnergyEMS2ReduceCosts c)
		(edge Directly2HURTConserveEnergyEMS c)
		(edge Directly2HELPConserveEnergyEMS c)
		(edge Indirectly2SaveTimeEMS c)
		(edge EncryptData2MAKEProtectPersonalInformationEMS c)
		(edge EncryptData2HELPProtectPersonalInformationEMS c)
		(edge NoEncryption2ReduceCosts c)
	))
)))
;Directly2HURTConserveEnergyEMS is Unique
(assert	(forall ((c1 Contribution) (c2 Contribution)) (=>
	(and (edge Directly2HURTConserveEnergyEMS c1) (edge Directly2HURTConserveEnergyEMS c2))
	(= c1 c2)
)))
;Directly2HURTConserveEnergyEMS is Distinct
(assert	(forall ((c Contribution)) (=>
	(edge Directly2HURTConserveEnergyEMS c)
	(not (or
		(edge BeInformedOfUsage2ConserveEnergyC c)
		(edge DefinePolicies2ConserveEnergyC c)
		(edge ManageEncryptionKeys2ProtectPersonalInformationC c)
		(edge ManageEncryptionKeys2SaveTimeC c)
		(edge ConserveEnergyEMS2ReduceCosts c)
		(edge Directly2SaveTimeEMS c)
		(edge Directly2HELPConserveEnergyEMS c)
		(edge Indirectly2SaveTimeEMS c)
		(edge EncryptData2MAKEProtectPersonalInformationEMS c)
		(edge EncryptData2HELPProtectPersonalInformationEMS c)
		(edge NoEncryption2ReduceCosts c)
	))
)))
;Directly2HELPConserveEnergyEMS is Unique
(assert	(forall ((c1 Contribution) (c2 Contribution)) (=>
	(and (edge Directly2HELPConserveEnergyEMS c1) (edge Directly2HELPConserveEnergyEMS c2))
	(= c1 c2)
)))
;Directly2HELPConserveEnergyEMS is Distinct
(assert	(forall ((c Contribution)) (=>
	(edge Directly2HELPConserveEnergyEMS c)
	(not (or
		(edge BeInformedOfUsage2ConserveEnergyC c)
		(edge DefinePolicies2ConserveEnergyC c)
		(edge ManageEncryptionKeys2ProtectPersonalInformationC c)
		(edge ManageEncryptionKeys2SaveTimeC c)
		(edge ConserveEnergyEMS2ReduceCosts c)
		(edge Directly2SaveTimeEMS c)
		(edge Directly2HURTConserveEnergyEMS c)
		(edge Indirectly2SaveTimeEMS c)
		(edge EncryptData2MAKEProtectPersonalInformationEMS c)
		(edge EncryptData2HELPProtectPersonalInformationEMS c)
		(edge NoEncryption2ReduceCosts c)
	))
)))
;Indirectly Exists
(assert (exists ((c Task)) (node Indirectly c)))
;Indirectly is Unique
(assert	(forall ((c1 Task) (c2 Task)) (=>
	(and (node Indirectly c1) (node Indirectly c2))
	(= c1 c2)
)))
;Indirectly is Distinct
(assert	(forall ((c Task)) (=>
	(node Indirectly c)
	(not (or
		(node DefinePolicies c)
		(node ManageEncryptionKeys c)
		(node DisplayData c)
		(node Directly c)
		(node EncryptData c)
		(node NoEncryption c)
	))
)))
;Indirectly2ControlSmartAppliancesEMS Exists
(assert (exists ((c MeansEnd)) (edge Indirectly2ControlSmartAppliancesEMS c)))
;Indirectly2ControlSmartAppliancesEMS is Unique
(assert	(forall ((c1 MeansEnd) (c2 MeansEnd)) (=>
	(and (edge Indirectly2ControlSmartAppliancesEMS c1) (edge Indirectly2ControlSmartAppliancesEMS c2))
	(= c1 c2)
)))
;Indirectly2ControlSmartAppliancesEMS is Distinct
(assert	(forall ((c MeansEnd)) (=>
	(edge Indirectly2ControlSmartAppliancesEMS c)
	(not (or
		(edge Directly2ControlSmartAppliancesEMS c)
		(edge EncryptData2HandleSecurity c)
		(edge NoEncryption2HandleSecurity c)
	))
)))
;Indirectly2SaveTimeEMS Exists
(assert (exists ((c Contribution)) (edge Indirectly2SaveTimeEMS c)))
;Indirectly2SaveTimeEMS is Unique
(assert	(forall ((c1 Contribution) (c2 Contribution)) (=>
	(and (edge Indirectly2SaveTimeEMS c1) (edge Indirectly2SaveTimeEMS c2))
	(= c1 c2)
)))
;Indirectly2SaveTimeEMS is Distinct
(assert	(forall ((c Contribution)) (=>
	(edge Indirectly2SaveTimeEMS c)
	(not (or
		(edge BeInformedOfUsage2ConserveEnergyC c)
		(edge DefinePolicies2ConserveEnergyC c)
		(edge ManageEncryptionKeys2ProtectPersonalInformationC c)
		(edge ManageEncryptionKeys2SaveTimeC c)
		(edge ConserveEnergyEMS2ReduceCosts c)
		(edge Directly2SaveTimeEMS c)
		(edge Directly2HURTConserveEnergyEMS c)
		(edge Directly2HELPConserveEnergyEMS c)
		(edge EncryptData2MAKEProtectPersonalInformationEMS c)
		(edge EncryptData2HELPProtectPersonalInformationEMS c)
		(edge NoEncryption2ReduceCosts c)
	))
)))
;HandleSecurity Exists
(assert (exists ((c Goal)) (node HandleSecurity c)))
;HandleSecurity is Unique
(assert	(forall ((c1 Goal) (c2 Goal)) (=>
	(and (node HandleSecurity c1) (node HandleSecurity c2))
	(= c1 c2)
)))
;HandleSecurity is Distinct
(assert	(forall ((c Goal)) (=>
	(node HandleSecurity c)
	(not (or
		(node ConsumeEnergyC c)
		(node BeInformedOfUsage c)
		(node StoreAndExecutePolicies c)
		(node CommunicateWithTheHouse c)
		(node ControlSmartAppliancesEMS c)
		(node ProvideAddedValueServices c)
		(node UseHANToCommunicate c)
		(node UseHGToCommunicate c)
		(node ControlSmartAppliances c)
	))
)))
;HandleSecurity2CommunicateWithTheHouse Exists
(assert (exists ((c Decomposition)) (edge HandleSecurity2CommunicateWithTheHouse c)))
;HandleSecurity2CommunicateWithTheHouse is Unique
(assert	(forall ((c1 Decomposition) (c2 Decomposition)) (=>
	(and (edge HandleSecurity2CommunicateWithTheHouse c1) (edge HandleSecurity2CommunicateWithTheHouse c2))
	(= c1 c2)
)))
;HandleSecurity2CommunicateWithTheHouse is Distinct
(assert	(forall ((c Decomposition)) (=>
	(edge HandleSecurity2CommunicateWithTheHouse c)
	(not (or
		(edge BeInformedOfUsage2ConsumeEnergyC c)
		(edge DefinePolicies2ConsumeEnergyC c)
		(edge CommunicateWithTheHouse2DisplayData c)
		(edge CommunicateWithTheHouse2StoreAndExecutePolicies c)
		(edge ControlSmartAppliancesEMS2StoreAndExecutePolicies c)
		(edge HomeAreaNetworkEMS2CommunicateWithTheHouse c)
		(edge HomeGatewayEMS2CommunicateWithTheHouse c)
	))
)))
;EncryptData Exists
(assert (exists ((c Task)) (node EncryptData c)))
;EncryptData is Unique
(assert	(forall ((c1 Task) (c2 Task)) (=>
	(and (node EncryptData c1) (node EncryptData c2))
	(= c1 c2)
)))
;EncryptData is Distinct
(assert	(forall ((c Task)) (=>
	(node EncryptData c)
	(not (or
		(node DefinePolicies c)
		(node ManageEncryptionKeys c)
		(node DisplayData c)
		(node Directly c)
		(node Indirectly c)
		(node NoEncryption c)
	))
)))
;EncryptData2HandleSecurity Exists
(assert (exists ((c MeansEnd)) (edge EncryptData2HandleSecurity c)))
;EncryptData2HandleSecurity is Unique
(assert	(forall ((c1 MeansEnd) (c2 MeansEnd)) (=>
	(and (edge EncryptData2HandleSecurity c1) (edge EncryptData2HandleSecurity c2))
	(= c1 c2)
)))
;EncryptData2HandleSecurity is Distinct
(assert	(forall ((c MeansEnd)) (=>
	(edge EncryptData2HandleSecurity c)
	(not (or
		(edge Directly2ControlSmartAppliancesEMS c)
		(edge Indirectly2ControlSmartAppliancesEMS c)
		(edge NoEncryption2HandleSecurity c)
	))
)))
;EncryptData2MAKEProtectPersonalInformationEMS is Unique
(assert	(forall ((c1 Contribution) (c2 Contribution)) (=>
	(and (edge EncryptData2MAKEProtectPersonalInformationEMS c1) (edge EncryptData2MAKEProtectPersonalInformationEMS c2))
	(= c1 c2)
)))
;EncryptData2MAKEProtectPersonalInformationEMS is Distinct
(assert	(forall ((c Contribution)) (=>
	(edge EncryptData2MAKEProtectPersonalInformationEMS c)
	(not (or
		(edge BeInformedOfUsage2ConserveEnergyC c)
		(edge DefinePolicies2ConserveEnergyC c)
		(edge ManageEncryptionKeys2ProtectPersonalInformationC c)
		(edge ManageEncryptionKeys2SaveTimeC c)
		(edge ConserveEnergyEMS2ReduceCosts c)
		(edge Directly2SaveTimeEMS c)
		(edge Directly2HURTConserveEnergyEMS c)
		(edge Directly2HELPConserveEnergyEMS c)
		(edge Indirectly2SaveTimeEMS c)
		(edge EncryptData2HELPProtectPersonalInformationEMS c)
		(edge NoEncryption2ReduceCosts c)
	))
)))
;EncryptData2HELPProtectPersonalInformationEMS is Unique
(assert	(forall ((c1 Contribution) (c2 Contribution)) (=>
	(and (edge EncryptData2HELPProtectPersonalInformationEMS c1) (edge EncryptData2HELPProtectPersonalInformationEMS c2))
	(= c1 c2)
)))
;EncryptData2HELPProtectPersonalInformationEMS is Distinct
(assert	(forall ((c Contribution)) (=>
	(edge EncryptData2HELPProtectPersonalInformationEMS c)
	(not (or
		(edge BeInformedOfUsage2ConserveEnergyC c)
		(edge DefinePolicies2ConserveEnergyC c)
		(edge ManageEncryptionKeys2ProtectPersonalInformationC c)
		(edge ManageEncryptionKeys2SaveTimeC c)
		(edge ConserveEnergyEMS2ReduceCosts c)
		(edge Directly2SaveTimeEMS c)
		(edge Directly2HURTConserveEnergyEMS c)
		(edge Directly2HELPConserveEnergyEMS c)
		(edge Indirectly2SaveTimeEMS c)
		(edge EncryptData2MAKEProtectPersonalInformationEMS c)
		(edge NoEncryption2ReduceCosts c)
	))
)))
;NoEncryption Exists
(assert (exists ((c Task)) (node NoEncryption c)))
;NoEncryption is Unique
(assert	(forall ((c1 Task) (c2 Task)) (=>
	(and (node NoEncryption c1) (node NoEncryption c2))
	(= c1 c2)
)))
;NoEncryption is Distinct
(assert	(forall ((c Task)) (=>
	(node NoEncryption c)
	(not (or
		(node DefinePolicies c)
		(node ManageEncryptionKeys c)
		(node DisplayData c)
		(node Directly c)
		(node Indirectly c)
		(node EncryptData c)
	))
)))
;NoEncryption2ReduceCosts Exists
(assert (exists ((c Contribution)) (edge NoEncryption2ReduceCosts c)))
;NoEncryption2ReduceCosts is Unique
(assert	(forall ((c1 Contribution) (c2 Contribution)) (=>
	(and (edge NoEncryption2ReduceCosts c1) (edge NoEncryption2ReduceCosts c2))
	(= c1 c2)
)))
;NoEncryption2ReduceCosts is Distinct
(assert	(forall ((c Contribution)) (=>
	(edge NoEncryption2ReduceCosts c)
	(not (or
		(edge BeInformedOfUsage2ConserveEnergyC c)
		(edge DefinePolicies2ConserveEnergyC c)
		(edge ManageEncryptionKeys2ProtectPersonalInformationC c)
		(edge ManageEncryptionKeys2SaveTimeC c)
		(edge ConserveEnergyEMS2ReduceCosts c)
		(edge Directly2SaveTimeEMS c)
		(edge Directly2HURTConserveEnergyEMS c)
		(edge Directly2HELPConserveEnergyEMS c)
		(edge Indirectly2SaveTimeEMS c)
		(edge EncryptData2MAKEProtectPersonalInformationEMS c)
		(edge EncryptData2HELPProtectPersonalInformationEMS c)
	))
)))
;NoEncryption2HandleSecurity Exists
(assert (exists ((c MeansEnd)) (edge NoEncryption2HandleSecurity c)))
;NoEncryption2HandleSecurity is Unique
(assert	(forall ((c1 MeansEnd) (c2 MeansEnd)) (=>
	(and (edge NoEncryption2HandleSecurity c1) (edge NoEncryption2HandleSecurity c2))
	(= c1 c2)
)))
;NoEncryption2HandleSecurity is Distinct
(assert	(forall ((c MeansEnd)) (=>
	(edge NoEncryption2HandleSecurity c)
	(not (or
		(edge Directly2ControlSmartAppliancesEMS c)
		(edge Indirectly2ControlSmartAppliancesEMS c)
		(edge EncryptData2HandleSecurity c)
	))
)))
;HomeAreaNetworkEMS is Unique
(assert	(forall ((c1 Resource) (c2 Resource)) (=>
	(and (node HomeAreaNetworkEMS c1) (node HomeAreaNetworkEMS c2))
	(= c1 c2)
)))
;HomeAreaNetworkEMS is Distinct
(assert	(forall ((c Resource)) (=>
	(node HomeAreaNetworkEMS c)
	(not (or
		(node HomeGatewayEMS c)
		(node Data c)
		(node BillingDataFeedback c)
		(node Policies c)
		(node EncryptionKeys1 c)
		(node EncryptionKeys2 c)
		(node OtherData c)
		(node AggregatedBillingData c)
		(node BillingData c)
	))
)))
;HomeAreaNetworkEMS2CommunicateWithTheHouse is Unique
(assert	(forall ((c1 Decomposition) (c2 Decomposition)) (=>
	(and (edge HomeAreaNetworkEMS2CommunicateWithTheHouse c1) (edge HomeAreaNetworkEMS2CommunicateWithTheHouse c2))
	(= c1 c2)
)))
;HomeAreaNetworkEMS2CommunicateWithTheHouse is Distinct
(assert	(forall ((c Decomposition)) (=>
	(edge HomeAreaNetworkEMS2CommunicateWithTheHouse c)
	(not (or
		(edge BeInformedOfUsage2ConsumeEnergyC c)
		(edge DefinePolicies2ConsumeEnergyC c)
		(edge CommunicateWithTheHouse2DisplayData c)
		(edge CommunicateWithTheHouse2StoreAndExecutePolicies c)
		(edge ControlSmartAppliancesEMS2StoreAndExecutePolicies c)
		(edge HandleSecurity2CommunicateWithTheHouse c)
		(edge HomeGatewayEMS2CommunicateWithTheHouse c)
	))
)))
;HomeGatewayEMS is Unique
(assert	(forall ((c1 Resource) (c2 Resource)) (=>
	(and (node HomeGatewayEMS c1) (node HomeGatewayEMS c2))
	(= c1 c2)
)))
;HomeGatewayEMS is Distinct
(assert	(forall ((c Resource)) (=>
	(node HomeGatewayEMS c)
	(not (or
		(node HomeAreaNetworkEMS c)
		(node Data c)
		(node BillingDataFeedback c)
		(node Policies c)
		(node EncryptionKeys1 c)
		(node EncryptionKeys2 c)
		(node OtherData c)
		(node AggregatedBillingData c)
		(node BillingData c)
	))
)))
;HomeGatewayEMS2CommunicateWithTheHouse is Unique
(assert	(forall ((c1 Decomposition) (c2 Decomposition)) (=>
	(and (edge HomeGatewayEMS2CommunicateWithTheHouse c1) (edge HomeGatewayEMS2CommunicateWithTheHouse c2))
	(= c1 c2)
)))
;HomeGatewayEMS2CommunicateWithTheHouse is Distinct
(assert	(forall ((c Decomposition)) (=>
	(edge HomeGatewayEMS2CommunicateWithTheHouse c)
	(not (or
		(edge BeInformedOfUsage2ConsumeEnergyC c)
		(edge DefinePolicies2ConsumeEnergyC c)
		(edge CommunicateWithTheHouse2DisplayData c)
		(edge CommunicateWithTheHouse2StoreAndExecutePolicies c)
		(edge ControlSmartAppliancesEMS2StoreAndExecutePolicies c)
		(edge HandleSecurity2CommunicateWithTheHouse c)
		(edge HomeAreaNetworkEMS2CommunicateWithTheHouse c)
	))
)))
;MeterPointOperator is Unique
(assert	(forall ((c1 Actor) (c2 Actor)) (=>
	(and (node MeterPointOperator c1) (node MeterPointOperator c2))
	(= c1 c2)
)))
;MeterPointOperator is Distinct
(assert	(forall ((c Actor)) (=>
	(node MeterPointOperator c)
	(not (or
		(node Consumer c)
		(node EnergyManagementSystem c)
		(node HomeAreaNetwork c)
		(node HomeGateway c)
		(node SmartMeter c)
	))
)))
;HomeAreaNetwork is Unique
(assert	(forall ((c1 Actor) (c2 Actor)) (=>
	(and (node HomeAreaNetwork c1) (node HomeAreaNetwork c2))
	(= c1 c2)
)))
;HomeAreaNetwork is Distinct
(assert	(forall ((c Actor)) (=>
	(node HomeAreaNetwork c)
	(not (or
		(node Consumer c)
		(node EnergyManagementSystem c)
		(node MeterPointOperator c)
		(node HomeGateway c)
		(node SmartMeter c)
	))
)))
;HomeGateway is Unique
(assert	(forall ((c1 Actor) (c2 Actor)) (=>
	(and (node HomeGateway c1) (node HomeGateway c2))
	(= c1 c2)
)))
;HomeGateway is Distinct
(assert	(forall ((c Actor)) (=>
	(node HomeGateway c)
	(not (or
		(node Consumer c)
		(node EnergyManagementSystem c)
		(node MeterPointOperator c)
		(node HomeAreaNetwork c)
		(node SmartMeter c)
	))
)))
;SmartMeter Exists
(assert (exists ((c Actor)) (node SmartMeter c)))
;SmartMeter is Unique
(assert	(forall ((c1 Actor) (c2 Actor)) (=>
	(and (node SmartMeter c1) (node SmartMeter c2))
	(= c1 c2)
)))
;SmartMeter is Distinct
(assert	(forall ((c Actor)) (=>
	(node SmartMeter c)
	(not (or
		(node Consumer c)
		(node EnergyManagementSystem c)
		(node MeterPointOperator c)
		(node HomeAreaNetwork c)
		(node HomeGateway c)
	))
)))
;EnergySupplierServer Exists
(assert (exists ((c Actor)) (node EnergySupplierServer c)))
;EnergySupplierServer is Unique
(assert	(forall ((c1 Actor) (c2 Actor)) (=>
	(and (node EnergySupplierServer c1) (node EnergySupplierServer c2))
	(= c1 c2)
)))
;StoreAggregatedBillingDataESS Exists
(assert (exists ((c Goal)) (node StoreAggregatedBillingDataESS c)))
;StoreAggregatedBillingDataESS is Unique
(assert	(forall ((c1 Goal) (c2 Goal)) (=>
	(and (node StoreAggregatedBillingDataESS c1) (node StoreAggregatedBillingDataESS c2))
	(= c1 c2)
)))
;StoreAggregatedBillingDataESS is Distinct
(assert	(forall ((c Goal)) (=>
	(node StoreAggregatedBillingDataESS c)
	(not (or
		(node UseHANToCommunicate c)
		(node UseHGToCommunicate c)
		(node ControlSmartAppliances c)
	))
)))
;ProvideAddedValueServices Exists
(assert (exists ((c Goal)) (node ProvideAddedValueServices c)))
;ProvideAddedValueServices is Distinct
(assert	(forall ((c Goal)) (=>
	(node ProvideAddedValueServices c)
	(not (or
		(node ConsumeEnergyC c)
		(node BeInformedOfUsage c)
		(node StoreAndExecutePolicies c)
		(node CommunicateWithTheHouse c)
		(node ControlSmartAppliancesEMS c)
		(node HandleSecurity c)
		(node UseHANToCommunicate c)
		(node UseHGToCommunicate c)
		(node ControlSmartAppliances c)
	))
)))
;AnotherServer is Unique
(assert	(forall ((c1 Actor) (c2 Actor)) (=>
	(and (node AnotherServer c1) (node AnotherServer c2))
	(= c1 c2)
)))
;StoreAggregatedBillingDataAS is Unique
(assert	(forall ((c1 Goal) (c2 Goal)) (=>
	(and (node StoreAggregatedBillingDataAS c1) (node StoreAggregatedBillingDataAS c2))
	(= c1 c2)
)))
;StoreAggregatedBillingDataAS is Distinct
(assert	(forall ((c Goal)) (=>
	(node StoreAggregatedBillingDataAS c)
	(not (or
		(node UseHANToCommunicate c)
		(node UseHGToCommunicate c)
		(node ControlSmartAppliances c)
	))
)))
;ProtectPersonalInformation Exists
(assert (exists ((c SoftGoal)) (node ProtectPersonalInformation c)))
;ProtectPersonalInformation is Unique
(assert	(forall ((c1 SoftGoal) (c2 SoftGoal)) (=>
	(and (node ProtectPersonalInformation c1) (node ProtectPersonalInformation c2))
	(= c1 c2)
)))
;ProtectPersonalInformation is Distinct
(assert	(forall ((c SoftGoal)) (=>
	(node ProtectPersonalInformation c)
	(not (or
		(node ProtectPersonalInformationC c)
		(node ConserveEnergyC c)
		(node SaveTimeC c)
		(node ReduceCosts c)
		(node ProtectPersonalInformationEMS c)
		(node SaveTimeEMS c)
		(node ConserveEnergyEMS c)
		(node SaveTime c)
		(node ConserveEnergy c)
	))
)))
;ProtectPersonalInformationC2ProtectPersonalInformation Exists
(assert (exists ((c DependerLink)) (edge ProtectPersonalInformationC2ProtectPersonalInformation c)))
;ProtectPersonalInformationC2ProtectPersonalInformation is Unique
(assert	(forall ((c1 DependerLink) (c2 DependerLink)) (=>
	(and (edge ProtectPersonalInformationC2ProtectPersonalInformation c1) (edge ProtectPersonalInformationC2ProtectPersonalInformation c2))
	(= c1 c2)
)))
;ProtectPersonalInformationC2ProtectPersonalInformation is Distinct
(assert	(forall ((c DependerLink)) (=>
	(edge ProtectPersonalInformationC2ProtectPersonalInformation c)
	(not (or
		(edge SaveTimeC2SaveTime c)
		(edge ConserveEnergyC2ConserveEnergy c)
		(edge BeInformedOfUsage2Data c)
		(edge BeInformedOfUsage2BillingDataFeedback c)
		(edge StoreAndExecutePolicies2Policies c)
		(edge EncryptData2EncryptionKeys1 c)
		(edge EncryptData2EncryptionKeys2 c)
		(edge CommunicateWithTheHouse2UseHANToCommunicate c)
		(edge CommunicateWithTheHouse2UseHGToCommunicate c)
		(edge ProvideAddedValueServices2OtherData c)
		(edge StoreAggregatedBillingDataESS2AggregatedBillingData c)
		(edge StoreAggregatedBillingDataAS2AggregatedBillingData c)
		(edge Indirectly2ControlSmartAppliances c)
		(edge DisplayData2BillingData c)
	))
)))
;ProtectPersonalInformation2ProtectPersonalInformationEMS Exists
(assert (exists ((c DependeeLink)) (edge ProtectPersonalInformation2ProtectPersonalInformationEMS c)))
;ProtectPersonalInformation2ProtectPersonalInformationEMS is Unique
(assert	(forall ((c1 DependeeLink) (c2 DependeeLink)) (=>
	(and (edge ProtectPersonalInformation2ProtectPersonalInformationEMS c1) (edge ProtectPersonalInformation2ProtectPersonalInformationEMS c2))
	(= c1 c2)
)))
;ProtectPersonalInformation2ProtectPersonalInformationEMS is Distinct
(assert	(forall ((c DependeeLink)) (=>
	(edge ProtectPersonalInformation2ProtectPersonalInformationEMS c)
	(not (or
		(edge SaveTime2SaveTimeEMS c)
		(edge ConserveEnergy2ConserveEnergyEMS c)
		(edge Data2DisplayData c)
		(edge BillingDataFeedback2DisplayData c)
		(edge Policies2DefinePolicies c)
		(edge EncryptionKeys12ManageEncryptionKeys c)
		(edge EncryptionKeys22MeterPointOperator c)
		(edge UseHANToCommunicate2HomeAreaNetwork c)
		(edge UseHGToCommunicate2HomeGateway c)
		(edge OtherData2HomeGateway c)
		(edge AggregatedBillingData2SmartMeter c)
		(edge ControlSmartAppliances2SmartMeter c)
		(edge BillingData2SmartMeter c)
	))
)))
;SaveTime Exists
(assert (exists ((c SoftGoal)) (node SaveTime c)))
;SaveTime is Unique
(assert	(forall ((c1 SoftGoal) (c2 SoftGoal)) (=>
	(and (node SaveTime c1) (node SaveTime c2))
	(= c1 c2)
)))
;SaveTime is Distinct
(assert	(forall ((c SoftGoal)) (=>
	(node SaveTime c)
	(not (or
		(node ProtectPersonalInformationC c)
		(node ConserveEnergyC c)
		(node SaveTimeC c)
		(node ReduceCosts c)
		(node ProtectPersonalInformationEMS c)
		(node SaveTimeEMS c)
		(node ConserveEnergyEMS c)
		(node ProtectPersonalInformation c)
		(node ConserveEnergy c)
	))
)))
;SaveTimeC2SaveTime Exists
(assert (exists ((c DependerLink)) (edge SaveTimeC2SaveTime c)))
;SaveTimeC2SaveTime is Unique
(assert	(forall ((c1 DependerLink) (c2 DependerLink)) (=>
	(and (edge SaveTimeC2SaveTime c1) (edge SaveTimeC2SaveTime c2))
	(= c1 c2)
)))
;SaveTimeC2SaveTime is Distinct
(assert	(forall ((c DependerLink)) (=>
	(edge SaveTimeC2SaveTime c)
	(not (or
		(edge ProtectPersonalInformationC2ProtectPersonalInformation c)
		(edge ConserveEnergyC2ConserveEnergy c)
		(edge BeInformedOfUsage2Data c)
		(edge BeInformedOfUsage2BillingDataFeedback c)
		(edge StoreAndExecutePolicies2Policies c)
		(edge EncryptData2EncryptionKeys1 c)
		(edge EncryptData2EncryptionKeys2 c)
		(edge CommunicateWithTheHouse2UseHANToCommunicate c)
		(edge CommunicateWithTheHouse2UseHGToCommunicate c)
		(edge ProvideAddedValueServices2OtherData c)
		(edge StoreAggregatedBillingDataESS2AggregatedBillingData c)
		(edge StoreAggregatedBillingDataAS2AggregatedBillingData c)
		(edge Indirectly2ControlSmartAppliances c)
		(edge DisplayData2BillingData c)
	))
)))
;SaveTime2SaveTimeEMS Exists
(assert (exists ((c DependeeLink)) (edge SaveTime2SaveTimeEMS c)))
;SaveTime2SaveTimeEMS is Unique
(assert	(forall ((c1 DependeeLink) (c2 DependeeLink)) (=>
	(and (edge SaveTime2SaveTimeEMS c1) (edge SaveTime2SaveTimeEMS c2))
	(= c1 c2)
)))
;SaveTime2SaveTimeEMS is Distinct
(assert	(forall ((c DependeeLink)) (=>
	(edge SaveTime2SaveTimeEMS c)
	(not (or
		(edge ProtectPersonalInformation2ProtectPersonalInformationEMS c)
		(edge ConserveEnergy2ConserveEnergyEMS c)
		(edge Data2DisplayData c)
		(edge BillingDataFeedback2DisplayData c)
		(edge Policies2DefinePolicies c)
		(edge EncryptionKeys12ManageEncryptionKeys c)
		(edge EncryptionKeys22MeterPointOperator c)
		(edge UseHANToCommunicate2HomeAreaNetwork c)
		(edge UseHGToCommunicate2HomeGateway c)
		(edge OtherData2HomeGateway c)
		(edge AggregatedBillingData2SmartMeter c)
		(edge ControlSmartAppliances2SmartMeter c)
		(edge BillingData2SmartMeter c)
	))
)))
;ConserveEnergy Exists
(assert (exists ((c SoftGoal)) (node ConserveEnergy c)))
;ConserveEnergy is Unique
(assert	(forall ((c1 SoftGoal) (c2 SoftGoal)) (=>
	(and (node ConserveEnergy c1) (node ConserveEnergy c2))
	(= c1 c2)
)))
;ConserveEnergy is Distinct
(assert	(forall ((c SoftGoal)) (=>
	(node ConserveEnergy c)
	(not (or
		(node ProtectPersonalInformationC c)
		(node ConserveEnergyC c)
		(node SaveTimeC c)
		(node ReduceCosts c)
		(node ProtectPersonalInformationEMS c)
		(node SaveTimeEMS c)
		(node ConserveEnergyEMS c)
		(node ProtectPersonalInformation c)
		(node SaveTime c)
	))
)))
;ConserveEnergyC2ConserveEnergy Exists
(assert (exists ((c DependerLink)) (edge ConserveEnergyC2ConserveEnergy c)))
;ConserveEnergyC2ConserveEnergy is Unique
(assert	(forall ((c1 DependerLink) (c2 DependerLink)) (=>
	(and (edge ConserveEnergyC2ConserveEnergy c1) (edge ConserveEnergyC2ConserveEnergy c2))
	(= c1 c2)
)))
;ConserveEnergyC2ConserveEnergy is Distinct
(assert	(forall ((c DependerLink)) (=>
	(edge ConserveEnergyC2ConserveEnergy c)
	(not (or
		(edge ProtectPersonalInformationC2ProtectPersonalInformation c)
		(edge SaveTimeC2SaveTime c)
		(edge BeInformedOfUsage2Data c)
		(edge BeInformedOfUsage2BillingDataFeedback c)
		(edge StoreAndExecutePolicies2Policies c)
		(edge EncryptData2EncryptionKeys1 c)
		(edge EncryptData2EncryptionKeys2 c)
		(edge CommunicateWithTheHouse2UseHANToCommunicate c)
		(edge CommunicateWithTheHouse2UseHGToCommunicate c)
		(edge ProvideAddedValueServices2OtherData c)
		(edge StoreAggregatedBillingDataESS2AggregatedBillingData c)
		(edge StoreAggregatedBillingDataAS2AggregatedBillingData c)
		(edge Indirectly2ControlSmartAppliances c)
		(edge DisplayData2BillingData c)
	))
)))
;ConserveEnergy2ConserveEnergyEMS Exists
(assert (exists ((c DependeeLink)) (edge ConserveEnergy2ConserveEnergyEMS c)))
;ConserveEnergy2ConserveEnergyEMS is Unique
(assert	(forall ((c1 DependeeLink) (c2 DependeeLink)) (=>
	(and (edge ConserveEnergy2ConserveEnergyEMS c1) (edge ConserveEnergy2ConserveEnergyEMS c2))
	(= c1 c2)
)))
;ConserveEnergy2ConserveEnergyEMS is Distinct
(assert	(forall ((c DependeeLink)) (=>
	(edge ConserveEnergy2ConserveEnergyEMS c)
	(not (or
		(edge ProtectPersonalInformation2ProtectPersonalInformationEMS c)
		(edge SaveTime2SaveTimeEMS c)
		(edge Data2DisplayData c)
		(edge BillingDataFeedback2DisplayData c)
		(edge Policies2DefinePolicies c)
		(edge EncryptionKeys12ManageEncryptionKeys c)
		(edge EncryptionKeys22MeterPointOperator c)
		(edge UseHANToCommunicate2HomeAreaNetwork c)
		(edge UseHGToCommunicate2HomeGateway c)
		(edge OtherData2HomeGateway c)
		(edge AggregatedBillingData2SmartMeter c)
		(edge ControlSmartAppliances2SmartMeter c)
		(edge BillingData2SmartMeter c)
	))
)))
;Data Exists
(assert (exists ((c Resource)) (node Data c)))
;Data is Unique
(assert	(forall ((c1 Resource) (c2 Resource)) (=>
	(and (node Data c1) (node Data c2))
	(= c1 c2)
)))
;Data is Distinct
(assert	(forall ((c Resource)) (=>
	(node Data c)
	(not (or
		(node HomeAreaNetworkEMS c)
		(node HomeGatewayEMS c)
	))
)))
;BeInformedOfUsage2Data Exists
(assert (exists ((c DependerLink)) (edge BeInformedOfUsage2Data c)))
;BeInformedOfUsage2Data is Unique
(assert	(forall ((c1 DependerLink) (c2 DependerLink)) (=>
	(and (edge BeInformedOfUsage2Data c1) (edge BeInformedOfUsage2Data c2))
	(= c1 c2)
)))
;BeInformedOfUsage2Data is Distinct
(assert	(forall ((c DependerLink)) (=>
	(edge BeInformedOfUsage2Data c)
	(not (or
		(edge ProtectPersonalInformationC2ProtectPersonalInformation c)
		(edge SaveTimeC2SaveTime c)
		(edge ConserveEnergyC2ConserveEnergy c)
		(edge CommunicateWithTheHouse2UseHANToCommunicate c)
		(edge CommunicateWithTheHouse2UseHGToCommunicate c)
		(edge Indirectly2ControlSmartAppliances c)
	))
)))
;Data2DisplayData Exists
(assert (exists ((c DependeeLink)) (edge Data2DisplayData c)))
;Data2DisplayData is Unique
(assert	(forall ((c1 DependeeLink) (c2 DependeeLink)) (=>
	(and (edge Data2DisplayData c1) (edge Data2DisplayData c2))
	(= c1 c2)
)))
;Data2DisplayData is Distinct
(assert	(forall ((c DependeeLink)) (=>
	(edge Data2DisplayData c)
	(not (or
		(edge ProtectPersonalInformation2ProtectPersonalInformationEMS c)
		(edge SaveTime2SaveTimeEMS c)
		(edge ConserveEnergy2ConserveEnergyEMS c)
		(edge UseHANToCommunicate2HomeAreaNetwork c)
		(edge UseHGToCommunicate2HomeGateway c)
		(edge ControlSmartAppliances2SmartMeter c)
	))
)))
;BillingDataFeedback Exists
(assert (exists ((c Resource)) (node BillingDataFeedback c)))
;BillingDataFeedback is Unique
(assert	(forall ((c1 Resource) (c2 Resource)) (=>
	(and (node BillingDataFeedback c1) (node BillingDataFeedback c2))
	(= c1 c2)
)))
;BillingDataFeedback is Distinct
(assert	(forall ((c Resource)) (=>
	(node BillingDataFeedback c)
	(not (or
		(node HomeAreaNetworkEMS c)
		(node HomeGatewayEMS c)
	))
)))
;BeInformedOfUsage2BillingDataFeedback Exists
(assert (exists ((c DependerLink)) (edge BeInformedOfUsage2BillingDataFeedback c)))
;BeInformedOfUsage2BillingDataFeedback is Unique
(assert	(forall ((c1 DependerLink) (c2 DependerLink)) (=>
	(and (edge BeInformedOfUsage2BillingDataFeedback c1) (edge BeInformedOfUsage2BillingDataFeedback c2))
	(= c1 c2)
)))
;BeInformedOfUsage2BillingDataFeedback is Distinct
(assert	(forall ((c DependerLink)) (=>
	(edge BeInformedOfUsage2BillingDataFeedback c)
	(not (or
		(edge ProtectPersonalInformationC2ProtectPersonalInformation c)
		(edge SaveTimeC2SaveTime c)
		(edge ConserveEnergyC2ConserveEnergy c)
		(edge CommunicateWithTheHouse2UseHANToCommunicate c)
		(edge CommunicateWithTheHouse2UseHGToCommunicate c)
		(edge Indirectly2ControlSmartAppliances c)
	))
)))
;BillingDataFeedback2DisplayData is Unique
(assert	(forall ((c1 DependeeLink) (c2 DependeeLink)) (=>
	(and (edge BillingDataFeedback2DisplayData c1) (edge BillingDataFeedback2DisplayData c2))
	(= c1 c2)
)))
;BillingDataFeedback2DisplayData is Distinct
(assert	(forall ((c DependeeLink)) (=>
	(edge BillingDataFeedback2DisplayData c)
	(not (or
		(edge ProtectPersonalInformation2ProtectPersonalInformationEMS c)
		(edge SaveTime2SaveTimeEMS c)
		(edge ConserveEnergy2ConserveEnergyEMS c)
		(edge UseHANToCommunicate2HomeAreaNetwork c)
		(edge UseHGToCommunicate2HomeGateway c)
		(edge ControlSmartAppliances2SmartMeter c)
	))
)))
;Policies Exists
(assert (exists ((c Resource)) (node Policies c)))
;Policies is Unique
(assert	(forall ((c1 Resource) (c2 Resource)) (=>
	(and (node Policies c1) (node Policies c2))
	(= c1 c2)
)))
;Policies is Distinct
(assert	(forall ((c Resource)) (=>
	(node Policies c)
	(not (or
		(node HomeAreaNetworkEMS c)
		(node HomeGatewayEMS c)
		(node EncryptionKeys1 c)
		(node EncryptionKeys2 c)
		(node OtherData c)
		(node AggregatedBillingData c)
		(node BillingData c)
	))
)))
;StoreAndExecutePolicies2Policies Exists
(assert (exists ((c DependerLink)) (edge StoreAndExecutePolicies2Policies c)))
;StoreAndExecutePolicies2Policies is Unique
(assert	(forall ((c1 DependerLink) (c2 DependerLink)) (=>
	(and (edge StoreAndExecutePolicies2Policies c1) (edge StoreAndExecutePolicies2Policies c2))
	(= c1 c2)
)))
;StoreAndExecutePolicies2Policies is Distinct
(assert	(forall ((c DependerLink)) (=>
	(edge StoreAndExecutePolicies2Policies c)
	(not (or
		(edge ProtectPersonalInformationC2ProtectPersonalInformation c)
		(edge SaveTimeC2SaveTime c)
		(edge ConserveEnergyC2ConserveEnergy c)
		(edge EncryptData2EncryptionKeys1 c)
		(edge EncryptData2EncryptionKeys2 c)
		(edge CommunicateWithTheHouse2UseHANToCommunicate c)
		(edge CommunicateWithTheHouse2UseHGToCommunicate c)
		(edge ProvideAddedValueServices2OtherData c)
		(edge StoreAggregatedBillingDataESS2AggregatedBillingData c)
		(edge StoreAggregatedBillingDataAS2AggregatedBillingData c)
		(edge Indirectly2ControlSmartAppliances c)
		(edge DisplayData2BillingData c)
	))
)))
;Policies2DefinePolicies Exists
(assert (exists ((c DependeeLink)) (edge Policies2DefinePolicies c)))
;Policies2DefinePolicies is Unique
(assert	(forall ((c1 DependeeLink) (c2 DependeeLink)) (=>
	(and (edge Policies2DefinePolicies c1) (edge Policies2DefinePolicies c2))
	(= c1 c2)
)))
;Policies2DefinePolicies is Distinct
(assert	(forall ((c DependeeLink)) (=>
	(edge Policies2DefinePolicies c)
	(not (or
		(edge ProtectPersonalInformation2ProtectPersonalInformationEMS c)
		(edge SaveTime2SaveTimeEMS c)
		(edge ConserveEnergy2ConserveEnergyEMS c)
		(edge EncryptionKeys12ManageEncryptionKeys c)
		(edge EncryptionKeys22MeterPointOperator c)
		(edge UseHANToCommunicate2HomeAreaNetwork c)
		(edge UseHGToCommunicate2HomeGateway c)
		(edge OtherData2HomeGateway c)
		(edge AggregatedBillingData2SmartMeter c)
		(edge ControlSmartAppliances2SmartMeter c)
		(edge BillingData2SmartMeter c)
	))
)))
;EncryptionKeys1 is Unique
(assert	(forall ((c1 Resource) (c2 Resource)) (=>
	(and (node EncryptionKeys1 c1) (node EncryptionKeys1 c2))
	(= c1 c2)
)))
;EncryptionKeys1 is Distinct
(assert	(forall ((c Resource)) (=>
	(node EncryptionKeys1 c)
	(not (or
		(node HomeAreaNetworkEMS c)
		(node HomeGatewayEMS c)
		(node Policies c)
		(node EncryptionKeys2 c)
		(node OtherData c)
		(node AggregatedBillingData c)
		(node BillingData c)
	))
)))
;EncryptData2EncryptionKeys1 is Unique
(assert	(forall ((c1 DependerLink) (c2 DependerLink)) (=>
	(and (edge EncryptData2EncryptionKeys1 c1) (edge EncryptData2EncryptionKeys1 c2))
	(= c1 c2)
)))
;EncryptData2EncryptionKeys1 is Distinct
(assert	(forall ((c DependerLink)) (=>
	(edge EncryptData2EncryptionKeys1 c)
	(not (or
		(edge ProtectPersonalInformationC2ProtectPersonalInformation c)
		(edge SaveTimeC2SaveTime c)
		(edge ConserveEnergyC2ConserveEnergy c)
		(edge StoreAndExecutePolicies2Policies c)
		(edge EncryptData2EncryptionKeys2 c)
		(edge CommunicateWithTheHouse2UseHANToCommunicate c)
		(edge CommunicateWithTheHouse2UseHGToCommunicate c)
		(edge ProvideAddedValueServices2OtherData c)
		(edge StoreAggregatedBillingDataESS2AggregatedBillingData c)
		(edge StoreAggregatedBillingDataAS2AggregatedBillingData c)
		(edge Indirectly2ControlSmartAppliances c)
		(edge DisplayData2BillingData c)
	))
)))
;EncryptionKeys12ManageEncryptionKeys is Unique
(assert	(forall ((c1 DependeeLink) (c2 DependeeLink)) (=>
	(and (edge EncryptionKeys12ManageEncryptionKeys c1) (edge EncryptionKeys12ManageEncryptionKeys c2))
	(= c1 c2)
)))
;EncryptionKeys12ManageEncryptionKeys is Distinct
(assert	(forall ((c DependeeLink)) (=>
	(edge EncryptionKeys12ManageEncryptionKeys c)
	(not (or
		(edge ProtectPersonalInformation2ProtectPersonalInformationEMS c)
		(edge SaveTime2SaveTimeEMS c)
		(edge ConserveEnergy2ConserveEnergyEMS c)
		(edge Policies2DefinePolicies c)
		(edge EncryptionKeys22MeterPointOperator c)
		(edge UseHANToCommunicate2HomeAreaNetwork c)
		(edge UseHGToCommunicate2HomeGateway c)
		(edge OtherData2HomeGateway c)
		(edge AggregatedBillingData2SmartMeter c)
		(edge ControlSmartAppliances2SmartMeter c)
		(edge BillingData2SmartMeter c)
	))
)))
;EncryptionKeys2 is Unique
(assert	(forall ((c1 Resource) (c2 Resource)) (=>
	(and (node EncryptionKeys2 c1) (node EncryptionKeys2 c2))
	(= c1 c2)
)))
;EncryptionKeys2 is Distinct
(assert	(forall ((c Resource)) (=>
	(node EncryptionKeys2 c)
	(not (or
		(node HomeAreaNetworkEMS c)
		(node HomeGatewayEMS c)
		(node Policies c)
		(node EncryptionKeys1 c)
		(node OtherData c)
		(node AggregatedBillingData c)
		(node BillingData c)
	))
)))
;EncryptData2EncryptionKeys2 is Unique
(assert	(forall ((c1 DependerLink) (c2 DependerLink)) (=>
	(and (edge EncryptData2EncryptionKeys2 c1) (edge EncryptData2EncryptionKeys2 c2))
	(= c1 c2)
)))
;EncryptData2EncryptionKeys2 is Distinct
(assert	(forall ((c DependerLink)) (=>
	(edge EncryptData2EncryptionKeys2 c)
	(not (or
		(edge ProtectPersonalInformationC2ProtectPersonalInformation c)
		(edge SaveTimeC2SaveTime c)
		(edge ConserveEnergyC2ConserveEnergy c)
		(edge StoreAndExecutePolicies2Policies c)
		(edge EncryptData2EncryptionKeys1 c)
		(edge CommunicateWithTheHouse2UseHANToCommunicate c)
		(edge CommunicateWithTheHouse2UseHGToCommunicate c)
		(edge ProvideAddedValueServices2OtherData c)
		(edge StoreAggregatedBillingDataESS2AggregatedBillingData c)
		(edge StoreAggregatedBillingDataAS2AggregatedBillingData c)
		(edge Indirectly2ControlSmartAppliances c)
		(edge DisplayData2BillingData c)
	))
)))
;EncryptionKeys22MeterPointOperator is Unique
(assert	(forall ((c1 DependeeLink) (c2 DependeeLink)) (=>
	(and (edge EncryptionKeys22MeterPointOperator c1) (edge EncryptionKeys22MeterPointOperator c2))
	(= c1 c2)
)))
;EncryptionKeys22MeterPointOperator is Distinct
(assert	(forall ((c DependeeLink)) (=>
	(edge EncryptionKeys22MeterPointOperator c)
	(not (or
		(edge ProtectPersonalInformation2ProtectPersonalInformationEMS c)
		(edge SaveTime2SaveTimeEMS c)
		(edge ConserveEnergy2ConserveEnergyEMS c)
		(edge Policies2DefinePolicies c)
		(edge EncryptionKeys12ManageEncryptionKeys c)
		(edge UseHANToCommunicate2HomeAreaNetwork c)
		(edge UseHGToCommunicate2HomeGateway c)
		(edge OtherData2HomeGateway c)
		(edge AggregatedBillingData2SmartMeter c)
		(edge ControlSmartAppliances2SmartMeter c)
		(edge BillingData2SmartMeter c)
	))
)))
;UseHANToCommunicate is Unique
(assert	(forall ((c1 Goal) (c2 Goal)) (=>
	(and (node UseHANToCommunicate c1) (node UseHANToCommunicate c2))
	(= c1 c2)
)))
;UseHANToCommunicate is Distinct
(assert	(forall ((c Goal)) (=>
	(node UseHANToCommunicate c)
	(not (or
		(node ConsumeEnergyC c)
		(node BeInformedOfUsage c)
		(node StoreAndExecutePolicies c)
		(node CommunicateWithTheHouse c)
		(node ControlSmartAppliancesEMS c)
		(node HandleSecurity c)
		(node StoreAggregatedBillingDataESS c)
		(node ProvideAddedValueServices c)
		(node StoreAggregatedBillingDataAS c)
		(node UseHGToCommunicate c)
		(node ControlSmartAppliances c)
	))
)))
;CommunicateWithTheHouse2UseHANToCommunicate is Unique
(assert	(forall ((c1 DependerLink) (c2 DependerLink)) (=>
	(and (edge CommunicateWithTheHouse2UseHANToCommunicate c1) (edge CommunicateWithTheHouse2UseHANToCommunicate c2))
	(= c1 c2)
)))
;CommunicateWithTheHouse2UseHANToCommunicate is Distinct
(assert	(forall ((c DependerLink)) (=>
	(edge CommunicateWithTheHouse2UseHANToCommunicate c)
	(not (or
		(edge ProtectPersonalInformationC2ProtectPersonalInformation c)
		(edge SaveTimeC2SaveTime c)
		(edge ConserveEnergyC2ConserveEnergy c)
		(edge BeInformedOfUsage2Data c)
		(edge BeInformedOfUsage2BillingDataFeedback c)
		(edge StoreAndExecutePolicies2Policies c)
		(edge EncryptData2EncryptionKeys1 c)
		(edge EncryptData2EncryptionKeys2 c)
		(edge CommunicateWithTheHouse2UseHGToCommunicate c)
		(edge ProvideAddedValueServices2OtherData c)
		(edge StoreAggregatedBillingDataESS2AggregatedBillingData c)
		(edge StoreAggregatedBillingDataAS2AggregatedBillingData c)
		(edge Indirectly2ControlSmartAppliances c)
		(edge DisplayData2BillingData c)
	))
)))
;UseHANToCommunicate2HomeAreaNetwork is Unique
(assert	(forall ((c1 DependeeLink) (c2 DependeeLink)) (=>
	(and (edge UseHANToCommunicate2HomeAreaNetwork c1) (edge UseHANToCommunicate2HomeAreaNetwork c2))
	(= c1 c2)
)))
;UseHANToCommunicate2HomeAreaNetwork is Distinct
(assert	(forall ((c DependeeLink)) (=>
	(edge UseHANToCommunicate2HomeAreaNetwork c)
	(not (or
		(edge ProtectPersonalInformation2ProtectPersonalInformationEMS c)
		(edge SaveTime2SaveTimeEMS c)
		(edge ConserveEnergy2ConserveEnergyEMS c)
		(edge Data2DisplayData c)
		(edge BillingDataFeedback2DisplayData c)
		(edge Policies2DefinePolicies c)
		(edge EncryptionKeys12ManageEncryptionKeys c)
		(edge EncryptionKeys22MeterPointOperator c)
		(edge UseHGToCommunicate2HomeGateway c)
		(edge OtherData2HomeGateway c)
		(edge AggregatedBillingData2SmartMeter c)
		(edge ControlSmartAppliances2SmartMeter c)
		(edge BillingData2SmartMeter c)
	))
)))
;UseHGToCommunicate is Unique
(assert	(forall ((c1 Goal) (c2 Goal)) (=>
	(and (node UseHGToCommunicate c1) (node UseHGToCommunicate c2))
	(= c1 c2)
)))
;UseHGToCommunicate is Distinct
(assert	(forall ((c Goal)) (=>
	(node UseHGToCommunicate c)
	(not (or
		(node ConsumeEnergyC c)
		(node BeInformedOfUsage c)
		(node StoreAndExecutePolicies c)
		(node CommunicateWithTheHouse c)
		(node ControlSmartAppliancesEMS c)
		(node HandleSecurity c)
		(node StoreAggregatedBillingDataESS c)
		(node ProvideAddedValueServices c)
		(node StoreAggregatedBillingDataAS c)
		(node UseHANToCommunicate c)
		(node ControlSmartAppliances c)
	))
)))
;CommunicateWithTheHouse2UseHGToCommunicate is Unique
(assert	(forall ((c1 DependerLink) (c2 DependerLink)) (=>
	(and (edge CommunicateWithTheHouse2UseHGToCommunicate c1) (edge CommunicateWithTheHouse2UseHGToCommunicate c2))
	(= c1 c2)
)))
;CommunicateWithTheHouse2UseHGToCommunicate is Distinct
(assert	(forall ((c DependerLink)) (=>
	(edge CommunicateWithTheHouse2UseHGToCommunicate c)
	(not (or
		(edge ProtectPersonalInformationC2ProtectPersonalInformation c)
		(edge SaveTimeC2SaveTime c)
		(edge ConserveEnergyC2ConserveEnergy c)
		(edge BeInformedOfUsage2Data c)
		(edge BeInformedOfUsage2BillingDataFeedback c)
		(edge StoreAndExecutePolicies2Policies c)
		(edge EncryptData2EncryptionKeys1 c)
		(edge EncryptData2EncryptionKeys2 c)
		(edge CommunicateWithTheHouse2UseHANToCommunicate c)
		(edge ProvideAddedValueServices2OtherData c)
		(edge StoreAggregatedBillingDataESS2AggregatedBillingData c)
		(edge StoreAggregatedBillingDataAS2AggregatedBillingData c)
		(edge Indirectly2ControlSmartAppliances c)
		(edge DisplayData2BillingData c)
	))
)))
;UseHGToCommunicate2HomeGateway is Unique
(assert	(forall ((c1 DependeeLink) (c2 DependeeLink)) (=>
	(and (edge UseHGToCommunicate2HomeGateway c1) (edge UseHGToCommunicate2HomeGateway c2))
	(= c1 c2)
)))
;UseHGToCommunicate2HomeGateway is Distinct
(assert	(forall ((c DependeeLink)) (=>
	(edge UseHGToCommunicate2HomeGateway c)
	(not (or
		(edge ProtectPersonalInformation2ProtectPersonalInformationEMS c)
		(edge SaveTime2SaveTimeEMS c)
		(edge ConserveEnergy2ConserveEnergyEMS c)
		(edge Data2DisplayData c)
		(edge BillingDataFeedback2DisplayData c)
		(edge Policies2DefinePolicies c)
		(edge EncryptionKeys12ManageEncryptionKeys c)
		(edge EncryptionKeys22MeterPointOperator c)
		(edge UseHANToCommunicate2HomeAreaNetwork c)
		(edge OtherData2HomeGateway c)
		(edge AggregatedBillingData2SmartMeter c)
		(edge ControlSmartAppliances2SmartMeter c)
		(edge BillingData2SmartMeter c)
	))
)))
;OtherData Exists
(assert (exists ((c Resource)) (node OtherData c)))
;OtherData is Distinct
(assert	(forall ((c Resource)) (=>
	(node OtherData c)
	(not (or
		(node HomeAreaNetworkEMS c)
		(node HomeGatewayEMS c)
		(node Policies c)
		(node EncryptionKeys1 c)
		(node EncryptionKeys2 c)
		(node AggregatedBillingData c)
		(node BillingData c)
	))
)))
;ProvideAddedValueServices2OtherData Exists
(assert (exists ((c DependerLink)) (edge ProvideAddedValueServices2OtherData c)))
;ProvideAddedValueServices2OtherData is Distinct
(assert	(forall ((c DependerLink)) (=>
	(edge ProvideAddedValueServices2OtherData c)
	(not (or
		(edge ProtectPersonalInformationC2ProtectPersonalInformation c)
		(edge SaveTimeC2SaveTime c)
		(edge ConserveEnergyC2ConserveEnergy c)
		(edge StoreAndExecutePolicies2Policies c)
		(edge EncryptData2EncryptionKeys1 c)
		(edge EncryptData2EncryptionKeys2 c)
		(edge CommunicateWithTheHouse2UseHANToCommunicate c)
		(edge CommunicateWithTheHouse2UseHGToCommunicate c)
		(edge StoreAggregatedBillingDataESS2AggregatedBillingData c)
		(edge StoreAggregatedBillingDataAS2AggregatedBillingData c)
		(edge Indirectly2ControlSmartAppliances c)
		(edge DisplayData2BillingData c)
	))
)))
;OtherData2HomeGateway Exists
(assert (exists ((c DependeeLink)) (edge OtherData2HomeGateway c)))
;OtherData2HomeGateway is Distinct
(assert	(forall ((c DependeeLink)) (=>
	(edge OtherData2HomeGateway c)
	(not (or
		(edge ProtectPersonalInformation2ProtectPersonalInformationEMS c)
		(edge SaveTime2SaveTimeEMS c)
		(edge ConserveEnergy2ConserveEnergyEMS c)
		(edge Policies2DefinePolicies c)
		(edge EncryptionKeys12ManageEncryptionKeys c)
		(edge EncryptionKeys22MeterPointOperator c)
		(edge UseHANToCommunicate2HomeAreaNetwork c)
		(edge UseHGToCommunicate2HomeGateway c)
		(edge AggregatedBillingData2SmartMeter c)
		(edge ControlSmartAppliances2SmartMeter c)
		(edge BillingData2SmartMeter c)
	))
)))
;AggregatedBillingData Exists
(assert (exists ((c Resource)) (node AggregatedBillingData c)))
;AggregatedBillingData is Unique
(assert	(forall ((c1 Resource) (c2 Resource)) (=>
	(and (node AggregatedBillingData c1) (node AggregatedBillingData c2))
	(= c1 c2)
)))
;AggregatedBillingData is Distinct
(assert	(forall ((c Resource)) (=>
	(node AggregatedBillingData c)
	(not (or
		(node HomeAreaNetworkEMS c)
		(node HomeGatewayEMS c)
		(node Policies c)
		(node EncryptionKeys1 c)
		(node EncryptionKeys2 c)
		(node OtherData c)
		(node BillingData c)
	))
)))
;StoreAggregatedBillingDataESS2AggregatedBillingData Exists
(assert (exists ((c DependerLink)) (edge StoreAggregatedBillingDataESS2AggregatedBillingData c)))
;StoreAggregatedBillingDataESS2AggregatedBillingData is Unique
(assert	(forall ((c1 DependerLink) (c2 DependerLink)) (=>
	(and (edge StoreAggregatedBillingDataESS2AggregatedBillingData c1) (edge StoreAggregatedBillingDataESS2AggregatedBillingData c2))
	(= c1 c2)
)))
;StoreAggregatedBillingDataESS2AggregatedBillingData is Distinct
(assert	(forall ((c DependerLink)) (=>
	(edge StoreAggregatedBillingDataESS2AggregatedBillingData c)
	(not (or
		(edge ProtectPersonalInformationC2ProtectPersonalInformation c)
		(edge SaveTimeC2SaveTime c)
		(edge ConserveEnergyC2ConserveEnergy c)
		(edge StoreAndExecutePolicies2Policies c)
		(edge EncryptData2EncryptionKeys1 c)
		(edge EncryptData2EncryptionKeys2 c)
		(edge CommunicateWithTheHouse2UseHANToCommunicate c)
		(edge CommunicateWithTheHouse2UseHGToCommunicate c)
		(edge ProvideAddedValueServices2OtherData c)
		(edge Indirectly2ControlSmartAppliances c)
		(edge DisplayData2BillingData c)
	))
)))
;StoreAggregatedBillingDataAS2AggregatedBillingData is Unique
(assert	(forall ((c1 DependerLink) (c2 DependerLink)) (=>
	(and (edge StoreAggregatedBillingDataAS2AggregatedBillingData c1) (edge StoreAggregatedBillingDataAS2AggregatedBillingData c2))
	(= c1 c2)
)))
;StoreAggregatedBillingDataAS2AggregatedBillingData is Distinct
(assert	(forall ((c DependerLink)) (=>
	(edge StoreAggregatedBillingDataAS2AggregatedBillingData c)
	(not (or
		(edge ProtectPersonalInformationC2ProtectPersonalInformation c)
		(edge SaveTimeC2SaveTime c)
		(edge ConserveEnergyC2ConserveEnergy c)
		(edge StoreAndExecutePolicies2Policies c)
		(edge EncryptData2EncryptionKeys1 c)
		(edge EncryptData2EncryptionKeys2 c)
		(edge CommunicateWithTheHouse2UseHANToCommunicate c)
		(edge CommunicateWithTheHouse2UseHGToCommunicate c)
		(edge ProvideAddedValueServices2OtherData c)
		(edge Indirectly2ControlSmartAppliances c)
		(edge DisplayData2BillingData c)
	))
)))
;AggregatedBillingData2SmartMeter Exists
(assert (exists ((c DependeeLink)) (edge AggregatedBillingData2SmartMeter c)))
;AggregatedBillingData2SmartMeter is Unique
(assert	(forall ((c1 DependeeLink) (c2 DependeeLink)) (=>
	(and (edge AggregatedBillingData2SmartMeter c1) (edge AggregatedBillingData2SmartMeter c2))
	(= c1 c2)
)))
;AggregatedBillingData2SmartMeter is Distinct
(assert	(forall ((c DependeeLink)) (=>
	(edge AggregatedBillingData2SmartMeter c)
	(not (or
		(edge ProtectPersonalInformation2ProtectPersonalInformationEMS c)
		(edge SaveTime2SaveTimeEMS c)
		(edge ConserveEnergy2ConserveEnergyEMS c)
		(edge Policies2DefinePolicies c)
		(edge EncryptionKeys12ManageEncryptionKeys c)
		(edge EncryptionKeys22MeterPointOperator c)
		(edge UseHANToCommunicate2HomeAreaNetwork c)
		(edge UseHGToCommunicate2HomeGateway c)
		(edge OtherData2HomeGateway c)
		(edge ControlSmartAppliances2SmartMeter c)
		(edge BillingData2SmartMeter c)
	))
)))
;ControlSmartAppliances Exists
(assert (exists ((c Goal)) (node ControlSmartAppliances c)))
;ControlSmartAppliances is Unique
(assert	(forall ((c1 Goal) (c2 Goal)) (=>
	(and (node ControlSmartAppliances c1) (node ControlSmartAppliances c2))
	(= c1 c2)
)))
;ControlSmartAppliances is Distinct
(assert	(forall ((c Goal)) (=>
	(node ControlSmartAppliances c)
	(not (or
		(node ConsumeEnergyC c)
		(node BeInformedOfUsage c)
		(node StoreAndExecutePolicies c)
		(node CommunicateWithTheHouse c)
		(node ControlSmartAppliancesEMS c)
		(node HandleSecurity c)
		(node StoreAggregatedBillingDataESS c)
		(node ProvideAddedValueServices c)
		(node StoreAggregatedBillingDataAS c)
		(node UseHANToCommunicate c)
		(node UseHGToCommunicate c)
	))
)))
;Indirectly2ControlSmartAppliances Exists
(assert (exists ((c DependerLink)) (edge Indirectly2ControlSmartAppliances c)))
;Indirectly2ControlSmartAppliances is Unique
(assert	(forall ((c1 DependerLink) (c2 DependerLink)) (=>
	(and (edge Indirectly2ControlSmartAppliances c1) (edge Indirectly2ControlSmartAppliances c2))
	(= c1 c2)
)))
;Indirectly2ControlSmartAppliances is Distinct
(assert	(forall ((c DependerLink)) (=>
	(edge Indirectly2ControlSmartAppliances c)
	(not (or
		(edge ProtectPersonalInformationC2ProtectPersonalInformation c)
		(edge SaveTimeC2SaveTime c)
		(edge ConserveEnergyC2ConserveEnergy c)
		(edge BeInformedOfUsage2Data c)
		(edge BeInformedOfUsage2BillingDataFeedback c)
		(edge StoreAndExecutePolicies2Policies c)
		(edge EncryptData2EncryptionKeys1 c)
		(edge EncryptData2EncryptionKeys2 c)
		(edge CommunicateWithTheHouse2UseHANToCommunicate c)
		(edge CommunicateWithTheHouse2UseHGToCommunicate c)
		(edge ProvideAddedValueServices2OtherData c)
		(edge StoreAggregatedBillingDataESS2AggregatedBillingData c)
		(edge StoreAggregatedBillingDataAS2AggregatedBillingData c)
		(edge DisplayData2BillingData c)
	))
)))
;ControlSmartAppliances2SmartMeter Exists
(assert (exists ((c DependeeLink)) (edge ControlSmartAppliances2SmartMeter c)))
;ControlSmartAppliances2SmartMeter is Unique
(assert	(forall ((c1 DependeeLink) (c2 DependeeLink)) (=>
	(and (edge ControlSmartAppliances2SmartMeter c1) (edge ControlSmartAppliances2SmartMeter c2))
	(= c1 c2)
)))
;ControlSmartAppliances2SmartMeter is Distinct
(assert	(forall ((c DependeeLink)) (=>
	(edge ControlSmartAppliances2SmartMeter c)
	(not (or
		(edge ProtectPersonalInformation2ProtectPersonalInformationEMS c)
		(edge SaveTime2SaveTimeEMS c)
		(edge ConserveEnergy2ConserveEnergyEMS c)
		(edge Data2DisplayData c)
		(edge BillingDataFeedback2DisplayData c)
		(edge Policies2DefinePolicies c)
		(edge EncryptionKeys12ManageEncryptionKeys c)
		(edge EncryptionKeys22MeterPointOperator c)
		(edge UseHANToCommunicate2HomeAreaNetwork c)
		(edge UseHGToCommunicate2HomeGateway c)
		(edge OtherData2HomeGateway c)
		(edge AggregatedBillingData2SmartMeter c)
		(edge BillingData2SmartMeter c)
	))
)))
;BillingData Exists
(assert (exists ((c Resource)) (node BillingData c)))
;BillingData is Unique
(assert	(forall ((c1 Resource) (c2 Resource)) (=>
	(and (node BillingData c1) (node BillingData c2))
	(= c1 c2)
)))
;BillingData is Distinct
(assert	(forall ((c Resource)) (=>
	(node BillingData c)
	(not (or
		(node HomeAreaNetworkEMS c)
		(node HomeGatewayEMS c)
		(node Policies c)
		(node EncryptionKeys1 c)
		(node EncryptionKeys2 c)
		(node OtherData c)
		(node AggregatedBillingData c)
	))
)))
;DisplayData2BillingData Exists
(assert (exists ((c DependerLink)) (edge DisplayData2BillingData c)))
;DisplayData2BillingData is Unique
(assert	(forall ((c1 DependerLink) (c2 DependerLink)) (=>
	(and (edge DisplayData2BillingData c1) (edge DisplayData2BillingData c2))
	(= c1 c2)
)))
;DisplayData2BillingData is Distinct
(assert	(forall ((c DependerLink)) (=>
	(edge DisplayData2BillingData c)
	(not (or
		(edge ProtectPersonalInformationC2ProtectPersonalInformation c)
		(edge SaveTimeC2SaveTime c)
		(edge ConserveEnergyC2ConserveEnergy c)
		(edge StoreAndExecutePolicies2Policies c)
		(edge EncryptData2EncryptionKeys1 c)
		(edge EncryptData2EncryptionKeys2 c)
		(edge CommunicateWithTheHouse2UseHANToCommunicate c)
		(edge CommunicateWithTheHouse2UseHGToCommunicate c)
		(edge ProvideAddedValueServices2OtherData c)
		(edge StoreAggregatedBillingDataESS2AggregatedBillingData c)
		(edge StoreAggregatedBillingDataAS2AggregatedBillingData c)
		(edge Indirectly2ControlSmartAppliances c)
	))
)))
;BillingData2SmartMeter Exists
(assert (exists ((c DependeeLink)) (edge BillingData2SmartMeter c)))
;BillingData2SmartMeter is Unique
(assert	(forall ((c1 DependeeLink) (c2 DependeeLink)) (=>
	(and (edge BillingData2SmartMeter c1) (edge BillingData2SmartMeter c2))
	(= c1 c2)
)))
;BillingData2SmartMeter is Distinct
(assert	(forall ((c DependeeLink)) (=>
	(edge BillingData2SmartMeter c)
	(not (or
		(edge ProtectPersonalInformation2ProtectPersonalInformationEMS c)
		(edge SaveTime2SaveTimeEMS c)
		(edge ConserveEnergy2ConserveEnergyEMS c)
		(edge Policies2DefinePolicies c)
		(edge EncryptionKeys12ManageEncryptionKeys c)
		(edge EncryptionKeys22MeterPointOperator c)
		(edge UseHANToCommunicate2HomeAreaNetwork c)
		(edge UseHGToCommunicate2HomeGateway c)
		(edge OtherData2HomeGateway c)
		(edge AggregatedBillingData2SmartMeter c)
		(edge ControlSmartAppliances2SmartMeter c)
	))
)))
;D1-D1A1 Alternative elements
(declare-fun D1A1 () Bool)
(assert (= D1A1 (and
	(exists ((c Task)) (node ManageEncryptionKeys c))
	(exists ((c Resource)) (node EncryptionKeys1 c))
	(exists ((c DependerLink)) (edge EncryptData2EncryptionKeys1 c))
	(exists ((c DependeeLink)) (edge EncryptionKeys12ManageEncryptionKeys c))
)))
(assert (=>
	(not D1A1)
	(not (or
		(exists ((c Task)) (node ManageEncryptionKeys c))
		(exists ((c Resource)) (node EncryptionKeys1 c))
		(exists ((c DependerLink)) (edge EncryptData2EncryptionKeys1 c))
		(exists ((c DependeeLink)) (edge EncryptionKeys12ManageEncryptionKeys c))
	))
))
;D1-D1A2 Alternative elements
(declare-fun D1A2 () Bool)
(assert (= D1A2 (and
	(exists ((c Actor)) (node MeterPointOperator c))
	(exists ((c Resource)) (node EncryptionKeys2 c))
	(exists ((c DependerLink)) (edge EncryptData2EncryptionKeys2 c))
	(exists ((c DependeeLink)) (edge EncryptionKeys22MeterPointOperator c))
)))
(assert (=>
	(not D1A2)
	(not (or
		(exists ((c Actor)) (node MeterPointOperator c))
		(exists ((c Resource)) (node EncryptionKeys2 c))
		(exists ((c DependerLink)) (edge EncryptData2EncryptionKeys2 c))
		(exists ((c DependeeLink)) (edge EncryptionKeys22MeterPointOperator c))
	))
))
;D1 Decision
(assert (xor
	D1A1
	D1A2
))
;D2-D2A1 Alternative elements
(declare-fun D2A1 () Bool)
(assert (= D2A1 (and
	(exists ((c Actor)) (node HomeAreaNetwork c))
	(exists ((c Goal)) (node UseHANToCommunicate c))
	(exists ((c DependerLink)) (edge CommunicateWithTheHouse2UseHANToCommunicate c))
	(exists ((c DependeeLink)) (edge UseHANToCommunicate2HomeAreaNetwork c))
)))
(assert (=>
	(not D2A1)
	(not (or
		(exists ((c Actor)) (node HomeAreaNetwork c))
		(exists ((c Goal)) (node UseHANToCommunicate c))
		(exists ((c DependerLink)) (edge CommunicateWithTheHouse2UseHANToCommunicate c))
		(exists ((c DependeeLink)) (edge UseHANToCommunicate2HomeAreaNetwork c))
	))
))
;D2-D2A2 Alternative elements
(declare-fun D2A2 () Bool)
(assert (= D2A2 (and
	(exists ((c Actor)) (node HomeGateway c))
	(exists ((c Goal)) (node UseHGToCommunicate c))
	(exists ((c DependerLink)) (edge CommunicateWithTheHouse2UseHGToCommunicate c))
	(exists ((c DependeeLink)) (edge UseHGToCommunicate2HomeGateway c))
)))
(assert (=>
	(not D2A2)
	(not (or
		(exists ((c Actor)) (node HomeGateway c))
		(exists ((c Goal)) (node UseHGToCommunicate c))
		(exists ((c DependerLink)) (edge CommunicateWithTheHouse2UseHGToCommunicate c))
		(exists ((c DependeeLink)) (edge UseHGToCommunicate2HomeGateway c))
	))
))
;D2 Decision
(assert (xor
	D2A1
	D2A2
))
;D3-D3A1 Alternative elements
(declare-fun D3A1 () Bool)
(assert (= D3A1
	(exists ((c Contribution)) (edge Directly2HELPConserveEnergyEMS c))
))
;D3-D3A2 Alternative elements
(declare-fun D3A2 () Bool)
(assert (= D3A2
	(exists ((c Contribution)) (edge Directly2HURTConserveEnergyEMS c))
))
;D3 Decision
(assert (xor
	D3A1
	D3A2
))
;D4-D4A1 Alternative elements
(declare-fun D4A1 () Bool)
(assert (= D4A1
	(exists ((c Contribution)) (edge EncryptData2MAKEProtectPersonalInformationEMS c))
))
;D4-D4A2 Alternative elements
(declare-fun D4A2 () Bool)
(assert (= D4A2
	(exists ((c Contribution)) (edge EncryptData2HELPProtectPersonalInformationEMS c))
))
;D4 Decision
(assert (xor
	D4A1
	D4A2
))
;D5-D5A merge Domain
(assert	(forall ((c Resource)) (=>
	(node Data c)
	(not (or
		(node Policies c)
		(node EncryptionKeys1 c)
		(node EncryptionKeys2 c)
		(node OtherData c)
		(node AggregatedBillingData c)
		(node BillingData c)
	))
)))
(assert	(forall ((c Resource)) (=>
	(node BillingDataFeedback c)
	(not (or
		(node Policies c)
		(node EncryptionKeys1 c)
		(node EncryptionKeys2 c)
		(node OtherData c)
		(node AggregatedBillingData c)
		(node BillingData c)
	))
)))
;D6-D6A merge Domain
(assert	(forall ((c Actor)) (=>
	(node EnergySupplierServer c)
	(not (or
		(node Consumer c)
		(node EnergyManagementSystem c)
		(node MeterPointOperator c)
		(node HomeAreaNetwork c)
		(node HomeGateway c)
		(node SmartMeter c)
	))
)))
(assert	(forall ((c Actor)) (=>
	(node AnotherServer c)
	(not (or
		(node Consumer c)
		(node EnergyManagementSystem c)
		(node MeterPointOperator c)
		(node HomeAreaNetwork c)
		(node HomeGateway c)
		(node SmartMeter c)
	))
)))
;D7-D7A merge Domain
(assert	(forall ((c Goal)) (=>
	(node StoreAggregatedBillingDataESS c)
	(not (or
		(node ConsumeEnergyC c)
		(node BeInformedOfUsage c)
		(node StoreAndExecutePolicies c)
		(node CommunicateWithTheHouse c)
		(node ControlSmartAppliancesEMS c)
		(node HandleSecurity c)
		(node ProvideAddedValueServices c)
	))
)))
(assert	(forall ((c Goal)) (=>
	(node StoreAggregatedBillingDataAS c)
	(not (or
		(node ConsumeEnergyC c)
		(node BeInformedOfUsage c)
		(node StoreAndExecutePolicies c)
		(node CommunicateWithTheHouse c)
		(node ControlSmartAppliancesEMS c)
		(node HandleSecurity c)
		(node ProvideAddedValueServices c)
	))
)))

;Contribution Types
(define-sort ContributionType () Int)
(declare-const MAKE ContributionType)
(assert (= MAKE 111))
(declare-const HELP ContributionType)
(assert (= HELP 112))
(declare-const SOMEPLUS ContributionType)
(assert (= SOMEPLUS 113))
(declare-const BREAK ContributionType)
(assert (= BREAK 114))
(declare-const HURT ContributionType)
(assert (= HURT 115))
(declare-const SOMEMINUS ContributionType)
(assert (= SOMEMINUS 116))
(declare-const UNKNOWN ContributionType)
(assert (= UNKNOWN 117))
(declare-fun type (Contribution) ContributionType)
(assert (forall ((c Contribution)) (=>
	(edge BeInformedOfUsage2ConserveEnergyC c)
	(= (type c) HELP)
)))
(assert (forall ((c Contribution)) (=>
	(edge DefinePolicies2ConserveEnergyC c)
	(= (type c) HELP)
)))
(assert (forall ((c Contribution)) (=>
	(edge ManageEncryptionKeys2ProtectPersonalInformationC c)
	(= (type c) HELP)
)))
(assert (forall ((c Contribution)) (=>
	(edge ManageEncryptionKeys2SaveTimeC c)
	(= (type c) HURT)
)))
(assert (forall ((c Contribution)) (=>
	(edge ConserveEnergyEMS2ReduceCosts c)
	(= (type c) HELP)
)))
(assert (forall ((c Contribution)) (=>
	(edge Directly2SaveTimeEMS c)
	(= (type c) HURT)
)))
(assert (forall ((c Contribution)) (=>
	(edge Directly2HURTConserveEnergyEMS c)
	(= (type c) HURT)
)))
(assert (forall ((c Contribution)) (=>
	(edge Directly2HELPConserveEnergyEMS c)
	(= (type c) HELP)
)))
(assert (forall ((c Contribution)) (=>
	(edge Indirectly2SaveTimeEMS c)
	(= (type c) HELP)
)))
(assert (forall ((c Contribution)) (=>
	(edge EncryptData2MAKEProtectPersonalInformationEMS c)
	(= (type c) MAKE)
)))
(assert (forall ((c Contribution)) (=>
	(edge EncryptData2HELPProtectPersonalInformationEMS c)
	(= (type c) HELP)
)))
(assert (forall ((c Contribution)) (=>
	(edge NoEncryption2ReduceCosts c)
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
	(node ProtectPersonalInformationC c)
	(and
		(= (fs c) false)
		(= (ps c) true)
		(= (un c) false)
		(= (co c) false)
		(= (pd c) false)
		(= (fd c) false)
		(= (no c) false)
		(= (inited c) true)
	)
)))
(assert (forall ((c SoftGoal)) (=>
	(node ConserveEnergyC c)
	(and
		(= (fs c) false)
		(= (ps c) true)
		(= (un c) false)
		(= (co c) false)
		(= (pd c) false)
		(= (fd c) false)
		(= (no c) false)
		(= (inited c) true)
	)
)))
(assert (forall ((c SoftGoal)) (=>
	(node SaveTimeC c)
	(and
		(= (fs c) false)
		(= (ps c) true)
		(= (un c) false)
		(= (co c) false)
		(= (pd c) false)
		(= (fd c) false)
		(= (no c) false)
		(= (inited c) true)
	)
)))
(assert (forall ((c Goal)) (=>
	(node ConsumeEnergyC c)
	(= (inited c) false)
)))
(assert (forall ((c Goal)) (=>
	(node BeInformedOfUsage c)
	(= (inited c) false)
)))
(assert (forall ((c Task)) (=>
	(node DefinePolicies c)
	(= (inited c) false)
)))
(assert (forall ((c Task)) (=>
	(node ManageEncryptionKeys c)
	(= (inited c) false)
)))
(assert (forall ((c SoftGoal)) (=>
	(node ReduceCosts c)
	(= (inited c) false)
)))
(assert (forall ((c Goal)) (=>
	(node StoreAndExecutePolicies c)
	(= (inited c) false)
)))
(assert (forall ((c Task)) (=>
	(node DisplayData c)
	(= (inited c) false)
)))
(assert (forall ((c Goal)) (=>
	(node CommunicateWithTheHouse c)
	(= (inited c) false)
)))
(assert (forall ((c SoftGoal)) (=>
	(node ProtectPersonalInformationEMS c)
	(= (inited c) false)
)))
(assert (forall ((c SoftGoal)) (=>
	(node SaveTimeEMS c)
	(= (inited c) false)
)))
(assert (forall ((c SoftGoal)) (=>
	(node ConserveEnergyEMS c)
	(= (inited c) false)
)))
(assert (forall ((c Goal)) (=>
	(node ControlSmartAppliancesEMS c)
	(= (inited c) false)
)))
(assert (forall ((c Task)) (=>
	(node Directly c)
	(= (inited c) false)
)))
(assert (forall ((c Task)) (=>
	(node Indirectly c)
	(= (inited c) false)
)))
(assert (forall ((c Goal)) (=>
	(node HandleSecurity c)
	(= (inited c) false)
)))
(assert (forall ((c Task)) (=>
	(node EncryptData c)
	(= (inited c) false)
)))
(assert (forall ((c Task)) (=>
	(node NoEncryption c)
	(= (inited c) false)
)))
(assert (forall ((c Resource)) (=>
	(node HomeAreaNetworkEMS c)
	(= (inited c) false)
)))
(assert (forall ((c Resource)) (=>
	(node HomeGatewayEMS c)
	(= (inited c) false)
)))
(assert (forall ((c Goal)) (=>
	(node StoreAggregatedBillingDataESS c)
	(= (inited c) false)
)))
(assert (forall ((c Goal)) (=>
	(node ProvideAddedValueServices c)
	(= (inited c) false)
)))
(assert (forall ((c Goal)) (=>
	(node StoreAggregatedBillingDataAS c)
	(= (inited c) false)
)))
(assert (forall ((c SoftGoal)) (=>
	(node ProtectPersonalInformation c)
	(= (inited c) false)
)))
(assert (forall ((c SoftGoal)) (=>
	(node SaveTime c)
	(= (inited c) false)
)))
(assert (forall ((c SoftGoal)) (=>
	(node ConserveEnergy c)
	(= (inited c) false)
)))
(assert (forall ((c Resource)) (=>
	(node Data c)
	(= (inited c) false)
)))
(assert (forall ((c Resource)) (=>
	(node BillingDataFeedback c)
	(= (inited c) false)
)))
(assert (forall ((c Resource)) (=>
	(node Policies c)
	(= (inited c) false)
)))
(assert (forall ((c Resource)) (=>
	(node EncryptionKeys1 c)
	(= (inited c) false)
)))
(assert (forall ((c Resource)) (=>
	(node EncryptionKeys2 c)
	(= (inited c) false)
)))
(assert (forall ((c Goal)) (=>
	(node UseHANToCommunicate c)
	(= (inited c) false)
)))
(assert (forall ((c Goal)) (=>
	(node UseHGToCommunicate c)
	(= (inited c) false)
)))
(assert (forall ((c Resource)) (=>
	(node OtherData c)
	(= (inited c) false)
)))
(assert (forall ((c Resource)) (=>
	(node AggregatedBillingData c)
	(= (inited c) false)
)))
(assert (forall ((c Goal)) (=>
	(node ControlSmartAppliances c)
	(= (inited c) false)
)))
(assert (forall ((c Resource)) (=>
	(node BillingData c)
	(= (inited c) false)
)))

;Goal propagation (MeansEnd + Decomposition + Depender + Dependee)
(assert	(forall ((c Goal)) (=>
	(or
		(and (exists ((mec MeansEnd)) (and (= (tgtType mec) GOAL) (= ((as tgt (Goal)) mec) c) (fs mec))) (not (exists ((dc DependerLink)) (and (= (srcType dc) GOAL) (= ((as src (Goal)) dc) c) (or (fd dc) (pd dc) (co dc) (un dc) (no dc) (ps dc))))))
		(and (exists ((dc1 Decomposition)) (and (= (tgtType dc1) GOAL) (= ((as tgt (Goal)) dc1) c) (fs dc1))) (not (exists ((dc2 Decomposition)) (and (= (tgtType dc2) GOAL) (= ((as tgt (Goal)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (no dc2) (ps dc2))))) (not (exists ((dc3 DependerLink)) (and (= (srcType dc3) GOAL) (= ((as src (Goal)) dc3) c) (or (fd dc3) (pd dc3) (co dc3) (un dc3) (no dc3) (ps dc3))))))
		(and (exists ((dc1 DependerLink)) (and (= (srcType dc1) GOAL) (= ((as src (Goal)) dc1) c) (fs dc1))) (not (exists ((dc2 DependerLink)) (and (= (srcType dc2) GOAL) (= ((as src (Goal)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (no dc2) (ps dc2))))))
		(and (exists ((dc1 DependeeLink)) (and (= (srcType dc1) GOAL) (= ((as src (Goal)) dc1) c) (fs dc1))) (not (exists ((dc2 DependeeLink)) (and (= (srcType dc2) GOAL) (= ((as src (Goal)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (no dc2) (ps dc2))))))
	)
	(= (fs c) true)
)))
(assert	(forall ((c Goal)) (=>
	(or
		(and (exists ((mec1 MeansEnd)) (and (= (tgtType mec1) GOAL) (= ((as tgt (Goal)) mec1) c) (ps mec1))) (and (not (exists ((mec2 MeansEnd)) (and (= (tgtType mec2) GOAL) (= ((as tgt (Goal)) mec2) c) (fs mec2)))) (not (exists ((dc DependerLink)) (and (= (srcType dc) GOAL) (= ((as src (Goal)) dc) c) (or (fd dc) (pd dc) (co dc) (un dc) (no dc)))))))
		(and (exists ((dc1 Decomposition)) (and (= (tgtType dc1) GOAL) (= ((as tgt (Goal)) dc1) c) (ps dc1))) (not (exists ((dc2 Decomposition)) (and (= (tgtType dc2) GOAL) (= ((as tgt (Goal)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (no dc2))))) (not (exists ((dc3 DependerLink)) (and (= (srcType dc3) GOAL) (= ((as src (Goal)) dc3) c) (or (fd dc3) (pd dc3) (co dc3) (un dc3) (no dc3))))))
		(and (exists ((dc1 DependerLink)) (and (= (srcType dc1) GOAL) (= ((as src (Goal)) dc1) c) (ps dc1))) (not (exists ((dc2 DependerLink)) (and (= (srcType dc2) GOAL) (= ((as src (Goal)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (no dc2))))))
		(and (exists ((dc1 DependeeLink)) (and (= (srcType dc1) GOAL) (= ((as src (Goal)) dc1) c) (ps dc1))) (not (exists ((dc2 DependeeLink)) (and (= (srcType dc2) GOAL) (= ((as src (Goal)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (no dc2))))))
	)
	(= (ps c) true)
)))
(assert	(forall ((c Goal)) (=>
	(or
		(and (exists ((mec1 MeansEnd)) (and (= (tgtType mec1) GOAL) (= ((as tgt (Goal)) mec1) c) (no mec1))) (and (not (exists ((mec2 MeansEnd)) (and (= (tgtType mec2) GOAL) (= ((as tgt (Goal)) mec2) c) (or (fs mec2) (ps mec2) (un mec2) (co mec2) (pd mec2) (fd mec2))))) (not (exists ((dc DependerLink)) (and (= (srcType dc) GOAL) (= ((as src (Goal)) dc) c) (or (fd dc) (pd dc) (co dc) (un dc)))))))
		(and (exists ((dc1 Decomposition)) (and (= (tgtType dc1) GOAL) (= ((as tgt (Goal)) dc1) c) (no dc1))) (not (exists ((dc2 Decomposition)) (and (= (tgtType dc2) GOAL) (= ((as tgt (Goal)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2))))) (not (exists ((dc3 DependerLink)) (and (= (srcType dc3) GOAL) (= ((as src (Goal)) dc3) c) (or (fd dc3) (pd dc3) (co dc3) (un dc3))))))
		(and (exists ((dc1 DependerLink)) (and (= (srcType dc1) GOAL) (= ((as src (Goal)) dc1) c) (no dc1))) (not (exists ((dc2 DependerLink)) (and (= (srcType dc2) GOAL) (= ((as src (Goal)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2))))))
		(and (exists ((dc1 DependeeLink)) (and (= (srcType dc1) GOAL) (= ((as src (Goal)) dc1) c) (no dc1))) (not (exists ((dc2 DependeeLink)) (and (= (srcType dc2) GOAL) (= ((as src (Goal)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2))))))
	)
	(= (no c) true)
)))
(assert	(forall ((c Goal)) (=>
	(or
		(and (exists ((mec1 MeansEnd)) (and (= (tgtType mec1) GOAL) (= ((as tgt (Goal)) mec1) c) (un mec1))) (and (not (exists ((mec2 MeansEnd)) (and (= (tgtType mec2) GOAL) (= ((as tgt (Goal)) mec2) c) (or (fs mec2) (ps mec2))))) (not (exists ((dc DependerLink)) (and (= (srcType dc) GOAL) (= ((as src (Goal)) dc) c) (or (fd dc) (pd dc) (co dc)))))))
		(and (exists ((dc1 Decomposition)) (and (= (tgtType dc1) GOAL) (= ((as tgt (Goal)) dc1) c) (un dc1))) (not (exists ((dc2 Decomposition)) (and (= (tgtType dc2) GOAL) (= ((as tgt (Goal)) dc2) c) (or (fd dc2) (pd dc2) (co dc2))))) (not (exists ((dc3 DependerLink)) (and (= (srcType dc3) GOAL) (= ((as src (Goal)) dc3) c) (or (fd dc3) (pd dc3) (co dc3))))))
		(and (exists ((dc1 DependerLink)) (and (= (srcType dc1) GOAL) (= ((as src (Goal)) dc1) c) (un dc1))) (not (exists ((dc2 DependerLink)) (and (= (srcType dc2) GOAL) (= ((as src (Goal)) dc2) c) (or (fd dc2) (pd dc2) (co dc2))))))
		(and (exists ((dc1 DependeeLink)) (and (= (srcType dc1) GOAL) (= ((as src (Goal)) dc1) c) (un dc1))) (not (exists ((dc2 DependeeLink)) (and (= (srcType dc2) GOAL) (= ((as src (Goal)) dc2) c) (or (fd dc2) (pd dc2) (co dc2))))))
	)
	(= (un c) true)
)))
(assert	(forall ((c Goal)) (=>
	(or
		(and (exists ((mec1 MeansEnd)) (and (= (tgtType mec1) GOAL) (= ((as tgt (Goal)) mec1) c) (co mec1))) (and (not (exists ((mec2 MeansEnd)) (and (= (tgtType mec2) GOAL) (= ((as tgt (Goal)) mec2) c) (or (fs mec2) (ps mec2) (un mec2))))) (not (exists ((dc DependerLink)) (and (= (srcType dc) GOAL) (= ((as src (Goal)) dc) c) (or (fd dc) (pd dc)))))))
		(and (exists ((dc1 Decomposition)) (and (= (tgtType dc1) GOAL) (= ((as tgt (Goal)) dc1) c) (co dc1))) (not (exists ((dc2 Decomposition)) (and (= (tgtType dc2) GOAL) (= ((as tgt (Goal)) dc2) c) (or (fd dc2) (pd dc2))))) (not (exists ((dc3 DependerLink)) (and (= (srcType dc3) GOAL) (= ((as src (Goal)) dc3) c) (or (fd dc3) (pd dc3))))))
		(and (exists ((dc1 DependerLink)) (and (= (srcType dc1) GOAL) (= ((as src (Goal)) dc1) c) (co dc1))) (not (exists ((dc2 DependerLink)) (and (= (srcType dc2) GOAL) (= ((as src (Goal)) dc2) c) (or (fd dc2) (pd dc2))))))
		(and (exists ((dc1 DependeeLink)) (and (= (srcType dc1) GOAL) (= ((as src (Goal)) dc1) c) (co dc1))) (not (exists ((dc2 DependeeLink)) (and (= (srcType dc2) GOAL) (= ((as src (Goal)) dc2) c) (or (fd dc2) (pd dc2))))))
	)
	(= (co c) true)
)))
(assert	(forall ((c Goal)) (=>
	(or
		(and (exists ((mec1 MeansEnd)) (and (= (tgtType mec1) GOAL) (= ((as tgt (Goal)) mec1) c) (pd mec1))) (and (not (exists ((mec2 MeansEnd)) (and (= (tgtType mec2) GOAL) (= ((as tgt (Goal)) mec2) c) (or (fs mec2) (ps mec2) (un mec2) (co mec2))))) (not (exists ((dc DependerLink)) (and (= (srcType dc) GOAL) (= ((as src (Goal)) dc) c) (fd dc))))))
		(and (exists ((dc1 Decomposition)) (and (= (tgtType dc1) GOAL) (= ((as tgt (Goal)) dc1) c) (pd dc1))) (not (exists ((dc2 Decomposition)) (and (= (tgtType dc2) GOAL) (= ((as tgt (Goal)) dc2) c) (fd dc2)))) (not (exists ((dc3 DependerLink)) (and (= (srcType dc3) GOAL) (= ((as src (Goal)) dc3) c) (fd dc3)))))
		(and (exists ((dc1 DependerLink)) (and (= (srcType dc1) GOAL) (= ((as src (Goal)) dc1) c) (pd dc1))) (not (exists ((dc2 DependerLink)) (and (= (srcType dc2) GOAL) (= ((as src (Goal)) dc2) c) (fd dc2)))))
		(and (exists ((dc1 DependeeLink)) (and (= (srcType dc1) GOAL) (= ((as src (Goal)) dc1) c) (pd dc1))) (not (exists ((dc2 DependeeLink)) (and (= (srcType dc2) GOAL) (= ((as src (Goal)) dc2) c) (fd dc2)))))
	)
	(= (pd c) true)
)))
(assert	(forall ((c Goal)) (=>
	(or
		(and (exists ((mec1 MeansEnd)) (and (= (tgtType mec1) GOAL) (= ((as tgt (Goal)) mec1) c) (fd mec1))) (not (exists ((mec2 MeansEnd)) (and (= (tgtType mec2) GOAL) (= ((as tgt (Goal)) mec2) c) (or (fs mec2) (ps mec2) (un mec2) (co mec2) (pd mec2))))))
		(exists ((dc Decomposition)) (and (= (tgtType dc) GOAL) (= ((as tgt (Goal)) dc) c) (fd dc)))
		(exists ((dc DependerLink)) (and (= (srcType dc) GOAL) (= ((as src (Goal)) dc) c) (fd dc)))
		(exists ((dc DependeeLink)) (and (= (srcType dc) GOAL) (= ((as src (Goal)) dc) c) (fd dc)))
	)
	(= (fd c) true)
)))

;Task propagation (Decomposition + Depender)
(assert (forall ((c Task)) (=>
	(or
		(exists ((dc Decomposition)) (and (= (tgtType dc) TASK) (= ((as tgt (Task)) dc) c) (fd dc)))
		(exists ((dc DependerLink)) (and (= (srcType dc) TASK) (= ((as src (Task)) dc) c) (fd dc)))
	)
	(= (fd c) true)
)))
(assert (forall ((c Task)) (=>
	(or
		(and (exists ((dc1 Decomposition)) (and (= (tgtType dc1) TASK) (= ((as tgt (Task)) dc1) c) (pd dc1))) (not (exists ((dc2 Decomposition)) (and (= (tgtType dc2) TASK) (= ((as tgt (Task)) dc2) c) (fd dc2)))) (not (exists ((dc3 DependerLink)) (and (= (srcType dc3) TASK) (= ((as src (Task)) dc3) c) (fd dc3)))))
		(and (exists ((dc1 DependerLink)) (and (= (srcType dc1) TASK) (= ((as src (Task)) dc1) c) (pd dc1))) (not (exists ((dc2 DependerLink)) (and (= (srcType dc2) TASK) (= ((as src (Task)) dc2) c) (fd dc2)))) (not (exists ((dc3 Decomposition)) (and (= (tgtType dc3) TASK) (= ((as tgt (Task)) dc3) c) (fd dc3)))))
	)
	(= (pd c) true)
)))
(assert (forall ((c Task)) (=>
	(or
		(and (exists ((dc1 Decomposition)) (and (= (tgtType dc1) TASK) (= ((as tgt (Task)) dc1) c) (co dc1))) (not (exists ((dc2 Decomposition)) (and (= (tgtType dc2) TASK) (= ((as tgt (Task)) dc2) c) (or (fd dc2) (pd dc2))))) (not (exists ((dc3 DependerLink)) (and (= (srcType dc3) TASK) (= ((as src (Task)) dc3) c) (or (fd dc3) (pd dc3))))))
		(and (exists ((dc1 DependerLink)) (and (= (srcType dc1) TASK) (= ((as src (Task)) dc1) c) (co dc1))) (not (exists ((dc2 DependerLink)) (and (= (srcType dc2) TASK) (= ((as src (Task)) dc2) c) (or (fd dc2) (pd dc2))))) (not (exists ((dc3 Decomposition)) (and (= (tgtType dc3) TASK) (= ((as tgt (Task)) dc3) c) (or (fd dc3) (pd dc3))))))
	)
	(= (co c) true)
)))
(assert (forall ((c Task)) (=>
	(or
		(and (exists ((dc1 Decomposition)) (and (= (tgtType dc1) TASK) (= ((as tgt (Task)) dc1) c) (un dc1))) (not (exists ((dc2 Decomposition)) (and (= (tgtType dc2) TASK) (= ((as tgt (Task)) dc2) c) (or (fd dc2) (pd dc2) (co dc2))))) (not (exists ((dc3 DependerLink)) (and (= (srcType dc3) TASK) (= ((as src (Task)) dc3) c) (or (fd dc3) (pd dc3) (co dc3))))))
		(and (exists ((dc1 DependerLink)) (and (= (srcType dc1) TASK) (= ((as src (Task)) dc1) c) (un dc1))) (not (exists ((dc2 DependerLink)) (and (= (srcType dc2) TASK) (= ((as src (Task)) dc2) c) (or (fd dc2) (pd dc2) (co dc2))))) (not (exists ((dc3 Decomposition)) (and (= (tgtType dc3) TASK) (= ((as tgt (Task)) dc3) c) (or (fd dc3) (pd dc3) (co dc3))))))
	)
	(= (un c) true)
)))
(assert (forall ((c Task)) (=>
	(or
		(and (exists ((dc1 Decomposition)) (and (= (tgtType dc1) TASK) (= ((as tgt (Task)) dc1) c) (no dc1))) (not (exists ((dc2 Decomposition)) (and (= (tgtType dc2) TASK) (= ((as tgt (Task)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2))))) (not (exists ((dc3 DependerLink)) (and (= (srcType dc3) TASK) (= ((as src (Task)) dc3) c) (or (fd dc3) (pd dc3) (co dc3) (un dc3))))))
		(and (exists ((dc1 DependerLink)) (and (= (srcType dc1) TASK) (= ((as src (Task)) dc1) c) (no dc1))) (not (exists ((dc2 DependerLink)) (and (= (srcType dc2) TASK) (= ((as src (Task)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2))))) (not (exists ((dc3 Decomposition)) (and (= (tgtType dc3) TASK) (= ((as tgt (Task)) dc3) c) (or (fd dc3) (pd dc3) (co dc3) (un dc3))))))
	)
	(= (no c) true)
)))
(assert (forall ((c Task)) (=>
	(or
		(and (exists ((dc1 Decomposition)) (and (= (tgtType dc1) TASK) (= ((as tgt (Task)) dc1) c) (ps dc1))) (not (exists ((dc2 Decomposition)) (and (= (tgtType dc2) TASK) (= ((as tgt (Task)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (no dc2))))) (not (exists ((dc3 DependerLink)) (and (= (srcType dc3) TASK) (= ((as src (Task)) dc3) c) (or (fd dc3) (pd dc3) (co dc3) (un dc3) (no dc3))))))
		(and (exists ((dc1 DependerLink)) (and (= (srcType dc1) TASK) (= ((as src (Task)) dc1) c) (ps dc1))) (not (exists ((dc2 DependerLink)) (and (= (srcType dc2) TASK) (= ((as src (Task)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (no dc2))))) (not (exists ((dc3 Decomposition)) (and (= (tgtType dc3) TASK) (= ((as tgt (Task)) dc3) c) (or (fd dc3) (pd dc3) (co dc3) (un dc3) (no dc3))))))
	)
	(= (ps c) true)
)))
(assert (forall ((c Task)) (=>
	(or
		(and (exists ((dc1 Decomposition)) (and (= (tgtType dc1) TASK) (= ((as tgt (Task)) dc1) c) (fs dc1))) (not (exists ((dc2 Decomposition)) (and (= (tgtType dc2) TASK) (= ((as tgt (Task)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (no dc2) (ps dc2))))) (not (exists ((dc3 DependerLink)) (and (= (srcType dc3) TASK) (= ((as src (Task)) dc3) c) (or (fd dc3) (pd dc3) (co dc3) (un dc3) (no dc3) (ps dc3))))))
		(and (exists ((dc1 DependerLink)) (and (= (srcType dc1) TASK) (= ((as src (Task)) dc1) c) (fs dc1))) (not (exists ((dc2 DependerLink)) (and (= (srcType dc2) TASK) (= ((as src (Task)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (no dc2) (ps dc2))))) (not (exists ((dc3 Decomposition)) (and (= (tgtType dc3) TASK) (= ((as tgt (Task)) dc3) c) (or (fd dc3) (pd dc3) (co dc3) (un dc3) (no dc3) (ps dc3))))))
	)
	(= (fs c) true)
)))

;SoftGoal propagation (Contribution + Depender + Dependee)
(assert (forall ((c SoftGoal)) (=>
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
	(= (co c) true)
)))
(assert (forall ((c SoftGoal)) (=>
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
	(= (un c) true)
)))
(assert (forall ((c SoftGoal)) (=>
	(or
		(and
			(exists ((cc1 Contribution)) (and (= (tgtType cc1) SOFTGOAL) (= ((as tgt (SoftGoal)) cc1) c) (fd cc1)))
			(not (exists ((cc2 Contribution)) (and (= (tgtType cc2) SOFTGOAL) (= ((as tgt (SoftGoal)) cc2) c) (or (co cc2) (un cc2) (fs cc2) (ps cc2)))))
		)
		(exists ((dc DependerLink)) (and (= (srcType dc) SOFTGOAL) (= ((as src (SoftGoal)) dc) c) (fd dc)))
		(exists ((dc DependeeLink)) (and (= (srcType dc) SOFTGOAL) (= ((as src (SoftGoal)) dc) c) (fd dc)))
	)
	(= (fd c) true)
)))
(assert (forall ((c SoftGoal)) (=>
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
	(= (pd c) true)
)))
(assert (forall ((c SoftGoal)) (=>
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
	(= (fs c) true)
)))
(assert (forall ((c SoftGoal)) (=>
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
	(= (ps c) true)
)))
(assert (forall ((c SoftGoal)) (=>
	(or
;		(and
;			(not (exists ((cc Contribution)) (and (= (tgtType cc) SOFTGOAL) (= ((as tgt (SoftGoal)) cc) c))))
;			(not (exists ((dc1 DependerLink)) (and (= (srcType dc1) SOFTGOAL) (= ((as src (SoftGoal)) dc1) c))))
;			(not (exists ((dc2 DependeeLink)) (and (= (srcType dc2) SOFTGOAL) (= ((as src (SoftGoal)) dc2) c))))
;		)
		(and
			(exists ((cc1 Contribution)) (and (= (tgtType cc1) SOFTGOAL) (= ((as tgt (SoftGoal)) cc1) c) (no cc1)))
			(not (exists ((cc2 Contribution)) (and (= (tgtType cc2) SOFTGOAL) (= ((as tgt (SoftGoal)) cc2) c) (or (co cc2) (un cc2) (fd cc2) (pd cc2) (fs cc2) (ps cc2)))))
			(not (exists ((dc DependerLink)) (and (= (srcType dc) SOFTGOAL) (= ((as src (SoftGoal)) dc) c) (or (fd dc) (pd dc) (co dc) (un dc)))))
		)
		(and
			(exists ((dc1 DependerLink)) (and (= (srcType dc1) SOFTGOAL) (= ((as src (SoftGoal)) dc1) c) (no dc1)))
			(not (exists ((dc2 DependerLink)) (and (= (srcType dc2) SOFTGOAL) (= ((as src (SoftGoal)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2)))))
			;not exists fd|pd|co|co_|un
			(not (exists ((cc1 Contribution)) (and (= (tgtType cc1) SOFTGOAL) (= ((as tgt (SoftGoal)) cc1) c) (or (co cc1) (un cc1) (fd cc1) (pd cc1)))))
		)
		(and
			(exists ((dc1 DependeeLink)) (and (= (srcType dc1) SOFTGOAL) (= ((as src (SoftGoal)) dc1) c) (no dc1)))
			(not (exists ((dc2 DependeeLink)) (and (= (srcType dc2) SOFTGOAL) (= ((as src (SoftGoal)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2)))))
		)
	)
	(= (no c) true)
)))

;Resource propagation (only Dependee)
(assert (forall ((c Resource)) (=>
	(exists ((dc DependeeLink)) (and (= (srcType dc) RESOURCE) (= ((as src (Resource)) dc) c) (fd dc)))
	(= (fd c) true)
)))
(assert (forall ((c Resource)) (=>
	(and (exists ((dc1 DependeeLink)) (and (= (srcType dc1) RESOURCE) (= ((as src (Resource)) dc1) c) (pd dc1))) (not (exists ((dc2 DependeeLink)) (and (= (srcType dc2) RESOURCE) (= ((as src (Resource)) dc2) c) (fd dc2)))))
	(= (pd c) true)
)))
(assert (forall ((c Resource)) (=>
	(and (exists ((dc1 DependeeLink)) (and (= (srcType dc1) RESOURCE) (= ((as src (Resource)) dc1) c) (co dc1))) (not (exists ((dc2 DependeeLink)) (and (= (srcType dc2) RESOURCE) (= ((as src (Resource)) dc2) c) (or (fd dc2) (pd dc2))))))
	(= (co c) true)
)))
(assert (forall ((c Resource)) (=>
	(and (exists ((dc1 DependeeLink)) (and (= (srcType dc1) RESOURCE) (= ((as src (Resource)) dc1) c) (un dc1))) (not (exists ((dc2 DependeeLink)) (and (= (srcType dc2) RESOURCE) (= ((as src (Resource)) dc2) c) (or (fd dc2) (pd dc2) (co dc2))))))
	(= (un c) true)
)))
(assert (forall ((c Resource)) (=>
	(or
		(and (exists ((dc1 DependeeLink)) (and (= (srcType dc1) RESOURCE) (= ((as src (Resource)) dc1) c) (no dc1))) (not (exists ((dc2 DependeeLink)) (and (= (srcType dc2) RESOURCE) (= ((as src (Resource)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2))))))
	)
	(= (no c) true)
)))
(assert (forall ((c Resource)) (=>
	(and (exists ((dc1 DependeeLink)) (and (= (srcType dc1) RESOURCE) (= ((as src (Resource)) dc1) c) (ps dc1))) (not (exists ((dc2 DependeeLink)) (and (= (srcType dc2) RESOURCE) (= ((as src (Resource)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (no dc2))))))
	(= (ps c) true)
)))
(assert (forall ((c Resource)) (=>
	(and (exists ((dc1 DependeeLink)) (and (= (srcType dc1) RESOURCE) (= ((as src (Resource)) dc1) c) (fs dc1))) (not (exists ((dc2 DependeeLink)) (and (= (srcType dc2) RESOURCE) (= ((as src (Resource)) dc2) c) (or (fd dc2) (pd dc2) (co dc2) (un dc2) (no dc2) (ps dc2))))))
	(= (fs c) true)
)))

