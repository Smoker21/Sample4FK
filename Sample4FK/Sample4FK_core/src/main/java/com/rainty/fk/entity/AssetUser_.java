package com.rainty.fk.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-10-16T23:34:50.037+0800")
@StaticMetamodel(AssetUser.class)
public class AssetUser_ {
	public static volatile SingularAttribute<AssetUser, Timestamp> updateDt;
	public static volatile SingularAttribute<AssetUser, String> updateUser;
	public static volatile SingularAttribute<AssetUser, AssetOwnerType> userType;
	public static volatile SingularAttribute<AssetUser, String> active;
	public static volatile SingularAttribute<AssetUser, AssetUserPK> id;
}
