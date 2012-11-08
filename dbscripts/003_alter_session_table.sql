ALTER TABLE session_attendee 
ADD CONSTRAINT FK_Session_Attendee FOREIGN KEY(session_id)
REFERENCES session(session_id) ON DELETE CASCADE; 
