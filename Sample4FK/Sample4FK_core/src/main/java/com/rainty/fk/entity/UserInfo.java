package com.rainty.fk.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the USER_INFO database table.
 * 
 */
@Entity
@Table(name="USER_INFO")
@NamedQuery(name="UserInfo.findAll", query="SELECT u FROM UserInfo u")
public class UserInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String userAcnt;
	private String location;
	private Date onboardDt;
	private String secretaryAcnt;
	private String supervisor;
	private Timestamp updateDt;
	private String updateUser;
	private String userDept;
	private String userName;
	private String userOrg;
	private List<AssetsUser> assetsUsers;

	public UserInfo() {
	}


	@Id
	@Column(name="USER_ACNT")
	public String getUserAcnt() {
		return this.userAcnt;
	}

	public void setUserAcnt(String userAcnt) {
		this.userAcnt = userAcnt;
	}


	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="ONBOARD_DT")
	public Date getOnboardDt() {
		return this.onboardDt;
	}

	public void setOnboardDt(Date onboardDt) {
		this.onboardDt = onboardDt;
	}


	@Column(name="SECRETARY_ACNT")
	public String getSecretaryAcnt() {
		return this.secretaryAcnt;
	}

	public void setSecretaryAcnt(String secretaryAcnt) {
		this.secretaryAcnt = secretaryAcnt;
	}


	public String getSupervisor() {
		return this.supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
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


	@Column(name="USER_DEPT")
	public String getUserDept() {
		return this.userDept;
	}

	public void setUserDept(String userDept) {
		this.userDept = userDept;
	}


	@Column(name="USER_NAME")
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	@Column(name="USER_ORG")
	public String getUserOrg() {
		return this.userOrg;
	}

	public void setUserOrg(String userOrg) {
		this.userOrg = userOrg;
	}


	//bi-directional many-to-one association to AssetsUser
	@OneToMany(mappedBy="userInfo")
	public List<AssetsUser> getAssetsUsers() {
		return this.assetsUsers;
	}

	public void setAssetsUsers(List<AssetsUser> assetsUsers) {
		this.assetsUsers = assetsUsers;
	}

	public AssetsUser addAssetsUser(AssetsUser assetsUser) {
		getAssetsUsers().add(assetsUser);
		assetsUser.setUserInfo(this);

		return assetsUser;
	}

	public AssetsUser removeAssetsUser(AssetsUser assetsUser) {
		getAssetsUsers().remove(assetsUser);
		assetsUser.setUserInfo(null);

		return assetsUser;
	}

}