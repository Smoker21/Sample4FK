package com.rainty.fk.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the COMMENTS database table.
 * 
 */
@Embeddable
public class CommentPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private String refType;
	private String refId;

	public CommentPK() {
	}

	@Column(name="REF_TYPE")
	public String getRefType() {
		return this.refType;
	}
	public void setRefType(String refType) {
		this.refType = refType;
	}

	@Column(name="REF_ID")
	public String getRefId() {
		return this.refId;
	}
	public void setRefId(String refId) {
		this.refId = refId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CommentPK)) {
			return false;
		}
		CommentPK castOther = (CommentPK)other;
		return 
			this.refType.equals(castOther.refType)
			&& this.refId.equals(castOther.refId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.refType.hashCode();
		hash = hash * prime + this.refId.hashCode();
		
		return hash;
	}
}