-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: jt
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `base_tour`
--

DROP TABLE IF EXISTS `base_tour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `base_tour` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `days` int NOT NULL,
  `difficulty_level` varchar(255) NOT NULL,
  `end_at` varchar(255) DEFAULT NULL,
  `mode` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `nights` int NOT NULL,
  `start_at` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `base_tour`
--

LOCK TABLES `base_tour` WRITE;
/*!40000 ALTER TABLE `base_tour` DISABLE KEYS */;
INSERT INTO `base_tour` VALUES (1,3,'MODERATE','Nasik','BICYCLE','MUMBAI-NASIK',2,'Mumbai'),(2,4,'EASY','Mumbai_Gateway_of_India','BICYCLE','PUNE-MUMBAI',3,'Pune-Shaniwarwada'),(3,3,'EASY','Udaipur','MOTORBIKE','JAIPUR-UDAIPUR',2,'Jaipur'),(4,3,'EASY','Agra','MOTORBIKE','DELHI-AGRA',2,'Delhi'),(5,3,'MODERATE','Coorg','WALK','BANGALORE-COORG',2,'Bangalore');
/*!40000 ALTER TABLE `base_tour` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-24 10:20:49
