package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

/**
create table das_document(
  id integer primary key,
  owner integer,
  name varchar2(50),
  datum date,
  description varchar2(100),
  constraint FK_user_document foreign key(owner) references das_user(id)
  );
 *
 */
@Entity
@Table(name="das_document")
public class Document {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="document_seq")
	@SequenceGenerator(name="document_seq", sequenceName="document_sequenz", allocationSize=1)
	@Column(name="id")
	private int documentId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="owner", nullable=false)
	private User owner;
	
	@Column(name="name")
	private String name;
	
	@Column(name="datum", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="format", nullable=false)
	private int format;
	
	@Column(name="description")
	private String description;
	
	@OneToMany(mappedBy = "das_version", fetch=FetchType.EAGER)
	private List<Version> versions;
	
	@OneToMany(mappedBy = "das_permission", fetch=FetchType.EAGER)
	private List<Permission> permissions;

	public int getDocumentId() {
		return documentId;
	}

	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getFormat() {
		return format;
	}

	public void setFormat(int format) {
		this.format = format;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Version> getVersions() {
		return versions;
	}

	public void setVersions(List<Version> versions) {
		this.versions = versions;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	
}
