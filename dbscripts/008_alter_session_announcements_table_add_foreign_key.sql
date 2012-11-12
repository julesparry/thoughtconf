ALTER TABLE session_announcements
ADD CONSTRAINT FK_Session_Announcements FOREIGN KEY(session_id)
REFERENCES session(session_id) ON DELETE CASCADE;