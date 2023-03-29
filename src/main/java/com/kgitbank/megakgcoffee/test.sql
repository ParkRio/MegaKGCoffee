DROP TABLE test_tb_Coffee;

CREATE TABLE test_tb_Coffee
(
    test_seq NUMBER PRIMARY KEY NOT NULL,
    test_id VARCHAR2(20) NOT NULL,
    test_password VARCHAR2(20) NOT NULL
);

DROP SEQUENCE test_Coffee_seq;

CREATE SEQUENCE test_Coffee_seq -- 카테고리 테이블 시퀀스
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1
    MAXVALUE 9999
    NOCYCLE
    NOCACHE
    NOORDER;

INSERT INTO test_tb_Coffee(test_seq, test_id, test_password)
VALUES (test_Coffee_seq.NEXTVAL, 'Rio', '1234');

SELECT * FROM test_tb_Coffee;

