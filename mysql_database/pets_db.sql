-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-08-2021 a las 06:42:23
-- Versión del servidor: 10.4.20-MariaDB
-- Versión de PHP: 8.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `pets_db`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblplans`
--

CREATE TABLE `tblplans` (
  `PlanID` int(11) NOT NULL,
  `PlaCode` varchar(20) NOT NULL,
  `PlaName` varchar(50) NOT NULL,
  `PlaDescription` varchar(200) NOT NULL,
  `PlaPrice` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tblplans`
--

INSERT INTO `tblplans` (`PlanID`, `PlaCode`, `PlaName`, `PlaDescription`, `PlaPrice`) VALUES
(9, 'PL01', 'BIENESTAR', 'Este Plan \"bienestar\" es el más básico para tu mascota,\nno recibes ningún beneficio.', '40000.00'),
(10, 'PL02', 'ELITE', 'Plan élite para tu mascota, beneficios en compras 30%', '65000.00'),
(11, 'PL03', 'DIAMANTE', 'Con este plan tienes beneficios hasta del 50% en compras \nde accesorios para tu mascota', '100000.00');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tblplans`
--
ALTER TABLE `tblplans`
  ADD PRIMARY KEY (`PlanID`),
  ADD UNIQUE KEY `PlaCode` (`PlaCode`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tblplans`
--
ALTER TABLE `tblplans`
  MODIFY `PlanID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
