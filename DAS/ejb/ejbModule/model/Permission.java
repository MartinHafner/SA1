package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
  create table das_permission(
  grantee integer,
  document integer,
  datum date,
  rights integer not null,
  constraint PK_grantee_doc_permission primary key(grantee,document),
  constraint FK_user_permission foreign key(grantee) references das_user(id),
  constraint FK_version_permission foreign key(document) references das_document(id)
  );

 *
 */

@Entity
@Table(name="das_permission")
public class Permission {
	@Id
	@Column(name="id")
	private PermissionId permissionId;
	// PermissionId????
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="grantee", nullable=false)
	private User grantee;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="document", nullable=false)
	private Document document;
	
	@Column(name="datum", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column(name="rights")
	private int rights;
	
	public Permission() {
	}

	public PermissionId getPermissionId() {
		return permissionId;
	}

	public User getGrantee() {
		return grantee;
	}

	public void setGrantee(User grantee) {
		this.grantee = grantee;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getRights() {
		return rights;
	}

	public void setRights(int rights) {
		this.rights = rights;
	}

	public void setPermissionId(int grantee, int document) {
		this.permissionId = new PermissionId(grantee,document);
	}
	
	
}
