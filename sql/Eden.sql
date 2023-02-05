/* 회원가입 Table */
drop table eden_user;
create table eden_user(
    user_no int(11) primary key auto_increment,
    question_no int(11) not null default 1,
    user_id varchar(15) not null unique,
    user_pw varchar(200) not null,
    user_nickname varchar(30) not null unique,
    user_image varchar(200) not null default 'default-user-image.jpg',
    user_gender varchar(1) not null default 'N',
    user_birth timestamp not null default now(),
    user_phone varchar(30) not null unique,
    user_email varchar(200) not null unique,
    user_findAnswer varchar(200) not null default '기본값',
    user_status varchar(200) not null default 'active',
    user_join_date timestamp not null default now(),
    user_last_connection_date timestamp not null default now(),
    sessionkey varchar(50) NOT NULL DEFAULT 'none',
    sessionlimit timestamp default now(),
    constraint user_find_question_no foreign key (question_no) references eden_find_question (question_no)
);

/* 비밀번호 찾기 질문 테이블 */
drop table eden_find_question;
create table eden_find_question
(
    question_no      INT(11) PRIMARY KEY AUTO_INCREMENT,
    question_content VARCHAR(100) NOT NULL
);

INSERT INTO eden_find_question(question_no, question_content) VALUES(1, '졸업한 초등학교의 이름은 무엇 입니까?');
INSERT INTO eden_find_question(question_no, question_content) VALUES(2, '태어난 고향은 어디 입니까?');
INSERT INTO eden_find_question(question_no, question_content) VALUES(3, '가장 친한 사촌의 이름은 무엇 입니까?');
INSERT INTO eden_find_question(question_no, question_content) VALUES(4, '어렷을적의 별명은 무엇 입니까?');
INSERT INTO eden_find_question(question_no, question_content) VALUES(5, '부모님의 고향은 어디 입니까?');
INSERT INTO eden_find_question(question_no, question_content) VALUES(6, '가장 좋아하는 색깔은 무엇 입니까?');
INSERT INTO eden_find_question(question_no, question_content) VALUES(7, '가장 좋아하는 음식은 무엇 입니까?');

alter table eden_user add column question_no INT(11) not null default 1;
alter table eden_user add constraint user_find_question_no foreign key (question_no) references eden_find_question (question_no);
alter table eden_user add column user_findAnswer varchar(200) not null default '기본값';

-- 세션 아이디
ALTER TABLE eden_user add column sessionkey varchar(50) NOT NULL DEFAULT 'none';

-- 세션 유효시간 : 유효한 기간에 다시 접속을 했는지 판단
ALTER TABLE eden_user add column sessionlimit timestamp default now();

-- 게시판 테이블
drop table eden_board;
create table eden_board(
    board_no int(11) primary key auto_increment,
    user_no int(11) not null,
    board_title varchar(2000) not null default '제목',
    board_content varchar(4000) not null default '내용',
    board_readcount int(11) not null default 0,
    board_write_date timestamp not null default now(),
    constraint board_userNo foreign key(user_no) references eden_user(user_no)
);

insert into eden_board(board_no, user_no, board_title, board_content, board_readcount, board_write_date) values(1, 1, '제목', '내용', 0, now());

-- 게시판 좋아요 테이블
drop table eden_board_like;
create table eden_board_like(
    like_no int(11) primary key AUTO_INCREMENT,
    user_no int(11) not null,
    board_no int(11) not null,
    like_date timestamp not null default now(),
    constraint like_userNo foreign key (user_no) references eden_user(user_no),
    constraint like_boardNo foreign key (board_no) references eden_board(board_no)
);

-- 댓글 테이블
drop table eden_comment;
create table eden_comment(
    comment_no int(11) primary key auto_increment,
    user_no int(11) not null,
    board_no int(11) not null,
    comment_content varchar(4000) not null,
    comment_write_date timestamp not null default now(),
    constraint comment_userNo foreign key (user_no) references eden_user(user_no),
    constraint comment_boardNo foreign key (board_no) references eden_board(board_no)
);

