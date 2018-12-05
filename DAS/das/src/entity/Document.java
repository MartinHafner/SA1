package entity;

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
  	format integer,
  	description varchar2(100),
  		constraint FK_user_document foreign key(owner) references das_user(id),
  		constraint FK_format_document foreign key(format) references das_format(formatId)
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
	private int owner;
	
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
	private List<Document> versions;
	
	

	public int getDocumentId() {
		return documentId;
	}

	public Document() {
	}

	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}

	public int getOwner() {
		return owner;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDatum() {
		return date;
	}

	public void setDatum(Date datum) {
		this.date = datum;
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
}
