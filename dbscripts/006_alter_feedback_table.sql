ALTER TABLE feedback DROP session_attendee_id;

ALTER TABLE feedback
ADD COLUMN (feedback_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,session_id INT NOT NULL, attendee_email VARCHAR(200) NOT NULL);

ALTER TABLE feedback
ADD CONSTRAINT FK_Feedback FOREIGN KEY(session_id)
REFERENCES session(session_id) ON DELETE CASCADE;

