package com.rainty.fk.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ASSETS_HISTORY database table.
 * 
 */
@Embeddable
public class AssetsHistoryPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private long historyId;
	private long assetId;

	public AssetsHistoryPK() {
	}

	@Column(name="HISTORY_ID")
	public long getHistoryId() {
		return this.historyId;
	}
	public void setHistoryId(long historyId) {
		this.historyId = historyId;
	}

	@Column(name="ASSET_ID")
	public long getAssetId() {
		return this.assetId;
	}
	public void setAssetId(long assetId) {
		this.assetId = assetId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AssetsHistoryPK)) {
			return false;
		}
		AssetsHistoryPK castOther = (AssetsHistoryPK)other;
		return 
			(this.historyId == castOther.historyId)
			&& (this.assetId == castOther.assetId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.historyId ^ (this.historyId >>> 32)));
		hash = hash * prime + ((int) (this.assetId ^ (this.assetId >>> 32)));
		
		return hash;
	}
}