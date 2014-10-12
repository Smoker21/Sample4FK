package com.rainty.fk.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-10-12T22:18:48.411+0800")
@StaticMetamodel(AssetsUser.class)
public class AssetsUser_ {
	public static volatile SingularAttribute<AssetsUser, AssetsUserPK> id;
	public static volatile SingularAttribute<AssetsUser, Timestamp> updateDt;
	public static volatile SingularAttribute<AssetsUser, String> updateUser;
	public static volatile SingularAttribute<AssetsUser, AssetOwnerType> userType;
	public static volatile SingularAttribute<AssetsUser, String> active;
}
