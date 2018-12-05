package entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
  create table das_version(
  	id integer primary key,
  	datum date,
  	document integer,
  	data blob,
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="document", nullable=false)
	private int documentId;
	
	@Lob
	@Column(length=100000)
	private byte[] data;
	
	@OneToMany(mappedBy = "das_permission", fetch=FetchType.EAGER)
	private List<Document> permissions;

	public Version() {
	}

	public int getVersionId() {
		return versionId;
	}

	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}

	public int getDocumentId() {
		return documentId;
	}

	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}
}
