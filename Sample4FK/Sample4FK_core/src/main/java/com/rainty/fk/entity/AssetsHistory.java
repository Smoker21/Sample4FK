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
	private AssetsHistoryPK id;
	private String assetName;
	private String description;
	private String location;
	private Timestamp updateDt;
	private String updateUser;

	public AssetsHistory() {
	}


	@EmbeddedId
	public AssetsHistoryPK getId() {
		return this.id;
	}

	public void setId(AssetsHistoryPK id) {
		this.id = id;
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

}