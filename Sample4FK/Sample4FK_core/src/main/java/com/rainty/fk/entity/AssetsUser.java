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
	private AssetOwnerType userType;

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
	public AssetOwnerType getUserType() {
		return this.userType;
	}

	public void setUserType(AssetOwnerType userType) {
		this.userType = userType;
	}
	
	
	public void setUserType(String userType) {
		this.setUserType(AssetOwnerType.valueOf(userType));
	}

}