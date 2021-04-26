create database lowcode;
use lowcode;

-- ------------------------------------------------
-- 基本权限配置表
-- ------------------------------------------------
create table user
(
    id int unsigned auto_increment comment '自增主键' primary key,
    user_id varchar(32) not null comment '用户标识',
    user_name varchar(32) not null comment '用户名称',
    remark varchar(64) not null comment '用户描述',
    status varchar(1) not null default 'S' comment '用户状态',
    app_name varchar(64) not null default 'system' comment '应用名称',
    operator_name varchar(64) not null default 'system' comment '操作员名称',
    create_time timestamp default CURRENT_TIMESTAMP not null comment '创建时间戳',
    update_time timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间戳'
) comment '用户表' ENGINE=Innodb default charset=UTF8 auto_increment=1;
create unique index uk_user_id on user (app_name, user_id) comment '标识索引';

-- ------------------------------------------------
-- 枚举映射表
-- ------------------------------------------------
create table lc_enum_mapping
(
    id int unsigned auto_increment comment '自增主键' primary key,
    table_name varchar(32) not null comment '表名称',
    column_name varchar(64) not null comment '字段名称',
    `key` varchar(64) not null comment '字段编码',
    label varchar(64) not null comment '字段显示',
    create_time timestamp default CURRENT_TIMESTAMP not null comment '创建时间戳',
    update_time timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间戳'
) comment '枚举映射表' ENGINE=Innodb default charset=UTF8 auto_increment=1;
create unique index ix_lc_enum_mapping on lc_enum_mapping (table_name, column_name, `key`) comment '标识索引';

insert into lc_enum_mapping (table_name, column_name, `key`, label)  values ('user', 'status', 'S', '正常');
insert into lc_enum_mapping (table_name, column_name, `key`, label)  values ('user', 'status', 'F', '失效');
