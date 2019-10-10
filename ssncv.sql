DROP DATABASE IF EXISTS `ssncvapi`;
CREATE DATABASE `ssncvapi`;

DROP TABLE IF EXISTS `surrounding`;
CREATE TABLE `surrounding` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `content` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

INSERT INTO `surrounding` VALUES ('1', '交通线路', '[\"107路内环晚班 19:40-22:30\",\"109路晚班 19:54-23:14\",\"111路晚班 19:25-23:15\"]');
INSERT INTO `surrounding` VALUES ('2', '便民服务', '[\"芜湖市政府 景区北门\",\"第二人民医院 景区南门\",\"皖医二附院 景区东门\"]');
INSERT INTO `surrounding` VALUES ('3', '公共厕所', '[\"鸠兹风景区公共厕所一 景区东北角\",\"鸠兹风景区公共厕所二 景区东南角\",\"鸠兹风景区公共厕所三 景区西北角\"]');

-- ----------------------------
-- Table structure for area
-- ----------------------------
DROP TABLE IF EXISTS `interest`;
CREATE TABLE `interest` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `description` text DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of area
-- ----------------------------
INSERT INTO `interest` VALUES (1, '3', '鸠兹广场', '鸠兹广场位于芜湖市中心区，依山（赭山）面湖（镜湖），临路（北京路）傍街（芜湖中山路步行街），位置优越，视野开阔，环境优美，是承载芜湖市悠久文化历史内涵，是反映芜湖市过去现在与未来的最富艺术魅力与文化品位的城市\"客厅\"。 广场总面积6.78万平方米，空间结构多变，主次分明，极富节奏韵律。原为市政府办公用地，1999年底市委、市政府决定将市政府移址重建，兴建市民文化休闲广场，造福人民。芜湖鸠兹风景区为国家4A级景区，先后获得中国魅力景区称号、全国建设管理项目综合奖项广厦奖等荣誉。 该广场于2000年开工，建成使用。广场中央的主题雕塑重在表现芜湖人勤奋智慧和开拓向上的进取精神。建成后的鸠兹广场体现了芜湖历史文化传统与地方山水城市特征，并具时代特色，满足了广大市民群众休闲生活的需要，深受市民喜爱。广场建成后提高了城市中心区的生态环境质量，创造了新颖优美的城市景观，为芜湖优秀旅游城市增添了新的旅游景区，改善了城市投资的硬环境，受到省内外、国内外来芜专家们的一致高度评价，成为芜湖市人民的骄傲。 鸠兹广场，最吸引人的是广场中心处拔地而起的高达33米的青铜雕塑，这尊雕塑是以芜湖古名“鸠兹”鸟为原型，加以艺术的夸张设计而成。七只姿态各异的鸠兹鸟，一只只都像振翅欲飞。顶端托起一只金球，仿佛是托起芜湖的希望。整个雕塑既庄严肃穆，又给人以艺术的享受。雕塑四周是几十只喷出的水柱，色如银，形如剑，直冲天空，与青铜雕塑浑然天成为一幅“鸠顶泽瑞”的景观广场北侧最富鲜明个性和独特魅力的当属历史文化长廊。它由24根石柱支撑，每根石柱的四壁都雕刻着精美的图案。这些石刻，荟萃鸠兹人文，对芜湖悠久的历史和灿烂的文化集中承载——有欧亚人类起源的“人字洞”；有西周时代南陵工山古铜冶情景；有干将莫邪；有大禹导中江……透过这些，让我们再次真切地感受到这座生机勃勃的城市人杰地灵。 关于“鸠顶泽瑞”，作为广场的主雕设计者韩美林大师参观了建成后的广场，由感而发，写下了这四个字。从字面上讲，“鸠”代表芜湖，因芜湖古称鸠兹、鸠江。“顶”是最高最好的地方。“泽”指镜湖之畔。“瑞”寓吉祥之意。其含义就是芜湖最好、最美的地方，就是鸠兹广场、中山路步行街。');

-- ----------------------------
-- Table structure for culture
-- ----------------------------
DROP TABLE IF EXISTS `spot`;
CREATE TABLE `spot` (
  `id` varchar(50) NOT NULL,
  #名称
  `name` varchar(10) DEFAULT NULL,
  #介绍
  `description` TEXT DEFAULT NULL,
  #位置
  `position` varchar(20) DEFAULT NULL,
  #景点图片
  `image` varchar(255),
  #管理员对景点的信息更新时间
  `lastModified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of culture
-- ----------------------------
INSERT INTO `spot` VALUES ('6f0e8dedf9054d56a897cfa988d80287', '3', '4', null, '[]', '2019-04-23 21:13:51');
INSERT INTO `spot` VALUES ('c8688922f637473ba04f8eac4312b7bf', '45', '345345', null, '[\"assets/file/1556025997024.jpg\"]', '2019-04-23 21:26:42');

-- ----------------------------
-- Table structure for say
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` varchar(64) NOT NULL,
  `uid` int(10) DEFAULT NULL,
  #可重复
  `sid` varchar(50) DEFAULT NULL,
  `content` TEXT DEFAULT NULL,
  `sendTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `sid` (`sid`),
  CONSTRAINT `say_ibfk_1` FOREIGN KEY (`sid`) REFERENCES `spot` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of say
-- ----------------------------
INSERT INTO `comment` VALUES ('63f9feb83179497fa2689321e9b22a1c', '8', '6f0e8dedf9054d56a897cfa988d80287', '很美！', '2019-04-23 21:19:54');
INSERT INTO `comment` VALUES ('7498bb9dbd18477b8d90fc22e93c3108', '1', 'c8688922f637473ba04f8eac4312b7bf', '还会再去一次', '2019-05-03 20:50:06');
INSERT INTO `comment` VALUES ('f190dd875d33407283ea195ac4fef79b', '8', '6f0e8dedf9054d56a897cfa988d80287', '风景如画呀', '2019-05-03 22:10:52');

-- ----------------------------
-- Table structure for user_data
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '用户唯一标识',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号',
  `username` varchar(20) DEFAULT NULL COMMENT '昵称',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `password` varchar(10) NOT NULL COMMENT '密码'
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_data
-- ----------------------------

INSERT INTO `user` VALUES ('8', '17754833705', 'Lyam', 'assets/file/1556026312685.jpg','000000');

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
                        `username` varchar(20) NOT NULL PRIMARY KEY,
                        `password` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `admin` VALUES ('Lyam','000000');

