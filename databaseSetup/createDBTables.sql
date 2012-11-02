
USE ThoughtConf;

DROP TABLE IF EXISTS conference;

CREATE TABLE conference(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
conference_name VARCHAR(200),
conference_date DATETIME,
conference_location VARCHAR(200),
Abstract VARCHAR(200),
conference_type VARCHAR(200));

DROP TABLE IF EXISTS track;

CREATE TABLE track(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
track_name VARCHAR(200),
track_description VARCHAR(200), 
conference_id INT);

ALTER TABLE track 
ADD CONSTRAINT FK_Conference_Track FOREIGN KEY(conference_id) 
REFERENCES conference(id) ON DELETE CASCADE;

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
 track_id INT);

ALTER TABLE session 
ADD CONSTRAINT FK_Track_Session FOREIGN KEY(track_id)
REFERENCES track(id) ON DELETE CASCADE;

CREATE TABLE session_attendee(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
attendee_email VARCHAR(200),
session_id INT);

ALTER TABLE session 
ADD CONSTRAINT FK_Session_Attendee FOREIGN KEY(session_id)
REFERENCES session(session_id) ON DELETE CASCADE; 
