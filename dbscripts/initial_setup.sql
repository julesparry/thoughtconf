drop user 'thoughtconf'@'localhost';
create user 'thoughtconf'@'localhost';
drop database ThoughtConf;
create database ThoughtConf;
grant all privileges on ThoughtConf.* to 'thoughtconf'@'localhost' with grant option;
