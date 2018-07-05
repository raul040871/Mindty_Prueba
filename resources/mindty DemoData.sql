-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 03-07-2018 a las 16:42:05
-- Versión del servidor: 5.7.11
-- Versión de PHP: 5.6.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `mindty`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `curso`
--

CREATE TABLE `curso` (
  `idCurso` int(11) NOT NULL,
  `codCurso` varchar(255) DEFAULT NULL,
  `horasCurso` int(11) DEFAULT NULL,
  `nombreCurso` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `curso`
--

INSERT INTO `curso` (`idCurso`, `codCurso`, `horasCurso`, `nombreCurso`) VALUES
(1, 'WEB 65823', 50, 'Desarrollo de aplicaciones con tecnologías web'),
(2, 'UXP 12578', 255, 'Introducción a SQL');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `curso_alumno`
--

CREATE TABLE `curso_alumno` (
  `idCurso` int(11) NOT NULL,
  `idAlumno` int(11) NOT NULL,
  `idu` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `curso_alumno`
--

INSERT INTO `curso_alumno` (`idCurso`, `idAlumno`, `idu`) VALUES
(1, 1, 0),
(1, 2, 1),
(1, 3, 2),
(2, 4, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `curso_formador`
--

CREATE TABLE `curso_formador` (
  `idFormador` int(11) DEFAULT NULL,
  `idCurso` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `curso_formador`
--

INSERT INTO `curso_formador` (`idFormador`, `idCurso`) VALUES
(5, 1),
(6, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `curso_modulo`
--

CREATE TABLE `curso_modulo` (
  `idCurso` int(11) NOT NULL,
  `idModulo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `curso_modulo`
--

INSERT INTO `curso_modulo` (`idCurso`, `idModulo`) VALUES
(1, 3),
(2, 4),
(2, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `modulo`
--

CREATE TABLE `modulo` (
  `idm` int(11) NOT NULL,
  `nombreModulo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `modulo`
--

INSERT INTO `modulo` (`idm`, `nombreModulo`) VALUES
(3, 'Desarrollo avanzado'),
(4, 'Conceptos básicos de SQL'),
(5, 'Consultas de SQL más avanzadas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `modulo_unidad`
--

CREATE TABLE `modulo_unidad` (
  `idModulo` int(11) NOT NULL,
  `idUnidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `modulo_unidad`
--

INSERT INTO `modulo_unidad` (`idModulo`, `idUnidad`) VALUES
(3, 8),
(3, 9),
(3, 10),
(3, 11),
(4, 1),
(4, 2),
(4, 3),
(4, 4),
(5, 5),
(5, 6),
(5, 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nota`
--

CREATE TABLE `nota` (
  `nid` int(11) NOT NULL,
  `nota` double DEFAULT NULL,
  `modulo_idm` int(11) DEFAULT NULL,
  `alumnoid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `nota`
--

INSERT INTO `nota` (`nid`, `nota`, `modulo_idm`, `alumnoid`) VALUES
(7, 5, 4, 3),
(8, 4.5, 4, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `unidad`
--

CREATE TABLE `unidad` (
  `idUni` int(11) NOT NULL,
  `nombreUnidad` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `unidad`
--

INSERT INTO `unidad` (`idUni`, `nombreUnidad`) VALUES
(1, 'Arquitectura de las aplicaciones web y tecnologías disponibles'),
(2, 'Gestión del software y de los proyectos de desarrollo'),
(3, 'Fundamentos UX y de tecnologías frontend'),
(4, 'Fundamentos de desarrollo orientado a objetos'),
(5, 'Servidores de aplicación JEE'),
(6, 'Aplicaciones web y MVC'),
(7, 'Testing de aplicaciones y aseguramiento de calidad'),
(8, 'Patrones de diseño y la capa de Business Logic'),
(9, 'Aplicaciones basadas en JSF y Struts'),
(10, 'Aplicaciones basadas en framework Spring'),
(11, 'Persistencia basada en JPA e Hibernate');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `DTYPE` varchar(31) NOT NULL,
  `idu` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nombreUsuario` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `tipo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`DTYPE`, `idu`, `email`, `nombreUsuario`, `password`, `telefono`, `tipo`) VALUES
('Alumno', 1, 'ht@ht.com', 'Héctor Torres', 'Password', '93-555-75-54', 3),
('Alumno', 2, 'is@is.com', 'Ivan Synytsya', 'Password', '93-555-75-54', 3),
('Alumno', 3, 'ya@ya.com', 'Youssef Ait', 'Password', '93-555-75-54', 3),
('Alumno', 4, 'dg@dg.com', 'David Guarch', 'Password', '93-555-75-54', 3),
('Usuario', 5, 'ra@ra.com', 'Ricardo Ahumada', 'Password', '93-555-75-55', 2),
('Usuario', 6, 'am@am.com', 'Ángel M. Rayo', 'Password', '93-555-75-55', 2),
('Usuario', 7, 'sp@sp.com', 'Silvia Perez', 'Password', '93-555-75-55', 2),
('Usuario', 8, 'al@al.com', 'Aina Llorens', 'Password', '93-555-75-56', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `curso`
--
ALTER TABLE `curso`
  ADD PRIMARY KEY (`idCurso`),
  ADD UNIQUE KEY `UK_rsqdt06md7614u6qmr74esx6c` (`codCurso`);

--
-- Indices de la tabla `curso_alumno`
--
ALTER TABLE `curso_alumno`
  ADD PRIMARY KEY (`idCurso`,`idu`),
  ADD KEY `FKhrmqy3sfscl85kyom4grf7u2v` (`idAlumno`);

--
-- Indices de la tabla `curso_formador`
--
ALTER TABLE `curso_formador`
  ADD PRIMARY KEY (`idCurso`),
  ADD KEY `FK5v61dbusrcltcnxi3j8ih984f` (`idFormador`);

--
-- Indices de la tabla `curso_modulo`
--
ALTER TABLE `curso_modulo`
  ADD KEY `FKfhi847kmbjqsk3h8dby4ea4d2` (`idModulo`),
  ADD KEY `FKc2juqnyphc5s7ifpjp5ipfn6d` (`idCurso`);

--
-- Indices de la tabla `modulo`
--
ALTER TABLE `modulo`
  ADD PRIMARY KEY (`idm`);

--
-- Indices de la tabla `modulo_unidad`
--
ALTER TABLE `modulo_unidad`
  ADD KEY `FKlblxn6p1binx3xk6s91b7b41` (`idUnidad`),
  ADD KEY `FK37cmcx6ymljb73k1raojdno5t` (`idModulo`);

--
-- Indices de la tabla `nota`
--
ALTER TABLE `nota`
  ADD PRIMARY KEY (`nid`),
  ADD KEY `FKbm2ctcp7t9lo21v8yclrhe31w` (`modulo_idm`),
  ADD KEY `FKhbsso9eevoiw955nt2lqb5nwx` (`alumnoid`);

--
-- Indices de la tabla `unidad`
--
ALTER TABLE `unidad`
  ADD PRIMARY KEY (`idUni`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idu`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `curso`
--
ALTER TABLE `curso`
  MODIFY `idCurso` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `modulo`
--
ALTER TABLE `modulo`
  MODIFY `idm` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `nota`
--
ALTER TABLE `nota`
  MODIFY `nid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT de la tabla `unidad`
--
ALTER TABLE `unidad`
  MODIFY `idUni` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `curso_alumno`
--
ALTER TABLE `curso_alumno`
  ADD CONSTRAINT `FKhrmqy3sfscl85kyom4grf7u2v` FOREIGN KEY (`idAlumno`) REFERENCES `usuario` (`idu`),
  ADD CONSTRAINT `FKp5old5n64ccqckh5w2po7kw5v` FOREIGN KEY (`idCurso`) REFERENCES `curso` (`idCurso`);

--
-- Filtros para la tabla `curso_formador`
--
ALTER TABLE `curso_formador`
  ADD CONSTRAINT `FK5v61dbusrcltcnxi3j8ih984f` FOREIGN KEY (`idFormador`) REFERENCES `usuario` (`idu`),
  ADD CONSTRAINT `FKq8u9blwaa649k2fwar4ugmwko` FOREIGN KEY (`idCurso`) REFERENCES `curso` (`idCurso`);

--
-- Filtros para la tabla `curso_modulo`
--
ALTER TABLE `curso_modulo`
  ADD CONSTRAINT `FKc2juqnyphc5s7ifpjp5ipfn6d` FOREIGN KEY (`idCurso`) REFERENCES `curso` (`idCurso`) ON DELETE CASCADE,
  ADD CONSTRAINT `FKfhi847kmbjqsk3h8dby4ea4d2` FOREIGN KEY (`idModulo`) REFERENCES `modulo` (`idm`) ON DELETE CASCADE;

--
-- Filtros para la tabla `modulo_unidad`
--
ALTER TABLE `modulo_unidad`
  ADD CONSTRAINT `FK37cmcx6ymljb73k1raojdno5t` FOREIGN KEY (`idModulo`) REFERENCES `modulo` (`idm`) ON DELETE CASCADE,
  ADD CONSTRAINT `FKlblxn6p1binx3xk6s91b7b41` FOREIGN KEY (`idUnidad`) REFERENCES `unidad` (`idUni`) ON DELETE CASCADE;

--
-- Filtros para la tabla `nota`
--
ALTER TABLE `nota`
  ADD CONSTRAINT `FKbm2ctcp7t9lo21v8yclrhe31w` FOREIGN KEY (`modulo_idm`) REFERENCES `modulo` (`idm`) ON DELETE CASCADE,
  ADD CONSTRAINT `FKhbsso9eevoiw955nt2lqb5nwx` FOREIGN KEY (`alumnoid`) REFERENCES `usuario` (`idu`) ON DELETE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
