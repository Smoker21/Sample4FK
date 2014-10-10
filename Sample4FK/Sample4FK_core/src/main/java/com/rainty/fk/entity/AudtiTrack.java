package com.rainty.fk.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the AUDTI_TRACK database table.
 * 
 */
@Entity
@Table(name="AUDTI_TRACK")
@NamedQuery(name="AudtiTrack.findAll", query="SELECT a FROM AudtiTrack a")
public class AudtiTrack implements Serializable {
	private static final long serialVersionUID = 1L;
	private int transactionId;
	private int newValue;
	private int oldValue;
	private String operation;
	private Timestamp transDate;
	private String updateUser;

	public AudtiTrack() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TRANSACTION_ID")
	public int getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}


	@Column(name="NEW_VALUE")
	public int getNewValue() {
		return this.newValue;
	}

	public void setNewValue(int newValue) {
		this.newValue = newValue;
	}


	@Column(name="OLD_VALUE")
	public int getOldValue() {
		return this.oldValue;
	}

	public void setOldValue(int oldValue) {
		this.oldValue = oldValue;
	}


	public String getOperation() {
		return this.operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}


	@Column(name="TRANS_DATE")
	public Timestamp getTransDate() {
		return this.transDate;
	}

	public void setTransDate(Timestamp transDate) {
		this.transDate = transDate;
	}


	@Column(name="UPDATE_USER")
	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

}