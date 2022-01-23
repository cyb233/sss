/*
 Navicat Premium Data Transfer

 Source Server         : tent
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : 119.23.173.153:3306
 Source Schema         : shop

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 23/01/2022 16:16:07
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
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for s_authority
-- ----------------------------
DROP TABLE IF EXISTS `s_authority`;
CREATE TABLE `s_authority`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `roleId` int(0) NOT NULL COMMENT '角色Id',
  `functionId` int(0) NOT NULL COMMENT '功能Id',
  `userTypeId` int(0) NULL DEFAULT NULL COMMENT '用户Id',
  `createTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `createdBy` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '取自s_user表中的loginCode',
  `del` int(0) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for s_function
-- ----------------------------
DROP TABLE IF EXISTS `s_function`;
CREATE TABLE `s_function`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `functionCode` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '功能编码',
  `functionName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '功能名称',
  `funcUrl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '功能URl',
  `parentId` int(0) NULL DEFAULT NULL COMMENT '父节点功能Id',
  `createTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `del` int(0) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for s_goods
-- ----------------------------
DROP TABLE IF EXISTS `s_goods`;
CREATE TABLE `s_goods`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `goodsSN` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '商品Id',
  `goodsName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '商品名称',
  `goodsFormat` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '商品规格',
  `marketPrice` double(10, 2) NOT NULL COMMENT '价格',
  `state` int(0) NOT NULL COMMENT '0 上架 1 下架',
  `note` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '商品说明',
  `num` int(0) NULL DEFAULT NULL COMMENT '库存数量',
  `unit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '单位',
  `createTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `lastUpateTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后创建时间',
  `reatedBy` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '取自是s_user表中的loginCode',
  `del` int(0) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `goodsSN`(`goodsSN`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

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
  `fileSize` double(10, 0) NOT NULL,
  `updateTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for s_inventory
-- ----------------------------
DROP TABLE IF EXISTS `s_inventory`;
CREATE TABLE `s_inventory`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `goodsID` int(0) NOT NULL,
  `num` int(0) NOT NULL,
  `state` int(0) NOT NULL DEFAULT 0 COMMENT '值为：0 有货、1 无货。根据 NUM 字\r\n段值判断，如果 NUM 值大于 0 则取值',
  `createTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `del` int(0) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for s_leaveMassage
-- ----------------------------
DROP TABLE IF EXISTS `s_leaveMassage`;
CREATE TABLE `s_leaveMassage`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `userId` int(0) NOT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `state` int(0) NULL DEFAULT 0,
  `del` int(0) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for s_order
-- ----------------------------
DROP TABLE IF EXISTS `s_order`;
CREATE TABLE `s_order`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `orderTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `orderSN` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `pickUserId` int(0) NOT NULL COMMENT '收货用户 ID。必填 取自 AU_USER 表中的主键',
  `buyUserId` int(0) NOT NULL COMMENT '买单用户 ID。必填 取自 AU_USER 表中的主键',
  `repeatPv` double(10, 0) NOT NULL COMMENT '重消 PV。必填  根据消费类型，取基础信息表中相应 PV 换算\r\n公式得出',
  `basePv` double(10, 0) NOT NULL COMMENT '基本 PV。必填  根据消费类型，取基础信息表中相应 PV 换算\r\n公式得出',
  `serviceFee` double(10, 0) NOT NULL COMMENT ' 服务费。必填 根据消费类型、消费金额得出',
  `shipFre` double(10, 0) NOT NULL COMMENT '快递费。必填  根据收获地址得出',
  `tax` double(10, 0) NOT NULL COMMENT '税费。必填  根据消费类型、消费金额得出',
  `country` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '收货国家。必填 取自 AU_USER 表中的相应字段',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `userAddress` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `postcode` int(0) NOT NULL,
  `stat` int(0) NOT NULL DEFAULT 0 COMMENT '取自数据字典表订单状态相关值（已下单、\r\n已取消、已付款、已配货、已发货、已送达、\r\n已收货、交易成功、交易未成功）\r\n系统默认已下单，根据实际交易情况修改状\r\n态',
  `shipType` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '取自数据字典表快递类型相关值（EMS、顺\r\n风快递、圆通快递、申通快递）',
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
  `eachPrice` double(10, 0) NOT NULL COMMENT '单价。必填',
  `sumPrice` double(10, 0) NOT NULL COMMENT '总价。必填',
  `discount` double(10, 0) NULL DEFAULT NULL COMMENT '折扣。可选',
  `currency` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '货币种类。可选',
  `realPv` double(10, 0) NOT NULL,
  `pvRate` double(10, 0) NOT NULL,
  `createTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `del` int(0) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

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
  `createBy` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '取自 s_user 表中的loginCode',
  `del` int(0) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for s_user
-- ----------------------------
DROP TABLE IF EXISTS `s_user`;
CREATE TABLE `s_user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `loginCode` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '系统生成，默认取证件号码后六位',
  `password2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '系统生成，默认取证件号码后六位',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `sex` int(0) NULL DEFAULT NULL,
  `birthday` date NULL DEFAULT NULL,
  `cardType` int(0) NOT NULL COMMENT '来源于数据字典表data_dictionary中tupeCode=\'CARD_TYPE\'的valueId',
  `cardTypeName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '来源于数据字典表data_dictionary中tupeCode=\'CARD_TYPE\'的valueName',
  `idCard` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `country` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '收货国家',
  `mobile` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '手机',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `userAddress` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `postCode` int(0) NULL DEFAULT NULL,
  `createTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `referId` int(0) NOT NULL COMMENT '推荐人Id',
  `referCode` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '推荐人编码  默认当前用户loginCode',
  `roleId` int(0) NOT NULL COMMENT '角色Id',
  `roleName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '角色名字',
  `userType` int(0) NOT NULL COMMENT '用户类型Id    来源于数据字典表data_dictionary中typeCode=\'USER_TYPE\'的valueId',
  `userTYpeName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户类型name    来源于数据字典表data_dictionary中typeCode=\'USER_TYPE\'的valueName',
  `isStart` int(0) NOT NULL DEFAULT 0 COMMENT '0 启用 1 未启用',
  `del` int(0) NOT NULL DEFAULT 0 COMMENT '0 正常 1 删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `loginCode`(`loginCode`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

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
  `freePv` double(10, 0) NULL DEFAULT NULL,
  `alreadyPv` double(10, 0) NULL DEFAULT NULL,
  `buyPv` double(10, 0) NULL DEFAULT NULL,
  `del` int(0) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for s_userAccountLog
-- ----------------------------
DROP TABLE IF EXISTS `s_userAccountLog`;
CREATE TABLE `s_userAccountLog`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `userId` int(0) NOT NULL,
  `actionTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `actionDesc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `actionType` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '取自数据字典财务动作',
  `baseIn` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `baseOut` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `baseBalance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `repratIn` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `repeatOut` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `repeatBalance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `del` int(0) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for s_userCash
-- ----------------------------
DROP TABLE IF EXISTS `s_userCash`;
CREATE TABLE `s_userCash`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `cashTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `cashNum` int(0) NOT NULL,
  `userId` int(0) NOT NULL,
  `cashPv` double(10, 0) NOT NULL,
  `currency` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '默认为人民币',
  `cashMoney` double(10, 0) NOT NULL,
  `note` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `fee` double(10, 0) NULL DEFAULT NULL,
  `tax` double(10, 0) NULL DEFAULT NULL,
  `otherFee` double(10, 0) NULL DEFAULT NULL,
  `bankName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `bankBrance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `bankAccount` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `accountName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `stat` int(0) NOT NULL COMMENT '（0 已申请、1 已审核、2 未\r\n通过、3 等待中、4 已提现）',
  `creditedMoney` double(10, 0) NULL DEFAULT NULL COMMENT '到账金额。系统生成',
  `creditedTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '到账时间。系统生成',
  `operator` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '操作人。系统生成',
  `del` int(0) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

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
  `rechargeMoney` decimal(10, 0) NULL DEFAULT NULL,
  `note` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `creditedMoney` double(10, 0) NULL DEFAULT NULL,
  `creditedTime` datetime(0) NULL DEFAULT NULL,
  `auditUser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `pvRete` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT 'PV 比率',
  `pv` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '兑换后PV 值',
  `bankName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '银行名',
  `bankAccount` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '银行账号',
  `platform` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '充值平台',
  `param` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '充值接口参数',
  `del` int(0) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for s_userRefer
-- ----------------------------
DROP TABLE IF EXISTS `s_userRefer`;
CREATE TABLE `s_userRefer`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `referTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `referId` int(0) NOT NULL,
  `buyPv` double(10, 0) NOT NULL,
  `bonusRate` double(10, 0) NOT NULL COMMENT '取自基础数据表相应字段',
  `bonusPv` double(10, 0) NOT NULL COMMENT '取自基础数据表相应字段',
  `del` int(0) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
