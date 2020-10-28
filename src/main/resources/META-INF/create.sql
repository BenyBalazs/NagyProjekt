-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Gép: localhost
-- Létrehozás ideje: 2020. Okt 28. 20:26
-- Kiszolgáló verziója: 8.0.13-4
-- PHP verzió: 7.2.24-0ubuntu0.18.04.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `aPtqQZyv3L`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `CAR`
--

CREATE TABLE `CAR` (
  `CAR_PK` bigint(20) NOT NULL,
  `OWNER_FK` bigint(20) DEFAULT NULL,
  `LICENSE_PLATE` int(11) NOT NULL,
  `MANIFACTURED_DATE` date DEFAULT NULL,
  `MODEL_FK` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `CAR_OWNER`
--

CREATE TABLE `CAR_OWNER` (
  `CAR_OWNER_PK` bigint(20) NOT NULL,
  `NAME` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DATE_OF_BIRTH` date DEFAULT NULL,
  `EMAIL` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PHONE_NUMBER` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `MECHANIC`
--

CREATE TABLE `MECHANIC` (
  `MECHANIC_PK` bigint(20) NOT NULL,
  `NAME` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DATE_OF_BIRTH` date DEFAULT NULL,
  `EMAIL` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PHONE_NUMBER` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `REPAIR_FK` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `MODEL`
--

CREATE TABLE `MODEL` (
  `MODEL_PK` bigint(20) NOT NULL,
  `BRAND` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TYPE` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=COMPACT;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `REPAIR`
--

CREATE TABLE `REPAIR` (
  `REPAIR_PK` bigint(20) NOT NULL,
  `CAR_FK` bigint(20) DEFAULT NULL,
  `START_OF_REPAIR` date DEFAULT NULL,
  `END_OF_REPAIR` date DEFAULT NULL,
  `PRICE` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `CAR`
--
ALTER TABLE `CAR`
  ADD PRIMARY KEY (`CAR_PK`),
  ADD UNIQUE KEY `LICENSE_PLATE` (`LICENSE_PLATE`),
  ADD KEY `OWNER_FK` (`OWNER_FK`),
  ADD KEY `MODEL_FK` (`MODEL_FK`);

--
-- A tábla indexei `CAR_OWNER`
--
ALTER TABLE `CAR_OWNER`
  ADD PRIMARY KEY (`CAR_OWNER_PK`);

--
-- A tábla indexei `MECHANIC`
--
ALTER TABLE `MECHANIC`
  ADD PRIMARY KEY (`MECHANIC_PK`),
  ADD KEY `REPAIR_FK` (`REPAIR_FK`);

--
-- A tábla indexei `MODEL`
--
ALTER TABLE `MODEL`
  ADD PRIMARY KEY (`MODEL_PK`);

--
-- A tábla indexei `REPAIR`
--
ALTER TABLE `REPAIR`
  ADD PRIMARY KEY (`REPAIR_PK`),
  ADD UNIQUE KEY `CAR_FK` (`CAR_FK`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `CAR`
--
ALTER TABLE `CAR`
  MODIFY `CAR_PK` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT a táblához `CAR_OWNER`
--
ALTER TABLE `CAR_OWNER`
  MODIFY `CAR_OWNER_PK` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT a táblához `MECHANIC`
--
ALTER TABLE `MECHANIC`
  MODIFY `MECHANIC_PK` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT a táblához `MODEL`
--
ALTER TABLE `MODEL`
  MODIFY `MODEL_PK` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT a táblához `REPAIR`
--
ALTER TABLE `REPAIR`
  MODIFY `REPAIR_PK` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Megkötések a kiírt táblákhoz
--

--
-- Megkötések a táblához `CAR`
--
ALTER TABLE `CAR`
  ADD CONSTRAINT `CAR_ibfk_1` FOREIGN KEY (`MODEL_FK`) REFERENCES `MODEL` (`model_pk`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `CAR_ibfk_2` FOREIGN KEY (`OWNER_FK`) REFERENCES `CAR_OWNER` (`car_owner_pk`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Megkötések a táblához `MECHANIC`
--
ALTER TABLE `MECHANIC`
  ADD CONSTRAINT `MECHANIC_ibfk_1` FOREIGN KEY (`REPAIR_FK`) REFERENCES `REPAIR` (`repair_pk`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Megkötések a táblához `REPAIR`
--
ALTER TABLE `REPAIR`
  ADD CONSTRAINT `REPAIR_ibfk_1` FOREIGN KEY (`CAR_FK`) REFERENCES `CAR` (`car_pk`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
