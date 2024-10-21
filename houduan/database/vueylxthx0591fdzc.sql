/*
Navicat MySQL Data Transfer

Source Server         : localhost_3307
Source Server Version : 50562
Source Host           : localhost:3307
Source Database       : vueylxthx0591fdzc

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2024-03-03 19:44:46
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `aihaozhe`
-- ----------------------------
DROP TABLE IF EXISTS `aihaozhe`;
CREATE TABLE `aihaozhe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `yonghuming` varchar(50) DEFAULT NULL,
  `mima` varchar(50) DEFAULT NULL,
  `xingming` varchar(50) DEFAULT NULL,
  `xingbie` varchar(50) DEFAULT NULL,
  `lianxidianhua` varchar(50) DEFAULT NULL,
  `weixinhao` varchar(50) DEFAULT NULL,
  `zhaopian` varchar(50) DEFAULT NULL,
  `level` varchar(10) DEFAULT '爱好者',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of aihaozhe
-- ----------------------------
INSERT INTO `aihaozhe` VALUES ('2', '028', 'dc5c7986daef50c1e02ab09b442ee34f', '范冰冰', '1', '13587835380', '5437334', '', '爱好者', '2024-03-03 14:25:36');
INSERT INTO `aihaozhe` VALUES ('3', '020', 'dc5c7986daef50c1e02ab09b442ee34f', '何永康', '0', '13544655202', '34737325', '', '爱好者', '2024-03-03 14:25:36');
INSERT INTO `aihaozhe` VALUES ('4', '034', 'dc5c7986daef50c1e02ab09b442ee34f', '李大汉', '0', '17706641413', '2362624', '', '爱好者', '2024-03-03 14:25:36');
INSERT INTO `aihaozhe` VALUES ('5', '022', 'dc5c7986daef50c1e02ab09b442ee34f', '方之明', '1', '13186835580', '264373757', '', '爱好者', '2024-03-03 14:25:36');
INSERT INTO `aihaozhe` VALUES ('6', '009', 'dc5c7986daef50c1e02ab09b442ee34f', '舒畅', '0', '13623256544', '3263266', '', '爱好者', '2024-03-03 14:25:36');
INSERT INTO `aihaozhe` VALUES ('7', '019', 'dc5c7986daef50c1e02ab09b442ee34f', '陈智一', '1', '13769548711', '36721533', '', '爱好者', '2024-03-03 14:25:36');
INSERT INTO `aihaozhe` VALUES ('8', '030', 'dc5c7986daef50c1e02ab09b442ee34f', '司宪策', '0', '13910215489', '7696676', '', '爱好者', '2024-03-03 14:25:36');
INSERT INTO `aihaozhe` VALUES ('9', '002', 'dc5c7986daef50c1e02ab09b442ee34f', '姚明', '0', '17505772420', '7475484', '', '爱好者', '2024-03-03 14:25:36');
INSERT INTO `aihaozhe` VALUES ('10', '017', 'dc5c7986daef50c1e02ab09b442ee34f', '刘建福', '0', '13489665487', '3523626', '', '爱好者', '2024-03-03 14:25:36');
INSERT INTO `aihaozhe` VALUES ('11', '001', 'dc5c7986daef50c1e02ab09b442ee34f', '贾静雯', '1', '13025896548', '3213622', '', '爱好者', '2024-03-03 14:25:36');

-- ----------------------------
-- Table structure for `bankuai`
-- ----------------------------
DROP TABLE IF EXISTS `bankuai`;
CREATE TABLE `bankuai` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bankuaimingcheng` varchar(50) DEFAULT NULL,
  `banzhu` varchar(50) DEFAULT NULL,
  `yiyoutieshu` varchar(50) DEFAULT NULL,
  `jianjie` varchar(500) DEFAULT NULL,
  `fengmian` varchar(50) DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of bankuai
-- ----------------------------
INSERT INTO `bankuai` VALUES ('2', '吉他版块', '何升高', '2', '暂无', '', '2024-01-04 01:17:38');
INSERT INTO `bankuai` VALUES ('3', '钢琴版块', 'wegwewe', '0', '无', '', '2024-01-04 01:17:38');
INSERT INTO `bankuai` VALUES ('4', '笛子版块', 'wehw', '0', '无', '', '2024-01-04 01:17:38');
INSERT INTO `bankuai` VALUES ('5', '手提琴版块', 'hwehw', '0', 'abc', '', '2024-01-04 01:17:38');
INSERT INTO `bankuai` VALUES ('6', '手风琴版块', 'hwehwe', '0', 'ok', '', '2024-01-04 01:17:38');

-- ----------------------------
-- Table structure for `bianhuantu`
-- ----------------------------
DROP TABLE IF EXISTS `bianhuantu`;
CREATE TABLE `bianhuantu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mingcheng` varchar(50) DEFAULT NULL,
  `tupian` varchar(50) DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of bianhuantu
-- ----------------------------
INSERT INTO `bianhuantu` VALUES ('1', 'P名称', '/files/download/36', '2024-03-03 14:25:36');
INSERT INTO `bianhuantu` VALUES ('2', 'C名称', '/files/download/37', '2024-03-03 14:25:36');
INSERT INTO `bianhuantu` VALUES ('3', 'N名称', '/files/download/38', '2024-03-03 14:25:36');
INSERT INTO `bianhuantu` VALUES ('4', 'Q名称', '/files/download/39', '2024-03-03 14:25:36');
INSERT INTO `bianhuantu` VALUES ('5', 'H名称', '/files/download/40', '2024-03-03 14:25:36');

-- ----------------------------
-- Table structure for `chuangzuozhe`
-- ----------------------------
DROP TABLE IF EXISTS `chuangzuozhe`;
CREATE TABLE `chuangzuozhe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `zhanghao` varchar(50) DEFAULT NULL,
  `mima` varchar(50) DEFAULT NULL,
  `xingming` varchar(50) DEFAULT NULL,
  `xingbie` varchar(50) DEFAULT NULL,
  `shenfenzheng` varchar(50) DEFAULT NULL,
  `lianxidianhua` varchar(50) DEFAULT NULL,
  `zhaopian` varchar(50) DEFAULT NULL,
  `level` varchar(10) DEFAULT '创作者',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of chuangzuozhe
-- ----------------------------
INSERT INTO `chuangzuozhe` VALUES ('2', '011', 'dc5c7986daef50c1e02ab09b442ee34f', '河升镇', '1', '330327185403060589', '17706641413', '', '创作者', '2024-03-03 14:25:36');
INSERT INTO `chuangzuozhe` VALUES ('3', '010', 'dc5c7986daef50c1e02ab09b442ee34f', '鲁艾弈', '1', '330327198615482633', '13159863241', '', '创作者', '2024-03-03 14:25:36');
INSERT INTO `chuangzuozhe` VALUES ('4', '017', 'dc5c7986daef50c1e02ab09b442ee34f', '梅西', '0', '330327198805060222', '13623256544', '', '创作者', '2024-03-03 14:25:36');
INSERT INTO `chuangzuozhe` VALUES ('5', '022', 'dc5c7986daef50c1e02ab09b442ee34f', '伍兆斌', '1', '33032719900723568X', '17505772420', '', '创作者', '2024-03-03 14:25:36');
INSERT INTO `chuangzuozhe` VALUES ('6', '029', 'dc5c7986daef50c1e02ab09b442ee34f', '霍建华', '0', '330327199010142546', '13587835380', '', '创作者', '2024-03-03 14:25:36');
INSERT INTO `chuangzuozhe` VALUES ('7', '019', 'dc5c7986daef50c1e02ab09b442ee34f', '袁庆轩', '0', '330327198501020300', '13052154877', '', '创作者', '2024-03-03 14:25:36');
INSERT INTO `chuangzuozhe` VALUES ('8', '008', 'dc5c7986daef50c1e02ab09b442ee34f', '马庆炳', '1', '330327198406150488', '13748589658', '', '创作者', '2024-03-03 14:25:36');
INSERT INTO `chuangzuozhe` VALUES ('9', '018', 'dc5c7986daef50c1e02ab09b442ee34f', '李大汉', '1', '330327199005060003', '13489665487', '', '创作者', '2024-03-03 14:25:36');
INSERT INTO `chuangzuozhe` VALUES ('10', '007', 'dc5c7986daef50c1e02ab09b442ee34f', '方之明', '1', '330327198708070789', '13544655202', '', '创作者', '2024-03-03 14:25:36');
INSERT INTO `chuangzuozhe` VALUES ('11', '001', 'dc5c7986daef50c1e02ab09b442ee34f', '杨颖', '1', '330327198811020456', '13186835580', '', '创作者', '2024-03-03 14:25:36');

-- ----------------------------
-- Table structure for `collect`
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `shangpinxinxiID` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of collect
-- ----------------------------

-- ----------------------------
-- Table structure for `fasonglepu`
-- ----------------------------
DROP TABLE IF EXISTS `fasonglepu`;
CREATE TABLE `fasonglepu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lepubianhao` varchar(50) DEFAULT NULL,
  `lepumingcheng` varchar(50) DEFAULT NULL,
  `lepuleibie` varchar(50) DEFAULT NULL,
  `chuangzuoren` varchar(50) DEFAULT NULL,
  `goumairen` varchar(50) DEFAULT NULL,
  `lepuchuansong` varchar(50) DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of fasonglepu
-- ----------------------------
INSERT INTO `fasonglepu` VALUES ('2', '33474087902381', 'R乐谱', '六线谱', '001', '001', null, '2024-03-03 18:10:05');

-- ----------------------------
-- Table structure for `file`
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `originName` varchar(255) DEFAULT NULL,
  `fileName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of file
-- ----------------------------
INSERT INTO `file` VALUES ('1', 'bht1.jpg', 'bht1.jpg');
INSERT INTO `file` VALUES ('2', 'bht2.jpg', 'bht2.jpg');
INSERT INTO `file` VALUES ('3', 'bht3.jpg', 'bht3.jpg');
INSERT INTO `file` VALUES ('4', 'bht4.jpg', 'bht4.jpg');
INSERT INTO `file` VALUES ('5', 'bht5.jpg', 'bht5.jpg');
INSERT INTO `file` VALUES ('16', 'aihaozhe1.jpg', 'aihaozhe1.jpg');
INSERT INTO `file` VALUES ('17', 'aihaozhe2.jpg', 'aihaozhe2.jpg');
INSERT INTO `file` VALUES ('18', 'aihaozhe3.jpg', 'aihaozhe3.jpg');
INSERT INTO `file` VALUES ('19', 'aihaozhe4.jpg', 'aihaozhe4.jpg');
INSERT INTO `file` VALUES ('20', 'aihaozhe5.jpg', 'aihaozhe5.jpg');
INSERT INTO `file` VALUES ('21', 'aihaozhe6.jpg', 'aihaozhe6.jpg');
INSERT INTO `file` VALUES ('22', 'aihaozhe7.jpg', 'aihaozhe7.jpg');
INSERT INTO `file` VALUES ('23', 'aihaozhe8.jpg', 'aihaozhe8.jpg');
INSERT INTO `file` VALUES ('24', 'aihaozhe9.jpg', 'aihaozhe9.jpg');
INSERT INTO `file` VALUES ('25', 'aihaozhe10.jpg', 'aihaozhe10.jpg');
INSERT INTO `file` VALUES ('26', 'chuangzuozhe1.jpg', 'chuangzuozhe1.jpg');
INSERT INTO `file` VALUES ('27', 'chuangzuozhe2.jpg', 'chuangzuozhe2.jpg');
INSERT INTO `file` VALUES ('28', 'chuangzuozhe3.jpg', 'chuangzuozhe3.jpg');
INSERT INTO `file` VALUES ('29', 'chuangzuozhe4.jpg', 'chuangzuozhe4.jpg');
INSERT INTO `file` VALUES ('30', 'chuangzuozhe5.jpg', 'chuangzuozhe5.jpg');
INSERT INTO `file` VALUES ('31', 'chuangzuozhe6.jpg', 'chuangzuozhe6.jpg');
INSERT INTO `file` VALUES ('32', 'chuangzuozhe7.jpg', 'chuangzuozhe7.jpg');
INSERT INTO `file` VALUES ('33', 'chuangzuozhe8.jpg', 'chuangzuozhe8.jpg');
INSERT INTO `file` VALUES ('34', 'chuangzuozhe9.jpg', 'chuangzuozhe9.jpg');
INSERT INTO `file` VALUES ('35', 'chuangzuozhe10.jpg', 'chuangzuozhe10.jpg');
INSERT INTO `file` VALUES ('36', '1.jpg', '11709447832365.jpg');
INSERT INTO `file` VALUES ('37', '2.jpg', '21709448186532.jpg');
INSERT INTO `file` VALUES ('38', '3.jpg', '31709448190198.jpg');
INSERT INTO `file` VALUES ('39', '4.jpg', '41709448193289.jpg');
INSERT INTO `file` VALUES ('40', '5.jpg', '51709448196659.jpg');
INSERT INTO `file` VALUES ('41', '2.jpg', '21709454179101.jpg');
INSERT INTO `file` VALUES ('42', 'lepuxinxi1.jpg', 'lepuxinxi1.jpg');
INSERT INTO `file` VALUES ('43', 'lepuxinxi2.jpg', 'lepuxinxi2.jpg');
INSERT INTO `file` VALUES ('44', 'lepuxinxi3.jpg', 'lepuxinxi3.jpg');
INSERT INTO `file` VALUES ('45', 'lepuxinxi4.jpg', 'lepuxinxi4.jpg');
INSERT INTO `file` VALUES ('46', 'lepuxinxi5.jpg', 'lepuxinxi5.jpg');
INSERT INTO `file` VALUES ('47', 'lepuxinxi6.jpg', 'lepuxinxi6.jpg');
INSERT INTO `file` VALUES ('48', 'lepuxinxi7.jpg', 'lepuxinxi7.jpg');
INSERT INTO `file` VALUES ('49', 'lepuxinxi8.jpg', 'lepuxinxi8.jpg');
INSERT INTO `file` VALUES ('50', 'lepuxinxi9.jpg', 'lepuxinxi9.jpg');
INSERT INTO `file` VALUES ('51', 'lepuxinxi10.jpg', 'lepuxinxi10.jpg');
INSERT INTO `file` VALUES ('52', 'R-C.jpg', 'R-C1709460569846.jpg');
INSERT INTO `file` VALUES ('53', 'R-C (1).jpg', 'R-C (1)1709466027670.jpg');
INSERT INTO `file` VALUES ('54', 'R-C.jpg', 'R-C1709466045443.jpg');

-- ----------------------------
-- Table structure for `goumai`
-- ----------------------------
DROP TABLE IF EXISTS `goumai`;
CREATE TABLE `goumai` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lepubianhao` varchar(50) DEFAULT NULL,
  `lepumingcheng` varchar(50) DEFAULT NULL,
  `lepuleibie` varchar(50) DEFAULT NULL,
  `jiage` varchar(50) DEFAULT NULL,
  `chuangzuoren` varchar(50) DEFAULT NULL,
  `goumairen` varchar(50) DEFAULT NULL,
  `issh` varchar(10) DEFAULT '0',
  `iszf` varchar(10) DEFAULT '否',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of goumai
-- ----------------------------
INSERT INTO `goumai` VALUES ('2', '33381781208638', 'C乐谱', 'N类别', '32', '006', '010', '0', '是', '2024-03-03 14:25:36');
INSERT INTO `goumai` VALUES ('3', '33386998552861', 'J乐谱', 'D类别', '33', '005', '009', '0', '是', '2024-03-03 14:25:36');
INSERT INTO `goumai` VALUES ('4', '33381793791928', 'R乐谱', 'K类别', '42', '008', '003', '0', '是', '2024-03-03 14:25:36');
INSERT INTO `goumai` VALUES ('5', '33385827060842', 'D乐谱', 'L类别', '42', '023', '011', '0', '是', '2024-03-03 14:25:36');
INSERT INTO `goumai` VALUES ('6', '33385827060842', 'D乐谱', 'L类别', '42', '023', '025', '0', '是', '2024-03-03 14:25:36');
INSERT INTO `goumai` VALUES ('7', '33387437338500', 'Y乐谱', 'B类别', '33', '014', '002', '0', '是', '2024-03-03 14:25:36');
INSERT INTO `goumai` VALUES ('8', '33381793791928', 'R乐谱', 'K类别', '42', '008', '004', '0', '是', '2024-03-03 14:25:36');
INSERT INTO `goumai` VALUES ('9', '33387194344015', 'M乐谱', 'H类别', '58', '013', '023', '0', '是', '2024-03-03 14:25:36');
INSERT INTO `goumai` VALUES ('10', '33381793791928', 'R乐谱', 'K类别', '42', '008', '030', '0', '是', '2024-03-03 14:25:36');
INSERT INTO `goumai` VALUES ('11', '33385910967896', 'E乐谱', 'C类别', '61', '003', '001', '0', '是', '2024-03-03 14:25:36');
INSERT INTO `goumai` VALUES ('12', '33474087902381', 'R乐谱', '六线谱', '97', '001', '001', '1', '是', '2024-03-03 18:00:37');

-- ----------------------------
-- Table structure for `guanliyuan`
-- ----------------------------
DROP TABLE IF EXISTS `guanliyuan`;
CREATE TABLE `guanliyuan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `yonghuming` varchar(50) DEFAULT NULL,
  `mima` varchar(50) DEFAULT NULL,
  `status` varchar(10) DEFAULT '0',
  `level` varchar(10) DEFAULT '管理员',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of guanliyuan
-- ----------------------------
INSERT INTO `guanliyuan` VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3', '0', '管理员', '2024-03-03 14:25:36');

-- ----------------------------
-- Table structure for `lepuleibie`
-- ----------------------------
DROP TABLE IF EXISTS `lepuleibie`;
CREATE TABLE `lepuleibie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `leibiemingcheng` varchar(50) DEFAULT NULL,
  `leibiejieshao` varchar(50) DEFAULT NULL,
  `shiyongleqi` varchar(50) DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of lepuleibie
-- ----------------------------
INSERT INTO `lepuleibie` VALUES ('2', '吉他谱', '吉他谱即指弹奏吉他的记谱方法，包括\"六线谱\"、\"五线谱\"和\"简谱\"等。其中六线谱属记录指法的乐谱，', '吉他', '2024-03-03 14:25:36');
INSERT INTO `lepuleibie` VALUES ('3', '其他自己修改一下', '其他自己修改一下', '其他自己修改一下', '2024-03-03 14:25:36');
INSERT INTO `lepuleibie` VALUES ('4', '图片自己去添加一下', '图片自己去添加一下', '图片自己去添加一下', '2024-03-03 14:25:36');
INSERT INTO `lepuleibie` VALUES ('5', '关于创作者和爱好者', '界面相同,但是功能是不一样的', '', '2024-03-03 14:25:36');
INSERT INTO `lepuleibie` VALUES ('6', 'R类别', '', '', '2024-03-03 14:25:36');
INSERT INTO `lepuleibie` VALUES ('7', 'H类别', '', '', '2024-03-03 14:25:36');
INSERT INTO `lepuleibie` VALUES ('8', 'N类别', '', '', '2024-03-03 14:25:36');
INSERT INTO `lepuleibie` VALUES ('9', 'B类别', '', '', '2024-03-03 14:25:36');
INSERT INTO `lepuleibie` VALUES ('10', 'K类别', '', '', '2024-03-03 14:25:36');
INSERT INTO `lepuleibie` VALUES ('11', 'M类别', '', '', '2024-03-03 14:25:36');

-- ----------------------------
-- Table structure for `lepuxinxi`
-- ----------------------------
DROP TABLE IF EXISTS `lepuxinxi`;
CREATE TABLE `lepuxinxi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lepubianhao` varchar(50) DEFAULT NULL,
  `lepumingcheng` varchar(50) DEFAULT NULL,
  `lepufenlei` varchar(50) DEFAULT NULL,
  `leqi` varchar(50) DEFAULT NULL,
  `lepujieshao` varchar(500) DEFAULT NULL,
  `jiage` varchar(50) DEFAULT NULL,
  `leputu` varchar(50) DEFAULT NULL,
  `chuangzuoren` varchar(50) DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of lepuxinxi
-- ----------------------------
INSERT INTO `lepuxinxi` VALUES ('12', '202403033558', '吉他谱', '六线谱', '吉他', '吉他', '111', '/files/download/53', '001', '2024-03-03 19:40:28');
INSERT INTO `lepuxinxi` VALUES ('13', '202403034099', '钢琴', '五线谱', '钢琴', '钢琴', '333', '/files/download/54', '001', '2024-03-03 19:40:45');

-- ----------------------------
-- Table structure for `liuyanban`
-- ----------------------------
DROP TABLE IF EXISTS `liuyanban`;
CREATE TABLE `liuyanban` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `yonghuming` varchar(50) DEFAULT NULL,
  `cheng` varchar(50) DEFAULT NULL,
  `touxiang` varchar(50) DEFAULT NULL,
  `biaoti` varchar(50) DEFAULT NULL,
  `neirong` varchar(500) DEFAULT NULL,
  `huifu` varchar(500) DEFAULT NULL,
  `status` varchar(10) DEFAULT '0',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `parent` int(11) DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of liuyanban
-- ----------------------------

-- ----------------------------
-- Table structure for `pinglun`
-- ----------------------------
DROP TABLE IF EXISTS `pinglun`;
CREATE TABLE `pinglun` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pinglunneirong` varchar(500) DEFAULT NULL,
  `pingfen` varchar(50) DEFAULT NULL,
  `biao` varchar(50) DEFAULT NULL,
  `pinglunren` varchar(50) DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `shujuid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of pinglun
-- ----------------------------

-- ----------------------------
-- Table structure for `tiezi`
-- ----------------------------
DROP TABLE IF EXISTS `tiezi`;
CREATE TABLE `tiezi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `suoshubankuai` varchar(50) DEFAULT NULL,
  `biaoti` varchar(50) DEFAULT NULL,
  `neirong` varchar(500) DEFAULT NULL,
  `leixing` varchar(50) DEFAULT NULL,
  `fujian` varchar(50) DEFAULT NULL,
  `fatieren` varchar(50) DEFAULT NULL,
  `fid` varchar(50) DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dianzan` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of tiezi
-- ----------------------------
INSERT INTO `tiezi` VALUES ('34', '2', 'greh', 'erherjreje', 'tuijian', null, '001', '0', '2024-01-06 15:04:11', '0');
INSERT INTO `tiezi` VALUES ('35', '2', 'rtrtj', 'rtktrkr', 'qiuzhu', null, '001', '0', '2024-01-06 15:04:52', '0');

-- ----------------------------
-- Table structure for `xinwentongzhi`
-- ----------------------------
DROP TABLE IF EXISTS `xinwentongzhi`;
CREATE TABLE `xinwentongzhi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `biaoti` varchar(50) DEFAULT NULL,
  `leibie` varchar(50) DEFAULT NULL,
  `neirong` longtext,
  `dianjilv` varchar(50) DEFAULT NULL,
  `dianzan_d` int(11) DEFAULT '0',
  `dianzan_c` int(11) DEFAULT '0',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of xinwentongzhi
-- ----------------------------
INSERT INTO `xinwentongzhi` VALUES ('10', '王昌荣出席市委政法委全体会议', '公告', '<P>　　7月3日，市委政法委全体会议暨今年第三次政法工作例会在市检察院召开。市委副书记、政法委书记王昌荣在会上强调，当前维护社会和谐稳定工作的任务依然繁重，下半年政法维稳工作形势依然严峻，全市政法各部门要结合实际工作，多措并举，标本兼治，狠抓落实，确保社会平安和谐稳定。</P>\r\n<P>　　会上，市检察院、市委政法委、市中院、市公安局、市司法局、市信访局等单位汇报了上半年工作情况及近期重点工作安排，并交流了队伍建设特别是政法干警核心价值观教育实践活动开展情况。同时，会议还解读了《2012年平安市、县（市、区）考核办法、评审条件》，对照往年评审标准，对细节改动和变化进行学习探讨。</P>\r\n<P>　　王昌荣说，党的十八大即将于今年十月份召开。做好十八大期间的安保工作，是一项重大政治任务。政法各部门要紧盯“不出大事”这个底线，排查各条线不稳定因素，加强稳控，严密防范，妥善处置，全力打赢十八大安保工作这场硬仗。要紧盯“四连创”这条主线，深化认识，常抓不懈，做好平安创建工作，不断提升群众安全感满意度。要紧盯基层基础建设这个关键，突出抓牢重点项目建设，强化外来人口服务管理，在加强和创新社会管理方面迈出实质性的一步。要紧盯队伍建设这个根本，从严治警、从优待警，打造对党对组织忠诚，有中心大局意识的领导班子和干警队伍。</P>\r\n<P>　　市委常委吴开锋出席会议。市委常委、公安局长黄宝坤，市人民检察院检察长金连山等汇报交流工作情况。</P>\r\n<META name=ContentEnd><!--ZJEG_RSS.content.end--><!--<$[信息内容]>end-->', '25', '0', '0', '2024-03-03 14:25:36');
INSERT INTO `xinwentongzhi` VALUES ('11', '“全球眼”助工地安全生产', '公告', '<P>　　春节将至，建筑工程的安全生产牵动人心。昨日（1月28日），记者随同市检查组到我市多个建筑工地检查时发现，新安装的建筑工地远程视频监控系统“全球眼”已经发挥功效，它通过摄像头将视频传输到“数字城管”信息平台，对工地施工情况进行实时监控。 </P>\r\n<P>　　昨日，副市长章方璋带领市住建、规划等部门，到市自来水公司、市管道燃气公司以及国脉大楼和中环商住广场的建设工地进行安全检查。此次检查突出我市重点市政工程、重点建设项目等各类在建施工工程的安全管理，并排查重大建筑设备运行和危险性较大工程施工隐患情况。</P>\r\n<P>　　在市自来水公司，检查组依次查看了东向水厂的原水池、沉淀池、过滤池，要求加强监管，保障居民的安全用水。据了解，公司就节日值班、设备检修、红外线警戒等工作做好了相应准备措施。在市管道燃气公司，工作人员就年初发生的几起管道燃气爆炸、泄漏事件作了汇报，表示将总结经验教训，保证居民生命和财产安全。</P>\r\n<P>　　在国脉大楼和中环商住广场的建设工地，施工现场均悬挂了重大危险源公示牌、安全警示牌。检查组详细了解项目进展情况，并要求对塔吊安全、建筑泥浆等督查中发现的问题进行认真落实。建筑工地在春节期间施工，尤其要做好安全生产和管理，严防建筑施工安全生产事故，营造安全放心的过节环境。</P></FOUNDER-CONTENT>\r\n<META name=ContentEnd><!--ZJEG_RSS.content.end--><!--<$[信息内容]>end-->', '60', '0', '0', '2024-03-03 14:25:36');
INSERT INTO `xinwentongzhi` VALUES ('12', '钱库紧抓重点深入推进“清剿火患”战役', '公告', '<P>&nbsp;&nbsp;&nbsp; 为了深入推进“清剿火患”工作，继续深化安全生产年活动，11月18日，钱库镇召开望里办事处安全生产工作座谈会，钱库镇主要领导、县安监局、望里办事处24个村居书记、主任、企业主会聚一堂，对安全生产工作进行了回顾总结，并各抒己见、建言献策。</P>\r\n<P>&nbsp;&nbsp;&nbsp; 截止10月底，该镇共发生各类事故1013起，其中望里559起；直接经济损失1300万元，其中望里868万元；火灾事故484起，其中望里办事处373起。从事故总体情况来看，事故起数和死亡人数上升幅度较大，直接经济损失上升幅度较大，安全生产形势不容乐观。目前钱库被列为温州市26个重点火灾隐患挂牌单位之一，望里又是钱库的事故多发区，虽然“清剿火患”决心大、力度强、措施多，但依然面对事故高位运行、严重后果事故有所抬头的情况。会议分析了事故原因以及存在问题，并提出了下一阶段的工作设想。各与会者也纷纷表态，提出了改变产业“低、小、散”状况，加大培训、执法力度、重点清查线路问题等建议。钱库镇镇长杨雷提出了出租房消防设施4要件配备、木质楼梯3楼以上不住人，“三合一”企业必须生产、生活区分开等具体要求，并强调，安全生产重在预防、重在落实，必须消除侥幸心理，全力排除火灾隐患，确保“清剿火患”工作取得成效。(颜鸯鸯&nbsp; 缪克梯 叶继来)<BR></P>', '54', '0', '0', '2024-03-03 14:25:36');
INSERT INTO `xinwentongzhi` VALUES ('13', '钱库户外登山俱乐部成立（图）', '公告', '<TABLE cellSpacing=20 cellPadding=0 align=center>\r\n<TBODY>\r\n<TR align=middle>\r\n<TD><IMG src=\"http://pic2.66wz.com/0/10/36/82/10368259_475646.jpg\" border=0></TD></TR></TBODY></TABLE>\r\n<P>&nbsp;&nbsp;&nbsp; 1月23日消息：1月22日，钱库户外登山俱乐部成立，有100多名爱好登山者参加了成立大会。图为钱库镇有关领导为该俱乐部授牌。（王晟/摄）</P>', '98', '0', '0', '2024-03-03 14:25:36');
INSERT INTO `xinwentongzhi` VALUES ('14', '人才驱动升级中国第一资源 国家升级首先是人才', '公告', '<DIV id=artbody class=artCon><!--enpcontent-->\r\n<P align=center><IMG style=\"WIDTH: 400px; HEIGHT: 198px\" id=22914853 title=\"\" border=0 align=center src=\"http://images.china.cn/attachement/jpg/site1000/20130729/002564ba9eb8135ff2b806.jpg\" md5=\"\" sourcedescription=\"编辑提供的本地文件\" sourcename=\"本地文件\"></P>\r\n<P style=\"TEXT-INDENT: 30px; MARGIN: 0px 3px 15px\">6月28日，中国海外学子创业周在辽宁大连世界博览广场举行。王锡增摄（新华社发）</P>\r\n<P style=\"TEXT-INDENT: 30px; MARGIN: 0px 3px 15px\">升级中国靠什么驱动？</P>\r\n<P style=\"TEXT-INDENT: 30px; MARGIN: 0px 3px 15px\">对于这个话题，本报已经连续用9篇文章来论述：理想驱动、目标驱动、问题驱动、改革驱动、创新驱动、转型驱动、法治驱动、公平驱动、务实驱动。</P>\r\n<P style=\"TEXT-INDENT: 30px; MARGIN: 0px 3px 15px\">而以上9种驱动的生成和实现，不会凭空而来，归根结底要靠人，靠人才。从某种意义上说，人才是国家升级的第一资源、第一要素。国家升级，首先是人才升级。</P>\r\n<P style=\"TEXT-INDENT: 30px; MARGIN: 0px 3px 15px\"><STRONG>第一资源 第一要素</STRONG></P>\r\n<P style=\"TEXT-INDENT: 30px; MARGIN: 0px 3px 15px\">在当下中国，最大的“升级”是中华民族的伟大复兴。中华民族复兴靠什么？习近平总书记给出了答案――7月21日下午，在考察武汉东湖国家自主创新示范区暨“中国光谷”时，习近平总书记说：“中华民族复兴靠什么？靠核心竞争力，其中关键是靠创新。实现这个目标，就要改革科技体制，培养和吸引人才。”</P>\r\n<P style=\"TEXT-INDENT: 30px; MARGIN: 0px 3px 15px\">早在4年前的第四届全国杰出专业技术人才表彰大会上，时任国家副主席的习近平即强调，“要深刻认识人才在我国经济社会发展中的重要作用，牢固树立人才资源是第一资源的理念。”</P>\r\n<P style=\"TEXT-INDENT: 30px; MARGIN: 0px 3px 15px\">所有的升级，人才是第一资源、第一要素。这一认知，多年来中国党和政府一以贯之。</P>\r\n<P style=\"TEXT-INDENT: 30px; MARGIN: 0px 3px 15px\"><STRONG>关键在干部 关键在高端</STRONG></P>\r\n<P style=\"TEXT-INDENT: 30px; MARGIN: 0px 3px 15px\">党员领导干部是各类人才中的关键成分；高层次人才、顶尖人才，则是各国各地争夺的对象。</P>\r\n<P style=\"TEXT-INDENT: 30px; MARGIN: 0px 3px 15px\">6月底召开的全国组织工作会议上，习近平强调，实现党的十八大确定的各项目标任务，关键在党，关键在人。其中“关键在人”，即是要建设一支宏大的高素质干部队伍。</P>\r\n<P style=\"TEXT-INDENT: 30px; MARGIN: 0px 3px 15px\">为保证“升级中国”顺利达成，中国对干部提出新标准：“既看发展又看基础，既看显绩又看潜绩，把民生改善、社会进步、生态效益等指标和实绩作为重要考核内容，再也不能简单以国内生产总值增长率来论英雄了。”</P>\r\n<P style=\"TEXT-INDENT: 30px; MARGIN: 0px 3px 15px\">我国已成为第一人力资源大国，但是人才队伍的规模、结构和素质等，与先进国家差距还比较大，还不能适应中国发展的需要，特别是高层次创新型人才匮乏、创新创业能力不强、人才结构和布局不尽合理等等。此外，我国流失的顶尖人才数量居世界首位。</P>\r\n<P style=\"TEXT-INDENT: 30px; MARGIN: 0px 3px 15px\"><STRONG>培养吸引 更要尊重关心</STRONG></P>\r\n<P style=\"TEXT-INDENT: 30px; MARGIN: 0px 3px 15px\">习近平强调，好干部不会自然而然产生。同样，高端人才也不会自动产生，需要培养、吸引。在美国，靠“三绿”吸引全球最高端人才，即绿卡、绿色钞票、绿色环境。</P>\r\n<P style=\"TEXT-INDENT: 30px; MARGIN: 0px 3px 15px\">在中国，为培养和引进人才各地均有招数。如，“安徽芜湖市引进领军人才购房最高补贴50万”、“广州成立国内首家地方人才工作局”、“江苏上半年引进3000名海外留学人才”、“田阳首批农村乡土拔尖人才获命名表彰”……</P>\r\n<P style=\"TEXT-INDENT: 30px; MARGIN: 0px 3px 15px\">“中国不缺人，但是缺人才特别是高层次人才。”7月26日，法国《欧洲时报》网站这样评论。</P>\r\n<P style=\"TEXT-INDENT: 30px; MARGIN: 0px 3px 15px\">为适应引智引资需要，中国新的出入境管理法，首次将“人才引进”纳入外国人普通签证申请事由，并增设R字（人才类）签证，发给国家需要的外国高层次人才和急需紧缺专门人才，并给予相应的出入境便利。</P>\r\n<P style=\"TEXT-INDENT: 30px; MARGIN: 0px 3px 15px\">近些年，中国持之以恒地推进“千人计划”，吸引海外高层次人才为中国的发展服务。</P>\r\n<P style=\"TEXT-INDENT: 30px; MARGIN: 0px 3px 15px\">培养、吸引人才，更要尊重、关心人才。近年，每到酷暑，中国北方的避暑胜地北戴河会迎来一批特殊的游客――参加暑期休假活动的优秀专家和基层一线人才，他们是由国家统一邀请的。</P>\r\n<P style=\"TEXT-INDENT: 30px; MARGIN: 0px 3px 15px\">“懂人才是大学问，聚人才是大本事，用人才是大智慧。”习近平两年前在吉林调研时，曾语重心长地告诫领导干部。(记者 陈振凯)</P><!--/enpcontent--></DIV>', '40', '0', '0', '2024-03-03 14:25:36');
INSERT INTO `xinwentongzhi` VALUES ('15', '陈金彪：打造独具温州特色的支柱产业', '公告', '<P>　　“温州今后将重点培育发展哪几大新兴产业？传统主导产业改造提升的务实路径何在？”围绕这两大命题，市委副书记、市长陈金彪在反复调研的基础上，11月19日再次组织召开专题会议，讨论研究、初步论证有关政策文件。</P>\r\n<P>　　历经前期多轮修改完善，市发改委、市经信委分别向会议提交了《关于加快培育发展温州重大新兴产业的指导意见（<SPAN style=\"FONT-FAMILY: 楷体, 楷体_GB2312\"><FONT face=\"\">征求意见稿</FONT></SPAN>）》《关于加快块状经济向现代产业集群转型升级实施意见（<SPAN style=\"FONT-FAMILY: 楷体, 楷体_GB2312\"><FONT face=\"\">征求意见稿</FONT></SPAN>）》，并就起草过程作了有关说明。针对政策文件涉及的产业门类、重点项目、产业布局、实现路径、运行机制和发展目标等问题，大家展开讨论并给出不少建设性意见。</P>\r\n<P>　　据悉，紧密结合我市当前产业基础和比较优势，遵循关联性大、带动性强、差异化发展原则，我市初步确定临港石化、通用航空、激光与光电等重大新兴产业作为我市当前及今后一个时期重大新兴产业培育的重点领域。以提升产业竞争力和价值链为目标，以重点产业集聚区和小微企业创业园为依托，着力加快电气、汽摩配、鞋服、泵阀等几大传统主导产业向现代产业集群转型升级。</P>\r\n<P>　　在认真听取各方意见后，陈金彪说：“培育发展新兴产业的设想无疑是诱人的，多方意见值得吸收采纳，可是转型发展贵在行动，‘喊破嗓子不如甩开膀子’。我们要务实着眼，找准切口，攻坚突破，大力培育发展重大新兴产业，推动传统产业群向现代产业集群转型。”</P>\r\n<P>　　陈金彪强调，要做深做细产业链补链、服务链配套文章，把基础产业做实、把支撑产业做全，着力打造“引不走”的产业集群，使温州特色支柱产业立于不败之地。要强化空间支撑，让产业发展与规划、土地保障实现无缝对接。要加强组织领导，由市四套班子领导牵头分别组成推进领导小组，强化综合协调、重大决策、重大项目及配套措施的督促落实，不断完善工作机制，量身定做细化方案，逐个加以推进实施。要以大项目引进作为突破口，以温商和台商、央企为主要对象开展主动招商，着力培育一批重大新兴产业，为实体经济振兴和产业转型升级提供有力支撑。</P>', '72', '0', '0', '2024-03-03 14:25:36');
INSERT INTO `xinwentongzhi` VALUES ('16', '我市三个现代农业园区升为“省级”', '公告', '　&nbsp; 我市又有三个现代农业园区升为“省级”，它们分别是苍南县金乡獭兔精品园、文成县平和茶叶精品园、瓯海区泽雅瓯柑精品园。截至目前，我市的省级现代农业精品园区已达6个。\r\n<P>　　由省农业厅组织省、市有关部门专家组成的验收组，对照《浙江省特色农业精品园建设标准》，对苍南县金乡獭兔精品园、文成县平和茶叶精品园、瓯海区泽雅瓯柑精品园进行实地考核验收。经过省级现代农业精品园区的创建，苍南县金乡獭兔精品园对4万多个养殖笼位进行了标准化的改建，新建3000平方米5000笼位的水帘降温封闭式兔舍、增铺污水管网设施1万米待标准化生产；在文成县平和茶叶精品园，通过创建基地共建设了茶园面积1582亩，安装频振式杀虫灯65盏，维修蓄水池350立方米，修建喷灌设施878亩，引进和推广茶叶加工设备70台，繁育和推广4个茶树良种，自研开发成功九龙顶名优绿茶等建设；在瓯海区泽雅瓯柑精品园创建中，该基地共建成了游步道20000米，山地喷滴灌设施500亩，新建瓯柑储藏通风库设施4座，新增自动化柑橘选果机4台，项目区实际实施面积1140亩，2010年基地实现瓯柑总产量2200吨，综合效益明显。验收组成员认定，三个精品园符合省级现代农业园区建设标准。</P>\r\n<META name=ContentEnd><!--ZJEG_RSS.content.end--><!--<$[信息内容]>end-->', '65', '0', '0', '2024-03-03 14:25:36');
INSERT INTO `xinwentongzhi` VALUES ('17', '土耳其东部地震死亡人数超过100人', '公告', '&nbsp;&nbsp;&nbsp;&nbsp; 新华网安卡拉１０月２３日电（记者郑金发　戚燕凌）据土耳其道安通讯社２３日报道，到目前为止，土耳其东部凡省地震造成的死亡人数已经超过１００人，另有３６６人被埋在废墟下。\r\n<P>&nbsp;&nbsp;&nbsp;&nbsp;目前，土耳其已有３８个省出动１２７５个地震救灾小组前往凡省地震灾区积极开展营救，在地震灾区已有１４５辆救护车和５００名医务人员。土耳其军队也派出６个营的兵力前往地震灾区援助救灾工作。</P>\r\n<P>&nbsp;&nbsp;&nbsp;&nbsp;据土耳其伊斯坦布尔地震研究中心报告，当地时间２３日１３时４１分（北京时间１８时４１分），凡省发生里氏７．２级地震，震中位于和伊朗接壤的凡省塔巴利村，震源深度５公里。</P>\r\n<P>&nbsp;&nbsp;&nbsp;&nbsp;据土耳其ＮＴＶ电视台报道，土耳其东部凡省当地时间２３时４５分（北京时间２４日４时４５分）又发生了里氏５．７级地震。但据美国地质勘探局地震信息网消息，土耳其此次地震为里氏６级，震源深度９．８公里。</P>\r\n<P>&nbsp;&nbsp;&nbsp;&nbsp;土耳其是一个地震多发国家。１９９９年，土耳其西北部地区曾连续发生两次大地震，造成约１．８万人死亡。</P>', '81', '0', '0', '2024-03-03 14:25:36');
INSERT INTO `xinwentongzhi` VALUES ('18', '2011年温州市各级机关考试录用公务员（村干部、紧缺职位）进入体检人员名单（1416人）', '公告', '<LI>下载附件： \r\n<LI><A href=\"http://www.wzrc.net/upload/2011/4/43f07720-d978-4006-b60a-f30dae932947.xls\">2011年温州市公务员考录入围体检名单</A> </LI>', '13', '0', '0', '2024-03-03 14:25:36');
INSERT INTO `xinwentongzhi` VALUES ('19', '我县禁毒工作迎“市考” “瘾君子”连续六年负增长', '公告', '&nbsp;&nbsp;&nbsp; 1月6日消息：今昨两天，市禁毒工作考核组来苍考核检查2010年禁毒工作。考核组随机抽取了灵溪、龙港两镇进行检查，经过听取汇报、查阅台账、实地走访，对我县2010年禁毒工作进行了全面、细致的检查。县委常委、常务副县长邱华萍、县人大常委会副主任陈孝沈参加汇报会。\r\n<P>&nbsp;&nbsp;&nbsp; 去年，我县禁毒形势持续好转，禁毒打击工作受到了省公安厅和公安部禁毒局的褒奖。截至去年12月22日，全县完成移诉毒品犯罪嫌疑人142名，查处涉毒场所案件4起，未发生涉毒场所不依法处罚或处罚执行不到位情况。目前全县已有龙港和金乡美沙酮门诊部2家，前三季度稳定参加治疗平均数为179名。到去年为止，我县累计戒断巩固3年以上（脱毒）人员 1053名，连续6年以上实现了实有吸毒成瘾人员负增长。</P><!--advertisement code begin--><!--advertisement code end-->\r\n<P>&nbsp;&nbsp;&nbsp; 听取汇报后，考核组充分肯定了我县禁毒工作，认为我县2010年禁毒工作措施有效、打击有力、宣传到位，圆满完成了年初市里下达的目标和要求。同时希望我县认真落实禁毒措施，继续加强乡镇基层基础建设，提高各职能部门协同作战的能力，以更大的决心和力度，不断推动禁毒工作取得新进展和新成效。（简宁静 温加俏）</P>', '42', '0', '0', '2024-03-03 14:25:36');
INSERT INTO `xinwentongzhi` VALUES ('20', '电影《奔向大海》在温州开机', '公告', '&nbsp;&nbsp;&nbsp; 温州市委宣传部、温州市广电集团电视剧制作中心、龙湾城市中心区开发建设指挥部、温州民间资本投资服务中心联合拍摄的电影《奔向大海》将于2月20日在温州开机。 \r\n<P>　　这部青春励志片以温州90后战士周尚从叛逆冲动的城市单亲孩子，经历了军营的历练，蜕变成为一名优秀的解放军战士的经历为主线，讲述了几个来自不同家庭背景，各具性格与理想的90后少男少女们在青春期所经历的带有鲜明时代特点的故事，展现了90后新一代温州军人特有的风采。该片全部在温州拍摄，同时将展现文化温州、山水温州的独特魅力。将是一部融教育性和艺术性为一体的主旋律影片。影片中的多位角色也由温州本地演员出演。</P>\r\n<P>　　据市电视剧中心主任管红艳透露，温州市委宣传部、温州市广电集团电视剧制作中心近年来联合摄制的多部优秀影片如《村支书郑九万》、《一代大儒孙诒让》等都是用胶片技术拍摄，这次拍摄《奔向大海》则启用了最新的RED ONE 4K高清摄影机拍摄，这是目前数字电影的最高清晰度标准。 （迪安）</P>', '83', '0', '0', '2024-03-03 14:25:36');
INSERT INTO `xinwentongzhi` VALUES ('21', '我县召开浙台（苍南）经贸合作区联席会议', '公告', '<P>&nbsp;&nbsp;&nbsp; 苍南新闻网10月10日消息：今天下午，我县召开浙台（苍南）经贸合作区联席会议。县委书记黄寿龙强调，开展对台经贸合作是我县实现跨越发展可遇不可求的良机，各地各部门要增强信心、紧抓机遇、趁势而上，加快项目落地速度，全面推进对台招商引资各项工作。县领导董庆华、黄锦耀、陈国苗、林小同等参加会议。</P>\r\n<P>&nbsp;&nbsp;&nbsp; 据了解，我县充分利用浙洽会、中国国际投资贸易洽谈会及第二届海洋经济投资洽谈会等大型招商活动，大力提升浙台（苍南）经贸合作区的知名度。截止9月底，我县已相继接待台商考察团52批266人次，达成26个投资意向项目，其中包括对台客货直航、台货交易市场、海西生态观光度假农庄项目等在内的9个已相对成熟的台资项目，我县招商引资工作得到有效推进。</P><!--advertisement code begin--><!--advertisement code end-->\r\n<P>&nbsp;&nbsp;&nbsp; 黄寿龙在了解各项目的具体推进情况及存在的问题后指出，我县自去年6月29日浙台经贸合作区正式挂牌以来，做了大量的基础性工作，相关部门及负责领导对具体项目招引和推进十分重视，主动做好项目前期对接的跟踪、服务工作，并成立项目讲解团队，推进前期接洽工作，使台商对苍南留下了良好的“第一印象”。</P>\r\n<P>&nbsp;&nbsp;&nbsp; 黄寿龙指出，做好对台经贸合作项目，要认清“0”和“50”的关系，没有尝试就意味着0可能，而一旦尝试就有50%的成功率。因此，相关部门一定要解放思想、敢闯敢试，做到认真负责且注重效率，在工作中严把政策法律关，最大限度地用好上级部门对合作区开发建设方面的优惠政策，做到事前认真评审，事中认真服务，事后加紧监管。分管领导要主动牵头进行协调，项目洽谈要体现主动性，平台职责要切实理清，不断改善外商投资服务方式，既坚持原则，又灵活处理，特别是在当前要充分体谅外商面临的困难，进一步改善投资环境，以优质服务来增强竞争力和吸引力，只有这样，苍南才有可能闯出一条快速发展、人民致富的新路子。</P>\r\n<P>&nbsp;&nbsp;&nbsp; 黄寿龙强调，当前推进浙台经贸合作的首要任务，是要发挥“微波炉效应”，趁热打铁地推进项目早日落地，让台商在苍投资的热情“升温”、信心倍增。全县各部门在招商引资工作中要树立大局意识，相互协调、齐抓共管，通过沟通、协调，帮助解决项目推进中的难点问题，加速项目落地。招商引资项目责任单位及责任人要从项目洽谈、开工、建设、投产等全过程对项目进行跟踪服务，做好投产项目、在建项目帮办工作，争取项目增资提效，同时要保障“招商引资”企业的利益，确保企业引得进、留得下、长得大。此外，项目招引工作仍然不能懈怠，相关部门要以积极热情的态度迎接台商来苍考察，同时要保持底线，不能降低门槛，来者不拒，而要让更多优秀的项目进驻苍南。（记者 李静静 实习生 刘笑笑）</P>', '59', '0', '0', '2024-03-03 14:25:36');
INSERT INTO `xinwentongzhi` VALUES ('22', '碗窑重现“碇埠烟雨”景色（图）', '公告', '<TABLE cellSpacing=20 cellPadding=0 align=center>\r\n<TBODY>\r\n<TR align=middle>\r\n<TD><IMG src=\"http://pic2.66wz.com/0/10/39/94/10399427_234219.jpg\" border=0></TD></TR></TBODY></TABLE>\r\n<TABLE cellSpacing=20 cellPadding=0 align=center>\r\n<TBODY>\r\n<TR align=middle>\r\n<TD><IMG src=\"http://pic2.66wz.com/0/10/39/94/10399428_691515.jpg\" border=0></TD></TR></TBODY></TABLE>\r\n<P>&nbsp;&nbsp;&nbsp; “鱼鳞砌就不呼渡，雁齿排来不问津”。毛毛细雨里，游人行走其间，脚下溪水潺潺，山村细雨如烟，如入梦中。这是古人称赞桥墩碗窑碇埠头“碇埠烟雨”景色的诗句。</P><!--advertisement code begin--><!--advertisement code end-->\r\n<P>&nbsp;&nbsp;&nbsp; 90年代初期，一场洪水把建于清同治1872年间的132齿碇埠石冲得七零八落，“碇埠烟雨”景色从此在人们视野中消失。年初，经村中热心人士提议，当地商人赖时翰捐款20万元、林诚翰、黄成品各捐10万元，并在县旅游、文化部门的帮助下，共集资80余万元，重建“碇埠烟雨”景点。目前该景点已基本完工，古人诗句中的“碇埠烟雨”景色将在当今游人眼中重现。（朱建德/摄）</P>', '78', '0', '0', '2024-03-03 14:25:36');
INSERT INTO `xinwentongzhi` VALUES ('23', '我市商家称“问题血燕”已停货下架', '公告', '&nbsp;&nbsp;&nbsp;&nbsp; 买血燕，你可要多个心眼。省工商行政管理局昨天发布消息称，在其近日进行的流通领域食品质量例行抽检中发现，浙江市场上的血燕中亚硝酸盐含量严重超标，这些燕窝主要来自马来西亚，目前工商部门已对关联经销商展开立案调查。 \r\n<P>　　早前马来西亚媒体曾披露，一些不法商人用燕子粪便将廉价燕窝熏至血红色，当做血燕出售，而这种血燕含有超量的亚硝酸盐，食用后对健康危害极大。据有关人士统计，马来西亚大部分血燕销往中国。</P>\r\n<P>　<STRONG>　抽检血燕亚硝酸盐超标</STRONG></P>\r\n<P>　　省工商部门在对491家血燕经销商进行的537个批次的血燕抽检中发现，涉及的“问题血燕”达20万克，3万多盏。已出具的303个批次的检测报告结果显示，血燕亚硝酸盐含量偏高，其中广东鹰皇参茸制品有限公司的“鹰皇”牌血燕、厦门市丝浓食品有限公司的“燕之屋”牌血燕、广州同康药业有限公司的“正基”牌血燕、北京庆和堂参茸有限公司的“庆和堂”牌等11批次的血燕产品检出的亚硝酸盐含量均超过10000毫克/千克，超过国家强制标准300倍之多。有关资料显示，亚硝酸盐是剧毒物质，成人摄入0.2克至0.5克即可引起中毒，3克即可致死，同时亚硝酸盐还可致癌。</P>\r\n<P>　　据悉，此次检测工作是由浙江公正检验中心、宁波出入境检验检疫中心、温州市工业科学研究院检测中心等6家检测机构承担。记者还从省工商局了解到，此次检测的部分样品来自温州。8月15日，温州市工业科学研究院检测中心有关人员表示，他们只负责检测委托检验的样品，至于其他不好多说。</P>\r\n<P>　<STRONG>　温州市场难觅血燕踪迹</STRONG></P>\r\n<P>　　8月15日下午，记者相继走访市区十余家营养品专卖店，仅有一家尚有血燕出售。店家称，血燕25元/克。在血燕的外包装上，记者没有发现任何厂家信息。</P>\r\n<P>　　在市区其他几家店里，店家明确表示他们已经有好几个月没有进干血燕出售了，并劝告消费者放弃购买血燕的念头，“其实血燕和白燕成分差别不大，营养价值都一样，而且价格也相近，只是血燕红彤彤的，送礼为图个彩头而已，而血燕产量毕竟少，有些人不免动起歪脑筋。不进货是因为我们行内人早就清楚血燕的成色，所以一般都会提醒消费者不要购买血燕。”</P>\r\n<P>　　<STRONG>“问题血燕”下架或停货</STRONG></P>\r\n<P>　　此次血燕事件中被曝光的4家企业中，只有“鹰皇”在温州尚无开设分店。记者电话联系了其余3个品牌的部分专卖店，其中位于苍南灵溪的“正基”专卖店和位于苍南宜山“庆和堂”药店的负责人均表示，早在几个月前就已发现血燕质量存疑，并陆续将其退回供应商，目前店内已没有血燕出售。</P>\r\n<P>　　位于乐清柳市的“燕之屋”燕窝专卖店一名店员称，所有血燕已下架并退回总公司暂时封存。“燕之屋”温州地区销售经理章先生则一再向记者强调，该公司已经开始着手处理此事，不日将对外公布相关处理措施。</P>\r\n<P><STRONG>　　亚硝酸盐为何超标？</STRONG></P>\r\n<P>　　亚硝酸盐为何会超标？有人说，可能是不良商家为了追逐更高利润，添加高含量的亚硝酸盐以达到延长血燕的保存期限，保持表面光鲜的目的。“有些血燕其实是低价的白燕窝熏制或染色后形成的。这些白燕窝亚硝酸盐含量非常高。”</P>\r\n<P>　<STRONG>　挑燕窝不妨“一摸二闻三看”</STRONG></P>\r\n<P>　　普通消费者该如何挑选燕窝？有业内人士支招，燕窝的挑选相对复杂，但大致可归纳为“一摸二闻三看”。摸――摸燕窝表面水分，燕窝一般都经过烘干处理，干度比例好；闻――闻燕窝表面气味，好的燕窝都有淡淡的清香味，如果闻起来有漂白剂等气味，就要多加留意；看――看燕盏的丝状结构，有的不法商贩会将零散的粗劣燕窝用胶进行拼接。（朱斌）</P>\r\n<META name=ContentEnd><!--ZJEG_RSS.content.end--><!--<$[信息内容]>end-->', '23', '0', '0', '2024-03-03 14:25:36');
