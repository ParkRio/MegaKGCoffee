DROP TABLE tb_register;

CREATE TABLE tb_register -- 회원테이블
(
    reg_seq NUMBER PRIMARY KEY NOT NULL, -- 회원 식별번호
    reg_name VARCHAR2(20) NOT NULL, -- 이름
    reg_id VARCHAR2(20) NOT NULL, -- 아이디 (중복안됨)
    reg_nick VARCHAR2(20) NOT NULL, -- 닉네임
    reg_tel VARCHAR2(20) NOT NULL, -- 전화번호
    reg_birth DATE NOT NULL, -- 생년월일
    reg_pwd VARCHAR2(20) NOT NULL, -- 비밀번호
    reg_date DATE NOT NULL, -- 가입일
    reg_admin VARCHAR2(1) Default 'N' NOT NULL, -- 관리자 여부 (기본 N(관리자 아님))
    reg_delete VARCHAR2(1) Default 'N' NOT NULL, -- 탈퇴 여부 (기본 N(탈퇴 회원아님)),
    reg_cash NUMBER Default 0, -- 충전금액 Default 0
    reg_login VARCHAR2(1) Default 'N' NOT NULL
);

CREATE SEQUENCE register_seq -- 카테고리 테이블 시퀀스
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1
    MAXVALUE 9999
    NOCYCLE
    NOCACHE
    NOORDER;

--DROP SEQUENCE register_seq;

INSERT INTO tb_register(reg_seq, reg_name, reg_id, reg_nick, reg_tel, reg_birth, reg_pwd, reg_date)
VALUES (register_seq.NEXTVAL,'키','rio1234','rio','010-0000-0000','9999-09-09','1234','9999-09-09');

SELECT * FROM tb_register;

-----------------------------------------------

DROP TABLE tb_category;

CREATE TABLE tb_category -- 카테고리 테이블
(
    category_seq NUMBER PRIMARY KEY NOT NULL,
    category_type VARCHAR2(20) UNIQUE NOT NULL
);

CREATE SEQUENCE category_seq -- 카테고리 테이블 시퀀스
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1
    MAXVALUE 9999
    NOCYCLE
    NOCACHE
    NOORDER;

-- DROP SEQUENCE category_seq;

INSERT INTO tb_category VALUES (category_seq.NEXTVAL, '커피');
INSERT INTO tb_category VALUES (category_seq.NEXTVAL, '에이드');
INSERT INTO tb_category VALUES (category_seq.NEXTVAL, '디저트');

-- UPDATE tb_category SET category_type = '커피' WHERE category_type = 'Coffee'; -- UPDATE CASECADE 안됨

-----------------------------------------------

DROP TABLE tb_menu;

CREATE TABLE tb_menu -- 메뉴 테이블
(
    menu_seq NUMBER PRIMARY KEY NOT NULL,
    menu_category VARCHAR2(20) NOT NULL,
    menu_name VARCHAR2(100) NOT NULL,
    menu_img VARCHAR2(200) NOT NULL, -- Default 사진 자바 로직을 통해 넣어야 할듯?
    menu_desc CLOB NOT NULL,
    menu_price NUMBER NOT NULL,
    CONSTRAINT FK_menu FOREIGN KEY (menu_category) REFERENCES tb_category(category_type) ON DELETE CASCADE
);

CREATE SEQUENCE menu_seq -- 카테고리 테이블 시퀀스
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1
    MAXVALUE 9999
    NOCYCLE
    NOCACHE
    NOORDER;

-- DROP SEQUENCE menu_seq;

INSERT INTO tb_menu(menu_seq, menu_category, menu_name, menu_img, menu_desc, menu_price)
VALUES (menu_seq.NEXTVAL, '커피', '아메리카노', 'Americano.jpeg','따듯한 아메리카노', 5000);

-----------------------------------------------

DROP TABLE tb_orderItem;

CREATE TABLE tb_orderItem
(
    item_seq NUMBER PRIMARY KEY NOT NULL,
    itemMenu_seq NUMBER NOT NULL,
    item_count NUMBER DEFAULT 1 NOT NULL,
    item_price NUMBER NOT NULL,
    CONSTRAINT FK_orderItem FOREIGN KEY(itemMenu_seq) REFERENCES tb_menu(menu_seq) ON DELETE CASCADE
);

CREATE SEQUENCE orderItem_seq -- 카테고리 테이블 시퀀스
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1
    MAXVALUE 9999
    NOCYCLE
    NOCACHE
    NOORDER;

--DROP SEQUENCE orderItem_seq;

INSERT INTO tb_orderItem(item_seq, itemMenu_seq, item_price)
VALUES (orderItem_seq.NEXTVAL, 1, 3000);

SELECT * FROM tb_orderItem;


-----------------

DROP TABLE tb_orderCheck;

CREATE TABLE tb_orderCheck
(
    check_seq NUMBER PRIMARY KEY NOT NULL,
    checkItem_seq NUMBER NOT NULL,
    checkReg_seq NUMBER NOT NULL,
    checkOrder NUMBER DEFAULT 0 NOT NULL,
    CONSTRAINT FK_checkOrder FOREIGN KEY(checkItem_seq) REFERENCES tb_orderItem(item_seq),
    CONSTRAINT FK_checkReg FOREIGN KEY(checkReg_seq) REFERENCES tb_register(reg_seq)
);

CREATE SEQUENCE orderCheck_seq -- 카테고리 테이블 시퀀스
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1
    MAXVALUE 9999
    NOCYCLE
    NOCACHE
    NOORDER;

DROP SEQUENCE orderCheck_seq;

INSERT INTO tb_orderCheck(check_seq, checkItem_seq, checkReg_seq)
VALUES (orderCheck_seq.NEXTVAL, 1, 1);

SELECT * FROM tb_orderCheck;


