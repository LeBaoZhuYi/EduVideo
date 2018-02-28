/*
 Navicat MySQL Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : edu_video

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 29/01/2018 15:33:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for video_class
-- ----------------------------
DROP TABLE IF EXISTS `video_class`;
CREATE TABLE `video_class`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `video_id` int(11) NULL DEFAULT NULL COMMENT '视频id',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '开放开始时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '开放结束时间',
  `ctime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `utime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
