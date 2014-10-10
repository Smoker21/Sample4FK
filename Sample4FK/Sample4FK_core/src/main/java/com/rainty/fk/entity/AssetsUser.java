package com.rainty.fk.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the ASSETS_USER database table.
 * 
 */
@Entity
@Table(name="ASSETS_USER")
@NamedQuery(name="AssetsUser.findAll", query="SELECT a FROM AssetsUser a")
public class AssetsUser implements Serializable {
	private static final long serialVersionUID = 1L;
	private AssetsUserPK id;
	private String active;
	private Timestamp updateDt;
	private String updateUser;
	private String userType;
	private Asset asset;
	private UserInfo userInfo;

	public AssetsUser() {
	}


	@EmbeddedId
	public AssetsUserPK getId() {
		return this.id;
	}

	public void setId(AssetsUserPK id) {
		this.id = id;
	}


	public String getActive() {
		return this.active;
	}

	public void setActive(String active) {
		this.active = active;
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


	@Column(name="USER_TYPE")
	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}


	//bi-directional many-to-one association to Asset
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="ASSET_ID")
	public Asset getAsset() {
		return this.asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}


	//bi-directional many-to-one association to UserInfo
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="USER_ID")
	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}