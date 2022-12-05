/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : localhost:3306
 Source Schema         : ds_ma

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 05/12/2022 20:34:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for indentity
-- ----------------------------
DROP TABLE IF EXISTS `indentity`;
CREATE TABLE `indentity`  (
  `indentity_id` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '唯一id',
  `user_id` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户id',
  `indentity_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '身份证姓名',
  `indentity_status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '身份证状态：0未认证，1待认证，2已认证，3认证未通过',
  `indentity_code` char(18) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '身份证号',
  `indentity_front` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '身份证正面',
  `indentity_verso` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '身份证反面',
  `indentity_explain` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '认证失败说明',
  `create_time` char(13) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建时间',
  `update_time` char(13) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`indentity_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of indentity
-- ----------------------------
INSERT INTO `indentity` VALUES ('6', '160583719445', '盖聂', '2', '362524198912051213', '/imgs/2021-01-29/04edc76c-6000-479c-88d0-fa2f6a3b62d2.jpg', '/imgs/2021-01-29/2524af20-abdd-49f1-97a1-bd88b4bc3143.jpg', NULL, NULL, NULL);
INSERT INTO `indentity` VALUES ('7', '160583811958', '铠', '1', '362421199007028030', '/imgs/2021-07-02/c83f37fd-326c-4571-9d54-718a7475bd59.jpg', '/imgs/2021-07-02/14a92e80-79ec-4e9e-bc95-fbd6995d64c9.jpg', NULL, NULL, NULL);
INSERT INTO `indentity` VALUES ('ind1669277357939qark', 'use16481231302651117', '111', '1', '222', '2022-11-24/ac48a0ae-cdb6-4fe3-be24-b9485f875236.png', '2022-11-24/6a5ccc47-e2b1-4588-a88a-dcd82472b382.png', NULL, '1669277357939', '1669277357939');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '唯一ID',
  `user_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '名称',
  `user_portrait` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '头像',
  `user_rank` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '权限',
  `user_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '手机',
  `user_account` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '账户',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `create_time` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '王世铠', '2022-10-14/101a3b48-8f6c-4481-bf6d-5df2c9116d7d.png', '超级管理员', '18218548496', 'root', '185a29046de1f3bd83759bf7fc72fe44', '0');
INSERT INTO `user` VALUES ('use1665492285823qDDe', '铠', NULL, '超级管理员', '18215474444', 'kai', '185a29046de1f3bd83759bf7fc72fe44', '1665493099016');
INSERT INTO `user` VALUES ('use1665493099016xDJk', 'df ', NULL, '超级管理员', 'dfg ', 'fd ', 'e7b3e907df88943aff31c0007feecdb6', '1665493099016');

SET FOREIGN_KEY_CHECKS = 1;
