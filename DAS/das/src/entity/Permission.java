package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
  create table das_permission(
  id integer primary key,
  userid integer,
  datum date, --new
  version integer, --version
  read varchar2(10),
  write varchar2(10),
  constraint FK_user_permission foreign key(userid) references das_user(id),
  constraint FK_version_permission foreign key(version) references das_version(id), --version
  constraint check_read check (read is not null and read in('true', 'false')),
  constraint check_write check (write is not null and write in('true', 'false'))
  );

 *
 */

@Entity
@Table(name="das_permission")
public class Permission {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="permission_seq")
	@SequenceGenerator(name="permission_seq", sequenceName="permission_sequenz", allocationSize=1)
	@Column(name="id")
	private int permissionId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="userid", nullable=false)
	private int userId;
	
	@Column(name="datum", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="version", nullable=false)
	private int versionId;
	
	@Column(name="read")
	private String read;
	
	@Column(name="write")
	private String write;
	
	public Permission() {
	}

	public int getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getVersionId() {
		return versionId;
	}

	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}

	public Boolean getRead() {
		if(this.read.equals("true"))
		return true;
		
		else {
			return false;
		}
	}

	public void setRead(Boolean read) {
		this.read = String.valueOf(read);
	}

	public Boolean getWrite() {
		if(this.write.equals("true"))
		return true;
		
		else {
			return false;
		}
	}

	public void setWrite(Boolean write) {
		this.read = String.valueOf(write);
	}
	
}
