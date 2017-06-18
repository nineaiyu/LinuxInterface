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
INSERT INTO `k8s` VALUES ('20', 'create', 'liuyu', 'httpd', '1', ' 10.23.74.212', '10283', '/data/NFS/services/httpd/liuyu/', '/usr/local/tomcat/webapps/ROOT', '10.23.74.220:5000/httpd:php5.6', '2', '2', '8080', '10283', 'null', 'null');
INSERT INTO `k8s` VALUES ('21', 'create', 'liuyu', 'httpd', '1', ' 10.23.74.213', '10285', '/data/NFS/services/httpd/liuyu/', '/var/www/html', '10.23.74.220:5000/httpd:php5.6', '2', '2', '80', '10285', 'null', 'null');
INSERT INTO `k8s` VALUES ('22', 'create', 'liuyu', 'httpd', '1', ' 10.23.74.212', '10287', '/data/NFS/services/httpd/liuyu/', '/var/www/html', '10.23.74.220:5000/httpd/httpd:php5.6', '2', '2', '80', '10287', 'null', 'null');
INSERT INTO `k8s` VALUES ('23', 'create', 'liuyu', 'httpd', '1', ' 10.23.74.212', '10289', '/data/NFS/services/httpd/liuyu/', '/var/www/html', '10.23.74.220:5000/httpd/httpd:php5.6', '2', '2', '80', '10289', 'null', 'null');
INSERT INTO `k8s` VALUES ('24', 'create', 'liuyu', 'httpd', '1', '10.1.41.101', '10002', '/data/NFS/services/httpd/liuyu/', '/var/www/html', '10.1.41.200:5000/httpd/httpd:php52', '1', '1', '80', '10002', 'null', 'null');
INSERT INTO `k8s` VALUES ('25', 'create', 'liuyu', 'httpd', '1', ' 10.1.41.102', '10004', '/data/NFS/services/httpd/liuyu/', '/var/www/html', '10.1.41.200:5000/httpd/httpd:php52', '1', '1', '80', '10004', 'null', 'null');
INSERT INTO `k8s` VALUES ('26', 'create', 'liuyu', 'httpd', '1', ' 10.1.41.102', '10004', '/data/NFS/services/httpd/liuyu/', '/var/www/html', '10.1.41.200:5000/httpd/httpd:php52', '1', '1', '80', '10004', 'null', 'null');
INSERT INTO `k8s` VALUES ('27', 'create', 'liuyu', 'mysql', '1', '10.1.41.101', '10006', '/data/NFS/services/mysql/liuyu/', '/var/lib/mysql', '10.1.41.200:5000/mysql/mysql:5.6', '1', '1', '3306', '10006', 'MYSQL_ROOT_PASSWORD', 'WRvMhAmogBfV6YlG');
INSERT INTO `k8s` VALUES ('28', 'create', 'liuyu', 'httpd', '1', '10.1.41.101', '10007', '/data/NFS/services/httpd/liuyu/', '/usr/local/apache2/htdocs', '10.1.41.200:5000/httpd/httpd:php52', '1', '1', '80', '10007', 'null', 'null');
INSERT INTO `k8s` VALUES ('29', 'create', 'liuyu', 'mysql', '1', ' 10.1.41.102', '10010', '/data/NFS/services/mysql/liuyu/', '/var/lib/mysql', '10.1.41.200:5000/mysql/mysql:5.6', '1', '1', '3306', '10010', 'MYSQL_ROOT_PASSWORD', 'IWaLlivu3bXPW2g4');
INSERT INTO `k8s` VALUES ('30', 'create', 'liuyu', 'httpd', '1', ' 10.1.41.102', '10011', '/data/NFS/services/httpd/liuyu/', '/usr/local/apache2/htdocs', '10.1.41.200:5000/httpd/httpd:php52', '1', '1', '80', '10011', 'null', 'null');
INSERT INTO `k8s` VALUES ('31', 'create', 'liuyu', 'mysql', '1', ' 10.1.41.102', '10010', '/data/NFS/services/mysql/liuyu/', '/var/lib/mysql', '10.1.41.200:5000/mysql/mysql:5.6', '1', '1', '3306', '10010', 'MYSQL_ROOT_PASSWORD', 'IWaLlivu3bXPW2g4');
INSERT INTO `k8s` VALUES ('32', 'create', 'liuyu', 'httpd', '1', '10.1.41.101', '10011', '/data/NFS/services/httpd/liuyu/', '/usr/local/apache2/htdocs', '10.1.41.200:5000/httpd/httpd:php52', '1', '1', '80', '10012', 'null', 'null');
INSERT INTO `k8s` VALUES ('33', 'create', 'liuyu', 'mysql', '1', ' 10.1.41.102', '10019', '/data/NFS/services/mysql/liuyu/', '/var/lib/mysql', '10.1.41.200:5000/mysql/mysql:5.6', '1', '1', '3306', '10019', 'MYSQL_ROOT_PASSWORD', 'n9bRgmEzGKZa6gwK');
INSERT INTO `k8s` VALUES ('34', 'create', 'liuyu', 'httpd', '1', '10.1.41.101', '10020', '/data/NFS/services/httpd/liuyu/', '/usr/local/apache2/htdocs', '10.1.41.200:5000/httpd/httpd:php52', '1', '1', '80', '10020', 'null', 'null');

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
