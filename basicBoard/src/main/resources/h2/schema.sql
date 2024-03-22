CREATE SEQUENCE board_id_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE user_id_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE USERS(
	user_id			NUMBER			NOT NULL DEFAULT user_id_seq.nextval,
	username		VARCHAR2(50)	NOT NULL, 
	email			VARCHAR2(50)    NOT NULL,
	password		VARCHAR2(50)	NOT NULL,
	primary key (user_id)
);
CREATE TABLE BOARD (
    board_id       NUMBER          NOT NULL DEFAULT board_id_seq.nextval, 
    writer         VARCHAR2(50)    NOT NULL, 
    title          VARCHAR2(50), 
    content        VARCHAR2(1000), 
    reg_date       VARCHAR2(20)    NOT NULL, 
    update_date    VARCHAR2(20), 
    delete_date    VARCHAR2(20), 
    PRIMARY KEY (board_id)
);

-- member 테이블 생성
CREATE TABLE MEMBER(
	member_id	 	VARCHAR2(50)	NOT NULL,
	username		VARCHAR2(50)	NOT NULL, 
	email			VARCHAR2(50)    NOT NULL,
	password		VARCHAR2(50)	NOT NULL,
	primary key (member_id)
);

-- board 테이블 Comment 설정
COMMENT ON TABLE board IS '게시판 테이블';
COMMENT ON COLUMN board.board_id IS '게시글ID';
COMMENT ON COLUMN board.writer IS '작성자';
COMMENT ON COLUMN board.title IS '제목';
COMMENT ON COLUMN board.content IS '내용';
COMMENT ON COLUMN board.reg_date IS '등록 일자';
COMMENT ON COLUMN board.update_date IS '수정 일자';
COMMENT ON COLUMN board.delete_date IS '삭제 일자';

-- board 시퀀스 생성
