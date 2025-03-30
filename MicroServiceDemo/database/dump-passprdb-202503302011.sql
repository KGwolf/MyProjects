-- MySQL dump 10.13  Distrib 5.7.37, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: passprdb
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `clinic_task_info`
--

DROP TABLE IF EXISTS `clinic_task_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clinic_task_info` (
  `taskid` bigint NOT NULL DEFAULT '0',
  `mhiscode` int NOT NULL DEFAULT '0',
  `userid` int NOT NULL DEFAULT '0',
  `starttime` varchar(255) DEFAULT '',
  `checkdatetime` varchar(255) DEFAULT '',
  `slcode` int DEFAULT '-1',
  `status` int DEFAULT '-4',
  `prescno` varchar(255) DEFAULT '',
  `patientname` varchar(100) DEFAULT NULL,
  `doctorid` int DEFAULT NULL,
  `remaintime` int DEFAULT NULL,
  KEY `idx_clinic_task_info_status` (`status`,`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clinic_task_info`
--

LOCK TABLES `clinic_task_info` WRITE;
/*!40000 ALTER TABLE `clinic_task_info` DISABLE KEYS */;
INSERT INTO `clinic_task_info` VALUES (7602,2,0,'2025-03-30 18:30:41','',2,15,'','hlXyIWfYGMZ+/1zZXRH1lUiTZ4A5zP9BMKHZXGn70A0=',1,-1);
/*!40000 ALTER TABLE `clinic_task_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clinic_task_info_history`
--

DROP TABLE IF EXISTS `clinic_task_info_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clinic_task_info_history` (
  `taskid` bigint NOT NULL DEFAULT '0',
  `sendtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `mhiscode` int NOT NULL DEFAULT '0',
  `userid` int NOT NULL DEFAULT '0',
  `starttime` varchar(255) DEFAULT '',
  `checkdatetime` varchar(255) DEFAULT '',
  `slcode` int DEFAULT '-1',
  `status` int DEFAULT '-4',
  `sendid` varchar(255) DEFAULT '',
  `sendname` varchar(255) DEFAULT '',
  `prescno` varchar(255) DEFAULT '',
  `statusdesc` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clinic_task_info_history`
--

LOCK TABLES `clinic_task_info_history` WRITE;
/*!40000 ALTER TABLE `clinic_task_info_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `clinic_task_info_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clinic_task_info_question`
--

DROP TABLE IF EXISTS `clinic_task_info_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clinic_task_info_question` (
  `taskid` bigint NOT NULL DEFAULT '0',
  `questionid` bigint NOT NULL DEFAULT '0',
  `date_id` int DEFAULT '0',
  `sendtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `mhiscode` int NOT NULL DEFAULT '0',
  `userid` int NOT NULL DEFAULT '0',
  `status` int DEFAULT '-4',
  `slcode` int DEFAULT '-1',
  `moduleid` int DEFAULT '0',
  `modulename` varchar(255) DEFAULT '',
  `ordernum` varchar(255) DEFAULT '',
  `druguniquehash` varchar(255) DEFAULT '',
  `drugindex` bigint NOT NULL DEFAULT '0',
  `drugname` varchar(255) DEFAULT '',
  `warning` varchar(255) DEFAULT '',
  `warninghash` varchar(255) DEFAULT '',
  `deptcode` varchar(255) DEFAULT '',
  `doctorcode` varchar(255) DEFAULT '',
  `reason` varchar(255) DEFAULT '',
  `submoduleid` int NOT NULL DEFAULT '0',
  `submodulename` varchar(255) DEFAULT '',
  `prescno` varchar(255) DEFAULT '',
  `deptuqid` bigint DEFAULT '0',
  `doctoruqid` bigint DEFAULT '0',
  PRIMARY KEY (`taskid`,`questionid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clinic_task_info_question`
--

LOCK TABLES `clinic_task_info_question` WRITE;
/*!40000 ALTER TABLE `clinic_task_info_question` DISABLE KEYS */;
/*!40000 ALTER TABLE `clinic_task_info_question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'passprdb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-03-30 20:11:53
