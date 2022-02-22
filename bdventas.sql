-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-12-2021 a las 17:29:26
-- Versión del servidor: 10.4.18-MariaDB
-- Versión de PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdventas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `IdCliente` int(11) UNSIGNED NOT NULL,
  `Dni` varchar(8) DEFAULT NULL,
  `Nombres` varchar(244) DEFAULT NULL,
  `Direccion` varchar(244) DEFAULT NULL,
  `Estado` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`IdCliente`, `Dni`, `Nombres`, `Direccion`, `Estado`) VALUES
(17, '21456987', 'Juan Guerrero Solis', 'Los Alamos', '1'),
(20, '47546852', 'Andres Mendoza', 'Chosica, actualizado', '1'),
(22, '32972385', 'angel ledesma', 'Frias 8969', '1'),
(25, '21658964', 'Carlos Maria Taruni', 'Coraceros 6377', '1'),
(26, '12546854', 'oscar fernandez', 'concepcion 3536', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_ventas`
--

CREATE TABLE `detalle_ventas` (
  `IdDetalleVentas` int(11) UNSIGNED NOT NULL,
  `IdVentas` int(11) UNSIGNED NOT NULL,
  `IdProducto` int(11) UNSIGNED NOT NULL,
  `Cantidad` int(11) UNSIGNED DEFAULT NULL,
  `PrecioVenta` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `detalle_ventas`
--

INSERT INTO `detalle_ventas` (`IdDetalleVentas`, `IdVentas`, `IdProducto`, `Cantidad`, `PrecioVenta`) VALUES
(155, 1, 4, 3, 1500),
(156, 1, 2, 1, 20),
(157, 1, 4, 5, 2500),
(158, 1, 4, 2, 1000),
(159, 1, 3, 2, 1600),
(160, 1, 3, 10, 8000),
(161, 1, 1, 2, 300),
(162, 2, 10, 6, 270),
(163, 2, 3, 5, 4000),
(164, 2, 10, 6, 270),
(165, 2, 3, 5, 4000),
(166, 2, 10, 6, 270),
(167, 2, 3, 5, 4000),
(168, 2, 4, 7, 3500),
(169, 2, 1, 3, 450),
(170, 2, 2, 1, 20),
(171, 2, 10, 5, 225),
(172, 2, 2, 1, 20),
(173, 2, 10, 5, 225),
(174, 2, 2, 20, 400),
(175, 2, 2, 1, 20),
(176, 2, 10, 5, 225),
(177, 2, 2, 20, 400),
(178, 2, 2, 1, 20),
(179, 2, 10, 5, 225),
(180, 2, 2, 20, 400),
(181, 2, 3, 10, 8000),
(182, 2, 4, 20, 10000),
(183, 2, 2, 3, 60),
(184, 2, 2, 3, 60),
(185, 2, 3, 5, 4000),
(186, 2, 13, 15, 225000),
(187, 2, 10, 2, 30090),
(188, 100, 13, 4, 60000),
(189, 101, 13, 4, 60000),
(190, 101, 10, 4, 60180),
(191, 102, 1, 2, 150),
(192, 102, 13, 1, 15000),
(193, 103, 13, 1, 15000),
(194, 103, 10, 4, 45),
(195, 104, 1, 4, 150),
(196, 104, 2, 5, 20),
(197, 105, 3, 2, 800),
(198, 105, 1, 3, 150),
(199, 105, 13, 3, 15000),
(200, 107, 1, 1, 150),
(201, 107, 1, 10, 150),
(202, 107, 1, 1, 150),
(203, 107, 3, 2, 800),
(204, 110, 4, 4, 500),
(205, 110, 2, 2, 20),
(206, 111, 4, 2, 1000),
(207, 111, 13, 3, 45000),
(208, 111, 3, 2, 1600),
(209, 111, 2, 4, 80),
(210, 112, 1, 2, 300),
(211, 113, 4, 1, 500),
(212, 113, 13, 1, 15000),
(213, 114, 4, 1, 500),
(214, 115, 1, 4, 600),
(215, 116, 4, 2, 1000),
(216, 117, 4, 2, 1000),
(217, 117, 4, 1, 500),
(218, 117, 1, 4, 600),
(219, 118, 2, 2, 40),
(220, 119, 10, 2, 90),
(221, 120, 2, 5, 100),
(222, 121, 1, 1, 150),
(223, 122, 11, 4, 180000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `IdEmpleado` int(10) UNSIGNED NOT NULL,
  `Dni` varchar(8) NOT NULL,
  `Nombres` varchar(255) DEFAULT NULL,
  `Telefono` varchar(10) DEFAULT NULL,
  `Estado` varchar(1) DEFAULT NULL,
  `User` varchar(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`IdEmpleado`, `Dni`, `Nombres`, `Telefono`, `Estado`, `User`) VALUES
(1, '32654741', 'Pedro Hernandez', '988252459', '1', 'emp01'),
(2, '23565587', 'Roman Riquelme', '1198825245', '1', 'Jo46'),
(3, '65321458', 'actualizado de nuevo', '453536458', '1', 'Em22'),
(8, '32972385', 'miguel garcia', '113206292', '1', 'txitxe'),
(12, '32451236', 'jose dario', '1154487876', '1', 'usuario3');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `IdProducto` int(11) UNSIGNED NOT NULL,
  `Nombres` varchar(244) DEFAULT NULL,
  `Precio` double DEFAULT NULL,
  `Stock` int(11) UNSIGNED DEFAULT NULL,
  `Estado` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`IdProducto`, `Nombres`, `Precio`, `Stock`, `Estado`) VALUES
(1, 'Teclado Logitech 345 Editado', 5000, 73, '1'),
(2, 'Mouse Logitech 567', 1500, 15, '1'),
(3, 'Laptop Lenovo Ideapad 520', 48000, 71, '1'),
(4, 'HeadPhones Sony M333', 5000, 58, '1'),
(10, 'Monitor Samsung 20', 45000, 12, '1'),
(11, 'Impresora HP', 45000, 10, '1'),
(13, 'WebCam 12345', 15000, 25, '1'),
(15, 'Netbook HP 65', 120000, 40, '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `IdVentas` int(11) UNSIGNED NOT NULL,
  `IdCliente` int(11) UNSIGNED NOT NULL,
  `IdEmpleado` int(10) UNSIGNED NOT NULL,
  `NumeroSerie` varchar(244) DEFAULT NULL,
  `FechaVentas` date DEFAULT NULL,
  `Monto` double DEFAULT NULL,
  `Estado` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`IdVentas`, `IdCliente`, `IdEmpleado`, `NumeroSerie`, `FechaVentas`, `Monto`, `Estado`) VALUES
(1, 22, 3, '00000010', '2021-12-03', 9800, '1'),
(2, 20, 2, '00000018', '2021-12-03', 10522, '1'),
(100, 25, 1, '00000019', '2021-12-02', 15000, '1'),
(101, 20, 1, '00000020', '2021-12-02', 45, '1'),
(102, 22, 1, '00000021', '2021-12-02', 15000, '1'),
(103, 25, 1, '00000022', '2021-12-02', 45, '1'),
(104, 25, 1, '00000023', '2021-12-02', 20, '1'),
(105, 25, 1, '00000024', '2021-12-02', 2050, '1'),
(107, 25, 1, '00000025', '2021-12-02', 1650, '1'),
(110, 17, 8, '00000026', '2021-12-02', 2040, '1'),
(111, 17, 8, '00000026', '2021-12-02', 47680, '1'),
(112, 25, 8, '00000026', '2021-12-02', 0, '1'),
(113, 22, 8, '00000026', '2021-12-02', 0, '1'),
(114, 22, 8, '00000026', '2021-12-02', 0, '1'),
(115, 25, 8, '00000027', '2021-12-02', 0, '1'),
(116, 25, 8, '00000028', '2021-12-02', 0, '1'),
(117, 22, 8, '00000028', '2021-12-02', 0, '1'),
(118, 25, 8, '00000029', '2021-12-02', 0, '1'),
(119, 17, 8, '00000030', '2021-12-02', 0, '1'),
(120, 22, 8, '00000031', '2021-12-02', 0, '1'),
(121, 17, 8, '00000032', '2021-12-02', 0, '1'),
(122, 25, 8, '00000033', '2021-12-02', 0, '1');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`IdCliente`);

--
-- Indices de la tabla `detalle_ventas`
--
ALTER TABLE `detalle_ventas`
  ADD PRIMARY KEY (`IdDetalleVentas`,`IdVentas`,`IdProducto`),
  ADD KEY `Ventas_has_Producto_FKIndex1` (`IdVentas`),
  ADD KEY `Ventas_has_Producto_FKIndex2` (`IdProducto`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`IdEmpleado`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`IdProducto`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`IdVentas`),
  ADD KEY `Ventas_FKIndex1` (`IdEmpleado`),
  ADD KEY `Ventas_FKIndex2` (`IdCliente`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `IdCliente` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT de la tabla `detalle_ventas`
--
ALTER TABLE `detalle_ventas`
  MODIFY `IdDetalleVentas` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=224;

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `IdEmpleado` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `IdProducto` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `IdVentas` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=123;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalle_ventas`
--
ALTER TABLE `detalle_ventas`
  ADD CONSTRAINT `detalle_ventas_ibfk_1` FOREIGN KEY (`IdVentas`) REFERENCES `ventas` (`IdVentas`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `detalle_ventas_ibfk_2` FOREIGN KEY (`IdProducto`) REFERENCES `producto` (`IdProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `ventas_ibfk_1` FOREIGN KEY (`IdEmpleado`) REFERENCES `empleado` (`IdEmpleado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `ventas_ibfk_2` FOREIGN KEY (`IdCliente`) REFERENCES `cliente` (`IdCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
