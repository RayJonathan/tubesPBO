-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 21, 2022 at 05:27 PM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_tubespbo`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id_admin` varchar(10) NOT NULL,
  `username` varchar(256) NOT NULL,
  `firstname` varchar(256) NOT NULL,
  `lastname` varchar(256) NOT NULL,
  `email` varchar(256) NOT NULL,
  `status_user` varchar(256) NOT NULL,
  `password` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id_admin`, `username`, `firstname`, `lastname`, `email`, `status_user`, `password`) VALUES
('A001', 'AD001', 'Wijaya', 'adiwijaya@gmail.com', 'ADMIN', '1234', 'Adi'),
('A002', 'AD002', 'Wijaya', 'susiwijaya@gmail.com', 'ADMIN', '4321', 'Susi'),
('A003', 'AD003', 'Sukamar', 'mamansukamar@gmail.com', 'ADMIN', '2341', 'Maman'),
('A004', 'AD004', 'Prajaya', 'surdiprajaya@gmail.com', 'ADMIN', '3421', 'Surdi');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id_cust` varchar(10) NOT NULL,
  `username` varchar(256) NOT NULL,
  `firstname` varchar(256) NOT NULL,
  `lastname` varchar(256) NOT NULL,
  `email` varchar(256) NOT NULL,
  `status_user` varchar(256) DEFAULT NULL,
  `isMember` tinyint(1) DEFAULT NULL,
  `balance` double DEFAULT NULL,
  `password` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id_cust`, `username`, `firstname`, `lastname`, `email`, `status_user`, `isMember`, `balance`, `password`) VALUES
('C001', 'big123', 'Handi', 'Surdi', 'handisurdi@gmail.com', 'CUSTOMER', 1, 150000, 'handi'),
('C002', 'Udin', 'Hector', 'Wilson', 'hectorwilson@gmail.com', 'CUSTOMER', 1, 200000, 'hecson'),
('C003', 'hp999', 'Hansel', 'Davis', 'hanseldavis@gmail.com', 'CUSTOMER', 0, 350000, 'havis'),
('C004', '123', 'Hendra', 'Aiden', 'hendraaiden@gmail.com', 'CUSTOMER', 0, 70000, 'henden'),
('C005', 'berjayajaya', 'Harry', 'Farrel', 'harryfarrel@gmail.com', 'CUSTOMER', 0, 100000, 'harrel'),
('C006', 'sinjite', 'Hendi', 'Farrel', 'hendifarrel@gmail.com', 'CUSTOMER', 0, 120000, 'herel'),
('C007', 'kapasterbang', 'Het', 'Thompson', 'hetthompson@gmail.com', 'CUSTOMER', 0, 100000, 'hetson'),
('C008', 'karpetmerah', 'karpet', 'merah', 'karpetmerah@gmail.com', 'CUSTOMER', 0, 90000, 'biru123'),
('C009', 'gamer1122', 'nasir', 'danish', 'gamer1122@gmail.com', 'CUSTOMER', 1, 180000, '11221122'),
('C010', 'lia', 'Habeeb', 'Lia', 'habeeblia@gmail.com', 'CUSTOMER', 0, 150000, 'halia');

-- --------------------------------------------------------

--
-- Table structure for table `discount`
--

CREATE TABLE `discount` (
  `id_discount` varchar(10) NOT NULL,
  `discount_amount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `discount`
--

INSERT INTO `discount` (`id_discount`, `discount_amount`) VALUES
('D001', 5),
('D002', 10),
('D003', 25),
('D004', 30);

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

CREATE TABLE `menu` (
  `id_menu` varchar(10) NOT NULL,
  `name_menu` varchar(256) NOT NULL,
  `category` varchar(64) NOT NULL,
  `price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `menu`
--

INSERT INTO `menu` (`id_menu`, `name_menu`, `category`, `price`) VALUES
('M001', 'CheeseBurger', 'Food', 30000),
('M002', 'Burger', 'Food', 25000),
('M003', 'Steak', 'Food', 70000),
('M004', 'Nasi Rendang', 'Food', 30000),
('M005', 'Mie Goreng Original', 'Food', 12000),
('M006', 'Mie Kuah Ayam Bawang', 'Food', 12000),
('M007', 'Fun Drink', 'Drink', 7000),
('M008', 'Coffee', 'Drink', 10000);

-- --------------------------------------------------------

--
-- Table structure for table `queue`
--

CREATE TABLE `queue` (
  `id_queue` int(11) NOT NULL,
  `id_cust` varchar(10) DEFAULT NULL,
  `capacity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `receipt`
--

CREATE TABLE `receipt` (
  `id_receipt` varchar(10) NOT NULL,
  `id_reservation` varchar(10) DEFAULT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `receiptdetails`
--

CREATE TABLE `receiptdetails` (
  `id_receiptDetails` varchar(10) NOT NULL,
  `id_receipt` varchar(10) DEFAULT NULL,
  `id_menu` varchar(10) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `status_food_progress` varchar(256) DEFAULT NULL,
  `subtotal` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

CREATE TABLE `reservation` (
  `id_reservation` varchar(10) NOT NULL,
  `id_table` varchar(10) NOT NULL,
  `id_cust` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `reservation`
--

INSERT INTO `reservation` (`id_reservation`, `id_table`, `id_cust`) VALUES
('R001', 'T001', 'C003'),
('R002', 'T002', 'C002'),
('R003', 'T003', 'C001');

-- --------------------------------------------------------

--
-- Table structure for table `table`
--

CREATE TABLE `table` (
  `id_table` varchar(10) NOT NULL,
  `noTable` int(8) NOT NULL,
  `capacity` int(16) NOT NULL,
  `isOccupied` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `table`
--

INSERT INTO `table` (`id_table`, `noTable`, `capacity`, `isOccupied`) VALUES
('T001', 1, 2, 1),
('T002', 2, 2, 1),
('T003', 3, 4, 1),
('T004', 4, 4, 0),
('T005', 5, 6, 0),
('T006', 6, 6, 0);

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `id_transaction` varchar(10) NOT NULL,
  `id_receipt` varchar(10) DEFAULT NULL,
  `id_discount` varchar(10) DEFAULT NULL,
  `total` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id_cust`);

--
-- Indexes for table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`id_menu`);

--
-- Indexes for table `queue`
--
ALTER TABLE `queue`
  ADD PRIMARY KEY (`id_queue`);

--
-- Indexes for table `receipt`
--
ALTER TABLE `receipt`
  ADD PRIMARY KEY (`id_receipt`);

--
-- Indexes for table `receiptdetails`
--
ALTER TABLE `receiptdetails`
  ADD PRIMARY KEY (`id_receiptDetails`);

--
-- Indexes for table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`id_reservation`);

--
-- Indexes for table `table`
--
ALTER TABLE `table`
  ADD PRIMARY KEY (`id_table`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`id_transaction`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `queue`
--
ALTER TABLE `queue`
  MODIFY `id_queue` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
