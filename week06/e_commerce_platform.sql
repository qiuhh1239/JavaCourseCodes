/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50732
Source Host           : localhost:3306
Source Database       : e-commerce_platform

Target Server Type    : MYSQL
Target Server Version : 50732
File Encoding         : 65001

Date: 2021-09-26 20:22:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `commodity`
-- ----------------------------
DROP TABLE IF EXISTS `commodity`;
CREATE TABLE `commodity` (
  `id` bigint(24) NOT NULL AUTO_INCREMENT,
  `commodity_code` varchar(24) DEFAULT NULL COMMENT '商品编码',
  `commodity_name` varchar(24) DEFAULT NULL COMMENT '商品名称',
  `commodity_label` tinyint(4) DEFAULT NULL COMMENT '商品分类',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of commodity
-- ----------------------------

-- ----------------------------
-- Table structure for `consignee_address`
-- ----------------------------
DROP TABLE IF EXISTS `consignee_address`;
CREATE TABLE `consignee_address` (
  `id` bigint(24) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(24) NOT NULL,
  `consignee_address` varchar(36) DEFAULT NULL COMMENT '收件人地址',
  `consignee_name` varchar(24) DEFAULT NULL COMMENT '收件人姓名',
  `consignee_telephone` int(11) DEFAULT NULL COMMENT '收件人电话',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of consignee_address
-- ----------------------------

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` bigint(24) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(24) DEFAULT NULL,
  `money` decimal(10,0) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `order_status` tinyint(2) DEFAULT NULL,
  `consignee_id` bigint(24) DEFAULT NULL COMMENT '收件人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of orders
-- ----------------------------

-- ----------------------------
-- Table structure for `orders_commodity`
-- ----------------------------
DROP TABLE IF EXISTS `orders_commodity`;
CREATE TABLE `orders_commodity` (
  `id` bigint(24) NOT NULL AUTO_INCREMENT,
  `orders_id` bigint(24) DEFAULT NULL COMMENT '订单ID',
  `commodity_id` bigint(24) DEFAULT NULL COMMENT '商品ID',
  `num` tinyint(2) DEFAULT NULL COMMENT '商品数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of orders_commodity
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(24) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(24) DEFAULT NULL,
  `user_password` char(32) DEFAULT NULL,
  `user_alias` varchar(24) DEFAULT NULL COMMENT '昵称',
  `identit_card` char(18) DEFAULT NULL COMMENT '身份证号码',
  `user_telephone` int(11) DEFAULT NULL COMMENT '手机号码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
