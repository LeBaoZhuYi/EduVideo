/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : edu_video

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-02-26 00:23:41
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
INSERT INTO `student` VALUES ('1', '2', '1', '201292368', 'im leBao', '1', '2018-01-18 17:14:21', '2018-02-22 22:44:47', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `student` VALUES ('2', '3', '1', '201292368', 'im leBao', '1', '2018-01-18 17:16:40', '2018-02-22 22:44:48', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `student` VALUES ('3', '4', '2', '201292368', 'lebao', '1', '2018-01-18 17:45:39', '2018-02-22 22:44:50', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `student` VALUES ('4', '6', '1', '4', '3', '1', '2018-02-25 15:21:51', '2018-02-25 15:22:05', '0', '', '', '', '5', '', '', '', '', '', null);
INSERT INTO `student` VALUES ('5', '1', '1', '4', '3', '1', '2018-02-25 15:23:21', '2018-02-25 15:23:21', '1', '', '', '', '5', '', '', '', '', '', null);
INSERT INTO `student` VALUES ('6', '8', '2', '123', '123', '1', '2018-02-25 15:27:16', '2018-02-25 15:27:16', '0', '', '', '', '123', '', '', '', '', '', null);
INSERT INTO `student` VALUES ('7', '9', '2', '45', '3', '1', '2018-02-25 15:35:48', '2018-02-25 15:35:48', '0', '', '', '', '5', '', '', '', '', '', null);
INSERT INTO `student` VALUES ('9', '11', '1', 's', 'd是的法定', '3', '2018-02-25 15:36:22', '2018-02-25 21:19:08', '0', '奥术大师', '阿萨德安盛', '', 's', '', '', '', '', '', null);

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of student_group
-- ----------------------------
INSERT INTO `student_group` VALUES ('1', '1', '2018-02-22 22:19:46', '2018-02-22 23:26:20', '分组一', '12312312312');
INSERT INTO `student_group` VALUES ('2', '1', '2018-02-22 22:19:52', '2018-02-22 23:26:21', '分组二', '3432423');
INSERT INTO `student_group` VALUES ('3', '1', '2018-02-25 15:43:25', '2018-02-25 22:09:54', '分组三', null);
INSERT INTO `student_group` VALUES ('4', '1', '2018-02-25 15:44:00', '2018-02-25 22:09:59', '分组四', null);
INSERT INTO `student_group` VALUES ('5', '1', '2018-02-25 15:44:02', '2018-02-25 15:44:02', '123', null);
INSERT INTO `student_group` VALUES ('6', '1', '2018-02-25 15:44:15', '2018-02-25 15:44:15', '123', null);
INSERT INTO `student_group` VALUES ('7', '3', '2018-02-25 15:45:43', '2018-02-25 21:57:39', '123', null);

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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', '2', null, '1', '1', '2017-12-27 15:27:25', '2017-12-27 15:27:25');
INSERT INTO `user` VALUES ('2', '2', '2', null, '3', '0', '2017-12-27 17:24:30', '2018-02-22 22:13:27');
INSERT INTO `user` VALUES ('3', '3', '2', null, '3', '0', '2017-12-27 18:23:30', '2018-02-22 22:13:29');
INSERT INTO `user` VALUES ('4', 'test', 'e10adc3949ba59abbe56e057f20f883e', null, '3', '0', '2018-01-18 11:00:33', '2018-02-22 22:13:32');
INSERT INTO `user` VALUES ('6', '1', '665f644e43731ff9db3d341da5c827e1', null, '3', '1', '2018-02-25 15:21:36', '2018-02-25 15:21:36');
INSERT INTO `user` VALUES ('8', 'gg', '202cb962ac59075b964b07152d234b70', null, '3', '1', '2018-02-25 15:27:16', '2018-02-25 15:27:16');
INSERT INTO `user` VALUES ('9', '1', 'c81e728d9d4c2f636f067f89cc14862c', null, '3', '1', '2018-02-25 15:35:48', '2018-02-25 15:35:48');
INSERT INTO `user` VALUES ('10', 'a', '03c7c0ace395d80182db07ae2c30f034', null, '3', '1', '2018-02-25 15:36:20', '2018-02-25 15:36:20');
INSERT INTO `user` VALUES ('11', 'a', '0305d718926ac8776a442023509c21ce', null, '3', '1', '2018-02-25 15:36:22', '2018-02-25 15:36:22');
INSERT INTO `user` VALUES ('12', 'a', '8d936fca1e4d7669450328c715b67afc', null, '3', '1', '2018-02-25 15:36:24', '2018-02-25 15:36:24');

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video` VALUES ('1', '123', '视频一', '测试', '2', '0', '2018-02-22 22:15:21', '2018-02-25 23:25:57');
INSERT INTO `video` VALUES ('3', '123', '视频三', '测试134', '3', '0', '2018-02-22 22:15:35', '2018-02-25 23:01:43');
INSERT INTO `video` VALUES ('4', '7447398154842963750', '啊', '123', '2', '0', '2018-02-25 18:22:51', '2018-02-25 23:01:45');

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of video_class
-- ----------------------------
INSERT INTO `video_class` VALUES ('1', '第一节课', '一', '1', '1', '2018-02-23 22:19:04', '2018-02-23 23:19:11', '1', '2018-02-22 22:17:08', '2018-02-22 22:17:08');
INSERT INTO `video_class` VALUES ('2', '第二节课', '二', '2', '2', '2018-02-23 22:19:04', '2018-02-23 23:19:11', '1', '2018-02-22 22:18:58', '2018-02-22 22:18:58');
INSERT INTO `video_class` VALUES ('3', '12', '123', '1', '4', null, null, '3', '2018-02-25 15:57:35', '2018-02-25 15:57:35');
INSERT INTO `video_class` VALUES ('4', '1', '1231', '3', '1', '2018-02-25 16:51:51', '2018-02-25 16:51:50', '1', '2018-02-25 16:05:12', '2018-02-25 16:05:12');
INSERT INTO `video_class` VALUES ('5', '32切完', '请问', '1', '3', '2018-03-02 16:51:35', '2018-02-21 16:51:38', '1', '2018-02-25 16:51:50', '2018-02-25 16:51:50');

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
