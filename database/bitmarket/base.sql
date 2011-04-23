CREATE TABLE `users` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Nick` varchar(100) NOT NULL,
  `OpenID` varchar(100),
  `Created` datetime NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
