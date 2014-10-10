package com.rainty.fk.entity;

import java.sql.Timestamp;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-10-10T21:14:28.601+0800")
@StaticMetamodel(UserInfo.class)
public class UserInfo_ {
	public static volatile SingularAttribute<UserInfo, Date> onboardDt;
	public static volatile SingularAttribute<UserInfo, String> secretaryAcnt;
	public static volatile SingularAttribute<UserInfo, Timestamp> updateDt;
	public static volatile SingularAttribute<UserInfo, String> updateUser;
	public static volatile SingularAttribute<UserInfo, String> userAcnt;
	public static volatile SingularAttribute<UserInfo, String> userDept;
	public static volatile SingularAttribute<UserInfo, String> userName;
	public static volatile SingularAttribute<UserInfo, String> userOrg;
	public static volatile ListAttribute<UserInfo, AssetsUser> assetsUsers;
	public static volatile SingularAttribute<UserInfo, String> location;
	public static volatile SingularAttribute<UserInfo, String> supervisor;
	public static volatile SingularAttribute<UserInfo, Long> userId;
}
