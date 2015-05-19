CREATE DATABASE mvcdiary;

CREATE TABLE entry (
	id BIGSERIAL PRIMARY KEY,
	title		 VARCHAR(50),
	text		 TEXT,
	date		 DATE
	);
	
INSERT INTO entry(id, title, text, date) VALUES (1, 'Hello world!', 'This is my first post', '08/05/2015');
INSERT INTO entry(id, title, text, date) VALUES (2, 'Hello world again!', 'This is my second post', '08/05/2015');
INSERT INTO entry(id, title, text, date) VALUES ('Hello world yet again!', 'This is my third post',

CREATE TABLE users (
	userid		 VARCHAR(20),
	username     VARCHAR(60),
	userpassword VARCHAR(10)
	);

INSERT INTO users(userid, username, userpassword) VALUES ('jelle', 'Jelle Timmerman', 'qwe');
INSERT INTO users(userid, username, userpassword) VALUES ('jan', 'Jan Janssen', 'qwe');
