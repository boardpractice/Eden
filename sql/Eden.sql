/* 회원가입 Table */
drop table eden_user;
create table eden_user(
    user_no int(11) primary key auto_increment,
    user_id varchar(15) not null unique,
    user_pw varchar(200) not null,
    user_nickname varchar(30) not null unique,
    user_image varchar(200) not null default 'default-user-image.jpg',
    user_gender varchar(1) not null default 'N',
    user_birth timestamp not null default now(),
    user_phone varchar(30) not null unique,
    user_email varchar(200) not null unique,
    user_status varchar(200) not null default 'active',
    user_join_date timestamp not null default now(),
    user_last_connection_date timestamp not null default now()
);