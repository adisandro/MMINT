(assert (forall (( c Goal))(=> (node ConvenientMeetingDate c )(not (or (node AgreeableMeetingDate c ))))))
(assert (forall (( c Goal))(=> (node AgreeableMeetingDate c )(not (or (node ConvenientMeetingDate c ))))))
