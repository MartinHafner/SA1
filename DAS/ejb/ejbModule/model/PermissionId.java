package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PermissionId implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "grantee")
	private int grantee;
	
	@Column(name = "document")
	private int document;
	
	public PermissionId() {
	}
	
	public PermissionId(int grantee, int document) {
		this.grantee = grantee;
		this.document = document;
	}

	public int getGrantee() {
		return grantee;
	}

	public int getDocument() {
		return document;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + document;
		result = prime * result + grantee;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PermissionId other = (PermissionId) obj;
		if (document != other.document)
			return false;
		if (grantee != other.grantee)
			return false;
		return true;
	}
	
}
