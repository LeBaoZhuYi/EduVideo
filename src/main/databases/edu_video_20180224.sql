/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : edu_video

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-02-25 01:17:48
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
  `group_name` varchar(127) DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '2', '1', null, '201292368', 'im leBao', '1', '2018-01-18 17:14:21', '2018-02-22 22:44:47', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `student` VALUES ('2', '3', '1', null, '201292368', 'im leBao', '1', '2018-01-18 17:16:40', '2018-02-22 22:44:48', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `student` VALUES ('3', '4', '2', null, '201292368', 'lebao', '1', '2018-01-18 17:45:39', '2018-02-22 22:44:50', null, null, null, null, null, null, null, null, null, null, null);

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
  `student_id_list` text NOT NULL COMMENT '学生学号',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态，具体值待定',
  `ctime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `utime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(127) DEFAULT NULL,
  `remark` varchar(1023) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of student_group
-- ----------------------------
INSERT INTO `student_group` VALUES ('1', '[1,2]', '1', '2018-02-22 22:19:46', '2018-02-22 23:26:20', '分组一', '12312312312');
INSERT INTO `student_group` VALUES ('2', '[3]', '1', '2018-02-22 22:19:52', '2018-02-22 23:26:21', '分组二', '3432423');

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
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', '2', null, '1', '1', '2017-12-27 15:27:25', '2017-12-27 15:27:25');
INSERT INTO `user` VALUES ('2', '2', '2', null, '3', '0', '2017-12-27 17:24:30', '2018-02-22 22:13:27');
INSERT INTO `user` VALUES ('3', '3', '2', null, '3', '0', '2017-12-27 18:23:30', '2018-02-22 22:13:29');
INSERT INTO `user` VALUES ('4', 'test', 'e10adc3949ba59abbe56e057f20f883e', null, '3', '0', '2018-01-18 11:00:33', '2018-02-22 22:13:32');

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video` VALUES ('1', '123', '视频一', '测试', '1', '0', '2018-02-22 22:15:21', '2018-02-22 22:44:27');
INSERT INTO `video` VALUES ('2', '123', '视频二', '测试', '1', '0', '2018-02-22 22:15:28', '2018-02-22 22:44:28');
INSERT INTO `video` VALUES ('3', '123', '视频三', '测试', '1', '0', '2018-02-22 22:15:35', '2018-02-22 22:44:29');

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of video_class
-- ----------------------------
INSERT INTO `video_class` VALUES ('1', '第一节课', '一', '1', '1', '2018-02-23 22:19:04', '2018-02-23 23:19:11', '1', '2018-02-22 22:17:08', '2018-02-22 22:17:08');
INSERT INTO `video_class` VALUES ('2', '第二节课', '二', '2', '2', '2018-02-23 22:19:04', '2018-02-23 23:19:11', '1', '2018-02-22 22:18:58', '2018-02-22 22:18:58');

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
