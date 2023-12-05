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
-- Table structure for table `tour_batch`
--

DROP TABLE IF EXISTS `tour_batch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tour_batch` (
  `id` bigint NOT NULL,
  `available_seats` int NOT NULL,
  `capacity` int NOT NULL,
  `end_date` date DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `first` varchar(255) DEFAULT NULL,
  `last` varchar(255) DEFAULT NULL,
  `sequence` int NOT NULL,
  `per_participant_cost` double NOT NULL,
  `start_date` date DEFAULT NULL,
  `status` varchar(255) NOT NULL,
  `guided_tour_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgi9p52lsr1l4khyecxhptorj` (`guided_tour_id`),
  CONSTRAINT `FKgi9p52lsr1l4khyecxhptorj` FOREIGN KEY (`guided_tour_id`) REFERENCES `base_tour` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tour_batch`
--

LOCK TABLES `tour_batch` WRITE;
/*!40000 ALTER TABLE `tour_batch` DISABLE KEYS */;
INSERT INTO `tour_batch` VALUES (1,10,10,'2023-11-27','9900000010','Tushar','Gandhi',0,10000,'2023-11-24','ACTIVE',1),(2,20,20,'2023-11-29','9123456789','John','Lee',0,9000,'2023-11-25','ACTIVE',2),(3,20,20,'2023-11-29','9123456789','James','Bond',0,9000,'2023-11-26','ACTIVE',3),(4,20,20,'2023-11-29','9123456789','Jacob','Ghosh',0,9000,'2023-11-26','ACTIVE',4),(5,20,20,'2023-11-29','9123456789','Jenny','Bell',0,9000,'2023-11-26','ACTIVE',5);
/*!40000 ALTER TABLE `tour_batch` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-24 10:20:47
