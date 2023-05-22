-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 22-05-2023 a las 06:11:12
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
  `dni` varchar(10) COLLATE utf8mb4_general_ci NOT NULL,
  `apellido` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `nombre` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `estado` tinyint(1) NOT NULL DEFAULT '1',
  `create_fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_alumno`),
  UNIQUE KEY `dni` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `alumno`
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
(16, '12345678', 'PEREZ', 'Jose', '1999-05-15', 1, '2023-05-21 02:23:34'),
(24, '123456789', 'JOFRE', 'Juan Manuel', '1985-01-15', 1, '2023-05-22 05:20:51'),
(26, '12345679', 'JOFRE', 'Juan Manuel', '1985-01-15', 1, '2023-05-22 05:27:56'),
(28, '1235679', 'JOFRE', 'Juan Manuel', '1985-01-15', 1, '2023-05-22 05:32:30'),
(29, '123569', 'JOFRE', 'Juan Manuel', '1985-01-15', 1, '2023-05-22 05:34:23'),
(30, '12569', 'GOMEZ', 'Juan Manuel', '1985-01-15', 1, '2023-05-22 05:35:17'),
(31, '125699999', 'GOMEZ', 'Juan Manuel', '1985-01-15', 1, '2023-05-22 05:36:26'),
(32, '1256989', 'GOMEZ', 'Juan Manuel', '1985-01-15', 1, '2023-05-22 05:37:29'),
(34, '1256949', 'GIMENEZ', 'Juan Manuel', '1985-01-15', 1, '2023-05-22 05:50:44'),
(36, '54771', 'GIMENEZ', 'Juan Manuel', '1985-01-15', 1, '2023-05-22 06:01:21'),
(37, '78046', 'GIMENEZ', 'Juan Manuel', '1985-01-15', 1, '2023-05-22 06:03:00'),
(38, '30966', 'GIMENEZ', 'Juan Manuel', '1985-01-15', 1, '2023-05-22 06:05:03'),
(39, '53174', 'GIMENEZ', 'Juan Manuel', '1985-01-15', 1, '2023-05-22 06:05:33'),
(40, '87567', 'GIMENEZ', 'Juan Manuel', '1985-01-15', 1, '2023-05-22 06:06:54'),
(41, '30493', 'GIMENEZ', 'Juan Manuel', '1985-01-15', 1, '2023-05-22 06:07:32'),
(42, '63120', 'GIMENEZ', 'Juan Manuel', '1985-01-15', 1, '2023-05-22 06:08:17'),
(43, '37084', 'GIMENEZ', 'Juan Manuel', '1985-01-15', 1, '2023-05-22 06:08:50');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inscripcion`
--

DROP TABLE IF EXISTS `inscripcion`;
CREATE TABLE IF NOT EXISTS `inscripcion` (
  `id_inscripto` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `nota` decimal(4,2) UNSIGNED DEFAULT NULL,
  `id_alumno` int UNSIGNED NOT NULL,
  `id_materia` int UNSIGNED NOT NULL,
  PRIMARY KEY (`id_inscripto`),
  UNIQUE KEY `id_alumno_2` (`id_alumno`,`id_materia`),
  KEY `id_alumno` (`id_alumno`),
  KEY `id_materia` (`id_materia`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `inscripcion`
--

INSERT INTO `inscripcion` (`id_inscripto`, `nota`, `id_alumno`, `id_materia`) VALUES
(1, '0.00', 1, 1),
(2, '8.00', 2, 3),
(3, '8.00', 2, 1),
(6, '0.00', 1, 5),
(7, '0.00', 3, 2),
(8, '8.20', 3, 1),
(15, '9.99', 1, 3),
(16, NULL, 24, 3),
(17, NULL, 26, 3),
(26, '8.50', 34, 3),
(36, '8.50', 39, 3),
(38, '8.50', 40, 3),
(40, '8.50', 41, 3),
(42, '8.50', 42, 3),
(44, '8.50', 43, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materia`
--

DROP TABLE IF EXISTS `materia`;
CREATE TABLE IF NOT EXISTS `materia` (
  `id_materia` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `anio` int UNSIGNED NOT NULL,
  `estado` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_materia`),
  UNIQUE KEY `materia` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `materia`
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
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  ADD CONSTRAINT `inscripcion_ibfk_1` FOREIGN KEY (`id_materia`) REFERENCES `materia` (`id_materia`),
  ADD CONSTRAINT `inscripcion_ibfk_2` FOREIGN KEY (`id_alumno`) REFERENCES `alumno` (`id_alumno`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
