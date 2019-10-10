DROP DATABASE IF EXISTS `ssncvuser`;
CREATE DATABASE `ssncvuser`;
USE `ssncvuser`;
-- ----------------------------
-- Table structure for user_data
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`       int(10)     NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '用户唯一标识',
    `phone`    varchar(11)  DEFAULT NULL COMMENT '手机号',
    `username` varchar(20)  DEFAULT NULL COMMENT '昵称',
    `avatar`   varchar(255) DEFAULT NULL COMMENT '头像',
    `password` varchar(10) NOT NULL COMMENT '密码'
) ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of user_data
-- ----------------------------

INSERT INTO `user`
VALUES ('8', '17754833705', 'Lyam', 'assets/file/1556026312685.jpg', '000000');

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`
(
    `username` varchar(20) NOT NULL PRIMARY KEY,
    `password` varchar(10) NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
INSERT INTO `admin`
VALUES ('Lyam', '000000');

