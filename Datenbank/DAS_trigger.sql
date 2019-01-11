--Trigger Permission
create or replace trigger setPermission
after insert on das_permission
referencing new as newRow
for each row
begin
  insert into das_booking VALUES(boocking_sequenz.nextval, :newRow.grantee, SYSDATE, 'das_permission', :newRow.document, 'insert');
--exception
  --when others then dbmv_output.put_line('exeption throw');
end setPermission; 
/

--Trigger Document
create or replace trigger setDocument
after insert on das_document
referencing new as nRow
for each row
begin
  insert into das_booking VALUES(boocking_sequenz.nextval, :nRow.owner, SYSDATE, 'das_document', :nRow.id, 'insert');
end setDocument;
/

--Trigger Version
create or replace trigger setVersion
after insert on das_version
referencing new as newRow
for each row
begin
  insert into das_booking VALUES(boocking_sequenz.nextval, null , SYSDATE, 'das_version', :newRow.id, 'insert');
end setVersion;
/
  