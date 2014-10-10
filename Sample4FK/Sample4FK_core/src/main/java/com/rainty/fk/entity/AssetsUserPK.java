package com.rainty.fk.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ASSETS_USER database table.
 * 
 */
@Embeddable
public class AssetsUserPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private String assetId;
	private String userAcnt;

	public AssetsUserPK() {
	}

	@Column(name="ASSET_ID", insertable=false, updatable=false)
	public String getAssetId() {
		return this.assetId;
	}
	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	@Column(name="USER_ACNT", insertable=false, updatable=false)
	public String getUserAcnt() {
		return this.userAcnt;
	}
	public void setUserAcnt(String userAcnt) {
		this.userAcnt = userAcnt;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AssetsUserPK)) {
			return false;
		}
		AssetsUserPK castOther = (AssetsUserPK)other;
		return 
			this.assetId.equals(castOther.assetId)
			&& this.userAcnt.equals(castOther.userAcnt);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.assetId.hashCode();
		hash = hash * prime + this.userAcnt.hashCode();
		
		return hash;
	}
}