package com.rainty.fk.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ASSETS database table.
 * 
 */
@Entity
@Table(name="ASSETS")
@NamedQuery(name="Asset.findAll", query="SELECT a FROM Asset a")
public class Asset implements Serializable {
	private static final long serialVersionUID = 1L;
	private String assetId;
	private int assetHistory;
	private String assetName;
	private String assetTypeassetType;
	private int column;
	private String description;
	private Timestamp updateDt;
	private String updateUser;
	private List<AssetsUser> assetsUsers;

	public Asset() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ASSET_ID")
	public String getAssetId() {
		return this.assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}


	@Column(name="ASSET_HISTORY")
	public int getAssetHistory() {
		return this.assetHistory;
	}

	public void setAssetHistory(int assetHistory) {
		this.assetHistory = assetHistory;
	}


	@Column(name="ASSET_NAME")
	public String getAssetName() {
		return this.assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}


	@Column(name="ASSET_TYPEASSET_TYPE")
	public String getAssetTypeassetType() {
		return this.assetTypeassetType;
	}

	public void setAssetTypeassetType(String assetTypeassetType) {
		this.assetTypeassetType = assetTypeassetType;
	}


	@Column(name="\"Column\"")
	public int getColumn() {
		return this.column;
	}

	public void setColumn(int column) {
		this.column = column;
	}


	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	@Column(name="UPDATE_DT")
	public Timestamp getUpdateDt() {
		return this.updateDt;
	}

	public void setUpdateDt(Timestamp updateDt) {
		this.updateDt = updateDt;
	}


	@Column(name="UPDATE_USER")
	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}


	//bi-directional many-to-one association to AssetsUser
	@OneToMany(mappedBy="asset")
	public List<AssetsUser> getAssetsUsers() {
		return this.assetsUsers;
	}

	public void setAssetsUsers(List<AssetsUser> assetsUsers) {
		this.assetsUsers = assetsUsers;
	}

	public AssetsUser addAssetsUser(AssetsUser assetsUser) {
		getAssetsUsers().add(assetsUser);
		assetsUser.setAsset(this);

		return assetsUser;
	}

	public AssetsUser removeAssetsUser(AssetsUser assetsUser) {
		getAssetsUsers().remove(assetsUser);
		assetsUser.setAsset(null);

		return assetsUser;
	}

}