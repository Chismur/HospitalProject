CREATE DATABASE  IF NOT EXISTS `mydb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mydb`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mydb
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `current_condition`
--

DROP TABLE IF EXISTS `current_condition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `current_condition` (
  `id_current_condition` int(11) NOT NULL AUTO_INCREMENT,
  `current_condition` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_current_condition`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `current_condition`
--

LOCK TABLES `current_condition` WRITE;
/*!40000 ALTER TABLE `current_condition` DISABLE KEYS */;
INSERT INTO `current_condition` VALUES (1,'is treated'),(2,'was cured'),(3,'sent to hospital'),(4,'died');
/*!40000 ALTER TABLE `current_condition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `date`
--

DROP TABLE IF EXISTS `date`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `date` (
  `id_date` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `date`
--

LOCK TABLES `date` WRITE;
/*!40000 ALTER TABLE `date` DISABLE KEYS */;
INSERT INTO `date` VALUES (1,'Monday'),(2,'Tuesday'),(3,'Wednesday'),(4,'Thursday'),(5,'Friday'),(6,'Saturday');
/*!40000 ALTER TABLE `date` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diognosis`
--

DROP TABLE IF EXISTS `diognosis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diognosis` (
  `id_diognosis` int(11) NOT NULL,
  `diognosis` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_diognosis`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diognosis`
--

LOCK TABLES `diognosis` WRITE;
/*!40000 ALTER TABLE `diognosis` DISABLE KEYS */;
INSERT INTO `diognosis` VALUES (1,'Acne'),(2,'Allergy'),(3,'Andropause'),(4,'Anorexia nervosa'),(5,'Arthritis'),(6,'Brain Cancer'),(7,'Asthma'),(8,'Back Pain'),(9,'Bipolar disorder'),(10,'Bone Cancer'),(11,'Burns'),(12,'Cholesterol'),(13,'Heart failure'),(14,'Dandruff'),(15,'Deep vein thrombosis'),(16,'Depression'),(17,'Diarrhea'),(18,'Ear Problems'),(19,'Eye Problems'),(20,'Flu'),(21,'Gonorrhea'),(22,'Headache'),(23,'Heartburn'),(24,'Heel Pain'),(25,'Hepatitis');
/*!40000 ALTER TABLE `diognosis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diognosis_has_visit`
--

DROP TABLE IF EXISTS `diognosis_has_visit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diognosis_has_visit` (
  `diognosis_id_diognosis` int(11) NOT NULL,
  `visit_id_visit` int(11) NOT NULL,
  PRIMARY KEY (`diognosis_id_diognosis`,`visit_id_visit`),
  KEY `fk_diognosis_has_visit_visit1_idx` (`visit_id_visit`),
  KEY `fk_diognosis_has_visit_diognosis1_idx` (`diognosis_id_diognosis`),
  CONSTRAINT `fk_diognosis_has_visit_diognosis1` FOREIGN KEY (`diognosis_id_diognosis`) REFERENCES `diognosis` (`id_diognosis`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_diognosis_has_visit_visit1` FOREIGN KEY (`visit_id_visit`) REFERENCES `visit` (`id_visit`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diognosis_has_visit`
--

LOCK TABLES `diognosis_has_visit` WRITE;
/*!40000 ALTER TABLE `diognosis_has_visit` DISABLE KEYS */;
INSERT INTO `diognosis_has_visit` VALUES (4,1);
/*!40000 ALTER TABLE `diognosis_has_visit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doctor` (
  `id_doctor` int(11) NOT NULL AUTO_INCREMENT,
  `d_name` varchar(45) DEFAULT NULL,
  `d_surname` varchar(45) DEFAULT NULL,
  `id_position` int(11) NOT NULL,
  `id_qualification` int(11) NOT NULL,
  `id_specialization` int(11) NOT NULL,
  PRIMARY KEY (`id_doctor`),
  KEY `id_qualification_idx` (`id_qualification`),
  KEY `id_specialization_idx` (`id_specialization`),
  KEY `position_idx` (`id_position`),
  CONSTRAINT `id_qualification` FOREIGN KEY (`id_qualification`) REFERENCES `qualification` (`id_qualification`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_specialization` FOREIGN KEY (`id_specialization`) REFERENCES `specialization` (`id_specialization`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `position` FOREIGN KEY (`id_position`) REFERENCES `position` (`id_position`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES (1,'Alexandr','Kitaev',1,2,7),(2,'Pavel','Kiktev',1,1,2),(3,'Stats','Volvgan',1,2,12),(4,'Igor','Amadey',1,2,3),(5,'Emil','Jabrail',1,1,8),(6,'Ivan','Sochnik',1,1,13),(7,'Petr','Fernans',2,4,9),(8,'Nikola','Kepler',1,3,4),(9,'Matvey','Santa',2,4,5),(10,'Lisa','Gromur',1,2,10),(11,'Maria','Leiblo',1,1,1),(12,'Fekla','Khalib',2,4,6),(13,'Lex','Dicanto',1,3,11),(14,'Lutor','Konor',1,2,14),(15,'matvey','malik',1,1,1);
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient` (
  `id_patient` int(11) NOT NULL AUTO_INCREMENT,
  `p_name` varchar(45) DEFAULT NULL,
  `p_surname` varchar(45) DEFAULT NULL,
  `b_date` date DEFAULT NULL,
  `id_social_status` int(11) NOT NULL,
  `id_current_condition` int(11) NOT NULL,
  PRIMARY KEY (`id_patient`),
  KEY `id_current_condition_idx` (`id_current_condition`),
  KEY `id_social_status_idx` (`id_social_status`),
  CONSTRAINT `id_current_condition` FOREIGN KEY (`id_current_condition`) REFERENCES `current_condition` (`id_current_condition`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_social_status` FOREIGN KEY (`id_social_status`) REFERENCES `social_status` (`id_social_status`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (1,'Max','Fry','1996-08-09',1,1),(2,'Andrey','Simens','1990-12-28',5,3),(3,'Steve','Martin','1996-04-07',2,2);
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position`
--

DROP TABLE IF EXISTS `position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `position` (
  `id_position` int(11) NOT NULL AUTO_INCREMENT,
  `position` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_position`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position`
--

LOCK TABLES `position` WRITE;
/*!40000 ALTER TABLE `position` DISABLE KEYS */;
INSERT INTO `position` VALUES (1,'doctor'),(2,'chief doc'),(3,'nurse');
/*!40000 ALTER TABLE `position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qualification`
--

DROP TABLE IF EXISTS `qualification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qualification` (
  `id_qualification` int(11) NOT NULL AUTO_INCREMENT,
  `qualification` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_qualification`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qualification`
--

LOCK TABLES `qualification` WRITE;
/*!40000 ALTER TABLE `qualification` DISABLE KEYS */;
INSERT INTO `qualification` VALUES (1,'first'),(2,'second'),(3,'third'),(4,'fourth');
/*!40000 ALTER TABLE `qualification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `queue`
--

DROP TABLE IF EXISTS `queue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `queue` (
  `id_queue` int(11) NOT NULL,
  `current_date` date DEFAULT NULL,
  `cab_num` int(11) DEFAULT NULL,
  `visit_has_specialization_id_visit_has_specialization` int(11) DEFAULT NULL,
  `id_doctor` int(11) NOT NULL,
  `id_timetable` int(11) DEFAULT NULL,
  `id_weekday` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_queue`),
  KEY `fk_queue_visit_has_specialization1_idx` (`visit_has_specialization_id_visit_has_specialization`),
  KEY `fk_queue_doctor_idx` (`id_doctor`),
  KEY `fk_queue_date_idx` (`id_weekday`),
  KEY `fk_queue_time_idx` (`id_timetable`),
  CONSTRAINT `fk_queue_date` FOREIGN KEY (`id_weekday`) REFERENCES `date` (`id_date`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_queue_doctor` FOREIGN KEY (`id_doctor`) REFERENCES `doctor` (`id_doctor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_queue_time` FOREIGN KEY (`id_timetable`) REFERENCES `time` (`id_time`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_queue_visit_has_specialization1` FOREIGN KEY (`visit_has_specialization_id_visit_has_specialization`) REFERENCES `visit_has_specialization` (`id_visit_has_specialization`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `queue`
--

LOCK TABLES `queue` WRITE;
/*!40000 ALTER TABLE `queue` DISABLE KEYS */;
INSERT INTO `queue` VALUES (1,'2017-09-11',13,0,4,4,4),(2,'2017-09-12',10,0,5,2,6);
/*!40000 ALTER TABLE `queue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_type`
--

DROP TABLE IF EXISTS `service_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `service_type` (
  `id_service_type` int(11) NOT NULL,
  `service_name` varchar(45) DEFAULT NULL,
  `service_price` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`id_service_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_type`
--

LOCK TABLES `service_type` WRITE;
/*!40000 ALTER TABLE `service_type` DISABLE KEYS */;
INSERT INTO `service_type` VALUES (1,'Coronary artery bypass',130.25),(2,'CFree skin graft',260.17),(3,'Hysteroscopy ',400.00),(4,'Low back pain surgery ',75.90),(5,'intestine  hernia repairs',305.88);
/*!40000 ALTER TABLE `service_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `services`
--

DROP TABLE IF EXISTS `services`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `services` (
  `id_services` int(11) NOT NULL,
  `service_type` int(11) NOT NULL,
  PRIMARY KEY (`id_services`),
  KEY `fk_services_service_type1_idx` (`service_type`),
  CONSTRAINT `fk_services_service_type1` FOREIGN KEY (`service_type`) REFERENCES `service_type` (`id_service_type`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `services`
--

LOCK TABLES `services` WRITE;
/*!40000 ALTER TABLE `services` DISABLE KEYS */;
INSERT INTO `services` VALUES (2,4),(1,5),(3,5);
/*!40000 ALTER TABLE `services` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `services_has_visit`
--

DROP TABLE IF EXISTS `services_has_visit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `services_has_visit` (
  `services_id_services` int(11) NOT NULL,
  `visit_id_visit` int(11) NOT NULL,
  PRIMARY KEY (`services_id_services`,`visit_id_visit`),
  KEY `fk_services_has_visit_visit1_idx` (`visit_id_visit`),
  KEY `fk_services_has_visit_services1_idx` (`services_id_services`),
  CONSTRAINT `fk_services_has_visit_services1` FOREIGN KEY (`services_id_services`) REFERENCES `services` (`id_services`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_services_has_visit_visit1` FOREIGN KEY (`visit_id_visit`) REFERENCES `visit` (`id_visit`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `services_has_visit`
--

LOCK TABLES `services_has_visit` WRITE;
/*!40000 ALTER TABLE `services_has_visit` DISABLE KEYS */;
INSERT INTO `services_has_visit` VALUES (1,1);
/*!40000 ALTER TABLE `services_has_visit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `social_status`
--

DROP TABLE IF EXISTS `social_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `social_status` (
  `id_social_status` int(11) NOT NULL AUTO_INCREMENT,
  `social_status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_social_status`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `social_status`
--

LOCK TABLES `social_status` WRITE;
/*!40000 ALTER TABLE `social_status` DISABLE KEYS */;
INSERT INTO `social_status` VALUES (1,'student'),(2,'worker'),(3,'unemployed'),(4,'disabled'),(5,'pensioner');
/*!40000 ALTER TABLE `social_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `specialization`
--

DROP TABLE IF EXISTS `specialization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `specialization` (
  `id_specialization` int(11) NOT NULL AUTO_INCREMENT,
  `specialization` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_specialization`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `specialization`
--

LOCK TABLES `specialization` WRITE;
/*!40000 ALTER TABLE `specialization` DISABLE KEYS */;
INSERT INTO `specialization` VALUES (1,'Allergist'),(2,'Cardiologist'),(3,'Dermatologist'),(4,'Endocrinologist'),(5,'Immunologist'),(6,'Neurologist'),(7,'Surgeon'),(8,'Oncologist'),(9,'Ophthalmologist'),(10,'Physiatrist'),(11,'Psychiatrist'),(12,'Urologist'),(13,'Gastroenterologist'),(14,'Diagnostician');
/*!40000 ALTER TABLE `specialization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `time`
--

DROP TABLE IF EXISTS `time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `time` (
  `id_time` int(11) NOT NULL,
  `time_start` time(4) DEFAULT NULL,
  `time_end` time(4) DEFAULT NULL,
  PRIMARY KEY (`id_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `time`
--

LOCK TABLES `time` WRITE;
/*!40000 ALTER TABLE `time` DISABLE KEYS */;
INSERT INTO `time` VALUES (1,'09:00:00.0000','10:00:00.0000'),(2,'10:30:00.0000','11:30:00.0000'),(3,'12:00:00.0000','13:00:00.0000'),(4,'14:00:00.0000','15:00:00.0000'),(5,'15:30:00.0000','16:30:00.0000'),(6,'17:00:00.0000','18:00:00.0000');
/*!40000 ALTER TABLE `time` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  ` id_user` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(45) DEFAULT NULL,
  `login` varchar(45) DEFAULT NULL,
  PRIMARY KEY (` id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'1234','matvey');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visit`
--

DROP TABLE IF EXISTS `visit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `visit` (
  `id_visit` int(11) NOT NULL AUTO_INCREMENT,
  `id_patient` int(11) NOT NULL,
  `date_cured` date DEFAULT NULL,
  `start_date_treatment` date DEFAULT NULL,
  `id_queue` int(11) NOT NULL,
  PRIMARY KEY (`id_visit`),
  KEY `id_patient_idx` (`id_patient`),
  KEY `fk_visit_queue1_idx` (`id_queue`),
  CONSTRAINT `fk_visit_queue1` FOREIGN KEY (`id_queue`) REFERENCES `queue` (`id_queue`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_patient` FOREIGN KEY (`id_patient`) REFERENCES `patient` (`id_patient`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visit`
--

LOCK TABLES `visit` WRITE;
/*!40000 ALTER TABLE `visit` DISABLE KEYS */;
INSERT INTO `visit` VALUES (1,1,'2017-09-11','2017-09-06',1),(2,2,'2017-09-10','2017-09-01',2);
/*!40000 ALTER TABLE `visit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visit_has_specialization`
--

DROP TABLE IF EXISTS `visit_has_specialization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `visit_has_specialization` (
  `id_visit_has_specialization` int(11) NOT NULL,
  `visit_id_visit` int(11) NOT NULL,
  `specialization_id_specialization` int(11) NOT NULL,
  PRIMARY KEY (`id_visit_has_specialization`),
  KEY `fk_visit_has_specialization_specialization1_idx` (`specialization_id_specialization`),
  KEY `fk_visit_has_specialization_visit1_idx` (`visit_id_visit`),
  CONSTRAINT `fk_visit_has_specialization_specialization1` FOREIGN KEY (`specialization_id_specialization`) REFERENCES `specialization` (`id_specialization`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_visit_has_specialization_visit1` FOREIGN KEY (`visit_id_visit`) REFERENCES `visit` (`id_visit`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visit_has_specialization`
--

LOCK TABLES `visit_has_specialization` WRITE;
/*!40000 ALTER TABLE `visit_has_specialization` DISABLE KEYS */;
/*!40000 ALTER TABLE `visit_has_specialization` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-04 22:23:20
