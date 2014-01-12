/*
Navicat MySQL Data Transfer

Source Server         : mydb
Source Server Version : 50523
Source Host           : localhost:3306
Source Database       : tooqu

Target Server Type    : MYSQL
Target Server Version : 50523
File Encoding         : 65001

Date: 2013-07-22 19:52:50
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `accompany`
-- ----------------------------
DROP TABLE IF EXISTS `accompany`;
CREATE TABLE `accompany` (
  `aid` bigint(20) NOT NULL AUTO_INCREMENT,
  `accAge` varchar(255) DEFAULT NULL,
  `accCar` varchar(255) DEFAULT NULL,
  `accEducation` varchar(255) DEFAULT NULL,
  `accHeight` varchar(255) DEFAULT NULL,
  `accLanguage` varchar(255) DEFAULT NULL,
  `accLicense` varchar(255) DEFAULT NULL,
  `accPassport` varchar(255) DEFAULT NULL,
  `accPick` varchar(255) DEFAULT NULL,
  `accSex` int(11) NOT NULL,
  `accType` int(11) NOT NULL,
  `accWeight` varchar(255) DEFAULT NULL,
  `accountAmount` int(11) NOT NULL,
  `authority` int(11) NOT NULL,
  `businessRequirement` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `deadline` date DEFAULT NULL,
  `feeType` varchar(255) DEFAULT NULL,
  `isReview` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `travelTime` date DEFAULT NULL,
  `travelduration` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `ceator_user` bigint(20) DEFAULT NULL,
  `departure_place` bigint(20) DEFAULT NULL,
  `destination` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`aid`),
  KEY `FK92A9A61BD0F75065` (`ceator_user`),
  KEY `FK92A9A61B9ACC5A5B` (`departure_place`),
  KEY `FK92A9A61B3FBFE06D` (`destination`),
  CONSTRAINT `FK92A9A61B3FBFE06D` FOREIGN KEY (`destination`) REFERENCES `place` (`pid`),
  CONSTRAINT `FK92A9A61B9ACC5A5B` FOREIGN KEY (`departure_place`) REFERENCES `place` (`pid`),
  CONSTRAINT `FK92A9A61BD0F75065` FOREIGN KEY (`ceator_user`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of accompany
-- ----------------------------
INSERT INTO `accompany` VALUES ('1', '18-22岁', '是', '初中', '140-145cm', '英语6级', '有', '阿尔巴尼亚', '是', '0', '0', '40-45kg', '5', '1', '有', '2013-06-19 16:10:25', '2013-02-01', '网站担保', '\0', 'Test', 'test', '2013-05-01', '5', '0', '2', '4', '4');
INSERT INTO `accompany` VALUES ('2', '18-22岁', '是', '初中', '140-145cm', '英语6级', '有', '阿尔巴尼亚', '是', '0', '0', '40-45kg', '5', '1', '有', '2013-06-19 16:10:45', '2013-02-01', '网站担保', '\0', 'Test', 'test', '2013-05-01', '5', '0', '2', '4', '4');
INSERT INTO `accompany` VALUES ('3', '18-22岁', '是', '初中', '140-145cm', '英语6级', '有', '阿尔巴尼亚', '是', '0', '0', '40-45kg', '5', '1', '有', '2013-06-19 16:11:42', '2013-02-01', '网站担保', '\0', 'Test', 'test', '2013-05-01', '5', '0', '2', '4', '4');
INSERT INTO `accompany` VALUES ('4', '18-22岁', '是', '初中', '140-145cm', '英语6级', '有', '阿尔巴尼亚', '是', '0', '0', '40-45kg', '5', '1', '有', '2013-06-19 16:14:31', '2013-02-01', '网站担保', '\0', 'Test', 'test', '2013-05-01', '5', '0', '2', '4', '4');
INSERT INTO `accompany` VALUES ('24', '18-22岁', '是', '初中', '140-145cm', '英语6级', '有', '阿尔巴尼亚', '是', '0', '0', '40-45kg', '5', '1', '有', '2013-06-26 14:11:21', '2013-02-01', '网站担保', '\0', 'Test', 'test', '2013-05-01', '5', '0', '2', '4', '4');
INSERT INTO `accompany` VALUES ('25', '18-22岁', '是', '初中', '140-145cm', '英语6级', '有', '阿尔巴尼亚', '是', '0', '0', '40-45kg', '5', '1', '有', '2013-06-26 14:19:34', '2013-02-01', '网站担保', '\0', 'Test123', 'test', '2013-05-01', '5', '0', '2', '4', '4');
INSERT INTO `accompany` VALUES ('26', '18-22岁', '是', '初中', '140-145cm', '英语6级', '有', '阿尔巴尼亚', '是', '0', '0', '40-45kg', '5', '1', '有', '2013-07-06 11:00:04', '2013-02-01', '网站担保', '\0', 'Test', 'test', '2013-05-01', '5', '0', '9', '4', '4');
INSERT INTO `accompany` VALUES ('27', '18-22岁', '是', '初中', '140-145cm', '英语6级', '有', '阿尔巴尼亚', '是', '0', '0', '40-45kg', '5', '1', '有', '2013-07-08 11:18:15', '2013-02-01', '网站担保', '\0', 'Test132', 'test', '2013-05-01', '5', '0', '9', '4', '4');
INSERT INTO `accompany` VALUES ('28', '18-22岁', '是', '初中', '140-145cm', '英语6级', '有', '阿尔巴尼亚', '是', '0', '0', '40-45kg', '5', '1', '有', '2013-07-10 19:47:41', '2013-02-01', '网站担保', '\0', 'Test99', 'test999', '2013-05-01', '5', '0', '9', '4', '4');
INSERT INTO `accompany` VALUES ('29', '18-22岁', '是', '初中', '140-145cm', '英语6级', '有', '阿尔巴尼亚', '是', '0', '0', '40-45kg', '5', '1', '有', '2013-07-15 20:40:53', '2013-02-01', '网站担保', '\0', 'Test', 'test', '2013-05-01', '5', '0', '9', '4', '4');

-- ----------------------------
-- Table structure for `accompany_comment`
-- ----------------------------
DROP TABLE IF EXISTS `accompany_comment`;
CREATE TABLE `accompany_comment` (
  `ac_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `accomment` bigint(20) DEFAULT NULL,
  `from_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ac_id`),
  KEY `FKA210F03BE89824B3` (`from_user`),
  KEY `FKA210F03BC6AD5570` (`accomment`),
  CONSTRAINT `FKA210F03BC6AD5570` FOREIGN KEY (`accomment`) REFERENCES `accompany` (`aid`),
  CONSTRAINT `FKA210F03BE89824B3` FOREIGN KEY (`from_user`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of accompany_comment
-- ----------------------------
INSERT INTO `accompany_comment` VALUES ('1', '加油！', '2013-07-16 19:37:58', '1', '18');
INSERT INTO `accompany_comment` VALUES ('2', '加油！', '2013-07-16 19:37:58', '1', '18');
INSERT INTO `accompany_comment` VALUES ('3', '加油！', '2013-07-16 19:38:05', '1', '18');
INSERT INTO `accompany_comment` VALUES ('4', '加油！', '2013-07-16 19:38:09', '1', '18');

-- ----------------------------
-- Table structure for `accompany_user`
-- ----------------------------
DROP TABLE IF EXISTS `accompany_user`;
CREATE TABLE `accompany_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `number` int(11) NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `accompany` bigint(20) DEFAULT NULL,
  `participate_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK26F2976F1AAD4CFF` (`participate_user`),
  KEY `FK26F2976FC6AEA38E` (`accompany`),
  CONSTRAINT `FK26F2976F1AAD4CFF` FOREIGN KEY (`participate_user`) REFERENCES `user` (`userId`),
  CONSTRAINT `FK26F2976FC6AEA38E` FOREIGN KEY (`accompany`) REFERENCES `accompany` (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of accompany_user
-- ----------------------------
INSERT INTO `accompany_user` VALUES ('1', '3', '12312123131', '1', '9');
INSERT INTO `accompany_user` VALUES ('2', '3', 's ', '27', '9');
INSERT INTO `accompany_user` VALUES ('3', '3', '12312123131', '28', '9');

-- ----------------------------
-- Table structure for `album`
-- ----------------------------
DROP TABLE IF EXISTS `album`;
CREATE TABLE `album` (
  `aid` bigint(20) NOT NULL AUTO_INCREMENT,
  `authority` int(11) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `imgpath` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `albumowner` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`aid`),
  KEY `FK5897E6FB23B7F17` (`albumowner`),
  CONSTRAINT `FK5897E6FB23B7F17` FOREIGN KEY (`albumowner`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of album
-- ----------------------------

-- ----------------------------
-- Table structure for `article`
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `aid` bigint(20) NOT NULL AUTO_INCREMENT,
  `authority` int(11) NOT NULL,
  `content` text,
  `createtime` date DEFAULT NULL,
  `isRelease` bit(1) NOT NULL,
  `isReview` bit(1) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `article_destination` bigint(20) DEFAULT NULL,
  `article_ower` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`aid`),
  KEY `FKD458CCF6C61B4AA4` (`article_destination`),
  KEY `FKD458CCF6CC4633B1` (`article_ower`),
  CONSTRAINT `FKD458CCF6C61B4AA4` FOREIGN KEY (`article_destination`) REFERENCES `place` (`pid`),
  CONSTRAINT `FKD458CCF6CC4633B1` FOREIGN KEY (`article_ower`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=159 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('45', '1', '<h1 align=\"center\">\r\n	哈哈\r\n</h1>\r\n<p>\r\n	<br />\r\n</p>\r\n<p>\r\n	<img src=\"http://localhost:8080/tooqu/js/plugins/kindeditor/plugins/emoticons/images/13.gif\" alt=\"\" border=\"0\" />\r\n</p>', null, '\0', '\0', '刚刚个', null, '14');
INSERT INTO `article` VALUES ('137', '2', '嘻嘻<img src=\"/tooqu/register/uploaded/catch?imagePath=C:\\tmp/image/20130718/20130718154442_884.jpg\" alt=\"\" /><img src=\"/tooqu/register/uploaded/catch?imagePath=C:\\tmp/image/20130718/20130718154442_62.png\" alt=\"\" /><img src=\"/tooqu/register/uploaded/catch?imagePath=C:\\tmp/image/20130718/20130718154442_958.jpg\" alt=\"\" /><img src=\"/tooqu/register/uploaded/catch?imagePath=C:\\tmp/image/20130718/20130718154442_626.jpg\" alt=\"\" />', '2013-07-18', '\0', '\0', '淡定点', null, '10');
INSERT INTO `article` VALUES ('158', '1', '中国', '2013-07-19', '\0', '\0', '旅行游记1', null, '5');

-- ----------------------------
-- Table structure for `article_comment`
-- ----------------------------
DROP TABLE IF EXISTS `article_comment`;
CREATE TABLE `article_comment` (
  `article_comment_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `createTime` date DEFAULT NULL,
  `isread` bit(1) NOT NULL,
  `article` bigint(20) DEFAULT NULL,
  `comment_owner` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`article_comment_id`),
  KEY `FKC3C50C16A1A41E46` (`comment_owner`),
  KEY `FKC3C50C1632AE744` (`article`),
  CONSTRAINT `FKC3C50C1632AE744` FOREIGN KEY (`article`) REFERENCES `article` (`aid`),
  CONSTRAINT `FKC3C50C16A1A41E46` FOREIGN KEY (`comment_owner`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=295 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article_comment
-- ----------------------------
INSERT INTO `article_comment` VALUES ('281', '写的很好', '2013-07-19', '\0', '158', '5');
INSERT INTO `article_comment` VALUES ('284', '漂亮', '2013-07-19', '\0', '158', '5');
INSERT INTO `article_comment` VALUES ('286', '2', '2013-07-19', '\0', '158', '5');
INSERT INTO `article_comment` VALUES ('287', '3', '2013-07-19', '\0', '158', '5');
INSERT INTO `article_comment` VALUES ('288', '4', '2013-07-19', '\0', '158', '5');
INSERT INTO `article_comment` VALUES ('289', '5', '2013-07-19', '\0', '158', '5');
INSERT INTO `article_comment` VALUES ('290', '6', '2013-07-19', '\0', '158', '5');
INSERT INTO `article_comment` VALUES ('291', '7', '2013-07-19', '\0', '158', '5');
INSERT INTO `article_comment` VALUES ('292', '8', '2013-07-19', '\0', '158', '5');
INSERT INTO `article_comment` VALUES ('293', '9', '2013-07-19', '\0', '158', '5');
INSERT INTO `article_comment` VALUES ('294', '10', '2013-07-19', '\0', '158', '5');

-- ----------------------------
-- Table structure for `check_user`
-- ----------------------------
DROP TABLE IF EXISTS `check_user`;
CREATE TABLE `check_user` (
  `cid` bigint(20) NOT NULL AUTO_INCREMENT,
  `isread` bit(1) NOT NULL,
  `from_user` bigint(20) DEFAULT NULL,
  `to_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`cid`),
  KEY `FKE11BA4A29EF6C882` (`to_user`),
  KEY `FKE11BA4A2E89824B3` (`from_user`),
  CONSTRAINT `FKE11BA4A29EF6C882` FOREIGN KEY (`to_user`) REFERENCES `user` (`userId`),
  CONSTRAINT `FKE11BA4A2E89824B3` FOREIGN KEY (`from_user`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of check_user
-- ----------------------------

-- ----------------------------
-- Table structure for `follow`
-- ----------------------------
DROP TABLE IF EXISTS `follow`;
CREATE TABLE `follow` (
  `follow_uid` bigint(20) NOT NULL,
  `followed_id` bigint(20) NOT NULL,
  PRIMARY KEY (`follow_uid`,`followed_id`),
  KEY `FKB45D3BB1433FF51D` (`followed_id`),
  KEY `FKB45D3BB16AFB4C35` (`follow_uid`),
  CONSTRAINT `FKB45D3BB1433FF51D` FOREIGN KEY (`followed_id`) REFERENCES `user` (`userId`),
  CONSTRAINT `FKB45D3BB16AFB4C35` FOREIGN KEY (`follow_uid`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of follow
-- ----------------------------

-- ----------------------------
-- Table structure for `follow_accompany`
-- ----------------------------
DROP TABLE IF EXISTS `follow_accompany`;
CREATE TABLE `follow_accompany` (
  `ac_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  KEY `FK8559B30D398A57CB` (`ac_id`),
  KEY `FK8559B30DDB034B82` (`user_id`),
  CONSTRAINT `FK8559B30D398A57CB` FOREIGN KEY (`ac_id`) REFERENCES `accompany` (`aid`),
  CONSTRAINT `FK8559B30DDB034B82` FOREIGN KEY (`user_id`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of follow_accompany
-- ----------------------------
INSERT INTO `follow_accompany` VALUES ('27', '9');
INSERT INTO `follow_accompany` VALUES ('1', '9');
INSERT INTO `follow_accompany` VALUES ('1', '18');

-- ----------------------------
-- Table structure for `gift`
-- ----------------------------
DROP TABLE IF EXISTS `gift`;
CREATE TABLE `gift` (
  `gid` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `imgpath` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `pingming` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gift
-- ----------------------------

-- ----------------------------
-- Table structure for `local_travel`
-- ----------------------------
DROP TABLE IF EXISTS `local_travel`;
CREATE TABLE `local_travel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `arrangement` varchar(255) DEFAULT NULL,
  `bookrule` varchar(255) DEFAULT NULL,
  `feetype` int(11) NOT NULL,
  `maxpeople` int(11) NOT NULL,
  `money` double NOT NULL,
  `notice` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `vehicletype` int(11) NOT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `place` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKB5457E6E2116DD9F` (`creator`),
  KEY `FKB5457E6E9B567566` (`place`),
  CONSTRAINT `FKB5457E6E2116DD9F` FOREIGN KEY (`creator`) REFERENCES `user` (`userId`),
  CONSTRAINT `FKB5457E6E9B567566` FOREIGN KEY (`place`) REFERENCES `place` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of local_travel
-- ----------------------------

-- ----------------------------
-- Table structure for `local_travel_record`
-- ----------------------------
DROP TABLE IF EXISTS `local_travel_record`;
CREATE TABLE `local_travel_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createTime` datetime DEFAULT NULL,
  `endTime` datetime DEFAULT NULL,
  `feetype` int(11) NOT NULL,
  `isSuccess` bit(1) NOT NULL,
  `number` int(11) NOT NULL,
  `orderinfo` varchar(255) DEFAULT NULL,
  `startTime` datetime DEFAULT NULL,
  `localtravel` bigint(20) DEFAULT NULL,
  `participator` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKA3A873426DC86AFD` (`participator`),
  KEY `FKA3A873429A8F9202` (`localtravel`),
  CONSTRAINT `FKA3A873426DC86AFD` FOREIGN KEY (`participator`) REFERENCES `user` (`userId`),
  CONSTRAINT `FKA3A873429A8F9202` FOREIGN KEY (`localtravel`) REFERENCES `local_travel` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of local_travel_record
-- ----------------------------

-- ----------------------------
-- Table structure for `mailtemplate`
-- ----------------------------
DROP TABLE IF EXISTS `mailtemplate`;
CREATE TABLE `mailtemplate` (
  `mtid` bigint(20) NOT NULL AUTO_INCREMENT,
  `createTime` date DEFAULT NULL,
  `creator` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `requiredFields` varchar(255) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `template` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`mtid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mailtemplate
-- ----------------------------

-- ----------------------------
-- Table structure for `message`
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `mid` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `isread` bit(1) NOT NULL,
  `sendtime` date DEFAULT NULL,
  `from_user` bigint(20) DEFAULT NULL,
  `to_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`mid`),
  KEY `FK38EB00079EF6C882` (`to_user`),
  KEY `FK38EB0007E89824B3` (`from_user`),
  CONSTRAINT `FK38EB00079EF6C882` FOREIGN KEY (`to_user`) REFERENCES `user` (`userId`),
  CONSTRAINT `FK38EB0007E89824B3` FOREIGN KEY (`from_user`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------

-- ----------------------------
-- Table structure for `picture`
-- ----------------------------
DROP TABLE IF EXISTS `picture`;
CREATE TABLE `picture` (
  `pid` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `createTime` date DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `pic_owner` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`pid`),
  KEY `FKDD905CFE2AEB7985` (`pic_owner`),
  CONSTRAINT `FKDD905CFE2AEB7985` FOREIGN KEY (`pic_owner`) REFERENCES `album` (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of picture
-- ----------------------------

-- ----------------------------
-- Table structure for `place`
-- ----------------------------
DROP TABLE IF EXISTS `place`;
CREATE TABLE `place` (
  `pid` bigint(20) NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `county` varchar(255) DEFAULT NULL,
  `iscapital` bit(1) NOT NULL,
  `picture_path` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=232 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of place
-- ----------------------------
INSERT INTO `place` VALUES ('4', '南京市', '中国', '玄武区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('5', '南京市', '中国', '白下区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('6', '南京市', '中国', '秦淮区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('7', '南京市', '中国', '建邺区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('8', '南京市', '中国', '鼓楼区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('9', '南京市', '中国', '下关区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('10', '南京市', '中国', '浦口区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('11', '南京市', '中国', '栖霞区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('12', '南京市', '中国', '雨花台', '\0', null, '江苏');
INSERT INTO `place` VALUES ('13', '南京市', '中国', '江宁区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('14', '南京市', '中国', '六合区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('15', '南京市', '中国', '溧水县', '\0', null, '江苏');
INSERT INTO `place` VALUES ('16', '南京市', '中国', '高淳县', '\0', null, '江苏');
INSERT INTO `place` VALUES ('18', '无锡市', '中国', '崇安区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('19', '无锡市', '中国', '南长区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('20', '无锡市', '中国', '北塘区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('21', '无锡市', '中国', '滨湖区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('22', '无锡市', '中国', '锡山区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('23', '无锡市', '中国', '惠山区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('24', '无锡市', '中国', '江阴市', '\0', null, '江苏');
INSERT INTO `place` VALUES ('25', '无锡市', '中国', '宜兴市', '\0', null, '江苏');
INSERT INTO `place` VALUES ('27', '徐州市', '中国', '云龙区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('28', '徐州市', '中国', '鼓楼区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('29', '徐州市', '中国', '九里区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('30', '徐州市', '中国', '贾汪区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('31', '徐州市', '中国', '泉山区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('32', '徐州市', '中国', '新沂市', '\0', null, '江苏');
INSERT INTO `place` VALUES ('33', '徐州市', '中国', '邳州市', '\0', null, '江苏');
INSERT INTO `place` VALUES ('34', '徐州市', '中国', '丰县', '\0', null, '江苏');
INSERT INTO `place` VALUES ('35', '徐州市', '中国', '沛县', '\0', null, '江苏');
INSERT INTO `place` VALUES ('36', '徐州市', '中国', '铜山县', '\0', null, '江苏');
INSERT INTO `place` VALUES ('37', '徐州市', '中国', '睢宁县', '\0', null, '江苏');
INSERT INTO `place` VALUES ('39', '常州市', '中国', '钟楼区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('40', '常州市', '中国', '天宁区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('41', '常州市', '中国', '戚墅堰', '\0', null, '江苏');
INSERT INTO `place` VALUES ('42', '常州市', '中国', '新北区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('43', '常州市', '中国', '武进区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('44', '常州市', '中国', '溧阳市', '\0', null, '江苏');
INSERT INTO `place` VALUES ('45', '常州市', '中国', '金坛市', '\0', null, '江苏');
INSERT INTO `place` VALUES ('47', '苏州市', '中国', '金阊区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('48', '苏州市', '中国', '沧浪区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('49', '苏州市', '中国', '平江区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('50', '苏州市', '中国', '虎丘区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('51', '苏州市', '中国', '吴中区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('52', '苏州市', '中国', '相城区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('53', '苏州市', '中国', '常熟市', '\0', null, '江苏');
INSERT INTO `place` VALUES ('54', '苏州市', '中国', '张家港', '\0', null, '江苏');
INSERT INTO `place` VALUES ('55', '苏州市', '中国', '昆山市', '\0', null, '江苏');
INSERT INTO `place` VALUES ('56', '苏州市', '中国', '吴江市', '\0', null, '江苏');
INSERT INTO `place` VALUES ('57', '苏州市', '中国', '太仓市', '\0', null, '江苏');
INSERT INTO `place` VALUES ('59', '南通市', '中国', '崇川区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('60', '南通市', '中国', '港闸区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('61', '南通市', '中国', '启东市', '\0', null, '江苏');
INSERT INTO `place` VALUES ('62', '南通市', '中国', '如皋市', '\0', null, '江苏');
INSERT INTO `place` VALUES ('63', '南通市', '中国', '通州市', '\0', null, '江苏');
INSERT INTO `place` VALUES ('64', '南通市', '中国', '海门市', '\0', null, '江苏');
INSERT INTO `place` VALUES ('65', '南通市', '中国', '海安县', '\0', null, '江苏');
INSERT INTO `place` VALUES ('66', '南通市', '中国', '如东县', '\0', null, '江苏');
INSERT INTO `place` VALUES ('68', '连云港市', '中国', '新浦区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('69', '连云港市', '中国', '连云区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('70', '连云港市', '中国', '海州区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('71', '连云港市', '中国', '赣榆县', '\0', null, '江苏');
INSERT INTO `place` VALUES ('72', '连云港市', '中国', '东海县', '\0', null, '江苏');
INSERT INTO `place` VALUES ('73', '连云港市', '中国', '灌云县', '\0', null, '江苏');
INSERT INTO `place` VALUES ('74', '连云港市', '中国', '灌南县', '\0', null, '江苏');
INSERT INTO `place` VALUES ('76', '淮安市', '中国', '清河区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('77', '淮安市', '中国', '清浦区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('78', '淮安市', '中国', '楚州区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('79', '淮安市', '中国', '淮阴区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('80', '淮安市', '中国', '涟水县', '\0', null, '江苏');
INSERT INTO `place` VALUES ('81', '淮安市', '中国', '洪泽县', '\0', null, '江苏');
INSERT INTO `place` VALUES ('82', '淮安市', '中国', '盱眙县', '\0', null, '江苏');
INSERT INTO `place` VALUES ('83', '淮安市', '中国', '金湖县', '\0', null, '江苏');
INSERT INTO `place` VALUES ('85', '盐城市', '中国', '亭湖区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('86', '盐城市', '中国', '盐都区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('87', '盐城市', '中国', '东台市', '\0', null, '江苏');
INSERT INTO `place` VALUES ('88', '盐城市', '中国', '大丰市', '\0', null, '江苏');
INSERT INTO `place` VALUES ('89', '盐城市', '中国', '响水县', '\0', null, '江苏');
INSERT INTO `place` VALUES ('90', '盐城市', '中国', '滨海县', '\0', null, '江苏');
INSERT INTO `place` VALUES ('91', '盐城市', '中国', '阜宁县', '\0', null, '江苏');
INSERT INTO `place` VALUES ('92', '盐城市', '中国', '射阳县', '\0', null, '江苏');
INSERT INTO `place` VALUES ('93', '盐城市', '中国', '建湖县', '\0', null, '江苏');
INSERT INTO `place` VALUES ('95', '扬州市', '中国', '广陵区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('96', '扬州市', '中国', '邗江区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('97', '扬州市', '中国', '维扬区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('98', '扬州市', '中国', '仪征市', '\0', null, '江苏');
INSERT INTO `place` VALUES ('99', '扬州市', '中国', '高邮市', '\0', null, '江苏');
INSERT INTO `place` VALUES ('100', '扬州市', '中国', '江都市', '\0', null, '江苏');
INSERT INTO `place` VALUES ('101', '扬州市', '中国', '宝应县', '\0', null, '江苏');
INSERT INTO `place` VALUES ('103', '镇江市', '中国', '京口区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('104', '镇江市', '中国', '润州区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('105', '镇江市', '中国', '丹徒区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('106', '镇江市', '中国', '丹阳市', '\0', null, '江苏');
INSERT INTO `place` VALUES ('107', '镇江市', '中国', '扬中市', '\0', null, '江苏');
INSERT INTO `place` VALUES ('108', '镇江市', '中国', '句容市', '\0', null, '江苏');
INSERT INTO `place` VALUES ('110', '泰州市', '中国', '海陵区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('111', '泰州市', '中国', '高港区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('112', '泰州市', '中国', '兴化市', '\0', null, '江苏');
INSERT INTO `place` VALUES ('113', '泰州市', '中国', '靖江市', '\0', null, '江苏');
INSERT INTO `place` VALUES ('114', '泰州市', '中国', '泰兴市', '\0', null, '江苏');
INSERT INTO `place` VALUES ('115', '泰州市', '中国', '姜堰市', '\0', null, '江苏');
INSERT INTO `place` VALUES ('117', '宿迁市', '中国', '宿城区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('118', '宿迁市', '中国', '宿豫区', '\0', null, '江苏');
INSERT INTO `place` VALUES ('119', '宿迁市', '中国', '沭阳县', '\0', null, '江苏');
INSERT INTO `place` VALUES ('120', '宿迁市', '中国', '泗阳县', '\0', null, '江苏');
INSERT INTO `place` VALUES ('121', '宿迁市', '中国', '泗洪县', '\0', null, '江苏');
INSERT INTO `place` VALUES ('124', '北京市', '中国', '东城区', '\0', null, '北京');
INSERT INTO `place` VALUES ('125', '北京市', '中国', '西城区', '\0', null, '北京');
INSERT INTO `place` VALUES ('126', '北京市', '中国', '朝阳区', '\0', null, '北京');
INSERT INTO `place` VALUES ('127', '北京市', '中国', '丰台区', '\0', null, '北京');
INSERT INTO `place` VALUES ('128', '北京市', '中国', '石景山区', '\0', null, '北京');
INSERT INTO `place` VALUES ('129', '北京市', '中国', '海淀区', '\0', null, '北京');
INSERT INTO `place` VALUES ('130', '北京市', '中国', '门头沟区', '\0', null, '北京');
INSERT INTO `place` VALUES ('131', '北京市', '中国', '房山区', '\0', null, '北京');
INSERT INTO `place` VALUES ('132', '北京市', '中国', '通州区', '\0', null, '北京');
INSERT INTO `place` VALUES ('133', '北京市', '中国', '顺义区', '\0', null, '北京');
INSERT INTO `place` VALUES ('134', '北京市', '中国', '昌平区', '\0', null, '北京');
INSERT INTO `place` VALUES ('135', '北京市', '中国', '大兴区', '\0', null, '北京');
INSERT INTO `place` VALUES ('136', '北京市', '中国', '怀柔区', '\0', null, '北京');
INSERT INTO `place` VALUES ('137', '北京市', '中国', '平谷区', '\0', null, '北京');
INSERT INTO `place` VALUES ('138', '北京市', '中国', '密云县', '\0', null, '北京');
INSERT INTO `place` VALUES ('139', '北京市', '中国', '延庆县', '\0', null, '北京');
INSERT INTO `place` VALUES ('142', '天津市', '中国', '和平区', '\0', null, '天津');
INSERT INTO `place` VALUES ('143', '天津市', '中国', '河东区', '\0', null, '天津');
INSERT INTO `place` VALUES ('144', '天津市', '中国', '河西区', '\0', null, '天津');
INSERT INTO `place` VALUES ('145', '天津市', '中国', '南开区', '\0', null, '天津');
INSERT INTO `place` VALUES ('146', '天津市', '中国', '河北区', '\0', null, '天津');
INSERT INTO `place` VALUES ('147', '天津市', '中国', '红桥区', '\0', null, '天津');
INSERT INTO `place` VALUES ('148', '天津市', '中国', '东丽区', '\0', null, '天津');
INSERT INTO `place` VALUES ('149', '天津市', '中国', '西青区', '\0', null, '天津');
INSERT INTO `place` VALUES ('150', '天津市', '中国', '津南区', '\0', null, '天津');
INSERT INTO `place` VALUES ('151', '天津市', '中国', '北辰区', '\0', null, '天津');
INSERT INTO `place` VALUES ('152', '天津市', '中国', '武清区', '\0', null, '天津');
INSERT INTO `place` VALUES ('153', '天津市', '中国', '宝坻区', '\0', null, '天津');
INSERT INTO `place` VALUES ('154', '天津市', '中国', '宁河县', '\0', null, '天津');
INSERT INTO `place` VALUES ('155', '天津市', '中国', '静海县', '\0', null, '天津');
INSERT INTO `place` VALUES ('156', '天津市', '中国', '蓟县', '\0', null, '天津');
INSERT INTO `place` VALUES ('157', '天津市', '中国', '滨海新区', '\0', null, '天津');
INSERT INTO `place` VALUES ('160', '上海市', '中国', '黄浦区', '\0', null, '上海');
INSERT INTO `place` VALUES ('161', '上海市', '中国', '徐汇区', '\0', null, '上海');
INSERT INTO `place` VALUES ('162', '上海市', '中国', '长宁区', '\0', null, '上海');
INSERT INTO `place` VALUES ('163', '上海市', '中国', '静安区', '\0', null, '上海');
INSERT INTO `place` VALUES ('164', '上海市', '中国', '普陀区', '\0', null, '上海');
INSERT INTO `place` VALUES ('165', '上海市', '中国', '闸北区', '\0', null, '上海');
INSERT INTO `place` VALUES ('166', '上海市', '中国', '虹口区', '\0', null, '上海');
INSERT INTO `place` VALUES ('167', '上海市', '中国', '杨浦区', '\0', null, '上海');
INSERT INTO `place` VALUES ('168', '上海市', '中国', '宝山区', '\0', null, '上海');
INSERT INTO `place` VALUES ('169', '上海市', '中国', '闵行区', '\0', null, '上海');
INSERT INTO `place` VALUES ('170', '上海市', '中国', '嘉定区', '\0', null, '上海');
INSERT INTO `place` VALUES ('171', '上海市', '中国', '浦东新区', '\0', null, '上海');
INSERT INTO `place` VALUES ('172', '上海市', '中国', '金山区', '\0', null, '上海');
INSERT INTO `place` VALUES ('173', '上海市', '中国', '松江区', '\0', null, '上海');
INSERT INTO `place` VALUES ('174', '上海市', '中国', '青浦区', '\0', null, '上海');
INSERT INTO `place` VALUES ('175', '上海市', '中国', '奉贤区', '\0', null, '上海');
INSERT INTO `place` VALUES ('176', '上海市', '中国', '崇明县', '\0', null, '上海');
INSERT INTO `place` VALUES ('179', '重庆市', '中国', '渝中区', '\0', null, '重庆');
INSERT INTO `place` VALUES ('180', '重庆市', '中国', '大渡口区', '\0', null, '重庆');
INSERT INTO `place` VALUES ('181', '重庆市', '中国', '江北区', '\0', null, '重庆');
INSERT INTO `place` VALUES ('182', '重庆市', '中国', '沙坪坝区', '\0', null, '重庆');
INSERT INTO `place` VALUES ('183', '重庆市', '中国', '九龙坡区', '\0', null, '重庆');
INSERT INTO `place` VALUES ('184', '重庆市', '中国', '南岸区', '\0', null, '重庆');
INSERT INTO `place` VALUES ('185', '重庆市', '中国', '北碚区', '\0', null, '重庆');
INSERT INTO `place` VALUES ('186', '重庆市', '中国', '渝北区', '\0', null, '重庆');
INSERT INTO `place` VALUES ('187', '重庆市', '中国', '巴南区', '\0', null, '重庆');
INSERT INTO `place` VALUES ('188', '重庆市', '中国', '万州区', '\0', null, '重庆');
INSERT INTO `place` VALUES ('189', '重庆市', '中国', '涪陵区', '\0', null, '重庆');
INSERT INTO `place` VALUES ('190', '重庆市', '中国', '黔江区', '\0', null, '重庆');
INSERT INTO `place` VALUES ('191', '重庆市', '中国', '长寿区', '\0', null, '重庆');
INSERT INTO `place` VALUES ('192', '重庆市', '中国', '江津区', '\0', null, '重庆');
INSERT INTO `place` VALUES ('193', '重庆市', '中国', '合川区', '\0', null, '重庆');
INSERT INTO `place` VALUES ('194', '重庆市', '中国', '永川区', '\0', null, '重庆');
INSERT INTO `place` VALUES ('195', '重庆市', '中国', '南川区', '\0', null, '重庆');
INSERT INTO `place` VALUES ('196', '重庆市', '中国', '綦江区', '\0', null, '重庆');
INSERT INTO `place` VALUES ('197', '重庆市', '中国', '大足区', '\0', null, '重庆');
INSERT INTO `place` VALUES ('198', '重庆市', '中国', '潼南县', '\0', null, '重庆');
INSERT INTO `place` VALUES ('199', '重庆市', '中国', '铜梁县', '\0', null, '重庆');
INSERT INTO `place` VALUES ('200', '重庆市', '中国', '荣昌县', '\0', null, '重庆');
INSERT INTO `place` VALUES ('201', '重庆市', '中国', '璧山县', '\0', null, '重庆');
INSERT INTO `place` VALUES ('202', '重庆市', '中国', '梁平县', '\0', null, '重庆');
INSERT INTO `place` VALUES ('203', '重庆市', '中国', '城口县', '\0', null, '重庆');
INSERT INTO `place` VALUES ('204', '重庆市', '中国', '丰都县', '\0', null, '重庆');
INSERT INTO `place` VALUES ('205', '重庆市', '中国', '垫江县', '\0', null, '重庆');
INSERT INTO `place` VALUES ('206', '重庆市', '中国', '武隆县', '\0', null, '重庆');
INSERT INTO `place` VALUES ('207', '重庆市', '中国', '忠县', '\0', null, '重庆');
INSERT INTO `place` VALUES ('208', '重庆市', '中国', '开县', '\0', null, '重庆');
INSERT INTO `place` VALUES ('209', '重庆市', '中国', '云阳县', '\0', null, '重庆');
INSERT INTO `place` VALUES ('210', '重庆市', '中国', '奉节县', '\0', null, '重庆');
INSERT INTO `place` VALUES ('211', '重庆市', '中国', '巫山县', '\0', null, '重庆');
INSERT INTO `place` VALUES ('212', '重庆市', '中国', '巫溪县', '\0', null, '重庆');
INSERT INTO `place` VALUES ('213', '重庆市', '中国', '石柱自治县', '\0', null, '重庆');
INSERT INTO `place` VALUES ('214', '重庆市', '中国', '秀山自治县', '\0', null, '重庆');
INSERT INTO `place` VALUES ('215', '重庆市', '中国', '酉阳自治县', '\0', null, '重庆');
INSERT INTO `place` VALUES ('216', '重庆市', '中国', '彭水自治县', '\0', null, '重庆');
INSERT INTO `place` VALUES ('219', '石家庄', '中国', '长安区', '\0', null, '河北省');
INSERT INTO `place` VALUES ('220', '石家庄', '中国', '桥东区', '\0', null, '河北省');
INSERT INTO `place` VALUES ('221', '石家庄', '中国', '桥西区', '\0', null, '河北省');
INSERT INTO `place` VALUES ('222', '石家庄', '中国', '新华区', '\0', null, '河北省');
INSERT INTO `place` VALUES ('223', '石家庄', '中国', '裕华区', '\0', null, '河北省');
INSERT INTO `place` VALUES ('224', '石家庄', '中国', '井陉矿区', '\0', null, '河北省');
INSERT INTO `place` VALUES ('225', '石家庄', '中国', '辛集市', '\0', null, '河北省');
INSERT INTO `place` VALUES ('226', '石家庄', '中国', '藁城市', '\0', null, '河北省');
INSERT INTO `place` VALUES ('227', '石家庄', '中国', '晋州市', '\0', null, '河北省');
INSERT INTO `place` VALUES ('228', '石家庄', '中国', '新乐市', '\0', null, '河北省');
INSERT INTO `place` VALUES ('229', '石家庄', '中国', '鹿泉市', '\0', null, '河北省');
INSERT INTO `place` VALUES ('230', '石家庄', '中国', '平山县', '\0', null, '河北省');
INSERT INTO `place` VALUES ('231', '石家庄', '中国', '井陉县', '\0', null, '河北省');

-- ----------------------------
-- Table structure for `report`
-- ----------------------------
DROP TABLE IF EXISTS `report`;
CREATE TABLE `report` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `isRead` bit(1) NOT NULL,
  `reason` int(11) NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `reportTime` date DEFAULT NULL,
  `from_user` bigint(20) DEFAULT NULL,
  `to_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKC84C55349EF6C882` (`to_user`),
  KEY `FKC84C5534E89824B3` (`from_user`),
  CONSTRAINT `FKC84C55349EF6C882` FOREIGN KEY (`to_user`) REFERENCES `user` (`userId`),
  CONSTRAINT `FKC84C5534E89824B3` FOREIGN KEY (`from_user`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of report
-- ----------------------------

-- ----------------------------
-- Table structure for `send_gift`
-- ----------------------------
DROP TABLE IF EXISTS `send_gift`;
CREATE TABLE `send_gift` (
  `sg_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `time` date DEFAULT NULL,
  `from_user` bigint(20) DEFAULT NULL,
  `gift` bigint(20) DEFAULT NULL,
  `to_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`sg_id`),
  KEY `FK191C787E3F24408` (`gift`),
  KEY `FK191C7879EF6C882` (`to_user`),
  KEY `FK191C787E89824B3` (`from_user`),
  CONSTRAINT `FK191C7879EF6C882` FOREIGN KEY (`to_user`) REFERENCES `user` (`userId`),
  CONSTRAINT `FK191C787E3F24408` FOREIGN KEY (`gift`) REFERENCES `gift` (`gid`),
  CONSTRAINT `FK191C787E89824B3` FOREIGN KEY (`from_user`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of send_gift
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` bigint(20) NOT NULL AUTO_INCREMENT,
  `UUID` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `isActive` bit(1) NOT NULL,
  `isAdvance` int(11) NOT NULL,
  `level` int(11) NOT NULL,
  `money` double NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `portrait` varchar(255) DEFAULT NULL,
  `sex` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `userlocation` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  KEY `FK36EBCBD4A92CDF` (`userlocation`),
  CONSTRAINT `FK36EBCBD4A92CDF` FOREIGN KEY (`userlocation`) REFERENCES `place` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2', '379843e6-b988-4568-9c69-324572943247', 'wanghao@nj.com', '', '0', '0', '0', '王豪', 'e10adc3949ba59abbe56e057f20f883e', 'D:\\tmp\\user-photo\\2\\1371279244136.jpg', '0', '0', null);
INSERT INTO `user` VALUES ('4', null, '890@nju.cn', '\0', '0', '0', '0', '2222发斯蒂芬', 'e10adc3949ba59abbe56e057f20f883e', null, '0', '0', null);
INSERT INTO `user` VALUES ('5', 'f51eb88d-9f22-4f55-b4ed-50dc1cd35c5b', 'kkk@nju.cn', '', '0', '0', '0', '2222', 'e10adc3949ba59abbe56e057f20f883e', '/tmp\\user-photo\\2\\1371279244136.jpg', '0', '0', '4');
INSERT INTO `user` VALUES ('6', '24c96617-fcf1-40f2-8548-56b71a326124', 'qqqqqqqq@nju.cn', '\0', '0', '0', '0', '2222', 'e10adc3949ba59abbe56e057f20f883e', '/tmp/user-photo/6/1372309626808.jpg', '1', '1', '4');
INSERT INTO `user` VALUES ('7', '5b46690f-5168-47ac-8019-549c12cf818d', 's@nju.cn', '\0', '0', '0', '0', '2222', 'e10adc3949ba59abbe56e057f20f883e', 'C:\\tmp\\user-photo\\7\\1372314875655.jpg', '0', '0', '4');
INSERT INTO `user` VALUES ('8', null, 'sdfdsf@nju.cn', '\0', '0', '0', '0', '2222', 'e10adc3949ba59abbe56e057f20f883e', 'C:\\tmp\\user-photo\\8\\1372325977543.jpg', '0', '0', '4');
INSERT INTO `user` VALUES ('9', 'bb6625cc-b428-44d4-8f38-3ee31a769f19', 'sdsds@nju.cn', '', '0', '0', '0', '2222', 'e10adc3949ba59abbe56e057f20f883e', 'C:\\tmp\\user-photo\\9\\1372327133779.jpg', '0', '1', '4');
INSERT INTO `user` VALUES ('10', 'a621ba4f-8c0f-4c75-ab52-db5d72f8a30d', 'dingxiaogang@nju.cn', '', '0', '0', '0', '丁晓刚', 'e10adc3949ba59abbe56e057f20f883e', 'C:\\tmp\\user-photo\\10\\1372749696848.jpg', '0', '1', '4');
INSERT INTO `user` VALUES ('11', 'd47fc37c-100d-4409-8a0b-2e7adc4b5103', 'gongzi@nju.cn', '', '0', '0', '0', '公子', 'e10adc3949ba59abbe56e057f20f883e', 'C:\\tmp\\user-photo\\11\\1372752733278.jpg', '0', '1', '4');
INSERT INTO `user` VALUES ('12', '091830a7-736f-4ed0-ba87-cfca1decfd95', 'ddddd@nju.cn', '', '0', '0', '0', '昆山', 'e10adc3949ba59abbe56e057f20f883e', 'C:\\tmp\\user-photo\\12\\1372761740263.jpg', '0', '1', '4');
INSERT INTO `user` VALUES ('13', '3645e286-9946-444e-ba14-f23043cb102b', 'dddddd@nju.cn', '', '0', '0', '0', '达哥', 'e10adc3949ba59abbe56e057f20f883e', 'C:\\tmp\\user-photo\\13\\1373082833864.jpg', '0', '1', '4');
INSERT INTO `user` VALUES ('14', 'a15970c6-53b9-4e9d-9876-b0eb0b18b1c2', 'LLLLL@nju.cn', '', '0', '0', '0', '2222', 'e10adc3949ba59abbe56e057f20f883e', '/tmp/user-photo/14/1373456006348.jpg', '0', '0', '4');
INSERT INTO `user` VALUES ('15', '389b1008-0473-44de-909e-b945d3c86597', 'xjy09@software.nju.edu.cn', '', '0', '0', '0', 'Tony', 'e10adc3949ba59abbe56e057f20f883e', 'C:\\tmp\\user-photo\\15\\1373461530952.jpg', '0', '0', '4');
INSERT INTO `user` VALUES ('16', 'f3834170-97de-4b14-92c4-d6e74da2354b', 'abc@nju.cn', '\0', '0', '0', '0', '2222', 'e10adc3949ba59abbe56e057f20f883e', null, '0', '0', '4');
INSERT INTO `user` VALUES ('17', null, '@nju.cn', '\0', '0', '0', '0', '2222', 'e10adc3949ba59abbe56e057f20f883e', null, '0', '0', null);
INSERT INTO `user` VALUES ('18', null, 'dddd@nju.cn', '\0', '0', '0', '0', 'adsf', 'e10adc3949ba59abbe56e057f20f883e', null, '0', '1', null);
INSERT INTO `user` VALUES ('19', null, 'frv@nju.cn', '\0', '0', '0', '0', '2222', 'e10adc3949ba59abbe56e057f20f883e', null, '0', '0', null);
INSERT INTO `user` VALUES ('20', null, 'we@nju.cn', '\0', '0', '0', '0', 'rcd', 'e10adc3949ba59abbe56e057f20f883e', 'C:\\tmp\\user-photo\\20\\1374128027465.jpg', '0', '1', '4');
INSERT INTO `user` VALUES ('21', null, 'sd@nju.cn', '\0', '0', '0', '0', '15', 'e10adc3949ba59abbe56e057f20f883e', 'C:\\tmp\\user-photo\\21\\1374128364871.jpg', '0', '1', '4');

-- ----------------------------
-- Table structure for `user_authority`
-- ----------------------------
DROP TABLE IF EXISTS `user_authority`;
CREATE TABLE `user_authority` (
  `uid` bigint(20) NOT NULL AUTO_INCREMENT,
  `permission` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`uid`),
  KEY `FKB55BEBCFDB034B82` (`user_id`),
  CONSTRAINT `FKB55BEBCFDB034B82` FOREIGN KEY (`user_id`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_authority
-- ----------------------------

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `uid` bigint(20) NOT NULL AUTO_INCREMENT,
  `birthday` date DEFAULT NULL,
  `education` varchar(255) DEFAULT NULL,
  `height` double NOT NULL,
  `hometown` varchar(255) DEFAULT NULL,
  `intro` varchar(255) DEFAULT NULL,
  `job` varchar(255) DEFAULT NULL,
  `license` varchar(255) DEFAULT NULL,
  `passport` varchar(255) DEFAULT NULL,
  `phonenum` varchar(255) DEFAULT NULL,
  `qq` varchar(255) DEFAULT NULL,
  `user_language` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`uid`),
  KEY `FK1437D8A2DB034B82` (`user_id`),
  CONSTRAINT `FK1437D8A2DB034B82` FOREIGN KEY (`user_id`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('2', '1990-05-01', '大学本科', '160', '123', '12312123131看刘靖康', '学生', '有', '港澳通行证', '13899994566', '563715442', '普通话', '2');
INSERT INTO `user_info` VALUES ('4', null, null, '0', null, null, null, null, null, null, null, null, '4');
INSERT INTO `user_info` VALUES ('5', '1990-05-01', '大学本科', '160', '123', '12312123131', '学生', '有', '港澳通行证', '15300994566', '12314123131', '普通话', '5');
INSERT INTO `user_info` VALUES ('6', '1990-05-01', '大学本科', '160', '123', '12312123131', '学生', '有', '港澳通行证', '15899994566', '12322123131', '普通话', '6');
INSERT INTO `user_info` VALUES ('7', '1990-05-01', '大学本科', '160', '123', '12312123131', '学生', '有', '港澳通行证', '15399991566', '123121222431', '普通话', '7');
INSERT INTO `user_info` VALUES ('8', '1990-05-01', '大学本科', '160', '123', '12312123131', '学生', '有', '港澳通行证', '15393994566', '12313123131', '普通话', '8');
INSERT INTO `user_info` VALUES ('9', '1990-05-01', '大学本科', '160', '123', '12312123131', '学生', '有', '港澳通行证', '15119994566', '12312123131', '普通话', '9');
INSERT INTO `user_info` VALUES ('10', '1990-05-01', '大学本科', '160', '123', '12312123131', '学生', '有', '港澳通行证', '15399990066', '12312120031', '普通话', '10');
INSERT INTO `user_info` VALUES ('11', '1991-01-16', '蓝翔技工', '180', '南通通州', 'Hello World', '学生', '有', '港澳通行证', '15399794566', '12312123190', '普通话', '11');
INSERT INTO `user_info` VALUES ('12', '1990-05-01', '研究生', '175', '昆山', '昆山一霸，呵呵呵呵', '学生', '无', '港澳通行证', '15390000566', '12312123000', '普通话', '12');
INSERT INTO `user_info` VALUES ('13', '1990-05-01', '大学本科', '160', '123', '12312123131', '学生', '有', '港澳通行证', '15388114566', '12312141131', '普通话', '13');
INSERT INTO `user_info` VALUES ('14', '1990-05-01', '大学本科', '160', '123', '12312123131', '学生', '有', '港澳通行证', '15399994444', '12312123100', '普通话', '14');
INSERT INTO `user_info` VALUES ('15', '1990-05-01', '大学本科', '160', '123', '12312123131', '学生', '有', '港澳通行证', '15399994566', '', '普通话', '15');
INSERT INTO `user_info` VALUES ('16', '1990-05-01', '大学本科', '160', '123', '12312123131', '学生', '有', '港澳通行证', '11111111111', '111111111', '普通话', '16');
INSERT INTO `user_info` VALUES ('17', null, null, '0', null, null, null, null, null, null, null, null, '17');
INSERT INTO `user_info` VALUES ('18', null, null, '0', null, null, null, null, null, null, null, null, '18');
INSERT INTO `user_info` VALUES ('19', null, null, '0', null, null, null, null, null, null, null, null, '19');
INSERT INTO `user_info` VALUES ('20', '1990-05-01', '大学本科', '160', '123', '这样的事情', '学生', '有', '港澳通行证', '15399004566', '12312108131', '普通话', '20');
INSERT INTO `user_info` VALUES ('21', '1990-05-01', '大学本科', '160', '123', '12312123131', '学生', '有', '港澳通行证', '15390794566', '12392123131', '普通话', '21');

-- ----------------------------
-- Table structure for `visit`
-- ----------------------------
DROP TABLE IF EXISTS `visit`;
CREATE TABLE `visit` (
  `vid` bigint(20) NOT NULL AUTO_INCREMENT,
  `visitTime` date DEFAULT NULL,
  `from_user` bigint(20) DEFAULT NULL,
  `to_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`vid`),
  KEY `FK6B04D4B9EF6C882` (`to_user`),
  KEY `FK6B04D4BE89824B3` (`from_user`),
  CONSTRAINT `FK6B04D4B9EF6C882` FOREIGN KEY (`to_user`) REFERENCES `user` (`userId`),
  CONSTRAINT `FK6B04D4BE89824B3` FOREIGN KEY (`from_user`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of visit
-- ----------------------------
