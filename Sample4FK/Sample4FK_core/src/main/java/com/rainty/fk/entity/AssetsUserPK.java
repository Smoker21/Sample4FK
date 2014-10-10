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
	private long assetId;
	private long userId;

	public AssetsUserPK() {
	}

	@Column(name="ASSET_ID", insertable=true, updatable=true)
	public long getAssetId() {
		return this.assetId;
	}
	public void setAssetId(long assetId) {
		this.assetId = assetId;
	}

	@Column(name="USER_ID", insertable=true, updatable=true)
	public long getUserId() {
		return this.userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
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
			(this.assetId == castOther.assetId)
			&& (this.userId == castOther.userId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.assetId ^ (this.assetId >>> 32)));
		hash = hash * prime + ((int) (this.userId ^ (this.userId >>> 32)));
		
		return hash;
	}
}