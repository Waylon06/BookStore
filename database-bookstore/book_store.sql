/*
 Navicat Premium Data Transfer

 Source Server         : Waylon
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : book_store

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 28/03/2023 11:50:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `book_id` int(0) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `details` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `old_price` decimal(10, 2) NULL DEFAULT NULL,
  `cover` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `type_id` int(0) NULL DEFAULT NULL,
  `new_price` decimal(10, 2) NULL DEFAULT NULL,
  `num` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`book_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, '鲁滨孙漂流记', '勇敢挑战大自然，充满拼搏的孤岛求生记', 123.00, 'http://47.120.8.6/books/book_1.jpg', '勇敢挑战大自然，充满拼搏的孤岛求生记', 1, 100.00, NULL);
INSERT INTO `book` VALUES (2, '李自成', '明末李自成领导的农民起义军由渺小变得强大', 200.00, 'http://47.120.8.6/books/book_2.jpg', '明末李自成领导的农民起义军由渺小变得强大', 2, 99.00, NULL);
INSERT INTO `book` VALUES (3, '老人与海', '老人与海', 125.00, 'http://47.120.8.6/books/book_3.jpg', '老人与海', 1, 80.00, NULL);
INSERT INTO `book` VALUES (4, '太阳照在桑干河上', '太阳照在桑干河上', 99.00, 'http://47.120.8.6/books/book_4.jpg', '太阳照在桑干河上', 1, 80.00, NULL);
INSERT INTO `book` VALUES (5, '天上的市街', '天上的市街', 150.00, 'http://47.120.8.6/books/book_5.jpg', '天上的市街', 2, 99.00, NULL);

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`  (
  `uid` int(0) NOT NULL COMMENT '用户id',
  `oid` int(0) NOT NULL AUTO_INCREMENT COMMENT '订单号',
  `bid` int(0) NULL DEFAULT NULL COMMENT '书籍id',
  `num` int(0) NULL DEFAULT 1 COMMENT '数量',
  `o_status` int(0) NOT NULL DEFAULT 0,
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES (2, 6, 3, 1, 0);
INSERT INTO `cart` VALUES (1, 8, 4, 1, 0);

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `notice_id` int(0) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`notice_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('3月23日-30日停止服务通告', 1, '因程序升级进行系统维护，我们将于2023年3月23日-30日暂停服务，请谅解', '2023-03-24 00:00:00');
INSERT INTO `notice` VALUES ('本项目所有权', 2, '项目所有权归编写者所有', '2023-03-25 00:00:00');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `user_id` int(0) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('waylon', '123456', 'waylon06@qq.com', 1);
INSERT INTO `user` VALUES ('lorrine', '123456', '1244', 2);
INSERT INTO `user` VALUES ('lorraine', '123456', '123', 3);
INSERT INTO `user` VALUES ('yan', '123', '123', 5);

SET FOREIGN_KEY_CHECKS = 1;
