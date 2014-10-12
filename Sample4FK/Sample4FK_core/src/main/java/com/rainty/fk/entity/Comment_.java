package com.rainty.fk.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-10-12T22:18:48.425+0800")
@StaticMetamodel(Comment.class)
public class Comment_ {
	public static volatile SingularAttribute<Comment, CommentPK> id;
	public static volatile SingularAttribute<Comment, Timestamp> updateDt;
	public static volatile SingularAttribute<Comment, String> updateUser;
	public static volatile SingularAttribute<Comment, String> comment;
}
