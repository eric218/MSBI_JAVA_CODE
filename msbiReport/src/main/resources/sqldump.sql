# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.20)
# Database: msbi_db
# Generation Time: 2018-01-02 06:47:12 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table lookup
# ------------------------------------------------------------

DROP TABLE IF EXISTS `lookup`;

CREATE TABLE `lookup` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `coulor` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `lookup` WRITE;
/*!40000 ALTER TABLE `lookup` DISABLE KEYS */;

INSERT INTO `lookup` (`id`, `title`, `code`, `coulor`)
VALUES
	(1,'Backup 1','1	','17'),
	(2,'Backup rerun and recovered','2','60'),
	(3,'Re-run in progress	','3','13'),
	(4,'No Schedule','4','44'),
	(5,'Backup Failed to recover','0','10'),
	(6,'Administrator Action','5','9'),
	(7,'Test','8','9'),
	(8,'Random','9','9');

/*!40000 ALTER TABLE `lookup` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table month_report
# ------------------------------------------------------------

DROP TABLE IF EXISTS `month_report`;

CREATE TABLE `month_report` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `month_indicator` int(11) DEFAULT NULL,
  `server_name` varchar(255) DEFAULT NULL,
  `schedule_name` varchar(255) DEFAULT NULL,
  `date_of_week` varchar(255) DEFAULT NULL,
  `each_month` varchar(255) DEFAULT NULL,
  `date_of_month` varchar(255) DEFAULT NULL,
  `week_of_month` varchar(255) DEFAULT NULL,
  `bsr` varchar(255) DEFAULT NULL,
  `total_schedule` varchar(255) DEFAULT NULL,
  `total_successful` varchar(255) DEFAULT NULL,
  `day_01_1` varchar(255) DEFAULT NULL,
  `day_01_2` varchar(255) DEFAULT NULL,
  `day_02_1` varchar(255) DEFAULT NULL,
  `day_02_2` varchar(255) DEFAULT NULL,
  `day_03_1` varchar(255) DEFAULT NULL,
  `day_03_2` varchar(255) DEFAULT NULL,
  `day_04_1` varchar(255) DEFAULT NULL,
  `day_04_2` varchar(255) DEFAULT NULL,
  `day_05_1` varchar(255) DEFAULT NULL,
  `day_05_2` varchar(255) DEFAULT NULL,
  `day_06_1` varchar(255) DEFAULT NULL,
  `day_06_2` varchar(255) DEFAULT NULL,
  `day_07_1` varchar(255) DEFAULT NULL,
  `day_07_2` varchar(255) DEFAULT NULL,
  `day_08_1` varchar(255) DEFAULT NULL,
  `day_08_2` varchar(255) DEFAULT NULL,
  `day_09_1` varchar(255) DEFAULT NULL,
  `day_09_2` varchar(255) DEFAULT NULL,
  `day_10_1` varchar(255) DEFAULT NULL,
  `day_10_2` varchar(255) DEFAULT NULL,
  `day_11_1` varchar(255) DEFAULT NULL,
  `day_11_2` varchar(255) DEFAULT NULL,
  `day_12_1` varchar(255) DEFAULT NULL,
  `day_12_2` varchar(255) DEFAULT NULL,
  `day_13_1` varchar(255) DEFAULT NULL,
  `day_13_2` varchar(255) DEFAULT NULL,
  `day_14_1` varchar(255) DEFAULT NULL,
  `day_14_2` varchar(255) DEFAULT NULL,
  `day_15_1` varchar(255) DEFAULT NULL,
  `day_15_2` varchar(255) DEFAULT NULL,
  `day_16_1` varchar(255) DEFAULT NULL,
  `day_16_2` varchar(255) DEFAULT NULL,
  `day_17_1` varchar(255) DEFAULT NULL,
  `day_17_2` varchar(255) DEFAULT NULL,
  `day_18_1` varchar(255) DEFAULT NULL,
  `day_18_2` varchar(255) DEFAULT NULL,
  `day_19_1` varchar(255) DEFAULT NULL,
  `day_19_2` varchar(255) DEFAULT NULL,
  `day_20_1` varchar(255) DEFAULT NULL,
  `day_20_2` varchar(255) DEFAULT NULL,
  `day_21_1` varchar(255) DEFAULT NULL,
  `day_21_2` varchar(255) DEFAULT NULL,
  `day_22_1` varchar(255) DEFAULT NULL,
  `day_22_2` varchar(255) DEFAULT NULL,
  `day_23_1` varchar(255) DEFAULT NULL,
  `day_23_2` varchar(255) DEFAULT NULL,
  `day_24_1` varchar(255) DEFAULT NULL,
  `day_24_2` varchar(255) DEFAULT NULL,
  `day_25_1` varchar(255) DEFAULT NULL,
  `day_25_2` varchar(255) DEFAULT NULL,
  `day_26_1` varchar(255) DEFAULT NULL,
  `day_26_2` varchar(255) DEFAULT NULL,
  `day_27_1` varchar(255) DEFAULT NULL,
  `day_27_2` varchar(255) DEFAULT NULL,
  `day_28_1` varchar(255) DEFAULT NULL,
  `day_28_2` varchar(255) DEFAULT NULL,
  `day_29_1` varchar(255) DEFAULT NULL,
  `day_29_2` varchar(255) DEFAULT NULL,
  `day_30_1` varchar(255) DEFAULT NULL,
  `day_30_2` varchar(255) DEFAULT NULL,
  `day_31_1` varchar(255) DEFAULT NULL,
  `day_31_2` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `month_indicator_index` (`month_indicator`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `month_report` WRITE;
/*!40000 ALTER TABLE `month_report` DISABLE KEYS */;

INSERT INTO `month_report` (`id`, `month_indicator`, `server_name`, `schedule_name`, `date_of_week`, `each_month`, `date_of_month`, `week_of_month`, `bsr`, `total_schedule`, `total_successful`, `day_01_1`, `day_01_2`, `day_02_1`, `day_02_2`, `day_03_1`, `day_03_2`, `day_04_1`, `day_04_2`, `day_05_1`, `day_05_2`, `day_06_1`, `day_06_2`, `day_07_1`, `day_07_2`, `day_08_1`, `day_08_2`, `day_09_1`, `day_09_2`, `day_10_1`, `day_10_2`, `day_11_1`, `day_11_2`, `day_12_1`, `day_12_2`, `day_13_1`, `day_13_2`, `day_14_1`, `day_14_2`, `day_15_1`, `day_15_2`, `day_16_1`, `day_16_2`, `day_17_1`, `day_17_2`, `day_18_1`, `day_18_2`, `day_19_1`, `day_19_2`, `day_20_1`, `day_20_2`, `day_21_1`, `day_21_2`, `day_22_1`, `day_22_2`, `day_23_1`, `day_23_2`, `day_24_1`, `day_24_2`, `day_25_1`, `day_25_2`, `day_26_1`, `day_26_2`, `day_27_1`, `day_27_2`, `day_28_1`, `day_28_2`, `day_29_1`, `day_29_2`, `day_30_1`, `day_30_2`, `day_31_1`, `day_31_2`)
VALUES
	(1,201702,'RBITBUR3','D1DCB210_WINOS_BACKUP	','Sun	','Any','Any','Any','100%','5','5','4',NULL,'1','1(0)/1','4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'1','1(0)/1','4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'',NULL,'',NULL,NULL,NULL),
	(2,201702,'RBITBUR3','D1DCB251_WINOS_BACKUP	','\"Sun,Mon,Tue,Wed,Thu,Fri\"','Any','Any','Any','100%','4','4','4',NULL,'4',NULL,'1','1(0)/1','4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'1','1(0)/1','4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'',NULL,'',NULL,NULL,NULL),
	(3,201702,'RBITBUR3','D1DCB210_WINOS_BACKUP	','Sun	','Any','Any','Any','100%','5','5','4',NULL,'1','1(0)/1','4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'1','1(0)/1','4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'',NULL,'',NULL,NULL,NULL),
	(4,201702,'RBITBUR3','D1DCB251_WINOS_BACKUP	','\"Sun,Mon,Tue,Wed,Thu,Fri\"','Any','Any','Any','100%','4','4','4',NULL,'4',NULL,'1','1(0)/1','4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'1','1(0)/1','4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'',NULL,'',NULL,NULL,NULL),
	(5,201702,'RBITBUR3','D1DCB251_WINOS_BACKUP	','\"Sun,Mon,Tue,Wed,Thu,Fri\"','Any','Any','Any','100%','4','4','4',NULL,'4',NULL,'1','1(0)/1','4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'1','1(0)/1','4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'',NULL,'',NULL,NULL,NULL),
	(6,201702,'RBITBUR3','D1DCB251_WINOS_BACKUP	','\"Sun,Mon,Tue,Wed,Thu,Fri\"','Any','Any','Any','100%','4','4','4',NULL,'4',NULL,'1','1(0)/1','4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'1','1(0)/1','4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'',NULL,'',NULL,NULL,NULL),
	(7,201702,'RBITBUR3','D1DCB251_WINOS_BACKUP	','\"Sun,Mon,Tue,Wed,Thu,Fri\"','Any','Any','Any','100%','4','4','4',NULL,'4',NULL,'1','1(0)/1','4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'1','1(0)/1','4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'',NULL,'',NULL,NULL,NULL),
	(8,201702,'RBITBUR3','D1DCB251_WINOS_BACKUP	','\"Sun,Mon,Tue,Wed,Thu,Fri\"','Any','Any','Any','100%','4','4','4',NULL,'4',NULL,'1','1(0)/1','4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'1','1(0)/1','4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'',NULL,'',NULL,NULL,NULL),
	(9,201702,'RBITBUR3','D1DCB251_WINOS_BACKUP	','\"Sun,Mon,Tue,Wed,Thu,Fri\"','Any','Any','Any','100%','4','4','4',NULL,'4',NULL,'1','1(0)/1','4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'1','1(0)/1','4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'',NULL,'',NULL,NULL,NULL),
	(10,201702,'RBITBUR3','D1DCB251_WINOS_BACKUP	','\"Sun,Mon,Tue,Wed,Thu,Fri\"','Any','Any','Any','100%','4','4','4',NULL,'4',NULL,'1','1(0)/1','4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'1','1(0)/1','4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'',NULL,'',NULL,NULL,NULL),
	(11,201702,'RBITBUR3','D1DCB251_WINOS_BACKUP	','\"Sun,Mon,Tue,Wed,Thu,Fri\"','Any','Any','Any','100%','4','4','4',NULL,'4',NULL,'1','1(0)/1','4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'1','1(0)/1','4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'',NULL,'',NULL,NULL,NULL),
	(12,201702,'RBITBUR3','D1DCB251_WINOS_BACKUP	','\"Sun,Mon,Tue,Wed,Thu,Fri\"','Any','Any','Any','100%','4','4','4',NULL,'4',NULL,'1','1(0)/1','4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'1','1(0)/1','4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'',NULL,'',NULL,NULL,NULL),
	(13,201702,'RBITBUR3','D1DCB251_WINOS_BACKUP	','\"Sun,Mon,Tue,Wed,Thu,Fri\"','Any','Any','Any','100%','4','4','4',NULL,'4',NULL,'1','1(0)/1','4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'1','1(0)/1','4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'',NULL,'',NULL,NULL,NULL),
	(14,201702,'RBITBUR3','D1DCB251_WINOS_BACKUP	','\"Sun,Mon,Tue,Wed,Thu,Fri\"','Any','Any','Any','100%','4','4','4',NULL,'4',NULL,'1','1(0)/1','4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'1','1(0)/1','4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'4',NULL,'',NULL,'',NULL,NULL,NULL);

/*!40000 ALTER TABLE `month_report` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table total_summary
# ------------------------------------------------------------

DROP TABLE IF EXISTS `total_summary`;

CREATE TABLE `total_summary` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `month_indicator` int(11) DEFAULT NULL,
  `total_name` int(11) DEFAULT NULL,
  `day_01` int(11) DEFAULT NULL,
  `day_02` int(11) DEFAULT NULL,
  `day_03` int(11) DEFAULT NULL,
  `day_04` int(11) DEFAULT NULL,
  `day_05` int(11) DEFAULT NULL,
  `day_06` int(11) DEFAULT NULL,
  `day_07` int(11) DEFAULT NULL,
  `day_08` int(11) DEFAULT NULL,
  `day_09` int(11) DEFAULT NULL,
  `day_10` int(11) DEFAULT NULL,
  `day_11` int(11) DEFAULT NULL,
  `day_12` int(11) DEFAULT NULL,
  `day_13` int(11) DEFAULT NULL,
  `day_14` int(11) DEFAULT NULL,
  `day_15` int(11) DEFAULT NULL,
  `day_16` int(11) DEFAULT NULL,
  `day_17` int(11) DEFAULT NULL,
  `day_18` int(11) DEFAULT NULL,
  `day_19` int(11) DEFAULT NULL,
  `day_20` int(11) DEFAULT NULL,
  `day_21` int(11) DEFAULT NULL,
  `day_22` int(11) DEFAULT NULL,
  `day_23` int(11) DEFAULT NULL,
  `day_24` int(11) DEFAULT NULL,
  `day_25` int(11) DEFAULT NULL,
  `day_26` int(11) DEFAULT NULL,
  `day_27` int(11) DEFAULT NULL,
  `day_28` int(11) DEFAULT NULL,
  `day_29` int(11) DEFAULT NULL,
  `day_30` int(11) DEFAULT NULL,
  `day_31` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `total_summary` WRITE;
/*!40000 ALTER TABLE `total_summary` DISABLE KEYS */;

INSERT INTO `total_summary` (`id`, `month_indicator`, `total_name`, `day_01`, `day_02`, `day_03`, `day_04`, `day_05`, `day_06`, `day_07`, `day_08`, `day_09`, `day_10`, `day_11`, `day_12`, `day_13`, `day_14`, `day_15`, `day_16`, `day_17`, `day_18`, `day_19`, `day_20`, `day_21`, `day_22`, `day_23`, `day_24`, `day_25`, `day_26`, `day_27`, `day_28`, `day_29`, `day_30`, `day_31`)
VALUES
	(1,201702,0,7,123,123,123,123,123,3,8,8,8,8,888888888,8,8,8,8,8,8,8,8,8,8,8,8,8,9,9,9,9,9,9),
	(2,201702,2,123,123,123,33,2,2,2,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8),
	(3,201702,3,123,123,123,1,1,1,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5),
	(4,201702,4,12,123,123,4,4,4,4,4,4,4,4,4,4,4,4,5,5,5,6,6,67,6,6,7,7,6,6,5,6,6,5),
	(5,201702,5,123,123,222,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8),
	(6,201702,7,7,7,6,76,6,6,7,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6);

/*!40000 ALTER TABLE `total_summary` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table total_title
# ------------------------------------------------------------

DROP TABLE IF EXISTS `total_title`;

CREATE TABLE `total_title` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `code` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `total_title` WRITE;
/*!40000 ALTER TABLE `total_title` DISABLE KEYS */;

INSERT INTO `total_title` (`id`, `code`, `title`)
VALUES
	(1,1,'Total Failed to recover'),
	(2,2,'Total Schedul Backup '),
	(3,3,'Total Backups (where we exclude the no schedule)'),
	(4,4,'Total backups success on 1st Run (only counts the number of \"1\")'),
	(5,5,'Total Backup failed on 1st Run (total backups minus success on 1st run)'),
	(6,6,'Total Backup success on 2nd run(count those with 2)');

/*!40000 ALTER TABLE `total_title` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
