package com.rainty.fk.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ASSET_TYPE database table.
 * 
 */
@Entity
@Table(name="ASSET_TYPE")
@NamedQuery(name="AssetType.findAll", query="SELECT a FROM AssetType a")
public class AssetType implements Serializable {
	private static final long serialVersionUID = 1L;
	private String assetType;
	private String typeDescription;
	private String updateUser;

	public AssetType() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ASSET_TYPE")
	public String getAssetType() {
		return this.assetType;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}


	@Column(name="TYPE_DESCRIPTION")
	public String getTypeDescription() {
		return this.typeDescription;
	}

	public void setTypeDescription(String typeDescription) {
		this.typeDescription = typeDescription;
	}


	@Column(name="UPDATE_USER")
	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

}