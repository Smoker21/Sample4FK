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
	private int transId;
	private String column;
	private String comment;
	private String newValue;
	private String oldValue;
	private String operation;
	private String tableName;
	private Timestamp transDate;
	private String transUser;

	public AudtiTrack() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TRANS_ID")
	public int getTransId() {
		return this.transId;
	}

	public void setTransId(int transId) {
		this.transId = transId;
	}


	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}


	@Column(name="NEW_VALUE")
	public String getNewValue() {
		return this.newValue;
	}

	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}


	@Column(name="OLD_VALUE")
	public String getOldValue() {
		return this.oldValue;
	}

	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}


	public String getOperation() {
		return this.operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}


	@Column(name="TABLE_NAME")
	public String getTableName() {
		return this.tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}


	@Column(name="TRANS_DATE")
	public Timestamp getTransDate() {
		return this.transDate;
	}

	public void setTransDate(Timestamp transDate) {
		this.transDate = transDate;
	}


	@Column(name="TRANS_USER")
	public String getTransUser() {
		return this.transUser;
	}

	public void setTransUser(String transUser) {
		this.transUser = transUser;
	}

}