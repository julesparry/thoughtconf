DROP TABLE IF EXISTS session;

CREATE TABLE session 
(session_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
 session_name VARCHAR(200),
 session_description VARCHAR(200),
 session_start_time DATETIME,
 session_end_time DATETIME,
 session_location VARCHAR(200),
 session_type VARCHAR(200),
 abstract VARCHAR(200),
 session_speaker VARCHAR(200),
 about_speaker VARCHAR(200),
conference_name VARCHAR(200));
