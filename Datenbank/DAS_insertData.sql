insert into das_user VALUES(user_sequenz.nextval, 'Domenico Milazzo', '1234', 'md@gmail.de');
insert into das_user VALUES(user_sequenz.nextval, 'Maik Dürr', '0000', 'dm@gmail.de'); 
insert into das_user VALUES(user_sequenz.nextval, 'Martin Hafner', '9999', 'hm@gmail.de'); 

insert into das_format VALUES(format_sequenz.nextval, 'txt');

insert into das_document VALUES(document_sequenz.nextval, 1, 'TestData_1', SYSDATE, 'Test Data für Insert');
insert into das_document VALUES(document_sequenz.nextval, 2, 'TestData_1', SYSDATE, 'Test Data für Insert');
insert into das_document VALUES(document_sequenz.nextval, 3, 'TestData_1', SYSDATE, 'Test Data für Insert');

insert into das_version VALUES(version_sequenz.nextval, to_date('01-05-18'), 2, 1, hextoraw('446174656e617263686976696572756e677373797374656d20536f667477617265617263686974656b7475722050726f6a656b74'));

insert into das_permission VALUES(1, 1, SYSDATE, 7);
insert into das_permission VALUES(1, 3, SYSDATE, 1);
insert into das_permission VALUES(2, 1, SYSDATE, 1);

--das_booking wird von den Triggern befüllt außer lesezugriffe!
--insert into das_booking VALUES(boocking_sequenz.nextval, 1, SYSDATE, 'das_permission', 1, 'insert');
--insert into das_booking VALUES(boocking_sequenz.nextval, :newRow.userid , to_date(SYSDATE), 'das_permission', :newRow.id, 'insert');

--select username, sid, serial#, SQL_EXEC_START from v$session;
--select * from v$parameter;