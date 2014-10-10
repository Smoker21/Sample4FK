package com.rainty.fk.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.eclipse.persistence.annotations.UuidGenerator;

/**
 * The persistent class for the USER_INFO database table.
 * 
 */
@Entity
@Table(name = "USER_INFO")
@NamedQuery(name = "UserInfo.findAll", query = "SELECT u FROM UserInfo u")
public class UserInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long userId;
	private String location;
	private Date onboardDt;
	private String secretaryAcnt;
	private String supervisor;
	private Timestamp updateDt;
	private String updateUser;
	private String userAcnt;
	private String userDept;
	private String userName;
	private String userOrg;
	private List<Asset> userAssets;

	public UserInfo() {
	}

	@Id
	@SequenceGenerator(sequenceName = "USER_SEQ", name = "USER_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
	@Column(name = "USER_ID")
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ONBOARD_DT")
	public Date getOnboardDt() {
		return this.onboardDt;
	}

	public void setOnboardDt(Date onboardDt) {
		this.onboardDt = onboardDt;
	}

	@Column(name = "SECRETARY_ACNT")
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

	@Column(name = "UPDATE_DT")
	public Timestamp getUpdateDt() {
		return this.updateDt;
	}

	public void setUpdateDt(Timestamp updateDt) {
		this.updateDt = updateDt;
	}

	@Column(name = "UPDATE_USER")
	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	@Column(name = "USER_ACNT")
	public String getUserAcnt() {
		return this.userAcnt;
	}

	public void setUserAcnt(String userAcnt) {
		this.userAcnt = userAcnt;
	}

	@Column(name = "USER_DEPT")
	public String getUserDept() {
		return this.userDept;
	}

	public void setUserDept(String userDept) {
		this.userDept = userDept;
	}

	@Column(name = "USER_NAME")
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "USER_ORG")
	public String getUserOrg() {
		return this.userOrg;
	}

	public void setUserOrg(String userOrg) {
		this.userOrg = userOrg;
	}

	@Transient
	public List<Asset> getUserAssets() {
		return this.userAssets; 
	}
	
	public void setUserAssets(List<Asset> userAssets) {
		this.userAssets = userAssets;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((userAcnt == null) ? 0 : userAcnt.hashCode());
		result = prime * result + (int) (userId ^ (userId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserInfo other = (UserInfo) obj;
		if (userAcnt == null) {
			if (other.userAcnt != null)
				return false;
		} else if (!userAcnt.equals(other.userAcnt))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", location=" + location
				+ ", onboardDt=" + onboardDt + ", secretaryAcnt="
				+ secretaryAcnt + ", supervisor=" + supervisor + ", updateDt="
				+ updateDt + ", updateUser=" + updateUser + ", userAcnt="
				+ userAcnt + ", userDept=" + userDept + ", userName="
				+ userName + ", userOrg=" + userOrg + ", assetsUsers="
				+ userAssets + "]";
	}

	public static class Builder {
		private String location;
		private Date onboardDt;
		private String secretaryAcnt;
		private String supervisor;
		private Timestamp updateDt;
		private String updateUser;
		private String userAcnt;
		private String userDept;
		private String userName;
		private String userOrg;
		private List<Asset> userAssets;

		public Builder location(String location) {
			this.location = location;
			return this;
		}

		public Builder onboardDt(Date onboardDt) {
			this.onboardDt = onboardDt;
			return this;
		}

		public Builder secretaryAcnt(String secretaryAcnt) {
			this.secretaryAcnt = secretaryAcnt;
			return this;
		}

		public Builder supervisor(String supervisor) {
			this.supervisor = supervisor;
			return this;
		}

		public Builder updateDt(Timestamp updateDt) {
			this.updateDt = updateDt;
			return this;
		}

		public Builder updateUser(String updateUser) {
			this.updateUser = updateUser;
			return this;
		}

		public Builder userAcnt(String userAcnt) {
			this.userAcnt = userAcnt;
			return this;
		}

		public Builder userDept(String userDept) {
			this.userDept = userDept;
			return this;
		}

		public Builder userName(String userName) {
			this.userName = userName;
			return this;
		}

		public Builder userOrg(String userOrg) {
			this.userOrg = userOrg;
			return this;
		}

		public Builder assetsUsers(List<Asset> userAssets) {
			this.userAssets = userAssets;
			return this;
		}

		public UserInfo build() {
			UserInfo userInfo = new UserInfo();
			userInfo.location = location;
			userInfo.onboardDt = onboardDt;
			userInfo.secretaryAcnt = secretaryAcnt;
			userInfo.supervisor = supervisor;
			userInfo.updateDt = updateDt;
			userInfo.updateUser = updateUser;
			userInfo.userAcnt = userAcnt;
			userInfo.userDept = userDept;
			userInfo.userName = userName;
			userInfo.userOrg = userOrg;
			userInfo.userAssets = userAssets;
			return userInfo;
		}
	}
}