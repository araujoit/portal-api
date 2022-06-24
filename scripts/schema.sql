create table posts (id bigint not null auto_increment, content varchar(1000) not null, subject varchar(200) not null, primary key (id)) engine=InnoDB
alter table posts add column updated_at datetime(6)
