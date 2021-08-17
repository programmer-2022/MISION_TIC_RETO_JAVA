-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-08-2021 a las 06:07:29
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

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_create_customer` (IN `pCustomerID` INT, IN `pCusName` VARCHAR(50), IN `pCusLastname` VARCHAR(50), IN `pCusAddress` VARCHAR(100), IN `pCusPhone` VARCHAR(10), IN `pCusEmail` VARCHAR(80))  BEGIN
    INSERT INTO tblcustomers(
        CustomerID,
        CusName,
        CusLastname,
        CusAddress,
        CusPhone,
        CusEmail
    )
    VALUES(
        pCustomerID,
        pCusName,
        pCusLastname,
        pCusAddress,
        pCusPhone,
        pCusEmail
    );
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_create_payment` (IN `pTblPets_PetID` INT, IN `pTblPlans_PlanID` INT, IN `pPaySubscription` TINYINT, IN `pPayDate` DATE)  BEGIN
INSERT INTO `tblpayments`(
    `TblPets_PetID`,
    `TblPlans_PlanID`,
    `PaySubscription`,
    `PayDate`)
VALUES (
    `pTblPets_PetID`,
    `pTblPlans_PlanID`,
    `pPaySubscription`,
    `pPayDate`
);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_create_pet` (IN `pPetCode` VARCHAR(20), IN `pPetName` VARCHAR(15), IN `pPetAge` TINYINT UNSIGNED, IN `pPetWeight` DECIMAL(5,2), IN `pPetSpecie` VARCHAR(6), IN `pCustomerID` INT)  BEGIN
    INSERT INTO tblpets(
        PetCode,
        PetName,
        PetAge,
        PetWeight,
        PetSpecie,
        TblCustomers_CustomerID
    )
    VALUES(
        pPetCode,
        pPetName,
        pPetAge,
        pPetWeight,
        pPetSpecie,
        pCustomerID
	);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_create_plan` (IN `pPlaCode` VARCHAR(20), IN `pPlaName` VARCHAR(50), IN `pPlaDescription` VARCHAR(200), IN `pPlaPrice` DECIMAL(10,2))  BEGIN
INSERT INTO `tblplans`(`PlaCode`, `PlaName`, `PlaDescription`, `PlaPrice`) VALUES (`pPlaCode`, `pPlaName`, `pPlaDescription`, `pPlaPrice`);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_delete_customer` (IN `pCustomerID` INT)  BEGIN
DELETE FROM `tblcustomers` WHERE CustomerID = pCustomerID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_delete_payment` (IN `pPaymentID` INT)  BEGIN
	DELETE FROM tblpayments
    WHERE PaymentID=pPaymentID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_delete_pet` (IN `pPetID` INT)  BEGIN
DELETE FROM `tblpets` WHERE PetID=pPetID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_delete_plan` (IN `pPlanID` INT)  BEGIN
DELETE FROM `tblplans` WHERE PlanID=pPlanID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_edit_customer` (IN `pCustomerID` INT, IN `pCusName` VARCHAR(50), IN `pCusLastname` VARCHAR(50), IN `pCusAddress` VARCHAR(100), IN `pCusPhone` VARCHAR(10), IN `pCusEmail` VARCHAR(80))  BEGIN
	UPDATE tblcustomers
    SET CusName=pCusName,
    	CusLastname=pCusLastname,
        CusAddress=pCusAddress,
        CusPhone=pCusPhone,
        CusEmail=pCusEmail
    WHERE CustomerID = pCustomerID;        
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_edit_payment` (IN `pPaymentID` INT, IN `pTblPets_PetID` INT, IN `pTblPlans_PlanID` INT, IN `pPaySubscription` TINYINT UNSIGNED, IN `pPayDate` DATE)  BEGIN
	UPDATE `tblpayments` 
	SET `TblPets_PetID`=pTblPets_PetID,
    `TblPlans_PlanID`=pTblPlans_PlanID,
    `PaySubscription`=pPaySubscription,
    `PayDate`=pPayDate
    WHERE PaymentID=pPaymentID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_edit_pet` (IN `pPetID` INT, IN `pPetCode` VARCHAR(20), IN `pPetName` VARCHAR(15), IN `pPetAge` TINYINT, IN `pPetWeight` DECIMAL(5,2), IN `pPetSpecie` VARCHAR(6), IN `pCustomerID` INT)  BEGIN
UPDATE `tblpets` 
SET 
`PetCode`=pPetCode,
`PetName`=pPetName,
`PetAge`=pPetAge,
`PetWeight`=pPetWeight,
`PetSpecie`=pPetSpecie,
`TblCustomers_CustomerID`=pCustomerID 
WHERE PetID=pPetID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_edit_plan` (IN `pPlanID` INT, IN `pPlaName` VARCHAR(50), IN `pPlaDescription` VARCHAR(200), IN `pPlaPrice` DECIMAL(10,2))  BEGIN
UPDATE `tblplans`
SET 
`PlaName`=pPlaName,
`PlaDescription`=pPlaDescription,
`PlaPrice`=pPlaPrice
WHERE PlanID=pPlanID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_getAllPetsByPlan_Report` ()  BEGIN
	SELECT 
    	COUNT(*) AS amount, 
        pla.PlaName
	FROM tblpets AS pet
	INNER JOIN tblpayments AS pay ON pay.TblPets_PetID=pet.PetID
	INNER JOIN tblplans AS pla ON pla.PlanID=pay.TblPlans_PlanID
	GROUP BY pla.PlaName;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_getAllPetsBySpecie_Report` ()  BEGIN 
	SELECT COUNT(*) as amount, PetSpecie FROM tblpets
    GROUP BY PetSpecie;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_getPetsCustomers_ReportExcel` ()  BEGIN
    SELECT 
        c.CustomerID,
        c.CusName, 
        c.CusLastname,
        c.CusAddress, 
        c.CusPhone, 
        c.CusEmail,
        p.PetCode,
        p.PetName,
        p.PetAge,
        p.PetWeight, 
        p.PetSpecie
    FROM tblpets AS p INNER JOIN tblcustomers AS c ON c.CustomerID=p.TblCustomers_CustomerID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_get_all_customers` ()  BEGIN
	SELECT CustomerID, CusName, CusLastname, CusPhone, CusAddress, CusEmail 
	FROM tblcustomers;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_get_all_pets` ()  BEGIN
SELECT `PetID`, `PetCode`, `PetName`, `PetAge`, `PetWeight`, `PetSpecie`, `TblCustomers_CustomerID` FROM `tblpets`;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_get_all_pets_customer` ()  BEGIN
SELECT p.`PetID`, p.`PetCode`, p.`PetName`, p.`PetAge`, p.`PetWeight`, p.`PetSpecie`, c.`CustomerID`, c.CusName, c.CusLastname FROM `tblpets` AS p INNER JOIN tblcustomers AS c ON c.CustomerID = p.TblCustomers_CustomerID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_get_all_plans` ()  BEGIN
SELECT 
    `PlanID`, 
    `PlaCode`, 
    `PlaName`, 
    `PlaDescription`, 
    `PlaPrice` 
FROM `tblplans`;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_get_customer` (IN `pCustomerID` INT)  BEGIN
	SELECT 
    	CustomerID,
    	CusName, 
        CusLastname, 
        CusAddress, 
        CusPhone,        
        CusEmail 
	FROM tblcustomers WHERE CustomerID=pCustomerID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_get_payment_by_pet` (IN `pPetCode` VARCHAR(20))  BEGIN
SELECT
	pet.PetID,
	pet.PetCode, 
    pet.PetName, 
    pet.PetSpecie,
    pla.PlanID,
    pla.PlaName,
    pay.PaymentID,
    pay.PaySubscription,
    pay.PayDate
FROM tblpets AS pet 
INNER JOIN tblpayments AS pay ON pay.TblPets_PetID=pet.PetID
INNER JOIN tblplans AS pla ON pla.PlanID=pay.TblPlans_PlanID
WHERE pet.PetCode LIKE CONCAT('%', pPetCode, '%');
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_get_pet` (IN `pPetCode` VARCHAR(20))  BEGIN
SELECT 
	p.`PetID`,
    p.`PetCode`, 
    p.`PetName`, 
    p.`PetAge`, 
    p.`PetWeight`, 
    p.`PetSpecie`, 
    c.`CustomerID`, 
    c.`CusName`, 
    c.`CusLastname`
FROM `tblpets` AS p
INNER JOIN tblcustomers AS c
ON c.CustomerID=p.TblCustomers_CustomerID
WHERE PetCode=pPetCode;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_get_petCustomer_byPetID` (IN `pPetID` INT)  BEGIN
SELECT 
	p.`PetID`, 
    p.`PetCode`, 
    p.`PetName`, 
    p.`PetAge`, 
    p.`PetWeight`, 
    p.`PetSpecie`,
    c.CustomerID,
    c.CusName,
    c.CusLastname
FROM `tblpets` AS p 
INNER JOIN tblcustomers AS c 
ON c.CustomerID=p.TblCustomers_CustomerID
WHERE p.PetID=pPetID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_get_pet_customerID` (IN `pCustomerID` INT)  BEGIN
SELECT 
	p.`PetID`, 
    p.`PetCode`, 
    p.`PetName`, 
    p.`PetAge`, 
    p.`PetWeight`, 
    p.`PetSpecie`
FROM `tblpets` AS p 
INNER JOIN tblcustomers AS c 
ON c.CustomerID = p.TblCustomers_CustomerID
WHERE c.CustomerID=pCustomerID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_get_plan` (IN `pPlaCode` VARCHAR(20))  BEGIN
SELECT 
	`PlanID`, 
    `PlaCode`, 
    `PlaName`, 
    `PlaDescription`, 
    `PlaPrice` 
FROM `tblplans` WHERE PlaCode=pPlaCode;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_get_plan_by_id` (IN `pPlanID` INT)  BEGIN
SELECT 
	`PlanID`, 
    `PlaCode`, 
    `PlaName`, 
    `PlaDescription`, 
    `PlaPrice` 
FROM `tblplans` WHERE PlanID=pPlanID;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblcustomers`
--

CREATE TABLE `tblcustomers` (
  `CustomerID` int(11) NOT NULL,
  `CusName` varchar(50) NOT NULL,
  `CusLastname` varchar(50) NOT NULL,
  `CusAddress` varchar(100) NOT NULL,
  `CusPhone` varchar(10) NOT NULL,
  `CusEmail` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tblcustomers`
--

INSERT INTO `tblcustomers` (`CustomerID`, `CusName`, `CusLastname`, `CusAddress`, `CusPhone`, `CusEmail`) VALUES
(124, 'GERALDINE', 'RODRIGUEZ', 'CHAMBU ALTO', '3184542200', 'geral_68@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblpayments`
--

CREATE TABLE `tblpayments` (
  `PaymentID` int(11) NOT NULL,
  `TblPets_PetID` int(11) DEFAULT NULL,
  `TblPlans_PlanID` int(11) DEFAULT NULL,
  `PaySubscription` tinyint(3) UNSIGNED NOT NULL,
  `PayDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tblpayments`
--

INSERT INTO `tblpayments` (`PaymentID`, `TblPets_PetID`, `TblPlans_PlanID`, `PaySubscription`, `PayDate`) VALUES
(18, 24, 11, 5, '2021-08-10'),
(20, 26, 10, 2, '2021-08-01'),
(21, 27, 10, 10, '2021-08-02');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblpets`
--

CREATE TABLE `tblpets` (
  `PetID` int(11) NOT NULL,
  `PetCode` varchar(20) NOT NULL,
  `PetName` varchar(15) NOT NULL,
  `PetAge` tinyint(3) UNSIGNED NOT NULL,
  `PetWeight` decimal(5,2) NOT NULL,
  `PetSpecie` varchar(6) NOT NULL,
  `TblCustomers_CustomerID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tblpets`
--

INSERT INTO `tblpets` (`PetID`, `PetCode`, `PetName`, `PetAge`, `PetWeight`, `PetSpecie`, `TblCustomers_CustomerID`) VALUES
(24, 'COD-02', 'JACKO', 10, '28.00', 'Canine', 124),
(26, 'COD-03', 'PERLA', 2, '9.00', 'Feline', 124),
(27, 'COD-04', 'KAYSER', 3, '12.50', 'Canine', 124);

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
(11, 'PL03', 'DIAMANTE', 'Con este plan tienes beneficios hasta del 50% en compras \nde accesorios para tu mascota', '100000.00'),
(18, 'PL1000', 'TEST PLAN', 'Descripcion de prueba del test', '1000.00');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tblcustomers`
--
ALTER TABLE `tblcustomers`
  ADD PRIMARY KEY (`CustomerID`);

--
-- Indices de la tabla `tblpayments`
--
ALTER TABLE `tblpayments`
  ADD PRIMARY KEY (`PaymentID`),
  ADD KEY `tblpayments_ibfk_1` (`TblPets_PetID`),
  ADD KEY `tblpayments_ibfk_2` (`TblPlans_PlanID`);

--
-- Indices de la tabla `tblpets`
--
ALTER TABLE `tblpets`
  ADD PRIMARY KEY (`PetID`),
  ADD UNIQUE KEY `PetCode` (`PetCode`),
  ADD KEY `tblpets_ibfk_1` (`TblCustomers_CustomerID`);

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
-- AUTO_INCREMENT de la tabla `tblpayments`
--
ALTER TABLE `tblpayments`
  MODIFY `PaymentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de la tabla `tblpets`
--
ALTER TABLE `tblpets`
  MODIFY `PetID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT de la tabla `tblplans`
--
ALTER TABLE `tblplans`
  MODIFY `PlanID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tblpayments`
--
ALTER TABLE `tblpayments`
  ADD CONSTRAINT `tblpayments_ibfk_1` FOREIGN KEY (`TblPets_PetID`) REFERENCES `tblpets` (`PetID`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `tblpayments_ibfk_2` FOREIGN KEY (`TblPlans_PlanID`) REFERENCES `tblplans` (`PlanID`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Filtros para la tabla `tblpets`
--
ALTER TABLE `tblpets`
  ADD CONSTRAINT `tblpets_ibfk_1` FOREIGN KEY (`TblCustomers_CustomerID`) REFERENCES `tblcustomers` (`CustomerID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
