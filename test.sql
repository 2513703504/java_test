/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 22/06/2022 10:20:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `credit` float NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, '数据结构', 4);
INSERT INTO `course` VALUES (2, '计算机网络', 3);
INSERT INTO `course` VALUES (3, '计算机网络', 2);
INSERT INTO `course` VALUES (4, 'c语言程序设计', 3);
INSERT INTO `course` VALUES (5, 'Java程序设计', 4);

-- ----------------------------
-- Table structure for sex
-- ----------------------------
DROP TABLE IF EXISTS `sex`;
CREATE TABLE `sex`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gender` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sex
-- ----------------------------
INSERT INTO `sex` VALUES (1, '男');
INSERT INTO `sex` VALUES (2, '女');

-- ----------------------------
-- Table structure for stu_course
-- ----------------------------
DROP TABLE IF EXISTS `stu_course`;
CREATE TABLE `stu_course`  (
  `stu_id` bigint(20) NOT NULL,
  `course_id` bigint(20) NOT NULL,
  INDEX `stu_id`(`stu_id`) USING BTREE,
  INDEX `course_id`(`course_id`) USING BTREE,
  CONSTRAINT `stu_course_ibfk_1` FOREIGN KEY (`stu_id`) REFERENCES `student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `stu_course_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stu_course
-- ----------------------------
INSERT INTO `stu_course` VALUES (1, 2);
INSERT INTO `stu_course` VALUES (1, 1);
INSERT INTO `stu_course` VALUES (1, 3);
INSERT INTO `stu_course` VALUES (1, 4);
INSERT INTO `stu_course` VALUES (1, 5);
INSERT INTO `stu_course` VALUES (2, 1);
INSERT INTO `stu_course` VALUES (2, 2);
INSERT INTO `stu_course` VALUES (2, 3);
INSERT INTO `stu_course` VALUES (2, 4);
INSERT INTO `stu_course` VALUES (2, 5);
INSERT INTO `stu_course` VALUES (5, 1);
INSERT INTO `stu_course` VALUES (5, 2);
INSERT INTO `stu_course` VALUES (5, 3);
INSERT INTO `stu_course` VALUES (5, 4);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `stud_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sex` tinyint(4) NULL DEFAULT NULL,
  `grade` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, 'zhangsan', 1, 1);
INSERT INTO `student` VALUES (2, 'lisi', 1, 3);
INSERT INTO `student` VALUES (4, 'wangwu', 1, 2);
INSERT INTO `student` VALUES (5, 'hanmeimei', 2, 3);

SET FOREIGN_KEY_CHECKS = 1;
