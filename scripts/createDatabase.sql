CREATE TABLE entry (
	id serial PRIMARY KEY,
	title		VARCHAR(50),
	text		TEXT,
	date		DATE
	);
	
INSERT INTO entry(id, title, text, date) VALUES (1, 'Hello world!', 'This is my first post', '08/05/2015');
INSERT INTO entry(id, title, text, date) VALUES (2, 'Hello world again!', 'This is my second post', '08/05/2015');
INSERT INTO entry(id, title, text, date) VALUES (3, 'Hello world yet again!', 'This is my third post', 