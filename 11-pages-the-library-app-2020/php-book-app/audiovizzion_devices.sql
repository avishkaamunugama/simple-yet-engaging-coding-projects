-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 06, 2019 at 12:29 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `audiovizzion_devices`
--

-- --------------------------------------------------------

--
-- Table structure for table `device`
--

CREATE TABLE `device` (
  `deviceCatalogId` int(11) NOT NULL,
  `deviceCatalogName` varchar(50) NOT NULL,
  `deviceDescrip` varchar(100) DEFAULT NULL,
  `availablityStatus` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `device`
--

INSERT INTO `device` (`deviceCatalogId`, `deviceCatalogName`, `deviceDescrip`, `availablityStatus`) VALUES
(17, 'War and Peace', 'Leo Tolstoy', 'Non-Fiction'),
(18, 'Song of Solomon', 'Toni Morrison', 'Legend Fantasy');

-- --------------------------------------------------------

--
-- Table structure for table `hearing_device`
--

CREATE TABLE `hearing_device` (
  `deviceCatalogId` int(11) NOT NULL,
  `hdMake` varchar(30) DEFAULT NULL,
  `hdModel` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hearing_device`
--

INSERT INTO `hearing_device` (`deviceCatalogId`, `hdMake`, `hdModel`) VALUES
(17, '6534253629278939X', '1987');

-- --------------------------------------------------------

--
-- Table structure for table `visual_device`
--

CREATE TABLE `visual_device` (
  `deviceCatalogId` int(11) NOT NULL,
  `frBrand` varchar(30) DEFAULT NULL,
  `frModel` varchar(20) DEFAULT NULL,
  `lensSerialNb` varchar(20) DEFAULT NULL,
  `lensThicknessLevel` varchar(20) DEFAULT NULL,
  `lensTint` varchar(20) DEFAULT NULL,
  `lensVisionType` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `visual_device`
--

INSERT INTO `visual_device` (`deviceCatalogId`, `frBrand`, `frModel`, `lensSerialNb`, `lensThicknessLevel`, `lensTint`, `lensVisionType`) VALUES
(18, 'Morrison Anderson Jr', 'mp3', '56 hrs and 78 mins', 'Harper Lee', 'Teens and beyond', '2001');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `device`
--
ALTER TABLE `device`
  ADD PRIMARY KEY (`deviceCatalogId`);

--
-- Indexes for table `hearing_device`
--
ALTER TABLE `hearing_device`
  ADD PRIMARY KEY (`deviceCatalogId`);

--
-- Indexes for table `visual_device`
--
ALTER TABLE `visual_device`
  ADD PRIMARY KEY (`deviceCatalogId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `device`
--
ALTER TABLE `device`
  MODIFY `deviceCatalogId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `hearing_device`
--
ALTER TABLE `hearing_device`
  MODIFY `deviceCatalogId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `visual_device`
--
ALTER TABLE `visual_device`
  MODIFY `deviceCatalogId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `hearing_device`
--
ALTER TABLE `hearing_device`
  ADD CONSTRAINT `hearing_device_ibfk_1` FOREIGN KEY (`deviceCatalogId`) REFERENCES `device` (`deviceCatalogId`);

--
-- Constraints for table `visual_device`
--
ALTER TABLE `visual_device`
  ADD CONSTRAINT `visual_device_ibfk_1` FOREIGN KEY (`deviceCatalogId`) REFERENCES `device` (`deviceCatalogId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
