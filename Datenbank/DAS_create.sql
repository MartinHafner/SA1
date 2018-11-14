create table das_user(
  id integer primary key,
  name varchar2(30),
  passwort varchar(2500),
  email varchar2(50) unique
);
create sequence user_sequenz MINVALUE 1 MAXVALUE 10000  START WITH 1 INCREMENT BY 1 CACHE 1000;

create table das_permission(
  id integer primary key,
  userid integer,
  read varchar2(10),
  write varchar2(10),
  constraint FK_user_permission foreign key(userid) references das_user(id),
  constraint check_read check (read is not null and read in('true', 'false')),
  constraint check_write check (write is not null and write in('true', 'false'))
  );

create sequence permission_sequenz MINVALUE 1 MAXVALUE 10000  START WITH 1 INCREMENT BY 1 CACHE 1000;

create table das_document(
  id integer primary key,
  owner integer,
  datum date,
  format integer,
  description varchar2(100),
  constraint FK_user_document foreign key(owner) references das_user(id)
  );
  create sequence document_sequenz MINVALUE 1 MAXVALUE 10000  START WITH 1 INCREMENT BY 1 CACHE 1000;
  
  create table das_version(
  id integer primary key,
  datum date,
  document integer,
  data blob,
  constraint FK_document_version foreign key(document) references das_document(id)
  );
create sequence version_sequenz MINVALUE 1 MAXVALUE 10000  START WITH 1 INCREMENT BY 1 CACHE 1000;

create table das_booking(
  id integer primary key,
  userid integer,
  datum date,
  version integer,
  constraint FK_version_boocking foreign key(version) references das_version(id),
  constraint FK_user_boocking foreign key(userid) references das_user(id)
);
create sequence boocking_sequenz MINVALUE 1 MAXVALUE 10000  START WITH 1 INCREMENT BY 1 CACHE 1000;
