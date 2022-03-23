-- table 생성
CREATE TABLE inside(
	NAME varchar2(15) NOT null
	,MBTI varchar2(4)
	,likething varchar2(30)
	,dislike varchar2(30)
	,CONSTRAINT product_pk PRIMARY KEY (name)
	);

-- table 삭제
drop TABLE inside;

-- table에 정보 삽입
insert INTO inside values('김은혁', 'intp', '게임', '벌레');
insert INTO inside values('오다솔', 'istp', '카페가기', '벌레');
insert INTO inside values('김예지', 'entp', '고양이', '당근');



-- table 확인
SELECT * FROM inside;



--------------------
CREATE TABLE outside(
	NAME varchar2(15), sex varchar(3), live varchar2(30), age number(2), phone varchar(9)
	,CONSTRAINT FK_NAME FOREIGN KEY(NAME) REFERENCES inside(NAME)
);
	
DROP TABLE outside;

INSERT INTO outside values('김은혁', '남', '인천', 27, '아이폰');
INSERT INTO outside values('오다솔', '여', '서울', 28, '아이폰');
INSERT INTO outside values('김예지', '여', '대구', 27, '갤럭시');



-- table 확인
SELECT * FROM outside;
