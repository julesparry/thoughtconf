DROP TABLE IF EXISTS feedback;

CREATE TABLE feedback
(session_attendee_id INT NOT NULL PRIMARY KEY,
 presenter_rating INT,
 content_rating INT,
 overall_rating INT
);