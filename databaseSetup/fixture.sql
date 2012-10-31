insert into conference(conference_name,conference_date,conference_location,Abstract,conference_type) values("away day","2012-12-11","conference location","happy away day","conference type");

insert into track(track_name,track_description,conference_id) values("dev", "sessions for dev",1);
insert into track(track_name,track_description,conference_id) values("qa", "sessions for qa",1);


insert into session(session_name,session_description,session_time,session_location,session_type,abstract,session_speaker,about_speaker,track_id) values("dev bootcamp",
	"bootcamping for devs", "2012-12-11 09:30AM", "Ajanta", "Hands on", "Attendees should bring laptops so that they can code, code and code", "Meng Wang", 
	"Guru in java and many other languages", 1);
insert into session(session_name,session_description,session_time,session_location,session_type,abstract,session_speaker,about_speaker,track_id) values("Java Extra",
	"bootcamping for devs", "2012-12-11 12:30AM", "Elora", "Technical", "This will be a technical session where new language libraries will be introduced", 
	"Ditjhaba Selemela", "Guru in java and many other languages", 1);
insert into session(session_name,session_description,session_time,session_location,session_type,abstract,session_speaker,about_speaker,track_id) values("QA bootcamp",
	"bootcamping for QAs", "2012-12-11 09:30AM", "Mercury", "Hands on", "Attendees will be introduced to different testing environments", "Nikitha Iyer", 
	"QA for 50 years", 2);
insert into session(session_name,session_description,session_time,session_location,session_type,abstract,session_speaker,about_speaker,track_id) values("QA Smoke tests",
	"smoke tests for QAs", "2012-12-11 12:30AM", "Mercury", "Hands on", "Attendees will be introduced to different testing environments", "Nikitha Iyer", 
	"QA for 50 years", 2); 