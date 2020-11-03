-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 192.168.21.128    Database: movieRental
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Actor`
--

DROP TABLE IF EXISTS `Actor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Actor` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `First_Name` varchar(255) DEFAULT NULL,
  `Last_Name` varchar(255) DEFAULT NULL,
  `Last_Update` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Actor`
--

LOCK TABLES `Actor` WRITE;
/*!40000 ALTER TABLE `Actor` DISABLE KEYS */;
/*!40000 ALTER TABLE `Actor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Address`
--

DROP TABLE IF EXISTS `Address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Address` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `CityID` int NOT NULL,
  `Address` varchar(50) DEFAULT NULL,
  `Address2` varchar(50) DEFAULT NULL,
  `District` int DEFAULT NULL,
  `Postal_Code` varchar(10) DEFAULT NULL,
  `Phone` varchar(20) DEFAULT NULL,
  `Last_Update` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKAddress207677` (`CityID`),
  CONSTRAINT `FKAddress207677` FOREIGN KEY (`CityID`) REFERENCES `City` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Address`
--

LOCK TABLES `Address` WRITE;
/*!40000 ALTER TABLE `Address` DISABLE KEYS */;
/*!40000 ALTER TABLE `Address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Category`
--

DROP TABLE IF EXISTS `Category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Category` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(25) DEFAULT NULL,
  `Last_Update` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Category`
--

LOCK TABLES `Category` WRITE;
/*!40000 ALTER TABLE `Category` DISABLE KEYS */;
/*!40000 ALTER TABLE `Category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `City`
--

DROP TABLE IF EXISTS `City`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `City` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `CountryID` int NOT NULL,
  `City` varchar(50) DEFAULT NULL,
  `Last_Update` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKCity241219` (`CountryID`),
  CONSTRAINT `FKCity241219` FOREIGN KEY (`CountryID`) REFERENCES `Country` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `City`
--

LOCK TABLES `City` WRITE;
/*!40000 ALTER TABLE `City` DISABLE KEYS */;
/*!40000 ALTER TABLE `City` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Country`
--

DROP TABLE IF EXISTS `Country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Country` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Country` varchar(50) DEFAULT NULL,
  `Last_Update` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Country`
--

LOCK TABLES `Country` WRITE;
/*!40000 ALTER TABLE `Country` DISABLE KEYS */;
/*!40000 ALTER TABLE `Country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Customer`
--

DROP TABLE IF EXISTS `Customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Customer` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `AddressID` int NOT NULL,
  `AddressColumn` int NOT NULL,
  `First_Name` varchar(255) DEFAULT NULL,
  `Last_Name` varchar(255) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Active` char(1) DEFAULT NULL,
  `Create_Date` timestamp NULL DEFAULT NULL,
  `Last_Update` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKCustomer673544` (`AddressID`),
  CONSTRAINT `FKCustomer673544` FOREIGN KEY (`AddressID`) REFERENCES `Address` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Customer`
--

LOCK TABLES `Customer` WRITE;
/*!40000 ALTER TABLE `Customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `Customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Film`
--

DROP TABLE IF EXISTS `Film`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Film` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `LanguageID` int NOT NULL,
  `Title` varchar(255) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `Release_Year` int DEFAULT NULL,
  `Rental_Duration` int DEFAULT NULL,
  `Rental_Rate` decimal(19,0) DEFAULT NULL,
  `Length` int DEFAULT NULL,
  `Replacement_Cost` decimal(19,0) DEFAULT NULL,
  `Rating` int DEFAULT NULL,
  `Last_Update` timestamp NULL DEFAULT NULL,
  `Special_Features` varchar(255) DEFAULT NULL,
  `Fulltext` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKFilm233048` (`LanguageID`),
  CONSTRAINT `FKFilm233048` FOREIGN KEY (`LanguageID`) REFERENCES `Language` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Film`
--

LOCK TABLES `Film` WRITE;
/*!40000 ALTER TABLE `Film` DISABLE KEYS */;
/*!40000 ALTER TABLE `Film` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Film_Actor`
--

DROP TABLE IF EXISTS `Film_Actor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Film_Actor` (
  `FilmID` int NOT NULL,
  `ActorID` int NOT NULL,
  `Last_Update` timestamp NULL DEFAULT NULL,
  KEY `FKFilm_Actor797332` (`FilmID`),
  KEY `FKFilm_Actor605325` (`ActorID`),
  CONSTRAINT `FKFilm_Actor605325` FOREIGN KEY (`ActorID`) REFERENCES `Actor` (`ID`),
  CONSTRAINT `FKFilm_Actor797332` FOREIGN KEY (`FilmID`) REFERENCES `Film` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Film_Actor`
--

LOCK TABLES `Film_Actor` WRITE;
/*!40000 ALTER TABLE `Film_Actor` DISABLE KEYS */;
/*!40000 ALTER TABLE `Film_Actor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Film_Category`
--

DROP TABLE IF EXISTS `Film_Category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Film_Category` (
  `FilmID` int NOT NULL,
  `CategoryID` int NOT NULL,
  `Last_Update` timestamp NULL DEFAULT NULL,
  KEY `FKFilm_Categ915069` (`CategoryID`),
  KEY `FKFilm_Categ712904` (`FilmID`),
  CONSTRAINT `FKFilm_Categ712904` FOREIGN KEY (`FilmID`) REFERENCES `Film` (`ID`),
  CONSTRAINT `FKFilm_Categ915069` FOREIGN KEY (`CategoryID`) REFERENCES `Category` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Film_Category`
--

LOCK TABLES `Film_Category` WRITE;
/*!40000 ALTER TABLE `Film_Category` DISABLE KEYS */;
/*!40000 ALTER TABLE `Film_Category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Inventory`
--

DROP TABLE IF EXISTS `Inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Inventory` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `FilmID` int NOT NULL,
  `Last_Update` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKInventory897443` (`FilmID`),
  CONSTRAINT `FKInventory897443` FOREIGN KEY (`FilmID`) REFERENCES `Film` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Inventory`
--

LOCK TABLES `Inventory` WRITE;
/*!40000 ALTER TABLE `Inventory` DISABLE KEYS */;
/*!40000 ALTER TABLE `Inventory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Language`
--

DROP TABLE IF EXISTS `Language`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Language` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) DEFAULT NULL,
  `Last_Update` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Language`
--

LOCK TABLES `Language` WRITE;
/*!40000 ALTER TABLE `Language` DISABLE KEYS */;
/*!40000 ALTER TABLE `Language` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Payment`
--

DROP TABLE IF EXISTS `Payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Payment` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `RentalID` int NOT NULL,
  `CustomerID` int NOT NULL,
  `StaffID` int NOT NULL,
  `Amount` decimal(19,0) DEFAULT NULL,
  `Payment_Date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKPayment287944` (`RentalID`),
  KEY `FKPayment75777` (`CustomerID`),
  KEY `FKPayment275761` (`StaffID`),
  CONSTRAINT `FKPayment275761` FOREIGN KEY (`StaffID`) REFERENCES `Staff` (`ID`),
  CONSTRAINT `FKPayment287944` FOREIGN KEY (`RentalID`) REFERENCES `Rental` (`ID`),
  CONSTRAINT `FKPayment75777` FOREIGN KEY (`CustomerID`) REFERENCES `Customer` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Payment`
--

LOCK TABLES `Payment` WRITE;
/*!40000 ALTER TABLE `Payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `Payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Rental`
--

DROP TABLE IF EXISTS `Rental`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Rental` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `StaffID` int NOT NULL,
  `CustomerID` int NOT NULL,
  `InventoryID` int NOT NULL,
  `Rental_Date` timestamp NULL DEFAULT NULL,
  `Return_Date` timestamp NULL DEFAULT NULL,
  `Last_Update` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKRental408601` (`StaffID`),
  KEY `FKRental331820` (`InventoryID`),
  KEY `FKRental608585` (`CustomerID`),
  CONSTRAINT `FKRental331820` FOREIGN KEY (`InventoryID`) REFERENCES `Inventory` (`ID`),
  CONSTRAINT `FKRental408601` FOREIGN KEY (`StaffID`) REFERENCES `Staff` (`ID`),
  CONSTRAINT `FKRental608585` FOREIGN KEY (`CustomerID`) REFERENCES `Customer` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Rental`
--

LOCK TABLES `Rental` WRITE;
/*!40000 ALTER TABLE `Rental` DISABLE KEYS */;
/*!40000 ALTER TABLE `Rental` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Staff`
--

DROP TABLE IF EXISTS `Staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Staff` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `AddressID` int NOT NULL,
  `StoreID` int NOT NULL,
  `PaymentID` int NOT NULL,
  `First_Name` varchar(255) DEFAULT NULL,
  `Last_Name` varchar(255) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Active` char(1) DEFAULT NULL,
  `Username` varchar(16) DEFAULT NULL,
  `Password` varchar(40) DEFAULT NULL,
  `Last_Update` timestamp NULL DEFAULT NULL,
  `PictureURL` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKStaff288981` (`AddressID`),
  KEY `FKStaff192835` (`StoreID`),
  CONSTRAINT `FKStaff192835` FOREIGN KEY (`StoreID`) REFERENCES `Store` (`ID`),
  CONSTRAINT `FKStaff288981` FOREIGN KEY (`AddressID`) REFERENCES `Address` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Staff`
--

LOCK TABLES `Staff` WRITE;
/*!40000 ALTER TABLE `Staff` DISABLE KEYS */;
/*!40000 ALTER TABLE `Staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Store`
--

DROP TABLE IF EXISTS `Store`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Store` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `AddressID` int NOT NULL,
  `Last_Update` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKStore275156` (`AddressID`),
  CONSTRAINT `FKStore275156` FOREIGN KEY (`AddressID`) REFERENCES `Address` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Store`
--

LOCK TABLES `Store` WRITE;
/*!40000 ALTER TABLE `Store` DISABLE KEYS */;
/*!40000 ALTER TABLE `Store` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-03 13:22:53
