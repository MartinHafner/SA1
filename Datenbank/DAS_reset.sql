drop table das_user cascade constraints purge;
drop table das_permission cascade constraints purge;
drop table das_document cascade constraints purge;
drop table das_version cascade constraints purge;
drop table das_booking cascade constraints purge;
drop table das_format cascade constraints purge;
drop SEQUENCE user_sequenz;
drop SEQUENCE permission_sequenz;
drop SEQUENCE document_sequenz;
drop SEQUENCE version_sequenz;
drop SEQUENCE boocking_sequenz;
drop SEQUENCE format_sequenz;

drop TRIGGER setPermission;
drop TRIGGER setDocument;
drop TRIGGER setVersion;
