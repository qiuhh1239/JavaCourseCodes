/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50732
Source Host           : localhost:3306
Source Database       : e_commerce_platform

Target Server Type    : MYSQL
Target Server Version : 50732
File Encoding         : 65001

Date: 2021-09-26 23:03:59
*/

/**
 * 创建数据库
 */
CREATE DATABASE IF NOT EXISTS  `e_commerce_platform`  DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;

CREATE DATABASE IF NOT EXISTS `e_commerce_platform_1` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin ;

/**
 * 在sharding proxy 控制台创建表
 */
use sharding_db;
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` bigint(24) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(24) DEFAULT NULL,
  `money` decimal(10,0) DEFAULT NULL,
  `create_time` bigint(20) DEFAULT NULL,
  `update_time` bigint(20) DEFAULT NULL,
  `order_status` tinyint(2) DEFAULT NULL,
  `consignee_id` bigint(24) DEFAULT NULL COMMENT '收件人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of orders
-- ----------------------------

