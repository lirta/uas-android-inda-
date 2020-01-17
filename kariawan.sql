-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 17, 2020 at 02:26 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.2.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kariawan`
--

-- --------------------------------------------------------

--
-- Table structure for table `data_kariawan`
--

CREATE TABLE `data_kariawan` (
  `nik` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `tempat_lahir` varchar(100) NOT NULL,
  `tgl_lahir` varchar(100) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `kelamin` varchar(100) NOT NULL,
  `agama` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL,
  `pendidikan` varchar(100) NOT NULL,
  `jabatan` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `data_kariawan`
--

INSERT INTO `data_kariawan` (`nik`, `nama`, `tempat_lahir`, `tgl_lahir`, `alamat`, `kelamin`, `agama`, `status`, `pendidikan`, `jabatan`) VALUES
(0, '', '', '', '', '', '', '', '', ''),
(4, 'bsbsn', 'sbhssh', '', 'bshs', 'bsbs', '', '', '', ''),
(5, 'maorio\n', '', '', '', '', '', '', '', ''),
(13, 'rjejrj', 'nrhehhd', '', '', '', '', '', '', ''),
(123, 'inda', 'padang', '18-11-90', '', '', '', '', '', ''),
(231, 'lirta', 'padang', '18-11-90', '', '', '', '', '', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `data_kariawan`
--
ALTER TABLE `data_kariawan`
  ADD PRIMARY KEY (`nik`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
