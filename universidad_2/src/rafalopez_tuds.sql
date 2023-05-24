-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 24-05-2023 a las 15:39:46
-- Versión del servidor: 8.0.31
-- Versión de PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `rafalopez_tuds`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

DROP TABLE IF EXISTS `alumno`;
CREATE TABLE IF NOT EXISTS `alumno` (
  `id_alumno` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `dni` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `apellido` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `nombre` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `estado` tinyint(1) NOT NULL DEFAULT '1',
  `create_fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_alumno`),
  UNIQUE KEY `dni` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`id_alumno`, `dni`, `apellido`, `nombre`, `fecha_nacimiento`, `estado`, `create_fecha`) VALUES
(1, '43690464', 'Vallejos', 'Roberta', '1999-05-15', 1, '2023-05-18 02:28:54'),
(2, '43764888', 'Gimenez', 'Valentin', '2001-09-19', 1, '2023-05-18 02:28:54'),
(3, '42290462', 'Villalobos', 'Cristian', '1990-03-10', 1, '2023-05-18 02:28:54'),
(4, '74748521', 'Zorro', 'Ricardo', '1964-01-19', 1, '2023-05-18 02:28:54'),
(5, '74741', 'Arjona', 'Ricardo', '1964-01-19', 1, '2023-05-18 02:28:54'),
(6, '7554741', 'Perez', 'Cristian Ruben', '1964-01-19', 1, '2023-05-18 02:28:54'),
(7, '888888', 'Gomez', 'Lucas MAX POWER', '1964-01-19', 1, '2023-05-18 02:28:54'),
(8, '8898888', 'Schumager', 'Michel', '1964-01-19', 1, '2023-05-18 02:28:54'),
(9, '12345678', 'Prost', 'Alan', '1999-05-15', 1, '2023-05-21 05:23:34'),
(10, '123456789', 'Senna', 'Airtho', '1985-01-15', 1, '2023-05-22 08:20:51'),
(11, '12345679', 'Fangio', 'Juan Manuel', '1985-01-15', 1, '2023-05-22 08:27:56'),
(12, '97666', 'GIMENEZ', 'Juan Manuel', '1985-01-15', 1, '2023-05-24 15:31:14'),
(13, '19569', 'VILLENEVE', 'Jaques', '1985-01-15', 1, '2023-05-24 15:37:01');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
