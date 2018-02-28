/*
Navicat MySQL Data Transfer

Source Server         : edu_video
Source Server Version : 50636
Source Host           : localhost:3306
Source Database       : edu_video

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2018-01-26 16:15:21
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
-- Records of history
-- ----------------------------

-- ----------------------------
-- Table structure for play_plan
-- ----------------------------
DROP TABLE IF EXISTS `play_plan`;
CREATE TABLE `play_plan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `video_id` int(11) NOT NULL COMMENT '视频id',
  `play_time` datetime NOT NULL COMMENT '播放时间',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '计划状态，0-待执行，1-执行中，2-已完成',
  `ctime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `utime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of play_plan
-- ----------------------------

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `study_id` varchar(64) NOT NULL COMMENT '学生学号',
  `stu_name` varchar(32) NOT NULL COMMENT '学生姓名',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态，具体值待定',
  `ctime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `utime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `stu_intro` varchar(1023) DEFAULT NULL,
  `remark` varchar(1023) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('2', '201292368', 'im leBao', '0', '2018-01-18 17:14:21', '2018-01-18 17:14:21', null, null);
INSERT INTO `student` VALUES ('3', '201292368', 'im leBao', '0', '2018-01-18 17:16:40', '2018-01-18 17:16:40', null, null);
INSERT INTO `student` VALUES ('4', '201292368', 'lebao', '0', '2018-01-18 17:45:39', '2018-01-18 17:45:39', null, null);
INSERT INTO `student` VALUES ('5', '201292368', 'lebao', '0', '2018-01-18 17:46:37', '2018-01-18 17:46:37', null, null);

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
  `current_online_count` tinyint(4) NOT NULL DEFAULT '0' COMMENT '当前在线数量',
  `status` tinyint(4) NOT NULL COMMENT '状态，具体值待定',
  `user_name` varchar(16) DEFAULT NULL COMMENT '用户姓名',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `ctime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `utime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', '2', null, '1', '1', '1', null, null, null, '2017-12-27 15:27:25', '2017-12-27 15:27:25');
INSERT INTO `user` VALUES ('2', '2', '2', null, '1', '0', '0', null, null, null, '2017-12-27 17:24:30', '2018-01-18 10:58:43');
INSERT INTO `user` VALUES ('3', '3', '2', null, '1', '0', '0', null, null, null, '2017-12-27 18:23:30', '2018-01-18 10:58:46');
INSERT INTO `user` VALUES ('4', '2', '2', null, '1', '0', '0', null, null, null, '2018-01-18 11:00:33', '2018-01-18 11:00:33');

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
-- Records of video
-- ----------------------------

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
INSERT INTO `watch_authority` VALUES ('1', '2010', '1', '2018-01-24 22:31:33', '2018-01-24 22:32:06');
INSERT INTO `watch_authority` VALUES ('2', '2011', '2', '2018-01-24 22:31:58', '2018-01-24 22:31:58');
INSERT INTO `watch_authority` VALUES ('3', '2012', '2', '2018-01-24 22:32:18', '2018-01-24 22:32:18');
