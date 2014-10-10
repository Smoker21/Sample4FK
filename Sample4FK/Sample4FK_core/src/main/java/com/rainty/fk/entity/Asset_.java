package com.rainty.fk.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-10-10T21:23:17.054+0800")
@StaticMetamodel(Asset.class)
public class Asset_ {
	public static volatile SingularAttribute<Asset, String> assetName;
	public static volatile SingularAttribute<Asset, String> assetType;
	public static volatile SingularAttribute<Asset, Timestamp> updateDt;
	public static volatile SingularAttribute<Asset, String> updateUser;
	public static volatile ListAttribute<Asset, AssetsUser> assetsUsers;
	public static volatile SingularAttribute<Asset, String> description;
	public static volatile SingularAttribute<Asset, String> location;
	public static volatile SingularAttribute<Asset, Long> assetId;
}
