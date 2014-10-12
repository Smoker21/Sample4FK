CREATE TABLE Comments (Ref_type varchar(100) NOT NULL, Ref_id varchar(100) NOT NULL, comment varchar(4000), update_user varchar(50), update_dt timestamp, PRIMARY KEY (Ref_type, Ref_id));
CREATE TABLE Audti_Track (Trans_Id int GENERATED BY DEFAULT AS IDENTITY, Trans_user varchar(50), Trans_Date timestamp, Table_name varchar(40), Old_Value varchar(4000), New_Value varchar(4000), Operation varchar(50), comment varchar(1000), PRIMARY KEY (Trans_Id));
CREATE TABLE Assets_User (Asset_Id bigint NOT NULL, User_Id bigint NOT NULL, user_type varchar(30), update_user varchar(50), update_dt timestamp, active varchar(5), PRIMARY KEY (Asset_Id, User_Id));
CREATE TABLE User_Info (User_Id bigint GENERATED BY DEFAULT AS IDENTITY, User_Acnt varchar(50) NOT NULL UNIQUE, User_Name varchar(50), User_Dept varchar(10), Location varchar(30), User_Org varchar(10), Secretary_Acnt varchar(50), Supervisor varchar(50), onboard_dt date, update_user varchar(50), update_dt timestamp, CONSTRAINT User_Acnt PRIMARY KEY (User_Id));
CREATE TABLE Asset_Type (Asset_Type varchar(40) NOT NULL, Type_Description varchar(2000), update_user varchar(50), update_dt timestamp, PRIMARY KEY (Asset_Type));
CREATE TABLE Assets (Asset_Id bigint GENERATED BY DEFAULT AS IDENTITY, Asset_Type varchar(40) NOT NULL, Asset_Name varchar(500), Location varchar(40), Description varchar(2000), Update_user varchar(50), Update_Dt timestamp, PRIMARY KEY (Asset_Id));
CREATE TABLE Assets_History (History_Id bigint GENERATED BY DEFAULT AS IDENTITY, Asset_Id bigint NOT NULL, Asset_Type varchar(40), Asset_Name varchar(500), Location varchar(40), Description varchar(2000), Update_User varchar(50), Update_Dt timestamp, PRIMARY KEY (History_Id));
CREATE SEQUENCE USER_SEQ; 
CREATE SEQUENCE ASSET_SEQ; 
CREATE SEQUENCE UNI_SEQ; 
CREATE SEQUENCE HISTORY_SEQ;


ALTER TABLE Assets_User ADD CONSTRAINT FKAssets_Use649444 FOREIGN KEY (User_Id) REFERENCES User_Info (User_Id);
ALTER TABLE Assets_User ADD CONSTRAINT FKAssets_Use866602 FOREIGN KEY (Asset_Id) REFERENCES Assets (Asset_Id);
ALTER TABLE Assets ADD CONSTRAINT FKAssets568458 FOREIGN KEY (Asset_Type) REFERENCES Asset_Type (Asset_Type);

-- init asset types
INSERT INTO ASSET_TYPE(ASSET_TYPE,TYPE_DESCRIPTION,UPDATE_USER,UPDATE_DT) values ('PC','Personal computer','TEST',sysdate);
INSERT INTO ASSET_TYPE(ASSET_TYPE,TYPE_DESCRIPTION,UPDATE_USER,UPDATE_DT) values ('NoteBook','Laptop computer','TEST',sysdate);
INSERT INTO ASSET_TYPE(ASSET_TYPE,TYPE_DESCRIPTION,UPDATE_USER,UPDATE_DT) values ('Thin Client','Thin client with backend host','TEST',sysdate);
