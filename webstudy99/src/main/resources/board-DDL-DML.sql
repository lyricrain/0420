DROP TABLE member;

CREATE TABLE member(
	id VARCHAR2(100) PRIMARY KEY,
	password VARCHAR2(100) NOT NULL,
	name VARCHAR2(100) NOT NULL
)
INSERT INTO member(id,password,name) VALUES('java','a','아이유');
INSERT INTO member(id,password,name) VALUES('spring','a','박보검');

COMMIT

SELECT * FROM member;

DROP TABLE board;

CREATE TABLE board(
	no NUMBER PRIMARY KEY,
	title VARCHAR2(100) NOT NULL,
	content CLOB NOT NULL,
	hits NUMBER DEFAULT 0,
	time_posted DATE NOT NULL,
	id VARCHAR2(100) NOT NULL,
	CONSTRAINT myboard_fk FOREIGN KEY(id) REFERENCES member(id)
)
/*
      Oracle 문자열 varchar2 타입은 최대 4000byte 까지 가능 
      Oracle clob datatype 을 이용하면 많은 문자열을 저장할 수 있음 
      CLOB (character large object) 최대 4GB까지 가능 
      사용법은 varchar2 와 동일함  
 */

DROP SEQUENCE board_seq;
CREATE SEQUENCE board_seq;

INSERT INTO board(no,title,content,time_posted,id) VALUES(board_seq.nextval,'즐공','웹공부중~',sysdate,'java');
INSERT INTO board(no,title,content,time_posted,id) VALUES(board_seq.nextval,'열공','인생공부중~',sysdate,'spring');
-- error : parent key not found , member table에 존재하는 회원아이디로만 insert 가능 -> foreign key 제약조건 
INSERT INTO board(no,title,content,time_posted,id) VALUES(board_seq.nextval,'열공','인생공부중~',sysdate,'jsp');

COMMIT
SELECT * FROM board;
-- 게시판 리스트 조회 SQL test 
-- 게시물번호, 제목 , 작성자명 , 작성일 , 조회수가 제공되어야 함 
-- 게시물번호 no , 제목 title , 작성일 time_posted , 조회수 hits -> board table 
-- 작성자명 name -> member table 
-- member 와 board 테이블 결합 -> inner join 
-- 최근 게시물순으로 정렬 , 작성일 to_char(column,'YYYY.MM.DD')
-- Oracle 
SELECT b.no,b.title,m.name,TO_CHAR(time_posted,'YYYY.MM.DD') as time_posted,b.hits
FROM member m, board b
WHERE	m.id=b.id
ORDER BY b.no DESC
-- ANSI SQL 
SELECT b.no,b.title,m.name,TO_CHAR(time_posted,'YYYY.MM.DD') as time_posted,b.hits
FROM member m
INNER JOIN board b ON m.id=b.id
ORDER BY b.no DESC


-- 로그인 SQL 
-- id password가 일치하지 않으면 결과조회 x 
SELECT name FROM member WHERE id='java' AND password='b';
-- id password 일치할때만 결과조회 o 
SELECT name FROM member WHERE id='java' AND password='a';


































