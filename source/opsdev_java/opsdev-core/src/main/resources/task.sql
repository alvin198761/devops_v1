DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task` (
  `id`INT NOT NULL auto_increment ,
  `status` varchar(10) NOT NULL,
  `code` int(11) DEFAULT NULL,
  `success` varchar(500) DEFAULT NULL,
  `error` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;