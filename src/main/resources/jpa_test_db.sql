-- MySQL dump 10.13  Distrib 5.7.21, for Win64 (x86_64)
--
-- Host: localhost    Database: jpa_test_db
-- ------------------------------------------------------
-- Server version	5.7.21-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `last_data_enter` bigint(20) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `player_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_account` (`player_id`)
) ENGINE=MyISAM AUTO_INCREMENT=108 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (97,1523934867816,'metade','52232',96),(98,1523934867816,'sologin','52532',96),(100,1523950954542,'metade','52232',99),(101,1523950954542,'sologin','52532',99),(103,1523951185206,'metade','52232',102),(104,1523951185206,'sologin','52532',102),(106,1523952931070,'vendetta529','52232',105),(107,1523952931070,'blizzcon@yandex.ru','52532',105);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departament_role`
--

DROP TABLE IF EXISTS `departament_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departament_role` (
  `id` bigint(20) NOT NULL,
  `role_code` int(11) DEFAULT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  `role_salary` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departament_role`
--

LOCK TABLES `departament_role` WRITE;
/*!40000 ALTER TABLE `departament_role` DISABLE KEYS */;
INSERT INTO `departament_role` VALUES (47,410113,'student',1200),(51,4100115,'prepod',8100);
/*!40000 ALTER TABLE `departament_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employees` (
  `employee_id` int(11) NOT NULL,
  `employee_adress` varchar(255) DEFAULT NULL,
  `employee_age` varchar(255) DEFAULT NULL,
  `employee_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'voll street','54','ROger'),(2,'temps','23','David'),(3,'temp adress','34','Stiven'),(4,'voll street','54','ROger'),(5,'temps','23','David'),(6,'temp adress','34','Stiven'),(7,'some address','54','Vova'),(8,'voll street','51','Nikolai'),(9,'temp adress','56','Dima'),(10,'some address','54','Vova'),(11,'voll street','51','Nikolai'),(12,'temp adress','56','Dima'),(13,'some address','54','Vova'),(14,'voll street','51','Nikolai'),(15,'temp adress','56','Dima'),(16,'some address','54','Vova'),(17,'voll street','51','Nikolai'),(18,'temp adress','56','Dima'),(19,'vika address','20','Vika'),(20,'masha adress','23','Masha'),(21,'Lola address','22','Lola'),(22,'vika address','20','Vika'),(23,'masha adress','23','Masha'),(24,'Lola address','22','Lola'),(25,'Lola address','22','Lola'),(26,'masha adress','23','Masha'),(27,'vika address','20','Vika'),(28,'Lola address','22','Lola'),(29,'masha adress','23','Masha'),(30,'vika address','20','Vika'),(32,'Lola address','22','Lola'),(33,'masha adress','23','Masha'),(34,'vika address','20','Vika'),(36,'Lola address','22','Lola'),(37,'masha adress','23','Masha'),(38,'vika address','20','Vika'),(40,'Lola address','22','Lola'),(41,'masha adress','23','Masha'),(42,'vika address','20','Vika'),(44,'Lola address','22','Lola'),(45,'masha adress','23','Masha'),(46,'vika address','20','Vika'),(48,'Lola address','22','Lola'),(49,'masha adress','23','Masha'),(50,'vika address','20','Vika'),(52,'Lola address','22','Lola'),(53,'masha adress','23','Masha'),(54,'vika address','20','Vika');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `games`
--

DROP TABLE IF EXISTS `games`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `games` (
  `game_id` int(11) NOT NULL AUTO_INCREMENT,
  `game_name` varchar(80) NOT NULL,
  `game_price` double NOT NULL,
  `game_company` varchar(80) NOT NULL,
  `player_id` int(11) NOT NULL,
  PRIMARY KEY (`game_id`),
  KEY `player_id` (`player_id`),
  CONSTRAINT `fk_game_player_id` FOREIGN KEY (`player_id`) REFERENCES `player` (`player_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `games`
--

LOCK TABLES `games` WRITE;
/*!40000 ALTER TABLE `games` DISABLE KEYS */;
INSERT INTO `games` VALUES (108,'GTA',50.5,'Biosystem',105),(109,'WoT',505.5,'Wargaming',105),(110,'FIFA2010',123.5,'Namco',105),(111,'WoW',504.5,'Blizzard',105),(112,'Lineage2',100.5,'Microsystem',105);
/*!40000 ALTER TABLE `games` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (113);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persons`
--

DROP TABLE IF EXISTS `persons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persons` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `EMAIL` varchar(255) DEFAULT NULL,
  `FIRST_NAME` varchar(255) DEFAULT NULL,
  `LAST_NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persons`
--

LOCK TABLES `persons` WRITE;
/*!40000 ALTER TABLE `persons` DISABLE KEYS */;
/*!40000 ALTER TABLE `persons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phone`
--

DROP TABLE IF EXISTS `phone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `phone` (
  `phone_id` int(11) NOT NULL,
  `phone_model` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`phone_id`),
  KEY `FK4dhxsv5byjbbh22m3hs6r2bp2` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone`
--

LOCK TABLES `phone` WRITE;
/*!40000 ALTER TABLE `phone` DISABLE KEYS */;
/*!40000 ALTER TABLE `phone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `player`
--

DROP TABLE IF EXISTS `player`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `player` (
  `player_id` int(11) NOT NULL AUTO_INCREMENT,
  `player_address` varchar(255) DEFAULT NULL,
  `player_age` int(11) DEFAULT NULL,
  `player_email` varchar(255) DEFAULT NULL,
  `player_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`player_id`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `player`
--

LOCK TABLES `player` WRITE;
/*!40000 ALTER TABLE `player` DISABLE KEYS */;
INSERT INTO `player` VALUES (96,'SGsd23DFH',181,'yadenx.ru','vova'),(99,'SGsd23DFH',181,'yadenx.ru','vova'),(102,'SGsd23DFH',181,'yadenx.ru','vova'),(105,'Bespalova 56',181,'testemail@yadenx.ru','Yarik');
/*!40000 ALTER TABLE `player` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `player_role`
--

DROP TABLE IF EXISTS `player_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `player_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_code` int(11) DEFAULT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  `role_salary` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=44 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `player_role`
--

LOCK TABLES `player_role` WRITE;
/*!40000 ALTER TABLE `player_role` DISABLE KEYS */;
INSERT INTO `player_role` VALUES (1,230013,'pomoshnik',13000),(2,230013,'pomoshnik',13000),(3,230015,'nachalnik',93000),(4,110013,'president',12000),(5,110015,'ministr',810000),(6,110013,'president',12000),(7,110015,'ministr',810000),(8,410113,'student',1200),(9,4100115,'prepod',8100),(10,410113,'student',1200),(11,4100115,'prepod',8100),(31,410113,'student',1200),(35,4100115,'prepod',8100),(39,410113,'student',1200),(43,4100115,'prepod',8100);
/*!40000 ALTER TABLE `player_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(80) DEFAULT NULL,
  `role_salary` double DEFAULT '0',
  `role_code` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_employee`
--

DROP TABLE IF EXISTS `role_employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_employee` (
  `id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`,`role_id`),
  KEY `FKe4oq6tk08kjhlnmbtr2msw2y0` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_employee`
--

LOCK TABLES `role_employee` WRITE;
/*!40000 ALTER TABLE `role_employee` DISABLE KEYS */;
INSERT INTO `role_employee` VALUES (2,1),(2,2),(2,3),(3,4),(3,5),(3,6),(4,7),(4,8),(4,9),(5,10),(5,11),(5,12),(6,13),(6,14),(6,15),(7,16),(7,17),(7,18),(8,19),(8,20),(8,21),(9,22),(9,23),(9,24),(10,25),(10,26),(10,27),(11,28),(11,29),(11,30),(31,32),(31,33),(31,34),(35,36),(35,37),(35,38),(39,40),(39,41),(39,42),(43,44),(43,45),(43,46),(47,48),(47,49),(47,50),(51,52),(51,53),(51,54);
/*!40000 ALTER TABLE `role_employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop`
--

DROP TABLE IF EXISTS `shop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shop` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `customers_density` double DEFAULT NULL,
  `shop_name` varchar(255) DEFAULT NULL,
  `owner` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop`
--

LOCK TABLES `shop` WRITE;
/*!40000 ALTER TABLE `shop` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `student_id` int(11) NOT NULL,
  `student_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studentclazzes`
--

DROP TABLE IF EXISTS `studentclazzes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `studentclazzes` (
  `student_id` int(11) NOT NULL,
  `clazz_id` int(11) NOT NULL,
  PRIMARY KEY (`student_id`,`clazz_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentclazzes`
--

LOCK TABLES `studentclazzes` WRITE;
/*!40000 ALTER TABLE `studentclazzes` DISABLE KEYS */;
/*!40000 ALTER TABLE `studentclazzes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-21 21:14:23
