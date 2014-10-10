package com.rainty.fk.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-10-10T21:01:00.625+0800")
@StaticMetamodel(AssetsUser.class)
public class AssetsUser_ {
	public static volatile SingularAttribute<AssetsUser, AssetsUserPK> id;
	public static volatile SingularAttribute<AssetsUser, Timestamp> updateDt;
	public static volatile SingularAttribute<AssetsUser, String> updateUser;
	public static volatile SingularAttribute<AssetsUser, String> userType;
	public static volatile SingularAttribute<AssetsUser, Asset> asset;
	public static volatile SingularAttribute<AssetsUser, UserInfo> userInfo;
	public static volatile SingularAttribute<AssetsUser, String> active;
}
