(assert (not (exists (( c Decomposition))(edge ProvideDetails2ParticipateInMeeting  c ))))
(assert (forall (( c1 Decomposition)( c2 Decomposition))(=> (and (edge ProvideDetails2ParticipateInMeeting c1 )(edge ProvideDetails2ParticipateInMeeting c2 ))(=  c1  c2 ))))
(assert (forall (( c Goal))(=> (node ConvenientMeetingDate c )(not (or (node AgreeableMeetingDate c ))))))
(assert (forall (( c Goal))(=> (node AgreeableMeetingDate c )(not (or (node ConvenientMeetingDate c ))))))
