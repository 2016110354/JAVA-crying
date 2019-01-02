-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.6.26 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win32
-- HeidiSQL 版本:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 scores 的数据库结构
CREATE DATABASE IF NOT EXISTS `scores` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `scores`;

-- 导出  表 scores.course 结构
CREATE TABLE IF NOT EXISTS `course` (
  `cursno` varchar(5) NOT NULL COMMENT '课程编号',
  `name` varchar(20) NOT NULL COMMENT '课程名称',
  `credit` varchar(5) NOT NULL COMMENT '学分',
  PRIMARY KEY (`cursno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 正在导出表  scores.course 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` (`cursno`, `name`, `credit`) VALUES
	('', '02 JAVA', '3'),
	('01', 'JS', '1'),
	('02', 'C', '4'),
	('1', 'JS', '2');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;

-- 导出  表 scores.sc 结构
CREATE TABLE IF NOT EXISTS `sc` (
  `stdno` varchar(12) NOT NULL DEFAULT '',
  `cursno` varchar(5) NOT NULL DEFAULT '',
  PRIMARY KEY (`stdno`,`cursno`),
  KEY `cursno` (`cursno`),
  CONSTRAINT `sc_ibfk_1` FOREIGN KEY (`stdno`) REFERENCES `student` (`stdno`),
  CONSTRAINT `sc_ibfk_2` FOREIGN KEY (`cursno`) REFERENCES `course` (`cursno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 正在导出表  scores.sc 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `sc` DISABLE KEYS */;
INSERT INTO `sc` (`stdno`, `cursno`) VALUES
	('2015001', '01'),
	('2015114', '01'),
	('2015001', '02'),
	('2015114', '02');
/*!40000 ALTER TABLE `sc` ENABLE KEYS */;

-- 导出  表 scores.student 结构
CREATE TABLE IF NOT EXISTS `student` (
  `stdno` varchar(12) NOT NULL COMMENT '学号',
  `name` varchar(20) NOT NULL COMMENT '姓名',
  `sex` varchar(10) DEFAULT NULL COMMENT '性别',
  `birthday` varchar(20) DEFAULT NULL COMMENT '出生日期',
  `password` varchar(20) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`stdno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 正在导出表  scores.student 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`stdno`, `name`, `sex`, `birthday`, `password`) VALUES
	('2015001', 'ze', 'male', '2014-3-3', '123456'),
	('2015002', 'er', 'male', '2012-2-3', '456'),
	('2015003', 'we', 'male', '2015-2-3', '123456'),
	('2015114', 'se', 'we', '2015-2-3', '123');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
