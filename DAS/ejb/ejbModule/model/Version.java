package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
  
  create table das_version(
  id integer primary key,
  datum date not null,
  document integer not null,
  format integer,
  data blob not null,
  constraint FK_format_version foreign key(format) references das_format(formatId),
  constraint FK_document_version foreign key(document) references das_document(id)
  );
 */

@Entity
@Table(name="das_version")
public class Version {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="version_seq")
	@SequenceGenerator(name="version_seq", sequenceName="version_sequenz", allocationSize=1)
	@Column(name="id")
	private int versionId;
	
	@Column(name="datum", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date date;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="document", nullable=false)
	private Document document;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="format", nullable=false)
	private Format format;
	
	@Lob
	@Column(length=100000)
	private byte[] data;
	

	public Version() {
	}


	public int getVersionId() {
		return versionId;
	}


	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Document getDocument() {
		return document;
	}


	public void setDocument(Document document) {
		this.document = document;
	}


	public Format getFormat() {
		return format;
	}


	public void setFormat(Format format) {
		this.format = format;
	}


	public byte[] getData() {
		return data;
	}


	public void setData(byte[] data) {
		this.data = data;
	}

	
}
