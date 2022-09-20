-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 08, 2019 at 04:27 AM
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
-- Database: `computerfirm`
--

-- --------------------------------------------------------

--
-- Table structure for table `contract`
--

CREATE TABLE `contract` (
  `conID` int(11) NOT NULL,
  `conName` varchar(50) DEFAULT NULL,
  `conDesc` varchar(100) DEFAULT NULL,
  `conDate` datetime DEFAULT CURRENT_TIMESTAMP,
  `conType` varchar(20) DEFAULT NULL,
  `conLeaderID` varchar(10) DEFAULT '-',
  `cusName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `contract`
--

INSERT INTO `contract` (`conID`, `conName`, `conDesc`, `conDate`, `conType`, `conLeaderID`, `cusName`) VALUES
(1, 'Upgade to windows 10', 'Upgrade the current windows version in HP qw123 to windows 10', '2019-04-07 06:23:58', 'Software upgrade', '10', 'Michael Jones'),
(2, 'Motherboard repair', 'Repair the power filure in ACER QW123', '2019-04-07 06:26:04', 'Sytem Development', '22', 'Tom Tomson'),
(3, 'RAM upgrade', 'Upgrade RAM from 2gb to 16gb in MSI QW123', '2019-04-07 06:27:53', 'System Upgrade', '21', 'Simpson De Ville'),
(4, 'Install SSD', 'Add a M.2 nVMe SSD 512GB  and replace the DVD-drive with the hard- disk', '2019-04-07 06:30:03', 'System Upgrade', '8', 'Andrew Clark'),
(5, 'Repair speakers', 'Repair the speakers of ALIENWARE QW123 if possible or else replace with new ones', '2019-04-07 06:32:24', 'System Repair', '14', 'Leornado Angelo'),
(6, 'Replace display', 'Repair if possible or else replace with a new one', '2019-04-07 06:33:57', 'System Upgrade', '21', 'Tim Buktoo'),
(7, 'Install software', 'Install all software needed for software development ', '2019-04-07 06:41:28', 'Software Upgrade', '23', 'Ellen Bowen');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `cusID` int(11) NOT NULL,
  `cusName` varchar(50) DEFAULT NULL,
  `cusContact` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`cusID`, `cusName`, `cusContact`) VALUES
(1, 'Michael Jones', '0215789321'),
(2, 'Tom Tomson', '0548793214'),
(3, 'Simpson De Ville', '0145239875'),
(4, 'Andrew Clark', '0125469876'),
(5, 'Leornado Angelo', '0456258796'),
(6, 'Tim Buktoo', '02564789641'),
(7, 'Ellen Bowen', '0124578965');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `empID` int(11) NOT NULL,
  `empName` varchar(100) DEFAULT NULL,
  `empDOB` varchar(20) DEFAULT NULL,
  `empContact` varchar(20) DEFAULT NULL,
  `empRole` varchar(100) DEFAULT NULL,
  `empSalary` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`empID`, `empName`, `empDOB`, `empContact`, `empRole`, `empSalary`) VALUES
(8, 'Michael', '21/06/1798', '0245869325', 'Hardware Technician', 70000),
(10, 'Jackson', '23/05/1795', '0245698745', 'Hardware Technician', 75000),
(13, 'Tomson', '11/11/1711', '0124563987', 'Hardware Technician  Programmer and Software Installer', 11200),
(14, 'Simpson', '31/04/1788', '0145698758', 'Programmer', 4800),
(15, 'Anderson', '12/03/1800', '0147852369', 'Programmer Software Installer', 12000),
(20, 'Tom', '30/02/1789', '0142589765', 'Programmer and Software Installer', 10000),
(21, 'Sally', '29/05/1769', '02478936523', 'Hardware Technician', 3000),
(22, 'Jojoba', '16/05/1768', '02458796332', 'Programmer', 6000),
(23, 'Tommy', '31/11/1795', '0125478965', 'Hardware Technician  Programmer and Software Installer', 9600);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `contract`
--
ALTER TABLE `contract`
  ADD PRIMARY KEY (`conID`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`cusID`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`empID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `contract`
--
ALTER TABLE `contract`
  MODIFY `conID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `cusID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `empID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
