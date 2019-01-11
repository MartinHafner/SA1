package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
  create table das_format(
   	formatId integer primary key,
   	bezeichnung varchar2(40)
);
 *
 */

@Entity
@Table(name="das_format")
public class Format { 
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="format_seq")
	@SequenceGenerator(name="format_seq", sequenceName="format_sequenz", allocationSize=1)
	@Column(name="formatId")
	private int formatId;
	
	@Column(name="description")
	private String description;
	
	@OneToMany(mappedBy = "das_version", fetch=FetchType.EAGER)
	private List<Version> versions;
	
	public Format(){
	}

	public int getFormatId() {
		return formatId;
	}

	public void setFormatId(int formatId) {
		this.formatId = formatId;
	}

	public List<Version> getVersions() {
		return versions;
	}

	public void setVersions(List<Version> versions) {
		this.versions = versions;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
