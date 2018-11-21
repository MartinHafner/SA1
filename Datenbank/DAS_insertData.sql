insert into das_user VALUES(user_sequenz.nextval, 'Domenico Milazzo', '1234', 'md@gmail.de');
insert into das_user VALUES(user_sequenz.nextval, 'Maik Dürr', '0000', 'dm@gmail.de'); 
insert into das_user VALUES(user_sequenz.nextval, 'Martin Hafner', '9999', 'hm@gmail.de'); 

insert into das_format VALUES(format_sequenz.nextval, 'txt');

insert into das_document VALUES(document_sequenz.nextval, 1, 'TestData_1', to_date('01-05-18'), 1, 'Test Data für Insert');
insert into das_document VALUES(document_sequenz.nextval, 2, 'TestData_1', to_date('01-06-18'), 1, 'Test Data für Insert');
insert into das_document VALUES(document_sequenz.nextval, 3, 'TestData_1', to_date('01-07-18'), 1, 'Test Data für Insert');

insert into das_permission VALUES(permission_sequenz.nextval, 1, 1, 'true', 'true');
insert into das_permission VALUES(permission_sequenz.nextval, 2, 1, 'true', 'true');
insert into das_permission VALUES(permission_sequenz.nextval, 3, 1, 'true', 'true');

insert into das_version VALUES(version_sequenz.nextval, to_date('01-05-18'), 1, hextoraw('446174656e617263686976696572756e677373797374656d20536f667477617265617263686974656b7475722050726f6a656b74'));
insert into das_booking VALUES(boocking_sequenz.nextval, 1, to_date('01-07-18'), 'r', 1, 1, 'true', 'true', 'true', 'true');
