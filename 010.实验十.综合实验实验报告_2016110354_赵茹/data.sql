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


-- 导出 diary 的数据库结构
CREATE DATABASE IF NOT EXISTS `diary` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `diary`;

-- 导出  表 diary.diary 结构
CREATE TABLE IF NOT EXISTS `diary` (
  `dates` date NOT NULL,
  `uname` varchar(20) COLLATE utf8_bin NOT NULL,
  `weather` enum('晴朗','多云','阴雨','冬雪') COLLATE utf8_bin NOT NULL,
  `mood` enum('大笑','哭泣','沉默','气愤') COLLATE utf8_bin NOT NULL,
  `tital` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `content` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`uname`,`dates`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  diary.diary 的数据：~9 rows (大约)
/*!40000 ALTER TABLE `diary` DISABLE KEYS */;
INSERT INTO `diary` (`dates`, `uname`, `weather`, `mood`, `tital`, `content`) VALUES
	('2015-01-01', '2016110354zr', '阴雨', '沉默', '春分吹', '吹红樱桃吹绿柳树'),
	('2018-12-26', '2016110354zr', '阴雨', '大笑', '十年', '若果那两个字没有颤抖'),
	('2018-12-27', '2016110354zr', '多云', '哭泣', '南山南', '你在南方的艳阳里，大雪纷飞'),
	('2018-12-29', '2016110354zr', '阴雨', '沉默', '陪我到可可西里去看海', '谁说太平洋里没有篝火'),
	('2018-12-21', 'clownzr', '多云', '哭泣', '董小姐', '谁说你是没有故事的女孩'),
	('2018-12-22', 'clownzr', '多云', '沉默', '月半弯', '月半弯,月半弯，多浪漫'),
	('2018-12-23', 'clownzr', '冬雪', '大笑', '好久不见', '我来到你的城市'),
	('2018-12-24', 'clownzr', '阴雨', '沉默', '勇气', '终于做了这个决定'),
	('2018-12-25', 'clownzr', '冬雪', '哭泣', '往后余生', '风雪是你，平淡是你');
/*!40000 ALTER TABLE `diary` ENABLE KEYS */;


-- 导出 java 的数据库结构
CREATE DATABASE IF NOT EXISTS `java` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `java`;

-- 导出  表 java.user 结构
CREATE TABLE IF NOT EXISTS `user` (
  `uname` varchar(20) COLLATE utf8_bin NOT NULL,
  `sname` varchar(20) COLLATE utf8_bin NOT NULL,
  `pwd` varchar(20) COLLATE utf8_bin NOT NULL,
  `mail` varchar(20) COLLATE utf8_bin NOT NULL,
  `num` int(11) DEFAULT NULL,
  `answer` varchar(20) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`uname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  java.user 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`uname`, `sname`, `pwd`, `mail`, `num`, `answer`) VALUES
	('', '', '', '', 0, 'null'),
	('2016110354zr', 'zr', '2016110354zr', '1500908547@qq.com', 3, '21'),
	('adminzr', 'admin', 'adminzr', '1600908508@qq.com', 1, 'zr'),
	('clownzr', 'clownzr', 'clownzr', '1500602514@qq.com', 1, 'clown');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
