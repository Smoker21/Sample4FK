package com.rainty.fk.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * The persistent class for the ASSETS database table.
 *
 */
@Entity
@Table(name = "ASSETS")
@NamedQuery(name = "Asset.findAll", query = "SELECT a FROM Asset a")
public class Asset implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1709230324579283520L;
	private Long assetId;
	private String assetName;
	private String assetType;
	private String description;
	private String location;
	private Timestamp updateDt;
	private String updateUser;
	private List<AssetUser> assetUsers;

	public Asset() {
	}

	@Id
	@SequenceGenerator(name = "ASSET_SEQ", sequenceName = "ASSET_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ASSET_SEQ")
	@Column(name = "ASSET_ID")
	public Long getAssetId() {
		return this.assetId;
	}

	public void setAssetId(final Long assetId) {
		this.assetId = assetId;
	}

	@Column(name = "ASSET_NAME")
	public String getAssetName() {
		return this.assetName;
	}

	public void setAssetName(final String assetName) {
		this.assetName = assetName;
	}

	@Column(name = "ASSET_TYPE")
	public String getAssetType() {
		return this.assetType;
	}

	public void setAssetType(final String assetType) {
		this.assetType = assetType;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(final String location) {
		this.location = location;
	}

	@Column(name = "UPDATE_DT")
	public Timestamp getUpdateDt() {
		return this.updateDt;
	}

	public void setUpdateDt(final Timestamp updateDt) {
		this.updateDt = updateDt;
	}

	@Column(name = "UPDATE_USER")
	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(final String updateUser) {
		this.updateUser = updateUser;
	}

	@Transient
	public List<AssetUser> getAssetUsers() {
		return this.assetUsers;
	}

	public void setAssetUsers(final List<AssetUser> users) {
		this.assetUsers = users;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((assetId == null) ? 0 : assetId.hashCode());
		result = (prime * result) + ((assetName == null) ? 0 : assetName.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Asset other = (Asset) obj;
		if (assetId == null) {
			if (other.assetId != null) {
				return false;
			}
		} else if (!assetId.equals(other.assetId)) {
			return false;
		}
		if (assetName == null) {
			if (other.assetName != null) {
				return false;
			}
		} else if (!assetName.equals(other.assetName)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Asset [assetId=" + assetId + ", assetName=" + assetName + ", assetType=" + assetType + ", description="
				+ description + ", location=" + location + ", updateDt=" + updateDt + ", updateUser=" + updateUser
				+ ", assetUsers=" + assetUsers + "]";
	}

	public static class Builder {
		private String assetName;
		private String assetType;
		private String description;
		private String location;
		private Timestamp updateDt;
		private String updateUser;
		private List<AssetUser> assetUsers;

		public Builder assetName(final String assetName) {
			this.assetName = assetName;
			return this;
		}

		public Builder assetType(final String assetType) {
			this.assetType = assetType;
			return this;
		}

		public Builder description(final String description) {
			this.description = description;
			return this;
		}

		public Builder location(final String location) {
			this.location = location;
			return this;
		}

		public Builder updateDt(final Timestamp updateDt) {
			this.updateDt = updateDt;
			return this;
		}

		public Builder updateUser(final String updateUser) {
			this.updateUser = updateUser;
			return this;
		}

		public Builder assetsUsers(final List<AssetUser> assetUsers) {
			this.assetUsers = assetUsers;
			return this;
		}

		public Asset build() {
			return new Asset(this);
		}
	}

	private Asset(final Builder builder) {
		this.assetName = builder.assetName;
		this.assetType = builder.assetType;
		this.description = builder.description;
		this.location = builder.location;
		this.updateDt = builder.updateDt;
		this.updateUser = builder.updateUser;
		this.assetUsers = builder.assetUsers;
	}
}