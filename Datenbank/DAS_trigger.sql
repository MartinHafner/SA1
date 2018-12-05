create or replace trigger changePermission
after insert on das_permission
referencing new as newRow
for each row
begin
  insert into das_booking VALUES(boocking_sequenz.nextval, :newRow.userid , to_date(SYSDATE), 'das_permission', :newRow.id, 'insert');
  dbms_output.put_line('insider trigger das_permission username' || :newRow.userid);
end changePermission;
  