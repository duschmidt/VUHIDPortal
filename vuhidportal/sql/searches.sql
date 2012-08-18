-- Database: `vuhid-portal`
-- 
-- --------------------------------------------------------
-- 
-- Table structure for table `searches`
-- 

DROP TABLE IF EXISTS `searches`;
CREATE TABLE `searches` (
  `ID` bigint(20) NOT NULL auto_increment,
  `Time` datetime NOT NULL default '0000-00-00 00:00:00',
  `VUHID_ID` boolean NOT NULL default false,
  `Success` boolean NOT NULL default false,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin PACK_KEYS=0 AUTO_INCREMENT=1 ;
