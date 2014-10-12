package com.rainty.fk.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the ASSETS_HISTORY database table.
 * 
 */
@Entity
@Table(name="ASSETS_HISTORY")
@NamedQuery(name="AssetsHistory.findAll", query="SELECT a FROM AssetsHistory a")
public class AssetsHistory implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long historyId; 
	private Long assetId; 
	private String assetName;
	private String assetType; 
	private String description;
	private String location;
	private Timestamp updateDt;
	private String updateUser;

	public AssetsHistory() {
	}

	
	public AssetsHistory(Asset asset) {
		this.assetId = asset.getAssetId();
		this.assetName = asset.getAssetName(); 
		this.description = asset.getDescription(); 
		this.location = asset.getLocation(); 
		this.updateDt = asset.getUpdateDt(); 
		this.updateUser = asset.getUpdateUser();
	}

	@Id
	@Column(name="HISTORY_ID")
	@SequenceGenerator(name="HISTORY_SEQ",allocationSize=1,sequenceName="HISTORY_SEQ")
	@GeneratedValue(generator="HISTORY_SEQ")
	public Long getHistoryId() {
		return this.historyId;
	}

	public void setHistoryId(Long historyId) {
		this.historyId = historyId;
	}

		
	@Column(name="ASSET_ID")
	public Long getAssetId() {
		return this.assetId;
	}
	
	
	public void setAssetId(Long assetId) {
		this.assetId = assetId; 
	}
	
	
	@Column(name="ASSET_TYPE",length=40)
	public String getAssetType() {
		return assetType;
	}


	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}


	@Column(name="ASSET_NAME")
	public String getAssetName() {
		return this.assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}


	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
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


	@Override
	public String toString() {
		return "AssetsHistory [historyId=" + historyId + ", assetId=" + assetId + ", assetName=" + assetName + ", description="
				+ description + ", location=" + location + ", updateDt=" + updateDt + ", updateUser=" + updateUser + "]";
	}

	
	
}