DROP TABLE IF EXISTS session_announcements;

CREATE TABLE session_announcements
(announcement_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
 announcement VARCHAR(200),
 session_id INT);