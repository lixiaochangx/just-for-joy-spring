CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(64) DEFAULT NULL COMMENT '用户名',
  `balance` double(255,0) DEFAULT NULL COMMENT '余额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `isbn` varchar(128) NOT NULL COMMENT '书号',
  `book_name` varchar(128) DEFAULT NULL COMMENT '书名',
  `price` double DEFAULT NULL COMMENT '单价',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `book_stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `stock` int(16) DEFAULT NULL COMMENT '书的存量',
  `isbn` varchar(128) DEFAULT NULL COMMENT '书号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

