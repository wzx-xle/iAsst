/*
Navicat MySQL Data Transfer

Source Server         : iasst
Source Server Version : 50534
Source Host           : localhost:3306
Source Database       : iasst

Target Server Type    : MYSQL
Target Server Version : 50534
File Encoding         : 65001

Date: 2016-08-18 14:59:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_users`
-- ----------------------------
DROP TABLE IF EXISTS `t_users`;
CREATE TABLE `t_users` (
  `oid` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `created_time` datetime NOT NULL COMMENT '创建时间',
  `updated_time` datetime NOT NULL COMMENT '更新时间',
  `username` varchar(45) NOT NULL COMMENT '用户名',
  `password` varchar(45) NOT NULL COMMENT '密码',
  `password_salt` varchar(45) NOT NULL COMMENT '密码的盐',
  `enable` tinyint(4) NOT NULL DEFAULT '1' COMMENT '权限',
  PRIMARY KEY (`oid`),
  UNIQUE KEY `t_users_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Table structure for `t_user_infos`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_infos`;
CREATE TABLE `t_user_infos` (
  `oid` int(11) unsigned NOT NULL COMMENT '主键',
  `created_time` datetime NOT NULL COMMENT '创建时间',
  `updated_time` datetime NOT NULL COMMENT '更新时间',
  `nick_name` varchar(45) DEFAULT '' COMMENT '昵称',
  `email` varchar(45) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`oid`),
  UNIQUE KEY `user_info_oid` (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';
