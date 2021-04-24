create database lowcode;
use lowcode;

-- ------------------------------------------------
-- 基本权限配置表
-- ------------------------------------------------
drop table user;
create table user
(
    id int unsigned auto_increment comment '自增主键' primary key,
    user_id varchar(32) not null comment '用户标识',
    user_name varchar(32) not null comment '用户名称',
    remark varchar(64) not null comment '用户描述',
    app_name varchar(64) not null default 'system' comment '应用名称',
    operator_name varchar(64) not null default 'system' comment '操作员名称',
    create_time timestamp default CURRENT_TIMESTAMP not null comment '创建时间戳',
    update_time timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间戳'
) comment '用户表' ENGINE=Innodb default charset=UTF8 auto_increment=1;
create unique index uk_user_id on user (app_name, user_id) comment '标识索引';
