/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : edu_video

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-02-11 00:29:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for history
-- ----------------------------
DROP TABLE IF EXISTS `history`;
CREATE TABLE `history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `video_id` int(11) NOT NULL COMMENT '视频id',
  `stu_id` int(11) NOT NULL COMMENT '学生id',
  `ctime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `study_id` varchar(64) NOT NULL COMMENT '学生学号',
  `stu_name` varchar(32) NOT NULL COMMENT '学生姓名',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态，具体值待定',
  `ctime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `utime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `stu_intro` varchar(1023) DEFAULT NULL,
  `remark` varchar(1023) DEFAULT NULL,
  `parent_words` varchar(1023) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `birthday` varchar(20) DEFAULT NULL,
  `food` varchar(127) DEFAULT NULL,
  `interest` varchar(127) DEFAULT NULL,
  `disagree` varchar(127) DEFAULT NULL,
  `ideal` varchar(127) DEFAULT NULL,
  `img_urls` varchar(2047) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for student_class_info
-- ----------------------------
DROP TABLE IF EXISTS `student_class_info`;
CREATE TABLE `student_class_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_id` int(11) NOT NULL,
  `stu_id` int(11) NOT NULL,
  `score` int(11) DEFAULT NULL,
  `teacher_remark` varchar(2047) DEFAULT NULL,
  `ctime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `utime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(255) NOT NULL COMMENT '登录名',
  `password` varchar(255) NOT NULL COMMENT '密码（已加密）',
  `last_login_time` datetime DEFAULT NULL COMMENT '上次登录时间',
  `role_id` tinyint(4) NOT NULL COMMENT '角色id',
  `status` tinyint(4) NOT NULL COMMENT '状态，具体值待定',
  `ctime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `utime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `route` varchar(255) NOT NULL COMMENT '视频路径（访问参数）',
  `name` varchar(255) NOT NULL COMMENT '视频路径（访问参数）',
  `teacher_name` varchar(255) DEFAULT NULL COMMENT '教师名',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `comment` varchar(255) DEFAULT NULL COMMENT '描述',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态，具体值待定',
  `watched_times` int(11) NOT NULL DEFAULT '0' COMMENT '点播次数',
  `ctime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `utime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for video_class
-- ----------------------------
DROP TABLE IF EXISTS `video_class`;
CREATE TABLE `video_class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `video_id` int(11) DEFAULT NULL COMMENT '视频id',
  `start_time` datetime DEFAULT NULL COMMENT '开放开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '开放结束时间',
  `ctime` datetime DEFAULT CURRENT_TIMESTAMP,
  `utime` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for watch_authority
-- ----------------------------
DROP TABLE IF EXISTS `watch_authority`;
CREATE TABLE `watch_authority` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(11) NOT NULL COMMENT '学生id',
  `video_id` int(11) NOT NULL COMMENT '视频id',
  `ctime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `utime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
