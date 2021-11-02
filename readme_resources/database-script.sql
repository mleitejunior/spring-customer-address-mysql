-- MySQL Workbench Synchronization
-- Generated: 2021-10-29 21:41
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: marcelojunior

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE TABLE IF NOT EXISTS `mydatabasetest`.`customer` (
  `id_customer` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(500) NULL DEFAULT NULL,
  `email` VARCHAR(500) NOT NULL,
  `document` VARCHAR(100) NULL DEFAULT NULL,
  `birthdate` DATETIME NULL DEFAULT NULL,
  `phone` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id_customer`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `mydatabasetest`.`address` (
  `id_address` INT(11) NOT NULL AUTO_INCREMENT,
  `zipcode` VARCHAR(100) NOT NULL,
  `street` VARCHAR(500) NOT NULL,
  `number` VARCHAR(100) NOT NULL,
  `complement` VARCHAR(500) NULL DEFAULT NULL,
  `district` VARCHAR(500) NULL DEFAULT NULL,
  `city` VARCHAR(100) NOT NULL,
  `state` VARCHAR(100) NOT NULL,
  `country` VARCHAR(100) NOT NULL,
  `customer_id_customer` INT(11) NOT NULL,
  PRIMARY KEY (`id_address`, `customer_id_customer`),
  INDEX `fk_address_customer_idx` (`customer_id_customer` ASC) VISIBLE,
  CONSTRAINT `fk_address_customer`
    FOREIGN KEY (`customer_id_customer`)
    REFERENCES `mydatabasetest`.`customer` (`id_customer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
