/*
 Navicat Premium Data Transfer

 Source Server         : 10.2.9.151
 Source Server Type    : MySQL
 Source Server Version : 50647
 Source Host           : 10.2.9.151:3306
 Source Schema         : yol_product_center

 Target Server Type    : MySQL
 Target Server Version : 50647
 File Encoding         : 65001

 Date: 14/05/2020 14:07:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for blc_mq_message
-- ----------------------------
DROP TABLE IF EXISTS `blc_mq_message`;
CREATE TABLE `blc_mq_message`  (
  `ID` bigint(20) NOT NULL,
  `MQ_MESSAGE` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `MQ_EXCHANGE_NAME` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `MQ_QUEUE_NAME` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `MQ_SEND_COUNT` int(20) NULL DEFAULT NULL,
  `MQ_SEND_STATUS` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `MQ_NEXT_RETRY` datetime(0) NULL DEFAULT NULL,
  `DATE_CREATED` datetime(0) NULL DEFAULT NULL,
  `DATE_UPDATED` datetime(0) NULL DEFAULT NULL,
  `ROUTING_KEY` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
