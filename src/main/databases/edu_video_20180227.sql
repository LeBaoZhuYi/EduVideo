/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : edu_video

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-02-27 01:55:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for history
-- ----------------------------
DROP TABLE IF EXISTS `history`;
CREATE TABLE `history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_id` int(11) NOT NULL COMMENT '视频id',
  `stu_id` int(11) NOT NULL COMMENT '学生id',
  `ctime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of history
-- ----------------------------

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `group_id` int(11) NOT NULL,
  `study_id` varchar(64) NOT NULL COMMENT '学生学号',
  `study_name` varchar(32) NOT NULL COMMENT '学生姓名',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态，具体值待定',
  `ctime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `utime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `sex` tinyint(4) DEFAULT NULL,
  `study_intro` varchar(1023) DEFAULT '',
  `teacher_remark` varchar(1023) DEFAULT '',
  `parent_words` varchar(1023) DEFAULT '',
  `phone` varchar(20) DEFAULT '',
  `birthday` varchar(20) DEFAULT '',
  `food` varchar(127) DEFAULT '',
  `interest` varchar(127) DEFAULT '',
  `disagree` varchar(127) DEFAULT '',
  `ideal` varchar(127) DEFAULT '',
  `img_urls` varchar(2047) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '13', '1', '123456', '测试', '1', '2018-02-26 23:23:07', '2018-02-26 23:27:37', '0', '', '', '', '10000', '', '', '', '', '', null);

-- ----------------------------
-- Table structure for student_class_info
-- ----------------------------
DROP TABLE IF EXISTS `student_class_info`;
CREATE TABLE `student_class_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `status` tinyint(4) DEFAULT '0',
  `score` int(11) DEFAULT NULL,
  `teacher_remark` varchar(2047) DEFAULT NULL,
  `ctime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `utime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_class_info
-- ----------------------------

-- ----------------------------
-- Table structure for student_group
-- ----------------------------
DROP TABLE IF EXISTS `student_group`;
CREATE TABLE `student_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态，具体值待定',
  `ctime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `utime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(127) DEFAULT NULL,
  `remark` varchar(1023) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of student_group
-- ----------------------------
INSERT INTO `student_group` VALUES ('1', '1', '2018-02-26 23:22:06', '2018-02-26 23:22:37', '分组一', '测试分组');

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
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态，具体值待定',
  `ctime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `utime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('13', 'test', 'e10adc3949ba59abbe56e057f20f883e', '2018-02-27 00:28:54', '3', '1', '2018-02-26 23:23:07', '2018-02-26 23:23:07');

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `route` varchar(255) NOT NULL COMMENT '视频路径（访问参数）',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `comment` varchar(255) DEFAULT NULL COMMENT '描述',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态，具体值待定',
  `watched_times` int(11) NOT NULL DEFAULT '0' COMMENT '点播次数',
  `ctime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `utime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video` VALUES ('5', '7447398154852882993', '视频一', '示例视频', '2', '0', '2018-02-26 23:53:15', '2018-02-27 00:00:18');
INSERT INTO `video` VALUES ('6', '4564972819148766178', '旧视频', '测试', '2', '0', '2018-02-27 01:41:14', '2018-02-27 01:41:14');

-- ----------------------------
-- Table structure for video_class
-- ----------------------------
DROP TABLE IF EXISTS `video_class`;
CREATE TABLE `video_class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(255) NOT NULL,
  `teacher_name` varchar(63) DEFAULT NULL,
  `video_id` int(11) NOT NULL COMMENT '视频id',
  `group_id` int(11) NOT NULL COMMENT '分组id',
  `start_time` datetime DEFAULT NULL COMMENT '开放开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '开放结束时间',
  `status` tinyint(4) DEFAULT '1',
  `ctime` datetime DEFAULT CURRENT_TIMESTAMP,
  `utime` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of video_class
-- ----------------------------
INSERT INTO `video_class` VALUES ('6', '测试一', '韩老师', '5', '1', '2018-02-27 01:36:10', '2018-02-27 01:40:49', '1', '2018-02-27 00:26:15', '2018-02-27 00:26:15');
INSERT INTO `video_class` VALUES ('7', '过去的', '嗯', '6', '1', '2018-02-26 01:42:01', '2018-02-26 01:42:05', '1', '2018-02-27 01:42:08', '2018-02-27 01:42:08');

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

-- ----------------------------
-- Records of watch_authority
-- ----------------------------
