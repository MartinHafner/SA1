create table das_user(
  id integer primary key,
  name varchar2(30),
  passwort varchar(2500),
  email varchar2(50) unique
);
create sequence user_sequenz MINVALUE 1 MAXVALUE 10000  START WITH 1 INCREMENT BY 1 CACHE 1000;

create table das_format(
   formatId integer primary key,
   bezeichnung varchar2(40)
);
create sequence format_sequenz MINVALUE 1 MAXVALUE 10000  START WITH 1 INCREMENT BY 1 CACHE 1000;

create table das_document(
  id integer primary key,
  owner integer,
  name varchar2(50),
  datum date,
  format integer,
  description varchar2(100),
  constraint FK_user_document foreign key(owner) references das_user(id),
  constraint FK_format_document foreign key(format) references das_format(formatId)
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

  create table das_permission(
  id integer primary key,
  userid integer,
  datum date,
  version integer,
  read varchar2(10),
  write varchar2(10),
  constraint FK_user_permission foreign key(userid) references das_user(id),
  constraint FK_version_permission foreign key(version) references das_version(id), --version
  constraint check_read check (read is not null and read in('true', 'false')),
  constraint check_write check (write is not null and write in('true', 'false'))
  );

create sequence permission_sequenz MINVALUE 1 MAXVALUE 10000  START WITH 1 INCREMENT BY 1 CACHE 1000;

create table das_booking(
  id integer primary key,
  userid integer,
  datum date,
  -- typ varchar2(1),
  subject varchar2(50),--new
  subjectID integer,--new
  operation varchar2(50) --new
  -- oldversion integer,
  ---version integer,
  -- oldread varchar2(10),
  -- read varchar2(10),
  -- oldwrite varchar2(10),
  -- write varchar2(10),
  -- constraint FK_version_boocking foreign key(version) references das_version(id),
  -- constraint FK_oldversion_boocking foreign key(oldversion) references das_version(id),
  -- constraint FK_user_boocking foreign key(userid) references das_user(id),
  -- constraint check_oldwrite check (write in('true', 'false')),
  -- constraint check_oldread check (write in('true', 'false')),
  -- constraint check_newread check (write in('true', 'false')),
  -- constraint check_newwrite check (write in('true', 'false')),
  -- constraint typ_check check (typ is not null and typ in('c', 'r', 'w'))
);
create sequence boocking_sequenz MINVALUE 1 MAXVALUE 10000  START WITH 1 INCREMENT BY 1 CACHE 1000;
