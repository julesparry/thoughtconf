DROP TABLE IF EXISTS session_attendee;
CREATE TABLE session_attendee(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
attendee_email VARCHAR(200),
session_id INT);

