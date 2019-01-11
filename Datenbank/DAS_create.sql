create table das_user(
  id integer primary key,
  name varchar2(30),
  passwort varchar(2500),
  email varchar2(50) unique
);
create sequence user_sequenz MINVALUE 1 START WITH 1 INCREMENT BY 1 CACHE 1000;

create table das_format(
   formatId integer primary key,
   bezeichnung varchar2(40)
);
create sequence format_sequenz MINVALUE 1 START WITH 1 INCREMENT BY 1 CACHE 1000;

create table das_document(
  id integer primary key,
  owner integer,
  name varchar2(50),
  datum date,
  description varchar2(100),
  constraint FK_user_document foreign key(owner) references das_user(id)
  );
  create sequence document_sequenz MINVALUE 1 START WITH 1 INCREMENT BY 1 CACHE 1000;
  
  create table das_version(
  id integer primary key,
  --creator integer not null,
  datum date not null,
  document integer not null,
  format integer,
  data blob not null,
  constraint FK_format_version foreign key(format) references das_format(formatId),
  constraint FK_document_version foreign key(document) references das_document(id)
  --constraint FK_creator_version foreign key(creator) references das_user(id)
  );
create sequence version_sequenz MINVALUE 1  START WITH 1 INCREMENT BY 1 CACHE 1000;

  create table das_permission(
  grantee integer,
  document integer,
  datum date,
  rights integer not null,
  constraint PK_grantee_doc_permission primary key(grantee,document),
  constraint FK_user_permission foreign key(grantee) references das_user(id),
  constraint FK_version_permission foreign key(document) references das_document(id)
  );

create table das_booking(
  id integer primary key,
  userid integer,
  datum date,
  subject varchar2(50),--new
  subjectID integer,--new
  operation varchar2(50) --new
);
create sequence boocking_sequenz MINVALUE 1 START WITH 1 INCREMENT BY 1 CACHE 1000;
