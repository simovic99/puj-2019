-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 23, 2018 at 08:01 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 5.6.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `knjiznica`
--

-- --------------------------------------------------------

--
-- Table structure for table `autor`
--

CREATE TABLE `autor` (
  `id` int(11) NOT NULL,
  `ime` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `prezime` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `datum_rodjenja` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `autor`
--

INSERT INTO `autor` (`id`, `ime`, `prezime`, `datum_rodjenja`) VALUES
(1, 'Andjela', 'Rotim', '1996-06-27'),
(2, 'August', 'Senoa', '1838-11-14'),
(3, 'Ivana', 'Markic', '1995-01-15'),
(4, 'Fjodor', 'M. Dostojevski', '1821-11-11'),
(5, 'Lav', 'N. Tolstoj', '1828-09-09'),
(6, 'Giovanni', 'Boccaccio', '1313-06-16'),
(7, 'Matea', 'Tomic', '1996-07-18');

-- --------------------------------------------------------

--
-- Table structure for table `knjiga`
--

CREATE TABLE `knjiga` (
  `id` int(11) NOT NULL,
  `naziv` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `vrsta` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `status` int(1) NOT NULL,
  `id_autora` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `knjiga`
--

INSERT INTO `knjiga` (`id`, `naziv`, `vrsta`, `status`, `id_autora`) VALUES
(1, 'Kako biti programer', 'udzbenik', 1, 1),
(2, 'Zlatarovo zlato', 'roman', 1, 2),
(3, 'Kameni svatovi', 'povjestica', 0, 2),
(4, 'Zakon velikih brojeva', 'komedija', 1, 3),
(5, 'Zlocin i kazna', 'roman', 0, 4),
(6, 'Ana Karenjina', 'roman', 0, 5),
(7, 'Dekameron', 'novela', 1, 6),
(9, 'Pijanica nisam', 'autobiografija', 1, 7);

-- --------------------------------------------------------

--
-- Table structure for table `korisnik`
--

CREATE TABLE `korisnik` (
  `id` int(11) NOT NULL,
  `ime` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `prezime` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `datum_rodjenja` date NOT NULL,
  `korisnicko_ime` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `sifra` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `id_tipa_korisnika` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `korisnik`
--

INSERT INTO `korisnik` (`id`, `ime`, `prezime`, `datum_rodjenja`, `korisnicko_ime`, `sifra`, `email`, `id_tipa_korisnika`) VALUES
(1, 'Pero', 'Peric', '1998-07-11', 'admin', 'admin', 'pero.peric@gmail.com', 1),
(2, 'Ivo', 'Ivic', '2000-04-05', 'ivo.ivic', '12345', 'ivo.ivic@gmail.com', 2),
(3, 'Slavena', 'Markic', '1998-12-19', 'slavena.markic', '12345', 'slavena.markic@gmail.com', 2),
(4, 'Slava', 'Sesar', '1994-11-26', 'slava.sesar', '12345', 'slava123@gmail.com', 2),
(5, 'Sara', 'Lasic', '1996-07-25', 'sara.lasic', '12345', 'lasic.sara@gmail.com', 2),
(6, 'Filip', 'Galic', '1996-03-11', 'filip.galic', '12345', 'filip.galic@gmail.com', 2),
(7, 'Marin', 'Zelenika', '1997-03-18', 'marin.zelenika', '12345', 'm.zelenika@gmail.com', 2);

-- --------------------------------------------------------

--
-- Table structure for table `rezervacija`
--

CREATE TABLE `rezervacija` (
  `id` int(11) NOT NULL,
  `id_korisnika` int(11) NOT NULL,
  `id_knjige` int(11) NOT NULL,
  `datum_od` date NOT NULL,
  `datum_do` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `rezervacija`
--

INSERT INTO `rezervacija` (`id`, `id_korisnika`, `id_knjige`, `datum_od`, `datum_do`) VALUES
(1, 6, 1, '2018-03-26', '2018-04-26'),
(3, 5, 7, '2018-04-30', '2018-05-04'),
(4, 5, 4, '2018-01-29', '2018-02-22'),
(5, 2, 7, '2018-04-20', '2018-04-26'),
(6, 3, 2, '2018-04-12', '2018-05-04'),
(7, 7, 9, '2018-04-06', '2018-05-06');

-- --------------------------------------------------------

--
-- Table structure for table `tip_korisnika`
--

CREATE TABLE `tip_korisnika` (
  `id` int(11) NOT NULL,
  `ime_role` varchar(15) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tip_korisnika`
--

INSERT INTO `tip_korisnika` (`id`, `ime_role`) VALUES
(1, 'Admin'),
(2, 'Korisnik');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `autor`
--
ALTER TABLE `autor`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `knjiga`
--
ALTER TABLE `knjiga`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_autora` (`id_autora`);

--
-- Indexes for table `korisnik`
--
ALTER TABLE `korisnik`
  ADD PRIMARY KEY (`id`),
  ADD KEY `korisnik_ibfk_1` (`id_tipa_korisnika`);

--
-- Indexes for table `rezervacija`
--
ALTER TABLE `rezervacija`
  ADD PRIMARY KEY (`id`),
  ADD KEY `rezervacija_ibfk_1` (`id_korisnika`),
  ADD KEY `rezervacija_ibfk_2` (`id_knjige`);

--
-- Indexes for table `tip_korisnika`
--
ALTER TABLE `tip_korisnika`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `autor`
--
ALTER TABLE `autor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `knjiga`
--
ALTER TABLE `knjiga`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `korisnik`
--
ALTER TABLE `korisnik`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `rezervacija`
--
ALTER TABLE `rezervacija`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `tip_korisnika`
--
ALTER TABLE `tip_korisnika`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `knjiga`
--
ALTER TABLE `knjiga`
  ADD CONSTRAINT `knjiga_ibfk_1` FOREIGN KEY (`id_autora`) REFERENCES `autor` (`id`);

--
-- Constraints for table `korisnik`
--
ALTER TABLE `korisnik`
  ADD CONSTRAINT `korisnik_ibfk_1` FOREIGN KEY (`id_tipa_korisnika`) REFERENCES `tip_korisnika` (`id`);

--
-- Constraints for table `rezervacija`
--
ALTER TABLE `rezervacija`
  ADD CONSTRAINT `rezervacija_ibfk_1` FOREIGN KEY (`id_korisnika`) REFERENCES `korisnik` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `rezervacija_ibfk_2` FOREIGN KEY (`id_knjige`) REFERENCES `knjiga` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
