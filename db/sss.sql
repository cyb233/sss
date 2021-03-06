/*
 Navicat Premium Data Transfer

 Source Server         : sss
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : 119.23.173.153:3306
 Source Schema         : shop

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 30/01/2022 13:32:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for d_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `d_dictionary`;
CREATE TABLE `d_dictionary`  (
                                 `id` int(0) NOT NULL AUTO_INCREMENT,
                                 `typeCode` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
                                 `typeName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
                                 `valueId` int(0) NOT NULL,
                                 `valueName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
                                 `del` int(0) NULL DEFAULT 0,
                                 PRIMARY KEY (`id`) USING BTREE,
                                 UNIQUE INDEX `typeCode`(`typeCode`, `valueId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log`  (
                        `id` int(0) NOT NULL AUTO_INCREMENT,
                        `userid` int(0) NOT NULL,
                        `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                        `operation` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                        `time` int(0) NULL DEFAULT NULL,
                        `method` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                        `params` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                        `ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                        `createtime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
                        PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for s_affiche
-- ----------------------------
DROP TABLE IF EXISTS `s_affiche`;
CREATE TABLE `s_affiche`  (
                              `id` int(0) NOT NULL AUTO_INCREMENT,
                              `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
                              `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                              `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                              `publisher` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                              `pulishTime` datetime(0) NULL DEFAULT NULL,
                              `startTime` datetime(0) NULL DEFAULT NULL,
                              `endTime` datetime(0) NULL DEFAULT NULL,
                              `del` int(0) NULL DEFAULT 0,
                              PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for s_authority
-- ----------------------------
DROP TABLE IF EXISTS `s_authority`;
CREATE TABLE `s_authority`  (
                                `id` int(0) NOT NULL AUTO_INCREMENT,
                                `roleId` int(0) NOT NULL COMMENT '??????Id',
                                `functionId` int(0) NOT NULL COMMENT '??????Id',
                                `userTypeId` int(0) NULL DEFAULT NULL COMMENT '??????Id',
                                `createTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
                                `createdBy` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '??????s_user?????????loginCode',
                                `del` int(0) NULL DEFAULT 0,
                                PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for s_function
-- ----------------------------
DROP TABLE IF EXISTS `s_function`;
CREATE TABLE `s_function`  (
                               `id` int(0) NOT NULL AUTO_INCREMENT,
                               `functionCode` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '????????????',
                               `functionName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '????????????',
                               `funcUrl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '??????URl',
                               `parentId` int(0) NULL DEFAULT NULL COMMENT '???????????????Id',
                               `createTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '????????????',
                               `del` int(0) NULL DEFAULT 0,
                               PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for s_goods
-- ----------------------------
DROP TABLE IF EXISTS `s_goods`;
CREATE TABLE `s_goods`  (
                            `id` int(0) NOT NULL AUTO_INCREMENT,
                            `goodsSN` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '??????Id',
                            `goodsName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '????????????',
                            `goodsFormat` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '????????????',
                            `marketPrice` double NOT NULL COMMENT '??????',
                            `state` int(0) NOT NULL COMMENT '0 ?????? 1 ??????',
                            `note` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '????????????',
                            `num` int(0) NULL DEFAULT NULL COMMENT '????????????',
                            `unit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '??????',
                            `createTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '????????????',
                            `lastUpateTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '??????????????????',
                            `reatedBy` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '?????????s_user?????????loginCode',
                            `del` int(0) NULL DEFAULT 0,
                            PRIMARY KEY (`id`) USING BTREE,
                            UNIQUE INDEX `goodsSN`(`goodsSN`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for s_information
-- ----------------------------
DROP TABLE IF EXISTS `s_information`;
CREATE TABLE `s_information`  (
                                  `id` int(0) NOT NULL AUTO_INCREMENT,
                                  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
                                  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                                  `state` int(0) NOT NULL DEFAULT 0,
                                  `publisher` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
                                  `publishTime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
                                  `typeId` int(0) NOT NULL,
                                  `typeName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
                                  `filePath` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
                                  `fileSize` double NOT NULL,
                                  `updateTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
                                  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for s_inventory
-- ----------------------------
DROP TABLE IF EXISTS `s_inventory`;
CREATE TABLE `s_inventory`  (
                                `id` int(0) NOT NULL AUTO_INCREMENT,
                                `goodsID` int(0) NOT NULL,
                                `num` int(0) NOT NULL,
                                `state` int(0) NOT NULL DEFAULT 0 COMMENT '?????????0 ?????????1 ??????????????? NUM ???\r\n????????????????????? NUM ????????? 0 ?????????',
                                `createTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
                                `del` int(0) NOT NULL DEFAULT 0,
                                PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for s_leaveMessage
-- ----------------------------
DROP TABLE IF EXISTS `s_leaveMessage`;
CREATE TABLE `s_leaveMessage`  (
                                   `id` int(0) NOT NULL AUTO_INCREMENT,
                                   `userId` int(0) NOT NULL,
                                   `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                                   `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                                   `state` int(0) NULL DEFAULT 0,
                                   `del` int(0) NULL DEFAULT 0,
                                   PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for s_order
-- ----------------------------
DROP TABLE IF EXISTS `s_order`;
CREATE TABLE `s_order`  (
                            `id` int(0) NOT NULL AUTO_INCREMENT,
                            `orderTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
                            `orderSN` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
                            `pickUserId` int(0) NOT NULL COMMENT '???????????? ID????????? ?????? AU_USER ???????????????',
                            `buyUserId` int(0) NOT NULL COMMENT '???????????? ID????????? ?????? AU_USER ???????????????',
                            `repeatPv` double NOT NULL COMMENT '?????? PV?????????  ???????????????????????????????????????????????? PV ??????\r\n????????????',
                            `basePv` double NOT NULL COMMENT '?????? PV?????????  ???????????????????????????????????????????????? PV ??????\r\n????????????',
                            `serviceFee` double NOT NULL COMMENT ' ?????????????????? ???????????????????????????????????????',
                            `shipFre` double NOT NULL COMMENT '??????????????????  ????????????????????????',
                            `tax` double NOT NULL COMMENT '???????????????  ???????????????????????????????????????',
                            `country` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '????????????????????? ?????? AU_USER ?????????????????????',
                            `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                            `userAddress` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
                            `postcode` int(0) NOT NULL,
                            `stat` int(0) NOT NULL DEFAULT 0 COMMENT '?????????????????????????????????????????????????????????\r\n????????????????????????????????????????????????????????????\r\n?????????????????????????????????????????????\r\n?????????????????????????????????????????????????????????\r\n???',
                            `shipType` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '?????????????????????????????????????????????EMS??????\r\n??????????????????????????????????????????',
                            `shipTime` datetime(0) NOT NULL,
                            `receiveTime` datetime(0) NOT NULL,
                            `shipNote` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                            `del` int(0) NULL DEFAULT 0,
                            PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for s_orderList
-- ----------------------------
DROP TABLE IF EXISTS `s_orderList`;
CREATE TABLE `s_orderList`  (
                                `id` int(0) NOT NULL AUTO_INCREMENT,
                                `orderId` int(0) NOT NULL,
                                `goodsId` int(0) NOT NULL,
                                `goodsSN` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
                                `goodsName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
                                `goodsFormat` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
                                `goodsNum` int(0) NOT NULL,
                                `eachPrice` double NOT NULL COMMENT '???????????????',
                                `sumPrice` double NOT NULL COMMENT '???????????????',
                                `discount` double NULL DEFAULT NULL COMMENT '???????????????',
                                `currency` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '?????????????????????',
                                `realPv` double NOT NULL,
                                `pvRate` double NOT NULL,
                                `createTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
                                `del` int(0) NULL DEFAULT 0,
                                PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for s_role
-- ----------------------------
DROP TABLE IF EXISTS `s_role`;
CREATE TABLE `s_role`  (
                           `id` int(0) NOT NULL AUTO_INCREMENT,
                           `roleCode` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
                           `roleName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
                           `isStart` int(0) NOT NULL DEFAULT 0,
                           `createDate` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
                           `createBy` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '?????? s_user ?????????loginCode',
                           `del` int(0) NULL DEFAULT 0,
                           PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for s_user
-- ----------------------------
DROP TABLE IF EXISTS `s_user`;
CREATE TABLE `s_user`  (
                           `id` int(0) NOT NULL AUTO_INCREMENT,
                           `loginCode` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
                           `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '?????????????????????????????????????????????',
                           `password2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '?????????????????????????????????????????????',
                           `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
                           `sex` int(0) NULL DEFAULT NULL,
                           `birthday` date NULL DEFAULT NULL,
                           `cardType` int(0) NOT NULL COMMENT '????????????????????????data_dictionary???tupeCode=\'CARD_TYPE\'???valueId',
                           `cardTypeName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '????????????????????????data_dictionary???tupeCode=\'CARD_TYPE\'???valueName',
                           `idCard` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
                           `country` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '????????????',
                           `mobile` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '??????',
                           `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                           `userAddress` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                           `postCode` int(0) NULL DEFAULT NULL,
                           `createTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
                           `referId` int(0) NOT NULL COMMENT '?????????Id',
                           `referCode` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '???????????????  ??????????????????loginCode',
                           `roleId` int(0) NOT NULL COMMENT '??????Id',
                           `roleName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '????????????',
                           `userType` int(0) NOT NULL COMMENT '????????????Id    ????????????????????????data_dictionary???typeCode=\'USER_TYPE\'???valueId',
                           `userTYpeName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '????????????name    ????????????????????????data_dictionary???typeCode=\'USER_TYPE\'???valueName',
                           `isStart` int(0) NOT NULL DEFAULT 0 COMMENT '0 ?????? 1 ?????????',
                           `del` int(0) NOT NULL DEFAULT 0 COMMENT '0 ?????? 1 ??????',
                           PRIMARY KEY (`id`) USING BTREE,
                           UNIQUE INDEX `loginCode`(`loginCode`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for s_userAccount
-- ----------------------------
DROP TABLE IF EXISTS `s_userAccount`;
CREATE TABLE `s_userAccount`  (
                                  `id` int(0) NOT NULL AUTO_INCREMENT,
                                  `userId` int(0) NOT NULL,
                                  `accountDate` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
                                  `stat` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                                  `baseIn` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                                  `baseOut` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                                  `baseBalance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                                  `repeatIn` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                                  `repeatOut` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                                  `repeatBalance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                                  `freePv` double NULL DEFAULT NULL,
                                  `alreadyPv` double NULL DEFAULT NULL,
                                  `buyPv` double NULL DEFAULT NULL,
                                  `del` int(0) NULL DEFAULT 0,
                                  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for s_userAccountLog
-- ----------------------------
DROP TABLE IF EXISTS `s_userAccountLog`;
CREATE TABLE `s_userAccountLog`  (
                                     `id` int(0) NOT NULL AUTO_INCREMENT,
                                     `userId` int(0) NOT NULL,
                                     `actionTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
                                     `actionDesc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
                                     `actionType` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '??????????????????????????????',
                                     `baseIn` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                                     `baseOut` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                                     `baseBalance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                                     `repratIn` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                                     `repeatOut` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                                     `repeatBalance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                                     `del` int(0) NULL DEFAULT 0,
                                     PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for s_userCash
-- ----------------------------
DROP TABLE IF EXISTS `s_userCash`;
CREATE TABLE `s_userCash`  (
                               `id` int(0) NOT NULL AUTO_INCREMENT,
                               `cashTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
                               `cashNum` int(0) NOT NULL,
                               `userId` int(0) NOT NULL,
                               `cashPv` double NOT NULL,
                               `currency` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '??????????????????',
                               `cashMoney` double NOT NULL,
                               `note` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
                               `fee` double NULL DEFAULT NULL,
                               `tax` double NULL DEFAULT NULL,
                               `otherFee` double NULL DEFAULT NULL,
                               `bankName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
                               `bankBrance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
                               `bankAccount` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                               `accountName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                               `stat` int(0) NOT NULL COMMENT '???0 ????????????1 ????????????2 ???\r\n?????????3 ????????????4 ????????????',
                               `creditedMoney` double NULL DEFAULT NULL COMMENT '???????????????????????????',
                               `creditedTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '???????????????????????????',
                               `operator` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '????????????????????????',
                               `del` int(0) NULL DEFAULT 0,
                               PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for s_userRecharge
-- ----------------------------
DROP TABLE IF EXISTS `s_userRecharge`;
CREATE TABLE `s_userRecharge`  (
                                   `id` int(0) NOT NULL AUTO_INCREMENT,
                                   `rechargeTime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
                                   `rechargeNum` int(0) NULL DEFAULT NULL,
                                   `userId` int(0) NULL DEFAULT NULL,
                                   `cirrency` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                                   `rechargeMoney` double NULL DEFAULT NULL,
                                   `note` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                                   `creditedMoney` double NULL DEFAULT NULL,
                                   `creditedTime` datetime(0) NULL DEFAULT NULL,
                                   `auditUser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                                   `pvRete` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT 'PV ??????',
                                   `pv` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '?????????PV ???',
                                   `bankName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '?????????',
                                   `bankAccount` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '????????????',
                                   `platform` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '????????????',
                                   `param` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '??????????????????',
                                   `del` int(0) NULL DEFAULT 0,
                                   PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for s_userRefer
-- ----------------------------
DROP TABLE IF EXISTS `s_userRefer`;
CREATE TABLE `s_userRefer`  (
                                `id` int(0) NOT NULL AUTO_INCREMENT,
                                `referTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
                                `referId` int(0) NOT NULL,
                                `buyPv` double NOT NULL,
                                `bonusRate` double NOT NULL COMMENT '?????????????????????????????????',
                                `bonusPv` double NOT NULL COMMENT '?????????????????????????????????',
                                `del` int(0) NULL DEFAULT 0,
                                PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
