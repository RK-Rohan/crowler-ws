-- phpMyAdmin SQL Dump
-- version 3.3.3
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 24, 2010 at 06:51 PM
-- Server version: 5.5.3
-- PHP Version: 5.2.12

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Database: `spiderdb`
--

-- --------------------------------------------------------

--
-- Stand-in structure for view `aziende_prova`
--
DROP VIEW IF EXISTS `aziende_prova`;
CREATE TABLE IF NOT EXISTS `aziende_prova` (
`id` int(11)
,`id_ricerca` int(11)
,`ragione_sociale` varchar(255)
,`categoria` int(2)
,`categoria_paginegialle` varchar(255)
,`provincia` char(2)
,`citta` varchar(255)
,`telefono` varchar(15)
,`fax` varchar(15)
,`email` varchar(255)
,`indirizzo` varchar(255)
,`cap` varchar(15)
,`numero_inviati` int(11)
,`note` text
);
-- --------------------------------------------------------

--
-- Table structure for table `clienti`
--

DROP TABLE IF EXISTS `clienti`;
CREATE TABLE IF NOT EXISTS `clienti` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_ricerca` int(11) NOT NULL,
  `ragione_sociale` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `categoria_paginegialle` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `provincia` char(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `citta` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `telefono` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fax` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `indirizzo` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cap` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `numero_inviati` int(11) NOT NULL COMMENT 'il numero di contatti realmente inviati alla azienda',
  `note` text COLLATE utf8_unicode_ci,
  `categoria` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_ricerca` (`id_ricerca`),
  FULLTEXT KEY `ragione_sociale` (`ragione_sociale`),
  FULLTEXT KEY `email` (`email`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=21564 ;

-- --------------------------------------------------------

--
-- Table structure for table `ricerca`
--

DROP TABLE IF EXISTS `ricerca`;
CREATE TABLE IF NOT EXISTS `ricerca` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cosa` varchar(255) NOT NULL,
  `dove` varchar(255) NOT NULL,
  `data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=90 ;

-- --------------------------------------------------------

--
-- Structure for view `aziende_prova`
--
DROP TABLE IF EXISTS `aziende_prova`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `aziende_prova` AS select `clienti`.`id` AS `id`,`clienti`.`id_ricerca` AS `id_ricerca`,`clienti`.`ragione_sociale` AS `ragione_sociale`,`clienti`.`categoria` AS `categoria`,`clienti`.`categoria_paginegialle` AS `categoria_paginegialle`,`clienti`.`provincia` AS `provincia`,`clienti`.`citta` AS `citta`,`clienti`.`telefono` AS `telefono`,`clienti`.`fax` AS `fax`,`clienti`.`email` AS `email`,`clienti`.`indirizzo` AS `indirizzo`,`clienti`.`cap` AS `cap`,`clienti`.`numero_inviati` AS `numero_inviati`,`clienti`.`note` AS `note` from `clienti` group by `clienti`.`email`,`clienti`.`provincia` having (`clienti`.`email` <> _utf8'');
