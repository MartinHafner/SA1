-- Prompt Anzeigen der gesetzten Parameter (hier nur der Form halber)
-- infdb und infdb2 sind so installiert, dass ein Audit-Trail möglich ist!
-- show parameters

prompt 1. Schritt: Aktivieren des Auditing für die betreffenden Tabellen
prompt (bzw. allgemein: DB-Objekte)
audit all on das_document;
audit all on das_version;
audit all on das_permission;
-- ...


prompt 2. Schritt: DD-Opertionen, z.B.:
select * from das_document;
select * from das_version;
select * from das_permission;

-- . . . inserts!

-- Struktur der Tablle dba_audit_trail
-- desc dba_audit_trail

prompt Beispielabfrage der beobachteten Objekte mit
prompt - Benutzername
prompt - Betriebssystem-Benutzername
prompt - Zeitpunkt des Zugriffs
prompt - verwendete Operation des Zugriffs (hier Einschaenkung auf UIDS)
-- Der "Username" ist bei Verwendung eines JEE-Servers ja stets
-- derselbe - man koennte deshalb also auf das als Basis
-- dienende Betriebssystem zurueckgreifen ?
set pagesize 1000
col obj_name format a20
col username format a20
col os_username format a20
col action_name format a20

select obj_name, username, os_username,
        to_char(timestamp, 'dd.mm.yyyy HH24:mi:ss') as datum, action_name
from dba_audit_trail
where upper(username) like upper ('MILAZZDO%')
and action_name in ( 'UPDATE', 'INSERT', 'DELETE', 'SELECT' )
and obj_name in ('DAS_DOCUMENT', 'DAS_VERSION', 'DAS_PERMISSION')
--and timestamp + 45/1440 >= sysdate  -- z.B: eingeschraenkt auf alle 
-- Operationen die 45 zurueckliegen (rel. zu sysdate)
order by datum asc;

desc dba_audit_trail

-- Dummerweise kann man auf die View dba_audit_trail des Benutzes SYS 
-- keinen
-- View definieren - ausser, dieser wuerde dies explizit erlauben.
-- Damit koennte dies dann auch jederzeit wieder rueckgaenig gemacht werden,
-- was zu einer m.E. grossen Abhaengigkeit fuehren wuerde.

-- Man koennte jedoch relativ einfach eine eigene Tabelle
-- mit dem Inhalt des AuditTrail-Views erzeugen - beispielsweise periodisch,
-- falls dies ueberhaupt erforderlich sein sollte?
--drop table myAuditTrailLogTable purge;
--create table myAuditTrailLogTable as
--select obj_name, username, os_username,
--        to_char(timestamp, 'dd.mm.yyyy HH24:mi:ss') as datum, action_name
--from dba_audit_trail
--where upper(os_username) like upper ('milazzdo%')
--and action_name in ( 'UPDATE', 'INSERT', 'DELETE', 'SELECT' )
--order by datum desc;

--select * from myAuditTrailLogTable;