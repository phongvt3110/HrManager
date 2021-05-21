-- MariaDB dump 10.17  Distrib 10.4.14-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: castis_hr_manager
-- ------------------------------------------------------
-- Server version	10.4.14-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `daily_report`
--

DROP TABLE IF EXISTS `daily_report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `daily_report` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `issued_date` datetime NOT NULL DEFAULT current_timestamp(),
  `reporter` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `project` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `position` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `work_details` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `time_required` float NOT NULL,
  `score` float NOT NULL,
  `level_of_work` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `daily_report`
--

LOCK TABLES `daily_report` WRITE;
/*!40000 ALTER TABLE `daily_report` DISABLE KEYS */;
INSERT INTO `daily_report` VALUES (1,2,'2020-07-08 18:08:59','VU TUNG PHONG','VIETTEL-SLA','Developer PHP','None Kplus package renewal',0.4,0.4,'NOT DIFFICULT','2021-03-29 04:37:16','2021-03-29 04:37:16'),(2,2,'2021-03-31 10:54:57','VU TUNG PHONG','VIETTEL-SLA','Developer Java','code Daily report in HR manager project',0.4,0.4,'NOT DIFFICULT','2021-03-31 03:54:57','2021-03-31 03:54:57'),(3,2,'2021-03-31 10:57:54','VU TUNG PHONG','VIETTEL-SLA','Developer Java','code Daily report in HR manager project',0.2,0.2,'NOT DIFFICULT','2021-03-31 03:57:54','2021-03-31 03:57:54'),(4,2,'2021-03-31 12:17:26','VU TUNG PHONG','*Self-development','Developer Java','code Daily report screen in Hr Manager project',0.4,0.4,'NOT EASY','2021-03-31 05:17:26','2021-03-31 05:17:26'),(5,2,'2021-03-31 15:34:22','VU TUNG PHONG','*Self-development','Developer Java','code Daily report screen in Hr Manager project',0.3,0.3,'NOT EASY','2021-03-31 08:34:22','2021-03-31 08:34:22'),(6,2,'2021-03-31 15:46:04','VU TUNG PHONG','*Self-development','Developer Java','code Daily report screen in Hr Manager project',0.6,0.6,'NOT DIFFICULT','2021-03-31 08:46:04','2021-03-31 08:46:04'),(7,2,'2021-04-01 17:39:32','VU TUNG PHONG','*Self Development','Developer Java','code Daily report screen in Hr Manager project',0.9,0.9,'NOT EASY','2021-04-01 10:39:32','2021-04-01 10:39:32'),(8,2,'2021-04-01 17:57:20','VU TUNG PHONG','VIETTEL-SLA','Developer Java','code Daily report screen in Hr Manager project',0.5,0.5,'HARD WORK','2021-04-01 10:57:20','2021-04-01 10:57:20'),(9,2,'2021-04-01 17:58:58','VU TUNG PHONG','*Self Development','Developer Java','code Daily report screen in Hr Manager project',0.8,0.8,'BASIC WORK','2021-04-01 10:58:58','2021-04-01 10:58:58'),(10,2,'2021-04-02 09:12:15','VU TUNG PHONG','*Self Development','Developer PHP','code Daily report screen in Hr Manager project',0.1,0.1,'HARD WORK','2021-04-02 02:12:15','2021-04-02 02:12:15'),(11,2,'2021-04-02 10:34:35','VU TUNG PHONG','*Self Development','Developer Java','code Daily report screen in Hr Manager project',1,1,'BASIC WORK','2021-04-02 03:34:35','2021-04-02 03:34:35'),(12,2,'2021-04-02 11:13:13','VU TUNG PHONG','*Self Development','Developer-C,C++.C#','code Daily report screen in Hr Manager project',0.1,0.1,'EASY WORK','2021-04-02 04:13:13','2021-04-02 04:13:13'),(13,2,'2021-04-02 11:19:48','VU TUNG PHONG','*Self Development','Developer Java','code Daily report screen in Hr Manager project',0.1,0.1,'EASY WORK','2021-04-02 04:19:48','2021-04-02 04:19:48'),(14,2,'2021-04-02 11:42:28','VU TUNG PHONG','*Self Development','Developer Java','code Daily report screen in Hr Manager project',0.1,0.1,'HARD WORK','2021-04-02 04:42:28','2021-04-02 04:42:28'),(15,5,'2021-04-03 11:12:30','Chu Huu Tuan','VIETTEL-SLA','Developer PHP','SLA-548',1,1,'BASIC WORK','2021-04-03 04:12:30','2021-04-03 04:12:30'),(16,5,'2021-04-03 11:12:56','Chu Huu Tuan','VIETTEL-SLA','Developer Java','SLA-550',0.5,0.5,'NOT DIFFICULT','2021-04-03 04:12:56','2021-04-03 04:12:56'),(17,2,'2021-04-06 14:43:48','VU TUNG PHONG','*Self Development','Developer PHP','code Filter function in Daily report screen in Hr Manager project',0.4,0.4,'BASIC WORK','2021-04-06 07:43:48','2021-04-06 07:43:48'),(18,2,'2021-04-06 14:47:06','VU TUNG PHONG','*Self Development','Developer Java','code Filter function in Daily report screen in Hr Manager project',1,1,'NOT EASY','2021-04-06 07:47:06','2021-04-06 07:47:06'),(19,2,'2021-04-07 16:40:09','VU TUNG PHONG','VIETTEL-SLA','Developer Java','SLA-550',1,1,'NOT DIFFICULT','2021-04-07 09:40:09','2021-04-07 09:40:09'),(20,2,'2021-04-09 15:53:22','VU TUNG PHONG','VIETTEL-PO5','Developer Java','code Daily report screen in Hr Manager project',0.4,0.4,'BASIC WORK','2021-04-09 08:53:22','2021-04-09 08:53:22'),(21,2,'2021-04-09 15:56:56','VU TUNG PHONG','VIETTEL-SLA','Developer PHP','SLA-550',0.5,0.5,'BASIC WORK','2021-04-09 08:56:56','2021-04-09 08:56:56'),(22,2,'2021-04-16 15:31:28','VU TUNG PHONG','VIETTEL-SLA','Developer Java','code Filter function in Daily report screen in Hr Manager project',0.4,0.4,'NOT DIFFICULT','2021-04-16 08:31:28','2021-04-16 08:31:28'),(23,2,'2021-04-16 15:36:46','VU TUNG PHONG','VIETTEL-SLA','Developer Java','SLA-550',0.4,0.4,'NOT DIFFICULT','2021-04-16 08:36:46','2021-04-16 08:36:46'),(24,2,'2021-04-23 17:14:28','VU TUNG PHONG','VIETTEL-SLA','Developer PHP','SLA-550',0.5,0.5,'NOT EASY','2021-04-23 10:14:28','2021-04-23 10:14:28'),(25,2,'2021-04-23 17:23:20','VU TUNG PHONG','VIETTEL-SLA','Developer-C,C++.C#','SLA-558',0.5,0.5,'HARD WORK','2021-04-23 10:23:20','2021-04-23 10:23:20');
/*!40000 ALTER TABLE `daily_report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `level_of_work`
--

DROP TABLE IF EXISTS `level_of_work`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `level_of_work` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `level_name` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `level_of_work`
--

LOCK TABLES `level_of_work` WRITE;
/*!40000 ALTER TABLE `level_of_work` DISABLE KEYS */;
INSERT INTO `level_of_work` VALUES (1,'EASY WORK','2021-03-29 03:47:38','2021-03-29 03:47:38'),(2,'NOT DIFFICULT','2021-03-29 03:52:05','2021-03-29 03:52:05'),(3,'BASIC WORK','2021-03-29 03:52:05','2021-03-29 03:52:05'),(4,'NOT EASY','2021-03-29 03:52:05','2021-03-29 03:52:05'),(5,'HARD WORK','2021-03-29 03:52:05','2021-03-29 03:52:05');
/*!40000 ALTER TABLE `level_of_work` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `creator_id` int(11) NOT NULL,
  `project_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (1,1,'VIETTEL-SLA','2021-04-14 04:21:49','2021-04-14 04:21:50'),(2,1,'VIETTEL-PO5','2021-03-29 04:20:08','2021-03-29 04:20:08'),(3,1,'VIETTEL-AD RS/TECH REP','2021-03-29 04:20:08','2021-03-29 04:20:08'),(4,1,'VIETTEL-OPENCDN','2021-03-29 04:20:08','2021-03-29 04:20:08'),(5,1,'TTBB-CMS','2021-03-29 04:20:08','2021-03-29 04:20:08'),(6,1,'TTBB-SYSTEM/SOLUTION DEPLOY','2021-03-29 04:20:08','2021-03-29 04:20:08'),(7,1,'BIZNET-4K IPTV business','2021-03-29 04:20:08','2021-03-29 04:20:08'),(8,1,'ADMIN-HR/FINANCE/ADMIN','2021-03-29 04:20:08','2021-03-29 04:20:08'),(9,1,'*Self Development','2021-03-29 04:20:08','2021-03-29 04:20:08'),(10,1,'VIETTEL-VOD','2021-03-29 04:20:08','2021-03-29 04:20:08'),(11,1,'D\'live-CMS','2021-03-29 04:20:08','2021-03-29 04:20:08'),(18,1,'VIETTEL-SLA phase 2 2022','2021-04-16 08:39:13','2021-04-16 08:39:13');
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ADMIN','2021-03-25 07:05:54','2021-03-25 07:05:54'),(2,'EDITOR','2021-03-25 07:05:54','2021-03-25 07:05:54'),(4,'HR','2021-03-30 11:28:46','2021-03-30 11:28:46'),(5,'USER','2021-04-09 10:32:41','2021-04-09 10:32:41');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff_position`
--

DROP TABLE IF EXISTS `staff_position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `staff_position` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `position_name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff_position`
--

LOCK TABLES `staff_position` WRITE;
/*!40000 ALTER TABLE `staff_position` DISABLE KEYS */;
INSERT INTO `staff_position` VALUES (1,'Office Director / Country Manager','2021-03-29 03:57:52','2021-03-29 03:57:52'),(2,'Admin-HR','2021-03-29 04:08:26','2021-03-29 04:08:26'),(3,'Admin-Accounting / Finance','2021-03-29 04:08:26','2021-03-29 04:08:26'),(4,'Admin-Management','2021-03-29 04:08:26','2021-03-29 04:08:26'),(5,'Sales-all jobs','2021-03-29 04:08:26','2021-03-29 04:08:26'),(6,'ProjectManager','2021-03-29 04:08:26','2021-03-29 04:08:26'),(7,'System Architecture','2021-03-29 04:08:26','2021-03-29 04:08:26'),(8,'Solution Architecture','2021-03-29 04:08:26','2021-03-29 04:08:26'),(9,'Developer Java','2021-03-29 04:08:26','2021-03-29 04:08:26'),(10,'Developer PHP','2021-03-29 04:08:26','2021-03-29 04:08:26'),(11,'Developer-C,C++.C#','2021-03-29 04:08:26','2021-03-29 04:08:26'),(12,'Engineer System','2021-03-29 04:08:26','2021-03-29 04:08:26'),(13,'Engineer Solution','2021-03-29 04:08:26','2021-03-29 04:08:26');
/*!40000 ALTER TABLE `staff_position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `full_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(64) NOT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT 1,
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','admin@gmail.com','DongHyun(AustineLIM) ','$2a$10$i6fmwnHsKisqtICPyl2ykOil25x5pxNqU0ri2nNB7JqTjk6og3nvC',1,'2021-03-25 07:04:35','2021-03-25 07:04:35'),(2,'phongvt','vtphong651043@gmail.com','VU TUNG PHONG','$2a$10$QoRx6ufqcAk2l4N.WRJ9uOg0jBlx.gegvl6kT42XrwXKRxyGY9zdm',1,'2021-03-25 07:05:04','2021-03-25 07:05:04'),(4,'hr','hr@gmail.com','nana','$2a$10$mLQvJjRsG8Eb0zSotgDh1OSFoBzsvuwim9zUIYUqe9UeqqZBjxmQi',1,'2021-04-22 03:30:32','2021-04-22 03:30:32'),(5,'Tuanch','Tuanch@gmail.com','Chu Huu Tuan','$2a$10$mn2FfS72q4OUkCmURwIM0OkvIeFS8Va3CzZQ.oJYJUxp0.7bssl6i',1,'2021-04-03 04:07:16','2021-04-03 04:07:16'),(6,'Viettq','viettq@gmail.com','Tran Quoc Viet','$2a$10$BqqHEdMxpu2MdL5tHY088.OW21sc2AJKe1G7Yc.PJgauP1KaLQtNW',1,'2021-04-14 04:44:46','2021-04-14 04:44:46'),(7,'Jong','jong@gmail.com','Chung Sung Jong','$2a$10$Z3p3p4tm2yXGNePrlXuA2.6E1Gv8M4vLuyeCF.MZKZc6uIz9QDfN.',1,'2021-04-14 04:44:58','2021-04-14 04:44:58'),(8,'thanhnd','Thanhnd@gmail.com','Nguyen Duc Thanh','$2a$10$XSAKy4xcPGu2FBwmnS9vJu44HTgZOj6kQwEVRtLOQOdo6DNIlbsz.',1,'2021-04-14 04:44:31','2021-04-14 04:44:31'),(9,'Tungtt','Tungtt@gmail.com','Tran Thanh Tung','$2a$10$89ImDOVf/c7DJZOp9B9t0OVy6LDZBLVdPShndl8ZYXlnTGHMXUfHO',1,'2021-04-07 11:23:15','2021-04-07 11:23:15'),(18,'Hungnv','hungvn@gmail.com','Nguyen Viet Hung','$2a$10$pdOH//UhoN75z2bJ.6nz4u9eRn.YL/O5fJqz7giTu9scB3o43XE6u',1,'2021-04-16 08:38:15','2021-04-16 08:38:15');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`),
  KEY `role_id_fk` (`role_id`),
  KEY `user_id_fk` (`user_id`),
  CONSTRAINT `role_id_fk` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1,1,'2021-03-25 08:14:50','2021-03-25 08:14:50'),(11,2,5,'2021-04-09 10:33:51','2021-04-09 10:33:51'),(13,5,5,'2021-04-09 10:34:33','2021-04-09 10:34:33'),(14,9,5,'2021-04-09 10:34:50','2021-04-09 10:34:50'),(18,8,5,'2021-04-14 04:44:31','2021-04-14 04:44:31'),(19,6,5,'2021-04-14 04:44:46','2021-04-14 04:44:46'),(20,7,5,'2021-04-14 04:44:58','2021-04-14 04:44:58'),(23,18,5,'2021-04-16 08:38:15','2021-04-16 08:38:15'),(25,4,4,'2021-04-22 03:30:32','2021-04-22 03:30:32');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-21  9:55:44
