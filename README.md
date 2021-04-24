# low-code

[low-code](https://github.com/houbb/low-code) 是一款为 java 打造的低代码平台。

[![Build Status](https://travis-ci.com/houbb/low-code.svg?branch=master)](https://travis-ci.com/houbb/low-code)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.houbb/low-code/badge.svg)](http://mvnrepository.com/artifact/com.github.houbb/low-code)
[![](https://img.shields.io/badge/license-Apache2-FF0080.svg)](https://github.com/houbb/low-code/blob/master/LICENSE.txt)
[![Open Source Love](https://badges.frapsoft.com/os/v2/open-source.svg?v=103)](https://github.com/houbb/low-code)

## 特性

- 代码一键生成

- 生产代码一键清理

## 技术选型

springboot 容器

mybatis-plus+druid+mysql 数据库

vue+element-ui 页面

hibernate-validator 参数校验

jwt 授权

## 变更日志

[变更日志](CHANGELOG.md)

# 快速开始

## 需要

jdk 1.7+

maven 3.x+

mysql 5.7

## 配置调整

此处使用的是 mysql-5.7，数据库脚本见 [mysql-5.7.sql](https://github.com/houbb/low-code/blob/master/low-code-dal/src/main/resources/sql/mysql-5.7.sql)

在 mysql 中执行上述脚本，默认的 mysql 登录信息为 root/123456。

如果需要调整，修改 [application.yml](https://github.com/houbb/low-code/blob/master/low-code-web/src/main/resources/application.yml) 文件。

## 启动

直接运行 Application#main() 方法，即可启动应用。

## 首页

![登录页面](https://images.gitee.com/uploads/images/2020/0922/220910_e720716c_508704.png)

默认的登录账号为 admin/123456。

# 分支特性

[v0.0.1-基本 dal 等实现]()

# 拓展阅读



# 后期 Road-MAP

## 数据源

- [ ] 其他数据库支持

- [ ] 其他前端语言支持

- [ ] 其他后端语言支持

## 自动生成

- gen-test-plugin 接入

- swagger 接入

- JAPIDocs 接入

## 可视化

- 页面化

- 高度定制化