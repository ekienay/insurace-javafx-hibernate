-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: insurance
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `agent`
--

DROP TABLE IF EXISTS `agent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agent` (
  `id` int NOT NULL AUTO_INCREMENT,
  `FLP` varchar(45) NOT NULL,
  `login` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agent`
--

LOCK TABLES `agent` WRITE;
/*!40000 ALTER TABLE `agent` DISABLE KEYS */;
INSERT INTO `agent` VALUES (1,'Петр Дьяковский Александрович','petr34','8990'),(2,'Александр Волков Валерьевич','admin','admin');
/*!40000 ALTER TABLE `agent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `calculator`
--

DROP TABLE IF EXISTS `calculator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `calculator` (
  `id` int NOT NULL AUTO_INCREMENT,
  `base_cost` int NOT NULL,
  `KT` double DEFAULT NULL,
  `KBM` double DEFAULT NULL,
  `KVS` double DEFAULT NULL,
  `KO` double DEFAULT NULL,
  `KM` double DEFAULT NULL,
  `KS` double DEFAULT NULL,
  `KN` double DEFAULT NULL,
  `KP` double DEFAULT NULL,
  `final_cost` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calculator`
--

LOCK TABLES `calculator` WRITE;
/*!40000 ALTER TABLE `calculator` DISABLE KEYS */;
INSERT INTO `calculator` VALUES (20,4000,1.3,1.2,1,1,1.2,1,1,1,7488),(21,4000,1.3,1.2,1.3,1,1.2,1,1,1,9734),(22,4000,1.1,1.1,1,1,1.2,1,1,1,5808);
/*!40000 ALTER TABLE `calculator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `category_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'M'),(2,'A'),(3,'A1'),(4,'B'),(5,'B1'),(6,'BE'),(7,'C'),(8,'C1'),(9,'C1E'),(10,'CE'),(11,'D'),(12,'D1'),(13,'D1E'),(14,'DE'),(15,'Tm'),(16,'Tb');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category_to_license`
--

DROP TABLE IF EXISTS `category_to_license`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category_to_license` (
  `category_id` int NOT NULL,
  `drv_license_id` int NOT NULL,
  KEY `fk_category_to_license_category1_idx` (`category_id`),
  KEY `fk_category_to_license_drv_license1_idx` (`drv_license_id`),
  CONSTRAINT `fk_category_to_license_category1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `fk_category_to_license_drv_license1` FOREIGN KEY (`drv_license_id`) REFERENCES `drv_license` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_to_license`
--

LOCK TABLES `category_to_license` WRITE;
/*!40000 ALTER TABLE `category_to_license` DISABLE KEYS */;
INSERT INTO `category_to_license` VALUES (14,9),(4,9),(16,9),(7,10),(4,10),(1,11),(14,11),(4,11);
/*!40000 ALTER TABLE `category_to_license` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `certificate_dimmatriculation`
--

DROP TABLE IF EXISTS `certificate_dimmatriculation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `certificate_dimmatriculation` (
  `id` int NOT NULL AUTO_INCREMENT,
  `reg_plate` varchar(45) NOT NULL,
  `certificate_series` varchar(45) NOT NULL,
  `certificate_number` varchar(45) NOT NULL,
  `PTS_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_certificate_dimmatriculation_PTS1_idx` (`PTS_id`),
  CONSTRAINT `fk_certificate_dimmatriculation_PTS1` FOREIGN KEY (`PTS_id`) REFERENCES `pts` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `certificate_dimmatriculation`
--

LOCK TABLES `certificate_dimmatriculation` WRITE;
/*!40000 ALTER TABLE `certificate_dimmatriculation` DISABLE KEYS */;
INSERT INTO `certificate_dimmatriculation` VALUES (10,'0001','0001','0001',9),(11,'0002','0002','0002',10),(12,'0003','0003','0003',11);
/*!40000 ALTER TABLE `certificate_dimmatriculation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `driver`
--

DROP TABLE IF EXISTS `driver`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `driver` (
  `id` int NOT NULL AUTO_INCREMENT,
  `FLP` varchar(45) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `birth_date` date NOT NULL,
  `address` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `passport_series` varchar(45) NOT NULL,
  `passport_number` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `driver`
--

LOCK TABLES `driver` WRITE;
/*!40000 ALTER TABLE `driver` DISABLE KEYS */;
INSERT INTO `driver` VALUES (34,'Кириллов Артём Юрьевич','м','2007-05-31','г.Павлово','+7809123123','2213','1231313'),(35,'Иваков Александр Акимович','м','2007-05-31','г.Павлово','+7908131233','2189','89099'),(36,'Зеленова Светлана Олеговна','ж','2007-05-31','г.Павлово','+7907131331','1898','000000');
/*!40000 ALTER TABLE `driver` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `driver_to_osago`
--

DROP TABLE IF EXISTS `driver_to_osago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `driver_to_osago` (
  `driver_id` int NOT NULL,
  `osago_id` int NOT NULL,
  KEY `fk_driver_to_osago_driver1_idx` (`driver_id`),
  KEY `fk_driver_to_osago_osago1_idx` (`osago_id`),
  CONSTRAINT `fk_driver_to_osago_driver1` FOREIGN KEY (`driver_id`) REFERENCES `driver` (`id`),
  CONSTRAINT `fk_driver_to_osago_osago1` FOREIGN KEY (`osago_id`) REFERENCES `osago` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `driver_to_osago`
--

LOCK TABLES `driver_to_osago` WRITE;
/*!40000 ALTER TABLE `driver_to_osago` DISABLE KEYS */;
INSERT INTO `driver_to_osago` VALUES (34,24),(35,25),(36,26);
/*!40000 ALTER TABLE `driver_to_osago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drv_license`
--

DROP TABLE IF EXISTS `drv_license`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `drv_license` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date_of_issue` date NOT NULL,
  `date_expiration` date NOT NULL,
  `dapart_state_inspection` varchar(45) NOT NULL,
  `license_series` varchar(45) NOT NULL,
  `license_number` varchar(45) NOT NULL,
  `driver_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_drv_license_driver1_idx` (`driver_id`),
  CONSTRAINT `fk_drv_license_driver1` FOREIGN KEY (`driver_id`) REFERENCES `driver` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drv_license`
--

LOCK TABLES `drv_license` WRITE;
/*!40000 ALTER TABLE `drv_license` DISABLE KEYS */;
INSERT INTO `drv_license` VALUES (9,'1993-06-05','2003-06-05','ГИБДД','0003','0003',36),(10,'1994-06-05','2004-06-05','ГИБДД','0002','0002',35),(11,'1995-06-05','2005-06-05','ГИБДД','0001','0001',34);
/*!40000 ALTER TABLE `drv_license` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eco_class`
--

DROP TABLE IF EXISTS `eco_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `eco_class` (
  `id` int NOT NULL AUTO_INCREMENT,
  `eco_class` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eco_class`
--

LOCK TABLES `eco_class` WRITE;
/*!40000 ALTER TABLE `eco_class` DISABLE KEYS */;
INSERT INTO `eco_class` VALUES (1,'Евро-1'),(2,'Евро-2'),(3,'Евро-3'),(4,'Евро-4'),(5,'Евро-5');
/*!40000 ALTER TABLE `eco_class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mark_tc`
--

DROP TABLE IF EXISTS `mark_tc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mark_tc` (
  `id` int NOT NULL AUTO_INCREMENT,
  `TC_mark` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mark_tc`
--

LOCK TABLES `mark_tc` WRITE;
/*!40000 ALTER TABLE `mark_tc` DISABLE KEYS */;
INSERT INTO `mark_tc` VALUES (7,'BMW'),(8,'audi'),(9,'TOYOTA');
/*!40000 ALTER TABLE `mark_tc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `model_tc`
--

DROP TABLE IF EXISTS `model_tc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `model_tc` (
  `id` int NOT NULL AUTO_INCREMENT,
  `model` varchar(45) NOT NULL,
  `mark_TC_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_model_TC_mark_TC1_idx` (`mark_TC_id`),
  CONSTRAINT `fk_model_TC_mark_TC1` FOREIGN KEY (`mark_TC_id`) REFERENCES `mark_tc` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `model_tc`
--

LOCK TABLES `model_tc` WRITE;
/*!40000 ALTER TABLE `model_tc` DISABLE KEYS */;
INSERT INTO `model_tc` VALUES (6,'x5',7),(7,'A4',8),(8,'Tundra',9);
/*!40000 ALTER TABLE `model_tc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `osago`
--

DROP TABLE IF EXISTS `osago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `osago` (
  `id` int NOT NULL AUTO_INCREMENT,
  `osago_series` varchar(45) NOT NULL,
  `osago_number` varchar(45) NOT NULL,
  `start_insurance` date NOT NULL,
  `end_insurance` date NOT NULL,
  `date_of_issue` date NOT NULL,
  `agent_id` int NOT NULL,
  `calculator_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_osago_agent1_idx` (`agent_id`),
  KEY `fk_osago_calculator1_idx` (`calculator_id`),
  CONSTRAINT `fk_osago_agent1` FOREIGN KEY (`agent_id`) REFERENCES `agent` (`id`),
  CONSTRAINT `fk_osago_calculator1` FOREIGN KEY (`calculator_id`) REFERENCES `calculator` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `osago`
--

LOCK TABLES `osago` WRITE;
/*!40000 ALTER TABLE `osago` DISABLE KEYS */;
INSERT INTO `osago` VALUES (24,'0001','0001','2003-06-05','2004-06-05','2003-06-05',1,20),(25,'0002','0002','2004-06-05','2005-06-05','2004-06-05',1,21),(26,'0003','0003','2005-06-05','2006-06-05','2005-06-05',1,22);
/*!40000 ALTER TABLE `osago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pts`
--

DROP TABLE IF EXISTS `pts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pts` (
  `id` int NOT NULL AUTO_INCREMENT,
  `PTS_series` varchar(45) NOT NULL,
  `PTS_number` varchar(45) NOT NULL,
  `VIN` varchar(45) NOT NULL,
  `year_manufacture` date NOT NULL,
  `trailer` varchar(45) NOT NULL,
  `color_trailer` varchar(45) NOT NULL,
  `power_engine_LS_kVT` varchar(45) NOT NULL,
  `engine_volume` varchar(45) NOT NULL,
  `max_weight` varchar(45) NOT NULL,
  `unladen_weight` varchar(45) NOT NULL,
  `manufacturer` varchar(45) NOT NULL,
  `country_imp_TC` varchar(45) NOT NULL,
  `series_number_TD_TPO` varchar(45) NOT NULL,
  `customs_restrictions` varchar(45) NOT NULL,
  `reg_name_organization` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `date_of_issue` date NOT NULL,
  `type_TC_id` int NOT NULL,
  `type_engine_id` int NOT NULL,
  `ECO_class_id` int NOT NULL,
  `model_TC_id` int NOT NULL,
  `driver_id` int NOT NULL,
  `category_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_PTS_type_TC_idx` (`type_TC_id`),
  KEY `fk_PTS_type_engine1_idx` (`type_engine_id`),
  KEY `fk_PTS_ECO_class1_idx` (`ECO_class_id`),
  KEY `fk_PTS_model_TC1_idx` (`model_TC_id`),
  KEY `fk_PTS_driver1_idx` (`driver_id`),
  KEY `fk_PTS_category1_idx` (`category_id`),
  CONSTRAINT `fk_PTS_category1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `fk_PTS_driver1` FOREIGN KEY (`driver_id`) REFERENCES `driver` (`id`),
  CONSTRAINT `fk_PTS_ECO_class1` FOREIGN KEY (`ECO_class_id`) REFERENCES `eco_class` (`id`),
  CONSTRAINT `fk_PTS_model_TC1` FOREIGN KEY (`model_TC_id`) REFERENCES `model_tc` (`id`),
  CONSTRAINT `fk_PTS_type_engine1` FOREIGN KEY (`type_engine_id`) REFERENCES `type_engine` (`id`),
  CONSTRAINT `fk_PTS_type_TC` FOREIGN KEY (`type_TC_id`) REFERENCES `type_tc` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pts`
--

LOCK TABLES `pts` WRITE;
/*!40000 ALTER TABLE `pts` DISABLE KEYS */;
INSERT INTO `pts` VALUES (9,'0001','0001','0001','1999-03-07','отсутствует','отсутствует','120','30','800','1120','China','China','отсутствует','отсутствует','ГИБДД','г.Павлово','2003-06-05',1,1,1,6,34,4),(10,'0002','0002','0002','1999-03-07','отсутствует','отсутствует','120','30','800','1120','China','China','отсутствует','отсутствует','ГИБДД','г.Павлово','2004-06-05',1,1,2,7,35,4),(11,'0003','0003','0003','1999-03-07','отсутствует','отсутствует','120','30','800','1120','China','China','отсутствует','отсутствует','ГИБДД','г.Павлово','2005-06-05',1,1,5,8,36,4);
/*!40000 ALTER TABLE `pts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type_engine`
--

DROP TABLE IF EXISTS `type_engine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `type_engine` (
  `id` int NOT NULL AUTO_INCREMENT,
  `engine_type` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type_engine`
--

LOCK TABLES `type_engine` WRITE;
/*!40000 ALTER TABLE `type_engine` DISABLE KEYS */;
INSERT INTO `type_engine` VALUES (1,'бензиновый'),(2,'дизельный'),(3,'мотор'),(4,'газовый');
/*!40000 ALTER TABLE `type_engine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type_tc`
--

DROP TABLE IF EXISTS `type_tc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `type_tc` (
  `id` int NOT NULL AUTO_INCREMENT,
  `TC_type` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type_tc`
--

LOCK TABLES `type_tc` WRITE;
/*!40000 ALTER TABLE `type_tc` DISABLE KEYS */;
INSERT INTO `type_tc` VALUES (1,'легковой'),(2,'грузовой'),(3,'автобус'),(4,'мотоцикл');
/*!40000 ALTER TABLE `type_tc` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-11  4:17:09
