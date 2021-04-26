

-- jblog ���� ����: system �������� ����
create user jblog identified by jblog;
grant resource, connect to jblog;

-- ���̺� ����
drop table comments;
drop table post;
drop table category;
drop table blog;
drop table users;

-- ������ ����
drop sequence seq_users_no;
drop sequence seq_category_no;
drop sequence seq_post_no;
drop sequence seq_comments_no;

-- ������ ����
CREATE SEQUENCE seq_users_no
INCREMENT BY 1
START WITH 1 
NOCACHE ;

CREATE SEQUENCE seq_category_no
INCREMENT BY 1
START WITH 1 
NOCACHE ;

CREATE SEQUENCE seq_post_no 
INCREMENT BY 1
START WITH 1 
NOCACHE ;


CREATE SEQUENCE seq_comments_no
INCREMENT BY 1
START WITH 1 
NOCACHE ;

-- ���̺� ����
CREATE TABLE users (
  userNo    NUMBER,
  id	    VARCHAR2(50) 	NOT NULL Unique,
  userName  VARCHAR2(100) 	NOT NULL,
  password  VARCHAR2(50) 	NOT NULL,
  joinDate  DATE 	        NOT NULL,
  PRIMARY KEY(userNo)
);

CREATE TABLE blog (
  userNo    NUMBER,
  blogTitle	VARCHAR2(200) 	NOT NULL,
  logoFile  VARCHAR2(200),
  PRIMARY KEY(userNo),
  CONSTRAINT c_blog_fk FOREIGN KEY (userNo)
  REFERENCES users(userNo)
);

CREATE TABLE category (
  cateNo        NUMBER,
  userNo        NUMBER,  
  cateName	    VARCHAR2(200) 	NOT NULL,
  description    VARCHAR2(500),
  regDate       DATE            NOT NULL,
 
  PRIMARY KEY(cateNo),
  CONSTRAINT c_category_fk FOREIGN KEY (userNo)
  REFERENCES blog(userNo)
);

CREATE TABLE post (
  postNo        NUMBER,
  cateNo        NUMBER,  
  postTitle	    VARCHAR2(300) 	NOT NULL,
  postContent   VARCHAR2(4000),
  regDate       DATE            NOT NULL,
  PRIMARY KEY(postNo),
  CONSTRAINT c_post_fk FOREIGN KEY (cateNo)
  REFERENCES category(cateNo)
);

CREATE TABLE comments (
  cmtNo         NUMBER,
  postNo            NUMBER,
  cmtContent	VARCHAR2(300) 	NOT NULL,
  regDate           DATE            NOT NULL,
  PRIMARY KEY(cmtNo),
  CONSTRAINT c_comment_fk FOREIGN KEY (postNo)
  REFERENCES post(postNo)
);


INSERT INTO users(userNo,id,userName,password,joinDate) values(seq_users_no.nextval,'wjsgpwl','wjsgpwl7','wjsgpwl725',sysdate);
INSERT INTO category(cateNo,userNo,cateName,description,regDate) values(seq_category_no.nextval,725,'a','aa',sysdate);
INSERT INTO post(postNo,cateNo,postTitle,postContent,regDate) values(seq_post_no.nextval,1,'post1','post content1',sysdate);
INSERT INTO comments(cmtNo,postNo,userNo,cmtContent,regDate) values(seq_comments_no.nextval,1,725,'cmt11',sysdate);
SELECT 
				cateNo,userNo,cateName,description,regDate
			FROM
				category
			WHERE
				userNo = 725
			ORDER BY
				regDate;

UPDATE
				blog
			SET
				blogTitle='�������� ��α� �Դϴ�.',logoFile=''
			WHERE
				userNo = 725;

delete from users;
delete from blog;
delete from category;

commit;

select * from users;
select * from blog;
select * from category;
select * from post;
select * from comments;

select c.cateNo,cateName,nvl(cnt,0) as cnt,description 
from category c left join (select count(*) cnt ,cateNo  from post where cateNo is not null group by cateNo) b
on c.cateNo = b.cateNo ;
select nvl(c.count,0) from (select count(*) count  from post where cateNo = 4 group by cateNo) c;
select count(*) count  from post where cateNo = 4 group by cateNo;
SELECT 
				c.cateNo,cateName,nvl(cnt,0) as cnt,description,c.regDate
			FROM 
				category c 
			LEFT JOIN 
				(
				SELECT
					count(*) cnt ,cateNo  
				FROM 
					post 
				WHERE 
					cateNo is not null 
				GROUP BY
					cateNo
				) b
			ON 
				c.cateNo = b.cateNo
            WHERE
                c.userNo = 725
			ORDER BY
				c.regDate;

select count(*) as cnt,cateNo from post group by cateNo;

SELECT B.userNo,blogTitle,logoFile,C.userNo,cateName
FROM
	blog b , category c
WHERE
    b.userNo = c.userNo
AND
    b.userNo = 725;

select * from user_sys_privs;

grant connect,resource to c##jblog;
SELECT seq_users_no.currval FROM dual ;
commit;

alter user c##jblog quota unlimited on blog;

SELECT * FROM POST;


    
SELECT
    *
FROM
    post
WHERE
    postNo = '1';
SELECT
				postTitle,regDate
			FROM
				post
			WHERE
				cateNo = 3;

SELECT 
				COUNT(*)
			FROM
				users
			WHERE
				id = 'wjsgpwl7';


SELECT 
    *
FROM
    category a left join post b
on
    a.cateNo  = b.cateNO 
where
    userNo = 725;
    
SELECT 
    *
FROM
    category a
WHERE
    userNo = 725;
    
SELECT 
				cmtNo,postNo,cmt.userNo,cmtContent,regDate,userName
			FROM
				comments cmt, users u
			WHERE
                cmt.userNo = u.userNo
            AND
				postNo = 1;
                
SELECT 
    cateNo
FROM
    post
WHERE
    postNo = 1;