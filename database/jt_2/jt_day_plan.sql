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
-- Table structure for table `day_plan`
--

DROP TABLE IF EXISTS `day_plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `day_plan` (
  `itinerary_id` bigint NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `hotel_name` varchar(255) DEFAULT NULL,
  `room_type` smallint DEFAULT NULL,
  `activity` varchar(255) DEFAULT NULL,
  `day_count` int NOT NULL,
  `distance` double DEFAULT NULL,
  `place` varchar(255) DEFAULT NULL,
  KEY `FK7h2a0civpep84iqlt7o09gtt1` (`itinerary_id`),
  CONSTRAINT `FK7h2a0civpep84iqlt7o09gtt1` FOREIGN KEY (`itinerary_id`) REFERENCES `base_tour` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `day_plan`
--

LOCK TABLES `day_plan` WRITE;
/*!40000 ALTER TABLE `day_plan` DISABLE KEYS */;
INSERT INTO `day_plan` VALUES (1,'SB road, Thane','Hotel Mayur',0,'reporting between 5 pm to 7 pm. Introduction, tour briefing and ice breaker',1,0,'Mumbai'),(1,'Dwaraka','Dwaraka',0,'Ride on Mumbai Agra road',2,150,'NASIK'),(1,'Dwaraka','Dwaraka',0,'Breakfast, Certifiate distribution and tour ends. Participants return home',3,0,'NASIK'),(2,'SB road','Hotel Lemon tree',0,'reporting between 5 pm to 7 pm. Introduction, tour briefing and ice breaker',0,0,'Pune'),(2,'Main square, Lonavala','Khandala Hotel',1,'Ride on good highway on NH 4. Stay and rest',1,65,'Lonavala'),(2,'Near Museum, Mumbai','Sea Palace',0,'Continue on NH 4.',2,100,'Mumbai'),(2,'Near Museum, Mumbai','Sea Palace',0,'Breakfast, Certifiate distribution and tour ends. Participants return home',3,0,'Mumbai'),(3,NULL,NULL,NULL,'Reporting between 6 am to 8 am. Introduction, tour briefing and gear check',1,0,'Jaipur'),(3,NULL,NULL,NULL,'Ride on Jaipur-Udaipur highway',2,350,'Chittorgarh'),(3,NULL,NULL,NULL,'Explore City Palace, Boat Ride in Lake Pichola',3,200,'Udaipur'),(4,NULL,NULL,NULL,'Morning visit to India Gate, Afternoon at Qutub Minar',1,0,'Delhi'),(4,NULL,NULL,NULL,'Drive through Yamuna Expressway',2,180,'Mathura'),(4,NULL,NULL,NULL,'Visit Taj Mahal, Agra Fort',3,60,'Agra'),(5,NULL,NULL,NULL,'Morning yoga session, Afternoon visit to Lalbagh Botanical Garden',1,0,'Bangalore'),(5,NULL,NULL,NULL,'Scenic drive to Mysore',2,140,'Mysore'),(5,NULL,NULL,NULL,'Trek through coffee plantations, Evening campfire',3,120,'Coorg');
/*!40000 ALTER TABLE `day_plan` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-24 10:20:51
