-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: covid
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `acceso`
--

DROP TABLE IF EXISTS `acceso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `acceso` (
  `id` int NOT NULL AUTO_INCREMENT,
  `registro_id` int DEFAULT NULL,
  `fechareg` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `estado` int DEFAULT NULL COMMENT 'Define el estado si fue correcto o se genera un error por no permitir el acceso',
  PRIMARY KEY (`id`),
  KEY `FK_acceso_registro_idx` (`registro_id`),
  CONSTRAINT `FK_acceso_registro` FOREIGN KEY (`registro_id`) REFERENCES `registro` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 COMMENT='Almacena el acceso de la persona a la institucion';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acceso`
--

LOCK TABLES `acceso` WRITE;
/*!40000 ALTER TABLE `acceso` DISABLE KEYS */;
INSERT INTO `acceso` VALUES (3,6,NULL,0),(4,NULL,NULL,0);
/*!40000 ALTER TABLE `acceso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `accesovisitante`
--

DROP TABLE IF EXISTS `accesovisitante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accesovisitante` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `temperatura` float DEFAULT NULL,
  `visitante_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_accesovisitante_visitante` (`visitante_id`),
  CONSTRAINT `FK_accesovisitante_visitante` FOREIGN KEY (`visitante_id`) REFERENCES `visitante` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accesovisitante`
--

LOCK TABLES `accesovisitante` WRITE;
/*!40000 ALTER TABLE `accesovisitante` DISABLE KEYS */;
INSERT INTO `accesovisitante` VALUES (1,'2020-06-25',36.6,1),(2,'2020-06-25',35,2);
/*!40000 ALTER TABLE `accesovisitante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `basico`
--

DROP TABLE IF EXISTS `basico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `basico` (
  `id` int NOT NULL AUTO_INCREMENT,
  `documento` varchar(20) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `fechanacimiento` date DEFAULT NULL,
  `genero` varchar(1) DEFAULT NULL,
  `eps_id` int DEFAULT NULL,
  `modalidad_id` int DEFAULT NULL,
  `tipo_id` int DEFAULT NULL,
  `embarazo` tinyint(1) DEFAULT NULL,
  `contactonombre` varchar(50) DEFAULT NULL,
  `contactotelefono` varchar(20) DEFAULT NULL,
  `mas60` tinyint(1) DEFAULT NULL,
  `menos15` tinyint(1) DEFAULT NULL,
  `salud` tinyint(1) DEFAULT NULL,
  `fechareg` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_basico_eps` (`eps_id`),
  KEY `FK_basico_modalidad` (`modalidad_id`),
  KEY `FK_basico_tipo` (`tipo_id`),
  CONSTRAINT `FK_basico_eps` FOREIGN KEY (`eps_id`) REFERENCES `eps` (`id`),
  CONSTRAINT `FK_basico_tipo` FOREIGN KEY (`tipo_id`) REFERENCES `tipo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `basico`
--

LOCK TABLES `basico` WRITE;
/*!40000 ALTER TABLE `basico` DISABLE KEYS */;
INSERT INTO `basico` VALUES (1,'1150001','www','222','0002-02-02','m',1,1,1,0,NULL,NULL,0,0,0,NULL),(2,'1150001','ddd','222','0002-02-02','m',1,1,1,0,'dds','22',0,0,0,NULL),(5,'1150002','aaaa','333','0002-02-02','m',1,1,1,0,'www','222',0,0,0,NULL),(6,'1150002','aaaa','333','0002-02-02','m',1,1,1,0,'2','22',0,0,0,NULL),(7,'1150002','aaaa','333','0002-02-02','m',1,1,1,0,'eee','22',0,0,0,NULL),(8,'1150002','aaaa','333','0002-02-02','m',1,1,1,0,'s','222',0,0,0,NULL),(9,'1150001','ddd','22','0002-02-02','m',1,1,1,0,'ss','22',0,0,0,NULL);
/*!40000 ALTER TABLE `basico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cormobilidad`
--

DROP TABLE IF EXISTS `cormobilidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cormobilidad` (
  `id` int NOT NULL AUTO_INCREMENT,
  `diabetes` tinyint(1) DEFAULT NULL,
  `cardio` tinyint(1) DEFAULT NULL,
  `cerebro` tinyint(1) DEFAULT NULL,
  `vih` tinyint(1) DEFAULT NULL,
  `cancer` tinyint(1) DEFAULT NULL,
  `corticoides` tinyint(1) DEFAULT NULL,
  `epoc` tinyint(1) DEFAULT NULL,
  `nutricion` tinyint(1) DEFAULT NULL,
  `fumador` tinyint(1) DEFAULT NULL,
  `fechareg` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COMMENT='Almacena la informaci?n de las enfermedades de las personas que ingresan a la Universdiad';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cormobilidad`
--

LOCK TABLES `cormobilidad` WRITE;
/*!40000 ALTER TABLE `cormobilidad` DISABLE KEYS */;
INSERT INTO `cormobilidad` VALUES (1,0,0,0,0,0,0,0,0,0,NULL),(2,0,0,0,0,0,0,0,0,0,NULL);
/*!40000 ALTER TABLE `cormobilidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empresa` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(200) DEFAULT NULL COMMENT 'Almacena el nombre de la empresa',
  `endpoint` varchar(500) DEFAULT NULL COMMENT 'Almacena el endpoint para validar los datos de la empresa',
  `estado` tinyint(1) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COMMENT='Almacena la informacion de la empresa';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` VALUES (1,'Universidad Francisco de Paula Santander','http://siaweb.ufps.edu.co/prueba.php',1,'ufps'),(2,'Universidad Simón Bolivar','http://siaweb.ufps.edu.co/prueba.php',1,'unisimon');
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eps`
--

DROP TABLE IF EXISTS `eps`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `eps` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eps`
--

LOCK TABLES `eps` WRITE;
/*!40000 ALTER TABLE `eps` DISABLE KEYS */;
INSERT INTO `eps` VALUES (1,'Coomeva'),(2,'Sanitas'),(3,'Nueva EPS'),(5,'Comparta'),(6,'Comfacor');
/*!40000 ALTER TABLE `eps` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modalidad`
--

DROP TABLE IF EXISTS `modalidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `modalidad` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COMMENT='Almacena la modalidad de la persona';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modalidad`
--

LOCK TABLES `modalidad` WRITE;
/*!40000 ALTER TABLE `modalidad` DISABLE KEYS */;
INSERT INTO `modalidad` VALUES (1,'Trabajo en casa'),(2,'Presencial');
/*!40000 ALTER TABLE `modalidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registro`
--

DROP TABLE IF EXISTS `registro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registro` (
  `id` int NOT NULL AUTO_INCREMENT,
  `persona_id` int DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `tos` tinyint(1) DEFAULT NULL,
  `malestar` tinyint(1) DEFAULT NULL,
  `fatiga` tinyint(1) DEFAULT NULL,
  `nasal` tinyint(1) DEFAULT NULL,
  `garganta` tinyint(1) DEFAULT NULL,
  `dificultad` tinyint(1) DEFAULT NULL,
  `temperatura` decimal(3,1) DEFAULT NULL,
  `fechareg` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `covid` tinyint(1) DEFAULT NULL COMMENT 'Almacena si la persona ha estado en contacto ',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_registro` (`persona_id`,`fecha`),
  CONSTRAINT `FK_registro_basico` FOREIGN KEY (`persona_id`) REFERENCES `basico` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1 COMMENT='Almacena el registro de ingreso del personal';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registro`
--

LOCK TABLES `registro` WRITE;
/*!40000 ALTER TABLE `registro` DISABLE KEYS */;
INSERT INTO `registro` VALUES (6,9,'2020-06-25',0,0,0,0,0,0,NULL,NULL,0);
/*!40000 ALTER TABLE `registro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COMMENT='Almacena informaci?n de los roles del docente';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'Administrador'),(2,'Usuario');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo`
--

DROP TABLE IF EXISTS `tipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) DEFAULT NULL,
  `empresa_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_tipo_empresa` (`empresa_id`),
  CONSTRAINT `FK_tipo_empresa` FOREIGN KEY (`empresa_id`) REFERENCES `empresa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1 COMMENT='Almacena el tipo de personas de la empresa';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo`
--

LOCK TABLES `tipo` WRITE;
/*!40000 ALTER TABLE `tipo` DISABLE KEYS */;
INSERT INTO `tipo` VALUES (1,'Docente',1),(2,'Estudiante',1),(3,'Administrativo',1),(4,'Contratista',1),(5,'Profesor',2),(6,'Estudiante',2),(7,'Adminsitrativo',2);
/*!40000 ALTER TABLE `tipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `empresa_id` int DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(150) DEFAULT NULL,
  `rol_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_usuario_empresa` (`empresa_id`),
  KEY `FK_usuario_rol` (`rol_id`),
  CONSTRAINT `FK_usuario_empresa` FOREIGN KEY (`empresa_id`) REFERENCES `empresa` (`id`),
  CONSTRAINT `FK_usuario_rol` FOREIGN KEY (`rol_id`) REFERENCES `rol` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COMMENT='Almacena la informaci?n de los usuarios del sistema';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,1,'brayan','b@gmail.com','$2a$10$yvQ..NBIfOnSstvlRHrlU.IkCKst.6Im840hzZDpHWtHjhAvEtXba',1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visitante`
--

DROP TABLE IF EXISTS `visitante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `visitante` (
  `id` int NOT NULL AUTO_INCREMENT,
  `documento` varchar(20) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `fechanacimiento` date DEFAULT NULL,
  `eps_id` int DEFAULT NULL,
  `genero` varchar(1) DEFAULT NULL,
  `empresa_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_visitante_empresa` (`empresa_id`),
  CONSTRAINT `FK_visitante_empresa` FOREIGN KEY (`empresa_id`) REFERENCES `empresa` (`id`),
  CONSTRAINT `FK_vistante_esp` FOREIGN KEY (`id`) REFERENCES `eps` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COMMENT='Almacen la infromaci?n de los visitantes';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visitante`
--

LOCK TABLES `visitante` WRITE;
/*!40000 ALTER TABLE `visitante` DISABLE KEYS */;
INSERT INTO `visitante` VALUES (1,'2','brayan david','2000-02-02',2,'m',NULL),(2,'22','ffff','0002-02-02',NULL,'m',NULL);
/*!40000 ALTER TABLE `visitante` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-25 20:53:42
