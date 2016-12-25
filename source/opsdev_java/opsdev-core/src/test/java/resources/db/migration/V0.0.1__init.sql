CREATE TABLE `task`(
 `uuid` VARCHAR(50) PRIMARY KEY NOT NULL ,
 `status` VARCHAR (10) NOT NULL ,
 `code` INT ,
 `success` VARCHAR (500),
 `error` VARCHAR (500)
)ENGINE = InnoDB
  DEFAULT CHARSET = utf8;