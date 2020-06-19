-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 12-08-2015 a las 18:56:45
-- Versión del servidor: 5.1.53
-- Versión de PHP: 5.3.4

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `factufacil`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comentario`
--

CREATE TABLE IF NOT EXISTS `comentario` (
  `idcomentario` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `correo` varchar(50) DEFAULT NULL,
  `empresa` varchar(50) DEFAULT NULL,
  `telefono` varchar(50) DEFAULT NULL,
  `comentario` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`idcomentario`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcar la base de datos para la tabla `comentario`
--

INSERT INTO `comentario` (`idcomentario`, `nombre`, `correo`, `empresa`, `telefono`, `comentario`) VALUES
(1, 'Luis Enrique', 'ezleyker_gdn@hotmail.com', 'Coca-Cola', '5564781248', 'jjasijiajsiajsiajs');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comprobante`
--

CREATE TABLE IF NOT EXISTS `comprobante` (
  `id_comprobante` int(11) NOT NULL,
  `concepto_importe` varchar(50) NOT NULL,
  `valorUnitario` varchar(50) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `unidad` varchar(50) NOT NULL,
  `cantidad` varchar(50) NOT NULL,
  `IEPS` varchar(50) NOT NULL,
  `Subtotal` varchar(50) NOT NULL,
  `Iva` varchar(50) NOT NULL,
  `Total` varchar(50) NOT NULL,
  PRIMARY KEY (`id_comprobante`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `comprobante`
--

INSERT INTO `comprobante` (`id_comprobante`, `concepto_importe`, `valorUnitario`, `descripcion`, `unidad`, `cantidad`, `IEPS`, `Subtotal`, `Iva`, `Total`) VALUES
(54545, 'hjhjhj', '12554', 'sds', 'hjh', '1', '376.62', '12930.62', '2068.8992', '14999.52');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `emisor`
--

CREATE TABLE IF NOT EXISTS `emisor` (
  `Rfc` varchar(30) NOT NULL,
  `Razon_Social` varchar(30) NOT NULL,
  `Regimen` varchar(120) NOT NULL,
  `Calle` varchar(30) NOT NULL,
  `No_Int` int(11) NOT NULL,
  `No_Ext` int(11) NOT NULL,
  `Colonia` varchar(30) NOT NULL,
  `C_P` char(5) NOT NULL,
  `Municipio` varchar(30) NOT NULL,
  `Estado` varchar(30) NOT NULL,
  `Pais` varchar(30) NOT NULL,
  PRIMARY KEY (`Rfc`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `emisor`
--

INSERT INTO `emisor` (`Rfc`, `Razon_Social`, `Regimen`, `Calle`, `No_Int`, `No_Ext`, `Colonia`, `C_P`, `Municipio`, `Estado`, `Pais`) VALUES
('GORG941501', 'Gamez', 'Regimen para sociedades', 'elimilani', 23, 11, 'San Martin', '55748', 'Tecamac', 'Mexico', 'Mexico'),
('GOTD984754', 'Telmex de S.A de C.V', 'RÃ©gimen Opcional para Grupos de Sociedades', 'ASDS', 12, 124, 'SDSD', '55545', 'TECAMAC', 'MEXICO', 'MEXICO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE IF NOT EXISTS `empleado` (
  `idempleado` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `paterno` varchar(50) DEFAULT NULL,
  `materno` varchar(50) DEFAULT NULL,
  `especialidad` varchar(50) DEFAULT NULL,
  `cargo` varchar(50) DEFAULT NULL,
  `correo` varchar(50) DEFAULT NULL,
  `contrasenia` varchar(50) DEFAULT NULL,
  `idempresa` int(10) DEFAULT NULL,
  PRIMARY KEY (`idempleado`),
  KEY `idempresa` (`idempresa`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcar la base de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`idempleado`, `nombre`, `paterno`, `materno`, `especialidad`, `cargo`, `correo`, `contrasenia`, `idempresa`) VALUES
(1, 'Margoth Sarahi', 'Leyva', 'Pineda', 'Adminis', 'Administrador general', 'leyva@hotmail.com', 'margoth1234', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresa`
--

CREATE TABLE IF NOT EXISTS `empresa` (
  `idempresa` int(10) NOT NULL AUTO_INCREMENT,
  `nomempresa` varchar(50) DEFAULT NULL,
  `razon` varchar(50) DEFAULT NULL,
  `rfc` varchar(12) DEFAULT NULL,
  `regimen` varchar(50) DEFAULT NULL,
  `calle` varchar(50) DEFAULT NULL,
  `numexterior` int(10) DEFAULT NULL,
  `numinterior` int(10) DEFAULT NULL,
  `colonia` varchar(50) DEFAULT NULL,
  `codigo_portal` varchar(10) DEFAULT NULL,
  `estado` varchar(50) DEFAULT NULL,
  `municipio` varchar(50) DEFAULT NULL,
  `paquete` varchar(50) DEFAULT NULL,
  `nombrepersonal` varchar(50) DEFAULT NULL,
  `correo` varchar(50) DEFAULT NULL,
  `contrasenia` varchar(50) DEFAULT NULL,
  `telefono` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idempresa`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcar la base de datos para la tabla `empresa`
--

INSERT INTO `empresa` (`idempresa`, `nomempresa`, `razon`, `rfc`, `regimen`, `calle`, `numexterior`, `numinterior`, `colonia`, `codigo_portal`, `estado`, `municipio`, `paquete`, `nombrepersonal`, `correo`, `contrasenia`, `telefono`) VALUES
(1, 'cocacola', 'refresqueria', '43800DDFFG', 'Moral', 'hazagar', 12, 1, 'tizayuca', '45754', 'Guerrero', 'tizayuca', 'CFDI-300', 'Juan Angel PeÃ?Â±a Negrete', 'juan@hotmail.com', 'cocacolandia', '59657541');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresadetalle`
--

CREATE TABLE IF NOT EXISTS `empresadetalle` (
  `idempresadetalle` int(10) NOT NULL AUTO_INCREMENT,
  `rfc` char(12) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `giro` varchar(50) DEFAULT NULL,
  `calle` varchar(50) DEFAULT NULL,
  `colonia` varchar(50) DEFAULT NULL,
  `numero` int(10) DEFAULT NULL,
  `municipio` varchar(50) DEFAULT NULL,
  `sucursal` varchar(50) DEFAULT NULL,
  `telefono` varchar(50) DEFAULT NULL,
  `usuario` varchar(50) DEFAULT NULL,
  `correo` varchar(50) DEFAULT NULL,
  `contrasenia` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idempresadetalle`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `empresadetalle`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE IF NOT EXISTS `factura` (
  `folio_fiscal` varchar(25) NOT NULL,
  `no_SerCertificado` int(25) NOT NULL,
  `LugarExpedicion` varchar(30) NOT NULL,
  `Hora_FechaExpedicion` datetime NOT NULL,
  `no_CertDigital` int(11) NOT NULL,
  `Hora_FechaCerti` datetime NOT NULL,
  `Rfc` varchar(30) NOT NULL,
  `Rfc_Rec` char(13) NOT NULL,
  `id_comprobante` int(11) NOT NULL,
  PRIMARY KEY (`folio_fiscal`),
  KEY `Rfc` (`Rfc`),
  KEY `Rfc_Rec` (`Rfc_Rec`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `factura`
--

INSERT INTO `factura` (`folio_fiscal`, `no_SerCertificado`, `LugarExpedicion`, `Hora_FechaExpedicion`, `no_CertDigital`, `Hora_FechaCerti`, `Rfc`, `Rfc_Rec`, `id_comprobante`) VALUES
('as-5455', 301214545, 'Mexico, D.F', '2015-07-31 12:19:45', 54754848, '2015-07-31 12:19:57', 'GOTD984754', 'GOTD984754', 0),
('5A3EDB336N', 2033860844, 'Mexii', '2015-08-12 13:47:02', 922946294, '2015-08-12 13:47:22', 'GORG941501', 'GORG941501', 54545);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `precio`
--

CREATE TABLE IF NOT EXISTS `precio` (
  `paquete` int(10) NOT NULL AUTO_INCREMENT,
  `no_folio` int(10) DEFAULT NULL,
  `archivo` varchar(10) DEFAULT NULL,
  `costo` float DEFAULT NULL,
  PRIMARY KEY (`paquete`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Volcar la base de datos para la tabla `precio`
--

INSERT INTO `precio` (`paquete`, `no_folio`, `archivo`, `costo`) VALUES
(1, 50, 'SI', 280),
(2, 100, 'SI', 400),
(3, 200, 'SI', 690),
(4, 300, 'SI', 960),
(5, 500, 'SI', 1450),
(6, 800, 'SI', 2000),
(7, 1000, 'SI', 2300),
(8, 2000, 'SI', 4200),
(9, 3000, 'SI', 5700),
(10, 5000, 'SI', 8600),
(11, 10000, 'SI', 15000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `receptor`
--

CREATE TABLE IF NOT EXISTS `receptor` (
  `Rfc_Rec` char(13) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `Calle` varchar(120) NOT NULL,
  `No_Int` int(11) NOT NULL,
  `No_Ext` int(11) NOT NULL,
  `Colonia` varchar(30) NOT NULL,
  `C_P` char(5) NOT NULL,
  `Municipio` varchar(30) NOT NULL,
  `Estado` varchar(30) NOT NULL,
  `Pais` varchar(30) NOT NULL,
  PRIMARY KEY (`Rfc_Rec`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `receptor`
--

INSERT INTO `receptor` (`Rfc_Rec`, `Nombre`, `Calle`, `No_Int`, `No_Ext`, `Colonia`, `C_P`, `Municipio`, `Estado`, `Pais`) VALUES
('GORG941501', 'Gerardo Gomez', 'elimilani', 23, 11, 'San Martin', '55748', 'Tecamac', 'Mexico', 'Mexico'),
('GOTD984754', 'Gerardo Gomez Rosas', 'Cerrada 20 de Noviembre', 23, 11, 'San Mateo Tecalco', '55748', 'Tecamac', 'Mexico', 'Mexico');

--
-- Filtros para las tablas descargadas (dump)
--

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `empleado_ibfk_1` FOREIGN KEY (`idempresa`) REFERENCES `empresa` (`idempresa`) ON DELETE CASCADE ON UPDATE CASCADE;
