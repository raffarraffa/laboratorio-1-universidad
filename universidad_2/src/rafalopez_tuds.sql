-- phpMyAdmin SQL Dump
-- version 5.1.4
-- https://www.phpmyadmin.net/
--
-- Host: mysql-rafalopez.alwaysdata.net
-- Generation Time: May 22, 2023 at 06:56 AM
-- Server version: 10.6.11-MariaDB
-- PHP Version: 7.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rafalopez_tuds`
--
CREATE DATABASE IF NOT EXISTS `rafalopez_tuds` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `rafalopez_tuds`;

-- --------------------------------------------------------

--
-- Table structure for table `alumno`
--

DROP TABLE IF EXISTS `alumno`;
CREATE TABLE `alumno` (
  `id_alumno` int(10) UNSIGNED NOT NULL,
  `dni` varchar(10) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `estado` tinyint(1) NOT NULL DEFAULT 1,
  `create_fecha` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `alumno`
--

INSERT INTO `alumno` (`id_alumno`, `dni`, `apellido`, `nombre`, `fecha_nacimiento`, `estado`, `create_fecha`) VALUES
(1, '43690464', 'Vallejos', 'Roberta', '1999-05-15', 1, '2023-05-17 23:28:54'),
(2, '43764888', 'Gimenez', 'Valentin', '2001-09-19', 1, '2023-05-17 23:28:54'),
(3, '42290462', 'Gonzales', 'Cristian', '1990-03-10', 1, '2023-05-17 23:28:54'),
(4, '74748521', 'Arjona', 'Ricardo', '1964-01-19', 1, '2023-05-17 23:28:54'),
(5, '74741', 'Arjona', 'Ricardo', '1964-01-19', 1, '2023-05-17 23:28:54'),
(6, '7554741', 'Arjona', 'Crsitian Ruben', '1964-01-19', 1, '2023-05-17 23:28:54'),
(7, '888888', 'Arjona', 'Lucas MAX POWER', '1964-01-19', 1, '2023-05-17 23:28:54'),
(8, '8898888', 'Arjona', 'Lucas MAX POWER', '1964-01-19', 1, '2023-05-17 23:28:54'),
(16, '12345678', 'PEREZ', 'Jose', '1999-05-15', 1, '2023-05-21 02:23:34');

-- --------------------------------------------------------

--
-- Table structure for table `inscripcion`
--

DROP TABLE IF EXISTS `inscripcion`;
CREATE TABLE `inscripcion` (
  `id_inscripto` int(10) UNSIGNED NOT NULL,
  `nota` decimal(4,2) UNSIGNED DEFAULT NULL,
  `id_alumno` int(10) UNSIGNED NOT NULL,
  `id_materia` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `inscripcion`
--

INSERT INTO `inscripcion` (`id_inscripto`, `nota`, `id_alumno`, `id_materia`) VALUES
(1, '0.00', 1, 1),
(2, '8.00', 2, 3),
(3, '8.00', 2, 1),
(6, '0.00', 1, 5),
(7, '0.00', 3, 2),
(8, '8.20', 3, 1),
(15, '9.99', 1, 3);

-- --------------------------------------------------------

--
-- Table structure for table `materia`
--

DROP TABLE IF EXISTS `materia`;
CREATE TABLE `materia` (
  `id_materia` int(10) UNSIGNED NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `anio` int(4) UNSIGNED NOT NULL,
  `estado` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `materia`
--

INSERT INTO `materia` (`id_materia`, `nombre`, `anio`, `estado`) VALUES
(1, 'Matematica', 1, 1),
(2, 'Fisica', 2, 1),
(3, 'Ingles', 1, 1),
(4, 'Programacion', 1, 1),
(5, 'Estructura de Datos y Algoritmos', 2, 1),
(6, 'Laboratorio II', 2, 1),
(7, 'WEB I', 2, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`id_alumno`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indexes for table `inscripcion`
--
ALTER TABLE `inscripcion`
  ADD PRIMARY KEY (`id_inscripto`),
  ADD UNIQUE KEY `id_alumno_2` (`id_alumno`,`id_materia`),
  ADD KEY `id_alumno` (`id_alumno`),
  ADD KEY `id_materia` (`id_materia`);

--
-- Indexes for table `materia`
--
ALTER TABLE `materia`
  ADD PRIMARY KEY (`id_materia`),
  ADD UNIQUE KEY `materia` (`nombre`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `alumno`
--
ALTER TABLE `alumno`
  MODIFY `id_alumno` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `inscripcion`
--
ALTER TABLE `inscripcion`
  MODIFY `id_inscripto` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `materia`
--
ALTER TABLE `materia`
  MODIFY `id_materia` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `inscripcion`
--
ALTER TABLE `inscripcion`
  ADD CONSTRAINT `inscripcion_ibfk_1` FOREIGN KEY (`id_materia`) REFERENCES `materia` (`id_materia`),
  ADD CONSTRAINT `inscripcion_ibfk_2` FOREIGN KEY (`id_alumno`) REFERENCES `alumno` (`id_alumno`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
