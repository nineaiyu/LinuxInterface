/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50552
Source Host           : localhost:3306
Source Database       : spring

Target Server Type    : MYSQL
Target Server Version : 50552
File Encoding         : 65001

Date: 2017-06-18 22:47:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `uid` int(255) NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) DEFAULT NULL,
  `upass` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'liuyu', 'liuyu');
INSERT INTO `admin` VALUES ('2', 'haha', 'haha');
INSERT INTO `admin` VALUES ('3', 'nihao', 'nihao');

-- ----------------------------
-- Table structure for app
-- ----------------------------
DROP TABLE IF EXISTS `app`;
CREATE TABLE `app` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `appname` varchar(255) DEFAULT NULL,
  `versions` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of app
-- ----------------------------
INSERT INTO `app` VALUES ('2', 'mysql', '5.6');
INSERT INTO `app` VALUES ('8', 'httpd', 'php52');

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `did` int(255) DEFAULT NULL,
  `dname` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('12', 'one');
INSERT INTO `dept` VALUES ('13', 'two');
INSERT INTO `dept` VALUES ('14', 'three');

-- ----------------------------
-- Table structure for k8s
-- ----------------------------
DROP TABLE IF EXISTS `k8s`;
CREATE TABLE `k8s` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `action` varchar(255) NOT NULL,
  `NamespaceName` varchar(255) NOT NULL,
  `appname` varchar(255) NOT NULL,
  `replicas` int(11) NOT NULL,
  `hostIP` varchar(255) NOT NULL,
  `hostPort` int(11) NOT NULL,
  `hostPath` varchar(255) NOT NULL,
  `containerPath` varchar(255) NOT NULL,
  `containerImage` varchar(255) NOT NULL,
  `cpu` int(11) NOT NULL,
  `mem` int(11) NOT NULL,
  `containerPort` int(11) NOT NULL,
  `deployId` varchar(255) NOT NULL,
  `envname` varchar(255) DEFAULT NULL,
  `envalue` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of k8s
-- ----------------------------

-- ----------------------------
-- Table structure for services
-- ----------------------------
DROP TABLE IF EXISTS `services`;
CREATE TABLE `services` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `servicename` varchar(255) DEFAULT NULL,
  `serviceversion` varchar(255) DEFAULT NULL,
  `ipandport` varchar(255) DEFAULT NULL,
  `account` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of services
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(255) NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) DEFAULT NULL,
  `age` int(255) DEFAULT NULL,
  `did` int(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'liuyu', '23', '12');
INSERT INTO `user` VALUES ('2', '11dd', '111', '13');
INSERT INTO `user` VALUES ('3', 'liuyu1', '452', '14');
INSERT INTO `user` VALUES ('4', 'df', '3', null);
INSERT INTO `user` VALUES ('5', '111', '222', '12');
INSERT INTO `user` VALUES ('6', 'a', '3', null);
INSERT INTO `user` VALUES ('7', '', null, '13');
