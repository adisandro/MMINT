(assert (forall (( c Goal))(=> (node ConvenientMeetingDate c )(not (or (node AgreeableMeetingDate c ))))))
(assert (not (exists (( c Decomposition))(edge UseProfiles2ParticipateInMeeting  c ))))
(assert (forall (( c Goal))(=> (node AgreeableMeetingDate c )(not (or (node ConvenientMeetingDate c ))))))
(assert (not (exists (( c Decomposition))(edge ConvenientMeetingDate2ParticipateInMeeting  c ))))
