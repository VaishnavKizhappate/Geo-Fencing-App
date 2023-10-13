-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 25, 2021 at 06:45 AM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `geofencing`
--

-- --------------------------------------------------------

--
-- Table structure for table `complainttable`
--

CREATE TABLE `complainttable` (
  `id` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `complaint` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `complainttable`
--

INSERT INTO `complainttable` (`id`, `email`, `complaint`) VALUES
(1, 'hee@gmail.com', 'Not good'),
(2, '', ''),
(3, '', '');

-- --------------------------------------------------------

--
-- Table structure for table `feedbacktable`
--

CREATE TABLE `feedbacktable` (
  `id` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `feedback` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `feedbacktable`
--

INSERT INTO `feedbacktable` (`id`, `email`, `feedback`) VALUES
(2, 'hafsashireencp1@gmail.com', 'Happy'),
(3, 'hafsashireencp1@gmail.com', 'Bad'),
(4, 'hafsashireencp1@gmail.com', 'Happy'),
(5, 'hafsashireencp1@gmail.com', 'Happy'),
(6, 'hafsashireencp1@gmail.com', 'Happy'),
(7, 'hafsashireencp1@gmail.com', 'Happy'),
(8, 'hafsashireencp1@gmail.com', 'Happy'),
(9, 'hafsashireencp1@gmail.com', 'Happy'),
(10, 'gjk', 'Happy');

-- --------------------------------------------------------

--
-- Table structure for table `notifications`
--

CREATE TABLE `notifications` (
  `id` int(11) NOT NULL,
  `title` varchar(50) NOT NULL,
  `notifications` varchar(200) NOT NULL,
  `date` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `notifications`
--

INSERT INTO `notifications` (`id`, `title`, `notifications`, `date`) VALUES
(1, 'Hi', 'This is a hi message', '16/04/2021');

-- --------------------------------------------------------

--
-- Table structure for table `regtable`
--

CREATE TABLE `regtable` (
  `id` int(11) NOT NULL,
  `user_name` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `address` varchar(100) NOT NULL,
  `landmark` varchar(30) NOT NULL,
  `city` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `phone` varchar(30) NOT NULL,
  `guardian` varchar(30) NOT NULL,
  `nationality` varchar(30) NOT NULL,
  `dob` varchar(30) NOT NULL,
  `gender` varchar(20) NOT NULL,
  `latitude` varchar(50) NOT NULL,
  `longitude` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `regtable`
--

INSERT INTO `regtable` (`id`, `user_name`, `password`, `address`, `landmark`, `city`, `email`, `phone`, `guardian`, `nationality`, `dob`, `gender`, `latitude`, `longitude`) VALUES
(25, 'mashood', 'mashood', 'Poozhikunnath Valappil House', 'Vattamkulam', 'Edappal', 'itsmemashood@gmail.com', '9567944372', 'Hameed, Father', 'India', '26/05/1997', 'Male', '', ''),
(26, 'jithin', 'jithin', 'panthalingal', 'mosque', 'vallapuzha', 'jithin14kr@gmail.con', '8129741713', 'sasikumar father', 'indian', '05/11/1999', 'Male', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `rescue_team`
--

CREATE TABLE `rescue_team` (
  `id` int(11) NOT NULL,
  `district` varchar(30) NOT NULL,
  `area` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `contact` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rescue_team`
--

INSERT INTO `rescue_team` (`id`, `district`, `area`, `name`, `contact`) VALUES
(1, 'Malappuram', 'Edappal', 'Mashood', '7012726482');

-- --------------------------------------------------------

--
-- Table structure for table `restricted_areas`
--

CREATE TABLE `restricted_areas` (
  `id` int(11) NOT NULL,
  `latitude` varchar(200) NOT NULL,
  `longitude` varchar(200) NOT NULL,
  `radius` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `restricted_areas`
--

INSERT INTO `restricted_areas` (`id`, `latitude`, `longitude`, `radius`) VALUES
(1, '10.524731', '76.2123228', '50');

-- --------------------------------------------------------

--
-- Table structure for table `restricted_crossing`
--

CREATE TABLE `restricted_crossing` (
  `id` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `date` varchar(15) NOT NULL,
  `time` varchar(15) NOT NULL,
  `latitude` varchar(100) NOT NULL,
  `longitude` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `restricted_crossing`
--

INSERT INTO `restricted_crossing` (`id`, `username`, `date`, `time`, `latitude`, `longitude`) VALUES
(5, 'mashood', '24-04-2021', '15:21:04', '10.7823505', '76.0351145');


--
-- Indexes for dumped tables
--


--
-- Indexes for table `complainttable`
--
ALTER TABLE `complainttable`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `feedbacktable`
--
ALTER TABLE `feedbacktable`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `notifications`
--
ALTER TABLE `notifications`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `regtable`
--
ALTER TABLE `regtable`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rescue_team`
--
ALTER TABLE `rescue_team`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `restricted_areas`
--
ALTER TABLE `restricted_areas`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `restricted_crossing`
--
ALTER TABLE `restricted_crossing`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--


--
-- AUTO_INCREMENT for table `complainttable`
--
ALTER TABLE `complainttable`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `feedbacktable`
--
ALTER TABLE `feedbacktable`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `notifications`
--
ALTER TABLE `notifications`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `regtable`
--
ALTER TABLE `regtable`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `rescue_team`
--
ALTER TABLE `rescue_team`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `restricted_areas`
--
ALTER TABLE `restricted_areas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `restricted_crossing`
--
ALTER TABLE `restricted_crossing`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
