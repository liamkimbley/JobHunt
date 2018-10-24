-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema jobhuntdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `jobhuntdb` ;

-- -----------------------------------------------------
-- Schema jobhuntdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `jobhuntdb` DEFAULT CHARACTER SET utf8 ;
USE `jobhuntdb` ;

-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `username_UNIQUE` ON `user` (`username` ASC);


-- -----------------------------------------------------
-- Table `address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `address` ;

CREATE TABLE IF NOT EXISTS `address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(200) NOT NULL,
  `street2` VARCHAR(200) NULL,
  `city` VARCHAR(100) NOT NULL,
  `state` VARCHAR(45) NOT NULL,
  `country` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `profile`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `profile` ;

CREATE TABLE IF NOT EXISTS `profile` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(50) NOT NULL,
  `last_name` VARCHAR(50) NOT NULL,
  `cover_letter` TEXT NULL,
  `resume` TEXT NULL,
  `user_id` INT NOT NULL,
  `address_id` INT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_user_profile`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_profile_address`
    FOREIGN KEY (`address_id`)
    REFERENCES `address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_user_profile_idx` ON `profile` (`user_id` ASC);

CREATE INDEX `fk_profile_address_idx` ON `profile` (`address_id` ASC);


-- -----------------------------------------------------
-- Table `company`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `company` ;

CREATE TABLE IF NOT EXISTS `company` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `jobs_available` INT NULL,
  `applied` TINYINT NULL,
  `date_applied` DATETIME NULL,
  `date_updated` DATETIME NULL,
  `address_id` INT NOT NULL,
  `response` TINYINT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_company_address`
    FOREIGN KEY (`address_id`)
    REFERENCES `address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_company_address_idx` ON `company` (`address_id` ASC);


-- -----------------------------------------------------
-- Table `applications`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `applications` ;

CREATE TABLE IF NOT EXISTS `applications` (
  `profile_id` INT NOT NULL,
  `company_id` INT NOT NULL,
  PRIMARY KEY (`profile_id`, `company_id`),
  CONSTRAINT `fk_company_applications`
    FOREIGN KEY (`company_id`)
    REFERENCES `company` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_proile_applications`
    FOREIGN KEY (`profile_id`)
    REFERENCES `profile` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_company_applications_idx` ON `applications` (`company_id` ASC);

SET SQL_MODE = '';
DROP USER IF EXISTS jobuser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'jobuser'@'localhost' IDENTIFIED BY 'jobuser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'jobuser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
