package com.rainty.fk.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-10-12T22:18:48.220+0800")
@StaticMetamodel(AssetsHistory.class)
public class AssetsHistory_ {
	public static volatile SingularAttribute<AssetsHistory, Long> historyId;
	public static volatile SingularAttribute<AssetsHistory, Long> assetId;
	public static volatile SingularAttribute<AssetsHistory, String> assetType;
	public static volatile SingularAttribute<AssetsHistory, String> assetName;
	public static volatile SingularAttribute<AssetsHistory, Timestamp> updateDt;
	public static volatile SingularAttribute<AssetsHistory, String> updateUser;
	public static volatile SingularAttribute<AssetsHistory, String> description;
	public static volatile SingularAttribute<AssetsHistory, String> location;
}
